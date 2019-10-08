package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.StaffExperience;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface StaffExperienceMapper {

    int deleteByPrimaryKey(Integer experienceId);

    int insert(StaffExperience record);

    StaffExperience selectByPrimaryKey(Integer experienceId);

    List<StaffExperience> selectAll();

    int updateByPrimaryKey(StaffExperience record);

    /**
     * 获取员工经验值列表
     * @param staffId
     * @return
     */
    List<StaffExperience> selectStaffExperienceList(@Param("staffId") int staffId);
}