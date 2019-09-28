/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: SupplierService
 * Author:   EDZ
 * Date:     2019/6/29 10:08
 * Description: 供应商管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.Supplier;
import com.mingyuansoftware.aifactory.model.dto.SupplierDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈供应商管理〉
 *
 * @author EDZ
 * @create 2019/6/29
 * @since 1.0.0
 */
public interface SupplierService {

    LayuiCommonResponse insert(Supplier supplier);

    LayuiCommonResponse delete(int id);

    LayuiCommonResponse getByid(int id);

    LayuiCommonResponse update(Supplier supplier);

    LayuiCommonResponse getAll();

    LayuiCommonResponse getByPage(int page, int limit,  SupplierDto supplierDto);

    /**
     * 获取供应商姓名列表
     * @return
     */
    List<Supplier> getSupplierNameList();

}
