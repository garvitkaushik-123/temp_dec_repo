package io.bidmachine.iab.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public class Logger {
    private static LogLevel c = LogLevel.error;

    /* renamed from: a, reason: collision with root package name */
    private final String f6856a;
    private final List<LogListener> b = new CopyOnWriteArrayList();

    public enum LogLevel {
        debug(1),
        info(2),
        warning(3),
        error(4),
        none(5);


        /* renamed from: a, reason: collision with root package name */
        private final int f6857a;

        LogLevel(int value) {
            this.f6857a = value;
        }

        public int getValue() {
            return this.f6857a;
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6858a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            f6858a = iArr;
            try {
                iArr[LogLevel.debug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6858a[LogLevel.error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6858a[LogLevel.warning.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Logger(String tag) {
        this.f6856a = tag;
    }

    private void a(LogLevel logLevel, String message) {
        int i = a.f6858a[logLevel.ordinal()];
        if (i == 1) {
            Log.d(this.f6856a, message);
        } else if (i == 2) {
            Log.e(this.f6856a, message);
        } else {
            if (i != 3) {
                return;
            }
            Log.w(this.f6856a, message);
        }
    }

    private void b(LogLevel logLevel, String message) {
        Iterator<LogListener> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().onLog(logLevel, this.f6856a, message);
        }
    }

    public void addLogListener(LogListener logListener) {
        if (logListener != null) {
            this.b.add(logListener);
        }
    }

    public boolean canSendDLog() {
        return a(LogLevel.debug);
    }

    public boolean canSendELog() {
        return a(LogLevel.error);
    }

    public boolean canSendWLog() {
        return a(LogLevel.warning);
    }

    public void d(String subTag, String message, Object... args) {
        a(LogLevel.debug, subTag, message, args);
    }

    public void e(String subTag, String message, Object... args) {
        a(LogLevel.error, subTag, message, args);
    }

    public LogLevel getLoggingLevel() {
        return c;
    }

    public boolean removeLogListener(LogListener logListener) {
        return logListener != null && this.b.remove(logListener);
    }

    public void setLoggingLevel(LogLevel logLevel) {
        Log.d(this.f6856a, String.format("Changing logging level. From: %s, To: %s", c, logLevel));
        c = logLevel;
    }

    public void w(String subTag, String message, Object... args) {
        a(LogLevel.warning, subTag, message, args);
    }

    public void e(String subTag, Throwable throwable) {
        a(LogLevel.error, subTag, throwable.toString(), new Object[0]);
    }

    private boolean b(LogLevel needLogLevel) {
        LogLevel logLevel = c;
        return logLevel != null && logLevel.getValue() <= needLogLevel.getValue();
    }

    private void a(LogLevel logLevel, String subTag, String message, Object... args) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        boolean b = b(logLevel);
        boolean a2 = a();
        if (b || a2) {
            String a3 = a(subTag, message, args);
            if (b) {
                a(logLevel, a3);
            }
            if (a2) {
                b(logLevel, a3);
            }
        }
    }

    private boolean a(LogLevel logLevel) {
        return b(logLevel) || a();
    }

    private boolean a() {
        return !this.b.isEmpty();
    }

    private static String a(String subTag, String message, Object... args) {
        String a2 = a(subTag, message);
        if (args == null || args.length == 0) {
            return a2;
        }
        try {
            return String.format(a2, args);
        } catch (Throwable unused) {
            return a2;
        }
    }

    private static String a(String subTag, String message) {
        return String.format("[%s] %s", subTag, message);
    }
}
