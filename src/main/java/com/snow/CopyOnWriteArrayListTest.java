/**
 * @(#) CopyOnWriteArrayListTest.java 2017/12/22
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author hzwanghuiqi
 * @version 2017/12/22
 */
@Slf4j
public class CopyOnWriteArrayListTest {

    public static void test1() {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(Integer.valueOf(i));
        }

        int hashCode = list.hashCode();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<Integer> iterator = list.listIterator();
                while (iterator.hasNext()) {
                    Integer integer = iterator.next();
                    System.out.println("thread1 " + integer.intValue());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (list.hashCode() != hashCode) {
                        log.info("list has changed!");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer integer : list) {
                    System.out.println("thread2 " + integer.intValue());
                    if (integer.intValue() == 5) {
                        list.remove(integer);
                    }
                }
                for (Integer integer : list) {
                    System.out.println("thread2 again " + integer.intValue());
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        test1();


    }

}
