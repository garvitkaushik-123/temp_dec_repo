package com.bytedance.sdk.openadsdk.multipro.aGH;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.MGA.eli.MGA;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class eli {
    public static HashSet<String> eli = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.multipro.aGH.eli.1
        {
            add(MBridgeConstans.APP_ID);
            add("tt_gdpr");
            add("extra_data");
            add("sdk_app_sha1");
            add("uuid");
            add("android_system_ua");
            add("sdk_local_web_ua");
            add("sdk_local_rom_info");
        }
    };

    public static boolean eli() {
        return dV.eli() != null;
    }

    private static MGA DbA() {
        try {
            if (eli()) {
                return com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(dV.eli());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Context Os() {
        return dV.eli();
    }

    private static String aGH() {
        return com.bytedance.sdk.openadsdk.multipro.aGH.DbA + "/t_sp/";
    }

    private static String DbA(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=".concat(String.valueOf(str));
    }

    public static synchronized void eli(String str, String str2, Boolean bool) {
        synchronized (eli.class) {
            if (eli()) {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                        DbA.eli(Os(), str, str2, bool);
                        return;
                    }
                    MGA DbA = DbA();
                    if (DbA != null) {
                        Uri parse = Uri.parse(aGH() + "boolean/" + str2 + DbA(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", bool);
                        DbA.eli(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void eli(String str, String str2, String str3) {
        synchronized (eli.class) {
            if (eli()) {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                        DbA.eli(Os(), str, str2, str3);
                        return;
                    }
                    MGA DbA = DbA();
                    if (DbA != null) {
                        Uri parse = Uri.parse(aGH() + "string/" + str2 + DbA(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", str3);
                        DbA.eli(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void eli(String str, String str2, Integer num) {
        synchronized (eli.class) {
            if (eli()) {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                        DbA.eli(Os(), str, str2, num);
                        return;
                    }
                    MGA DbA = DbA();
                    if (DbA != null) {
                        Uri parse = Uri.parse(aGH() + "int/" + str2 + DbA(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", num);
                        DbA.eli(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void eli(String str, String str2, Long l) {
        synchronized (eli.class) {
            if (eli()) {
                try {
                    if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                        DbA.eli(Os(), str, str2, l);
                        return;
                    }
                    MGA DbA = DbA();
                    if (DbA != null) {
                        Uri parse = Uri.parse(aGH() + "long/" + str2 + DbA(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", l);
                        DbA.eli(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static String DbA(String str, String str2, String str3) {
        String eli2;
        if (eli()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    return eli(Os(), str, str2, str3);
                }
                MGA DbA = DbA();
                if (DbA != null && (eli2 = DbA.eli(Uri.parse(aGH() + "string/" + str2 + DbA(str)))) != null && !eli2.equals("null")) {
                    return eli2;
                }
            } catch (Throwable unused) {
            }
        }
        return str3;
    }

    protected static String eli(Context context, String str, String str2, String str3) {
        String eli2 = eli(str, str2);
        if (FC.kb(eli2)) {
            return com.bytedance.sdk.component.eli.eli(context, eli2).eli(str2, str3);
        }
        SharedPreferences eli3 = DbA.eli(context, eli2);
        return eli3 == null ? str3 : eli3.getString(str2, str3);
    }

    public static String eli(String str, String str2) {
        return eli.contains(str2) ? "pag_sp_bad_par" : str;
    }

    public static int eli(String str, String str2, int i) {
        String eli2;
        if (eli()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    return eli(Os(), str, str2, i);
                }
                MGA DbA = DbA();
                if (DbA != null && (eli2 = DbA.eli(Uri.parse(aGH() + "int/" + str2 + DbA(str)))) != null && !eli2.equals("null")) {
                    return Integer.parseInt(eli2);
                }
            } catch (Throwable unused) {
            }
        }
        return i;
    }

    protected static int eli(Context context, String str, String str2, int i) {
        String eli2 = eli(str, str2);
        if (FC.kb(eli2)) {
            return com.bytedance.sdk.component.eli.eli(context, eli2).eli(str2, i);
        }
        SharedPreferences eli3 = DbA.eli(context, eli2);
        return eli3 == null ? i : eli3.getInt(str2, i);
    }

    protected static float eli(Context context, String str, String str2, float f) {
        String eli2 = eli(str, str2);
        if (FC.kb(eli2)) {
            return com.bytedance.sdk.component.eli.eli(context, eli2).eli(str2, f);
        }
        SharedPreferences eli3 = DbA.eli(context, eli2);
        return eli3 == null ? f : eli3.getFloat(str2, f);
    }

    public static boolean eli(String str, String str2, boolean z) {
        String eli2;
        if (eli()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    return eli(Os(), str, str2, z);
                }
                MGA DbA = DbA();
                if (DbA != null && (eli2 = DbA.eli(Uri.parse(aGH() + "boolean/" + str2 + DbA(str)))) != null && !eli2.equals("null")) {
                    return Boolean.parseBoolean(eli2);
                }
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    protected static boolean eli(Context context, String str, String str2, boolean z) {
        String eli2 = eli(str, str2);
        if (FC.kb(eli2)) {
            return com.bytedance.sdk.component.eli.eli(context, eli2).eli(str2, z);
        }
        SharedPreferences eli3 = DbA.eli(context, eli2);
        return eli3 == null ? z : eli3.getBoolean(str2, z);
    }

    public static long eli(String str, String str2, long j) {
        String eli2;
        if (eli()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    return eli(Os(), str, str2, j);
                }
                MGA DbA = DbA();
                if (DbA != null && (eli2 = DbA.eli(Uri.parse(aGH() + "long/" + str2 + DbA(str)))) != null && !eli2.equals("null")) {
                    return Long.parseLong(eli2);
                }
            } catch (Throwable unused) {
            }
        }
        return j;
    }

    protected static long eli(Context context, String str, String str2, long j) {
        String eli2 = eli(str, str2);
        if (FC.kb(eli2)) {
            return com.bytedance.sdk.component.eli.eli(context, eli2).eli(str2, j);
        }
        SharedPreferences eli3 = DbA.eli(context, eli2);
        return eli3 == null ? j : eli3.getLong(str2, j);
    }

    public static void DbA(String str, String str2) {
        if (eli()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    DbA.DbA(Os(), str, str2);
                    return;
                }
                MGA DbA = DbA();
                if (DbA != null) {
                    DbA.eli(Uri.parse(aGH() + "long/" + str2 + DbA(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void eli(String str) {
        if (eli()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    DbA.DbA(Os(), str);
                    return;
                }
                MGA DbA = DbA();
                if (DbA != null) {
                    DbA.eli(Uri.parse(aGH() + "clean" + DbA(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
