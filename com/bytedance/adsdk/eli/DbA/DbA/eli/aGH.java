package com.bytedance.adsdk.eli.DbA.DbA.eli;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH extends dV {
    public aGH() {
        super(com.bytedance.adsdk.eli.DbA.aGH.Os.EQ);
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public Object eli(Map<String, JSONObject> map) {
        Object eli = this.eli.eli(map);
        Object eli2 = this.DbA.eli(map);
        if (eli == null && eli2 == null) {
            return Boolean.TRUE;
        }
        if (eli == null && eli2 != null) {
            return Boolean.FALSE;
        }
        if (eli != null && eli2 == null) {
            return Boolean.FALSE;
        }
        if ((eli instanceof Number) && (eli2 instanceof Number)) {
            return Boolean.valueOf(com.bytedance.adsdk.eli.DbA.ui.eli.DbA.eli((Number) eli, (Number) eli2));
        }
        return Boolean.valueOf(eli.equals(eli2));
    }
}
