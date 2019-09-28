package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 库存状态
 */
@ApiModel(description = "郝腾")
public class InventoryStatus implements Serializable {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "平均月贩", example = "1")
    private BigDecimal averageMonthlyVendor;

    @ApiModelProperty(value = "包含运送途中的在库月数", example = "monthsInStock")
    private String monthsInStock;

    @ApiModelProperty(value = "日本侧商品", example = "1")
    private BigDecimal jpGoods;

    @ApiModelProperty(value = "日本侧半成品", example = "1")
    private BigDecimal jpSemiFinished;

    @ApiModelProperty(value = "中国侧运输中", example = "1")
    private BigDecimal cnTransport;

    @ApiModelProperty(value = "中国侧半成品", example = "1")
    private BigDecimal cnSemiFinished;

    @ApiModelProperty(value = "中国侧部品", example = "1")
    private BigDecimal cnParts;

    @ApiModelProperty(value = "手配", example = "1")
    private BigDecimal handWith;

    @ApiModelProperty(value = "预定", example = "1")
    private BigDecimal reservation;

    @ApiModelProperty(value = "半成品合计", example = "1")
    private BigDecimal totalSemiFinished;

    @ApiModelProperty(value = "月数", example = "months")
    private String months;

    @ApiModelProperty(value = "半成品预备", example = "1")
    private BigDecimal prepareSemiFinished;

    @ApiModelProperty(value = "过不住", example = "1")
    private BigDecimal haveNotToLive;

    @ApiModelProperty(value = "货物类别", example = "1")
    private Byte category;

    @ApiModelProperty(value = "状态 1.着急出货 2.着急生产 3.着急准备", example = "1")
    private Byte state;


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

    public BigDecimal getJpGoods() {
        return jpGoods;
    }

    public void setJpGoods(BigDecimal jpGoods) {
        this.jpGoods = jpGoods;
    }

    public BigDecimal getJpSemiFinished() {
        return jpSemiFinished;
    }

    public void setJpSemiFinished(BigDecimal jpSemiFinished) {
        this.jpSemiFinished = jpSemiFinished;
    }

    public BigDecimal getCnTransport() {
        return cnTransport;
    }

    public void setCnTransport(BigDecimal cnTransport) {
        this.cnTransport = cnTransport;
    }

    public BigDecimal getCnSemiFinished() {
        return cnSemiFinished;
    }

    public void setCnSemiFinished(BigDecimal cnSemiFinished) {
        this.cnSemiFinished = cnSemiFinished;
    }

    public BigDecimal getCnParts() {
        return cnParts;
    }

    public void setCnParts(BigDecimal cnParts) {
        this.cnParts = cnParts;
    }

    public BigDecimal getHandWith() {
        return handWith;
    }

    public void setHandWith(BigDecimal handWith) {
        this.handWith = handWith;
    }

    public BigDecimal getReservation() {
        return reservation;
    }

    public void setReservation(BigDecimal reservation) {
        this.reservation = reservation;
    }

    public BigDecimal getTotalSemiFinished() {
        return totalSemiFinished;
    }

    public void setTotalSemiFinished(BigDecimal totalSemiFinished) {
        this.totalSemiFinished = totalSemiFinished;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public BigDecimal getPrepareSemiFinished() {
        return prepareSemiFinished;
    }

    public void setPrepareSemiFinished(BigDecimal prepareSemiFinished) {
        this.prepareSemiFinished = prepareSemiFinished;
    }

    public BigDecimal getHaveNotToLive() {
        return haveNotToLive;
    }

    public void setHaveNotToLive(BigDecimal haveNotToLive) {
        this.haveNotToLive = haveNotToLive;
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "InventoryStatus{" +
                "partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", averageMonthlyVendor=" + averageMonthlyVendor +
                ", monthsInStock='" + monthsInStock + '\'' +
                ", jpGoods=" + jpGoods +
                ", jpSemiFinished=" + jpSemiFinished +
                ", cnTransport=" + cnTransport +
                ", cnSemiFinished=" + cnSemiFinished +
                ", cnParts=" + cnParts +
                ", handWith=" + handWith +
                ", reservation=" + reservation +
                ", totalSemiFinished=" + totalSemiFinished +
                ", months='" + months + '\'' +
                ", prepareSemiFinished=" + prepareSemiFinished +
                ", haveNotToLive=" + haveNotToLive +
                ", category=" + category +
                ", state=" + state +
                '}';
    }
}
