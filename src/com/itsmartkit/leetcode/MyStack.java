package com.itsmartkit.leetcode;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @ClassName MyStack
 * @Description TODO 用数组实现栈
 * @Author changyj
 * @Date 2020-06-01 00:48
 */
public class MyStack {

    private int[] data;

    private int size = 0;

    private static final int DEFAULT_CAPACITY = 8;


    public MyStack() {
        data = new int[DEFAULT_CAPACITY];
    }

    public void push(int x) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size++] = x;
    }

    public int pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        if (size > DEFAULT_CAPACITY && size < data.length >>> 1) {
            data = Arrays.copyOfRange(data, 0, size);
        }
        return data[--size];
    }

    public int peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
