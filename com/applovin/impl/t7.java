package com.applovin.impl;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class t7 implements n4 {

    /* renamed from: a, reason: collision with root package name */
    private a f741a;
    private Uri b;
    private String c;

    public enum a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private t7() {
    }

    static t7 a(m8 m8Var, t7 t7Var, com.applovin.impl.sdk.k kVar) {
        if (m8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (t7Var == null) {
            try {
                t7Var = new t7();
            } catch (Throwable th) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("VastNonVideoResource", "Error occurred while initializing", th);
                }
                kVar.E().a("VastNonVideoResource", th);
                return null;
            }
        }
        if (t7Var.b == null && !StringUtils.isValidString(t7Var.c)) {
            String a2 = a(m8Var, "StaticResource");
            if (URLUtil.isValidUrl(a2)) {
                t7Var.b = Uri.parse(a2);
                t7Var.f741a = a.STATIC;
                return t7Var;
            }
            String a3 = a(m8Var, "IFrameResource");
            if (StringUtils.isValidString(a3)) {
                t7Var.f741a = a.IFRAME;
                if (URLUtil.isValidUrl(a3)) {
                    t7Var.b = Uri.parse(a3);
                    return t7Var;
                }
                t7Var.c = a3;
                return t7Var;
            }
            String a4 = a(m8Var, "HTMLResource");
            if (StringUtils.isValidString(a4)) {
                t7Var.f741a = a.HTML;
                if (URLUtil.isValidUrl(a4)) {
                    t7Var.b = Uri.parse(a4);
                    return t7Var;
                }
                t7Var.c = a4;
            }
        }
        return t7Var;
    }

    public String b() {
        return this.c;
    }

    public Uri c() {
        return this.b;
    }

    public a d() {
        return this.f741a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t7)) {
            return false;
        }
        t7 t7Var = (t7) obj;
        if (this.f741a != t7Var.f741a) {
            return false;
        }
        Uri uri = this.b;
        if (uri == null ? t7Var.b != null : !uri.equals(t7Var.b)) {
            return false;
        }
        String str = this.c;
        String str2 = t7Var.c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        a aVar = this.f741a;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.b;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.c;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.f741a + ", resourceUri=" + this.b + ", resourceContents='" + this.c + "'}";
    }

    private static String a(m8 m8Var, String str) {
        m8 c = m8Var.c(str);
        if (c != null) {
            return c.d();
        }
        return null;
    }

    public void a(Uri uri) {
        this.b = uri;
    }

    public void a(String str) {
        this.c = str;
    }

    public static t7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, "type", null);
        a valueOf = string == null ? null : a.valueOf(string);
        String string2 = JsonUtils.getString(jSONObject, "resource_uri", null);
        Uri parse = StringUtils.isValidString(string2) ? Uri.parse(string2) : null;
        t7 t7Var = new t7();
        t7Var.f741a = valueOf;
        t7Var.b = parse;
        t7Var.c = JsonUtils.getString(jSONObject, "resource_contents", null);
        return t7Var;
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        a aVar = this.f741a;
        JsonUtils.putString(jSONObject, "type", aVar == null ? null : aVar.toString());
        Uri uri = this.b;
        JsonUtils.putString(jSONObject, "resource_uri", uri != null ? uri.toString() : null);
        JsonUtils.putString(jSONObject, "resource_contents", this.c);
        return jSONObject;
    }
}
