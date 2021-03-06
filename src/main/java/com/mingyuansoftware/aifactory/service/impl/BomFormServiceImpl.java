package com.mingyuansoftware.aifactory.service.impl;

import com.csvreader.CsvReader;
import com.mingyuansoftware.aifactory.config.LogConfig;
import com.mingyuansoftware.aifactory.constants.Constants;
import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.BomFormDto;
import com.mingyuansoftware.aifactory.service.BomFormService;
import com.mingyuansoftware.aifactory.util.Base64;
import com.mingyuansoftware.aifactory.util.DateUtil;
import com.mingyuansoftware.aifactory.util.DeleteFileUtil;
import com.mingyuansoftware.aifactory.util.RandomCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 张婷
 * @date 2019/7/4 16:29
 */

@Service
public class BomFormServiceImpl implements BomFormService {

    @Autowired
    private BomFormMapper bomFormMapper;

    @Autowired
    private BomFormDetailMapper bomFormDetailMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private StockKucunGoodsMapper stockKucunGoodsMapper;

    @Override
    public List<BomForm> selectBomFormList(BomFormDto bomFormDto) {
        try {
            return bomFormMapper.selectBomFormList(bomFormDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCount(BomFormDto bomFormDto) {
        try {
            return bomFormMapper.selectCount(bomFormDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public BomForm selectBomFormDetailById(int bomId) {
        try {
            BomForm bomForm = bomFormMapper.selectBomFormById(bomId);
            List<BomFormDetail> bomFormDetailList = bomFormDetailMapper.selectBomFormDetailById(bomId);
            bomForm.setBomFormDetailList(bomFormDetailList);
            return bomForm;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insertBomForm(BomForm bomForm) {
        int bom = 0;
        //先查询bom表中有没有货物Id,如果有添加失败
        BomForm bomForm1 = bomFormMapper.selectBomFormByGoodsId(bomForm.getGoodId());
        if(bomForm1 != null){
            return bom;
        }
        bom = bomFormMapper.insert(bomForm);
        //获取刚刚插入的记录id
        Integer bomFormId = bomFormMapper.selectLastId();
//        System.out.println("BomForm的实现类中最新插入的id是:" + bomFormId);
        List<BomFormDetail> bomFormDetailList = bomForm.getBomFormDetailList();
        for (BomFormDetail bomFormDetails : bomFormDetailList) {
            bomFormDetails.setBomId(bomFormId);
            bomFormDetailMapper.insert(bomFormDetails);
        }
        return bom;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBomFormById(int bomId) {
        int delete = bomFormMapper.deleteByPrimaryKey(bomId);
        bomFormDetailMapper.deleteBomFormDetails(bomId);
        return delete;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int updateBomFormDetail(BomForm bomForm) {
        BomForm bomForm1 = bomFormMapper.selectBomFormById(bomForm.getBomId());
        bomForm.setCreateTime(bomForm1.getCreateTime());
        bomForm.setUpdateTime(new Date());
        //修改bomform表单数据
        int bom = bomFormMapper.updateByPrimaryKey(bomForm);
        //先删除数据库中的bom表单详情删除
        bomFormDetailMapper.deleteBomFormDetails(bomForm.getBomId());
        //遍历修改和新增后的bom表单详情
        List<BomFormDetail> bomFormDetailList = bomForm.getBomFormDetailList();
        for (BomFormDetail bomFormDetails : bomFormDetailList) {
            bomFormDetails.setBomId(bomForm.getBomId());
            bomFormDetails.setUpdateTime(new Date());
            bomFormDetailMapper.insert(bomFormDetails);
        }
        return bom;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importBomForm(MultipartFile file) {
        //先删除文件夹内的文件，保证是空文件夹
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {//如果是Windows系统
            String unZipAddress = "D:/importCsv/";
            DeleteFileUtil.delFolder(unZipAddress);
        } else {  //linux 和mac
            String unZipAddress = "/usr/local/csv/";
            DeleteFileUtil.delFolder(unZipAddress);
        }
        String fileName = file.getOriginalFilename();
        String folderName = Base64.getRandomFileName();
        //zip文件路径
        String ufSavePath = "";
        //添加到bom表单内的集合
        List<BomFormDetail> bomFormDetailList = new ArrayList<>();
        //修改bom表单内的集合
        List<BomFormDetail> bomFormDetailList1 = new ArrayList<>();
        if (os.toLowerCase().startsWith("win")) {//如果是Windows系统
            File dest = new File("D:/importCsv/" + folderName + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
                ufSavePath = "D:/importCsv/" + folderName + fileName;

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {  //linux 和mac
            File dest = new File("/usr/local/csv/" + folderName + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
                ufSavePath = "/usr/local/csv/" + folderName + fileName;

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            //用来保存数据
            CsvReader r = new CsvReader(ufSavePath, ',', Charset.forName("Shift_JIS"));
            //读取表头
            r.readHeaders();
            //逐条读取记录，直至读完
            while (r.readRecord()) {
                Goods goods1 = goodsMapper.selectGoodsByPartsCd(r.get(1));
                //根据部品cd查询货物
                Goods goods = goodsMapper.selectGoodsByPartsCd(r.get(0));
                if (goods == null) {
                    goods.setGoodsNumber(r.get(0));
                    goods.setPartsCd(r.get(0));
                    goods.setCreateTime(new Date());
                    goodsMapper.insert(goods);
                }
                if (goods1 == null) {
                    goods1.setGoodsNumber(r.get(0));
                    goods1.setPartsCd(r.get(1));
                    goods1.setCreateTime(new Date());
                    goodsMapper.insert(goods1);
                }
                //根据货物id查询bom表单
                BomForm bomForm = bomFormMapper.selectBomFormByGoodsId(goods.getGoodsId());
                BomForm bomForm1 = new BomForm();
                BomFormDetail bomFormDetail = new BomFormDetail();
                //如果bom不存在，则新建
                if (bomForm == null) {
                    bomForm1.setGoodId(goods.getGoodsId());
                    bomForm1.setBomNumber("05" + RandomCodeUtil.getRandomCode());
                    bomForm1.setQuantity(new BigDecimal(1));
                    bomForm1.setCreateTime(DateUtil.getDateTime());
                    bomForm1.setDefineDate(DateUtil.getDate());
                    bomFormMapper.insert(bomForm1);
                    bomFormDetail.setBomId(bomForm1.getBomId());
                    bomFormDetail.setCreateTime(new Date());
                    bomFormDetail.setQuantity(new BigDecimal(r.get(2)));
                    bomFormDetail.setGoodId(goods1.getGoodsId());
                    bomFormDetailList.add(bomFormDetail);
                } else {
                    //如果bom存在，查询配料的货物比例，如果存在配料货物，则更换比例，如果不存在，则新增
                    BomFormDetail bomFormDetail1 = bomFormDetailMapper.selectBomFormDetailByGoodsId(bomForm.getBomId(), goods1.getGoodsId());
                    if (bomFormDetail1 != null) {
                        bomFormDetail1.setBomDetailId(bomFormDetail1.getBomDetailId());
                        if (bomFormDetail1.getQuantity().compareTo(new BigDecimal(r.get(2))) != 0) {
                            bomFormDetail1.setQuantity(new BigDecimal(r.get(2)));
                            bomFormDetailList1.add(bomFormDetail1);
                        }
                    } else {
                        bomFormDetail.setBomId(bomForm.getBomId());
                        bomFormDetail.setCreateTime(new Date());
                        bomFormDetail.setQuantity(new BigDecimal(r.get(2)));
                        bomFormDetail.setGoodId(goods1.getGoodsId());
                        bomFormDetailList.add(bomFormDetail);
                    }
                }
            }
            if (!(bomFormDetailList.isEmpty())) {
                bomFormDetailMapper.insertList(bomFormDetailList);
            }
            if (!(bomFormDetailList1.isEmpty())) {
                for (BomFormDetail bomFormDetail : bomFormDetailList1
                        ) {
                    bomFormDetailMapper.updateByPrimaryKey(bomFormDetail);
                }

            }
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public BomForm selectBomFormByGoodsId(int goodsId) {
        try {
            return bomFormMapper.selectBomFormByGoodsId(goodsId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
//    public BomForm selectProductionOrderGoodsMaterialList(int goodsId,int productionInstructionId) {
    public BomForm selectProductionOrderGoodsMaterialList(int goodsId,BigDecimal totalTaskAmount) {
        try {
            BomForm bomForm = bomFormMapper.selectProductionOrderGoodsMaterialList(goodsId);
            List<BomFormDetail> bomFormDetailList = bomFormDetailMapper.selectBomFormDetailById(bomForm.getBomId());
            //计算需要数量:生产指示书需要货物数量*bomFormDetail数量
            //生产指示书需要货物数量
//            ProductionInstructionGoods productionInstructionGoods = productionInstructionGoodsMapper.selectProductionInstructionGoods(productionInstructionId, goodsId);
            for(BomFormDetail bomFormDetail:bomFormDetailList){
//                bomFormDetail.setQuantity(productionInstructionGoods.getUnfinishedQuantity().multiply(bomFormDetail.getQuantity()));
                bomFormDetail.setQuantity(totalTaskAmount.multiply(bomFormDetail.getQuantity()));
            }
            bomForm.setBomFormDetailList(bomFormDetailList);
            return bomForm;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BomForm> selectProductionOrderGoodsMaterialsList(ProductionOrder productionOrder) {
        try {
            List<BomForm> bomFormList = new ArrayList<>();
            BomForm bomForm;
            for (Picking picking:productionOrder.getPickingList()) {
                for (PickingDetails pickingDetails:picking.getPickingDetailsList()) {
                    bomForm = bomFormMapper.selectProductionOrderGoodsMaterialList(pickingDetails.getGoodsId());
//                    bomForm = bomFormMapper.selectProductionOrderGoodsMaterialList(pickingDetails.getGoodsId());
                    List<BomFormDetail> bomFormDetailList1 = bomFormDetailMapper.selectBomFormDetailById(bomForm.getBomId());
                    for(BomFormDetail bomFormDetail:bomFormDetailList1) {
                        bomFormDetail.setQuantity(pickingDetails.getQuantity().multiply(bomFormDetail.getQuantity()));
                        //仓库切换
                        if(LogConfig.warehouseType==1){
                            //如果仓库类型是1,就是天津总库
                            pickingDetails.setOutWarehouseId(Constants.WAREHOUSE_ID);
                        }else if(LogConfig.warehouseType==2) {
                            pickingDetails.setOutWarehouseId(pickingDetails.getOutWarehouseId());
                        }
                        if (pickingDetails.getOutWarehouseId() != null) {
                            //根据货物和仓库在库存表中查询货物数量
                            KucunGoods kucunGoods = stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsIdAndWarehouseId(pickingDetails.getOutWarehouseId(), bomFormDetail.getGoodId());
                            if (kucunGoods != null) {
                                bomFormDetail.setSkgCount(kucunGoods.getSkgCount());
                            } else {
                                bomFormDetail.setSkgCount(new BigDecimal(0));
                            }
                        }
                    }
                        //如果bomFormList中存在货物Id,那么设置list中的货物数量叠加
                    bomForm.setBomFormDetailList(bomFormDetailList1);
                    bomFormList.add(bomForm);
                }
            }
            return bomFormList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
