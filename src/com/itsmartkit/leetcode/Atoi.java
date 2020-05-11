package com.itsmartkit.leetcode;

/**
 * @author cyj
 * @name Atoi
 * @description TODO
 * @date 2020/5/11 16:23
 * Version 1.0
 */
public class Atoi {
    /*
        实现函数 atoi 。函数的功能为将字符串转化为整数
        提示：仔细思考所有可能的输入情况。这个问题故意描述的很模糊（没有给出输入的限制），你需要自己考虑所有可能的情况。
    */
    public int atoi(String str) {
        int p = 0;
        int res = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ' ') {
                p++;
            } else {
                break;
            }
        }
        if (p == n) {
            return 0;
        }
        boolean negative = str.charAt(p) == '-';
        if (str.charAt(p) == '-' || str.charAt(p) == '+') {
            p++;
        }
        for (; p < n; p++) {
            int digit = str.charAt(p) - '0';
            if (str.charAt(p) >= '0' && str.charAt(p) <= '9') {
                if ((Integer.MAX_VALUE - digit) / 10 < res) {
                    return Integer.MAX_VALUE;
                }
                if ((Integer.MIN_VALUE + digit) / 10 > res) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + (negative ? -digit : digit);
            } else {
                break;
            }
        }
        return res;
    }

}