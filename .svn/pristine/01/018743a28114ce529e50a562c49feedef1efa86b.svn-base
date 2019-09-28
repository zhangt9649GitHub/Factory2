package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.WarehouseMapper;
import com.mingyuansoftware.aifactory.mapper.WarehousePositionMapper;
import com.mingyuansoftware.aifactory.model.WarehousePosition;
import com.mingyuansoftware.aifactory.model.dto.WarehousePositionDto;
import com.mingyuansoftware.aifactory.service.WarehousePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张婷
 * @date 2019/6/27 15:59
 */

@Service
public class WarehousePositionServiceImpl implements WarehousePositionService {
    @Autowired
    private WarehousePositionMapper warehousePositionMapper;
    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<WarehousePositionDto> selectWarehousePositionAll(WarehousePositionDto warehousePositionDto) {
        try {
            return warehousePositionMapper.selectWarehousePositionAll(warehousePositionDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer count(WarehousePositionDto warehousePositionDto) {
        try {
            return warehousePositionMapper.count(warehousePositionDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addWarehousePosition(WarehousePosition warehousePosition) {
        warehousePosition.setIsDelete((byte)0);
        warehousePosition.setState((byte)1);//1.已创建
        return warehousePositionMapper.addWarehousePosition(warehousePosition);
    }

    @Override
    public WarehousePosition selectEditWP(Integer warehousePositionId) {
        try {
            return warehousePositionMapper.selectEditWP(warehousePositionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer editWP(WarehousePosition warehousePosition) {
        WarehousePosition warehousePosition1 = warehousePositionMapper.selectEditWP(warehousePosition.getWpId());
        warehousePosition.setState(warehousePosition1.getState());
        warehousePosition.setCreateTime(warehousePosition1.getCreateTime());
        warehousePosition.setIsDelete(warehousePosition1.getIsDelete());
        return warehousePositionMapper.editWP(warehousePosition);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteWPById(Integer warehousePositionId) {
        return warehousePositionMapper.deleteWPById(warehousePositionId);
    }

    @Override
    public List<WarehousePosition> selectWpNameList() {
        try {
            return warehousePositionMapper.selectWpNameList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WarehousePosition> selectWpList(String wpName) {
        try {
            return warehousePositionMapper.selectWpList(wpName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
