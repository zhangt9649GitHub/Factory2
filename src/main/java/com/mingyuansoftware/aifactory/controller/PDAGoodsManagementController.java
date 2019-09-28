package com.mingyuansoftware.aifactory.controller;


import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.Goods;
import com.mingyuansoftware.aifactory.model.dto.GoodsPrintDto;
import com.mingyuansoftware.aifactory.model.dto.PDAGoodsDto;
import com.mingyuansoftware.aifactory.pojo.CommonResponse;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@Api(value = "PDAGoodsManagement", description = "PDA货物管理API", tags = {"PDA货物管理"})
@RestController
@RequestMapping("/pdaGoods")
public class PDAGoodsManagementController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "提交货物信息", notes = "提交货物信息", tags = {"@郝腾"})
    @ApiImplicitParam(name = "pdaGoodsDto", value = "货物及详情", dataType = "PDAGoodsDto")
    @RequestMapping(value = "/updateGoods", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse updateGoods(@RequestBody PDAGoodsDto pdaGoodsDto) {
        CommonResponse response = new CommonResponse();
        try {
            goodsService.updateGoods(pdaGoodsDto);
            response.setCode(HtCode.SUCCESS_SUBMIT.getCode());
            response.setMessage(HtCode.SUCCESS_SUBMIT.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_SUBMIT.getCode());
            response.setMessage(HtCode.FAIL_SUBMIT.getInfo());
            return response;
        }
        return response;
    }

    @ApiOperation(value = "货物修改打印状态", notes = "货物修改打印状态", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "货物id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "isPrint", value = "是否打印", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "printNumber", value = "打印几张", required = true, paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/updateGoodsPrint", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse updateGoodsPrint(HttpServletRequest req ,@Validated Integer goodsId, @Validated Integer isPrint, @Validated Integer printNumber) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            if(goodsId ==null){
                StringBuffer sb = new StringBuffer();
                try(BufferedReader reader = req.getReader()) {
                    char[]buff = new char[1024];
                    int len;
                    while((len = reader.read(buff)) != -1) {
                        sb.append(buff,0, len);
                    }
                }catch (IOException e) {
                  e.printStackTrace();
                }
                String str = new String(sb);
                JSONObject jsonobject = JSONObject.fromObject(str);
                GoodsPrintDto goodsPrintDto = (GoodsPrintDto)JSONObject.toBean(jsonobject,
                        GoodsPrintDto.class);
                goodsId = goodsPrintDto.getGoodsId();
                isPrint = goodsPrintDto.getIsPrint();
                printNumber = goodsPrintDto.getPrintNumber();
            }
            if(printNumber!=null){
                goodsService.updateGoodsPrintByGoodsId(goodsId, isPrint,printNumber);
            }
            response.setCode(HtCode.SUCCESS_PRINT.getCode());
            response.setMsg(HtCode.SUCCESS_PRINT.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_PRINT.getCode());
            response.setMsg(HtCode.FAIL_PRINT.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "获取打印货物信息", notes = "获取打印货物信息", tags = {"@郝腾"})
    @RequestMapping(value = "/getGoodsPrint", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getGoodsPrint() {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            Goods goods = goodsService.selectGoodsPrint();
            response.setMsg("success");
            response.setCode(0);
            response.setData(goods);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(-1);
            response.setMsg("error");
        }
        return response;
    }
}
