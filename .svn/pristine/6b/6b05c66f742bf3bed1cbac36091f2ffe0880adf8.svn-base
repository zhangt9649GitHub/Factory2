/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: StaffDto
 * Author:   EDZ
 * Date:     2019/6/28 13:47
 * Description: 员工查询
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈员工查询〉
 *
 * @author EDZ
 * @create 2019/6/28
 * @since 1.0.0
 */
@ApiModel(description = "王力影")
public class StaffDto {

    @ApiModelProperty(value = "工号", example = "12")
    private String jobNumber;

    @ApiModelProperty(value = "姓名", example = "小王")
    private String name;

    @ApiModelProperty(value = "电话号码", example = "123456")
    private String phone;

    @ApiModelProperty(value = "角色 ", example = "职员")
    private String role;

    @ApiModelProperty(value = "入职时间", example = "2018-06-04")
    private String entryTime;

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    private static Date parseDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
