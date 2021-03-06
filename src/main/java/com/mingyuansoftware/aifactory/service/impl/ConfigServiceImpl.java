package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.config.LogConfig;
import com.mingyuansoftware.aifactory.mapper.ConfigMapper;
import com.mingyuansoftware.aifactory.model.Config;
import com.mingyuansoftware.aifactory.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public List<Config> selectAll() {
        try{
            return configMapper.selectAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void findAndUpdateByKey(String key, String value) {
       Config config = configMapper.selectByKey(key);
        if (config==null){
            Config data = new Config();
            data.setKey(key);
            data.setValue(value);
            configMapper.insert(data);
        }
        else {
            if (null == config.getValue() && null != value){
                config.setValue(value);
                configMapper.updateByPrimaryKey(config);
            }else if (!config.getValue().equals(value)){
                config.setValue(value);
                configMapper.updateByPrimaryKey(config);
            }
        }
    }

    @Override
    public void loadConfig() {
        List<Config> list = selectAll();
        for (Config config : list
        ) {
            if (config.getKey().equals("requiredQuantityGoodsInsufficient")) {
                LogConfig.requiredQuantityGoodsInsufficient = Integer.valueOf(config.getValue());
            }

            if (config.getKey().equals("logWrite")) {
                LogConfig.STATE = Boolean.valueOf(config.getValue());
            }

            if (config.getKey().equals("warehouseType")){
                LogConfig.warehouseType = Integer.valueOf(config.getValue());
            }
        }
    }
}
