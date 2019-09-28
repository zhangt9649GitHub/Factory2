package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.dto.SalesDetailsDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.SalesOrderDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "SalesDetails", description = "销售明细API", tags = {"销售明细"})
@RestController
@RequestMapping("/salesDetails")
public class SalesDetailsController {

    @Autowired
    private SalesOrderDetailsService salesOrderDetailsService;

    @ApiOperation(value = "获取销售明细列表", notes = "获取销售明细列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "salesDetailsDto", value = "销售明细参数实体类", paramType = "query", dataType = "SalesDetailsDto"),
            @ApiImplicitParam(name = "startTime", value = "开始时间",  dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/getSalesDetailsList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getSalesDetailsList"})
    public LayuiCommonResponse getSalesDetailsList(@Validated @RequestParam(defaultValue = "1") int page,
                                                 @Validated @RequestParam(defaultValue = "10") int limit,
                                                 @Validated SalesDetailsDto salesDetailsDto,@Validated String startTime,
                                                   @Validated String endTime) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<SalesDetailsDto> salesDetailsDtos =salesOrderDetailsService.selectSalesDetailsList(salesDetailsDto,startTime,endTime);
            int count = salesOrderDetailsService.selectSalesDetailsCount(salesDetailsDto,startTime,endTime);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(salesDetailsDtos);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }
}
