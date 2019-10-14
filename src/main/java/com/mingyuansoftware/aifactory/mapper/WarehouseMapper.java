package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.Warehouse;
import com.mingyuansoftware.aifactory.model.dto.WarehouseDto;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
@Repository
public interface WarehouseMapper {

    //仓库列表
    List<Warehouse> selectWarehouseAll(@Param("warehouseDto")WarehouseDto warehouseDto);

    //仓库列表数量
    Integer count(@Param("warehouseDto")WarehouseDto warehouseDto);

    //添加仓库信息
    Integer addWarehouse(Warehouse warehouse);

    //查询编辑仓库信息根据仓库id
    Warehouse selectEditWarehouse(@Param("warehouseId") Integer warehouseId);

    //编辑仓库
    Integer editWarehouse(Warehouse warehouse);

    //删除仓库
    Integer deletetWarehouse(@Param("warehouseId") Integer warehouseId);


    //查询所有仓库列表
    List<Warehouse> warehouseList();

    /**
     * 获取仓库列表
     * @return
     */
    List<Warehouse> selectWarehouseNameList(@Param("warehouseType") int warehouseType);

    /**
     * 根据仓库名字查出仓库id
     * @param warehouseName
     * @return
     */
    int selectWIdByWarehouseName(String warehouseName);

    /**
     * 修改仓库状态为 2.使用中
     * @param warehouseId
     * @param state
     */
    void updateWarehouseStateById(@Param("warehouseId") Integer warehouseId,@Param("state") int state);
}