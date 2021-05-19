package com.tjut.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String date2String(Date d) {
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dFormat.format(d);
    }

    public static Date string2Date(String s) {
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
