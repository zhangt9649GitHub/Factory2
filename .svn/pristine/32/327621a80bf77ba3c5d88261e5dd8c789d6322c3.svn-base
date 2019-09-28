package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.PurchaseDeliveryDateDto;
import com.mingyuansoftware.aifactory.model.dto.PurchaseOrderDetailsDto;
import com.mingyuansoftware.aifactory.model.dto.PurchaseOrderDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface PurchaseOrderService {
    /**
     * 获取采购订单列表
     * @param purchaseOrderDto
     * @return
     */
    List<PurchaseOrderDetailsDto> selectPurchaseOrderList(PurchaseOrderDto purchaseOrderDto);
    /**
     * 获取采购订单列表条数
     * @param purchaseOrderDto
     * @return
     */
    int selectCount(PurchaseOrderDto purchaseOrderDto);

    /**
     * 新增采购订单
     * @param purchaseOrder
     * @return
     */
    int insertPurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * 逻辑删除采购订单
     * @param purchaseOrderId
     * @return
     */
    int deletePurchaseOrder(int purchaseOrderId);

    /**
     * 根据采购订单id获取采购订单信息
     * @param purchaseOrderId
     * @return
     */
    PurchaseOrder selectPurchaseOrderById(int purchaseOrderId);

    /**
     * 更新采购订单
     * @param purchaseOrder
     * @return
     */
    int updatePurchaseOrderInfo(PurchaseOrder purchaseOrder);

    /**
     * 根据供应商id,采购订单详情id查询货物列表
     * @param supplierId,purchaseOrderDetailsId
     * @return
     */

    List<PurchaseOrderDetails> selectPurchaseOrderGoodsUpdate(Integer supplierId, Integer purchaseOrderDetailsId);

    /**
     * 根据供应商id,采购订单详情id查询货物列表条数
     * @param supplierId,purchaseOrderDetailsId
     * @return
     */
    int selectGoodsUpdateCount(Integer supplierId, Integer purchaseOrderDetailsId);

    /**
     * 根据供应商id查询货物列表
     * @param supplierId
     * @return
     */
    List<PurchaseOrderDetails> selectPurchaseOrderGoodsInsert(Integer supplierId,String partsCd,String goodsName );

    /**
     * 根据供应商id查询货物列表条数
     * @param supplierId
     * @return
     */
    int selectGoodsInsertCount(Integer supplierId,String partsCd,String goodsName);

    /**
     * 获取导出的采购订单列表
     * @return
     */
    List<PurchaseOrderDto> selectExportPurchaseOrderList();

    /**
     * 根据采购订单id编辑采购订单附件字段
     * @param fileAttachment
     * @return
     */
    UploadFileAttachment updatePurchaseOrderById(MultipartFile fileAttachment,int purchaseOrderId);

    /**
     * 采购订单确认合同
     * @param purchaseOrderId
     * @return
     */
    int affirmationContract(int purchaseOrderId);

    /**
     * 获取采购入库采购订单列表
     * @return
     */
    List<PurchaseOrder> selectPDaPurchaseOrderList();

    /**
     * 获取采购入库待处理任务列表总条数
     * @return
     */
    int selectPDaPurchaseOrderListCount();

    /**
     * 获取销售订单
     * @return
     */
    List<SalesOrder> selectSalesOrder();

    /**
     * 判断能否确认合同(2.已确认)
     * @param purchaseOrderId
     * @return
     */
    int selectPurchaseOrderStatus(int purchaseOrderId);

    /**
     * 如果入库状态为已入库,或者付款状态为已付款,都不能编辑
     * @param purchaseOrder
     * @return
     */
    int selectLimit(PurchaseOrder purchaseOrder);

    /**
     * 查看采购订单附件字段
     * @param purchaseOrderId
     * @return
     */
    PurchaseOrder selectFileAttachment(int purchaseOrderId);

    /**
     * 编辑采购订单附件字段为null
     * @param purchaseOrderId
     * @return
     */
    int editFileAttachment(int purchaseOrderId);

    /**
     * 获取采购入库任务列表
     * @return
     */
    List<PDAPurchaseStorageTask> selectPDaPurchaseOrderTaskList();

    /**
     * 查询采购订单入库状态
     * @param purchaseOrderId
     * @return
     */
    int selectStorage(Integer purchaseOrderId);

    /**
     * 查询采购单价
     * @param purchaseOrderDetailsId
     * @return
     */
    BigDecimal selectPrice(Integer purchaseOrderDetailsId);

    /**
     * 更新采购订单财务金额
     * @param purchaseOrder
     * @return
     */
    void updatePurchaseOrderFinance(PurchaseOrder purchaseOrder);

    /**
     * 采购交货期预警列表
     * @param purchaseDeliveryDateDto
     * @return
     */
    List<PurchaseDeliveryDateDto> selectPurchaseDeliveryDateList(PurchaseDeliveryDateDto purchaseDeliveryDateDto);

    /**
     * 采购交货期预警列表条数
     * @param purchaseDeliveryDateDto
     * @return
     */
    int selectPurchaseDeliveryDateCount(PurchaseDeliveryDateDto purchaseDeliveryDateDto);
}
