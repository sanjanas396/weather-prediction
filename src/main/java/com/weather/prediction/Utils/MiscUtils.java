package com.weather.prediction.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MiscUtils {

    public static String getCurrentDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDateTime.format(formatter);
    }

    public static String getDateFromTs(String timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate date = LocalDate.parse(timestamp, formatter);
        return date.toString();
    }
}
