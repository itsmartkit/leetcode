package com.itsmartkit.leetcode;

/**
 * @author cyj
 * @name GetKthFromEnd
 * @description TODO 链表中倒数第k个节点
 * @date 2020/5/13 17:28
 * Version 1.0
 */
public class GetKthFromEnd {

    /*
        链表中倒数第k个节点
        输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
        例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

        示例：

        给定一个链表: 1->2->3->4->5, 和 k = 2.

        返回链表 4->5.
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        ListNode res = head;
        int n = 0;
        while (cur != null) {
            if (n++ >= k) {
                res = res.next;
            }
            cur = cur.next;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}