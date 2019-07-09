package com.kr.caption.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class AnotherGetPrice {

    List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));


    /**
     * 创建一个线 程池，线程 池中线程的 数目为100 和商店数目 二者中较小 的一个值
     * 这是一个由守护线程构成的线程池，ava程序无法终止或者退出一个正 在运行中的线程，
     * 所以最后剩下的那个线程会由于一直等待无法发生的事件而引发问题。与此相反，
     * 如果将线程标记为守护进程，意味着程序退出时它也会被回收。
     */
    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setDaemon(true);   //使用守护线程——这种方式不会阻止程序的关停
                    return t;
                }
            });


    public List<String> findPrices(String product) {
        return shops.stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    /**
     * 并行流
     *
     * @param product
     * @return
     */
    public List<String> findPricesParallel(String product) {
        return shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }


    /**
     * 需要等到所有的Fututre都执行完毕
     * CompletableFuture类中的join方法和Future接口中的get有相同的含义
     * 它们唯一的不同是join不会抛出任何检测到的异常。使用它你不再需要使用 try/catch语句块让你传递给第二个map方法的Lambda表达式变得过于臃肿。
     *
     * @param product
     * @return
     */
    public List<String> findPricesCompletedFuture(String product) {
//        List<CompletableFuture<String>> list = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))).collect(Collectors.toList());
        List<CompletableFuture<String>> list = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " +
                shop.getPrice(product), executor)).collect(Collectors.toList());
        return list.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        AnotherGetPrice price = new AnotherGetPrice();

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
        long start = System.nanoTime();
        System.out.println(price.findPricesCompletedFuture("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

}
