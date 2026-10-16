package com.bytedance.sdk.openadsdk.wC;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.Cp;
import java.util.Map;

/* loaded from: classes3.dex */
public final class aGH extends eli {
    public static Os eli;

    public static String eli(com.bytedance.sdk.component.kb.DbA.Os os, String str) {
        Os eli2;
        Map map;
        if (!Cp.Os() || (eli2 = DbA.eli("net")) == null || (map = (Map) eli2.eli(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                os.DbA(str3, (String) map2.get(str3));
            }
        }
        return str;
    }
}
