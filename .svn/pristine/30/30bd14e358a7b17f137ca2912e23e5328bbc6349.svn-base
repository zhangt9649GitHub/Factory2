package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.dto.PurchaseDeliveryDateDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.PurchaseOrderService;
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
 * @date 2019/9/12 11:24
 */

@Api(value = "PurchaseDeliveryDate",description = "采购交货期预警API",tags = {"采购交货期预警"})
@RestController
@RequestMapping("/purchaseDeliveryDate")
public class PurchaseDeliveryDateController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @ApiOperation(value = "采购交货期预警列表", nickname = "/selectPurchaseDeliveryDateList", notes = "获取采购交货期预警列表", tags = {"@张婷"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "purchaseDeliveryDateDto", value = "采购交货期预警实体类", paramType = "query", dataType = "PurchaseDeliveryDateDto"),
    })
    @RequestMapping(value = "/getPurchaseDeliveryDateList", method = RequestMethod.GET)
    @ResponseBody
//    @RequiresPermissions(value = {"getPurchaseDeliveryDateList"})
    public LayuiCommonResponse getPurchaseDeliveryDateList(@Validated @RequestParam(defaultValue = "1") int page,
                                                    @Validated @RequestParam(defaultValue = "10") int limit,
                                                    @Validated PurchaseDeliveryDateDto purchaseDeliveryDateDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<PurchaseDeliveryDateDto> purchaseDeliveryDateDtoList = purchaseOrderService.selectPurchaseDeliveryDateList(purchaseDeliveryDateDto);
            int count = purchaseOrderService.selectPurchaseDeliveryDateCount(purchaseDeliveryDateDto);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCount(count);
            response.setData(purchaseDeliveryDateDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

}
