package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.ironsource.C3040d4;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MGA {
    public static String eli(String str) {
        if (!com.bytedance.sdk.component.utils.Dfc.aGH() || TextUtils.isEmpty(str)) {
            return str;
        }
        com.bytedance.sdk.openadsdk.core.model.aAs aas = new com.bytedance.sdk.openadsdk.core.model.aAs(com.bytedance.sdk.openadsdk.core.FC.DbA().NU());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = aas.DbA().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append(C3040d4.i.c).append(aas.eli());
                } else {
                    sb.append("?").append(aas.eli());
                }
            }
        }
        return sb.toString();
    }
}
