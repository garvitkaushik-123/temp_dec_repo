package com.inmobi.media;

import android.app.Activity;
import android.util.Log;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.adquality.models.AdQualityResult;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.f0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2638f0 implements N2 {

    /* renamed from: a, reason: collision with root package name */
    public static ScheduledExecutorService f2564a;
    public static ExecutorService b;
    public static final Lazy c;
    public static C2605d0 d;
    public static AdConfig e;

    static {
        C2638f0 c2638f0 = new C2638f0();
        c = LazyKt.lazy(C2622e0.f2553a);
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, Uc.b(), c2638f0);
        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
        e = (AdConfig) a2;
    }

    public static void a(long j, final C2604d execute) {
        Intrinsics.checkNotNullParameter(execute, "execute");
        ScheduledExecutorService scheduledExecutorService = f2564a;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5, new K5("AdQualityComponent-aqHandler"));
            Intrinsics.checkNotNullExpressionValue(newScheduledThreadPool, "newScheduledThreadPool(...)");
            f2564a = newScheduledThreadPool;
        }
        ScheduledExecutorService scheduledExecutorService2 = f2564a;
        if (scheduledExecutorService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aqHandlerExecutor");
            scheduledExecutorService2 = null;
        }
        scheduledExecutorService2.schedule(new Runnable() { // from class: com.inmobi.media.f0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2638f0.b(Function0.this);
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public static final void b(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static void a(final C2587c execute) {
        Intrinsics.checkNotNullParameter(execute, "execute");
        ExecutorService executorService = b;
        if (executorService == null || executorService.isShutdown()) {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new K5("AdQualityComponent-aqBeacon"));
            Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
            b = newSingleThreadExecutor;
        }
        ExecutorService executorService2 = b;
        if (executorService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aqBeaconExecutor");
            executorService2 = null;
        }
        executorService2.submit(new Runnable() { // from class: com.inmobi.media.f0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C2638f0.a(Function0.this);
            }
        });
    }

    public static final void a(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // com.inmobi.media.N2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof AdConfig) {
            AdConfig adConfig = (AdConfig) config;
            e = adConfig;
            C2605d0 c2605d0 = d;
            if (c2605d0 != null) {
                Intrinsics.checkNotNullParameter(adConfig, "adConfig");
                c2605d0.f2541a = adConfig;
                if (!c2605d0.b.get()) {
                    if (adConfig.getAdQuality().getEnabled()) {
                        c2605d0.a();
                        return;
                    }
                    return;
                }
                if (!c2605d0.b.get() || adConfig.getAdQuality().getEnabled()) {
                    return;
                }
                Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                Intrinsics.checkNotNullParameter("kill switch encountered. shut down.", PglCryptUtils.KEY_MESSAGE);
                Log.i("AdQualityBeaconExecutor", "kill switch encountered. shut down.");
                c2605d0.b.set(false);
                ExecutorService executorService = b;
                if (executorService != null) {
                    executorService.shutdown();
                    try {
                        try {
                            executorService.shutdownNow();
                        } catch (InterruptedException unused) {
                            executorService.shutdownNow();
                            Thread.currentThread().interrupt();
                        }
                    } catch (Exception e2) {
                        Intrinsics.checkNotNullParameter("AdQualityComponent", "tag");
                        Intrinsics.checkNotNullParameter("shutdown fail", PglCryptUtils.KEY_MESSAGE);
                        Log.e("AdQualityComponent", "shutdown fail", e2);
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void a(Activity activity, GestureDetectorOnGestureListenerC2634ec renderView, String beaconUrl, boolean z, JSONObject extras, Jb listener) {
        Jb listener2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(beaconUrl, "url");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(listener, "listener");
        C2786o0 adQualityManager = renderView.getAdQualityManager();
        adQualityManager.getClass();
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(beaconUrl, "url");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(listener, "listener");
        C2605d0 c2605d0 = null;
        if (extras.length() > 0 && beaconUrl.length() > 0) {
            adQualityManager.j = beaconUrl;
            adQualityManager.k = extras;
            adQualityManager.a("report ad starting");
            if (z) {
                adQualityManager.a("report ad capture");
                listener2 = listener;
                adQualityManager.a(activity, 0L, true, listener2);
            } else {
                listener2 = listener;
                adQualityManager.a("report ad report");
                adQualityManager.a(new AdQualityResult("", null, beaconUrl, extras.toString()), false);
            }
        } else {
            listener2 = listener;
            listener2.f2327a.c("window.mraidview.broadcastEvent('AdReportFailed')");
            adQualityManager.a((Exception) null, "Incorrect parameters for reporting. url - " + beaconUrl + " , extras - " + extras);
        }
        C2605d0 c2605d02 = d;
        if (c2605d02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
        } else {
            c2605d0 = c2605d02;
        }
        c2605d0.getClass();
        Intrinsics.checkNotNullParameter(beaconUrl, "beaconUrl");
        Intrinsics.checkNotNullParameter(listener2, "listener");
        c2605d0.d.put(beaconUrl, new WeakReference(listener2));
        String creativeID = renderView.getCreativeID();
        if (creativeID.length() > 0) {
            Lazy lazy = c;
            if (((CopyOnWriteArrayList) lazy.getValue()).size() < e.getAdReport().getCridls()) {
                ((CopyOnWriteArrayList) lazy.getValue()).add(creativeID);
            }
        }
    }

    public static void a(GestureDetectorOnGestureListenerC2634ec view, GestureDetectorOnGestureListenerC2634ec renderView, String beaconUrl, boolean z, JSONObject extras, Jb listener) {
        Jb listener2;
        Intrinsics.checkNotNullParameter(view, "adView");
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(beaconUrl, "url");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(listener, "listener");
        C2786o0 adQualityManager = renderView.getAdQualityManager();
        adQualityManager.getClass();
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(beaconUrl, "url");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(listener, "listener");
        C2605d0 c2605d0 = null;
        if (extras.length() > 0 && beaconUrl.length() > 0) {
            adQualityManager.j = beaconUrl;
            adQualityManager.k = extras;
            if (z) {
                listener2 = listener;
                adQualityManager.a(view, 0L, true, listener2);
            } else {
                listener2 = listener;
                adQualityManager.a(new AdQualityResult("", null, beaconUrl, extras.toString()), false);
            }
        } else {
            listener2 = listener;
            listener2.f2327a.c("window.mraidview.broadcastEvent('AdReportFailed')");
            adQualityManager.a((Exception) null, "Incorrect parameters for reporting. url - " + beaconUrl + " , extras - " + extras);
        }
        C2605d0 c2605d02 = d;
        if (c2605d02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
        } else {
            c2605d0 = c2605d02;
        }
        c2605d0.getClass();
        Intrinsics.checkNotNullParameter(beaconUrl, "beaconUrl");
        Intrinsics.checkNotNullParameter(listener2, "listener");
        c2605d0.d.put(beaconUrl, new WeakReference(listener2));
        String creativeID = renderView.getCreativeID();
        if (creativeID.length() > 0) {
            Lazy lazy = c;
            if (((CopyOnWriteArrayList) lazy.getValue()).size() < e.getAdReport().getCridls()) {
                ((CopyOnWriteArrayList) lazy.getValue()).add(creativeID);
            }
        }
    }
}
