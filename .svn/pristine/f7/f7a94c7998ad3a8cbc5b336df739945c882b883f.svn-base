package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.InboundAndOutboundAnalysis;
import com.mingyuansoftware.aifactory.model.KucunGoods;
import com.mingyuansoftware.aifactory.model.StockKucunGoods;
import com.mingyuansoftware.aifactory.model.dto.InboundAndOutboundDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Mapper
@Repository
public interface StockKucunGoodsMapper {


    int deleteByPrimaryKey(Integer skgid);


    int insert(StockKucunGoods record);


    StockKucunGoods selectByPrimaryKey(Integer skgid);


    List<StockKucunGoods> selectAll();


    int updateByPrimaryKey(StockKucunGoods record);


    /**
     * 根据仓库id查询仓库内货物库存数量
     * @param warehouseId
     * @return
     */
    List<KucunGoods> selectStockKucunGoodsCountByWarehouseId(@Param("warehouseId") int warehouseId,@Param("goodsId") Integer goodsId,@Param("partsCd") String partsCd,@Param("goodsName") String goodsName);

    List<KucunGoods> selectStockKucunGoodsByWarehouseId(HashMap map);
    /**
     * 根据仓库id查询仓库内货物库存数量总条数
     * @param warehouseId
     * @return
     */
    int selectCountStockKucunGoodsByWarehouseId(@Param("warehouseId") int warehouseId,@Param("goodsId") Integer goodsId,@Param("partsCd") String partsCd,@Param("goodsName") String goodsName);

    /**
     * 根据货物id查询所有仓库此货物的库存数
     * @param goodsId
     * @return
     */
    KucunGoods getStockKucunGoodsCountByGoodsId(@Param("goodsId") int goodsId);

    /**
     * 根据仓库id和货物id查询此仓库中此货物的库存数
     * @return
     */
    KucunGoods getStockKucunGoodsCountByGoodsIdAndWarehouseId(@Param("warehouseId") int warehouseId,@Param("goodsId") int goodsId);

    /**
     * 获取所有货物的库存数
     * @return
     */
    List<StockKucunGoods> selectGoodsKucun();

    /**
     * 根据获取id查询货物库存数
     * @param goodsId
     * @return
     */
    List<StockKucunGoods> selectGoodsKucunById(@Param("goodsId") Integer goodsId);

    /**
     * 根据货物id查询天津库存详情
     * @param goodsId
     * @return
     */
    List<StockKucunGoods> selectTjGoodsKucunInfo(@Param("goodsId") int goodsId);

    /**
     * 查询当时货物的总数量
     * @param skgid
     * @param goodsId
     * @return
     */
    StockKucunGoods selectTjGoodsKucunNow(@Param("skgid") int skgid,@Param("goodsId") int goodsId);

    /**
     * 获取出入库分析表列表
     * @param inboundAndOutboundDto
     * @return
     */
    List<InboundAndOutboundAnalysis> selectInboundAndOutboundAnalysisList(@Param("inboundAndOutboundDto") InboundAndOutboundDto inboundAndOutboundDto);

    /**
     * 获取出入库分析表总条数
     * @param inboundAndOutboundDto
     * @return
     */
    int selectCountInboundAndOutboundAnalysisList(@Param("inboundAndOutboundDto") InboundAndOutboundDto inboundAndOutboundDto);
}