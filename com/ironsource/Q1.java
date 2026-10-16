package com.ironsource;

import com.ironsource.B3;
import com.ironsource.Q1;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public final class Q1 {

    /* renamed from: a, reason: collision with root package name */
    private final V0 f3001a;
    private final AbstractC3340v0 b;
    private final Map<String, G> c;
    private final C3072f2 d;
    private final List<CallableC3394y3> e;
    private final boolean f;

    public static final class a extends Pd {
        final /* synthetic */ B3 b;
        final /* synthetic */ Q1 c;
        final /* synthetic */ B3.b d;

        a(B3 b3, Q1 q1, B3.b bVar) {
            this.b = b3;
            this.c = q1;
            this.d = bVar;
        }

        @Override // com.ironsource.Pd
        public void a() {
            this.b.a(this.c.e(), this.d, this.c.b.f(), TimeUnit.MILLISECONDS);
        }
    }

    public static final class c implements B3.b {
        final /* synthetic */ d b;

        c(d dVar) {
            this.b = dVar;
        }

        @Override // com.ironsource.B3.b
        public void a(final List<? extends C3> biddingDataList, final long j, final List<String> reachedTimeout) {
            Intrinsics.checkNotNullParameter(biddingDataList, "biddingDataList");
            Intrinsics.checkNotNullParameter(reachedTimeout, "reachedTimeout");
            V0 v0 = Q1.this.f3001a;
            final Q1 q1 = Q1.this;
            final d dVar = this.b;
            v0.a(new Runnable() { // from class: com.ironsource.Q1$c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Q1.c.a(Q1.this, j, biddingDataList, reachedTimeout, dVar);
                }
            });
        }

        @Override // com.ironsource.B3.b
        public void onFailure(final String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            V0 v0 = Q1.this.f3001a;
            final Q1 q1 = Q1.this;
            final d dVar = this.b;
            v0.a(new Runnable() { // from class: com.ironsource.Q1$c$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Q1.c.a(Q1.this, error, dVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Q1 this$0, long j, List biddingDataList, List reachedTimeout, d biddingDataListener) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(biddingDataList, "$biddingDataList");
            Intrinsics.checkNotNullParameter(reachedTimeout, "$reachedTimeout");
            Intrinsics.checkNotNullParameter(biddingDataListener, "$biddingDataListener");
            this$0.a(j, biddingDataList, reachedTimeout, biddingDataListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Q1 this$0, String error, d biddingDataListener) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(error, "$error");
            Intrinsics.checkNotNullParameter(biddingDataListener, "$biddingDataListener");
            this$0.f3001a.e().g().a(error);
            biddingDataListener.a(this$0, error);
        }
    }

    public interface d {
        void a(Q1 q1);

        void a(Q1 q1, String str);
    }

    public Q1(V0 adTools, AbstractC3340v0 adUnitData) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.f3001a = adTools;
        this.b = adUnitData;
        this.c = a();
        this.d = new C3072f2(adUnitData);
        this.e = new ArrayList();
        this.f = adUnitData.e().q();
        b b2 = b();
        C3203mf g = adUnitData.b().g();
        for (NetworkSettings networkSettings : adUnitData.m()) {
            if (g == null || g.a(networkSettings, this.b.b().a())) {
                AdData a2 = this.b.a(networkSettings);
                if (networkSettings.isBidder(this.b.b().a())) {
                    Object b3 = this.f ? b(networkSettings.getProviderName()) : a(networkSettings);
                    if (b3 instanceof A3) {
                        this.e.add(new CallableC3394y3(networkSettings.getInstanceType(this.b.b().a()), networkSettings.getProviderInstanceName(), a2, (A3) b3, b2, networkSettings));
                    } else {
                        this.f3001a.e().h().g(b3 == null ? "prepareAuctionCandidates - could not load network adapter " + networkSettings.getProviderName() : "network adapter " + networkSettings.getProviderName() + " does not implementing BiddingDataInterface");
                    }
                } else {
                    this.d.a(networkSettings);
                }
            }
        }
    }

    public final Map<String, G> c() {
        return this.c;
    }

    public final C3072f2 d() {
        return this.d;
    }

    public final List<CallableC3394y3> e() {
        return this.e;
    }

    public final boolean f() {
        return !this.e.isEmpty();
    }

    public final boolean g() {
        return this.d.d();
    }

    public final boolean h() {
        return this.f;
    }

    private final b b() {
        return new b();
    }

    private final B3.b b(d dVar) {
        return new c(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseAdAdapter<?, ?> b(String str) {
        G g = this.c.get(str);
        if (g != null) {
            return g.b();
        }
        return null;
    }

    private final Map<String, G> a() {
        List<NetworkSettings> m = this.b.m();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(m, 10)), 16));
        Iterator<T> it = m.iterator();
        while (it.hasNext()) {
            G g = new G(this.f3001a, this.b, (NetworkSettings) it.next());
            Pair pair = TuplesKt.to(g.c(), g);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    public static final class b implements InterfaceC3411z3 {
        b() {
        }

        @Override // com.ironsource.InterfaceC3411z3
        public void a(NetworkSettings networkSettings) {
            AdapterBaseInterface a2;
            if (Q1.this.h()) {
                a2 = null;
                BaseAdAdapter b = Q1.this.b(networkSettings != null ? networkSettings.getProviderName() : null);
                if (b != null) {
                    a2 = b.getNetworkAdapter();
                }
            } else {
                a2 = Q1.this.a(networkSettings);
            }
            if (a2 != null) {
                Q1.this.f3001a.e().g().a(Q1.this.a(networkSettings, a2));
            }
        }

        @Override // com.ironsource.InterfaceC3411z3
        public void a(String str) {
            Q1.this.f3001a.e().h().g(str);
        }
    }

    public final void a(d biddingDataListener) {
        Intrinsics.checkNotNullParameter(biddingDataListener, "biddingDataListener");
        B3 b3 = new B3();
        B3.b b2 = b(biddingDataListener);
        this.f3001a.e().g().a();
        this.f3001a.c((Pd) new a(b3, this, b2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(long j, List<? extends C3> list, List<String> list2, d dVar) {
        this.f3001a.e().g().a(j);
        for (C3 c3 : list) {
            String c2 = c3.c();
            Intrinsics.checkNotNullExpressionValue(c2, "biddingResponse.instanceName");
            Map<String, Object> a2 = a(c2);
            if (c3.a() != null) {
                this.d.a(c3);
                this.f3001a.e().g().a(a2, c3.e());
            } else {
                this.f3001a.e().g().a(a2, c3.e(), c3.b());
            }
        }
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            this.f3001a.e().g().b(a(it.next()), j);
        }
        dVar.a(this);
    }

    private final Map<String, Object> a(String str) {
        AdapterBaseInterface a2;
        NetworkSettings a3 = this.b.a(str);
        if (this.f) {
            BaseAdAdapter<?, ?> b2 = b(str);
            a2 = b2 != null ? b2.getNetworkAdapter() : null;
        } else {
            a2 = a(a3);
        }
        return a(a3, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        String providerDefaultInstance;
        HashMap hashMap = new HashMap();
        if (networkSettings != null) {
            try {
                providerDefaultInstance = networkSettings.getProviderDefaultInstance();
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getProviderEventData " + (networkSettings != null ? networkSettings.getProviderDefaultInstance() : null), e);
                return hashMap;
            }
        } else {
            providerDefaultInstance = null;
        }
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, providerDefaultInstance);
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, adapterBaseInterface != null ? adapterBaseInterface.getAdapterVersion() : null);
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, adapterBaseInterface != null ? adapterBaseInterface.getNetworkSDKVersion() : null);
        hashMap.put("spId", networkSettings != null ? networkSettings.getSubProviderId() : null);
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        hashMap.put("instanceType", networkSettings != null ? Integer.valueOf(networkSettings.getInstanceType(this.b.b().a())) : null);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdapterBaseInterface a(NetworkSettings networkSettings) {
        return com.ironsource.mediationsdk.c.b().b(networkSettings, this.b.b().a(), this.b.b().b());
    }
}
