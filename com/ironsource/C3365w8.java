package com.ironsource;

import android.content.Context;
import android.util.Pair;
import com.ironsource.C3230o8;
import com.ironsource.C3314t8;
import com.ironsource.F5;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.ironsource.w8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3365w8 {
    public static C3314t8 a(Context context, String str, String str2, Map<String, String> map) throws Exception {
        C3314t8.a aVar = new C3314t8.a();
        if (map != null && map.containsKey("sessionid")) {
            aVar.c(map.get("sessionid"));
        }
        aVar.a(context);
        return aVar.d(str).a(str2).a();
    }

    public static F5 a(JSONObject jSONObject) {
        return new F5.a(jSONObject.optString(D5.r)).b().b(jSONObject.optBoolean("enabled")).a(new C3331u8()).a(a()).a(false).a();
    }

    private static ArrayList<Pair<String, String>> a() {
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<>("Content-Type", D5.L));
        arrayList.add(new Pair<>("charset", D5.N));
        return arrayList;
    }

    public static boolean a(V4 v4) {
        if (v4 == null || v4.g().get("inAppBidding") == null) {
            return false;
        }
        return Boolean.parseBoolean(v4.g().get("inAppBidding"));
    }

    public static C3230o8.e a(V4 v4, C3230o8.e eVar) {
        if (v4 == null || v4.g() == null || v4.g().get("rewarded") == null) {
            return eVar;
        }
        if (Boolean.parseBoolean(v4.g().get("rewarded"))) {
            return C3230o8.e.RewardedVideo;
        }
        return C3230o8.e.Interstitial;
    }
}
