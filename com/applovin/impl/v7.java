package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class v7 implements n4 {

    /* renamed from: a, reason: collision with root package name */
    private String f772a;
    private String b;
    private String c;
    private boolean d;
    private long e = -1;
    private int f = -1;

    private v7() {
    }

    public static v7 a(m8 m8Var, p7 p7Var, com.applovin.impl.sdk.k kVar) {
        List<String> explode;
        int size;
        long seconds;
        if (m8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String d = m8Var.d();
            if (TextUtils.isEmpty(d)) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().b("VastTracker", "Unable to create tracker. Could not find URL.");
                }
                return null;
            }
            v7 v7Var = new v7();
            v7Var.c = d;
            v7Var.f772a = (String) m8Var.a().get("id");
            v7Var.b = (String) m8Var.a().get("event");
            v7Var.d = ((Boolean) kVar.a(v4.Z4)).booleanValue();
            if (p7Var != null) {
                v7Var.d = JsonUtils.getBoolean(p7Var.b(), "vast_fire_trackers_from_webview", Boolean.valueOf(v7Var.d)).booleanValue();
            }
            v7Var.f = a(v7Var.b(), p7Var);
            String str = (String) m8Var.a().get("offset");
            if (StringUtils.isValidString(str)) {
                String trim = str.trim();
                if (trim.contains("%")) {
                    v7Var.f = StringUtils.parseInt(trim.substring(0, trim.length() - 1));
                    return v7Var;
                }
                if (trim.contains(":") && (size = (explode = CollectionUtils.explode(trim, ":")).size()) > 0) {
                    int i = size - 1;
                    long j = 0;
                    for (int i2 = i; i2 >= 0; i2--) {
                        String str2 = explode.get(i2);
                        if (StringUtils.isNumeric(str2)) {
                            int parseInt = Integer.parseInt(str2);
                            if (i2 == i) {
                                seconds = parseInt;
                            } else if (i2 == size - 2) {
                                seconds = TimeUnit.MINUTES.toSeconds(parseInt);
                            } else if (i2 == size - 3) {
                                seconds = TimeUnit.HOURS.toSeconds(parseInt);
                            }
                            j += seconds;
                        }
                    }
                    v7Var.e = j;
                    v7Var.f = -1;
                }
            }
            return v7Var;
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("VastTracker", "Error occurred while initializing", th);
            }
            kVar.E().a("VastTracker", th);
            return null;
        }
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v7)) {
            return false;
        }
        v7 v7Var = (v7) obj;
        if (this.e != v7Var.e || this.f != v7Var.f) {
            return false;
        }
        String str = this.f772a;
        if (str == null ? v7Var.f772a != null : !str.equals(v7Var.f772a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? v7Var.b == null : str2.equals(v7Var.b)) {
            return this.c.equals(v7Var.c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f772a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c.hashCode()) * 31;
        long j = this.e;
        return ((hashCode2 + ((int) (j ^ (j >>> 32)))) * 31) + this.f;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.f772a + "', event='" + this.b + "', uriString='" + this.c + "', offsetSeconds=" + this.e + ", offsetPercent=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean a(long j, int i) {
        long j2 = this.e;
        boolean z = j2 >= 0;
        boolean z2 = j >= j2;
        int i2 = this.f;
        return (z && z2) || ((i2 >= 0) && (i >= i2));
    }

    private static int a(String str, p7 p7Var) {
        if ("start".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if (CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT.equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!CampaignEx.JSON_NATIVE_VIDEO_COMPLETE.equalsIgnoreCase(str)) {
            return -1;
        }
        if (p7Var != null) {
            return p7Var.g();
        }
        return 95;
    }

    public static v7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        v7 v7Var = new v7();
        String string = JsonUtils.getString(jSONObject, "uri_string", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        v7Var.c = string;
        v7Var.f772a = JsonUtils.getString(jSONObject, "identifier", "");
        v7Var.b = JsonUtils.getString(jSONObject, "event", "");
        v7Var.e = JsonUtils.getLong(jSONObject, "offset_seconds", -1L);
        v7Var.f = JsonUtils.getInt(jSONObject, "offset_percent", -1);
        return v7Var;
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "identifier", this.f772a);
        JsonUtils.putString(jSONObject, "event", this.b);
        JsonUtils.putString(jSONObject, "uri_string", this.c);
        JsonUtils.putLong(jSONObject, "offset_seconds", this.e);
        JsonUtils.putInt(jSONObject, "offset_percent", this.f);
        return jSONObject;
    }
}
