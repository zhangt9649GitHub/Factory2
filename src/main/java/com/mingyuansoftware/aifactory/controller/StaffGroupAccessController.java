/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: StaffGroupAccessController
 * Author:   EDZ
 * Date:     2019/7/23 16:59
 * Description: 员工组中间表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.StaffAccessGroupDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.StaffAccessGroupService;
import com.mingyuansoftware.aifactory.service.StaffAccessService;
import com.mingyuansoftware.aifactory.service.StaffGroupAccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈员工组中间表〉
 *
 * @author EDZ
 * @create 2019/7/23
 * @since 1.0.0
 */
@Api(value = "staffGroupAccess", description = "员工组API", tags = {"员工组"})
@RestController
@RequestMapping("/staffGroupAccess")
public class StaffGroupAccessController {
    @Autowired
    private StaffAccessGroupService staffAccessGroupService;

    @Autowired
    private StaffAccessService staffAccessService;

    @ApiOperation(value = "获取新增所有权限", nickname = "accessTreeAll", notes = "", tags={ "@王力影" })
    @RequestMapping(value = "/accessTreeAll",method = RequestMethod.GET)
    public LayuiCommonResponse accessTreeAll() {

        try{
            List<StaffAccess> staffAccesses = staffAccessService.selectByParId(0);

            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,staffAccesses);

        }catch (Exception e){
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }

    }

    @ApiOperation(value = "权限管理列表", nickname = "groupAccessList", notes = "", tags={ "@王力影" })
    @ApiImplicitParams({
            @ApiImplicitParam(name="page", value="第几页",paramType="query",dataType="int"),
            @ApiImplicitParam(name="limit", value="每页容量",paramType="query",dataType="int")

    })
    @RequestMapping(value = "/getGroupAccessList",method = RequestMethod.GET)
    @RequiresPermissions(value = {"getGroupAccessList"})
    public LayuiCommonResponse list(@Validated @RequestParam(defaultValue = "1") int page, @Validated @RequestParam(defaultValue = "10") int limit,
                                    StaffAccessGroupDto staffAccessGroupDto) {

        try{
            PageHelper.startPage(page,limit);
            List<StaffAccessGroup> staffAccessGroups = staffAccessGroupService.selectAll(staffAccessGroupDto);
            Page<StaffAccessGroup> page1= (Page<StaffAccessGroup>) staffAccessGroups;
            List<StaffAccessGroup> result = page1.getResult();
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,(int) page1.getTotal(),result);

        }catch (Exception e){
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }

    }


    @ApiOperation(value = "添加权限组", nickname = "addGroupAccess", notes = "", tags={ "@王力影" })
    @RequestMapping(value = "/addGroupAccess",method = RequestMethod.POST)
    @RequiresPermissions(value = {"addGroupAccess"})
    public LayuiCommonResponse addGroupAccess(@RequestBody StaffAccessGroup staffAccessGroup) {

        try{
            Staff user =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
            staffAccessGroup.setStaffId(user.getStaffId());
            staffAccessGroupService.insert(staffAccessGroup);

            return new LayuiCommonResponse(WlCode.SUCCESS_INSERT,0,staffAccessGroup);

        }catch (Exception e){
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_INSERT,0,"");
        }

    }

    @ApiOperation(value = "删除权限组", nickname = "deleteGroupAccess", notes = "", tags={ "@王力影" })
    @ApiImplicitParam(name="groupId", value="权限组id",paramType="query",dataType="int",required=true)
    @RequestMapping(value = "/deleteGroupAccess",method = RequestMethod.POST)
    @RequiresPermissions(value = {"deleteGroupAccess"})
    public LayuiCommonResponse deleteGroupAccess(@Validated int groupId) {

        try{

            staffAccessGroupService.deleteByPrimaryKey(groupId);
            return new LayuiCommonResponse(WlCode.SUCCESS_DELETE,0,"");
        }catch (Exception e){
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_DELETE,0,"");
        }

    }

    @ApiOperation(value = "编辑权限组-编辑信息", nickname = "selectEditGroupTree", notes = "", tags={ "@王力影" })
    @ApiImplicitParam(name="groupId", value="权限组id",paramType="query",dataType="int",required=true)
    @RequestMapping(value = "/getGroupTreeById",method = RequestMethod.POST)
    public LayuiCommonResponse selectEditGroupTree(@Validated int groupId) {

        try{
            StaffAccessGroup staffAccessGroup = staffAccessGroupService.selectByPrimaryKey(groupId);
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,staffAccessGroup);
        }catch (Exception e){
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }

    @ApiOperation(value = "更新权限组", nickname = "editGroupAccess", notes = "", tags={ "@王力影" })
    @RequestMapping(value = "/updateGroupAccess",method = RequestMethod.POST)
    @RequiresPermissions(value = {"updateGroupAccess"})
    public LayuiCommonResponse editGroupAccess(@Validated @RequestBody  StaffAccessGroup staffAccessGroup) {

        try{
            staffAccessGroupService.updateByPrimaryKey(staffAccessGroup);
            return new LayuiCommonResponse(WlCode.SUCCESS_UPDAE,0,staffAccessGroup);
        }catch (Exception e){
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_UPDATE,0,"");
        }

    }
}
