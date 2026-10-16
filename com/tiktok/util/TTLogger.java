package com.tiktok.util;

import android.util.Log;
import com.tiktok.TikTokBusinessSdk;

/* loaded from: classes6.dex */
public class TTLogger {
    public final TikTokBusinessSdk.LogLevel logLevel;
    private final String tag;

    public TTLogger(String tag, TikTokBusinessSdk.LogLevel logLevel) {
        this.tag = tag;
        this.logLevel = logLevel;
    }

    private String resolvedStr(String format, Object... extra) {
        if (format == null) {
            return "null";
        }
        return extra.length == 0 ? format : String.format(format, extra);
    }

    public void info(String format, Object... extra) {
        if (shouldLog(TikTokBusinessSdk.LogLevel.INFO)) {
            String resolvedStr = resolvedStr(format, extra);
            if (resolvedStr.length() > 1000) {
                Log.i(this.tag, resolvedStr.substring(0, 1000));
                info(resolvedStr.substring(1000), new Object[0]);
            } else {
                Log.i(this.tag, resolvedStr);
            }
        }
    }

    public void warn(String format, Object... extra) {
        if (shouldLog(TikTokBusinessSdk.LogLevel.WARN)) {
            Log.w(this.tag, resolvedStr(format, extra));
        }
    }

    public void debug(String format, Object... extra) {
        if (shouldLog(TikTokBusinessSdk.LogLevel.DEBUG)) {
            String resolvedStr = resolvedStr(format, extra);
            if (resolvedStr.length() > 1000) {
                Log.d(this.tag, resolvedStr.substring(0, 1000));
                debug(resolvedStr.substring(1000), new Object[0]);
            } else {
                Log.d(this.tag, resolvedStr);
            }
        }
    }

    public void error(Throwable error, String format, Object... extra) {
        if (shouldLog(TikTokBusinessSdk.LogLevel.INFO)) {
            Log.e(this.tag, resolvedStr(format, extra), error);
        }
    }

    private boolean shouldLog(TikTokBusinessSdk.LogLevel level) {
        return this.logLevel.ordinal() >= level.ordinal();
    }
}
