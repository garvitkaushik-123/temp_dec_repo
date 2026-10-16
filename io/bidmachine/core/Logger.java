package io.bidmachine.core;

import io.bidmachine.utils.lazy.LazyValue;
import io.bidmachine.utils.log.DefaultLoggerInstance;
import io.bidmachine.utils.log.EmptyLoggerInstance;
import io.bidmachine.utils.log.LoggerInstance;

/* loaded from: classes7.dex */
public class Logger {
    private static boolean isLoggingEnabled = false;
    private static volatile LoggerInstance enabledInstance = new DefaultLoggerInstance("BidMachineLog");
    private static volatile LoggerInstance disabledInstance = new EmptyLoggerInstance();
    static volatile LoggerInstance instance = disabledInstance;

    public static void setLoggingEnabled(boolean enabled) {
        LoggerInstance loggerInstance;
        isLoggingEnabled = enabled;
        if (enabled) {
            loggerInstance = enabledInstance;
        } else {
            loggerInstance = disabledInstance;
        }
        instance = loggerInstance;
    }

    public static void setEnabledInstance(LoggerInstance enabledInstance2) {
        enabledInstance = enabledInstance2;
        setLoggingEnabled(isLoggingEnabled);
    }

    public static void setDisabledInstance(LoggerInstance disabledInstance2) {
        disabledInstance = disabledInstance2;
        setLoggingEnabled(isLoggingEnabled);
    }

    public static boolean isLoggingEnabled() {
        return isLoggingEnabled;
    }

    public static void d(Object subTag, String message) {
        instance.d(subTag, message);
    }

    public static void d(String message) {
        instance.d(message);
    }

    public static void d(Object subTag, LazyValue<String> lazyMessage) {
        instance.d(subTag, lazyMessage);
    }

    public static void d(LazyValue<String> lazyMessage) {
        instance.d(lazyMessage);
    }

    public static void w(Object subTag, String message) {
        instance.w(subTag, message);
    }

    public static void w(String message) {
        instance.w(message);
    }

    public static void w(Throwable throwable) {
        instance.w(throwable);
    }

    public static void e(Object subTag, String message) {
        instance.e(subTag, message);
    }

    public static void e(String message) {
        instance.e(message);
    }

    public static void e(Object subTag, LazyValue<String> lazyMessage) {
        instance.e(subTag, lazyMessage);
    }

    public static void e(LazyValue<String> lazyMessage) {
        instance.e(lazyMessage);
    }
}
