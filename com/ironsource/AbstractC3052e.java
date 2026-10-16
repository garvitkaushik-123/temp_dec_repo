package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.e, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
abstract class AbstractC3052e {

    /* renamed from: a, reason: collision with root package name */
    private final String f3260a = "eventId";
    private final String b = "timestamp";
    private final String c = "InterstitialEvents";
    private final String d = "events";
    private final String e = "events";
    JSONObject f;
    int g;
    private String h;

    AbstractC3052e() {
    }

    private String a(int i) {
        return i != 2 ? "events" : "InterstitialEvents";
    }

    protected abstract String a();

    public abstract String a(ArrayList<C3413z5> arrayList, JSONObject jSONObject);

    String b() {
        return TextUtils.isEmpty(this.h) ? a() : this.h;
    }

    public abstract String c();

    JSONObject a(C3413z5 c3413z5) {
        JSONObject jSONObject;
        try {
            String a2 = c3413z5.a();
            if (!TextUtils.isEmpty(a2)) {
                jSONObject = new JSONObject(a2);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put("eventId", c3413z5.c());
            jSONObject.put("timestamp", c3413z5.d());
            return jSONObject;
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return null;
        }
    }

    String a(JSONArray jSONArray) {
        try {
            if (this.f == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(this.f.toString());
            jSONObject.put("timestamp", IronSourceUtils.getTimestamp());
            jSONObject.put(a(this.g), jSONArray);
            return jSONObject.toString();
        } catch (Exception e) {
            C3260q4.d().a(e);
            return "";
        }
    }

    void a(String str) {
        this.h = str;
    }
}
