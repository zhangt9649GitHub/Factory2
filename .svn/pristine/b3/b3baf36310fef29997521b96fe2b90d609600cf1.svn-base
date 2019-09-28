package com.mingyuansoftware.aifactory.util;


import com.mingyuansoftware.aifactory.model.GoodsLadderPrice;


import java.util.List;

public class LadderPriceUtil {


    /**
     * 根据货物阶梯价格集合拼接成字符串
     * @param goodsLadderPriceList
     * @return
     */
    public static String getLadderPrice(List<GoodsLadderPrice> goodsLadderPriceList) {
        String ladderPrice = null;
        if(!(goodsLadderPriceList.isEmpty())){
            for (GoodsLadderPrice goodsLadderPrice:goodsLadderPriceList
             ) {
                if(ladderPrice==null){
                    ladderPrice=goodsLadderPrice.getStartNumber()+"~"+goodsLadderPrice.getEndNumber()+"："+goodsLadderPrice.getPrice()+"；";
                }else{
                    ladderPrice=ladderPrice+goodsLadderPrice.getStartNumber()+"~"+goodsLadderPrice.getEndNumber()+"："+goodsLadderPrice.getPrice()+"；";
                }

            }
        }
        return ladderPrice;
    }
}
