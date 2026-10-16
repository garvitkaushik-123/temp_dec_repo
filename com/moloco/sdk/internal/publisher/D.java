package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.FullscreenAd;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.InterstitialAdShowListener;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class D implements InterstitialAd, r, FullscreenAd<InterstitialAdShowListener> {

    /* renamed from: a, reason: collision with root package name */
    public final u<InterstitialAdShowListener> f5485a;

    /* JADX WARN: Multi-variable type inference failed */
    public D(u<? super InterstitialAdShowListener> fullscreenAd) {
        Intrinsics.checkNotNullParameter(fullscreenAd, "fullscreenAd");
        this.f5485a = fullscreenAd;
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        this.f5485a.destroy();
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.f5485a.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.f5485a.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        this.f5485a.load(bidResponseJson, listener);
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.f5485a.setCreateAdObjectStartTime(j);
    }

    @Override // com.moloco.sdk.publisher.FullscreenAd
    public void show(InterstitialAdShowListener interstitialAdShowListener) {
        this.f5485a.show(E.a(interstitialAdShowListener));
    }
}
