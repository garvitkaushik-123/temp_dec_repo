package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;

/* loaded from: classes3.dex */
public class DbA {
    public static Boolean eli;

    public static void eli() {
        eli = Boolean.TRUE;
        com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
    }

    public static void DbA() {
        eli = Boolean.FALSE;
        BinderPoolService.eli = true;
    }

    public static boolean Os() {
        Boolean bool = eli;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!nn.ui()) {
            return false;
        }
        if (eli == null) {
            eli = Boolean.valueOf(com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_info", "is_support_multi_process", false));
        }
        return eli.booleanValue();
    }
}
