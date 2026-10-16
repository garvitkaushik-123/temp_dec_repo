package com.inmobi.media;

import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.AudioStatus;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.banner.AudioListener;
import com.inmobi.ads.controllers.PublisherCallbacks;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class O1 extends PublisherCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<InMobiBanner> f2379a;

    public O1(InMobiBanner banner) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        this.f2379a = new WeakReference<>(banner);
    }

    public final WeakReference<InMobiBanner> a() {
        return this.f2379a;
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public byte getType() {
        return (byte) 1;
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdClicked(Map<Object, ? extends Object> params) {
        H1 mPubListener;
        Intrinsics.checkNotNullParameter(params, "params");
        InMobiBanner inMobiBanner = this.f2379a.get();
        if (inMobiBanner == null || (mPubListener = inMobiBanner.getMPubListener()) == null) {
            return;
        }
        mPubListener.a(inMobiBanner, params);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdDismissed() {
        InMobiBanner ad = this.f2379a.get();
        if (ad == null) {
            return;
        }
        H1 mPubListener = ad.getMPubListener();
        if (mPubListener != null) {
            Intrinsics.checkNotNullParameter(ad, "ad");
            ((I1) mPubListener).f2310a.onAdDismissed(ad);
        }
        ad.scheduleRefresh$media_release();
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdDisplayed(AdMetaInfo info) {
        H1 mPubListener;
        Intrinsics.checkNotNullParameter(info, "info");
        InMobiBanner ad = this.f2379a.get();
        if (ad == null || (mPubListener = ad.getMPubListener()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(ad, "ad");
        ((I1) mPubListener).f2310a.onAdDisplayed(ad);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdFetchFailed(InMobiAdRequestStatus status) {
        H1 mPubListener;
        Intrinsics.checkNotNullParameter(status, "status");
        InMobiBanner ad = this.f2379a.get();
        if (ad == null || (mPubListener = ad.getMPubListener()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(status, "status");
        ((I1) mPubListener).f2310a.onAdFetchFailed(ad, status);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdFetchSuccessful(AdMetaInfo info) {
        H1 mPubListener;
        Intrinsics.checkNotNullParameter(info, "info");
        InMobiBanner inMobiBanner = this.f2379a.get();
        if (inMobiBanner == null || (mPubListener = inMobiBanner.getMPubListener()) == null) {
            return;
        }
        mPubListener.a(inMobiBanner, info);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdImpression(Yd yd) {
        InMobiBanner inMobiBanner = this.f2379a.get();
        H1 mPubListener = inMobiBanner != null ? inMobiBanner.getMPubListener() : null;
        if (mPubListener == null) {
            if (yd != null) {
                yd.c();
            }
        } else {
            mPubListener.a(inMobiBanner);
            if (yd != null) {
                yd.d();
            }
        }
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdLoadFailed(InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullExpressionValue("O1", "getSimpleName(...)");
        InMobiBanner inMobiBanner = this.f2379a.get();
        if (inMobiBanner == null) {
            return;
        }
        H1 mPubListener = inMobiBanner.getMPubListener();
        if (mPubListener != null) {
            mPubListener.a(inMobiBanner, status);
        }
        inMobiBanner.scheduleRefresh$media_release();
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAdLoadSucceeded(AdMetaInfo info) {
        R1 mAdManager;
        Intrinsics.checkNotNullParameter(info, "info");
        InMobiBanner inMobiBanner = this.f2379a.get();
        if (inMobiBanner == null || (mAdManager = inMobiBanner.getMAdManager()) == null) {
            return;
        }
        if (!mAdManager.B() && mAdManager.x()) {
            inMobiBanner.swapAdUnitsAndDisplayAd$media_release();
            H1 mPubListener = inMobiBanner.getMPubListener();
            if (mPubListener != null) {
                mPubListener.b(inMobiBanner, info);
            }
            inMobiBanner.scheduleRefresh$media_release();
            return;
        }
        if (mAdManager.B()) {
            S0 j = mAdManager.j();
            if (j != null) {
                j.b((short) 2173);
                return;
            }
            return;
        }
        S0 j2 = mAdManager.j();
        if (j2 != null) {
            j2.b((short) 2174);
        }
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onAudioStatusChanged(D1 item) {
        Intrinsics.checkNotNullParameter(item, "audioStatusInternal");
        InMobiBanner inMobiBanner = this.f2379a.get();
        if (inMobiBanner == null) {
            return;
        }
        inMobiBanner.setAudioStatusInternal$media_release(item);
        AudioListener mAudioListener = inMobiBanner.getMAudioListener();
        if (mAudioListener != null) {
            D1.b.getClass();
            Intrinsics.checkNotNullParameter(item, "item");
            int ordinal = item.ordinal();
            mAudioListener.onAudioStatusChanged(inMobiBanner, ordinal != 1 ? ordinal != 2 ? AudioStatus.COMPLETED : AudioStatus.PAUSED : AudioStatus.PLAYING);
        }
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onImraidLog(String log) {
        H1 mPubListener;
        Intrinsics.checkNotNullParameter(log, "log");
        InMobiBanner inMobiBanner = this.f2379a.get();
        if (inMobiBanner == null || (mPubListener = inMobiBanner.getMPubListener()) == null) {
            return;
        }
        mPubListener.a(inMobiBanner, log);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onRequestPayloadCreated(byte[] request) {
        H1 mPubListener;
        Intrinsics.checkNotNullParameter(request, "request");
        InMobiBanner inMobiBanner = this.f2379a.get();
        if (inMobiBanner == null || (mPubListener = inMobiBanner.getMPubListener()) == null) {
            return;
        }
        ((I1) mPubListener).f2310a.onRequestPayloadCreated(request);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onRequestPayloadCreationFailed(InMobiAdRequestStatus status) {
        H1 mPubListener;
        Intrinsics.checkNotNullParameter(status, "reason");
        InMobiBanner inMobiBanner = this.f2379a.get();
        if (inMobiBanner == null || (mPubListener = inMobiBanner.getMPubListener()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(status, "status");
        ((I1) mPubListener).f2310a.onRequestPayloadCreationFailed(status);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onRewardsUnlocked(Map<Object, ? extends Object> rewards) {
        H1 mPubListener;
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        InMobiBanner ad = this.f2379a.get();
        if (ad == null || (mPubListener = ad.getMPubListener()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        ((I1) mPubListener).f2310a.onRewardsUnlocked(ad, rewards);
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onUserLeftApplication() {
        H1 mPubListener;
        InMobiBanner ad = this.f2379a.get();
        if (ad == null || (mPubListener = ad.getMPubListener()) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(ad, "ad");
        ((I1) mPubListener).f2310a.onUserLeftApplication(ad);
    }

    public final void a(WeakReference<InMobiBanner> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.f2379a = weakReference;
    }
}
