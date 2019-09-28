package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author 张婷
 * @date 2019/7/16 17:24
 */

@ApiModel(description = "张婷")
public class InventoryWarningDto {

    private Integer goodsId;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "库存数量", example = "1")
    private BigDecimal skgCount;

    @ApiModelProperty(value = "最低库存", example = "1")
    private BigDecimal minimumStock;

    @ApiModelProperty(value = "仓库名称", example = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "在库月数", example = "monthsInStock")
    private String monthsInStock;

    @ApiModelProperty(value = "生产预定数", example = "1")
    private BigDecimal productionSchedule;

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

    public BigDecimal getSkgCount() {
        return skgCount;
    }

    public void setSkgCount(BigDecimal skgCount) {
        this.skgCount = skgCount;
    }

    public BigDecimal getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(BigDecimal minimumStock) {
        this.minimumStock = minimumStock;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getMonthsInStock() {
        return monthsInStock;
    }

    public void setMonthsInStock(String monthsInStock) {
        this.monthsInStock = monthsInStock;
    }

    public BigDecimal getProductionSchedule() {
        return productionSchedule;
    }

    public void setProductionSchedule(BigDecimal productionSchedule) {
        this.productionSchedule = productionSchedule;
    }
}
