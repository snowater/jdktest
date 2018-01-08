/**
 * @(#) List.java 2017/09/30
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author wanghuiqi
 * @version 2017/09/30
 */
@Slf4j
public class ListTest {

    public static void test1() {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.ensureCapacity(20);
    }

    public static void test2() {
        ArrayList<Integer> testList = new ArrayList<>();
        ArrayList<Integer> retainList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                retainList.add(i);
            }
            testList.add(i);
        }
        testList.retainAll(retainList);
        for (Integer integer : testList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void test3() throws IOException {
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            testList.add(i);
        }
        Iterator<Integer> iterator = testList.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value == 5) {
                // testList.remove(5);
                iterator.remove();
            }
        }

        ListIterator<Integer> listIterator = testList.listIterator();
        while (listIterator.hasNext()) {
            int value = listIterator.next();
            if (value == 6) {
                listIterator.remove();
                listIterator.add(5);
            }
        }

        List<Integer> subList = testList.subList(5, 10);
        for (Integer integer : subList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) throws IOException {
        test3();
    }

}
