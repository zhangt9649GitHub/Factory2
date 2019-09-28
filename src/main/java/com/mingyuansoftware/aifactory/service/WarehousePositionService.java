package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.WarehousePosition;
import com.mingyuansoftware.aifactory.model.dto.WarehousePositionDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张婷
 * @date 2019/6/27 15:58
 */

@Service
public interface WarehousePositionService {

    /**
     * 仓位列表
     *
     * @param
     * @return
     */
    List<WarehousePositionDto> selectWarehousePositionAll(WarehousePositionDto warehousePositionDto);

    /**
     * 仓位列表数量
     *
     * @param
     * @return
     */
    Integer count(WarehousePositionDto warehousePositionDto);

    /**
     * 添加仓位
     *
     * @param
     * @return
     */
    Integer addWarehousePosition(WarehousePosition warehousePosition);

    /**
     * 根据id查询仓位
     *
     * @param warehousePositionId
     * @return
     */
    WarehousePosition selectEditWP(Integer warehousePositionId);

    /**
     * 编辑仓位信息
     *
     * @param warehousePosition
     * @return
     */
    Integer editWP(WarehousePosition warehousePosition);

    /**
     * 删除仓位信息,根据仓位id做逻辑删除
     *
     * @param warehousePositionId
     * @return
     */
    Integer deleteWPById(Integer warehousePositionId);

    /**
     * 获取使用中的仓位列表
     * @return
     */
    List<WarehousePosition> selectWpNameList();

    /**
     * 获取仓位列表
     * @param wpName
     * @return
     */
    List<WarehousePosition>  selectWpList(String wpName);
}
