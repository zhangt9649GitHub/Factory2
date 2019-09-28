package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.Picking;
import com.mingyuansoftware.aifactory.model.ProductionCosting;
import com.mingyuansoftware.aifactory.model.ProductionInstructionGoods;
import com.mingyuansoftware.aifactory.model.dto.PickingDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.PickingService;
import com.mingyuansoftware.aifactory.service.ProductionInstructionGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "ProductionCosting", description = "生产成本计算API", tags = {"生产成本计算"})
@RestController
@RequestMapping("/productionCosting")
public class ProductionCostingController {

    @Autowired
    private ProductionInstructionGoodsService productionInstructionGoodsService;

    @ApiOperation(value = "获取生产成本计算列表", notes = "获取生产成本计算列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "productionCosting", value = "生产成本计算参数实体类", paramType = "query", dataType = "ProductionCosting")
    })
    @RequestMapping(value = "/getProductionCostingList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getProductionCostingList"})
    public LayuiCommonResponse getProductionCostingList(@Validated @RequestParam(defaultValue = "1") int page,
                                              @Validated @RequestParam(defaultValue = "10") int limit,
                                              @Validated ProductionCosting productionCosting) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<ProductionCosting> productionCostingList =productionInstructionGoodsService.selectProductionCostingList(productionCosting);
            for (ProductionCosting productionCosting1:productionCostingList
                 ) {
                if(productionCosting1.getDocumentTime()!=null){
                    productionCosting1.setDocumentTime(productionCosting1.getDocumentTime().substring(0,productionCosting1.getDocumentTime().indexOf(" ")));
                }
            }
            Page<ProductionCosting> page1 = (Page<ProductionCosting>)productionCostingList;
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount((int) page1.getTotal());
            response.setData(productionCostingList);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }
}
