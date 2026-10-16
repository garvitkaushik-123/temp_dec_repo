package com.bytedance.adsdk.ugeno.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class aGH {
    private static Map<String, DbA> eli = new HashMap();

    public static void eli(List<DbA> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (DbA dbA : list) {
            if (dbA != null) {
                eli.put(dbA.eli(), dbA);
            }
        }
    }

    public static DbA eli(String str) {
        return eli.get(str);
    }
}
