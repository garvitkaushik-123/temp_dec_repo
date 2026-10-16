package io.bidmachine.analytics.internal;

import io.bidmachine.analytics.ReaderConfig;
import io.bidmachine.analytics.internal.AbstractC3569i;
import io.bidmachine.analytics.internal.G;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* loaded from: classes7.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    private final J f6659a;
    private final G.a b;
    private Map c;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a implements G.a {

        /* renamed from: a, reason: collision with root package name */
        private final J f6660a;

        public a(J j) {
            this.f6660a = j;
        }

        @Override // io.bidmachine.analytics.internal.G.a
        public G a() {
            return new G(this.f6660a, new K(), CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(Executors.newSingleThreadExecutor())));
        }
    }

    public I(J j, G.a aVar) {
        this.f6659a = j;
        this.b = aVar;
    }

    public final void a(AbstractC3569i.a aVar) {
        List c = aVar.c();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(c, 10));
        Iterator it = c.iterator();
        while (it.hasNext()) {
            arrayList.add(((ReaderConfig.Rule) it.next()).getPath());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(obj, this.b.a());
        }
        this.c = MapsKt.toMutableMap(linkedHashMap);
    }

    public final void b() {
        Map map = this.c;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                ((G) entry.getValue()).a((String) entry.getKey());
            }
        }
    }

    public /* synthetic */ I(J j, G.a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? new a(j) : aVar);
    }

    public final void a() {
        Map map = this.c;
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                ((G) ((Map.Entry) it.next()).getValue()).a();
            }
        }
    }

    public final String a(ReaderConfig.Rule rule) {
        String b = this.f6659a.b(rule.getPath());
        if (b != null) {
            return b;
        }
        throw new FileNotFoundException();
    }
}
