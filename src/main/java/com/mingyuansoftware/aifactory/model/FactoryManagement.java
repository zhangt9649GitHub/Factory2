package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "张婷")
public class FactoryManagement implements Serializable {

    @ApiModelProperty(value = "所属工厂管理Id", example = "1")
    private Integer fmId;

    @ApiModelProperty(value = "工厂名称", example = "fName")
    private String fName;

    @ApiModelProperty(value = "伙食扣款", example = "0.00")
    private BigDecimal foodDeduction;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除 0.否 1是", example = "0")
    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getFmId() {
        return fmId;
    }

    public void setFmId(Integer fmId) {
        this.fmId = fmId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public BigDecimal getFoodDeduction() {
        return foodDeduction;
    }

    public void setFoodDeduction(BigDecimal foodDeduction) {
        this.foodDeduction = foodDeduction;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fmId=").append(fmId);
        sb.append(", fName=").append(fName);
        sb.append(", foodDeduction=").append(foodDeduction);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}