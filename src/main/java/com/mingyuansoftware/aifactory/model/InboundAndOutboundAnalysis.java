package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
@ApiModel(description = "郝腾")
public class InboundAndOutboundAnalysis   implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "入库数量", example = "1")
    private BigDecimal inventoryQuantity;

    @ApiModelProperty(value = "入库单价", example = "1")
    private BigDecimal inventoryUnitPrice;

    @ApiModelProperty(value = "入库金额", example = "1")
    private BigDecimal inventoryAmount;

    @ApiModelProperty(value = "出库数量", example = "1")
    private BigDecimal outboundQuantity;

    @ApiModelProperty(value = "出库单价", example = "1")
    private BigDecimal outboundUnitPrice;

    @ApiModelProperty(value = "出库金额", example = "1")
    private BigDecimal outboundAmount;

    @ApiModelProperty(value = "在库数量", example = "1")
    private BigDecimal inStockQuantity;

    @ApiModelProperty(value = "在库单价", example = "1")
    private BigDecimal inStockUnitPrice;

    @ApiModelProperty(value = "在库金额", example = "1")
    private BigDecimal inStockAmount;

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

    public BigDecimal getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(BigDecimal inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public BigDecimal getInventoryUnitPrice() {
        return inventoryUnitPrice;
    }

    public void setInventoryUnitPrice(BigDecimal inventoryUnitPrice) {
        this.inventoryUnitPrice = inventoryUnitPrice;
    }

    public BigDecimal getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(BigDecimal inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public BigDecimal getOutboundQuantity() {
        return outboundQuantity;
    }

    public void setOutboundQuantity(BigDecimal outboundQuantity) {
        this.outboundQuantity = outboundQuantity;
    }

    public BigDecimal getOutboundUnitPrice() {
        return outboundUnitPrice;
    }

    public void setOutboundUnitPrice(BigDecimal outboundUnitPrice) {
        this.outboundUnitPrice = outboundUnitPrice;
    }

    public BigDecimal getOutboundAmount() {
        return outboundAmount;
    }

    public void setOutboundAmount(BigDecimal outboundAmount) {
        this.outboundAmount = outboundAmount;
    }

    public BigDecimal getInStockQuantity() {
        return inStockQuantity;
    }

    public void setInStockQuantity(BigDecimal inStockQuantity) {
        this.inStockQuantity = inStockQuantity;
    }

    public BigDecimal getInStockUnitPrice() {
        return inStockUnitPrice;
    }

    public void setInStockUnitPrice(BigDecimal inStockUnitPrice) {
        this.inStockUnitPrice = inStockUnitPrice;
    }

    public BigDecimal getInStockAmount() {
        return inStockAmount;
    }

    public void setInStockAmount(BigDecimal inStockAmount) {
        this.inStockAmount = inStockAmount;
    }

    @Override
    public String toString() {
        return "InboundAndOutboundAnalysis{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", inventoryQuantity=" + inventoryQuantity +
                ", inventoryUnitPrice=" + inventoryUnitPrice +
                ", inventoryAmount=" + inventoryAmount +
                ", outboundQuantity=" + outboundQuantity +
                ", outboundUnitPrice=" + outboundUnitPrice +
                ", outboundAmount=" + outboundAmount +
                ", inStockQuantity=" + inStockQuantity +
                ", inStockUnitPrice=" + inStockUnitPrice +
                ", inStockAmount=" + inStockAmount +
                '}';
    }
}
