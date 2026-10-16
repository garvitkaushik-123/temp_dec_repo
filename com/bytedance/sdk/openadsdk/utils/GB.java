package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ironsource.C3207n2;
import com.ironsource.mediationsdk.d;
import java.util.Map;

/* loaded from: classes3.dex */
public class GB {
    public static void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, Double d) {
        if (evVar == null || evVar.FYe() == null) {
            return;
        }
        Map<String, Object> FYe = evVar.FYe();
        try {
            Object obj = evVar.FYe().get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String str = (String) FYe.get(C3207n2.A);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (d != null) {
                    str = str.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d));
                }
                com.bytedance.sdk.openadsdk.core.dV.Os().eli(str);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.Xb.Os("report Win error", new Object[0]);
        }
    }

    public static void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, Double d, String str, String str2) {
        if (evVar == null || evVar.FYe() == null) {
            return;
        }
        Map<String, Object> FYe = evVar.FYe();
        try {
            Object obj = evVar.FYe().get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String str3 = (String) FYe.get(C3207n2.z);
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                if (d != null) {
                    str3 = str3.replace(d.n, String.valueOf(d));
                }
                if (str != null) {
                    str3 = str3.replace(d.l, str);
                }
                if (str2 != null) {
                    str3 = str3.replace("${AUCTION_WINNER}", str2);
                }
                com.bytedance.sdk.openadsdk.core.dV.Os().eli(str3);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.Xb.Os("report Loss error", new Object[0]);
        }
    }
}
