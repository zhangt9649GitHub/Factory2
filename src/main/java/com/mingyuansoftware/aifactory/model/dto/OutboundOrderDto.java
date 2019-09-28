package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "郝腾")
public class OutboundOrderDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出库单编号", example = "outboundOrderNumber")
    private String outboundOrderNumber;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "出库类型", example = "type")
    private String type;

    @ApiModelProperty(value = "仓库", example = "warehouseName")
    private String warehouseName;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    public String getOutboundOrderNumber() {
        return outboundOrderNumber;
    }

    public void setOutboundOrderNumber(String outboundOrderNumber) {
        this.outboundOrderNumber = outboundOrderNumber;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "OutboundOrderDto{" +
                "outboundOrderNumber='" + outboundOrderNumber + '\'' +
                ", addTime='" + addTime + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
