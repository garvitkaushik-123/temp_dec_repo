package com.ironsource;

import com.ironsource.L8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.sdk.controller.FeaturesManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class De implements L8, L8.a {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, C3356w> f2832a = new LinkedHashMap();
    private final Xb b = new Xb();
    private final ReadWriteLock c = new ReentrantReadWriteLock();

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2833a;

        static {
            int[] iArr = new int[Ce.values().length];
            try {
                iArr[Ce.CurrentlyLoadedAdsAndFullHistory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Ce.CurrentlyLoadedAds.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Ce.Off.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f2833a = iArr;
        }
    }

    private final void b() {
        Be configuration = FeaturesManager.getInstance().getSessionHistoryConfig();
        Xb xb = this.b;
        Intrinsics.checkNotNullExpressionValue(configuration, "configuration");
        xb.a(a(configuration));
        this.b.a(a());
    }

    @Override // com.ironsource.L8.a
    public void a(Ee historyRecord) {
        Intrinsics.checkNotNullParameter(historyRecord, "historyRecord");
        this.c.writeLock().lock();
        try {
            N a2 = historyRecord.a();
            String valueOf = String.valueOf(a2 != null ? a2.b() : null);
            Map<String, C3356w> map = this.f2832a;
            C3356w c3356w = map.get(valueOf);
            if (c3356w == null) {
                c3356w = new C3356w();
                map.put(valueOf, c3356w);
            }
            c3356w.a(historyRecord.a(new Ke()));
            this.c.writeLock().unlock();
            b();
        } catch (Throwable th) {
            this.c.writeLock().unlock();
            throw th;
        }
    }

    @Override // com.ironsource.L8
    public JSONObject a(Ne mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.c.readLock().lock();
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, C3356w> entry : this.f2832a.entrySet()) {
                String key = entry.getKey();
                JSONObject a2 = entry.getValue().a(mode);
                if (a2.length() > 0) {
                    jSONObject.put(key, a2);
                }
            }
            return jSONObject;
        } finally {
            this.c.readLock().unlock();
        }
    }

    @Override // com.ironsource.L8
    public int a(IronSource.AD_UNIT adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        this.c.readLock().lock();
        try {
            C3356w c3356w = this.f2832a.get(adFormat.toString());
            return c3356w != null ? c3356w.a() : 0;
        } finally {
            this.c.readLock().unlock();
        }
    }

    @Override // com.ironsource.L8
    public List<String> a() {
        this.c.readLock().lock();
        try {
            Map<String, C3356w> map = this.f2832a;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, C3356w> entry : map.entrySet()) {
                if (entry.getValue().b()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return CollectionsKt.toList(linkedHashMap.keySet());
        } finally {
            this.c.readLock().unlock();
        }
    }

    @Override // com.ironsource.L8
    public Map<String, JSONObject> a(Be configuration) {
        Map<String, JSONObject> mutableMapOf;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.c.readLock().lock();
        try {
            int i = a.f2833a[configuration.a().ordinal()];
            if (i == 1) {
                mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(N6.y1, a(Ne.FullHistory)), TuplesKt.to(N6.z1, a(Ne.CurrentlyLoadedAds)));
            } else if (i == 2) {
                mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(N6.z1, a(Ne.CurrentlyLoadedAds)));
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                mutableMapOf = MapsKt.emptyMap();
            }
            return mutableMapOf;
        } finally {
            this.c.readLock().unlock();
        }
    }
}
