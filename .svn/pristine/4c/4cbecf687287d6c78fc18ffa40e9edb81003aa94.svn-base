package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "张婷")
public class PurchaseReturnOrder implements Serializable {

    @ApiModelProperty(value = "采购退货单id",example = "1")
    private Integer proId;

    @ApiModelProperty(value = "编号",example = "purchaseReturnOrderNumber")
    private String purchaseReturnOrderNumber;

    @ApiModelProperty(value = "原采购订单Id",example = "1")
    private Integer purchaseOrderId;

    @ApiModelProperty(value = "采购订单编号",example = "purchaseOrderNumber")
    private String purchaseOrderNumber;

    @ApiModelProperty(value = "供应商Id",example = "1")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商名称", example = "供应1")
    private String supplierName;

    @ApiModelProperty(value = "创建日期",example = "defineDate")
    private String defineDate;

    @ApiModelProperty(value = "创建人id",example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "出库时间",example = "storageTime")
    private Date storageTime;

    @ApiModelProperty(value = "出库状态  1.未出库 2.已出库",example = "1")
    private Byte storageState;

    @ApiModelProperty(value = "采购退货金额",example = "1")
    private BigDecimal purchaseReturnAmount;

    @ApiModelProperty(value = "未收款金额",example = "1")
    private BigDecimal noneReceiveAmount;

    @ApiModelProperty(value = "收款金额",example = "1")
    private BigDecimal receivingAmount;

    @ApiModelProperty(value = "收款日期",example = "paymentDate")
    private Date paymentDate;

    @ApiModelProperty(value = "收款状态 1.未结算 2.已结算",example = "1")
    private Byte paymentStatus;

    @ApiModelProperty(value = "备注",example = "comment")
    private String comment;

    @ApiModelProperty(value = "创建时间",example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间",example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除 1是 0否",example = "0")
    private Byte isDelete;

    @ApiModelProperty(value = "采购退货单详情集合",example = "purchaseReturnOrderDetailsList")
    private List<PurchaseReturnOrderDetails> purchaseReturnOrderDetailsList = new ArrayList<>();

    private static final long serialVersionUID = 1L;

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
        this.purchaseReturnOrderNumber = purchaseReturnOrderNumber == null ? null : purchaseReturnOrderNumber.trim();
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

    public List<PurchaseReturnOrderDetails> getPurchaseReturnOrderDetailsList() {
        return purchaseReturnOrderDetailsList;
    }

    public void setPurchaseReturnOrderDetailsList(List<PurchaseReturnOrderDetails> purchaseReturnOrderDetailsList) {
        this.purchaseReturnOrderDetailsList = purchaseReturnOrderDetailsList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", proId=").append(proId);
        sb.append(", purchaseReturnOrderNumber=").append(purchaseReturnOrderNumber);
        sb.append(", purchaseOrderId=").append(purchaseOrderId);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", defineDate=").append(defineDate);
        sb.append(", staffId=").append(staffId);
        sb.append(", storageTime=").append(storageTime);
        sb.append(", storageState=").append(storageState);
        sb.append(", purchaseReturnAmount=").append(purchaseReturnAmount);
        sb.append(", actuallyReceiveAmount=").append(noneReceiveAmount);
        sb.append(", receivingAmount=").append(receivingAmount);
        sb.append(", paymentDate=").append(paymentDate);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", comment=").append(comment);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}