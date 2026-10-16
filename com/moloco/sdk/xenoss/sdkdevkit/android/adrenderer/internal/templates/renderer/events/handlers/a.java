package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers;

import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class a implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public final MetricsRecorder f5975a;

    public a(MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5975a = metricsRecorder;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public Set<String> a() {
        return SetsKt.setOf("metric");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public String b() {
        return "ACMHandler";
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public void a(JSONObject event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String string = event.getString("event");
        String string2 = event.getString("metricName");
        String string3 = event.getString("type");
        JSONObject optJSONObject = event.optJSONObject("tags");
        String string4 = event.getString("value");
        if (Intrinsics.areEqual(string3, "counter")) {
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, b(), "Count metric recorded: " + string2 + " = " + string4, false, 4, null);
            Intrinsics.checkNotNull(string2);
            CountEvent countEvent = new CountEvent(string2);
            Intrinsics.checkNotNull(string4);
            countEvent.withCount(Integer.parseInt(string4));
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
                while (keys.hasNext()) {
                    String next = keys.next();
                    Intrinsics.checkNotNull(next);
                    String string5 = optJSONObject.getString(next);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    countEvent = countEvent.withTag(next, string5);
                }
            }
            this.f5975a.recordCountEvent(countEvent);
            return;
        }
        if (!Intrinsics.areEqual(string3, "timer")) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, b(), "Unknown event type: " + string, null, false, 12, null);
            return;
        }
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, b(), "Timer metric recorded: " + string2 + " = " + string4, false, 4, null);
        TimerEvent.Companion companion = TimerEvent.INSTANCE;
        Intrinsics.checkNotNull(string2);
        TimerEvent create = companion.create(string2);
        Intrinsics.checkNotNull(string4);
        create.withTime(Long.parseLong(string4));
        if (optJSONObject != null) {
            Iterator<String> keys2 = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys2, "keys(...)");
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                Intrinsics.checkNotNull(next2);
                String string6 = optJSONObject.getString(next2);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                create = create.withTag(next2, string6);
            }
        }
        this.f5975a.recordTimerEvent(create);
    }
}
