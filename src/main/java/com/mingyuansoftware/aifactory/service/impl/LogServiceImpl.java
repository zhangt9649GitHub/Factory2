package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.LogMapper;
import com.mingyuansoftware.aifactory.model.Log;
import com.mingyuansoftware.aifactory.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveLog(int staffId, int type, String text) {
            Log log = new Log();
            log.setStaffId(staffId);
            log.setType((byte)type);
            log.setText(text);
            log.setCreateTime(new Date());
            logMapper.insert(log);
    }
}
