package io.bidmachine.iab.mraid;

import io.bidmachine.iab.utils.LogListener;
import io.bidmachine.iab.utils.Logger;

/* loaded from: classes7.dex */
public class MraidLog {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f6812a = new Logger("MraidLog");

    public static void addLogListener(LogListener logListener) {
        f6812a.addLogListener(logListener);
    }

    public static boolean canSendDLog() {
        return f6812a.canSendDLog();
    }

    public static boolean canSendELog() {
        return f6812a.canSendELog();
    }

    public static boolean canSendWLog() {
        return f6812a.canSendWLog();
    }

    public static void d(String subTag, String message, Object... args) {
        f6812a.d(subTag, message, args);
    }

    public static void e(String subTag, String message, Object... args) {
        f6812a.e(subTag, message, args);
    }

    public static Logger.LogLevel getLoggingLevel() {
        return f6812a.getLoggingLevel();
    }

    public static boolean removeLogListener(LogListener logListener) {
        return f6812a.removeLogListener(logListener);
    }

    public static void setLoggingLevel(Logger.LogLevel logLevel) {
        f6812a.setLoggingLevel(logLevel);
    }

    public static void w(String subTag, String message, Object... args) {
        f6812a.w(subTag, message, args);
    }

    public static void e(String subTag, Throwable throwable) {
        f6812a.e(subTag, throwable);
    }
}
