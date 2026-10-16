package com.inmobi.media;

import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class U0 {

    /* renamed from: a, reason: collision with root package name */
    public final S0 f2445a;
    public final Zd b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public final T0 j;

    public U0(S0 adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f2445a = adUnit;
        this.b = new Zd();
        this.j = new T0(this);
    }

    public final String a() {
        C2947y0 y;
        LinkedList<C2672h> f;
        C2672h c2672h;
        String w;
        S0 s0 = this.f2445a;
        return (s0 == null || (y = s0.y()) == null || (f = y.f()) == null || (c2672h = (C2672h) CollectionsKt.firstOrNull((List) f)) == null || (w = c2672h.w()) == null) ? "" : w;
    }
}
