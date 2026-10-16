package com.bytedance.adsdk.eli.DbA.DbA.eli;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Xb implements com.bytedance.adsdk.eli.DbA.DbA.eli {
    private final String eli;

    public Xb(String str) {
        this.eli = str;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public Object eli(Map<String, JSONObject> map) {
        return this.eli;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public com.bytedance.adsdk.eli.DbA.aGH.ui eli() {
        return com.bytedance.adsdk.eli.DbA.aGH.MGA.STRING;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public String DbA() {
        return "'" + this.eli + "'";
    }

    public String toString() {
        return DbA();
    }
}
