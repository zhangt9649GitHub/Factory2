package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.config.LogConfig;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.ProductionEntryDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.LogService;
import com.mingyuansoftware.aifactory.service.ProductionEntryService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "ProductionEntry", description = "生产入库单API", tags = {"生产入库单"})
@RestController
@RequestMapping("/productionEntry")
public class ProductionEntryController {

    @Autowired
    private ProductionEntryService productionEntryService;
    @Autowired
    private LogService logService;


    @ApiOperation(value = "获取生产入库单列表", notes = "获取生产入库单列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "productionEntryDto", value = "生产入库单参数实体类", paramType = "query", dataType = "ProductionEntryDto")
    })
    @RequestMapping(value = "/getProductionEntryList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getProductionEntryList"})
    public LayuiCommonResponse getProductionEntryList(@Validated @RequestParam(defaultValue = "1") int page,
                                              @Validated @RequestParam(defaultValue = "10") int limit,
                                              @Validated ProductionEntryDto productionEntryDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<ProductionEntry> productionEntryList =productionEntryService.selectProductionEntryList(productionEntryDto);
            int count = productionEntryService.selectCountProductionEntry(productionEntryDto);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(productionEntryList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "删除生产入库单", notes = "删除生产入库单", tags = {"@郝腾"})
    @ApiImplicitParam(name = "productionEntryId", value = "生产入库单id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/deleteProductionEntryById", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"deleteProductionEntryById"})
    public LayuiCommonResponse deleteProductionEntryById(int productionEntryId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
               productionEntryService.deleteProductionEntryById(productionEntryId);
                if (LogConfig.STATE) {
                    String[] str = new String[]{productionEntryId + ""};
                    Map<String, String[]> a_mMap = new HashMap<>();
                    a_mMap.put("productionEntryId", str);
                    String text = BaseToString.MapToString(a_mMap);
                   Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
                   int staffId = staff.getStaffId();
                   logService.saveLog(staffId, 3, text);
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

    @ApiOperation(value = "查看生产入库单详情", notes = "查看生产入库单详情", tags = {"@郝腾"})
    @ApiImplicitParam(name = "productionEntryId", value = "生产入库单id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/getProductionEntryInfoById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getProductionEntryInfoById(int productionEntryId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            ProductionEntryInfo productionEntryInfo =productionEntryService.selectProductionEntryInfoById(productionEntryId);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(productionEntryInfo);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }
}
