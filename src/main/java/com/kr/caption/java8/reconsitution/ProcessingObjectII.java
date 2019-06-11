package com.kr.caption.java8.reconsitution;

public class ProcessingObjectII extends ProcessingObject<String> {
    public String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
