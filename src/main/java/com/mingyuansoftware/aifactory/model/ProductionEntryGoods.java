package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
@ApiModel(description = "郝腾")
public class ProductionEntryGoods  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "排产单详情id", example = "1")
    private Integer productionOrderDetailsId;

    @ApiModelProperty(value = "排产单id", example = "1")
    private Integer productionOrderId;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "货物入库数量", example = "1")
    private BigDecimal amount;

    public Integer getProductionOrderDetailsId() {
        return productionOrderDetailsId;
    }

    public void setProductionOrderDetailsId(Integer productionOrderDetailsId) {
        this.productionOrderDetailsId = productionOrderDetailsId;
    }

    public Integer getProductionOrderId() {
        return productionOrderId;
    }

    public void setProductionOrderId(Integer productionOrderId) {
        this.productionOrderId = productionOrderId;
    }

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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProductionEntryGoods{" +
                "productionOrderDetailsId=" + productionOrderDetailsId +
                ", productionOrderId=" + productionOrderId +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", amount=" + amount +
                '}';
    }
}
