package com.mingyuansoftware.aifactory.service.impl;


import com.mingyuansoftware.aifactory.mapper.StaffUserLoginMapper;

import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.dto.StaffUserLoginDto;
import com.mingyuansoftware.aifactory.service.StaffUserLoginService;
import com.mingyuansoftware.aifactory.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 张赛潮
 * @date 2019/7/12 17:52
 */
@Service
public class StaffUserLoginServiceImpl implements StaffUserLoginService {

    @Autowired
    private StaffUserLoginMapper staffUserLoginMapper;

    @Override
    public StaffUserLoginDto select(StaffUserLoginDto staffUserLoginDto) {
        String password = staffUserLoginDto.getPassword();
        String adminName = staffUserLoginDto.getAdminName();
//        如果用户名密码不为空就查询数据库
        if(password!=null&&password!=""&&adminName!=null&&adminName!=""){
//            对用户密码加密
            staffUserLoginDto.setPassword(MD5Util.encrypt(staffUserLoginDto.getPassword()));
            return staffUserLoginMapper.select(staffUserLoginDto);
        }else{
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateUserLogin(Staff userLogin) {
        staffUserLoginMapper.updateUserLogin(userLogin);
    }

    @Override
    public Staff selectByName(String adminName) {
        return staffUserLoginMapper.selectByName(adminName);
    }
}
