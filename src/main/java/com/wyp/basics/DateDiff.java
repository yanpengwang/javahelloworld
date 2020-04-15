package com.wyp.basics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class DateDiff {

    static long calDateDiff(String date1, String date2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return Math.abs(ChronoUnit.DAYS.between(LocalDate.parse(date1, dtf), LocalDate.parse(date2, dtf)));
    }

    public static void main(String[] args) {
        System.out.println(calDateDiff("2029-02-01", "2021-02-11"));
    }
}


