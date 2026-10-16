package com.bytedance.sdk.openadsdk.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nn {
    public static volatile boolean eli = false;
    private static volatile HandlerThread kb;
    public static long ui;
    public static AtomicBoolean DbA = new AtomicBoolean(false);
    public static long Os = 0;
    private static volatile int MGA = 0;
    public static float aGH = 1.0f;
    private static volatile Handler wC = null;

    static {
        HandlerThread handlerThread = new HandlerThread("csj_init_handle", 10) { // from class: com.bytedance.sdk.openadsdk.core.nn.1
            boolean eli = false;

            @Override // java.lang.Thread
            public synchronized void start() {
                if (this.eli) {
                    return;
                }
                this.eli = true;
                super.start();
            }
        };
        kb = handlerThread;
        handlerThread.start();
        com.bytedance.sdk.component.utils.wC.eli(kb);
        ui = System.currentTimeMillis();
    }

    public static void eli(long j) {
        ui = j;
    }

    public static long eli() {
        return ui;
    }

    public static Handler DbA() {
        if (kb == null || !kb.isAlive()) {
            synchronized (nn.class) {
                if (kb == null || !kb.isAlive()) {
                    kb = com.bytedance.sdk.component.utils.wC.eli("csj_init_handle", -1);
                    wC = new Handler(kb.getLooper());
                }
            }
        } else if (wC == null) {
            synchronized (nn.class) {
                if (wC == null) {
                    wC = new Handler(kb.getLooper());
                }
            }
        }
        return wC;
    }

    public static Handler Os() {
        return new Handler(Looper.getMainLooper());
    }

    public static int aGH() {
        return MGA;
    }

    public static void eli(int i) {
        MGA = i;
    }

    public static boolean ui() {
        return aGH() == 1;
    }

    public static void MGA() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - Os <= 10000) {
            return;
        }
        Os = elapsedRealtime;
        com.bytedance.sdk.openadsdk.utils.cyF.eli(new com.bytedance.sdk.component.wC.wC("onSharedPreferenceChanged") { // from class: com.bytedance.sdk.openadsdk.core.nn.2
            @Override // java.lang.Runnable
            public void run() {
                String Os2 = com.bytedance.sdk.openadsdk.core.settings.NU.Os(dV.eli());
                if (TextUtils.equals(Os2, com.bytedance.sdk.openadsdk.core.settings.NU.aGH)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.settings.NU.nY().eli(6, true);
                com.bytedance.sdk.openadsdk.core.settings.NU.aGH = Os2;
            }
        });
    }

    public static void kb() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - Os <= 10000) {
            return;
        }
        synchronized (nn.class) {
            if (elapsedRealtime - Os <= 10000) {
                return;
            }
            Os = elapsedRealtime;
            com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nn.3
                @Override // java.lang.Runnable
                public void run() {
                    String Os2 = com.bytedance.sdk.openadsdk.core.settings.NU.Os(dV.eli());
                    if (TextUtils.equals(Os2, com.bytedance.sdk.openadsdk.core.settings.NU.aGH)) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.settings.NU.nY().eli(6, true);
                    com.bytedance.sdk.openadsdk.core.settings.NU.aGH = Os2;
                }
            });
        }
    }

    public static void eli(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if ("mediation".equals(jSONObject.optString("name", ""))) {
                    FC.DbA().DbA(jSONObject.optString("value", ""));
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("InitHelper", th.getMessage());
        }
    }

    public static void wC() {
        DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nn.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.nn.4.1
                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                            eliVar.DbA(C3040d4.a.f);
                            return eliVar;
                        }
                    });
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.Xb.Os("InitHelper", th.getMessage());
                }
            }
        });
    }
}
