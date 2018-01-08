/**
 * @(#) LangTest.java 2017/09/30
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wanghuiqi
 * @version 2017/09/30
 */
@Slf4j
public class LangTest {

    public static void test1() {
        System.out.println(Long.divideUnsigned(10L, 3L));
        System.out.println(Long.remainderUnsigned(10L, 3L));

        System.out.println(Long.divideUnsigned(10L, -3L));
        System.out.println(Long.remainderUnsigned(10L, -3L));

        System.out.println(Long.divideUnsigned(-10L, -3L));
        System.out.println(Long.remainderUnsigned(-10L, -3L));

        System.out.println(Long.divideUnsigned(-3L, -10L));
        System.out.println(Long.remainderUnsigned(-3L, -10L));

        System.out.println(Long.sum(9223372036854775807L, 9223372036854775807L ));
    }

    public static void main(String[] args) {
        test1();

    }

}
