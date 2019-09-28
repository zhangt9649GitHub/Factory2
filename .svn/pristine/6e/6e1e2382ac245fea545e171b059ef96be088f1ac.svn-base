package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(description = "郝腾")
public class StorageAccess implements Serializable {

    @ApiModelProperty(value = "入库单id", example = "")
    private Integer storageAccessId;

    @ApiModelProperty(value = "入库编号", example = "5588")
    private String storageNumber;

    @ApiModelProperty(value = "入库仓库id", example = "2")
    private Integer warehouseId;

    @ApiModelProperty(value = "批号", example = "225")
    private String lotNumber;

    @ApiModelProperty(value = "员工id", example = "员工id")
    private Integer createStaffId;

    @ApiModelProperty(value = "创建时间", example = "2018-03-04")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "2018-03-04")
    private Date updateTime;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "类型", example = "1")
    private String type;

    @ApiModelProperty(value = "入库时间", example = "2018-03-04")
    private String rukuTime;

    @ApiModelProperty(value = "总金额", example = "2.00")
    private BigDecimal amount;

   @ApiModelProperty(value = "是否删除 1是 0 否", example = "0")
    private Integer isDelete;

    public String getRukuTime() {
        return rukuTime;
    }

    public void setRukuTime(String rukuTime) {
        this.rukuTime = rukuTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private String name;

   private String warehouseName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }


    private List<StorageGoods> storageGoods;

    public List<StorageGoods> getStorageGoods() {
        return storageGoods;
    }

    public void setStorageGoods(List<StorageGoods> storageGoods) {
        this.storageGoods = storageGoods;
    }

    private static final long serialVersionUID = 1L;


    public Integer getStorageAccessId() {
        return storageAccessId;
    }


    public void setStorageAccessId(Integer storageAccessId) {
        this.storageAccessId = storageAccessId;
    }


    public String getStorageNumber() {
        return storageNumber;
    }


    public void setStorageNumber(String storageNumber) {
        this.storageNumber = storageNumber == null ? null : storageNumber.trim();
    }


    public Integer getWarehouseId() {
        return warehouseId;
    }


    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }


    public String getLotNumber() {
        return lotNumber;
    }


    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber == null ? null : lotNumber.trim();
    }


    public Integer getCreateStaffId() {
        return createStaffId;
    }


    public void setCreateStaffId(Integer createStaffId) {
        this.createStaffId = createStaffId;
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


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public Integer getIsDelete() {
        return isDelete;
    }


    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", storageAccessId=").append(storageAccessId);
        sb.append(", storageNumber=").append(storageNumber);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", lotNumber=").append(lotNumber);
        sb.append(", createStaffId=").append(createStaffId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", comment=").append(comment);
        sb.append(", type=").append(type);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}