package com.mbridge.msdk.videocommon.entity;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Reward.java */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f5286a;
    private int b;

    public c(String str, int i) {
        this.f5286a = str;
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    public void b(String str) {
        this.f5286a = str;
    }

    public String c() {
        return this.f5286a;
    }

    public String toString() {
        return "Reward{name='" + this.f5286a + "', amount=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public static c b() {
        return new c("Virtual Item", 1);
    }

    public void a(int i) {
        this.b = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a A[Catch: Exception -> 0x0030, TRY_LEAVE, TryCatch #0 {Exception -> 0x0030, blocks: (B:3:0x0001, B:5:0x000f, B:8:0x002a, B:14:0x0017, B:16:0x001d), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(String str) {
        c cVar;
        c cVar2 = null;
        try {
            com.mbridge.msdk.videocommon.setting.a c = com.mbridge.msdk.videocommon.setting.b.b().c();
            if (TextUtils.isEmpty(str)) {
                cVar = b();
            } else {
                if (c != null && c.g() != null) {
                    cVar = c.g().get(str);
                }
                return cVar2 != null ? b() : cVar2;
            }
            cVar2 = cVar;
            if (cVar2 != null) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return cVar2;
        }
    }

    public static Map<String, c> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                hashMap.put(optJSONObject.optString("id"), new c(optJSONObject.optString("name"), optJSONObject.optInt("amount")));
            }
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("name");
            int optInt = jSONObject.optInt("amount");
            jSONObject.optString("id");
            return new c(optString, optInt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
