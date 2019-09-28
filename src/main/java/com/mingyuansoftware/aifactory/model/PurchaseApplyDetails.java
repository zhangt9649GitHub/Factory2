package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "张婷")
public class PurchaseApplyDetails implements Serializable {

    @ApiModelProperty(value = "采购申请单详情id", example = "1")
    private Integer purchaseApplyDetailsId;

    @ApiModelProperty(value = "采购申请单id", example = "1")
    private Integer purchaseApplyId;

    @ApiModelProperty(value = "货物id(部品CD,品名,单位,规格供应商,在库月数)", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "在库数量", example = "1")
    private BigDecimal skgCount;

    @ApiModelProperty(value = "采购数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "采购周期要求", example = "purchaseCycle")
    private String purchaseCycle;

    @ApiModelProperty(value = "用途说明", example = "purpose")
    private String purpose;

    @ApiModelProperty(value = "阶梯价格信息", example = "stairPrice")
    private String stairPrice;

    @ApiModelProperty(value = "处理状态 1.未生成 2.已生成", example = "1")
    private Byte handleStatus;

    @ApiModelProperty(value = "处理意见", example = "handleIdea")
    private String handleIdea;

    @ApiModelProperty(value = "货物", example = "goods")
    private Goods goods;

    @ApiModelProperty(value = "删除状态 1.表示删除 0.表示未删除", example = "0")
    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getPurchaseApplyDetailsId() {
        return purchaseApplyDetailsId;
    }

    public void setPurchaseApplyDetailsId(Integer purchaseApplyDetailsId) {
        this.purchaseApplyDetailsId = purchaseApplyDetailsId;
    }

    public Integer getPurchaseApplyId() {
        return purchaseApplyId;
    }

    public void setPurchaseApplyId(Integer purchaseApplyId) {
        this.purchaseApplyId = purchaseApplyId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getSkgCount() {
        return skgCount;
    }

    public void setSkgCount(BigDecimal skgCount) {
        this.skgCount = skgCount;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getPurchaseCycle() {
        return purchaseCycle;
    }

    public void setPurchaseCycle(String purchaseCycle) {
        this.purchaseCycle = purchaseCycle == null ? null : purchaseCycle.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getStairPrice() {
        return stairPrice;
    }

    public void setStairPrice(String stairPrice) {
        this.stairPrice = stairPrice == null ? null : stairPrice.trim();
    }

    public Byte getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Byte handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getHandleIdea() {
        return handleIdea;
    }

    public void setHandleIdea(String handleIdea) {
        this.handleIdea = handleIdea;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", purchaseApplyDetailsId=").append(purchaseApplyDetailsId);
        sb.append(", purchaseApplyId=").append(purchaseApplyId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", quantity=").append(quantity);
        sb.append(", purchaseCycle=").append(purchaseCycle);
        sb.append(", purpose=").append(purpose);
        sb.append(", stairPrice=").append(stairPrice);
        sb.append(", handleStatus=").append(handleStatus);
        sb.append(", handleIdea=").append(handleIdea);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}