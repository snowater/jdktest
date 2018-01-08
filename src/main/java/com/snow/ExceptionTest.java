/**
 * @(#) ExceptionTest.java 2017/12/20
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author hzwanghuiqi
 * @version 2017/12/20
 */
@Slf4j
public class ExceptionTest {

    public static void test1() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }

        // 复现方法一
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                arrayList.remove(integer);
            }
        }

        // 复现方法二
        iterator = arrayList.iterator();
        for (Integer value : arrayList) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                arrayList.remove(integer);
            }
        }
    }

    public static void test2() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }

        ListIterator<Integer> iterator = arrayList.listIterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                iterator.set(Integer.valueOf(6));
                iterator.remove();
                iterator.add(integer);
            }
        }
    }

    public static void test3() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<Integer> iterator = arrayList.listIterator();
                while (iterator.hasNext()) {
                    System.out.println("thread1 " + iterator.next().intValue());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<Integer> iterator = arrayList.listIterator();
                while (iterator.hasNext()) {
                    Integer integer = iterator.next();
                    System.out.println("thread2 " + integer.intValue());
                    if (integer.intValue() == 5) {
                        iterator.remove();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void test4() {
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 20; i++) {
            vector.add(Integer.valueOf(i));
        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<Integer> iterator = vector.listIterator();
                while (iterator.hasNext()) {
                    System.out.println("thread1 " + iterator.next().intValue());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<Integer> iterator = vector.listIterator();
                while (iterator.hasNext()) {
                    Integer integer = iterator.next();
                    System.out.println("thread2 " + integer.intValue());
                    if (integer.intValue() == 5) {
                        iterator.remove();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void test5() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (arrayList) {
                    ListIterator<Integer> iterator = arrayList.listIterator();
                    while (iterator.hasNext()) {
                        System.out.println("thread1 " + iterator.next().intValue());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (arrayList) {
                    ListIterator<Integer> iterator = arrayList.listIterator();
                    while (iterator.hasNext()) {
                        Integer integer = iterator.next();
                        System.out.println("thread2 " + integer.intValue());
                        if (integer.intValue() == 5) {
                            iterator.remove();
                        }
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }


    public static void test6() {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(Integer.valueOf(i));
        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<Integer> iterator = list.listIterator();
                while (iterator.hasNext()) {
                    System.out.println("thread1 " + iterator.next().intValue());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
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
//                ListIterator<Integer> iterator = list.listIterator();
//                while (iterator.hasNext()) {
//                    Integer integer = iterator.next();
//                    System.out.println("thread2 " + integer.intValue());
//                    if (integer.intValue() == 5) {
//                        iterator.remove();
//                    }
//                }
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void test7() {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(Integer.valueOf(i));
        }
        System.out.println(list.hashCode());
        list.add(21);
        System.out.println(list.hashCode());
        list.add(22);
        System.out.println(list.hashCode());
        list.add(23);
        System.out.println(list.hashCode());
        list.add(24);
        System.out.println(list.hashCode());
        list.add(25);
        System.out.println(list.hashCode());
        list.remove(0);
        System.out.println(list.hashCode());
        list.remove(0);
        System.out.println(list.hashCode());
        list.remove(0);
        System.out.println(list.hashCode());
        list.remove(0);
        System.out.println(list.hashCode());
    }

    public static void main(String[] args) {
        test7();
    }

}
