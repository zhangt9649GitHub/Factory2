package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.RequisitionDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface RequisitionDetailsMapper {


    int deleteByPrimaryKey(Integer requisitionDetailsId);


    int insert(RequisitionDetails record);


    RequisitionDetails selectByPrimaryKey(Integer requisitionDetailsId);


    List<RequisitionDetails> selectAll();


    int updateByPrimaryKey(RequisitionDetails record);

    List<RequisitionDetails> selectRequisitionDetailsById(@Param("requisitionId") int requisitionId);

    void deleteRequisitionDetails(@Param("requisitionId") int requisitionId);
}