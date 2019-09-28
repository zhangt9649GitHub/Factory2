package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "郝腾")
public class ProductionEntry implements Serializable {

    @ApiModelProperty(value = "生产入库单id", example = "1")
    private Integer productionEntryId;

    @ApiModelProperty(value = "生产入库单编号", example = "productionEntryNumber")
    private String productionEntryNumber;

    @ApiModelProperty(value = "工号", example = "jobNumber")
    private String jobNumber;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "仓库id", example = "1")
    private Integer warehouseId;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "批号", example = "lotNumber")
    private String lotNumber;

    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "仓库", example = "warehouseName")
    private String warehouseName;


    private static final long serialVersionUID = 1L;


    public Integer getProductionEntryId() {
        return productionEntryId;
    }


    public void setProductionEntryId(Integer productionEntryId) {
        this.productionEntryId = productionEntryId;
    }


    public String getProductionEntryNumber() {
        return productionEntryNumber;
    }


    public void setProductionEntryNumber(String productionEntryNumber) {
        this.productionEntryNumber = productionEntryNumber == null ? null : productionEntryNumber.trim();
    }


    public String getJobNumber() {
        return jobNumber;
    }


    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }


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


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }


    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getLotNumber() {
        return lotNumber;
    }


    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber == null ? null : lotNumber.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productionEntryId=").append(productionEntryId);
        sb.append(", productionEntryNumber=").append(productionEntryNumber);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", staffId=").append(staffId);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", comment=").append(comment);
        sb.append(", addTime=").append(addTime);
        sb.append(", lotNumber=").append(lotNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}