package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.PayrollDetailsMapper;
import com.mingyuansoftware.aifactory.mapper.PayrollMapper;
import com.mingyuansoftware.aifactory.mapper.StaffInsuranceMapper;
import com.mingyuansoftware.aifactory.mapper.StaffMapper;
import com.mingyuansoftware.aifactory.model.Payroll;
import com.mingyuansoftware.aifactory.model.PayrollDetails;
import com.mingyuansoftware.aifactory.model.Staff;
import com.mingyuansoftware.aifactory.model.StaffInsurance;
import com.mingyuansoftware.aifactory.model.dto.PayrollDto;
import com.mingyuansoftware.aifactory.service.PayrollService;
import com.mingyuansoftware.aifactory.util.DateUtil;
import com.mingyuansoftware.aifactory.util.MyException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollMapper payrollMapper;
    @Autowired
    private PayrollDetailsMapper payrollDetailsMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private StaffInsuranceMapper staffInsuranceMapper;


    @Override
    public List<Payroll> selectPayrollList(PayrollDto payrollDto) {
        try {
            return payrollMapper.selectPayrollList(payrollDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCountPayrollList(PayrollDto payrollDto) {
        try {
           return payrollMapper.selectCountPayrollList(payrollDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<PayrollDetails> importPayrollExcel(String fileName, MultipartFile file) {
        List<PayrollDetails> payrollDetailsList = new ArrayList<>();
     /*   //几年工资
        String year =null;
        //几月工资
        String month =null;*/
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        try{
            Workbook wb = null;
            Set<Sheet> sheets = null;
            InputStream is = file.getInputStream();
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {
                wb = new XSSFWorkbook(is);
            }
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {//获取每个Sheet表
                Sheet sheet = wb.getSheetAt(i);
                String sheetName = sheet.getSheetName();
                int a =  sheet.getPhysicalNumberOfRows();
                if(sheetName.indexOf("计时")!=-1){
                   /* if(year==null&&month==null){
                        Row row1 = sheet.getRow(0);
                        row1.getCell(0).setCellType(HSSFCell.CELL_TYPE_STRING);
                        String years = row1.getCell(0).getStringCellValue();
                        String[] strs = years.split("月");
                        String years1 =strs[0].substring(strs[0].length()-6,strs[0].length());
                        String[] strs1 =years1.split(".");
                        year =strs1[0];
                        month =strs1[1];
                    }*/
                    //循环工作表Sheet
                    for (int r = 2; r <= sheet.getLastRowNum(); r++) {
                        Row row = sheet.getRow(r);
                        if (row == null) {
                            //如果是空行（即没有任何数据、格式），直接把它以下的数据往上移动
                            sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
                            continue;

                        }
                        try {
                            row.getCell(0).setCellType(HSSFCell.CELL_TYPE_STRING);
                        }catch (Exception e){
                            continue;
                        }
                        String jobNumber = row.getCell(0).getStringCellValue();
                        if(jobNumber==null||(jobNumber.equals(""))){
                            continue;
                        }
                        row.getCell(1).setCellType(HSSFCell.CELL_TYPE_STRING);
                        String name = row.getCell(1).getStringCellValue();
                        row.getCell(28).setCellType(HSSFCell.CELL_TYPE_STRING);
                        String basicTiming = row.getCell(28).getStringCellValue();
                            //如果不为空，如果已有sheet表加入了
                            if(payrollDetailsList!=null){
                                boolean flag = true;
                                for (PayrollDetails payrollDetails:payrollDetailsList
                                ) {
                                    if(jobNumber.indexOf(payrollDetails.getOperationPermitNo())!=-1){
                                        payrollDetails.setBasicTiming(new BigDecimal(basicTiming).setScale(0, BigDecimal.ROUND_HALF_UP ));
                                        flag = false;
                                    }
                                }
                                if(flag){
                                    PayrollDetails payrollDetails = new PayrollDetails();
                                    payrollDetails.setOperationPermitNo(jobNumber);
                                    payrollDetails.setName(name);
                                    payrollDetails.setBasicTiming(new BigDecimal(basicTiming).setScale(0, BigDecimal.ROUND_HALF_UP ));
                                    payrollDetailsList.add(payrollDetails);
                                }
                            }else{
                                //如果为空，需要按第一张sheet加入
                                PayrollDetails payrollDetails = new PayrollDetails();
                                payrollDetails.setOperationPermitNo(jobNumber);
                                payrollDetails.setName(name);
                                payrollDetails.setBasicTiming(new BigDecimal(basicTiming).setScale(0, BigDecimal.ROUND_HALF_UP ));
                                payrollDetailsList.add(payrollDetails);
                            }

                        }

                }else if(sheetName.indexOf("计件")!=-1){
                    //循环工作表Sheet
                    for (int r = 1; r < sheet.getLastRowNum(); r++) {

                        Row row = sheet.getRow(r);
                        if (row == null) {
                            continue;
                        }
                        int line = r + 1;
                        try {
                            row.getCell(4).setCellType(HSSFCell.CELL_TYPE_STRING);
                        }catch (Exception e){
                            continue;
                        }
                        String jobNumber = row.getCell(4).getStringCellValue();
                        if (jobNumber.equals("")||(jobNumber.equals(""))) {
                            continue;
                        }
                        row.getCell(5).setCellType(HSSFCell.CELL_TYPE_STRING);
                        String name = row.getCell(5).getStringCellValue();
                        row.getCell(16).setCellType(HSSFCell.CELL_TYPE_STRING);
                        String pieces = row.getCell(16).getStringCellValue();
                        row.getCell(18).setCellType(HSSFCell.CELL_TYPE_STRING);
                        String basicWage = row.getCell(18).getStringCellValue();
                            //如果不为空，如果已有sheet表加入了
                            if (payrollDetailsList != null) {
                                boolean flag = true;
                                for (PayrollDetails payrollDetails : payrollDetailsList
                                ) {
                                    if (jobNumber.indexOf(payrollDetails.getOperationPermitNo()) != -1) {
                                        if (payrollDetails.getPieces() == null) {
                                            if (pieces != null&&!(pieces.equals(""))) {
                                                payrollDetails.setPieces(Integer.parseInt(pieces));
                                                payrollDetails.setBasicWage(new BigDecimal(Double.parseDouble(basicWage)));
                                            }

                                        } else {
                                            if (pieces != null&&!(pieces.equals(""))) {
                                                payrollDetails.setPieces(payrollDetails.getPieces() + Integer.parseInt(pieces));
                                                payrollDetails.setBasicWage(payrollDetails.getBasicWage().add(new BigDecimal(Double.parseDouble(basicWage))));
                                            }
                                        }
                                        flag = false;
                                    }
                                }
                                if (flag) {
                                    PayrollDetails payrollDetails = new PayrollDetails();
                                    payrollDetails.setOperationPermitNo(jobNumber);
                                    payrollDetails.setName(name);
                                    if (payrollDetails.getPieces() == null) {
                                        if (payrollDetails.getPieces() == null) {
                                            if (pieces != null&&!(pieces.equals(""))) {
                                                payrollDetails.setPieces(Integer.parseInt(pieces));
                                                payrollDetails.setBasicWage(new BigDecimal(Double.parseDouble(basicWage)));
                                            }

                                        } else {
                                            if (pieces != null&&!(pieces.equals(""))) {
                                                payrollDetails.setPieces(payrollDetails.getPieces() + Integer.parseInt(pieces));
                                                payrollDetails.setBasicWage(payrollDetails.getBasicWage().add(new BigDecimal(Double.parseDouble(basicWage))));
                                            }
                                        }
                                        payrollDetailsList.add(payrollDetails);
                                }
                            }
                            }else {
                                //如果为空，需要按第一张sheet加入
                                PayrollDetails payrollDetails = new PayrollDetails();
                                payrollDetails.setOperationPermitNo(jobNumber);
                                payrollDetails.setName(name);
                                if (payrollDetails.getPieces() == null) {
                                    if (pieces != null&&!(pieces.equals(""))) {
                                        payrollDetails.setPieces(Integer.parseInt(pieces));
                                        payrollDetails.setBasicWage(new BigDecimal(Double.parseDouble(basicWage)));
                                    }

                                } else {
                                    if (pieces != null&&!(pieces.equals(""))) {
                                        payrollDetails.setPieces(payrollDetails.getPieces() + Integer.parseInt(pieces));
                                        payrollDetails.setBasicWage(payrollDetails.getBasicWage().add(new BigDecimal(Double.parseDouble(basicWage))));
                                    }
                                }
                                payrollDetailsList.add(payrollDetails);
                            }

                    }
                }else if(sheetName.indexOf("一厂考勤")!=-1){
                    //循环工作表Sheet
                    for (int r = 3; r < sheet.getLastRowNum(); r++) {
                        Row row = sheet.getRow(r);
                        if (row == null) {
                            //如果是空行（即没有任何数据、格式），直接把它以下的数据往上移动
                            sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
                            continue;
                        }
                        try {
                            row.getCell(1).setCellType(HSSFCell.CELL_TYPE_STRING);
                        }catch (Exception e){
                            continue;
                        }
                        String jobNumber = row.getCell(1).getStringCellValue();
                        if(jobNumber.equals("")||(jobNumber.equals(""))){
                            continue;
                        }
                        row.getCell(2).setCellType(HSSFCell.CELL_TYPE_STRING);
                        String name = row.getCell(2).getStringCellValue();
                        row.getCell(66).setCellType(HSSFCell.CELL_TYPE_STRING);
                        String attendanceDays = row.getCell(66).getStringCellValue();
                            //如果不为空，如果已有sheet表加入了
                            if(payrollDetailsList!=null){
                                boolean flag = true;
                                for (PayrollDetails payrollDetails:payrollDetailsList
                                ) {
                                    if(jobNumber.indexOf(payrollDetails.getOperationPermitNo())!=-1){
                                        payrollDetails.setAttendanceDays(new BigDecimal(Float.parseFloat(attendanceDays)).setScale(1,BigDecimal.ROUND_HALF_UP ).floatValue());
                                        flag = false;
                                        break;
                                    }
                                }
                                if(flag){
                                    PayrollDetails payrollDetails = new PayrollDetails();
                                    payrollDetails.setOperationPermitNo(jobNumber);
                                    payrollDetails.setName(name);
                                    payrollDetails.setAttendanceDays(new BigDecimal(Float.parseFloat(attendanceDays)).setScale(1,BigDecimal.ROUND_HALF_UP ).floatValue());
                                    payrollDetailsList.add(payrollDetails);
                                }
                            }else {
                                //如果为空，需要按第一张sheet加入
                                PayrollDetails payrollDetails = new PayrollDetails();
                                payrollDetails.setOperationPermitNo(jobNumber);
                                payrollDetails.setName(name);
                                payrollDetails.setAttendanceDays(new BigDecimal(Float.parseFloat(attendanceDays)).setScale(1,BigDecimal.ROUND_HALF_UP ).floatValue());
                                payrollDetailsList.add(payrollDetails);
                            }
                        }

                }else if(sheetName.indexOf("二厂考勤")!=-1){
                    //循环工作表Sheet
                    for (int r = 4; r <= sheet.getLastRowNum(); r++) {
                        Row row = sheet.getRow(r);
                        if (row == null) {
                            continue;
                        }
                        int line = r + 1;
                        try {
                            row.getCell(1).setCellType(HSSFCell.CELL_TYPE_STRING);
                        }catch (Exception e){
                            continue;
                        }
                        String jobNumber = row.getCell(1).getStringCellValue();
                        if(jobNumber.equals("")||(jobNumber.equals(""))){
                            continue;
                        }
                        row.getCell(2).setCellType(HSSFCell.CELL_TYPE_STRING);
                        String name = row.getCell(2).getStringCellValue();
                        row.getCell(72).setCellType(HSSFCell.CELL_TYPE_STRING);
                        String attendanceDays = row.getCell(72).getStringCellValue();
                            //如果不为空，如果已有sheet表加入了
                            if(payrollDetailsList!=null){
                                boolean flag = true;
                                for (PayrollDetails payrollDetails:payrollDetailsList
                                ) {
                                    if(jobNumber.indexOf(payrollDetails.getOperationPermitNo())!=-1){
                                        payrollDetails.setAttendanceDays(new BigDecimal(Float.parseFloat(attendanceDays)).setScale(1,BigDecimal.ROUND_HALF_UP ).floatValue());
                                        flag = false;
                                    }
                                }
                                if(flag){
                                    PayrollDetails payrollDetails = new PayrollDetails();
                                    payrollDetails.setOperationPermitNo(jobNumber);
                                    payrollDetails.setName(name);
                                    payrollDetails.setAttendanceDays(new BigDecimal(Float.parseFloat(attendanceDays)).setScale(1,BigDecimal.ROUND_HALF_UP ).floatValue());
                                    payrollDetailsList.add(payrollDetails);
                                }
                            }else {
                                //如果为空，需要按第一张sheet加入
                                PayrollDetails payrollDetails = new PayrollDetails();
                                payrollDetails.setOperationPermitNo(jobNumber);
                                payrollDetails.setName(name);
                                payrollDetails.setAttendanceDays(new BigDecimal(Float.parseFloat(attendanceDays)).setScale(1,BigDecimal.ROUND_HALF_UP ).floatValue());
                                payrollDetailsList.add(payrollDetails);
                            }
                        }
                    }
            }
            List<Staff> staffList = staffMapper.selectAllStaff();
            //如果员工列表不为空
            if(!(staffList.isEmpty())){
                for (Staff staff:staffList
                ) {
                    String jobNumber = staff.getJobNumber();
                    boolean num = true;
                    for (PayrollDetails payrollDetails:payrollDetailsList
                    ) {
                        if(jobNumber.equals(payrollDetails.getOperationPermitNo())){
                            //保险公司
                            if(staff.getInsuranceCompany()!=null){
                                payrollDetails.setInsuranceCompany(staff.getInsuranceCompany());
                            }
                            //管理费
                            if(staff.getManagementFee()!=null){
                                payrollDetails.setManagementFee(staff.getManagementFee());
                            }
                            //岗位津贴
                            if(staff.getPostAllowance()!=null){
                                payrollDetails.setPostAllowance(staff.getPostAllowance());
                            }
                            //伙食扣款
                            if(staff.getFoodDeduction()!=null){
                                payrollDetails.setFoodDeduction(staff.getFoodDeduction());
                            }else{
                                payrollDetails.setFoodDeduction(BigDecimal.ZERO);
                            }
                            //天津工厂扣款
                            if(staff.getTjFactoryDeduction()!=null){
                                payrollDetails.setTjFactoryDeduction(staff.getTjFactoryDeduction());
                            }else{
                                payrollDetails.setTjFactoryDeduction(BigDecimal.ZERO);
                            }
                            //如果有社保
                            if(staff.getIssocial()!=null&&staff.getIssocial()==1){
                                StaffInsurance staffInsurance = staffInsuranceMapper.selectByStaffId(staff.getStaffId());
                                //公积金扣款  个人公积金缴纳+公司公积金缴纳
                                if(staffInsurance!=null && staffInsurance.getPersonalAccumulationFund()!=null){
                                    payrollDetails.setProvidentFundDeduction(staffInsurance.getPersonalAccumulationFund().add(staffInsurance.getCompanyAccumulationFund()));
                                }
                                //保险扣款  个人保险缴纳+公司保险缴纳
                                if(staffInsurance!=null && staffInsurance.getPersonalInsuranceTotal()!=null) {
                                    BigDecimal InsuranceDeduction = staffInsurance.getPersonalInsuranceTotal().add(staffInsurance.getCompanyInsuranceTotal());
                                    //是否加大额260元
                              /*  //1.获取当前月份
                                String month1 = DateUtil.getMonth();
                                //2.其他月份,判断是否是刚刚转正员工，如果是转正月份，也要缴纳260元 ,如果员工满足这种情况就不用判断是否是1月份
                                 if(Integer.valueOf(month1)>1){

                                 }
                                //3.如果是1月份,正式员工有社保的缴纳260元大额*/
                                    payrollDetails.setInsuranceDeduction(InsuranceDeduction);
                                }
                            }else{
                                //公积金扣款
                                payrollDetails.setProvidentFundDeduction(BigDecimal.ZERO);
                                //保险扣款
                                payrollDetails.setInsuranceDeduction(BigDecimal.ZERO);
                            }
                            //扣款小计
                            payrollDetails.setSubtotalDeduction(payrollDetails.getTjFactoryDeduction().add(payrollDetails.getFoodDeduction()).add(payrollDetails.getInsuranceDeduction()).add(payrollDetails.getProvidentFundDeduction()));
                            num = false;
                        }
                        if(num){
                            payrollDetails.setManagementFee(BigDecimal.ZERO);
                            payrollDetails.setPostAllowance(BigDecimal.ZERO);
                            payrollDetails.setFoodDeduction(BigDecimal.ZERO);
                            payrollDetails.setTjFactoryDeduction(BigDecimal.ZERO);
                            //公积金扣款
                            payrollDetails.setProvidentFundDeduction(BigDecimal.ZERO);
                            //保险扣款
                            payrollDetails.setInsuranceDeduction(BigDecimal.ZERO);
                            payrollDetails.setSubtotalDeduction(BigDecimal.ZERO);
                        }
                    }
                    //如果为true,表示导入的工资单内没有此员工
                    if(num){
                        PayrollDetails payrollDetails = new PayrollDetails();
                        payrollDetails.setName(staff.getName());
                        payrollDetails.setOperationPermitNo(staff.getJobNumber());
                        //基本工资 员工已转正
                        if(staff.getIsTurnPositive()==1){
                            //获取转正日期
                          String PositiveTime = staff.getPositiveTime();
                          //如果转正日期大于工资发放周期 按照实习工资发放
                          //如果转正日期小于工资发放周期 按照正式工资发放
                          //如果转正日期在工资发放周期内 进行工资计算
                            if (staff.getBasicSalary() != null) {
                                payrollDetails.setBasicTiming(staff.getBasicSalary());
                            }
                        }else if(staff.getIsTurnPositive()==2){
                            //实习工资
                            if (staff.getTrainSalary() != null) {
                                payrollDetails.setBasicTiming(staff.getTrainSalary());
                            }
                        }
                        //保险公司
                        if (staff.getInsuranceCompany() != null) {
                            payrollDetails.setInsuranceCompany(staff.getInsuranceCompany());
                        }
                        //管理费
                        if (staff.getManagementFee() != null) {
                            payrollDetails.setManagementFee(staff.getManagementFee());
                        }
                        //岗位津贴
                        if (staff.getPostAllowance() != null) {
                            payrollDetails.setPostAllowance(staff.getPostAllowance());
                        }
                        //伙食扣款
                        if (staff.getFoodDeduction() != null) {
                            payrollDetails.setFoodDeduction(staff.getFoodDeduction());
                        } else {
                            payrollDetails.setFoodDeduction(BigDecimal.ZERO);
                        }
                        //天津工厂扣款
                        if (staff.getTjFactoryDeduction() != null) {
                            payrollDetails.setTjFactoryDeduction(staff.getTjFactoryDeduction());
                        } else {
                            payrollDetails.setTjFactoryDeduction(BigDecimal.ZERO);
                        }
                        //如果有社保
                        if (staff.getIssocial() != null && staff.getIssocial() == 1) {
                            StaffInsurance staffInsurance = staffInsuranceMapper.selectByStaffId(staff.getStaffId());
                            //公积金扣款  个人公积金缴纳+公司公积金缴纳
                            if(staffInsurance!=null && staffInsurance.getPersonalAccumulationFund()!=null){
                                payrollDetails.setProvidentFundDeduction(staffInsurance.getPersonalAccumulationFund().add(staffInsurance.getCompanyAccumulationFund()));
                            }
                            //保险扣款  个人保险缴纳+公司保险缴纳
                            if(staffInsurance!=null && staffInsurance.getPersonalInsuranceTotal()!=null) {
                                BigDecimal InsuranceDeduction = staffInsurance.getPersonalInsuranceTotal().add(staffInsurance.getCompanyInsuranceTotal());
                                //是否加大额260元
                                payrollDetails.setInsuranceDeduction(InsuranceDeduction);
                            }
                        } else {
                            //公积金扣款  个人公积金缴纳
                            payrollDetails.setProvidentFundDeduction(BigDecimal.ZERO);
                            //保险扣款  个人保险缴纳
                            payrollDetails.setInsuranceDeduction(BigDecimal.ZERO);
                            }
                            //扣款小计
                        payrollDetails.setSubtotalDeduction(payrollDetails.getTjFactoryDeduction().add(payrollDetails.getFoodDeduction()).add(payrollDetails.getInsuranceDeduction()).add(payrollDetails.getProvidentFundDeduction()));
                        payrollDetailsList.add(payrollDetails);
                        }
                }
            }
           return payrollDetailsList;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertPayroll(Payroll payroll) {
        payroll.setIsDelete((byte)0);
        payroll.setState((byte)1);
        payrollMapper.insert(payroll);
        List<PayrollDetails> payrollDetailsList = payroll.getPayrollDetailsList();
        for (PayrollDetails payrollDetails:payrollDetailsList
             ) {
            payrollDetails.setPayrollId(payroll.getPayrollId());
            //根据员工工号查询员工id
            Staff staff =staffMapper.selectStaffIdByNumber(payrollDetails.getOperationPermitNo());
            if(staff!=null){
                payrollDetails.setStaffId(staff.getStaffId());
            }
            payrollDetailsMapper.insert(payrollDetails);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deletePayrollById(int payrollId) {
        payrollMapper.updatePayrollById(payrollId);

    }

    @Override
    public Payroll selectPayrollById(int payrollId) {
        try{
            Payroll payroll =payrollMapper.selectByPrimaryKey(payrollId);
            List<PayrollDetails> payrollDetailsList =payrollDetailsMapper.selectPayrollDetailsListById(payrollId);
            payroll.setPayrollDetailsList(payrollDetailsList);
            return payroll;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updatePayrollInfo(Payroll payroll) {
        Payroll payroll1 =payrollMapper.selectByPrimaryKey(payroll.getPayrollId());
        payroll.setState(payroll1.getState());
        payroll.setIsDelete(payroll1.getIsDelete());
        payrollMapper.updateByPrimaryKey(payroll);
        List<PayrollDetails> payrollDetailsList1 =payrollDetailsMapper.selectPayrollDetailsListById(payroll.getPayrollId());
        for (PayrollDetails payrollDetails:payrollDetailsList1
             ) {
            payrollDetailsMapper.deleteByPrimaryKey(payrollDetails.getPayrollDetailsId());
        }
        List<PayrollDetails> payrollDetailsList =payroll.getPayrollDetailsList();
        for (PayrollDetails payrollDetails:payrollDetailsList
             ) {
                payrollDetails.setPayrollId(payroll.getPayrollId());
                //根据员工工号查询员工id
                Staff staff =staffMapper.selectStaffIdByNumber(payrollDetails.getOperationPermitNo());
                if(staff!=null){
                    payrollDetails.setStaffId(staff.getStaffId());
                }
                payrollDetailsMapper.insert(payrollDetails);
        }
    }
}
