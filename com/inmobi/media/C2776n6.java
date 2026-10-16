package com.inmobi.media;

import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.controllers.PublisherCallbacks;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.n6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C2776n6 extends PublisherCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<InMobiInterstitial> f2648a;

    public C2776n6(InMobiInterstitial interstitial) {
        Intrinsics.checkNotNullParameter(interstitial, "interstitial");
        this.f2648a = new WeakReference<>(interstitial);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public byte getType() {
        return (byte) 1;
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdClicked(Map<Object, ? extends Object> params) {
        AbstractC2679h6 mPubListener$media_release;
        Intrinsics.checkNotNullParameter(params, "params");
        InMobiInterstitial inMobiInterstitial = this.f2648a.get();
        if (inMobiInterstitial == null || (mPubListener$media_release = inMobiInterstitial.getMPubListener$media_release()) == null) {
            return;
        }
        mPubListener$media_release.a(inMobiInterstitial, params);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdDismissed() {
        AbstractC2679h6 mPubListener$media_release;
        InMobiInterstitial ad = this.f2648a.get();
        if (ad == null || (mPubListener$media_release = ad.getMPubListener$media_release()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(ad, "ad");
        ((C2695i6) mPubListener$media_release).f2597a.onAdDismissed(ad);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdDisplayFailed() {
        AbstractC2679h6 mPubListener$media_release;
        InMobiInterstitial ad = this.f2648a.get();
        if (ad == null || (mPubListener$media_release = ad.getMPubListener$media_release()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(ad, "ad");
        ((C2695i6) mPubListener$media_release).f2597a.onAdDisplayFailed(ad);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdDisplayed(AdMetaInfo info) {
        AbstractC2679h6 mPubListener$media_release;
        Intrinsics.checkNotNullParameter(info, "info");
        InMobiInterstitial ad = this.f2648a.get();
        if (ad == null || (mPubListener$media_release = ad.getMPubListener$media_release()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(info, "info");
        ((C2695i6) mPubListener$media_release).f2597a.onAdDisplayed(ad, info);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdFetchFailed(InMobiAdRequestStatus status) {
        AbstractC2679h6 mPubListener$media_release;
        Intrinsics.checkNotNullParameter(status, "status");
        InMobiInterstitial ad = this.f2648a.get();
        if (ad == null || (mPubListener$media_release = ad.getMPubListener$media_release()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(status, "status");
        ((C2695i6) mPubListener$media_release).f2597a.onAdFetchFailed(ad, status);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdFetchSuccessful(AdMetaInfo info) {
        AbstractC2679h6 mPubListener$media_release;
        Intrinsics.checkNotNullParameter(info, "info");
        InMobiInterstitial inMobiInterstitial = this.f2648a.get();
        if (inMobiInterstitial == null || (mPubListener$media_release = inMobiInterstitial.getMPubListener$media_release()) == null) {
            return;
        }
        mPubListener$media_release.a(inMobiInterstitial, info);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdImpression(Yd yd) {
        InMobiInterstitial inMobiInterstitial = this.f2648a.get();
        AbstractC2679h6 mPubListener$media_release = inMobiInterstitial != null ? inMobiInterstitial.getMPubListener$media_release() : null;
        if (mPubListener$media_release == null) {
            if (yd != null) {
                yd.c();
            }
        } else {
            mPubListener$media_release.a(inMobiInterstitial);
            if (yd != null) {
                yd.d();
            }
        }
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdLoadFailed(InMobiAdRequestStatus status) {
        AbstractC2679h6 mPubListener$media_release;
        Intrinsics.checkNotNullParameter(status, "status");
        InMobiInterstitial inMobiInterstitial = this.f2648a.get();
        if (inMobiInterstitial == null || (mPubListener$media_release = inMobiInterstitial.getMPubListener$media_release()) == null) {
            return;
        }
        mPubListener$media_release.a(inMobiInterstitial, status);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdLoadSucceeded(AdMetaInfo info) {
        AbstractC2679h6 mPubListener$media_release;
        Intrinsics.checkNotNullParameter(info, "info");
        InMobiInterstitial inMobiInterstitial = this.f2648a.get();
        if (inMobiInterstitial == null || (mPubListener$media_release = inMobiInterstitial.getMPubListener$media_release()) == null) {
            return;
        }
        mPubListener$media_release.b(inMobiInterstitial, info);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdWillDisplay() {
        AbstractC2679h6 mPubListener$media_release;
        InMobiInterstitial ad = this.f2648a.get();
        if (ad == null || (mPubListener$media_release = ad.getMPubListener$media_release()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(ad, "ad");
        ((C2695i6) mPubListener$media_release).f2597a.onAdWillDisplay(ad);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onImraidLog(String log) {
        AbstractC2679h6 mPubListener$media_release;
        Intrinsics.checkNotNullParameter(log, "log");
        InMobiInterstitial inMobiInterstitial = this.f2648a.get();
        if (inMobiInterstitial == null || (mPubListener$media_release = inMobiInterstitial.getMPubListener$media_release()) == null) {
            return;
        }
        mPubListener$media_release.a(inMobiInterstitial, log);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onRequestPayloadCreated(byte[] request) {
        AbstractC2679h6 mPubListener$media_release;
        Intrinsics.checkNotNullParameter(request, "request");
        InMobiInterstitial inMobiInterstitial = this.f2648a.get();
        if (inMobiInterstitial == null || (mPubListener$media_release = inMobiInterstitial.getMPubListener$media_release()) == null) {
            return;
        }
        ((C2695i6) mPubListener$media_release).f2597a.onRequestPayloadCreated(request);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onRequestPayloadCreationFailed(InMobiAdRequestStatus status) {
        AbstractC2679h6 mPubListener$media_release;
        Intrinsics.checkNotNullParameter(status, "reason");
        InMobiInterstitial inMobiInterstitial = this.f2648a.get();
        if (inMobiInterstitial == null || (mPubListener$media_release = inMobiInterstitial.getMPubListener$media_release()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(status, "status");
        ((C2695i6) mPubListener$media_release).f2597a.onRequestPayloadCreationFailed(status);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onRewardsUnlocked(Map<Object, ? extends Object> rewards) {
        AbstractC2679h6 mPubListener$media_release;
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        InMobiInterstitial ad = this.f2648a.get();
        if (ad == null || (mPubListener$media_release = ad.getMPubListener$media_release()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        ((C2695i6) mPubListener$media_release).f2597a.onRewardsUnlocked(ad, rewards);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onUserLeftApplication() {
        AbstractC2679h6 mPubListener$media_release;
        InMobiInterstitial ad = this.f2648a.get();
        if (ad == null || (mPubListener$media_release = ad.getMPubListener$media_release()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(ad, "ad");
        ((C2695i6) mPubListener$media_release).f2597a.onUserLeftApplication(ad);
    }
}
