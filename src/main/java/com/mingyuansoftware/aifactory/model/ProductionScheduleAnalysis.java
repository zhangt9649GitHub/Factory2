package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生产进度分析
 */
@ApiModel(description = "郝腾")
public class ProductionScheduleAnalysis implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "货物类别", example = "1")
    private Byte category;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "平均月贩", example = "1")
    private BigDecimal averageMonthlyVendor;

    @ApiModelProperty(value = "在库月数(日本)", example = "monthsInStock")
    private String monthsInStock;

    @ApiModelProperty(value = "库存", example = "1")
    private BigDecimal inventory;

    @ApiModelProperty(value = "最低库存", example = "1")
    private BigDecimal minimumStock;

    @ApiModelProperty(value = "压缩的准备(可以生产)", example = "1")
    private BigDecimal PrepareProduction;

    @ApiModelProperty(value = "压缩的准备(可以生产)的占比", example = "1")
    private BigDecimal PrepareProductionRate;

    @ApiModelProperty(value = "压缩的生产完成", example = "1")
    private BigDecimal ProductionComplete;

    @ApiModelProperty(value = "压缩的生产完成的占比", example = "1")
    private BigDecimal ProductionCompleteRate;

    @ApiModelProperty(value = "压缩的销售出货", example = "1")
    private BigDecimal SalesShipment;

    @ApiModelProperty(value = "压缩的销售出货的占比", example = "1")
    private BigDecimal SalesShipmentRate;

    @ApiModelProperty(value = "压缩的需要继续加工生产", example = "1")
    private BigDecimal ProcessingProduction;

    @ApiModelProperty(value = "压缩的需要继续加工生产的占比", example = "1")
    private BigDecimal ProcessingProductionRate;

    @ApiModelProperty(value = "压缩的返品数量", example = "1")
    private BigDecimal returnQuantity;

    @ApiModelProperty(value = "压缩的返品数量的占比", example = "1")
    private BigDecimal returnQuantityRate;

    @ApiModelProperty(value = "总数量", example = "1")
    private BigDecimal totalQuantity;

    @ApiModelProperty(value = "生产回数的集合", example = "productionProcessList")
    private List<ProductionProcess> productionProcessList =new ArrayList<>();

    @ApiModelProperty(value = "生产进程比率集合", example = "productionProcessRateList")
    private List<ProductionProcessRate> productionProcessRateList;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getAverageMonthlyVendor() {
        return averageMonthlyVendor;
    }

    public void setAverageMonthlyVendor(BigDecimal averageMonthlyVendor) {
        this.averageMonthlyVendor = averageMonthlyVendor;
    }

    public String getMonthsInStock() {
        return monthsInStock;
    }

    public void setMonthsInStock(String monthsInStock) {
        this.monthsInStock = monthsInStock;
    }

    public BigDecimal getInventory() {
        return inventory;
    }

    public void setInventory(BigDecimal inventory) {
        this.inventory = inventory;
    }

    public BigDecimal getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(BigDecimal minimumStock) {
        this.minimumStock = minimumStock;
    }

    public BigDecimal getPrepareProduction() {
        return PrepareProduction;
    }

    public void setPrepareProduction(BigDecimal prepareProduction) {
        PrepareProduction = prepareProduction;
    }

    public BigDecimal getPrepareProductionRate() {
        return PrepareProductionRate;
    }

    public void setPrepareProductionRate(BigDecimal prepareProductionRate) {
        PrepareProductionRate = prepareProductionRate;
    }

    public BigDecimal getProductionComplete() {
        return ProductionComplete;
    }

    public void setProductionComplete(BigDecimal productionComplete) {
        ProductionComplete = productionComplete;
    }

    public BigDecimal getProductionCompleteRate() {
        return ProductionCompleteRate;
    }

    public void setProductionCompleteRate(BigDecimal productionCompleteRate) {
        ProductionCompleteRate = productionCompleteRate;
    }

    public BigDecimal getSalesShipment() {
        return SalesShipment;
    }

    public void setSalesShipment(BigDecimal salesShipment) {
        SalesShipment = salesShipment;
    }

    public BigDecimal getSalesShipmentRate() {
        return SalesShipmentRate;
    }

    public void setSalesShipmentRate(BigDecimal salesShipmentRate) {
        SalesShipmentRate = salesShipmentRate;
    }

    public BigDecimal getProcessingProduction() {
        return ProcessingProduction;
    }

    public void setProcessingProduction(BigDecimal processingProduction) {
        ProcessingProduction = processingProduction;
    }

    public BigDecimal getProcessingProductionRate() {
        return ProcessingProductionRate;
    }

    public void setProcessingProductionRate(BigDecimal processingProductionRate) {
        ProcessingProductionRate = processingProductionRate;
    }

    public BigDecimal getReturnQuantity() {
        return returnQuantity;
    }

    public void setReturnQuantity(BigDecimal returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    public BigDecimal getReturnQuantityRate() {
        return returnQuantityRate;
    }

    public void setReturnQuantityRate(BigDecimal returnQuantityRate) {
        this.returnQuantityRate = returnQuantityRate;
    }

    public List<ProductionProcess> getProductionProcessList() {
        return productionProcessList;
    }

    public void setProductionProcessList(List<ProductionProcess> productionProcessList) {
        this.productionProcessList = productionProcessList;
    }

    public BigDecimal getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(BigDecimal totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    public List<ProductionProcessRate> getProductionProcessRateList() {
        return productionProcessRateList;
    }

    public void setProductionProcessRateList(List<ProductionProcessRate> productionProcessRateList) {
        this.productionProcessRateList = productionProcessRateList;
    }

    @Override
    public String toString() {
        return "ProductionScheduleAnalysis{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", averageMonthlyVendor=" + averageMonthlyVendor +
                ", monthsInStock='" + monthsInStock + '\'' +
                ", inventory=" + inventory +
                ", minimumStock=" + minimumStock +
                ", PrepareProduction=" + PrepareProduction +
                ", PrepareProductionRate=" + PrepareProductionRate +
                ", ProductionComplete=" + ProductionComplete +
                ", ProductionCompleteRate=" + ProductionCompleteRate +
                ", SalesShipment=" + SalesShipment +
                ", SalesShipmentRate=" + SalesShipmentRate +
                ", ProcessingProduction=" + ProcessingProduction +
                ", ProcessingProductionRate=" + ProcessingProductionRate +
                ", returnQuantity=" + returnQuantity +
                ", returnQuantityRate=" + returnQuantityRate +
                ", totalQuantity=" + totalQuantity +
                ", productionProcessList=" + productionProcessList +
                '}';
    }
}
