package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "郝腾")
public class StorageGoods implements Serializable {

    @ApiModelProperty(value = "入库单货物详情id", example = "1")
    private Integer storageGoodsId;

    @ApiModelProperty(value = "入库单id", example = "1")
    private Integer storageAccessId;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "金额", example = "1")
    private BigDecimal amount;

    @ApiModelProperty(value = "备注", example = "1")
    private String comment;

    @ApiModelProperty(value = "货物", example = "goods")
    private Goods goods;


    @ApiModelProperty(value = "平均单价", example = "1")
    private BigDecimal averagePrice;

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    private static final long serialVersionUID = 1L;


    public Integer getStorageGoodsId() {
        return storageGoodsId;
    }


    public void setStorageGoodsId(Integer storageGoodsId) {
        this.storageGoodsId = storageGoodsId;
    }


    public Integer getStorageAccessId() {
        return storageAccessId;
    }


    public void setStorageAccessId(Integer storageAccessId) {
        this.storageAccessId = storageAccessId;
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


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", storageGoodsId=").append(storageGoodsId);
        sb.append(", storageAccessId=").append(storageAccessId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", quantity=").append(quantity);
        sb.append(", amount=").append(amount);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}