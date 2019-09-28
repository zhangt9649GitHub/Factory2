package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
@ApiModel(description = "郝腾")
public class RequisitionDetails implements Serializable {

    @ApiModelProperty(value = "调拨单详情id", example = "1")
    private Integer requisitionDetailsId;

    @ApiModelProperty(value = "调拨单id", example = "1")
    private Integer requisitionId;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "货物", example = "goods")
    private Goods goods;

    @ApiModelProperty(value = "平均单价", example = "1")
    private BigDecimal averagePrice;



    private static final long serialVersionUID = 1L;


    public Integer getRequisitionDetailsId() {
        return requisitionDetailsId;
    }


    public void setRequisitionDetailsId(Integer requisitionDetailsId) {
        this.requisitionDetailsId = requisitionDetailsId;
    }


    public Integer getRequisitionId() {
        return requisitionId;
    }


    public void setRequisitionId(Integer requisitionId) {
        this.requisitionId = requisitionId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", requisitionDetailsId=").append(requisitionDetailsId);
        sb.append(", requisitionId=").append(requisitionId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", quantity=").append(quantity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}