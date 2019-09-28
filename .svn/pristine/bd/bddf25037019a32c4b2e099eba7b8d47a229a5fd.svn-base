/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: ReimburseController
 * Author:   EDZ
 * Date:     2019/7/11 10:16
 * Description: 报销单
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.model.Reimburse;
import com.mingyuansoftware.aifactory.model.StorageAccess;
import com.mingyuansoftware.aifactory.model.dto.ReimburseDto;
import com.mingyuansoftware.aifactory.model.dto.StorageAccessDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.ReimburseService;
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
 * 〈报销单〉
 *
 * @author EDZ
 * @create 2019/7/11
 * @since 1.0.0
 */
@RestController
@RequestMapping("/reimburse")
@Api(value = "Reimburse", description = "报销单API", tags = {"报销单"})
public class ReimburseController {

    @Autowired
    private ReimburseService reimburseService;

    @ApiOperation(value = "新增数据", notes = "新增数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "reimburse", value = "报销单实体类", required = true, dataType = "Reimburse")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @RequiresPermissions(value = {"insertReimburse"})
    public LayuiCommonResponse insert(@RequestBody Reimburse reimburse){

        try {
            int insert = reimburseService.insert(reimburse);
            return new LayuiCommonResponse(WlCode.SUCCESS_INSERT,insert,reimburse);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_INSERT,0,"");
        }
    }
    @ApiOperation(value = "删除数据", notes = "删除数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "报销单id", required = true, dataType = "int")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @RequiresPermissions(value = {"deleteReimburse"})
    public LayuiCommonResponse delete(int id){

        try {
            int i = reimburseService.deleteByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_DELETE,i,"");
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_DELETE,0,"");
        }
    }
    @ApiOperation(value = "获取数据", notes = "获取数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "报销单id", required = true, dataType = "int")
    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public LayuiCommonResponse getById(int id){
        try {
            Reimburse reimburse = reimburseService.selectByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,reimburse);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }
    @ApiOperation(value = "更新数据", notes = "更新数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "报销单实体类",required = true, dataType = "Reimburse")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @RequiresPermissions(value = {"updateReimburse"})
    public LayuiCommonResponse update(@RequestBody Reimburse record){

        try {
            reimburseService.updateByPrimaryKey(record);
            return new LayuiCommonResponse(WlCode.SUCCESS_UPDAE,0,record);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_UPDATE,0,"");
        }
    }

    @ApiOperation(value = "获取报销单列表",notes = "获取报销单列表", tags = {"@王力影"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "reimburseDto", value = "报销单实体类", paramType = "query", dataType = "ReimburseDto"),
    })
    @RequestMapping(value = "/getReimburseList",method = RequestMethod.POST)
    @RequiresPermissions(value = {"getReimburseList"})
    public LayuiCommonResponse getAll(@Validated @RequestParam(defaultValue = "1") int page,
                                      @Validated @RequestParam(defaultValue = "10") int limit,
                                      @Validated ReimburseDto reimburseDto){

        try {
            PageHelper.startPage(page, limit);
            List<Reimburse> reimburses = reimburseService.selectAll(reimburseDto);
            Page<Reimburse> page1= (Page<Reimburse>) reimburses;
            List<Reimburse> result = page1.getResult();
            return new LayuiCommonResponse(WlCode.SUCCESS_GET, (int) page1.getTotal(), result);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"" );
        }
    }
}
