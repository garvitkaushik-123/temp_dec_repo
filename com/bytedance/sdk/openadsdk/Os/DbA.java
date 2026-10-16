package com.bytedance.sdk.openadsdk.Os;

import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.core.dV;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private static volatile DbA eli;
    private final CMM<com.bytedance.sdk.openadsdk.aGH.eli> DbA = dV.Os();

    private DbA() {
    }

    public static DbA eli() {
        if (eli == null) {
            synchronized (DbA.class) {
                if (eli == null) {
                    eli = new DbA();
                }
            }
        }
        return eli;
    }

    public void eli(String str, List<FilterWord> list, String str2) {
        eli(str, list, null, null, str2);
    }

    public void eli(String str, List<FilterWord> list, JSONObject jSONObject, String str2, String str3) {
        this.DbA.eli(str, list, jSONObject, str2, str3);
    }
}
