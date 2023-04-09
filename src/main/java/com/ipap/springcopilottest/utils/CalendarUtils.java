package com.ipap.springcopilottest.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalendarUtils {

    public static String getCurrentDate() {
        return java.time.LocalDate.now().toString();
    }

    public static String getCurrentTime() {
        return java.time.LocalTime.now().toString();
    }

    public static String getCurrentDateTime() {
        return java.time.LocalDateTime.now().toString();
    }

    public int calculateDaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }

    public int calculateMonthsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return (int) ChronoUnit.MONTHS.between(startDate, endDate);
    }

    public int calculateYearsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return (int) ChronoUnit.YEARS.between(startDate, endDate);
    }

    public int calculateWeeksBetweenDates(LocalDate startDate, LocalDate endDate) {
        return (int) ChronoUnit.WEEKS.between(startDate, endDate);
    }

    public int calculateHoursBetweenDates(LocalDate startDate, LocalDate endDate) {
        return (int) ChronoUnit.HOURS.between(startDate, endDate);
    }

    public int getDaysFromDate(LocalDate date) {
        return date.getDayOfMonth();
    }

    public int getYearFromDate(LocalDate date) {
        return date.getYear();
    }

}
