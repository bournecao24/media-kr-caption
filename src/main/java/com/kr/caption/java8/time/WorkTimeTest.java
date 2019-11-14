package com.kr.caption.java8.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class WorkTimeTest {

    private static final Integer EXPIRE_MONTH = 10;
    private static final Integer EXPIRE_DAY = 1;

    /**
     * 计算过期时间
     *
     * @return
     */
    private Long getExpireTime() {

        LocalDate expireDate = LocalDate.of(LocalDate.now().getYear(), EXPIRE_MONTH, EXPIRE_DAY);

        if (LocalDate.now().isBefore(expireDate)) {
            getDateMinTime(expireDate);
        } else {
            getDateMinTime(expireDate.plusYears(1));
        }

        //----以下为自己写

        //当前时间
        LocalDate now = LocalDate.now();
        long nowTime = Instant.now().toEpochMilli();


        //本年过期时间
        LocalDate localDate = now.withMonth(EXPIRE_MONTH).withDayOfMonth(EXPIRE_DAY);
        long thisYearExpireTime = getDateMinTime(localDate);

        //第二年过期时间
        LocalDate laterYear = localDate.plusYears(1);
        LocalDateTime dateTime = laterYear.atTime(0, 0);
        long afterYearTime = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        if (nowTime > thisYearExpireTime) {
            return afterYearTime;
        }

        return thisYearExpireTime;

    }


    public static long getDateMinTime(LocalDate localDate) {
        return localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

}
