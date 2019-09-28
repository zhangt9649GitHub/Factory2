package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "张婷")
public class Warehouse implements Serializable {
    @ApiModelProperty(value = "仓库id", example = "1")
    private Integer warehouseId;

    @ApiModelProperty(value = "仓库名称", example = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "员工名称", example = "员工名称")
    private String name;

    @ApiModelProperty(value = "仓库状态 1.表示空闲 2.表示使用中", example = "1")
    private Byte state;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "备注", example = "备注")
    private String comment;

    @ApiModelProperty(value = "删除状态 1.表示删除 0.表示未删除", example = "0")
    private Byte isDelete;


    private static final long serialVersionUID = 1L;

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }


    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }


    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId=" + warehouseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", staffId=" + staffId +
                ", name=" + name +
                ", state=" + state +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", comment='" + comment + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}