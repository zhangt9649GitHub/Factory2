package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.dto.InventoryWarningDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.GoodsService;
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
 * @date 2019/7/16 17:04
 */

@Api(value = "InventoryWarning",description = "库存预警API",tags = {"库存预警-库存预警列表"})
@RestController
@RequestMapping("/inventoryWarning")
public class InventoryWarningController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "获取库存预警",nickname = "getInventoryWarningList",notes = "获取库存预警", tags = {"@张婷"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "inventoryWarningDto", value = "库存预警天津货物库存参数实体类", paramType = "query", dataType = "InventoryWarningDto"),
    })
    @RequestMapping(value = "/getInventoryWarningList", method = RequestMethod.GET)
    @ResponseBody
    public LayuiCommonResponse getInventoryWarningList(@Validated @RequestParam(defaultValue = "1") int page,
                                                   @Validated @RequestParam(defaultValue = "10") int limit,
                                                   @Validated InventoryWarningDto inventoryWarningDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<InventoryWarningDto> inventoryWarningList =goodsService.selectInventoryWarningList(inventoryWarningDto);
            int count = goodsService.selecInventoryWarningtCount(inventoryWarningDto);
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(inventoryWarningList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

}
