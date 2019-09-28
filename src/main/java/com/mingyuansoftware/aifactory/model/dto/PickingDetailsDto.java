package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "郝腾")
public class PickingDetailsDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "生产领料员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "领出仓库", example = "outWarehouseName")
    private String outWarehouseName;

    @ApiModelProperty(value = "领入仓库", example = "intoWarehouseName")
    private String intoWarehouseName;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "领料单编号", example = "pickingNumber")
    private String pickingNumber;

    @ApiModelProperty(value = "批号", example = "lotNumber")
    private String lotNumber;

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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutWarehouseName() {
        return outWarehouseName;
    }

    public void setOutWarehouseName(String outWarehouseName) {
        this.outWarehouseName = outWarehouseName;
    }

    public String getIntoWarehouseName() {
        return intoWarehouseName;
    }

    public void setIntoWarehouseName(String intoWarehouseName) {
        this.intoWarehouseName = intoWarehouseName;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getPickingNumber() {
        return pickingNumber;
    }

    public void setPickingNumber(String pickingNumber) {
        this.pickingNumber = pickingNumber;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    @Override
    public String toString() {
        return "PickingDetailsDto{" +
                "partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", outWarehouseName='" + outWarehouseName + '\'' +
                ", intoWarehouseName='" + intoWarehouseName + '\'' +
                ", addTime='" + addTime + '\'' +
                ", pickingNumber='" + pickingNumber + '\'' +
                ", lotNumber='" + lotNumber + '\'' +
                '}';
    }
}
