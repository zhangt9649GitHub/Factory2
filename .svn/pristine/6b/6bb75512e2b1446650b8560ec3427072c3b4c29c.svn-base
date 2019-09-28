package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.Requisition;
import com.mingyuansoftware.aifactory.model.dto.RequisitionDto;
import com.mingyuansoftware.aifactory.model.dto.RequisitionGoodsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequisitionService {

    /**
     * 查询调拨单列表
     * @return
     */
    List<Requisition> selectRequisitionList(RequisitionDto requisitionDto);

    /**
     * 获取调拨单总条数
     * @param requisitionDto
     * @return
     */
    int selectCount(RequisitionDto requisitionDto);

    /**
     * 根据仓库id查询仓库内货物列表
     * @param warehouseId
     * @return
     */
    List<RequisitionGoodsDto> selectRequisitionGoodsList(int warehouseId);

    /**
     * 根据仓库id查询仓库内货物数量
     * @param warehouseId
     * @return
     */
    int selectRequisitionGoodsCount(int warehouseId);

    /**
     * 新增调拨单
     * @param requisition
     */
    void insertRequisition(Requisition requisition);

    /**
     * 删除调拨单
     * @param requisitionId
     */
    void deleteRequisitionById(int requisitionId);

    /**
     * 根据调拨单id查询调拨单信息
     * @param requisitionId
     * @return
     */
    Requisition selectRequisitionById(int requisitionId);

    /**
     * 更新调拨单信息
     * @param requisition
     */
    void updateRequisitionInfo(Requisition requisition);
}
