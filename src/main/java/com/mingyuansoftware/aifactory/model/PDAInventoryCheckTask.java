package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 张婷
 * @date 2019/8/6 14:27
 */

//盘点操作任务列表

public class PDAInventoryCheckTask {

    @ApiModelProperty(value = "库存盘点id", example = "1")
    private Integer inventoryCheckId;

    @ApiModelProperty(value = "库存盘点编号", example = "134")
    private String inventoryCheckNumber;

    @ApiModelProperty(value = "仓库id", example = "1")
    private Integer warehouseId;

    @ApiModelProperty(value = "仓库名称", example = "仓库名称")
    private String warehouseName;

    public Integer getInventoryCheckId() {
        return inventoryCheckId;
    }

    public void setInventoryCheckId(Integer inventoryCheckId) {
        this.inventoryCheckId = inventoryCheckId;
    }

    public String getInventoryCheckNumber() {
        return inventoryCheckNumber;
    }

    public void setInventoryCheckNumber(String inventoryCheckNumber) {
        this.inventoryCheckNumber = inventoryCheckNumber;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
