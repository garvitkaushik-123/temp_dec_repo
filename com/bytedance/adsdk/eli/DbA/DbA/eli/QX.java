package com.bytedance.adsdk.eli.DbA.DbA.eli;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class QX implements com.bytedance.adsdk.eli.DbA.DbA.DbA {
    private com.bytedance.adsdk.eli.DbA.DbA.eli DbA;
    private com.bytedance.adsdk.eli.DbA.DbA.eli Os;
    private com.bytedance.adsdk.eli.DbA.DbA.eli eli;

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public Object eli(Map<String, JSONObject> map) {
        Object eli = this.eli.eli(map);
        if (eli == null) {
            return null;
        }
        if (((Boolean) eli).booleanValue()) {
            return this.DbA.eli(map);
        }
        return this.Os.eli(map);
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public com.bytedance.adsdk.eli.DbA.aGH.ui eli() {
        return com.bytedance.adsdk.eli.DbA.aGH.MGA.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.DbA
    public void eli(com.bytedance.adsdk.eli.DbA.DbA.eli eliVar) {
        this.eli = eliVar;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.DbA
    public void DbA(com.bytedance.adsdk.eli.DbA.DbA.eli eliVar) {
        this.DbA = eliVar;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.DbA
    public void Os(com.bytedance.adsdk.eli.DbA.DbA.eli eliVar) {
        this.Os = eliVar;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public String DbA() {
        return this.eli.DbA() + "?" + this.DbA.DbA() + ":" + this.Os.DbA();
    }

    public String toString() {
        return DbA();
    }
}
