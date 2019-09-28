package com.mingyuansoftware.aifactory.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
@ApiModel(description = "郝腾")
public class SalesReturnDetails implements Serializable {

    @ApiModelProperty(value = "销售退货单详情id", example = "1")
    private Integer salesReturnDetailsId;

    @ApiModelProperty(value = "销售退货单id", example = "1")
    private Integer salesReturnId;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "单价", example = "1")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "批号", example = "lotNumber")
    private String lotNumber;

    @ApiModelProperty(value = "总价", example = "1")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "海关类型", example = "customsCategory")
    private String customsCategory;

    @ApiModelProperty(value = "海关税号", example = "seaTariffNumber")
    private String seaTariffNumber;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "退货数量（用于前台显示）", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "销售订单货物数量", example = "1")
    private BigDecimal orderQuantity;


    @ApiModelProperty(value = "已到库数量", example = "1")
    private BigDecimal arrivedQuantity;

    @ApiModelProperty(value = "未到库数量", example = "1")
    private BigDecimal noArrivedQuantity;

    @ApiModelProperty(value = "货物", example = "goods")
    private Goods goods;

    @ApiModelProperty(value = "库存数", example = "1")
    private BigDecimal skgCount;


    private static final long serialVersionUID = 1L;


    public Integer getSalesReturnDetailsId() {
        return salesReturnDetailsId;
    }


    public void setSalesReturnDetailsId(Integer salesReturnDetailsId) {
        this.salesReturnDetailsId = salesReturnDetailsId;
    }


    public Integer getSalesReturnId() {
        return salesReturnId;
    }


    public void setSalesReturnId(Integer salesReturnId) {
        this.salesReturnId = salesReturnId;
    }


    public Integer getGoodsId() {
        return goodsId;
    }


    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }


    public String getLotNumber() {
        return lotNumber;
    }


    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber == null ? null : lotNumber.trim();
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


    public BigDecimal getArrivedQuantity() {
        return arrivedQuantity;
    }


    public void setArrivedQuantity(BigDecimal arrivedQuantity) {
        this.arrivedQuantity = arrivedQuantity;
    }


    public BigDecimal getNoArrivedQuantity() {
        return noArrivedQuantity;
    }


    public void setNoArrivedQuantity(BigDecimal noArrivedQuantity) {
        this.noArrivedQuantity = noArrivedQuantity;
    }


    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
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

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", salesReturnDetailsId=").append(salesReturnDetailsId);
        sb.append(", salesReturnId=").append(salesReturnId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", lotNumber=").append(lotNumber);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", customsCategory=").append(customsCategory);
        sb.append(", seaTariffNumber=").append(seaTariffNumber);
        sb.append(", comment=").append(comment);
        sb.append(", arrivedQuantity=").append(arrivedQuantity);
        sb.append(", noArrivedQuantity=").append(noArrivedQuantity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}