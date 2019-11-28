package com.kr.caption.normal;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProcessTimer {
    private ProcessTimer() {
    }

    private List<OneStep> steps = new ArrayList<>();


    private static ThreadLocal<ProcessTimer> processTimerThreadLocal = new ThreadLocal<>();

    private static ProcessTimer getInstance() {
        ProcessTimer processTimer = processTimerThreadLocal.get();
        if (processTimer != null) {
            return processTimer;
        }
        processTimerThreadLocal.set(new ProcessTimer());
        return processTimerThreadLocal.get();
    }

    public static OneStep start() {
        return oneStep("start");
    }

    public static OneStep oneStep() {
        return oneStep(new OneStep(System.currentTimeMillis(), null));
    }

    public static OneStep oneStep(String log) {
        return oneStep(new OneStep(System.currentTimeMillis(), log));
    }

    private static OneStep oneStep(OneStep oneStep) {
        ProcessTimer processTimer = getInstance();

        int size = processTimer.steps.size();
        if (size == 0) {
            processTimer.steps.add(oneStep);
        } else {
            oneStep.previous = processTimer.steps.get(size - 1);
            processTimer.steps.add(oneStep);
        }
        return oneStep;
    }

    public static void printAll() {
        getInstance().steps.forEach(OneStep::print);
    }

    public static class OneStep {
        private String log;
        private long timestamp;
        private Duration duration;
        private long total;
        private int order;
        private OneStep previous;

        OneStep(long timestamp, String log) {
            this.timestamp = timestamp;
            this.log = log;
        }

        public String getLog() {
            return log;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public long getDuration() {
            if (previous == null) {
                return 0;
            }
            duration = Duration.between(Instant.ofEpochMilli(previous.getTimestamp()), Instant.ofEpochMilli(getTimestamp()));
            return duration.toMillis();
        }

        public int getOrder() {
            if (previous == null) {
                return 0;
            }
            order = previous.getOrder() + 1;
            return order;
        }

        public long getTotal() {
            if (previous == null) {
                return 0;
            }
            total = previous.getTotal() + getDuration();
            return total;
        }

        public void print() {
            System.out.println(toString());
        }

        @Override
        public String toString() {
            return "==>  OneStep_" + getOrder() + " {" +
                    "log='" + Objects.toString(getLog(), "") + '\'' +
                    ", duration=" + formatMs(getDuration()) +
                    ", total=" + formatMs(getTotal()) +
                    ", timestamp=" + getTimestamp() +
                    '}';
        }

        private String formatMs(Long millis) {
            return millis / 1000 + "_" + (millis + 1000) % 1000 + "ms";
        }
    }


    /*public static void main(String[] args) throws InterruptedException {
        ProcessTimer.start().print();
        ProcessTimer.oneStep().print();
        Thread.sleep(Duration.ofSeconds(1).toMillis());
        ProcessTimer.oneStep("first step").print();
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        ProcessTimer.oneStep("second step").print();
        Thread.sleep(Duration.ofSeconds(1).toMillis());
        ProcessTimer.oneStep("third step").print();


        System.out.println();


        ProcessTimer.printAll();
    }*/


}
