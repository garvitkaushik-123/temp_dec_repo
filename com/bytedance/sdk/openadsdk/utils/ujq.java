package com.bytedance.sdk.openadsdk.utils;

import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class ujq {
    public static boolean eli = eli();

    private static boolean eli() {
        SharedPreferences sharedPreferences;
        try {
            if (com.bytedance.sdk.openadsdk.core.dV.eli() != null && (sharedPreferences = com.bytedance.sdk.openadsdk.core.dV.eli().getSharedPreferences("pag_sp_prop_switch", 0)) != null) {
                return sharedPreferences.getInt("perf_con_use_prop", 1) == 1;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os(th.getMessage(), new Object[0]);
        }
        return true;
    }

    public static void eli(int i) {
        try {
            SharedPreferences.Editor edit = com.bytedance.sdk.openadsdk.core.dV.eli().getSharedPreferences("pag_sp_prop_switch", 0).edit();
            edit.putInt("perf_con_use_prop", i);
            edit.apply();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os(th.getMessage(), new Object[0]);
        }
    }
}
