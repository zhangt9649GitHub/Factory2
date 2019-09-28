package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@ApiModel(description = "郝腾")
public class TotalInboundAndOutboundAnalysis  implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "出入库集合", example = "1")
    private List<InboundAndOutboundAnalysis> inboundAndOutboundAnalysisList;

    @ApiModelProperty(value = "入库数量合计", example = "1")
    private BigDecimal totalInventoryQuantity;

    @ApiModelProperty(value = "入库单价合计", example = "1")
    private BigDecimal totalInventoryUnitPrice;

    @ApiModelProperty(value = "入库金额合计", example = "1")
    private BigDecimal totalInventoryAmount;

    @ApiModelProperty(value = "出库数量合计", example = "1")
    private BigDecimal totalOutboundQuantity;

    @ApiModelProperty(value = "出库单价合计", example = "1")
    private BigDecimal totalOutboundUnitPrice;

    @ApiModelProperty(value = "出库金额合计", example = "1")
    private BigDecimal totalOutboundAmount;

    @ApiModelProperty(value = "在库数量合计", example = "1")
    private BigDecimal totalInStockQuantity;

    @ApiModelProperty(value = "在库单价合计", example = "1")
    private BigDecimal totalInStockUnitPrice;

    @ApiModelProperty(value = "在库金额合计", example = "1")
    private BigDecimal totalInStockAmount;

    public List<InboundAndOutboundAnalysis> getInboundAndOutboundAnalysisList() {
        return inboundAndOutboundAnalysisList;
    }

    public void setInboundAndOutboundAnalysisList(List<InboundAndOutboundAnalysis> inboundAndOutboundAnalysisList) {
        this.inboundAndOutboundAnalysisList = inboundAndOutboundAnalysisList;
    }

    public BigDecimal getTotalInventoryQuantity() {
        return totalInventoryQuantity;
    }

    public void setTotalInventoryQuantity(BigDecimal totalInventoryQuantity) {
        this.totalInventoryQuantity = totalInventoryQuantity;
    }

    public BigDecimal getTotalInventoryUnitPrice() {
        return totalInventoryUnitPrice;
    }

    public void setTotalInventoryUnitPrice(BigDecimal totalInventoryUnitPrice) {
        this.totalInventoryUnitPrice = totalInventoryUnitPrice;
    }

    public BigDecimal getTotalInventoryAmount() {
        return totalInventoryAmount;
    }

    public void setTotalInventoryAmount(BigDecimal totalInventoryAmount) {
        this.totalInventoryAmount = totalInventoryAmount;
    }

    public BigDecimal getTotalOutboundQuantity() {
        return totalOutboundQuantity;
    }

    public void setTotalOutboundQuantity(BigDecimal totalOutboundQuantity) {
        this.totalOutboundQuantity = totalOutboundQuantity;
    }

    public BigDecimal getTotalOutboundUnitPrice() {
        return totalOutboundUnitPrice;
    }

    public void setTotalOutboundUnitPrice(BigDecimal totalOutboundUnitPrice) {
        this.totalOutboundUnitPrice = totalOutboundUnitPrice;
    }

    public BigDecimal getTotalOutboundAmount() {
        return totalOutboundAmount;
    }

    public void setTotalOutboundAmount(BigDecimal totalOutboundAmount) {
        this.totalOutboundAmount = totalOutboundAmount;
    }

    public BigDecimal getTotalInStockQuantity() {
        return totalInStockQuantity;
    }

    public void setTotalInStockQuantity(BigDecimal totalInStockQuantity) {
        this.totalInStockQuantity = totalInStockQuantity;
    }

    public BigDecimal getTotalInStockUnitPrice() {
        return totalInStockUnitPrice;
    }

    public void setTotalInStockUnitPrice(BigDecimal totalInStockUnitPrice) {
        this.totalInStockUnitPrice = totalInStockUnitPrice;
    }

    public BigDecimal getTotalInStockAmount() {
        return totalInStockAmount;
    }

    public void setTotalInStockAmount(BigDecimal totalInStockAmount) {
        this.totalInStockAmount = totalInStockAmount;
    }

    @Override
    public String toString() {
        return "TotalInboundAndOutboundAnalysis{" +
                "inboundAndOutboundAnalysisList=" + inboundAndOutboundAnalysisList +
                ", totalInventoryQuantity=" + totalInventoryQuantity +
                ", totalInventoryUnitPrice=" + totalInventoryUnitPrice +
                ", totalInventoryAmount=" + totalInventoryAmount +
                ", totalOutboundQuantity=" + totalOutboundQuantity +
                ", totalOutboundUnitPrice=" + totalOutboundUnitPrice +
                ", totalOutboundAmount=" + totalOutboundAmount +
                ", totalInStockQuantity=" + totalInStockQuantity +
                ", totalInStockUnitPrice=" + totalInStockUnitPrice +
                ", totalInStockAmount=" + totalInStockAmount +
                '}';
    }
}
