package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.BomForm;
import com.mingyuansoftware.aifactory.model.dto.BomFormDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BomFormMapper {
    int deleteByPrimaryKey(Integer bomId);

    int insert(BomForm record);

    BomForm selectByPrimaryKey(Integer bomId);

    List<BomForm> selectAll();

    int updateByPrimaryKey(BomForm record);

    /**
     * 查询BOM表单列表
     * @param bomFormDto
     * @return
     */
    List<BomForm> selectBomFormList(@Param("bomFormDto") BomFormDto bomFormDto);

    /**
     * 获取BOm表单总条数
     * @param bomFormDto
     * @return
     */
    int selectCount(@Param("bomFormDto") BomFormDto bomFormDto);

    /**
     * 根据id查询bom表单数据
     * @param bomId
     * @return
     */
    BomForm selectBomFormById(@Param("bomId") int bomId);

    /**
     * 获取插入的最新的id
     * @return
     */
    Integer selectLastId();

   /* *//**
     * 逻辑删除bom表单
     * @param bomId
     * @return
     *//*
    int updateBomFormById(@Param("bomId") int bomId);*/

    /**
     * 根据货物id查询bom表单
     * @param goodsId
     * @return
     */
    BomForm selectBomFormByGoodsId(@Param("goodsId") int goodsId);
}