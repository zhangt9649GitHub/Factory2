package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(description = "郝腾")
public class OutboundOrder implements Serializable {

    @ApiModelProperty(value = "出库单id", example = "1")
    private Integer outboundOrderId;

    @ApiModelProperty(value = "出库单编号", example = "outboundOrderNumber")
    private String outboundOrderNumber;

    @ApiModelProperty(value = "表单时间", example = "addTime")
    private String addTime;

    @ApiModelProperty(value = "仓库id", example = "1")
    private Integer warehouseId;

    @ApiModelProperty(value = "出库类型", example = "type")
    private String type;

    @ApiModelProperty(value = "批号", example = "lotNumber")
    private String lotNumber;

    @ApiModelProperty(value = "备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "员工id", example = "staffId")
    private Integer staffId;

    @ApiModelProperty(value = "是否删除 1是 0否", example = "0")
    private Byte isDelete;

    @ApiModelProperty(value = "员工姓名", example = "name")
    private String name;

    @ApiModelProperty(value = "仓库", example = "warehouseName")
    private String warehouseName;

    @ApiModelProperty(value = "出库单详情集合", example = "outboundOrderDetailsList")
    private List<OutboundOrderDetails> outboundOrderDetailsList;

    @ApiModelProperty(value = "总价", example = "1")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "员工", example = "staff")
    private Staff staff;

    @ApiModelProperty(value = "仓库", example = "warehouse")
    private Warehouse warehouse;

    private static final long serialVersionUID = 1L;


    public Integer getOutboundOrderId() {
        return outboundOrderId;
    }


    public void setOutboundOrderId(Integer outboundOrderId) {
        this.outboundOrderId = outboundOrderId;
    }


    public String getOutboundOrderNumber() {
        return outboundOrderNumber;
    }


    public void setOutboundOrderNumber(String outboundOrderNumber) {
        this.outboundOrderNumber = outboundOrderNumber == null ? null : outboundOrderNumber.trim();
    }


    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }


    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }


    public String getLotNumber() {
        return lotNumber;
    }


    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber == null ? null : lotNumber.trim();
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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


    public Integer getStaffId() {
        return staffId;
    }


    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public List<OutboundOrderDetails> getOutboundOrderDetailsList() {
        return outboundOrderDetailsList;
    }

    public void setOutboundOrderDetailsList(List<OutboundOrderDetails> outboundOrderDetailsList) {
        this.outboundOrderDetailsList = outboundOrderDetailsList;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", outboundOrderId=").append(outboundOrderId);
        sb.append(", outboundOrderNumber=").append(outboundOrderNumber);
        sb.append(", addTime=").append(addTime);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", type=").append(type);
        sb.append(", lotNumber=").append(lotNumber);
        sb.append(", comment=").append(comment);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", staffId=").append(staffId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}