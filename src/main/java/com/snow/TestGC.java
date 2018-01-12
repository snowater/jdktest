/**
 * @(#) TestGC.java 2018/01/11
 * Copyright 2016 Snow.com, Inc. All rights reserved.
 */
package com.snow;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author snow
 * @version 2018/01/11
 */
public class TestGC {

    public static void main(String args[]) {
        List<GarbageCollectorMXBean> l = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean b : l) {
            System.out.println(b.getName());
        }
    }
}
