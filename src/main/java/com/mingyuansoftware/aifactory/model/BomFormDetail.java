package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "张婷")
public class BomFormDetail implements Serializable {

    @ApiModelProperty(value = "bom详情表id", example = "1")
    private Integer bomDetailId;

    @ApiModelProperty(value = "父id  bom表单id", example = "1")
    private Integer bomId;

    @ApiModelProperty(value = "货物id  货物内容", example = "1")
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

    @ApiModelProperty(value = "必要数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "bom详情表备注", example = "bom详情表备注")
    private String comment;

    @ApiModelProperty(value = "货物类别", example = "1")
    private Byte category;

    @ApiModelProperty(value = "成型周期", example = "1")
    private BigDecimal cycle;

//    @ApiModelProperty(value = "货物", example = "goods")
//    private Goods goods;

    private static final long serialVersionUID = 1L;

    public Integer getBomDetailId() {
        return bomDetailId;
    }

    public void setBomDetailId(Integer bomDetailId) {
        this.bomDetailId = bomDetailId;
    }

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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    public BigDecimal getCycle() {
        return cycle;
    }

    public void setCycle(BigDecimal cycle) {
        this.cycle = cycle;
    }

    //    public Goods getGoods() {
//        return goods;
//    }
//
//    public void setGoods(Goods goods) {
//        this.goods = goods;
//    }

    @Override
    public String toString() {
        return "BomFormDetail{" +
                "bomDetailId=" + bomDetailId +
                ", bomId=" + bomId +
                ", goodId=" + goodId +
                ", partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", variety='" + variety + '\'' +
                ", specification='" + specification + '\'' +
                ", unit='" + unit + '\'' +
                ", quantity=" + quantity +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", comment='" + comment + '\'' +
//                ", goods=" + goods +
                '}';
    }
}