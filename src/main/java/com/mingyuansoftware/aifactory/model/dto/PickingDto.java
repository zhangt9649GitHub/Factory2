package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "郝腾")
public class PickingDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "领料单编号", example = "pickingNumber")
    private String pickingNumber;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "入仓库", example = "intoWarehouseName")
    private String intoWarehouseName;

    @ApiModelProperty(value = "出仓库", example = "outWarehouseName")
    private String outWarehouseName;

    @ApiModelProperty(value = "状态  1.已创建 2.已领料 3.已确认", example = "1")
    private Byte state;

    public String getPickingNumber() {
        return pickingNumber;
    }

    public void setPickingNumber(String pickingNumber) {
        this.pickingNumber = pickingNumber;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "PickingDto{" +
                "pickingNumber='" + pickingNumber + '\'' +
                ", addTime='" + addTime + '\'' +
                ", name='" + name + '\'' +
                ", intoWarehouseName='" + intoWarehouseName + '\'' +
                ", outWarehouseName='" + outWarehouseName + '\'' +
                ", state=" + state +
                '}';
    }
}
