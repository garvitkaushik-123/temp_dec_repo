package com.inmobi.media;

import com.adjust.sdk.Constants;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.TelemetryConfig;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Ma {

    /* renamed from: a, reason: collision with root package name */
    public final Pa f2362a;
    public final ConcurrentHashMap b;
    public final AdConfig.PingsV2Config c;
    public final Ka d;

    public Ma(Pa dao) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        this.f2362a = dao;
        this.b = new ConcurrentHashMap();
        LinkedHashMap linkedHashMap = O2.f2380a;
        AdConfig.PingsV2Config pingV2 = ((AdConfig) AbstractC2808p5.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null)).getPingV2();
        this.c = pingV2;
        this.d = new Ka(pingV2);
    }

    public static void a(C2976za c2976za, short s) {
        Unit unit;
        C2685hc c2685hc = c2976za.k;
        if (c2685hc != null) {
            C2782nc c2782nc = new C2782nc(c2685hc);
            String priority = c2976za.e;
            int i = c2976za.g;
            Intrinsics.checkNotNullParameter(priority, "priority");
            Map a2 = c2782nc.a();
            a2.put(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(s));
            a2.put("trigger", priority);
            a2.put("retryCount", String.valueOf(i));
            Oa.a("PingFailed", a2);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            TelemetryConfig telemetryConfig = Oa.f2385a;
            Oa.a("PingFailed", MapsKt.mutableMapOf(TuplesKt.to("trigger", c2976za.e), TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(s)), TuplesKt.to("retryCount", Integer.valueOf(c2976za.g))));
        }
    }

    public abstract void a(C2976za c2976za);

    public final void b(final C2976za ping) {
        Intrinsics.checkNotNullParameter(ping, "ping");
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue()).execute(new Runnable() { // from class: com.inmobi.media.Ma$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Ma.a(Ma.this, ping);
            }
        });
    }

    public final void b(Da pingResult, La la) {
        Unit unit;
        Intrinsics.checkNotNullParameter(pingResult, "pingResult");
        Intrinsics.checkNotNullExpressionValue("Ma", "getSimpleName(...)");
        String str = pingResult.f2264a.f2774a;
        Objects.toString(la);
        Unit unit2 = null;
        if (la != null) {
            C2976za ping = pingResult.f2264a;
            int i = pingResult.b;
            long j = pingResult.d;
            Ia ia = (Ia) la;
            Intrinsics.checkNotNullParameter(ping, "ping");
            if (!ia.d.get()) {
                String str2 = ping.f2774a;
                if (Intrinsics.areEqual(Constants.HIGH, ping.e) && ping.f) {
                    String str3 = ping.b;
                    Ha ha = ia.f2316a;
                    if (ha != null) {
                        ((Yb) ha).a(str3, i, null, j, ping.g);
                    }
                }
                String priority = ping.e;
                long currentTimeMillis = System.currentTimeMillis() - ping.i;
                C2782nc c2782nc = ia.b;
                if (c2782nc != null) {
                    Intrinsics.checkNotNullParameter(priority, "priority");
                    Map a2 = c2782nc.a();
                    a2.put("trigger", priority);
                    a2.put("latency", Long.valueOf(currentTimeMillis));
                    Oa.a("PingSuccess", a2);
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            C2976za c2976za = pingResult.f2264a;
            C2685hc c2685hc = c2976za.k;
            if (c2685hc != null) {
                C2782nc c2782nc2 = new C2782nc(c2685hc);
                String priority2 = c2976za.e;
                long j2 = c2976za.i;
                Intrinsics.checkNotNullParameter(priority2, "priority");
                Map a3 = c2782nc2.a();
                a3.put("trigger", priority2);
                a3.put("latency", Long.valueOf(j2));
                Oa.a("PingSuccess", a3);
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                TelemetryConfig telemetryConfig = Oa.f2385a;
                Oa.a("PingSuccess", MapsKt.mutableMapOf(TuplesKt.to("trigger", c2976za.e), TuplesKt.to("retryCount", Integer.valueOf(c2976za.g))));
            }
        }
        Pa pa = this.f2362a;
        C2976za ping2 = pingResult.f2264a;
        Intrinsics.checkNotNullParameter(ping2, "ping");
        pa.a("id = ?", new String[]{ping2.b});
    }

    public final boolean a(String priority) {
        C2976za a2;
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (T1.a(this.f2362a, null, null, 63) < this.c.getMaxEntries()) {
            return true;
        }
        TelemetryConfig telemetryConfig = Oa.f2385a;
        Oa.a("PingDBMaxLimitReached", new LinkedHashMap());
        if (Intrinsics.areEqual(priority, Constants.HIGH)) {
            a2 = this.f2362a.a(Constants.NORMAL);
            if (a2 == null) {
                a2 = this.f2362a.a(Constants.HIGH);
            }
        } else {
            a2 = this.f2362a.a(Constants.NORMAL);
        }
        if (a2 == null) {
            return false;
        }
        a(a2, Intrinsics.areEqual(priority, Constants.HIGH) ? (short) 2259 : (short) 2260);
        return true;
    }

    public final void a(Da pingResult, La la) {
        int maxRetries;
        Pair pair;
        Intrinsics.checkNotNullParameter(pingResult, "pingResult");
        C2976za ping = pingResult.f2264a;
        String str = ping.f2774a;
        int i = pingResult.b;
        C2726k4 c2726k4 = EnumC2758m4.b;
        if (i != -22) {
            C2742l4 c2742l4 = EnumC2790o4.b;
            if (i != -22) {
                int i2 = ping.g + 1;
                if (Intrinsics.areEqual(ping.e, Constants.HIGH)) {
                    maxRetries = this.c.getRetryConfig().getHigh().getMaxRetries();
                } else {
                    maxRetries = this.c.getRetryConfig().getNormal().getMaxRetries();
                }
                if (i2 > maxRetries) {
                    Pa pa = this.f2362a;
                    Intrinsics.checkNotNullParameter(ping, "ping");
                    pa.a("id = ?", new String[]{ping.b});
                    a(pingResult.b, pingResult.c, (short) 2249, ping, pingResult.d, la);
                    return;
                }
                if (Intrinsics.areEqual(ping.e, Constants.HIGH)) {
                    pair = new Pair(Long.valueOf(this.c.getRetryConfig().getHigh().getRetryInterval()), Double.valueOf(this.c.getRetryConfig().getHigh().getFactor()));
                } else {
                    pair = new Pair(Long.valueOf(this.c.getRetryConfig().getNormal().getRetryInterval()), Double.valueOf(this.c.getRetryConfig().getNormal().getFactor()));
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() + ((long) (Math.pow(((Number) pair.component2()).doubleValue(), i2) * ((Number) pair.component1()).longValue() * 1000)));
                String url = ping.f2774a;
                String id = ping.b;
                Map headers = ping.c;
                boolean z = ping.d;
                String priority = ping.e;
                boolean z2 = ping.f;
                String ownerId = ping.h;
                long j = ping.i;
                C2685hc c2685hc = ping.k;
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(headers, "headers");
                Intrinsics.checkNotNullParameter(priority, "priority");
                Intrinsics.checkNotNullParameter(ownerId, "ownerId");
                C2976za ping2 = new C2976za(url, id, headers, z, priority, z2, i2, ownerId, j, valueOf, c2685hc);
                Pa pa2 = this.f2362a;
                Intrinsics.checkNotNullParameter(ping2, "ping");
                pa2.b(ping2, "id = ?", new String[]{id});
                a(pingResult.b, pingResult.c, (short) 2247, ping, pingResult.d, la);
                return;
            }
        }
        Pa pa3 = this.f2362a;
        Intrinsics.checkNotNullParameter(ping, "ping");
        pa3.a("id = ?", new String[]{ping.b});
        a(pingResult.b, "Redirect URL is malformed", (short) 2258, pingResult.f2264a, pingResult.d, la);
    }

    public static void a(int i, String str, short s, C2976za ping, long j, La la) {
        Unit unit;
        int i2;
        Intrinsics.checkNotNullParameter(ping, "ping");
        Intrinsics.checkNotNullExpressionValue("Ma", "getSimpleName(...)");
        String str2 = ping.f2774a;
        Intrinsics.checkNotNullExpressionValue("Ma", "getSimpleName(...)");
        Objects.toString(la);
        int i3 = ping.g;
        if (la != null) {
            Ia ia = (Ia) la;
            Intrinsics.checkNotNullParameter(ping, "ping");
            if (!ia.d.get()) {
                if (Intrinsics.areEqual(Constants.HIGH, ping.e) && ping.f && (i2 = ping.g) < 1) {
                    String str3 = ping.b;
                    Ha ha = ia.f2316a;
                    if (ha != null) {
                        ((Yb) ha).a(str3, i, str, j, i2);
                    }
                }
                String priority = ping.e;
                C2782nc c2782nc = ia.b;
                if (c2782nc != null) {
                    if (priority == null) {
                        priority = "unknown";
                    }
                    Intrinsics.checkNotNullParameter(priority, "priority");
                    Map a2 = c2782nc.a();
                    a2.put(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2247);
                    a2.put("trigger", priority);
                    a2.put("retryCount", String.valueOf(i3));
                    Oa.a("PingFailed", a2);
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            a(ping, s);
        }
    }

    public static final void a(Ma this$0, C2976za ping) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ping, "$ping");
        this$0.a(ping);
    }
}
