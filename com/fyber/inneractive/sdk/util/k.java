package com.fyber.inneractive.sdk.util;

import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;

/* loaded from: classes4.dex */
public abstract class k extends o {
    public static String i() {
        try {
            return ((TelephonyManager) o.f1770a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkCountryIso();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String j() {
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static int k() {
        try {
            if (o.a("android.permission.READ_PHONE_STATE")) {
                return ((TelephonyManager) o.f1770a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getDataNetworkType();
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String l() {
        try {
            return o.f1770a.getPackageManager().getPackageInfo(o.f1770a.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean m() {
        boolean z = (o.f1770a.getResources().getConfiguration().screenLayout & 15) == 4;
        IAlog.e("This device has a tablet resolution? %s", Boolean.valueOf(z));
        return z;
    }

    public static boolean n() {
        TelephonyManager telephonyManager = (TelephonyManager) o.f1770a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        return telephonyManager != null && telephonyManager.getSimState() == 5;
    }
}
