package io.bidmachine.rendering;

import android.content.Context;
import io.bidmachine.iab.mraid.MraidLog;
import io.bidmachine.iab.utils.Logger;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.utils.UserAgentProvider;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public class Rendering {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f6934a = new AtomicBoolean(false);
    private static UserAgentProvider b;

    public static String getUserAgent() {
        UserAgentProvider userAgentProvider = b;
        if (userAgentProvider != null) {
            return userAgentProvider.getUserAgent();
        }
        return null;
    }

    public static void initialize(Context context) {
        f6934a.compareAndSet(false, true);
    }

    public static void setLoggingEnabled(boolean isLoggingEnabled) {
        o.a(isLoggingEnabled);
        MraidLog.setLoggingLevel(isLoggingEnabled ? Logger.LogLevel.debug : Logger.LogLevel.none);
    }

    public static void setUserAgentProvider(UserAgentProvider userAgentProvider) {
        b = userAgentProvider;
    }
}
