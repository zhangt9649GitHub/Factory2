package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.Requisition;
import com.mingyuansoftware.aifactory.model.dto.RequisitionDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RequisitionMapper {

    int deleteByPrimaryKey(Integer requisitionId);


    int insert(Requisition record);


    Requisition selectByPrimaryKey(Integer requisitionId);


    List<Requisition> selectAll();


    int updateByPrimaryKey(Requisition record);

    /**
     * 查询调拨单列表
     * @return
     */
    List<Requisition> selectRequisitionList(@Param("requisitionDto") RequisitionDto requisitionDto);

    /**
     * 获取调拨单总条数
     * @param requisitionDto
     * @return
     */
    int selectCount(@Param("requisitionDto") RequisitionDto requisitionDto);

    /**
     * 查询刚刚插入的记录id
     * @return
     */
    int selectLastId();

    /**
     * 根据主键id删除记录
     * @param requisitionId
     */
    void updateRequisitionById(@Param("requisitionId") Integer requisitionId);

    /**
     * 根据调拨单id查询调拨单信息
     * @param requisitionId
     * @return
     */
    Requisition selectRequisitionById(@Param("requisitionId") Integer requisitionId);
}