package com.kr.caption.java8.future.asyncStream;

import java.util.Random;

public class AnotherShop {


    private String name;
    private String price;


    public void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);

        Random random = new Random();
        Discount.Code code = Discount.Code.values()[
                random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }


    public static void main(String[] args) {
        AnotherShop anotherShop = new AnotherShop("another");

        String asss = anotherShop.getPrice("asss");
        System.out.println(asss);
    }


    public AnotherShop(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}