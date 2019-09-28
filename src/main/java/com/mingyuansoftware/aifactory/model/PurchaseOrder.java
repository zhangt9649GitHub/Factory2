package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "张婷")
public class PurchaseOrder implements Serializable {

    @ApiModelProperty(value = "采购订单id",example = "1")
    private Integer purchaseOrderId;

    @ApiModelProperty(value = "采购订单编号",example = "purchaseOrderNumber")
    private String purchaseOrderNumber;

    @ApiModelProperty(value = "销售订单id",example = "1")
    private Integer salesOrderId;

    @ApiModelProperty(value = "销售订单编号", example = "salesOrderNumber")
    private String salesOrderNumber;

    @ApiModelProperty(value = "供应商id",example = "1")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商名称", example = "供应1")
    private String supplierName;

    @ApiModelProperty(value = "交货日期",example = "deliveryDate")
    private String deliveryDate;

    @ApiModelProperty(value = "自定义日期",example = "defineDate")
    private String defineDate;

    @ApiModelProperty(value = "员工id",example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "订单状态 1.未确认 2.已确认",example = "1")
    private Byte orderStatus;

    @ApiModelProperty(value = "入库时间",example = "storageTime")
    private String storageTime;

    @ApiModelProperty(value = "入库状态 1.未入库 2.部分入库 3.已入库",example = "1")
    private Byte storageState;

    @ApiModelProperty(value = "采购金额",example = "1.1")
    private BigDecimal purchaseAmount;

    @ApiModelProperty(value = "折扣金额",example = "1.1")
    private BigDecimal discountAmount;

    @ApiModelProperty(value = "实付金额",example = "1.1")
    private BigDecimal actuallyPaidAmount;

    @ApiModelProperty(value = "待付金额",example = "1.1")
    private BigDecimal pendingAmount;

    @ApiModelProperty(value = "付款时间",example = "paymentDate")
    private String paymentDate;

    @ApiModelProperty(value = "付款状态 1.未付款 2.部分付款 3.已付款 ",example = "1")
    private Byte paymentStatus;

    @ApiModelProperty(value = "采购类型",example = "purchaseType")
    private String purchaseType;

    @ApiModelProperty(value = "备注",example = "comment")
    private String comment;

    @ApiModelProperty(value = "创建时间",example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间",example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除  0否 1是",example = "0")
    private Byte isDelete;

    @ApiModelProperty(value = "大写",example = "capital")
    private String capital;

    @ApiModelProperty(value = "附件",example = "fileAttachment")
    private String fileAttachment;

    @ApiModelProperty(value = "退货情况 1.无退货 2.已退货",example = "1")
    private Byte purchaseReturnSituation;

    @ApiModelProperty(value = "财务金额总和",example = "1.1")
    private BigDecimal financeMoneySum;

    @ApiModelProperty(value = "采购订单详情集合",example = "purchaseOrderDetailsList")
    private List<PurchaseOrderDetails> purchaseOrderDetailsList = new ArrayList<>();

    @ApiModelProperty(value = "供应商实体类",example = "supplier")
    private Supplier supplier;

    private static final long serialVersionUID = 1L;

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber == null ? null : purchaseOrderNumber.trim();
    }

    public Integer getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDefineDate() {
        return defineDate;
    }

    public void setDefineDate(String defineDate) {
        this.defineDate = defineDate;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime;
    }

    public Byte getStorageState() {
        return storageState;
    }

    public void setStorageState(Byte storageState) {
        this.storageState = storageState;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getActuallyPaidAmount() {
        return actuallyPaidAmount;
    }

    public void setActuallyPaidAmount(BigDecimal actuallyPaidAmount) {
        this.actuallyPaidAmount = actuallyPaidAmount;
    }

    public BigDecimal getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(BigDecimal pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType == null ? null : purchaseType.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital == null ? null : capital.trim();
    }

    public String getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(String fileAttachment) {
        this.fileAttachment = fileAttachment == null ? null : fileAttachment.trim();
    }

    public Byte getPurchaseReturnSituation() {
        return purchaseReturnSituation;
    }

    public void setPurchaseReturnSituation(Byte purchaseReturnSituation) {
        this.purchaseReturnSituation = purchaseReturnSituation;
    }

    public BigDecimal getFinanceMoneySum() {
        return financeMoneySum;
    }

    public void setFinanceMoneySum(BigDecimal financeMoneySum) {
        this.financeMoneySum = financeMoneySum;
    }

    public List<PurchaseOrderDetails> getPurchaseOrderDetailsList() {
        return purchaseOrderDetailsList;
    }

    public void setPurchaseOrderDetailsList(List<PurchaseOrderDetails> purchaseOrderDetailsList) {
        this.purchaseOrderDetailsList = purchaseOrderDetailsList;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", purchaseOrderId=").append(purchaseOrderId);
        sb.append(", purchaseOrderNumber=").append(purchaseOrderNumber);
        sb.append(", sellOrderId=").append(salesOrderId);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", deliveryDate=").append(deliveryDate);
        sb.append(", defineDate=").append(defineDate);
        sb.append(", staffId=").append(staffId);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", storageTime=").append(storageTime);
        sb.append(", storageState=").append(storageState);
        sb.append(", purchaseAmount=").append(purchaseAmount);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", actuallyPaidAmount=").append(actuallyPaidAmount);
        sb.append(", pendingAmount=").append(pendingAmount);
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", purchaseType=").append(purchaseType);
        sb.append(", comment=").append(comment);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", capital=").append(capital);
        sb.append(", fileAttachment=").append(fileAttachment);
        sb.append(", purchaseReturnSituation=").append(purchaseReturnSituation);
        sb.append(", financeMoneySum=").append(financeMoneySum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}