package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "郝腾")
public class RefundPickingDetails implements Serializable {

    @ApiModelProperty(value = "退料单详情id", example = "1")
    private Integer refundPickingDetailsId;

    @ApiModelProperty(value = "退料单id", example = "1")
    private Integer refundPickingId;


    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;


    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal quantity;


    @ApiModelProperty(value = "退换原因", example = "reason")
    private String reason;

    @ApiModelProperty(value = "货物", example = "goods")
    private Goods goods;

    @ApiModelProperty(value = "库存数", example = "1")
    private BigDecimal skgCount;

    @ApiModelProperty(value = "状态,1.未领料 2.已领料", example = "1")
    private byte status;

    private static final long serialVersionUID = 1L;



    public Integer getRefundPickingDetailsId() {
        return refundPickingDetailsId;
    }



    public void setRefundPickingDetailsId(Integer refundPickingDetailsId) {
        this.refundPickingDetailsId = refundPickingDetailsId;
    }



    public Integer getRefundPickingId() {
        return refundPickingId;
    }



    public void setRefundPickingId(Integer refundPickingId) {
        this.refundPickingId = refundPickingId;
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



    public String getReason() {
        return reason;
    }



    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", refundPickingDetailsId=").append(refundPickingDetailsId);
        sb.append(", refundPickingId=").append(refundPickingId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", quantity=").append(quantity);
        sb.append(", reason=").append(reason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}