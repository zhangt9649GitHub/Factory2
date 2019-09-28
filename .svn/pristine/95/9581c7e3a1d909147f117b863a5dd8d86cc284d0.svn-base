package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.PickingDetails;
import com.mingyuansoftware.aifactory.model.PickingGoods;
import com.mingyuansoftware.aifactory.model.dto.PickingDetailsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PickingDetailsMapper {


    int deleteByPrimaryKey(Integer pickingDetailsId);


    int insert(PickingDetails record);


    PickingDetails selectByPrimaryKey(Integer pickingDetailsId);


    List<PickingDetails> selectAll();


    int updateByPrimaryKey(PickingDetails record);

    /**
     * 根据领料单id查询关联货物集合
     * @param pickingId
     * @return
     */
    List<PickingDetails> selectPickingDetailById(@Param("pickingId") int pickingId);

    void deleteByPickingId(@Param("pickingId") int pickingId);

    /**
     * 获取生产领料明细列表
     * @param pickingDetailsDto
     * @return
     */
    List<PickingDetailsDto> selectPickingDetailsList(@Param("pickingDetailsDto") PickingDetailsDto pickingDetailsDto);


    /**
     * 获取生产领料明细列表总条数
     * @param pickingDetailsDto
     * @return
     */
    int selectCountPickingDetails(@Param("pickingDetailsDto") PickingDetailsDto pickingDetailsDto);

    /**
     * 根据领料单id获取未完成领料的货物列表
     * @param pickingId
     * @return
     */
    List<PickingGoods> selectPdaPickingGoodsList(@Param("pickingId") int pickingId);

    /**
     * 根据领料单id获取未完成领料的货物列表总条数
     * @param pickingId
     * @return
     */
    int selectPdaPickingGoodsListCount(@Param("pickingId") int pickingId);

    /**
     * 根据货物单号与领料单id获取货物信息
     * @param goodsId
     * @param pickingId
     * @return
     */
    PickingDetails selectGoodsInfoByGoodsNumber(@Param("goodsId") int goodsId,@Param("pickingId") int pickingId);

    /**
     * 根据领料单详情id修改货物领料状态
     * @param pickingDetailsId
     */
    void  updatePickingDetailsStatus(@Param("pickingDetailsId") int pickingDetailsId);

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