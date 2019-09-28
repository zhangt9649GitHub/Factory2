package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.dto.PickingDetailsDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.PickingDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "PickingDetails", description = "生产领料明细API", tags = {"生产领料明细"})
@RestController
@RequestMapping("/pickingDetails")
public class PickingDetailsController {

    @Autowired
    private PickingDetailsService pickingDetailsService;

    @ApiOperation(value = "获取生产领料明细列表", notes = "获取生产领料明细列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pickingDetailsDto", value = "生产领料明细参数实体类", paramType = "query", dataType = "PickingDetailsDto")
    })
    @RequestMapping(value = "/getPickingDetailsList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getPickingDetailsList"})
    public LayuiCommonResponse getPickingDetailsList(@Validated @RequestParam(defaultValue = "1") int page,
                                              @Validated @RequestParam(defaultValue = "10") int limit,
                                              @Validated PickingDetailsDto pickingDetailsDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<PickingDetailsDto> pickingDetailsDtoList =pickingDetailsService.selectPickingDetailsList(pickingDetailsDto);
            int count = pickingDetailsService.selectCountPickingDetails(pickingDetailsDto);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(pickingDetailsDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }
}
