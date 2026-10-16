package com.inmobi.media;

import androidx.browser.trusted.sharing.ShareTarget;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.RootConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class U2 extends N9 {
    public final int A;
    public final String B;
    public final boolean C;
    public final Map y;
    public final int z;

    @Override // com.inmobi.media.N9
    public final void f() {
        String str;
        this.u = false;
        super.f();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            Q2 q2 = new Q2();
            try {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry entry : this.y.entrySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.ironsource.D5.q, entry.getKey());
                    jSONObject.put("t", q2.a((String) entry.getKey(), ((Config) entry.getValue()).getAccountId$media_release()));
                    jSONArray.put(jSONObject);
                }
                str = jSONArray.toString();
                Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            } catch (JSONException unused) {
                str = "";
            }
        }
        HashMap hashMap2 = this.k;
        if (hashMap2 != null) {
        }
        if (this.C) {
            this.i.put("rip", "true");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U2(Map requestedConfigMap, C2897ue uidMap, String url, int i, int i2, boolean z, String accountId, boolean z2) {
        super("POST", (requestedConfigMap.get("root") != null || StringsKt.trim((CharSequence) url).toString().length() == 0) ? RootConfig.DEFAULT_FALLBACK_URL : url, uidMap, z, (InterfaceC2971z5) null, ShareTarget.ENCODING_TYPE_URL_ENCODED, 64);
        Intrinsics.checkNotNullParameter(requestedConfigMap, "requestedConfigMap");
        Intrinsics.checkNotNullParameter(uidMap, "uidMap");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        this.y = requestedConfigMap;
        this.z = i;
        this.A = i2;
        this.B = accountId;
        this.C = z2;
    }
}
