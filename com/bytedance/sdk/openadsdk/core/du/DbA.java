package com.bytedance.sdk.openadsdk.core.du;

import com.bytedance.sdk.openadsdk.core.du.Os.eli;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA extends Os {
    private long aAs;
    private long du;

    public DbA(int i, int i2, long j, long j2, eli.EnumC0190eli enumC0190eli, eli.DbA dbA, String str, List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list, List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list2, String str2) {
        super(i, i2, enumC0190eli, dbA, str, list, list2, str2);
        this.aAs = j;
        this.du = j2;
        this.FC = "icon_click";
    }

    @Override // com.bytedance.sdk.openadsdk.core.du.Os
    public JSONObject eli() throws JSONException {
        JSONObject eli = super.eli();
        if (eli != null) {
            eli.put("offset", this.aAs);
            eli.put("duration", this.du);
        }
        return eli;
    }

    public static DbA eli(JSONObject jSONObject) {
        Os DbA = Os.DbA(jSONObject);
        if (DbA == null) {
            return null;
        }
        return new DbA(DbA.eli, DbA.DbA, jSONObject.optLong("offset", -1L), jSONObject.optLong("duration", -1L), DbA.Os, DbA.aGH, DbA.ui, DbA.MGA, DbA.kb, DbA.wC);
    }
}
