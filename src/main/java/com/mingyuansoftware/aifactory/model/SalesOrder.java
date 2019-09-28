package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "郝腾")
public class SalesOrder implements Serializable {

    @ApiModelProperty(value = "销售订单id", example = "1")
    private Integer salesOrderId;

    @ApiModelProperty(value = "客户id", example = "1")
    private Integer customerId;

    @ApiModelProperty(value = "销售订单编号", example = "salesOrderNumber")
    private String salesOrderNumber;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "当前状态", example = "1")
    private Byte state;

    @ApiModelProperty(value = "回款状态", example = "1")
    private Byte paymentStatus;

    @ApiModelProperty(value = "金额", example = "1")
    private BigDecimal amount;

    @ApiModelProperty(value = "已收金额", example = "1")
    private BigDecimal amountReceived;

    @ApiModelProperty(value = "未收金额", example = "1")
    private BigDecimal outstandingAmount;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除 1是 0否", example = "0")
    private Byte isDelete;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "订单类型  1.日本出口 2.天津贩卖", example = "1")
    private Byte orderType;

    @ApiModelProperty(value = "员工", example = "staff")
    private Staff staff;

    @ApiModelProperty(value = "客户", example = "customer")
    private Customer customer;

    @ApiModelProperty(value = "销售单详情表集合", example = "salesOrderDetailsList")
    private List<SalesOrderDetails> salesOrderDetailsList ;

    @ApiModelProperty(value = "创建时间", example = "addtime")
    private String addtime;

    @ApiModelProperty(value = "总箱数", example = "1")
    private Integer totalBoxesNumber;

    @ApiModelProperty(value = "总数量", example = "1")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "总价", example = "1")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "总净重", example = "1")
    private BigDecimal totalNetWeight;

    @ApiModelProperty(value = "总毛重", example = "1")
    private BigDecimal totalGrossWeight;

    @ApiModelProperty(value = "总体积", example = "1")
    private BigDecimal totalVolume;

    @ApiModelProperty(value = "客户名称", example = "客户名称")
    private String customerName;


    @ApiModelProperty(value = "待核销金额", example = "2.00")
    private BigDecimal writeOffAmount;

    public BigDecimal getWriteOffAmount() {
        return writeOffAmount;
    }

    public void setWriteOffAmount(BigDecimal writeOffAmount) {
        this.writeOffAmount = writeOffAmount;
    }

    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    private static final long serialVersionUID = 1L;


    public Integer getSalesOrderId() {
        return salesOrderId;
    }


    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }


    public Integer getCustomerId() {
        return customerId;
    }


    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }


    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber == null ? null : salesOrderNumber.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        this.comment = comment == null ? null : comment.trim();
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


    public Integer getStaffId() {
        return staffId;
    }


    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }


    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<SalesOrderDetails> getSalesOrderDetailsList() {
        return salesOrderDetailsList;
    }

    public void setSalesOrderDetailsList(List<SalesOrderDetails> salesOrderDetailsList) {
        this.salesOrderDetailsList = salesOrderDetailsList;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public Integer getTotalBoxesNumber() {
        return totalBoxesNumber;
    }

    public void setTotalBoxesNumber(Integer totalBoxesNumber) {
        this.totalBoxesNumber = totalBoxesNumber;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalNetWeight() {
        return totalNetWeight;
    }

    public void setTotalNetWeight(BigDecimal totalNetWeight) {
        this.totalNetWeight = totalNetWeight;
    }

    public BigDecimal getTotalGrossWeight() {
        return totalGrossWeight;
    }

    public void setTotalGrossWeight(BigDecimal totalGrossWeight) {
        this.totalGrossWeight = totalGrossWeight;
    }

    public BigDecimal getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(BigDecimal totalVolume) {
        this.totalVolume = totalVolume;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", salesOrderId=").append(salesOrderId);
        sb.append(", customerId=").append(customerId);
        sb.append(", salesOrderNumber=").append(salesOrderNumber);
        sb.append(", createTime=").append(createTime);
        sb.append(", state=").append(state);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", amount=").append(amount);
        sb.append(", amountReceived=").append(amountReceived);
        sb.append(", comment=").append(comment);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", staffId=").append(staffId);
        sb.append(", orderType=").append(orderType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}