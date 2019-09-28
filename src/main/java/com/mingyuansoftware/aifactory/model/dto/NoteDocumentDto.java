package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author 张婷
 * @date 2019/8/13 13:45
 */

//注文书列表

@ApiModel(description = "张婷")
public class NoteDocumentDto {

    @ApiModelProperty(value = "注文书Id", example = "1")
    private Integer ndid;

    @ApiModelProperty(value = "注文书编号", example = "noteDcNumber")
    private String noteDcNumber;

    @ApiModelProperty(value = "生产指示书Id(截取的'回'之前的数字)", example = "1")
    private Integer productionInstructionId;

    @ApiModelProperty(value = "货物Id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "部品CD", example = "partsCd")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "goodsName")
    private String goodsName;

    @ApiModelProperty(value = "单位", example = "unit")
    private String unit;

    @ApiModelProperty(value = "规格", example = "specification")
    private String specification;

    @ApiModelProperty(value = "供应商id", example = "1")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商名称", example = "supplierName")
    private String supplierName;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal count;

    @ApiModelProperty(value = "预计单价", example = "1")
    private BigDecimal price;

    @ApiModelProperty(value = "合计金额", example = "1")
//    private String money;
    private BigDecimal money;

    @ApiModelProperty(value = "注文书状态 1.无采购 2.采购中 3.退换货 4.交货期 5.订购/预警 6.已完成", example = "1")
    private Byte ndStatus;

    @ApiModelProperty(value = "在库月数", example = "monthsInStock")
    private String monthsInStock;

    @ApiModelProperty(value = "天津侧库存", example = "1")
    private BigDecimal tjStock;

    //发注中(实时计算)  采购订单未入库数量 not_in_quantity
    private BigDecimal faZhuZhong;

    @ApiModelProperty(value = "发注残", example = "1")
    private BigDecimal faZhuCan;

    @ApiModelProperty(value = "引当残", example = "1")
    private BigDecimal yinDangCan;

    @ApiModelProperty(value = "注文不足或多余在库", example = "注文不足或多余在库 正数:多余在库 ; 负数:注文不足；")
    private BigDecimal annotation;

    @ApiModelProperty(value = "采购日期",example = "defineDate")
    private String defineDate;

    @ApiModelProperty(value = "实际单价", example = "1")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "交货日期",example = "deliveryDate")
    private String deliveryDate;

    @ApiModelProperty(value = "到货日期(入库时间)",example = "storageTime")
    private String storageTime;

    @ApiModelProperty(value = "已到情况(入库状态 1.未入库 2.部分入库 3.已入库)",example = "1")
    private Byte storageState;

    @ApiModelProperty(value = "采购订单编号",example = "purchaseOrderNumber")
    private String purchaseOrderNumber;

    @ApiModelProperty(value = "退货情况 1.无退货 2.已退货",example = "1")
    private Byte purchaseReturnSituation;

    @ApiModelProperty(value = "备注",example = "comment")
    private String comment;

    public Integer getNdid() {
        return ndid;
    }

    public void setNdid(Integer ndid) {
        this.ndid = ndid;
    }

    public String getNoteDcNumber() {
        return noteDcNumber;
    }

    public void setNoteDcNumber(String noteDcNumber) {
        this.noteDcNumber = noteDcNumber;
    }

    public Integer getProductionInstructionId() {
        return productionInstructionId;
    }

    public void setProductionInstructionId(Integer productionInstructionId) {
        this.productionInstructionId = productionInstructionId;
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
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

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

   /* public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }*/

        public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Byte getNdStatus() {
        return ndStatus;
    }

    public void setNdStatus(Byte ndStatus) {
        this.ndStatus = ndStatus;
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

    public BigDecimal getFaZhuZhong() {
        return faZhuZhong;
    }

    public void setFaZhuZhong(BigDecimal faZhuZhong) {
        this.faZhuZhong = faZhuZhong;
    }

    public BigDecimal getFaZhuCan() {
        return faZhuCan;
    }

    public void setFaZhuCan(BigDecimal faZhuCan) {
        this.faZhuCan = faZhuCan;
    }

    public BigDecimal getYinDangCan() {
        return yinDangCan;
    }

    public void setYinDangCan(BigDecimal yinDangCan) {
        this.yinDangCan = yinDangCan;
    }

    public BigDecimal getAnnotation() {
        return annotation;
    }

    public void setAnnotation(BigDecimal annotation) {
        this.annotation = annotation;
    }

    public void setTjStock(BigDecimal tjStock) {
        this.tjStock = tjStock;
    }

    public String getDefineDate() {
        return defineDate;
    }

    public void setDefineDate(String defineDate) {
        this.defineDate = defineDate;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime.replace(".0","");
    }

    public Byte getStorageState() {
        return storageState;
    }

    public void setStorageState(Byte storageState) {
        this.storageState = storageState;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public Byte getPurchaseReturnSituation() {
        return purchaseReturnSituation;
    }

    public void setPurchaseReturnSituation(Byte purchaseReturnSituation) {
        this.purchaseReturnSituation = purchaseReturnSituation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "NoteDocumentDto{" +
                "ndid=" + ndid +
                ", noteDcNumber='" + noteDcNumber + '\'' +
                ", productionInstructionId=" + productionInstructionId +
                ", goodsId=" + goodsId +
                ", partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", unit='" + unit + '\'' +
                ", specification='" + specification + '\'' +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", money=" + money +
                ", ndStatus=" + ndStatus +
                ", monthsInStock='" + monthsInStock + '\'' +
                ", tjStock=" + tjStock +
                ", faZhuZhong=" + faZhuZhong +
                ", faZhuCan=" + faZhuCan +
                ", yinDangCan=" + yinDangCan +
                ", annotation='" + annotation + '\'' +
                ", defineDate='" + defineDate + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", storageTime='" + storageTime + '\'' +
                ", storageState=" + storageState +
                ", purchaseOrderNumber='" + purchaseOrderNumber + '\'' +
                ", purchaseReturnSituation=" + purchaseReturnSituation +
                ", comment='" + comment + '\'' +
                '}';
    }
}
