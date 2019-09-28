package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "郝腾")
public class ShipmentPrintDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出货单id", example = "1")
    private Integer shipmentId;

    @ApiModelProperty(value = "是否打印", example = "1")
    private Integer isPrint;

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Integer getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(Integer isPrint) {
        this.isPrint = isPrint;
    }

    @Override
    public String toString() {
        return "ShipmentPrintDto{" +
                "shipmentId=" + shipmentId +
                ", isPrint=" + isPrint +
                '}';
    }
}
