package com.itsmartkit.leetcode.linkedlist;

import com.itsmartkit.leetcode.linkedlist.common.ListNode;

/**
 * @author cyj
 * @name GetIntersectionNode
 * @description TODO 两个链表的第一个公共节点
 * @date 2020/5/28 9:46
 * Version 1.0
 */
public class GetIntersectionNode {

    /*
        两个链表的第一个公共节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode list1 = headA;
        ListNode list2 = headB;
        while (list1 != list2) {
            list1 = list1 == null ? headB : list1.next;
            list2 = list2 == null ? headA : list2.next;
        }
        return list1;
    }

}