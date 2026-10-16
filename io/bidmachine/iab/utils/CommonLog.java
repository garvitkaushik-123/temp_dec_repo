package io.bidmachine.iab.utils;

import io.bidmachine.iab.utils.Logger;

/* loaded from: classes7.dex */
public class CommonLog {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f6848a = new Logger("CommonLog");

    public static boolean canSendDLog() {
        return f6848a.canSendDLog();
    }

    public static boolean canSendELog() {
        return f6848a.canSendELog();
    }

    public static boolean canSendWLog() {
        return f6848a.canSendWLog();
    }

    public static void d(String subTag, String message, Object... args) {
        f6848a.d(subTag, message, args);
    }

    public static void e(String subTag, String message, Object... args) {
        f6848a.e(subTag, message, args);
    }

    public static void setLoggingLevel(Logger.LogLevel logLevel) {
        f6848a.setLoggingLevel(logLevel);
    }

    public static void e(String subTag, Throwable throwable) {
        f6848a.e(subTag, throwable);
    }
}
