package com.inmobi.media;

import android.util.Log;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.adquality.models.AdQualityResult;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.b0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2571b0 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2605d0 f2522a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2571b0(C2605d0 c2605d0) {
        super(0);
        this.f2522a = c2605d0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C2605d0 c2605d0 = this.f2522a;
        c2605d0.getClass();
        Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
        Intrinsics.checkNotNullParameter("beacon handler execute", PglCryptUtils.KEY_MESSAGE);
        Log.i("AdQualityBeaconExecutor", "beacon handler execute");
        c2605d0.b.set(true);
        ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
        Lazy lazy = Nc.f2375a;
        int a2 = T1.a((C2656g0) lazy.getValue(), null, null, 63);
        C2656g0 c2656g0 = (C2656g0) lazy.getValue();
        c2656g0.getClass();
        Log.i("AdQualityDao", "peek");
        List<AdQualityResult> a3 = T1.a(c2656g0, null, null, null, null, null, Integer.valueOf(a2), 31);
        if (a3.isEmpty()) {
            a3 = CollectionsKt.emptyList();
        }
        for (AdQualityResult adQualityResult : a3) {
            if (adQualityResult != null) {
                AdConfig adConfig = c2605d0.f2541a;
                C2956y6 c2956y6 = new C2956y6(adQualityResult, new C2897ue(adConfig.getIncludeIds()), adConfig.getAdQuality());
                C2588c0 onBeaconHit = new C2588c0(c2605d0, adQualityResult);
                Intrinsics.checkNotNullParameter(onBeaconHit, "onBeaconHit");
                Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
                Intrinsics.checkNotNullParameter("hitBeacon", PglCryptUtils.KEY_MESSAGE);
                Log.i("JsonBeaconRequest", "hitBeacon");
                c2956y6.f();
                C2879tc retryPolicy = new C2879tc(c2956y6.z.getMaxRetries(), c2956y6.z.getRetryInterval());
                Intrinsics.checkNotNullParameter(retryPolicy, "retryPolicy");
                c2956y6.w = retryPolicy;
                c2956y6.a(new C2937x6(onBeaconHit));
            }
        }
        c2605d0.c.set(true);
        return Unit.INSTANCE;
    }
}
