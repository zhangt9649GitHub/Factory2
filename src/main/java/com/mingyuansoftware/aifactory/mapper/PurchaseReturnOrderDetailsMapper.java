package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PurchaseReturnOrderDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface PurchaseReturnOrderDetailsMapper {
    int deleteByPrimaryKey(Integer prodId);

    int insert(PurchaseReturnOrderDetails record);

    PurchaseReturnOrderDetails selectByPrimaryKey(Integer prodId);

    List<PurchaseReturnOrderDetails> selectAll();

    int updateByPrimaryKey(PurchaseReturnOrderDetails record);

    /**
     * 过采购退换货单id获取采购退换货单详情集合
     * @param proId
     * @return
     */
    List<PurchaseReturnOrderDetails> selectPurchaseReturnOrderDetailsByProId(@Param("proId") int proId);

    /**
     * 更新采购退货单详情中货物的已出库数量
     * @param prodId
     * @param returnQuantity
     */
    void updateQuantity(@Param("prodId") Integer prodId,@Param("returnQuantity") BigDecimal returnQuantity);
}