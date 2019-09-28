package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.ProductionDaily;
import com.mingyuansoftware.aifactory.model.ProductionEntryDetails;
import com.mingyuansoftware.aifactory.model.ProductionGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface ProductionEntryDetailsMapper {


    int deleteByPrimaryKey(Integer productionEntryDetailsId);


    int insert(ProductionEntryDetails record);


    ProductionEntryDetails selectByPrimaryKey(Integer productionEntryDetailsId);


    List<ProductionEntryDetails> selectAll();


    int updateByPrimaryKey(ProductionEntryDetails record);

    /**
     * 根据生产入库单id删除生产入库单详情
     * @param productionEntryId
     */
    void deleteProductionEntryDetailById(@Param("productionEntryId") int productionEntryId);

    List<ProductionGoods> selectProductionEntryDetailsById(@Param("productionEntryId") int productionEntryId);

    /**
     * 获取生产日报列表
     * @param productionDaily
     * @return
     */
    List<ProductionDaily> selectProductionDailyList(@Param("productionDaily") ProductionDaily productionDaily);

    /**
     * 获取生产日报列表总条目
     * @param productionDaily
     * @return
     */
    int selectCountProductionDaily(@Param("productionDaily") ProductionDaily productionDaily);
}