package com.mingyuansoftware.aifactory.service.impl;

import com.csvreader.CsvReader;
import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.constants.Constants;
import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.ProductionInstructionGoodsDto;
import com.mingyuansoftware.aifactory.model.dto.ProductionScheduleAnalysisDto;
import com.mingyuansoftware.aifactory.model.dto.ValueEstimationDto;
import com.mingyuansoftware.aifactory.service.BomFormService;
import com.mingyuansoftware.aifactory.service.ProductionInstructionGoodsService;
import com.mingyuansoftware.aifactory.util.*;
import com.mingyuansoftware.aifactory.util.Base64;
import jp.gr.java_conf.dangan.util.lha.LhaHeader;
import jp.gr.java_conf.dangan.util.lha.LhaInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.*;

@Service
public class ProductionInstructionGoodsServiceImpl implements ProductionInstructionGoodsService {


    @Autowired
    private ProductionInstructionGoodsMapper productionInstructionGoodsMapper;
    @Autowired
    private ProductionInstructionDetailMapper productionInstructionDetailMapper;
    @Autowired
    private ProductionInstructionMapper productionInstructionMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsVarietyMapper goodsVarietyMapper;
    @Autowired
    private BomFormMapper bomFormMapper;
    @Autowired
    private BomFormDetailMapper bomFormDetailMapper;
    @Autowired
    private StockKucunGoodsMapper stockKucunGoodsMapper;
    @Autowired
    private GoodsLadderPriceMapper goodsLadderPriceMapper;



    @Override
    public List<ProductionInstructionGoods> getProductionInstructionDetailByPId(int productionInstructionId) {
        try{
            List<ProductionInstructionGoods> productionInstructionGoodsList = productionInstructionGoodsMapper.selectProductionInstructionDetailById(productionInstructionId);
            for (ProductionInstructionGoods productionInstructionGoods:productionInstructionGoodsList
                 ) {
               List<ProductionInstructionDetail> productionInstructionDetailsList =productionInstructionDetailMapper.selectProductionInstructionDetailsById(productionInstructionGoods.getProductionInstructionGoodsId());
                for (ProductionInstructionDetail productionInstructionDetail:productionInstructionDetailsList
                     ) {
                    for (int s: Constants.MAP_CATEGORY.keySet()
                    ) {
                        if(productionInstructionDetail.getCategory()==s){
                            productionInstructionDetail.setCategoryName(Constants.MAP_CATEGORY.get(s));
                        }
                    }
                }
                productionInstructionGoods.setProductionInstructionDetailList(productionInstructionDetailsList);
            }
            return productionInstructionGoodsList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProductionInstructionGoodsDto> selectProductionInstructionGoodsList(ProductionInstructionGoodsDto productionInstructionGoodsDto) {
        try{
            return productionInstructionGoodsMapper.selectProductionInstructionGoodsList(productionInstructionGoodsDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCountProductionInstructionGoods(ProductionInstructionGoodsDto productionInstructionGoodsDto) {
        try{
            return productionInstructionGoodsMapper.selectCountProductionInstructionGoods(productionInstructionGoodsDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importProductionInstructionZip(MultipartFile file) {
        //先删除文件夹内的文件，保证是空文件夹
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {//如果是Windows系统
            String unZipAddress = "D:/importZip/";
            DeleteFileUtil.delFolder(unZipAddress);
        } else {  //linux 和mac
            String unZipAddress = "/usr/local/zip/";
            DeleteFileUtil.delFolder(unZipAddress);
        }

        String fileName = file.getOriginalFilename();
        String folderName = Base64.getRandomFileName();
        //zip文件路径
        String ufSavePath = "";
        //zip文件解压地址
        String unZipAddress = "";
        boolean flag = true;
        ProductionInstruction productionInstruction = new ProductionInstruction();
        productionInstruction.setCreateTime(new Date());
        productionInstruction.setState((byte)1);
        productionInstructionMapper.insert(productionInstruction);
        int productionInstructionId = productionInstruction.getProductionInstructionId();
        String serialNumber = null;
        ProductionInstructionGoods productionInstructionGoods = null;
        ProductionInstructionDetail productionInstructionDetail = null;
        List<ProductionInstructionGoods> productionInstructionGoodsList = new ArrayList<>();
        if (os.toLowerCase().startsWith("win")) {//如果是Windows系统

            File dest = new File("D:/importZip/" + folderName + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
                ufSavePath ="D:/importZip/" + folderName + fileName;

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            unZipAddress = "D:/importZip/";
        } else {  //linux 和mac
            File dest = new File("/usr/local/zip/" + folderName + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
                ufSavePath ="/usr/local/zip/" + folderName + fileName;

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            unZipAddress ="/usr/local/zip/";
        }
        try{
            LhaInputStream in = new LhaInputStream(new FileInputStream(ufSavePath));
            //?取ZipInputStream中的ZipEntry条目，一个zip文件中可能包含多个ZipEntry，
            //当getNextEntry方法的返回??null，?代表ZipInputStream中没有下一个ZipEntry，
            // ?入流?取完成；
            LhaHeader z =in.getNextEntry();
            List<String> srcPaths = new ArrayList<>();
            while (z != null) {
                File f = new File(unZipAddress);
                f.mkdir();

                if (z.getPath().endsWith("/")) {
                    String path = z.getPath();
                    path = path.substring(0, path.length() - 1);
                    f = new File(unZipAddress +  path);
                    f.mkdir();
                    srcPaths.add(unZipAddress +  path);
                }else {
                    if(z.getPath().lastIndexOf('/')>0){
                        f = new File(unZipAddress + z.getPath().substring(z.getPath().lastIndexOf('/')));
                        srcPaths.add(unZipAddress + z.getPath().substring(z.getPath().lastIndexOf('/')));
                    }else {
                        f = new File(unZipAddress + z.getPath());
                        srcPaths.add(unZipAddress + z.getPath());
                    }
                    f.createNewFile();
                    FileOutputStream out = new FileOutputStream(f);
                    int b;
                    while ((b = in.read()) != -1) {
                        out.write(b);
                    }
                    out.close();
                }
                //?取下一个ZipEntry
                z = in.getNextEntry();
            }
            in.close();
            //Shift_JIS
            for (String srcPath:srcPaths
            ) {
                //用来保存数据
                CsvReader r = new CsvReader(srcPath, ',', Charset.forName("Shift_JIS"));
                //读取表头
                r.readHeaders();
                //逐条读取记录，直至读完

                while (r.readRecord() && r.getColumnCount() == 14) {
                    Goods goods = goodsMapper.selectGoodsByPartsCd(r.get(4));
                    if (goods == null) {
                        goods.setGoodsNumber(r.get(4));
                        goods.setPartsCd(r.get(4));
                        goods.setCreateTime(new Date());
                        goodsMapper.insert(goods);
                        BomForm bomForm = bomFormMapper.selectBomFormByGoodsId(goods.getGoodsId());
                        if(bomForm==null){
                            throw new MyException("导入失败,部品CD:"+r.get(4)+"的货物在bom表单内未找到，请先导入bom表单信息");
                        }
                    }
                    BomForm bomForm = bomFormMapper.selectBomFormByGoodsId(goods.getGoodsId());
                    if(bomForm==null){
                        throw new MyException("导入失败,部品CD:"+r.get(4)+"的货物在bom表单内未找到，请先导入bom表单信息");
                    }
                    productionInstructionGoods = new ProductionInstructionGoods();
                    productionInstructionGoods.setGoodsId(goods.getGoodsId());
                    if (goods.getGoodsVariety() != null && goods.getGoodsVariety().getVarietyValue() != null) {
                        productionInstructionGoods.setVarietyValue(goods.getGoodsVariety().getVarietyValue());
                    }
                    if (!(r.get(3).equals(serialNumber))) {
                        if (serialNumber != null) {
                            ProductionInstruction productionInstruction1 = new ProductionInstruction();
                            productionInstruction1.setCreateTime(new Date());
                            productionInstruction1.setState((byte) 1);
                            productionInstruction1.setSerialNumber(serialNumber);
                            productionInstructionMapper.insert(productionInstruction1);
                            productionInstructionId = productionInstruction1.getProductionInstructionId();
                        }
                        serialNumber = r.get(3);
                        flag = true;
                    }

                    productionInstructionGoods.setPartsCd(r.get(4));
                    productionInstructionGoods.setProductName(r.get(6));
                    productionInstructionGoods.setConnectionNo(r.get(0));
                    productionInstructionGoods.setProductionSchedule(new BigDecimal(r.get(13)));
                    productionInstructionGoods.setUnit(r.get(8));
                    productionInstructionGoods.setBoxesNumber(Integer.valueOf(r.get(9)));
                    productionInstructionGoods.setNumber(Integer.valueOf(r.get(10)));
                    productionInstructionGoods.setUnfinishedQuantity(new BigDecimal(r.get(13)));
                    productionInstructionGoods.setFinishedQuantity(BigDecimal.ZERO);
                    productionInstructionGoods.setProductionInstructionId(productionInstructionId);
                    productionInstructionGoodsMapper.insert(productionInstructionGoods);
                    if (flag) {
                        int count = productionInstructionMapper.selectSerialNumber(serialNumber);
                        if (count > 0) {
                            throw new MyException("导入失败,第" + r.get(3) + "回已存在");
                        }
                        flag = false;
                    }
                    productionInstructionMapper.updateSerialNumberByProductionInstructionId(serialNumber, productionInstructionId);
                    productionInstructionGoodsList.add(productionInstructionGoods);
                }
                while (r.readRecord() && r.getColumnCount() == 3) {

                    if (productionInstructionGoodsList.size() > 0) {
                        for (ProductionInstructionGoods productionInstructionGoods1 : productionInstructionGoodsList
                        ) {
                            if (productionInstructionGoods1.getPartsCd().equals(r.get(0))) {
                                productionInstructionDetail = new ProductionInstructionDetail();
                                Goods goods = goodsMapper.selectGoodsByPartsCd(r.get(1));
                                if (goods == null) {
                                    goods.setGoodsNumber(r.get(4));
                                    goods.setPartsCd(r.get(4));
                                    goods.setCreateTime(new Date());
                                    goodsMapper.insert(goods);
                                }
                                productionInstructionDetail.setGoodsId(goods.getGoodsId());
                                if (goods.getGoodsVariety() != null && goods.getGoodsVariety().getVarietyValue() != null) {
                                    productionInstructionDetail.setVarietyValue(goods.getGoodsVariety().getVarietyValue());
                                }
                                productionInstructionDetail.setProductName(goods.getGoodsName());
                                productionInstructionDetail.setPartsCd(r.get(1));
                                productionInstructionDetail.setProductionInstructionGoodsId(productionInstructionGoods1.getProductionInstructionGoodsId());
                                productionInstructionDetail.setProductionSchedule(new BigDecimal(r.get(2)).multiply(productionInstructionGoods1.getProductionSchedule()));
                                productionInstructionDetail.setProductionInstructionId(productionInstructionGoods1.getProductionInstructionId());
                                productionInstructionDetailMapper.insert(productionInstructionDetail);
                            }
                        }
                    }

                }
                while (r.readRecord() && r.getColumnCount() == 4) {
                    GoodsVariety goodsVariety = new GoodsVariety();
                    int varietyValue = Integer.valueOf(r.get(0));
                    GoodsVariety goodsVariety1 = goodsVarietyMapper.selectByPrimaryKey(varietyValue);
                    if (goodsVariety1 == null) {
                        goodsVariety.setVarietyValue(varietyValue);
                        goodsVariety.setJpName(r.get(1));
                        goodsVariety.setElName(r.get(2));
                        goodsVariety.setCnName(r.get(3));
                        goodsVarietyMapper.insert(goodsVariety);
                    }
                }
                r.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public ProductionInstructionGoods selectProductionInstructionGoods(int productionInstructionId, int goodsId) {
        try{
            return productionInstructionGoodsMapper.selectProductionInstructionGoods(productionInstructionId,goodsId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ValueEstimationDto> selectValueEstimationList(ValueEstimationDto valueEstimationDto) {
        try {
            return productionInstructionGoodsMapper.selectValueEstimationList(valueEstimationDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectValueEstimationCount(ValueEstimationDto valueEstimationDto) {
        try {
            return productionInstructionGoodsMapper.selectValueEstimationCount(valueEstimationDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<ProductionScheduleAnalysis> selectProductionScheduleAnalysisList(int page,int limit,ProductionScheduleAnalysisDto productionScheduleAnalysisDto) {
        try{
            //获取生产指示书未完成回数的货物列表信息
            List<ProductionScheduleAnalysis> productionScheduleAnalysisList = productionInstructionGoodsMapper.selectProductionScheduleAnalysisList(productionScheduleAnalysisDto);
            //获取生产指示书未完成回数的前十回，正序
             PageHelper.startPage(page, limit);
             List<ProductionProcess> productionProcessList = productionInstructionMapper.selectUnfinishList();
            for (int i =0;i<productionProcessList.size();i++) {
                productionProcessList.get(i).setOrder(i+1);
            }
             //求压缩
            if(page>1){
                page=page-1;
                limit = page*limit;
                PageHelper.startPage(page, limit);
                List<ProductionProcess> productionProcessList1 = productionInstructionMapper.selectUnfinishList();
                for (int i =0;i<productionProcessList1.size();i++) {
                    productionProcessList1.get(i).setOrder(i+1);
                }
                Map<Integer,String> serialNumberMap = new HashMap<>();
                for (ProductionProcess productionProcess1:productionProcessList1
                ) {
                    serialNumberMap.put(productionProcess1.getOrder(),productionProcess1.getSerialNumber());
                }
                //根据货物id和回数的集合查询比率集合
                for (ProductionScheduleAnalysis productionScheduleAnalysis:productionScheduleAnalysisList
                ) {
                    List<ProductionProcessRate> productionProcessRateList = new ArrayList<>();
                    for (int s:serialNumberMap.keySet()
                         ) {
                      ProductionProcessRate productionProcessRate = productionInstructionGoodsMapper.selectProductionProcessRate(productionScheduleAnalysis.getGoodsId(),serialNumberMap.get(s));
                        if(productionProcessRate!=null){
                            productionProcessRate.setOrder(s);
                            //根据货物id和bomId和PrepareProduction的数量计算可以准备生产的数量
                            List<CalculateQuantity> calculateQuantityList = new ArrayList<>();
                            List<BomFormDetail> bomFormDetailList = bomFormDetailMapper.selectBomFormDetailById(productionProcessRate.getBomId());
                            for (BomFormDetail bomFormDetail:bomFormDetailList
                                 ) {
                                CalculateQuantity calculateQuantity = new CalculateQuantity();
                                KucunGoods kucunGoods=stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsId(bomFormDetail.getGoodId());
                                calculateQuantity.setGoodsId(bomFormDetail.getGoodId());
                                calculateQuantity.setQuantity(bomFormDetail.getQuantity());
                                if(kucunGoods != null){
                                    calculateQuantity.setSkgCount(kucunGoods.getSkgCount());
                                }else{
                                    calculateQuantity.setSkgCount(BigDecimal.ZERO);
                                }
                                calculateQuantityList.add(calculateQuantity);
                            }
                            BigDecimal PrepareProduction = CalculateQuantityUtil.calculateQuantity(calculateQuantityList);
                            productionProcessRate.setPrepareProduction(PrepareProduction);
                           /* if(PrepareProduction.compareTo(productionProcessRate.getPrepareProduction())<=0) {

                            }*/
                            productionProcessRateList.add(productionProcessRate);
                        }


                    }


                    BigDecimal rate = new BigDecimal(100);
                    //准备(可以生产)
                    BigDecimal PrepareProduction = new BigDecimal(0);
                    //生产完成
                    BigDecimal ProductionComplete = new BigDecimal(0);
                    //销售出货
                    BigDecimal SalesShipment = new BigDecimal(0);
                    //需要继续加工生产
                    BigDecimal ProcessingProduction = new BigDecimal(0);
                    //返品数量
                    BigDecimal returnQuantity = new BigDecimal(0);
                    //总数量
                    BigDecimal totalQuantity =new BigDecimal(0);
                    if(!(productionProcessRateList.isEmpty())){
                        for (ProductionProcessRate productionProcessRate:productionProcessRateList
                        ) {
                            //如果等于商品
                            if (productionProcessRate.getCategory()!=null && productionProcessRate.getCategory()== Constants.GOODS_CATEGORY_COMMODITY){
                                //需要继续加工生产的数等于完成的数
                                productionProcessRate.setProcessingProduction(BigDecimal.ZERO);
                            }else{
                                //需要继续加工生产的数等于完成的数
                                productionProcessRate.setProcessingProduction(productionProcessRate.getProductionComplete());
                            }
                            PrepareProduction = PrepareProduction.add(productionProcessRate.getPrepareProduction());
                            ProductionComplete = ProductionComplete.add(productionProcessRate.getProductionComplete());
                            SalesShipment = SalesShipment.add(productionProcessRate.getSalesShipment());
                            ProcessingProduction = ProcessingProduction.add(productionProcessRate.getProcessingProduction());
                            returnQuantity = returnQuantity.add(productionProcessRate.getReturnQuantity());
                            totalQuantity =totalQuantity.add(productionProcessRate.getTotalQuantity());
                        }
                        productionScheduleAnalysis.setPrepareProduction(PrepareProduction);
                        productionScheduleAnalysis.setProductionComplete(ProductionComplete);
                        productionScheduleAnalysis.setSalesShipment(SalesShipment);
                        productionScheduleAnalysis.setProcessingProduction(ProcessingProduction);
                        productionScheduleAnalysis.setReturnQuantity(returnQuantity);
                        productionScheduleAnalysis.setTotalQuantity(totalQuantity);
                    }

                    if(totalQuantity.compareTo(BigDecimal.ZERO)>0){
                        //准备(可以生产)的占比
                        BigDecimal PrepareProductionRate =PrepareProduction.divide(totalQuantity,2,BigDecimal.ROUND_HALF_DOWN).multiply(rate);
                        //生产完成的占比
                        BigDecimal ProductionCompleteRate =ProductionComplete.divide(totalQuantity,2,BigDecimal.ROUND_HALF_DOWN).multiply(rate);
                        //销售出货的占比
                        BigDecimal SalesShipmentRate =SalesShipment.divide(totalQuantity,2,BigDecimal.ROUND_HALF_DOWN).multiply(rate);
                        //需要继续加工生产的占比
                        BigDecimal ProcessingProductionRate = ProcessingProduction.divide(totalQuantity,2,BigDecimal.ROUND_HALF_DOWN).multiply(rate);
                        //返品数量的占比
                        BigDecimal returnQuantityRate =returnQuantity.divide(totalQuantity,2,BigDecimal.ROUND_HALF_DOWN).multiply(rate);
                        productionScheduleAnalysis.setPrepareProductionRate(PrepareProductionRate);
                        productionScheduleAnalysis.setProductionCompleteRate(ProductionCompleteRate);
                        productionScheduleAnalysis.setSalesShipmentRate(SalesShipmentRate);
                        productionScheduleAnalysis.setProcessingProductionRate(ProcessingProductionRate);
                        productionScheduleAnalysis.setReturnQuantityRate(returnQuantityRate);
                    }else{
                        productionScheduleAnalysis.setPrepareProductionRate(BigDecimal.ZERO);
                        productionScheduleAnalysis.setProductionCompleteRate(BigDecimal.ZERO);
                        productionScheduleAnalysis.setSalesShipmentRate(BigDecimal.ZERO);
                        productionScheduleAnalysis.setProcessingProductionRate(BigDecimal.ZERO);
                        productionScheduleAnalysis.setReturnQuantityRate(BigDecimal.ZERO);
                    }
            }

            }else{
                for (ProductionScheduleAnalysis productionScheduleAnalysis:productionScheduleAnalysisList
                ) {
                    productionScheduleAnalysis.setPrepareProductionRate(BigDecimal.ZERO);
                    productionScheduleAnalysis.setProductionCompleteRate(BigDecimal.ZERO);
                    productionScheduleAnalysis.setSalesShipmentRate(BigDecimal.ZERO);
                    productionScheduleAnalysis.setProcessingProductionRate(BigDecimal.ZERO);
                    productionScheduleAnalysis.setReturnQuantityRate(BigDecimal.ZERO);
                }
            }

            Map<Integer,String> serialNumberMap = new HashMap<>();
            for (ProductionProcess productionProcess:productionProcessList
            ) {
                serialNumberMap.put(productionProcess.getOrder(),productionProcess.getSerialNumber());
            }

            //根据货物id和回数的集合查询比率集合
            for (ProductionScheduleAnalysis productionScheduleAnalysis:productionScheduleAnalysisList
                 ) {
                List<ProductionProcessRate> productionProcessRateList = new ArrayList<>();
                for (int s:serialNumberMap.keySet()
                ) {
                    ProductionProcessRate productionProcessRate = productionInstructionGoodsMapper.selectProductionProcessRate(productionScheduleAnalysis.getGoodsId(), serialNumberMap.get(s));
                    if(productionProcessRate!=null){
                        productionProcessRate.setOrder(s);
                        //根据货物id和bomId和PrepareProduction的数量计算可以准备生产的数量
                        List<CalculateQuantity> calculateQuantityList = new ArrayList<>();
                        List<BomFormDetail> bomFormDetailList = bomFormDetailMapper.selectBomFormDetailById(productionProcessRate.getBomId());
                        for (BomFormDetail bomFormDetail:bomFormDetailList
                        ) {
                            CalculateQuantity calculateQuantity = new CalculateQuantity();
                            KucunGoods kucunGoods=stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsId(bomFormDetail.getGoodId());
                            calculateQuantity.setGoodsId(bomFormDetail.getGoodId());
                            calculateQuantity.setQuantity(bomFormDetail.getQuantity());
                            if(kucunGoods != null){
                                calculateQuantity.setSkgCount(kucunGoods.getSkgCount());
                            }else{
                                calculateQuantity.setSkgCount(BigDecimal.ZERO);
                            }
                            calculateQuantityList.add(calculateQuantity);
                        }
                        BigDecimal PrepareProduction = CalculateQuantityUtil.calculateQuantity(calculateQuantityList);
                        productionProcessRate.setPrepareProduction(PrepareProduction);
                      /*  if(PrepareProduction.compareTo(productionProcessRate.getPrepareProduction())<=0) {

                        }*/
                        productionProcessRateList.add(productionProcessRate);
                    }else{
                        ProductionProcessRate productionProcessRate1 = new ProductionProcessRate();
                        productionProcessRate1.setPrepareProduction(BigDecimal.ZERO);
                        productionProcessRate1.setProductionComplete(BigDecimal.ZERO);
                        productionProcessRate1.setSalesShipment(BigDecimal.ZERO);
                        productionProcessRate1.setProcessingProduction(BigDecimal.ZERO);
                        productionProcessRate1.setReturnQuantity(BigDecimal.ZERO);
                        productionProcessRate1.setTotalQuantity(BigDecimal.ZERO);
                        productionProcessRate1.setPrepareProductionRate(BigDecimal.ZERO);
                        productionProcessRate1.setProductionCompleteRate(BigDecimal.ZERO);
                        productionProcessRate1.setSalesShipmentRate(BigDecimal.ZERO);
                        productionProcessRate1.setProcessingProductionRate(BigDecimal.ZERO);
                        productionProcessRate1.setReturnQuantityRate(BigDecimal.ZERO);
                        productionProcessRate1.setOrder(s);
                        productionProcessRateList.add(productionProcessRate1);
                    }

                }
                    BigDecimal rate = new BigDecimal(100);
                if(!(productionProcessRateList.isEmpty())){
                    for (ProductionProcessRate productionProcessRate : productionProcessRateList
                    ) {
                        if(productionProcessRate.getTotalQuantity().compareTo(BigDecimal.ZERO)!=0){
                            //如果等于商品
                            if (productionProcessRate.getCategory()!=null && productionProcessRate.getCategory() == Constants.GOODS_CATEGORY_COMMODITY) {
                                //需要继续加工生产的数等于完成的数
                                productionProcessRate.setProcessingProduction(BigDecimal.ZERO);
                                //需要继续加工生产占比
                                productionProcessRate.setProcessingProductionRate(productionProcessRate.getProcessingProduction().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                            } else {
                                //需要继续加工生产的数等于完成的数
                                productionProcessRate.setProcessingProduction(productionProcessRate.getProductionComplete());
                                //需要继续加工生产占比
                                productionProcessRate.setProcessingProductionRate(productionProcessRate.getProcessingProduction().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                            }
                            //准备(可以生产)占比
                            productionProcessRate.setPrepareProductionRate(productionProcessRate.getPrepareProduction().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                            //生产完成占比
                            productionProcessRate.setProductionCompleteRate(productionProcessRate.getProductionComplete().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                            //销售出货占比
                            productionProcessRate.setSalesShipmentRate(productionProcessRate.getSalesShipment().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                            //返品数量的占比
                            productionProcessRate.setReturnQuantityRate(productionProcessRate.getReturnQuantity().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                        }
                    }
                    productionScheduleAnalysis.setProductionProcessRateList(productionProcessRateList);
                }

            }

            //将生产指示书未完成回数的前十回放入未完成回数的货物列表中
            for (ProductionScheduleAnalysis productionScheduleAnalysis:productionScheduleAnalysisList
                 ) {
                productionScheduleAnalysis.setProductionProcessList(productionProcessList);
            }
             return productionScheduleAnalysisList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProductionScheduleAnalysis> selectInfoByGoodsId(int page,int limit,int goodsId) {
        List<ProductionScheduleAnalysis> productionScheduleAnalysisList1 = new ArrayList<>();
        //根据货物id查询bom表单内组成此货物信息的货物列表
        BomForm bomForm =bomFormMapper.selectBomFormByGoodsId(goodsId);
        if(bomForm==null){
            return productionScheduleAnalysisList1;
        }
        List<BomFormDetail> bomFormDetailList = bomFormDetailMapper.selectBomFormDetailById(bomForm.getBomId());
        ProductionScheduleAnalysisDto productionScheduleAnalysisDto = new ProductionScheduleAnalysisDto();
        //获取生产指示书未完成回数的货物列表信息
        List<ProductionScheduleAnalysis> productionScheduleAnalysisList = productionInstructionGoodsMapper.selectProductionScheduleAnalysisList(productionScheduleAnalysisDto);
        //获取生产指示书未完成的回数数据根据货物id进行分组
        PageHelper.startPage(page, limit);
        List<ProductionProcess> productionProcessList = productionInstructionMapper.selectUnfinishList();
        for (int i =0;i<productionProcessList.size();i++) {
            productionProcessList.get(i).setOrder(i+1);
        }

        //求压缩
        if(page>1){
            page=page-1;
            limit = page*limit;
            PageHelper.startPage(page, limit);
            List<ProductionProcess> productionProcessList1 = productionInstructionMapper.selectUnfinishList();
            for (int i =0;i<productionProcessList1.size();i++) {
                productionProcessList1.get(i).setOrder(i+1);
            }
            Map<Integer,String> serialNumberMap = new HashMap<>();
            for (ProductionProcess productionProcess1:productionProcessList1
            ) {
                serialNumberMap.put(productionProcess1.getOrder(),productionProcess1.getSerialNumber());
            }
            //根据货物id和回数的集合查询比率集合
            for (ProductionScheduleAnalysis productionScheduleAnalysis:productionScheduleAnalysisList
            ) {
                List<ProductionProcessRate> productionProcessRateList = new ArrayList<>();
                for (int s:serialNumberMap.keySet()
                ) {
                    ProductionProcessRate productionProcessRate = productionInstructionGoodsMapper.selectProductionProcessRate(productionScheduleAnalysis.getGoodsId(),serialNumberMap.get(s));
                    if(productionProcessRate!=null){
                        productionProcessRate.setOrder(s);
                        //根据货物id和bomId和PrepareProduction的数量计算可以准备生产的数量
                        List<CalculateQuantity> calculateQuantityList = new ArrayList<>();
                        List<BomFormDetail> bomFormDetailList1 = bomFormDetailMapper.selectBomFormDetailById(productionProcessRate.getBomId());
                        for (BomFormDetail bomFormDetail:bomFormDetailList1
                        ) {
                            CalculateQuantity calculateQuantity = new CalculateQuantity();
                            KucunGoods kucunGoods=stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsId(bomFormDetail.getGoodId());
                            calculateQuantity.setGoodsId(bomFormDetail.getGoodId());
                            calculateQuantity.setQuantity(bomFormDetail.getQuantity());
                            if(kucunGoods != null){
                                calculateQuantity.setSkgCount(kucunGoods.getSkgCount());
                            }else{
                                calculateQuantity.setSkgCount(BigDecimal.ZERO);
                            }
                            calculateQuantityList.add(calculateQuantity);
                        }
                        BigDecimal PrepareProduction = CalculateQuantityUtil.calculateQuantity(calculateQuantityList);
                        productionProcessRate.setPrepareProduction(PrepareProduction);
                      /*  if(PrepareProduction.compareTo(productionProcessRate.getPrepareProduction())<=0) {

                        }*/
                        productionProcessRateList.add(productionProcessRate);
                    }


                }


                BigDecimal rate = new BigDecimal(100);
                //准备(可以生产)
                BigDecimal PrepareProduction = new BigDecimal(0);
                //生产完成
                BigDecimal ProductionComplete = new BigDecimal(0);
                //销售出货
                BigDecimal SalesShipment = new BigDecimal(0);
                //需要继续加工生产
                BigDecimal ProcessingProduction = new BigDecimal(0);
                //返品数量
                BigDecimal returnQuantity = new BigDecimal(0);
                //总数量
                BigDecimal totalQuantity =new BigDecimal(0);
                if(!(productionProcessRateList.isEmpty())){
                    for (ProductionProcessRate productionProcessRate:productionProcessRateList
                    ) {
                        //如果等于商品
                        if (productionProcessRate.getCategory()!=null && productionProcessRate.getCategory()== Constants.GOODS_CATEGORY_COMMODITY){
                            //需要继续加工生产的数等于完成的数
                            productionProcessRate.setProcessingProduction(BigDecimal.ZERO);
                        }else{
                            //需要继续加工生产的数等于完成的数
                            productionProcessRate.setProcessingProduction(productionProcessRate.getProductionComplete());
                        }
                        PrepareProduction = PrepareProduction.add(productionProcessRate.getPrepareProduction());
                        ProductionComplete = ProductionComplete.add(productionProcessRate.getProductionComplete());
                        SalesShipment = SalesShipment.add(productionProcessRate.getSalesShipment());
                        ProcessingProduction = ProcessingProduction.add(productionProcessRate.getProcessingProduction());
                        returnQuantity = returnQuantity.add(productionProcessRate.getReturnQuantity());
                        totalQuantity =totalQuantity.add(productionProcessRate.getTotalQuantity());
                    }
                    productionScheduleAnalysis.setPrepareProduction(PrepareProduction);
                    productionScheduleAnalysis.setProductionComplete(ProductionComplete);
                    productionScheduleAnalysis.setSalesShipment(SalesShipment);
                    productionScheduleAnalysis.setProcessingProduction(ProcessingProduction);
                    productionScheduleAnalysis.setReturnQuantity(returnQuantity);
                    productionScheduleAnalysis.setTotalQuantity(totalQuantity);
                }

                if(totalQuantity.compareTo(BigDecimal.ZERO)>0){
                    //准备(可以生产)的占比
                    BigDecimal PrepareProductionRate =PrepareProduction.divide(totalQuantity,2,BigDecimal.ROUND_HALF_DOWN).multiply(rate);
                    //生产完成的占比
                    BigDecimal ProductionCompleteRate =ProductionComplete.divide(totalQuantity,2,BigDecimal.ROUND_HALF_DOWN).multiply(rate);
                    //销售出货的占比
                    BigDecimal SalesShipmentRate =SalesShipment.divide(totalQuantity,2,BigDecimal.ROUND_HALF_DOWN).multiply(rate);
                    //需要继续加工生产的占比
                    BigDecimal ProcessingProductionRate = ProcessingProduction.divide(totalQuantity,2,BigDecimal.ROUND_HALF_DOWN).multiply(rate);
                    //返品数量的占比
                    BigDecimal returnQuantityRate =returnQuantity.divide(totalQuantity,2,BigDecimal.ROUND_HALF_DOWN).multiply(rate);
                    productionScheduleAnalysis.setPrepareProductionRate(PrepareProductionRate);
                    productionScheduleAnalysis.setProductionCompleteRate(ProductionCompleteRate);
                    productionScheduleAnalysis.setSalesShipmentRate(SalesShipmentRate);
                    productionScheduleAnalysis.setProcessingProductionRate(ProcessingProductionRate);
                    productionScheduleAnalysis.setReturnQuantityRate(returnQuantityRate);
                }else{
                    productionScheduleAnalysis.setPrepareProductionRate(BigDecimal.ZERO);
                    productionScheduleAnalysis.setProductionCompleteRate(BigDecimal.ZERO);
                    productionScheduleAnalysis.setSalesShipmentRate(BigDecimal.ZERO);
                    productionScheduleAnalysis.setProcessingProductionRate(BigDecimal.ZERO);
                    productionScheduleAnalysis.setReturnQuantityRate(BigDecimal.ZERO);
                }
            }

        }else{
            for (ProductionScheduleAnalysis productionScheduleAnalysis:productionScheduleAnalysisList
            ) {
                productionScheduleAnalysis.setPrepareProductionRate(BigDecimal.ZERO);
                productionScheduleAnalysis.setProductionCompleteRate(BigDecimal.ZERO);
                productionScheduleAnalysis.setSalesShipmentRate(BigDecimal.ZERO);
                productionScheduleAnalysis.setProcessingProductionRate(BigDecimal.ZERO);
                productionScheduleAnalysis.setReturnQuantityRate(BigDecimal.ZERO);
            }
        }
        Map<Integer,String> serialNumberMap = new HashMap<>();
        for (ProductionProcess productionProcess:productionProcessList
        ) {
            serialNumberMap.put(productionProcess.getOrder(),productionProcess.getSerialNumber());
        }

        //根据货物id和回数的集合查询比率集合
        for (ProductionScheduleAnalysis productionScheduleAnalysis:productionScheduleAnalysisList
        ) {
            List<ProductionProcessRate> productionProcessRateList = new ArrayList<>();
            for (int s:serialNumberMap.keySet()
            ) {
                ProductionProcessRate productionProcessRate = productionInstructionGoodsMapper.selectProductionProcessRate(productionScheduleAnalysis.getGoodsId(), serialNumberMap.get(s));
                if(productionProcessRate!=null){
                    productionProcessRate.setOrder(s);
                    //根据货物id和bomId和PrepareProduction的数量计算可以准备生产的数量
                    List<CalculateQuantity> calculateQuantityList = new ArrayList<>();
                    List<BomFormDetail> bomFormDetailList1 = bomFormDetailMapper.selectBomFormDetailById(productionProcessRate.getBomId());
                    for (BomFormDetail bomFormDetail:bomFormDetailList1
                    ) {
                        CalculateQuantity calculateQuantity = new CalculateQuantity();
                        KucunGoods kucunGoods=stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsId(bomFormDetail.getGoodId());
                        calculateQuantity.setGoodsId(bomFormDetail.getGoodId());
                        calculateQuantity.setQuantity(bomFormDetail.getQuantity());
                        if(kucunGoods != null){
                            calculateQuantity.setSkgCount(kucunGoods.getSkgCount());
                        }else{
                            calculateQuantity.setSkgCount(BigDecimal.ZERO);
                        }
                        calculateQuantityList.add(calculateQuantity);
                    }
                    BigDecimal PrepareProduction = CalculateQuantityUtil.calculateQuantity(calculateQuantityList);
                    productionProcessRate.setPrepareProduction(PrepareProduction);
                   /* if(PrepareProduction.compareTo(productionProcessRate.getPrepareProduction())<=0) {

                    }*/
                    productionProcessRateList.add(productionProcessRate);
                }else{
                    ProductionProcessRate productionProcessRate1 = new ProductionProcessRate();
                    productionProcessRate1.setPrepareProduction(BigDecimal.ZERO);
                    productionProcessRate1.setProductionComplete(BigDecimal.ZERO);
                    productionProcessRate1.setSalesShipment(BigDecimal.ZERO);
                    productionProcessRate1.setProcessingProduction(BigDecimal.ZERO);
                    productionProcessRate1.setReturnQuantity(BigDecimal.ZERO);
                    productionProcessRate1.setTotalQuantity(BigDecimal.ZERO);
                    productionProcessRate1.setPrepareProductionRate(BigDecimal.ZERO);
                    productionProcessRate1.setProductionCompleteRate(BigDecimal.ZERO);
                    productionProcessRate1.setSalesShipmentRate(BigDecimal.ZERO);
                    productionProcessRate1.setProcessingProductionRate(BigDecimal.ZERO);
                    productionProcessRate1.setReturnQuantityRate(BigDecimal.ZERO);
                    productionProcessRate1.setOrder(s);
                    productionProcessRateList.add(productionProcessRate1);
                }

            }
            BigDecimal rate = new BigDecimal(100);
            if(!(productionProcessRateList.isEmpty())){
                for (ProductionProcessRate productionProcessRate : productionProcessRateList
                ) {
                    if(productionProcessRate.getTotalQuantity().compareTo(BigDecimal.ZERO)!=0){
                        //如果等于商品
                        if (productionProcessRate.getCategory()!=null && productionProcessRate.getCategory() == Constants.GOODS_CATEGORY_COMMODITY) {
                            //需要继续加工生产的数等于完成的数
                            productionProcessRate.setProcessingProduction(BigDecimal.ZERO);
                            //需要继续加工生产占比
                            productionProcessRate.setProcessingProductionRate(productionProcessRate.getProcessingProduction().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                        } else {
                            //需要继续加工生产的数等于完成的数
                            productionProcessRate.setProcessingProduction(productionProcessRate.getProductionComplete());
                            //需要继续加工生产占比
                            productionProcessRate.setProcessingProductionRate(productionProcessRate.getProcessingProduction().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                        }
                        //准备(可以生产)占比
                        productionProcessRate.setPrepareProductionRate(productionProcessRate.getPrepareProduction().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                        //生产完成占比
                        productionProcessRate.setProductionCompleteRate(productionProcessRate.getProductionComplete().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                        //销售出货占比
                        productionProcessRate.setSalesShipmentRate(productionProcessRate.getSalesShipment().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                        //返品数量的占比
                        productionProcessRate.setReturnQuantityRate(productionProcessRate.getReturnQuantity().divide(productionProcessRate.getTotalQuantity(), 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate));
                    }
                }
                productionScheduleAnalysis.setProductionProcessRateList(productionProcessRateList);
            }

        }

        //将生产指示书未完成回数的前十回放入未完成回数的货物列表中
        for (ProductionScheduleAnalysis productionScheduleAnalysis:productionScheduleAnalysisList
        ) {
            productionScheduleAnalysis.setProductionProcessList(productionProcessList);
        }

        for (BomFormDetail bomFormDetail:bomFormDetailList
             ) {
            int goodsId1 = bomFormDetail.getGoodId();
            for (ProductionScheduleAnalysis productionScheduleAnalysis:productionScheduleAnalysisList
                 ) {
                if(productionScheduleAnalysis.getGoodsId()==goodsId1){
                    productionScheduleAnalysisList1.add(productionScheduleAnalysis);
                }
            }
        }
        return productionScheduleAnalysisList1;
    }

    @Override
    public List<ProductionCosting> selectProductionCostingList(ProductionCosting productionCosting) {
        return productionInstructionGoodsMapper.selectProductionCostingList(productionCosting);
    }

    @Override
    public List<KucunGoods> selectJPExportsGoodsList(Integer goodsId, String partsCd,String goodsName) {
        List<KucunGoods> kucunGoodsList = productionInstructionGoodsMapper.selectJPExportsGoodsList(goodsId,partsCd,goodsName);
        for (KucunGoods kucunGoods:kucunGoodsList
        ) {
            List<GoodsLadderPrice> goodsLadderPriceList = goodsLadderPriceMapper.selectGoodsLadderPriceListByGoodsId(kucunGoods.getGoodsId());
            kucunGoods.setLadderPrice(LadderPriceUtil.getLadderPrice(goodsLadderPriceList));
        }
        List<StockKucunGoods> stockKucunGoodsList = new ArrayList<>();
        if(goodsId!=null){
            stockKucunGoodsList =stockKucunGoodsMapper.selectGoodsKucunById(goodsId);
        }else {
            stockKucunGoodsList =stockKucunGoodsMapper.selectGoodsKucun();
        }
        if(stockKucunGoodsList.size()>0){
            for (KucunGoods kucunGoods:kucunGoodsList
            ) {
                int goodsId1 = kucunGoods.getGoodsId();
                for (StockKucunGoods stockKucunGoods:stockKucunGoodsList
                ) {
                    if(goodsId1==stockKucunGoods.getGid() ){
                        kucunGoods.setSkgCount(stockKucunGoods.getSkgCount());
                    }
                }
                if(kucunGoods.getSkgCount()==null){
                    kucunGoods.setSkgCount(new BigDecimal(0));
                }
            }
        }else{
            for (KucunGoods kucunGoods:kucunGoodsList
            ) {
                kucunGoods.setSkgCount(new BigDecimal(0));
            }
        }
        return kucunGoodsList;
    }

    @Override
    public int selectJPExportsGoodsCount(Integer goodsId, String partsCd,String goodsName) {
        return productionInstructionGoodsMapper.selectJPExportsGoodsCount(goodsId,partsCd,goodsName);
    }
}
