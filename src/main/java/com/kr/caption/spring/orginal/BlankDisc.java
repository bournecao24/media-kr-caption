package com.kr.caption.spring.orginal;

public class BlankDisc implements Compactdic {

    private String title;
    private String article;

    public BlankDisc(String title, String article) {
        this.title = title;
        this.article = article;
    }

    @Override
    public void play() {

    }
}
