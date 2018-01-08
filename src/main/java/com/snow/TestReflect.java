/**
 * @(#) ReflectTest.java 2018/01/08
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

/**
 * @author snow
 * @version 2018/01/08
 */
public class TestReflect {
    public String param1;
    private String param2;

    public TestReflect() {
    }

    public TestReflect(String para) {
        this.param1 = para;
    }

    public String test1(String param) {
        System.out.println("public test1 " + param);
        return "return public test1 " + param;
    }

    private String test2(String param) {
        System.out.println("private test2 " + param);
        return "return private test2 " + param;
    }

    protected String test3(String param) {
        System.out.println("protected test3 " + param);
        return "return protected test3 " + param;
    }

    String test4(String param) {
        System.out.println("test4 " + param);
        return "return test4 " + param;
    }

}

