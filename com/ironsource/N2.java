package com.ironsource;

import com.ironsource.AbstractC3340v0;
import com.ironsource.N0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
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
public final class N2 extends AbstractC3340v0 {
    public static final a z = new a(null);
    private final K2 t;
    private final boolean u;
    private final C3323u0 v;
    private final V2 w;
    private final String x;
    private final String y;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final N2 a(K2 adProperties, La la, boolean z) {
            List<C3116hc> emptyList;
            C3337ue d;
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            AbstractC3340v0.a aVar = AbstractC3340v0.r;
            U3 c = (la == null || (d = la.d()) == null) ? null : d.c();
            V2 c2 = c != null ? c.c() : null;
            if (c2 == null) {
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
            return new N2(adProperties, z, new C3323u0(userIdForNetworks, arrayList, b), c2);
        }

        private a() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public N2(K2 adProperties, boolean z2, C3323u0 adUnitCommonData, V2 configs) {
        super(adProperties, z2, r3, r4, r5, r6, configs.a(), (int) (configs.b() / 1000), configs.c(), configs.f(), -1, new N0(N0.a.MANUAL_WITH_AUTOMATIC_RELOAD, configs.d().j(), configs.d().b(), 1000 * configs.h()), configs.e(), configs.l(), configs.n(), configs.m(), false, 65536, null);
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        String f = adUnitCommonData.f();
        List<NetworkSettings> d = adUnitCommonData.d();
        Z9 e = adUnitCommonData.e();
        C3241p2 d2 = configs.d();
        Intrinsics.checkNotNullExpressionValue(d2, "configs.bannerAuctionSettings");
        this.t = adProperties;
        this.u = z2;
        this.v = adUnitCommonData;
        this.w = configs;
        this.x = "BN";
        this.y = Ma.d;
    }

    @Override // com.ironsource.AbstractC3340v0
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public K2 b() {
        return this.t;
    }

    public final C3323u0 B() {
        return this.v;
    }

    public final V2 C() {
        return this.w;
    }

    public final N2 a(K2 adProperties, boolean z2, C3323u0 adUnitCommonData, V2 configs) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new N2(adProperties, z2, adUnitCommonData, configs);
    }

    @Override // com.ironsource.AbstractC3340v0
    public String c() {
        return this.x;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N2)) {
            return false;
        }
        N2 n2 = (N2) obj;
        return Intrinsics.areEqual(this.t, n2.t) && this.u == n2.u && Intrinsics.areEqual(this.v, n2.v) && Intrinsics.areEqual(this.w, n2.w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.t.hashCode() * 31;
        boolean z2 = this.u;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return ((((hashCode + i) * 31) + this.v.hashCode()) * 31) + this.w.hashCode();
    }

    @Override // com.ironsource.AbstractC3340v0
    public String j() {
        return this.y;
    }

    public String toString() {
        return "BannerAdUnitData(adProperties=" + this.t + ", isPublisherLoad=" + this.u + ", adUnitCommonData=" + this.v + ", configs=" + this.w + ")";
    }

    @Override // com.ironsource.AbstractC3340v0
    public boolean u() {
        return this.u;
    }

    public final K2 w() {
        return this.t;
    }

    public final boolean x() {
        return this.u;
    }

    public final C3323u0 y() {
        return this.v;
    }

    public final V2 z() {
        return this.w;
    }

    public static /* synthetic */ N2 a(N2 n2, K2 k2, boolean z2, C3323u0 c3323u0, V2 v2, int i, Object obj) {
        if ((i & 1) != 0) {
            k2 = n2.t;
        }
        if ((i & 2) != 0) {
            z2 = n2.u;
        }
        if ((i & 4) != 0) {
            c3323u0 = n2.v;
        }
        if ((i & 8) != 0) {
            v2 = n2.w;
        }
        return n2.a(k2, z2, c3323u0, v2);
    }

    @Override // com.ironsource.AbstractC3340v0
    public JSONObject b(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        JSONObject bannerSettings = providerSettings.getBannerSettings();
        Intrinsics.checkNotNullExpressionValue(bannerSettings, "providerSettings.bannerSettings");
        return bannerSettings;
    }

    @Override // com.ironsource.AbstractC3340v0
    public AdData a(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        AdData createAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(b(providerSettings), b().a(), r(), new IronSourceBannerLayout(ContextProvider.getInstance().getApplicationContext(), new C3154k0().b(b().h())));
        Intrinsics.checkNotNullExpressionValue(createAdDataForNetworkAdapter, "createAdDataForNetworkAd…ze(adProperties.adSize)))");
        return createAdDataForNetworkAdapter;
    }
}
