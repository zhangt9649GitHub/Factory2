package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "郝腾")
public class UploadFiles implements Serializable {

    @ApiModelProperty(value = "图片上传表id", example = "1")
    private Integer ufId;

    @ApiModelProperty(value = "图片路径", example = "ufSavePath")
    private String ufSavePath;


    private static final long serialVersionUID = 1L;


    public Integer getUfId() {
        return ufId;
    }


    public void setUfId(Integer ufId) {
        this.ufId = ufId;
    }


    public String getUfSavePath() {
        return ufSavePath;
    }


    public void setUfSavePath(String ufSavePath) {
        this.ufSavePath = ufSavePath == null ? null : ufSavePath.trim();
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ufId=").append(ufId);
        sb.append(", ufSavePath=").append(ufSavePath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}