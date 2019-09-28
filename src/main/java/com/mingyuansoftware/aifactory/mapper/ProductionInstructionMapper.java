package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.ProductionInstruction;
import com.mingyuansoftware.aifactory.model.ProductionProcess;
import com.mingyuansoftware.aifactory.model.dto.ProductionInstructionDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductionInstructionMapper {

    int deleteByPrimaryKey(Integer productionInstructionId);


    int insert(ProductionInstruction record);


    ProductionInstruction selectByPrimaryKey(Integer productionInstructionId);


    List<ProductionInstruction> selectAll();


    int updateByPrimaryKey(ProductionInstruction record);

    /**
     * 获取生产指示书列表
     * @param productionInstructionDto
     * @return
     */
    List<ProductionInstruction> selectProductionInstructionList(@Param("productionInstructionDto") ProductionInstructionDto productionInstructionDto);

    /**
     * 获取生产指示书列表总条目
     * @param productionInstructionDto
     * @return
     */
    int selectCountProductionInstruction(@Param("productionInstructionDto") ProductionInstructionDto productionInstructionDto);

    /**
     * 更改生产指示书的删除状态为删除
     * @param productionInstructionId
     */
    void updateProductionInstructionById(@Param("productionInstructionId") Integer productionInstructionId);

    int selectSerialNumber(@Param("serialNumber") String serialNumber);

    void updateSerialNumberByProductionInstructionId(@Param("serialNumber") String serialNumber, @Param("productionInstructionId") int productionInstructionId);

    /**
     * 获取生产指示书编号列表
     * @return
     */
    List<ProductionInstruction>  selectSerialNumberList();

    /**
     * 获取未完成的生产指示书回数
     * @return
     */
    List<ProductionProcess> selectUnfinishList();
}