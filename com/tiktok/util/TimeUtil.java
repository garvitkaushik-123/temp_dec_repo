package com.tiktok.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class TimeUtil {
    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static String getISO8601Timestamp(Date date) {
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df.format(date);
    }

    public static String dateStr(int dayDifference) {
        Calendar calendar = Calendar.getInstance();
        if (dayDifference != 0) {
            calendar.add(5, dayDifference);
        }
        return sdf.format(calendar.getTime());
    }

    public static boolean isNowAfter(String referenceStr, int days) {
        return dateStr(-days).equals(referenceStr);
    }
}
