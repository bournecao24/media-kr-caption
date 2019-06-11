package com.kr.caption.java8.reconsitution;


public class reconsitution {


    /**
     * 替换为Lambda
     */
    private void reconsitutionClass() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        };


        Runnable runnable1 = () -> System.out.println("Lambda表达式");
    }


    /**
     * 变量是否可以屏蔽
     */
    private void reconsitutionClassTest() {

        int a = 100;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int a = 200;
                System.out.println("匿名内部类");
            }
        };


        Runnable runnable1 = () -> {
//            int a = 200;
            System.out.println("Lambda表达式");
        };


    }


    public static void main(String[] args) {

        ReconsitutionTest.doSomething(new ReconsitutionTest.Task() {
            @Override
            public void execute() {
                System.out.println("Danger danger!!");
            }
        });


        //转换为Lambda的时候,会出现编译错误
//        ReconsitutionTest.doSomething(() -> System.out.println("Danger danger!!"));

        //可以用显式的转换
        ReconsitutionTest.doSomething((ReconsitutionTest.Task) () -> System.out.println("Danger danger!!"));

    }



}
