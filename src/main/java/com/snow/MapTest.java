/**
 * @(#) MapTest.java 2017/10/27
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author hzwanghuiqi
 * @version 2017/10/27
 */
public class MapTest {

    public static void test1() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 3);
        hashMap.put(4, 4);
        hashMap.put(5, 5);
        hashMap.put(null, null);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            if(entry.getKey() != null && entry.getKey() == 3) {
                hashMap.entrySet().remove(entry.getKey());
            }
        }
    }

    public static void test2() {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1, 1);
        hashtable.put(2, 2);
        hashtable.put(3, 3);
        // hashtable.put(null, 4);
        // hashtable.put(5, null);
        for (Map.Entry<Integer, Integer> entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        test1();
        // test2();
    }


}
