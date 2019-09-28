package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.PurchaseDeliveryDateDto;
import com.mingyuansoftware.aifactory.model.dto.PurchaseOrderDetailsDto;
import com.mingyuansoftware.aifactory.model.dto.PurchaseOrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PurchaseOrderMapper {
    int deleteByPrimaryKey(Integer purchaseOrderId);

    int insert(PurchaseOrder record);

    PurchaseOrder selectByPrimaryKey(Integer purchaseOrderId);

    List<PurchaseOrder> selectAll();

    int updateByPrimaryKey(PurchaseOrder record);

    /**
     * 获取采购订单列表
     * @param purchaseOrderDto
     * @return
     */
    List<PurchaseOrderDetailsDto> selectPurchaseOrderList(@Param("purchaseOrderDto") PurchaseOrderDto purchaseOrderDto);

    /**
     * 获取采购订单列表条数
     * @param purchaseOrderDto
     * @return
     */
    int selectCount(@Param("purchaseOrderDto") PurchaseOrderDto purchaseOrderDto);

    /**
     * 获取刚刚插入的记录id
     * @return
     */
    int selectLastId();

    /**
     * 根据采购订单id逻辑删除采购订单
     * @param purchaseOrderId
     * @return
     */
    int deletePurchaseOrder(@Param("purchaseOrderId") int purchaseOrderId);

    /**
     * 根据采购订单id查询采购订单
     * @param purchaseOrderId
     * @return
     */
    PurchaseOrder selectPurchaseOrderById(@Param("purchaseOrderId") int purchaseOrderId);

    /**
     * 根据供应商id,采购订单详情id查询货物列表
     * @param supplierId,purchaseOrderDetailsId
     * @return
     */
    List<PurchaseOrderDetails> selectPurchaseOrderGoodsUpdate(@Param("supplierId") Integer supplierId,@Param("purchaseOrderDetailsId") Integer purchaseOrderDetailsId);

    /**
     * 根据供应商id,采购订单详情id查询货物列表条数
     * @param supplierId,purchaseOrderDetailsId
     * @return
     */
    int selectGoodsUpdateCount(@Param("supplierId") Integer supplierId,@Param("purchaseOrderDetailsId") Integer purchaseOrderDetailsId);

    /**
     * 根据供应商id查询货物列表
     * @param supplierId
     * @return
     */
    List<PurchaseOrderDetails> selectPurchaseOrderGoodsInsert(@Param("supplierId") Integer supplierId,@Param("partsCd") String partsCd,@Param("goodsName") String goodsName);

    /**
     * 根据供应商id查询货物列表条数
     * @param supplierId
     * @return
     */
    int selectGoodsInsertCount(@Param("supplierId") Integer supplierId,@Param("partsCd") String partsCd,@Param("goodsName") String goodsName);

    /**
     * 获取导出的采购订单列表
     * @return
     */
    List<PurchaseOrderDto> selectExportPurchaseOrderList();

    /**
     * 根据采购订单id编辑采购订单附件字段
     * @param uploadFileAttachment
     * @return
     */
    int updatePurchaseOrderById(@Param("uploadFileAttachment") UploadFileAttachment uploadFileAttachment);

    /**
     * 获取采购订单中的供应商列表
     * @return
     */
    List<PaymentOrder> selectPaymentOrderSupplierList();

    /**
     * 获取采购订单中的供应商列表总条数
     * @return
     */
    int selectSuplierCount();

    /**
     * 根据采购订单编号修改内容
     * @param purchaseOrderDetailsDto
     */
    void updateByPurchaseOrderNumber(@Param("purchaseOrderDetailsDto") PurchaseOrderDetailsDto purchaseOrderDetailsDto);

    /**
     * 根据供应商id查询采购订单编号列表
     * @param supplierId
     * @return
     */
    List<PurchaseOrder> selectPurchaseOrderBySupplierId(@Param("supplierId") Integer supplierId);

    /**
     * 根据供应商id查询采购订单编号列表总条数
     * @param supplierId
     * @return
     */
    int selectPurchaseOrderCount(@Param("supplierId") Integer supplierId);

    /**
     * 根据采购订单id修改订单状态:2.已确认
     * @param purchaseOrderId
     * @return
     */
    int affirmationContract(@Param("purchaseOrderId") int purchaseOrderId);

    /**
     * 获取采购入库采购订单列表(入库状态不是3.已入库)
     * @return
     */
    List<PurchaseOrder> selectPDaPurchaseOrderList();

    /**
     * 获取采购入库任务列表(待处理)总条数(入库状态不是3.已入库)
     * @return
     */
    int selectPDaPurchaseOrderListCount();

    /**
     * 编辑采购订单附件字段为null
     * @param purchaseOrderId
     * @return
     */
    int editFileAttachmentById(@Param("purchaseOrderId") int purchaseOrderId);

    /**
     * 修改采购订单入库状态
     * @param purchaseOrderId
     * @param state
     * @param staffId
     */
    void updatePurchaseOrderStorageState(@Param("purchaseOrderId") Integer purchaseOrderId,@Param("state") int state,@Param("staffId") int staffId);

    /**
     * 获取采购入库任务列表
     * @return
     */
    List<PDAPurchaseStorageTask> selectPDaPurchaseOrderTaskList();

    /**
     * 根据采购订单id修改采购退货情况字段为 2.已退货
     * @param purchaseOrderId
     */
    void updatePurchaseReturnSituationById(@Param("purchaseOrderId") Integer purchaseOrderId,@Param("state") int state);

    /**
     * 根据采购订单Id修改财务金额总和
     * @param purchaseOrder
     */
    void updateFinanceSum(@Param("purchaseOrder") PurchaseOrder purchaseOrder);

    /**
     * 采购订单交货期预警货物列表
     * @param purchaseDeliveryDateDto
     * @return
     */
    List<PurchaseDeliveryDateDto> selectPurchaseDeliveryDateList(@Param("purchaseDeliveryDateDto") PurchaseDeliveryDateDto purchaseDeliveryDateDto);

    /**
     * 采购订单交货期预警货物列表总条数
     * @param purchaseDeliveryDateDto
     * @return
     */
    int selectPurchaseDeliveryDateCount(@Param("purchaseDeliveryDateDto") PurchaseDeliveryDateDto purchaseDeliveryDateDto);
}