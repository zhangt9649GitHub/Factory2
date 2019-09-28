package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.InventoryStatus;
import com.mingyuansoftware.aifactory.model.Picking;
import com.mingyuansoftware.aifactory.model.dto.PickingDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "InventoryStatus", description = "库存状态API", tags = {"库存状态"})
@RestController
@RequestMapping("/inventoryStatus")
public class InventoryStatusController {


    @ApiOperation(value = "获取库存状态列表", notes = "获取库存状态列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "inventoryStatus", value = "参数实体类", paramType = "query", dataType = "InventoryStatus")
    })
    @RequestMapping(value = "/getInventoryStatusList", method = RequestMethod.GET)
    @ResponseBody
    public LayuiCommonResponse getInventoryStatusList(@Validated @RequestParam(defaultValue = "1") int page,
                                              @Validated @RequestParam(defaultValue = "10") int limit,
                                              @Validated InventoryStatus inventoryStatus) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);

            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            //response.setCount();
            //response.setData();
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }
}
