package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.PDAOutboundGoods;
import com.mingyuansoftware.aifactory.model.ShipmentDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipmentDetailsService {
    /**
     * 获取出货单货物列表
     * @return
     */
    List<PDAOutboundGoods> selectPdaOutboundGoodsList(int shipmentId);

    /**
     * 根据货物id和出货单id查询出货数量
     * @param goodsId
     * @param shipmentId
     * @return
     */
    ShipmentDetails selectPdaOutboundGoodsCount(int goodsId, int shipmentId);

    /**
     * 修改出货单状态及销售单状态
     * @param shipmentDetailsId
     */
    void updateShipmentStatus(int shipmentDetailsId);

}
