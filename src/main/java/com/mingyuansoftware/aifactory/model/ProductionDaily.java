package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 生产日报
 */
@ApiModel(description = "郝腾")
public class ProductionDaily  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal amount;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "生产入库单编号", example = "productionEntryNumber")
    private String productionEntryNumber;

    @ApiModelProperty(value = "工号", example = "jobNumber")
    private String jobNumber;

    @ApiModelProperty(value = "姓名", example = "小王")
    private String name;

    @ApiModelProperty(value = "机器编号", example = "machinaryCode")
    private String machinaryCode;

    @ApiModelProperty(value = "多少个/1箱", example = "1")
    private Integer boxesNumber;

    @ApiModelProperty(value = "工资 货物的工资单价*数量", example = "1")
    private BigDecimal salary;

    @ApiModelProperty(value = "生产指示书编号", example = "serialNumber")
    private String serialNumber;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getProductionEntryNumber() {
        return productionEntryNumber;
    }

    public void setProductionEntryNumber(String productionEntryNumber) {
        this.productionEntryNumber = productionEntryNumber;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "ProductionDaily{" +
                "partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", amount=" + amount +
                ", addTime='" + addTime + '\'' +
                ", productionEntryNumber='" + productionEntryNumber + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", name='" + name + '\'' +
                ", machinaryCode='" + machinaryCode + '\'' +
                ", boxesNumber=" + boxesNumber +
                ", salary=" + salary +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
