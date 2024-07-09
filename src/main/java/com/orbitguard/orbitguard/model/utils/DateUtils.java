package com.orbitguard.orbitguard.model.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String format(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date parse(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date plusDays(Date date, int days) {
        long time = date.getTime();
        time += (long) days * 24 * 60 * 60 * 1000;
        return new Date(time);
    }

    public static Date minusDays(Date date, int days) {
        long time = date.getTime();
        time -= (long) days * 24 * 60 * 60 * 1000;
        return new Date(time);
    }
}
