package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.ProductionEntryGoods;
import com.mingyuansoftware.aifactory.model.ProductionOrderDetails;
import com.mingyuansoftware.aifactory.model.ProductionPlanningAnalysis;
import com.mingyuansoftware.aifactory.model.dto.PDAProductionEntryDto;
import com.mingyuansoftware.aifactory.model.dto.ProductionOrderDetailsDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public interface ProductionOrderDetailsService {

    /**
     * 获取排产单明细列表
     * @param productionOrderDetailsDto
     * @return
     */
    List<ProductionOrderDetailsDto> selectProductionOrderDetailsList(ProductionOrderDetailsDto productionOrderDetailsDto);

    /**
     * 获取排产单明细列表总条目
     * @param productionOrderDetailsDto
     * @return
     */
    int selectCountProductionOrderDetails(ProductionOrderDetailsDto productionOrderDetailsDto);

    /**
     * 将排产单明细设为已读
     * @param productionOrderDetailsId
     */
    void updateProductionOrderDetailsIsRead(int productionOrderDetailsId);

    /**
     * 获取生产计划分析列表
     * @param productionPlanningAnalysis
     * @return
     */
    List<ProductionPlanningAnalysis> selectProductionPlanningAnalysisList(ProductionPlanningAnalysis productionPlanningAnalysis);

}
