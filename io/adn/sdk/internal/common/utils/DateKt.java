package io.adn.sdk.internal.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Date.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0015\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00030\u0003H\u0000¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\n \t*\u0004\u0018\u00010\u00030\u0003H\u0000¢\u0006\u0002\u0010\n\u001a\b\u0010\f\u001a\u00020\rH\u0000\u001a\u0015\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u00030\u0003H\u0000¢\u0006\u0002\u0010\n\u001a\u001d\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\u0010\u0012\u001a\u001d\u0010\u0013\u001a\n \t*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\u0010\u0012\u001a\u001d\u0010\u0014\u001a\n \t*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\u0010\u0012\u001a\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"createSimpleDateFormat", "Ljava/text/SimpleDateFormat;", "pattern", "", "dateFormat", "utcDateFormat", "dateFormatMs", "utcDateFormatMs", "utcNow", "kotlin.jvm.PlatformType", "()Ljava/lang/String;", "now", "unixNow", "", "utcNowMs", "utcDate", "date", "Ljava/util/Date;", "(Ljava/util/Date;)Ljava/lang/String;", "utcDateMs", "localDate", "durationSecond", "", "startTime", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DateKt {
    private static final SimpleDateFormat dateFormat;
    private static final SimpleDateFormat dateFormatMs;
    private static final SimpleDateFormat utcDateFormat;
    private static final SimpleDateFormat utcDateFormatMs;

    public static final SimpleDateFormat createSimpleDateFormat(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ROOT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT);
        dateFormat = simpleDateFormat;
        Object clone = simpleDateFormat.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.text.SimpleDateFormat");
        SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) clone;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        utcDateFormat = simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ROOT);
        dateFormatMs = simpleDateFormat3;
        Object clone2 = simpleDateFormat3.clone();
        Intrinsics.checkNotNull(clone2, "null cannot be cast to non-null type java.text.SimpleDateFormat");
        SimpleDateFormat simpleDateFormat4 = (SimpleDateFormat) clone2;
        simpleDateFormat4.setTimeZone(TimeZone.getTimeZone("UTC"));
        utcDateFormatMs = simpleDateFormat4;
    }

    public static final String utcNow() {
        return utcDate(new Date());
    }

    public static final String now() {
        return localDate(new Date());
    }

    public static final long unixNow() {
        return System.currentTimeMillis() / 1000;
    }

    public static final String utcNowMs() {
        return utcDateMs(new Date());
    }

    public static final String utcDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return utcDateFormat.format(date);
    }

    public static final String utcDateMs(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return utcDateFormatMs.format(date);
    }

    public static final String localDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return dateFormat.format(date);
    }

    public static final double durationSecond(long j) {
        return (System.currentTimeMillis() - j) / 1000.0d;
    }
}
