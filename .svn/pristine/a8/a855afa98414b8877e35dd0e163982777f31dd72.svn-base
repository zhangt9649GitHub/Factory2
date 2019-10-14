package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.FactoryManagement;
import com.mingyuansoftware.aifactory.model.dto.FactoryManagementDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FactoryManagementMapper {
    int deleteByPrimaryKey(Integer fmId);

    int insert(FactoryManagement record);

    FactoryManagement selectByPrimaryKey(Integer fmId);

    List<FactoryManagement> selectAll();

    int updateByPrimaryKey(FactoryManagement record);

    /**
     * 获取所属工厂管理列表
     * @param factoryManagementDto
     * @return
     */
    List<FactoryManagementDto> selectFactoryManagementList(@Param("factoryManagementDto") FactoryManagementDto factoryManagementDto);

    /**
     * 获取所属工厂管理列表总条数
     * @param factoryManagementDto
     * @return
     */
    int selectCount(@Param("factoryManagementDto") FactoryManagementDto factoryManagementDto);

    /**
     * 根据Id逻辑删除所属工厂管理
     * @param fmId
     * @return
     */
    int updateByFmId(@Param("fmId") int fmId);

}