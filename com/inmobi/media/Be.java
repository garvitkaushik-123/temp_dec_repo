package com.inmobi.media;

import com.inmobi.unifiedId.InMobiUserDataModel;
import com.inmobi.unifiedId.InMobiUserDataTypes;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Be extends Ac {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Be(String url, C2897ue c2897ue, String str, int i, int i2, int i3) {
        super(url, c2897ue, str, i, i2);
        Intrinsics.checkNotNullParameter("POST", "requestType");
        Intrinsics.checkNotNullParameter(url, "url");
        this.p = i3;
    }

    @Override // com.inmobi.media.N9
    public final void f() {
        InMobiUserDataTypes inMobiUserDataTypes;
        InMobiUserDataTypes inMobiUserDataTypes2;
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        String str;
        HashMap hashMap5;
        super.f();
        InMobiUserDataModel inMobiUserDataModel = L4.f2349a;
        String.valueOf(L4.f2349a);
        HashMap a2 = AbstractC2564ab.a();
        HashMap hashMap6 = this.k;
        if (hashMap6 != null) {
            hashMap6.put("mk-version", Vc.a());
            String str2 = C2623e1.f2554a;
            if (str2 != null) {
            }
            hashMap6.put(com.ironsource.N6.d0, Uc.k());
            hashMap6.put("ts", String.valueOf(System.currentTimeMillis()));
        }
        String str3 = this.m;
        if (str3 != null && (hashMap5 = this.k) != null) {
        }
        Boolean c = C2881te.f2715a.c();
        HashMap hashMap7 = this.k;
        if (hashMap7 != null) {
            if (c == null || (str = c.toString()) == null) {
                str = "true";
            }
        }
        String str4 = (String) a2.get("u-age");
        if (str4 != null && (hashMap4 = this.k) != null) {
        }
        InMobiUserDataModel inMobiUserDataModel2 = L4.f2349a;
        if (inMobiUserDataModel2 == null || (inMobiUserDataTypes = inMobiUserDataModel2.getEmailId()) == null || (inMobiUserDataTypes.getMd5() == null && inMobiUserDataTypes.getSha1() == null && inMobiUserDataTypes.getSha256() == null)) {
            inMobiUserDataTypes = null;
        }
        if (inMobiUserDataTypes != null && (hashMap3 = this.k) != null) {
        }
        InMobiUserDataModel inMobiUserDataModel3 = L4.f2349a;
        if (inMobiUserDataModel3 == null || (inMobiUserDataTypes2 = inMobiUserDataModel3.getPhoneNumber()) == null || (inMobiUserDataTypes2.getMd5() == null && inMobiUserDataTypes2.getSha1() == null && inMobiUserDataTypes2.getSha256() == null)) {
            inMobiUserDataTypes2 = null;
        }
        if (inMobiUserDataTypes2 != null && (hashMap2 = this.k) != null) {
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject b = Q5.b();
        if (b != null) {
            try {
                if (b.has("ufids")) {
                    JSONArray jSONArray2 = b.getJSONArray("ufids");
                    int length = jSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray2.getJSONObject(i).has("src") ? jSONArray2.getJSONObject(i).getString("src") : null;
                        String string2 = jSONArray2.getJSONObject(i).has(InAppPurchaseMetaData.KEY_SIGNATURE) ? jSONArray2.getJSONObject(i).getString(InAppPurchaseMetaData.KEY_SIGNATURE) : null;
                        boolean z = System.currentTimeMillis() > jSONArray2.getJSONObject(i).getLong("expiry");
                        if (string != null && string2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("src", string);
                            jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, string2);
                            jSONObject.put("expired", z);
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (JSONException unused) {
                Objects.toString(b);
            }
        }
        HashMap hashMap8 = this.k;
        if (hashMap8 != null) {
            String jSONArray3 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray3, "toString(...)");
        }
        InMobiUserDataModel inMobiUserDataModel4 = L4.f2349a;
        HashMap<String, String> extras = inMobiUserDataModel4 != null ? inMobiUserDataModel4.getExtras() : null;
        if (extras == null || (hashMap = this.k) == null) {
            return;
        }
        hashMap.putAll(extras);
    }
}
