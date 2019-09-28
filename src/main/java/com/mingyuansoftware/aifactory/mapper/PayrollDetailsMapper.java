package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PayrollDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface PayrollDetailsMapper {

    int deleteByPrimaryKey(Integer payrollDetailsId);

    int insert(PayrollDetails record);

    PayrollDetails selectByPrimaryKey(Integer payrollDetailsId);

    List<PayrollDetails> selectAll();

    int updateByPrimaryKey(PayrollDetails record);

    /**
     * 根据工资单id获取工资单详情列表
     * @param payrollId
     * @return
     */
    List<PayrollDetails> selectPayrollDetailsListById(@Param("payrollId") int payrollId);
}