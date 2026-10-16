package com.inmobi.media;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2737l {
    public static String a(C2705j asset, File file, long j, long j2) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(file, "file");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", asset.b);
            jSONObject.put("saved_url", Uri.fromFile(file));
            jSONObject.put("size_in_bytes", file.length());
            jSONObject.put("download_started_at", j);
            jSONObject.put("download_ended_at", j2);
        } catch (JSONException e) {
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return StringsKt.replace$default(jSONObject2, "\"", "\\\"", false, 4, (Object) null);
    }
}
