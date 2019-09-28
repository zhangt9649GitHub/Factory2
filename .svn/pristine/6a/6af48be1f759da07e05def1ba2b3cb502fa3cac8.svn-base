package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.RefundPickingDetails;
import com.mingyuansoftware.aifactory.model.RefundPickingGoods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RefundPickingDetailsService {

    /**
     * 根据退料单id获取退料单货物列表
     * @param refundPickingId
     * @return
     */
    List<RefundPickingGoods> SelectPdaRefundPickingGoodsList(int refundPickingId);

    /**
     * 根据退料单id获取退料单货物列表总条数
     * @param refundPickingId
     * @return
     */
    int selectPdaRefundPickingGoodsListCount(int refundPickingId);

    /**
     * 根据货物id和退料单id查询货物数量
     * @param goodsId
     * @param refundPickingId
     * @return
     */
    RefundPickingDetails selectRefundGoodsCount(int goodsId, int refundPickingId);

    /**
     * 将退料单的货物状态为已领料
     * @param refundPickingDetailsId
     */
    void updateRefundPickingDetailsStatus(int refundPickingDetailsId);
}
