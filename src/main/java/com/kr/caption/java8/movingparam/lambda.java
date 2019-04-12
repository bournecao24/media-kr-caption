package com.kr.caption.java8.movingparam;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class lambda {


    //资源处理，就是打开一个资源，做些处理，再关闭，
    public static String processFile() throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            return bufferedReader.readLine();  //只能读第一行
        }

    }

    public static void updateProcessFile(){

//       String result =  processFile((BufferedReader br) -> br.readLine() + br.readLine());

    }


    public static void main(String[] args) {

        //   参数列表，参数   ->   返回值（lambda主体）

        //五种lambda
        Consumer<String> stringConsumer = (String s) -> s.length();

        Predicate<Apple> predicate = ((Apple a) -> a.getWeight() > 150);

//        (int x, int y) -> {
//            System.out.println("Result");
//            System.out.println(x + y);
//        };

//        () -> 42;

//        (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        //函数式接口的实现
        Runnable runnable = () -> System.out.println("Hello world1");

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello word");
            }
        };

    }
}
