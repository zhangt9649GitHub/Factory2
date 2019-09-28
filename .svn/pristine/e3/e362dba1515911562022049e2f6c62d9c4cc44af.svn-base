package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.Config;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ConfigService {

    /**
     * 获取配置集合
     * @return
     */
    List<Config> selectAll();

    void findAndUpdateByKey(String key,String value);

    void loadConfig();
}
