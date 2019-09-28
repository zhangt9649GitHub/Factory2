package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.PDAProductionEntryTask;
import com.mingyuansoftware.aifactory.model.ProductionOrder;
import com.mingyuansoftware.aifactory.model.ProductionOrderInfo;
import com.mingyuansoftware.aifactory.model.dto.ProductionOrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionOrderService {

    /**
     * 获取排产单列表
     * @param productionOrderDto
     * @return
     */
    List<ProductionOrder> selectProductionOrderList(ProductionOrderDto productionOrderDto);

    /**
     * 获取排产单列表总条数
     * @param productionOrderDto
     * @return
     */
    int selectCount(ProductionOrderDto productionOrderDto);


    /**
     * 新增排产单
     * @param productionOrder
     */
    void insertProductionOrder(ProductionOrder productionOrder);

    /**
     * 查看生产指示书详情
     * @param productionOrderId
     * @return
     */
    ProductionOrder selectProductionOrderById(int productionOrderId);

    /**
     * 删除排产单
     * @param productionOrderId
     */
    void deleteProductionOrderById(int productionOrderId);

    /**
     * 更新排产单
     * @param productionOrder
     */
    void updateProductionOrderInfo(ProductionOrder productionOrder);

    /**
     * 获取生产入库任务列表
     * @return
     */
    List<PDAProductionEntryTask> selectPdaProductionEntryTaskList();

    /**
     * 获取生产入库任务列表总条数
     * @return
     */
    int selectPdaProductionEntryListTaskCount();

    /**
     * 获取首页的排产单列表
     * @return
     */
    List<ProductionOrderInfo> selectProductionOrderInfoList();

    /**
     * 获取首页排产单列表总条数
     * @return
     */
    int selectCountProductionOrderInfoList();
}
