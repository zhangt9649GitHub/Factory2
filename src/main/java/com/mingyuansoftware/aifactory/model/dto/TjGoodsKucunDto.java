package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "郝腾")
public class TjGoodsKucunDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "库存数", example = "1")
    private BigDecimal skgCount;

    @ApiModelProperty(value = "仓库名称", example = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "仓位名称", example = "仓位名称")
    private String wpName;

    @ApiModelProperty(value = "最新出货数 (取最新的一次销售出库数)", example = "1")
    private BigDecimal latestShipment;

    @ApiModelProperty(value = "a单价（进货价）", example = "1")
    private BigDecimal aPrice;

    @ApiModelProperty(value = "b单价（加工价）", example = "1")
    private BigDecimal bPrice;

    @ApiModelProperty(value = "金额 （a单价*库存数）", example = "1")
    private BigDecimal amount;

    @ApiModelProperty(value = "货物类别", example = "1")
    private Byte category;

    @ApiModelProperty(value = "货物类别名称", example = "1")
    private String categoryName;

    @ApiModelProperty(value = "被领料单占用的数量", example = "1")
    private BigDecimal occupiedAmount;

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

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWpName() {
        return wpName;
    }

    public void setWpName(String wpName) {
        this.wpName = wpName;
    }

    public BigDecimal getLatestShipment() {
        return latestShipment;
    }

    public void setLatestShipment(BigDecimal latestShipment) {
        this.latestShipment = latestShipment;
    }

    public BigDecimal getaPrice() {
        return aPrice;
    }

    public void setaPrice(BigDecimal aPrice) {
        this.aPrice = aPrice;
    }

    public BigDecimal getbPrice() {
        return bPrice;
    }

    public void setbPrice(BigDecimal bPrice) {
        this.bPrice = bPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getOccupiedAmount() {
        return occupiedAmount;
    }

    public void setOccupiedAmount(BigDecimal occupiedAmount) {
        this.occupiedAmount = occupiedAmount;
    }

    @Override
    public String toString() {
        return "TjGoodsKucunDto{" +
                "goodsId=" + goodsId +
                ", partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", skgCount=" + skgCount +
                ", warehouseName='" + warehouseName + '\'' +
                ", wpName='" + wpName + '\'' +
                ", latestShipment=" + latestShipment +
                ", aPrice=" + aPrice +
                ", bPrice=" + bPrice +
                ", amount=" + amount +
                ", category=" + category +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
