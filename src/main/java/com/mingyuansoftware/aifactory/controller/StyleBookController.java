package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.StyleBook;
import com.mingyuansoftware.aifactory.model.UploadFiles;
import com.mingyuansoftware.aifactory.model.dto.StyleBookDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.pojo.UploadFilesResponse;
import com.mingyuansoftware.aifactory.service.StyleBookService;
import com.mingyuansoftware.aifactory.service.UploadFilesService;
import com.mingyuansoftware.aifactory.util.Base64;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张婷
 * @date 2019/7/4 10:00
 */

@Api(value = "StyleBook", description = "式样书API", tags = {"式样书-式样书列表"})
@RestController
@RequestMapping("/styleBook")
public class StyleBookController {

    @Autowired
    private StyleBookService styleBookService;
    @Autowired
    private UploadFilesService uploadFilesService;

    @ApiOperation(value = "式样书列表", nickname = "/getStyleBookList", notes = "获取式样书列表", tags = {"@张婷"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "styleBookDto", value = "式样书参数实体类", paramType = "query", dataType = "StyleBookDto"),
    })
    @RequestMapping(value = "/getStyleBookList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getStyleBookList"})
    public LayuiCommonResponse getStyleBookList(@Validated @RequestParam(defaultValue = "1") int page,
                                                @Validated @RequestParam(defaultValue = "10") int limit,
                                                @Validated StyleBookDto styleBookDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<StyleBook> styleBookList = styleBookService.getStyleBookList(styleBookDto);
            int count = styleBookService.selectCount(styleBookDto);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCount(count);
            response.setData(styleBookList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "新增式样书", nickname = "/insertStyleBook", notes = "添加式样书", tags = {"@张婷"})
    @ApiImplicitParam(name = "styleBook", value = "式样书实体类", required = true, dataType = "StyleBook")
    @RequestMapping(value = "/insertStyleBook", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"insertStyleBook"})
    public LayuiCommonResponse insertStyleBook(@RequestBody StyleBook styleBook) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int insertStyleBook = styleBookService.insertStyleBook(styleBook);
            //登录验证
            if (insertStyleBook < 1) {
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

    @ApiOperation(value = "删除式样书", nickname = "/deleteStyleBookById", notes = "逻辑删除式样书", tags = {"@张婷"})
    @ApiImplicitParam(name = "styleBookId", value = "式样书id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/deleteStyleBookById", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"deleteStyleBookById"})
    public LayuiCommonResponse deleteStyleBookById(int styleBookId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int deleteStyleBook = styleBookService.deleteStyleBookById(styleBookId);
            //登录验证
            if (deleteStyleBook < 1) {
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

    @ApiOperation(value = "查看式样书", nickname = "/selectStyleBookById", notes = "根据式样书id查询式样书信息", tags = {"@张婷"})
    @ApiImplicitParam(name = "styleBookId", value = "式样书id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/getStyleBookById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getStyleBookById(int styleBookId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            StyleBook styleBook = styleBookService.selectStyleBookById(styleBookId);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setData(styleBook);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "更新式样书",nickname = "/updateStyleBook",notes = "更新式样书", tags = {"@张婷"})
    @ApiImplicitParam(name = "styleBook", value = "式样书信息", dataType = "StyleBook")
    @RequestMapping(value = "/updateStyleBook", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"updateStyleBook"})
    public LayuiCommonResponse updateStyleBook(@RequestBody StyleBook styleBook){
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int updateStyleBook = styleBookService.updateStyleBook(styleBook);
            //登录验证
            if(updateStyleBook < 1){
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

    @ApiOperation(value = "上传图片(限制只能单张上传)",nickname = "/saveFile",notes = "保存图片",tags = {"@张婷"})
    @RequestMapping(value = "/saveFile",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public UploadFilesResponse saveFile(@RequestParam(value = "file",required = false) MultipartFile file){
        UploadFilesResponse response = new UploadFilesResponse();
        List<String> saveFiles  = new ArrayList<>();
        UploadFiles uploadFiles = new UploadFiles();
        try {
            String fileName = file.getOriginalFilename();

            String folderName = Base64.getRandomFileName();

            String os = System.getProperty("os.name");
            String ufSavePath = "";
            if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
                File dest = new File("D:/importFile/" + folderName + fileName);
                if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest); //保存文件
                    ufSavePath ="/importFile/" + folderName + fileName;

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {  //linux 和mac
                File dest = new File("/usr/local/images/" + folderName + fileName);
                if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest); //保存文件
                    ufSavePath ="/images/" + folderName + fileName;

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            uploadFiles.setUfSavePath(ufSavePath);
            Integer ufId = uploadFilesService.insert(uploadFiles);
            uploadFiles.setUfId(ufId);
            saveFiles.add(uploadFiles.getUfSavePath());

        } catch (Exception e) {
            e.printStackTrace();
            //错误代码,0表示没有错误
            response.setErrno(1);
            return response;
        }
        //错误代码,0表示没有错误
        response.setErrno(0);
        response.setData(saveFiles);

        return response;
    }
}
