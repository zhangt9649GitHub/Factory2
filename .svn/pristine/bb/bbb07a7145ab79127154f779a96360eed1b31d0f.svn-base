package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.Warehouse;
import com.mingyuansoftware.aifactory.model.dto.WarehouseDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.WarehouseService;
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
 * @date 2019/6/27 14:08
 */

@Api(value = "warehouse", description = "仓库列表", tags = {"仓库管理-仓库列表"})
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @ApiOperation(value = "获取仓库列表", nickname = "selectWarehouseAll", notes = "查询仓库信息", tags = "@张婷")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "warehouseDto",value = "仓库查询参数实体类",paramType = "query",dataType = "WarehouseDto"),
    })
    @RequestMapping(value = "/selectWarehouseAll", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"selectWarehouseAll"})
    public LayuiCommonResponse selectWarehouseAll(@Validated @RequestParam(defaultValue = "1") int page,
                                                  @Validated @RequestParam(defaultValue = "10") int limit,
                                                  @Validated WarehouseDto warehouseDto) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);

            List<Warehouse> selectWarehouseAll = warehouseService.selectWarehouseAll(warehouseDto);
            Integer count = warehouseService.count(warehouseDto);

            layuiCommonResponse.setData(selectWarehouseAll);
            layuiCommonResponse.setCount(count);
            layuiCommonResponse.setCode(ZtCode.SUCCESS_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_GET.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return layuiCommonResponse;
    }

    @ApiOperation(value = "添加仓库", nickname = "addWarehouse", notes = "添加仓库", tags = "@张婷")
    @RequestMapping(value = "/addWarehouse", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"addWarehouse"})
    public LayuiCommonResponse addWarehouse(@RequestBody Warehouse warehouse) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            Integer addWarehouse = warehouseService.addWarehouse(warehouse);
            if (addWarehouse < 1) {
                layuiCommonResponse.setCode(ZtCode.FAIL_ADD.getCode());
                layuiCommonResponse.setMsg(ZtCode.FAIL_ADD.getInfo());
                return layuiCommonResponse;
            }

            layuiCommonResponse.setCode(ZtCode.SUCCESS_ADD.getCode());
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_ADD.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_ADD.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_ADD.getInfo());
        }
        return layuiCommonResponse;
    }

    @ApiOperation(value = "仓库名字查询重复", nickname = "warehouseNameCheck", notes = "仓库名字查询是否可用", tags = "@张婷")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "warehouseId", value = "仓库Id", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "warehouseName", value = "仓库名称", paramType = "query", dataType = "String")})
    @RequestMapping(value = "/warehouseNameCheck", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse warehouseNameCheck(Integer warehouseId, String warehouseName) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        //添加时候没有仓库Id,设置仓库Id为0
        if(warehouseId == null){
            warehouseId = 0;
        }
        //如果通过名字查询到的id和传过来的id一样可以使用(修改使用),如果id不同,则可以添加新的仓库名称
        boolean checkResult = warehouseService.warehouseNameCheck(warehouseId, warehouseName);
        if (!checkResult) {
            layuiCommonResponse.setCode(ZtCode.UNABLE_CHECKNAME.getCode());
            layuiCommonResponse.setMsg(ZtCode.UNABLE_CHECKNAME.getInfo());
        } else {
            layuiCommonResponse.setCode(ZtCode.CAN_USERNAME.getCode());
            layuiCommonResponse.setMsg(ZtCode.CAN_USERNAME.getInfo());
        }
        return layuiCommonResponse;
    }

    @ApiOperation(value = "查询编辑仓库信息根据仓库id", nickname = "selectEditWarehouse", notes = "查询编辑仓库信息", tags = "@张婷")
    @ApiImplicitParam(name = "warehouseId", value = "仓库id", paramType = "query", dataType = "int")
    @RequestMapping(value = "/selectEditWarehouse", method = RequestMethod.GET)
    @ResponseBody
    public LayuiCommonResponse selectEditWarehouse(Integer warehouseId) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            Warehouse selectEditWarehouse = warehouseService.selectEditWarehouse(warehouseId);
            layuiCommonResponse.setCode(ZtCode.SUCCESS_GET.getCode());
            layuiCommonResponse.setData(selectEditWarehouse);
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_GET.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return layuiCommonResponse;
    }

    @ApiOperation(value = "编辑仓库", nickname = "editWarehouse", notes = "编辑仓库", tags = "@张婷")
    @RequestMapping(value = "/editWarehouse", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"editWarehouse"})
    public LayuiCommonResponse editWarehouse(@RequestBody Warehouse warehouse) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            Integer editWarehouse = warehouseService.editWarehouse(warehouse);
            if (editWarehouse < 1) {
                layuiCommonResponse.setCode(ZtCode.FAIL_EDIT.getCode());
                layuiCommonResponse.setMsg(ZtCode.FAIL_EDIT.getInfo());
                return layuiCommonResponse;
            }

            layuiCommonResponse.setCode(ZtCode.SUCCESS_EDIT.getCode());
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_EDIT.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_EDIT.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_EDIT.getInfo());
        }
        return layuiCommonResponse;
    }

    @ApiOperation(value = "删除仓库", nickname = "deletetWarehouse", notes = "删除仓库", tags = "@张婷")
    @ApiImplicitParam(name = "warehouseId", value = "仓库id", paramType = "query", dataType = "int")
    @RequestMapping(value = "/deletetWarehouse", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"deletetWarehouse"})
    public LayuiCommonResponse deletetWarehouse(Integer warehouseId) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            //先查询仓库下的仓位状态,如果有东西提示用户先删除仓位
            Integer deletetWarehouse = warehouseService.deletetWarehouse(warehouseId);
            if (deletetWarehouse < 1) {
                layuiCommonResponse.setCode(ZtCode.FAIL_DELETE.getCode());
                layuiCommonResponse.setMsg(ZtCode.FAIL_DELETE.getInfo());
                return layuiCommonResponse;
            }
            layuiCommonResponse.setCode(ZtCode.SUCCESS_DELETE.getCode());
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_DELETE.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_DELETE.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_DELETE.getInfo());
        }
        return layuiCommonResponse;
    }

}
