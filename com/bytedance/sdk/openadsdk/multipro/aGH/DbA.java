package com.bytedance.sdk.openadsdk.multipro.aGH;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.eli;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.FC;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
class DbA {
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> eli;

    public static SharedPreferences eli(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(eli(str), 0);
        } catch (Throwable th) {
            Xb.Os("SPMultiHelperImpl", "getSharedPreferences error ", th.getMessage());
            return null;
        }
    }

    private static String eli(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static Object eli(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = eli;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(eli(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static void eli(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = eli;
        if (softReference == null || softReference.get() == null) {
            eli = new SoftReference<>(new ConcurrentHashMap());
        }
        String eli2 = eli(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = eli.get();
        if (concurrentHashMap.get(eli2) == null) {
            concurrentHashMap.put(eli2, new HashMap());
        }
        concurrentHashMap.get(eli2).put(str2, obj);
    }

    private static void DbA(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = eli;
        if (softReference == null || softReference.get() == null || (map = eli.get().get(eli(str))) == null) {
            return;
        }
        map.clear();
    }

    static synchronized <T> void eli(Context context, String str, String str2, T t) {
        synchronized (DbA.class) {
            String eli2 = eli.eli(str, str2);
            if (FC.kb(eli2)) {
                com.bytedance.sdk.component.eli eli3 = com.bytedance.sdk.component.eli.eli(context, eli2);
                if (t.equals(eli(eli2, str2))) {
                    return;
                }
                eli.Os DbA = eli3.DbA();
                eli(DbA, str2, (Object) t);
                DbA.apply();
                eli(eli2, str2, t);
                return;
            }
            SharedPreferences eli4 = eli(context, eli2);
            if (eli4 == null) {
                return;
            }
            if (t.equals(eli(eli2, str2))) {
                return;
            }
            SharedPreferences.Editor edit = eli4.edit();
            eli(edit, str2, t);
            edit.apply();
            eli(eli2, str2, t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static <T> void eli(SharedPreferences.Editor editor, String str, T t) {
        if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            editor.putLong(str, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        }
        if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            editor.putString(str, (String) t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static <T> void eli(eli.Os os, String str, T t) {
        if (t instanceof Integer) {
            os.putInt(str, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            os.putLong(str, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            os.putFloat(str, ((Float) t).floatValue());
        }
        if (t instanceof Boolean) {
            os.putBoolean(str, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            os.putString(str, (String) t);
        }
    }

    static String eli(Context context, String str, String str2, String str3) {
        Object eli2 = eli(str, str2);
        if (eli2 != null) {
            return String.valueOf(eli2);
        }
        Object DbA = DbA(context, str, str2, str3);
        eli(str, str2, DbA);
        return String.valueOf(DbA);
    }

    private static Object DbA(Context context, String str, String str2, String str3) {
        String eli2 = eli(str);
        if (!eli(context, eli2, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return eli.eli(context, eli2, str2, (String) null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(eli.eli(context, eli2, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(eli.eli(context, eli2, str2, 0));
        }
        if (str3.equalsIgnoreCase(Constants.LONG)) {
            return Long.valueOf(eli.eli(context, eli2, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(eli.eli(context, eli2, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return eli.eli(context, eli2, str2, (String) null);
        }
        return null;
    }

    static boolean eli(Context context, String str, String str2) {
        String eli2 = eli.eli(str, str2);
        if (FC.kb(eli2)) {
            return com.bytedance.sdk.component.eli.eli(context, eli2).eli(str2);
        }
        SharedPreferences eli3 = eli(context, eli2);
        return eli3 != null && eli3.contains(str2);
    }

    public static void DbA(Context context, String str, String str2) {
        try {
            String eli2 = eli.eli(str, str2);
            if (FC.kb(eli2)) {
                com.bytedance.sdk.component.eli.eli(context, eli2).DbA().remove(str2).apply();
                return;
            }
            SharedPreferences eli3 = eli(context, eli2);
            if (eli3 == null) {
                return;
            }
            SharedPreferences.Editor edit = eli3.edit();
            edit.remove(str2);
            edit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = eli;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            Map<String, Object> map = eli.get().get(eli(eli2));
            if (map != null && map.size() != 0) {
                map.remove(str2);
            }
        } catch (Throwable unused) {
        }
    }

    static void DbA(Context context, String str) {
        if (FC.kb(str)) {
            com.bytedance.sdk.component.eli.eli(context, str).DbA().clear().apply();
            DbA(str);
            return;
        }
        SharedPreferences eli2 = eli(context, str);
        if (eli2 == null) {
            return;
        }
        SharedPreferences.Editor edit = eli2.edit();
        edit.clear();
        edit.apply();
        DbA(str);
    }

    static Map<String, ?> Os(Context context, String str) {
        SharedPreferences eli2 = eli(context, str);
        if (eli2 == null) {
            return null;
        }
        return eli2.getAll();
    }
}
