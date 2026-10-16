package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ad, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2567ad {
    public static JSONObject a(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(str3, str4);
        return jSONObject;
    }
}
