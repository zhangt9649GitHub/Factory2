package com.mingyuansoftware.aifactory.config;

public class LogConfig {
    /**
     *生产入库数量所属货物数量小于库存量是否可以操作的设置 1.是可以操作 2.不可以操作
     */
    public static int requiredQuantityGoodsInsufficient = 1;
    /**
     *日志是否需要写入的设置 false.不写入 true.写入
     */
    public static Boolean STATE = false;

}
