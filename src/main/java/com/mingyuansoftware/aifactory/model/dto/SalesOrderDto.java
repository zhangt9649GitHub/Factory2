package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "郝腾")
public class SalesOrderDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "销售订单编号", example = "salesOrderNumber")
    private String salesOrderNumber;

    @ApiModelProperty(value = "创建时间", example = "addtime")
    private String addtime;

    @ApiModelProperty(value = "客户名称", example = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "当前状态", example = "1")
    private Byte state;

    @ApiModelProperty(value = "回款状态", example = "1")
    private Byte paymentStatus;

    @ApiModelProperty(value = "金额", example = "1")
    private BigDecimal amount;

    @ApiModelProperty(value = "已收金额", example = "1")
    private BigDecimal amountReceived;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
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
        return "SalesOrderDto{" +
                "salesOrderNumber='" + salesOrderNumber + '\'' +
                ", addtime='" + addtime + '\'' +
                ", customerName='" + customerName + '\'' +
                ", state=" + state +
                ", paymentStatus=" + paymentStatus +
                ", amount=" + amount +
                ", amountReceived=" + amountReceived +
                ", comment='" + comment + '\'' +
                '}';
    }
}
