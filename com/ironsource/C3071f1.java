package com.ironsource;

import java.util.Calendar;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.f1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3071f1 {

    /* renamed from: a, reason: collision with root package name */
    private final Le f3290a;
    private final S7 b;
    private final String c;
    private final long d;

    public C3071f1(Le recordType, S7 adProvider, String adInstanceId) {
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(adProvider, "adProvider");
        Intrinsics.checkNotNullParameter(adInstanceId, "adInstanceId");
        this.f3290a = recordType;
        this.b = adProvider;
        this.c = adInstanceId;
        this.d = Calendar.getInstance().getTimeInMillis() / 1000;
    }

    public final String a() {
        return this.c;
    }

    public final S7 b() {
        return this.b;
    }

    public final Map<String, Object> c() {
        return MapsKt.mapOf(TuplesKt.to(C3114ha.c, Integer.valueOf(this.b.b())), TuplesKt.to("ts", String.valueOf(this.d)));
    }

    public final Map<String, Object> d() {
        return MapsKt.mapOf(TuplesKt.to(C3114ha.b, this.c), TuplesKt.to(C3114ha.c, Integer.valueOf(this.b.b())), TuplesKt.to("ts", String.valueOf(this.d)), TuplesKt.to("rt", Integer.valueOf(this.f3290a.ordinal())));
    }

    public final Le e() {
        return this.f3290a;
    }

    public final long f() {
        return this.d;
    }
}
