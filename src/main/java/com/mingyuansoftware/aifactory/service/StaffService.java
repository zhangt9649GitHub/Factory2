package com.mingyuansoftware.aifactory.service;


import com.mingyuansoftware.aifactory.model.Payroll;
import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.StaffPayroll;
import com.mingyuansoftware.aifactory.model.dto.StaffDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;

import java.util.List;

public interface StaffService {

    LayuiCommonResponse insert(Staff record);

    LayuiCommonResponse delete(int id);

    List<Staff> getName();

    LayuiCommonResponse getByid(int id);

    LayuiCommonResponse update(Staff record);

    LayuiCommonResponse getAll();

    LayuiCommonResponse getByPage(int page, int limit, StaffDto staffDto);

    LayuiCommonResponse getAdjust(int id);

    int updatePasswd(int id);

    /**
     * 根据工号查询员工id
     * @param jobNumber
     * @return
     */
    Staff selectStaffIdByNumber(String jobNumber);

    /**
     * 根据角色类型获取员工信息
     * @param roleType
     * @return
     */
    List<StaffPayroll> selectStaffListByRole(int roleType);
}
