package com.itsmartkit.leetcode;

import java.util.Stack;

/**
 * @author cyj
 * @name SortedStack
 * @description TODO 栈排序/最小栈
 * @date 2020/5/28 13:49
 * Version 1.0
 */
public class SortedStack {

    /*
        栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
        最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
        该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
     */

    private Stack<Integer> stack;
    private Stack<Integer> temp;

    public SortedStack() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int val) {
        int max = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
        int min = temp.isEmpty() ? Integer.MIN_VALUE : temp.peek();
        while (true) {
            if (val > max) {
                temp.push(stack.pop());
                max = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
            } else if (val < min) {
                stack.push(temp.pop());
                min = temp.isEmpty() ? Integer.MIN_VALUE : temp.peek();
            } else {
                stack.push(val);
                break;
            }
        }
    }

    public void pop() {
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty() && temp.isEmpty();
    }
}