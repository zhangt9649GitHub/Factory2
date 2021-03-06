package com.mingyuansoftware.aifactory.constants;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    /**
     * 货物类别  商品
     */
    public static final int GOODS_CATEGORY_COMMODITY = 0;
    /**
     * 货物类别  完成品
     */
    public static final int GOODS_CATEGORY_HALF = 1;
    /**
     * 货物类别 成型品
     */
    public static final int GOODS_CATEGORY_MANUFACTURING = 2;
    /**
     * 货物类别 原材料
     */
    public static final int GOODS_CATEGORY_RAW_MATERIAL = 3;

    /**
     *货物类别Map
     */
    public static Map<Integer,String> MAP_CATEGORY =new HashMap<Integer,String>();
    static {
        MAP_CATEGORY.put(GOODS_CATEGORY_COMMODITY,"商品");
        MAP_CATEGORY.put(GOODS_CATEGORY_HALF,"完成品");
        MAP_CATEGORY.put(GOODS_CATEGORY_MANUFACTURING,"成型品");
        MAP_CATEGORY.put(GOODS_CATEGORY_RAW_MATERIAL,"原材料");
    }

    /**
     * 采购入库
     */
    public static final int KUCUN_PURCHASE_STORAGE = 1;

    /**
     * 销售出库
     */
    public static final int KUCUN_SALES_OUTBOUND = 2;

    /**
     * 销售退货入库
     */
    public static final int KUCUN_SALES_RETURN_STORAGE =3;

    /**
     * 采购退换货
     */
    public static final int KUCUN_PURCHASE_RETURN_STORAGE =4;

    /**
     * 盘盈入库
     */
    public static final int KUCUN_INVENTORY_CHECK_STORAGE =5;

    /**
     * 盘亏出库
     */
    public static final int KUCUN_INVENTORY_CHECK_OUTBOUND =6;

    /**
     * 领料入库
     */
    public static final int KUCUN_PICKING_STORAGE = 7;

    /**
     * 领料出库
     */
    public static final int KUCUN_PICKING_OUTBOUND = 8;

    /**
     * 退料入库
     */
    public static final int KUCUN_REFUND_PICKING_STORAGE = 9;

    /**
     * 退料出库
     */
    public static final int KUCUN_REFUND_PICKING_OUTBOUND =10;

    /**
     * 调拨入库
     */
    public static final int KUCUN_REQUISITION_STORAGE = 11;

    /**
     * 调拨出库
     */
    public static final int KUCUN_REQUISITION_OUTBOUND = 12;

    /**
     * 生产入库
     */
    public static final int KUCUN_PRODUCTION_ENTRY_STORAGE = 13;


    /**
     *库存类别 Map
     */
    public static Map<Integer,String> MAP_KUCUN =new HashMap<Integer,String>();
    static {
        MAP_KUCUN.put(KUCUN_PURCHASE_STORAGE,"采购入库");
        MAP_KUCUN.put(KUCUN_SALES_OUTBOUND,"销售出库");
        MAP_KUCUN.put(KUCUN_SALES_RETURN_STORAGE,"销售退货入库");
        MAP_KUCUN.put(KUCUN_PURCHASE_RETURN_STORAGE,"采购退换货");
        MAP_KUCUN.put(KUCUN_INVENTORY_CHECK_STORAGE,"盘盈入库");
        MAP_KUCUN.put(KUCUN_INVENTORY_CHECK_OUTBOUND,"盘亏出库");
        MAP_KUCUN.put(KUCUN_PICKING_STORAGE,"领料入库");
        MAP_KUCUN.put(KUCUN_PICKING_OUTBOUND,"领料出库");
        MAP_KUCUN.put(KUCUN_REFUND_PICKING_STORAGE,"退料入库");
        MAP_KUCUN.put(KUCUN_REFUND_PICKING_OUTBOUND,"退料出库");
        MAP_KUCUN.put(KUCUN_REQUISITION_STORAGE,"调拨入库");
        MAP_KUCUN.put(KUCUN_REQUISITION_OUTBOUND,"调拨出库");
        MAP_KUCUN.put(KUCUN_PRODUCTION_ENTRY_STORAGE,"生产入库");

    }

    /**
     * 天津总库主键id
     */
    public static final int WAREHOUSE_ID = 1;
    /**
     * 不良品仓库主键id
     */
    public static final int NO_WAREHOUSE_ID = 2;
}
