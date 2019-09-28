package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.FinanceMoneyRecordMapper;
import com.mingyuansoftware.aifactory.model.FinanceMoneyRecord;
import com.mingyuansoftware.aifactory.service.FinanceMoneyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @author 张婷
 * @date 2019/7/23 14:19
 */

@Service
public class FinanceMoneyRecordServiceImpl implements FinanceMoneyRecordService {

    @Autowired
    private FinanceMoneyRecordMapper financeMoneyRecordMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer insertFinanceMoneyRecordPayment(Map<String, Object> parameters) {
        FinanceMoneyRecord financeMoneyRecord = new FinanceMoneyRecord();
        financeMoneyRecord.setFmMoney((BigDecimal) parameters.get("fmMoney"));
        financeMoneyRecord.setFmType((String) parameters.get("fmType"));
        financeMoneyRecord.setFmDatetime(new Date());
        financeMoneyRecord.setSid((Integer) parameters.get("sid"));
        financeMoneyRecord.setFmSerialNumber((String) parameters.get("fmSerialNumber"));
        financeMoneyRecord.setFmJieSuanType((String) parameters.get("fmJieSuanType"));
        financeMoneyRecord.setFmJiaoyiDuixiang((String) parameters.get("fmJiaoyiDuixiang"));
        return financeMoneyRecordMapper.insert(financeMoneyRecord);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer insertFinanceMoneyRecordReceipt(Map<String, Object> parameters) {
        FinanceMoneyRecord financeMoneyRecord = new FinanceMoneyRecord();
        financeMoneyRecord.setFmMoney((BigDecimal) parameters.get("fmMoney"));
        financeMoneyRecord.setFmType((String) parameters.get("fmType"));
        financeMoneyRecord.setFmDatetime(new Date());
        financeMoneyRecord.setCid((Integer) parameters.get("cid"));
        financeMoneyRecord.setFmSerialNumber((String) parameters.get("fmSerialNumber"));
        financeMoneyRecord.setFmJieSuanType((String) parameters.get("fmJieSuanType"));
        financeMoneyRecord.setFmJiaoyiDuixiang((String) parameters.get("fmJiaoyiDuixiang"));
        return financeMoneyRecordMapper.insert(financeMoneyRecord);
    }
}
