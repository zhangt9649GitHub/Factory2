package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "张婷")
public class FinanceMoneyRecord implements Serializable {

    @ApiModelProperty(value = "财务流水id", example = "1")
    private Integer fmid;

    @ApiModelProperty(value = "金额", example = "0")
    private BigDecimal fmMoney;

    @ApiModelProperty(value = "流水类型(采购付款,销售收款...)", example = "")
    private String fmType;

    @ApiModelProperty(value = "流水时间", example = "fmDatetime")
    private Date fmDatetime;

    @ApiModelProperty(value = "供应商Id", example = "1")
    private Integer sid;

    @ApiModelProperty(value = "客户id", example = "1")
    private Integer cid;

    @ApiModelProperty(value = "单据编号", example = "fmSerialNumber")
    private String fmSerialNumber;

    @ApiModelProperty(value = "支付方式", example = "fmJieSuanType")
    private String fmJieSuanType;

    @ApiModelProperty(value = "交易对象(描述信息)", example = "fmJiaoyiDuixiang")
    private String fmJiaoyiDuixiang;

    private static final long serialVersionUID = 1L;

    public Integer getFmid() {
        return fmid;
    }

    public void setFmid(Integer fmid) {
        this.fmid = fmid;
    }

    public BigDecimal getFmMoney() {
        return fmMoney;
    }

    public void setFmMoney(BigDecimal fmMoney) {
        this.fmMoney = fmMoney;
    }

    public String getFmType() {
        return fmType;
    }

    public void setFmType(String fmType) {
        this.fmType = fmType == null ? null : fmType.trim();
    }

    public Date getFmDatetime() {
        return fmDatetime;
    }

    public void setFmDatetime(Date fmDatetime) {
        this.fmDatetime = fmDatetime;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getFmSerialNumber() {
        return fmSerialNumber;
    }

    public void setFmSerialNumber(String fmSerialNumber) {
        this.fmSerialNumber = fmSerialNumber == null ? null : fmSerialNumber.trim();
    }

    public String getFmJieSuanType() {
        return fmJieSuanType;
    }

    public void setFmJieSuanType(String fmJieSuanType) {
        this.fmJieSuanType = fmJieSuanType == null ? null : fmJieSuanType.trim();
    }

    public String getFmJiaoyiDuixiang() {
        return fmJiaoyiDuixiang;
    }

    public void setFmJiaoyiDuixiang(String fmJiaoyiDuixiang) {
        this.fmJiaoyiDuixiang = fmJiaoyiDuixiang == null ? null : fmJiaoyiDuixiang.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fmid=").append(fmid);
        sb.append(", fmMoney=").append(fmMoney);
        sb.append(", fmType=").append(fmType);
        sb.append(", fmDatetime=").append(fmDatetime);
        sb.append(", sid=").append(sid);
        sb.append(", cid=").append(cid);
        sb.append(", fmSerialNumber=").append(fmSerialNumber);
        sb.append(", fmJieSuanType=").append(fmJieSuanType);
        sb.append(", fmJiaoyiDuixiang=").append(fmJiaoyiDuixiang);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}