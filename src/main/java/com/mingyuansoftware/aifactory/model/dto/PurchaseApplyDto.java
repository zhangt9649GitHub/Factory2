package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author 张婷
 * @date 2019/7/9 17:57
 */

//采购申请单模糊查询
@ApiModel(description = "张婷")
public class PurchaseApplyDto {

    @ApiModelProperty(value = "采购编号", example = "purchaseNumber")
    private String purchaseNumber;

    @ApiModelProperty(value = "部品CD", example = "partsCd")
    private String partsCd;

    @ApiModelProperty(value = "品名", example = "goodsName")
    private String goodsName;

    @ApiModelProperty(value = "单位", example = "unit")
    private String unit;

    @ApiModelProperty(value = "规格", example = "specification")
    private String specification;

    @ApiModelProperty(value = "采购数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "采购周期要求", example = "purchaseCycle")
    private String purchaseCycle;

    @ApiModelProperty(value = "用途说明", example = "purpose")
    private String purpose;

    @ApiModelProperty(value = "自定义日期", example = "defineDate")
    private String defineDate;

    @ApiModelProperty(value = "创建人", example = "name")
    private String name;

    @ApiModelProperty(value = "在库月数", example = "monthsInStock")
    private String monthsInStock;

    @ApiModelProperty(value = "在库数量(天津侧)", example = "1")
    private BigDecimal tjStock;

    //库存余额表字段 getter/setter
    /*@ApiModelProperty(value = "发注中", example = "fazhuzhong")
    private String fazhuzhong;

    @ApiModelProperty(value = "发注残", example = "fazhucan")
    private String fazhucan;

    @ApiModelProperty(value = "引当残", example = "yindangcan")
    private String yindangcan;

    @ApiModelProperty(value = "注文不足或多余在库", example = "spare")
    private String spare;*/

    @ApiModelProperty(value = "供应商名称", example = "supplierName")
    private String supplierName;

    @ApiModelProperty(value = "阶梯价格信息", example = "stairPrice")
    private String stairPrice;

    /*@ApiModelProperty(value = "订单状态 1.未确认 2.已确认", example = "1")
    private Byte orderStatus; 删除*/

    @ApiModelProperty(value = "处理状态 1.未生成 2.已生成", example = "1")
    private Byte handleStatus;

    @ApiModelProperty(value = "处理意见", example = "handleIdea")
    private String handleIdea;

    @ApiModelProperty(value = "采购备注", example = "comment")
    private String comment;

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
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

    public String getPurchaseCycle() {
        return purchaseCycle;
    }

    public void setPurchaseCycle(String purchaseCycle) {
        this.purchaseCycle = purchaseCycle;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDefineDate() {
        return defineDate;
    }

    public void setDefineDate(String defineDate) {
        this.defineDate = defineDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonthsInStock() {
        return monthsInStock;
    }

    public void setMonthsInStock(String monthsInStock) {
        this.monthsInStock = monthsInStock;
    }

    public BigDecimal getTjStock() {
        return tjStock;
    }

    public void setTjStock(BigDecimal tjStock) {
        this.tjStock = tjStock;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getStairPrice() {
        return stairPrice;
    }

    public void setStairPrice(String stairPrice) {
        this.stairPrice = stairPrice;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
