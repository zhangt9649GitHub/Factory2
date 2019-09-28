package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.*;
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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张婷
 * @date 2019/7/17 14:56
 */

@Api(value = "PaymentOrder",description = "付款单API",tags = {"付款单-付款单列表"})
@RestController
@RequestMapping("/paymentOrder")
public class PaymentOrderController {

    @Autowired
    private PaymentOrderService paymentOrderService;
    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Autowired
    private BizDictionaryService bizDictionaryService;
    @Autowired
    private FinanceMoneyRecordService financeMoneyRecordService;
    @Autowired
    private ReimburseService reimburseService;
    @Autowired
    private PayrollService payrollService;
    @Autowired
    private SalesReturnService salesReturnService;


    @ApiOperation(value = "付款单列表", nickname = "/getPaymentOrderList", notes = "获取付款单列表", tags = {"@张婷"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "paymentOrderDto", value = "付款单参数实体类", paramType = "query", dataType = "PaymentOrderDto"),
    })
    @RequestMapping(value = "/getPaymentOrderList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getPaymentOrderList"})
    public LayuiCommonResponse getPaymentOrderList(@Validated @RequestParam(defaultValue = "1") int page,
                                                   @Validated @RequestParam(defaultValue = "10") int limit,
                                                   @Validated PaymentOrderDto paymentOrderDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<PaymentOrder> paymentOrderList = paymentOrderService.selectPaymentOrderList(paymentOrderDto);
            int count = paymentOrderService.selectCount(paymentOrderDto);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCount(count);
            response.setData(paymentOrderList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "获取采购订单信息", nickname = "/getPurchaseOrderBySupplierId", notes = "根据供应商id查询采购订单信息", tags = {"@张婷"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "purchaseOrderDto", value = "采购订单参数实体类", paramType = "query", dataType = "PurchaseOrderDto"),
    })
    @RequestMapping(value = "/getPurchaseOrderBySupplierId", method = RequestMethod.GET)
    @ResponseBody
    public LayuiCommonResponse getPurchaseOrderBySupplierId(@Validated @RequestParam(defaultValue = "1") int page,
                                                           @Validated @RequestParam(defaultValue = "10") int limit,
                                                           @Validated PurchaseOrderDto purchaseOrderDto ) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<PurchaseOrderDetailsDto> purchaseOrderBySupplierId = purchaseOrderService.selectPurchaseOrderList(purchaseOrderDto);//供应商id查询采购订单信息
            int count = purchaseOrderService.selectCount(purchaseOrderDto);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCount(count);
            response.setData(purchaseOrderBySupplierId);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "新增付款单", nickname = "/insertPaymentOrder", notes = "添加付款单", tags = {"@张婷"})
    @ApiImplicitParam(name = "paymentOrder", value = "付款单实体类", required = true, dataType = "PaymentOrder")
    @RequestMapping(value = "/insertPaymentOrder", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresPermissions(value = {"insertPaymentOrder"})
    public LayuiCommonResponse insertPaymentOrder(@RequestBody PaymentOrder paymentOrder) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int insertPaymentOrder = paymentOrderService.insertPaymentOrder(paymentOrder);
            Map<String,Object> parameters = new HashMap<>();
            //采购付款  报销付款  工资付款  退货付款 其他付款 -
            parameters.put("fmMoney",paymentOrder.getPaymentAmount().multiply(new BigDecimal(-1)));
            parameters.put("fmType",paymentOrder.getCategory());
            parameters.put("sid",paymentOrder.getBeneficiaryId());
            parameters.put("fmSerialNumber",paymentOrder.getPaymentOrderNumber());
            parameters.put("fmJieSuanType",paymentOrder.getPaymentMethod());
            parameters.put("fmJiaoyiDuixiang",paymentOrder.getBeneficiary());
            financeMoneyRecordService.insertFinanceMoneyRecordPayment(parameters);
            //登录验证
            if(insertPaymentOrder < 1){
                response.setCode(ZtCode.FAIL_ADD.getCode());
                response.setMsg(ZtCode.FAIL_ADD.getInfo());
                return response;
            }
            response.setCode(ZtCode.SUCCESS_ADD.getCode());
            response.setMsg(ZtCode.SUCCESS_ADD.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_ADD.getCode());
            response.setMsg(ZtCode.FAIL_ADD.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "查看付款单", nickname = "/getPaymentOrderById", notes = "根据付款单id获取付款单信息", tags = {"@张婷"})
    @ApiImplicitParam(name = "paymentOrderId", value = "付款单id",required = true, paramType = "query", dataType = "int")
    @RequestMapping(value = "/getPaymentOrderById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getPaymentOrderById(int paymentOrderId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PaymentOrder paymentOrder = paymentOrderService.selectPaymentOrderById(paymentOrderId);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setData(paymentOrder);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "获取付款类型列表", nickname = "getPaymentTypeList",notes = "获取付款类型列表", tags = {"@张婷"})
    @RequestMapping(value = "/getPaymentTypeList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getPaymentTypeList() {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int parentId = 53;
            List<Bizdictionary> bizdictionaryList =bizDictionaryService.selectListByParentId(parentId);
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setData(bizdictionaryList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    //报销单中的报销人姓名(收款方) 3.已审核
    @ApiOperation(value = "获取报销单报销人列表(收款方)(3.已审核)", nickname = "selectReimburseCreateStaffList",notes = "获取报销单信息(报销人Id,姓名列表){createStaffId,createName}", tags = {"@张婷"})
    @RequestMapping(value = "/getReimburseCreateStaffList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getReimburseCreateStaffList() {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            ReimburseDto reimburseDto = new ReimburseDto();
            reimburseDto.setState((byte)3); //3.已审核
            List<Reimburse> reimburseList =reimburseService.selectAll(reimburseDto);
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setData(reimburseList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    //工资单详情中的员工姓名(收款方)  2.已审核
    @ApiOperation(value = "获取工资单员工列表(收款方)(2.已审核)", nickname = "selectPayrollList",notes = "获取工资单信息(员工Id,姓名列表){staffId,name}", tags = {"@张婷"})
    @RequestMapping(value = "/getPayrollList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getPayrollList() {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PayrollDto payrollDto = new PayrollDto();
            payrollDto.setState((byte)2);
            List<Payroll> payrollList = payrollService.selectPayrollList(payrollDto);
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setData(payrollList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    //销售退货单中的客户名称(收款方)
    @ApiOperation(value = "获取销售退货单客户列表(收款方)(回款状态 !=3 1.未回款 2.部分回款 )", nickname = "selectSalesReturnList",notes = "获取销售退货单客户信息(客户Id,客户名称列表){customerId,customerName}", tags = {"@张婷"})
    @RequestMapping(value = "/getSalesReturnList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getSalesReturnList() {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
//            salesReturnDto.setPaymentStatus((byte)1);  //修改xml添加回款状态 < 3
            List<SalesReturn> salesReturnList =salesReturnService.selectSalesReturnListForPayment();
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setData(salesReturnList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    /*
      新增付款单
      1.采购付款
    {
      "amount": 3000,
      "associatedDocument": "13391314178",
      "associatedDocumentId": "10",
      "beneficiary": "■大阪クリップ■",
      "beneficiaryId": 8,
      "category": "采购付款",
      "comment": "comment",
      "defineDate": "2018-08-08",
      "paymentAmount": 500,
      "paymentMethod": "支付宝",
      "paymentOrderNumber": "1111110122",
      "pendingPaymentAmount":3000,
      "pendingWriteOffAmount": 100,
      "staffId": 1,
      "writeOffAmount": 100,
      "discountAmount":200
    }
    2.报销付款
    {
      "amount": 700,
      "associatedDocument": "09788656993",
      "associatedDocumentId": "14",
      "beneficiary": "小王",
      "beneficiaryId": 1,
      "category": "报销付款",
      "comment": "comment",
      "defineDate": "2018-08-08",
      "paymentAmount": 600,
      "paymentMethod": "支付宝",
      "paymentOrderNumber": "11111102233",
      "pendingPaymentAmount":700,
      "pendingWriteOffAmount": 0,
      "staffId": 15,
      "writeOffAmount": 0
    }
    3.工资付款
    {
      "amount": 8000,
      "associatedDocument": "15646445555",
      "associatedDocumentId": "1",
      "beneficiary": "小王",
      "beneficiaryId": 1,
      "category": "工资付款",
      "comment": "comment",
      "defineDate": "2018-08-20",
      "paymentAmount": 8000,
      "paymentMethod": "支付宝",
      "paymentOrderNumber": "1111110223344",
      "pendingPaymentAmount":8000,
      "pendingWriteOffAmount": 0,
      "staffId": 15,
      "writeOffAmount": 0
    }
    4.退货付款
    {
      "amount": 100,
      "associatedDocument": "17619481884",
      "associatedDocumentId": "12",
      "beneficiary": "小王",
      "beneficiaryId": 1,
      "category": "退货付款",
      "comment": "comment",
      "defineDate": "2018-08-20",
      "paymentAmount": 30,
      "paymentMethod": "支付宝",
      "paymentOrderNumber": "1234566666",
      "pendingPaymentAmount":100,
      "pendingWriteOffAmount": 0,
      "staffId": 15,
      "writeOffAmount": 0
    }
    */

}


