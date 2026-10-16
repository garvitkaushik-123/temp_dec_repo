package com.ironsource;

import com.ironsource.C3239p0;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC3340v0 f2783a;
    private final NetworkSettings b;
    private final C3156k2 c;
    private final C3000b1 d;
    private final C3207n2 e;
    private final int f;
    private final H g;
    private final IronSource.AD_UNIT h;
    private final JSONObject i;
    private final String j;
    private final int k;
    private final String l;
    private final C3207n2 m;
    private final String n;
    private final String o;
    private final int p;
    private final AdData q;

    public A(AbstractC3340v0 adUnitData, NetworkSettings providerSettings, C3156k2 auctionData, C3000b1 adapterConfig, C3207n2 auctionResponseItem, int i) {
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        Intrinsics.checkNotNullParameter(auctionData, "auctionData");
        Intrinsics.checkNotNullParameter(adapterConfig, "adapterConfig");
        Intrinsics.checkNotNullParameter(auctionResponseItem, "auctionResponseItem");
        this.f2783a = adUnitData;
        this.b = providerSettings;
        this.c = auctionData;
        this.d = adapterConfig;
        this.e = auctionResponseItem;
        this.f = i;
        this.g = new H(C3239p0.a.DidntAttemptToLoad);
        IronSource.AD_UNIT a2 = adUnitData.b().a();
        this.h = a2;
        this.i = auctionData.h();
        this.j = auctionData.g();
        this.k = auctionData.i();
        this.l = auctionData.f();
        this.m = auctionData.j();
        String f = adapterConfig.f();
        Intrinsics.checkNotNullExpressionValue(f, "adapterConfig.providerName");
        this.n = f;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s %s", Arrays.copyOf(new Object[]{f, Integer.valueOf(hashCode())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        this.o = format;
        this.p = adapterConfig.d();
        String k = auctionResponseItem.k();
        Map<String, Object> a3 = V9.a(auctionResponseItem.a());
        Intrinsics.checkNotNullExpressionValue(a3, "jsonObjectToMap(auctionResponseItem.adData)");
        a3.put("adUnit", a2);
        HashMap hashMap = new HashMap();
        Map<String, Object> a4 = V9.a(adapterConfig.c());
        Intrinsics.checkNotNullExpressionValue(a4, "jsonObjectToMap(adapterConfig.adUnitSettings)");
        hashMap.putAll(a4);
        a3.put("userId", adUnitData.r());
        a3.put("adUnitId", adUnitData.b().c());
        a3.put("isMultipleAdUnits", Boolean.TRUE);
        this.q = new AdData(k, hashMap, a3);
    }

    public final AbstractC3340v0 a() {
        return this.f2783a;
    }

    public final NetworkSettings b() {
        return this.b;
    }

    public final C3156k2 c() {
        return this.c;
    }

    public final C3000b1 d() {
        return this.d;
    }

    public final C3207n2 e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A)) {
            return false;
        }
        A a2 = (A) obj;
        return Intrinsics.areEqual(this.f2783a, a2.f2783a) && Intrinsics.areEqual(this.b, a2.b) && Intrinsics.areEqual(this.c, a2.c) && Intrinsics.areEqual(this.d, a2.d) && Intrinsics.areEqual(this.e, a2.e) && this.f == a2.f;
    }

    public final int f() {
        return this.f;
    }

    public final AdData g() {
        return this.q;
    }

    public final IronSource.AD_UNIT h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((this.f2783a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Integer.hashCode(this.f);
    }

    public final AbstractC3340v0 i() {
        return this.f2783a;
    }

    public final C3000b1 j() {
        return this.d;
    }

    public final C3156k2 k() {
        return this.c;
    }

    public final String l() {
        return this.l;
    }

    public final String m() {
        return this.j;
    }

    public final C3207n2 n() {
        return this.e;
    }

    public final int o() {
        return this.k;
    }

    public final C3207n2 p() {
        return this.m;
    }

    public final JSONObject q() {
        return this.i;
    }

    public final String r() {
        return this.n;
    }

    public final int s() {
        return this.p;
    }

    public final H t() {
        return this.g;
    }

    public String toString() {
        return "AdInstanceData(adUnitData=" + this.f2783a + ", providerSettings=" + this.b + ", auctionData=" + this.c + ", adapterConfig=" + this.d + ", auctionResponseItem=" + this.e + ", sessionDepth=" + this.f + ")";
    }

    public final NetworkSettings u() {
        return this.b;
    }

    public final int v() {
        return this.f;
    }

    public final String w() {
        return this.o;
    }

    public final A a(AbstractC3340v0 adUnitData, NetworkSettings providerSettings, C3156k2 auctionData, C3000b1 adapterConfig, C3207n2 auctionResponseItem, int i) {
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        Intrinsics.checkNotNullParameter(auctionData, "auctionData");
        Intrinsics.checkNotNullParameter(adapterConfig, "adapterConfig");
        Intrinsics.checkNotNullParameter(auctionResponseItem, "auctionResponseItem");
        return new A(adUnitData, providerSettings, auctionData, adapterConfig, auctionResponseItem, i);
    }

    public static /* synthetic */ A a(A a2, AbstractC3340v0 abstractC3340v0, NetworkSettings networkSettings, C3156k2 c3156k2, C3000b1 c3000b1, C3207n2 c3207n2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            abstractC3340v0 = a2.f2783a;
        }
        if ((i2 & 2) != 0) {
            networkSettings = a2.b;
        }
        if ((i2 & 4) != 0) {
            c3156k2 = a2.c;
        }
        if ((i2 & 8) != 0) {
            c3000b1 = a2.d;
        }
        if ((i2 & 16) != 0) {
            c3207n2 = a2.e;
        }
        if ((i2 & 32) != 0) {
            i = a2.f;
        }
        C3207n2 c3207n22 = c3207n2;
        int i3 = i;
        return a2.a(abstractC3340v0, networkSettings, c3156k2, c3000b1, c3207n22, i3);
    }

    public final void a(C3239p0.a performance) {
        Intrinsics.checkNotNullParameter(performance, "performance");
        this.g.b(performance);
    }
}
