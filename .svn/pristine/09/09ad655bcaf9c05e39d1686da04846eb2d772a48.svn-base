package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author 张婷
 * @date 2019/8/1 10:03
 */

//pda采购入库货物

public class PurchaseStorageGoods {

    @ApiModelProperty(value = "采购订单详情id",example = "1")
    private Integer purchaseOrderDetailsId;

    @ApiModelProperty(value = "采购订单id",example = "1")
    private Integer purchaseOrderId;

    @ApiModelProperty(value = "货物id",example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "采购订单数量",example = "1.1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "'pda操作货物入库状态 1.未入库  2.已入库",example = "podStorageState")
    private Byte podStorageState;

    @ApiModelProperty(value = "货物", example = "goods")
    private Goods goods;

    @ApiModelProperty(value = "库存数", example = "1")
    private BigDecimal skgCount;

    public Integer getPurchaseOrderDetailsId() {
        return purchaseOrderDetailsId;
    }

    public void setPurchaseOrderDetailsId(Integer purchaseOrderDetailsId) {
        this.purchaseOrderDetailsId = purchaseOrderDetailsId;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
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

    public Byte getPodStorageState() {
        return podStorageState;
    }

    public void setPodStorageState(Byte podStorageState) {
        this.podStorageState = podStorageState;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BigDecimal getSkgCount() {
        return skgCount;
    }

    public void setSkgCount(BigDecimal skgCount) {
        this.skgCount = skgCount;
    }
}
