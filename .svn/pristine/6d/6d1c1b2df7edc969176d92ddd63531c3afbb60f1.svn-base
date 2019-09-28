package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(description = "郝腾")
public class PDAProductionEntryTask  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "排产单id", example = "1")
    private Integer productionOrderId;

    @ApiModelProperty(value = "排产单编号", example = "productionOrderNumber")
    private String productionOrderNumber;


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

    @Override
    public String toString() {
        return "PDAProductionEntryTask{" +
                "productionOrderId=" + productionOrderId +
                ", productionOrderNumber='" + productionOrderNumber + '\'' +
                '}';
    }
}
