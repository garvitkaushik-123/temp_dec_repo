package com.bytedance.adsdk.eli.DbA.DbA.eli;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NU extends dV {
    public NU() {
        super(com.bytedance.adsdk.eli.DbA.aGH.Os.MULTI);
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public Object eli(Map<String, JSONObject> map) {
        Object eli;
        Object eli2 = this.eli.eli(map);
        if (eli2 == null || (eli = this.DbA.eli(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.eli.DbA.ui.eli.kb.eli((Number) eli2, (Number) eli);
    }
}
