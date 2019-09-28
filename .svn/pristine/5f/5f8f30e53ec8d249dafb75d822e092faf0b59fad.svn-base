package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.Customer;
import com.mingyuansoftware.aifactory.model.dto.CustomerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CustomerMapper {

    /**
     * 根据客户id查询客户联系人信息
     *
     * @param
     * @return
     */
    Customer selectCustomerByCId(@Param("customerId") Integer customerId);

    /**
     * 客户列表
     *
     * @param customerDto
     * @return
     */
    List<Customer> selectCustomerAll(@Param("customerDto") CustomerDto customerDto);

    /**
     * 客户列表条数
     *
     * @param customerDto
     * @return
     */
    Integer count(@Param("customerDto") CustomerDto customerDto);

    /**
     * 添加客户
     *
     * @param
     * @return
     */
    Integer addCustomer(@Param("customer") Customer customer);

    /**
     * 编辑客户信息
     *
     * @param customer
     * @return
     */
    Integer editCustomer(@Param("customer") Customer customer);

    /**
     * 逻辑删除客户
     *
     * @param customerId
     * @return
     */
    Integer updateCustomer(@Param("customerId") Integer customerId);

    /**
     * 获取客户姓名列表
     *
     * @return
     */
    List<Customer> getCustomerNameList();

    /**
     * 查询刚刚插入的记录id
     * @return
     */
    Integer selectLastId();


    Integer updateWriteOffAmount(Map map);


    /**
     * 根据客户Id添加待核销金额(待付款金额)
     * @param customerId
     * @param subtract
     */
    void updateWriteOffAmountByCId(@Param("customerId") Integer customerId,@Param("subtract") BigDecimal subtract);

}