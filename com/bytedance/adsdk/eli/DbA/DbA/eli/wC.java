package com.bytedance.adsdk.eli.DbA.DbA.eli;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class wC extends dV {
    public wC() {
        super(com.bytedance.adsdk.eli.DbA.aGH.Os.LT_EQ);
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public Object eli(Map<String, JSONObject> map) {
        Object eli;
        if (this.eli.eli(map) == null || (eli = this.DbA.eli(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.eli.DbA.ui.eli.Os.eli(r0, (Number) eli)).booleanValue());
    }
}
