package com.itsmartkit.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cyj
 * @name LRUCache
 * @description TODO LRU(最近最少使用)缓存机制
 * @date 2020/5/29 13:42
 * Version 1.0
 */
public class LRUCache {

    /*
        设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

        获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
        写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
        当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     */

    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap(capacity,0.75f ,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry entry) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer val = map.get(key);
        return val == null ? -1 : val;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}