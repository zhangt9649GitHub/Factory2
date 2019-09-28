package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "郝腾")
public class SalesReturnDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "销售退货单编号", example = "salesReturnNumber")
    private String salesReturnNumber;

    @ApiModelProperty(value = "表单日期", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "客户名称", example = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "当前状态 1.已创建 2.已配货 3.已出库", example = "1")
    private Byte state;

    @ApiModelProperty(value = "回款状态 1.未回款 2.部分回款 3.已回款", example = "1")
    private Byte paymentStatus;

    @ApiModelProperty(value = "金额", example = "1")
    private BigDecimal amount;

    @ApiModelProperty(value = "已收金额", example = "1")
    private BigDecimal amountReceived;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    public String getSalesReturnNumber() {
        return salesReturnNumber;
    }

    public void setSalesReturnNumber(String salesReturnNumber) {
        this.salesReturnNumber = salesReturnNumber;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(BigDecimal amountReceived) {
        this.amountReceived = amountReceived;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "SalesReturnDto{" +
                "salesReturnNumber='" + salesReturnNumber + '\'' +
                ", addTime='" + addTime + '\'' +
                ", customerName='" + customerName + '\'' +
                ", state=" + state +
                ", paymentStatus=" + paymentStatus +
                ", amount=" + amount +
                ", amountReceived=" + amountReceived +
                ", comment='" + comment + '\'' +
                '}';
    }
}
