package com.inmobi.media;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.d1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2606d1 extends T5 {
    public final int g;
    public final String h;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2606d1(String str, int i, String trace) {
        super("AppExitReasonReporting", "AppExitReasonEvent", r5);
        Intrinsics.checkNotNullParameter(trace, "trace");
        String message = "reason - " + i + " description - " + (str == null ? "ApplicationExit" : str);
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        Intrinsics.checkNotNullParameter("AppExitEvent", "name");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(trace, "trace");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", "AppExitEvent");
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, message);
            jSONObject.put("stack", trace);
        } catch (JSONException e) {
            e.toString();
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        this.g = i;
        this.h = trace;
    }
}
