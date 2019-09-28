/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: InventoryCheckController
 * Author:   EDZ
 * Date:     2019/7/13 18:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.model.InventoryCheck;
import com.mingyuansoftware.aifactory.model.dto.InventoryCheckDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.InventoryCheckService;
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
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author EDZ
 * @create 2019/7/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/inventoryCheck")
@Api(value = "InventoryCheck", description = "库存盘点API", tags = {"库存盘点"})
public class InventoryCheckController {


    @Autowired
    private InventoryCheckService inventoryCheckService;

    @ApiOperation(value = "新增数据", notes = "新增数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "库存盘点实体类", required = true, dataType = "InventoryCheck")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @RequiresPermissions(value = {"insertInventoryCheck"})
    public LayuiCommonResponse insert(@RequestBody InventoryCheck record){

        try {
            int insert = inventoryCheckService.insert(record);
            return new LayuiCommonResponse(WlCode.SUCCESS_INSERT,insert,record);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_INSERT,0,"");
        }
    }
    @ApiOperation(value = "删除数据", notes = "删除数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "库存盘点id", required = true, dataType = "int")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @RequiresPermissions(value = {"deleteInventoryCheck"})
    public LayuiCommonResponse delete(int id){

        try {
            inventoryCheckService.deleteByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_DELETE,0,"");
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_DELETE,0,"");
        }
    }
    @ApiOperation(value = "获取数据", notes = "获取数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "库存盘点id", required = true, dataType = "int")
    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public LayuiCommonResponse getById(int id){
        try {
            InventoryCheck inventoryCheck = inventoryCheckService.selectByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,inventoryCheck);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }

    }
    /*@ApiOperation(value = "更新数据", notes = "更新数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "库存盘点实体类",required = true, dataType = "InventoryCheck")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public LayuiCommonResponse update(@RequestBody InventoryCheck record){

        try {
            inventoryCheckService.updateByPrimaryKey(record);
            return new LayuiCommonResponse(WlCode.SUCCESS_UPDAE,0,record);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_UPDATE,0,"");
        }
    }*/
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "inventoryCheckDto", value = "库存盘点参数实体类", paramType = "query", dataType = "InventoryCheckDto"),
    })
    @ApiOperation(value = "获取所有数据", notes = "获取所有数据", tags = {"@王力影"})
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    @RequiresPermissions(value = {"getInventoryCheckList"})
    public LayuiCommonResponse getAll(@Validated @RequestParam(defaultValue = "1") int page,
                                      @Validated @RequestParam(defaultValue = "10") int limit,
                                      @Validated InventoryCheckDto inventoryCheckDto){
        try {
            PageHelper.startPage(page, limit);
            List<InventoryCheck> inventoryChecks = inventoryCheckService.selectAll(inventoryCheckDto);
            Page<InventoryCheck> page1= (Page<InventoryCheck>) inventoryChecks;

            List<InventoryCheck> result = page1.getResult();
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,(int) page1.getTotal(), result);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }


}
