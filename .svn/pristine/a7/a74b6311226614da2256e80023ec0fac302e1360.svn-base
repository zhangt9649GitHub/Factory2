package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.Customer;
import com.mingyuansoftware.aifactory.model.CustomerContact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerContactMapper {

    /**
     * 根据客户id查询客户信息列表
     *
     * @param customerId
     * @return
     */
    List<CustomerContact> selectCustomerDetailByCId(@Param("customerId") Integer customerId);

    /**
     * 客户列表条数
     *
     * @param
     * @return
     */
    Integer count();

    /**
     * 删除联系人
     *
     * @param
     * @return
     */
    int deleteCustomerContactByCId(@Param("customerContactId") Integer customerContactId);

    /**
     * 添加联系人
     *
     * @param
     * @return
     */
    int addcustomerContact(CustomerContact record);

    /**
     * 通过联系人id查询一条记录
     *
     * @param
     * @return
     */
    CustomerContact selectByPrimaryKey(Integer customerContactId);

    /**
     * 通过联系人id查询
     *
     * @param
     * @return
     */
    int updateByPrimaryKey(CustomerContact record);


    /**
     * 获取客户联系人一条列表,用于添加数据
     *
     * @param
     * @return
     */
    List<CustomerContact> customerContactList(@Param("customerContactId") Integer customerContactId);

    /**
     * 根据客户Id逻辑删除客户联系人
     * @param customerId
     */
    void updateCustomerContactByCId(@Param("customerId") Integer customerId);
}