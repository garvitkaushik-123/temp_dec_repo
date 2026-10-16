package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* renamed from: com.ironsource.nc, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3217nc extends ig {
    private final V0 e;
    private final AbstractC3340v0 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3217nc(V0 tools, AbstractC3340v0 adUnitData) {
        super(tools, adUnitData);
        Intrinsics.checkNotNullParameter(tools, "tools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.e = tools;
        this.f = adUnitData;
    }

    private final C3156k2 b() {
        return new C3156k2("", new JSONObject(), null, 0, "");
    }

    private final Map<String, G> c() {
        C3203mf g = this.f.b().g();
        List<NetworkSettings> m = this.f.m();
        ArrayList<NetworkSettings> arrayList = new ArrayList();
        for (Object obj : m) {
            NetworkSettings networkSettings = (NetworkSettings) obj;
            if (g == null || g.a(networkSettings, this.f.b().a())) {
                if (!networkSettings.isBidder(this.f.b().a())) {
                    arrayList.add(obj);
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (NetworkSettings networkSettings2 : arrayList) {
            Pair pair = TuplesKt.to(networkSettings2.getProviderInstanceName(), new G(this.e, this.f, networkSettings2));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    private final List<C3207n2> d() {
        C3203mf g = this.f.b().g();
        List<NetworkSettings> m = this.f.m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : m) {
            NetworkSettings networkSettings = (NetworkSettings) obj;
            if (g == null || g.a(networkSettings, this.f.b().a())) {
                if (!networkSettings.isBidder(this.f.b().a())) {
                    arrayList.add(obj);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new C3207n2(((NetworkSettings) it.next()).getProviderInstanceName()));
        }
        return arrayList2;
    }

    @Override // com.ironsource.ig
    public void a(C adInstanceFactory, jg waterfallFetcherListener) {
        Intrinsics.checkNotNullParameter(adInstanceFactory, "adInstanceFactory");
        Intrinsics.checkNotNullParameter(waterfallFetcherListener, "waterfallFetcherListener");
        IronLog.INTERNAL.verbose(C3205n0.a(this.e, "auction disabled", (String) null, 2, (Object) null));
        a(waterfallFetcherListener, b(), adInstanceFactory);
    }

    public final void a(jg waterfallFetcherListener, int i, String auctionFallback, String auctionId, C adInstanceFactory) {
        Intrinsics.checkNotNullParameter(waterfallFetcherListener, "waterfallFetcherListener");
        Intrinsics.checkNotNullParameter(auctionFallback, "auctionFallback");
        Intrinsics.checkNotNullParameter(auctionId, "auctionId");
        Intrinsics.checkNotNullParameter(adInstanceFactory, "adInstanceFactory");
        a(waterfallFetcherListener, new C3156k2(auctionId, new JSONObject(), null, i, auctionFallback), adInstanceFactory);
    }

    private final void a(jg jgVar, C3156k2 c3156k2, C c) {
        IronLog.INTERNAL.verbose(C3205n0.a(this.e, (String) null, (String) null, 3, (Object) null));
        jgVar.a(a(d(), c(), c3156k2, c));
    }
}
