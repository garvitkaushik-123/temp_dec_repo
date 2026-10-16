package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.sdk.utils.SDKUtils;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.zd, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3421zd implements InterfaceC3199mb {

    /* renamed from: a, reason: collision with root package name */
    private final RewardedAdRequest f3967a;
    private final RewardedAdLoaderListener b;
    private final InterfaceC3037d1 c;
    private final InterfaceC3223o1 d;

    public C3421zd(RewardedAdRequest adRequest, RewardedAdLoaderListener publisherListener, InterfaceC3037d1 adapterConfigProvider, InterfaceC3223o1 analyticsFactory) {
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        Intrinsics.checkNotNullParameter(publisherListener, "publisherListener");
        Intrinsics.checkNotNullParameter(adapterConfigProvider, "adapterConfigProvider");
        Intrinsics.checkNotNullParameter(analyticsFactory, "analyticsFactory");
        this.f3967a = adRequest;
        this.b = publisherListener;
        this.c = adapterConfigProvider;
        this.d = analyticsFactory;
    }

    @Override // com.ironsource.InterfaceC3199mb
    public InterfaceC3148jb a() throws Exception {
        IronSourceError d;
        String instanceId = this.f3967a.getInstanceId();
        String sDKVersion = SDKUtils.getSDKVersion();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        Intrinsics.checkNotNullExpressionValue(sDKVersion, "getSDKVersion()");
        InterfaceC3240p1 a2 = this.d.a(new C3138j1(sDKVersion, instanceId, ad_unit, false, false, false, 56, null));
        try {
            C3165kb a3 = new C3182lb(this.f3967a.getAdm(), this.f3967a.getProviderName$mediationsdk_release(), this.c, Sb.e.a().c().get()).a();
            new C3387xd(a3).a();
            C3065ec c3065ec = new C3065ec();
            C3173l2 c3173l2 = new C3173l2(this.f3967a.getAdm(), this.f3967a.getProviderName$mediationsdk_release());
            RewardedAdRequest rewardedAdRequest = this.f3967a;
            Intrinsics.checkNotNull(a3);
            R7 r7 = R7.f3025a;
            return new C3370wd(rewardedAdRequest, a3, new C3404yd(r7, this.b), c3173l2, c3065ec, a2, new C3285rd(a2, r7.c()), null, null, 384, null);
        } catch (Exception e) {
            C3260q4.d().a(e);
            if (e instanceof Wd) {
                d = ((Wd) e).a();
            } else {
                C3362w5 c3362w5 = C3362w5.f3920a;
                String message = e.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                d = c3362w5.d(message);
            }
            return new C3396y5(this.f3967a, new C3404yd(R7.f3025a, this.b), a2, d);
        }
    }

    public /* synthetic */ C3421zd(RewardedAdRequest rewardedAdRequest, RewardedAdLoaderListener rewardedAdLoaderListener, InterfaceC3037d1 interfaceC3037d1, InterfaceC3223o1 interfaceC3223o1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rewardedAdRequest, rewardedAdLoaderListener, interfaceC3037d1, (i & 8) != 0 ? new C3206n1(IronSource.AD_UNIT.REWARDED_VIDEO) : interfaceC3223o1);
    }
}
