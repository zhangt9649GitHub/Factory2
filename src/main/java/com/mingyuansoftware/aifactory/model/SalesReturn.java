package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(description = "郝腾")
public class SalesReturn implements Serializable {

    @ApiModelProperty(value = "销售退货单id", example = "1")
    private Integer salesReturnId;

    @ApiModelProperty(value = "销售退货单编号", example = "salesReturnNumber")
    private String salesReturnNumber;

    @ApiModelProperty(value = "表单时间", example = "addtime")
    private String addTime;

    @ApiModelProperty(value = "客户id", example = "1")
    private Integer customerId;

    @ApiModelProperty(value = "销售订单id", example = "1")
    private Integer salesOrderId;

    @ApiModelProperty(value = "销售订单", example = "salesOrder")
    private SalesOrder salesOrder;


    @ApiModelProperty(value = "当前状态 1.已创建 2.已入库 3.已完成", example = "1")
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

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除 1是 0否", example = "0")
    private Byte isDelete;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "总箱数", example = "1")
    private Integer totalBoxesNumber;

    @ApiModelProperty(value = "总数量", example = "1")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "总净重", example = "1")
    private BigDecimal totalNetWeight;

    @ApiModelProperty(value = "总毛重", example = "1")
    private BigDecimal totalGrossWeight;

    @ApiModelProperty(value = "总体积", example = "1")
    private BigDecimal totalVolume;

    @ApiModelProperty(value = "客户名称", example = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "销售退货单详情集合", example = "salesReturnDetailsList")
    private List<SalesReturnDetails> salesReturnDetailsList;

    @ApiModelProperty(value = "员工", example = "staff")
    private Staff staff;

    @ApiModelProperty(value = "客户", example = "customer")
    private Customer customer;

    private static final long serialVersionUID = 1L;


    public Integer getSalesReturnId() {
        return salesReturnId;
    }


    public void setSalesReturnId(Integer salesReturnId) {
        this.salesReturnId = salesReturnId;
    }


    public String getSalesReturnNumber() {
        return salesReturnNumber;
    }


    public void setSalesReturnNumber(String salesReturnNumber) {
        this.salesReturnNumber = salesReturnNumber == null ? null : salesReturnNumber.trim();
    }


    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }


    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    public Integer getSalesOrderId() {
        return salesOrderId;
    }


    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
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


    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }


    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
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


    public Integer getStaffId() {
        return staffId;
    }


    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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

    public List<SalesReturnDetails> getSalesReturnDetailsList() {
        return salesReturnDetailsList;
    }

    public void setSalesReturnDetailsList(List<SalesReturnDetails> salesReturnDetailsList) {
        this.salesReturnDetailsList = salesReturnDetailsList;
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

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", salesReturnId=").append(salesReturnId);
        sb.append(", salesReturnNumber=").append(salesReturnNumber);
        sb.append(", addTime=").append(addTime);
        sb.append(", customerId=").append(customerId);
        sb.append(", salesOrderId=").append(salesOrderId);
        sb.append(", state=").append(state);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", amount=").append(amount);
        sb.append(", amountReceived=").append(amountReceived);
        sb.append(", outstandingAmount=").append(outstandingAmount);
        sb.append(", comment=").append(comment);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", staffId=").append(staffId);
        sb.append(", totalBoxesNumber=").append(totalBoxesNumber);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", totalNetWeight=").append(totalNetWeight);
        sb.append(", totalGrossWeight=").append(totalGrossWeight);
        sb.append(", totalVolume=").append(totalVolume);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}