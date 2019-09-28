package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "郝腾")
public class Log implements Serializable {

    @ApiModelProperty(value = "日志表id", example = "1")
    private Integer logId;

    @ApiModelProperty(value = "操作人id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "操作类型  1.新增 2修改 3删除 4导入 5导出", example = "1")
    private Byte type;

    @ApiModelProperty(value = "操作内容{id}{内容}", example = "text")
    private String text;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;


    private static final long serialVersionUID = 1L;


    public Integer getLogId() {
        return logId;
    }


    public void setLogId(Integer logId) {
        this.logId = logId;
    }


    public Integer getStaffId() {
        return staffId;
    }


    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }


    public Byte getType() {
        return type;
    }


    public void setType(Byte type) {
        this.type = type;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logId=").append(logId);
        sb.append(", staffId=").append(staffId);
        sb.append(", type=").append(type);
        sb.append(", text=").append(text);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}