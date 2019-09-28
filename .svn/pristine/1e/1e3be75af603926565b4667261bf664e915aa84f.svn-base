package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "郝腾")
public class TjKucunGoodsInfo   implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "库存表集合", example = "库存表集合")
    private List<StockKucunGoods> stockKucunGoodsList;

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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public List<StockKucunGoods> getStockKucunGoodsList() {
        return stockKucunGoodsList;
    }

    public void setStockKucunGoodsList(List<StockKucunGoods> stockKucunGoodsList) {
        this.stockKucunGoodsList = stockKucunGoodsList;
    }

    @Override
    public String toString() {
        return "TjKucunGoodsInfo{" +
                "partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", stockKucunGoodsList=" + stockKucunGoodsList +
                '}';
    }
}
