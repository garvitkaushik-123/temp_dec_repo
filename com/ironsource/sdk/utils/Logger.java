package com.ironsource.sdk.utils;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.C3230o8;

/* loaded from: classes6.dex */
public class Logger {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3828a;

    public static void d(String str, String str2) {
        if (f3828a) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (f3828a) {
            Log.e(str, str2);
        }
    }

    public static void enableLogging(int i) {
        f3828a = C3230o8.d.MODE_0.b() != i;
    }

    public static void i(String str, String str2) {
        if (f3828a) {
            Log.i(str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (f3828a) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (f3828a) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f3828a) {
            Log.d(str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (f3828a) {
            Log.e(str, str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (!f3828a || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        if (f3828a) {
            Log.v(str, str2, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (f3828a) {
            Log.w(str, str2, th);
        }
    }
}
