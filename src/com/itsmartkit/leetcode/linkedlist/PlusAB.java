package com.itsmartkit.leetcode.linkedlist;

import com.itsmartkit.leetcode.linkedlist.common.ListNode;

/**
 * @author cyj
 * @name PlusAB
 * @description TODO 链式 A+B
 * @date 2020/5/18 14:51
 * Version 1.0
 */
public class PlusAB {

    /*
        题目描述
        有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。

        给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
        测试样例：
            {1,2,3},{3,2,1}
            返回：{4,4,4}
        提示：考虑进位
    */
    public ListNode plusAB(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode m = a;
        ListNode n = b;
        ListNode res = null;
        ListNode t = null;
        int plus = 0;
        while (m != null || n != null) {
            int sum = 0;
            if (m != null && n != null) {
                sum = m.val + n.val + plus;
            } else if (m != null) {
                sum = m.val + plus;
            } else {
                sum = n.val + plus;
            }
            int v = sum % 10;
            plus = sum / 10;
            if (t == null) {
                t = new ListNode(v);
                res = t;
            } else {
                t.next = new ListNode(v);
                t = t.next;
            }
            if (m != null) {
                m = m.next;
            }
            if (n != null) {
                n = n.next;
            }
        }
        if (plus != 0) {
            t.next = new ListNode(plus);
        }
        return res;
    }

}