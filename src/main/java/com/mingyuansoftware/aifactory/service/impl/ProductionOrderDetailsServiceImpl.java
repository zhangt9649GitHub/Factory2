package com.mingyuansoftware.aifactory.service.impl;


import com.mingyuansoftware.aifactory.constants.Constants;
import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.PDAProductionEntryDto;
import com.mingyuansoftware.aifactory.model.dto.ProductionOrderDetailsDto;
import com.mingyuansoftware.aifactory.service.PickingService;
import com.mingyuansoftware.aifactory.service.ProductionOrderDetailsService;
import com.mingyuansoftware.aifactory.util.CalculateQuantityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductionOrderDetailsServiceImpl implements ProductionOrderDetailsService {

    @Autowired
    private ProductionOrderDetailsMapper productionOrderDetailsMapper;
    @Autowired
    private BomFormMapper bomFormMapper;
    @Autowired
    private BomFormDetailMapper bomFormDetailMapper;
    @Autowired
    private StockKucunGoodsMapper stockKucunGoodsMapper;
    @Autowired
    private PickingDetailsMapper pickingDetailsMapper;


    @Override
    public List<ProductionOrderDetailsDto> selectProductionOrderDetailsList(ProductionOrderDetailsDto productionOrderDetailsDto) {
        try{
            List<ProductionOrderDetailsDto>  productionOrderDetailsDtoList = productionOrderDetailsMapper.selectProductionOrderDetailsList(productionOrderDetailsDto);
            for (ProductionOrderDetailsDto productionOrderDetailsDto1:productionOrderDetailsDtoList
                 ) {
                 BomForm bomForm = bomFormMapper.selectBomFormByGoodsId(productionOrderDetailsDto1.getGoodsId());
                //根据货物id和bomId和PrepareProduction的数量计算可以准备生产的数量
                List<CalculateQuantity> calculateQuantityList = new ArrayList<>();
                 if(bomForm==null){
                     productionOrderDetailsDto1.setNewStorageAmount(BigDecimal.ZERO);
                 }else{
                     List<BomFormDetail> bomFormDetailList = bomFormDetailMapper.selectBomFormDetailById(bomForm.getBomId());
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
                     BigDecimal newStorageAmount = CalculateQuantityUtil.calculateQuantity(calculateQuantityList);
                     productionOrderDetailsDto1.setNewStorageAmount(newStorageAmount);
                 }
                //如果状态为3,说明是已完成,3.绿色是已完成
                if(productionOrderDetailsDto1.getStatus()==3){
                    productionOrderDetailsDto1.setColor(3);
                }else{
                    //标记
                    Boolean number = true;
                    Boolean flag = true;
                    //判断是否已领料，1.黄色是已领料
                    for (CalculateQuantity calculateQuantity:calculateQuantityList
                         ) {
                       //根据排产单id与货物id查询领料单
                       PickingDetails pickingDetails = pickingDetailsMapper.selectPickingStatusById(productionOrderDetailsDto1.getProductionOrderId(),calculateQuantity.getGoodsId());
                       if(pickingDetails==null){
                           flag = false;
                       }else if(pickingDetails.getStatus()==1){
                           number = false;
                       }
                    }
                    if(flag){
                        //如果为true，说明已领料
                        if(number){
                            productionOrderDetailsDto1.setColor(1);
                        }else{
                            //如果为false，如果没领料，或者是部分领料 2.红色是资材不足 4.蓝色为原料足够 5.不是足够但是有的为淡蓝色
                            //可以新增的数量
                            BigDecimal newStorageAmount = productionOrderDetailsDto1.getNewStorageAmount();
                            //已经生产的数量
                            BigDecimal producedAmount = productionOrderDetailsDto1.getProducedAmount();
                            //排产数量
                            BigDecimal quantity = productionOrderDetailsDto1.getQuantity();
                            //如果可以新增的数量+已经生产的数量>=排产数量,说明原料足够
                            if(newStorageAmount.add(producedAmount).compareTo(quantity)>=0){
                                productionOrderDetailsDto1.setColor(4);
                            }else if(newStorageAmount.compareTo(BigDecimal.ZERO)==0){
                                productionOrderDetailsDto1.setColor(2);
                            }else if(newStorageAmount.add(producedAmount).compareTo(quantity)<0){
                                productionOrderDetailsDto1.setColor(5);
                            }
                        }
                    }
                }

            }

            if(productionOrderDetailsDto.getNewStorageAmount()==null){}else{
                    List<ProductionOrderDetailsDto> productionOrderDetailsDtoList1 = new ArrayList<>();
                    for (ProductionOrderDetailsDto productionOrderDetailsDto1:productionOrderDetailsDtoList
                    ) {
                        if(productionOrderDetailsDto.getNewStorageAmount().compareTo(productionOrderDetailsDto1.getNewStorageAmount())==0){
                            productionOrderDetailsDtoList1.add(productionOrderDetailsDto1);
                        }
                    }
                    return productionOrderDetailsDtoList1;
            }
            return productionOrderDetailsDtoList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCountProductionOrderDetails(ProductionOrderDetailsDto productionOrderDetailsDto) {
        try{
          //return productionOrderDetailsMapper.selectCountProductionOrderDetails(productionOrderDetailsDto);
            List<ProductionOrderDetailsDto>  productionOrderDetailsDtoList = productionOrderDetailsMapper.selectProductionOrderDetailsList(productionOrderDetailsDto);
            for (ProductionOrderDetailsDto productionOrderDetailsDto1:productionOrderDetailsDtoList
            ) {
                BomForm bomForm = bomFormMapper.selectBomFormByGoodsId(productionOrderDetailsDto1.getGoodsId());
                if(bomForm==null){
                    productionOrderDetailsDto1.setNewStorageAmount(BigDecimal.ZERO);
                }else{
                    //根据货物id和bomId和PrepareProduction的数量计算可以准备生产的数量
                    List<CalculateQuantity> calculateQuantityList = new ArrayList<>();
                    List<BomFormDetail> bomFormDetailList = bomFormDetailMapper.selectBomFormDetailById(bomForm.getBomId());
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
                    BigDecimal newStorageAmount = CalculateQuantityUtil.calculateQuantity(calculateQuantityList);
                    productionOrderDetailsDto1.setNewStorageAmount(newStorageAmount);
                }
            }
            if(productionOrderDetailsDto.getNewStorageAmount()==null){}else{
                    List<ProductionOrderDetailsDto> productionOrderDetailsDtoList1 = new ArrayList<>();
                    for (ProductionOrderDetailsDto productionOrderDetailsDto1 : productionOrderDetailsDtoList
                    ) {
                        if (productionOrderDetailsDto.getNewStorageAmount().compareTo(productionOrderDetailsDto1.getNewStorageAmount()) == 0) {
                            productionOrderDetailsDtoList1.add(productionOrderDetailsDto1);
                        }
                    }
                    if (productionOrderDetailsDtoList1.isEmpty()) {
                        return 0;
                    } else {
                        return productionOrderDetailsDtoList1.size();
                    }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProductionOrderDetailsIsRead(int productionOrderDetailsId) {
        productionOrderDetailsMapper.updateProductionOrderDetailsIsRead(productionOrderDetailsId);
    }

    @Override
    public List<ProductionPlanningAnalysis> selectProductionPlanningAnalysisList(ProductionPlanningAnalysis productionPlanningAnalysis) {
        //根据生产指示书查询所有准备要生产的货物
        List<ProductionPlanningAnalysis>  productionPlanningAnalysisList = productionOrderDetailsMapper.selectProductionPlanningAnalysisList(productionPlanningAnalysis);
        //成型品集合
        List<MoldingProduction> moldingProductionList = new ArrayList<>();
        //材料集合
        List<Material> materialList = new ArrayList<>();
        //完成品集合
        List<FinishedProduct> finishedProductList = new ArrayList<>();

        //遍历商品,获取组成商品的完成品的在库量，如果是多个取第一个
        for (ProductionPlanningAnalysis productionPlanningAnalysis1:productionPlanningAnalysisList
             ) {
            int goodsId =productionPlanningAnalysis1.getGoodsId();
            //根据货物id查询bom表单的bomId
            BomForm bomForm = bomFormMapper.selectBomFormByGoodsId(goodsId);
            List<BomFormDetail> bomFormDetailList =bomFormDetailMapper.selectBomFormDetailById(bomForm.getBomId());
            boolean flag = true;
            for (BomFormDetail bomFormDetail:bomFormDetailList
                 ) {
          /*      //判断组成此货物的完成品
                if(flag){
                    if(bomFormDetail.getCategory()== Constants.GOODS_CATEGORY_HALF){
                        flag = false;
                        KucunGoods kucunGoods = stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsId(bomFormDetail.getGoodId());
                        if(kucunGoods!=null){
                            productionPlanningAnalysis1.setFinishedAmount(kucunGoods.getSkgCount());
                        }else{
                            flag = true;
                        }
                    }
                }
                if(flag){
                    productionPlanningAnalysis1.setFinishedAmount(BigDecimal.ZERO);
                }*/
               //判断组成此货物的完成品
                if(bomFormDetail.getCategory()== Constants.GOODS_CATEGORY_HALF) {
                    FinishedProduct finishedProduct = new FinishedProduct();
                    finishedProduct.setGoodsName(bomFormDetail.getGoodsName());
                    //任务量 商品的新加任务量*bom表单中对应的比例
                    BigDecimal taskAmount =productionPlanningAnalysis1.getNewTask().multiply(bomFormDetail.getQuantity());
                    finishedProduct.setTaskAmount(taskAmount);
                    finishedProduct.setCycle(bomFormDetail.getCycle());
                    BigDecimal shift = CalculateQuantityUtil.calculateShift(taskAmount,bomFormDetail.getCycle());
                    finishedProduct.setShift(shift);
                    //累计完成量 待定
                    KucunGoods kucunGoods = stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsId(bomFormDetail.getGoodId());
                    if(kucunGoods!=null) {
                        finishedProduct.setFinishedAmount(kucunGoods.getSkgCount());
                    }else{
                        finishedProduct.setFinishedAmount(BigDecimal.ZERO);
                    }
                    finishedProductList.add(finishedProduct);
                }
              //判断组成此货物的成型品
                if(bomFormDetail.getCategory()== Constants.GOODS_CATEGORY_MANUFACTURING){
                //根据货物id查询MoldingProduction
                    MoldingProduction moldingProduction = new MoldingProduction();
                    moldingProduction.setGoodsName(bomFormDetail.getGoodsName());
                    //任务量 商品的新加任务量*bom表单中对应的比例
                    BigDecimal taskAmount =productionPlanningAnalysis1.getNewTask().multiply(bomFormDetail.getQuantity());
                    moldingProduction.setTaskAmount(taskAmount);
                    moldingProduction.setCycle(bomFormDetail.getCycle());
                    BigDecimal shift = CalculateQuantityUtil.calculateShift(taskAmount,bomFormDetail.getCycle());
                    moldingProduction.setShift(shift);
                    //累计完成量 待定
                    KucunGoods kucunGoods = stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsId(bomFormDetail.getGoodId());
                    if(kucunGoods!=null) {
                        moldingProduction.setCumulativeCompletion(kucunGoods.getSkgCount());
                    }else{
                        moldingProduction.setCumulativeCompletion(BigDecimal.ZERO);
                    }
                    moldingProductionList.add(moldingProduction);
                }
             //判断组成此货物的材料
                if(bomFormDetail.getCategory()== Constants.GOODS_CATEGORY_RAW_MATERIAL){
                    Material material = new Material();
                    material.setMaterial(bomFormDetail.getGoodsName());
                    //累计完成量 待定
                    KucunGoods kucunGoods = stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsId(bomFormDetail.getGoodId());
                    if(kucunGoods!=null) {
                        material.setSkgCount(kucunGoods.getSkgCount());
                    }else{
                        material.setSkgCount(BigDecimal.ZERO);
                    }
                    //所需数量
                    BigDecimal amount =productionPlanningAnalysis1.getNewTask().multiply(bomFormDetail.getQuantity());
                    material.setAmount(amount);
                    materialList.add(material);
                }
            }

        }
        //最大集合名
        String maxListName = null;
       //将集合放入结果集
        for (ProductionPlanningAnalysis productionPlanningAnalysis1:productionPlanningAnalysisList
             ) {
            productionPlanningAnalysis1.setMoldingProductionList(moldingProductionList);
            productionPlanningAnalysis1.setMaterialList(materialList);
            productionPlanningAnalysis1.setFinishedProductList(finishedProductList);
            int a = moldingProductionList.size();
            int b = materialList.size();
            int c = finishedProductList.size();
            int max = ((max=(a>=b)?a:b)>=c?max:c);
            if(max == a){
                maxListName = "moldingProductionList";
            }else if(max == b){
                maxListName = "materialList";
            }else if(max == c){
                maxListName = "finishedProductList";
            }
            productionPlanningAnalysis1.setMaxListName(maxListName);
        }
        return productionPlanningAnalysisList;
    }

}
