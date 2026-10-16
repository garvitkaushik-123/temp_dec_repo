package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.sdk.utils.SDKUtils;
import com.unity3d.ironsourceads.AdSize;
import com.unity3d.ironsourceads.banner.BannerAdLoaderListener;
import com.unity3d.ironsourceads.banner.BannerAdRequest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.g3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3090g3 implements InterfaceC3199mb {

    /* renamed from: a, reason: collision with root package name */
    private final BannerAdRequest f3311a;
    private final BannerAdLoaderListener b;
    private final InterfaceC3037d1 c;
    private final InterfaceC3223o1 d;

    public C3090g3(BannerAdRequest adRequest, BannerAdLoaderListener publisherListener, InterfaceC3037d1 adapterConfigProvider, InterfaceC3223o1 analyticsFactory) {
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        Intrinsics.checkNotNullParameter(publisherListener, "publisherListener");
        Intrinsics.checkNotNullParameter(adapterConfigProvider, "adapterConfigProvider");
        Intrinsics.checkNotNullParameter(analyticsFactory, "analyticsFactory");
        this.f3311a = adRequest;
        this.b = publisherListener;
        this.c = adapterConfigProvider;
        this.d = analyticsFactory;
    }

    @Override // com.ironsource.InterfaceC3199mb
    public InterfaceC3148jb a() throws Exception {
        IronSourceError a2;
        String instanceId = this.f3311a.getInstanceId();
        String sDKVersion = SDKUtils.getSDKVersion();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        Intrinsics.checkNotNullExpressionValue(sDKVersion, "getSDKVersion()");
        InterfaceC3240p1 a3 = this.d.a(new C3138j1(sDKVersion, instanceId, ad_unit, false, false, false, 56, null));
        try {
            C3165kb a4 = new C3182lb(this.f3311a.getAdm(), this.f3311a.getProviderName$mediationsdk_release(), this.c, Sb.e.a().c().get()).a();
            new C3056e3(a4, this.f3311a.getSize()).a();
            C3065ec c3065ec = new C3065ec();
            C3173l2 c3173l2 = new C3173l2(this.f3311a.getAdm(), this.f3311a.getProviderName$mediationsdk_release());
            BannerAdRequest bannerAdRequest = this.f3311a;
            AdSize size = bannerAdRequest.getSize();
            Intrinsics.checkNotNull(a4);
            R7 r7 = R7.f3025a;
            return new C3039d3(bannerAdRequest, size, c3173l2, a4, c3065ec, a3, new C3073f3(r7, this.b), new F2(a3, r7.c()), null, null, 768, null);
        } catch (Exception e) {
            C3260q4.d().a(e);
            if (e instanceof Wd) {
                a2 = ((Wd) e).a();
            } else {
                C3362w5 c3362w5 = C3362w5.f3920a;
                String message = e.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                a2 = c3362w5.a(message);
            }
            return new C3345v5(a2, new C3073f3(R7.f3025a, this.b), a3);
        }
    }

    public /* synthetic */ C3090g3(BannerAdRequest bannerAdRequest, BannerAdLoaderListener bannerAdLoaderListener, InterfaceC3037d1 interfaceC3037d1, InterfaceC3223o1 interfaceC3223o1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bannerAdRequest, bannerAdLoaderListener, interfaceC3037d1, (i & 8) != 0 ? new C3206n1(IronSource.AD_UNIT.BANNER) : interfaceC3223o1);
    }
}
