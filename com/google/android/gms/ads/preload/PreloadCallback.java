package com.google.android.gms.ads.preload;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface PreloadCallback {
    void onAdsAvailable(PreloadConfiguration preloadConfiguration);

    void onAdsExhausted(PreloadConfiguration preloadConfiguration);
}
