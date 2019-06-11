package com.kr.caption.java8.reconsitution;

public class ReconsitutionTest {


    interface Task {
        public void execute();
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task a) {
        a.execute();
    }

}
