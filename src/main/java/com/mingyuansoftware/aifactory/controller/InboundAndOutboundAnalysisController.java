package com.mingyuansoftware.aifactory.controller;


import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.InboundAndOutboundAnalysis;
import com.mingyuansoftware.aifactory.model.TotalInboundAndOutboundAnalysis;
import com.mingyuansoftware.aifactory.model.dto.InboundAndOutboundDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.StockKucunGoodsService;
import com.mingyuansoftware.aifactory.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;


@Api(value = "InboundAndOutboundAnalysis", description = "出入库分析表API", tags = {"出入库分析表"})
@RestController
@RequestMapping("/inboundAndOutbound")
public class InboundAndOutboundAnalysisController {

    @Autowired
    private StockKucunGoodsService stockKucunGoodsService;

    @ApiOperation(value = "获取出入库分析表", notes = "获取出入库分析表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime", value = "开始时间", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "goodsId", value = "货物id", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "category", value = "类别", paramType = "query", dataType = "Byte")
    })
    @RequestMapping(value = "/getInboundAndOutboundAnalysisList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getInboundAndOutboundAnalysisList"})
    public LayuiCommonResponse getInboundAndOutboundAnalysisList( @Validated String startTime, @Validated String endTime,
                                                                  @Validated Integer goodsId, @Validated Byte category) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            InboundAndOutboundDto inboundAndOutboundDto = new InboundAndOutboundDto();
            //inboundAndOutboundDto.setGoodsName(goodsName);
            inboundAndOutboundDto.setStartTime(startTime);
            inboundAndOutboundDto.setEndTime(endTime);
            inboundAndOutboundDto.setCategory(category);
            inboundAndOutboundDto.setGoodsId(goodsId);
            TotalInboundAndOutboundAnalysis totalInboundAndOutboundAnalysis = stockKucunGoodsService.selectInboundAndOutboundAnalysisList(inboundAndOutboundDto);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(totalInboundAndOutboundAnalysis);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

   @ApiOperation(value = "导出出入库分析表", notes = "导出出入库分析表",tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime", value = "开始时间", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "goodsId", value = "货物id", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "category", value = "类别", paramType = "query", dataType = "Byte")
    })
    @RequestMapping(value = "/exportInboundAndOutboundAnalysisList", method = RequestMethod.GET)
    @ResponseBody
   @RequiresPermissions(value = {"exportInboundAndOutboundAnalysisList"})
    public void exportGoodsList(HttpServletResponse response, @Validated String startTime, @Validated String endTime,
                                @Validated Integer goodsId, @Validated Byte category)
            throws IOException {
       InboundAndOutboundDto inboundAndOutboundDto = new InboundAndOutboundDto();
       //inboundAndOutboundDto.setGoodsName(goodsName);
       inboundAndOutboundDto.setStartTime(startTime);
       inboundAndOutboundDto.setEndTime(endTime);
       inboundAndOutboundDto.setCategory(category);
       inboundAndOutboundDto.setGoodsId(goodsId);
       TotalInboundAndOutboundAnalysis totalInboundAndOutboundAnalysis = stockKucunGoodsService.selectInboundAndOutboundAnalysisList(inboundAndOutboundDto);
       List<InboundAndOutboundAnalysis> inboundAndOutboundAnalysisList =totalInboundAndOutboundAnalysis.getInboundAndOutboundAnalysisList();
       String fileName = DateUtil.getStringTodayMillisecond()  + ".xls";//设置要导出的文件的名字
       response.setContentType("application/application/vnd.ms-excel");
       response.setHeader("Content-disposition",
               "attachment;filename=" + URLEncoder.encode(DateUtil.getStringTodayMillisecond() + ".xls", "UTF-8"));
       ServletOutputStream out = response.getOutputStream();
       HSSFWorkbook workbook = new HSSFWorkbook();
       HSSFSheet sheet = workbook.createSheet();
       //合并单元格
       HSSFRow row = sheet.createRow(0);
       row.createCell(0).setCellValue("名称");
       row.createCell(1).setCellValue("入库");
       row.createCell(4).setCellValue("出库");
       row.createCell(7).setCellValue("结存");
       HSSFRow row1= sheet.createRow(1);
       row1.createCell(1).setCellValue("入库数量");
       row1.createCell(2).setCellValue("入库单价");
       row1.createCell(3).setCellValue("入库金额");
       row1.createCell(4).setCellValue("出库数量");
       row1.createCell(5).setCellValue("出库单价");
       row1.createCell(6).setCellValue("出库金额");
       row1.createCell(7).setCellValue("在库数量");
       row1.createCell(8).setCellValue("在库单价");
       row1.createCell(9).setCellValue("在库金额");
       ByteArrayOutputStream arrayInputStream = new ByteArrayOutputStream();
       int index = 2;
       try {
           for (InboundAndOutboundAnalysis inboundAndOutboundAnalysis : inboundAndOutboundAnalysisList) {
               row = sheet.createRow(index);
               row.createCell(0).setCellValue(inboundAndOutboundAnalysis.getGoodsName());
               row.createCell(1).setCellValue(String.valueOf(inboundAndOutboundAnalysis.getInventoryQuantity()));
               row.createCell(2).setCellValue(String.valueOf(inboundAndOutboundAnalysis.getInventoryUnitPrice()));
               row.createCell(3).setCellValue(String.valueOf(inboundAndOutboundAnalysis.getInventoryUnitPrice()));
               row.createCell(4).setCellValue(String.valueOf(inboundAndOutboundAnalysis.getOutboundQuantity()));
               row.createCell(5).setCellValue(String.valueOf(inboundAndOutboundAnalysis.getOutboundUnitPrice()));
               row.createCell(6).setCellValue(String.valueOf(inboundAndOutboundAnalysis.getOutboundAmount()));
               row.createCell(7).setCellValue(String.valueOf(inboundAndOutboundAnalysis.getInStockQuantity()));
               row.createCell(8).setCellValue(String.valueOf(inboundAndOutboundAnalysis.getInStockUnitPrice()));
               row.createCell(9).setCellValue(String.valueOf(inboundAndOutboundAnalysis.getInStockAmount()));
               index++;
           }
           row = sheet.createRow(index);
           row.createCell(0).setCellValue("合计");
           row.createCell(1).setCellValue(String.valueOf(totalInboundAndOutboundAnalysis.getTotalInventoryQuantity()));
           row.createCell(2).setCellValue(String.valueOf(totalInboundAndOutboundAnalysis.getTotalInventoryUnitPrice()));
           row.createCell(3).setCellValue(String.valueOf(totalInboundAndOutboundAnalysis.getTotalInventoryAmount()));
           row.createCell(4).setCellValue(String.valueOf(totalInboundAndOutboundAnalysis.getTotalOutboundQuantity()));
           row.createCell(5).setCellValue(String.valueOf(totalInboundAndOutboundAnalysis.getTotalOutboundUnitPrice()));
           row.createCell(6).setCellValue(String.valueOf(totalInboundAndOutboundAnalysis.getTotalOutboundAmount()));
           row.createCell(7).setCellValue(String.valueOf(totalInboundAndOutboundAnalysis.getTotalInStockQuantity()));
           row.createCell(8).setCellValue(String.valueOf(totalInboundAndOutboundAnalysis.getTotalInStockUnitPrice()));
           row.createCell(9).setCellValue(String.valueOf(totalInboundAndOutboundAnalysis.getTotalInStockAmount()));
       } catch (Exception e) {
           e.printStackTrace();
       }
       CellRangeAddress callRangeAddress = new CellRangeAddress(0,0,1,3);//起始行,结束行,起始列,结束列
       CellRangeAddress callRangeAddress1 = new CellRangeAddress(0,0,4,6);//起始行,结束行,起始列,结束列
       CellRangeAddress callRangeAddress2 = new CellRangeAddress(0,0,7,9);//起始行,结束行,起始列,结束列
       CellRangeAddress callRangeAddress3 = new CellRangeAddress(0,1,0,0);//起始行,结束行,起始列,结束列
       sheet.addMergedRegion(callRangeAddress);
       sheet.addMergedRegion(callRangeAddress1);
       sheet.addMergedRegion(callRangeAddress2);
       sheet.addMergedRegion(callRangeAddress3);
       workbook.write(arrayInputStream);
       byte[] bytes = arrayInputStream.toByteArray();
       out.write(bytes);
       out.close();
    }

}
