package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(description = "郝腾")
public class ProductionEntryInfo   implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产入库单编号", example = "productionEntryNumber")
    private String productionEntryNumber;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "仓库", example = "warehouseName")
    private String warehouseName;

    @ApiModelProperty(value = "批号", example = "lotNumber")
    private String lotNumber;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "生产货物列表合计金额", example = "1")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "生产货物列表集合", example = "productionGoodsList")
    private List<ProductionGoods> productionGoodsList;

    @ApiModelProperty(value = "消耗货物列表集合", example = "consumptionGoodsList")
    private List<ConsumptionGoods> consumptionGoodsList;

    public String getProductionEntryNumber() {
        return productionEntryNumber;
    }

    public void setProductionEntryNumber(String productionEntryNumber) {
        this.productionEntryNumber = productionEntryNumber;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductionGoods> getProductionGoodsList() {
        return productionGoodsList;
    }

    public void setProductionGoodsList(List<ProductionGoods> productionGoodsList) {
        this.productionGoodsList = productionGoodsList;
    }

    public List<ConsumptionGoods> getConsumptionGoodsList() {
        return consumptionGoodsList;
    }

    public void setConsumptionGoodsList(List<ConsumptionGoods> consumptionGoodsList) {
        this.consumptionGoodsList = consumptionGoodsList;
    }

    @Override
    public String toString() {
        return "ProductionEntryInfo{" +
                "productionEntryNumber='" + productionEntryNumber + '\'' +
                ", addTime='" + addTime + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", lotNumber='" + lotNumber + '\'' +
                ", comment='" + comment + '\'' +
                ", name='" + name + '\'' +
                ", totalPrice=" + totalPrice +
                ", productionGoodsList=" + productionGoodsList +
                ", consumptionGoodsList=" + consumptionGoodsList +
                '}';
    }
}
