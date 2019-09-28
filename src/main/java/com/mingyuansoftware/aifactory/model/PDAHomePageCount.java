package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "郝腾")
public class PDAHomePageCount  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产领料待处理数量", example = "1")
    private int pickingCount;

    @ApiModelProperty(value = "生产入库待处理数量", example = "1")
    private int productionEntryCount;

    @ApiModelProperty(value = "采购入库待处理数量", example = "1")
    private int purchaseOrderCount;

    @ApiModelProperty(value = "生产退料待处理数量", example = "1")
    private int refundPickingCount;

    @ApiModelProperty(value = "盘点操作待处理数量", example = "1")
    private int inventoryCheckCount;

    @ApiModelProperty(value = "商品出库待处理数量", example = "1")
    private int outboundOrderCount;

    public int getPickingCount() {
        return pickingCount;
    }

    public void setPickingCount(int pickingCount) {
        this.pickingCount = pickingCount;
    }

    public int getProductionEntryCount() {
        return productionEntryCount;
    }

    public void setProductionEntryCount(int productionEntryCount) {
        this.productionEntryCount = productionEntryCount;
    }

    public int getPurchaseOrderCount() {
        return purchaseOrderCount;
    }

    public void setPurchaseOrderCount(int purchaseOrderCount) {
        this.purchaseOrderCount = purchaseOrderCount;
    }

    public int getRefundPickingCount() {
        return refundPickingCount;
    }

    public void setRefundPickingCount(int refundPickingCount) {
        this.refundPickingCount = refundPickingCount;
    }

    public int getInventoryCheckCount() {
        return inventoryCheckCount;
    }

    public void setInventoryCheckCount(int inventoryCheckCount) {
        this.inventoryCheckCount = inventoryCheckCount;
    }

    public int getOutboundOrderCount() {
        return outboundOrderCount;
    }

    public void setOutboundOrderCount(int outboundOrderCount) {
        this.outboundOrderCount = outboundOrderCount;
    }

    @Override
    public String toString() {
        return "PDAHomePageCount{" +
                "pickingCount=" + pickingCount +
                ", productionEntryCount=" + productionEntryCount +
                ", purchaseOrderCount=" + purchaseOrderCount +
                ", refundPickingCount=" + refundPickingCount +
                ", inventoryCheckCount=" + inventoryCheckCount +
                ", outboundOrderCount=" + outboundOrderCount +
                '}';
    }
}
