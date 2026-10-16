package com.mbridge.msdk.videocommon.entity;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdUnitInfo.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f5285a;
    private int b;
    private a c;

    public b(int i, int i2, a aVar) {
        this.f5285a = i;
        this.b = i2;
        this.c = aVar;
    }

    public int a() {
        return this.f5285a;
    }

    public int b() {
        return this.b;
    }

    public static List<b> a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    int optInt = optJSONObject.optInt("id");
                    int optInt2 = optJSONObject.optInt("timeout");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("params");
                    arrayList.add(new b(optInt, optInt2, optJSONObject2 != null ? a.a(optJSONObject2) : null));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        }
        return null;
    }
}
