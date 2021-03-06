/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: SupplierDto
 * Author:   EDZ
 * Date:     2019/6/29 15:57
 * Description: 供应商查询
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 〈一句话功能简述〉<br> 
 * 〈供应商查询〉
 *
 * @author EDZ
 * @create 2019/6/29
 * @since 1.0.0
 */
public class SupplierDto {

    @ApiModelProperty(value = "供应商编码", example = "supplierNumber")
    private String supplierNumber;

    @ApiModelProperty(value = "供应商名称", example = "供应1")
    private String supplierName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supplier.contact
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系人", example = "小李")
    private String contact;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supplier.phone
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系电话", example = "1456721896")
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supplier.address
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "地址", example = "天津市")
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supplier.payee
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收款人", example = "小王")
    private String payee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supplier.bank_account
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开户行", example = "天津支行")
    private String bankAccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supplier.account_number
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "银行卡号", example = "6226898822223333")
    private String accountNumber;


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column supplier.account_period
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "账期", example = "账期")
    private String accountPeriod;

    @ApiModelProperty(value = "邮箱", example = "124@qq.com")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountPeriod() {
        return accountPeriod;
    }

    public void setAccountPeriod(String accountPeriod) {
        this.accountPeriod = accountPeriod;
    }
}
