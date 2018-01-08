/**
 * @(#) StringTest.java 2017/10/09
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

import java.io.UnsupportedEncodingException;

/**
 * @author wanghuiqi
 * @version 2017/10/09
 */
public class StringTest {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
        test4();
    }

    public static void test1() {
        try {
            String str = new String("中国China");
            byte[] bytes = str.getBytes("uTf-8");
            String str2 = new String(bytes, "UtF-8");
            System.out.println(str2);
            System.out.println(str == str);
            System.out.println(str.equalsIgnoreCase(str2));
            System.out.println(str == str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String source = "abcdeefffffffbcdeffff";
        String dest = "bcdef";
        int index = source.indexOf(dest);
        System.out.println(index);


        String splitStr = "aaa\\nbbbb\nccc      ";
        String[] splitArray = splitStr.split("\\n");
        System.out.println("split size : " + splitArray.length);
        for (String temp : splitArray) {
            System.out.print(temp + "|");
        }

        System.out.println();
        splitStr = ",,a,b,c,d,,,,";
        splitArray = splitStr.split(",");
        for (String temp : splitArray) {
            System.out.print(temp + "|");
        }
        System.out.println(splitArray.length);

        System.out.println();
        splitStr = ",,a,b,c,d,,,,";
        splitArray = splitStr.split(",", -1);
        for (String temp : splitArray) {
            System.out.print(temp + "|");
        }
        System.out.println(splitArray.length);

        System.out.println();
        splitStr = ",,a,b,c,d,,,,";
        splitArray = splitStr.split(",", 5);
        for (String temp : splitArray) {
            System.out.print(temp + "|");
        }
        System.out.println(splitArray.length);

        String joinerStr = String.join(",", "1", "2", "3");
        System.out.println(joinerStr);

        System.out.println("|" + "  \n\r\r\n\t\0\faaaaaabbbbb  \r\n\t\f\b\0   ".trim() + "|");
        System.out.println("|" + "  \n\r\r\n\t\0\f  \r\n\t\f\b\0   ".trim() + "|");
    }

    public static void test2() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = "a" + "b";
        String str5 = str1 + str2;
        String str6 = new String("ab");

        System.out.println(str4 == str3);
        System.out.println(str5 == str3);
        System.out.println(str6 == str3);
        System.out.println(str4.intern() == str3);
        System.out.println(str5.intern() == str3);
        System.out.println(str6.intern() == str3);
    }

    public static void test3() {
        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern(); // 此处调用并不会改变s3的地址
        System.out.println(s3 == s4);
        System.out.println(s3.intern() == s4);
    }

    public static void test4() {
        String s3 = new String("1") + new String("1");
        s3.intern(); // 此处调用并不会改变s3的地址
        String s4 = "11";
        System.out.println(s3 == s4);
        System.out.println(s3.intern() == s4);
    }
}
