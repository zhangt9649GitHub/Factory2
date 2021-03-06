package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.Picking;
import com.mingyuansoftware.aifactory.model.dto.PickingDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PickingMapper {


    int deleteByPrimaryKey(Integer pickingId);


    int insert(Picking record);


    Picking selectByPrimaryKey(Integer pickingId);


    List<Picking> selectAll();


    int updateByPrimaryKey(Picking record);

    /**
     * 获取领料单列表
     * @param pickingDto
     * @return
     */
    List<Picking> selectPickingList(@Param("pickingDto") PickingDto pickingDto);

    /**
     * 获取领料单总条数
     * @param pickingDto
     * @return
     */
    int selectCount(@Param("pickingDto") PickingDto pickingDto);

    /**
     * 获取刚刚插入记录的主键id
     * @return
     */
    int selectLastId();

    /**
     * 根据主键id将此条记录改为删除状态
     * @param picking
     */
    void updatePickingById(int picking);

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
     * 修改领料单状态为已领料
     * @param pickingId
     * @param state
     */
    void updatePickingState(@Param("pickingId") int pickingId,@Param("state") int state,@Param("staffId") int staffId);

    /**
     * 更新状态为已完成
     * @param pickingId
     * @param state
     */
    void updatePickingStateById(@Param("pickingId") int pickingId,@Param("state") int state);

    /**
     * 修改领料单出入库仓库Id
     * @param pickingId
     * @param intoWarehouseId
     * @param outWarehouseId
     */
    void updateWarehouseById(@Param("pickingId") int pickingId,@Param("intoWarehouseId") Integer intoWarehouseId,@Param("outWarehouseId") Integer outWarehouseId);
}