package io.bidmachine.util;

import android.content.Context;
import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppUtils.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\t\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\t\u001a\n\u0010\u000b\u001a\u00020\u0004*\u00020\t\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\f"}, d2 = {"appName", "", C3040d4.i.W, "isCleartextTrafficPermitted", "", "Ljava/lang/Boolean;", "resetAppUtils", "", "getAppName", "Landroid/content/Context;", "getAppVersion", "isDebuggable", "bidmachine-android-sdk_ca_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class AppUtilsKt {
    private static String appName;
    private static String appVersion;
    private static Boolean isCleartextTrafficPermitted;

    public static final String getAppName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String str = appName;
        if (str != null) {
            return str;
        }
        String obj = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
        appName = obj;
        return obj;
    }

    public static final String getAppVersion(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "<this>");
        String str2 = appVersion;
        if (str2 != null) {
            return str2;
        }
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            return null;
        }
        appVersion = str;
        return str;
    }

    public static final boolean isDebuggable(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static final void resetAppUtils() {
        appName = null;
        appVersion = null;
        isCleartextTrafficPermitted = null;
    }
}
