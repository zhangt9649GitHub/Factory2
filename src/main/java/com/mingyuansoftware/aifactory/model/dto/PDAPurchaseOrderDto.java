package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 张婷
 * @date 2019/7/29 16:31
 */

//PDA采购入库扫描

@ApiModel(description = "张婷")
public class PDAPurchaseOrderDto {

    @ApiModelProperty(value = "采购订单id",example = "1")
    private Integer purchaseOrderId;

    @ApiModelProperty(value = "采购订单详情id",example = "1")
    private Integer purchaseOrderDetailsId;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal skgCount;

    @ApiModelProperty(value = "仓库id", example = "1")
    private Integer warehouseId;

    @ApiModelProperty(value = "库存类型", example = "skgType")
    private String skgType;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer gid;

    @ApiModelProperty(value = "货物成本", example = "1")
    private BigDecimal skgDanJia;

    @ApiModelProperty(value = "单据编号", example = "skgSerialNumber")
    private String skgSerialNumber;

    @ApiModelProperty(value = "往来单位", example = "skgWanglaiDanwei")
    private String skgWanglaiDanwei;

//    @ApiModelProperty(value = "当时总数量", example = "1")
//    private BigDecimal totalSkgCount;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getPurchaseOrderDetailsId() {
        return purchaseOrderDetailsId;
    }

    public void setPurchaseOrderDetailsId(Integer purchaseOrderDetailsId) {
        this.purchaseOrderDetailsId = purchaseOrderDetailsId;
    }

    public BigDecimal getSkgCount() {
        return skgCount;
    }

    public void setSkgCount(BigDecimal skgCount) {
        this.skgCount = skgCount;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getSkgType() {
        return skgType;
    }

    public void setSkgType(String skgType) {
        this.skgType = skgType;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public BigDecimal getSkgDanJia() {
        return skgDanJia;
    }

    public void setSkgDanJia(BigDecimal skgDanJia) {
        this.skgDanJia = skgDanJia;
    }

    public String getSkgSerialNumber() {
        return skgSerialNumber;
    }

    public void setSkgSerialNumber(String skgSerialNumber) {
        this.skgSerialNumber = skgSerialNumber;
    }

    public String getSkgWanglaiDanwei() {
        return skgWanglaiDanwei;
    }

    public void setSkgWanglaiDanwei(String skgWanglaiDanwei) {
        this.skgWanglaiDanwei = skgWanglaiDanwei;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}
