package com.kr.caption.java8.movingparam;

import java.util.*;
import java.util.stream.Collectors;

public class Apple {

    private Long id;
    private Long weight;
    private String color;

    public Apple(Long weight) {
        this.weight = weight;
    }

    public Apple() {
    }

    public Apple(Long weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public static void main(String[] args) {

        List<Apple> appleList = new ArrayList<>();

        List<Apple> wantedAppleList = new ArrayList<>();
        for (Apple app : appleList) {
            if (app.getWeight() < 400) {
                wantedAppleList.add(app);
            }
        }

        Collections.sort(wantedAppleList, new Comparator<Apple>() {
            public int compare(Apple d1, Apple d2) {
                return Long.compare(d1.getWeight(), d2.getWeight());
            }
        });

        List<Long> appleIdList = new ArrayList<>();
        for (Apple d : wantedAppleList) {
            appleIdList.add(d.getId());
        }

        List<Long> appleId = appleList.stream().filter(apple -> apple.getWeight() < 400)
                .sorted(Comparator.comparing(Apple::getWeight))
                .map(Apple::getId)
                .collect(Collectors.toList());

        for (Apple apple : appleList) {
            System.out.println(apple.getWeight());
        }


    }
}
