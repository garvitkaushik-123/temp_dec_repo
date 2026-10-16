package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import io.bidmachine.iab.vast.tags.VastAttributes;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class s7 implements n4 {

    /* renamed from: a, reason: collision with root package name */
    private final String f652a;
    private final String b;

    private s7(String str, String str2) {
        this.f652a = str;
        this.b = str2;
    }

    public static s7 a(m8 m8Var, com.applovin.impl.sdk.k kVar) {
        if (m8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            return new s7((String) m8Var.a().get(VastAttributes.API_FRAMEWORK), m8Var.d());
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("VastJavaScriptResource", "Error occurred while initializing", th);
            }
            kVar.E().a("VastJavaScriptResource", th);
            return null;
        }
    }

    public String b() {
        return this.f652a;
    }

    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            s7 s7Var = (s7) obj;
            String str = this.f652a;
            if (str == null ? s7Var.f652a != null : !str.equals(s7Var.f652a)) {
                return false;
            }
            String str2 = this.b;
            String str3 = s7Var.b;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f652a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastJavaScriptResource{apiFramework='" + this.f652a + "', javascriptResourceUrl='" + this.b + "'}";
    }

    public static s7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        return new s7(JsonUtils.getString(jSONObject, "api_framework", null), JsonUtils.getString(jSONObject, "javascript_resource_url", null));
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "api_framework", this.f652a);
        JsonUtils.putString(jSONObject, "javascript_resource_url", this.b);
        return jSONObject;
    }
}
