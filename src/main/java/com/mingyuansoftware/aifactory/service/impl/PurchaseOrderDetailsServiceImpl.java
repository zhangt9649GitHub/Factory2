package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.GoodsMapper;
import com.mingyuansoftware.aifactory.mapper.PurchaseOrderDetailsMapper;
import com.mingyuansoftware.aifactory.mapper.PurchaseOrderMapper;
import com.mingyuansoftware.aifactory.mapper.SupplierGoodsMapper;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.service.PurchaseOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 张婷
 * @date 2019/7/29 16:49
 */

@Service
public class PurchaseOrderDetailsServiceImpl implements PurchaseOrderDetailsService {

    @Autowired
    private PurchaseOrderDetailsMapper purchaseOrderDetailsMapper;
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private SupplierGoodsMapper supplierGoodsMapper;

    @Override
    public List<PurchaseOrderGoods> selectPDaPurchaseOrderDetailsGoodsList(int purchaseOrderId) {
        try {
            return purchaseOrderDetailsMapper.selectPDaPurchaseOrderDetailsGoodsList(purchaseOrderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectPdaPurchaseOrderDetailsGoodsListCount(int purchaseOrderId) {
        try {
            return purchaseOrderDetailsMapper.selectPdaPurchaseOrderDetailsGoodsListCount(purchaseOrderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public PurchaseStorageGoods selectPurchaseStorageGoodsCount(int goodsId, int purchaseOrderId) {
        try {
            return purchaseOrderDetailsMapper.selectPurchaseStorageGoodsCount(goodsId,purchaseOrderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PurchaseOrder updatePurchaseOrderDetailsStatus(Integer staffId, Integer purchaseOrderDetailsId, BigDecimal skgCount) {
        int state = 2;
        //修改本条采购订单详情货物为已入库(2)
        purchaseOrderDetailsMapper.updatePurchaseOrderDetailsStatus(purchaseOrderDetailsId,skgCount,state);  //修改未入库数量:未入库数量-入库数量
        PurchaseOrderDetails purchaseOrderDetails = purchaseOrderDetailsMapper.selectByPrimaryKey(purchaseOrderDetailsId);
        //判断 入库数量-未入库数量的!=0,修改本条采购订单详情货物为部分入库(3)
        if(!(purchaseOrderDetails.getQuantity().subtract(purchaseOrderDetails.getInQuantity()).compareTo(BigDecimal.ZERO) == 0)){
            state = 3;
            purchaseOrderDetailsMapper.updatePurchaseOrderDetailsStatusById(purchaseOrderDetailsId,state);
        }else {
            state = 2;
            purchaseOrderDetailsMapper.updatePurchaseOrderDetailsStatusById(purchaseOrderDetailsId,state);
        }
        //判断入库状态不能为3(已入库)
        PurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(purchaseOrderDetails.getPurchaseOrderId());
        if(purchaseOrder.getStorageState() == 3){
            return purchaseOrder;
        }
        List<PurchaseOrderDetails> purchaseOrderDetailsList = purchaseOrderDetailsMapper.selectPurchaseOrderDetailsById(purchaseOrderDetails.getPurchaseOrderId());
        boolean flag = true;
        for (PurchaseOrderDetails purchaseOrderDetails1:purchaseOrderDetailsList){
            if (purchaseOrderDetails1.getPodStorageState() == 1){
                flag = false;
                state = 2;
                //部分入库为2
                purchaseOrderMapper.updatePurchaseOrderStorageState(purchaseOrderDetails.getPurchaseOrderId(),state,staffId);
                break;
            }
            if (purchaseOrderDetails1.getPodStorageState() == 3){
                flag = false;
                state = 2;
                //部分入库为2
                purchaseOrderMapper.updatePurchaseOrderStorageState(purchaseOrderDetails.getPurchaseOrderId(),state,staffId);
                break;
            }
        }
        //采购订单详情中的所有货物全部完成入库操作,则修改采购订单状态为已入库
        if(flag){
            //已入库
            state = 3;
            purchaseOrderMapper.updatePurchaseOrderStorageState(purchaseOrderDetails.getPurchaseOrderId(),state,staffId);
        }

        //添加供应商供应货物历史
        Goods goods = goodsMapper.selectByPrimaryKey(purchaseOrderDetails.getGoodsId());
        //先根据供应商Id和货物CD查询供应商货物表中的内容,如果为空就添加,否则修改货物数量
        SupplierGoods supplierGoodsInfo = supplierGoodsMapper.selectSuGoodsBySuIdAndGoodsId(purchaseOrder.getSupplierId(),goods.getPartsCd());
        SupplierGoods supplierGoods = new SupplierGoods();
        if(supplierGoodsInfo == null){
            supplierGoods.setSupplierId(purchaseOrder.getSupplierId());
            supplierGoods.setPartsCd(goods.getPartsCd());
            supplierGoods.setQuantity(purchaseOrderDetails.getInQuantity());
            supplierGoods.setProductName(goods.getGoodsName());
            supplierGoods.setSpecification(goods.getSpecification());
            supplierGoods.setIsDelete((byte)0);
            supplierGoodsMapper.insert(supplierGoods);
        }else {//根据供应商Id和部品CD修改供应过的货物数量(叠加)
            supplierGoods.setSupplierId(purchaseOrder.getSupplierId());
            supplierGoods.setPartsCd(goods.getPartsCd());
            supplierGoods.setQuantity(skgCount);
            supplierGoodsMapper.updateQuantityBy(supplierGoods);
        }
        return purchaseOrder;
    }

    @Override
    public List<PurchaseOrderGoods> selectPDaGoodsList(int purchaseOrderId) {
        try {
            return purchaseOrderDetailsMapper.selectPDaGoodsList(purchaseOrderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer selectPoId(Integer purchaseOrderId, Integer gid) {
        try {
            return purchaseOrderDetailsMapper.selectPoId(purchaseOrderId,gid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PurchaseOrderDetails selectPDaPurchaseOrderDetailsByProIdAndGoodsId(Integer purchaseOrderId, Integer gid) {
        try {
            return purchaseOrderDetailsMapper.selectPDaPurchaseOrderDetailsByProIdAndGoodsId(purchaseOrderId,gid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
