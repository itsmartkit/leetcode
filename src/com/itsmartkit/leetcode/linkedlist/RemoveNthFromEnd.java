package com.itsmartkit.leetcode.linkedlist;

import com.itsmartkit.leetcode.linkedlist.common.ListNode;

/**
 * @ClassName RemoveNthFromEnd
 * @Description TODO 删除链表的倒数第N个节点
 * @Author changyj
 * @Date 2020-05-17 17:05
 */
public class RemoveNthFromEnd {

    /*
        给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

        示例：

        给定一个链表: 1->2->3->4->5, 和 n = 2.

        当删除了倒数第二个节点后，链表变为 1->2->3->5.
        说明：

        给定的 n 保证是有效的。
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode cur = head;
        int m = 0;
        while (cur != null) {
            if (m > n) {
                pre = pre.next;
            }
            cur = cur.next;
            m++;
        }
        ListNode next = pre.next;
        if (m == n) {
            head = next;
        } else {
            pre.next = next.next;
        }
        return head;
    }

}
