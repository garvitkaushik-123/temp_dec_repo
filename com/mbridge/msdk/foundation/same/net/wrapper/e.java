package com.mbridge.msdk.foundation.same.net.wrapper;

import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.tools.p0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommonRequestParams.java */
/* loaded from: classes6.dex */
public final class e {
    private static final String c = "e";
    public static String d = "h";
    public static String e = "i";
    public static String f = "coppa";
    public static String g = "d";
    public static String h = "e";
    public static String i = "a";
    public static String j = "f";
    public static String k = "g";

    /* renamed from: a, reason: collision with root package name */
    private Map<String, com.mbridge.msdk.foundation.same.net.model.a> f4304a = new LinkedHashMap();
    private Map<String, String> b = new LinkedHashMap();

    public void a(String str, String str2) {
        if (str2 == null) {
            p0.b(c, "add() value is null!");
        }
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.b.put(str, str2);
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : this.b.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append(C3040d4.i.b);
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.b.entrySet()) {
                jSONObject.put(URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, com.mbridge.msdk.foundation.same.net.model.a> entry2 : this.f4304a.entrySet()) {
                jSONObject.put(URLEncoder.encode(entry2.getKey(), "UTF-8"), URLEncoder.encode("FILE_NAME_" + entry2.getValue().a().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException unused) {
        } catch (JSONException e2) {
            p0.b(c, e2.getMessage());
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(28);
        try {
            for (Map.Entry<String, String> entry : this.b.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append(D5.T);
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, com.mbridge.msdk.foundation.same.net.model.a> entry2 : this.f4304a.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(URLEncoder.encode(entry2.getKey(), "UTF-8"));
                sb.append(D5.T);
                sb.append(URLEncoder.encode("FILE_NAME_" + entry2.getValue().a().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e2) {
            p0.b(c, e2.getMessage());
        }
        return sb.toString();
    }

    public Map<String, String> a() {
        return this.b;
    }

    public void a(String str) {
        this.b.remove(str);
        this.f4304a.remove(str);
    }
}
