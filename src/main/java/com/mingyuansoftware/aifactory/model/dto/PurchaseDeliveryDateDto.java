package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author 张婷
 * @date 2019/9/12 11:35
 */

//采购交货期预警列表(模糊)

@ApiModel(description = "张婷")
public class PurchaseDeliveryDateDto {

    private Integer goodsId;

    @ApiModelProperty(value = "部品CD", example = "partsCd")
    private String partsCd;

    private Integer supplierId;

    @ApiModelProperty(value = "供应商名称", example = "supplierName")
    private String supplierName;

    @ApiModelProperty(value = "自定义日期",example = "defineDate")
    private String defineDate;

    @ApiModelProperty(value = "品名EL", example = "goodsName")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "specification")
    private String specification;

    @ApiModelProperty(value = "采购数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "交货日期",example = "deliveryDate")
    private String deliveryDate;

    @ApiModelProperty(value = "入库状态 1.未入库 2.部分入库 3.已入库",example = "1")
    private Byte storageState;

//    @ApiModelProperty(value = "预警来源",example = "deliveryDate")
//    private String source;

    private Integer purchaseOrderId;

    @ApiModelProperty(value = "采购订单编号",example = "purchaseOrderNumber")
    private String purchaseOrderNumber;

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

    public String getDefineDate() {
        return defineDate;
    }

    public void setDefineDate(String defineDate) {
        this.defineDate = defineDate;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Byte getStorageState() {
        return storageState;
    }

    public void setStorageState(Byte storageState) {
        this.storageState = storageState;
    }

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
}
