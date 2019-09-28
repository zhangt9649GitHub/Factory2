package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "郝腾")
public class Requisition implements Serializable {

    @ApiModelProperty(value = "调拨单id", example = "1")
    private Integer requisitionId;

    @ApiModelProperty(value = "调拨单编号", example = "requisitionNumber")
    private String requisitionNumber;

    @ApiModelProperty(value = "批号", example = "lotNumber")
    private String lotNumber;

    @ApiModelProperty(value = "调入仓库id", example = "1")
    private Integer intoWarehouseId;

    @ApiModelProperty(value = "调出仓库id", example = "1")
    private Integer outWarehouseId;

    @ApiModelProperty(value = "创建人id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "调拨类型", example = "type")
    private String type;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "是否删除 1是 0否", example = "0")
    private Byte isDelete;

    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "调入仓库", example = "intoWarehouseName")
    private String intoWarehouseName;

    @ApiModelProperty(value = "调出仓库", example = "outWarehouseName")
    private String outWarehouseName;

    @ApiModelProperty(value = "调拨单详情集合", example = "requisitionDetailsList")
    private List<RequisitionDetails> requisitionDetailsList = new ArrayList<>();


    @ApiModelProperty(value = "创建时间", example = "addtime")
    private String addtime;



    private static final long serialVersionUID = 1L;


    public Integer getRequisitionId() {
        return requisitionId;
    }


    public void setRequisitionId(Integer requisitionId) {
        this.requisitionId = requisitionId;
    }


    public String getRequisitionNumber() {
        return requisitionNumber;
    }


    public void setRequisitionNumber(String requisitionNumber) {
        this.requisitionNumber = requisitionNumber == null ? null : requisitionNumber.trim();
    }


    public String getLotNumber() {
        return lotNumber;
    }


    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber == null ? null : lotNumber.trim();
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


    public Integer getStaffId() {
        return staffId;
    }


    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<RequisitionDetails> getRequisitionDetailsList() {
        return requisitionDetailsList;
    }

    public void setRequisitionDetailsList(List<RequisitionDetails> requisitionDetailsList) {
        this.requisitionDetailsList = requisitionDetailsList;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", requisitionId=").append(requisitionId);
        sb.append(", requisitionNumber=").append(requisitionNumber);
        sb.append(", lotNumber=").append(lotNumber);
        sb.append(", intoWarehouseId=").append(intoWarehouseId);
        sb.append(", outWarehouseId=").append(outWarehouseId);
        sb.append(", staffId=").append(staffId);
        sb.append(", type=").append(type);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", comment=").append(comment);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}