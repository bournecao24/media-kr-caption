package com.kr.caption.java8.reconsitution;

public class ProcessingObjectI extends ProcessingObject<String> {
    public String handleWork(String text) {
        return "ObjectI::  labda" + text;
    }
}
