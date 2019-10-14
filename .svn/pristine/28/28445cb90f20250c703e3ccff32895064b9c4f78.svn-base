package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.FactoryManagementMapper;
import com.mingyuansoftware.aifactory.model.FactoryManagement;
import com.mingyuansoftware.aifactory.model.dto.FactoryManagementDto;
import com.mingyuansoftware.aifactory.service.FactoryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 张婷
 * @date 2019/10/14 13:52
 */

@Service
public class FactoryManagementServiceImpl implements FactoryManagementService {

    @Autowired
    private FactoryManagementMapper factoryManagementMapper;

    @Override
    public List<FactoryManagementDto> selectFactoryManagementList(FactoryManagementDto factoryManagementDto) {
        try {
            return factoryManagementMapper.selectFactoryManagementList(factoryManagementDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCount(FactoryManagementDto factoryManagementDto) {
        try {
            return factoryManagementMapper.selectCount(factoryManagementDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertFactoryManagement(FactoryManagement factoryManagement) {
        factoryManagement.setCreateTime(new Date());
        factoryManagement.setIsDelete((byte) 0);
        int insertFac = factoryManagementMapper.insert(factoryManagement);
        return insertFac;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteFactoryManagement(int fmId) {
        int delFac = factoryManagementMapper.updateByFmId(fmId);
        return delFac;
    }

    @Override
    public FactoryManagement selectFactoryManagementById(int fmId) {
        try {
            return factoryManagementMapper.selectByPrimaryKey(fmId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateFactoryManagement(FactoryManagement factoryManagement) {
        try {
            FactoryManagement factoryManagement1 = factoryManagementMapper.selectByPrimaryKey(factoryManagement.getFmId());
            factoryManagement.setCreateTime(factoryManagement1.getCreateTime());
            factoryManagement.setIsDelete(factoryManagement1.getIsDelete());
            factoryManagement.setUpdateTime(new Date());
            return factoryManagementMapper.updateByPrimaryKey(factoryManagement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
