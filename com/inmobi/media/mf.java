package com.inmobi.media;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class mf extends T5 {
    public final StackTraceElement[] g;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public mf(StackTraceElement[] stackTrace) {
        super("ANRWatchDog", "ANRWatchDogEvent", r0);
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        Intrinsics.checkNotNullParameter("Blocked", "name");
        Intrinsics.checkNotNullParameter("MainThreadBlocked", PglCryptUtils.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", "Blocked");
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, "MainThreadBlocked");
            jSONObject.put("stack", Ie.a(stackTrace));
        } catch (JSONException e) {
            e.toString();
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        this.g = stackTrace;
    }
}
