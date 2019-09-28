package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
@ApiModel(description = "郝腾")
public class ShipmentDetails implements Serializable {

    @ApiModelProperty(value = "出货单详情id", example = "1")
    private Integer shipmentDetailsId;

    @ApiModelProperty(value = "出货单id", example = "1")
    private Integer shipmentId;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "总箱数", example = "1")
    private Integer boxesNumber;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal outQuantity;

    @ApiModelProperty(value = "状态 1.未配货 2.已配货", example = "1")
    private Byte status;

    @ApiModelProperty(value = "货柜信息", example = "1")
    private String containerInfo;

    @ApiModelProperty(value = "备注", example = "1")
    private String comment;

    @ApiModelProperty(value = "销售订单详情id", example = "1")
    private Integer salesOrderDetailsId;

    @ApiModelProperty(value = "货物", example = "goods")
    private Goods goods;

    @ApiModelProperty(value = "批号", example = "lotNumber")
    private String lotNumber;

    @ApiModelProperty(value = "回数", example = "returnNumber")
    private String returnNumber;

    private static final long serialVersionUID = 1L;

    public Integer getShipmentDetailsId() {
        return shipmentDetailsId;
    }

    public void setShipmentDetailsId(Integer shipmentDetailsId) {
        this.shipmentDetailsId = shipmentDetailsId;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getBoxesNumber() {
        return boxesNumber;
    }

    public void setBoxesNumber(Integer boxesNumber) {
        this.boxesNumber = boxesNumber;
    }

    public BigDecimal getOutQuantity() {
        return outQuantity;
    }

    public void setOutQuantity(BigDecimal outQuantity) {
        this.outQuantity = outQuantity;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getContainerInfo() {
        return containerInfo;
    }

    public void setContainerInfo(String containerInfo) {
        this.containerInfo = containerInfo == null ? null : containerInfo.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getSalesOrderDetailsId() {
        return salesOrderDetailsId;
    }

    public void setSalesOrderDetailsId(Integer salesOrderDetailsId) {
        this.salesOrderDetailsId = salesOrderDetailsId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(String returnNumber) {
        this.returnNumber = returnNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shipmentDetailsId=").append(shipmentDetailsId);
        sb.append(", shipmentId=").append(shipmentId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", boxesNumber=").append(boxesNumber);
        sb.append(", outQuantity=").append(outQuantity);
        sb.append(", status=").append(status);
        sb.append(", containerInfo=").append(containerInfo);
        sb.append(", comment=").append(comment);
        sb.append(", salesOrderDetailsId=").append(salesOrderDetailsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}