package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.ProductionOrderInfo;
import com.mingyuansoftware.aifactory.model.dto.PickingDetailsDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.PickingDetailsService;
import com.mingyuansoftware.aifactory.service.ProductionOrderService;
import com.mingyuansoftware.aifactory.util.DateUtil;
import com.mingyuansoftware.aifactory.util.DeleteFileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Api(value = "HomePage", description = "后台首页API", tags = {"后台首页"})
@RestController
@RequestMapping("/homePage")
public class HomePageController {

    @Autowired
    private PickingDetailsService pickingDetailsService;
    @Autowired
    private ProductionOrderService productionOrderService;

    @ApiOperation(value = "获取领料明细列表", notes = "获取领料明细列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
    })
    @RequestMapping(value = "/getPickingInfoList", method = RequestMethod.GET)
    @ResponseBody
    public LayuiCommonResponse getPickingInfoList(@Validated @RequestParam(defaultValue = "1") int page,
                                                  @Validated @RequestParam(defaultValue = "10") int limit) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<PickingDetailsDto> pickingDetailsDtoList = pickingDetailsService.selectPickingInfoList();
            int count = pickingDetailsService.selectCountPickingInfoList();
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(pickingDetailsDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "获取排产单列表", notes = "获取排产单列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/getProductionOrderInfoList", method = RequestMethod.GET)
    @ResponseBody
    public LayuiCommonResponse getProductionOrderInfoList(@Validated @RequestParam(defaultValue = "1") int page,
                                                          @Validated @RequestParam(defaultValue = "10") int limit) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<ProductionOrderInfo> productionOrderInfoList = productionOrderService.selectProductionOrderInfoList();
            int count = productionOrderService.selectCountProductionOrderInfoList();
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(productionOrderInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "导出", notes = "导出",tags = {"@郝腾"})
    @RequestMapping(value = "/getExport", method = RequestMethod.GET)
    @ResponseBody
    public void getExport(HttpServletResponse response)
            throws IOException {
        File zipFile=new File(DateUtil.getStringTodayMillisecond()+".zip");
        FileOutputStream zipOut = new FileOutputStream(zipFile);
        byte[] buffer = new byte[1024];
        ZipOutputStream out = new ZipOutputStream(zipOut);
        File csvFile = null;
        BufferedWriter csvWtriter = null;
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {//如果是Windows系统
            String outPutPath = "D:/importCsv/";
            csvFile = new File(outPutPath + File.separator + DateUtil.getStringTodayMillisecond() + ".csv");
        } else {  //linux 和mac
            String outPutPath = "/usr/local/csv/";
            csvFile = new File(outPutPath + File.separator + DateUtil.getStringTodayMillisecond() + ".csv");
        }
        File parent = csvFile.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        csvFile.createNewFile();
        // GB2312使正确读取分隔符","
        BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                csvFile), "GB2312"), 1024);
        Object[] head = {"", "", "", "", "", "", "", "", "", "", "" };
        List<Object> headList = Arrays.asList(head);
        for (Object data : headList) {
            StringBuffer sb = new StringBuffer();
            String rowStr = sb.append("\"").append(data).append("\",").toString();
            csvWriter.write(rowStr);
        }
        csvWriter.newLine();
        //TODO:查询列表 写入列表内容

        FileOutputStream fOut = new FileOutputStream(csvFile);
        fOut.flush();
        fOut.close();// 操作结束，关闭文件

        FileInputStream fileInputStream = new FileInputStream(csvFile);
        //在压缩包中创建文件
        out.putNextEntry(new ZipEntry(csvFile.getName()));
        int length;
        while ((length = fileInputStream.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        out.closeEntry();
        fileInputStream.close();
        out.close();

        ByteArrayOutputStream byteOut=new ByteArrayOutputStream();
        FileInputStream fileInput = new FileInputStream(zipFile);

        byte [] byte_i=new byte[1024];
        int num_i=0;
        while((num_i=(fileInput.read(byte_i)))>-1){
            byteOut.write(byte_i,0,num_i);
        }
        byte [] byte_z=byteOut.toByteArray();

        fileInput.close();
        byteOut.close();
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition","attachment;filename="+zipFile.getName()+"");
        OutputStream fileOutputStream = response.getOutputStream();
        fileOutputStream.write(byte_z);
        fileOutputStream.flush();
        fileOutputStream.close();
        csvFile.delete();
        zipFile.delete();
    }
}
