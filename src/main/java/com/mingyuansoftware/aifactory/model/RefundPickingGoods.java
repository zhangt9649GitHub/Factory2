package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
@ApiModel(description = "郝腾")
public class RefundPickingGoods  implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "退料单详情id", example = "1")
    private Integer refundPickingDetailsId;

    @ApiModelProperty(value = "退料单id", example = "1")
    private Integer refundPickingId;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "仓位名称", example = "仓位名称")
    private String wpName;

    @ApiModelProperty(value = "状态,1.未领料 2.已领料", example = "1")
    private byte status;

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

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RefundPickingGoods{" +
                "refundPickingDetailsId=" + refundPickingDetailsId +
                ", refundPickingId=" + refundPickingId +
                ", goodsId=" + goodsId +
                ", quantity=" + quantity +
                ", partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", wpName='" + wpName + '\'' +
                ", status=" + status +
                '}';
    }
}
