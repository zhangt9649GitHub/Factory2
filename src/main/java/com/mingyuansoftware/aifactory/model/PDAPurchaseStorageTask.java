package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 张婷
 * @date 2019/8/1 14:36
 */

public class PDAPurchaseStorageTask {

    @ApiModelProperty(value = "采购订单id",example = "1")
    private Integer purchaseOrderId;

    @ApiModelProperty(value = "采购订单编号",example = "purchaseOrderNumber")
    private String purchaseOrderNumber;

    @ApiModelProperty(value = "供应商id", example = "1")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商名称", example = "供应1")
    private String supplierName;

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
