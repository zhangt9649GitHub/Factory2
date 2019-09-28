package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 材料需求列表
 */
@ApiModel(description = "郝腾")
public class MaterialRequirements implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "采购需求数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "需求来源", example = "requirementSource")
    private String requirementSource;

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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getRequirementSource() {
        return requirementSource;
    }

    public void setRequirementSource(String requirementSource) {
        this.requirementSource = requirementSource;
    }

    @Override
    public String toString() {
        return "MaterialRequirements{" +
                "partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", quantity=" + quantity +
                ", requirementSource='" + requirementSource + '\'' +
                '}';
    }
}
