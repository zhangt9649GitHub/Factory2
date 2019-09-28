package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.Customer;
import com.mingyuansoftware.aifactory.model.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    /**
     * 客户列表
     *
     * @param customerDto
     * @return
     */
    List<Customer> selectCustomerAll(CustomerDto customerDto);

    /**
     * 客户列表条数
     *
     * @param
     * @return
     */
    Integer count(CustomerDto customerDto);

    /**
     * 添加客户
     *
     * @param customer
     * @return
     */
    Integer addCustomer(Customer customer);

    /**
     * 编辑客户信息
     *
     * @param customer
     * @return
     */
    Integer editCustomer(Customer customer);

    /**
     * 删除客户
     *
     * @param customerId
     * @return
     */
    Integer deleteCustomer(Integer customerId);

    /**
     * 获取客户姓名列表
     *
     * @return
     */
    List<Customer> getCustomerNameList();

    /**
     * 根据客户id查询客户信息
     *
     * @return
     */
    Customer selectCustomerByCId(Integer customerId);
}
