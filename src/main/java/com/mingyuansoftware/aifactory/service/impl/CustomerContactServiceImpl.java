package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.CustomerContactMapper;
import com.mingyuansoftware.aifactory.mapper.CustomerMapper;
import com.mingyuansoftware.aifactory.model.Customer;
import com.mingyuansoftware.aifactory.model.CustomerContact;
import com.mingyuansoftware.aifactory.service.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张婷
 * @date 2019/6/29 10:57
 */

@Service
public class CustomerContactServiceImpl implements CustomerContactService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerContactMapper customerContactMapper;

    @Override
    public Customer selectCustomerDetailByCId(Integer customerId) {
        Customer customer = customerMapper.selectCustomerByCId(customerId);
        List<CustomerContact> customerContactList = customerContactMapper.selectCustomerDetailByCId(customerId);
        customer.setCustomerContactList(customerContactList);
        return customer;
    }

    @Override
    public Integer count() {
        return customerContactMapper.count();
    }


    @Override
    public List<CustomerContact> customerContactList(Integer customerContactId) {
        return customerContactMapper.customerContactList(customerContactId);
    }
}
