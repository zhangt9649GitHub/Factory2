package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.FactoryManagement;
import com.mingyuansoftware.aifactory.model.dto.FactoryManagementDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.FactoryManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 张婷
 * @date 2019/10/14 13:50
 */

@Api(value = "FactoryManagement", description = "所属工厂管理API", tags = {"基础资料-所属工厂管理"})
@RestController
@RequestMapping("/factoryManagement")
public class FactoryManagementController {

    @Autowired
    private FactoryManagementService factoryManagementService;

    @ApiOperation(value = "所属工厂管理列表", nickname = "/selectFactoryManagementList", notes = "获取所属工厂管理列表", tags = {"@张婷"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "factoryManagementDto", value = "所属工厂管理参数实体类", paramType = "query", dataType = "FactoryManagementDto"),
    })
    @RequestMapping(value = "/getFactoryManagementList", method = RequestMethod.GET)
    @ResponseBody
//    @RequiresPermissions(value = {"getFactoryManagementList"})
    public LayuiCommonResponse getFactoryManagementList(@Validated @RequestParam(defaultValue = "1") int page,
                                                         @Validated @RequestParam(defaultValue = "10") int limit,
                                                         @Validated FactoryManagementDto factoryManagementDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<FactoryManagementDto> factoryManagementList = factoryManagementService.selectFactoryManagementList(factoryManagementDto);
            int count = factoryManagementService.selectCount(factoryManagementDto);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCount(count);
            response.setData(factoryManagementList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "新增所属工厂管理", nickname = "/insertFactoryManagement", notes = "添加所属工厂管理", tags = {"@张婷"})
    @ApiImplicitParam(name = "factoryManagement", value = "所属工厂管理实体类", required = true, dataType = "FactoryManagement")
    @RequestMapping(value = "/insertFactoryManagement", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresPermissions(value = {"insertFactoryManagement"})
    public LayuiCommonResponse insertFactoryManagement(@RequestBody FactoryManagement factoryManagement) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int insertFactoryManagement = factoryManagementService.insertFactoryManagement(factoryManagement);
            if(insertFactoryManagement < 1){
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

    @ApiOperation(value = "删除所属工厂管理", nickname = "/deleteFactoryManagement", notes = "删除所属工厂管理", tags = {"@张婷"})
    @ApiImplicitParam(name = "fmId", value = "所属工厂管理Id",required = true, paramType = "query", dataType = "int")
    @RequestMapping(value = "/deleteFactoryManagement", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresPermissions(value = {"deleteFactoryManagement"})
    public LayuiCommonResponse deleteFactoryManagement(int fmId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int deleteFactoryManagement = factoryManagementService.deleteFactoryManagement(fmId);
            if(deleteFactoryManagement < 1){
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

    @ApiOperation(value = "查看所属工厂管理", nickname = "/selectFactoryManagementById", notes = "通过Id获取所属工厂管理", tags = {"@张婷"})
    @ApiImplicitParam(name = "fmId", value = "所属工厂管理Id",required = true, paramType = "query", dataType = "int")
    @RequestMapping(value = "/getFactoryManagementById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getFactoryManagementById(int fmId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            FactoryManagement factoryManagement = factoryManagementService.selectFactoryManagementById(fmId);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setData(factoryManagement);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "更新人员派遣公司管理", nickname = "/updateFactoryManagement", notes = "更新人员派遣公司管理", tags = {"@张婷"})
    @ApiImplicitParam(name = "factoryManagement", value = "人员派遣公司管理实体类", dataType = "FactoryManagement")
    @RequestMapping(value = "/updateFactoryManagement", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresPermissions(value = {"updateFactoryManagement"})
    public LayuiCommonResponse updateFactoryManagement(@RequestBody FactoryManagement factoryManagement) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int updateFactoryManagement = factoryManagementService.updateFactoryManagement(factoryManagement);
            if(updateFactoryManagement < 1){
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

}
