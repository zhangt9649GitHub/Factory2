package com.mingyuansoftware.aifactory.util;

import com.mingyuansoftware.aifactory.model.CalculateQuantity;

import java.math.BigDecimal;
import java.util.List;

public class CalculateQuantityUtil {

    /**
     * 计算准备生产数量
     * @param calculateQuantityList
     * @return
     */
    public static BigDecimal calculateQuantity(List<CalculateQuantity> calculateQuantityList){
        //定义准备（可以生产）的最低数为0
        BigDecimal PrepareProduction = new BigDecimal(0);
        if(!(calculateQuantityList.isEmpty())){
            for (CalculateQuantity calculateQuantity:calculateQuantityList
            ) {
                //计算每一种货物可以生产的数量
                BigDecimal quantity = calculateQuantity.getQuantity();
                BigDecimal skgCount = calculateQuantity.getSkgCount();
                if(quantity.compareTo(BigDecimal.ZERO)!=0){
                    BigDecimal productionQuantity = skgCount.divide(quantity,2,BigDecimal.ROUND_HALF_DOWN);
                    if(productionQuantity.compareTo(BigDecimal.ZERO)==0){
                        return BigDecimal.ZERO;
                    }
                    if(productionQuantity.compareTo(BigDecimal.ZERO)>0){
                        if(PrepareProduction.compareTo(BigDecimal.ZERO)==0){
                            PrepareProduction =productionQuantity;
                        }
                        if(PrepareProduction.compareTo(productionQuantity)>0){
                            PrepareProduction =productionQuantity;
                        }
                    }
                }
            }
        }
        return PrepareProduction;
    }

    /**
     * 计算班次
     * @param quantity 任务量
     * @param cycle 成型周期
     * @return
     */
   public static BigDecimal calculateShift(BigDecimal quantity,BigDecimal cycle){
        //任务量/3600*12/成型周期
       BigDecimal base = new BigDecimal(3600);
       BigDecimal base1= new BigDecimal(12);
       if(cycle==null||cycle.compareTo(BigDecimal.ZERO)==0){
           return BigDecimal.ZERO;
       }
      BigDecimal quantity1 = quantity.divide(base,2,BigDecimal.ROUND_HALF_DOWN);
      BigDecimal shift =quantity1.multiply(base1).divide(cycle,2,BigDecimal.ROUND_HALF_DOWN);
      return shift;
    }
}
