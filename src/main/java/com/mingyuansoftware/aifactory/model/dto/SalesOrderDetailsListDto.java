package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用于生产出货单的参数
 */
@ApiModel(description = "郝腾")
public class SalesOrderDetailsListDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "销售单详情表id", example = "1")
    private Integer salesOrderDetailsId;

    @ApiModelProperty(value = "出货数量", example = "1")
    private BigDecimal outQuantity;

    @ApiModelProperty(value = "货柜信息", example = "1")
    private String containerInfo;


    public Integer getSalesOrderDetailsId() {
        return salesOrderDetailsId;
    }

    public void setSalesOrderDetailsId(Integer salesOrderDetailsId) {
        this.salesOrderDetailsId = salesOrderDetailsId;
    }

    public BigDecimal getOutQuantity() {
        return outQuantity;
    }

    public void setOutQuantity(BigDecimal outQuantity) {
        this.outQuantity = outQuantity;
    }

    public String getContainerInfo() {
        return containerInfo;
    }

    public void setContainerInfo(String containerInfo) {
        this.containerInfo = containerInfo;
    }

    @Override
    public String toString() {
        return "SalesOrderDetailsListDto{" +
                "salesOrderDetailsId=" + salesOrderDetailsId +
                ", outQuantity=" + outQuantity +
                ", containerInfo='" + containerInfo + '\'' +
                '}';
    }
}
