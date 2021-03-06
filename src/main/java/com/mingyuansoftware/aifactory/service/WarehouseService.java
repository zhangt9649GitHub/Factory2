package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.Warehouse;
import com.mingyuansoftware.aifactory.model.dto.WarehouseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WarehouseService {
    /**
     * 仓库列表
     *
     * @param warehouseDto
     * @return
     */
    List<Warehouse> selectWarehouseAll(WarehouseDto warehouseDto);

    /**
     * 仓库列表数量
     *
     * @param warehouseDto
     * @return
     */

    Integer count(WarehouseDto warehouseDto);
    /**
     * 添加仓库
     *
     * @param warehouse
     * @return
     */

    Integer addWarehouse(Warehouse warehouse);

    /**
     * 查询编辑仓库信息根据仓库id
     *
     * @param warehouseId
     * @return
     */
    Warehouse selectEditWarehouse(Integer warehouseId);

    /**
     * 编辑仓库信息
     *
     * @param warehouse
     * @return
     */
    Integer editWarehouse(Warehouse warehouse);

    /**
     * 删除仓库信息
     *
     * @param warehouseId
     * @return
     */
    Integer deletetWarehouse(Integer warehouseId);

    /**
     * 查询所有仓库
     *
     * @param
     * @return
     */
    List<Warehouse> warehouseList();

    /**
     * 获取仓库列表
     * @return
     */
    List<Warehouse> selectWarehouseNameList(int warehouseType);

    /**
     * 检查仓库名字是否可用
     * @param warehouseId
     * @param warehouseName
     * @return
     */
    boolean warehouseNameCheck(int warehouseId, String warehouseName);
}
