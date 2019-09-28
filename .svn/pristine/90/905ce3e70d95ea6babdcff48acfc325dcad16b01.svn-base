package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.Customer;
import com.mingyuansoftware.aifactory.model.CustomerContact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerContactService {

    /**
     * 客户联系人列表(包括联系人信息)
     *
     * @param
     * @return
     */
    Customer selectCustomerDetailByCId(Integer customerId);

    /**
     * 客户联系人列表数量
     *
     * @param
     * @return
     */
    Integer count();


    /**
     * 获取客户联系人一条列表,用于添加数据
     *
     * @param
     * @return
     */
    List<CustomerContact> customerContactList(Integer customerContactId);

}
