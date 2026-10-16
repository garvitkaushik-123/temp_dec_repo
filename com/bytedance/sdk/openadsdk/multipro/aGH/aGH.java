package com.bytedance.sdk.openadsdk.multipro.aGH;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.eli;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.dV;

/* loaded from: classes3.dex */
public class aGH {
    private static boolean eli() {
        return dV.eli() == null;
    }

    private static String DbA(String str) {
        return TextUtils.isEmpty(str) ? "tt_sp" : str;
    }

    public static void eli(String str, String str2, Boolean bool) {
        if (eli()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli.eli(DbA(str), str2, bool);
        } else {
            eli(DbA(str), str2, bool);
        }
    }

    public static void eli(String str, String str2, Long l) {
        if (eli()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli.eli(DbA(str), str2, l);
        } else {
            eli(DbA(str), str2, l);
        }
    }

    public static void eli(String str, String str2, String str3) {
        if (eli()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli.eli(DbA(str), str2, str3);
        } else {
            eli(DbA(str), str2, str3);
        }
    }

    public static void eli(String str, String str2, Integer num) {
        if (eli()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli.eli(DbA(str), str2, num);
        } else {
            eli(DbA(str), str2, num);
        }
    }

    public static int eli(String str, String str2, int i) {
        if (eli()) {
            return i;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            return eli.eli(DbA(str), str2, i);
        }
        return eli.eli(dV.eli(), DbA(str), str2, i);
    }

    public static boolean eli(String str, String str2, boolean z) {
        if (eli()) {
            return z;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            return eli.eli(DbA(str), str2, z);
        }
        return eli.eli(dV.eli(), DbA(str), str2, z);
    }

    public static long eli(String str, String str2, long j) {
        if (eli()) {
            return j;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            return eli.eli(DbA(str), str2, j);
        }
        return eli.eli(dV.eli(), DbA(str), str2, j);
    }

    public static String DbA(String str, String str2, String str3) {
        if (eli()) {
            return str3;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            return eli.DbA(DbA(str), str2, str3);
        }
        return eli.eli(dV.eli(), DbA(str), str2, str3);
    }

    public static void eli(String str, String str2) {
        if (eli()) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                eli.DbA(DbA(str), str2);
            } else {
                DbA.DbA(dV.eli(), DbA(str), str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void eli(String str) {
        if (eli()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli.eli(DbA(str));
        } else {
            DbA.DbA(dV.eli(), DbA(str));
        }
    }

    private static <T> void eli(String str, String str2, T t) {
        String eli = eli.eli(str, str2);
        if (FC.kb(eli)) {
            eli.Os DbA = com.bytedance.sdk.component.eli.eli(dV.eli(), DbA(eli)).DbA();
            DbA.eli(DbA, str2, (Object) t);
            DbA.apply();
        } else {
            SharedPreferences eli2 = DbA.eli(dV.eli(), DbA(eli));
            if (eli2 == null) {
                return;
            }
            SharedPreferences.Editor edit = eli2.edit();
            DbA.eli(edit, str2, t);
            edit.apply();
        }
    }
}
