/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: StaffGroupAccessServiceImpl
 * Author:   EDZ
 * Date:     2019/7/23 16:51
 * Description: 员工权限组中间表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.StaffGroupAccessMapper;
import com.mingyuansoftware.aifactory.model.StaffGroupAccess;
import com.mingyuansoftware.aifactory.service.StaffGroupAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈员工权限组中间表〉
 *
 * @author EDZ
 * @create 2019/7/23
 * @since 1.0.0
 */
@Service
public class StaffGroupAccessServiceImpl implements StaffGroupAccessService {

    @Autowired
    private StaffGroupAccessMapper staffGroupAccessMapper;

    @Override
    public int deleteByPrimaryKey(Integer groupId, Integer accessId) {
        return 0;
    }

    @Override
    public int insert(StaffGroupAccess record) {

        return 0;
    }

    @Override
    public StaffGroupAccess selectByPrimaryKey(Integer groupId, Integer accessId) {
        return null;
    }

    @Override
    public List<StaffGroupAccess> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(StaffGroupAccess record) {
        return 0;
    }
}
