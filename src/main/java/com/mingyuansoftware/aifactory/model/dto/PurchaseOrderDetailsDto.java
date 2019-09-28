package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 张婷
 * @date 2019/7/13 18:22
 */

//采购订单详情列表显示

public class PurchaseOrderDetailsDto {

    @ApiModelProperty(value = "采购订单id",example = "1")
    private Integer purchaseOrderId;

    @ApiModelProperty(value = "采购订单编号",example = "purchaseOrderNumber")
    private String purchaseOrderNumber;

    @ApiModelProperty(value = "自定义日期",example = "defineDate")
    private String defineDate;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "供应商id", example = "1")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商名称", example = "supplierName")
    private String supplierName;

    @ApiModelProperty(value = "订单状态 1.未确认 2.已确认",example = "1")
    private Byte orderStatus;

    @ApiModelProperty(value = "交货日期",example = "deliveryDate")
    private String deliveryDate;

    @ApiModelProperty(value = "入库时间",example = "1")
    private Date storageTime;

    @ApiModelProperty(value = "入库状态",example = "1")
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
    private Date paymentDate;

    @ApiModelProperty(value = "付款状态 1.未付款 2.部分付款 3.已付款 ",example = "1")
    private Byte paymentStatus;

    @ApiModelProperty(value = "采购类型",example = "purchaseType")
    private String purchaseType;

    @ApiModelProperty(value = "备注",example = "comment")
    private String comment;

    @ApiModelProperty(value = "附件",example = "fileAttachment")
    private String fileAttachment;

    @ApiModelProperty(value = "待核销金额",example = "1.1")
    private BigDecimal pendAmount;

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
        this.purchaseOrderNumber = purchaseOrderNumber;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Date storageTime) {
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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
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
        this.purchaseType = purchaseType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(String fileAttachment) {
        this.fileAttachment = fileAttachment;
    }

    public BigDecimal getPendAmount() {
        return pendAmount;
    }

    public void setPendAmount(BigDecimal pendAmount) {
        this.pendAmount = pendAmount;
    }

    @Override
    public String toString() {
        return "PurchaseOrderDetailsDto{" +
                "purchaseOrderId=" + purchaseOrderId +
                ", purchaseOrderNumber='" + purchaseOrderNumber + '\'' +
                ", defineDate='" + defineDate + '\'' +
                ", staffId=" + staffId +
                ", name='" + name + '\'' +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", orderStatus=" + orderStatus +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", storageTime=" + storageTime +
                ", storageState=" + storageState +
                ", purchaseAmount=" + purchaseAmount +
                ", discountAmount=" + discountAmount +
                ", actuallyPaidAmount=" + actuallyPaidAmount +
                ", pendingAmount=" + pendingAmount +
                ", paymentDate=" + paymentDate +
                ", paymentStatus=" + paymentStatus +
                ", purchaseType='" + purchaseType + '\'' +
                ", comment='" + comment + '\'' +
                ", fileAttachment='" + fileAttachment + '\'' +
                '}';
    }
}
