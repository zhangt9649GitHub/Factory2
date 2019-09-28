package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.Warehouse;
import com.mingyuansoftware.aifactory.model.WarehousePosition;
import com.mingyuansoftware.aifactory.model.dto.WarehousePositionDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.WarehousePositionService;
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
 * @date 2019/6/27 15:56
 */

@RestController
@Api(value = "warehousePosition",description = "仓位列表",tags = {"仓位管理-仓位列表"})
@RequestMapping("/warehousePosition")
public class WarehousePositionController {

    @Autowired
    private WarehousePositionService warehousePositionService;
    @Autowired
    private WarehouseService warehouseService;

    @ApiOperation(value = "获取仓位列表",nickname = "selectWarehousePositionAll",notes = "查询仓位信息",tags = "@张婷")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "wpName", value = "仓位名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "warehouseName", value = "仓库名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "createTime", value = "仓位创建时间", paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/selectWarehousePositionAll",method = RequestMethod.GET)
    @RequiresPermissions(value = {"selectWarehousePositionAll"})
    public LayuiCommonResponse selectWarehousePositionAll(
            @Validated @RequestParam(defaultValue = "1") int page,
            @Validated @RequestParam(defaultValue = "10") int limit,
            String wpName , String warehouseName , String createTime) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            WarehousePositionDto wpd = new WarehousePositionDto();
            wpd.setWpName(wpName);
            wpd.setWarehouseName(warehouseName);
            wpd.setCreateTime(createTime);
            List<WarehousePositionDto> selectWarehousePositionAll = warehousePositionService.selectWarehousePositionAll(wpd);
            Integer count = warehousePositionService.count(wpd);

            layuiCommonResponse.setCode(ZtCode.SUCCESS_GET.getCode());
            layuiCommonResponse.setData(selectWarehousePositionAll);
            layuiCommonResponse.setCount(count);
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_GET.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return layuiCommonResponse;
    }


    @ApiOperation(value = "添加仓位", nickname = "addWarehousePosition", notes = "添加仓位", tags = "@张婷")
    @RequestMapping(value = "/addWarehousePosition", method = RequestMethod.POST)
    @RequiresPermissions(value = {"addWarehousePosition"})
    public LayuiCommonResponse addWarehousePosition(@RequestBody WarehousePosition warehousePosition) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            Integer addWarehousePosition = warehousePositionService.addWarehousePosition(warehousePosition);
            if (addWarehousePosition < 1) {
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

   /* @ApiOperation(value = "仓库列表",notes = "warehouseList",tags = "张婷")
    @RequestMapping(value = "/warehouseList",method = RequestMethod.GET)
    public LayuiCommonResponse warehouseList() {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            List<Warehouse> warehouseList = warehouseService.warehouseList();
            layuiCommonResponse.setCode(ZtCode.SUCCESS_GET.getCode());
            layuiCommonResponse.setData(warehouseList);
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_GET.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return layuiCommonResponse;
    }
*/

    @ApiOperation(value = "查询编辑仓位信息根据仓位id", nickname = "selectEditWP", notes = "查询编辑仓位信息", tags = "@张婷")
    @ApiImplicitParam(name="warehousePositionId", value="仓位id",paramType="query",dataType="int")
    @RequestMapping(value = "/selectEditWP", method = RequestMethod.GET)
    public LayuiCommonResponse selectEditWP(Integer warehousePositionId) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            WarehousePosition selectEditWP = warehousePositionService.selectEditWP(warehousePositionId);
            layuiCommonResponse.setData(selectEditWP);
            layuiCommonResponse.setCode(ZtCode.SUCCESS_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.SUCCESS_GET.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            layuiCommonResponse.setCode(ZtCode.FAIL_GET.getCode());
            layuiCommonResponse.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return layuiCommonResponse;
    }

    //可修改内容:仓位名称,所属仓库,状态,备注,修改时间
    @ApiOperation(value = "编辑仓位",nickname = "editWP",notes = "编辑仓位",tags = "@张婷")
    @RequestMapping(value = "/editWP",method = RequestMethod.POST)
    @RequiresPermissions(value = {"editWP"})
    public LayuiCommonResponse editWP(@RequestBody WarehousePosition warehousePosition) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            Integer editWP = warehousePositionService.editWP(warehousePosition);
            if(editWP == null){
                layuiCommonResponse.setCode(ZtCode.FAIL_EDIT.getCode());
                layuiCommonResponse.setMsg(ZtCode.FAIL_EDIT.getInfo());
                return layuiCommonResponse;
            }
            if(editWP < 1){
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

    @ApiOperation(value = "删除仓位",nickname = "deletetWP",notes = "根据id修改is+_delete为1",tags = "@张婷")
    @ApiImplicitParam(name="warehousePositionId", value="仓位id",paramType="query",dataType="int")
    @RequestMapping(value = "/deleteWPById",method = RequestMethod.POST)
    @RequiresPermissions(value = {"deleteWPById"})
    public LayuiCommonResponse deleteWPById(Integer warehousePositionId) {
        LayuiCommonResponse layuiCommonResponse = new LayuiCommonResponse();
        try {
            Integer deleteWPById = warehousePositionService.deleteWPById(warehousePositionId);
            if (deleteWPById < 1){
                layuiCommonResponse.setCode(ZtCode.FAIL_DELETE.getCode());
                layuiCommonResponse.setMsg(ZtCode.FAIL_DELETE.getInfo());
                return layuiCommonResponse;
            }
            if (deleteWPById == null){
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
