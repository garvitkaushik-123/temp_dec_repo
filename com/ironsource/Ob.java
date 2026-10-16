package com.ironsource;

import com.ironsource.AbstractC3340v0;
import com.ironsource.N0;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Ob extends AbstractC3340v0 {
    public static final a y = new a(null);
    private final C3070f0 t;
    private final C3323u0 u;
    private final C3419zb v;
    private final String w;
    private final String x;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Ob a(C3070f0 adProperties, La la) {
            List<C3116hc> emptyList;
            C3337ue d;
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            AbstractC3340v0.a aVar = AbstractC3340v0.r;
            U3 c = (la == null || (d = la.d()) == null) ? null : d.c();
            C3419zb e = c != null ? c.e() : null;
            if (e == null) {
                throw new IllegalStateException("Error getting " + adProperties.a() + " configurations");
            }
            if (la == null || (emptyList = la.d(adProperties.e(), adProperties.c())) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            String userIdForNetworks = IronSourceUtils.getUserIdForNetworks();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(emptyList, 10));
            Iterator<T> it = emptyList.iterator();
            while (it.hasNext()) {
                arrayList.add(((C3116hc) it.next()).f());
            }
            Z9 b = Z9.b();
            Intrinsics.checkNotNullExpressionValue(b, "getInstance()");
            return new Ob(adProperties, new C3323u0(userIdForNetworks, arrayList, b), e);
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ob(C3070f0 adProperties, C3323u0 adUnitCommonData, C3419zb configs) {
        super(adProperties, true, adUnitCommonData.f(), adUnitCommonData.d(), adUnitCommonData.e(), configs.d(), configs.b(), (int) (configs.c() / 1000), configs.a(), configs.f(), -1, new N0(N0.a.MANUAL, configs.d().j(), configs.d().b(), -1L), configs.h(), configs.i(), configs.k(), configs.j(), false, 65536, null);
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        this.t = adProperties;
        this.u = adUnitCommonData;
        this.v = configs;
        this.w = "NA";
        this.x = Ma.e;
    }

    public final C3419zb A() {
        return this.v;
    }

    public final Ob a(C3070f0 adProperties, C3323u0 adUnitCommonData, C3419zb configs) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new Ob(adProperties, adUnitCommonData, configs);
    }

    @Override // com.ironsource.AbstractC3340v0
    public C3070f0 b() {
        return this.t;
    }

    @Override // com.ironsource.AbstractC3340v0
    public String c() {
        return this.w;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ob)) {
            return false;
        }
        Ob ob = (Ob) obj;
        return Intrinsics.areEqual(this.t, ob.t) && Intrinsics.areEqual(this.u, ob.u) && Intrinsics.areEqual(this.v, ob.v);
    }

    public int hashCode() {
        return (((this.t.hashCode() * 31) + this.u.hashCode()) * 31) + this.v.hashCode();
    }

    @Override // com.ironsource.AbstractC3340v0
    public String j() {
        return this.x;
    }

    public String toString() {
        return "NativeAdUnitData(adProperties=" + this.t + ", adUnitCommonData=" + this.u + ", configs=" + this.v + ")";
    }

    public final C3070f0 w() {
        return this.t;
    }

    public final C3323u0 x() {
        return this.u;
    }

    public final C3419zb y() {
        return this.v;
    }

    public final C3323u0 z() {
        return this.u;
    }

    public static /* synthetic */ Ob a(Ob ob, C3070f0 c3070f0, C3323u0 c3323u0, C3419zb c3419zb, int i, Object obj) {
        if ((i & 1) != 0) {
            c3070f0 = ob.t;
        }
        if ((i & 2) != 0) {
            c3323u0 = ob.u;
        }
        if ((i & 4) != 0) {
            c3419zb = ob.v;
        }
        return ob.a(c3070f0, c3323u0, c3419zb);
    }

    @Override // com.ironsource.AbstractC3340v0
    public JSONObject b(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        JSONObject nativeAdSettings = providerSettings.getNativeAdSettings();
        Intrinsics.checkNotNullExpressionValue(nativeAdSettings, "providerSettings.nativeAdSettings");
        return nativeAdSettings;
    }
}
