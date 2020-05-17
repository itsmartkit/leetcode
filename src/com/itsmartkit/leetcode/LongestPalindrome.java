package com.itsmartkit.leetcode;

/**
 * @ClassName LongestPalindrome
 * @Description TODO 最长回文子串
 * @Author changyj
 * @Date 2020-05-17 23:35
 */
public class LongestPalindrome {


    /*
        给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

        示例 1：

        输入: "babad"
        输出: "bab"
        注意: "aba" 也是一个有效答案。
        示例 2：

        输入: "cbbd"
        输出: "bb"
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int left = 0, right = 0, len = 1;
        int minIdx = 0, maxLen = 0;
        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(i) == s.charAt(right)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)) {
                len += 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                minIdx = left + 1;
            }
            len = 1;
        }
        return s.substring(minIdx, minIdx + maxLen);
    }

}
