package com.bytedance.adsdk.ugeno.aGH.eli;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class eli {
    private volatile Map<String, Os> eli = new HashMap();

    public Os eli(String str) {
        if (this.eli.containsKey(str) && this.eli.get(str) != null) {
            return this.eli.get(str);
        }
        DbA dbA = new DbA();
        this.eli.put(str, dbA);
        return dbA;
    }

    public void eli(String str, Os os) {
        if (!this.eli.containsKey(str) || this.eli.get(str) == null) {
            this.eli.put(str, os);
        }
    }
}
