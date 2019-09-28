/**
 * Copyright (C), 2019-2019, 天津斯睿曼科技有限公司
 * FileName: ReimburseServiceImpl
 * Author:   EDZ
 * Date:     2019/7/10 17:53
 * Description: 报销单
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.ReimburseDetailsMapper;
import com.mingyuansoftware.aifactory.mapper.ReimburseMapper;
import com.mingyuansoftware.aifactory.model.Reimburse;
import com.mingyuansoftware.aifactory.model.ReimburseDetails;
import com.mingyuansoftware.aifactory.model.dto.ReimburseDto;
import com.mingyuansoftware.aifactory.service.ReimburseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈报销单〉
 *
 * @author EDZ
 * @create 2019/7/10
 * @since 1.0.0
 */
@Service
public class ReimburseServiceImpl implements ReimburseService {

    @Resource
    private ReimburseMapper reimburseMapper;
    @Resource
    private ReimburseDetailsMapper reimburseDetailsMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer reimburseId) {
        return reimburseMapper.deleteByPrimaryKey(reimburseId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Reimburse record) {
        byte isDelete=0;
        record.setIsDelete(isDelete);
        record.setState((byte) 1);
        record.setCreateTime(new Date());
        int insert = reimburseMapper.insert(record);
        List<ReimburseDetails> reimburseDetails = record.getReimburseDetails();
        for (int i = 0; i < reimburseDetails.size(); i++) {
            ReimburseDetails reimburseDetail = reimburseDetails.get(i);
            reimburseDetail.setReimburseId(record.getReimburseId());
            reimburseDetailsMapper.insert(reimburseDetail);
        }
        return insert;
    }

    @Override
    public Reimburse selectByPrimaryKey(Integer reimburseId) {
        Reimburse reimburse = reimburseMapper.selectByPrimaryKey(reimburseId);
        List<ReimburseDetails> reimburseDetails = reimburseDetailsMapper.selectByPrimaryKey(reimburseId);
        reimburse.setReimburseDetails(reimburseDetails);
        return reimburse;
    }

    @Override
    public List<Reimburse> selectAll( ReimburseDto reimburseDto) {
        return reimburseMapper.selectAll(reimburseDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateByPrimaryKey(Reimburse record) {
        record.setUpdateTime(new Date());
        reimburseMapper.updateByPrimaryKey(record);
        reimburseDetailsMapper.deleteByPrimaryKey(record.getReimburseId());
        List<ReimburseDetails> reimburseDetails = record.getReimburseDetails();
        for (int i = 0; i < reimburseDetails.size(); i++) {
            ReimburseDetails reimburseDetail = reimburseDetails.get(i);
            reimburseDetail.setReimburseId(record.getReimburseId());
            reimburseDetailsMapper.insert(reimburseDetail);
        }
    }

    @Override
    public List<Reimburse> selectReimburseByStaffId(int staffId) {
        try {
            List<Reimburse> reimburseList = reimburseMapper.selectListByStaffId(staffId);
            for(Reimburse reimburse:reimburseList){
                List<ReimburseDetails> reimburseDetails =reimburseDetailsMapper.selectByPrimaryKey(reimburse.getReimburseId());
                reimburse.setReimburseDetails(reimburseDetails);
            }
            return reimburseList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
