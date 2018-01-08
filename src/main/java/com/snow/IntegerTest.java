/**
 * @(#) IntegerTest.java 2017/10/13
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

/**
 * @author snow
 * @version 2017/10/13
 */
public class IntegerTest {

    public static void test1() {
        int i = 123456789;
        String string = Integer.toString(i);
        System.out.println(string);
    }

    public static void test2() {
        int i = -35;
        System.out.println(Integer.toString(i, 36));
        System.out.println(Integer.toUnsignedString(35, 36));


        System.out.println(Integer.parseInt("-987654321"));
        System.out.println(Integer.parseInt("987654321"));

        System.out.println(Integer.highestOneBit(15));
        System.out.println(Integer.lowestOneBit(15));

        System.out.println(Integer.reverse(123456789));
        System.out.println(Integer.reverseBytes(123456789));


        System.out.println(Integer.toUnsignedString(-1));
    }

    public static void main(String[] args) {
        test1();

        test2();
    }
}
