package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "郝腾")
public class SalesOrderDetails implements Serializable {

    @ApiModelProperty(value = "销售单详情表id", example = "1")
    private Integer salesOrderDetailsId;

    @ApiModelProperty(value = "销售单id", example = "1")
    private Integer salesOrderId;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "单价", example = "1")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "批号", example = "lotNumber")
    private String lotNumber;

    @ApiModelProperty(value = "数量（用于前台显示）", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "出货数量", example = "1")
    private BigDecimal outQuantity;

    @ApiModelProperty(value = "未出货数量", example = "1")
    private BigDecimal notOutQuantity;


    @ApiModelProperty(value = "总价", example = "1")
    private BigDecimal totalPrice;


    @ApiModelProperty(value = "海关类别", example = "customsCategory")
    private String customsCategory;

    @ApiModelProperty(value = "海关税号", example = "seaTariffNumber")
    private String seaTariffNumber;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "货物", example = "goods")
    private Goods goods;

    @ApiModelProperty(value = "库存数", example = "1")
    private BigDecimal skgCount;

    @ApiModelProperty(value = "状态 1.未出货 2.已部分出货 3.已出货", example = "1")
    private Byte status;

    @ApiModelProperty(value = "退货数量", example = "1")
    private BigDecimal returnAmount;

    @ApiModelProperty(value = "箱数", example = "1")
    private Integer boxesNumber;

    @ApiModelProperty(value = "回数", example = "returnNumber")
    private String returnNumber;


    private static final long serialVersionUID = 1L;


    public Integer getSalesOrderDetailsId() {
        return salesOrderDetailsId;
    }


    public void setSalesOrderDetailsId(Integer salesOrderDetailsId) {
        this.salesOrderDetailsId = salesOrderDetailsId;
    }


    public Integer getSalesOrderId() {
        return salesOrderId;
    }


    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getLotNumber() {
        return lotNumber;
    }


    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber == null ? null : lotNumber.trim();
    }


    public BigDecimal getOutQuantity() {
        return outQuantity;
    }

    public void setOutQuantity(BigDecimal outQuantity) {
        this.outQuantity = outQuantity;
    }

    public BigDecimal getNotOutQuantity() {
        return notOutQuantity;
    }

    public void setNotOutQuantity(BigDecimal notOutQuantity) {
        this.notOutQuantity = notOutQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }


    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }



    public String getCustomsCategory() {
        return customsCategory;
    }


    public void setCustomsCategory(String customsCategory) {
        this.customsCategory = customsCategory == null ? null : customsCategory.trim();
    }


    public String getSeaTariffNumber() {
        return seaTariffNumber;
    }


    public void setSeaTariffNumber(String seaTariffNumber) {
        this.seaTariffNumber = seaTariffNumber == null ? null : seaTariffNumber.trim();
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }


    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSkgCount() {
        return skgCount;
    }

    public void setSkgCount(BigDecimal skgCount) {
        this.skgCount = skgCount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public Integer getBoxesNumber() {
        return boxesNumber;
    }

    public void setBoxesNumber(Integer boxesNumber) {
        this.boxesNumber = boxesNumber;
    }

    public String getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(String returnNumber) {
        this.returnNumber = returnNumber;
    }

    @Override
    public String toString() {
        return "SalesOrderDetails{" +
                "salesOrderDetailsId=" + salesOrderDetailsId +
                ", salesOrderId=" + salesOrderId +
                ", goodsId=" + goodsId +
                ", unitPrice=" + unitPrice +
                ", lotNumber='" + lotNumber + '\'' +
                ", quantity=" + quantity +
                ", outQuantity=" + outQuantity +
                ", notOutQuantity=" + notOutQuantity +
                ", totalPrice=" + totalPrice +
                ", customsCategory='" + customsCategory + '\'' +
                ", seaTariffNumber='" + seaTariffNumber + '\'' +
                ", comment='" + comment + '\'' +
                ", goods=" + goods +
                ", skgCount=" + skgCount +
                ", status=" + status +
                ", returnAmount=" + returnAmount +
                ", boxesNumber=" + boxesNumber +
                ", returnNumber='" + returnNumber + '\'' +
                '}';
    }
}