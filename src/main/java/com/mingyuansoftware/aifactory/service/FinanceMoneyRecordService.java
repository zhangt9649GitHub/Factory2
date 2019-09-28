package com.mingyuansoftware.aifactory.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface FinanceMoneyRecordService {

    /**
     * 添加付款金额流水
     * @param parameters
     */
    Integer insertFinanceMoneyRecordPayment(Map<String,Object> parameters);

    /**
     * 添加收款金额流水
     * @param parameters
     */
    Integer insertFinanceMoneyRecordReceipt(Map<String,Object> parameters);
}
