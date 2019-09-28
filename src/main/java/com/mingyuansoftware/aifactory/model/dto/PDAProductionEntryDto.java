package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "郝腾")
public class PDAProductionEntryDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "仓库id", example = "1")
    private Integer warehouseId;

    @ApiModelProperty(value = "仓库", example = "warehouseName")
    private String warehouseName;

    @ApiModelProperty(value = "排产单id", example = "1")
    private Integer poId;


    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "货物入库数量", example = "1")
    private BigDecimal amount;

    @ApiModelProperty(value = "机器编号", example = "machinaryCode")
    private String machinaryCode;

    @ApiModelProperty(value = "箱数", example = "1")
    private Integer boxesNumber;


    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getPoId() {
        return poId;
    }

    public void setPoId(Integer poId) {
        this.poId = poId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMachinaryCode() {
        return machinaryCode;
    }

    public void setMachinaryCode(String machinaryCode) {
        this.machinaryCode = machinaryCode;
    }

    public Integer getBoxesNumber() {
        return boxesNumber;
    }

    public void setBoxesNumber(Integer boxesNumber) {
        this.boxesNumber = boxesNumber;
    }

    @Override
    public String toString() {
        return "PDAProductionEntryDto{" +
                "staffId=" + staffId +
                ", warehouseId=" + warehouseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", poId=" + poId +
                ", goodsId=" + goodsId +
                ", amount=" + amount +
                ", machinaryCode='" + machinaryCode + '\'' +
                '}';
    }
}
