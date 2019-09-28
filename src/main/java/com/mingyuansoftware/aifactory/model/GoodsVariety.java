package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "郝腾")
public class GoodsVariety implements Serializable {

    @ApiModelProperty(value = "品种值", example = "1")
    private Integer varietyValue;

    @ApiModelProperty(value = "日文名", example = "jpName")
    private String jpName;

    @ApiModelProperty(value = "英文名", example = "elName")
    private String elName;

    @ApiModelProperty(value = "中文名", example = "cnName")
    private String cnName;


    private static final long serialVersionUID = 1L;


    public Integer getVarietyValue() {
        return varietyValue;
    }


    public void setVarietyValue(Integer varietyValue) {
        this.varietyValue = varietyValue;
    }


    public String getJpName() {
        return jpName;
    }


    public void setJpName(String jpName) {
        this.jpName = jpName == null ? null : jpName.trim();
    }


    public String getElName() {
        return elName;
    }


    public void setElName(String elName) {
        this.elName = elName == null ? null : elName.trim();
    }


    public String getCnName() {
        return cnName;
    }


    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", varietyValue=").append(varietyValue);
        sb.append(", jpName=").append(jpName);
        sb.append(", elName=").append(elName);
        sb.append(", cnName=").append(cnName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}