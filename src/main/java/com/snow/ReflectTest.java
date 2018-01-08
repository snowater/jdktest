/**
 * @(#) ReflectTest.java 2018/01/08
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author snow
 * @version 2018/01/08
 */
public class ReflectTest {

    public static void test1() {
        try {
            Class<TestReflect> c = TestReflect.class;
            TestReflect testReflect= c.newInstance();

            // Method
            Method[] methods = c.getMethods();
            Method[] methods1 = c.getDeclaredMethods();
            System.out.print("getMethods: ");
            for (Method method : methods) {
                System.out.print(method.getName() + " ");
            }
            System.out.print("\n\ngetDeclaredMethods: ");
            for (Method method : methods1) {
                System.out.print(method.getName() + " ");
            }

            // Field
            Field[] fields = c.getFields();
            Field[] fields1 = c.getDeclaredFields();
            System.out.print("\n\ngetFields: ");
            for (Field field : fields) {
                System.out.print(field.getName() + " ");
            }
            System.out.print("\n\ngetDeclaredFields: ");
            for (Field field : fields1) {
                System.out.print(field.getName() + " ");
            }

            // invoke
            System.out.println("\n\ninvoke:");
            for (Method method : methods1) {
                method.setAccessible(true); // 关闭access访问权限检查
                Object result = method.invoke(testReflect, "invoke");
                System.out.println(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test1();
    }


}
