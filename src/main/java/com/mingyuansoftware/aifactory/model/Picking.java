package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(description = "郝腾")
public class Picking implements Serializable {

    @ApiModelProperty(value = "领料单id", example = "1")
    private Integer pickingId;


    @ApiModelProperty(value = "领料单编号", example = "pickingNumber")
    private String pickingNumber;


    @ApiModelProperty(value = "排产单id", example = "1")
    private Integer psId;


    @ApiModelProperty(value = "批号", example = "lotNumber")
    private String lotNumber;


    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;


    @ApiModelProperty(value = "入仓库id", example = "1")
    private Integer intoWarehouseId;


    @ApiModelProperty(value = "出仓库id", example = "1")
    private Integer outWarehouseId;


    @ApiModelProperty(value = "状态  1.已创建 2.已领料 3.已确认", example = "1")
    private Byte state;


    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;


    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;


    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;


    @ApiModelProperty(value = "是否删除 1是 0否", example = "0")
    private Byte isDelete;


    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;


    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "领入仓库", example = "intoWarehouseName")
    private String intoWarehouseName;

    @ApiModelProperty(value = "领出仓库", example = "outWarehouseName")
    private String outWarehouseName;

    @ApiModelProperty(value = "领料单详情", example = "pickingDetailsList")
    private List<PickingDetails> pickingDetailsList;

    @ApiModelProperty(value = "员工", example = "staff")
    private Staff staff;

    @ApiModelProperty(value = "领入仓库", example = "intoWarehouse")
    private Warehouse intoWarehouse;

    @ApiModelProperty(value = "领出仓库", example = "outWarehouse")
    private Warehouse outWarehouse;

    @ApiModelProperty(value = "领料员工id", example = "pickingStaffId")
    private Integer pickingStaffId;

    private static final long serialVersionUID = 1L;



    public Integer getPickingId() {
        return pickingId;
    }



    public void setPickingId(Integer pickingId) {
        this.pickingId = pickingId;
    }



    public String getPickingNumber() {
        return pickingNumber;
    }



    public void setPickingNumber(String pickingNumber) {
        this.pickingNumber = pickingNumber == null ? null : pickingNumber.trim();
    }


    public Integer getPsId() {
        return psId;
    }


    public void setPsId(Integer psId) {
        this.psId = psId;
    }


    public String getLotNumber() {
        return lotNumber;
    }



    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber == null ? null : lotNumber.trim();
    }


    public Integer getStaffId() {
        return staffId;
    }


    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }


    public Integer getIntoWarehouseId() {
        return intoWarehouseId;
    }


    public void setIntoWarehouseId(Integer intoWarehouseId) {
        this.intoWarehouseId = intoWarehouseId;
    }


    public Integer getOutWarehouseId() {
        return outWarehouseId;
    }


    public void setOutWarehouseId(Integer outWarehouseId) {
        this.outWarehouseId = outWarehouseId;
    }


    public Byte getState() {
        return state;
    }


    public void setState(Byte state) {
        this.state = state;
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


    public Byte getIsDelete() {
        return isDelete;
    }


    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }


    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntoWarehouseName() {
        return intoWarehouseName;
    }

    public void setIntoWarehouseName(String intoWarehouseName) {
        this.intoWarehouseName = intoWarehouseName;
    }

    public String getOutWarehouseName() {
        return outWarehouseName;
    }

    public void setOutWarehouseName(String outWarehouseName) {
        this.outWarehouseName = outWarehouseName;
    }

    public List<PickingDetails> getPickingDetailsList() {
        return pickingDetailsList;
    }

    public void setPickingDetailsList(List<PickingDetails> pickingDetailsList) {
        this.pickingDetailsList = pickingDetailsList;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Warehouse getIntoWarehouse() {
        return intoWarehouse;
    }

    public void setIntoWarehouse(Warehouse intoWarehouse) {
        this.intoWarehouse = intoWarehouse;
    }

    public Warehouse getOutWarehouse() {
        return outWarehouse;
    }

    public void setOutWarehouse(Warehouse outWarehouse) {
        this.outWarehouse = outWarehouse;
    }

    public Integer getPickingStaffId() {
        return pickingStaffId;
    }

    public void setPickingStaffId(Integer pickingStaffId) {
        this.pickingStaffId = pickingStaffId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pickingId=").append(pickingId);
        sb.append(", pickingNumber=").append(pickingNumber);
        sb.append(", psId=").append(psId);
        sb.append(", lotNumber=").append(lotNumber);
        sb.append(", staffId=").append(staffId);
        sb.append(", intoWarehouseId=").append(intoWarehouseId);
        sb.append(", outWarehouseId=").append(outWarehouseId);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", comment=").append(comment);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", addTime=").append(addTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}