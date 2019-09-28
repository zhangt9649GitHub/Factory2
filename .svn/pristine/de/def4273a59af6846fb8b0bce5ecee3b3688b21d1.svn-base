package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.BomFormDetail;
import com.mingyuansoftware.aifactory.model.dto.BomFormGoodsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface BomFormDetailMapper {
    int deleteByPrimaryKey(Integer bomDetailId);

    int insert(BomFormDetail record);

    BomFormDetail selectByPrimaryKey(Integer bomDetailId);

    List<BomFormDetail> selectAll();

    int updateByPrimaryKey(BomFormDetail record);

    /**
     * 根据id查询bom详情表信息
     * @param bomId
     * @return
     */
    List<BomFormDetail> selectBomFormDetailById(@Param("bomId") int bomId);

    /**
     * 根据bomid删除bom表单详情中的数据
     * @param bomId
     */
    void deleteBomFormDetails(@Param("bomId") int bomId);

    /**
     * 修改货物配料配比
     * @param quantity
     * @param bomDetailId
     */
    void updateQuantity(@Param("quantity") BigDecimal quantity,@Param("bomDetailId") int bomDetailId);

    BomFormDetail selectBomFormDetailByGoodsId(@Param("bomId") int bomId,@Param("goodsId") int goodsId);

    /**
     * 批量添加bom表单详情集合
     * @param bomFormDetailList
     */
    void insertList(@Param("bomFormDetailList") List<BomFormDetail> bomFormDetailList );


}