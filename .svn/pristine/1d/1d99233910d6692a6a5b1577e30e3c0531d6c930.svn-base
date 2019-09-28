package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.CustomerContactMapper;
import com.mingyuansoftware.aifactory.mapper.CustomerMapper;
import com.mingyuansoftware.aifactory.model.Customer;
import com.mingyuansoftware.aifactory.model.CustomerContact;
import com.mingyuansoftware.aifactory.model.dto.CustomerDto;
import com.mingyuansoftware.aifactory.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 张婷
 * @date 2019/6/27 10:16
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerContactMapper customerContactMapper;

    @Override
    public List<Customer> selectCustomerAll(CustomerDto customerDto) {
        try {
            return customerMapper.selectCustomerAll(customerDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer count(CustomerDto customerDto) {
        try {
            return customerMapper.count(customerDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer addCustomer(Customer customer) {
        customer.setIsDelete((byte) 0);
        customer.setWriteOffAmount(BigDecimal.ZERO);
        Integer addCustomer = customerMapper.addCustomer(customer);
        //获取刚刚插入的记录id
        Integer customerId = customerMapper.selectLastId();
        List<CustomerContact> customerContactList = customer.getCustomerContactList();
        for (CustomerContact ccList : customerContactList) {
            ccList.setCustomerId(customerId);
            customerContactMapper.addcustomerContact(ccList);
        }
        return addCustomer;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer editCustomer(Customer customer) {
        //根据客户id查询客户信息
        Customer customer1 = customerMapper.selectCustomerByCId(customer.getCustomerId());
        customer.setCustomerNumber(customer1.getCustomerNumber());
        customer.setIsDelete(customer1.getIsDelete());
        customer.setWriteOffAmount(customer1.getWriteOffAmount());
        //修改客户
        customerMapper.editCustomer(customer);
        //先将数据库中客户联系人删除
        customerContactMapper.deleteCustomerContactByCId(customer.getCustomerId());
        //遍历新增修改后的客户联系人
        List<CustomerContact> customerContactList = customer.getCustomerContactList();
        for (CustomerContact ccL : customerContactList) {
            ccL.setCustomerId(customer.getCustomerId());
            customerContactMapper.addcustomerContact(ccL);
        }
        return customerMapper.editCustomer(customer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteCustomer(Integer customerId) {
        //根据客户Id将客户和客户联系人表的数据都逻辑删除
        customerContactMapper.updateCustomerContactByCId(customerId);
        return customerMapper.updateCustomer(customerId);
    }

    @Override
    public List<Customer> getCustomerNameList() {
        try {
            return customerMapper.getCustomerNameList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer selectCustomerByCId(Integer customerId) {
        try {
            Customer customer = customerMapper.selectCustomerByCId(customerId);
            List<CustomerContact> customerContactList = customerContactMapper.selectCustomerDetailByCId(customerId);
            customer.setCustomerContactList(customerContactList);
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
