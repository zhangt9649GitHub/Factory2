package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.Picking;
import com.mingyuansoftware.aifactory.model.dto.PickingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PickingService {

    /**
     * 获取领料单列表
     * @param pickingDto
     * @return
     */
    List<Picking> selectPickingList(PickingDto pickingDto);

    /**
     * 获取领料单总条数
     * @param pickingDto
     * @return
     */
    int selectCount(PickingDto pickingDto);

    /**
     * 新增领料单
     * @param picking
     */
    void insertPicking(Picking picking);

    /**
     * 根据主键id查询详情
     * @param picking
     * @return
     */
    Picking selectPickingById(int picking);


    /**
     * 根据id删除领料单
     * @param picking
     */
    void deletePickingById(int picking);

    /**
     * 编辑领料单信息
     * @param picking
     */
    void updatePickingInfo(Picking picking);

    /**
     * PDA获取生产领料列表
     * @return
     */
    List<Picking> selectPdaPickingList();

    /**
     * PDA获取生产领料列表总条数
     * @return
     */
    int selectPdaPickingListCount();

    /**
     * 根据领料单id变更状态为已完成
     * @param pickingId
     */
    void updatePickingState(int pickingId);

}
