package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.StaffInsurance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface StaffInsuranceMapper {
    int deleteByPrimaryKey(Integer insuranceId);

    int insert(StaffInsurance record);

    StaffInsurance selectByPrimaryKey(Integer insuranceId);

    List<StaffInsurance> selectAll();

    int updateByPrimaryKey(StaffInsurance record);

    /**
     * 根据员工id获取保险设置
     * @param staffId
     * @return
     */
    StaffInsurance selectByStaffId(@Param("staffId") int staffId);

    /**
     * 根据员工id删除保险设置
     * @param staffId
     */
    void deleteByStaffId(@Param("staffId") int staffId);
}