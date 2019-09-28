package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.constants.Constants;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.GoodsPrintDto;
import com.mingyuansoftware.aifactory.model.dto.SalesOrderDto;
import com.mingyuansoftware.aifactory.model.dto.ShipmentDto;
import com.mingyuansoftware.aifactory.model.dto.ShipmentPrintDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.SalesOrderService;
import com.mingyuansoftware.aifactory.service.ShipmentService;
import com.mingyuansoftware.aifactory.service.StockKucunGoodsService;
import com.mingyuansoftware.aifactory.service.WarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "Shipment", description = "货单管理API", tags = {"货单管理"})
@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private StockKucunGoodsService stockKucunGoodsService;
    @Autowired
    private SalesOrderService salesOrderService;

    @ApiOperation(value = "获取出货单列表", notes = "获取出货单列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "shipmentDto", value = "销售订单参数实体类", paramType = "query", dataType = "ShipmentDto"),
    })
    @RequestMapping(value = "/getShipmentList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getShipmentList"})
    public LayuiCommonResponse getShipmentList(@Validated @RequestParam(defaultValue = "1") int page,
                                                 @Validated @RequestParam(defaultValue = "10") int limit,
                                                 @Validated ShipmentDto shipmentDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<Shipment> shipmentList = shipmentService.selectShipmentList(shipmentDto);
            int count = shipmentService.selectCountShipmentList(shipmentDto);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(shipmentList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "查看出货单详情", notes = "查看出货单详情", tags = {"@郝腾"})
    @ApiImplicitParam(name = "shipmentId", value = "出货单id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/getShipmentById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getShipmentById(int shipmentId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            Shipment shipment =shipmentService.selectShipmentById(shipmentId);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(shipment);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "更新出货单状态为已出库", notes = "更新出货单状态为已出库", tags = {"@郝腾"})
    @ApiImplicitParam(name = "shipmentId", value = "出货单id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/updateShipmentState", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"updateShipmentState"})
    public LayuiCommonResponse updateShipmentState(int shipmentId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            Shipment shipment = shipmentService.selectShipmentById(shipmentId);
            if(shipment.getState()==1){
                response.setCode(HtCode.FAIL_UPDATE_COMPLETE.getCode());
                response.setMsg(HtCode.FAIL_UPDATE_COMPLETE.getInfo());
                return response;
            }
            if(shipment.getState()==2) {
                shipmentService.updateShipmentState(shipmentId);
                SalesOrder salesOrder = salesOrderService.selectSalesOrderById(shipment.getSalesOrderId());
                List<ShipmentDetails> shipmentDetailsList =shipment.getShipmentDetailsList();
                if(!(shipmentDetailsList.isEmpty())){
                    for (ShipmentDetails shipmentDetails:shipmentDetailsList
                    ) {
                        Map<String,Object> parameters = new HashMap<>();
                        parameters.put("skgCount",shipmentDetails.getOutQuantity().multiply(new BigDecimal(-1)));
                        //获取仓库列表
                        List<Warehouse> warehouseList = warehouseService.selectWarehouseNameList();
                        if(!(warehouseList.isEmpty())){
                            for (Warehouse warehouse:warehouseList
                            ) {
                                if(warehouse.getWarehouseName().equals("商品仓库")){
                                    parameters.put("warehouseId",warehouse.getWarehouseId());
                                }
                            }
                        }
                        parameters.put("skgType", Constants.MAP_KUCUN.get(Constants.KUCUN_SALES_OUTBOUND));
                        parameters.put("gid",shipmentDetails.getGoods().getGoodsId());
                        parameters.put("skgDanJia",shipmentDetails.getGoods().getAveragePrice());
                        parameters.put("skgSerialNumber",shipment.getShipmentNumber());
                        if(salesOrder.getCustomer()!=null&&salesOrder.getCustomer().getCustomerName()!=null){
                            parameters.put("skgWanglaiDanwei",salesOrder.getCustomer().getCustomerName());
                        }
                        parameters.put("changeType","1");
                        stockKucunGoodsService.insertStockKucunGoods(parameters);
                    }
                }
            }
            response.setCode(HtCode.SUCCESS_UPDATE.getCode());
            response.setMsg(HtCode.SUCCESS_UPDATE.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_UPDATE.getCode());
            response.setMsg(HtCode.FAIL_UPDATE.getInfo());
            return response;
        }
        return response;
    }

    @ApiOperation(value = "出货单修改打印状态", notes = "出货单修改打印状态", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shipmentId", value = "货物id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "isPrint", value = "是否打印", required = true, paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/updateShipmentPrint", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse updateShipmentPrint(HttpServletRequest req , @Validated Integer shipmentId, @Validated Integer isPrint) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            if(shipmentId ==null){
                StringBuffer sb = new StringBuffer();
                try(BufferedReader reader = req.getReader()) {
                    char[]buff = new char[1024];
                    int len;
                    while((len = reader.read(buff)) != -1) {
                        sb.append(buff,0, len);
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
                String str = new String(sb);
                JSONObject jsonobject = JSONObject.fromObject(str);
                ShipmentPrintDto shipmentPrintDto = (ShipmentPrintDto)JSONObject.toBean(jsonobject,
                        ShipmentPrintDto.class);
                shipmentId = shipmentPrintDto.getShipmentId();
                isPrint = shipmentPrintDto.getIsPrint();
            }
            shipmentService.updateShipmentPrintById(shipmentId, isPrint);
            response.setCode(HtCode.SUCCESS_PRINT.getCode());
            response.setMsg(HtCode.SUCCESS_PRINT.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_PRINT.getCode());
            response.setMsg(HtCode.FAIL_PRINT.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "获取打印出货单信息", notes = "获取打印出货单信息", tags = {"@郝腾"})
    @RequestMapping(value = "/getShipmentPrint", method = RequestMethod.GET)
    @ResponseBody
    public LayuiCommonResponse getShipmentPrint() {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            Shipment shipment = shipmentService.selectShipmentPrint();
            response.setMsg("success");
            response.setCode(0);
            response.setData(shipment);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(-1);
            response.setMsg("error");
        }
        return response;
    }

}
