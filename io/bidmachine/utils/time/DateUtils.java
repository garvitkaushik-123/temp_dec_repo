package io.bidmachine.utils.time;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class DateUtils {
    private static final long DAY_IN_MS = TimeUnit.DAYS.toMillis(1);

    public static int daysBetween(Date startDate, Date endDate) {
        return (int) (Math.abs(beginOfDay(calendarFromDate(endDate)).getTimeInMillis() - beginOfDay(calendarFromDate(startDate)).getTimeInMillis()) / DAY_IN_MS);
    }

    public static Calendar beginOfDay(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static Calendar calendarFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
