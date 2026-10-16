package com.bytedance.sdk.openadsdk.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui {
    private static long DbA;
    private static boolean Os;
    private static WeakReference<com.bytedance.sdk.openadsdk.core.model.ev> eli;

    public static void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        com.bytedance.sdk.openadsdk.core.model.MGA pu = evVar.pu();
        if (pu == null || TextUtils.isEmpty(pu.eli())) {
            return;
        }
        eli = new WeakReference<>(evVar);
    }

    public static void eli(long j) {
        DbA(j);
    }

    private static void DbA(final long j) {
        com.bytedance.sdk.openadsdk.core.model.ev evVar;
        WeakReference<com.bytedance.sdk.openadsdk.core.model.ev> weakReference = eli;
        if (weakReference == null || j <= 0 || (evVar = weakReference.get()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), evVar, evVar.aGH(), "store_duration", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.utils.ui.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", j);
                } catch (JSONException unused) {
                }
                return jSONObject;
            }
        });
        eli = null;
        Os = false;
    }

    public static void eli() {
        if (eli == null || Os) {
            return;
        }
        if (DbA > 0) {
            DbA(SystemClock.elapsedRealtime() - DbA);
        }
        eli = null;
        DbA = 0L;
    }

    public static void DbA() {
        if (eli == null || Os) {
            return;
        }
        DbA = SystemClock.elapsedRealtime();
    }

    public static boolean Os() {
        WeakReference<com.bytedance.sdk.openadsdk.core.model.ev> weakReference = eli;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        Os = true;
        return true;
    }
}
