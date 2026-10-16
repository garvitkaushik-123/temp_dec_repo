package com.bytedance.adsdk.eli.DbA.DbA.eli;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FC extends dV {
    public FC() {
        super(com.bytedance.adsdk.eli.DbA.aGH.Os.LT);
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public Object eli(Map<String, JSONObject> map) {
        Object eli;
        Object eli2 = this.eli.eli(map);
        if (eli2 == null || (eli = this.DbA.eli(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.eli.DbA.ui.eli.aGH.eli(eli2, (Number) eli);
    }
}
