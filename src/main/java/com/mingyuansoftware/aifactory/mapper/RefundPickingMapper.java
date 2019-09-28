package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.RefundPicking;
import com.mingyuansoftware.aifactory.model.dto.RefundPickingDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface RefundPickingMapper {


    int deleteByPrimaryKey(Integer refundPickingId);



    int insert(RefundPicking record);



    RefundPicking selectByPrimaryKey(Integer refundPickingId);



    List<RefundPicking> selectAll();



    int updateByPrimaryKey(RefundPicking record);

    /**
     * 获取退料单列表
     * @param refundPickingDto
     * @return
     */
    List<RefundPicking> selectRefundPickingList(@Param("refundPickingDto") RefundPickingDto refundPickingDto);

    /**
     * 获取退料单列表总条数
     * @param refundPickingDto
     * @return
     */
    int selectCount(@Param("refundPickingDto") RefundPickingDto refundPickingDto);

    /**
     * 根据id修改删除状态
     * @param refundPickingId
     */
    void updateRefundPickingById(@Param("refundPickingId") int refundPickingId);

    /**
     * 获取生产退料单列表
     * @return
     */
    List<RefundPicking> selectPdaRefundPickingList();

    /**
     * 获取生产退料单总条目
     * @return
     */
    int selectPdaRefundPickingCount();

    /**
     * 修改退料单的状态为已领料
     * @param refundPickingId
     * @param state
     */
    void updateRefundPickingState(@Param("refundPickingId") int refundPickingId,@Param("state") int state);
}