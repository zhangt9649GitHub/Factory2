/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: StaffAccessController
 * Author:   EDZ
 * Date:     2019/7/25 10:46
 * Description: 员工权限
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.controller;

import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.model.StaffAccess;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.StaffAccessService;
import com.mingyuansoftware.aifactory.service.StaffAccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈员工权限〉
 *
 * @author EDZ
 * @create 2019/7/25
 * @since 1.0.0
 */
@RestController
@RequestMapping("/staffAccess")
@Api(value = "StaffAccess", description = "员工权限API", tags = {"员工权限"})
public class StaffAccessController {
    @Autowired
    private StaffAccessService staffAccessService;

    @ApiOperation(value = "新增数据", notes = "新增数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "员工权限实体类", required = true, dataType = "StaffAccess")
    @RequestMapping(value = "/insertStaffAccess",method = RequestMethod.POST)
    @RequiresPermissions(value ={"insertStaffAccess"} )
    public LayuiCommonResponse insert(@RequestBody StaffAccess record){

        try {
            staffAccessService.insert(record);
            return new LayuiCommonResponse(WlCode.SUCCESS_INSERT,0,record);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_INSERT,0,"");
        }
    }



    @ApiOperation(value = "删除数据", notes = "删除数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "员工权限id", required = true, dataType = "int")
    @RequestMapping(value = "/deleteStaffAccess",method = RequestMethod.POST)
    @RequiresPermissions(value = {"deleteStaffAccess"})
    public LayuiCommonResponse delete(int id){

        try {
            staffAccessService.deleteByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_DELETE,0,"");
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_DELETE,0,"");
        }
    }
    @ApiOperation(value = "获取数据", notes = "获取数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "员工权限id", required = true, dataType = "int")
    @RequestMapping(value = "/getStaffAccessById",method = RequestMethod.POST)
    public LayuiCommonResponse getById(int id){

        try {
            StaffAccess staffAccess = staffAccessService.selectByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,staffAccess);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }
    @ApiOperation(value = "更新数据", notes = "更新数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "员工权限实体类",required = true, dataType = "StaffAccess")
    @RequestMapping(value = "/updateStaffAccess",method = RequestMethod.POST)
    @RequiresPermissions(value = {"updateStaffAccess"})
    public LayuiCommonResponse update(@RequestBody StaffAccess record){

        try {
            staffAccessService.updateByPrimaryKey(record);
            return new LayuiCommonResponse(WlCode.SUCCESS_UPDAE,0,record);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_UPDATE,0,"");
        }
    }
    @ApiOperation(value = "获取所有数据", notes = "获取所有数据", tags = {"@王力影"})
    @RequestMapping(value = "/getStaffAccessList",method = RequestMethod.POST)
    @RequiresPermissions(value = {"getStaffAccessList"})
    public LayuiCommonResponse getAll(){

        try {
            List<StaffAccess> staffAccesses = staffAccessService.selectAll();
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,staffAccesses);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }
}
