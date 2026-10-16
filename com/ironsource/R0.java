package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
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

/* loaded from: classes6.dex */
public final class R0 extends com.ironsource.mediationsdk.h {
    private final Map<String, J> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public R0(List<? extends NetworkSettings> providers, int i) {
        super(providers, i);
        Intrinsics.checkNotNullParameter(providers, "providers");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(providers, 10)), 16));
        Iterator<T> it = providers.iterator();
        while (it.hasNext()) {
            Pair pair = TuplesKt.to(((NetworkSettings) it.next()).getProviderName(), new J(i));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        this.e = linkedHashMap;
    }

    public final void a(kg waterfallInstances) {
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
        List<AbstractC3407z> b = waterfallInstances.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(b, 10)), 16));
        for (AbstractC3407z abstractC3407z : b) {
            Pair pair = TuplesKt.to(abstractC3407z.p(), abstractC3407z.s());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        a(linkedHashMap);
    }

    @Override // com.ironsource.mediationsdk.h
    public String a(String instanceName) {
        String d;
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        J j = this.e.get(instanceName);
        return (j == null || (d = j.d()) == null) ? "" : d;
    }

    private final void a(Map<String, H> map) {
        for (Map.Entry<String, J> entry : this.e.entrySet()) {
            entry.getValue().a(map.get(entry.getKey()));
        }
    }
}
