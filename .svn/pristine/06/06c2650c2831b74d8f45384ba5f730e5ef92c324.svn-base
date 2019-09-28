package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.GoodsVariety;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface GoodsVarietyMapper {



    int deleteByPrimaryKey(Integer varietyValue);


    int insert(GoodsVariety record);


    GoodsVariety selectByPrimaryKey(Integer varietyValue);


    List<GoodsVariety> selectAll();


    int updateByPrimaryKey(GoodsVariety record);

    /**
     * 获取品种列表
     * @param goodsVariety
     * @return
     */
    List<GoodsVariety> selectAllGoodsVarietyList(@Param("goodsVariety") GoodsVariety goodsVariety);

    /**
     * 获取品种列表总条目
     * @param goodsVariety
     * @return
     */
    int selectCountGoodsVarietyList(@Param("goodsVariety") GoodsVariety goodsVariety);
}