package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.InboundAndOutboundAnalysis;
import com.mingyuansoftware.aifactory.model.KucunGoods;
import com.mingyuansoftware.aifactory.model.TotalInboundAndOutboundAnalysis;
import com.mingyuansoftware.aifactory.model.dto.InboundAndOutboundDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StockKucunGoodsService {

    /**
     * 根据仓库id获取仓库内库存流水记录
     * @param warehouseId
     * @param goodsId
     * @param partsCd
     * @return
     */
    List<KucunGoods> getStockKucunGoodsCount(int warehouseId,Integer goodsId, String partsCd,String goodsName);

    /**
     * 根据仓库id获取仓库内库存流水记录总条数
     * @param warehouseId
     * @param goodsId
     * @param partsCd
     * @return
     */
    int getCountStockKucunGoods(int warehouseId,Integer goodsId, String partsCd,String goodsName);

    /**
     * 添加货物库存流水
     * @param parameters  ("skgCount(必传)","warehouseId(必传)","skgType(必传)","gid(必传)","skgDanJia(必传)",
     *                    "skgSerialNumber(必传)","skgWanglaiDanwei(采购入库，销售出库为必传,其余传空字符串)",changeType,必传
     *                    变动类型  1.外部变动 包括销售,销售退货,采购,采购退货,入库单,出库单,库存盘点 2.内部变动 包括领料单,退料单,调拨单,生产入库")
     * @return
     */
    Integer insertStockKucunGoods(Map<String,Object> parameters);

    /**
     * 根据仓库id和货物id查询仓库内货物的库存
     * @param warehouseId  仓库id为0，表示所有仓库
     * @param goodsId
     * @return
     */
    KucunGoods getStockKucunGoodsCountByGoodsIdAndWarehouseId(int warehouseId,int goodsId);

    /**
     * 获取出入库分析表列表
     * @param inboundAndOutboundDto
     * @return
     */
    TotalInboundAndOutboundAnalysis selectInboundAndOutboundAnalysisList(InboundAndOutboundDto inboundAndOutboundDto);

    /**
     * 获取出入库分析表总条数
     * @param inboundAndOutboundDto
     * @return
     */
    int selectCountInboundAndOutboundAnalysisList(InboundAndOutboundDto inboundAndOutboundDto);

}
