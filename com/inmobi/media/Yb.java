package com.inmobi.media;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Yb implements Ha {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetectorOnGestureListenerC2634ec f2497a;

    public Yb(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        this.f2497a = gestureDetectorOnGestureListenerC2634ec;
    }

    public final void a(String id, int i, String str, long j, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullExpressionValue(GestureDetectorOnGestureListenerC2634ec.a1, "access$getTAG$cp(...)");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", i);
        if (str != null) {
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
        }
        jSONObject.put("retryCount", i2);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        this.f2497a.c("window.imraidview.broadcastEvent('onPingComplete', '" + id + "', " + j + ", '" + jSONObject2 + "');");
    }
}
