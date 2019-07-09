package com.kr.caption.java8.future.asyncStream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Discount {

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    private static final Random random = new Random();


    List<AnotherShop> shops = Arrays.asList(new AnotherShop("BestPrice"),
            new AnotherShop("LetsSaveBig"),
            new AnotherShop("MyFavoriteShop"),
            new AnotherShop("BuyItAll"));


    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);   //使用守护线程——这种方式不会阻止程序的关停
            return t;
        }
    });

    public static void randomDelay() {
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " +
                Discount.apply(quote.getPrice(),
                        quote.getDiscountCode());   //将折扣代码应 用于商品最初 的原始价格
    }

    private static double apply(double price, Code code) {
        delay();
        return price * (100 - code.percentage) / 100;
    }


    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(toList());
    }


    public List<String> findPricesAnsyc(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse)) //同步操作
                //thenCompose方法允许你对两个异步操作进行流水线，第一个操作完成时，将其结果作为参数传递给第二个操作
                //thenComposeAsync由不同的线程去处理，用之前的，因为上一个更高效，少了线程切换的开销
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote), executor)))
                .collect(toList());


//        Future<Double> futurePriceInUSD =
//                CompletableFuture.supplyAsync(() -> shop.getPrice(product)).thenCombine(
//                        CompletableFuture.supplyAsync(
//                                () ->  exchangeService.getRate(Money.EUR, Money.USD)),
//                        (price, rate) -> price * rate
//                );

        //将两个完 全不相干的CompletableFuture对象的结果整合起来，而且你也不希望等到第一个任务完全结束才开始第二项任务；thenCombine


        return priceFutures.stream()
                .map(CompletableFuture::join).collect(toList());

    }


    /**
     * 直 接处理CompletableFuture流，这样每个CompletableFuture都在为某个商店执行必要的操作。
     *
     * @param product
     * @return
     */
    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote), executor)));
    }


    public static void main(String[] args) {

        Discount discount = new Discount();
        //在每一个completeFuture对象上注册一个操作，该操作会在CompletableFuture完成执行后使用它的返回值
        //对这个<CompletableFuture<Void>>对象，你能做的事非常有限，只能等待其运行结束，希望 能给最慢的商店一些机会，让它有机会打印输出返回的价格。
        // 为了实现这一目的，你可以把构成 Stream的所有CompletableFuture<Void>对象放到一个数组中，等待所有的任务执行完成.

//        CompletableFuture[] futures = discount.findPricesStream("myPhone")
//                .map(f -> f.thenAccept(System.out::println))
//                .toArray(size -> new CompletableFuture[size]);
//        CompletableFuture.allOf(futures).join();

        long start = System.nanoTime();
        CompletableFuture[] futures = discount.findPricesStream("myPhone27S")
                .map(f -> f.thenAccept(
                        s -> System.out.println(s + " (done in " +
                                ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        System.out.println("All shops have now responded in "
                + ((System.nanoTime() - start) / 1_000_000) + " msecs");

    }


}
