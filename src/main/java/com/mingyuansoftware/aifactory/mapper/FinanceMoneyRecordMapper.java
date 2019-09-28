package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.FinanceMoneyRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FinanceMoneyRecordMapper {
    int deleteByPrimaryKey(Integer fmid);

    int insert(FinanceMoneyRecord record);

    FinanceMoneyRecord selectByPrimaryKey(Integer fmid);

    List<FinanceMoneyRecord> selectAll();

    int updateByPrimaryKey(FinanceMoneyRecord record);
}