package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ApiModel(description = "王力影")
public class Staff implements Serializable {

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer staffId;

    @ApiModelProperty(value = "工号", example = "12")
    private String jobNumber;

    @ApiModelProperty(value = "姓名", example = "小王")
    private String name;

    @ApiModelProperty(value = "性别", example = "男")
    private String gender;

    @ApiModelProperty(value = "上传头像图片路径id", example = "1")
    private Integer ufId;

    @ApiModelProperty(value = "图片路径", example = "ufSavePath")
    private String ufSavePath;

    @ApiModelProperty(value = "身份证号", example = "130128556")
    private String cardNumber;

    @ApiModelProperty(value = "电话号码", example = "123456")
    private String phone;

    @ApiModelProperty(value = "地址", example = "天津市")
    private String address;

    @ApiModelProperty(value = "入职时间", example = "2018-06-04")
    private String entryTime;


//1为离职 2为在职
    @ApiModelProperty(value = "状态", example = "1")
    private Byte state;

    @ApiModelProperty(value = "是否转正 1，是 2，否", example = "1")
    private Byte isTurnPositive;

    @ApiModelProperty(value = "转正日期", example = "2018-09-04")
    private String positiveTime;

    @ApiModelProperty(value = "所在部门", example = "培训部")
    private String department;

    @ApiModelProperty(value = "角色 ", example = "职员")
    private String role;

    @ApiModelProperty(value = "岗位 ", example = "讲师")
    private String post;

    @ApiModelProperty(value = "备注 ", example = "11")
    private String comment;

    @ApiModelProperty(value = "密码 ", example = "11")
    private String password;

    @ApiModelProperty(value = "用户名 ", example = "11")
    private String adminName;

    @ApiModelProperty(value = "登陆时间", example = "11")
    private String loginTime;

    @ApiModelProperty(value = "登陆ip", example = "11")
    private String loginIp;

    @ApiModelProperty(value = "组id", example = "11")
    private String groupId;

    @ApiModelProperty(value = "保险公司", example = "insuranceCompany")
    private String insuranceCompany;

    @ApiModelProperty(value = "权限组", example = "")
    private List<StaffPermission> permissions;

    @ApiModelProperty(value = "删除状态 1.表示删除 0.表示未删除", example = "0")
    private Byte isDelete;

    @ApiModelProperty(value = "实习工资", example = "2000.00")
    private BigDecimal trainSalary;

    @ApiModelProperty(value = "基本工资", example = "2000.00")
    private BigDecimal basicSalary;

    @ApiModelProperty(value = "支付劳动局管理费", example = "1")
    private BigDecimal managementFee;

    @ApiModelProperty(value = "岗位津贴", example = "1")
    private BigDecimal postAllowance;

    @ApiModelProperty(value = "伙食扣款", example = "1")
    private BigDecimal foodDeduction;

    @ApiModelProperty(value = "天津工厂扣款", example = "1")
    private BigDecimal tjFactoryDeduction;

    @ApiModelProperty(value = "是否有社保0无1有", example = "0")
    private Byte issocial;

    @ApiModelProperty(value = "上传图片实体类", example = "uploadFiles")
    private UploadFiles uploadFiles;

    @ApiModelProperty(value = "员工保险", example = "staffInsurance")
    private StaffInsurance staffInsurance;

    @ApiModelProperty(value = "离职日期", example = "departureTime")
    private Date departureTime;


    private StaffAccessGroup staffAccessGroup;

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }



    public Byte getIssocial() {
        return issocial;
    }

    public void setIssocial(Byte issocial) {
        this.issocial = issocial;
    }



    public BigDecimal getTrainSalary() {
        return trainSalary;
    }

    public void setTrainSalary(BigDecimal trainSalary) {
        this.trainSalary = trainSalary;
    }

    public StaffAccessGroup getStaffAccessGroup() {
        return staffAccessGroup;
    }

    public void setStaffAccessGroup(StaffAccessGroup staffAccessGroup) {
        this.staffAccessGroup = staffAccessGroup;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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

    public List<StaffPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<StaffPermission> permissions) {
        this.permissions = permissions;
    }

    public UploadFiles getUploadFiles() {
        return uploadFiles;
    }

    public void setUploadFiles(UploadFiles uploadFiles) {
        this.uploadFiles = uploadFiles;
    }

    private static final long serialVersionUID = 1L;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStaffId() {
        return staffId;
    }


    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }


    public String getJobNumber() {
        return jobNumber;
    }


    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }


    public Integer getUfId() {
        return ufId;
    }


    public void setUfId(Integer ufId) {
        this.ufId = ufId;
    }


    public String getCardNumber() {
        return cardNumber;
    }


    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }


    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getPositiveTime() {
        return positiveTime;
    }

    public void setPositiveTime(String positiveTime) {
        this.positiveTime = positiveTime;
    }

    public Byte getState() {
        return state;
    }


    public void setState(Byte state) {
        this.state = state;
    }


    public Byte getIsTurnPositive() {
        return isTurnPositive;
    }


    public void setIsTurnPositive(Byte isTurnPositive) {
        this.isTurnPositive = isTurnPositive;
    }


    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
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
        this.post = post == null ? null : post.trim();
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

    private static Date parseDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public String getUfSavePath() {
        return ufSavePath;
    }

    public void setUfSavePath(String ufSavePath) {
        this.ufSavePath = ufSavePath;
    }

    public BigDecimal getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(BigDecimal managementFee) {
        this.managementFee = managementFee;
    }

    public BigDecimal getPostAllowance() {
        return postAllowance;
    }

    public void setPostAllowance(BigDecimal postAllowance) {
        this.postAllowance = postAllowance;
    }

    public BigDecimal getFoodDeduction() {
        return foodDeduction;
    }

    public void setFoodDeduction(BigDecimal foodDeduction) {
        this.foodDeduction = foodDeduction;
    }

    public BigDecimal getTjFactoryDeduction() {
        return tjFactoryDeduction;
    }

    public void setTjFactoryDeduction(BigDecimal tjFactoryDeduction) {
        this.tjFactoryDeduction = tjFactoryDeduction;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public StaffInsurance getStaffInsurance() {
        return staffInsurance;
    }

    public void setStaffInsurance(StaffInsurance staffInsurance) {
        this.staffInsurance = staffInsurance;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", staffId=").append(staffId);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", ufId=").append(ufId);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", entryTime=").append(entryTime);
        sb.append(", state=").append(state);
        sb.append(", isTurnPositive=").append(isTurnPositive);
        sb.append(", positiveTime=").append(positiveTime);
        sb.append(", department=").append(department);
        sb.append(", role=").append(role);
        sb.append(", post=").append(post);
        sb.append(", comment=").append(comment);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}