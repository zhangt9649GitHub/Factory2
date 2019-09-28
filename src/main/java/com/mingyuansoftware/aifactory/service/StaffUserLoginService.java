package com.mingyuansoftware.aifactory.service;




import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.dto.StaffUserLoginDto;
import org.springframework.stereotype.Service;

@Service
public interface StaffUserLoginService {

    /**
     * 根据账号密码查询获取用户登录信息
     * @param staffUserLoginDto
     * @return
     */
    StaffUserLoginDto select(StaffUserLoginDto staffUserLoginDto);

    /**
     * 更新登录时间和ip
     * @param userLogin
     */
    void updateUserLogin(Staff userLogin);

    /**
     * 查询用户根据用户名
     * @param adminName
     * @return
     */
    Staff selectByName(String adminName);
}
