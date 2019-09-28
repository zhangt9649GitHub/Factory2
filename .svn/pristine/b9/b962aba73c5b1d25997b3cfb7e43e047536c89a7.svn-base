package com.mingyuansoftware.aifactory.controller;

import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.model.Bizdictionary;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.BizDictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈1〉
 *
 * @author EDZ
 * @create 2019/6/27
 * @since 1.0.0
 */
@RestController
@RequestMapping("/bizd")
@Api(value = "BizDictionary", description = "数据字典API", tags = {"数据字典"})
public class BizDictionaryController {

    @Autowired
    private BizDictionaryService bizDictionaryService;

    @ApiOperation(value = "新增数据", notes = "新增数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "数据字典实体类", required = true, dataType = "Bizdictionary")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @RequiresPermissions(value ={"insertBizd"} )
    public LayuiCommonResponse insert(@RequestBody Bizdictionary record){

        try {
            return bizDictionaryService.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_INSERT,0,"");
        }
    }
    @ApiOperation(value = "删除数据", notes = "删除数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "数据字典id", required = true, dataType = "int")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @RequiresPermissions(value = {"deleteBizd"})
    public LayuiCommonResponse delete(int id){

        try {
            return bizDictionaryService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_DELETE,0,"");
        }
    }
    @ApiOperation(value = "获取数据", notes = "获取数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "id", value = "数据字典id", required = true, dataType = "int")
    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public LayuiCommonResponse getById(int id){

        return bizDictionaryService.getByid(id);
    }
    @ApiOperation(value = "更新数据", notes = "更新数据", tags = {"@王力影"})
    @ApiImplicitParam(name = "record", value = "数据字典实体类",required = true, dataType = "Bizdictionary")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @RequiresPermissions(value = {"updateBizd"})
    public LayuiCommonResponse update(@RequestBody Bizdictionary record){

        try {
            return bizDictionaryService.update(record);
        } catch (Exception e) {
            e.printStackTrace();
            return new LayuiCommonResponse(WlCode.FAIL_UPDATE,0,"");
        }
    }
    @ApiOperation(value = "获取所有数据", notes = "获取所有数据", tags = {"@王力影"})
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    @RequiresPermissions(value = {"getAllBizd"})
    public LayuiCommonResponse getAll(){

        return bizDictionaryService.getAll();
    }

}
