package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
@ApiModel(description = "郝腾")
public class ProductionInstructionGoodsDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产指示书编号", example = "serialNumber")
    private String serialNumber;

    @ApiModelProperty(value = "品名", example = "goodsName")
    private String productName;

    @ApiModelProperty(value = "部品CD", example = "partsCd")
    private String partsCd;

    @ApiModelProperty(value = "连接No", example = "connectionNo")
    private String connectionNo;

    @ApiModelProperty(value = "父No", example = "parentNo")
    private String parentNo;

    @ApiModelProperty(value = "品种", example = "variety")
    private String variety;

    @ApiModelProperty(value = "生产预定数", example = "1")
    private BigDecimal productionSchedule;

    @ApiModelProperty(value = "单位 ", example = "unit")
    private String unit;

    @ApiModelProperty(value = "状态 1.已创建  2.部分完成 3.已完成", example = "1")
    private Byte state;

    @ApiModelProperty(value = "生产指示书id", example = "1")
    private Integer productionInstructionId;

    @ApiModelProperty(value = "货物类别", example = "1")
    private Byte category;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPartsCd() {
        return partsCd;
    }

    public void setPartsCd(String partsCd) {
        this.partsCd = partsCd;
    }

    public String getConnectionNo() {
        return connectionNo;
    }

    public void setConnectionNo(String connectionNo) {
        this.connectionNo = connectionNo;
    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public BigDecimal getProductionSchedule() {
        return productionSchedule;
    }

    public void setProductionSchedule(BigDecimal productionSchedule) {
        this.productionSchedule = productionSchedule;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getProductionInstructionId() {
        return productionInstructionId;
    }

    public void setProductionInstructionId(Integer productionInstructionId) {
        this.productionInstructionId = productionInstructionId;
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductionInstructionGoodsDto{" +
                "serialNumber='" + serialNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", partsCd='" + partsCd + '\'' +
                ", connectionNo='" + connectionNo + '\'' +
                ", parentNo='" + parentNo + '\'' +
                ", variety='" + variety + '\'' +
                ", productionSchedule=" + productionSchedule +
                ", unit='" + unit + '\'' +
                ", state=" + state +
                '}';
    }
}
