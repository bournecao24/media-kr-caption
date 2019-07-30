package com.kr.caption.spring.orginal;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements Compactdic {

    private String title = "This is title";
    private String artist = "This is artist";

    @Override
    public void play() {
        System.out.println(artist + " Playing" + title);
    }
}
