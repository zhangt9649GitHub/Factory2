package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.Picking;
import com.mingyuansoftware.aifactory.model.PickingDetails;
import com.mingyuansoftware.aifactory.model.PickingGoods;
import com.mingyuansoftware.aifactory.pojo.CommonResponse;
import com.mingyuansoftware.aifactory.service.PickingDetailsService;
import com.mingyuansoftware.aifactory.service.PickingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "PDAPicking", description = "PDA生产领料API", tags = {"PDA生产领料"})
@RestController
@RequestMapping("/PdaPicking")
public class PDAPickingController {

    @Autowired
    private PickingService pickingService;
    @Autowired
    private PickingDetailsService pickingDetailsService;

    @ApiOperation(value = "获取生产领料任务列表", notes = "获取生产领料任务列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/getPdaPickingList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResponse getPdaPickingList(@Validated @RequestParam(defaultValue = "1") int page,
                                            @Validated @RequestParam(defaultValue = "10") int limit) {
        CommonResponse response = new CommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<Picking> pickingList =pickingService.selectPdaPickingList();
            int count = pickingService.selectPdaPickingListCount();
            response.setMessage(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(pickingList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMessage(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "获取生产领料货物列表", notes = "获取生产领料货物列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pickingId", value = "领料单id", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/getPdaPickingGoodsList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResponse getPdaPickingGoodsList(@Validated @RequestParam(defaultValue = "1") int page,
                                                @Validated @RequestParam(defaultValue = "10") int limit,
                                                 @Validated int pickingId) {
        CommonResponse response = new CommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<PickingGoods> pickingGoodsList  =pickingDetailsService.selectPdaPickingGoodsList(pickingId);
            int count = pickingDetailsService.selectPdaPickingGoodsListCount(pickingId);
            response.setMessage(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(pickingGoodsList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMessage(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }


    @ApiOperation(value = "获取领料货物的数量", notes = "获取领料货物的数量", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "货物id",  required = true,paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pickingId", value = "领料单id", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/getGoodsCount", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse getGoodsCount(@Validated int goodsId,@Validated int pickingId) {
        CommonResponse response = new CommonResponse();
        try {
            PickingDetails pickingDetails  =pickingDetailsService.selectGoodsInfoByGoodsNumber(goodsId,pickingId);
            response.setMessage(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(pickingDetails);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMessage(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "保存提交", notes = "保存提交", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffId", value = "员工id",  required = true,paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pickingDetailsId", value = "领料单详情id", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/updatePickingDetailsStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse updatePickingDetailsStatus(int staffId,int pickingDetailsId) {
        CommonResponse response = new CommonResponse();
        try {
            pickingDetailsService.updatePickingDetailsStatus(staffId,pickingDetailsId);
            response.setMessage(HtCode.SUCCESS_SAVE.getInfo());
            response.setCode(HtCode.SUCCESS_SAVE.getCode());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_SAVE.getCode());
            response.setMessage(HtCode.FAIL_SAVE.getInfo());
        }
        return response;
    }

}
