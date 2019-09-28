package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 完成品
 */
@ApiModel(description = "郝腾")
public class FinishedProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "对应完成品", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "任务量", example = "1")
    private BigDecimal taskAmount;

    @ApiModelProperty(value = "成型周期", example = "1")
    private BigDecimal cycle;

    @ApiModelProperty(value = "所需班次", example = "1")
    private BigDecimal shift;

    @ApiModelProperty(value = "对应成品在库量", example = "1")
    private BigDecimal finishedAmount;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getTaskAmount() {
        return taskAmount;
    }

    public void setTaskAmount(BigDecimal taskAmount) {
        this.taskAmount = taskAmount;
    }

    public BigDecimal getCycle() {
        return cycle;
    }

    public void setCycle(BigDecimal cycle) {
        this.cycle = cycle;
    }

    public BigDecimal getShift() {
        return shift;
    }

    public void setShift(BigDecimal shift) {
        this.shift = shift;
    }

    public BigDecimal getFinishedAmount() {
        return finishedAmount;
    }

    public void setFinishedAmount(BigDecimal finishedAmount) {
        this.finishedAmount = finishedAmount;
    }

    @Override
    public String toString() {
        return "FinishedProduct{" +
                "goodsName='" + goodsName + '\'' +
                ", taskAmount=" + taskAmount +
                ", cycle=" + cycle +
                ", shift=" + shift +
                '}';
    }
}
