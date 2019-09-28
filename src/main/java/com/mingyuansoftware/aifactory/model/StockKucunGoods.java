package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@ApiModel(description = "郝腾")
public class StockKucunGoods implements Serializable {

    @ApiModelProperty(value = "库存流水表id", example = "1")
    private Integer skgid;

    @ApiModelProperty(value = "创建时间", example = "skgCreateDatetime")
    private Date skgCreateDatetime;

    @ApiModelProperty(value = "数量", example = "1")
    private BigDecimal skgCount;

    @ApiModelProperty(value = "仓库id", example = "1")
    private Integer warehouseId;

    @ApiModelProperty(value = "库存类型", example = "skgType")
    private String skgType;

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer gid;

    @ApiModelProperty(value = "货物成本", example = "1")
    private BigDecimal skgDanJia;

    @ApiModelProperty(value = "单据编号", example = "skgSerialNumber")
    private String skgSerialNumber;

    @ApiModelProperty(value = "往来单位", example = "skgWanglaiDanwei")
    private String skgWanglaiDanwei;

    @ApiModelProperty(value = "当时总数量", example = "1")
    private BigDecimal totalSkgCount;

    @ApiModelProperty(value = "变动类型  1.外部变动 包括销售,销售退货,采购,采购退货,入库单,出库单,库存盘点 2.内部变动 包括领料单,退料单,调拨单,生产入库", example = "1")
    private Byte changeType;


    private static final long serialVersionUID = 1L;


    public Integer getSkgid() {
        return skgid;
    }


    public void setSkgid(Integer skgid) {
        this.skgid = skgid;
    }


    public Date getSkgCreateDatetime() {
        return skgCreateDatetime;
    }


    public void setSkgCreateDatetime(Date skgCreateDatetime) {
        this.skgCreateDatetime = skgCreateDatetime;
    }


    public BigDecimal getSkgCount() {
        return skgCount;
    }


    public void setSkgCount(BigDecimal skgCount) {
        this.skgCount = skgCount;
    }


    public Integer getWarehouseId() {
        return warehouseId;
    }


    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }


    public String getSkgType() {
        return skgType;
    }


    public void setSkgType(String skgType) {
        this.skgType = skgType == null ? null : skgType.trim();
    }


    public Integer getGid() {
        return gid;
    }


    public void setGid(Integer gid) {
        this.gid = gid;
    }


    public BigDecimal getSkgDanJia() {
        return skgDanJia;
    }


    public void setSkgDanJia(BigDecimal skgDanJia) {
        this.skgDanJia = skgDanJia;
    }


    public String getSkgSerialNumber() {
        return skgSerialNumber;
    }


    public void setSkgSerialNumber(String skgSerialNumber) {
        this.skgSerialNumber = skgSerialNumber == null ? null : skgSerialNumber.trim();
    }


    public String getSkgWanglaiDanwei() {
        return skgWanglaiDanwei;
    }


    public void setSkgWanglaiDanwei(String skgWanglaiDanwei) {
        this.skgWanglaiDanwei = skgWanglaiDanwei == null ? null : skgWanglaiDanwei.trim();
    }

    public BigDecimal getTotalSkgCount() {
        return totalSkgCount;
    }

    public void setTotalSkgCount(BigDecimal totalSkgCount) {
        this.totalSkgCount = totalSkgCount;
    }

    public Byte getChangeType() {
        return changeType;
    }

    public void setChangeType(Byte changeType) {
        this.changeType = changeType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", skgid=").append(skgid);
        sb.append(", skgCreateDatetime=").append(skgCreateDatetime);
        sb.append(", skgCount=").append(skgCount);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", skgType=").append(skgType);
        sb.append(", gid=").append(gid);
        sb.append(", skgDanJia=").append(skgDanJia);
        sb.append(", skgSerialNumber=").append(skgSerialNumber);
        sb.append(", skgWanglaiDanwei=").append(skgWanglaiDanwei);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}