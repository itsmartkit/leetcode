package com.itsmartkit.leetcode.linkedlist;

import com.itsmartkit.leetcode.linkedlist.common.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cyj
 * @name PrintListFromTailToHead
 * @description TODO 从尾到头打印链表
 * @date 2020/5/26 10:18
 * Version 1.0
 */
public class PrintListFromTailToHead {

    /*
        题目描述
        输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

        思路：
            1.栈
            2.递归（操作系统的栈）
            3.list.add(idx, val);
            4.反转链表
     */

    // 1.栈
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode cur = listNode;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        ArrayList<Integer>  res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    //2.递归
    ArrayList<Integer> list = new ArrayList();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    //3.list.add(idx, val);
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode cur = listNode;
        while (cur != null) {
            res.add(0, cur.val);
            cur = cur.next;
        }
        return res;
    }

    //4.反转链表
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode reversed = reverseList(listNode);
        ListNode cur = reversed;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        return res;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null,next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}