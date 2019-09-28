package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.ProductionDaily;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionEntryDetailsService {

    /**
     * 获取生产日报列表
     * @param productionDaily
     * @return
     */
    List<ProductionDaily> selectProductionDailyList(ProductionDaily productionDaily);

    /**
     * 获取生产日报列表总条目
     * @param productionDaily
     * @return
     */
    int selectCountProductionDaily(ProductionDaily productionDaily);
}
