package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 生产成本计算
 */
@ApiModel(description = "郝腾")
public class ProductionCosting implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "单位", example = "单位")
    private String unit;

    @ApiModelProperty(value = "生产指示书编号", example = "serialNumber")
    private String serialNumber;

    @ApiModelProperty(value = "单据日期", example = "documentTime")
    private String documentTime;

    @ApiModelProperty(value = "领料成本", example = "1")
    private BigDecimal acquisitionCost;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDocumentTime() {
        return documentTime;
    }

    public void setDocumentTime(String documentTime) {
        this.documentTime = documentTime;
    }

    public BigDecimal getAcquisitionCost() {
        return acquisitionCost;
    }

    public void setAcquisitionCost(BigDecimal acquisitionCost) {
        this.acquisitionCost = acquisitionCost;
    }

    @Override
    public String toString() {
        return "ProductionCosting{" +
                "partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", unit='" + unit + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", documentTime='" + documentTime + '\'' +
                ", acquisitionCost=" + acquisitionCost +
                '}';
    }
}
