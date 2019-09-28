package com.mingyuansoftware.aifactory.util;

import java.util.Random;

public class RandomCodeUtil {
    /**
     * 九位获取随机码
     */
    public static String getRandomCode() {
        Random random = new Random();
        Long rannum = (long) (random.nextDouble() * (999999999 - 100000000 + 1)) + 100000000;
        String code = String.valueOf(rannum);
        return code;
    }

    /**
     * 六位随机码
     * 03+用户编号使用
     */
    public static String getSixRandomCode() {
        Random random = new Random();
        Integer rannum = (int) (random.nextDouble() * (999999 - 100000 + 1)) + 100000;
        String code = String.valueOf(rannum);
        return code;
    }


    public static String getEightRandomCode() {
        Random random = new Random();
        Long rannum = (long) (random.nextDouble() * (99999999 - 10000000 + 1)) + 10000000;
        String code = String.valueOf(rannum);
        return code;
    }

    /**
     * 生n位随机数
     * @return String
     */
    public static String getRandom(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            String random = (int) (10 * (Math.random())) + "";
            sb.append(random);
        }
        return sb.toString();
    }

    /**
     * 生成唯一编号
     */
    public static long genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }
}
