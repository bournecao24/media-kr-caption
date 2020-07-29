package com.kr.caption.concurrent.interview.workPattern;

public class TimerTask implements Task {


    private static int count = 0;
    private int num = count;

    public TimerTask() {
        count++;
    }

    @Override
    public void execute() {

        System.out.println("[TimerTask " + num + "] start...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        System.out.println("[TimerTask " + num + "] done.");
    }
}
