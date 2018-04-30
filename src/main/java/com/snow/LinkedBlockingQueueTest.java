/**
 * @(#) LinkedBlockingQueueTest.java 2018/04/29
 *
 * Copyright 2018 snow.com, Inc. All rights reserved.
 */
package com.snow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author snow
 * @version 2018/04/29
 */
public class LinkedBlockingQueueTest {

    public static void test1() {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
        List<String> stringList = new ArrayList<>(5);
        List<String> stringList1 = new ArrayList<>();
        for (int i = 0 ; i< 10; i++) {
            queue.offer(String.valueOf(i));
        }
        queue.drainTo(stringList);

        for (int i = 0 ; i< 10; i++) {
            queue.offer(String.valueOf(i));
        }
        queue.drainTo(stringList1, 5);

        for (String temp : stringList) {
            System.out.print(temp + " ");
        }
        System.out.println();


        for (String temp : stringList1) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test1();
    }

}
