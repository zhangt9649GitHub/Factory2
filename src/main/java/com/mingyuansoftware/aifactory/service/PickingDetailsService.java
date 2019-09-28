package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.PickingDetails;
import com.mingyuansoftware.aifactory.model.PickingGoods;
import com.mingyuansoftware.aifactory.model.dto.PickingDetailsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PickingDetailsService {

    /**
     * 获取生产领料明细列表
     * @param pickingDetailsDto
     * @return
     */
    List<PickingDetailsDto> selectPickingDetailsList(PickingDetailsDto pickingDetailsDto);


    /**
     * 获取生产领料明细列表总条数
     * @param pickingDetailsDto
     * @return
     */
    int selectCountPickingDetails(PickingDetailsDto pickingDetailsDto);

    /**
     * 根据领料单id获取货物详情
     * @param pickingId
     * @return
     */
    List<PickingGoods> selectPdaPickingGoodsList(int pickingId);

    /**
     * 根据领料单id获取货物详情总条数
     * @param pickingId
     * @return
     */
    int selectPdaPickingGoodsListCount(int pickingId);

    /**
     * 根据货物编号与领料单id获取货物信息
     * @param goodsId
     * @param pickingId
     * @return
     */
    PickingDetails selectGoodsInfoByGoodsNumber(int goodsId, int pickingId);

    /**
     * 根据领料单详情id修改货物领料状态
     * @param pickingDetailsId
     * @param staffId
     */
    void  updatePickingDetailsStatus(int staffId,int pickingDetailsId);

    /**
     * 首页获取领料明细
     * @return
     */
    List<PickingDetailsDto>  selectPickingInfoList();

    /**
     * 首页获取领料明细条数
     * @return
     */
    int selectCountPickingInfoList();
}
