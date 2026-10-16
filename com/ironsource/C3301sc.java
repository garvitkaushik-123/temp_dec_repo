package com.ironsource;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.sc, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3301sc implements InterfaceC3284rc {

    /* renamed from: a, reason: collision with root package name */
    private B2 f3694a;
    private WeakReference<D2> b = new WeakReference<>(null);

    public final void a(B2 loadListener) {
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        this.f3694a = loadListener;
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerClick() {
        D2 d2 = this.b.get();
        if (d2 != null) {
            d2.onBannerClick();
        }
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerInitFailed(String str) {
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerInitSuccess() {
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerLoadFail(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        B2 b2 = this.f3694a;
        if (b2 != null) {
            b2.onBannerLoadFail(description);
        }
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerLoadSuccess(B9 adInstance, C3078f8 adContainer) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        B2 b2 = this.f3694a;
        if (b2 != null) {
            b2.onBannerLoadSuccess(adInstance, adContainer);
        }
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerShowSuccess() {
        D2 d2 = this.b.get();
        if (d2 != null) {
            d2.onBannerShowSuccess();
        }
    }

    public final void a(D2 showListener) {
        Intrinsics.checkNotNullParameter(showListener, "showListener");
        this.b = new WeakReference<>(showListener);
    }
}
