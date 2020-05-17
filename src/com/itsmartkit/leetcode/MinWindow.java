package com.itsmartkit.leetcode;

/**
 * @ClassName MinWindow
 * @Description TODO 最小覆盖子串/最短子字符串
 * @Author changyj
 * @Date 2020-05-17 00:28
 */
public class MinWindow {

    /*
        给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。

        示例：

        输入: S = "ADOBECODEBANC", T = "ABC"
        输出: "BANC"
        说明：

        如果 S 中不存这样的子串，则返回空字符串 ""。
        如果 S 中存在这样的子串，我们保证它是唯一的答案。
    */
    public String minWindow(String s, String t) {
        int[] bhash = new int[128];
        int[] hash = new int[128];
        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();
        int num = 0, valid = 0;
        for (char c : tc) {
            if (bhash[c] == 0) {
                num++;
            }
            bhash[c]++;
        }
        int idx = 0, len = sc.length + 1;
        int left = 0, right = 0;
        while (right < sc.length) {
            char c = sc[right];
            right++;
            if (bhash[c] > 0) {
                hash[c]++;
                if (bhash[c] == hash[c]) {
                    valid++;
                }
            }
            // 缩小窗口大小
            while (valid == num) {
                // 记录最短长度
                if (right - left < len) {
                    idx = left;
                    len = right - left;
                }
                char d = sc[left];
                // 缩小窗口
                left++;
                if (bhash[d] > 0) {
                    if (bhash[d] == hash[d]) {
                        valid--;
                    }
                    hash[d]--;
                }
            }
        }
        return len == sc.length + 1 ? "" : s.substring(idx, idx + len);
    }

}
