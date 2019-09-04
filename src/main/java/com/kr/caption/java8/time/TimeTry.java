package com.kr.caption.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static java.time.temporal.TemporalAdjusters.*;


public class TimeTry {
    private void LocateDateTest() {

        //LocalDate 不可变对象，只包含简单的日期，无时区
        //通过静态工厂方法of创建一个LocalDate实例
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        LocalDate today = LocalDate.now();


        LocalDate dateParse = LocalDate.parse("2014-03-18");

    }

    private void LocateTimeTest() {

        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        LocalTime timeParse = LocalTime.parse("13:45:20");

    }


    /**
     * LocalDate和LocalTime的合体。它同时表示了日期
     * 和时间，但不带有时区信息，你可以直接创建，也可以通过合并日期和时间对象构造
     */
    private void LocalDateTimeTest() {

        LocalDate date = LocalDate.parse("2014-03-18");
        LocalTime time = LocalTime.parse("13:45:20");

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();

    }

    private void DurationTest() {

        LocalDate date1 = LocalDate.parse("2014-03-18");
        LocalDate date2 = LocalDate.parse("2014-03-18");
        LocalTime time1 = LocalTime.parse("13:45:20");
        LocalTime time2 = LocalTime.parse("13:45:20");
        Instant instant1 = Instant.now();
        Instant instant2 = Instant.now();

        Duration d1 = Duration.between(time1, time2);
        Duration d2 = Duration.between(date1, date2);
        Duration d3 = Duration.between(instant1, instant2);

        //如果你需要以年、月或者日的方式对多个时间单位建模，可以使用Period类
        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
                LocalDate.of(2014, 3, 18));

        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);
        Period tenDays1 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

    }

    private void modLocateDateTest() {

        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);

        LocalDate date11 = LocalDate.of(2014, 3, 18);
        LocalDate date22 = date1.plusWeeks(1);
        LocalDate date33 = date2.minusYears(3);
        LocalDate date44 = date3.plus(6, ChronoUnit.MONTHS);

    }

    private void temporalAdjusterTest() {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.FRIDAY));
        date2.with(lastDayOfMonth());
        TemporalAdjuster adjuster = lastDayOfYear();
        date2.with(adjuster);
    }


    private void autoHotNews() {
        //过去两个小时的毫秒数
        LocalDateTime time = LocalDateTime.now().minus(2, ChronoUnit.DAYS);
        ZonedDateTime zone = time.atZone(ZoneId.systemDefault());
        long twoDaysMilli = zone.toInstant().toEpochMilli();
    }


    //所有的DateTimeFormatter实例都是线程安全的，可以以单例模式创建一个DateTimeFormatter
    private void dataTimeFormatterTest() {

        LocalDate date = LocalDate.of(2018, 3, 3);
        String format = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String format1 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format + "++++" + format1);

        //20180303++++2018-03-03

        LocalDate parse = LocalDate.parse("20180318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parse1 = LocalDate.parse("2018-09-23", DateTimeFormatter.ISO_LOCAL_DATE);


        //支持自定义格式器的静态工厂方法
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String format2 = date.format(dateTimeFormatter);


        //自定义格式举例
        String starTime = "2019-08-09";
        LocalDate activityDate = LocalDate.parse(starTime);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MM月dd日");
        String activityFormat = activityDate.format(pattern);
        System.out.println(activityFormat);



        //格式化时间
        String time ="2019-07-17T06:53:56.762Z";
        LocalDate parseDate = LocalDate.parse(time);
        DateTimeFormatter patternDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDate = parseDate.format(patternDate);
        System.out.println(formatDate);


        LocalDate parse2 = LocalDate.parse(format2, dateTimeFormatter);
        System.out.println(format2);
    }

    //创建一个本地的化DateTimeFormatter
    private void createLocalDateTimeFormatter() {

        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1.format(italianFormatter); // 18. marzo 2014
        LocalDate date2 = LocalDate.parse(formattedDate, italianFormatter);


        //构造一个DateTimeFormatter
        DateTimeFormatter italianFormatters = new DateTimeFormatterBuilder().appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
        String format = date1.format(italianFormatters);
        System.out.println(format);

    }


    private void zoneDeal() {

        ZoneId romeZone = ZoneId.of("Europe/Rome");

        LocalDate localDate = LocalDate.of(2019, Month.MARCH, 18);
        ZoneId zoneId = TimeZone.getDefault().toZoneId();

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(romeZone);


    }


    public static void main(String[] args) {

        TimeTry timeTry = new TimeTry();
        timeTry.createLocalDateTimeFormatter();


    }


    //start 需求：得到本周自然周和本月自然月的开始时间和结束时间 以下两个方法为旧版本

    private Date getWeekMinDateTime(LocalDateTime localDateTime) {

        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            c.add(Calendar.DAY_OF_MONTH, -1);
        }
        c.add(Calendar.DATE, c.getFirstDayOfWeek() - c.get(Calendar.DAY_OF_WEEK) + 1);
        Date time = c.getTime();
        return time;
    }

    private Date getWeekMaxDateTime(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        // 如果是周日直接返回
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            return date;
        }
        c.add(Calendar.DATE, 7 - c.get(Calendar.DAY_OF_WEEK) + 1);
        Date macTime = c.getTime();
        return macTime;
    }

    private void getWeekAndMonthTime(){

        LocalDateTime nowTime = LocalDateTime.now();
        LocalDate nowDate = nowTime.toLocalDate();

        LocalDate monthFirstDay = LocalDate.of(nowTime.getYear(), nowTime.getMonth(), 1);
        LocalDate monthLastDay = nowDate.with(TemporalAdjusters.lastDayOfMonth());

        LocalDate weekFirstDay = nowTime.with(DayOfWeek.MONDAY).toLocalDate();
        LocalDate weekLastDay = nowTime.with(DayOfWeek.SUNDAY).toLocalDate();


    }

    //需求结束



}
