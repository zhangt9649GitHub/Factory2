/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: StaffController
 * Author:   EDZ
 * Date:     2019/6/28 9:21
 * Description: 员工管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.model.Bizdictionary;
import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.StaffAccessGroup;
import com.mingyuansoftware.aifactory.model.dto.StaffDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.StaffAccessGroupService;
import com.mingyuansoftware.aifactory.service.StaffService;
import com.mingyuansoftware.aifactory.util.MyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈员工管理〉
 *
 * @author EDZ
 * @create 2019/6/28
 * @since 1.0.0
 */
@RestController
@RequestMapping("/staff")
@Api(value = "Staff", description = "员工管理API", tags = {"员工管理"})
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffAccessGroupService staffAccessGroupService;

    @ApiOperation(value = "获取员工列表", notes = "获取员工列表信息", tags = {"@王力影"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),

    })
    @RequestMapping(value = "/getStaffList", method = RequestMethod.POST)
    @RequiresPermissions(value = {"getStaffList"})
    public LayuiCommonResponse getGoodsList( @RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "10") int limit,
                                             StaffDto staffDto) {

       return staffService.getByPage(page,limit,staffDto);
    }

    @ApiOperation(value = "新增员工", notes = "新增员工", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "员工实体类", dataType = "Staff")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @RequiresPermissions(value = {"insertStaff"})
    public LayuiCommonResponse insert(@RequestBody Staff record)  {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            return staffService.insert(record);
        } catch (MyException e){
            response.setCode(WlCode.FAIL_INSERT.getCode());
            response.setMsg(e.getMessage());
            return response;
        } catch(Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_INSERT,0,record);
        }
    }

    @ApiOperation(value = "删除数据", notes = "删除数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "员工id", required = true, dataType = "int")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @RequiresPermissions(value = {"deleteStaff"})
    public LayuiCommonResponse delete(int id){

        try {
            return staffService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_DELETE,0,"");
        }
    }
    @ApiOperation(value = "获取数据", notes = "获取数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "员工id", required = true, dataType = "int")
    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public LayuiCommonResponse getById(int id){

        return staffService.getByid(id);
    }

    @ApiOperation(value = "获取调岗记录", notes = "获取调岗记录", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "员工id", required = true, dataType = "int")
    @RequestMapping(value = "/getRecordById",method = RequestMethod.POST)
    @RequiresPermissions(value = {"getRecordById"})
    public LayuiCommonResponse getAdjust(int id){

        return staffService.getAdjust(id);
    }


    @ApiOperation(value = "更新数据", notes = "更新数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "员工实体类", dataType = "Staff")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @RequiresPermissions(value = {"updateStaff"})
    public LayuiCommonResponse update(@RequestBody Staff record){
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            return staffService.update(record);
        } catch (MyException e){
            response.setCode(WlCode.FAIL_UPDATE.getCode());
            response.setMsg(e.getMessage());
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_UPDATE,0,"");
        }
    }

    @ApiOperation(value = "重置员工密码", notes = "重置员工密码", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "员工id", required = true, dataType = "int")
    @RequestMapping(value = "/updatePasswd",method = RequestMethod.POST)
    public LayuiCommonResponse updatePasswd(int id){

        try {
            staffService.updatePasswd(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_UPDAE,0,"");
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_UPDATE,0,"");
        }
    }


    @ApiOperation(value = "获取所有数据", notes = "获取所有数据", tags = {"@王力影"})
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public LayuiCommonResponse getAll(){

        return staffService.getAll();
    }

    @ApiOperation(value = "获取权限组列表", notes = "获取权限组列表", tags = {"@王力影"})
    @RequestMapping(value = "/getStaffAccessGroupList",method = RequestMethod.POST)
    public LayuiCommonResponse getAll1(){
        try {
            List<StaffAccessGroup> staffAccessGroups = staffAccessGroupService.selectList();
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,staffAccessGroups);
        } catch (Exception e) {
            e.printStackTrace();

            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }
}
