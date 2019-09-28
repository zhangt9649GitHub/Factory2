package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "郝腾")
public class ShipmentListDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出货单编号", example = "1")
    private String shipmentNumber;

    @ApiModelProperty(value = "出货单集合", example = "1")
    private List<SalesOrderDetailsListDto> salesOrderDetailsListDtos;

    public String getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public List<SalesOrderDetailsListDto> getSalesOrderDetailsListDtos() {
        return salesOrderDetailsListDtos;
    }

    public void setSalesOrderDetailsListDtos(List<SalesOrderDetailsListDto> salesOrderDetailsListDtos) {
        this.salesOrderDetailsListDtos = salesOrderDetailsListDtos;
    }

    @Override
    public String toString() {
        return "ShipmentListDto{" +
                "shipmentNumber='" + shipmentNumber + '\'' +
                ", salesOrderDetailsListDtos=" + salesOrderDetailsListDtos +
                '}';
    }
}
