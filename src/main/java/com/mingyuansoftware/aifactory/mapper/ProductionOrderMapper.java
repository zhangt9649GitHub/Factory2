package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PDAProductionEntryTask;
import com.mingyuansoftware.aifactory.model.ProductionOrder;
import com.mingyuansoftware.aifactory.model.ProductionOrderInfo;
import com.mingyuansoftware.aifactory.model.dto.ProductionOrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ProductionOrderMapper {

    int deleteByPrimaryKey(Integer productionOrderId);


    int insert(ProductionOrder record);


    ProductionOrder selectByPrimaryKey(Integer productionOrderId);


    List<ProductionOrder> selectAll();


    int updateByPrimaryKey(ProductionOrder record);

    /**
     * 获取排产单列表
     * @param productionOrderDto
     * @return
     */
    List<ProductionOrder> selectProductionOrderList(@Param("productionOrderDto") ProductionOrderDto productionOrderDto);

    /**
     * 获取排产单列表总条数
     * @param productionOrderDto
     * @return
     */
    int selectCount(@Param("productionOrderDto") ProductionOrderDto productionOrderDto);

    /**
     * 将排产单的状态改为删除
     */
    void updateProductionOrderById(@Param("productionOrderId") int productionOrderId);

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

    /**
     * 修改排产单的状态
     * @param productionOrderId
     * @param state
     */
    void updateStateById(@Param("productionOrderId") int productionOrderId,@Param("state") int state);
}