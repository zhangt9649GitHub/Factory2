package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.RefundPicking;
import com.mingyuansoftware.aifactory.model.RefundPickingDetails;
import com.mingyuansoftware.aifactory.model.RefundPickingGoods;
import com.mingyuansoftware.aifactory.pojo.CommonResponse;
import com.mingyuansoftware.aifactory.service.RefundPickingDetailsService;
import com.mingyuansoftware.aifactory.service.RefundPickingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "PDARefundPicking", description = "PDA生产退料API", tags = {"PDA生产退料"})
@RestController
@RequestMapping("/PdaRefundPicking")
public class PDARefundPickingController {

    @Autowired
    private RefundPickingService refundPickingService;
    @Autowired
    private RefundPickingDetailsService refundPickingDetailsService;

    @ApiOperation(value = "获取生产退料任务列表", notes = "获取生产退料任务列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/getPdaRefundPickingList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResponse getPdaRefundPickingList(@Validated @RequestParam(defaultValue = "1") int page,
                                            @Validated @RequestParam(defaultValue = "10") int limit) {
        CommonResponse response = new CommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<RefundPicking> refundPickingList =refundPickingService.selectPdaRefundPickingList();
            response.setMessage(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(refundPickingList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMessage(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "获取生产退料货物列表", notes = "获取生产退料货物列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "refundPickingId", value = "退料单id", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/getPdaRefundPickingGoodsList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResponse getPdaRefundPickingGoodsList(@Validated @RequestParam(defaultValue = "1") int page,
                                                 @Validated @RequestParam(defaultValue = "10") int limit,
                                                 @Validated int refundPickingId) {
        CommonResponse response = new CommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<RefundPickingGoods> refundPickingGoodsList  =refundPickingDetailsService.SelectPdaRefundPickingGoodsList(refundPickingId);
           // int count = refundPickingDetailsService.selectPdaRefundPickingGoodsListCount(refundPickingId);
            response.setMessage(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(refundPickingGoodsList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMessage(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "获取退料货物的数量", notes = "获取退料货物的数量", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "货物id",  required = true,paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "refundPickingId", value = "退料单id", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/getRefundGoodsCount", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse getRefundGoodsCount(@Validated int goodsId,@Validated int refundPickingId) {
        CommonResponse response = new CommonResponse();
        try {
            RefundPickingDetails refundPickingDetails =refundPickingDetailsService.selectRefundGoodsCount(goodsId,refundPickingId);
            response.setMessage(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(refundPickingDetails);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMessage(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "保存提交", notes = "保存提交", tags = {"@郝腾"})
    @ApiImplicitParam(name = "refundPickingDetailsId", value = "领料单详情id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/updateRefundPickingDetailsStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse updateRefundPickingDetailsStatus(int refundPickingDetailsId) {
        CommonResponse response = new CommonResponse();
        try {
            refundPickingDetailsService.updateRefundPickingDetailsStatus(refundPickingDetailsId);
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
