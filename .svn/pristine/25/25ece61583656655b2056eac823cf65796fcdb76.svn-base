package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.FactoryManagement;
import com.mingyuansoftware.aifactory.model.dto.FactoryManagementDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张婷
 * @date 2019/10/14 13:52
 */

@Service
public interface FactoryManagementService {
    /**
     * 获取所属工厂管理列表
     * @param factoryManagementDto
     * @return
     */
    List<FactoryManagementDto> selectFactoryManagementList(FactoryManagementDto factoryManagementDto);

    /**
     * 获取所属工厂管理列表总条数
     * @param factoryManagementDto
     * @return
     */
    int selectCount(FactoryManagementDto factoryManagementDto);

    /**
     * 新增所属工厂管理
     * @param factoryManagement
     * @return
     */
    int insertFactoryManagement(FactoryManagement factoryManagement);

    /**
     * 删除所属工厂管理
     * @param fmId
     * @return
     */
    int deleteFactoryManagement(int fmId);

    /**
     * 通过Id获取所属工厂管理
     * @param fmId
     * @return
     */
    FactoryManagement selectFactoryManagementById(int fmId);

    /**
     * 更新人员派遣公司管理
     * @param factoryManagement
     * @return
     */
    int updateFactoryManagement(FactoryManagement factoryManagement);
}
