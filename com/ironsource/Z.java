package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Z implements Y {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3048dc f3151a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3152a = new a();
        public static final int b = 1000;

        private a() {
        }
    }

    public Z(InterfaceC3048dc networkLoadApi) {
        Intrinsics.checkNotNullParameter(networkLoadApi, "networkLoadApi");
        this.f3151a = networkLoadApi;
    }

    @Override // com.ironsource.Y
    public String a() {
        return this.f3151a.a();
    }

    @Override // com.ironsource.Y
    public void a(B9 adInstance, Map<String, String> loadParams) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(loadParams, "loadParams");
        try {
            this.f3151a.a(adInstance, new C3082fc(null, false, 3, null));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.ADAPTER_API.verbose("load ad with identifier: " + adInstance.e() + " failed. error: " + e.getMessage());
            String str = "1000: loadAd failed: " + e.getMessage();
            InterfaceC3268qc b = adInstance.b();
            if (b instanceof C3005b6) {
                InterfaceC3268qc b2 = adInstance.b();
                Intrinsics.checkNotNull(b2, "null cannot be cast to non-null type com.unity3d.ironsourceads.internal.FullScreenAdInstanceListenerWrapper");
                ((C3005b6) b2).onInterstitialLoadFailed(str);
            } else if (b instanceof C3301sc) {
                InterfaceC3268qc b3 = adInstance.b();
                Intrinsics.checkNotNull(b3, "null cannot be cast to non-null type com.unity3d.ironsourceads.internal.OnBannerListenerWrapper");
                ((C3301sc) b3).onBannerLoadFail(str);
            }
        }
    }
}
