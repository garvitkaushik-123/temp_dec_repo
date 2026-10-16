package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.CrashConfig;
import com.inmobi.commons.core.configs.TelemetryConfig;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes4.dex */
public final class Cb implements N2 {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC2560a7 f2253a;
    public static C2645f7 b;
    public static final AtomicBoolean c;
    public static TelemetryConfig d;
    public static CrashConfig e;
    public static final ReentrantLock f;
    public static final Bb g;
    public static final ReferenceQueue h;
    public static final ConcurrentHashMap i;
    public static final AtomicBoolean j;

    static {
        Cb cb = new Cb();
        f2253a = EnumC2560a7.c;
        c = new AtomicBoolean(false);
        f = new ReentrantLock();
        g = Bb.f2245a;
        h = new ReferenceQueue();
        i = new ConcurrentHashMap();
        j = new AtomicBoolean(false);
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a("telemetry", Uc.b(), cb);
        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.TelemetryConfig");
        d = (TelemetryConfig) a2;
        Config a3 = M2.a("crashReporting", Uc.b(), cb);
        Intrinsics.checkNotNull(a3, "null cannot be cast to non-null type com.inmobi.commons.core.configs.CrashConfig");
        e = (CrashConfig) a3;
    }

    public static A5 a(String logType, String placementType, boolean z) {
        Intrinsics.checkNotNullParameter(logType, "logType");
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        Context context = Uc.d();
        if (context != null) {
            try {
                b();
                TelemetryConfig.LoggingConfig loggingConfig = d.getLoggingConfig();
                double b2 = b(logType, placementType, loggingConfig);
                EnumC2560a7 logLevel = a(logType, placementType, loggingConfig);
                boolean z2 = !loggingConfig.getEnabled();
                long expiry = loggingConfig.getExpiry() * 1000;
                int maxNoOfEntries = loggingConfig.getMaxNoOfEntries();
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(logLevel, "logLevel");
                return new A5(context, b2, logLevel, z2, z, maxNoOfEntries, expiry, false);
            } catch (Exception e2) {
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e2, "event"));
            }
        }
        return null;
    }

    public static void b() {
        if (b != null) {
            return;
        }
        ReentrantLock reentrantLock = f;
        if (reentrantLock.tryLock()) {
            try {
                if (b == null && c.get()) {
                    Context d2 = Uc.d();
                    if (d2 != null) {
                        TelemetryConfig.LoggingConfig loggingConfig = d.getLoggingConfig();
                        b = new C2645f7(d2, loggingConfig.getLoggingUrl(), loggingConfig.getRetryInterval() * 1000, loggingConfig.getExpiry(), loggingConfig.getMaxRetries(), loggingConfig.getMaxNoOfEntries());
                    }
                    C2645f7 c2645f7 = b;
                    if (c2645f7 != null) {
                        D5.a(c2645f7);
                    }
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                f.unlock();
                throw th;
            }
        }
    }

    public static final void c() {
        WeakReference weakReference;
        InterfaceC2971z5 interfaceC2971z5;
        while (c.get()) {
            Reference remove = h.remove();
            ConcurrentHashMap concurrentHashMap = i;
            if (CollectionsKt.contains(concurrentHashMap.keySet(), remove)) {
                Pair pair = (Pair) concurrentHashMap.get(remove);
                if (pair != null && (weakReference = (WeakReference) pair.getSecond()) != null && (interfaceC2971z5 = (InterfaceC2971z5) weakReference.get()) != null) {
                    ((A5) interfaceC2971z5).a("ReferenceTracker", " reference " + ((String) pair.getFirst()) + " reference is GCed.");
                }
                TypeIntrinsics.asMutableMap(concurrentHashMap).remove(remove);
            }
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                if (((WeakReference) ((Pair) entry.getValue()).getSecond()).get() == null) {
                    i.remove(entry.getKey());
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static EnumC2560a7 a(String str, String str2, TelemetryConfig.LoggingConfig loggingConfig) {
        switch (str.hashCode()) {
            case -1396342996:
                if (str.equals("banner")) {
                    if (Intrinsics.areEqual(str2, "AB")) {
                        return AbstractC2578b7.a(loggingConfig.getBanner().getAb().getLogLevel());
                    }
                    return AbstractC2578b7.a(loggingConfig.getBanner().getNonAb().getLogLevel());
                }
                break;
            case -1052618729:
                if (str.equals("native")) {
                    if (Intrinsics.areEqual(str2, "AB")) {
                        return AbstractC2578b7.a(loggingConfig.getNative().getAb().getLogLevel());
                    }
                    return AbstractC2578b7.a(loggingConfig.getNative().getNonAb().getLogLevel());
                }
                break;
            case -171121434:
                if (str.equals("intNative")) {
                    if (Intrinsics.areEqual(str2, "AB")) {
                        return AbstractC2578b7.a(loggingConfig.getInt_native().getAb().getLogLevel());
                    }
                    return AbstractC2578b7.a(loggingConfig.getInt_native().getNonAb().getLogLevel());
                }
                break;
            case 93166550:
                if (str.equals("audio")) {
                    return AbstractC2578b7.a(loggingConfig.getAudio().getNonAb().getLogLevel());
                }
                break;
            case 1957200954:
                if (str.equals("intHtml")) {
                    if (Intrinsics.areEqual(str2, "AB")) {
                        return AbstractC2578b7.a(loggingConfig.getInt_html().getAb().getLogLevel());
                    }
                    return AbstractC2578b7.a(loggingConfig.getInt_html().getNonAb().getLogLevel());
                }
                break;
            case 1966366787:
                if (str.equals("getToken")) {
                    return AbstractC2578b7.a(loggingConfig.getGetToken().getLogLevel());
                }
                break;
        }
        return f2253a;
    }

    public static double b(String str, String str2, TelemetryConfig.LoggingConfig loggingConfig) {
        switch (str.hashCode()) {
            case -1396342996:
                if (!str.equals("banner")) {
                    return 0.01d;
                }
                if (Intrinsics.areEqual(str2, "AB")) {
                    return loggingConfig.getBanner().getAb().getSamplePercent();
                }
                return loggingConfig.getBanner().getNonAb().getSamplePercent();
            case -1052618729:
                if (!str.equals("native")) {
                    return 0.01d;
                }
                if (Intrinsics.areEqual(str2, "AB")) {
                    return loggingConfig.getNative().getAb().getSamplePercent();
                }
                return loggingConfig.getNative().getNonAb().getSamplePercent();
            case -171121434:
                if (!str.equals("intNative")) {
                    return 0.01d;
                }
                if (Intrinsics.areEqual(str2, "AB")) {
                    return loggingConfig.getInt_native().getAb().getSamplePercent();
                }
                return loggingConfig.getInt_native().getNonAb().getSamplePercent();
            case 93166550:
                if (str.equals("audio")) {
                    return loggingConfig.getAudio().getNonAb().getSamplePercent();
                }
                return 0.01d;
            case 1957200954:
                if (!str.equals("intHtml")) {
                    return 0.01d;
                }
                if (Intrinsics.areEqual(str2, "AB")) {
                    return loggingConfig.getInt_html().getAb().getSamplePercent();
                }
                return loggingConfig.getInt_html().getNonAb().getSamplePercent();
            case 1966366787:
                if (str.equals("getToken")) {
                    return loggingConfig.getGetToken().getSamplePercent();
                }
                return 0.01d;
            default:
                return 0.01d;
        }
    }

    public static void a(Object obj, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        try {
            if (d.getLoggingConfig().getEnabled()) {
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).a("RemoteLoggerComponent", "starting to track reference of " + obj);
                }
                if (interfaceC2971z5 != null) {
                    i.put(new PhantomReference(obj, h), new Pair(obj.toString(), new WeakReference(interfaceC2971z5)));
                    if (j.getAndSet(true)) {
                        return;
                    }
                    ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
                    Runnable runnable = new Runnable() { // from class: com.inmobi.media.Cb$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            Cb.c();
                        }
                    };
                    Intrinsics.checkNotNullParameter("RemoteLoggerComponent", "tag");
                    Intrinsics.checkNotNullParameter(runnable, "runnable");
                    try {
                        AbstractC2745l7.b.submit(runnable);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e2) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e2, "event"));
        }
    }

    @Override // com.inmobi.media.N2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof TelemetryConfig) {
            d = (TelemetryConfig) config;
            C2645f7 c2645f7 = b;
            if (c2645f7 != null) {
                c2645f7.g.set(true);
            }
            b = null;
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.Cb$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Cb.a();
                }
            };
            ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            Ie.f2319a.execute(runnable);
            return;
        }
        if (config instanceof CrashConfig) {
            e = (CrashConfig) config;
        }
    }

    public static final void a() {
        b();
    }
}
