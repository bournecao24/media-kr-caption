package com.kr.caption.designmode.jiketime.jike64Chapter;

public enum State {

    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);


    private int value;

    State(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
