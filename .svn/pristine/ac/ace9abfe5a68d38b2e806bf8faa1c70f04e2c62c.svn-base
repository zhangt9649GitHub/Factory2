package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PurchaseReturnOrder;
import com.mingyuansoftware.aifactory.model.dto.PurchaseReturnOrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PurchaseReturnOrderMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(PurchaseReturnOrder record);

    PurchaseReturnOrder selectByPrimaryKey(@Param("proId") Integer proId);

    List<PurchaseReturnOrder> selectAll();

    int updateByPrimaryKey(PurchaseReturnOrder record);

    /**
     * 获取采购退货单列表
     * @param purchaseReturnOrderDto
     * @return
     */
    List<PurchaseReturnOrderDto> selectPurchaseReturnOrderList(@Param("purchaseReturnOrderDto") PurchaseReturnOrderDto purchaseReturnOrderDto);

    /**
     * 获取采购退货单列表总条数
     * @param purchaseReturnOrderDto
     */
    int selectPurchaseReturnOrderCount(@Param("purchaseReturnOrderDto") PurchaseReturnOrderDto purchaseReturnOrderDto);

    /**
     * 获取采购退货单最新的id
     * @return
     */
    int selectLastId();

    /**
     * 逻辑删除采购退货单
     * @param proId
     * @return
     */
    int deletePROByProId(@Param("proId") int proId);

    /**
     * 获取导出的采购退换货单列表
     * @return
     */
    List<PurchaseReturnOrderDto> selectExportPurchaseReturnOrderList();

    /**
     * 更新采购退货单的出库状态为已出库
     * @param purchaseReturnOrderId
     * @return
     */
    int updatePurchaseReturnOrderStorageState(@Param("purchaseReturnOrderId") int purchaseReturnOrderId);

    /**
     * 货物采购退换货单列表(收款使用)
     * @return
     */
    List<PurchaseReturnOrderDto> selectPurchaseReturnOrderListForReceipt();

    /**
     * 根据采购退货单Id修改内容
     * @param purchaseReturnOrder
     */
    void updateReceiptInfoById(@Param("purchaseReturnOrder") PurchaseReturnOrder purchaseReturnOrder);
}