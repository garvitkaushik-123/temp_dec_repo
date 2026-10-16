package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.C3040d4;

/* loaded from: classes3.dex */
public class Xb {
    private static String DbA = "";
    private static boolean eli = false;

    public static void eli() {
        eli = true;
    }

    public static void DbA() {
        eli = false;
    }

    public static void eli(String str, String str2) {
        if (eli && str2 != null) {
            Log.d(DbA(str), str2);
        }
    }

    public static void eli(String str, Object... objArr) {
        if (eli && objArr != null) {
            Log.d(DbA(str), eli(objArr));
        }
    }

    public static void DbA(String str, String str2) {
        if (eli && str2 != null) {
            Log.i(DbA(str), str2);
        }
    }

    public static void DbA(String str, Object... objArr) {
        if (eli && objArr != null) {
            Log.i(DbA(str), eli(objArr));
        }
    }

    public static void Os(String str, String str2) {
        if (eli && str2 != null) {
            Log.e(DbA(str), str2);
        }
    }

    public static void Os(String str, Object... objArr) {
        if (eli && objArr != null) {
            Log.e(DbA(str), eli(objArr));
        }
    }

    public static void eli(String str, String str2, Throwable th) {
        if (eli) {
            if (str2 == null && th == null) {
                return;
            }
            Log.e(DbA(str), str2, th);
        }
    }

    public static void eli(String str) {
        DbA = str;
    }

    private static String DbA(String str) {
        return TextUtils.isEmpty(DbA) ? str : eli(C3040d4.i.d + DbA + "]-[" + str + C3040d4.i.e);
    }

    private static String eli(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
