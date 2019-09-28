package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "郝腾")
public class ProductionInstructionDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产指示书编号", example = "serialNumber")
    private String serialNumber;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private String createTime;

    @ApiModelProperty(value = "状态 1.已创建  2.部分完成 3.已完成", example = "1")
    private Byte state;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ProductionInstructionDto{" +
                "serialNumber='" + serialNumber + '\'' +
                ", createTime='" + createTime + '\'' +
                ", state=" + state +
                '}';
    }
}
