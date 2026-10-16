package com.bytedance.adsdk.ugeno.aGH;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class aAs {
    private static Map<String, kb> eli = new HashMap();

    public static void eli(List<kb> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (kb kbVar : list) {
            if (kbVar != null) {
                eli.put(kbVar.eli(), kbVar);
            }
        }
    }

    public static kb eli(String str) {
        return eli.get(str);
    }
}
