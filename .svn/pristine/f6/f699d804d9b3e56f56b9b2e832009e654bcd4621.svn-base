package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.dto.StaffDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface StaffMapper {

    int deleteByPrimaryKey(Integer staffId);


    int insert(Staff record);


    Staff selectByPrimaryKey(Integer staffId);


    List<Staff> selectAll();

    List<Staff> selectName();


    List<Staff> selectByPage(@Param("staffDto") StaffDto staffDto);


    int updateByPrimaryKey(Staff record);

    int updatePasswd(Staff record);

    /**
     * 根据工号查询员工id
     * @param jobNumber
     * @return
     */
    Staff selectStaffIdByNumber(@Param("jobNumber") String jobNumber);

    /**
     * 获取所有员工信息
     * @return
     */
    List<Staff>  selectAllStaff();
}