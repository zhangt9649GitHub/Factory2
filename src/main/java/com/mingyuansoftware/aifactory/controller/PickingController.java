package com.mingyuansoftware.aifactory.controller;


import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.config.LogConfig;
import com.mingyuansoftware.aifactory.constants.Constants;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.PickingDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.LogService;
import com.mingyuansoftware.aifactory.service.PickingService;
import com.mingyuansoftware.aifactory.service.StockKucunGoodsService;
import com.mingyuansoftware.aifactory.util.BaseToString;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "Picking", description = "领料单API", tags = {"领料单"})
@RestController
@RequestMapping("/picking")
public class PickingController {

    @Autowired
    private PickingService pickingService;
    @Autowired
    private StockKucunGoodsService stockKucunGoodsService;
    @Autowired
    private LogService logService;

    @ApiOperation(value = "获取领料单列表", notes = "获取领料单列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pickingDto", value = "领料单参数实体类", paramType = "query", dataType = "PickingDto")
    })
    @RequestMapping(value = "/getPickingList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getPickingList"})
    public LayuiCommonResponse getPickingList(@Validated @RequestParam(defaultValue = "1") int page,
                                            @Validated @RequestParam(defaultValue = "10") int limit,
                                            @Validated PickingDto pickingDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<Picking> pickingList =pickingService.selectPickingList(pickingDto);
            int count = pickingService.selectCount(pickingDto);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(pickingList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "新增领料单", notes = "新增领料单", tags = {"@郝腾"})
    @ApiImplicitParam(name = "picking", value = "领料单实体类,其中type为必传字段", required = true, dataType = "Picking")
    @RequestMapping(value = "/insertPicking", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"insertPicking"})
    public LayuiCommonResponse insertPicking(@RequestBody Picking picking) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            pickingService.insertPicking(picking);
            if(LogConfig.STATE){
                String text = BaseToString.BaseEntityToString(picking);
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

    @ApiOperation(value = "删除领料单", notes = "删除领料单", tags = {"@郝腾"})
    @ApiImplicitParam(name = "pickingId", value = "领料单id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/deletePickingById", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"deletePickingById"})
    public LayuiCommonResponse deletePickingById(int pickingId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
           Picking picking = pickingService.selectPickingById(pickingId);
           if(picking.getState()==2){
               response.setCode(HtCode.FAIL_DELETE_STATE_ING.getCode());
               response.setMsg(HtCode.FAIL_DELETE_STATE_ING.getInfo());
               return response;
           }
            List<PickingDetails> pickingDetailsList =picking.getPickingDetailsList();
            for (PickingDetails pickingDetails:pickingDetailsList
            ) {
              if(pickingDetails.getStatus()==2){
                  response.setCode(HtCode.FAIL_DELETE_STATE_ANG_ING.getCode());
                  response.setMsg(HtCode.FAIL_DELETE_STATE_ANG_ING.getInfo());
                  return response;
              }
            }
           if(picking.getState()==3){
               response.setCode(HtCode.FAIL_DELETE_STATE_DO.getCode());
               response.setMsg(HtCode.FAIL_DELETE_STATE_DO.getInfo());
               return response;
           }
           if(picking.getState()==1) {
               pickingService.deletePickingById(pickingId);
               if (LogConfig.STATE) {
                   String[] str = new String[]{pickingId + ""};
                   Map<String, String[]> a_mMap = new HashMap<>();
                   a_mMap.put("pickingId", str);
                   String text = BaseToString.MapToString(a_mMap);
                   Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
                   int staffId = staff.getStaffId();
                   logService.saveLog(staffId, 3, text);
               }
           }
            response.setCode(HtCode.SUCCESS_DELETE.getCode());
            response.setMsg(HtCode.SUCCESS_DELETE.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_DELETE.getCode());
            response.setMsg(HtCode.FAIL_DELETE.getInfo());
            return response;
        }
        return response;
    }

    @ApiOperation(value = "查看领料单", notes = "查看领料单", tags = {"@郝腾"})
    @ApiImplicitParam(name = "pickingId", value = "领料单id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/getPickingById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getPickingById(int pickingId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            Picking picking = pickingService.selectPickingById(pickingId);
            List<PickingDetails> pickingDetailsList =picking.getPickingDetailsList();
            for (PickingDetails pickingDetails:pickingDetailsList
                 ) {
               KucunGoods kucunGoods= stockKucunGoodsService.getStockKucunGoodsCountByGoodsIdAndWarehouseId(picking.getOutWarehouse().getWarehouseId(),pickingDetails.getGoods().getGoodsId());
               if(kucunGoods!=null&&kucunGoods.getSkgCount()!=null){
                   pickingDetails.setSkgCount(kucunGoods.getSkgCount());
               }else{
                   pickingDetails.setSkgCount(new BigDecimal(0));
               }

            }
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(picking);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "更新领料单", notes = "更新领料单", tags = {"@郝腾"})
    @ApiImplicitParam(name = "picking", value = "领料单及详情", dataType = "Picking")
    @RequestMapping(value = "/updatePickingInfo", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"updatePickingInfo"})
    public LayuiCommonResponse updatePickingInfo(@RequestBody Picking picking) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            Picking picking1 = pickingService.selectPickingById(picking.getPickingId());
            if(picking1.getState()==2){
                response.setCode(HtCode.FAIL_UPDATE_STATE_SOME_ING.getCode());
                response.setMsg(HtCode.FAIL_UPDATE_STATE_SOME_ING.getInfo());
                return response;
            }
            List<PickingDetails> pickingDetailsList =picking1.getPickingDetailsList();
            for (PickingDetails pickingDetails:pickingDetailsList
            ) {
                if(pickingDetails.getStatus()==2){
                    response.setCode(HtCode.FAIL_UPDATE_STATE_ANG_ING.getCode());
                    response.setMsg(HtCode.FAIL_UPDATE_STATE_ANG_ING.getInfo());
                    return response;
                }
            }
            if(picking1.getState()==3){
                response.setCode(HtCode.FAIL_UPDATE_STATE_ALL_DO.getCode());
                response.setMsg(HtCode.FAIL_UPDATE_STATE_ALL_DO.getInfo());
                return response;
            }
            if(picking1.getState()==1) {
                pickingService.updatePickingInfo(picking);
                if (LogConfig.STATE) {
                    String text = BaseToString.BaseEntityToString(picking);
                    Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
                    int staffId = staff.getStaffId();
                    logService.saveLog(staffId, 2, text);
                }
                response.setCode(HtCode.SUCCESS_UPDATE.getCode());
                response.setMsg(HtCode.SUCCESS_UPDATE.getInfo());
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_UPDATE.getCode());
            response.setMsg(HtCode.FAIL_UPDATE.getInfo());
            return response;
        }
        return response;
    }

    @ApiOperation(value = "更新领料单状态为已完成", notes = "更新领料单状态为已完成", tags = {"@郝腾"})
    @ApiImplicitParam(name = "pickingId", value = "领料单id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/updatePickingState", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"updatePickingState"})
    public LayuiCommonResponse updatePickingState(int pickingId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            Picking picking1 = pickingService.selectPickingById(pickingId);
            if(picking1.getState()==1){
                response.setCode(HtCode.FAIL_UPDATE_COMPLETE.getCode());
                response.setMsg(HtCode.FAIL_UPDATE_COMPLETE.getInfo());
                return response;
            }
            if(picking1.getState()==2) {
                pickingService.updatePickingState(pickingId);
                List<PickingDetails> pickingDetailsList =picking1.getPickingDetailsList();
                if(!(pickingDetailsList.isEmpty())){
                    for (PickingDetails pickingDetails:pickingDetailsList
                     ) {
                        Map<String,Object> parameters = new HashMap<>();
                        parameters.put("skgCount",pickingDetails.getQuantity().multiply(new BigDecimal(-1)));
                        parameters.put("warehouseId",picking1.getOutWarehouse().getWarehouseId());
                        parameters.put("skgType",Constants.MAP_KUCUN.get(Constants.KUCUN_PICKING_OUTBOUND));
                        parameters.put("gid",pickingDetails.getGoods().getGoodsId());
                        parameters.put("skgDanJia",pickingDetails.getGoods().getAveragePrice());
                        parameters.put("skgSerialNumber",picking1.getPickingNumber());
                        parameters.put("skgWanglaiDanwei","");
                        parameters.put("changeType","2");
                        stockKucunGoodsService.insertStockKucunGoods(parameters);
                        parameters.put("skgCount",pickingDetails.getQuantity());
                        parameters.put("warehouseId",picking1.getIntoWarehouse().getWarehouseId());
                        parameters.put("skgType", Constants.MAP_KUCUN.get(Constants.KUCUN_PICKING_STORAGE));
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

}
