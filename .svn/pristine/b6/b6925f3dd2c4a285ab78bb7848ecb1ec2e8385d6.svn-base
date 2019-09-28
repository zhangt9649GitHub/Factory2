package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.Payroll;
import com.mingyuansoftware.aifactory.model.dto.PayrollDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface PayrollMapper {

    int deleteByPrimaryKey(Integer payrollId);

    int insert(Payroll record);

    Payroll selectByPrimaryKey(Integer payrollId);

    List<Payroll> selectAll();

    int updateByPrimaryKey(Payroll record);

    /**
     * 获取工资单列表
     * @param payrollDto
     * @return
     */
    List<Payroll> selectPayrollList(@Param("payrollDto") PayrollDto payrollDto);

    /**
     * 获取工资单列表总条数
     * @param payrollDto
     * @return
     */
    int selectCountPayrollList(@Param("payrollDto") PayrollDto payrollDto);

    /**
     * 删除工资单
     * @param payrollId
     */
    void updatePayrollById(@Param("payrollId") int payrollId);

    /**
     * 根据工资单Id修改工资单的付款时间和状态
     * @param associatedDocumentId
     * @param state
     */
    void updateStateById(@Param("associatedDocumentId") Integer associatedDocumentId,@Param("state") int state);
}