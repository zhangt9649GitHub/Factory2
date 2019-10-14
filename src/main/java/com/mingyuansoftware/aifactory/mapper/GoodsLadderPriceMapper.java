package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.GoodsLadderPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface GoodsLadderPriceMapper {


    int deleteByPrimaryKey(Integer ladderPriceId);



    int insert(GoodsLadderPrice record);



    GoodsLadderPrice selectByPrimaryKey(Integer ladderPriceId);



    List<GoodsLadderPrice> selectAll();



    int updateByPrimaryKey(GoodsLadderPrice record);

    /**
     * 根据货物id查询阶梯价格集合
     * @param goodsId
     * @return
     */
    List<GoodsLadderPrice> selectGoodsLadderPriceListByGoodsId(int goodsId);

    /**
     * 根据货物id删除阶梯价格集合
     * @param goodsId
     */
   void deleteByGoodsId(@Param("goodsId") int goodsId);
}