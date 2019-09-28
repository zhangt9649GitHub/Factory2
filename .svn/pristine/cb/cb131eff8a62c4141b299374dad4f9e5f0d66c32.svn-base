package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于生产进度分析条件查询
 */
@ApiModel(description = "郝腾")
public class ProductionScheduleAnalysisDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "货物类别(检索)", example = "1")
    private Byte category;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductionScheduleAnalysisDto{" +
                "goodsName='" + goodsName + '\'' +
                ", category=" + category +
                '}';
    }
}
