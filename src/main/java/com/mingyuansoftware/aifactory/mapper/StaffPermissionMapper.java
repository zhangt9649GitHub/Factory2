package com.mingyuansoftware.aifactory.mapper;



import com.mingyuansoftware.aifactory.model.StaffPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffPermissionMapper {

    /**
     * 根据用户id查出用户所需的权限
     * @param uid
     * @return
     */
    List<StaffPermission> selectByUId(int uid);
}
