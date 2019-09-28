package com.mingyuansoftware.aifactory.controller;

import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.UploadFiles;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.UploadFilesService;
import com.mingyuansoftware.aifactory.util.Base64;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Api(value="importFile",description = "上传图片",tags={"上传图片"})
@SpringBootApplication
@RestController
@RequestMapping("/multipleFileUpload")
public class MultipleFileUploadController {

    @Autowired
    private UploadFilesService uploadFilesService;

    @ApiOperation(value = "保存图片",notes = "保存图片",tags={"@郝腾"})
    @RequestMapping(value = "/importFile",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public LayuiCommonResponse importFile(@RequestParam(value = "file", required = false) MultipartFile file){

        LayuiCommonResponse response = new LayuiCommonResponse();
        UploadFiles uploadFiles = new UploadFiles();
        try {
            String fileName = file.getOriginalFilename();

            /*ApplicationHome home = new ApplicationHome(getClass());
            File jarFile = home.getSource();
            String filePath = jarFile.getParentFile().toString();*/

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
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_UPLOAD.getCode());
            response.setMsg(HtCode.FAIL_UPLOAD.getInfo());
            return response;
        }

        response.setCode(HtCode.SUCCESS_UPLOAD.getCode());
        response.setMsg(HtCode.SUCCESS_UPLOAD.getInfo());
        response.setData(uploadFiles);

        return response;
    }

}
