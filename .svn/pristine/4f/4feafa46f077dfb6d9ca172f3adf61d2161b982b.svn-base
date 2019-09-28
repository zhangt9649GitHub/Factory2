package com.mingyuansoftware.aifactory.util;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * @version V1.0
 * @desc AES 浮点数计算工具类
 */
public class DoubleUtil {
	
	/**
	 * 两个double类型的数据相减
	 */
 	public static double doubleSub(double d1,double d2){ 
         BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
         BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
         return bd1.subtract(bd2).doubleValue(); 
    } 
 	/**
	 * 两个double类型的数据相加
	 */
 	public static double doubleAdd(double d1,double d2){ 
 		BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
 		BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
 		return bd1.add(bd2).doubleValue(); 
 	}
 	/**
	 * 两个double类型的数据相乘
	 */
 	public static double doubleMultiply(double d1,double d2){ 
 		BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
 		BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
 		return bd1.multiply(bd2).doubleValue(); 
 	} 
 	/**
	 * 两个double类型的数据相除
	 */
 	public static double doubleDivide(double d1,double d2){ 
 		BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
 		BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
 		return bd1.divide(bd2).doubleValue(); 
 	}
 	
 	/**
	 * 两个BigDecimal类型的数据相减
	 */
 	public static BigDecimal bigDecimalSub(BigDecimal bd1,BigDecimal bd2){ 
 		BigDecimal b1 = new BigDecimal(0);
 		if(bd1!=null){
 			b1 = bd1;
 		}
 		BigDecimal b2 = new BigDecimal(0);
 		if(bd2!=null){
 			b2 = bd2;
 		}
         return b1.subtract(b2); 
    } 
 	/**
	 * 两个BigDecimal类型的数据相加
	 */
 	public static BigDecimal bigDecimalAdd(BigDecimal bd1,BigDecimal bd2){ 
 		BigDecimal b1 = new BigDecimal(0);
 		if(bd1!=null){
 			b1 = bd1;
 		}
 		BigDecimal b2 = new BigDecimal(0);
 		if(bd2!=null){
 			b2 = bd2;
 		}
 		return b1.add(b2); 
 	}
 	/**
	 * 两个BigDecimal类型的数据相乘
	 */
 	public static BigDecimal bigDecimalMultiply(BigDecimal bd1,BigDecimal bd2){ 
 		BigDecimal b1 = new BigDecimal(0);
 		if(bd1!=null){
 			b1 = bd1;
 		}
 		BigDecimal b2 = new BigDecimal(0);
 		if(bd2!=null){
 			b2 = bd2;
 		}
 		return b1.multiply(b2); 
 	} 
 	/**
	 * 两个BigDecimal类型的数据相除
	 */
 	public static BigDecimal bigDecimalDivide(BigDecimal bd1,BigDecimal bd2){ 
 		BigDecimal b1 = new BigDecimal(0);
 		if(bd1!=null){
 			b1 = bd1;
 		}
 		BigDecimal b2 = new BigDecimal(0);
 		if(bd2!=null){
 			b2 = bd2;
 		}
 		return b1.divide(b2,BigDecimal.ROUND_HALF_DOWN); 
 	}
    /** 
     * @param number 需要保留两位的数 
     * @return 
     */  
    public static double doubleFormat2(double number) {  
        // 将double类型转为BigDecimal  
        BigDecimal bigDecimal = new BigDecimal(number);    
        // 保留两位小数,并且四舍五入  
        return bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();    
    }  
    
    public static void main(String[] args) {
		System.out.println(String.format("%02d", 10));
	}


	/*
	 * 判断是否为整数
	 * @param str 传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	/*
	 * 判断是否为小数
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		if (str.indexOf(".") > 0) {//判断是否有小数点
			if (str.indexOf(".") == str.lastIndexOf(".") && str.split("\\.").length == 2) { //判断是否只有一个小数点
				return pattern.matcher(str.replace(".", "")).matches();
			} else {
				return false;
			}
		} else {
			return pattern.matcher(str).matches();
		}
	}
}