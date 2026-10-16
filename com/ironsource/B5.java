package com.ironsource;

import com.ironsource.D0;
import com.ironsource.mediationsdk.IronSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class B5 implements C0 {

    /* renamed from: a, reason: collision with root package name */
    private final IronSource.AD_UNIT f2800a;
    private final D0 b;
    private final List<C0> c;
    private final U8 d;
    private final C3115hb e;
    private final Hf f;
    private final R1 g;
    private final M h;
    private final Mf i;
    private final Dc j;

    public B5(IronSource.AD_UNIT adFormat, D0.b level, List<? extends C0> eventsInterfaces, AbstractC3326u3 abstractC3326u3) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(eventsInterfaces, "eventsInterfaces");
        this.f2800a = adFormat;
        D0 d0 = new D0(adFormat, level, this, abstractC3326u3);
        this.b = d0;
        this.c = CollectionsKt.toMutableList((Collection) eventsInterfaces);
        U8 u8 = d0.e;
        Intrinsics.checkNotNullExpressionValue(u8, "wrapper.init");
        this.d = u8;
        C3115hb c3115hb = d0.f;
        Intrinsics.checkNotNullExpressionValue(c3115hb, "wrapper.load");
        this.e = c3115hb;
        Hf hf = d0.g;
        Intrinsics.checkNotNullExpressionValue(hf, "wrapper.token");
        this.f = hf;
        R1 r1 = d0.h;
        Intrinsics.checkNotNullExpressionValue(r1, "wrapper.auction");
        this.g = r1;
        M m = d0.i;
        Intrinsics.checkNotNullExpressionValue(m, "wrapper.adInteraction");
        this.h = m;
        Mf mf = d0.j;
        Intrinsics.checkNotNullExpressionValue(mf, "wrapper.troubleshoot");
        this.i = mf;
        Dc dc = d0.k;
        Intrinsics.checkNotNullExpressionValue(dc, "wrapper.operational");
        this.j = dc;
    }

    public final M a() {
        return this.h;
    }

    public final R1 b() {
        return this.g;
    }

    public final List<C0> c() {
        return this.c;
    }

    public final U8 d() {
        return this.d;
    }

    public final C3115hb e() {
        return this.e;
    }

    public final Dc f() {
        return this.j;
    }

    public final Hf g() {
        return this.f;
    }

    public final Mf h() {
        return this.i;
    }

    @Override // com.ironsource.C0
    public Map<String, Object> a(A0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        HashMap hashMap = new HashMap();
        Iterator<C0> it = this.c.iterator();
        while (it.hasNext()) {
            Map<String, Object> a2 = it.next().a(event);
            Intrinsics.checkNotNullExpressionValue(a2, "it.getEventsAdditionalDataMap(event)");
            hashMap.putAll(a2);
        }
        return hashMap;
    }

    public /* synthetic */ B5(IronSource.AD_UNIT ad_unit, D0.b bVar, List list, AbstractC3326u3 abstractC3326u3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ad_unit, bVar, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : abstractC3326u3);
    }

    public final void a(C0 eventInterface) {
        Intrinsics.checkNotNullParameter(eventInterface, "eventInterface");
        this.c.add(eventInterface);
    }

    public final void a(boolean z) {
        if (z) {
            this.e.a(true);
        } else {
            if (z) {
                throw new NoWhenBranchMatchedException();
            }
            if (this.f2800a == IronSource.AD_UNIT.BANNER) {
                this.e.a();
            } else {
                this.e.a(false);
            }
        }
    }
}
