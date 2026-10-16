package com.ironsource;

import com.ironsource.AbstractC3340v0;
import com.ironsource.N0;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Ad extends AbstractC3340v0 {
    public static final a z = new a(null);
    private final C3070f0 t;
    private final boolean u;
    private final C3323u0 v;
    private final Gd w;
    private final String x;
    private final String y;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Ad a(C3070f0 adProperties, La la, boolean z) {
            List<C3116hc> emptyList;
            C3337ue d;
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            AbstractC3340v0.a aVar = AbstractC3340v0.r;
            U3 c = (la == null || (d = la.d()) == null) ? null : d.c();
            Gd f = c != null ? c.f() : null;
            if (f == null) {
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
            return new Ad(adProperties, z, new C3323u0(userIdForNetworks, arrayList, b), f);
        }

        private a() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Ad(C3070f0 adProperties, boolean z2, C3323u0 adUnitCommonData, Gd configs) {
        super(adProperties, z2, r3, r4, r5, r6, configs.g(), configs.h(), configs.j(), configs.b(), configs.c(), new N0(N0.a.MANUAL, configs.k().j(), configs.k().b(), -1L), configs.l(), configs.f(), configs.o(), configs.n(), false, 65536, null);
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        String f = adUnitCommonData.f();
        List<NetworkSettings> d = adUnitCommonData.d();
        Z9 e = adUnitCommonData.e();
        C3241p2 k = configs.k();
        Intrinsics.checkNotNullExpressionValue(k, "configs.rewardedVideoAuctionSettings");
        this.t = adProperties;
        this.u = z2;
        this.v = adUnitCommonData;
        this.w = configs;
        this.x = IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
        this.y = Ma.b;
    }

    public final C3323u0 A() {
        return this.v;
    }

    public final Gd B() {
        return this.w;
    }

    public final Ad a(C3070f0 adProperties, boolean z2, C3323u0 adUnitCommonData, Gd configs) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new Ad(adProperties, z2, adUnitCommonData, configs);
    }

    @Override // com.ironsource.AbstractC3340v0
    public C3070f0 b() {
        return this.t;
    }

    @Override // com.ironsource.AbstractC3340v0
    public String c() {
        return this.x;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ad)) {
            return false;
        }
        Ad ad = (Ad) obj;
        return Intrinsics.areEqual(this.t, ad.t) && this.u == ad.u && Intrinsics.areEqual(this.v, ad.v) && Intrinsics.areEqual(this.w, ad.w);
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
        return "RewardedAdUnitData(adProperties=" + this.t + ", isPublisherLoad=" + this.u + ", adUnitCommonData=" + this.v + ", configs=" + this.w + ")";
    }

    @Override // com.ironsource.AbstractC3340v0
    public boolean u() {
        return this.u;
    }

    public final C3070f0 w() {
        return this.t;
    }

    public final boolean x() {
        return this.u;
    }

    public final C3323u0 y() {
        return this.v;
    }

    public final Gd z() {
        return this.w;
    }

    public static /* synthetic */ Ad a(Ad ad, C3070f0 c3070f0, boolean z2, C3323u0 c3323u0, Gd gd, int i, Object obj) {
        if ((i & 1) != 0) {
            c3070f0 = ad.t;
        }
        if ((i & 2) != 0) {
            z2 = ad.u;
        }
        if ((i & 4) != 0) {
            c3323u0 = ad.v;
        }
        if ((i & 8) != 0) {
            gd = ad.w;
        }
        return ad.a(c3070f0, z2, c3323u0, gd);
    }

    @Override // com.ironsource.AbstractC3340v0
    public JSONObject b(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        JSONObject rewardedVideoSettings = providerSettings.getRewardedVideoSettings();
        Intrinsics.checkNotNullExpressionValue(rewardedVideoSettings, "providerSettings.rewardedVideoSettings");
        return rewardedVideoSettings;
    }
}
