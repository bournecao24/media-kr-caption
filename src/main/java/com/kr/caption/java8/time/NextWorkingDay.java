package com.kr.caption.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.*;


public class NextWorkingDay implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        int i = temporal.get(ChronoField.DAY_OF_WEEK);
        DayOfWeek ofWeek = DayOfWeek.of(i);

        int dayAdd = 1;
        if (ofWeek == DayOfWeek.FRIDAY) {
            dayAdd = 3;
        } else if (ofWeek == DayOfWeek.SATURDAY) {
            dayAdd = 2;
        }

        return temporal.plus(dayAdd, ChronoUnit.DAYS);
    }

    // 如果你想要使用Lambda表达式定义TemporalAdjuster对象，推荐使用Temporal- Adjusters类的静态工厂方法ofDateAdjuster，它接受一个UnaryOperator<LocalDate>
    public TemporalAdjuster initTemporal(LocalDate date) {
        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        date = date.with(nextWorkingDay);

        return nextWorkingDay;
    }
}
