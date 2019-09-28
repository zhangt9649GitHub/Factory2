package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.PaymentOrder;
import com.mingyuansoftware.aifactory.model.dto.PaymentOrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentOrderService {
    /**
     * 获取付款单列表
     * @param paymentOrderDto
     * @return
     */
    List<PaymentOrder> selectPaymentOrderList(PaymentOrderDto paymentOrderDto);

    /**
     * 获取付款单列表总条数
     * @param paymentOrderDto
     * @return
     */
    int selectCount(PaymentOrderDto paymentOrderDto);

    /**
     * 添加付款单
     * @param paymentOrder
     * @return
     */
    int insertPaymentOrder(PaymentOrder paymentOrder);

    /**
     * 获取采购订单中的供应商列表信息
     * @return
     */
    List<PaymentOrder> selectPaymentOrderSupplierList();

    /**
     * 获取采购订单中的供应商列表信息总条数
     * @return
     */
    int selectSuplierCount();

    /**
     * 根据付款单id逻辑删除
     * @param paymentOrderId
     * @return
     */
    int deletePaymentOrder(int paymentOrderId);

    /**
     * 根据付款单id获取付款单信息
     * @param paymentOrderId
     * @return
     */
    PaymentOrder selectPaymentOrderById(int paymentOrderId);
}
