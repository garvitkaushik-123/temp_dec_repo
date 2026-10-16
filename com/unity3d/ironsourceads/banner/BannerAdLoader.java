package com.unity3d.ironsourceads.banner;

import com.ironsource.C3090g3;
import com.ironsource.InterfaceC3148jb;
import com.ironsource.InterfaceC3199mb;
import com.ironsource.R7;
import com.ironsource.Sb;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.concurrent.Executor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class BannerAdLoader {
    public static final BannerAdLoader INSTANCE = new BannerAdLoader();

    /* renamed from: a, reason: collision with root package name */
    private static final Executor f6426a = R7.f3025a.c();

    private BannerAdLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InterfaceC3148jb loadTask) {
        Intrinsics.checkNotNullParameter(loadTask, "$loadTask");
        loadTask.start();
    }

    @JvmStatic
    public static final void loadAd(BannerAdRequest adRequest, BannerAdLoaderListener listener) {
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.API.info("instanceId: " + adRequest.getInstanceId());
        INSTANCE.internalLoadAd$mediationsdk_release(f6426a, new C3090g3(adRequest, listener, Sb.e.a(IronSource.AD_UNIT.BANNER), null, 8, null));
    }

    public final void internalLoadAd$mediationsdk_release(Executor executor, InterfaceC3199mb loadTaskProvider) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(loadTaskProvider, "loadTaskProvider");
        final InterfaceC3148jb a2 = loadTaskProvider.a();
        executor.execute(new Runnable() { // from class: com.unity3d.ironsourceads.banner.BannerAdLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BannerAdLoader.a(InterfaceC3148jb.this);
            }
        });
    }
}
