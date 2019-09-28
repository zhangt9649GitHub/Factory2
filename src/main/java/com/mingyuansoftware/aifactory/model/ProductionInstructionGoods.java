package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(description = "郝腾")
public class ProductionInstructionGoods implements Serializable {

    @ApiModelProperty(value = "生产指示书货物id", example = "1")
    private Integer productionInstructionGoodsId;

    @ApiModelProperty(value = "生产指示书id", example = "1")
    private Integer productionInstructionId;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "部品CD", example = "1")
    private String partsCd;

    @ApiModelProperty(value = "品名", example = "1")
    private String productName;

    @ApiModelProperty(value = "连接No", example = "connectionNo")
    private String connectionNo;

    @ApiModelProperty(value = "父No", example = "parentNo")
    private String parentNo;

    @ApiModelProperty(value = "品种", example = "variety")
    private String variety;

    @ApiModelProperty(value = "生产预定数", example = "1")
    private BigDecimal productionSchedule;

    @ApiModelProperty(value = "返品数量", example = "1")
    private Integer returnQuantity;

    @ApiModelProperty(value = "单位 ", example = "unit")
    private String unit;

    @ApiModelProperty(value = "多少箱/1捆 ", example = "1")
    private Integer boxesNumber;

    @ApiModelProperty(value = "多少个/1箱 ", example = "1")
    private Integer number;

    @ApiModelProperty(value = "备注 ", example = "comment")
    private String comment;

    @ApiModelProperty(value = "生产指示书详情集合 ", example = "productionInstructionDetailList")
    private List<ProductionInstructionDetail> productionInstructionDetailList;

    @ApiModelProperty(value = "未完成数量", example = "1")
    private BigDecimal unfinishedQuantity;

    @ApiModelProperty(value = "完成数量", example = "1")
    private BigDecimal finishedQuantity;

    @ApiModelProperty(value = "品种值", example = "1")
    private Integer varietyValue;

    @ApiModelProperty(value = "货物品种类", example = "goodsVariety")
    private GoodsVariety goodsVariety;

    @ApiModelProperty(value = "生产指示书编号", example = "serialNumber")
    private String serialNumber;

    @ApiModelProperty(value = "状态 1.已创建  2.部分完成 3.已完成", example = "1")
    private Byte state;

    private static final long serialVersionUID = 1L;


    public Integer getProductionInstructionGoodsId() {
        return productionInstructionGoodsId;
    }


    public void setProductionInstructionGoodsId(Integer productionInstructionGoodsId) {
        this.productionInstructionGoodsId = productionInstructionGoodsId;
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
        this.partsCd = partsCd == null ? null : partsCd.trim();
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }


    public String getConnectionNo() {
        return connectionNo;
    }


    public void setConnectionNo(String connectionNo) {
        this.connectionNo = connectionNo == null ? null : connectionNo.trim();
    }


    public String getParentNo() {
        return parentNo;
    }


    public void setParentNo(String parentNo) {
        this.parentNo = parentNo == null ? null : parentNo.trim();
    }


    public String getVariety() {
        return variety;
    }


    public void setVariety(String variety) {
        this.variety = variety == null ? null : variety.trim();
    }


    public BigDecimal getProductionSchedule() {
        return productionSchedule;
    }


    public void setProductionSchedule(BigDecimal productionSchedule) {
        this.productionSchedule = productionSchedule;
    }


    public Integer getReturnQuantity() {
        return returnQuantity;
    }


    public void setReturnQuantity(Integer returnQuantity) {
        this.returnQuantity = returnQuantity;
    }


    public String getUnit() {
        return unit;
    }


    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }


    public Integer getBoxesNumber() {
        return boxesNumber;
    }


    public void setBoxesNumber(Integer boxesNumber) {
        this.boxesNumber = boxesNumber;
    }


    public Integer getNumber() {
        return number;
    }


    public void setNumber(Integer number) {
        this.number = number;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public List<ProductionInstructionDetail> getProductionInstructionDetailList() {
        return productionInstructionDetailList;
    }

    public void setProductionInstructionDetailList(List<ProductionInstructionDetail> productionInstructionDetailList) {
        this.productionInstructionDetailList = productionInstructionDetailList;
    }

    public BigDecimal getUnfinishedQuantity() {
        return unfinishedQuantity;
    }

    public void setUnfinishedQuantity(BigDecimal unfinishedQuantity) {
        this.unfinishedQuantity = unfinishedQuantity;
    }

    public BigDecimal getFinishedQuantity() {
        return finishedQuantity;
    }

    public void setFinishedQuantity(BigDecimal finishedQuantity) {
        this.finishedQuantity = finishedQuantity;
    }

    public Integer getVarietyValue() {
        return varietyValue;
    }

    public void setVarietyValue(Integer varietyValue) {
        this.varietyValue = varietyValue;
    }

    public GoodsVariety getGoodsVariety() {
        return goodsVariety;
    }

    public void setGoodsVariety(GoodsVariety goodsVariety) {
        this.goodsVariety = goodsVariety;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productionInstructionGoodsId=").append(productionInstructionGoodsId);
        sb.append(", productionInstructionId=").append(productionInstructionId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", partsCd=").append(partsCd);
        sb.append(", productName=").append(productName);
        sb.append(", connectionNo=").append(connectionNo);
        sb.append(", parentNo=").append(parentNo);
        sb.append(", variety=").append(variety);
        sb.append(", productionSchedule=").append(productionSchedule);
        sb.append(", returnQuantity=").append(returnQuantity);
        sb.append(", unit=").append(unit);
        sb.append(", boxesNumber=").append(boxesNumber);
        sb.append(", number=").append(number);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}