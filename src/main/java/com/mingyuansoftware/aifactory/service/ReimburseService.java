package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.Reimburse;
import com.mingyuansoftware.aifactory.model.dto.ReimburseDto;

import java.util.List;

public interface ReimburseService {
    int deleteByPrimaryKey(Integer reimburseId);


    int insert(Reimburse record);


    Reimburse selectByPrimaryKey(Integer reimburseId);


    List<Reimburse> selectAll(ReimburseDto reimburseDto);


    void updateByPrimaryKey(Reimburse record);

    /**
     * 根据员工Id获取报销单信息(包括编号,金额)
     * @param staffId
     * @return
     */
    List<Reimburse> selectReimburseByStaffId(int staffId);

}
