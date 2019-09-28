/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: InventoryCheckServiceImpl
 * Author:   EDZ
 * Date:     2019/7/13 17:56
 * Description: 库存盘点
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.InventoryCheckDto;
import com.mingyuansoftware.aifactory.service.InventoryCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈库存盘点〉
 *
 * @author EDZ
 * @create 2019/7/13
 * @since 1.0.0
 */
@Service
public class InventoryCheckServiceImpl implements InventoryCheckService {

    @Autowired
    private InventoryCheckMapper inventoryCheckMapper;
    @Autowired
    private InventoryCheckGoodsMapper inventoryCheckGoodsMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private StockKucunGoodsMapper stockKucunGoodsMapper;

    @Override
    public int deleteByPrimaryKey(Integer inventoryCheckId) {
        return inventoryCheckMapper.deleteByPrimaryKey(inventoryCheckId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(InventoryCheck record) {
        record.setState((byte) 1);
        record.setIsDelete((byte) 0);
        record.setCreateTime(new Date());
        int insert = inventoryCheckMapper.insert(record);
        Integer warehouseId = record.getWarehouseId();
        Warehouse warehouse = warehouseMapper.selectEditWarehouse(warehouseId);
        HashMap<String, Integer> map = new HashMap();
        map.put("warehouseId", warehouseId);
        List<KucunGoods> kucunGoods = stockKucunGoodsMapper.selectStockKucunGoodsByWarehouseId(map);
        for (int i = 0; i < kucunGoods.size(); i++) {
            InventoryCheckGoods inventoryCheckGoods = new InventoryCheckGoods();
            inventoryCheckGoods.setInventoryCheckId(record.getInventoryCheckId());
            //inventoryCheckGoods.setStockQuantity(kucunGoods.get(i).getSkgCount());
            inventoryCheckGoods.setWarehousePosition(kucunGoods.get(i).getWpName());
            inventoryCheckGoods.setGoodsId(kucunGoods.get(i).getGoodsId());
            inventoryCheckGoods.setPdaState(1);
            inventoryCheckGoodsMapper.insert(inventoryCheckGoods);
        }
        return insert;
    }

    @Override
    public InventoryCheck selectByPrimaryKey(int inventoryCheckId) {
        InventoryCheck inventoryCheck = inventoryCheckMapper.selectByPrimaryKey(inventoryCheckId);
        List<InventoryCheckGoods> inventoryCheckGoods = inventoryCheckGoodsMapper.selectByPrimaryKey(inventoryCheckId);
        for (InventoryCheckGoods inventoryCheckGood : inventoryCheckGoods) {
            HashMap<String, Integer> map = new HashMap();
            map.put("warehouseId", inventoryCheck.getWarehouseId());
            map.put("goodsId", inventoryCheckGood.getGoodsId());
            List<KucunGoods> kucunGoods = stockKucunGoodsMapper.selectStockKucunGoodsByWarehouseId(map);
            inventoryCheckGood.setStockQuantity(kucunGoods.get(0).getSkgCount());
        }
        inventoryCheck.setInventoryCheckGoods(inventoryCheckGoods);
        return inventoryCheck;
    }

    @Override
    public List<InventoryCheck> selectAll(InventoryCheckDto inventoryCheckDto) {
        return inventoryCheckMapper.selectAll(inventoryCheckDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateByPrimaryKey(InventoryCheck record) {
        record.setUpdateTime(new Date());
        inventoryCheckMapper.updateByPrimaryKey(record);
        inventoryCheckGoodsMapper.deleteByPrimaryKey(record.getInventoryCheckId());
        List<InventoryCheckGoods> inventoryCheckGoods = record.getInventoryCheckGoods();
        for (int i = 0; i < inventoryCheckGoods.size(); i++) {
            inventoryCheckGoods.get(i).setInventoryCheckId(record.getInventoryCheckId());
            inventoryCheckGoodsMapper.insert(inventoryCheckGoods.get(i));
        }

    }

    @Override
    public int selectPDaInventoryCheckTaskListCount() {
        try {
            return inventoryCheckMapper.selectPDaInventoryCheckTaskListCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<PDAInventoryCheckTask> selectPDaInventoryCheckTaskList() {
        try {
            return inventoryCheckMapper.selectPDaInventoryCheckTaskList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public InventoryCheck updateInventoryCheck(Integer staffId, Integer inventoryCheckGoodsId, BigDecimal inventoryQuantity) {
        //修改本条盘点详情货物:盘点人,盘点数量,盘点状态2.已盘点;并且修改盘盈数量或者盘亏数量
        inventoryCheckGoodsMapper.updateInventoryCheckGoodsState(staffId, inventoryCheckGoodsId, inventoryQuantity);
        InventoryCheckGoods inventoryCheckGoods = inventoryCheckGoodsMapper.selectById(inventoryCheckGoodsId);
        //根据货物Id和仓库Id查询库存表中的盘点的该货物的库存数量 根据盘点单Id查询仓库Id
        InventoryCheckGoods inventoryCheckGoods1 = inventoryCheckGoodsMapper.selectQuantityByGId(inventoryCheckGoods.getGoodsId(), inventoryCheckMapper.selectByPrimaryKey(inventoryCheckGoods.getInventoryCheckId()).getWarehouseId());
//            System.out.println(inventoryCheckGoods1.getStockQuantity());
        //如果相等的话:盘盈数量==盘亏数量==0
        if (inventoryCheckGoods1.getStockQuantity().compareTo(inventoryCheckGoods.getInventoryQuantity()) == 0) {
            inventoryCheckGoods.setSurplusQuantity(BigDecimal.ZERO);
            inventoryCheckGoods.setDeficitQuantity(BigDecimal.ZERO);
        }
        //stock_quantity 库存数量(计算出来)  inventory_quantity 盘点数量  surplus_quantity 盘盈数量  deficit_quantity盘亏数量
        if (inventoryCheckGoods1.getStockQuantity().compareTo(inventoryCheckGoods.getInventoryQuantity()) > 0) {
            //如果盘点数量<库存数量,设置盘亏数量 : 库存数量-盘点数量
            inventoryCheckGoods.setSurplusQuantity(BigDecimal.ZERO);
            inventoryCheckGoods.setDeficitQuantity(inventoryCheckGoods1.getStockQuantity().subtract(inventoryCheckGoods.getInventoryQuantity()));
        }
        if (inventoryCheckGoods1.getStockQuantity().compareTo(inventoryCheckGoods.getInventoryQuantity()) < 0) {
            //如果盘点数量>库存数量,设置盘盈数量 : 盘点数量-库存数量
            inventoryCheckGoods.setSurplusQuantity(inventoryCheckGoods.getInventoryQuantity().subtract(inventoryCheckGoods1.getStockQuantity()));//如果库存数量为负数
            inventoryCheckGoods.setDeficitQuantity(BigDecimal.ZERO);
        }
        inventoryCheckGoodsMapper.updateInventorCheckQuantity(inventoryCheckGoods);
        //判断盘点单入库状态不能为2.已盘点(state)
        InventoryCheck inventoryCheck = inventoryCheckMapper.selectByPrimaryKey(inventoryCheckGoods.getInventoryCheckId());
        List<InventoryCheckGoods> inventoryCheckGoodsList = inventoryCheckGoodsMapper.selectByPrimaryKey(inventoryCheckGoods.getInventoryCheckId());
        boolean flag = true;
        for (InventoryCheckGoods inventoryCheckGoods2 : inventoryCheckGoodsList) {
            if (inventoryCheckGoods2.getPdaState() == 1) {
                flag = false;
                int state = 3;
                //部分盘点为3
                inventoryCheckMapper.updateStateById(inventoryCheckGoods.getInventoryCheckId(), state, staffId);
                break;
            }
        }
        if (flag) {
            //已盘点 2.
            int state = 2;
            inventoryCheckMapper.updateStateById(inventoryCheckGoods.getInventoryCheckId(), state, staffId);
        }
        return inventoryCheck;
    }

    @Override
    public Integer selectInventoryCheckGoodsId(Integer inventoryCheckId, Integer goodsId) {
        try {
            return inventoryCheckGoodsMapper.selectInventoryCheckGoodsId(inventoryCheckId, goodsId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public InventoryCheckGoods selectStockQuantityByGId(Integer goodsId, Integer warehouseId) {
        try {
            return inventoryCheckGoodsMapper.selectQuantityByGId(goodsId, warehouseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
