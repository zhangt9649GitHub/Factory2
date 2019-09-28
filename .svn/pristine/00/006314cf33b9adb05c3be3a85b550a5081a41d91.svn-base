package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "郝腾")
public class OutboundOrderDetails implements Serializable {

    @ApiModelProperty(value = "出库单详情id", example = "1")
    private Integer outboundOrderDetailsId;

    @ApiModelProperty(value = "出库单id", example = "1")
    private Integer outboundOrderId;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "出库数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "金额", example = "1")
    private BigDecimal amount;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "平均单价", example = "1")
    private BigDecimal averagePrice;

    @ApiModelProperty(value = "货物", example = "goods")
    private Goods goods;

    private static final long serialVersionUID = 1L;


    public Integer getOutboundOrderDetailsId() {
        return outboundOrderDetailsId;
    }


    public void setOutboundOrderDetailsId(Integer outboundOrderDetailsId) {
        this.outboundOrderDetailsId = outboundOrderDetailsId;
    }


    public Integer getOutboundOrderId() {
        return outboundOrderId;
    }


    public void setOutboundOrderId(Integer outboundOrderId) {
        this.outboundOrderId = outboundOrderId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", outboundOrderDetailsId=").append(outboundOrderDetailsId);
        sb.append(", outboundOrderId=").append(outboundOrderId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", quantity=").append(quantity);
        sb.append(", amount=").append(amount);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}