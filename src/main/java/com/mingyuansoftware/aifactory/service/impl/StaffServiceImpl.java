package com.mingyuansoftware.aifactory.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mingyuansoftware.aifactory.enums.WlCode;
import com.mingyuansoftware.aifactory.mapper.AdjustRecordMapper;
import com.mingyuansoftware.aifactory.mapper.StaffInsuranceMapper;
import com.mingyuansoftware.aifactory.mapper.StaffMapper;
import com.mingyuansoftware.aifactory.model.AdjustRecord;
import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.StaffInsurance;
import com.mingyuansoftware.aifactory.model.dto.StaffDto;
import com.mingyuansoftware.aifactory.pojo.LayuiCommonResponse;
import com.mingyuansoftware.aifactory.service.StaffService;
import com.mingyuansoftware.aifactory.util.MD5Util;
import com.mingyuansoftware.aifactory.util.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈1〉
 *
 * @author EDZ
 * @create 2019/6/27
 * @since 1.0.0
 */
@Service
public class StaffServiceImpl implements StaffService{

    @Resource
    private StaffMapper staffMapper;
    @Resource
    private AdjustRecordMapper adjustRecordMapper;
    @Autowired
    private StaffInsuranceMapper staffInsuranceMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public LayuiCommonResponse insert(Staff record) {

            List<Staff> staffList = staffMapper.selectAll();
            for (Staff staff:staffList
                 ) {
                if(record.getJobNumber().equals(staff.getJobNumber())){
                    throw new MyException("新增失败,此工号已存在");
                }
            }
            byte isDelete=0;
            record.setIsDelete(isDelete);
            record.setPassword(MD5Util.encrypt("123456"));
            int insert = staffMapper.insert(record);
            //如果有社保
            if(record.getIssocial()==1){
                StaffInsurance staffInsurance =record.getStaffInsurance();
                staffInsurance.setStaffId(record.getStaffId());
                staffInsuranceMapper.insert(staffInsurance);
            }

            return new LayuiCommonResponse(WlCode.SUCCESS_INSERT,insert,record);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LayuiCommonResponse delete(int id) {

            staffMapper.deleteByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_DELETE,0,"");

    }

    @Override
    public List<Staff> getName() {
        return staffMapper.selectName();
    }

    @Override
    public LayuiCommonResponse getByid(int id) {
        try {
            Staff staff = staffMapper.selectByPrimaryKey(id);
            //如果有社保
            if(staff.getIssocial() != null){
                if(staff.getIssocial()==1){
                    StaffInsurance staffInsurance = staffInsuranceMapper.selectByStaffId(id);
                    staff.setStaffInsurance(staffInsurance);
                }
            }
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,0,staff);
        }catch (Exception e){
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LayuiCommonResponse update(Staff record) {

            Staff staff = staffMapper.selectByPrimaryKey(record.getStaffId());
            if(!(record.getJobNumber().equals(staff.getJobNumber()))){
                List<Staff> staffList = staffMapper.selectAll();
                for (Staff staff1:staffList
                ) {
                    if(record.getJobNumber().equals(staff1.getJobNumber())){
                        throw new MyException("编辑失败,此工号已存在");
                    }
                }
            }
            if (staff.getDepartment().equals(record.getDepartment())&&staff.getPost().equals(record.getPost())){
                staffMapper.updateByPrimaryKey(record);
            }else {

                AdjustRecord adjust =new AdjustRecord();
            adjust.setStaffId(staff.getStaffId());
            adjust.setCreatetime(new Date());
            adjust.setDept(staff.getDepartment());
            adjust.setJob(staff.getPost());
            adjustRecordMapper.insert(adjust);
            staffMapper.updateByPrimaryKey(record);
        }
           //如果有社保
            if(record.getIssocial()==1){
                StaffInsurance staffInsurance1 =staffInsuranceMapper.selectByStaffId(record.getStaffId());
                StaffInsurance staffInsurance =record.getStaffInsurance();
                staffInsurance.setStaffId(record.getStaffId());
                if(staffInsurance1!=null){
                    staffInsuranceMapper.updateByPrimaryKey(staffInsurance);
                }else{
                    staffInsuranceMapper.insert(staffInsurance);
                }
            }else if(record.getIssocial()== 0){
                staffInsuranceMapper.deleteByStaffId(record.getStaffId());
            }
            return new LayuiCommonResponse(WlCode.SUCCESS_UPDAE,0,"");

    }

    @Override
    public LayuiCommonResponse getAll() {
        try {
            List<Staff> list = staffMapper.selectAll();

            return new LayuiCommonResponse(WlCode.SUCCESS_GET, list.size(),list);
        }catch (Exception e){
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }

    @Override
    public LayuiCommonResponse getByPage(int page, int limit, StaffDto staffDto) {

        try {
            PageHelper.startPage(page, limit);
            List<Staff> list = staffMapper.selectByPage(staffDto);
            Page<Staff> page1= (Page<Staff>) list;

            List<Staff> result = page1.getResult();

            return new LayuiCommonResponse(WlCode.SUCCESS_GET, (int) page1.getTotal(), result);

        }catch (Exception e){
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }

    }

    @Override
    public LayuiCommonResponse getAdjust(int id) {
        try {
            List<AdjustRecord> adjustRecords = adjustRecordMapper.selectByPrimaryKey(id);
            return new LayuiCommonResponse(WlCode.SUCCESS_GET,adjustRecords.size(),adjustRecords);
        }catch (Exception e){
            return new LayuiCommonResponse(WlCode.FAIL_GET,0,"");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updatePasswd(int id) {
        Staff staff = new Staff();
        staff.setStaffId(id);
        staff.setPassword(MD5Util.encrypt("123456"));
        return staffMapper.updatePasswd(staff);
    }

    @Override
    public Staff selectStaffIdByNumber(String jobNumber) {
        try{
            return staffMapper.selectStaffIdByNumber(jobNumber);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
