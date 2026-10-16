package com.ironsource;

import com.ironsource.C3230o8;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class L9 {

    /* renamed from: a, reason: collision with root package name */
    static String f2941a = "ManRewInst_";

    public static String a(JSONObject jSONObject) {
        return jSONObject.optBoolean("rewarded") ? f2941a + jSONObject.optString("name") : jSONObject.optString("name");
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    public static String a() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String a(B9 b9) {
        if (b9.i()) {
            return C3230o8.e.Banner.toString();
        }
        if (b9.n()) {
            return C3230o8.e.RewardedVideo.toString();
        }
        return C3230o8.e.Interstitial.toString();
    }
}
