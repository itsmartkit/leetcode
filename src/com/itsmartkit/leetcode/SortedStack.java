package com.itsmartkit.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cyj
 * @name SortedStack
 * @description TODO 栈排序/最小栈/最大栈
 * @date 2020/5/28 13:49
 * Version 1.0
 */
public class SortedStack {

    /*
        栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
        最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
        该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
     */

    private Deque<Integer> stack;
    private Deque<Integer> maxStack;

    public SortedStack() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
    }

    public void push(int val) {
        int max = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
        int min = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        while (true) {
            if (val > max) {
                maxStack.push(stack.pop());
                max = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
            } else if (val < min) {
                stack.push(maxStack.pop());
                min = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
            } else {
                stack.push(val);
                break;
            }
        }
    }

    /**
     * @description //TODO 最小栈 pop()
     * @author cyj
     * @date 2020/5/28 16:22
     * @return
     * change notes
     */
    public void pop() {
        while (!maxStack.isEmpty()) {
            stack.push(maxStack.pop());
        }
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }
    /**
     * @description //TODO 最小栈 peek()
     * @author cyj
     * @date 2020/5/28 16:22
     * @return
     * change notes
     */
    public int peek() {
        while (!maxStack.isEmpty()) {
            stack.push(maxStack.pop());
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }


    /**
     * @description //TODO 最大栈 pop()
     * @author cyj
     * @date 2020/5/28 16:22
     * @return
     * change notes
     */
    public void popMax() {
        while (!stack.isEmpty()) {
            maxStack.push(stack.pop());
        }
        if (!maxStack.isEmpty()) {
            maxStack.pop();
        }
    }
    /**
     * @description //TODO 最大栈 peek()
     * @author cyj
     * @date 2020/5/28 16:22
     * @return
     * change notes
     */
    public int peekMax() {
        while (!stack.isEmpty()) {
            maxStack.push(stack.pop());
        }
        return maxStack.isEmpty() ? -1 : maxStack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty() && maxStack.isEmpty();
    }
}