package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "张婷")
public class PurchaseApply implements Serializable {

    @ApiModelProperty(value = "采购申请单id", example = "1")
    private Integer purchaseApplyId;

    @ApiModelProperty(value = "采购申请单详情id", example = "1")
    private Integer purchaseApplyDetailsId;

    @ApiModelProperty(value = "采购编号", example = "purchaseNumber")
    private String purchaseNumber;

    @ApiModelProperty(value = "自定义日期", example = "defineDate")
    private String defineDate;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "创建人", example = "name")
    private String name;

//    @ApiModelProperty(value = "订单状态 1.未确认 2.已确认", example = "1")
//    private Byte orderStatus;

    @ApiModelProperty(value = "采购备注", example = "comment")
    private String comment;

    @ApiModelProperty(value = "删除状态 1.表示删除 0.表示未删除", example = "0")
    private Byte isDelete;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "采购申请单详情集合", example = "purchaseApplyDetailsList")
    private List<PurchaseApplyDetails> purchaseApplyDetailsList = new ArrayList<>();

    @ApiModelProperty(value = "采购申请单详情", example = "purchaseApplyDetails")
    private PurchaseApplyDetails purchaseApplyDetails;

    private static final long serialVersionUID = 1L;

    public Integer getPurchaseApplyId() {
        return purchaseApplyId;
    }

    public void setPurchaseApplyId(Integer purchaseApplyId) {
        this.purchaseApplyId = purchaseApplyId;
    }

    public Integer getPurchaseApplyDetailsId() {
        return purchaseApplyDetailsId;
    }

    public void setPurchaseApplyDetailsId(Integer purchaseApplyDetailsId) {
        this.purchaseApplyDetailsId = purchaseApplyDetailsId;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber == null ? null : purchaseNumber.trim();
    }

    public String getDefineDate() {
        return defineDate;
    }

    public void setDefineDate(String defineDate) {
        this.defineDate = defineDate;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<PurchaseApplyDetails> getPurchaseApplyDetailsList() {
        return purchaseApplyDetailsList;
    }

    public void setPurchaseApplyDetailsList(List<PurchaseApplyDetails> purchaseApplyDetailsList) {
        this.purchaseApplyDetailsList = purchaseApplyDetailsList;
    }

    public PurchaseApplyDetails getPurchaseApplyDetails() {
        return purchaseApplyDetails;
    }

    public void setPurchaseApplyDetails(PurchaseApplyDetails purchaseApplyDetails) {
        this.purchaseApplyDetails = purchaseApplyDetails;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", purchaseApplyId=").append(purchaseApplyId);
        sb.append(", purchaseNumber=").append(purchaseNumber);
        sb.append(", defineDate=").append(defineDate);
        sb.append(", staffId=").append(staffId);
        sb.append(", comment=").append(comment);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}