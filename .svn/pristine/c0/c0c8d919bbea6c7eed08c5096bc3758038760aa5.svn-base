package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.Goods;
import com.mingyuansoftware.aifactory.model.ProductionProcess;
import com.mingyuansoftware.aifactory.model.ProductionScheduleAnalysis;
import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.dto.ProductionInstructionGoodsDto;
import com.mingyuansoftware.aifactory.model.dto.ProductionScheduleAnalysisDto;
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

import java.util.ArrayList;
import java.util.List;

@Api(value = "ProductionScheduleAnalysis", description = "生产进度分析API", tags = {"生产进度分析"})
@RestController
@RequestMapping("/productionScheduleAnalysis")
public class ProductionScheduleAnalysisController {

    @Autowired
    private ProductionInstructionGoodsService productionInstructionGoodsService;

    @ApiOperation(value = "获取生产进度分析列表", notes = "获取生产进度分析列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "productionScheduleAnalysisDto", value = "生产进度分析参数实体类", paramType = "query", dataType = "ProductionScheduleAnalysisDto"),
    })
    @RequestMapping(value = "/getProductionScheduleAnalysisList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getProductionScheduleAnalysisList"})
    public LayuiCommonResponse getProductionScheduleAnalysisList(@Validated @RequestParam(defaultValue = "1") int page,
                                                            @Validated @RequestParam(defaultValue = "10") int limit,
                                                            @Validated ProductionScheduleAnalysisDto productionScheduleAnalysisDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            List<ProductionScheduleAnalysis> productionScheduleAnalysisList =productionInstructionGoodsService.selectProductionScheduleAnalysisList(page,limit,productionScheduleAnalysisDto);
            List<ProductionProcess> productionProcessList = new ArrayList<>();
            for (ProductionScheduleAnalysis productionScheduleAnalysis:productionScheduleAnalysisList
                 ) {
                productionProcessList = productionScheduleAnalysis.getProductionProcessList();
                break;
            }
            Page<ProductionProcess> page1= (Page<ProductionProcess>) productionProcessList;
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount((int) page1.getTotal());
            response.setData(productionScheduleAnalysisList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "获取详细", notes = "获取详细", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "goodsId", value = "货物id", required = true, dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/getInfoByGoodsId", method = RequestMethod.GET)
    @ResponseBody
    public LayuiCommonResponse getInfoByGoodsId(@Validated @RequestParam(defaultValue = "1") int page,
                                                @Validated @RequestParam(defaultValue = "10") int limit,Integer goodsId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            List<ProductionScheduleAnalysis> productionScheduleAnalysisList =productionInstructionGoodsService.selectInfoByGoodsId(page,limit,goodsId);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(productionScheduleAnalysisList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }
}
