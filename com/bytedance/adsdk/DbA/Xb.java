package com.bytedance.adsdk.DbA;

import java.util.Map;

/* loaded from: classes3.dex */
public class Xb {
    private boolean DbA;
    private final Map<String, String> eli;

    public String eli(String str) {
        return str;
    }

    public String eli(String str, String str2) {
        return eli(str2);
    }

    public final String DbA(String str, String str2) {
        if (this.DbA && this.eli.containsKey(str2)) {
            return this.eli.get(str2);
        }
        String eli = eli(str, str2);
        if (this.DbA) {
            this.eli.put(str2, eli);
        }
        return eli;
    }
}
