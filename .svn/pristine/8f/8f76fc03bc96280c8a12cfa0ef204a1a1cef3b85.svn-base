package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "郝腾")
public class ProductionOrderInfo    implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "排产单id", example = "1")
    private Integer productionOrderId;

    @ApiModelProperty(value = "排产单编号", example = "productionOrderNumber")
    private String productionOrderNumber;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "生产指示书编号", example = "serialNumber")
    private String serialNumber;

    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "状态  1.已创建  2.部分完成 3.已完成", example = "1")
    private Byte state;

    public Integer getProductionOrderId() {
        return productionOrderId;
    }

    public void setProductionOrderId(Integer productionOrderId) {
        this.productionOrderId = productionOrderId;
    }

    public String getProductionOrderNumber() {
        return productionOrderNumber;
    }

    public void setProductionOrderNumber(String productionOrderNumber) {
        this.productionOrderNumber = productionOrderNumber;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ProductionOrderInfo{" +
                "productionOrderId=" + productionOrderId +
                ", productionOrderNumber='" + productionOrderNumber + '\'' +
                ", addTime='" + addTime + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
