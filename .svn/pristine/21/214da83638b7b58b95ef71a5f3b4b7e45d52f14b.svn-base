package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 生产入库单消耗货物列表
 */
@ApiModel(description = "郝腾")
public class ConsumptionGoods   implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "单位", example = "单位")
    private String unit;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal quantity;

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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ConsumptionGoods{" +
                "partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", unit='" + unit + '\'' +
                ", specification='" + specification + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
