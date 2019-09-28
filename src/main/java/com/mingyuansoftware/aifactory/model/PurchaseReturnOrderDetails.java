package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "张婷")
public class PurchaseReturnOrderDetails implements Serializable {

    @ApiModelProperty(value = "采购退货单详情id",example = "1")
    private Integer prodId;

    @ApiModelProperty(value = "采购退货单id",example = "1")
    private Integer proId;

    @ApiModelProperty(value = "货物id",example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "单位", example = "单位")
    private String unit;

    @ApiModelProperty(value = "数量(采购订单)",example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "退货数量",example = "1")
    private BigDecimal returnQuantity;

    @ApiModelProperty(value = "退货单价",example = "1")
    private BigDecimal price;

    @ApiModelProperty(value = "退货总价",example = "1")
    private BigDecimal money;

    @ApiModelProperty(value = "退货原因",example = "reasonReturn")
    private String reasonReturn;

    @ApiModelProperty(value = "已出库数量",example = "1")
    private BigDecimal leaveQuantity;

    @ApiModelProperty(value = "未出库数量",example = "1")
    private BigDecimal noLeaveQuantity;

    @ApiModelProperty(value = "库存数", example = "1")
    private BigDecimal skgCount;

    private static final long serialVersionUID = 1L;

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getReturnQuantity() {
        return returnQuantity;
    }

    public void setReturnQuantity(BigDecimal returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getReasonReturn() {
        return reasonReturn;
    }

    public void setReasonReturn(String reasonReturn) {
        this.reasonReturn = reasonReturn == null ? null : reasonReturn.trim();
    }

    public BigDecimal getLeaveQuantity() {
        return leaveQuantity;
    }

    public void setLeaveQuantity(BigDecimal leaveQuantity) {
        this.leaveQuantity = leaveQuantity;
    }

    public BigDecimal getNoLeaveQuantity() {
        return noLeaveQuantity;
    }

    public void setNoLeaveQuantity(BigDecimal noLeaveQuantity) {
        this.noLeaveQuantity = noLeaveQuantity;
    }

    public BigDecimal getSkgCount() {
        return skgCount;
    }

    public void setSkgCount(BigDecimal skgCount) {
        this.skgCount = skgCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prodId=").append(prodId);
        sb.append(", proId=").append(proId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", returnQuantity=").append(returnQuantity);
        sb.append(", price=").append(price);
        sb.append(", money=").append(money);
        sb.append(", reasonReturn=").append(reasonReturn);
        sb.append(", leaveQuantity=").append(leaveQuantity);
        sb.append(", noLeaveQuantity=").append(noLeaveQuantity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}