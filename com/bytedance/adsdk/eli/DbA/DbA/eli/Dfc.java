package com.bytedance.adsdk.eli.DbA.DbA.eli;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Dfc implements com.bytedance.adsdk.eli.DbA.DbA.eli {
    private Number eli;

    public Dfc(String str) {
        if (str.indexOf(46) >= 0) {
            Float valueOf = Float.valueOf(str);
            this.eli = valueOf;
            if (Float.isInfinite(valueOf.floatValue())) {
                this.eli = Double.valueOf(str);
                return;
            }
            return;
        }
        try {
            this.eli = Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            this.eli = Long.valueOf(str);
        }
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public Object eli(Map<String, JSONObject> map) {
        return this.eli;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public com.bytedance.adsdk.eli.DbA.aGH.ui eli() {
        return com.bytedance.adsdk.eli.DbA.aGH.MGA.NUMBER;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public String DbA() {
        return this.eli.toString();
    }

    public String toString() {
        return DbA();
    }
}
