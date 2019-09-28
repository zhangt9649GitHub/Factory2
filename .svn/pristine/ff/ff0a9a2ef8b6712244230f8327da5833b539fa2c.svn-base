package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "郝腾")
public class ProductionInstruction implements Serializable {

    @ApiModelProperty(value = "生产指示书id", example = "1")
    private Integer productionInstructionId;

    @ApiModelProperty(value = "生产指示书编号", example = "serialNumber")
    private String serialNumber;

    @ApiModelProperty(value = "状态 1.已创建  2.部分完成 3.已完成", example = "1")
    private Byte state;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    private static final long serialVersionUID = 1L;


    public Integer getProductionInstructionId() {
        return productionInstructionId;
    }


    public void setProductionInstructionId(Integer productionInstructionId) {
        this.productionInstructionId = productionInstructionId;
    }


    public String getSerialNumber() {
        return serialNumber;
    }


    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productionInstructionId=").append(productionInstructionId);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}