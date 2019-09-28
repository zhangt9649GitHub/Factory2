package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.WarehousePosition;
import com.mingyuansoftware.aifactory.model.dto.WarehousePositionDto;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
@Repository
public interface WarehousePositionMapper {
    //仓位列表
    List<WarehousePositionDto> selectWarehousePositionAll(WarehousePositionDto warehousePositionDto);

    //仓位列表数量
    Integer count(WarehousePositionDto warehousePositionDto);

    //添加仓位信息
    Integer addWarehousePosition(WarehousePosition warehousePosition);

    //查询编辑仓位信息根据仓位id
    WarehousePosition selectEditWP(@Param("warehousePositionId") Integer warehousePositionId);

    //编辑仓位
    Integer editWP(WarehousePosition warehousePosition);

    //删除仓位,修改仓位状态
    Integer deleteWPById(@Param("warehousePositionId") Integer warehousePositionId);

    /**
     * 获取使用中的仓位列表
     * @return
     */
    List<WarehousePosition> selectWpNameList();

    /**
     * 修改仓位的状态为使用中
     * @param warehousePositionId
     */
    void updateWarehousePrositonState(@Param("warehousePositionId") Integer warehousePositionId);

    /**
     * 获取仓位列表
     * @param wpName
     * @return
     */
    List<WarehousePosition>  selectWpList(@Param("wpName") String wpName);
}