package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PDAOutboundGoods;
import com.mingyuansoftware.aifactory.model.ShipmentDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface ShipmentDetailsMapper {

    int deleteByPrimaryKey(Integer shipmentDetailsId);

    int insert(ShipmentDetails record);

    ShipmentDetails selectByPrimaryKey(Integer shipmentDetailsId);

    List<ShipmentDetails> selectAll();

    int updateByPrimaryKey(ShipmentDetails record);

    /**
     * 获取出货单货物列表
     * @return
     */
    List<PDAOutboundGoods> selectPdaOutboundGoodsList(@Param("shipmentId") int shipmentId);

    /**
     * 根据货物id和出货单id查询出货数量
     * @param goodsId
     * @param shipmentId
     * @return
     */
    ShipmentDetails selectPdaOutboundGoodsCount(@Param("goodsId") int goodsId,@Param("shipmentId") int shipmentId);

    /**
     * 修改出货单状态为已配货
     * @param shipmentDetailsId
     */
    void updateShipmentStatus(@Param("shipmentDetailsId") int shipmentDetailsId);

    /**
     * 根据出货单id查询出货单详情集合
     * @param shipmentId
     * @return
     */
    List<ShipmentDetails> selectShipmentDetailsListById(@Param("shipmentId") int shipmentId);

    /**
     * 根据货物id和出货单id查询出货单货物集合
     * @param shipmentId
     * @param goodsId
     * @return
     */
    List<ShipmentDetails> selectShipmentDetailsListByIdAndGoodsId(@Param("shipmentId") int shipmentId,@Param("goodsId") int goodsId);
}