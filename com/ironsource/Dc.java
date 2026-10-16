package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Dc {

    /* renamed from: a, reason: collision with root package name */
    private final D0 f2831a;

    public Dc(D0 eventsWrapper) {
        Intrinsics.checkNotNullParameter(eventsWrapper, "eventsWrapper");
        this.f2831a = eventsWrapper;
    }

    public final void a() {
        this.f2831a.a(A0.OPERATIONAL_LOAD_AD, new HashMap());
    }

    public final void b() {
        this.f2831a.a(A0.PAUSE_AD, null);
    }

    public final void c() {
        this.f2831a.a(A0.RESUME_AD, null);
    }

    public final void a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        this.f2831a.a(A0.OPERATIONAL_LOAD_SUCCESS, hashMap);
    }

    public final void a(long j, int i, String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        hashMap.put("reason", reason);
        hashMap.put("duration", Long.valueOf(j));
        this.f2831a.a(A0.OPERATIONAL_LOAD_FAILED, hashMap);
    }

    public final void a(double d) {
        this.f2831a.a(A0.OPERATIONAL_SET_CONFIGURATIONS, MapsKt.mapOf(TuplesKt.to(IronSourceConstants.EVENTS_EXT1, "flooring=" + d)));
    }
}
