/**
 * @(#) ConcurrentHashMapTest.java 2017/12/25
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hzwanghuiqi
 * @version 2017/12/25
 */
@Slf4j
public class ConcurrentHashMapTest {
    private static sun.misc.Unsafe U;

    public static int test1(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }

    public static void test2() {
        int i = 1 << -30;
        System.out.println(i);
        // 32 is the size of integer in Java
        i = 1 << ((32 - 30) % 32);
        System.out.println(i);
        i = 26 | 2^15;
        System.out.println(i);
        i = (26 | 2^15) << 16;
        System.out.println(i);
    }


    public static void test3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 9);
        map.put("b", 8);
        map.put("c", 7);
        map.put("d", 6);
        map.put("e", 5);
        map.put("f", 4);
        map.put("g", 3);
        map.put("h", 2);
        map.put("i", 1);

        List<Map.Entry<String, Integer>> mapList = new ArrayList<>();
        mapList.addAll(map.entrySet());
        for (Map.Entry<String, Integer> entry : mapList) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("\n");


        Comparator<Map.Entry<String, Integer>> comparator = (o1, o2) -> o1.getKey().compareToIgnoreCase(o2.getKey());

        Collections.sort(mapList, comparator);
        for (Map.Entry<String, Integer> entry : mapList) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


    public static void test4() {
        Map<String, Integer> map = new ConcurrentHashMap<>(16);
        for (int i=0; i<20; i++) {
            map.put(String.valueOf(i), i);
        }



    }


    public static void main(String[] args) {
        System.out.println(test1(15));
        test4();
    }

}
