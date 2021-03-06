package com.mingyuansoftware.aifactory.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(description = "郝腾")
public class Goods implements Serializable {

    @ApiModelProperty(value = "货物id", example = "1")
    private Integer goodsId;

    @ApiModelProperty(value = "货物编号 类别+部品cd", example = "goodsNumber")
    private String goodsNumber;

    @ApiModelProperty(value = "部品CD", example = "部品CD")
    private String partsCd;

    @ApiModelProperty(value = "品名EL", example = "品名")
    private String goodsName;

    @ApiModelProperty(value = "品名JP", example = "品名")
    private String  goodsNameJp;

    @ApiModelProperty(value = "品种", example = "品种")
    private String variety;

    @ApiModelProperty(value = "品种值", example = "1")
    private Integer varietyValue;

    @ApiModelProperty(value = "单位", example = "单位")
    private String unit;

    @ApiModelProperty(value = "规格", example = "规格")
    private String specification;

    @ApiModelProperty(value = "重量", example = "1")
    private Float weight;

    @ApiModelProperty(value = "日元单价", example = "1")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "a单价（进货价）", example = "1")
    private BigDecimal aPrice;

    @ApiModelProperty(value = "b单价（加工价）", example = "1")
    private BigDecimal bPrice;

    @ApiModelProperty(value = "采购起订量", example = "1")
    private BigDecimal purchaseOrderQuantity;

    @ApiModelProperty(value = "销售价格", example = "1")
    private BigDecimal sellingPrice;

    @ApiModelProperty(value = "批发价格", example = "1")
    private BigDecimal wholesalePrices;

    @ApiModelProperty(value = "最低库存", example = "1")
    private BigDecimal minimumStock;

    @ApiModelProperty(value = "采购预备库存指数", example = "procurementReserveStockIndex")
    private String procurementReserveStockIndex;

    @ApiModelProperty(value = "日本侧库存", example = "1")
    private BigDecimal japanStock;

    @ApiModelProperty(value = "天津侧库存", example = "1")
    private BigDecimal tjStock;


    @ApiModelProperty(value = "进货价", example = "1")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "工资单价", example = "1")
    private BigDecimal salaryPrice;

    @ApiModelProperty(value = "上传货物图片路径表id", example = "1")
    private Integer ufId;

    @ApiModelProperty(value = "图片路径", example = "ufSavePath")
    private String ufSavePath;

    @ApiModelProperty(value = "创建时间", example = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "上传图片实体类", example = "uploadFiles")
    private UploadFiles uploadFiles;

    @ApiModelProperty(value = "平均单价", example = "1")
    private BigDecimal averagePrice;


    @ApiModelProperty(value = "供应商id(作废)", example = "1")
    private Integer supplierId;

    @ApiModelProperty(value = "多少个/1箱", example = "1")
    private Integer boxesNumber;

    @ApiModelProperty(value = "月贩卖量", example = "1")
    private BigDecimal monthlySalesVolume;

    @ApiModelProperty(value = "贩卖月数", example = "1")
    private BigDecimal sellingMonths;

    @ApiModelProperty(value = "净重", example = "1")
    private BigDecimal netWeight;

    @ApiModelProperty(value = "毛重", example = "1")
    private BigDecimal grossWeight;

    @ApiModelProperty(value = "体积", example = "1")
    private BigDecimal volume;

    @ApiModelProperty(value = "供应商", example = "supplier")
    private Supplier supplier;

    @ApiModelProperty(value = "供应商名称", example = "供应1")
    private String supplierName;

    @ApiModelProperty(value = "在库月数", example = "monthsInStock")
    private String monthsInStock;

    @ApiModelProperty(value = "货物类别", example = "1")
    private Byte category;

    @ApiModelProperty(value = "货物类别名称", example = "1")
    private String categoryName;

    @ApiModelProperty(value = "仓位id", example = "1")
    private int wpId;

    @ApiModelProperty(value = "仓位名称", example = "仓位名称")
    private String wpName;

    @ApiModelProperty(value = "仓位", example = "warehousePosition")
    private WarehousePosition warehousePosition;

    @ApiModelProperty(value = "阶梯价格集合", example = "goodsLadderPriceList")
    private List<GoodsLadderPrice> goodsLadderPriceList;

    @ApiModelProperty(value = "货物品种类", example = "goodsVariety")
    private GoodsVariety goodsVariety;

    @ApiModelProperty(value = "多少箱/1捆", example = "1")
    private Integer bundleNumber;

    @ApiModelProperty(value = "打印张数", example = "1")
    private Integer printNumber;

    @ApiModelProperty(value = "成型周期", example = "1")
    private BigDecimal cycle;

    @ApiModelProperty(value = "供应商id集合", example = "goodsSupplierList")
    private List<GoodsSupplier> goodsSupplierList;

    private static final long serialVersionUID = 1L;


    public Integer getGoodsId() {
        return goodsId;
    }


    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }


    public String getPartsCd() {
        return partsCd;
    }


    public void setPartsCd(String partsCd) {
        this.partsCd = partsCd == null ? null : partsCd.trim();
    }


    public String getGoodsName() {
        return goodsName;
    }


    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }


    public String getVariety() {
        return variety;
    }


    public void setVariety(String variety) {
        this.variety = variety == null ? null : variety.trim();
    }


    public String getUnit() {
        return unit;
    }


    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }


    public String getSpecification() {
        return specification;
    }


    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }


    public Float getWeight() {
        return weight;
    }


    public void setWeight(Float weight) {
        this.weight = weight;
    }


    public BigDecimal getUnitPrice() {
        return unitPrice;
    }


    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }


    public BigDecimal getaPrice() {
        return aPrice;
    }


    public void setaPrice(BigDecimal aPrice) {
        this.aPrice = aPrice;
    }


    public BigDecimal getbPrice() {
        return bPrice;
    }


    public void setbPrice(BigDecimal bPrice) {
        this.bPrice = bPrice;
    }


    public BigDecimal getPurchaseOrderQuantity() {
        return purchaseOrderQuantity;
    }


    public void setPurchaseOrderQuantity(BigDecimal purchaseOrderQuantity) {
        this.purchaseOrderQuantity = purchaseOrderQuantity;
    }


    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }


    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }


    public BigDecimal getWholesalePrices() {
        return wholesalePrices;
    }


    public void setWholesalePrices(BigDecimal wholesalePrices) {
        this.wholesalePrices = wholesalePrices;
    }


    public BigDecimal getMinimumStock() {
        return minimumStock;
    }


    public void setMinimumStock(BigDecimal minimumStock) {
        this.minimumStock = minimumStock;
    }


    public String getProcurementReserveStockIndex() {
        return procurementReserveStockIndex;
    }


    public void setProcurementReserveStockIndex(String procurementReserveStockIndex) {
        this.procurementReserveStockIndex = procurementReserveStockIndex == null ? null : procurementReserveStockIndex.trim();
    }


    public BigDecimal getJapanStock() {
        return japanStock;
    }


    public void setJapanStock(BigDecimal japanStock) {
        this.japanStock = japanStock;
    }


    public BigDecimal getTjStock() {
        return tjStock;
    }


    public void setTjStock(BigDecimal tjStock) {
        this.tjStock = tjStock;
    }




    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }


    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }


    public BigDecimal getSalaryPrice() {
        return salaryPrice;
    }


    public void setSalaryPrice(BigDecimal salaryPrice) {
        this.salaryPrice = salaryPrice;
    }


    public Integer getUfId() {
        return ufId;
    }


    public void setUfId(Integer ufId) {
        this.ufId = ufId;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public UploadFiles getUploadFiles() {
        return uploadFiles;
    }

    public void setUploadFiles(UploadFiles uploadFiles) {
        this.uploadFiles = uploadFiles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getBoxesNumber() {
        return boxesNumber;
    }

    public void setBoxesNumber(Integer boxesNumber) {
        this.boxesNumber = boxesNumber;
    }

    public BigDecimal getMonthlySalesVolume() {
        return monthlySalesVolume;
    }

    public void setMonthlySalesVolume(BigDecimal monthlySalesVolume) {
        this.monthlySalesVolume = monthlySalesVolume;
    }

    public BigDecimal getSellingMonths() {
        return sellingMonths;
    }

    public void setSellingMonths(BigDecimal sellingMonths) {
        this.sellingMonths = sellingMonths;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getMonthsInStock() {
        return monthsInStock;
    }

    public void setMonthsInStock(String monthsInStock) {
        this.monthsInStock = monthsInStock;
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getWpId() {
        return wpId;
    }

    public void setWpId(int wpId) {
        this.wpId = wpId;
    }

    public WarehousePosition getWarehousePosition() {
        return warehousePosition;
    }

    public void setWarehousePosition(WarehousePosition warehousePosition) {
        this.warehousePosition = warehousePosition;
    }

    public String getWpName() {
        return wpName;
    }

    public void setWpName(String wpName) {
        this.wpName = wpName;
    }

    public List<GoodsLadderPrice> getGoodsLadderPriceList() {
        return goodsLadderPriceList;
    }

    public void setGoodsLadderPriceList(List<GoodsLadderPrice> goodsLadderPriceList) {
        this.goodsLadderPriceList = goodsLadderPriceList;
    }

    public Integer getVarietyValue() {
        return varietyValue;
    }

    public void setVarietyValue(Integer varietyValue) {
        this.varietyValue = varietyValue;
    }

    public GoodsVariety getGoodsVariety() {
        return goodsVariety;
    }

    public void setGoodsVariety(GoodsVariety goodsVariety) {
        this.goodsVariety = goodsVariety;
    }

    public String getGoodsNameJp() {
        return goodsNameJp;
    }

    public void setGoodsNameJp(String goodsNameJp) {
        this.goodsNameJp = goodsNameJp;
    }

    public Integer getBundleNumber() {
        return bundleNumber;
    }

    public void setBundleNumber(Integer bundleNumber) {
        this.bundleNumber = bundleNumber;
    }

    public String getUfSavePath() {
        return ufSavePath;
    }

    public void setUfSavePath(String ufSavePath) {
        this.ufSavePath = ufSavePath;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getPrintNumber() {
        return printNumber;
    }

    public void setPrintNumber(Integer printNumber) {
        this.printNumber = printNumber;
    }

    public BigDecimal getCycle() {
        return cycle;
    }

    public void setCycle(BigDecimal cycle) {
        this.cycle = cycle;
    }

    public List<GoodsSupplier> getGoodsSupplierList() {
        return goodsSupplierList;
    }

    public void setGoodsSupplierList(List<GoodsSupplier> goodsSupplierList) {
        this.goodsSupplierList = goodsSupplierList;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", partsCd='" + partsCd + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsNameJp='" + goodsNameJp + '\'' +
                ", variety='" + variety + '\'' +
                ", varietyValue=" + varietyValue +
                ", unit='" + unit + '\'' +
                ", specification='" + specification + '\'' +
                ", weight=" + weight +
                ", unitPrice=" + unitPrice +
                ", aPrice=" + aPrice +
                ", bPrice=" + bPrice +
                ", purchaseOrderQuantity=" + purchaseOrderQuantity +
                ", sellingPrice=" + sellingPrice +
                ", wholesalePrices=" + wholesalePrices +
                ", minimumStock=" + minimumStock +
                ", procurementReserveStockIndex='" + procurementReserveStockIndex + '\'' +
                ", japanStock=" + japanStock +
                ", tjStock=" + tjStock +
                ", purchasePrice=" + purchasePrice +
                ", salaryPrice=" + salaryPrice +
                ", ufId=" + ufId +
                ", ufSavePath='" + ufSavePath + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", uploadFiles=" + uploadFiles +
                ", averagePrice=" + averagePrice +
                ", supplierId=" + supplierId +
                ", boxesNumber=" + boxesNumber +
                ", monthlySalesVolume=" + monthlySalesVolume +
                ", sellingMonths=" + sellingMonths +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", volume=" + volume +
                ", supplier=" + supplier +
                ", supplierName='" + supplierName + '\'' +
                ", monthsInStock='" + monthsInStock + '\'' +
                ", category=" + category +
                ", categoryName='" + categoryName + '\'' +
                ", wpId=" + wpId +
                ", wpName='" + wpName + '\'' +
                ", warehousePosition=" + warehousePosition +
                ", goodsLadderPriceList=" + goodsLadderPriceList +
                ", goodsVariety=" + goodsVariety +
                ", bundleNumber=" + bundleNumber +
                ", printNumber=" + printNumber +
                ", cycle=" + cycle +
                '}';
    }
}