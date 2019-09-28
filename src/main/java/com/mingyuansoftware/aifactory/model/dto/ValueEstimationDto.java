package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author 张婷
 * @date 2019/9/3 10:57
 */

//在产产值估算列表
@ApiModel(description = "张婷")
public class ValueEstimationDto {

    private Integer goodsId;

    @ApiModelProperty(value = "部品CD", example = "partsCd")
    private String partsCd;

    @ApiModelProperty(value = "品名", example = "goodsName")
    private String productName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "单位 ", example = "unit")
    private String unit;

    private Integer productionInstructionId;

    @ApiModelProperty(value = "生产指示书编号", example = "serialNumber")
    private String serialNumber;

    @ApiModelProperty(value = "未完成数量", example = "1")
    private BigDecimal unfinishedQuantity;

    @ApiModelProperty(value = "a单价（进货价）", example = "1")
    private BigDecimal aPrice;

    //计算出来不能查询
    @ApiModelProperty(value = "金额", example = "1")
    private BigDecimal amount;


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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public BigDecimal getUnfinishedQuantity() {
        return unfinishedQuantity;
    }

    public void setUnfinishedQuantity(BigDecimal unfinishedQuantity) {
        this.unfinishedQuantity = unfinishedQuantity;
    }

    public BigDecimal getaPrice() {
        return aPrice;
    }

    public void setaPrice(BigDecimal aPrice) {
        this.aPrice = aPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
