package com.kr.caption.jvm;

import sun.misc.Unsafe;

import javax.management.MBeanAttributeInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * -Xms20m -Xmx20m
 */
public class DirectMemoryOOM {

    private static final int _1M= 1024 * 1024;

    public static void main(String[] args) {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];

    }
}
