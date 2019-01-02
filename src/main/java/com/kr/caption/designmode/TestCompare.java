package com.kr.caption.designmode;

import com.kr.caption.designmode.template.Compareto;

import java.util.Arrays;

public class TestCompare {

    public static void main(String[] args) {
        Compareto [] example = {
                new Compareto("first", 3),
                new Compareto("f", 34),
                new Compareto("fi", 34),
                new Compareto("fir", 31),
                new Compareto("firs", 35),
                new Compareto("first", 9),
        };

        Arrays.sort(example);
        display(example);

    }

    public static void display(Compareto [] examples){
        for(Compareto com:examples){
            System.out.println(com);
        }
    }
}
