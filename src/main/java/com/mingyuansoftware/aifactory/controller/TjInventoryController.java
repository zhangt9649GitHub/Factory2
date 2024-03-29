package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.TjKucunGoodsInfo;
import com.mingyuansoftware.aifactory.model.dto.TjGoodsKucunDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.GoodsService;
import com.mingyuansoftware.aifactory.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

@Api(value = "TjInventory", description = "天津库存表API", tags = {"天津库存表"})
@RestController
@RequestMapping("/tjInventory")
public class TjInventoryController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "获取天津库存表", notes = "获取天津库存表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "tjGoodsKucunDto", value = "天津货物库存参数实体类", paramType = "query", dataType = "TjGoodsKucunDto"),
    })
    @RequestMapping(value = "/getTjGoodsKucunList", method = RequestMethod.GET)
    @ResponseBody

    public LayuiCommonResponse getTjGoodsKucunList(@Validated @RequestParam(defaultValue = "1") int page,
                                                   @Validated @RequestParam(defaultValue = "10") int limit,
                                                   @Validated TjGoodsKucunDto tjGoodsKucunDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<TjGoodsKucunDto> tjGoodsKucunDtoList = goodsService.selectTjGoodsKucunList(tjGoodsKucunDto);
            int count = goodsService.selectTjGoodsKucunCount(tjGoodsKucunDto);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(tjGoodsKucunDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "查看货物库存详情", notes = "查看货物库存详情", tags = {"@郝腾"})
    @ApiImplicitParam(name = "goodsId", value = "货物id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = "/getTjGoodsKucunInfoById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getTjGoodsKucunInfoById(int goodsId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            TjKucunGoodsInfo tjKucunGoodsInfo = goodsService.selectTjGoodsKucunInfoById(goodsId);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setData(tjKucunGoodsInfo);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "导出天津库存表", notes = "导出天津库存表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "partsCd", value = "部品CD", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "goodsName", value = "品名", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "specification", value = "规格", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "skgCount", value = "库存数", paramType = "query", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "warehouseName", value = "仓库名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "wpName", value = "仓位名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "latestShipment", value = "最新出货数", paramType = "query", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "aPrice", value = "a单价", paramType = "query", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "bPrice", value = "b单价", paramType = "query", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "amount", value = "金额", paramType = "query", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "category", value = "货物类别", paramType = "query", dataType = "Byte"),
            @ApiImplicitParam(name = "occupiedAmount", value = "被领料单占用的数量", paramType = "query", dataType = "BigDecimal")
    })
    @RequestMapping(value = "/exportTjGoodsKucunList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"exportTjGoodsKucunList"})
    public void exportTjGoodsKucunList(HttpServletResponse response, @Validated String partsCd, @Validated String goodsName,
                                       @Validated String specification, @Validated BigDecimal skgCount, @Validated String warehouseName,
                                       @Validated String wpName, @Validated BigDecimal latestShipment, @Validated BigDecimal aPrice,
                                       @Validated BigDecimal bPrice, @Validated BigDecimal amount, @Validated Byte category,
                                       @Validated BigDecimal occupiedAmount)
            throws IOException {
        TjGoodsKucunDto tjGoodsKucunDto = new TjGoodsKucunDto();
        tjGoodsKucunDto.setPartsCd(partsCd);
        tjGoodsKucunDto.setGoodsName(goodsName);
        tjGoodsKucunDto.setSpecification(specification);
        tjGoodsKucunDto.setSkgCount(skgCount);
        tjGoodsKucunDto.setWarehouseName(warehouseName);
        tjGoodsKucunDto.setWpName(wpName);
        tjGoodsKucunDto.setLatestShipment(latestShipment);
        tjGoodsKucunDto.setaPrice(aPrice);
        tjGoodsKucunDto.setbPrice(bPrice);
        tjGoodsKucunDto.setAmount(amount);
        tjGoodsKucunDto.setCategory(category);
        tjGoodsKucunDto.setOccupiedAmount(occupiedAmount);
        List<TjGoodsKucunDto> tjGoodsKucunDtoList = goodsService.selectTjGoodsKucunList(tjGoodsKucunDto);
        String fileName = DateUtil.getStringTodayMillisecond() + ".xls";//设置要导出的文件的名字
        response.setContentType("application/application/vnd.ms-excel");
        response.setHeader("Content-disposition",
                "attachment;filename=" + URLEncoder.encode(DateUtil.getStringTodayMillisecond() + ".xls", "UTF-8"));
        ServletOutputStream out = response.getOutputStream();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("部品CD");
        row.createCell(1).setCellValue("品名");
        row.createCell(2).setCellValue("规格");
        row.createCell(3).setCellValue("库存数量");
        row.createCell(4).setCellValue("仓库");
        row.createCell(5).setCellValue("仓位");
        row.createCell(6).setCellValue("最新出货数");
        row.createCell(7).setCellValue("a单价");
        row.createCell(8).setCellValue("b单价");
        row.createCell(9).setCellValue("金额");
        row.createCell(10).setCellValue("种类");
        ByteArrayOutputStream arrayInputStream = new ByteArrayOutputStream();
        int index = 1;
        try {
            for (TjGoodsKucunDto tjGoodsKucunDto1 : tjGoodsKucunDtoList) {
                row = sheet.createRow(index);
                row.createCell(0).setCellValue(tjGoodsKucunDto1.getPartsCd());
                row.createCell(1).setCellValue(tjGoodsKucunDto1.getGoodsName());
                row.createCell(2).setCellValue(tjGoodsKucunDto1.getSpecification());
                row.createCell(3).setCellValue(String.valueOf(tjGoodsKucunDto1.getSkgCount()));
                row.createCell(4).setCellValue(tjGoodsKucunDto1.getWarehouseName());
                row.createCell(5).setCellValue(tjGoodsKucunDto1.getWpName());
                row.createCell(6).setCellValue(String.valueOf(tjGoodsKucunDto1.getLatestShipment()));
                row.createCell(7).setCellValue(String.valueOf(tjGoodsKucunDto1.getaPrice()));
                row.createCell(8).setCellValue(String.valueOf(tjGoodsKucunDto1.getbPrice()));
                row.createCell(9).setCellValue(String.valueOf(tjGoodsKucunDto1.getAmount()));
                row.createCell(10).setCellValue(tjGoodsKucunDto1.getCategoryName());
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        workbook.write(arrayInputStream);
        byte[] bytes = arrayInputStream.toByteArray();
        out.write(bytes);
        out.close();
    }

}
