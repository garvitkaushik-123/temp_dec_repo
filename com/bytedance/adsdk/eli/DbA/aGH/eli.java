package com.bytedance.adsdk.eli.DbA.aGH;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum eli implements ui {
    TRUE,
    FALSE,
    NULL;

    private static final Map<String, eli> aGH = new HashMap(128);

    static {
        for (eli eliVar : values()) {
            aGH.put(eliVar.name().toLowerCase(), eliVar);
        }
    }

    public static eli eli(String str) {
        return aGH.get(str.toLowerCase());
    }
}
