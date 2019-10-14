package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.DispatchingCompanyMapper;
import com.mingyuansoftware.aifactory.model.DispatchingCompany;
import com.mingyuansoftware.aifactory.model.dto.DispatchingCompanyDto;
import com.mingyuansoftware.aifactory.service.DispatchingCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 张婷
 * @date 2019/10/14 10:27
 */

@Service
public class DispatchingCompanyServiceImpl implements DispatchingCompanyService {

    @Autowired
    private DispatchingCompanyMapper dispatchingCompanyMapper;

    @Override
    public List<DispatchingCompanyDto> selectDispatchingCompanyList(DispatchingCompanyDto dispatchingCompanyDto) {
        try {
            return dispatchingCompanyMapper.selectDispatchingCompanyList(dispatchingCompanyDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCount(DispatchingCompanyDto dispatchingCompanyDto) {
        try {
            return dispatchingCompanyMapper.selectCount(dispatchingCompanyDto);
        } catch (Exception e) {
            e.printStackTrace();
        }return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insertDispatchingCompany(DispatchingCompany dispatchingCompany) {
        dispatchingCompany.setCreateTime(new Date());
        dispatchingCompany.setIsDelete((byte) 0);
        int insertDispatchingCompany = dispatchingCompanyMapper.insert(dispatchingCompany);
        return insertDispatchingCompany;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteDispatchingCompany(int dcId) {
        int deleteDis = dispatchingCompanyMapper.updateByDcId(dcId);
        return deleteDis;
    }

    @Override
    public DispatchingCompany selectDispatchingCompanyById(int dcId) {
        try {
            return dispatchingCompanyMapper.selectByPrimaryKey(dcId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int updateDispatchingCompany(DispatchingCompany dispatchingCompany) {
        DispatchingCompany dispatchingCompany1 = dispatchingCompanyMapper.selectByPrimaryKey(dispatchingCompany.getDcId());
        dispatchingCompany.setCreateTime(dispatchingCompany1.getCreateTime());
        dispatchingCompany.setIsDelete(dispatchingCompany1.getIsDelete());
        dispatchingCompany.setUpdateTime(new Date());
        int updateDis = dispatchingCompanyMapper.updateByPrimaryKey(dispatchingCompany);
        return updateDis;
    }
}
