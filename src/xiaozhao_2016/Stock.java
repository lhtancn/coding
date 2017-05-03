package xiaozhao_2016;

/**
 * Created by lhtan on 5/3/2017.
 */

/**
 * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
 给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
 测试样例：
 [10,22,5,75,65,80],6
 返回：87
 */
public class Stock {
    public int maxProfit(int[] prices, int n) {
        // write code here
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;

        for(int i = 1; i < prices.length; ++i) {
            int temp = getMax(prices, 0, i) + getMax(prices, i + 1, prices.length - 1); //为了第一次交易的范围可以覆盖整个数据集，i需要能到prices.length - 1.
            max = temp > max ? temp : max;
        }
        return max;
    }
    private int getMax(int[] prices, int start, int end) {
        if(start >= end) {
            return 0;
        }
        int min = prices[start];
        int max = 0;
        for(int i = start; i <= end; ++i) {

            if(prices[i] - min > max) {
                max = prices[i] - min;
            }
            if(prices[i] < min) {
                min = prices[i];
            }
        }
        return max;
    }
}


/**
 *另一种方法，不是很理解
 */
/*
public class Solution {
    */
/**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     *//*

    public int calculateMax(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        */
/**
         *第一次购买后的剩余值的初始值很重要，感觉不能单独拆开来看。不然无法理解初始值的设定以及整个意思
         *//*

        int resAfterFB = Integer.MIN_VALUE, resAfterFS = 0;
        int resAfterSB = Integer.MIN_VALUE, resAfterSS = 0;
        for(int price : prices) {
            resAfterFB = Math.max(resAfterFB, -price);
            resAfterFS = Math.max(resAfterFS, resAfterFB + price);
            resAfterSB = Math.max(resAfterSB, resAfterFS - price);
            resAfterSS = Math.max(resAfterSS, resAfterSB + price);
        }
        return resAfterSS;
    }
}
*/
