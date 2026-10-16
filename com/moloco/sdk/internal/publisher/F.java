package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.FullscreenAd;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.publisher.RewardedInterstitialAdShowListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class F implements RewardedInterstitialAd, r, FullscreenAd<RewardedInterstitialAdShowListener> {

    /* renamed from: a, reason: collision with root package name */
    public final u<RewardedInterstitialAdShowListener> f5487a;
    public final String b;

    /* JADX WARN: Multi-variable type inference failed */
    public F(u<? super RewardedInterstitialAdShowListener> fullscreenAd, String adUnitId) {
        Intrinsics.checkNotNullParameter(fullscreenAd, "fullscreenAd");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.f5487a = fullscreenAd;
        this.b = adUnitId;
    }

    public static final com.moloco.sdk.internal.ortb.model.r a(F f) {
        return f.f5487a.c();
    }

    public static final Boolean b(F f) {
        return f.f5487a.e();
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        this.f5487a.destroy();
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.f5487a.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.f5487a.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        this.f5487a.load(bidResponseJson, listener);
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.f5487a.setCreateAdObjectStartTime(j);
    }

    public static final Unit a(RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener, F f, boolean z) {
        rewardedInterstitialAdShowListener.onRewardedVideoCompleted(MolocoAdKt.createAdInfo$default(f.b, null, 2, null));
        return Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.publisher.FullscreenAd
    public void show(RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener) {
        final RewardedInterstitialAdShowListener a2 = G.a(G.a(rewardedInterstitialAdShowListener, new Function0() { // from class: com.moloco.sdk.internal.publisher.F$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return F.a(F.this);
            }
        }), this.f5487a.b() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.f5770a, new Function0() { // from class: com.moloco.sdk.internal.publisher.F$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return F.b(F.this);
            }
        });
        this.f5487a.a(new Function1() { // from class: com.moloco.sdk.internal.publisher.F$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return F.a(RewardedInterstitialAdShowListener.this, this, ((Boolean) obj).booleanValue());
            }
        });
        this.f5487a.show(a2);
    }
}
