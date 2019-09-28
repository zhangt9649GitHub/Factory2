package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.ProductionInstructionDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionInstructionDetailService {

    /**
     * 根据生产指示书货物id查询生产指示书详情集合
     * @param productionInstructionGoodsId
     * @return
     */
    List<ProductionInstructionDetail> selectProductionInstructionDetailsById(int productionInstructionGoodsId);
}
