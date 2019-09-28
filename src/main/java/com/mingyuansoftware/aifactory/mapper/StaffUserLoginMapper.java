package com.mingyuansoftware.aifactory.mapper;




import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.dto.StaffUserLoginDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StaffUserLoginMapper {

    /**
     * 根据账号密码查出用户
     //* @param adminUserLoginDto
     * @return
     */

    StaffUserLoginDto select(@Param("staffUserLoginDto") StaffUserLoginDto staffUserLoginDto);

    /**
     * 修改用户登录ip 时间
     * @param userLogin
     */
    void updateUserLogin(@Param("userLogin") Staff userLogin);

    /**
     * 根据账号查出用户
     * @param adminName
     * @return
     */
    Staff selectByName(String adminName);
}
