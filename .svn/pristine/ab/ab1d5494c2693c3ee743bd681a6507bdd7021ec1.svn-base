package com.mingyuansoftware.aifactory.controller;

import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.dto.ProductionInstructionGoodsDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
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

@Api(value = "ProductionInstructionGoods", description = "生产指示书明细API", tags = {"生产指示书明细"})
@RestController
@RequestMapping("/productionInstructionGoods")
public class ProductionInstructionGoodsController {

    @Autowired
    private ProductionInstructionGoodsService productionInstructionGoodsService;

    @ApiOperation(value = "获取生产指示书明细列表", notes = "获取生产指示书明细列表", tags = {"@郝腾"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "productionInstructionGoodsDto", value = "生产指示书明细参数实体类", paramType = "query", dataType = "ProductionInstructionGoodsDto"),
    })
    @RequestMapping(value = "/getProductionInstructionList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getProductionInstructionList"})
    public LayuiCommonResponse getProductionInstructionList(@Validated @RequestParam(defaultValue = "1") int page,
                                                            @Validated @RequestParam(defaultValue = "10") int limit,
                                                            @Validated ProductionInstructionGoodsDto productionInstructionGoodsDto) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            PageHelper.startPage(page, limit);
            List<ProductionInstructionGoodsDto> ProductionInstructionGoodsDtos =productionInstructionGoodsService.selectProductionInstructionGoodsList(productionInstructionGoodsDto);
            int count = productionInstructionGoodsService.selectCountProductionInstructionGoods(productionInstructionGoodsDto);
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setCount(count);
            response.setData(ProductionInstructionGoodsDtos);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }
}
