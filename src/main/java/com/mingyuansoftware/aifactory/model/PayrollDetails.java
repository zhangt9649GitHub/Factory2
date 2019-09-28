package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "郝腾")
public class PayrollDetails implements Serializable {

    @ApiModelProperty(value = "工资详情表id", example = "1")
    private Integer payrollDetailsId;

    @ApiModelProperty(value = "姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "作业证No", example = "operationPermitNo")
    private String operationPermitNo;

    @ApiModelProperty(value = "出勤天数", example = "1")
    private Float attendanceDays;

    @ApiModelProperty(value = "保险公司", example = "insuranceCompany")
    private String insuranceCompany;

    @ApiModelProperty(value = "管理费", example = "1")
    private BigDecimal managementFee;

    @ApiModelProperty(value = "基本工资/计时工资", example = "1")
    private BigDecimal basicTiming;

    @ApiModelProperty(value = "基本工资/计件工资", example = "1")
    private BigDecimal basicWage;

    @ApiModelProperty(value = "奖金/加班/津贴", example = "1")
    private BigDecimal subsidy;

    @ApiModelProperty(value = "件数", example = "1")
    private Integer pieces;

    @ApiModelProperty(value = "奖金", example = "1")
    private BigDecimal bonus;

    @ApiModelProperty(value = "职能评价", example = "evaluation")
    private String evaluation;

    @ApiModelProperty(value = "岗位津贴", example = "1")
    private BigDecimal postAllowance;

    @ApiModelProperty(value = "工资小计", example = "1")
    private BigDecimal subtotalWage;

    @ApiModelProperty(value = "伙食扣款", example = "1")
    private BigDecimal foodDeduction;

    @ApiModelProperty(value = "天津工厂扣款", example = "1")
    private BigDecimal tjFactoryDeduction;

    @ApiModelProperty(value = "公积金扣款", example = "1")
    private BigDecimal providentFundDeduction;

    @ApiModelProperty(value = "保险扣款", example = "1")
    private BigDecimal insuranceDeduction;

    @ApiModelProperty(value = "扣款小计", example = "1")
    private BigDecimal subtotalDeduction;

    @ApiModelProperty(value = "应得", example = "1")
    private BigDecimal deserve;

    @ApiModelProperty(value = "采暖费", example = "1")
    private BigDecimal heatingFee;

    @ApiModelProperty(value = "个人所得税", example = "1")
    private BigDecimal personalIncomeTax;

    @ApiModelProperty(value = "实得", example = "1")
    private BigDecimal realize;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "工资单id", example = "1")
    private Integer payrollId;

    @ApiModelProperty(value = "待扣代缴保险", example = "1")
    private BigDecimal withholdingInsurance;

    @ApiModelProperty(value = "公积金", example = "1")
    private BigDecimal accumulationFund;

    @ApiModelProperty(value = "补贴", example = "1")
    private BigDecimal subsidies;

    private static final long serialVersionUID = 1L;

    public Integer getPayrollDetailsId() {
        return payrollDetailsId;
    }

    public void setPayrollDetailsId(Integer payrollDetailsId) {
        this.payrollDetailsId = payrollDetailsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOperationPermitNo() {
        return operationPermitNo;
    }

    public void setOperationPermitNo(String operationPermitNo) {
        this.operationPermitNo = operationPermitNo == null ? null : operationPermitNo.trim();
    }

    public Float getAttendanceDays() {
        return attendanceDays;
    }

    public void setAttendanceDays(Float attendanceDays) {
        this.attendanceDays = attendanceDays;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany == null ? null : insuranceCompany.trim();
    }

    public BigDecimal getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(BigDecimal managementFee) {
        this.managementFee = managementFee;
    }

    public BigDecimal getBasicTiming() {
        return basicTiming;
    }

    public void setBasicTiming(BigDecimal basicTiming) {
        this.basicTiming = basicTiming;
    }

    public BigDecimal getBasicWage() {
        return basicWage;
    }

    public void setBasicWage(BigDecimal basicWage) {
        this.basicWage = basicWage;
    }

    public BigDecimal getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(BigDecimal subsidy) {
        this.subsidy = subsidy;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation == null ? null : evaluation.trim();
    }

    public BigDecimal getPostAllowance() {
        return postAllowance;
    }

    public void setPostAllowance(BigDecimal postAllowance) {
        this.postAllowance = postAllowance;
    }

    public BigDecimal getSubtotalWage() {
        return subtotalWage;
    }

    public void setSubtotalWage(BigDecimal subtotalWage) {
        this.subtotalWage = subtotalWage;
    }

    public BigDecimal getFoodDeduction() {
        return foodDeduction;
    }

    public void setFoodDeduction(BigDecimal foodDeduction) {
        this.foodDeduction = foodDeduction;
    }

    public BigDecimal getTjFactoryDeduction() {
        return tjFactoryDeduction;
    }

    public void setTjFactoryDeduction(BigDecimal tjFactoryDeduction) {
        this.tjFactoryDeduction = tjFactoryDeduction;
    }

    public BigDecimal getProvidentFundDeduction() {
        return providentFundDeduction;
    }

    public void setProvidentFundDeduction(BigDecimal providentFundDeduction) {
        this.providentFundDeduction = providentFundDeduction;
    }

    public BigDecimal getInsuranceDeduction() {
        return insuranceDeduction;
    }

    public void setInsuranceDeduction(BigDecimal insuranceDeduction) {
        this.insuranceDeduction = insuranceDeduction;
    }

    public BigDecimal getSubtotalDeduction() {
        return subtotalDeduction;
    }

    public void setSubtotalDeduction(BigDecimal subtotalDeduction) {
        this.subtotalDeduction = subtotalDeduction;
    }

    public BigDecimal getDeserve() {
        return deserve;
    }

    public void setDeserve(BigDecimal deserve) {
        this.deserve = deserve;
    }

    public BigDecimal getHeatingFee() {
        return heatingFee;
    }

    public void setHeatingFee(BigDecimal heatingFee) {
        this.heatingFee = heatingFee;
    }

    public BigDecimal getPersonalIncomeTax() {
        return personalIncomeTax;
    }

    public void setPersonalIncomeTax(BigDecimal personalIncomeTax) {
        this.personalIncomeTax = personalIncomeTax;
    }

    public BigDecimal getRealize() {
        return realize;
    }

    public void setRealize(BigDecimal realize) {
        this.realize = realize;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(Integer payrollId) {
        this.payrollId = payrollId;
    }

    public BigDecimal getWithholdingInsurance() {
        return withholdingInsurance;
    }

    public void setWithholdingInsurance(BigDecimal withholdingInsurance) {
        this.withholdingInsurance = withholdingInsurance;
    }

    public BigDecimal getAccumulationFund() {
        return accumulationFund;
    }

    public void setAccumulationFund(BigDecimal accumulationFund) {
        this.accumulationFund = accumulationFund;
    }

    public BigDecimal getSubsidies() {
        return subsidies;
    }

    public void setSubsidies(BigDecimal subsidies) {
        this.subsidies = subsidies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", payrollDetailsId=").append(payrollDetailsId);
        sb.append(", name=").append(name);
        sb.append(", operationPermitNo=").append(operationPermitNo);
        sb.append(", attendanceDays=").append(attendanceDays);
        sb.append(", insuranceCompany=").append(insuranceCompany);
        sb.append(", managementFee=").append(managementFee);
        sb.append(", basicWage=").append(basicWage);
        sb.append(", subsidy=").append(subsidy);
        sb.append(", pieces=").append(pieces);
        sb.append(", bonus=").append(bonus);
        sb.append(", evaluation=").append(evaluation);
        sb.append(", postAllowance=").append(postAllowance);
        sb.append(", subtotalWage=").append(subtotalWage);
        sb.append(", foodDeduction=").append(foodDeduction);
        sb.append(", tjFactoryDeduction=").append(tjFactoryDeduction);
        sb.append(", providentFundDeduction=").append(providentFundDeduction);
        sb.append(", insuranceDeduction=").append(insuranceDeduction);
        sb.append(", subtotalDeduction=").append(subtotalDeduction);
        sb.append(", deserve=").append(deserve);
        sb.append(", heatingFee=").append(heatingFee);
        sb.append(", personalIncomeTax=").append(personalIncomeTax);
        sb.append(", realize=").append(realize);
        sb.append(", comment=").append(comment);
        sb.append(", staffId=").append(staffId);
        sb.append(", payrollId=").append(payrollId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}