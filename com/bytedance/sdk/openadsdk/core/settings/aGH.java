package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

/* loaded from: classes3.dex */
public class aGH {
    private static volatile String DbA = "";
    private static String Os = null;
    private static volatile int aGH = 0;
    private static volatile String eli = "";

    public static void eli() {
        try {
            AppSet.getClient(dV.eli()).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() { // from class: com.bytedance.sdk.openadsdk.core.settings.AppSetIdAndScope$1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(AppSetIdInfo appSetIdInfo) {
                    String unused = aGH.eli = Integer.toString(appSetIdInfo.getScope());
                    String unused2 = aGH.DbA = appSetIdInfo.getId();
                    int unused3 = aGH.aGH = 1;
                }
            });
        } catch (Throwable unused) {
            aGH = 2;
        }
    }

    public static String DbA() {
        if (aGH != 0) {
            return eli;
        }
        eli();
        return eli;
    }

    public static String Os() {
        if (aGH != 0) {
            return DbA;
        }
        eli();
        return DbA;
    }

    public static String aGH() {
        if (TextUtils.isEmpty(Os)) {
            Os = dV.eli().getPackageManager().getInstallerPackageName(dZ.MGA());
        }
        if (Os == null) {
            Os = "";
        }
        return Os;
    }
}
