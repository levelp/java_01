package com.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Перевод даты в формат БД и обратно
 */
public class OracleDateHelper {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String toStr(Date date) {
        return dateFormat.format(date);
    }

    public static Date parse(String s) throws ParseException {
        return dateFormat.parse(s);
    }
}
