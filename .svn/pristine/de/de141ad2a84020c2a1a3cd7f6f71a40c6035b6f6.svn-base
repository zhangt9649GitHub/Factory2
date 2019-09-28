package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.dto.ValueEstimationDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.ProductionInstructionGoodsService;
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
 * @date 2019/9/3 10:34
 */

@Api(value = "valueEstimation",description = "在产产值估算API",tags = {"报表-在产产值估算"})
@RestController
@RequestMapping(value = "/valueEstimation")
public class ValueEstimationController {

    @Autowired
    private ProductionInstructionGoodsService productionInstructionGoodsService;

    @ApiOperation(value = "获取在产产值估算列表", nickname = "/selectValueEstimationList", notes = "获取在产产值估算列表", tags = {"@张婷"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "valueEstimationDto", value = "在产产值估算实体类", paramType = "query", dataType = "ValueEstimationDto"),
    })
    @RequestMapping(value = "/getValueEstimationList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getValueEstimationList"})
    public LayuiCommonResponse getProductionInstructionList(@Validated @RequestParam(defaultValue = "1") int page,
                                                            @Validated @RequestParam(defaultValue = "10") int limit,
                                                            @Validated ValueEstimationDto valueEstimationDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<ValueEstimationDto> valueEstimationList =productionInstructionGoodsService.selectValueEstimationList(valueEstimationDto);
            int count = productionInstructionGoodsService.selectValueEstimationCount(valueEstimationDto);
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(valueEstimationList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

}
