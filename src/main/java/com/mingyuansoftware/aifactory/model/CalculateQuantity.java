package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 计算班次
 */
@ApiModel(description = "郝腾")
public class CalculateQuantity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需要的货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "必要数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "库存数量", example = "1")
    private BigDecimal skgCount;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSkgCount() {
        return skgCount;
    }

    public void setSkgCount(BigDecimal skgCount) {
        this.skgCount = skgCount;
    }

    @Override
    public String toString() {
        return "CalculateQuantity{" +
                "goodsId=" + goodsId +
                ", quantity=" + quantity +
                ", skgCount=" + skgCount +
                '}';
    }
}
