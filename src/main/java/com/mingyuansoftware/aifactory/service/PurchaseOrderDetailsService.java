package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.PurchaseOrder;
import com.mingyuansoftware.aifactory.model.PurchaseOrderDetails;
import com.mingyuansoftware.aifactory.model.PurchaseOrderGoods;
import com.mingyuansoftware.aifactory.model.PurchaseStorageGoods;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 张婷
 * @date 2019/7/29 16:48
 */

@Service
public interface PurchaseOrderDetailsService {

    /**
     * 获取采购入库货物未入库货物列表(保存使用)
     * @param purchaseOrderId
     * @return
     */
    List<PurchaseOrderGoods> selectPDaPurchaseOrderDetailsGoodsList(int purchaseOrderId);
    /**
     * PDA获取采购入库未入库货物列表总条数(保存使用)
     * @param purchaseOrderId
     * @return
     */
    int selectPdaPurchaseOrderDetailsGoodsListCount(int purchaseOrderId);

    /**
     * 根据货物编号与采购订单id获取货物信息
     * @param goodsId
     * @param purchaseOrderId
     * @return
     */
    PurchaseStorageGoods selectPurchaseStorageGoodsCount(int goodsId, int purchaseOrderId);

    /**
     * 根据采购订详情id修改货物入库状态
     * @param staffId
     * @param purchaseOrderDetailsId
     * @param skgCount
     */

    PurchaseOrder updatePurchaseOrderDetailsStatus(Integer staffId, Integer purchaseOrderDetailsId, BigDecimal skgCount);

    /**
     * 获取采购入库货物列表(已入库操作)
     * @param purchaseOrderId
     * @return
     */
    List<PurchaseOrderGoods> selectPDaGoodsList(int purchaseOrderId);

    /**
     * 根据采购订单id和货物id查询采购详情订单id
     * @param purchaseOrderId
     * @param gid
     * @return
     */
    Integer selectPoId(Integer purchaseOrderId, Integer gid);

    /**
     * 采购订单Id和货物Id查询采购详情单内容(数量)
     * @param purchaseOrderId
     * @param gid
     * @return
     */
    PurchaseOrderDetails selectPDaPurchaseOrderDetailsByProIdAndGoodsId(Integer purchaseOrderId, Integer gid);
}
