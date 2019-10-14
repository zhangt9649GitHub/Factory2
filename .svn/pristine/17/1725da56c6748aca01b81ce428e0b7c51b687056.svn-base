package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 角色员工工资单信息类
 */
@ApiModel(description = "郝腾")
public class StaffPayroll implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "工号", example = "12")
    private String jobNumber;

    @ApiModelProperty(value = "姓名", example = "小王")
    private String name;

    @ApiModelProperty(value = "保险公司", example = "insuranceCompany")
    private String insuranceCompany;

    @ApiModelProperty(value = "支付劳动局管理费", example = "1")
    private BigDecimal managementFee;

    @ApiModelProperty(value = "伙食扣款", example = "1")
    private BigDecimal foodDeduction;

    @ApiModelProperty(value = "保险扣款", example = "1")
    private BigDecimal InsuranceDeduction;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public BigDecimal getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(BigDecimal managementFee) {
        this.managementFee = managementFee;
    }

    public BigDecimal getFoodDeduction() {
        return foodDeduction;
    }

    public void setFoodDeduction(BigDecimal foodDeduction) {
        this.foodDeduction = foodDeduction;
    }

    public BigDecimal getInsuranceDeduction() {
        return InsuranceDeduction;
    }

    public void setInsuranceDeduction(BigDecimal insuranceDeduction) {
        InsuranceDeduction = insuranceDeduction;
    }

    @Override
    public String toString() {
        return "StaffPayroll{" +
                "staffId=" + staffId +
                ", jobNumber='" + jobNumber + '\'' +
                ", name='" + name + '\'' +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", managementFee=" + managementFee +
                ", foodDeduction=" + foodDeduction +
                '}';
    }
}
