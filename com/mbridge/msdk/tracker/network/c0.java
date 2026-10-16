package com.mbridge.msdk.tracker.network;

import android.util.Log;
import java.util.Locale;

/* compiled from: VolleyLog.java */
/* loaded from: classes6.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static String f4938a = "TrackManager_Volley";
    private static final String b = "com.mbridge.msdk.tracker.network.c0";

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f4938a, a(str, objArr), th);
    }

    public static void b(String str, Object... objArr) {
        Log.d(f4938a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f4938a, a(str, objArr));
    }

    public static void d(String str, Object... objArr) {
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClassName().equals(b)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
