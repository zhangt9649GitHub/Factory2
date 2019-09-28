package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.SalesReturn;
import com.mingyuansoftware.aifactory.model.dto.SalesReturnDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface SalesReturnMapper {

    int deleteByPrimaryKey(Integer salesReturnId);


    int insert(SalesReturn record);


    SalesReturn selectByPrimaryKey(Integer salesReturnId);


    List<SalesReturn> selectAll();


    int updateByPrimaryKey(SalesReturn record);

    /**
     * 获取销售退货单列表
     * @param salesReturnDto
     * @return
     */
    List<SalesReturn> selectSalesReturnList(@Param("salesReturnDto") SalesReturnDto salesReturnDto);

    /**
     * 获取销售退货单列表总条目
     * @param salesReturnDto
     * @return
     */
    int selectSalesReturnCount(@Param("salesReturnDto") SalesReturnDto salesReturnDto);


    /**
     * 将销售退货单的状态改为删除
     * @param salesReturnId
     */
    void updateSalesReturnById(@Param("salesReturnId") Integer salesReturnId);

    /**
     * 根据销售订单获取销售退货单列表
     * @param salesOrderId
     * @return
     */
    List<SalesReturn> selectSalesReturnListById(@Param("salesOrderId") int salesOrderId);

    /**
     * 更新销售退货单的状态为已入库
     * @param salesReturnId
     */
    void updateSalesReturnState(@Param("salesReturnId") int salesReturnId);

    /**
     * 根据销售退货单Id修改内容
     * @param salesReturn1
     */
    void updatePaymentInfoById(@Param("salesReturn1") SalesReturn salesReturn1);

    /**
     * 获取销售退货单列表(付款使用)
     * @return
     */
    List<SalesReturn> selectSalesReturnListForPayment();
}