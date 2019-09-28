package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.WarehouseMapper;
import com.mingyuansoftware.aifactory.model.Warehouse;
import com.mingyuansoftware.aifactory.model.dto.WarehouseDto;
import com.mingyuansoftware.aifactory.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张婷
 * @date 2019/6/27 18:23
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Warehouse> selectWarehouseAll(WarehouseDto warehouseDto) {
        try {
            return warehouseMapper.selectWarehouseAll(warehouseDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer count(WarehouseDto warehouseDto) {
        try {
            return warehouseMapper.count(warehouseDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addWarehouse(Warehouse warehouse) {
        warehouse.setIsDelete((byte) 0);
        warehouse.setState((byte) 1);//状态 1.表示空闲 2.表示使用中
        return warehouseMapper.addWarehouse(warehouse);
    }

    @Override
    public Warehouse selectEditWarehouse(Integer warehouseId) {
        try {
            return warehouseMapper.selectEditWarehouse(warehouseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer editWarehouse(Warehouse warehouse) {
        Warehouse warehouse1 = warehouseMapper.selectEditWarehouse(warehouse.getWarehouseId());
        warehouse.setIsDelete(warehouse1.getIsDelete());
        warehouse.setCreateTime(warehouse1.getCreateTime());
        return warehouseMapper.editWarehouse(warehouse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deletetWarehouse(Integer warehouseId) {
        return warehouseMapper.deletetWarehouse(warehouseId);
    }

    @Override
    public List<Warehouse> warehouseList() {
        try {
            return warehouseMapper.warehouseList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Warehouse> selectWarehouseNameList() {
        try {
            return warehouseMapper.selectWarehouseNameList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean warehouseNameCheck(int warehouseId, String warehouseName) {
        //如果id存在
        if (warehouseId > 0) {
            try {
                //通过仓库名称查询仓库id, 没有修改名字就可以使用
                int wId = warehouseMapper.selectWIdByWarehouseName(warehouseName);
                if (wId == warehouseId) {
                    return true;
                }
                //如果名字存在查出来id与本身id不同就不可用
                if (wId != warehouseId) {
                    return false;
                }
                //查询结果为空可以使用
            } catch (Exception e) {
                return true;
            }
        } else {
            //id不存在
            try {
                warehouseMapper.selectWIdByWarehouseName(warehouseName);
                //查询不到,可以使用
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }


}
