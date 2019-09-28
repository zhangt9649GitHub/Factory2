/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: StaffAccessGroupServiceImpl
 * Author:   EDZ
 * Date:     2019/7/24 13:36
 * Description: 权限
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.StaffAccessGroupMapper;
import com.mingyuansoftware.aifactory.mapper.StaffAccessMapper;
import com.mingyuansoftware.aifactory.mapper.StaffGroupAccessMapper;
import com.mingyuansoftware.aifactory.model.StaffAccess;
import com.mingyuansoftware.aifactory.model.StaffAccessGroup;
import com.mingyuansoftware.aifactory.model.dto.StaffAccessGroupDto;
import com.mingyuansoftware.aifactory.service.StaffAccessGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈权限〉
 *
 * @author EDZ
 * @create 2019/7/24
 * @since 1.0.0
 */
@Service
public class StaffAccessGroupServiceImpl implements StaffAccessGroupService {

    @Autowired
    private StaffAccessGroupMapper staffAccessGroupMapper;

    @Autowired
    private StaffGroupAccessMapper staffGroupAccessMapper;

    @Autowired
    private StaffAccessMapper staffAccessMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer groupId) {
        staffAccessGroupMapper.deleteByPrimaryKey(groupId);
        int i = staffGroupAccessMapper.deleteByPrimaryKey(groupId);
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(StaffAccessGroup record) {
        record.setAddTime(new Date());
        int insert = staffAccessGroupMapper.insert(record);
        int insert1 = staffGroupAccessMapper.insert(record);
        return insert1;
    }

    @Override
    public StaffAccessGroup selectByPrimaryKey(Integer groupId) {
        StaffAccessGroup staffAccessGroup = staffAccessGroupMapper.selectByPrimaryKey(groupId);
        List<StaffAccess> staffAccesses = staffAccessMapper.selectAll();
        List<StaffAccess> staffAccesses1 = staffAccessMapper.selectByGroupId(groupId);

        for(StaffAccess access : staffAccesses){
            for(StaffAccess access1 : staffAccesses1){
                if(access.getAccessId().equals(access1.getAccessId())){
                    access.setMark(1);
                }
            }
        }

        List<StaffAccess> handleAccessTree = handleAccessTree(staffAccesses);
        staffAccessGroup.setAccessTree(handleAccessTree);

        return staffAccessGroup;
    }

    @Override
    public List<StaffAccessGroup> selectAll(StaffAccessGroupDto staffAccessGroupDto) {
        return staffAccessGroupMapper.selectAll(staffAccessGroupDto);
    }

    @Override
    public List<StaffAccessGroup> selectList() {
        return staffAccessGroupMapper.selectList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKey(StaffAccessGroup record) {
        staffAccessGroupMapper.updateByPrimaryKey(record);
        staffGroupAccessMapper.deleteByPrimaryKey(record.getGroupId());
        int insert = staffGroupAccessMapper.insert(record);
        return insert;

    }

    /**
     * 处理权限树
     * @param accessAll
     * @return
     */

    public List<StaffAccess> handleAccessTree(List<StaffAccess> accessAll) {
        List<StaffAccess> returnAccessAll = new ArrayList<>();

        for(StaffAccess access : accessAll){
            int accessModuleId = access.getAccessModuleId();
            List<StaffAccess> accesses = new ArrayList<>();
            List<StaffAccess> accessThree = new ArrayList<>();
            if(access.getAccessModuleId() == 0){
                returnAccessAll.add(access);
            }else{
                for(StaffAccess access1 : returnAccessAll){
                    if(accessModuleId == access1.getAccessId()){
                        if(access1.getChildren() == null){
                            accesses.add(access);
                            access1.setChildren(accesses);
                        }else{
                            access1.getChildren().add(access);
                        }
                    }else{
                        if(access1.getChildren().size() != 0){//防止没有三级权限
                            for(StaffAccess access2 : access1.getChildren()){
                                if(accessModuleId == access2.getAccessId()){
                                    if(access2.getChildren() == null){
                                        accessThree.add(access);
                                        access2.setChildren(accessThree);
                                    }else {
                                        access2.getChildren().add(access);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return returnAccessAll;
    }

   /* public List<StaffAccess> handleAccessTree(List<StaffAccess> accessAll) {
        List<StaffAccess> returnAccessAll = new ArrayList<>();
        *//*处理权限树*//*
        for(StaffAccess access : accessAll){
            int accessModuleId = access.getAccessModuleId();

            List<StaffAccess> accessThree = new ArrayList<>();
            if(access.getAccessModuleId() == 0){*//*如果是一级侧边栏*//*
                returnAccessAll.add(access);
            }
            for(StaffAccess access1 : accessAll){
                if(access1.getAccessModuleId() == access.getAccessId()){*//*如果是一级侧边栏*//*

                    if(access.getChildren() == null){
                        List<StaffAccess> myChildrens = new ArrayList<>();
                        myChildrens.add(access1);
                        access.setChildren(myChildrens);
                    }else{
                        access.getChildren().add(access1);
                    }

                }

            }

        }
        return returnAccessAll;
    }*/
}
