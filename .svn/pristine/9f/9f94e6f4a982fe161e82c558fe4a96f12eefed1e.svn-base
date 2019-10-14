package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.DispatchingCompany;
import com.mingyuansoftware.aifactory.model.dto.DispatchingCompanyDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张婷
 * @date 2019/10/14 10:26
 */

@Service
public interface DispatchingCompanyService {
    /**
     * 获取人员派遣公司管理列表
     * @param dispatchingCompanyDto
     * @return
     */
    List<DispatchingCompanyDto> selectDispatchingCompanyList(DispatchingCompanyDto dispatchingCompanyDto);

    /**
     * 获取人员派遣公司管理列表总条数
     * @param dispatchingCompanyDto
     * @return
     */
    int selectCount(DispatchingCompanyDto dispatchingCompanyDto);

    /**
     * 新增人员派遣公司管理
     * @param dispatchingCompany
     * @return
     */
    int insertDispatchingCompany(DispatchingCompany dispatchingCompany);

    /**
     * 删除人员派遣公司管理
     * @param dcId
     * @return
     */
    int deleteDispatchingCompany(int dcId);

    /**
     * 通过id获取人员派遣公司管理信息
     * @param dcId
     * @return
     */
    DispatchingCompany selectDispatchingCompanyById(int dcId);

    /**
     * 更新人员派遣公司管理
     * @param dispatchingCompany
     * @return
     */
    int updateDispatchingCompany(DispatchingCompany dispatchingCompany);
}
