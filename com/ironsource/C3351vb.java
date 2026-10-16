package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Map;

/* renamed from: com.ironsource.vb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3351vb {
    public final void a(Map<String, String> map, boolean z) {
        if (z && TextUtils.isEmpty(com.ironsource.mediationsdk.p.j().n()) && map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                if (IronSourceUtils.doesClassExist(str)) {
                    String str2 = map.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                    com.ironsource.mediationsdk.p.j().setMediationType(str);
                    return;
                }
            }
        }
    }
}
