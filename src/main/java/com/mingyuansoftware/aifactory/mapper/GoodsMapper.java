package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.GoodsDto;
import com.mingyuansoftware.aifactory.model.dto.InventoryWarningDto;
import com.mingyuansoftware.aifactory.model.dto.PDAGoodsDto;
import com.mingyuansoftware.aifactory.model.dto.TjGoodsKucunDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
@Mapper
public interface GoodsMapper {

    int deleteByPrimaryKey(Integer goodsId);


    int insert(Goods record);


    Goods selectByPrimaryKey(Integer goodsId);


    List<Goods> selectAll();


    int updateByPrimaryKey(Goods record);

    /**
     * 获取货物列表
     * @param goodsDto
     * @return
     */
    List<Goods> selectGoodsList(@Param("goodsDto") GoodsDto goodsDto);

    /**
     * 获取货物列表总条数
     * @param goodsDto
     * @return
     */
    int selectCount(@Param("goodsDto") GoodsDto goodsDto);


    /**
     * 获取导出的货物列表信息
     * @return
     */
    List<Goods> selectExportGoodsList();

    /**
     * 获取所有货物包括库存数
     * @return
     */
    List<KucunGoods> selectAllGoodsList(@Param("goodsId") Integer goodsId, @Param("partsCd") String partsCd,@Param("goodsName") String goodsName);

    /**
     * 获取所有获取总条数
     * @return
     */
    int selectAllGoodsCount(@Param("goodsId") Integer goodsId, @Param("partsCd") String partsCd,@Param("goodsName") String goodsName);


    /**
     * 获取天津货物库存表
     * @param tjGoodsKucunDto
     * @return
     */
    List<TjGoodsKucunDto> selectTjGoodsKucunList(@Param("tjGoodsKucunDto") TjGoodsKucunDto tjGoodsKucunDto);

    /**
     * 获取天津货物库存表总条数
     * @param tjGoodsKucunDto
     * @return
     */
    int selectTjGoodsKucunCount(@Param("tjGoodsKucunDto") TjGoodsKucunDto tjGoodsKucunDto);

    /**
     * 库存预警显示条件:是库存数量<最低库存,显示货物和库存
     * 获取库存预警列表
     * @param inventoryWarningDto
     * @return
     */
    List<InventoryWarningDto> selectInventoryWarningList(@Param("inventoryWarningDto") InventoryWarningDto inventoryWarningDto);

    /**
     * 获取库存预警列表总条数
     * @param inventoryWarningDto
     * @return
     */
    int selecInventoryWarningtCount(@Param("inventoryWarningDto") InventoryWarningDto inventoryWarningDto);

    /**
     *
     * @param partsCd
     * @param goodsName
     * @return
     */
     List<ProductionOrderGoods> selectProductionOrderGoodsList(@Param("partsCd") String partsCd,@Param("goodsName") String goodsName);

    /**
     *
     * @param partsCd
     * @param goodsName
     * @return
     */
     int selectProductionOrderGoodsCount(@Param("partsCd") String partsCd,@Param("goodsName") String goodsName);

    /**
     * 根据部品CD查询货物是否存在
     * @param partsCd
     * @return
     */
     Goods selectGoodsByPartsCd(@Param("partsCd") String partsCd);

    /**
     * 采购单价根据货物id修改aPrice(进货价)的值
     * @param goodsId
     * @param purchasePrice
     */
    void updateAPriceByGoodsId(@Param("goodsId") Integer goodsId,@Param("purchasePrice") BigDecimal purchasePrice);

    /**
     * 根据货物编号获取货物信息
     * @param goodsNumber
     * @return
     */
    Goods selectGoodsInfoByGoodsNumber(@Param("goodsNumber") String goodsNumber);


    /**
     * 更新货物信息
     * @param pdaGoodsDto
     */
    void updateGoods(@Param("pdaGoodsDto") PDAGoodsDto pdaGoodsDto);

    /**
     * 修改货物的打印状态
     * @param goodsId
     * @param isPrint
     */
    void updateGoodsPrintByGoodsId(@Param("goodsId") int goodsId,@Param("isPrint") int isPrint,@Param("printNumber") int printNumber);

    /**
     * 获取打印的货物信息
     * @return
     */
    Goods selectGoodsPrint();

    /**
     * 插入货物集合
     * @param goodsList
     */
    void insertList(@Param("goodsList") List<Goods> goodsList);

    /**
     * 根据供应商Id获取货物列表
     * @param supplierId
     * @return
     */
    List<Goods> selectGoodsListBySupplierId(@Param("supplierId") int supplierId);

    /**
     * 获取材料需求清单列表
     * @param materialRequirements
     * @return
     */
    List<MaterialRequirements> selectMaterialRequirementList(@Param("materialRequirements") MaterialRequirements materialRequirements);

    /**
     * 货物一键打印
     */
    void updateGoodsPrint();

    /**
     * 修改货物集合
     * @param goodsList
     */
    void updateList(@Param("goodsList") List<Goods> goodsList);
}