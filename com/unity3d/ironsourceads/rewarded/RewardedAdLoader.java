package com.unity3d.ironsourceads.rewarded;

import com.ironsource.C3421zd;
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
public final class RewardedAdLoader {
    public static final RewardedAdLoader INSTANCE = new RewardedAdLoader();

    /* renamed from: a, reason: collision with root package name */
    private static final Executor f6437a = R7.f3025a.c();

    private RewardedAdLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InterfaceC3148jb loadTask) {
        Intrinsics.checkNotNullParameter(loadTask, "$loadTask");
        loadTask.start();
    }

    @JvmStatic
    public static final void loadAd(RewardedAdRequest adRequest, RewardedAdLoaderListener listener) {
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.API.info("instanceId: " + adRequest.getInstanceId());
        INSTANCE.internalLoadAd$mediationsdk_release(f6437a, new C3421zd(adRequest, listener, Sb.e.a(IronSource.AD_UNIT.REWARDED_VIDEO), null, 8, null));
    }

    public final void internalLoadAd$mediationsdk_release(Executor executor, InterfaceC3199mb loadTaskProvider) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(loadTaskProvider, "loadTaskProvider");
        final InterfaceC3148jb a2 = loadTaskProvider.a();
        executor.execute(new Runnable() { // from class: com.unity3d.ironsourceads.rewarded.RewardedAdLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RewardedAdLoader.a(InterfaceC3148jb.this);
            }
        });
    }
}
