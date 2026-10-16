package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.tools.FastKV;

/* compiled from: SharedPreferencesUtils.java */
/* loaded from: classes6.dex */
public class x0 {

    /* renamed from: a, reason: collision with root package name */
    static FastKV f4384a;

    public static void b(Context context, String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        if (context == null) {
            return;
        }
        if (com.mbridge.msdk.foundation.controller.d.a().e() && f4384a == null) {
            try {
                f4384a = new FastKV.Builder(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), "share_date").build();
            } catch (Exception unused) {
                f4384a = null;
            }
        }
        if (f4384a != null) {
            try {
                if ("String".equals(simpleName)) {
                    f4384a.putString(str, (String) obj);
                } else if ("Integer".equals(simpleName)) {
                    f4384a.putInt(str, ((Integer) obj).intValue());
                } else if ("Boolean".equals(simpleName)) {
                    f4384a.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if ("Float".equals(simpleName)) {
                    f4384a.putFloat(str, ((Float) obj).floatValue());
                } else if ("Long".equals(simpleName)) {
                    f4384a.putLong(str, ((Long) obj).longValue());
                }
                return;
            } catch (Exception unused2) {
                return;
            }
        }
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("share_date", 0).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str, (String) obj);
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.apply();
    }

    public static Object a(Context context, String str, Object obj) {
        if (context != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : "";
            if (com.mbridge.msdk.foundation.controller.d.a().e() && f4384a == null) {
                try {
                    f4384a = new FastKV.Builder(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), "share_date").build();
                } catch (Exception unused) {
                    f4384a = null;
                }
            }
            if (f4384a != null) {
                try {
                    if ("String".equals(simpleName)) {
                        return f4384a.getString(str, (String) obj);
                    }
                    if ("Integer".equals(simpleName)) {
                        return Integer.valueOf(f4384a.getInt(str, ((Integer) obj).intValue()));
                    }
                    if ("Boolean".equals(simpleName)) {
                        return Boolean.valueOf(f4384a.getBoolean(str, ((Boolean) obj).booleanValue()));
                    }
                    if ("Float".equals(simpleName)) {
                        return Float.valueOf(f4384a.getFloat(str, ((Float) obj).floatValue()));
                    }
                    if ("Long".equals(simpleName)) {
                        return Long.valueOf(f4384a.getLong(str, ((Long) obj).longValue()));
                    }
                } catch (Exception unused2) {
                }
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences("share_date", 0);
                if ("String".equals(simpleName)) {
                    return sharedPreferences.getString(str, (String) obj);
                }
                if ("Integer".equals(simpleName)) {
                    return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
                }
                if ("Boolean".equals(simpleName)) {
                    return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
                }
                if ("Float".equals(simpleName)) {
                    return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
                }
                if ("Long".equals(simpleName)) {
                    return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
                }
            }
        }
        return obj;
    }
}
