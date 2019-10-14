package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.DispatchingCompany;
import com.mingyuansoftware.aifactory.model.dto.DispatchingCompanyDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.DispatchingCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 张婷
 * @date 2019/10/14 9:50
 */

@Api(value = "DispatchingCompany", description = "人员派遣公司管理API", tags = {"基础资料-人员派遣公司管理"})
@RestController
@RequestMapping("/dispatchingCompany")
public class DispatchingCompanyController {

    @Autowired
    private DispatchingCompanyService dispatchingCompanyService;

    @ApiOperation(value = "人员派遣公司管理列表", nickname = "/selectDispatchingCompanyList", notes = "获取人员派遣公司管理列表", tags = {"@张婷"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "dispatchingCompanyDto", value = "人员派遣公司管理参数实体类", paramType = "query", dataType = "DispatchingCompanyDto"),
    })
    @RequestMapping(value = "/getDispatchingCompanyList", method = RequestMethod.GET)
    @ResponseBody
//    @RequiresPermissions(value = {"getDispatchingCompanyList"})
    public LayuiCommonResponse getDispatchingCompanyList(@Validated @RequestParam(defaultValue = "1") int page,
                                                    @Validated @RequestParam(defaultValue = "10") int limit,
                                                    @Validated DispatchingCompanyDto dispatchingCompanyDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<DispatchingCompanyDto> dispatchingCompanyList = dispatchingCompanyService.selectDispatchingCompanyList(dispatchingCompanyDto);
            int count = dispatchingCompanyService.selectCount(dispatchingCompanyDto);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCount(count);
            response.setData(dispatchingCompanyList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "新增人员派遣公司管理", nickname = "/insertDispatchingCompany", notes = "添加人员派遣公司管理", tags = {"@张婷"})
    @ApiImplicitParam(name = "dispatchingCompany", value = "人员派遣公司管理实体类", required = true, dataType = "DispatchingCompany")
    @RequestMapping(value = "/insertDispatchingCompany", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresPermissions(value = {"insertDispatchingCompany"})
    public LayuiCommonResponse insertDispatchingCompany(@RequestBody DispatchingCompany dispatchingCompany) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int insertDispatchingCompany = dispatchingCompanyService.insertDispatchingCompany(dispatchingCompany);
            if(insertDispatchingCompany < 1){
                response.setCode(ZtCode.FAIL_ADD.getCode());
                response.setMsg(ZtCode.FAIL_ADD.getInfo());
                return response;
            }
            response.setCode(ZtCode.SUCCESS_ADD.getCode());
            response.setMsg(ZtCode.SUCCESS_ADD.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_ADD.getCode());
            response.setMsg(ZtCode.FAIL_ADD.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "删除人员派遣公司管理", nickname = "/deleteDispatchingCompany", notes = "删除人员派遣公司管理", tags = {"@张婷"})
    @ApiImplicitParam(name = "dcId", value = "人员派遣公司管理Id",required = true, paramType = "query", dataType = "int")
    @RequestMapping(value = "/deleteDispatchingCompany", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresPermissions(value = {"deleteDispatchingCompany"})
    public LayuiCommonResponse deleteDispatchingCompany(int dcId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int deleteDispatchingCompany = dispatchingCompanyService.deleteDispatchingCompany(dcId);
            if(deleteDispatchingCompany < 1){
                response.setCode(ZtCode.FAIL_DELETE.getCode());
                response.setMsg(ZtCode.FAIL_DELETE.getInfo());
                return response;
            }
            response.setCode(ZtCode.SUCCESS_DELETE.getCode());
            response.setMsg(ZtCode.SUCCESS_DELETE.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_DELETE.getCode());
            response.setMsg(ZtCode.FAIL_DELETE.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "查看人员派遣公司管理", nickname = "/selectDispatchingCompanyById", notes = "通过Id获取人员派遣公司管理", tags = {"@张婷"})
    @ApiImplicitParam(name = "dcId", value = "人员派遣公司管理Id",required = true, paramType = "query", dataType = "int")
    @RequestMapping(value = "/getDispatchingCompanyById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getDispatchingCompanyById(int dcId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            DispatchingCompany dispatchingCompany = dispatchingCompanyService.selectDispatchingCompanyById(dcId);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setData(dispatchingCompany);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "更新人员派遣公司管理", nickname = "/updateDispatchingCompany", notes = "更新人员派遣公司管理", tags = {"@张婷"})
    @ApiImplicitParam(name = "dispatchingCompany", value = "人员派遣公司管理实体类", dataType = "DispatchingCompany")
    @RequestMapping(value = "/updateDispatchingCompany", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresPermissions(value = {"updateDispatchingCompany"})
    public LayuiCommonResponse updateDispatchingCompany(@RequestBody DispatchingCompany dispatchingCompany) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int updateDispatchingCompany = dispatchingCompanyService.updateDispatchingCompany(dispatchingCompany);
            if(updateDispatchingCompany < 1){
                response.setCode(ZtCode.FAIL_EDIT.getCode());
                response.setMsg(ZtCode.FAIL_EDIT.getInfo());
                return response;
            }
            response.setCode(ZtCode.SUCCESS_EDIT.getCode());
            response.setMsg(ZtCode.SUCCESS_EDIT.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_EDIT.getCode());
            response.setMsg(ZtCode.FAIL_EDIT.getInfo());
        }
        return response;
    }

    /*
    1.新增
    {
      "insuranceCompany": "保险公司",
      "insuranceDeduction": 10023,
      "managementFee": 23
    }
    2.修改
    {
      "dcId": 1,
      "insuranceCompany": "编辑保险公司",
      "insuranceDeduction": 99.99,
      "managementFee": 90
    }
     */

}
