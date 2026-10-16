package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.xe, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2945xe {

    /* renamed from: a, reason: collision with root package name */
    public static final JSONObject f2756a = new JSONObject();
    public static final LinkedHashSet b = new LinkedHashSet();
    public static Be c;

    public static void a() {
        synchronized (f2756a) {
            c = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (f2756a) {
            Be be = c;
            if (be != null) {
                z = be.A.get() ? false : true;
            }
        }
        return z;
    }

    public static void c() {
        Be be;
        synchronized (f2756a) {
            if (b() && (be = c) != null) {
                be.A.compareAndSet(false, true);
            }
            Unit unit = Unit.INSTANCE;
        }
        d();
    }

    public static void d() {
        LinkedHashMap linkedHashMap = O2.f2380a;
        SignalsConfig.UnifiedIdServiceConfig unifiedIdServiceConfig = ((SignalsConfig) AbstractC2808p5.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getUnifiedIdServiceConfig();
        synchronized (f2756a) {
            String url = unifiedIdServiceConfig.getUrl();
            LinkedHashMap linkedHashMap2 = O2.f2380a;
            Config a2 = M2.a("signals", Uc.b(), null);
            Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
            Be be = new Be(url, new C2897ue(((SignalsConfig) a2).getIncludeIds()), Uc.b(), unifiedIdServiceConfig.getMaxRetries(), unifiedIdServiceConfig.getRetryInterval(), unifiedIdServiceConfig.getTimeout());
            c = be;
            F5 f5 = new F5(new C2964ye(be, b), be);
            HashMap hashMap = new HashMap();
            Pd pd = Pd.f2401a;
            Pd.b("UnifiedIdNetworkCallRequested", hashMap, Td.f2443a);
            ((ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue()).submit(f5);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static void e() {
        synchronized (f2756a) {
            Be be = c;
            if (be != null) {
                be.A.compareAndSet(false, true);
            }
            c = null;
            b.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
