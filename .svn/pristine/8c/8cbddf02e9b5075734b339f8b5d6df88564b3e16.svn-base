package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.Payroll;
import com.mingyuansoftware.aifactory.model.PayrollDetails;
import com.mingyuansoftware.aifactory.model.dto.PayrollDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface PayrollService {

    /**
     * 获取工资单列表
     * @param payrollDto
     * @return
     */
    List<Payroll> selectPayrollList(PayrollDto payrollDto);

    /**
     * 获取工资单列表总条数
     * @param payrollDto
     * @return
     */
    int selectCountPayrollList(PayrollDto payrollDto);

    /**
     * 导入工资单信息，保存到list中
     * @param fileName
     * @param file
     * @return
     */
    List<PayrollDetails> importPayrollExcel(String fileName, MultipartFile file);

    /**
     * 新增工资单
     * @param payroll
     */
    void insertPayroll(Payroll payroll);

    /**
     * 删除工资单
     * @param payrollId
     */
    void deletePayrollById(int payrollId);

    /**
     * 查询工资单详情
     * @param payrollId
     * @return
     */
    Payroll selectPayrollById(int payrollId);

    /**
     * 更新工资单信息
     * @param payroll
     */
    void updatePayrollInfo(Payroll payroll);
}
