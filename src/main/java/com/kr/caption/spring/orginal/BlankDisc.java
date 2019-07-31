package com.kr.caption.spring.orginal;

import java.util.List;

public class BlankDisc implements Compactdic {

    private String title;
    private String article;
    private List<String> tracks;


    public BlankDisc(String title, String article, List<String> tracks) {
        this.title = title;
        this.article = article;
        this.tracks = tracks;
    }

    @Override
    public void play() {

    }
}
