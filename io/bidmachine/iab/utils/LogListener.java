package io.bidmachine.iab.utils;

import io.bidmachine.iab.utils.Logger;

/* loaded from: classes7.dex */
public interface LogListener {
    void onLog(Logger.LogLevel logLevel, String tag, String message);
}
