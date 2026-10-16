package com.bytedance.adsdk.eli.DbA.DbA.eli;

import com.ironsource.C3040d4;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb implements com.bytedance.adsdk.eli.DbA.DbA.eli {
    private final Object eli;

    public kb(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.eli = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.eli = Boolean.FALSE;
        } else {
            if (str.equalsIgnoreCase("null")) {
                this.eli = null;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public Object eli(Map<String, JSONObject> map) {
        return this.eli;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public com.bytedance.adsdk.eli.DbA.aGH.ui eli() {
        return com.bytedance.adsdk.eli.DbA.aGH.MGA.CONSTANT;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.eli + C3040d4.i.e;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public String DbA() {
        Object obj = this.eli;
        if (obj != null) {
            return obj.toString();
        }
        return "NULL";
    }
}
