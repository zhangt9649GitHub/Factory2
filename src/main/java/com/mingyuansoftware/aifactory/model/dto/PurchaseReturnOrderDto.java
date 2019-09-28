package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author 张婷
 * @date 2019/7/26 15:36
 */

//采购退换货单模糊查询

@ApiModel(description = "张婷")
public class PurchaseReturnOrderDto {

    private Integer proId;

    @ApiModelProperty(value = "采购退货单编号", example = "purchaseReturnOrderNumber")
    private String purchaseReturnOrderNumber;

    @ApiModelProperty(value = "创建日期", example = "defineDate")
    private String defineDate;

    private Integer staffId;

    @ApiModelProperty(value = "创建人名称", example = "name")
    private String name;

    private Integer purchaseOrderId;

    @ApiModelProperty(value = "原采购订单编号", example = "purchaseOrderNumber")
    private String purchaseOrderNumber;

    private Integer supplierId;

    @ApiModelProperty(value = "供应商名称", example = "供应1")
    private String supplierName;

    @ApiModelProperty(value = "采购退货金额", example = "1")
    private BigDecimal purchaseReturnAmount;

    //未收款金额
    private BigDecimal noneReceiveAmount;

    //收款金额
    private BigDecimal receivingAmount;

    @ApiModelProperty(value = "收款状态 1.未结算 2.已结算", example = "1")
    private Byte paymentStatus;

    @ApiModelProperty(value = "出库状态  1.未出库 2.已出库", example = "1")
    private Byte storageState;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    private BigDecimal pendingAmount;//待核销金额

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getPurchaseReturnOrderNumber() {
        return purchaseReturnOrderNumber;
    }

    public void setPurchaseReturnOrderNumber(String purchaseReturnOrderNumber) {
        this.purchaseReturnOrderNumber = purchaseReturnOrderNumber;
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

    public BigDecimal getPurchaseReturnAmount() {
        return purchaseReturnAmount;
    }

    public void setPurchaseReturnAmount(BigDecimal purchaseReturnAmount) {
        this.purchaseReturnAmount = purchaseReturnAmount;
    }

    public BigDecimal getNoneReceiveAmount() {
        return noneReceiveAmount;
    }

    public void setNoneReceiveAmount(BigDecimal noneReceiveAmount) {
        this.noneReceiveAmount = noneReceiveAmount;
    }

    public BigDecimal getReceivingAmount() {
        return receivingAmount;
    }

    public void setReceivingAmount(BigDecimal receivingAmount) {
        this.receivingAmount = receivingAmount;
    }

    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Byte getStorageState() {
        return storageState;
    }

    public void setStorageState(Byte storageState) {
        this.storageState = storageState;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(BigDecimal pendingAmount) {
        this.pendingAmount = pendingAmount;
    }
}
