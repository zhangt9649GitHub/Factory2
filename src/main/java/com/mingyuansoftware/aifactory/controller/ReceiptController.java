/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: ReceiptController
 * Author:   EDZ
 * Date:     2019/7/17 10:11
 * Description: 收款单
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.model.Bizdictionary;
import com.mingyuansoftware.aifactory.model.Receipt;
import com.mingyuansoftware.aifactory.model.SalesOrder;
import com.mingyuansoftware.aifactory.model.dto.PurchaseReturnOrderDto;
import com.mingyuansoftware.aifactory.model.dto.ReceiptDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈收款单〉
 *
 * @author EDZ
 * @create 2019/7/17
 * @since 1.0.0
 */
@RestController
@RequestMapping("/receipt")
@Api(value = "Receipt", description = "收款单API", tags = {"收款单"})
public class ReceiptController {

    @Autowired
    private BizDictionaryService bizDictionaryService;
    @Autowired
    private ReceiptService receiptService;
    @Autowired
    private SalesOrderService salesOrderService;
    @Autowired
    private FinanceMoneyRecordService financeMoneyRecordService;
    @Autowired
    private PurchaseReturnOrderService purchaseReturnOrderService;

    @ApiOperation(value = "新增数据", notes = "新增数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "收款单实体类", required = true, dataType = "Receipt")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
//    @RequiresPermissions(value = {"insertReceipt"})
    public LayuiCommonResponse insert(@RequestBody Receipt record){

        try {
            int insert = receiptService.insert(record);
            Map<String,Object> parameters = new HashMap<>();
            //销售收款  其他收款  采购退货收款  +
            parameters.put("fmMoney",record.getCollectionAmount());
            parameters.put("fmType",record.getCategory());
            parameters.put("cid",record.getPayerId());
            parameters.put("fmSerialNumber",record.getAssociatedDocument());
            parameters.put("fmJieSuanType",record.getPaymentMethod());
            parameters.put("fmJiaoyiDuixiang",record.getPayer());
            financeMoneyRecordService.insertFinanceMoneyRecordReceipt(parameters);
            return new LayuiCommonResponse(WlCode.SUCCESS_INSERT,insert,record);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_INSERT,0,"");
        }
    }
    @ApiOperation(value = "删除数据", notes = "删除数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "收款单id", required = true, dataType = "int")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public LayuiCommonResponse delete(int id){

        try {
            receiptService.deleteByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_DELETE,0,"");
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_DELETE,0,"");
        }
    }
    @ApiOperation(value = "获取数据", notes = "获取数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "收款单id", required = true, dataType = "int")
    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public LayuiCommonResponse getById(int id){
        try {
            Receipt receipt = receiptService.selectByPrimaryKey(id);
           return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,receipt);
        } catch (Exception e) {
            e.printStackTrace();
          return  new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }

    }

    @ApiOperation(value = "根据客户id获取销售数据", notes = "获取销售数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "客户id", required = true, dataType = "int")
    @RequestMapping(value = "/getSaleData",method = RequestMethod.POST)
    public LayuiCommonResponse getSaleData(int id){
        try {
            List<SalesOrder> salesOrders = salesOrderService.selectByCustomerId(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,salesOrders);
        } catch (Exception e) {
            e.printStackTrace();
            return  new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }

    }

    @ApiOperation(value = "根据客户id获取未收款销售数据", notes = "获取未收款销售数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "客户id", required = true, dataType = "int")
    @RequestMapping(value = "/getUnSaleData",method = RequestMethod.POST)
    public LayuiCommonResponse getSaleData1(int id){
        try {
            List<SalesOrder> salesOrders = salesOrderService.selectByCustomerId1(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,salesOrders);
        } catch (Exception e) {
            e.printStackTrace();
            return  new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }

    }
    @ApiOperation(value = "更新数据", notes = "更新数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "收款单实体类",required = true, dataType = "Receipt")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public LayuiCommonResponse update(@RequestBody Receipt record){

        try {
            receiptService.updateByPrimaryKey(record);
            return new LayuiCommonResponse(WlCode.SUCCESS_UPDAE,0,record);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_UPDATE,0,"");
        }
    }
    @ApiOperation(value = "获取分页数据", notes = "获取所有数据", tags = {"@王力影"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "receiptDto", value = "收款单参数实体类", paramType = "query", dataType = "ReceiptDto"),
    })
    @RequestMapping(value = "/getPageData",method = RequestMethod.POST)
    @RequiresPermissions(value = {"getReceiptList"})
    public LayuiCommonResponse getAll(@Validated @RequestParam(defaultValue = "1") int page,
                                      @Validated @RequestParam(defaultValue = "10") int limit,
                                      @Validated ReceiptDto receiptDto){
        try {
            PageHelper.startPage(page, limit);
            List<Receipt> receipts = receiptService.selectAll(receiptDto);
            Page<Receipt> page1= (Page<Receipt>) receipts;
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,(int) page1.getTotal(),page1.getResult());
        } catch (Exception e) {
            e.printStackTrace();
            return  new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }

    @ApiOperation(value = "获取收款单类型列表", notes = "获取收款单类型列表", tags = {"@王力影"})
    @RequestMapping(value = "/getTypeList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getTypeList() {
        try {
            int parentId = 46;
            List<Bizdictionary> bizdictionaryList =bizDictionaryService.selectListByParentId(parentId);
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,bizdictionaryList);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }

    }

    //采购退换货中的供应商名称(付款方)
    @ApiOperation(value = "获取采购退货单供应商列表(付款方)(收款状态!=2 1.未结算 2.已结算 3.部分结算)", nickname = "selectPurchaseReturnOrderList", notes = "获取采购退货单供应商信息(供应商Id,供应商名称列表)", tags = {"@张婷"})
    @RequestMapping(value = "/getPurchaseReturnOrderList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getPurchaseReturnOrderList() {
        try {
            List<PurchaseReturnOrderDto> purchaseReturnOrderList = purchaseReturnOrderService.selectPurchaseReturnOrderListForReceipt();
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,purchaseReturnOrderList);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }

    }

}
