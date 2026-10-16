package io.bidmachine.iab.vast;

import io.bidmachine.iab.utils.LogListener;
import io.bidmachine.iab.utils.Logger;

/* loaded from: classes7.dex */
public class VastLog {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f6867a = new Logger("VastLog");

    public static void addLogListener(LogListener logListener) {
        f6867a.addLogListener(logListener);
    }

    public static boolean canSendDLog() {
        return f6867a.canSendDLog();
    }

    public static boolean canSendELog() {
        return f6867a.canSendELog();
    }

    public static boolean canSendWLog() {
        return f6867a.canSendWLog();
    }

    public static void d(String subTag, String message, Object... args) {
        f6867a.d(subTag, message, args);
    }

    public static void e(String subTag, String message, Object... args) {
        f6867a.e(subTag, message, args);
    }

    public static boolean removeLogListener(LogListener logListener) {
        return f6867a.removeLogListener(logListener);
    }

    public static void setLoggingLevel(Logger.LogLevel logLevel) {
        f6867a.setLoggingLevel(logLevel);
    }

    public static void e(String subTag, Throwable throwable) {
        f6867a.e(subTag, throwable);
    }
}
