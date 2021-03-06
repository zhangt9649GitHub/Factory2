package com.mingyuansoftware.aifactory.service.impl;

import com.csvreader.CsvReader;
import com.mingyuansoftware.aifactory.constants.Constants;
import com.mingyuansoftware.aifactory.mapper.*;
import com.mingyuansoftware.aifactory.model.*;
import com.mingyuansoftware.aifactory.model.dto.GoodsDto;
import com.mingyuansoftware.aifactory.model.dto.InventoryWarningDto;
import com.mingyuansoftware.aifactory.model.dto.PDAGoodsDto;
import com.mingyuansoftware.aifactory.model.dto.TjGoodsKucunDto;
import com.mingyuansoftware.aifactory.service.GoodsService;
import com.mingyuansoftware.aifactory.util.*;
import com.mingyuansoftware.aifactory.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.*;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper  goodsMapper;
    @Autowired
    private StockKucunGoodsMapper stockKucunGoodsMapper;
    @Autowired
    private GoodsLadderPriceMapper goodsLadderPriceMapper;
    @Autowired
    private GoodsSupplierMapper goodsSupplierMapper;


    @Override
    public List<Goods> selectGoodsList(GoodsDto goodsDto) {
        try{
            return goodsMapper.selectGoodsList(goodsDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCount(GoodsDto goodsDto) {
        try{
            return goodsMapper.selectCount(goodsDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertGoods(Goods goods) {
             goods.setCreateTime(new Date());
             goods.setGoodsNumber(goods.getCategory()+goods.getPartsCd());
             goodsMapper.insert(goods);
             //修改仓位的状态为使用中
           // warehousePositionMapper.updateWarehousePrositonState(goods.getWpId());
        if(!(goods.getGoodsLadderPriceList().isEmpty())){
            for (GoodsLadderPrice goodsLadderPrice:goods.getGoodsLadderPriceList()
                 ) {
                goodsLadderPrice.setGoodsId(goods.getGoodsId());
                goodsLadderPriceMapper.insert(goodsLadderPrice);
            }
        }
        if(!(goods.getGoodsSupplierList().isEmpty())){
            for (GoodsSupplier goodsSupplier:goods.getGoodsSupplierList()
                 ) {
                goodsSupplier.setGoodsId(goods.getGoodsId());
                goodsSupplierMapper.insert(goodsSupplier);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteGoodsById(Integer goodsId) {
            goodsMapper.deleteByPrimaryKey(goodsId);
        goodsLadderPriceMapper.deleteByGoodsId(goodsId);
        goodsSupplierMapper.deleteGoodsSupplierByGoodsId(goodsId);
    }

    @Override
    public Goods selectGoodsById(int goodsId) {
        try{
            Goods  goods =goodsMapper.selectByPrimaryKey(goodsId);
            for (int s: Constants.MAP_CATEGORY.keySet()
            ) {
             if(goods.getCategory()==s){
                 goods.setCategoryName(Constants.MAP_CATEGORY.get(s));
             }
            }
            if(goods.getWarehousePosition()!=null){
                goods.setWpId(goods.getWarehousePosition().getWpId());
                goods.setWpName(goods.getWarehousePosition().getWpName());
            }
            if(goods.getUploadFiles()!=null){
                goods.setUfId(goods.getUploadFiles().getUfId());
                goods.setUfSavePath(goods.getUploadFiles().getUfSavePath());
            }
            if(goods.getSupplier()!=null){
                goods.setSupplierId(goods.getSupplier().getSupplierId());
                goods.setSupplierName(goods.getSupplier().getSupplierName());
            }
            if(goods.getGoodsVariety()!=null){
                goods.setVarietyValue(goods.getGoodsVariety().getVarietyValue());
                goods.setVariety(goods.getGoodsVariety().getCnName());
            }
            List<GoodsLadderPrice> goodsLadderPriceList = goodsLadderPriceMapper.selectGoodsLadderPriceListByGoodsId(goodsId);
            List<GoodsSupplier> goodsSupplierList = goodsSupplierMapper.selectGoodsSupplierByGoodsId(goodsId);
            goods.setGoodsSupplierList(goodsSupplierList);
            goods.setGoodsLadderPriceList(goodsLadderPriceList);
            return goods;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGoodsInfo(Goods goods) {
            goods.setUpdateTime(new Date());
            goods.setGoodsNumber(goods.getCategory()+goods.getPartsCd());
            goodsMapper.updateByPrimaryKey(goods);
          List<GoodsLadderPrice> goodsLadderPriceList = goodsLadderPriceMapper.selectGoodsLadderPriceListByGoodsId(goods.getGoodsId());
          if(!(goodsLadderPriceList.isEmpty())){
              for (GoodsLadderPrice goodsLadderPrice:goodsLadderPriceList
                   ) {
                  goodsLadderPriceMapper.deleteByPrimaryKey(goodsLadderPrice.getLadderPriceId());
              }
          }
          if(!(goods.getGoodsLadderPriceList().isEmpty())){
              for (GoodsLadderPrice goodsLadderPrice:goods.getGoodsLadderPriceList()
                   ) {
                  goodsLadderPrice.setGoodsId(goods.getGoodsId());
                  goodsLadderPriceMapper.insert(goodsLadderPrice);
              }
          }
          goodsSupplierMapper.deleteGoodsSupplierByGoodsId(goods.getGoodsId());
        if(!(goods.getGoodsSupplierList().isEmpty())){
            for (GoodsSupplier goodsSupplier:goods.getGoodsSupplierList()
            ) {
                goodsSupplier.setGoodsId(goods.getGoodsId());
                goodsSupplierMapper.insert(goodsSupplier);
            }
        }

    }

    @Override
    public List<Goods> selectExportGoodsList() {
        try{
           return goodsMapper.selectExportGoodsList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<KucunGoods> selectAllGoodsList(Integer goodsId,String partsCd,String goodsName) {
        try {
            List<KucunGoods> goodsList = goodsMapper.selectAllGoodsList(goodsId,partsCd,goodsName);
            for (KucunGoods kucunGoods:goodsList
                 ) {
               List<GoodsLadderPrice> goodsLadderPriceList = goodsLadderPriceMapper.selectGoodsLadderPriceListByGoodsId(kucunGoods.getGoodsId());
                kucunGoods.setLadderPrice(LadderPriceUtil.getLadderPrice(goodsLadderPriceList));
            }
            List<StockKucunGoods> stockKucunGoodsList = new ArrayList<>();
            if(goodsId!=null){
                 stockKucunGoodsList =stockKucunGoodsMapper.selectGoodsKucunById(goodsId);
            }else {
                 stockKucunGoodsList =stockKucunGoodsMapper.selectGoodsKucun();
            }
            if(stockKucunGoodsList.size()>0){
                for (KucunGoods kucunGoods:goodsList
                ) {
                    int goodsId1 = kucunGoods.getGoodsId();
                    for (StockKucunGoods stockKucunGoods:stockKucunGoodsList
                    ) {
                        if(goodsId1==stockKucunGoods.getGid() ){
                            kucunGoods.setSkgCount(stockKucunGoods.getSkgCount());
                        }
                    }
                    if(kucunGoods.getSkgCount()==null){
                        kucunGoods.setSkgCount(new BigDecimal(0));
                    }
                }
            }else{
                for (KucunGoods kucunGoods:goodsList
                ) {
                    kucunGoods.setSkgCount(new BigDecimal(0));
                }
            }
            return goodsList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectAllGoodsCount(Integer goodsId,String partsCd,String goodsName) {
        try {
          return goodsMapper.selectAllGoodsCount(goodsId,partsCd,goodsName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<TjGoodsKucunDto> selectTjGoodsKucunList(TjGoodsKucunDto tjGoodsKucunDto) {
        try{
            List<TjGoodsKucunDto>  tjGoodsKucunDtoList = goodsMapper.selectTjGoodsKucunList(tjGoodsKucunDto);
                for (TjGoodsKucunDto tjGoodsKucunDto1:tjGoodsKucunDtoList
                     ) {
                    if(tjGoodsKucunDto1.getCategory()!=null){
                        for (int s: Constants.MAP_CATEGORY.keySet()
                        ) {
                            if(tjGoodsKucunDto1.getCategory()==s){
                                tjGoodsKucunDto1.setCategoryName(Constants.MAP_CATEGORY.get(s));
                                break;
                            }
                    }
                }
            }
            return tjGoodsKucunDtoList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectTjGoodsKucunCount(TjGoodsKucunDto tjGoodsKucunDto) {
        try{

          return goodsMapper.selectTjGoodsKucunCount(tjGoodsKucunDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<InventoryWarningDto> selectInventoryWarningList(InventoryWarningDto inventoryWarningDto) {
        try {
            return goodsMapper.selectInventoryWarningList(inventoryWarningDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selecInventoryWarningtCount(InventoryWarningDto inventoryWarningDto) {
        try {
        return goodsMapper.selecInventoryWarningtCount(inventoryWarningDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<ProductionOrderGoods> selectProductionOrderGoodsList(String partsCd, String goodsName,String monthsInStock) {
        try{
          return goodsMapper.selectProductionOrderGoodsList(partsCd,goodsName,monthsInStock);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectProductionOrderGoodsCount(String partsCd, String goodsName,String monthsInStock) {
        try{
           return goodsMapper.selectProductionOrderGoodsCount(partsCd,goodsName,monthsInStock);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importGoods(MultipartFile file) {
        //先删除文件夹内的文件，保证是空文件夹
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {//如果是Windows系统
            String unZipAddress = "D:/importCsv/";
            DeleteFileUtil.delFolder(unZipAddress);
        } else {  //linux 和mac
            String unZipAddress = "/usr/local/csv/";
            DeleteFileUtil.delFolder(unZipAddress);
        }
        String fileName = file.getOriginalFilename();
        String folderName = Base64.getRandomFileName();
        //zip文件路径
        String ufSavePath = "";
        if (os.toLowerCase().startsWith("win")) {//如果是Windows系统
            File dest = new File("D:/importCsv/" + folderName + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
                ufSavePath ="D:/importCsv/" + folderName + fileName;

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {  //linux 和mac
            File dest = new File("/usr/local/csv/" + folderName + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
                ufSavePath ="/usr/local/csv/" + folderName + fileName;

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        List<Goods> goodsList = new ArrayList<>();
        List<Goods> goodsList1 = new ArrayList<>();
        try{
            //用来保存数据
            CsvReader r = new CsvReader(ufSavePath,',', Charset.forName("Shift_JIS"));
            //读取表头
            r.readHeaders();
            //逐条读取记录，直至读完
            while (r.readRecord()) {
                Goods goods1 = goodsMapper.selectGoodsByPartsCd(r.get(0));
                if(goods1==null){
                    Goods goods = new Goods();
                    goods.setGoodsNumber(r.get(1)+r.get(0));
                    goods.setPartsCd(r.get(0));
                    goods.setGoodsName(r.get(3));
                    goods.setGoodsNameJp(r.get(2));
                    if(!(r.get(1).equals(""))) {
                        goods.setCategory(Byte.valueOf(r.get(1)));
                    }
                    goods.setUnit(r.get(5));
                    if(!(r.get(12).equals(""))){
                        goods.setBoxesNumber(Integer.valueOf(r.get(12)));
                    }
                    if(!(r.get(15).equals(""))) {
                        goods.setVarietyValue(Integer.valueOf(r.get(15)));
                    }
                    if(!(r.get(11).equals(""))) {
                        goods.setBundleNumber(Integer.valueOf(r.get(11)));
                    }
                    goods.setCreateTime(new Date());
                    goodsList.add(goods);
                }else{
                    goods1.setGoodsNumber(r.get(1)+r.get(0));
                    goods1.setGoodsName(r.get(3));
                    goods1.setGoodsNameJp(r.get(2));
                    if(!(r.get(1).equals(""))) {
                        goods1.setCategory(Byte.valueOf(r.get(1)));
                    }
                    goods1.setUnit(r.get(5));
                    if(!(r.get(12).equals(""))){
                        goods1.setBoxesNumber(Integer.valueOf(r.get(12)));
                    }
                    if(!(r.get(15).equals(""))) {
                        goods1.setVarietyValue(Integer.valueOf(r.get(15)));
                    }
                    if(!(r.get(11).equals(""))) {
                        goods1.setBundleNumber(Integer.valueOf(r.get(11)));
                    }
                    goods1.setUpdateTime(new Date());
                    goodsList1.add(goods1);
                }
            }
            if(!(goodsList.isEmpty())){
                goodsMapper.insertList(goodsList);
            }
            if(!(goodsList1.isEmpty())){
                goodsMapper.updateList(goodsList1);
            }
            r.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public TjKucunGoodsInfo selectTjGoodsKucunInfoById(int goodsId) {
        try{
            Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
            TjKucunGoodsInfo tjKucunGoodsInfo = new TjKucunGoodsInfo();
            tjKucunGoodsInfo.setGoodsName(goods.getGoodsName());
            tjKucunGoodsInfo.setPartsCd(goods.getPartsCd());
            tjKucunGoodsInfo.setSpecification(goods.getSpecification());
            List<StockKucunGoods> stockKucunGoodsList =stockKucunGoodsMapper.selectTjGoodsKucunInfo(goodsId);
            if(!(stockKucunGoodsList.isEmpty())){
                for (StockKucunGoods stockKucunGoods:stockKucunGoodsList
                ) {
                    if(stockKucunGoods.getSkgCount().compareTo(BigDecimal.ZERO)<0){
                        stockKucunGoods.setSkgCount(stockKucunGoods.getSkgCount().multiply(new BigDecimal(-1)));
                    }
                    StockKucunGoods stockKucunGoods1 =stockKucunGoodsMapper.selectTjGoodsKucunNow(stockKucunGoods.getSkgid(),goodsId);
                    if(stockKucunGoods1!=null&&stockKucunGoods1.getSkgCount()!=null){
                        stockKucunGoods.setTotalSkgCount(stockKucunGoods1.getSkgCount());
                    }
                }
            }
            tjKucunGoodsInfo.setStockKucunGoodsList(stockKucunGoodsList);
            return tjKucunGoodsInfo;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Goods selectGoodsInfoByGoodsNumber(String goodsNumber) {
        try{
            return goodsMapper.selectGoodsInfoByGoodsNumber(goodsNumber);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGoods(PDAGoodsDto pdaGoodsDto) {
        goodsMapper.updateGoods(pdaGoodsDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGoodsPrintByGoodsId(int goodsId, int isPrint,int printNumber) {
        goodsMapper.updateGoodsPrintByGoodsId(goodsId,isPrint,printNumber);
    }

    @Override
    public Goods selectGoodsPrint() {
        try{
            return goodsMapper.selectGoodsPrint();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Goods> selectGoodsListBySupplierId(int supplierId) {
        try {
            return goodsMapper.selectGoodsListBySupplierId(supplierId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  List<MaterialRequirements>  selectMaterialRequirementList(MaterialRequirements materialRequirements) {
            return  goodsMapper.selectMaterialRequirementList(materialRequirements);
        }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGoodsPrint() {
        goodsMapper.updateGoodsPrint();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importGoodsInfo(MultipartFile file) {
        //先删除文件夹内的文件，保证是空文件夹
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {//如果是Windows系统
            String unZipAddress = "D:/importCsv/";
            DeleteFileUtil.delFolder(unZipAddress);
        } else {  //linux 和mac
            String unZipAddress = "/usr/local/csv/";
            DeleteFileUtil.delFolder(unZipAddress);
        }
        String fileName = file.getOriginalFilename();
        String folderName = Base64.getRandomFileName();
        //zip文件路径
        String ufSavePath = "";
        if (os.toLowerCase().startsWith("win")) {//如果是Windows系统
            File dest = new File("D:/importCsv/" + folderName + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
                ufSavePath ="D:/importCsv/" + folderName + fileName;

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {  //linux 和mac
            File dest = new File("/usr/local/csv/" + folderName + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest); //保存文件
                ufSavePath ="/usr/local/csv/" + folderName + fileName;

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        List<Goods> goodsList = new ArrayList<>();
        List<Goods> goodsList1 = new ArrayList<>();
        try{
            //用来保存数据
            CsvReader r = new CsvReader(ufSavePath,',', Charset.forName("Shift_JIS"));
            //读取表头
            r.readHeaders();
            //逐条读取记录，直至读完
            while (r.readRecord()) {
                Goods goods1 = goodsMapper.selectGoodsByPartsCd(r.get(0));
                if(goods1==null) {
                    Goods goods = new Goods();
                    goods.setGoodsNumber(r.get(1) + r.get(0));
                    goods.setPartsCd(r.get(0));
                    goods.setGoodsName(r.get(2));
                    goods.setGoodsNameJp(r.get(3));
                    if (!(r.get(1).equals(""))) {
                        goods.setCategory(Byte.valueOf(r.get(1)));
                    }
                    if (!(r.get(6).equals(""))) {
                        goods.setMonthlySalesVolume(new BigDecimal(r.get(6)));
                    }
                    goods.setCreateTime(new Date());
                    goodsList.add(goods);
                }else{
                    goods1.setGoodsNumber(r.get(1) + r.get(0));
                    goods1.setPartsCd(r.get(0));
                    goods1.setGoodsName(r.get(2));
                    goods1.setGoodsNameJp(r.get(3));
                    if (!(r.get(1).equals(""))) {
                        goods1.setCategory(Byte.valueOf(r.get(1)));
                    }
                    if (!(r.get(6).equals(""))) {
                        goods1.setMonthlySalesVolume(new BigDecimal(r.get(6)));
                    }
                    goods1.setUpdateTime(new Date());
                    goodsList1.add(goods1);
                }
            }
            if(!(goodsList.isEmpty())){
                goodsMapper.insertList(goodsList);
            }
            if(!(goodsList1.isEmpty())){
                goodsMapper.updateList(goodsList1);
            }
            r.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Goods> selectGoodsNameList(String goodsName) {
        try {
            return goodsMapper.selectGoodsNameList(goodsName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
