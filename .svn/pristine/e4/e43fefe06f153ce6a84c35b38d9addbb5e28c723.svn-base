package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 生产进度分析部分表头
 */
@ApiModel(description = "郝腾")
public class ProductionProcess implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日期", example = "createTime")
    private String createTime;

    @ApiModelProperty(value = "状态 1.已创建  2.部分完成 3.已完成", example = "1")
    private Byte state;

    @ApiModelProperty(value = "生产指示书编号", example = "serialNumber")
    private String serialNumber;

    @ApiModelProperty(value = "排序字段", example = "1")
    private Integer order;


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        createTime = createTime.substring(0,7);
        this.createTime = createTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ProductionProcess{" +
                "createTime='" + createTime + '\'' +
                ", state=" + state +
                ", serialNumber='" + serialNumber + '\'' +
                ", order=" + order +
                '}';
    }
}
