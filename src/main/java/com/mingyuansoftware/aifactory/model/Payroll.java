package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(description = "郝腾")
public class Payroll implements Serializable {

    @ApiModelProperty(value = "工资表id", example = "1")
    private Integer payrollId;

    @ApiModelProperty(value = "工资单编号", example = "1")
    private String payrollNumber;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "开始时间", example = "startTime")
    private String startTime;

    @ApiModelProperty(value = "结束时间", example = "endTime")
    private String endTime;

    @ApiModelProperty(value = "状态 1.已创建 2.已审核 3.已付款", example = "1")
    private Byte state;

    @ApiModelProperty(value = "付款时间", example = "paymentTime")
    private Date paymentTime;

    @ApiModelProperty(value = "是否删除 1是 0否", example = "0")
    private Byte isDelete;

    @ApiModelProperty(value = "姓名", example = "小王")
    private String name;

    @ApiModelProperty(value = "员工", example = "staff")
    private Staff staff;

    @ApiModelProperty(value = "工资单详情集合", example = "payrollDetailsList")
    private List<PayrollDetails> payrollDetailsList;

    @ApiModelProperty(value = "工资合计", example = "totalWages")
    private BigDecimal totalWages;

    @ApiModelProperty(value = "数据字典id 记录角色", example = "1")
    private Integer bizId;

    @ApiModelProperty(value = "角色 ", example = "职员")
    private String role;

    private static final long serialVersionUID = 1L;

    public Integer getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(Integer payrollId) {
        this.payrollId = payrollId;
    }

    public String getPayrollNumber() {
        return payrollNumber;
    }

    public void setPayrollNumber(String payrollNumber) {
        this.payrollNumber = payrollNumber == null ? null : payrollNumber.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PayrollDetails> getPayrollDetailsList() {
        return payrollDetailsList;
    }

    public void setPayrollDetailsList(List<PayrollDetails> payrollDetailsList) {
        this.payrollDetailsList = payrollDetailsList;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public BigDecimal getTotalWages() {
        return totalWages;
    }

    public void setTotalWages(BigDecimal totalWages) {
        this.totalWages = totalWages;
    }

    public Integer getBizId() {
        return bizId;
    }

    public void setBizId(Integer bizId) {
        this.bizId = bizId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", payrollId=").append(payrollId);
        sb.append(", payrollNumber=").append(payrollNumber);
        sb.append(", addTime=").append(addTime);
        sb.append(", staffId=").append(staffId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", state=").append(state);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}