package com.bytedance.sdk.openadsdk.core.du;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aAs {
    private final URL DbA;
    private final String Os;
    private final String aGH;
    private final String eli;

    private aAs(String str, String str2, String str3, String str4) throws MalformedURLException {
        this.eli = str2;
        this.DbA = new URL(str);
        this.Os = str3;
        this.aGH = str4;
    }

    public String eli() {
        return this.eli;
    }

    public String DbA() {
        return this.Os;
    }

    public URL Os() {
        return this.DbA;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aAs)) {
            return false;
        }
        aAs aas = (aAs) obj;
        if (eli(this.eli, aas.eli) && eli(this.DbA, aas.DbA) && eli(this.Os, aas.Os)) {
            return eli(this.aGH, aas.aGH);
        }
        return false;
    }

    public int hashCode() {
        String str = this.eli;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.DbA.hashCode()) * 31;
        String str2 = this.Os;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.aGH;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    private boolean eli(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public JSONObject aGH() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(VastAttributes.API_FRAMEWORK, CampaignEx.KEY_OMID);
            jSONObject.put("javascriptResourceUrl", this.DbA.toString());
            if (!TextUtils.isEmpty(this.eli)) {
                jSONObject.put("vendorKey", this.eli);
            }
            if (!TextUtils.isEmpty(this.Os)) {
                jSONObject.put("verificationParameters", this.Os);
            }
            if (!TextUtils.isEmpty(this.aGH)) {
                jSONObject.put("verificationNotExecuted", this.aGH);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static aAs eli(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new aAs(str, str2, str3, str4);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static aAs eli(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(VastAttributes.API_FRAMEWORK);
            String optString2 = jSONObject.optString("javascriptResourceUrl");
            if (CampaignEx.KEY_OMID.equalsIgnoreCase(optString) && !TextUtils.isEmpty(optString2)) {
                return new aAs(optString2, jSONObject.optString("vendorKey"), jSONObject.optString("verificationParameters"), jSONObject.optString("verificationNotExecuted"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static HashSet<aAs> eli(JSONArray jSONArray) {
        HashSet<aAs> hashSet = new HashSet<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    hashSet.add(eli(jSONArray.getJSONObject(i)));
                } catch (Throwable unused) {
                }
            }
        }
        return hashSet;
    }
}
