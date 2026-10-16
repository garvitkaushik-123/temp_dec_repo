package com.moloco.sdk.internal.services.bidtoken.providers;

import com.google.common.annotations.VisibleForTesting;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.AbstractC3439c;
import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public final class m implements l {
    public static final a c = new a(null);
    public static final int d = 8;
    public static final String e = "ClientBidTokenSignalProviderImpl";
    public final List<j<?>> b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(@VisibleForTesting List<? extends j<?>> signalProviders) {
        Intrinsics.checkNotNullParameter(signalProviders, "signalProviders");
        this.b = signalProviders;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        Iterator<j<?>> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        List<j<?>> list = this.b;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            boolean b = jVar.b();
            if (b) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, e, "[CBT] Signal provider " + jVar.c() + " needs refresh", null, false, 12, null);
            }
            if (b) {
                return true;
            }
        }
        return false;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return e;
    }

    public final List<j<?>> e() {
        return this.b;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public k d() {
        List<j<?>> list = this.b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(Reflection.getOrCreateKotlinClass(((j) obj).getClass()), obj);
        }
        Object obj2 = linkedHashMap.get(Reflection.getOrCreateKotlinClass(w.class));
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.SDKInitStateSignalProvider");
        boolean booleanValue = ((w) obj2).d().booleanValue();
        Object obj3 = linkedHashMap.get(Reflection.getOrCreateKotlinClass(v.class));
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.PrivacyStateSignalProvider");
        MolocoPrivacy.PrivacySettings d2 = ((v) obj3).d();
        Object obj4 = linkedHashMap.get(Reflection.getOrCreateKotlinClass(s.class));
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.MemorySignalProvider");
        r d3 = ((s) obj4).d();
        Object obj5 = linkedHashMap.get(Reflection.getOrCreateKotlinClass(e.class));
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.AppDirInfoSignalProvider");
        d d4 = ((e) obj5).d();
        Object obj6 = linkedHashMap.get(Reflection.getOrCreateKotlinClass(u.class));
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.NetworkInfoSignalProvider");
        t d5 = ((u) obj6).d();
        Object obj7 = linkedHashMap.get(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.BatteryInfoSignalProvider");
        h d6 = ((i) obj7).d();
        Object obj8 = linkedHashMap.get(Reflection.getOrCreateKotlinClass(c.class));
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.AdvertisingSignalProvider");
        AbstractC3439c d7 = ((c) obj8).d();
        Object obj9 = linkedHashMap.get(Reflection.getOrCreateKotlinClass(o.class));
        Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.DeviceSignalProvider");
        n d8 = ((o) obj9).d();
        Object obj10 = linkedHashMap.get(Reflection.getOrCreateKotlinClass(g.class));
        Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.AudioSignalProvider");
        f d9 = ((g) obj10).d();
        Object obj11 = linkedHashMap.get(Reflection.getOrCreateKotlinClass(b.class));
        Intrinsics.checkNotNull(obj11, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.AccessibilitySignalProvider");
        com.moloco.sdk.internal.services.bidtoken.providers.a d10 = ((b) obj11).d();
        Object obj12 = linkedHashMap.get(Reflection.getOrCreateKotlinClass(q.class));
        Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.IlrdSignalProvider");
        return new k(booleanValue, d2, d3, d4, d5, d6, d7, d8, d9, d10, ((q) obj12).d());
    }
}
