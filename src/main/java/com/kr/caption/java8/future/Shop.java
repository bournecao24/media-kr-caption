package com.kr.caption.java8.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private String name;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice(String product) {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Shop(String name) {
        this.name = name;
    }

    public void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }


    public Future<Double> getPriceAsync(String product) {
        //创建CompletableFuture 对象，它会包含计算的结果
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            //在另一个线程中以异步方式执行计算
            double price = calculatePrice(product);
            futurePrice.complete(price);    //需长时间计算的任务结束并得出结果时，设置Future的返回值
        }).start();
        // 无需等待还没结束的计算，直接返回Future对象
        return futurePrice;
    }


    /**
     * 你需要使用 CompletableFuture的completeExceptionally方法将导致CompletableFuture内发生问题的异常抛出。
     * @param product
     * @return
     */
    public Future<Double> getPriceAsyncAndDealExecption(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            }catch (Exception ex){
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        return futurePrice;
    }


    /**
     * 使用工厂方法supplyAsync创建CompletableFuture对象
     * 接受一个Supplier生产者作为参数
     * @param product
     * @return
     */
    public Future<Double> getPriceAsyncByFactoryMethod(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }


    public static void main(String[] args) {
        Shop shop = new Shop("as");
        ExecutorTest executorTest = new ExecutorTest();

        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        executorTest.doSomethingElse(); // 执行更多任务，比如查询其他商店

        // 在计算商品价格的同时
        try {
            double price = futurePrice.get();     //从Future对象中读 取价格，如果价格 未知，会发生阻塞
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
}

