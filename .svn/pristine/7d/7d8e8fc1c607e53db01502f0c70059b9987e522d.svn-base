/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: StorageAccessController
 * Author:   EDZ
 * Date:     2019/7/9 11:08
 * Description: 入库单
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.controller;

import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.model.Bizdictionary;
import com.mingyuansoftware.aifactory.model.StorageAccess;
import com.mingyuansoftware.aifactory.model.StorageGoodsDetail;
import com.mingyuansoftware.aifactory.model.dto.StorageAccessDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.BizDictionaryService;
import com.mingyuansoftware.aifactory.service.StockKucunGoodsService;
import com.mingyuansoftware.aifactory.service.StorageAccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈入库单〉
 *
 * @author EDZ
 * @create 2019/7/9
 * @since 1.0.0
 */
@Api(value = "StorageAccess", description = "入库单API", tags = {"入库单"})
@RestController
@RequestMapping("/storageAcess")
public class StorageAccessController {
    @Autowired
    private StorageAccessService storageAccessService;

    @Autowired
    private BizDictionaryService bizDictionaryService;

    @ApiOperation(value = "新增数据", notes = "新增数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "入库单实体类", required = true, dataType = "StorageAccess")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @RequiresPermissions(value = {"insertStorageAcess"})
    public LayuiCommonResponse insert(@RequestBody StorageAccess record){

        try {
            return storageAccessService.insert(record);

        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_INSERT,0,"");
        }
    }
   /* @ApiOperation(value = "删除数据", notes = "删除数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "入库单id", required = true, dataType = "int")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public LayuiCommonResponse delete(int id){

        try {
            return storageAccessService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_DELETE,0,"");
        }
    }*/

    @ApiOperation(value = "获取入库明细数据", notes = "获取入库明细数据", tags = {"@王力影"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "storageGoodsDetail", value = "入库单明细参数实体类", paramType = "query", dataType = "StorageGoodsDetail")
    })
    @RequestMapping(value = "/getDetailStorageAccessList",method = RequestMethod.POST)
    @RequiresPermissions(value = {"getDetailStorageAccessList"})
    public LayuiCommonResponse getDetailStorageAccessList(@Validated @RequestParam(defaultValue = "1") int page,
                                                          @Validated @RequestParam(defaultValue = "10") int limit,
                                                          @Validated StorageGoodsDetail storageGoodsDetail){

        return storageAccessService.selectDetailGoods(page,limit,storageGoodsDetail);
    }

    @ApiOperation(value = "获取数据", notes = "获取数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "入库单id", required = true, dataType = "int")
    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public LayuiCommonResponse getById(int id){

        return storageAccessService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "获取货物列表数据", notes = "获取货物列表数据", tags = {"@王力影"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/getByGoodsList",method = RequestMethod.POST)
    public LayuiCommonResponse getByGoodsList(@Validated @RequestParam(defaultValue = "1") int page,
                                              @Validated @RequestParam(defaultValue = "10") int limit){

        return storageAccessService.selectGoodsByPage(page,limit);
    }

    /*@ApiOperation(value = "更新数据", notes = "更新数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "入库单实体类",required = true, dataType = "StorageAccess")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public LayuiCommonResponse update(@RequestBody StorageAccess record){

        try {
            return storageAccessService.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_UPDATE,0,"");
        }
    }*/
    @ApiOperation(value = "获取入库列表",notes = "获取入库列表", tags = {"@王力影"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页容量", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "requisitionDto", value = "货物参数实体类", paramType = "query", dataType = "RequisitionDto"),
    })
    @RequestMapping(value = "/getStorageAccessList",method = RequestMethod.POST)
    @RequiresPermissions(value = {"getStorageAccessList"})
    public LayuiCommonResponse getAll(@Validated @RequestParam(defaultValue = "1") int page,
                                      @Validated @RequestParam(defaultValue = "10") int limit,
                                      @Validated StorageAccessDto storageAccessDto){

        return storageAccessService.selectAll(page,limit,storageAccessDto);
    }


    @ApiOperation(value = "获取入库类型列表", notes = "获取入库类型列表", tags = {"@王力影"})
    @RequestMapping(value = "/getStorageAccessTypeList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse getStorageAccessTypeList() {
        try {
            int parentId = 41;
            List<Bizdictionary> bizdictionaryList =bizDictionaryService.selectListByParentId(parentId);
           return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,bizdictionaryList);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }

    }

}
