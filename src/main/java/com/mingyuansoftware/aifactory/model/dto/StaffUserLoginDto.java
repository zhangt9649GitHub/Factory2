package com.mingyuansoftware.aifactory.model.dto;


import com.mingyuansoftware.aifactory.model.StaffPermission;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author 张赛潮
 * @date 2019/7/12 17:32
 */
@ApiModel(description = "张赛潮")
public class StaffUserLoginDto implements Serializable {


    @ApiModelProperty(value = "权限组", example = "")
    private List<StaffPermission> permissions;



    @ApiModelProperty(value = "用户id", example = "用户id")
    private Integer staffId;

    private String jobNumer;

    private String Name;

    private String Gender;

    private Integer ufId;

    private String cardNunber;

    private String phone;

    private String address;

    private String entryTime;

    private Integer state;

    private String isTurnPositive;


    private String positiveTime;

    private String department;

    private String role;

    private String post;

    private String comment;

    private int isDelete;

    private String adminName;

    private String password;

    private String loginTime;

    private String loginIp;

    private String groupId;

    public List<StaffPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<StaffPermission> permissions) {
        this.permissions = permissions;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getJobNumer() {
        return jobNumer;
    }

    public void setJobNumer(String jobNumer) {
        this.jobNumer = jobNumer;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Integer getUfId() {
        return ufId;
    }

    public void setUfId(Integer ufId) {
        this.ufId = ufId;
    }

    public String getCardNunber() {
        return cardNunber;
    }

    public void setCardNunber(String cardNunber) {
        this.cardNunber = cardNunber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIsTurnPositive() {
        return isTurnPositive;
    }

    public void setIsTurnPositive(String isTurnPositive) {
        this.isTurnPositive = isTurnPositive;
    }

    public String getPositiveTime() {
        return positiveTime;
    }

    public void setPositiveTime(String positiveTime) {
        this.positiveTime = positiveTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "StaffUserLoginDto{" +
                "permissions=" + permissions +
                ", staffId='" + staffId + '\'' +
                ", jobNumer='" + jobNumer + '\'' +
                ", Name='" + Name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", ufId=" + ufId +
                ", cardNunber='" + cardNunber + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", entryTime='" + entryTime + '\'' +
                ", state=" + state +
                ", isTurnPositive='" + isTurnPositive + '\'' +
                ", positiveTime='" + positiveTime + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", post='" + post + '\'' +
                ", comment='" + comment + '\'' +
                ", isDelete=" + isDelete +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffUserLoginDto that = (StaffUserLoginDto) o;
        return isDelete == that.isDelete &&
                Objects.equals(permissions, that.permissions) &&
                Objects.equals(staffId, that.staffId) &&
                Objects.equals(jobNumer, that.jobNumer) &&
                Objects.equals(Name, that.Name) &&
                Objects.equals(Gender, that.Gender) &&
                Objects.equals(ufId, that.ufId) &&
                Objects.equals(cardNunber, that.cardNunber) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(address, that.address) &&
                Objects.equals(entryTime, that.entryTime) &&
                Objects.equals(state, that.state) &&
                Objects.equals(isTurnPositive, that.isTurnPositive) &&
                Objects.equals(positiveTime, that.positiveTime) &&
                Objects.equals(department, that.department) &&
                Objects.equals(role, that.role) &&
                Objects.equals(post, that.post) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(adminName, that.adminName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(loginTime, that.loginTime) &&
                Objects.equals(loginIp, that.loginIp) &&
                Objects.equals(groupId, that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissions, staffId, jobNumer, Name, Gender, ufId, cardNunber, phone, address, entryTime, state, isTurnPositive, positiveTime, department, role, post, comment, isDelete, adminName, password, loginTime, loginIp, groupId);
    }
}