package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PurchaseOrderDetails;
import com.mingyuansoftware.aifactory.model.PurchaseOrderGoods;
import com.mingyuansoftware.aifactory.model.PurchaseStorageGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface PurchaseOrderDetailsMapper {
    int deleteByPrimaryKey(Integer purchaseOrderDetailsId);

    int insert(PurchaseOrderDetails record);

    PurchaseOrderDetails selectByPrimaryKey(Integer purchaseOrderDetailsId);

    List<PurchaseOrderDetails> selectAll();

    int updateByPrimaryKey(PurchaseOrderDetails record);

    /**
     * 根据采购订单id查询采购订单详情
     * @param purchaseOrderId
     * @return
     */
    List<PurchaseOrderDetails> selectPurchaseOrderDetailsById(@Param("purchaseOrderId") int purchaseOrderId);

    /**
     * 根据采购订单id删除采购订单详情内容
     * @param purchaseOrderId
     */
    void deletePurchaseOrderDetails(@Param("purchaseOrderId") Integer purchaseOrderId);

    /**
     * 根据采购订单id查询采购订单详情
     * @param purchaseOrderId
     * @return
     */
    List<PurchaseOrderDetails> selectPurchaseOrderGoodsList(@Param("purchaseOrderId") int purchaseOrderId,@Param("partsCd") String partsCd,@Param("goodsName") String goodsName);

    /**
     * 根据采购订单id查询采购订单详情总条数
     * @param purchaseOrderId
     * @return
     */
    int selectSalesReturnGoodsCount(@Param("purchaseOrderId") int purchaseOrderId,@Param("partsCd") String partsCd,@Param("goodsName") String goodsName);

    /**
     * 获取采购入库货物未入库货物列表
     * @param purchaseOrderId
     * @return
     */
    List<PurchaseOrderGoods> selectPDaPurchaseOrderDetailsGoodsList(@Param("purchaseOrderId") int purchaseOrderId);

    /**
     * PDA获取采购入库未入库货物列表总条数
     * @param purchaseOrderId
     * @return
     */
    int selectPdaPurchaseOrderDetailsGoodsListCount(@Param("purchaseOrderId") int purchaseOrderId);

    /**
     * 根据货物编号与采购订单id获取货物信息
     * @param goodsId
     * @param purchaseOrderId
     * @return
     */
    PurchaseStorageGoods selectPurchaseStorageGoodsCount(@Param("goodsId") int goodsId, @Param("purchaseOrderId") int purchaseOrderId);

    /**
     * 更新采购订单详情的退货数量
     * @param purchaseOrderId
     * @param goodsId
     * @param returnQuantity
     */
    void updateReturnQuantity(@Param("purchaseOrderId") Integer purchaseOrderId,@Param("goodsId") Integer goodsId,@Param("returnQuantity") BigDecimal returnQuantity);

    /**
     * 根据采购订单详情id修改货物入库状态
     * @param purchaseOrderDetailsId
     */
    void updatePurchaseOrderDetailsStatus(@Param("purchaseOrderDetailsId") int purchaseOrderDetailsId,@Param("skgCount") BigDecimal skgCount,@Param("state") int state);

    /**
     * 获取采购入库货物列表(已入库操作 2.)
     * @param purchaseOrderId
     * @return
     */
    List<PurchaseOrderGoods> selectPDaGoodsList(@Param("purchaseOrderId") int purchaseOrderId);

    /**
     * 查询货物的退货数量
     * @param purchaseOrderId
     * @param goodsId
     * @return
     */
    PurchaseOrderDetails selectReturnQuantity(@Param("purchaseOrderId") Integer purchaseOrderId,@Param("goodsId") Integer goodsId);

    /**
     * 根据采购订单id和货物id查询此货物的数量
     * @param purchaseOrderId
     * @param goodsId
     * @return
     */
    PurchaseOrderDetails selectGoodsQuantityById(@Param("purchaseOrderId") Integer purchaseOrderId,@Param("goodsId") Integer goodsId);

    /**
     * 根据采购订单id和货物id查询采购详情订单id
     * @param purchaseOrderId
     * @param gid
     * @return
     */
    Integer selectPoId(@Param("purchaseOrderId") Integer purchaseOrderId,@Param("gid") Integer gid);

    /**
     * 根据采购订单id修改pda操作货物入库状态:3.部分入库
     * @param purchaseOrderDetailsId
     * @param state
     */
    void updatePurchaseOrderDetailsStatusById(@Param("purchaseOrderDetailsId") Integer purchaseOrderDetailsId,@Param("state") int state);


    /**
     * 根据采购订单详情id修改财务金额
     * @param purchaseOrderDetailsId
     * @param financeMoney
     */
    void updatePurchaseOrderFinance(@Param("purchaseOrderDetailsId") Integer purchaseOrderDetailsId,@Param("financeMoney") BigDecimal financeMoney);

    /**
     * 采购订单Id和货物Id查询采购详情单内容(数量)
     * @param purchaseOrderId
     * @param gid
     * @return
     */
    PurchaseOrderDetails selectPDaPurchaseOrderDetailsByProIdAndGoodsId(@Param("purchaseOrderId") Integer purchaseOrderId,@Param("gid") Integer gid);

    /**
     * 更新采购订单详情的已入库数量,已入库数量:采购数量-已退货数量
     * @param purchaseOrderId
     * @param goodsId
     * @param returnQuantity
     */
    void updateInQuantity(@Param("purchaseOrderId") Integer purchaseOrderId,@Param("goodsId") Integer goodsId,@Param("returnQuantity") BigDecimal returnQuantity);
}