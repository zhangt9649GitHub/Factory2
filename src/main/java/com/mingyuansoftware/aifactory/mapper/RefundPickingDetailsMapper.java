package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.RefundPickingDetails;
import com.mingyuansoftware.aifactory.model.RefundPickingGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface RefundPickingDetailsMapper {


    int deleteByPrimaryKey(Integer refundPickingDetailsId);



    int insert(RefundPickingDetails record);



    RefundPickingDetails selectByPrimaryKey(Integer refundPickingDetailsId);



    List<RefundPickingDetails> selectAll();


    int updateByPrimaryKey(RefundPickingDetails record);

    /**
     * 根据退料单id查询退料单详情
     * @param refundPickingId
     * @return
     */
    List<RefundPickingDetails> selectRefundPinkingDetailsById(@Param("refundPickingId") int refundPickingId);

    /**
     * 删除旧的退料单详情
     * @param refundPickingId
     */
    void deleteRefundPickingDetailsById(@Param("refundPickingId") int refundPickingId );


    /**
     * 根据退料单id获取退料单货物列表
     * @param refundPickingId
     * @return
     */
    List<RefundPickingGoods> SelectPdaRefundPickingGoodsList(@Param("refundPickingId") int refundPickingId);

    /**
     * 根据退料单id获取退料单货物列表总条数
     * @param refundPickingId
     * @return
     */
    int selectPdaRefundPickingGoodsListCount(@Param("refundPickingId") int refundPickingId);

    /**
     * 根据货物id和退料单id查询货物数量
     * @param goodsId
     * @param refundPickingId
     * @return
     */
    RefundPickingDetails selectRefundGoodsCount(@Param("goodsId") int goodsId, @Param("refundPickingId") int refundPickingId);


    /**
     * 根据退料单详情id修改此条货物的退料状态
     * @param refundPickingDetailsId
     */
    void updateRefundPickingDetailsStatus(@Param("refundPickingDetailsId") int refundPickingDetailsId);
}