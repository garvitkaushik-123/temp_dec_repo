package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;

/* loaded from: classes4.dex */
public abstract class a {
    public static r0 a(String str) {
        IAConfigManager iAConfigManager = IAConfigManager.O;
        HashMap hashMap = iAConfigManager.b;
        if (hashMap != null && hashMap.containsKey(str)) {
            return (r0) iAConfigManager.b.get(str);
        }
        IAlog.c("Requested unit config doesn't exists - %s", str);
        return null;
    }
}
