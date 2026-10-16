package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.internal.publisher.h, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3434h implements AdShowListener {

    /* renamed from: a, reason: collision with root package name */
    public final AdShowListener f5512a;

    public C3434h(AdShowListener adShowListener) {
        this.f5512a = adShowListener;
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdClicked(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        AdShowListener adShowListener = this.f5512a;
        if (adShowListener != null) {
            adShowListener.onAdClicked(molocoAd);
        }
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdHidden(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        AdShowListener adShowListener = this.f5512a;
        if (adShowListener != null) {
            adShowListener.onAdHidden(molocoAd);
        }
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowFailed(MolocoAdError molocoAdError) {
        Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
        AdShowListener adShowListener = this.f5512a;
        if (adShowListener != null) {
            adShowListener.onAdShowFailed(molocoAdError);
        }
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowSuccess(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        AdShowListener adShowListener = this.f5512a;
        if (adShowListener != null) {
            adShowListener.onAdShowSuccess(molocoAd);
        }
    }
}
