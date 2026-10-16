package com.inmobi.media;

import android.util.Log;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.d0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2605d0 {

    /* renamed from: a, reason: collision with root package name */
    public AdConfig f2541a;
    public final AtomicBoolean b;
    public final AtomicBoolean c;
    public final HashMap d;

    public C2605d0(AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        this.f2541a = adConfig;
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.d = new HashMap();
        Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
        Intrinsics.checkNotNullParameter("adding listener to dao", PglCryptUtils.KEY_MESSAGE);
        Log.i("AdQualityBeaconExecutor", "adding listener to dao");
        Uc.a(new Runnable() { // from class: com.inmobi.media.d0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2605d0.a(C2605d0.this);
            }
        });
    }

    public static final void a(C2605d0 queueUpdateListener) {
        Intrinsics.checkNotNullParameter(queueUpdateListener, "this$0");
        ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
        C2656g0 c2656g0 = (C2656g0) Nc.f2375a.getValue();
        c2656g0.getClass();
        Intrinsics.checkNotNullParameter(queueUpdateListener, "queueUpdateListener");
        c2656g0.b = queueUpdateListener;
    }

    public final void a() {
        if (this.b.get()) {
            Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
            Intrinsics.checkNotNullParameter("executor already started. ignore.", PglCryptUtils.KEY_MESSAGE);
            Log.i("AdQualityBeaconExecutor", "executor already started. ignore.");
        } else {
            if (!this.f2541a.getAdQuality().getEnabled()) {
                Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
                Intrinsics.checkNotNullParameter("kill switch encountered. skip", PglCryptUtils.KEY_MESSAGE);
                Log.i("AdQualityBeaconExecutor", "kill switch encountered. skip");
                return;
            }
            Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
            Intrinsics.checkNotNullParameter("beacon executor starting", PglCryptUtils.KEY_MESSAGE);
            Log.i("AdQualityBeaconExecutor", "beacon executor starting");
            C2571b0 execute = new C2571b0(this);
            Intrinsics.checkNotNullParameter(execute, "execute");
            ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
            C2638f0.a(new C2587c(execute));
        }
    }
}
