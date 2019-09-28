package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 仓位列表
 *
 * @author 张婷
 * @date 2019/6/27 16:26
 */
@ApiModel(description = "张婷")
public class WarehousePositionDto {
    @ApiModelProperty(value = "仓位id", example = "1")
    private Integer wpId;

    @ApiModelProperty(value = "仓位名称", example = "仓位名称")
    private String wpName;

    @ApiModelProperty(value = "仓库id", example = "1")
    private Integer warehouseId;

    @ApiModelProperty(value = "仓库名称", example = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "状态 1.表示空闲 2.表示使用中", example = "1")
    private Byte state;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private String createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "备注", example = "备注")
    private String comment;

    @ApiModelProperty(value = "删除状态 1.表示删除 0.表示未删除", example = "0")
    private Byte isDelete;

    public Integer getWpId() {
        return wpId;
    }

    public void setWpId(Integer wpId) {
        this.wpId = wpId;
    }

    public String getWpName() {
        return wpName;
    }

    public void setWpName(String wpName) {
        this.wpName = wpName;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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
        this.comment = comment;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }


}
