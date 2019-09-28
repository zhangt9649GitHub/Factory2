/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: StaffAccessServiceImpl
 * Author:   EDZ
 * Date:     2019/7/24 10:11
 * Description: 员工权限
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.StaffAccessMapper;
import com.mingyuansoftware.aifactory.mapper.StaffGroupAccessMapper;
import com.mingyuansoftware.aifactory.model.StaffAccess;
import com.mingyuansoftware.aifactory.service.StaffAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈员工权限〉
 *
 * @author EDZ
 * @create 2019/7/24
 * @since 1.0.0
 */
@Service
public class StaffAccessServiceImpl implements StaffAccessService {

    @Autowired
    private StaffAccessMapper staffAccessMapper;
    @Autowired
    private StaffGroupAccessMapper staffGroupAccessMapper;

    @Override
    public int deleteByPrimaryKey(Integer accessId) {
        staffGroupAccessMapper.deleteByAccessId(accessId);
        return staffAccessMapper.deleteByPrimaryKey(accessId);
    }

    @Override
    public int insert(StaffAccess record) {
        record.setAddTime(new Date());
        return staffAccessMapper.insert(record);
    }

    @Override
    public StaffAccess selectByPrimaryKey(Integer accessId) {
        return staffAccessMapper.selectByPrimaryKey(accessId);
    }

    @Override
    public List<StaffAccess> selectAll() {
        return staffAccessMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(StaffAccess record) {
        return staffAccessMapper.updateByPrimaryKey(record);
    }
    

    @Override
    public List<StaffAccess> selectByParId(Integer accessId) {
        return staffAccessMapper.selectByParId(accessId);
    }
}
