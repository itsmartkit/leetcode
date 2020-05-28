package com.itsmartkit.leetcode;

/**
 * @author cyj
 * @name AddStrings
 * @description TODO 字符串相加/大数求和
 * @date 2020/5/28 10:45
 * Version 1.0
 */
public class AddStrings {

    /*
        给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
        注意：
            num1 和num2 的长度都小于 5100.
            num1 和num2 都只包含数字 0-9.
            num1 和num2 都不包含任何前导零。
            你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int hi = 0;
        int i = 0;
        int t, t1, t2;
        while (i < len1 || i < len2) {
            t1 = i < len1 ? num1.charAt(len1 - i - 1) - '0' : 0;
            t2 = i < len2 ? num2.charAt(len2 - i - 1) - '0' : 0;
            t = t1 + t2 + hi;
            sb.append(String.valueOf(t % 10));
            hi = t / 10;
            i++;
        }
        if (hi != 0) {
            sb.append(hi);
        }
        return sb.reverse().toString();
    }

}