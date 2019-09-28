package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.SupplierContact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface SupplierContactMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier_contact
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer supplierContactId);


    int deleteKey(Integer supplierId);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier_contact
     *
     * @mbggenerated
     */
    int insert(SupplierContact record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier_contact
     *
     * @mbggenerated
     */
    List<SupplierContact> selectByPrimaryKey(Integer supplierContactId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier_contact
     *
     * @mbggenerated
     */
    List<SupplierContact> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier_contact
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SupplierContact record);
}