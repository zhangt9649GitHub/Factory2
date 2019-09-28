package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "张婷")
public class PaymentOrder implements Serializable {

    @ApiModelProperty(value = "付款单id", example = "1")
    private Integer paymentOrderId;

    @ApiModelProperty(value = "付款单编号", example = "paymentOrderNumber")
    private String paymentOrderNumber;

    @ApiModelProperty(value = "付款类别", example = "category")
    private String category;

    @ApiModelProperty(value = "用户日期", example = "defineDate")
    private String defineDate;

    @ApiModelProperty(value = "收款方id", example = "1")
    private Integer beneficiaryId;

    @ApiModelProperty(value = "收款方", example = "beneficiary")
    private String beneficiary;

    @ApiModelProperty(value = "关联单据id", example = "associatedDocumentId")
    private Integer associatedDocumentId;

    @ApiModelProperty(value = "关联单据", example = "associatedDocument")
    private String associatedDocument;

    @ApiModelProperty(value = "单据金额", example = "1.1")
    private BigDecimal amount;

    @ApiModelProperty(value = "待付款金额(计算)", example = "1.1")
    private BigDecimal pendingPaymentAmount;

    @ApiModelProperty(value = "待付款金额(查看,忽略)", example = "1.1")
    private BigDecimal pendingPaymentAmountView;

    @ApiModelProperty(value = "待核销金额", example = "1.1")
    private BigDecimal pendingWriteOffAmount;

    @ApiModelProperty(value = "付款金额", example = "1.1")
    private BigDecimal paymentAmount;

    @ApiModelProperty(value = "核销金额", example = "1.1")
    private BigDecimal writeOffAmount;

    @ApiModelProperty(value = "支付方式", example = "paymentMethod")
    private String paymentMethod;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "创建人id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "姓名", example = "小王")
    private String name;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除 0否 1是 ", example = "0")
    private Byte isDelete;

    @ApiModelProperty(value = "折扣金额", example = "1.1")
    private BigDecimal discountAmount;

    private static final long serialVersionUID = 1L;

    public Integer getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(Integer paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public String getPaymentOrderNumber() {
        return paymentOrderNumber;
    }

    public void setPaymentOrderNumber(String paymentOrderNumber) {
        this.paymentOrderNumber = paymentOrderNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDefineDate() {
        return defineDate;
    }

    public void setDefineDate(String defineDate) {
        this.defineDate = defineDate;
    }

    public Integer getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Integer beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Integer getAssociatedDocumentId() {
        return associatedDocumentId;
    }

    public void setAssociatedDocumentId(Integer associatedDocumentId) {
        this.associatedDocumentId = associatedDocumentId;
    }

    public String getAssociatedDocument() {
        return associatedDocument;
    }

    public void setAssociatedDocument(String associatedDocument) {
        this.associatedDocument = associatedDocument;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPendingPaymentAmount() {
        return pendingPaymentAmount;
    }

    public void setPendingPaymentAmount(BigDecimal pendingPaymentAmount) {
        this.pendingPaymentAmount = pendingPaymentAmount;
    }

    public BigDecimal getPendingPaymentAmountView() {
        return pendingPaymentAmountView;
    }

    public void setPendingPaymentAmountView(BigDecimal pendingPaymentAmountView) {
        this.pendingPaymentAmountView = pendingPaymentAmountView;
    }

    public BigDecimal getPendingWriteOffAmount() {
        return pendingWriteOffAmount;
    }

    public void setPendingWriteOffAmount(BigDecimal pendingWriteOffAmount) {
        this.pendingWriteOffAmount = pendingWriteOffAmount;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getWriteOffAmount() {
        return writeOffAmount;
    }

    public void setWriteOffAmount(BigDecimal writeOffAmount) {
        this.writeOffAmount = writeOffAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "PaymentOrder{" +
                "paymentOrderId=" + paymentOrderId +
                ", paymentOrderNumber='" + paymentOrderNumber + '\'' +
                ", category='" + category + '\'' +
                ", defineDate='" + defineDate + '\'' +
                ", beneficiaryId=" + beneficiaryId +
                ", beneficiary='" + beneficiary + '\'' +
                ", associatedDocumentId='" + associatedDocumentId + '\'' +
                ", associatedDocument='" + associatedDocument + '\'' +
                ", amount=" + amount +
                ", pendingPaymentAmount=" + pendingPaymentAmount +
                ", pendingPaymentAmountView=" + pendingPaymentAmountView +
                ", pendingWriteOffAmount=" + pendingWriteOffAmount +
                ", paymentAmount=" + paymentAmount +
                ", writeOffAmount=" + writeOffAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", comment='" + comment + '\'' +
                ", staffId=" + staffId +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", discountAmount=" + discountAmount +
                '}';
    }
}