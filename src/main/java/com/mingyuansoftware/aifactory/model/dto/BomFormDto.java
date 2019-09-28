package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BOM表单模糊查询参数
 *
 * @author 张婷
 * @date 2019/7/4 16:45
 */

@ApiModel(description = "张婷")
public class BomFormDto {

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "用户时间", example = "用户时间")
    private String defineDate;

    public String getPartsCd() {
        return partsCd;
    }

    public void setPartsCd(String partsCd) {
        this.partsCd = partsCd;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getDefineDate() {
        return defineDate;
    }

    public void setDefineDate(String defineDate) {
        this.defineDate = defineDate;
    }

    @Override
    public String toString() {
        return "BomFormDto{" +
                "partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", defineDate='" + defineDate + '\'' +
                '}';
    }
}
