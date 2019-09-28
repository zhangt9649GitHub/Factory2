package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(description = "郝腾")
public class Shipment implements Serializable {

    @ApiModelProperty(value = "出货单id", example = "1")
    private Integer shipmentId;

    @ApiModelProperty(value = "出货单编号", example = "1")
    private String shipmentNumber;

    @ApiModelProperty(value = "当前状态 1.已创建 2.已配货 3.已出库", example = "1")
    private Byte state;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

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

    @ApiModelProperty(value = "金额", example = "1")
    private BigDecimal amount;

    @ApiModelProperty(value = "销售订单id", example = "1")
    private Integer salesOrderId;

    @ApiModelProperty(value = "备注", example = "1")
    private String comment;

    @ApiModelProperty(value = "表单时间", example = "1")
    private String addTime;

    @ApiModelProperty(value = "销售订单编号", example = "salesOrderNumber")
    private String salesOrderNumber;

    @ApiModelProperty(value = "出货单详情列表", example = "shipmentDetailsList")
    private List<ShipmentDetails> shipmentDetailsList;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "员工", example = "staff")
    private Staff staff;

    private static final long serialVersionUID = 1L;

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber == null ? null : shipmentNumber.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public List<ShipmentDetails> getShipmentDetailsList() {
        return shipmentDetailsList;
    }

    public void setShipmentDetailsList(List<ShipmentDetails> shipmentDetailsList) {
        this.shipmentDetailsList = shipmentDetailsList;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId=" + shipmentId +
                ", shipmentNumber='" + shipmentNumber + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", totalBoxesNumber=" + totalBoxesNumber +
                ", totalAmount=" + totalAmount +
                ", totalNetWeight=" + totalNetWeight +
                ", totalGrossWeight=" + totalGrossWeight +
                ", totalVolume=" + totalVolume +
                ", amount=" + amount +
                ", salesOrderId=" + salesOrderId +
                ", comment='" + comment + '\'' +
                ", addTime='" + addTime + '\'' +
                ", salesOrderNumber='" + salesOrderNumber + '\'' +
                ", shipmentDetailsList=" + shipmentDetailsList +
                ", staffId=" + staffId +
                '}';
    }
}