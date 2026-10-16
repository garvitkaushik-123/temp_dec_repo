package io.adn.sdk.internal.common.logger;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.ironsource.B1;
import io.adn.sdk.internal.common.logger.AdLogEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Logger.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ \u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lio/adn/sdk/internal/common/logger/Logger;", "", "<init>", "()V", "isVerboseEnabled", "", "customAdLogger", "Lio/adn/sdk/internal/common/logger/CustomAdEventLogger;", "setVerbose", "", "isVerbose", "setCustomAdLogger", "logger", "d", "className", "", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "log", "event", "Lio/adn/sdk/internal/common/logger/AdLogEvent;", B1.e, "internal", "level", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class Logger {
    private static CustomAdEventLogger customAdLogger;
    private static boolean isVerboseEnabled;
    public static final Logger INSTANCE = new Logger();
    public static final int $stable = 8;

    private final void log(String className, String msg, int level) {
    }

    public final void log(AdLogEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    private Logger() {
    }

    public final void setVerbose(boolean isVerbose) {
        isVerboseEnabled = isVerbose;
    }

    public final boolean isVerbose() {
        return isVerboseEnabled;
    }

    public final void setCustomAdLogger(CustomAdEventLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        customAdLogger = logger;
    }

    public final void d(String className, String msg) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(msg, "msg");
        log(className, msg, 3);
    }

    public final void e(String className, String msg) {
        Intrinsics.checkNotNullParameter(className, "className");
        String str = msg;
        if (str == null || str.length() == 0) {
            return;
        }
        log(className, msg, 6);
    }

    public final void e(String className, Throwable throwable) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        String message = throwable.getMessage();
        if (message == null) {
            message = throwable.toString();
        }
        log(className, message, 6);
    }

    public final void external(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isVerboseEnabled) {
            Log.v("[AdnSdk]", msg);
        }
        log(new AdLogEvent.LogMessage(0L, 0L, msg, null, 11, null));
    }

    public final void internal(String className, String msg) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(msg, "msg");
        log(className, msg, 3);
        log(new AdLogEvent.LogMessage(0L, 0L, msg, null, 11, null));
    }
}
