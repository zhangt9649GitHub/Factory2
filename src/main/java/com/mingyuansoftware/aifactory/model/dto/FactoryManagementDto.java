package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 张婷
 * @date 2019/10/14 13:55
 */

@ApiModel(description = "张婷")
public class FactoryManagementDto {

    private Integer fmId;

    @ApiModelProperty(value = "工厂名称", example = "fName")
    private String fName;

    @ApiModelProperty(value = "伙食扣款", example = "0.00")
    private BigDecimal foodDeduction;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    public Integer getFmId() {
        return fmId;
    }

    public void setFmId(Integer fmId) {
        this.fmId = fmId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public BigDecimal getFoodDeduction() {
        return foodDeduction;
    }

    public void setFoodDeduction(BigDecimal foodDeduction) {
        this.foodDeduction = foodDeduction;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}
