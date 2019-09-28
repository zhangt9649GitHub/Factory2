package com.mingyuansoftware.aifactory.service;

import org.springframework.stereotype.Service;

@Service
public interface LogService {

    /**
     * 添加日志
     * @param staffId
     * @param type  1.新增 2修改 3删除 4导入 5导出
     * @param text
     */
    void saveLog(int staffId,int type,String text);
}
