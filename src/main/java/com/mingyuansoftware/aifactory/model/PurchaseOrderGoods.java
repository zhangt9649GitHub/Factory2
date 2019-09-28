package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 张婷
 * @date 2019/7/29 16:31
 */

//PDA采购入库货物实体类

@ApiModel(description = "张婷")
public class PurchaseOrderGoods {

    @ApiModelProperty(value = "采购订单详情id",example = "1")
    private Integer purchaseOrderDetailsId;

    @ApiModelProperty(value = "采购订单id(修改状态)",example = "1")
    private Integer purchaseOrderId;

    @ApiModelProperty(value = "采购订单编号",example = "purchaseOrderNumber")
    private String purchaseOrderNumber;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "部品CD", example = "partsCd")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "goodsName")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "specification")
    private String specification;

    @ApiModelProperty(value = "仓位名字", example = "wpName")
    private String wpName;

    @ApiModelProperty(value = "采购单价", example = "1")
    private BigDecimal purchasePrice;

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getPurchaseOrderDetailsId() {
        return purchaseOrderDetailsId;
    }

    public void setPurchaseOrderDetailsId(Integer purchaseOrderDetailsId) {
        this.purchaseOrderDetailsId = purchaseOrderDetailsId;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

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

    public String getWpName() {
        return wpName;
    }

    public void setWpName(String wpName) {
        this.wpName = wpName;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
