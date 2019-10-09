package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(description = "郝腾")
public class PickingDetails implements Serializable {

    @ApiModelProperty(value = "领料单详情id", example = "1")
    private Integer pickingDetailsId;

    @ApiModelProperty(value = "领料单id", example = "1")
    private Integer pickingId;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "已领数量", example = "1")
    private BigDecimal getQuantity;

    @ApiModelProperty(value = "备注", example = "1")
    private String comment;

    @ApiModelProperty(value = "货物", example = "goods")
    private Goods goods;

    @ApiModelProperty(value = "库存数", example = "1")
    private BigDecimal skgCount;

    @ApiModelProperty(value = "状态,1.未领料 2.已领料", example = "1")
    private byte status;

    @ApiModelProperty(value = "入仓库id", example = "1")
    private Integer intoWarehouseId;

    @ApiModelProperty(value = "出仓库id", example = "1")
    private Integer outWarehouseId;

    @ApiModelProperty(value = "领料单详情", example = "pickingDetailsList")
    private List<PickingDetails> pickingDetailsList;

    private static final long serialVersionUID = 1L;


    public Integer getPickingDetailsId() {
        return pickingDetailsId;
    }


    public void setPickingDetailsId(Integer pickingDetailsId) {
        this.pickingDetailsId = pickingDetailsId;
    }


    public Integer getPickingId() {
        return pickingId;
    }


    public void setPickingId(Integer pickingId) {
        this.pickingId = pickingId;
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
        this.comment = comment == null ? null : comment.trim();
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

    public Integer getIntoWarehouseId() {
        return intoWarehouseId;
    }

    public void setIntoWarehouseId(Integer intoWarehouseId) {
        this.intoWarehouseId = intoWarehouseId;
    }

    public Integer getOutWarehouseId() {
        return outWarehouseId;
    }

    public void setOutWarehouseId(Integer outWarehouseId) {
        this.outWarehouseId = outWarehouseId;
    }

    public BigDecimal getGetQuantity() {
        return getQuantity;
    }

    public void setGetQuantity(BigDecimal getQuantity) {
        this.getQuantity = getQuantity;
    }

    public List<PickingDetails> getPickingDetailsList() {
        return pickingDetailsList;
    }

    public void setPickingDetailsList(List<PickingDetails> pickingDetailsList) {
        this.pickingDetailsList = pickingDetailsList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pickingDetailsId=").append(pickingDetailsId);
        sb.append(", pickingId=").append(pickingId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", quantity=").append(quantity);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}