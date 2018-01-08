/**
 * @(#) StringBufferTest.java 2017/10/11
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

/**
 * @author snow
 * @version 2017/10/11
 */
public class StringBufferTest {

    public static void test1() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder.capacity());
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer.capacity());
    }

    public static void test2() {

    }


    public static void main(String[] args) {
        test1();
        test2();

    }

}
