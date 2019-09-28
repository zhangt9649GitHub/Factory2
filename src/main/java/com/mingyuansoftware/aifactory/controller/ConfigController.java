package com.mingyuansoftware.aifactory.controller;

import com.mingyuansoftware.aifactory.enums.HtCode;
import com.mingyuansoftware.aifactory.model.Config;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.ConfigService;
import com.mingyuansoftware.aifactory.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "Config", description = "系统参数API", tags = {"系统参数"})
@RestController
@RequestMapping("/config")
public class ConfigController {
    Logger logger = LoggerFactory
            .getLogger(ConfigController.class);

    @Autowired
    private ConfigService configService;

    @ApiOperation(value = "获取系统配置参数列表", notes = "获取系统配置参数列表", nickname = "getConfig", tags = {"@郝腾"})
    @RequestMapping(value = "/getConfigList", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = {"getConfigList"})
    public LayuiCommonResponse getConfig() {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try {
            List<Config> configList = configService.selectAll();
            response.setData(configList);
            response.setCode(HtCode.SUCCESS_GET.getCode());
            response.setMsg(HtCode.SUCCESS_GET.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(HtCode.FAIL_GET.getCode());
            response.setMsg(HtCode.FAIL_GET.getInfo());
        }
        return response;
    }

    @ApiOperation(value = "系统参数修改", notes = "系统参数修改", nickname = "updateConfig", tags = {"@郝腾"})
    @RequestMapping(value = "/updateConfig", method = RequestMethod.POST)
    @ResponseBody
    public LayuiCommonResponse updateConfig(@RequestBody HashMap<String, String> map) {
        LayuiCommonResponse response = new LayuiCommonResponse();
        try{
            if (map.size() > 0) {
                logger.info("正在修改系统参数" + DateUtil.getDateTime());
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    logger.info(entry.getKey() + " : " + entry.getValue());
                    configService.findAndUpdateByKey(entry.getKey(), entry.getValue());
                }
                configService.loadConfig();
                logger.info("修改系统参数成功" + DateUtil.getDateTime());
                response.setMsg(HtCode.SUCCESS_UPDATE.getInfo());
                response.setCode(HtCode.SUCCESS_UPDATE.getCode());
            }
        }catch (Exception e){
            e.printStackTrace();
            response.setMsg(HtCode.FAIL_UPDATE.getInfo());
            response.setCode(HtCode.FAIL_UPDATE.getCode());
        }
        return response;
    }
}
