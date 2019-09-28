package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.config.LogConfig;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.GoodsVariety;
import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.GoodsVarietyService;
import com.mingyuansoftware.aifactory.service.LogService;
import com.mingyuansoftware.aifactory.util.BaseToString;
import com.mingyuansoftware.aifactory.util.MyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "GoodVariety", description = "货物品种管理API", tags = {"货物品种管理"})
@RestController
@RequestMapping("/goodVariety")
public class GoodVarietyController {

    @Autowired
    private GoodsVarietyService goodsVarietyService;
    @Autowired
    private LogService logService;

    @ApiOperation(value = "获取货物品种列表", notes = "获取货物品种列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "goodsVariety", value = "货物品种实体类", paramType = "query", dataType = "GoodsVariety"),
    })
    @RequestMapping(value = "/getGoodsVarietyList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getGoodsVarietyList"})
    public LayuiCommonResponse getGoodsVarietyList(@Validated @RequestParam(defaultValue = "1") int page,
                                            @Validated @RequestParam(defaultValue = "10") int limit,
                                            @Validated GoodsVariety goodsVariety) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<GoodsVariety> goodsVarietyList =goodsVarietyService.selectAllGoodsVarietyList(goodsVariety);
            int count = goodsVarietyService.selectCountGoodsVarietyList(goodsVariety);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(goodsVarietyList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "新增货物品种", notes = "新增货物品种", tags = {"@郝腾"})
    @ApiImplicitParam(name = "goodsVariety", value = "货物品种实体类", required = true, dataType = "GoodsVariety")
    @RequestMapping(value = "/insertGoodsVariety", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"insertGoodsVariety"})
    public LayuiCommonResponse insertGoodsVariety(@RequestBody GoodsVariety goodsVariety) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            goodsVarietyService.insertGoodsVariety(goodsVariety);
            if(LogConfig.STATE){
                String text = BaseToString.BaseEntityToString(goodsVariety);
                Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
                int staffId = staff.getStaffId();
                logService.saveLog(staffId,1,text);
            }
            response.setCode(HtCode.SUCCESS_ADD.getCode());
            response.setMsg(HtCode.SUCCESS_ADD.getInfo());
        } catch (MyException e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_ADD.getCode());
            response.setMsg(e.getMessage());
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_ADD.getCode());
            response.setMsg(HtCode.FAIL_ADD.getInfo());
            return response;
        }
        return response;
    }

    @ApiOperation(value = "查看货物品种信息", notes = "查看货物品种信息", tags = {"@郝腾"})
    @ApiImplicitParam(name = "varietyValue", value = "品种值", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/getGoodsVarietyById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getGoodsVarietyById(int varietyValue) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            GoodsVariety goodsVariety = goodsVarietyService.selectGoodsVarietyById(varietyValue);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(goodsVariety);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "更新货物品种信息", notes = "更新货物品种信息", tags = {"@郝腾"})
    @ApiImplicitParam(name = "goodsVariety", value = "货物品种详情", dataType = "GoodsVariety")
    @RequestMapping(value = "/updateGoodsVariety", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"updateGoodsVariety"})
    public LayuiCommonResponse updateGoodsVariety(@RequestBody GoodsVariety goodsVariety) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            goodsVarietyService.updateGoodsVariety(goodsVariety);
            if(LogConfig.STATE){
                String text = BaseToString.BaseEntityToString(goodsVariety);
                Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
                int staffId = staff.getStaffId();
                logService.saveLog(staffId,2,text);
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
