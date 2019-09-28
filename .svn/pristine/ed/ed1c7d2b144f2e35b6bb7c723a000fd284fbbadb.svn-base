/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: SupplierController
 * Author:   EDZ
 * Date:     2019/6/29 14:17
 * Description: 供应商
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.controller;

import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.model.Supplier;
import com.mingyuansoftware.aifactory.model.SupplierContact;
import com.mingyuansoftware.aifactory.model.SupplierGoods;
import com.mingyuansoftware.aifactory.model.dto.StaffDto;
import com.mingyuansoftware.aifactory.model.dto.SupplierDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈供应商〉
 *
 * @author EDZ
 * @create 2019/6/29
 * @since 1.0.0
 */
@RestController
@RequestMapping("/supplier")
@Api(value = "Supplier", description = "供应商管理API", tags = {"供应商管理"})
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @ApiOperation(value = "供应商列表", notes = "获取供应商列表信息", tags = {"@王力影"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),

    })
    @RequestMapping(value = "/getSupList", method = RequestMethod.POST)
    @RequiresPermissions(value = {"getSupList"})
    public LayuiCommonResponse getGoodsList(@RequestParam(defaultValue = "1") int page,
                                            @RequestParam(defaultValue = "10") int limit,
                                            SupplierDto supplierDto) {

        return supplierService.getByPage(page,limit,supplierDto);
    }

    @ApiOperation(value = "新增供应商", notes = "新增供应商", tags = {"@王力影"})
    @ApiImplicitParam(name = "supplier", value = "供应商实体类", required = true, dataType = "Supplier")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @RequiresPermissions(value = {"insertSupplier"})
    public LayuiCommonResponse insert(@RequestBody Supplier supplier)  {

        try {
            return supplierService.insert(supplier);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_INSERT,0,supplier);
        }
    }



    @ApiOperation(value = "删除数据", notes = "删除数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "供应商id", required = true, dataType = "int")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @RequiresPermissions(value = {"deleteSupplier"})
    public LayuiCommonResponse delete(int id){

        try {
            return supplierService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_DELETE,0,"");
        }
    }
    @ApiOperation(value = "获取数据", notes = "获取数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "供应商id", required = true, dataType = "int")
    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public LayuiCommonResponse getById(int id){

        return supplierService.getByid(id);
    }

    @ApiOperation(value = "更新数据", notes = "更新数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "supplier", value = "供应商实体类", required = true, dataType = "Supplier")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @RequiresPermissions(value = {"updateSupplier"})
    public LayuiCommonResponse update(@RequestBody Supplier supplier){

        try {
            return supplierService.update(supplier);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_UPDATE,0,supplier);
        }
    }

    @ApiOperation(value = "获取所有数据", notes = "获取所有数据", tags = {"@王力影"})
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public LayuiCommonResponse getAll(){

        return supplierService.getAll();
    }


}
