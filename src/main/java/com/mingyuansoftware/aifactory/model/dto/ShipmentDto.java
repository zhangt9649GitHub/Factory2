package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "郝腾")
public class ShipmentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出货单编号", example = "1")
    private String shipmentNumber;

    @ApiModelProperty(value = "当前状态 1.已创建 2.已配货 3.已出库", example = "1")
    private Byte state;

    @ApiModelProperty(value = "表单时间", example = "1")
    private String addTime;

    @ApiModelProperty(value = "销售订单编号", example = "salesOrderNumber")
    private String salesOrderNumber;

    public String getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    @Override
    public String toString() {
        return "ShipmentDto{" +
                "shipmentNumber='" + shipmentNumber + '\'' +
                ", state=" + state +
                ", addTime='" + addTime + '\'' +
                ", salesOrderNumber='" + salesOrderNumber + '\'' +
                '}';
    }
}
