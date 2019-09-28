package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
@ApiModel(description = "郝腾")
public class StaffInsurance implements Serializable {

    @ApiModelProperty(value = "保险id", example = "1")
    private Integer insuranceId;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "个人保险补助", example = "1")
    private BigDecimal personalInsuranceBenefits;

    @ApiModelProperty(value = "个人养老保险", example = "1")
    private BigDecimal personalEndowmentInsurance;

    @ApiModelProperty(value = "个人医疗保险", example = "1")
    private BigDecimal personalMedicalInsurance;

    @ApiModelProperty(value = "个人失业保险", example = "1")
    private BigDecimal personalUnemploymentInsurance;

    @ApiModelProperty(value = "个人社保合计", example = "1")
    private BigDecimal personalInsuranceTotal;

    @ApiModelProperty(value = "个人公积金", example = "1")
    private BigDecimal personalAccumulationFund;

    @ApiModelProperty(value = "个人社保公积金合计", example = "1")
    private BigDecimal personalTotalIndividual;

    @ApiModelProperty(value = "单位养老保险", example = "1")
    private BigDecimal companyEndowmentInsurance;

    @ApiModelProperty(value = "单位医疗保险", example = "1")
    private BigDecimal companyMedicalInsurance;

    @ApiModelProperty(value = "单位失业保险", example = "1")
    private BigDecimal companyUnemploymentInsurance;

    @ApiModelProperty(value = "单位工伤保险", example = "1")
    private BigDecimal inductrialInjuryInsurance;

    @ApiModelProperty(value = "单位生育保险", example = "1")
    private BigDecimal fertilityInsurance;

    @ApiModelProperty(value = "单位社保合计", example = "1")
    private BigDecimal companyInsuranceTotal;

    @ApiModelProperty(value = "单位公积金", example = "1")
    private BigDecimal companyAccumulationFund;

    @ApiModelProperty(value = "单位社保公积金合计", example = "1")
    private BigDecimal companyTotalIndividual;

    private static final long serialVersionUID = 1L;

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public BigDecimal getPersonalInsuranceBenefits() {
        return personalInsuranceBenefits;
    }

    public void setPersonalInsuranceBenefits(BigDecimal personalInsuranceBenefits) {
        this.personalInsuranceBenefits = personalInsuranceBenefits;
    }

    public BigDecimal getPersonalEndowmentInsurance() {
        return personalEndowmentInsurance;
    }

    public void setPersonalEndowmentInsurance(BigDecimal personalEndowmentInsurance) {
        this.personalEndowmentInsurance = personalEndowmentInsurance;
    }

    public BigDecimal getPersonalMedicalInsurance() {
        return personalMedicalInsurance;
    }

    public void setPersonalMedicalInsurance(BigDecimal personalMedicalInsurance) {
        this.personalMedicalInsurance = personalMedicalInsurance;
    }

    public BigDecimal getPersonalUnemploymentInsurance() {
        return personalUnemploymentInsurance;
    }

    public void setPersonalUnemploymentInsurance(BigDecimal personalUnemploymentInsurance) {
        this.personalUnemploymentInsurance = personalUnemploymentInsurance;
    }

    public BigDecimal getPersonalInsuranceTotal() {
        return personalInsuranceTotal;
    }

    public void setPersonalInsuranceTotal(BigDecimal personalInsuranceTotal) {
        this.personalInsuranceTotal = personalInsuranceTotal;
    }

    public BigDecimal getPersonalAccumulationFund() {
        return personalAccumulationFund;
    }

    public void setPersonalAccumulationFund(BigDecimal personalAccumulationFund) {
        this.personalAccumulationFund = personalAccumulationFund;
    }

    public BigDecimal getPersonalTotalIndividual() {
        return personalTotalIndividual;
    }

    public void setPersonalTotalIndividual(BigDecimal personalTotalIndividual) {
        this.personalTotalIndividual = personalTotalIndividual;
    }

    public BigDecimal getCompanyEndowmentInsurance() {
        return companyEndowmentInsurance;
    }

    public void setCompanyEndowmentInsurance(BigDecimal companyEndowmentInsurance) {
        this.companyEndowmentInsurance = companyEndowmentInsurance;
    }

    public BigDecimal getCompanyMedicalInsurance() {
        return companyMedicalInsurance;
    }

    public void setCompanyMedicalInsurance(BigDecimal companyMedicalInsurance) {
        this.companyMedicalInsurance = companyMedicalInsurance;
    }

    public BigDecimal getCompanyUnemploymentInsurance() {
        return companyUnemploymentInsurance;
    }

    public void setCompanyUnemploymentInsurance(BigDecimal companyUnemploymentInsurance) {
        this.companyUnemploymentInsurance = companyUnemploymentInsurance;
    }

    public BigDecimal getInductrialInjuryInsurance() {
        return inductrialInjuryInsurance;
    }

    public void setInductrialInjuryInsurance(BigDecimal inductrialInjuryInsurance) {
        this.inductrialInjuryInsurance = inductrialInjuryInsurance;
    }

    public BigDecimal getFertilityInsurance() {
        return fertilityInsurance;
    }

    public void setFertilityInsurance(BigDecimal fertilityInsurance) {
        this.fertilityInsurance = fertilityInsurance;
    }

    public BigDecimal getCompanyAccumulationFund() {
        return companyAccumulationFund;
    }

    public void setCompanyAccumulationFund(BigDecimal companyAccumulationFund) {
        this.companyAccumulationFund = companyAccumulationFund;
    }

    public BigDecimal getCompanyTotalIndividual() {
        return companyTotalIndividual;
    }

    public void setCompanyTotalIndividual(BigDecimal companyTotalIndividual) {
        this.companyTotalIndividual = companyTotalIndividual;
    }

    public BigDecimal getCompanyInsuranceTotal() {
        return companyInsuranceTotal;
    }

    public void setCompanyInsuranceTotal(BigDecimal companyInsuranceTotal) {
        this.companyInsuranceTotal = companyInsuranceTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", insuranceId=").append(insuranceId);
        sb.append(", staffId=").append(staffId);
        sb.append(", personalInsuranceBenefits=").append(personalInsuranceBenefits);
        sb.append(", personalEndowmentInsurance=").append(personalEndowmentInsurance);
        sb.append(", personalMedicalInsurance=").append(personalMedicalInsurance);
        sb.append(", personalUnemploymentInsurance=").append(personalUnemploymentInsurance);
        sb.append(", personalInsuranceTotal=").append(personalInsuranceTotal);
        sb.append(", personalAccumulationFund=").append(personalAccumulationFund);
        sb.append(", personalTotalIndividual=").append(personalTotalIndividual);
        sb.append(", companyEndowmentInsurance=").append(companyEndowmentInsurance);
        sb.append(", companyMedicalInsurance=").append(companyMedicalInsurance);
        sb.append(", companyUnemploymentInsurance=").append(companyUnemploymentInsurance);
        sb.append(", inductrialInjuryInsurance=").append(inductrialInjuryInsurance);
        sb.append(", fertilityInsurance=").append(fertilityInsurance);
        sb.append(", companyAccumulationFund=").append(companyAccumulationFund);
        sb.append(", companyTotalIndividual=").append(companyTotalIndividual);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}