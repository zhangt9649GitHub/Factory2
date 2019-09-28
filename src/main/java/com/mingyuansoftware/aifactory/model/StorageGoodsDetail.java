package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "王力影")
public class StorageGoodsDetail implements Serializable {

    @ApiModelProperty(value = "入库单货物详情id", example = "1")
    private Integer storageGoodsId;

    @ApiModelProperty(value = "入库单id", example = "1")
    private Integer storageAccessId;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal quantity;

    @ApiModelProperty(value = "金额", example = "1")
    private BigDecimal amount;

    @ApiModelProperty(value = "部品CD", example = "1")
    private String partsCd;

    @ApiModelProperty(value = "规格", example = "1")
    private String specification;

    @ApiModelProperty(value = "品名EL", example = "1")
    private String goodsName;

    @ApiModelProperty(value = "a单价（进货价）", example = "1.11")
    private BigDecimal aPrice;

    @ApiModelProperty(value = "入库编号", example = "1")
    private String storageNumber;

    @ApiModelProperty(value = "b单价（加工价）", example = "1.11")
    private BigDecimal bPrice;

    @ApiModelProperty(value = "批号", example = "1")
    private String lotNumber;

    @ApiModelProperty(value = "类型  1.盘盈入库 2.采购入库等", example = "1")
    private String type;

    @ApiModelProperty(value = "入库时间", example = "2018-03-04")
    private String rukuTime;

    @ApiModelProperty(value = "入库仓库名称", example = "仓库一")
    private String warehouseName;

    @ApiModelProperty(value = "开始时间", example = "2018-03-04")
    private String beginDate;

    @ApiModelProperty(value = "结束时间", example = "2018-03-04")
    private String endDate;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPartsCd() {
        return partsCd;
    }

    public void setPartsCd(String partsCd) {
        this.partsCd = partsCd;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getaPrice() {
        return aPrice;
    }

    public void setaPrice(BigDecimal aPrice) {
        this.aPrice = aPrice;
    }

    public String getStorageNumber() {
        return storageNumber;
    }

    public void setStorageNumber(String storageNumber) {
        this.storageNumber = storageNumber;
    }

    public BigDecimal getbPrice() {
        return bPrice;
    }

    public void setbPrice(BigDecimal bPrice) {
        this.bPrice = bPrice;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRukuTime() {
        return rukuTime;
    }

    public void setRukuTime(String rukuTime) {
        this.rukuTime = rukuTime;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    private static final long serialVersionUID = 1L;


    public Integer getStorageGoodsId() {
        return storageGoodsId;
    }


    public void setStorageGoodsId(Integer storageGoodsId) {
        this.storageGoodsId = storageGoodsId;
    }


    public Integer getStorageAccessId() {
        return storageAccessId;
    }


    public void setStorageAccessId(Integer storageAccessId) {
        this.storageAccessId = storageAccessId;
    }


    public Integer getGoodsId() {
        return goodsId;
    }


    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }


    public BigDecimal getQuantity() {
        return quantity;
    }


    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }





}