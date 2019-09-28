package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.ZtCode;
import com.mingyuansoftware.aifactory.model.KucunGoods;
import com.mingyuansoftware.aifactory.model.PurchaseApply;
import com.mingyuansoftware.aifactory.model.PurchaseApplyDetails;
import com.mingyuansoftware.aifactory.model.PurchaseOrder;
import com.mingyuansoftware.aifactory.model.dto.PurchaseApplyDetailsDto;
import com.mingyuansoftware.aifactory.model.dto.PurchaseApplyDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.PurchaseApplyService;
import com.mingyuansoftware.aifactory.service.StockKucunGoodsService;
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
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author 张婷
 * @date 2019/7/9 15:40
 */

@Api(value = "PurchaseApply",description = "采购申请单API",tags = {"采购申请单-采购申请单列表"})
@RestController
@RequestMapping("/purchaseApply")
public class PurchaseApplyController {

    @Autowired
    private PurchaseApplyService purchaseApplyService;
    @Autowired
    private StockKucunGoodsService stockKucunGoodsService;

    @ApiOperation(value = "采购申请单列表", nickname = "/selectPurchaseApplyList", notes = "获取采购申请单列表", tags = {"@张婷"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "purchaseApplyDto", value = "采购申请单参数实体类", paramType = "query", dataType = "PurchaseApplyDto"),
    })
    @RequestMapping(value = "/getPurchaseApplyList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getPurchaseApplyList"})
    public LayuiCommonResponse getPurchaseApplyList(@Validated @RequestParam(defaultValue = "1") int page,
                                              @Validated @RequestParam(defaultValue = "10") int limit,
                                              @Validated PurchaseApplyDto purchaseApplyDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<PurchaseApplyDetailsDto> purchaseApplyList = purchaseApplyService.selectpurchaseApplyList(purchaseApplyDto);
            int count = purchaseApplyService.selectCount(purchaseApplyDto);
            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setCount(count);
            response.setData(purchaseApplyList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "新增采购申请单", nickname = "/insertPurchaseApply", notes = "添加采购申请单", tags = {"@张婷"})
    @ApiImplicitParam(name = "purchaseApply", value = "采购申请单实体类", required = true, dataType = "PurchaseApply")
    @RequestMapping(value = "/insertPurchaseApply", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"insertPurchaseApply"})
    public LayuiCommonResponse insertPurchaseApply(@RequestBody PurchaseApply purchaseApply) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int insertPurchaseApply = purchaseApplyService.insertPurchaseApply(purchaseApply);
            //登录验证
            if(insertPurchaseApply < 1){
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

    @ApiOperation(value = "删除采购申请单", nickname = "/deletePurchaseApply", notes = "删除采购申请单", tags = {"@张婷"})
    @ApiImplicitParam(name = "purchaseApplyDetailsId", value = "采购申请单详情id",required = true, paramType = "query", dataType = "int")
    @RequestMapping(value = "/deletePurchaseApply", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"deletePurchaseApply"})
    public LayuiCommonResponse deletePurchaseApply(int purchaseApplyDetailsId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int deletePurchaseApply = purchaseApplyService.deletePurchaseApply(purchaseApplyDetailsId);
            //登录验证
            if(deletePurchaseApply < 1){
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

    @ApiOperation(value = "查看采购申请单", nickname = "/getPurchaseApplyDetailsById", notes = "通过id获取采购申请单详情(编辑使用)", tags = {"@张婷"})
    @ApiImplicitParam(name = "purchaseApplyDetailsId", value = "采购申请单详情id",required = true, paramType = "query", dataType = "int")
    @RequestMapping(value = "/getPurchaseApplyDetailsById", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getPurchaseApplyDetailsById(int purchaseApplyDetailsId) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PurchaseApply purchaseApply = purchaseApplyService.selectPurchaseApplyById(purchaseApplyDetailsId);
            PurchaseApplyDetails purchaseApplyDetails = purchaseApply.getPurchaseApplyDetails();
            KucunGoods kucunGoods= stockKucunGoodsService.getStockKucunGoodsCountByGoodsIdAndWarehouseId(0,purchaseApply.getPurchaseApplyDetails().getGoodsId());
            if(kucunGoods!=null&&kucunGoods.getSkgCount()!=null){
                purchaseApplyDetails.setSkgCount(kucunGoods.getSkgCount());
            }else{
                purchaseApplyDetails.setSkgCount(new BigDecimal(0));
            }

            response.setCode(ZtCode.SUCCESS_GET.getCode());
            response.setMsg(ZtCode.SUCCESS_GET.getInfo());
            response.setData(purchaseApply);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_GET.getCode());
            response.setMsg(ZtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "更新采购申请单", nickname = "/updatePurchaseApplyInfo", notes = "更新采购申请单", tags = {"@张婷"})
    @ApiImplicitParam(name = "purchaseApply", value = "采购申请单信息", dataType = "PurchaseApply")
    @RequestMapping(value = "/updatePurchaseApplyInfo", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"updatePurchaseApplyInfo"})
    public LayuiCommonResponse updatePurchaseApplyInfo(@RequestBody PurchaseApply purchaseApply) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int insertPurchaseApply = purchaseApplyService.updatePurchaseApply(purchaseApply);
            //登录验证
            if(insertPurchaseApply < 1){
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

    /*@ApiOperation(value = "导出采购申请单列表",nickname = "/exportPurchaseApplyList",notes = "导出采购申请单列表",tags = {"@张婷"})
    @RequestMapping(value = "/exportPurchaseApplyList",method = RequestMethod.GET)
    @ResponseBody
    public void exportPurchaseApplyList(HttpServletResponse response)
            throws IOException {
        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            csvFile = new File("C:/" + File.separator + "export" + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();
            // UTF-8使正确读取分隔符","
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"), 1024);
            //写入前段字节流，防止乱码
            csvFileOutputStream.write(getBOM());
            LinkedHashMap map = new LinkedHashMap();

            //设置列名
            map.put("1", "部品CD");
            map.put("2", "品名");
            map.put("3", "数量");
            map.put("4", "单位");
            map.put("5", "规格");
            map.put("6", "采购周期要求");
            map.put("7", "用途说明");
            map.put("8", "时间");
            map.put("9", "创建人");
            map.put("10","在库月数");
            map.put("11","在库数量（天津侧）");
//            map.put("12","发注中");
//            map.put("13","发注残");
//            map.put("14","引当残");
//            map.put("15","注文不足或多余在库");
            map.put("16","供应商");
            map.put("17","阶梯价格信息");
            map.put("18","处理状态");
            map.put("19","处理意见");
            map.put("20","备注");
            map.put("21","编号");
            // 写入文件头部
            for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext(); ) {
                Map.Entry propertyEntry = (Map.Entry) propertyIterator.next();
                csvFileOutputStream.write((String) propertyEntry.getValue() != null ? (String) propertyEntry.getValue() : "");
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();
            List exportData = new ArrayList<Map>();
            List<PurchaseApplyDto> purchaseApplyList = purchaseApplyService.selectExportPurchaseApplyList();
            for (PurchaseApplyDto purchaseApply:purchaseApplyList){
                Map row1 = new LinkedHashMap<String, String>();
                //部品CD 品名 数量d 单位 规格 采购周期要求 用途说明 时间 创建人 在库月数d
                //在库数量(天津侧)d 发注中 发注残 引当残 注文不足或多余在库 供应商 阶梯价格信息d 订单状态 处理状态 处理意见
                //备注 编号23
                row1.put("1", purchaseApply.getPartsCd()==null?"":purchaseApply.getPartsCd());
                row1.put("2", purchaseApply.getGoodsName()==null?"":purchaseApply.getGoodsName());
                row1.put("3", String.valueOf(purchaseApply.getQuantity()==null?"":purchaseApply.getQuantity()));
                row1.put("4", purchaseApply.getUnit()==null?"":purchaseApply.getUnit());
                row1.put("5", purchaseApply.getSpecification()==null?"":purchaseApply.getSpecification());
                row1.put("6", purchaseApply.getPurchaseCycle()==null?"":purchaseApply.getPurchaseCycle());
                row1.put("7", purchaseApply.getPurpose()==null?"":purchaseApply.getPurpose());
                row1.put("8", purchaseApply.getDefineDate()==null?"":purchaseApply.getDefineDate());
                row1.put("9", purchaseApply.getName()==null?"":purchaseApply.getName());
                row1.put("10", String.valueOf(purchaseApply.getMonthsInStock()==null?"":purchaseApply.getMonthsInStock()));
                row1.put("11", String.valueOf(purchaseApply.getTjStock()==null?"":purchaseApply.getTjStock()));
//                row1.put("12", purchaseApply.getFazhuzhong()==null?"":purchaseApply.getFazhuzhong());
//                row1.put("13", purchaseApply.getFazhucan()==null?"":purchaseApply.getFazhucan());
//                row1.put("14", purchaseApply.getYindangcan()==null?"":purchaseApply.getYindangcan());
//                row1.put("15", purchaseApply.getSpare()==null?"":purchaseApply.getSpare());
                row1.put("16", purchaseApply.getSupplierName()==null?"":purchaseApply.getSupplierName());
                row1.put("17", String.valueOf(purchaseApply.getStairPrice()==null?"":purchaseApply.getStairPrice()));
//                row1.put("18", String.valueOf(purchaseApply.getOrderStatus()==null?"":purchaseApply.getOrderStatus()));
                row1.put("18", String.valueOf(purchaseApply.getHandleStatus()==null?"":purchaseApply.getHandleStatus()));
                row1.put("19", purchaseApply.getHandleIdea()==null?"":purchaseApply.getHandleIdea());
                row1.put("20", purchaseApply.getComment()==null?"":purchaseApply.getComment());
                row1.put("21", purchaseApply.getPurchaseNumber()==null?"":purchaseApply.getPurchaseNumber());
                exportData.add(row1);
            }
            // 写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext(); ) {
                Object row = (Object) iterator.next();
                for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator
                        .hasNext(); ) {
                    Map.Entry propertyEntry = (Map.Entry) propertyIterator
                            .next();
                    String str = row != null ? ((String) ((Map) row).get(propertyEntry.getKey())) : "";
                    if (StringUtils.isEmpty(str)) {
                        str = "";
                    } else {
                        str = str.replaceAll("\"", "\"\"");
                        if (str.indexOf(",") >= 0) {
                            str = "\"" + str + "\"";
                        }
                    }
                    csvFileOutputStream.write(str);
                    if (propertyIterator.hasNext()) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        InputStream in = null;
        try {
            in = new FileInputStream(csvFile);
            int len = 0;
            byte[] buffer = new byte[1024];

            OutputStream out = response.getOutputStream();
            response.reset();

            response.setContentType("application/csv;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("export" + ".csv", "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            while ((len = in.read(buffer)) > 0) {
                out.write(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF});
                out.write(buffer, 0, len);
            }
            out.close();
        } catch (FileNotFoundException e) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    *//**
     * 功能说明：获取UTF-8编码文本文件开头的BOM签名。
     * BOM(Byte Order Mark)，是UTF编码方案里用于标识编码的标准标记。例：接收者收到以EF BB BF开头的字节流，就知道是UTF-8编码。
     * @return UTF-8编码文本文件开头的BOM签名
     *//*
    public static String getBOM() {

        byte b[] = {(byte)0xEF, (byte)0xBB, (byte)0xBF};
        return new String(b);
    }*/

    @ApiOperation(value = "导出采购申请单列表",nickname = "/exportPurchaseApplyList",notes = "导出采购申请单列表",tags = {"@张婷"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "partsCd", value = "部品CD", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "goodsName", value = "品名", paramType = "query", dataType = "String"),

            @ApiImplicitParam(name = "quantity", value = "数量", paramType = "query", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "unit", value = "单位", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "purchaseCycle", value = "采购周期要求", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "purpose", value = "用途说明", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "defineDate", value = "创建时间", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "创建人", paramType = "query", dataType = "String"),

            @ApiImplicitParam(name = "monthsInStock", value = "在库月数", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "tjStock", value = "在库数量（天津侧）", paramType = "query", dataType = "BigDecimal"),

            @ApiImplicitParam(name = "supplierName", value = "供应商", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "stairPrice", value = "阶梯价格信息", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "handleStatus", value = "处理状态", paramType = "query", dataType = "Byte"),
            @ApiImplicitParam(name = "handleIdea", value = "处理意见", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "specification", value = "规格数据", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "comment", value = "备注", paramType = "query", dataType = "String"),

            @ApiImplicitParam(name = "purchaseNumber", value = "采购申请单编号", paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/exportPurchaseApplyList",method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"exportPurchaseApplyList"})
    public void exportPurchaseApplyList(HttpServletResponse response, @Validated String partsCd, @Validated String goodsName,
                                        @Validated BigDecimal quantity, @Validated String unit, @Validated String purchaseCycle,
                                        @Validated String purpose, @Validated String defineDate, @Validated String name,
                                        @Validated String monthsInStock, @Validated BigDecimal tjStock,
                                        @Validated String supplierName, @Validated String stairPrice, @Validated Byte handleStatus,
                                        @Validated String handleIdea, @Validated String specification, @Validated String comment,
                                        @Validated String purchaseNumber)
            throws IOException {
        PurchaseApplyDto purchaseApplyDto = new PurchaseApplyDto();
        purchaseApplyDto.setPartsCd(partsCd);
        purchaseApplyDto.setGoodsName(goodsName);
        purchaseApplyDto.setQuantity(quantity);
        purchaseApplyDto.setUnit(unit);
        purchaseApplyDto.setPurchaseCycle(purchaseCycle);
        purchaseApplyDto.setPurpose(purpose);
        purchaseApplyDto.setDefineDate(defineDate);
        purchaseApplyDto.setName(name);
        purchaseApplyDto.setMonthsInStock(monthsInStock);
        purchaseApplyDto.setTjStock(tjStock);
        purchaseApplyDto.setSupplierName(supplierName);
        purchaseApplyDto.setStairPrice(stairPrice);
        purchaseApplyDto.setHandleStatus(handleStatus);
        purchaseApplyDto.setHandleIdea(handleIdea);
        purchaseApplyDto.setSpecification(specification);
        purchaseApplyDto.setComment(comment);
        purchaseApplyDto.setPurchaseNumber(purchaseNumber);
        List<PurchaseApplyDetailsDto> purchaseApplyList = purchaseApplyService.selectpurchaseApplyList(purchaseApplyDto);
        String fileName = DateUtil.getStringTodayMillisecond()  + ".xls";//设置要导出的文件的名字
        response.setContentType("application/application/vnd.ms-excel");
        response.setHeader("Content-disposition",
                "attachment;filename=" + URLEncoder.encode(DateUtil.getStringTodayMillisecond() + ".xls", "UTF-8"));
        ServletOutputStream out = response.getOutputStream();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("部品CD");
        row.createCell(1).setCellValue("品名");
        row.createCell(2).setCellValue("数量");
        row.createCell(3).setCellValue("单位");
        row.createCell(4).setCellValue("采购周期要求");
        row.createCell(5).setCellValue("用途说明");
        row.createCell(6).setCellValue("创建时间");
        row.createCell(7).setCellValue("创建人");
        row.createCell(8).setCellValue("在库月数");
        row.createCell(9).setCellValue("在库数量（天津侧）");
        row.createCell(10).setCellValue("供应商");
        row.createCell(11).setCellValue("阶梯价格信息");
        row.createCell(12).setCellValue("处理状态");
        row.createCell(13).setCellValue("处理意见");
        row.createCell(14).setCellValue("规格数据");
        row.createCell(15).setCellValue("备注");
        row.createCell(16).setCellValue("采购申请单编号");
        ByteArrayOutputStream arrayInputStream = new ByteArrayOutputStream();
        int index = 1;
        try {
            for(PurchaseApplyDetailsDto purchaseApplyDetailsDto: purchaseApplyList){
                row = sheet.createRow(index);
                row.createCell(0).setCellValue(purchaseApplyDetailsDto.getPartsCd());
                row.createCell(1).setCellValue(purchaseApplyDetailsDto.getGoodsName());
                row.createCell(2).setCellValue(String.valueOf(purchaseApplyDetailsDto.getQuantity()));
                row.createCell(3).setCellValue(purchaseApplyDetailsDto.getUnit());
                row.createCell(4).setCellValue(purchaseApplyDetailsDto.getPurchaseCycle());
                row.createCell(5).setCellValue(purchaseApplyDetailsDto.getPurpose());
                row.createCell(6).setCellValue(purchaseApplyDetailsDto.getDefineDate());
                row.createCell(7).setCellValue(purchaseApplyDetailsDto.getName());
                row.createCell(8).setCellValue(purchaseApplyDetailsDto.getMonthsInStock());
                if(purchaseApplyDetailsDto.getTjStock() != null){
                    row.createCell(9).setCellValue(String.valueOf(purchaseApplyDetailsDto.getTjStock()));
                }
                /*row.createCell(10).setCellValue(purchaseApplyDetailsDto.getPartsCd());
                row.createCell(11).setCellValue(purchaseApplyDetailsDto.getPartsCd());
                row.createCell(12).setCellValue(purchaseApplyDetailsDto.getPartsCd());
                row.createCell(13).setCellValue(purchaseApplyDetailsDto.getPartsCd());*/
                row.createCell(10).setCellValue(purchaseApplyDetailsDto.getSupplierName());
                row.createCell(11).setCellValue(purchaseApplyDetailsDto.getStairPrice());
//                row.createCell(16).setCellValue(purchaseApplyDetailsDto.getHandleStatus());
                //处理状态 1.未生成 2.已生成
                if(purchaseApplyDetailsDto.getHandleStatus()==1){
                    row.createCell(12).setCellValue("未生成");
                }else if(purchaseApplyDetailsDto.getHandleStatus()==2){
                    row.createCell(12).setCellValue("已生成");
                }
                row.createCell(13).setCellValue(purchaseApplyDetailsDto.getHandleIdea());
                row.createCell(14).setCellValue(purchaseApplyDetailsDto.getSpecification());
                row.createCell(15).setCellValue(purchaseApplyDetailsDto.getComment());
                row.createCell(16).setCellValue(purchaseApplyDetailsDto.getPurchaseNumber());
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

    @ApiOperation(value = "查询能否生成采购订单", nickname = "/selectCreatePurchaseOrder", notes = "根据采购申请单详情id查询供应商", tags = {"@张婷"})
    @ApiImplicitParam(name = "purchaseApply", value = "采购申请单详情id[]", required = true, dataType = "PurchaseApply")
    @RequestMapping(value = "/selectCreatePurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse selectCreatePurchaseOrder(@RequestBody PurchaseApply purchaseApply) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            //查询处理状态,如果是已生成,采购订单已生成,请不要重复生成
            int handleStatus = purchaseApplyService.selectHandleStatus(purchaseApply);
            if(handleStatus == 2){
                response.setCode(ZtCode.UNABLE_CREATEPO.getCode());
                response.setMsg(ZtCode.UNABLE_CREATEPO.getInfo());
                return response;
            }
            //查询判断是否是同一供应商
           PurchaseApply purchaseApply1 = purchaseApplyService.selectCreatePurchaseOrder(purchaseApply);
            //登录验证
            if (purchaseApply1 == null){
                response.setCode(ZtCode.UNABLE_CREATEPO.getCode());
                response.setMsg(ZtCode.UNABLE_CREATEPO.getInfo());
                return response;
            }
            response.setCode(ZtCode.CAN_CREATEPO.getCode());
            response.setMsg(ZtCode.CAN_CREATEPO.getInfo());
            response.setData(purchaseApply1);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.UNABLE_CREATEPO.getCode());
            response.setMsg(ZtCode.UNABLE_CREATEPO.getInfo());
        }
        return response;
    }
    /*
       {
          "purchaseApplyDetailsList":[{"purchaseApplyDetailsId":1},{"purchaseApplyDetailsId":5}]
        }
    */

    @ApiOperation(value = "生成采购订单", nickname = "/createPurchaseOrder", notes = "由采购申请单生成采购订单", tags = {"@张婷"})
    @ApiImplicitParam(name = "purchaseOrder", value = "采购订单实体类", required = true, dataType = "PurchaseOrder")
    @RequestMapping(value = "/createPurchaseOrder", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"createPurchaseOrder"})
    public LayuiCommonResponse createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            int insertPurchaseOrder = purchaseApplyService.createPurchaseOrder(purchaseOrder);
            //登录验证
            if(insertPurchaseOrder < 1){
                response.setCode(ZtCode.FAIL_CREATEPO.getCode());
                response.setMsg(ZtCode.FAIL_CREATEPO.getInfo());
                return response;
            }
            response.setCode(ZtCode.SUCCESS_CREATEPO.getCode());
            response.setMsg(ZtCode.SUCCESS_CREATEPO.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(ZtCode.FAIL_CREATEPO.getCode());
            response.setMsg(ZtCode.FAIL_CREATEPO.getInfo());
        }
        return response;
    }

    /*  生成采购订单
        {
          "capital": "capital",
          "comment": "comment",
          "defineDate": "2018-02-02",
          "deliveryDate": "2018-04-04",
          "orderStatus": 1,
          "paymentStatus": 1,
          "purchaseAmount": 100,
          "purchaseOrderDetailsList": [
          {
            "purchaseApplyDetailsId": 6,
            "purchasePrice":100.11,
            "goodsId":1,
            "quantity":111,
            "excludingTaxAmount":1,
            "taxRate":1,
            "tax":1,
            "taxIncludedAmount":1,
            "financeMoney":1
          }
        ],
          "purchaseOrderNumber": "111111111001",
          "purchaseType": "天津",
          "staffId": 6,
          "supplierId": 1
        }
    */


    /* 添加数据
    {
      "comment": "comment",
      "defineDate": "2018-02-02",
      "purchaseApplyDetailsList": [
     {
        "goodsId": 1,
        "purchaseCycle": "purchaseCycle1",
        "purpose": "purpose1",
        "quantity": 100.11,
        "stairPrice": "stairPric1e"
      },{
        "goodsId": 2,
        "purchaseCycle": "purchaseCycle2",
        "purpose": "purpose2",
        "quantity": 100.22,
        "stairPrice": "stairPrice2"
      }
    ],
      "purchaseNumber": "1212121123",
      "staffId": 1
    }
     */
    /* 编辑数据
        1.根据采购申请单详情id只修改采购申请单内容,详情list为空
        {
          "comment": "更新主表操作",
          "defineDate": "2018-03-03",
          "purchaseApplyDetailsId": 13,
          "staffId": 2
        }
        2.更新操作
        {
          "comment": "更新操作",
          "defineDate": "2019-02-04",
          "purchaseApplyDetails": {
            "goodsId": 2,
            "purchaseCycle": "采购周期",
            "purpose": "更新用途说明",
            "quantity": 111,
            "stairPrice": "阶梯价格"
          },
          "purchaseApplyDetailsId": 13,
          "staffId": 1
        }
     */
}
