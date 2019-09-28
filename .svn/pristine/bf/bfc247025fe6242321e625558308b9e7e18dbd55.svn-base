package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel(description = "郝腾")
public class PayrollDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工资单编号", example = "1")
    private String payrollNumber;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "姓名", example = "小王")
    private String name;

    @ApiModelProperty(value = "开始时间", example = "startTime")
    private String startTime;

    @ApiModelProperty(value = "结束时间", example = "endTime")
    private String endTime;

    @ApiModelProperty(value = "状态 1.已创建 2.已审核 3.已付款", example = "1")
    private Byte state;

    @ApiModelProperty(value = "付款时间", example = "paymentTime")
    private String paymentTime;

    public String getPayrollNumber() {
        return payrollNumber;
    }

    public void setPayrollNumber(String payrollNumber) {
        this.payrollNumber = payrollNumber;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public String toString() {
        return "PayrollDto{" +
                "payrollNumber='" + payrollNumber + '\'' +
                ", addTime='" + addTime + '\'' +
                ", name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", state=" + state +
                ", paymentTime='" + paymentTime + '\'' +
                '}';
    }
}
