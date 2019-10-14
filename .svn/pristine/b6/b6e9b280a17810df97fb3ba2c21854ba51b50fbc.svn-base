package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.DispatchingCompany;
import com.mingyuansoftware.aifactory.model.dto.DispatchingCompanyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DispatchingCompanyMapper {
    int deleteByPrimaryKey(Integer dcId);

    int insert(DispatchingCompany record);

    DispatchingCompany selectByPrimaryKey(Integer dcId);

    List<DispatchingCompany> selectAll();

    int updateByPrimaryKey(DispatchingCompany record);

    /**
     * 获取人员派遣公司管理列表
     * @param dispatchingCompanyDto
     * @return
     */
    List<DispatchingCompanyDto> selectDispatchingCompanyList(@Param("dispatchingCompanyDto") DispatchingCompanyDto dispatchingCompanyDto);

    /**
     * 获取人员派遣公司管理列表总条数
     * @param dispatchingCompanyDto
     * @return
     */
    int selectCount(@Param("dispatchingCompanyDto") DispatchingCompanyDto dispatchingCompanyDto);

    /**
     * 根据Id逻辑删除人员派遣公司管理
     * @param dcId
     * @return
     */
    int updateByDcId(@Param("dcId") int dcId);
}