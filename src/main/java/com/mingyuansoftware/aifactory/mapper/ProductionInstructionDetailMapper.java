package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.ProductionInstructionDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface ProductionInstructionDetailMapper {


    int deleteByPrimaryKey(Integer productionInstructionDetailId);


    int insert(ProductionInstructionDetail record);


    ProductionInstructionDetail selectByPrimaryKey(Integer productionInstructionDetailId);


    List<ProductionInstructionDetail> selectAll();


    int updateByPrimaryKey(ProductionInstructionDetail record);

    /**
     * 根据生产指示书
     * @param productionInstructionGoodsId
     * @return
     */
    List<ProductionInstructionDetail> selectProductionInstructionDetailsById(@Param("productionInstructionGoodsId") int productionInstructionGoodsId);

    /**
     * 根据生产指示书货物Id和货物Id查询详情内容
     * @param productionInstructionGoodsId
     * @param goodsId
     * @return
     */
    List<ProductionInstructionDetail> selectProductionInstructionDetailsByIdAndGoodsId(@Param("productionInstructionGoodsId") Integer productionInstructionGoodsId, @Param("goodsId") Integer goodsId);
}