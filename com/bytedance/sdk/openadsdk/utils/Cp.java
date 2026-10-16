package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.ironsource.C3114ha;

/* loaded from: classes3.dex */
public class Cp {
    private static String eli;

    public static boolean Os() {
        return false;
    }

    public static boolean eli() {
        return com.bytedance.sdk.component.utils.Dfc.aGH() && com.bytedance.sdk.openadsdk.core.FC.DbA().dV() && com.bytedance.sdk.openadsdk.core.FC.DbA().QX();
    }

    public static String eli(String str) {
        try {
            if (!eli()) {
                return str;
            }
            String Xb = com.bytedance.sdk.openadsdk.core.FC.DbA().Xb();
            if (TextUtils.isEmpty(Xb)) {
                return str;
            }
            Log.d("TestHelperUtils", "AnyDoorId=".concat(String.valueOf(Xb)));
            return Uri.parse(str).buildUpon().appendQueryParameter(DbA(), Xb).appendQueryParameter(C3114ha.b, "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String DbA() {
        if (TextUtils.isEmpty(eli)) {
            eli = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return eli;
    }
}
