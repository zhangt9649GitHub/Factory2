package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "郝腾")
public class SalesDetailsDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部品CD", example = "partsCd")
    private String partsCd;

    @ApiModelProperty(value = "客户名称", example = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "销售日期", example = "addtime")
    private String addtime;

    @ApiModelProperty(value = "品名", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "销售数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "销售价格(单价)", example = "1")
    private BigDecimal sellingPrice;

    @ApiModelProperty(value = "总价", example = "1")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "库存数", example = "1")
    private BigDecimal skgCount;

    @ApiModelProperty(value = "销售订单编号", example = "salesOrderNumber")
    private String salesOrderNumber;


    public String getPartsCd() {
        return partsCd;
    }

    public void setPartsCd(String partsCd) {
        this.partsCd = partsCd;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
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

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getSkgCount() {
        return skgCount;
    }

    public void setSkgCount(BigDecimal skgCount) {
        this.skgCount = skgCount;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    @Override
    public String toString() {
        return "SalesDetailsDto{" +
                "partsCd='" + partsCd + '\'' +
                ", customerName='" + customerName + '\'' +
                ", addtime='" + addtime + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", quantity=" + quantity +
                ", sellingPrice=" + sellingPrice +
                ", totalPrice=" + totalPrice +
                ", skgCount=" + skgCount +
                ", salesOrderNumber='" + salesOrderNumber + '\'' +
                '}';
    }
}
