package com.bytedance.sdk.openadsdk.core.aAs;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.google.firebase.sessions.settings.RemoteSettings;

/* loaded from: classes3.dex */
public class Os {
    public static String eli(String str) {
        return TextUtils.isEmpty(str) ? str : eli(NU.nY().GMY(), str);
    }

    public static String eli(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.startsWith("http://") || str2.startsWith("https://")) {
            return str2;
        }
        if (!TextUtils.isEmpty(str) && !str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            return str + "/static/" + str2;
        }
        return str + "static/" + str2;
    }
}
