package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.ProductionInstruction;
import com.mingyuansoftware.aifactory.model.dto.ProductionInstructionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionInstructionService {

    /**
     * 获取生产指示书列表
     * @param productionInstructionDto
     * @return
     */
    List<ProductionInstruction> selectProductionInstructionList(ProductionInstructionDto productionInstructionDto);

    /**
     * 获取生产指示书列表总条目
     * @param productionInstructionDto
     * @return
     */
    int selectCountProductionInstruction(ProductionInstructionDto productionInstructionDto);

    /**
     * 根据id查询生产指示书详情
     * @param productionInstructionId
     * @return
     */
    ProductionInstruction selectProductionInstructionById(int productionInstructionId);

    /**
     * 更新生产指示书信息
     * @param productionInstruction
     */
    void updateGoodsInfo(ProductionInstruction productionInstruction);

    /**
     * 删除生产指示书
     * @param productionInstructionId
     */
    void deleteProductionInstructionById(int productionInstructionId);

    /**
     * 获取生产指示书列表
     * @return
     */
    List<ProductionInstruction> selectSerialNumberList();
}
