package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.RequisitionDetailsMapper;
import com.mingyuansoftware.aifactory.mapper.RequisitionMapper;
import com.mingyuansoftware.aifactory.mapper.StorageAccessMapper;
import com.mingyuansoftware.aifactory.model.Requisition;
import com.mingyuansoftware.aifactory.model.RequisitionDetails;
import com.mingyuansoftware.aifactory.model.StorageAccess;
import com.mingyuansoftware.aifactory.model.dto.RequisitionDto;
import com.mingyuansoftware.aifactory.model.dto.RequisitionGoodsDto;
import com.mingyuansoftware.aifactory.model.dto.StaffUserLoginDto;
import com.mingyuansoftware.aifactory.service.RequisitionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RequisitionServiceImpl implements RequisitionService {

    @Autowired
    private RequisitionMapper requisitionMapper;
    @Autowired
    private StorageAccessMapper storageAccessMapper;
    @Autowired
    private RequisitionDetailsMapper requisitionDetailsMapper;

    @Override
    public List<Requisition> selectRequisitionList(RequisitionDto requisitionDto) {
        try{
            return requisitionMapper.selectRequisitionList(requisitionDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCount(RequisitionDto requisitionDto) {
        try{
          return requisitionMapper.selectCount(requisitionDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<RequisitionGoodsDto> selectRequisitionGoodsList(int warehouseId) {
        try{
            //在入库单内根据仓库id查询货物列表
           return storageAccessMapper.selectInventoryGoodsList(warehouseId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectRequisitionGoodsCount(int warehouseId) {
        try{
            //在入库单内根据仓库id查询货物列表数量
            return storageAccessMapper.selectInventoryGoodsCount(warehouseId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertRequisition(Requisition requisition) {
            requisition.setIsDelete((byte)0);
            requisition.setCreateTime(new Date());
          /*  Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
                int staffId = staff.getStaffId();
            requisition.setStaffId(staffId);*/
            requisitionMapper.insert(requisition);
            //获取刚刚插入的记录id
           // Integer requisitionId =requisitionMapper.selectLastId();
            List<RequisitionDetails> requisitionDetailsList =requisition.getRequisitionDetailsList();
            if(!(requisitionDetailsList.isEmpty())){
                for (RequisitionDetails requisitionDetails:requisitionDetailsList
                ) {
                    requisitionDetails.setRequisitionId(requisition.getRequisitionId());
                    requisitionDetailsMapper.insert(requisitionDetails);
                }
            }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRequisitionById(int requisitionId) {
        requisitionMapper.updateRequisitionById(requisitionId);
    }

    @Override
    public Requisition selectRequisitionById(int requisitionId) {
        try{
            Requisition requisition = requisitionMapper.selectRequisitionById(requisitionId);
            List<RequisitionDetails> requisitionDetailsList =requisitionDetailsMapper.selectRequisitionDetailsById(requisitionId);
            requisition.setRequisitionDetailsList(requisitionDetailsList);
            return requisition;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateRequisitionInfo(Requisition requisition) {
            Requisition requisition1 = requisitionMapper.selectRequisitionById(requisition.getRequisitionId());
            requisition.setIsDelete(requisition1.getIsDelete());
            requisition.setCreateTime(requisition1.getCreateTime());
            requisition.setRequisitionNumber(requisition1.getRequisitionNumber());
            requisition.setUpdateTime(new Date());
            requisitionMapper.updateByPrimaryKey(requisition);
            //先将数据库中调拨单货物详情删除
            requisitionDetailsMapper.deleteRequisitionDetails(requisition.getRequisitionId());
            //遍历新增修改后的调拨单货物详情
            List<RequisitionDetails> requisitionDetailsList =requisition.getRequisitionDetailsList();
            for (RequisitionDetails requisitionDetails:requisitionDetailsList
            ) {
                requisitionDetails.setRequisitionId(requisition.getRequisitionId());
                requisitionDetails.setGoodsId(requisitionDetails.getGoods().getGoodsId());
                requisitionDetailsMapper.insert(requisitionDetails);
            }
    }
}
