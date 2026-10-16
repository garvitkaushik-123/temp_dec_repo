package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class z7 implements n4 {

    /* renamed from: a, reason: collision with root package name */
    private Uri f819a;
    private Uri b;
    private a c;
    private String d;
    private int e;
    private int f;
    private long g;

    public enum a {
        Progressive,
        Streaming
    }

    private z7() {
    }

    public static z7 a(m8 m8Var, com.applovin.impl.sdk.k kVar) {
        if (m8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String d = m8Var.d();
            if (!URLUtil.isValidUrl(d)) {
                kVar.O();
                if (!com.applovin.impl.sdk.o.a()) {
                    return null;
                }
                kVar.O().b("VastVideoFile", "Unable to create video file. Could not find URL.");
                return null;
            }
            Uri parse = Uri.parse(d);
            z7 z7Var = new z7();
            z7Var.f819a = parse;
            z7Var.b = parse;
            z7Var.g = a(m8Var);
            z7Var.c = a((String) m8Var.a().get("delivery"));
            z7Var.f = StringUtils.parseInt((String) m8Var.a().get("height"));
            z7Var.e = StringUtils.parseInt((String) m8Var.a().get("width"));
            z7Var.d = ((String) m8Var.a().get("type")).toLowerCase(Locale.ENGLISH);
            return z7Var;
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("VastVideoFile", "Error occurred while initializing", th);
            }
            kVar.E().a("VastVideoFile", th);
            return null;
        }
    }

    public long b() {
        return this.g;
    }

    public String c() {
        return this.d;
    }

    public Uri d() {
        return this.f819a;
    }

    public Uri e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z7)) {
            return false;
        }
        z7 z7Var = (z7) obj;
        if (this.e != z7Var.e || this.f != z7Var.f || this.g != z7Var.g) {
            return false;
        }
        Uri uri = this.f819a;
        if (uri == null ? z7Var.f819a != null : !uri.equals(z7Var.f819a)) {
            return false;
        }
        Uri uri2 = this.b;
        if (uri2 == null ? z7Var.b != null : !uri2.equals(z7Var.b)) {
            return false;
        }
        if (this.c != z7Var.c) {
            return false;
        }
        String str = this.d;
        String str2 = z7Var.d;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        Uri uri = this.f819a;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.b;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        a aVar = this.c;
        int hashCode3 = (hashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.d;
        return ((((((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.e) * 31) + this.f) * 31) + Long.valueOf(this.g).hashCode();
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.f819a + ", videoUri=" + this.b + ", deliveryType=" + this.c + ", fileType='" + this.d + "', width=" + this.e + ", height=" + this.f + ", bitrate=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }

    private static a a(String str) {
        if (StringUtils.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return a.Streaming;
            }
        }
        return a.Progressive;
    }

    private static long a(m8 m8Var) {
        Map a2 = m8Var.a();
        long parseLong = StringUtils.parseLong((String) a2.get(VastAttributes.BITRATE), 0L);
        return parseLong != 0 ? parseLong : (StringUtils.parseLong((String) a2.get(VastAttributes.MIN_BITRATE), 0L) + StringUtils.parseLong((String) a2.get(VastAttributes.MAX_BITRATE), 0L)) / 2;
    }

    public void a(Uri uri) {
        this.b = uri;
    }

    public static z7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, "source_video_uri", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        Uri parse = Uri.parse(string);
        if (TextUtils.isEmpty(JsonUtils.getString(jSONObject, "video_uri", null))) {
            return null;
        }
        Uri parse2 = Uri.parse(string);
        String string2 = JsonUtils.getString(jSONObject, "file_type", null);
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        a valueOf = a.valueOf(JsonUtils.getString(jSONObject, "delivery_type", a.Progressive.toString()));
        int i = JsonUtils.getInt(jSONObject, "width", 0);
        int i2 = JsonUtils.getInt(jSONObject, "height", 0);
        int i3 = JsonUtils.getInt(jSONObject, VastAttributes.BITRATE, 0);
        z7 z7Var = new z7();
        z7Var.f819a = parse;
        z7Var.b = parse2;
        z7Var.c = valueOf;
        z7Var.d = string2;
        z7Var.e = i;
        z7Var.f = i2;
        z7Var.g = i3;
        return z7Var;
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        Uri uri = this.f819a;
        if (uri != null) {
            JsonUtils.putString(jSONObject, "source_video_uri", uri.toString());
        }
        Uri uri2 = this.b;
        if (uri2 != null) {
            JsonUtils.putString(jSONObject, "video_uri", uri2.toString());
        }
        a aVar = this.c;
        JsonUtils.putString(jSONObject, "delivery_type", aVar == null ? null : aVar.toString());
        JsonUtils.putString(jSONObject, "file_type", this.d);
        JsonUtils.putInt(jSONObject, "width", this.e);
        JsonUtils.putInt(jSONObject, "height", this.f);
        JsonUtils.putLong(jSONObject, VastAttributes.BITRATE, this.g);
        return jSONObject;
    }
}
