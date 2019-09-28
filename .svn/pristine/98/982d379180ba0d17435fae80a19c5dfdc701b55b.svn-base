package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 张婷
 * @date 2019/6/29 16:22
 */

@ApiModel(description = "张婷")
public class WarehouseDto {

    //仓库模糊查询需要的数据

    @ApiModelProperty(value = "仓库id", example = "1")
    private Integer warehouseId;

    @ApiModelProperty(value = "仓库名称", example = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "状态 1.表示空闲 2.表示使用中", example = "1")
    private Integer state;

    @ApiModelProperty(value = "备注", example = "备注")
    private String comment;

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

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "WarehouseDto{" +
                "warehouseId=" + warehouseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", staffId=" + staffId +
                ", state=" + state +
                ", comment='" + comment + '\'' +
                '}';
    }
}
