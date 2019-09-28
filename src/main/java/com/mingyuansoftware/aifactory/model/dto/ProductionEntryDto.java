package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "郝腾")
public class ProductionEntryDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产入库单编号", example = "productionEntryNumber")
    private String productionEntryNumber;

    @ApiModelProperty(value = "工号", example = "jobNumber")
    private String jobNumber;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "仓库", example = "warehouseName")
    private String warehouseName;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ProductionEntryDto{" +
                "productionEntryNumber='" + productionEntryNumber + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", addTime='" + addTime + '\'' +
                ", name='" + name + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
