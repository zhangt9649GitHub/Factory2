package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.InventoryCheckGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
@Mapper
public interface InventoryCheckGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_check_goods
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer inventoryCheckGoodsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_check_goods
     *
     * @mbggenerated
     */
    int insert(InventoryCheckGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_check_goods
     *
     * @mbggenerated
     */
    List<InventoryCheckGoods> selectByPrimaryKey(Integer inventoryCheckGoodsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_check_goods
     *
     * @mbggenerated
     */
    List<InventoryCheckGoods> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory_check_goods
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(InventoryCheckGoods record);

    /**
     * 根据盘点详情id添加盘点人,盘点数量
     * @param staffId
     * @param inventoryCheckGoodsId
     * @param inventoryQuantity
     */
    void updateInventoryCheckGoodsState(@Param("staffId") Integer staffId, @Param("inventoryCheckGoodsId") Integer inventoryCheckGoodsId, @Param("inventoryQuantity") BigDecimal inventoryQuantity);

    /**
     * 根据盘点详情id查询盘点信息
     * @param inventoryCheckGoodsId
     * @return
     */
    InventoryCheckGoods selectById(@Param("inventoryCheckGoodsId") Integer inventoryCheckGoodsId);

    /**
     * 修改盘盈数量和盘亏数量
     * @param inventoryCheckGoods
     */
    void updateInventorCheckQuantity(@Param("inventoryCheckGoods") InventoryCheckGoods inventoryCheckGoods);

    /**
     * 根据货物id和盘点单id查询盘点单详情id
     * @param inventoryCheckId
     * @param goodsId
     * @return
     */
    Integer selectInventoryCheckGoodsId(@Param("inventoryCheckId") Integer inventoryCheckId,@Param("goodsId") Integer goodsId);

    /**
     * 根据货物Id查询库存表中的盘点的货物的库存数量
     * @param goodsId
     * @return
     */
    InventoryCheckGoods selectQuantityByGId(@Param("goodsId") Integer goodsId,@Param("warehouseId") Integer warehouseId);
}