package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.ProductionEntry;
import com.mingyuansoftware.aifactory.model.dto.ProductionEntryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductionEntryMapper {


    int deleteByPrimaryKey(Integer productionEntryId);



    int insert(ProductionEntry record);



    ProductionEntry selectByPrimaryKey(Integer productionEntryId);



    List<ProductionEntry> selectAll();



    int updateByPrimaryKey(ProductionEntry record);

    /**
     * 获取生产入库单列表
     * @param productionEntryDto
     * @return
     */
    List<ProductionEntry> selectProductionEntryList(@Param("productionEntryDto") ProductionEntryDto productionEntryDto);

    /**
     * 获取生产入库单列表总条目
     * @param productionEntryDto
     * @return
     */
    int selectCountProductionEntry(@Param("productionEntryDto") ProductionEntryDto productionEntryDto);

    /**
     * 根据生产入库单id查询详情
     * @param productionEntryId
     * @return
     */
    ProductionEntry selectProductionEntryById(@Param("productionEntryId") Integer productionEntryId);
}