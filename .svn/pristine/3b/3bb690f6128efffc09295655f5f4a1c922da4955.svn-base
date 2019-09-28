package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.GoodsMapper;
import com.mingyuansoftware.aifactory.mapper.SalesOrderDetailsMapper;
import com.mingyuansoftware.aifactory.mapper.SalesOrderMapper;
import com.mingyuansoftware.aifactory.mapper.StockKucunGoodsMapper;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.SalesOrderDto;
import com.mingyuansoftware.aifactory.service.SalesOrderService;
import com.mingyuansoftware.aifactory.util.DateUtil;
import com.mingyuansoftware.aifactory.util.DoubleUtil;
import com.mingyuansoftware.aifactory.util.MyException;
import com.mingyuansoftware.aifactory.util.RandomCodeUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    @Autowired
    private SalesOrderMapper salesOrderMapper;
    @Autowired
    private SalesOrderDetailsMapper salesOrderDetailsMapper;
    @Autowired
    private StockKucunGoodsMapper stockKucunGoodsMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<SalesOrder> selectSalesOrderList(SalesOrderDto salesOrderDto) {
        try{
            return salesOrderMapper.selectSalesOrderList(salesOrderDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectSalesOrderCount(SalesOrderDto salesOrderDto) {
        try{
            return salesOrderMapper.selectSalesOrderCount(salesOrderDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void deleteSalesOrderById(int salesOrderId) {
        try{
            salesOrderMapper.updateSalesOrderById(salesOrderId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public SalesOrder selectSalesOrderById(int salesOrderId) {
        try{
            SalesOrder salesOrder = salesOrderMapper.selectSalesOrderById(salesOrderId);
            List<SalesOrderDetails> salesOrderDetailsList = salesOrderDetailsMapper.selectSalesOrderDetailsListById(salesOrderId);
            if(!(salesOrderDetailsList.isEmpty())){
                for (SalesOrderDetails salesOrderDetails:salesOrderDetailsList
                ) {
                    KucunGoods kucunGoods = stockKucunGoodsMapper.getStockKucunGoodsCountByGoodsId(salesOrderDetails.getGoods().getGoodsId());
                    if(kucunGoods!=null&&kucunGoods.getSkgCount()!=null){
                        salesOrderDetails.setSkgCount(kucunGoods.getSkgCount());
                    }else{
                        salesOrderDetails.setSkgCount(BigDecimal.ZERO);
                    }

                }
            }
            salesOrder.setSalesOrderDetailsList(salesOrderDetailsList);
            return salesOrder;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertSalesOrder(SalesOrder salesOrder) {
        salesOrder.setCreateTime(new Date());
        salesOrder.setIsDelete((byte)0);
       /* Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
         int staffId = staff.getStaffId();
        salesOrder.setStaffId(staffId);*/
        //订单状态为已创建
        salesOrder.setState((byte)1);
        //回款状态为未回款
        salesOrder.setPaymentStatus((byte)1);
        salesOrder.setAmountReceived(BigDecimal.ZERO);
        salesOrder.setOutstandingAmount(salesOrder.getAmount());
        salesOrderMapper.insert(salesOrder);
        List<SalesOrderDetails> salesOrderDetailsList = salesOrder.getSalesOrderDetailsList();
        if(!(salesOrderDetailsList.isEmpty())){
            for (SalesOrderDetails salesOrderDetails:salesOrderDetailsList
             ) {
                if(!(DoubleUtil.isInteger((salesOrderDetails.getLotNumber())))){
                    throw new MyException("新增失败,批次输入格式不正确");
                }
                salesOrderDetails.setNotOutQuantity(salesOrderDetails.getQuantity());
                salesOrderDetails.setOutQuantity(BigDecimal.ZERO);
                salesOrderDetails.setSalesOrderId(salesOrder.getSalesOrderId());
                salesOrderDetailsMapper.insert(salesOrderDetails);
            }
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateRequisitionInfo(SalesOrder salesOrder) {
        SalesOrder salesOrder1 = salesOrderMapper.selectSalesOrderById(salesOrder.getSalesOrderId());
        salesOrder.setCreateTime(salesOrder1.getCreateTime());
        salesOrder.setIsDelete(salesOrder1.getIsDelete());
        salesOrder.setUpdateTime(new Date());
        salesOrder.setSalesOrderNumber(salesOrder1.getSalesOrderNumber());
        salesOrder.setState(salesOrder1.getState());
        salesOrder.setPaymentStatus(salesOrder1.getPaymentStatus());
        /*Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
         int staffId = staff.getStaffId();
        salesOrder.setStaffId(staffId);*/
        salesOrder.setAmountReceived(BigDecimal.ZERO);
        salesOrder.setOutstandingAmount(salesOrder.getAmount());
        salesOrderMapper.updateByPrimaryKey(salesOrder);
        List<SalesOrderDetails> salesOrderDetailsList1 = salesOrderDetailsMapper.selectSalesOrderDetailsListById(salesOrder.getSalesOrderId());
        for (SalesOrderDetails salesOrderDetails:salesOrderDetailsList1
             ) {
            salesOrderDetailsMapper.deleteByPrimaryKey(salesOrderDetails.getSalesOrderDetailsId());
        }
        List<SalesOrderDetails> salesOrderDetailsList =salesOrder.getSalesOrderDetailsList();
        for (SalesOrderDetails salesOrderDetails:salesOrderDetailsList
             ) {
            salesOrderDetails.setSalesOrderId(salesOrder.getSalesOrderId());
            salesOrderDetails.setNotOutQuantity(salesOrderDetails.getQuantity());
            salesOrderDetails.setOutQuantity(BigDecimal.ZERO);
            salesOrderDetailsMapper.insert(salesOrderDetails);
        }

    }

    @Override
    public List<SalesOrder> selectByCustomerId(Integer customerId) {
        return salesOrderMapper.selectByCustomerId(customerId);
    }

    @Override
    public List<PdaOutBoundGoodsTask> selectPdaOutboundGoodsTaskList() {
        try{
            return salesOrderMapper.selectPdaOutboundGoodsTaskList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectPdaOutboundGoodsTaskListCount() {
        try{
            return salesOrderMapper.selectPdaOutboundGoodsTaskListCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateSalesOrderState(int salesOrderId) {
        //已配货
        int state = 3;
        salesOrderMapper.updateSaleOrderState(salesOrderId,state);
    }

    @Override
    public List<SalesOrder> selectByCustomerId1(int id) {
        return salesOrderMapper.selectByCustomerId1(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importSalesOrder(String fileName, MultipartFile file) {
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        //创建一条销售订单
        SalesOrder salesOrder = new SalesOrder();
        String salesOrderNumber = "02"+ RandomCodeUtil.getRandomCode();
        salesOrder.setSalesOrderNumber(salesOrderNumber);
        salesOrder.setCreateTime(new Date());
        salesOrder.setState((byte)1);
        salesOrder.setPaymentStatus((byte)1);
        salesOrder.setIsDelete((byte)0);
        salesOrder.setAddtime(DateUtil.getDate());
        /*Staff staff =(Staff) SecurityUtils.getSubject().getSession().getAttribute("user");
        int staffId = staff.getStaffId();
        salesOrder.setStaffId(staffId);*/
        //日本出口
        salesOrder.setOrderType((byte)1);
        salesOrderMapper.insert(salesOrder);
        int salesOrderId = salesOrder.getSalesOrderId();
        //总箱数
        int totalBoxesNumber = 0 ;
        //总数量
        BigDecimal totalAmount = new BigDecimal(0);
        //总净重
        BigDecimal totalNetWeight = new BigDecimal(0);
        //总毛重
        BigDecimal totalGrossWeight = new BigDecimal(0);
        //总体积
        BigDecimal totalVolume = new BigDecimal(0);
        //总金额
        BigDecimal amount =  new BigDecimal(0);

        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        try{
            InputStream is = file.getInputStream();
            Sheet sheet = null;
            if (isExcel2003) {
                HSSFWorkbook wb = new HSSFWorkbook(is);
                sheet = wb.getSheetAt(0);
            } else {
                XSSFWorkbook wb = new XSSFWorkbook(is);
                sheet = wb.getSheetAt(0);
            }

            for (int i = 8; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                row.getCell(2).setCellType(HSSFCell.CELL_TYPE_STRING);
                String partsCd = row.getCell(2).getStringCellValue();
                row.getCell(3).setCellType(HSSFCell.CELL_TYPE_STRING);
                String goodsName = row.getCell(3).getStringCellValue();
                row.getCell(13).setCellType(HSSFCell.CELL_TYPE_STRING);
                String lotNumber = row.getCell(13).getStringCellValue();
                row.getCell(14).setCellType(HSSFCell.CELL_TYPE_STRING);
                String returnNumber = row.getCell(14).getStringCellValue();
                row.getCell(16).setCellType(HSSFCell.CELL_TYPE_STRING);
                String notOutQuantity = row.getCell(16).getStringCellValue();
                row.getCell(17).setCellType(HSSFCell.CELL_TYPE_STRING);
                String boxNumber = row.getCell(17).getStringCellValue();
                if(partsCd==null||partsCd.equals("")){
                    break;
                }
                if(notOutQuantity==null||notOutQuantity.equals("")){
                    notOutQuantity="0";
                }
                //总箱数
                if(DoubleUtil.isInteger(boxNumber)){
                    totalBoxesNumber =  totalBoxesNumber+ Integer.valueOf(boxNumber);
                }
                //总数量
                if(DoubleUtil.isInteger(notOutQuantity)|| DoubleUtil.isNumeric(notOutQuantity)){
                    totalAmount = totalAmount.add(BigDecimal.valueOf(Double.parseDouble(notOutQuantity)));
                }

                //获取货物信息
                Goods goods = goodsMapper.selectGoodsByPartsCd(partsCd);
                if(goods==null){
                    goods.setPartsCd(partsCd);
                    goods.setGoodsName(goodsName);
                    goods.setCreateTime(new Date());
                    goods.setaPrice(BigDecimal.ZERO);
                    goods.setNetWeight(BigDecimal.ZERO);
                    goods.setGrossWeight(BigDecimal.ZERO);
                    goods.setVolume(BigDecimal.ZERO);
                    goodsMapper.insert(goods);
                }
                //总数量
                if(DoubleUtil.isInteger(notOutQuantity)|| DoubleUtil.isNumeric(notOutQuantity)) {
                    //叠加总净重
                    totalNetWeight = goods.getNetWeight().multiply(BigDecimal.valueOf(Double.valueOf(notOutQuantity))).add(totalNetWeight);
                    //叠加总毛重
                    totalGrossWeight = goods.getGrossWeight().multiply(BigDecimal.valueOf(Double.valueOf(notOutQuantity))).add(totalGrossWeight);
                    //叠加总体积
                    totalVolume = goods.getVolume().multiply(BigDecimal.valueOf(Double.valueOf(notOutQuantity))).add(totalVolume);
                }
                SalesOrderDetails salesOrderDetails = new SalesOrderDetails();
                salesOrderDetails.setSalesOrderId(salesOrderId);
                salesOrderDetails.setGoodsId(goods.getGoodsId());
                if(goods.getaPrice()==null||goods.getaPrice().equals("")){
                    salesOrderDetails.setUnitPrice(BigDecimal.ZERO);
                }else{
                    salesOrderDetails.setUnitPrice(goods.getaPrice());
                }
                salesOrderDetails.setLotNumber(lotNumber);
                if(DoubleUtil.isInteger(notOutQuantity)|| DoubleUtil.isNumeric(notOutQuantity)) {
                    salesOrderDetails.setTotalPrice(BigDecimal.valueOf(Double.valueOf(notOutQuantity)).multiply(salesOrderDetails.getUnitPrice()));
                    salesOrderDetails.setNotOutQuantity(BigDecimal.valueOf(Double.parseDouble(notOutQuantity)));
                }else{
                    salesOrderDetails.setTotalPrice(BigDecimal.ZERO);
                    salesOrderDetails.setNotOutQuantity(BigDecimal.ZERO);
                }


                salesOrderDetails.setStatus((byte)1);
                salesOrderDetails.setReturnAmount(BigDecimal.ZERO);
                if(DoubleUtil.isInteger(boxNumber)){
                    salesOrderDetails.setBoxesNumber(Integer.valueOf(boxNumber));
                }else{
                    salesOrderDetails.setBoxesNumber(0);
                }
                salesOrderDetails.setReturnNumber(returnNumber);
                salesOrderDetailsMapper.insert(salesOrderDetails);
                //总价
                amount= amount.add(salesOrderDetails.getTotalPrice());
            }
            //总金额
            salesOrder.setAmount(amount);
            salesOrder.setOutstandingAmount(amount);
            salesOrder.setTotalBoxesNumber(totalBoxesNumber);
            salesOrder.setTotalAmount(totalAmount);
            salesOrder.setTotalNetWeight(totalNetWeight);
            salesOrder.setTotalGrossWeight(totalGrossWeight);
            salesOrder.setTotalVolume(totalVolume);
            salesOrderMapper.updateByPrimaryKey(salesOrder);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
