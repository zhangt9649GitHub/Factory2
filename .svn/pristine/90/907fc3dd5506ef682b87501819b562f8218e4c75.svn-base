package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.config.LogConfig;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.OutboundOrderDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.BizDictionaryService;
import com.mingyuansoftware.aifactory.service.LogService;
import com.mingyuansoftware.aifactory.service.OutboundOrderService;
import com.mingyuansoftware.aifactory.service.StockKucunGoodsService;
import com.mingyuansoftware.aifactory.util.BaseToString;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "OutboundOrder", description = "出库单API", tags = {"出库单"})
@RestController
@RequestMapping("/outboundOrder")
public class OutboundOrderController {

    @Autowired
    private OutboundOrderService outboundOrderService;
    @Autowired
    private StockKucunGoodsService stockKucunGoodsService;
    @Autowired
    private LogService logService;
    @Autowired
    private BizDictionaryService bizDictionaryService;

    @ApiOperation(value = "获取出库单列表", notes = "获取出库单列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "outboundOrderDto", value = "出库单实体类", paramType = "query", dataType = "OutboundOrderDto"),
    })
    @RequestMapping(value = "/getOutboundOrderList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getOutboundOrderList"})
    public LayuiCommonResponse getOutboundOrderList(@Validated @RequestParam(defaultValue = "1") int page,
                                                  @Validated @RequestParam(defaultValue = "10") int limit,
                                                  @Validated OutboundOrderDto outboundOrderDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<OutboundOrder> outboundOrderList = outboundOrderService.selectOutboundOrderList(outboundOrderDto);
            int count = outboundOrderService.selectCount(outboundOrderDto);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(outboundOrderList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }


    @ApiOperation(value = "新增出库单", notes = "新增出库单", tags = {"@郝腾"})
    @ApiImplicitParam(name = "outboundOrder", value = "出库单实体类", required = true, dataType = "OutboundOrder")
    @RequestMapping(value = "/insertOutboundOrder", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"insertOutboundOrder"})
    public LayuiCommonResponse insertOutboundOrder( @RequestBody OutboundOrder outboundOrder) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            outboundOrderService.insertOutboundOrder(outboundOrder);
            List<OutboundOrderDetails> outboundOrderDetails = outboundOrder.getOutboundOrderDetailsList();
            for (OutboundOrderDetails outboundOrderDetails1:outboundOrderDetails
                 ) {
                Map<String,Object> parameters = new HashMap<>();
                parameters.put("skgCount",outboundOrderDetails1.getQuantity().multiply(new BigDecimal(-1)));
                parameters.put("warehouseId",outboundOrder.getWarehouseId());
                parameters.put("skgType",outboundOrder.getType());
                parameters.put("gid",outboundOrderDetails1.getGoodsId());
                parameters.put("skgDanJia",outboundOrderDetails1.getAveragePrice());
                parameters.put("skgSerialNumber",outboundOrder.getOutboundOrderNumber());
                parameters.put("skgWanglaiDanwei","");
                parameters.put("changeType","1");
                stockKucunGoodsService.insertStockKucunGoods(parameters);
            }
            if(LogConfig.STATE){
                String text = BaseToString.BaseEntityToString(outboundOrder);
                Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
                int staffId = staff.getStaffId();
                logService.saveLog(staffId,1,text);
            }
            response.setCode(HtCode.SUCCESS_ADD.getCode());
            response.setMsg(HtCode.SUCCESS_ADD.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_ADD.getCode());
            response.setMsg(HtCode.FAIL_ADD.getInfo());
            return response;
        }
        return response;
    }

    @ApiOperation(value = "查看出库单", notes = "查看出库单", tags = {"@郝腾"})
    @ApiImplicitParam(name = "outboundOrderId", value = "出库单id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/getOutboundOrderById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getOutboundOrderById(int outboundOrderId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            OutboundOrder outboundOrder = outboundOrderService.selectOutboundOrderById(outboundOrderId);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(outboundOrder);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "获取出库类型列表", notes = "获取出库类型列表", tags = {"@郝腾"})
    @RequestMapping(value = "/getOutboundOrderTypeList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getOutboundOrderTypeList() {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int parentId = 29;
            List<Bizdictionary> bizdictionaryList =bizDictionaryService.selectListByParentId(parentId);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(bizdictionaryList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }
}
