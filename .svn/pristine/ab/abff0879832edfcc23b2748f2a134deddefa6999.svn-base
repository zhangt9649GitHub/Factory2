package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.config.LogConfig;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.ProductionInstructionDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.LogService;
import com.mingyuansoftware.aifactory.service.ProductionInstructionGoodsService;
import com.mingyuansoftware.aifactory.service.ProductionInstructionService;
import com.mingyuansoftware.aifactory.util.BaseToString;
import com.mingyuansoftware.aifactory.util.DeleteFileUtil;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "ProductionInstruction", description = "生产指示书API", tags = {"生产指示书"})
@RestController
@RequestMapping("/productionInstruction")
public class ProductionInstructionController {

    @Autowired
    private ProductionInstructionService productionInstructionService;
    @Autowired
    private LogService logService;
    @Autowired
    private ProductionInstructionGoodsService productionInstructionGoodsService;

    @ApiOperation(value = "获取生产指示书列表", notes = "获取生产指示书列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "productionInstructionDto", value = "货物参数实体类", paramType = "query", dataType = "ProductionInstructionDto"),
    })
    @RequestMapping(value = "/getProductionInstructionList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getProductionInstructionList"})
    public LayuiCommonResponse getProductionInstructionList(@Validated @RequestParam(defaultValue = "1") int page,
                                            @Validated @RequestParam(defaultValue = "10") int limit,
                                            @Validated ProductionInstructionDto productionInstructionDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<ProductionInstruction> productionInstructionList =productionInstructionService.selectProductionInstructionList(productionInstructionDto);
            int count = productionInstructionService.selectCountProductionInstruction(productionInstructionDto);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(productionInstructionList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }


    @ApiOperation(value = "查看生产指示书状态信息", notes = "查看货物信息", tags = {"@郝腾"})
    @ApiImplicitParam(name = "productionInstructionId", value = "生产指示书id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/getProductionInstructionById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getProductionInstructionById(int productionInstructionId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            ProductionInstruction productionInstruction = productionInstructionService.selectProductionInstructionById(productionInstructionId);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(productionInstruction);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }


    @ApiOperation(value = "更新生产指示书状态", notes = "更新生产指示书状态", tags = {"@郝腾"})
    @ApiImplicitParam(name = "productionInstruction", value = "货物及详情", dataType = "ProductionInstruction")
    @RequestMapping(value = "/updateProductionInstructionInfo", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"updateProductionInstructionInfo"})
    public LayuiCommonResponse updateProductionInstructionInfo(@RequestBody ProductionInstruction productionInstruction) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            ProductionInstruction productionInstruction1 = productionInstructionService.selectProductionInstructionById(productionInstruction.getProductionInstructionId());
            productionInstruction.setSerialNumber(productionInstruction1.getSerialNumber());
            productionInstruction.setCreateTime(productionInstruction1.getCreateTime());
            productionInstructionService.updateGoodsInfo(productionInstruction);
            if(LogConfig.STATE){
                String text = BaseToString.BaseEntityToString(productionInstruction);
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

    @ApiOperation(value = "删除生产指示书", notes = "删除生产指示书", tags = {"@郝腾"})
    @ApiImplicitParam(name = "productionInstructionId", value = "生产指示书id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/deleteProductionInstructionById", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"deleteProductionInstructionById"})
    public LayuiCommonResponse deleteProductionInstructionById(int productionInstructionId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            ProductionInstruction productionInstruction = productionInstructionService.selectProductionInstructionById(productionInstructionId);
            if(productionInstruction.getState()!=1){
                response.setCode(HtCode.FAIL_DELETE_STATE_FINISH.getCode());
                response.setMsg(HtCode.FAIL_DELETE_STATE_FINISH.getInfo());
                return response;
            }
            productionInstructionService.deleteProductionInstructionById(productionInstructionId);
            if(LogConfig.STATE){
                String[] str= new String[]{productionInstructionId+""};
                Map<String, String[]> a_mMap= new HashMap<>();
                a_mMap.put("productionInstructionId",str);
                String text = BaseToString.MapToString(a_mMap);
                Staff userLoginDto =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
                int staffId = userLoginDto.getStaffId();
                logService.saveLog(staffId,3,text);
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

    @ApiOperation(value = "查看生产指示书详情", notes = "查看生产指示书详情", tags = {"@郝腾"})
    @ApiImplicitParam(name = "productionInstructionId", value = "生产指示书id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/getProductionInstructionDetailByPId", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getProductionInstructionDetailByPId(int productionInstructionId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            List<ProductionInstructionGoods> productionInstructionGoodsList = productionInstructionGoodsService.getProductionInstructionDetailByPId(productionInstructionId);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(productionInstructionGoodsList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "导入生产指示书", notes = "导入生产指示书", tags = {"@郝腾"})
    @RequestMapping(value = "/importProductionInstructionZip", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"importProductionInstructionZip"})
    public LayuiCommonResponse importProductionInstructionZip(@ApiParam(value = "MultipartFile", required = true) MultipartFile file) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            productionInstructionGoodsService.importProductionInstructionZip(file);
            response.setCode(HtCode.SUCCESS_IMPORT.getCode());
            response.setMsg(HtCode.SUCCESS_IMPORT.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_IMPORT.getCode());
            response.setMsg(e.getMessage());
        }finally {
            //先删除文件夹内的文件，保证是空文件夹
            String os = System.getProperty("os.name");
            if (os.toLowerCase().startsWith("win")) {//如果是Windows系统
                String unZipAddress = "D:/importZip/";
                DeleteFileUtil.delFolder(unZipAddress);
            } else {  //linux 和mac
                String unZipAddress = "/usr/local/zip/";
                DeleteFileUtil.delFolder(unZipAddress);
            }
        }
        return response;
    }

    @ApiOperation(value = "返品操作", notes = "返品操作", tags = {"@郝腾"})
    @ApiImplicitParam(name = "productionInstruction", value = "货物及详情", dataType = "ProductionInstruction")
    @RequestMapping(value = "/updatereturnQuantity", method = RequestMethod.POST)
    @ResponseBody
   // @RequiresPermissions(value = {"updatereturnQuantity"})
    public LayuiCommonResponse updatereturnQuantity() {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            //最后编写  待修改
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
