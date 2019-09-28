package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.config.LogConfig;
import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.PDAProductionEntryDto;
import com.mingyuansoftware.aifactory.model.dto.ProductionEntryDto;
import com.mingyuansoftware.aifactory.service.ProductionEntryService;
import com.mingyuansoftware.aifactory.util.DateUtil;
import com.mingyuansoftware.aifactory.util.MyException;
import com.mingyuansoftware.aifactory.util.RandomCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

@Service
public class ProductionEntryServiceImpl implements ProductionEntryService {

    @Autowired
    private ProductionEntryMapper productionEntryMapper;
    @Autowired
    private ProductionEntryDetailsMapper productionEntryDetailsMapper;
    @Autowired
    private ProductionInstructionGoodsMapper productionInstructionGoodsMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private ProductionInstructionMapper productionInstructionMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private StockKucunGoodsMapper stockKucunGoodsMapper;
    @Autowired
    private ProductionOrderMapper productionOrderMapper;
    @Autowired
    private ProductionOrderDetailsMapper productionOrderDetailsMapper;
    @Autowired
    private BomFormMapper bomFormMapper;
    @Autowired
    private BomFormDetailMapper bomFormDetailMapper;

    @Override
    public List<ProductionEntry> selectProductionEntryList(ProductionEntryDto productionEntryDto) {
        try{
            return productionEntryMapper.selectProductionEntryList(productionEntryDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCountProductionEntry(ProductionEntryDto productionEntryDto) {
        try{
            return productionEntryMapper.selectCountProductionEntry(productionEntryDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteProductionEntryById(int productionEntryId) {
        productionEntryMapper.deleteByPrimaryKey(productionEntryId);
        productionEntryDetailsMapper.deleteProductionEntryDetailById(productionEntryId);

    }

    @Override
    public ProductionEntryInfo selectProductionEntryInfoById(int productionEntryId) {
        try {
            ProductionEntryInfo productionEntryInfo = new ProductionEntryInfo();
            ProductionEntry productionEntry= productionEntryMapper.selectProductionEntryById(productionEntryId);
            productionEntryInfo.setProductionEntryNumber(productionEntry.getProductionEntryNumber());
            productionEntryInfo.setAddTime(productionEntry.getAddTime());
            productionEntryInfo.setComment(productionEntry.getComment());
            productionEntryInfo.setLotNumber(productionEntry.getLotNumber());
            productionEntryInfo.setName(productionEntry.getName());
            productionEntryInfo.setWarehouseName(productionEntry.getWarehouseName());
            List<ProductionGoods> productionGoodsList = productionEntryDetailsMapper.selectProductionEntryDetailsById(productionEntryId);
            productionEntryInfo.setProductionGoodsList(productionGoodsList);
            List<ConsumptionGoods> consumptionGoodsList = new ArrayList<>();
            for (ProductionGoods productionGoods:productionGoodsList
                 ) {
                Goods goods = goodsMapper.selectGoodsByPartsCd(productionGoods.getPartsCd());
                BomForm bomForm = bomFormMapper.selectBomFormByGoodsId(goods.getGoodsId());
                List<BomFormDetail> bomFormDetailList = bomFormDetailMapper.selectBomFormDetailById(bomForm.getBomId());
                for (BomFormDetail bomFormDetail:bomFormDetailList
                ) {
                    ConsumptionGoods consumptionGoods = new ConsumptionGoods();
                    //计算需要货物比例
                    BigDecimal quantity = bomFormDetail.getQuantity().multiply(productionGoods.getAmount());
                    consumptionGoods.setQuantity(quantity.setScale(2,BigDecimal.ROUND_HALF_UP));
                    consumptionGoods.setPartsCd(bomFormDetail.getPartsCd());
                    consumptionGoods.setGoodsName(bomFormDetail.getGoodsName());
                    consumptionGoods.setSpecification(bomFormDetail.getSpecification());
                    consumptionGoods.setUnit(bomFormDetail.getUnit());
                    consumptionGoodsList.add(consumptionGoods);
                }
            }
            productionEntryInfo.setConsumptionGoodsList(consumptionGoodsList);
            return productionEntryInfo;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public String insertPdaProductionEntryList(List<PDAProductionEntryDto> pdaProductionEntryDtoList) {
        //仓库id
        int warehouseId =0;
        boolean number = true;
        int poId = 0;
        if(!(pdaProductionEntryDtoList.isEmpty())){
            ProductionEntry productionEntry = new ProductionEntry();
            //生产入库单编号
            String productionEntryNumber = "19"+ RandomCodeUtil.getRandomCode();
            boolean flag = true;
            for (PDAProductionEntryDto pdaProductionEntryDto:pdaProductionEntryDtoList
                 ) {
                Goods goods = goodsMapper.selectByPrimaryKey(pdaProductionEntryDto.getGoodsId());
                if(pdaProductionEntryDto.getAmount()==null||pdaProductionEntryDto.getAmount().equals("")){
                    if(pdaProductionEntryDto.getBoxesNumber()!=null){
                        pdaProductionEntryDto.setAmount(new BigDecimal(goods.getBoxesNumber()*pdaProductionEntryDto.getBoxesNumber()));
                    }
                }
                if(pdaProductionEntryDto.getBoxesNumber()==null||pdaProductionEntryDto.getBoxesNumber().equals("")){
                    if(pdaProductionEntryDto.getAmount()!=null){
                        pdaProductionEntryDto.setBoxesNumber(Integer.parseInt(String.valueOf(pdaProductionEntryDto.getAmount().divide(new BigDecimal(goods.getBoxesNumber()),0,BigDecimal.ROUND_UP))));
                    }
                }
                if (flag) {
                    productionEntry.setProductionEntryNumber(productionEntryNumber);
                    productionEntry.setStaffId(pdaProductionEntryDto.getStaffId());
                    productionEntry.setWarehouseId(pdaProductionEntryDto.getWarehouseId());
                    warehouseId = pdaProductionEntryDto.getWarehouseId();
                    productionEntry.setAddTime(DateUtil.getDate());
                    Staff staff = staffMapper.selectByPrimaryKey(pdaProductionEntryDto.getStaffId());
                    if (staff != null) {
                        productionEntry.setJobNumber(staff.getJobNumber());
                    }
                    productionEntryMapper.insert(productionEntry);
                    flag = false;
                }
                //根据排产单与货物id查询
                List<ProductionOrderDetails> productionOrderDetailsList = productionOrderDetailsMapper.selectProductionOrderDetailsByIdAndGoodsId(pdaProductionEntryDto.getPoId(), pdaProductionEntryDto.getGoodsId());
                //进行判断，货物详情为1个的情况
                if(productionOrderDetailsList.size()==1){
                    ProductionEntryDetails productionEntryDetails = new ProductionEntryDetails();
                    ProductionOrderDetails productionOrderDetails = productionOrderDetailsList.get(0);
                    int productionInstructionId =productionOrderDetails.getProductionInstructionId();
                    ProductionInstructionGoods productionInstructionGoods = productionInstructionGoodsMapper.selectProductionInstructionGoods(productionInstructionId,pdaProductionEntryDto.getGoodsId());
                    BomForm bomForm = bomFormMapper.selectBomFormByGoodsId(pdaProductionEntryDto.getGoodsId());
                    if(bomForm==null){
                        throw new MyException("生产入库提交失败,部品CD:"+goods.getPartsCd()+"的货物在BOM表单中未找到,请先创建此货物的Bom表单");
                    }
                    productionEntryDetails.setBomId(bomForm.getBomId());
                    productionEntryDetails.setProductionEntryId(productionEntry.getProductionEntryId());
                    productionEntryDetails.setPoId(pdaProductionEntryDto.getPoId());
                    poId =pdaProductionEntryDto.getPoId();
                    productionEntryDetails.setProductionInstructionId(productionOrderDetails.getProductionInstructionId());
                    if(productionInstructionGoods!=null){
                        productionEntryDetails.setProductionInstructionGoodsId(productionInstructionGoods.getProductionInstructionGoodsId());
                    }else{
                        throw new MyException("生产入库失败,该货物不属于此排产单内需生产的货物");
                    }
                    ProductionInstruction productionInstruction = productionInstructionMapper.selectByPrimaryKey(productionOrderDetails.getProductionInstructionId());
                    productionEntryDetails.setSerialNumber(productionInstruction.getSerialNumber());
                    productionEntryDetails.setGoodsId(pdaProductionEntryDto.getGoodsId());
                    productionEntryDetails.setAmount(pdaProductionEntryDto.getAmount());
                    productionEntryDetails.setMachinaryCode(pdaProductionEntryDto.getMachinaryCode());
                    productionEntryDetails.setBoxesNumber(pdaProductionEntryDto.getBoxesNumber());
                    productionEntryDetailsMapper.insert(productionEntryDetails);
                    //修改排产单状态和排产单详情状态
                    if(productionOrderDetails.getInventoryQuantity()==null){
                        productionOrderDetails.setInventoryQuantity(BigDecimal.ZERO);
                    }
                    BigDecimal quantity1 = productionOrderDetails.getQuantity().subtract(productionOrderDetails.getInventoryQuantity());
                    BigDecimal quantity2 = productionOrderDetails.getInventoryQuantity().add(pdaProductionEntryDto.getAmount());
                    //2.进行比较如果相等，则是完成，如果小于，则是部分完成
                    if(quantity1.compareTo(pdaProductionEntryDto.getAmount())==0){
                        //已完成
                        int status = 3;
                        productionOrderDetailsMapper.updateProductionOrderDetailsStatus(productionOrderDetails.getProductionOrderDetailsId(),quantity2,status);
                    }else if(quantity1.compareTo(pdaProductionEntryDto.getAmount())>0){
                        //部分完成
                        int status = 2;
                        productionOrderDetailsMapper.updateProductionOrderDetailsStatus(productionOrderDetails.getProductionOrderDetailsId(),quantity2,status);
                    }else if(quantity1.compareTo(pdaProductionEntryDto.getAmount())<0){
                        throw new MyException("生产入库失败,入库数量大于排产数量");
                    }
                    //根据bomId获取需要消耗货物的数量是否够用
                    if(LogConfig.requiredQuantityGoodsInsufficient==2){
                        List<BomFormDetail> bomFormDetailList = bomFormDetailMapper.selectBomFormDetailById(bomForm.getBomId());
                        for (BomFormDetail bomFormDetail:bomFormDetailList
                        ) {
                            //计算需要货物比例
                            BigDecimal quantity = bomFormDetail.getQuantity().multiply(pdaProductionEntryDto.getAmount());
                            KucunGoods kucunGoods=  stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsIdAndWarehouseId(warehouseId,bomFormDetail.getGoodId());
                            if(kucunGoods ==null || kucunGoods.getSkgCount().compareTo(quantity)<0){
                                throw new MyException("生产入库失败,生产数量为:"+pdaProductionEntryDto.getAmount()+"的部品CD:"+goods.getPartsCd()+"的货物需要部品CD:"+bomFormDetail.getPartsCd()+"的货物数量为:"+quantity+",仓库内目前存在的货物数量不足");
                            }
                        }
                    }
                      productionInstructionGoods.setFinishedQuantity(productionInstructionGoods.getFinishedQuantity().add(pdaProductionEntryDto.getAmount()));
                      productionInstructionGoods.setUnfinishedQuantity(productionInstructionGoods.getUnfinishedQuantity().subtract(pdaProductionEntryDto.getAmount()));
                      if((productionInstructionGoods.getFinishedQuantity().compareTo(BigDecimal.ZERO)<0)
                              ||(productionInstructionGoods.getUnfinishedQuantity().compareTo(BigDecimal.ZERO)<0)
                              ||(productionInstructionGoods.getFinishedQuantity().add(productionInstructionGoods.getUnfinishedQuantity()).compareTo(productionInstructionGoods.getProductionSchedule())!=0)){
                          throw new MyException("提交失败,"+goods.getPartsCd()+"入库数量大于生产预定数");
                      }
                      //未完成数量为0，修改状态为已完成
                      if(productionInstructionGoods.getUnfinishedQuantity().compareTo(BigDecimal.ZERO)==0){
                          productionInstructionGoods.setState((byte)3);
                      }
                      //完成数量大于0并且完成数量小于生产预定数，修改状态为部分完成
                      if(productionInstructionGoods.getFinishedQuantity().compareTo(BigDecimal.ZERO)>0&&
                              productionInstructionGoods.getFinishedQuantity().compareTo(productionInstructionGoods.getProductionSchedule())<0){
                          productionInstructionGoods.setState((byte)2);
                      }
                      productionInstructionGoodsMapper.updateByPrimaryKey(productionInstructionGoods);

                    //3.修改排产单的状态
                    List<ProductionOrderDetails> productionOrderDetailsList1 =productionOrderDetailsMapper.selectProductionOrderDetailsById(poId);

                    for (ProductionOrderDetails productionOrderDetails1:productionOrderDetailsList1
                    ) {
                        if(productionOrderDetails1.getStatus()<3){
                            number = false;
                            break;
                        }
                    }
                    if(number){
                        //已完成
                        int state = 3;
                        productionOrderMapper.updateStateById(poId,state);
                    }else{
                        //部分完成
                        int state = 2;
                        productionOrderMapper.updateStateById(poId,state);

                    }

                }else if(productionOrderDetailsList.size()>1){
                    //入库总数量
                    BigDecimal entryQuantity = pdaProductionEntryDto.getAmount();
                    //生产数量
                    BigDecimal productionQuantity = new BigDecimal(0);
                    //剩余数量
                    BigDecimal amount = pdaProductionEntryDto.getAmount();
                    //计算入库数量与排产单中需要排产的数量进行比较
                    for (ProductionOrderDetails productionOrderDetails:productionOrderDetailsList
                         ) {
                        //如果剩余数量与排产单详情数量相等
                        if(amount.compareTo(productionOrderDetails.getQuantity().subtract(productionOrderDetails.getInventoryQuantity()))==0){
                            productionOrderDetails.setFlag(true);
                            productionOrderDetails.setNum(1);
                            amount = BigDecimal.ZERO;
                            break;
                        }else if(amount.compareTo(productionOrderDetails.getQuantity().subtract(productionOrderDetails.getInventoryQuantity()))<0){
                            productionOrderDetails.setFlag(true);
                            productionOrderDetails.setNum(2);
                           break;
                        }else if(amount.compareTo(productionOrderDetails.getQuantity().subtract(productionOrderDetails.getInventoryQuantity()))>0){
                            productionOrderDetails.setFlag(true);
                            productionOrderDetails.setNum(1);
                            amount =amount.subtract(productionOrderDetails.getQuantity().subtract(productionOrderDetails.getInventoryQuantity()));
                        }
                    }
                    for (ProductionOrderDetails productionOrderDetails:productionOrderDetailsList
                    ) {
                        productionQuantity = productionQuantity.add(productionOrderDetails.getQuantity().subtract(productionOrderDetails.getInventoryQuantity()));
                    }
                    if(entryQuantity.compareTo(productionQuantity)>0){
                        throw new MyException("提交失败,"+goods.getPartsCd()+"入库数量大于排产数量");
                    }

                    //遍历(按照生产指示书id正序排列)排产单货物列表
                    for (ProductionOrderDetails productionOrderDetails:productionOrderDetailsList
                         ) {
                        if(productionOrderDetails.getFlag()==null){
                            productionOrderDetails.setFlag(false);
                        }
                        if (productionOrderDetails.getFlag()){
                            ProductionEntryDetails productionEntryDetails = new ProductionEntryDetails();
                            int productionInstructionId =productionOrderDetails.getProductionInstructionId();
                            ProductionInstructionGoods productionInstructionGoods = productionInstructionGoodsMapper.selectProductionInstructionGoods(productionInstructionId,pdaProductionEntryDto.getGoodsId());
                            BomForm bomForm = bomFormMapper.selectBomFormByGoodsId(pdaProductionEntryDto.getGoodsId());
                            if(bomForm==null){
                                throw new MyException("生产入库提交失败,部品CD:"+goods.getPartsCd()+"的货物在BOM表单中未找到,请先创建此货物的Bom表单");
                            }
                            productionEntryDetails.setBomId(bomForm.getBomId());
                            productionEntryDetails.setProductionEntryId(productionEntry.getProductionEntryId());
                            productionEntryDetails.setPoId(pdaProductionEntryDto.getPoId());
                            poId =pdaProductionEntryDto.getPoId();
                            productionEntryDetails.setProductionInstructionId(productionOrderDetails.getProductionInstructionId());
                            if(productionInstructionGoods!=null){
                                productionEntryDetails.setProductionInstructionGoodsId(productionInstructionGoods.getProductionInstructionGoodsId());
                            }else{
                                throw new MyException("生产入库失败,该货物不属于此排产单内需生产的货物");
                            }
                            ProductionInstruction productionInstruction = productionInstructionMapper.selectByPrimaryKey(productionOrderDetails.getProductionInstructionId());
                            productionEntryDetails.setSerialNumber(productionInstruction.getSerialNumber());
                            productionEntryDetails.setGoodsId(pdaProductionEntryDto.getGoodsId());
                            if(productionOrderDetails.getNum()==1){
                                productionEntryDetails.setAmount(productionOrderDetails.getQuantity().subtract(productionOrderDetails.getInventoryQuantity()));
                            }else if(productionOrderDetails.getNum()==2){
                                productionEntryDetails.setAmount(amount);
                            }
                            productionEntryDetails.setMachinaryCode(pdaProductionEntryDto.getMachinaryCode());
                            productionEntryDetails.setBoxesNumber(Integer.parseInt(String.valueOf(pdaProductionEntryDto.getAmount().divide(new BigDecimal(goods.getBoxesNumber()),0,BigDecimal.ROUND_UP))));
                            productionEntryDetailsMapper.insert(productionEntryDetails);
                            //修改排产单状态和排产单详情状态
                            if(productionOrderDetails.getNum()==1){
                                //已完成
                                int status = 3;
                                productionOrderDetailsMapper.updateProductionOrderDetailsStatus(productionOrderDetails.getProductionOrderDetailsId(),productionOrderDetails.getQuantity(),status);
                            }else if(productionOrderDetails.getNum()==2){
                                //部分完成
                                int status = 2;
                                productionOrderDetailsMapper.updateProductionOrderDetailsStatus(productionOrderDetails.getProductionOrderDetailsId(),amount.add(productionOrderDetails.getInventoryQuantity()),status);
                            }
                            //根据bomId获取需要消耗货物的数量是否够用
                            if(LogConfig.requiredQuantityGoodsInsufficient==2){
                                List<BomFormDetail> bomFormDetailList = bomFormDetailMapper.selectBomFormDetailById(bomForm.getBomId());
                                for (BomFormDetail bomFormDetail:bomFormDetailList
                                ) {
                                    //计算需要货物比例
                                    BigDecimal quantity = bomFormDetail.getQuantity().multiply(pdaProductionEntryDto.getAmount());
                                    KucunGoods kucunGoods=  stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsIdAndWarehouseId(warehouseId,bomFormDetail.getGoodId());
                                    if(kucunGoods ==null || kucunGoods.getSkgCount().compareTo(quantity)<0){
                                        throw new MyException("生产入库失败,生产数量为:"+pdaProductionEntryDto.getAmount()+"的部品CD:"+goods.getPartsCd()+"的货物需要部品CD:"+bomFormDetail.getPartsCd()+"的货物数量为:"+quantity+",仓库内目前存在的货物数量不足");
                                    }
                                }
                            }
                            productionInstructionGoods.setFinishedQuantity(productionInstructionGoods.getFinishedQuantity().add(productionEntryDetails.getAmount()));
                            productionInstructionGoods.setUnfinishedQuantity(productionInstructionGoods.getUnfinishedQuantity().subtract(productionEntryDetails.getAmount()));
                            if((productionInstructionGoods.getFinishedQuantity().compareTo(BigDecimal.ZERO)<0)
                                    ||(productionInstructionGoods.getUnfinishedQuantity().compareTo(BigDecimal.ZERO)<0)
                                    ||(productionInstructionGoods.getFinishedQuantity().add(productionInstructionGoods.getUnfinishedQuantity()).compareTo(productionInstructionGoods.getProductionSchedule())!=0)){
                                throw new MyException("提交失败,"+goods.getPartsCd()+"入库数量大于生产预定数");
                            }
                            //未完成数量为0，修改状态为已完成
                            if(productionInstructionGoods.getUnfinishedQuantity().compareTo(BigDecimal.ZERO)==0){
                                productionInstructionGoods.setState((byte)3);
                            }
                            //完成数量大于0并且完成数量小于生产预定数，修改状态为部分完成
                            if(productionInstructionGoods.getFinishedQuantity().compareTo(BigDecimal.ZERO)>0&&
                                    productionInstructionGoods.getFinishedQuantity().compareTo(productionInstructionGoods.getProductionSchedule())<0){
                                productionInstructionGoods.setState((byte)2);
                            }
                            productionInstructionGoodsMapper.updateByPrimaryKey(productionInstructionGoods);

                            //3.修改排产单的状态
                            List<ProductionOrderDetails> productionOrderDetailsList1 =productionOrderDetailsMapper.selectProductionOrderDetailsById(poId);

                            for (ProductionOrderDetails productionOrderDetails1:productionOrderDetailsList1
                            ) {
                                if(productionOrderDetails1.getStatus()<3){
                                    number = false;
                                    break;
                                }
                            }
                            if(number){
                                //已完成
                                int state = 3;
                                productionOrderMapper.updateStateById(poId,state);
                            }else{
                                //部分完成
                                int state = 2;
                                productionOrderMapper.updateStateById(poId,state);

                            }
                        }
                    }
                }else if(productionOrderDetailsList.isEmpty()){
                    throw new MyException("生产入库失败,该货物不属于此排产单内需生产的货物");
                }
            }
            return productionEntryNumber;
        }
        return null;
  }


}
