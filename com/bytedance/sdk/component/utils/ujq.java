package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class ujq {
    private static final Object eli = new Object();
    private static final Map<eli, Object> DbA = new ConcurrentHashMap();
    private static AtomicBoolean Os = new AtomicBoolean(false);
    private static volatile int aGH = -1;
    private static volatile long ui = 0;
    private static volatile int MGA = 60000;
    private static QX kb = null;
    private static final AtomicBoolean wC = new AtomicBoolean(false);

    public interface eli {
        void eli(Context context, Intent intent, boolean z, int i);
    }

    public static int eli(Context context, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (ui + j <= elapsedRealtime) {
            return DbA(context);
        }
        if (aGH == -1) {
            return DbA(context);
        }
        if (elapsedRealtime - ui >= MGA) {
            DbA(context, (Intent) null, false, false);
        }
        return aGH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(final Context context, final Intent intent, final boolean z, final boolean z2) {
        if (!z && z2) {
            aGH = 0;
        } else if (wC.compareAndSet(false, true)) {
            com.bytedance.sdk.component.wC.MGA.DbA(new com.bytedance.sdk.component.wC.wC("getNetworkType") { // from class: com.bytedance.sdk.component.utils.ujq.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = ujq.aGH = z2 ? 0 : ujq.DbA(context);
                    ujq.wC.set(false);
                    if (z) {
                        ujq.DbA(context, intent, ujq.aGH, z2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(Context context, Intent intent, int i, boolean z) {
        Map<eli, Object> map = DbA;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (eli eliVar : map.keySet()) {
            if (eliVar != null) {
                try {
                    eliVar.eli(context, intent, !z, i);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int DbA(Context context) {
        aGH = Os(context);
        ui = SystemClock.elapsedRealtime();
        return aGH;
    }

    private static int Os(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        QX qx = kb;
                        return (qx == null || !qx.eli(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static void eli(eli eliVar, Context context) {
        if (eliVar == null) {
            return;
        }
        if (!Os.get()) {
            try {
                context.registerReceiver(new DbA(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                Os.set(true);
            } catch (Throwable unused) {
            }
        }
        DbA.put(eliVar, eli);
    }

    public static void eli(eli eliVar) {
        if (eliVar == null) {
            return;
        }
        DbA.remove(eliVar);
    }

    private static class DbA extends BroadcastReceiver {
        private DbA() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                boolean z = false;
                boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                if (ujq.DbA != null && ujq.DbA.size() > 0) {
                    z = true;
                }
                ujq.DbA(context, intent, z, booleanExtra);
            } catch (Throwable unused) {
            }
        }
    }
}
