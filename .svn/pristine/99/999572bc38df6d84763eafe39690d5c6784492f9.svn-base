package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "郝腾")
public class ProductionOrderDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "排产单编号", example = "productionOrderNumber")
    private String productionOrderNumber;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "状态", example = "1")
    private Byte state;

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
        return "ProductionOrderDto{" +
                "productionOrderNumber='" + productionOrderNumber + '\'' +
                ", addTime='" + addTime + '\'' +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
