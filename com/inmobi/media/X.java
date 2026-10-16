package com.inmobi.media;

import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    private final String f2474a;
    private long b;
    private Map<String, String> c;
    private String d;
    private String e;
    private final String f;
    private String g;
    private boolean h;
    private String i;
    private String j;

    public X(String mAdType) {
        Intrinsics.checkNotNullParameter(mAdType, "mAdType");
        this.f2474a = mAdType;
        this.b = Long.MIN_VALUE;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.f = uuid;
        this.g = "";
        this.i = "activity";
    }

    private static /* synthetic */ void b() {
    }

    private static /* synthetic */ void c() {
    }

    public final X a(long j) {
        this.b = j;
        return this;
    }

    public final X d(String m10Context) {
        Intrinsics.checkNotNullParameter(m10Context, "m10Context");
        this.i = m10Context;
        return this;
    }

    public final X e(String str) {
        this.e = str;
        return this;
    }

    public final X a(Z placement) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.b = placement.g();
        this.i = placement.j();
        this.c = placement.f();
        this.g = placement.a();
        return this;
    }

    public final X b(String str) {
        this.j = str;
        return this;
    }

    public final X c(String str) {
        this.d = str;
        return this;
    }

    public final X a(String adSize) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        this.g = adSize;
        return this;
    }

    public final X a(Map<String, String> map) {
        this.c = map;
        return this;
    }

    public final X a(boolean z) {
        this.h = z;
        return this;
    }

    public final Z a() throws IllegalStateException {
        String str;
        long j = this.b;
        if (j != Long.MIN_VALUE) {
            Map<String, String> map = this.c;
            if (map == null || (str = map.get("tp")) == null) {
                str = "";
            }
            Z z = new Z(j, str, this.f2474a, this.e, null);
            z.d = this.d;
            z.a(this.c);
            z.a(this.g);
            z.b(this.i);
            z.g = this.f;
            z.j = this.h;
            z.k = this.j;
            return z;
        }
        throw new IllegalStateException("When the integration type is IM, IM-Plc can't be empty");
    }
}
