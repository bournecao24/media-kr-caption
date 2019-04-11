package com.kr.caption;

import java.util.LinkedList;

public class TestClass {

    private static int initStaticValue = 234;
    private static String initStringValue = "init";

    private static StringBuilder initStringBuilder = new StringBuilder(" init_StringBuilder");

    public static void main(String[] args) {

        LinkedList<Object> objects = new LinkedList<>();

        modValue(initStaticValue);
        modString(initStringValue);

        modString(initStringBuilder, initStringBuilder);

        System.out.println(initStaticValue);

        modValue();
        System.out.println(initStaticValue);

        System.out.println(initStringValue);
        System.out.println(initStringBuilder);

    }

    private static void modValue(int initStaticValue) {
        initStaticValue = 567;
    }

    private static void modValue(){
        initStaticValue = 890;
    }

    private static void modString(String initStringValue){
        initStringValue = " another_string";
    }

    private static void modString(StringBuilder stringBuilder1, StringBuilder stringBuilder2){
        stringBuilder1.append(" add string first");
        stringBuilder2.append(" add string second");

        stringBuilder1 = new StringBuilder(" new StringBuilder");
        stringBuilder1.append(" new StringBuilder append");
    }
}
