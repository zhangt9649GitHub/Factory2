package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "张婷")
public class BomForm implements Serializable {

    @ApiModelProperty(value = "bom表单id", example = "1")
    private Integer bomId;

    @ApiModelProperty(value = "父id(货物id)", example = "1")
    private Integer goodId;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "品种", example = "品种")
    private String variety;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "单位", example = "单位")
    private String unit;

    @ApiModelProperty(value = "bom表单编号", example = "bom表单编号")
    private String bomNumber;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private String createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "自定义日期(用户修改字段)", example = "defineDate")
    private String defineDate;

    @ApiModelProperty(value = "bom表备注", example = "bom表备注")
    private String comment;

    @ApiModelProperty(value = "bom表单详情集合", example = "bomFormDetailList")
    private List<BomFormDetail> bomFormDetailList = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    public Integer getBomId() {
        return bomId;
    }

    public void setBomId(Integer bomId) {
        this.bomId = bomId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
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

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBomNumber() {
        return bomNumber;
    }

    public void setBomNumber(String bomNumber) {
        this.bomNumber = bomNumber == null ? null : bomNumber.trim();
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getCreateTime() {
        return createTime.replace(".0", "");//截取".0"
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDefineDate() {
        return defineDate;
    }

    public void setDefineDate(String defineDate) {
        this.defineDate = defineDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public List<BomFormDetail> getBomFormDetailList() {
        return bomFormDetailList;
    }

    public void setBomFormDetailList(List<BomFormDetail> bomFormDetailList) {
        this.bomFormDetailList = bomFormDetailList;
    }

    @Override
    public String toString() {
        return "BomForm{" +
                "bomId=" + bomId +
                ", goodId=" + goodId +
                ", partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", variety='" + variety + '\'' +
                ", specification='" + specification + '\'' +
                ", unit='" + unit + '\'' +
                ", bomNumber='" + bomNumber + '\'' +
                ", quantity=" + quantity +
                ", createTime='" + createTime + '\'' +
                ", updateTime=" + updateTime +
                ", defineDate='" + defineDate + '\'' +
                ", comment='" + comment + '\'' +
                ", bomFormDetailList=" + bomFormDetailList +
                '}';
    }
}