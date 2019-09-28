package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface LogMapper {

    int deleteByPrimaryKey(Integer logId);


    int insert(Log record);


    Log selectByPrimaryKey(Integer logId);


    List<Log> selectAll();

    int updateByPrimaryKey(Log record);
}