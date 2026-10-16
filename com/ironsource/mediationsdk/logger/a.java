package com.ironsource.mediationsdk.logger;

import android.os.Looper;
import android.util.Log;
import com.ironsource.C3040d4;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

/* loaded from: classes6.dex */
public class a extends IronSourceLogger {
    public static final String c = "console";
    public static final String d = "LevelPlaySDK: ";

    private a() {
        super("console");
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        String str2 = "UIThread: " + (Looper.getMainLooper() == Looper.myLooper()) + " ";
        String str3 = "Activity: " + (ContextProvider.getInstance().getCurrentActiveActivity() != null ? Integer.valueOf(ContextProvider.getInstance().getCurrentActiveActivity().hashCode()) : Boolean.FALSE) + " ";
        if (i == 0) {
            Log.v(d + ironSourceTag, str2 + str3 + str);
            return;
        }
        if (i != 1) {
            if (i == 2) {
                Log.w(d + ironSourceTag, str);
                return;
            } else if (i == 3) {
                Log.e(d + ironSourceTag, str);
                return;
            } else if (i != 4) {
                return;
            }
        }
        Log.i(d + ironSourceTag, str);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        log(ironSourceTag, str + ":stacktrace[" + Log.getStackTraceString(th) + C3040d4.i.e, 3);
    }

    public a(int i) {
        super("console", i);
    }
}
