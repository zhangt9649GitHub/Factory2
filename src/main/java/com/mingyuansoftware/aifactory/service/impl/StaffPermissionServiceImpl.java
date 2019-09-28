package com.mingyuansoftware.aifactory.service.impl;


import com.mingyuansoftware.aifactory.mapper.StaffPermissionMapper;
import com.mingyuansoftware.aifactory.model.StaffPermission;
import com.mingyuansoftware.aifactory.service.StaffPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张赛潮
 * @date 2019/7/13 10:18
 */
@Service
public class StaffPermissionServiceImpl implements StaffPermissionService {


    @Autowired
    private StaffPermissionMapper staffPermissionMapper;

    @Override
    public List<StaffPermission> selectByUId(int uid) {
        return  staffPermissionMapper.selectByUId(uid);
    }
}
