package LeetCode.Array;

import java.util.Arrays;

/**
 * 买卖股票的最佳时机
 */
public class Solution5 {

    /**
     * 暴力破解
     * 遍历求最大差
     * 问题是太耗时
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int i1 = prices[j] - prices[i];
                if (i1 > max) {
                    max = i1;
                }
            }
        }
        return max;
    }

    /**
     * 通过记录最小价格和最大价格求差值
     * 问题是如何保证先最小价格是买入
     * 最大价格是卖出价格
     * 答案是通过一次遍历，遍历顺序保证了会先买后卖
     * 先通过记录最小价格，同时不停减最小价格得出最大利润
     * 利润每次得最大
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        //最低价格
        int minprice = Integer.MAX_VALUE;
        //最大利润
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            //遍历寻找最小价格
            if (prices[i] < minprice) {
                minprice = prices[i];
                //如果当前价格减去最小价格比最大利润还大，就重新赋值最大利润
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
