package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.BomForm;
import com.mingyuansoftware.aifactory.model.dto.BomFormDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.BomFormService;
import com.mingyuansoftware.aifactory.util.DeleteFileUtil;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 张婷
 * @date 2019/7/4 16:23
 */

@Api(value = "BomForm",description = "BOM表单API",tags = {"BOM表单-BOM表单列表"})
@RestController
@RequestMapping(value = "/bomForm")
public class BomFormController {

    @Autowired
    private BomFormService bomFormService;

    @ApiOperation(value = "BOM表单列表", nickname = "/selectBomFormList", notes = "获取BOM表单列表", tags = {"@张婷"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "bomFormDto", value = "BOM表单参数实体类", paramType = "query", dataType = "BomFormDto"),
    })
    @RequestMapping(value = "/getBomFormList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getBomFormList"})
    public LayuiCommonResponse getBomFormList(@Validated @RequestParam(defaultValue = "1") int page,
                                                @Validated @RequestParam(defaultValue = "10") int limit,
                                                @Validated BomFormDto bomFormDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<BomForm> bomFormList = bomFormService.selectBomFormList(bomFormDto);
            int count = bomFormService.selectCount(bomFormDto);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCount(count);
            response.setData(bomFormList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "新增bom表单", nickname = "/insertBomForm", notes = "添加bom表单", tags = {"@张婷"})
    @ApiImplicitParam(name = "bomForm", value = "BOM表单实体类",required = true, dataType = "BomForm")
    @RequestMapping(value = "/insertBomForm", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"insertBomForm"})
    public LayuiCommonResponse insertBomForm(@RequestBody BomForm bomForm) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int insertBomForm = bomFormService.insertBomForm(bomForm);
            //登录验证
            if(insertBomForm < 1){
                response.setCode(ZtCode.FAIL_READD.getCode());
                response.setMsg(ZtCode.FAIL_READD.getInfo());
                return response;
            }
            response.setCode(ZtCode.SUCCESS_ADD.getCode());
            response.setMsg(ZtCode.SUCCESS_ADD.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_READD.getCode());
            response.setMsg(ZtCode.FAIL_READD.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "删除bom表单", nickname = "/deleteBomFormById", notes = "根据id删除bom表单", tags = {"@张婷"})
    @ApiImplicitParam(name = "bomId", value = "BOM表单id",required = true,paramType = "query",dataType = "int")
    @RequestMapping(value = "/deleteBomFormById", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"deleteBomFormById"})
    public LayuiCommonResponse deleteBomFormById(int bomId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int insertBomForm = bomFormService.deleteBomFormById(bomId);
            //登录验证
            if(insertBomForm < 1){
                response.setCode(ZtCode.FAIL_DELETE.getCode());
                response.setMsg(ZtCode.FAIL_DELETE.getInfo());
                return response;
            }
            response.setCode(ZtCode.SUCCESS_DELETE.getCode());
            response.setMsg(ZtCode.SUCCESS_DELETE.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_DELETE.getCode());
            response.setMsg(ZtCode.FAIL_DELETE.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "查看BOM表单信息", nickname = "/getBomFormDetailById", notes = "根据id查询bom表单信息", tags = {"@张婷"})
    @ApiImplicitParam(name = "bomId", value = "BOM表单id",required = true,paramType = "query", dataType = "int")
    @RequestMapping(value = "/getBomFormDetailById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getBomFormDetailById(int bomId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            BomForm bomForm = bomFormService.selectBomFormDetailById(bomId);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setData(bomForm);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "更新BOM表单", nickname = "/getBomFormDetailById", notes = "修改bom表单内容", tags = {"@张婷"})
    @ApiImplicitParam(name = "bomForm", value = "BOM表单信息", dataType = "BomForm")
    @RequestMapping(value = "/updateBomFormDetail", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"updateBomFormDetail"})
    public LayuiCommonResponse updateBomFormDetail(@RequestBody BomForm bomForm) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int updateBomFormDetail = bomFormService.updateBomFormDetail(bomForm);
            //登录验证
            if (updateBomFormDetail < 1){
                response.setCode(ZtCode.FAIL_EDIT.getCode());
                response.setMsg(ZtCode.FAIL_EDIT.getInfo());
                return response;
            }
            response.setCode(ZtCode.SUCCESS_EDIT.getCode());
            response.setMsg(ZtCode.SUCCESS_EDIT.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_EDIT.getCode());
            response.setMsg(ZtCode.FAIL_EDIT.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "导入Bom表单", notes = "导入Bom表单", tags = {"@郝腾"})
    @RequestMapping(value = "/importBomForm", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"importBomForm"})
    public LayuiCommonResponse importBomForm(@ApiParam(value = "MultipartFile", required = true) MultipartFile file) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            bomFormService.importBomForm(file);
            response.setCode(HtCode.SUCCESS_IMPORT.getCode());
            response.setMsg(HtCode.SUCCESS_IMPORT.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_IMPORT.getCode());
            response.setMsg(e.getMessage());
        } finally {
            //删除文件夹内的文件
            String os = System.getProperty("os.name");
            if (os.toLowerCase().startsWith("win")) {//如果是Windows系统
                String unZipAddress = "D:/importCsv/";
                DeleteFileUtil.delFolder(unZipAddress);
            } else {  //linux 和mac
                String unZipAddress = "/usr/local/csv/";
                DeleteFileUtil.delFolder(unZipAddress);
            }
        }
        return response;
    }
}
