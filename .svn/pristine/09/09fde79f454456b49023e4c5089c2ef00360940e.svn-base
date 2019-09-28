package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PaymentOrder;
import com.mingyuansoftware.aifactory.model.dto.PaymentOrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PaymentOrderMapper {
    int deleteByPrimaryKey(Integer paymentOrderId);

    int insert(PaymentOrder record);

    PaymentOrder selectByPrimaryKey(Integer paymentOrderId);

    List<PaymentOrder> selectAll();

    int updateByPrimaryKey(PaymentOrder record);
    /**
     * 获取付款单列表
     * @param paymentOrderDto
     * @return
     */
    List<PaymentOrder> selectPaymentOrderList(@Param("paymentOrderDto") PaymentOrderDto paymentOrderDto);
    /**
     * 获取付款单列表总条数
     * @param paymentOrderDto
     * @return
     */
    int selectCount(@Param("paymentOrderDto") PaymentOrderDto paymentOrderDto);

    /**
     * 根据付款单id逻辑删除
     * @param paymentOrderId
     * @return
     */
    int updatePaymentOrderById(@Param("paymentOrderId") int paymentOrderId);

    /**
     * 根据员工id查询员工名字
     * @param staffId
     * @return
     */
    String selectStaffNameById(@Param("staffId") Integer staffId);
}