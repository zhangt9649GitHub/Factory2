package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.RefundPicking;
import com.mingyuansoftware.aifactory.model.dto.RefundPickingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RefundPickingService {

    /**
     * 获取退料单列表
     * @param refundPickingDto
     * @return
     */
    List<RefundPicking> selectRefundPickingList(RefundPickingDto refundPickingDto);

    /**
     * 获取退料单列表总条数
     * @param refundPickingDto
     * @return
     */
    int selectCount(RefundPickingDto refundPickingDto);

    /**
     * 新增退料单
     * @param refundPicking
     */
    void insertRefundPicking(RefundPicking refundPicking);

    /**
     * 根据退料单id查询退料单详情
     * @param refundPickingId
     * @return
     */
    RefundPicking selectRefundPickingById(int refundPickingId);


    /**
     * 根据退料单id修改删除状态
     * @param refundPickingId
     */
    void deleteRefundPickingById(int refundPickingId);

    /**
     * 更新退料单信息
     * @param refundPicking
     */
    void updateRefundPickingInfo(RefundPicking refundPicking);

    /**
     * 获取生产退料单列表
     * @return
     */
    List<RefundPicking> selectPdaRefundPickingList();

    /**
     * 获取生产退料单总条数
     * @return
     */
    int selectPdaRefundPickingCount();

    /**
     * 更新退料单状态为已完成
     * @param refundPickingId
     */
    void updateRefundPickingState(int refundPickingId);

}
