package com.bytedance.sdk.openadsdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;

/* loaded from: classes3.dex */
public class kb {
    static float DbA = 0.0f;
    private static long Os = 0;
    static int eli = -1;

    private static void eli(Intent intent) {
        if (intent.getIntExtra("status", -1) == 2) {
            eli = 1;
        } else {
            eli = 0;
        }
        DbA = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
    }

    public static eli eli() {
        if (Os == 0 || SystemClock.elapsedRealtime() - Os > 60000) {
            Intent registerReceiver = com.bytedance.sdk.openadsdk.core.dV.eli().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            Log.d("BatteryDataWatcher", "obtainCurrentState: registerReceiver result is ".concat(String.valueOf(registerReceiver)));
            if (registerReceiver != null) {
                eli(registerReceiver);
                Os = SystemClock.elapsedRealtime();
            }
        }
        eli eliVar = new eli(eli, DbA);
        int i = eliVar.eli;
        float f = eliVar.DbA;
        return eliVar;
    }

    public static class eli {
        public final float DbA;
        public final int eli;

        public eli(int i, float f) {
            this.eli = i;
            this.DbA = f;
        }
    }
}
