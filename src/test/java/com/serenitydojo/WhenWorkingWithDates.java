package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class WhenWorkingWithDates{

    @Test
    public void gettingTodayDay(){
        LocalDate today = LocalDate.now();
        System.out.println("getDayOfWeek is: "+today.getDayOfWeek());

        Assertions.assertThat(today.getDayOfWeek()).isEqualByComparingTo(DayOfWeek.TUESDAY);
        Assertions.assertThat(today.getDayOfWeek()).isEqualByComparingTo(DayOfWeek.MONDAY);
    }

    @Test
    public void creatingATimestampForToday(){
        LocalDate today = LocalDate.now();
        System.out.println("Today is: "+today);

        LocalTime now = LocalTime.now();
        System.out.println("The time is: "+now);
    }

    @Test
    public void createAGivenDate(){
        LocalDate fourthOfJuly = LocalDate.of(2020, 7, 4);
        System.out.println("The Fourth Of July: "+fourthOfJuly);
    }

    @Test
    public void parsingADate(){
        String dateInStringForm = "2020-05-01";
        LocalDate firstOfMay = LocalDate.parse(dateInStringForm);
        System.out.println(firstOfMay);
    }

    @Test
    public void pasingADateWithAGivenFormat(){
        LocalDate mayFirst = LocalDate.parse("05/01/2020", DateTimeFormatter.ofPattern("MM/dd/yyyy")); // 2020-05-01
        System.out.println(mayFirst);
    }

    @Test
    public void yesterday(){
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minus(1, ChronoUnit.CENTURIES);
        System.out.println(yesterday);
    }

    @Test
    public void checkingTheMonth(){
        LocalDate today = LocalDate.now();
        System.out.println(today.getYear());
        System.out.println(today.getMonth());
        System.out.println(today.getDayOfMonth());

        Assertions.assertThat(today.getMonth()).isEqualByComparingTo(Month.APRIL);

    }

    @Test
    public void comparingDates(){
        LocalDate firstOfMay = LocalDate.of(2022, 5, 1);
        LocalDate fifthOfMay = LocalDate.of(2022, 5, 5);
        LocalDate tenthOfMay = LocalDate.of(2022, 5, 10);

        Assertions.assertThat(firstOfMay).isBefore(fifthOfMay);
        Assertions.assertThat(fifthOfMay).isBetween(firstOfMay, tenthOfMay);
    }

    @Test
    public void usingTimes(){
        LocalTime now = LocalTime.now();
        LocalTime fiveHoursAgo = now.minus(5, ChronoUnit.HOURS);
        System.out.println(fiveHoursAgo);
    }
}
