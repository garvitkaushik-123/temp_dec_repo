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

/* renamed from: com.ironsource.u9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3332u9 extends AbstractC3340v0 {
    public static final a z = new a(null);
    private final C3070f0 t;
    private final boolean u;
    private final C3323u0 v;
    private final C3366w9 w;
    private final String x;
    private final String y;

    /* renamed from: com.ironsource.u9$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final C3332u9 a(C3070f0 adProperties, La la, boolean z) {
            List<C3116hc> emptyList;
            C3337ue d;
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            AbstractC3340v0.a aVar = AbstractC3340v0.r;
            U3 c = (la == null || (d = la.d()) == null) ? null : d.c();
            C3366w9 d2 = c != null ? c.d() : null;
            if (d2 == null) {
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
            return new C3332u9(adProperties, z, new C3323u0(userIdForNetworks, arrayList, b), d2);
        }

        private a() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C3332u9(C3070f0 adProperties, boolean z2, C3323u0 adUnitCommonData, C3366w9 configs) {
        super(adProperties, z2, r3, r4, r5, r6, configs.c(), configs.d(), configs.f(), configs.b(), -1, new N0(N0.a.MANUAL, configs.g().j(), configs.g().b(), -1L), configs.h(), configs.k(), configs.m(), configs.l(), false, 65536, null);
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        String f = adUnitCommonData.f();
        List<NetworkSettings> d = adUnitCommonData.d();
        Z9 e = adUnitCommonData.e();
        C3241p2 g = configs.g();
        Intrinsics.checkNotNullExpressionValue(g, "configs.interstitialAuctionSettings");
        this.t = adProperties;
        this.u = z2;
        this.v = adUnitCommonData;
        this.w = configs;
        this.x = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
        this.y = Ma.c;
    }

    public final C3323u0 A() {
        return this.v;
    }

    public final C3366w9 B() {
        return this.w;
    }

    public final C3332u9 a(C3070f0 adProperties, boolean z2, C3323u0 adUnitCommonData, C3366w9 configs) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new C3332u9(adProperties, z2, adUnitCommonData, configs);
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
        if (!(obj instanceof C3332u9)) {
            return false;
        }
        C3332u9 c3332u9 = (C3332u9) obj;
        return Intrinsics.areEqual(this.t, c3332u9.t) && this.u == c3332u9.u && Intrinsics.areEqual(this.v, c3332u9.v) && Intrinsics.areEqual(this.w, c3332u9.w);
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
        return "InterstitialAdUnitData(adProperties=" + this.t + ", isPublisherLoad=" + this.u + ", adUnitCommonData=" + this.v + ", configs=" + this.w + ")";
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

    public final C3366w9 z() {
        return this.w;
    }

    public static /* synthetic */ C3332u9 a(C3332u9 c3332u9, C3070f0 c3070f0, boolean z2, C3323u0 c3323u0, C3366w9 c3366w9, int i, Object obj) {
        if ((i & 1) != 0) {
            c3070f0 = c3332u9.t;
        }
        if ((i & 2) != 0) {
            z2 = c3332u9.u;
        }
        if ((i & 4) != 0) {
            c3323u0 = c3332u9.v;
        }
        if ((i & 8) != 0) {
            c3366w9 = c3332u9.w;
        }
        return c3332u9.a(c3070f0, z2, c3323u0, c3366w9);
    }

    @Override // com.ironsource.AbstractC3340v0
    public JSONObject b(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        JSONObject interstitialSettings = providerSettings.getInterstitialSettings();
        Intrinsics.checkNotNullExpressionValue(interstitialSettings, "providerSettings.interstitialSettings");
        return interstitialSettings;
    }
}
