package com.mbridge.msdk.videocommon.entity;

import org.json.JSONObject;

/* compiled from: AdParams.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f5284a;
    private String b;

    public a(String str, String str2) {
        this.f5284a = str;
        this.b = str2;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new a(jSONObject.optString("appId"), jSONObject.optString("placementId"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
