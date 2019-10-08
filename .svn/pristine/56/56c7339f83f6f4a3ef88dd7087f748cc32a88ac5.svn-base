package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.StaffExperienceMapper;
import com.mingyuansoftware.aifactory.model.StaffExperience;
import com.mingyuansoftware.aifactory.model.dto.StaffExperienceDto;
import com.mingyuansoftware.aifactory.service.StaffExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffExperienceServiceImpl implements StaffExperienceService {

    @Autowired
    private StaffExperienceMapper staffExperienceMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertStaffExperience(StaffExperienceDto staffExperienceDto) {
        int staffId = staffExperienceDto.getStaffId();
        List<StaffExperience> staffExperienceList = staffExperienceMapper.selectStaffExperienceList(staffId);
        if(!(staffExperienceList.isEmpty())){
            for (StaffExperience staffExperience:staffExperienceList
            ) {
                staffExperienceMapper.deleteByPrimaryKey(staffExperience.getExperienceId());
            }
        }
        List<StaffExperience> staffExperienceList1 =staffExperienceDto.getStaffExperienceList();
        if(!(staffExperienceList1.isEmpty())){
            for (StaffExperience staffExperience:staffExperienceList1
                 ) {
                staffExperience.setStaffId(staffId);
                staffExperienceMapper.insert(staffExperience);
            }
        }
    }

    @Override
    public List<StaffExperience> selectStaffExperienceList(int staffId) {
        try{
            return staffExperienceMapper.selectStaffExperienceList(staffId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
