package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
@ApiModel(description = "郝腾")
public class ProductionOrderGoods   implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "单位", example = "单位")
    private String unit;

    @ApiModelProperty(value = "月贩卖量", example = "1")
    private BigDecimal monthlySalesVolume;

    @ApiModelProperty(value = "库存数", example = "1")
    private BigDecimal skgCount;

    @ApiModelProperty(value = "总任务量", example = "1")
    private BigDecimal totalTaskAmount;

    @ApiModelProperty(value = "销售预定数", example = "1")
    private BigDecimal salesBooking;

    @ApiModelProperty(value = "生产指示书id", example = "1")
    private Integer productionInstructionId;

    @ApiModelProperty(value = "生产指示书编号", example = "serialNumber")
    private String serialNumber;

    @ApiModelProperty(value = "成型周期", example = "1")
    private BigDecimal cycle;

    @ApiModelProperty(value = "在库月数", example = "monthsInStock")
    private String monthsInStock;


    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getPartsCd() {
        return partsCd;
    }

    public void setPartsCd(String partsCd) {
        this.partsCd = partsCd;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getMonthlySalesVolume() {
        return monthlySalesVolume;
    }

    public void setMonthlySalesVolume(BigDecimal monthlySalesVolume) {
        this.monthlySalesVolume = monthlySalesVolume;
    }

    public BigDecimal getSkgCount() {
        return skgCount;
    }

    public void setSkgCount(BigDecimal skgCount) {
        this.skgCount = skgCount;
    }

    public BigDecimal getTotalTaskAmount() {
        return totalTaskAmount;
    }

    public void setTotalTaskAmount(BigDecimal totalTaskAmount) {
        this.totalTaskAmount = totalTaskAmount;
    }

    public BigDecimal getSalesBooking() {
        return salesBooking;
    }

    public void setSalesBooking(BigDecimal salesBooking) {
        this.salesBooking = salesBooking;
    }

    public Integer getProductionInstructionId() {
        return productionInstructionId;
    }

    public void setProductionInstructionId(Integer productionInstructionId) {
        this.productionInstructionId = productionInstructionId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getCycle() {
        return cycle;
    }

    public void setCycle(BigDecimal cycle) {
        this.cycle = cycle;
    }

    public String getMonthsInStock() {
        return monthsInStock;
    }

    public void setMonthsInStock(String monthsInStock) {
        this.monthsInStock = monthsInStock;
    }

    @Override
    public String toString() {
        return "ProductionOrderGoods{" +
                "goodsId=" + goodsId +
                ", partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", unit='" + unit + '\'' +
                ", monthlySalesVolume=" + monthlySalesVolume +
                ", skgCount=" + skgCount +
                ", totalTaskAmount=" + totalTaskAmount +
                ", salesBooking=" + salesBooking +
                ", productionInstructionId=" + productionInstructionId +
                ", serialNumber='" + serialNumber + '\'' +
                ", cycle=" + cycle +
                '}';
    }
}
