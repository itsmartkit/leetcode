package com.itsmartkit.leetcode;

/**
 * @ClassName GetSum
 * @Description TODO 两整数之和
 * @Author changyj
 * @Date 2020-06-06 00:52
 */
public class GetSum {


    /*
        不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

        示例 1:
            输入: a = 1, b = 2
            输出: 3
        示例 2:
            输入: a = -2, b = 3
            输出: 1
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int t = a ^ b;
            b = (a & b) << 1;
            a = t;
        }
        return a;
    }

}
