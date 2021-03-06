package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.ProductionDaily;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.ProductionEntryDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "ProductionDaily", description = "生产日报API", tags = {"生产日报"})
@RestController
@RequestMapping("/productionDaily")
public class ProductionDailyController {

    @Autowired
    private ProductionEntryDetailsService productionEntryDetailsService;

    @ApiOperation(value = "获取生产日报列表", notes = "获取生产日报列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "productionDaily", value = "生产日报实体类", paramType = "query", dataType = "ProductionDaily")
    })
    @RequestMapping(value = "/getProductionDailyList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getProductionDailyList"})
    public LayuiCommonResponse getProductionDailyList(@Validated @RequestParam(defaultValue = "1") int page,
                                                      @Validated @RequestParam(defaultValue = "10") int limit,
                                                      @Validated ProductionDaily productionDaily) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<ProductionDaily> productionDailyList = productionEntryDetailsService.selectProductionDailyList(productionDaily);
            int count = productionEntryDetailsService.selectCountProductionDaily(productionDaily);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(productionDailyList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }
}
