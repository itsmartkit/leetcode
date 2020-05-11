package com.itsmartkit.leetcode;

/**
 * @author cyj
 * @name Stock
 * @description TODO 股票最大收益
 * @date 2020/5/11 17:25
 * Version 1.0
 */
public class Stock {

    /*
        在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。
        给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。

        给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。

        测试样例：
                [10,22,5,75,65,80],6
        返回：87
    */
    public int maxProfit(int[] prices, int n) {
        // 二分法
        int temp1 = 0, temp2 = 0, temp3 = 0, l = 0;
        while(l < n){
            for (int i = 0;i < l + 1; i++) {
                for (int j = i + 1;j < l + 1; j++) {
                    if((prices[j]-prices[i] > temp1)){
                        temp1 = prices[j]-prices[i];
                    }
                }
            }
            for (int i = l + 1;i < n; i++) {
                for (int j = i + 1;j < n; j++) {
                    if((prices[j]-prices[i] > temp2)){
                        temp2 = prices[j]-prices[i];
                    }
                }
            }
            if ((temp1+temp2) > temp3) {
                temp3 = temp1 + temp2;
            }
            temp1 = 0;
            temp2 = 0;
            l++;
        }
        return temp3;
    }

}