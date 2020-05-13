package com.itsmartkit.leetcode;

/**
 * @author cyj
 * @name MergeTwoLists
 * @description TODO
 * @date 2020/5/13 14:40
 * Version 1.0
 */
public class MergeTwoLists {

    /*
        将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

        示例：

        输入：1->2->4, 1->3->4
        输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
//                // 去重
//                if (l1.val == l2.val) {
//                    l1 = l1.next;
//                }
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}