package com.mingyuansoftware.aifactory.model.dto;

import com.mingyuansoftware.aifactory.model.StaffExperience;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "郝腾")
public class StaffExperienceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "经验值集合", example = "staffExperienceList")
    private List<StaffExperience> staffExperienceList;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public List<StaffExperience> getStaffExperienceList() {
        return staffExperienceList;
    }

    public void setStaffExperienceList(List<StaffExperience> staffExperienceList) {
        this.staffExperienceList = staffExperienceList;
    }

    @Override
    public String toString() {
        return "StaffExperienceDto{" +
                "staffId=" + staffId +
                ", staffExperienceList=" + staffExperienceList +
                '}';
    }
}
