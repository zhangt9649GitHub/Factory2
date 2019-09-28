package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.Config;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface ConfigMapper {

    int deleteByPrimaryKey(Integer configId);

    int insert(Config record);

    Config selectByPrimaryKey(Integer configId);

    List<Config> selectAll();

    int updateByPrimaryKey(Config record);

    Config selectByKey(String key);
}