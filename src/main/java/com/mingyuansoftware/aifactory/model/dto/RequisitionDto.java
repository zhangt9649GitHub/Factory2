package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "郝腾")
public class RequisitionDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "调拨单编号", example = "requisitionNumber")
    private String requisitionNumber;

    @ApiModelProperty(value = "创建时间", example = "addtime")
    private String addtime;

    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "调入仓库", example = "intoWarehouseName")
    private String intoWarehouseName;

    @ApiModelProperty(value = "调出仓库", example = "outWarehouseName")
    private String outWarehouseName;

    @ApiModelProperty(value = "调拨类型", example = "type")
    private String type;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;



    public String getRequisitionNumber() {
        return requisitionNumber;
    }

    public void setRequisitionNumber(String requisitionNumber) {
        this.requisitionNumber = requisitionNumber;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntoWarehouseName() {
        return intoWarehouseName;
    }

    public void setIntoWarehouseName(String intoWarehouseName) {
        this.intoWarehouseName = intoWarehouseName;
    }

    public String getOutWarehouseName() {
        return outWarehouseName;
    }

    public void setOutWarehouseName(String outWarehouseName) {
        this.outWarehouseName = outWarehouseName;
    }

    @Override
    public String toString() {
        return "RequisitionDto{" +
                "requisitionNumber='" + requisitionNumber + '\'' +
                ", addtime='" + addtime + '\'' +
                ", name='" + name + '\'' +
                ", intoWarehouseName='" + intoWarehouseName + '\'' +
                ", outWarehouseName='" + outWarehouseName + '\'' +
                ", type='" + type + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
