package com.ironsource;

import com.ironsource.O;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Q implements O, O.a {

    /* renamed from: a, reason: collision with root package name */
    private final ReadWriteLock f3000a;
    private final Map<String, N> b;

    /* JADX WARN: Multi-variable type inference failed */
    public Q() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.O
    public N a(String adId) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        this.f3000a.readLock().lock();
        try {
            return this.b.get(adId);
        } finally {
            this.f3000a.readLock().unlock();
        }
    }

    public Q(ReadWriteLock readWriteLock) {
        Intrinsics.checkNotNullParameter(readWriteLock, "readWriteLock");
        this.f3000a = readWriteLock;
        this.b = new LinkedHashMap();
    }

    @Override // com.ironsource.O
    public List<N> a() {
        this.f3000a.readLock().lock();
        List<N> list = CollectionsKt.toList(this.b.values());
        this.f3000a.readLock().unlock();
        return list;
    }

    public /* synthetic */ Q(ReadWriteLock readWriteLock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ReentrantReadWriteLock() : readWriteLock);
    }

    @Override // com.ironsource.O.a
    public void a(N adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3000a.writeLock().lock();
        try {
            if (this.b.get(adInfo.c()) == null) {
                this.b.put(adInfo.c(), adInfo);
            }
        } finally {
            this.f3000a.writeLock().unlock();
        }
    }

    @Override // com.ironsource.O.a
    public void a(JSONObject json, EnumC3188m0 adStatus, String adId) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(adStatus, "adStatus");
        Intrinsics.checkNotNullParameter(adId, "adId");
        this.f3000a.writeLock().lock();
        try {
            N n = this.b.get(adId);
            if (n == null) {
                return;
            }
            String bundleId = json.optString("bundleId");
            Intrinsics.checkNotNullExpressionValue(bundleId, "bundleId");
            if (bundleId.length() > 0) {
                n.a(bundleId);
            }
            String dynamicDemandSourceId = json.optString("dynamicDemandSource");
            Intrinsics.checkNotNullExpressionValue(dynamicDemandSourceId, "dynamicDemandSourceId");
            if (dynamicDemandSourceId.length() > 0) {
                n.a(S7.b.a(dynamicDemandSourceId));
            }
            n.a(adStatus);
        } finally {
            this.f3000a.writeLock().unlock();
        }
    }

    @Override // com.ironsource.O.a
    public void a(EnumC3188m0 adStatus, String adId) {
        Intrinsics.checkNotNullParameter(adStatus, "adStatus");
        Intrinsics.checkNotNullParameter(adId, "adId");
        this.f3000a.writeLock().lock();
        try {
            N n = this.b.get(adId);
            if (n == null) {
                return;
            }
            n.a(adStatus);
            n.a(System.currentTimeMillis() / 1000.0d);
        } finally {
            this.f3000a.writeLock().unlock();
        }
    }
}
