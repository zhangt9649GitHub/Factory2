package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 生产入库单生产货物列表
 */
@ApiModel(description = "郝腾")
public class ProductionGoods   implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "单位", example = "单位")
    private String unit;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;


    @ApiModelProperty(value = "单价（a单价+b单价）", example = "1")
    private BigDecimal unitPrice;


    @ApiModelProperty(value = "货物入库数量", example = "1")
    private BigDecimal amount;

    @ApiModelProperty(value = "金额", example = "1")
    private BigDecimal money;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "生产指示书货物id", example = "1")
    private Integer productionInstructionGoodsId;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getProductionInstructionGoodsId() {
        return productionInstructionGoodsId;
    }

    public void setProductionInstructionGoodsId(Integer productionInstructionGoodsId) {
        this.productionInstructionGoodsId = productionInstructionGoodsId;
    }

    @Override
    public String toString() {
        return "ProductionGoods{" +
                "partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", unit='" + unit + '\'' +
                ", specification='" + specification + '\'' +
                ", unitPrice=" + unitPrice +
                ", amount=" + amount +
                ", money=" + money +
                ", comment='" + comment + '\'' +
                ", productionInstructionGoodsId=" + productionInstructionGoodsId +
                '}';
    }
}
