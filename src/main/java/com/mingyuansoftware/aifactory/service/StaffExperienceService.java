package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.StaffExperience;
import com.mingyuansoftware.aifactory.model.dto.StaffExperienceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffExperienceService {

    /**
     * 新增员工经验值
     * @param staffExperienceDto
     */
    void insertStaffExperience(StaffExperienceDto staffExperienceDto);

    /**
     * 获取员工经验值列表
     * @param staffId
     * @return
     */
    List<StaffExperience> selectStaffExperienceList(int staffId);
}
