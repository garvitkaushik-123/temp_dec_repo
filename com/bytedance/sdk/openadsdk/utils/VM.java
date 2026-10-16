package com.bytedance.sdk.openadsdk.utils;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class VM {
    private static String DbA = null;
    private static String Os = null;
    private static volatile boolean aGH = true;
    private static String eli;

    /* JADX INFO: Access modifiers changed from: private */
    public static void ui() {
        String str;
        String str2;
        String str3;
        if (com.bytedance.sdk.openadsdk.core.dV.eli() == null) {
            return;
        }
        aGH = true;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.bytedance.sdk.openadsdk.core.dV.eli().getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            try {
                int simState = telephonyManager.getSimState();
                if (simState == 0) {
                    aGH = false;
                } else if (simState == 1) {
                    aGH = false;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.Os("SimUtils", th.getMessage());
            }
            String str4 = null;
            try {
                str = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                str = null;
            }
            try {
                str2 = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                str2 = null;
            }
            if (str2 == null || str2.length() < 5) {
                try {
                    str2 = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(str2) || str2.length() <= 4) {
                str3 = null;
            } else {
                String substring = str2.substring(0, 3);
                str3 = str2.substring(3);
                str4 = substring;
            }
            if (!TextUtils.isEmpty(str)) {
                eli = str;
            }
            if (!TextUtils.isEmpty(str4)) {
                DbA = str4;
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            Os = str3;
        } catch (Throwable unused4) {
        }
    }

    public static String eli() {
        eli.eli();
        return eli;
    }

    public static String DbA() {
        try {
            eli.eli();
            if (!aGH) {
                com.bytedance.sdk.component.utils.Xb.Os("MCC", "getMCC" + (aGH ? "Have SIM card" : "No SIM card, MCC returns null"));
                return null;
            }
            Configuration configuration = com.bytedance.sdk.openadsdk.core.dV.eli().getResources().getConfiguration();
            String valueOf = configuration.mcc != 0 ? String.valueOf(configuration.mcc) : DbA;
            com.bytedance.sdk.component.utils.Xb.Os("MCC", "config=" + configuration.mcc + ",sMCC=" + DbA);
            return valueOf;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("SimUtils", th.getMessage());
            return null;
        }
    }

    public static String Os() {
        eli.eli();
        return Os;
    }

    public static class eli extends com.bytedance.sdk.component.wC.wC {
        public static AtomicBoolean eli = new AtomicBoolean(false);
        private static final AtomicLong DbA = new AtomicLong(0);

        public eli(String str, int i) {
            super(str, i);
        }

        public static void eli() {
            if (eli.get()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            AtomicLong atomicLong = DbA;
            if (currentTimeMillis - atomicLong.get() < TTAdConstant.AD_MAX_EVENT_TIME) {
                return;
            }
            atomicLong.set(currentTimeMillis);
            cyF.DbA((com.bytedance.sdk.component.wC.wC) new eli("UpdateSimStatusTask", 5));
        }

        @Override // java.lang.Runnable
        public void run() {
            eli.set(true);
            VM.ui();
            eli.set(false);
        }
    }
}
