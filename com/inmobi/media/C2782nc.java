package com.inmobi.media;

import android.os.SystemClock;
import com.inmobi.commons.core.configs.TelemetryConfig;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.nc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2782nc {

    /* renamed from: a, reason: collision with root package name */
    public final C2685hc f2652a;
    public long b;
    public long c;
    public int d;
    public int e;
    public final AtomicInteger f;
    public final AtomicBoolean g;
    public long h;

    public C2782nc(C2685hc renderViewMetaData) {
        Intrinsics.checkNotNullParameter(renderViewMetaData, "renderViewMetaData");
        this.f2652a = renderViewMetaData;
        LinkedHashMap linkedHashMap = O2.f2380a;
        TelemetryConfig telemetryConfig = (TelemetryConfig) AbstractC2808p5.a("telemetry", "null cannot be cast to non-null type com.inmobi.commons.core.configs.TelemetryConfig", null);
        C2766mc c2766mc = renderViewMetaData.j;
        this.f = new AtomicInteger(c2766mc != null ? c2766mc.f2642a : telemetryConfig.getMaxTemplateEvents());
        this.g = new AtomicBoolean(false);
    }

    public final Map a() {
        String str = this.f2652a.k;
        if (str == null) {
            str = "";
        }
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("trigger", str), TuplesKt.to("plType", String.valueOf(this.f2652a.f2589a.m())), TuplesKt.to("plId", String.valueOf(this.f2652a.f2589a.l())), TuplesKt.to("adType", String.valueOf(this.f2652a.f2589a.b())), TuplesKt.to("markupType", this.f2652a.b), TuplesKt.to("networkType", L3.q()), TuplesKt.to("retryCount", String.valueOf(this.f2652a.d)), TuplesKt.to("creativeType", this.f2652a.e), TuplesKt.to("adPosition", String.valueOf(this.f2652a.h)), TuplesKt.to("isRewarded", String.valueOf(this.f2652a.g)));
        if (this.f2652a.c.length() > 0) {
            mutableMapOf.put("metadataBlob", this.f2652a.c);
        }
        return mutableMapOf;
    }

    public final void b() {
        String a2 = a("WebViewLoadCalled");
        this.c = SystemClock.elapsedRealtime();
        Map a3 = a();
        if (Intrinsics.areEqual(a2, "CompanionWebViewLoadCalled")) {
            long j = this.b;
            ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
            a3.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        } else {
            T0 t0 = this.f2652a.i;
            if (t0 != null) {
                long j2 = t0.f2432a.c;
                ScheduledExecutorService scheduledExecutorService2 = Ie.f2319a;
                a3.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j2));
            }
        }
        a3.put("creativeId", this.f2652a.f);
        Pd pd = Pd.f2401a;
        Pd.b(a2, a3, Td.f2443a);
    }

    public final String a(String str) {
        if (Intrinsics.areEqual(this.f2652a.k, EventTaskParams.STATE_GROUP_DEFAULT)) {
            return str;
        }
        switch (str.hashCode()) {
            case -1395724590:
                return !str.equals("PageStarted") ? str : "CompanionWebViewPageStarted";
            case -81019210:
                return !str.equals("FireAdFailed") ? str : "CompanionFireAdFailed";
            case 147127306:
                return !str.equals("FireAdReady") ? str : "CompanionFireAdReady";
            case 260281564:
                return !str.equals("WebViewLoadCalled") ? str : "CompanionWebViewLoadCalled";
            case 520950289:
                return !str.equals("WebViewLoadFinished") ? str : "CompanionWebViewLoadFinished";
            case 570988141:
                return !str.equals("RenderProcessResponsive") ? str : "RenderProcessResponsive";
            case 1001819046:
                return !str.equals("RenderProcessUnResponsive") ? str : "CompanionRenderProcessUnResponsive";
            default:
                return str;
        }
    }
}
