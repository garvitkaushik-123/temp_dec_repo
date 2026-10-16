package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class nro {
    private static final Map<String, nro> eli = new HashMap();
    private SharedPreferences DbA;

    public static nro eli(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        Map<String, nro> map = eli;
        nro nroVar = map.get(str);
        if (nroVar != null) {
            return nroVar;
        }
        synchronized (nro.class) {
            if (nroVar == null) {
                try {
                    nroVar = new nro(str, com.bytedance.sdk.openadsdk.core.dV.eli());
                } catch (Throwable th) {
                    throw th;
                }
            }
            map.put(str, nroVar);
        }
        return nroVar;
    }

    private nro(String str, Context context) {
        if (context != null) {
            this.DbA = context.getSharedPreferences(str, 0);
        }
    }

    public String eli(String str, String str2) {
        try {
            return this.DbA.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void eli(String str) {
        try {
            this.DbA.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
