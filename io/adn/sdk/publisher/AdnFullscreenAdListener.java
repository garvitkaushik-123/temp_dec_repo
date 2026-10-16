package io.adn.sdk.publisher;

import com.ironsource.C3355vf;
import kotlin.Metadata;

/* compiled from: AdnAdListener.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lio/adn/sdk/publisher/AdnFullscreenAdListener;", "", C3355vf.j, "", "adInfo", "Lio/adn/sdk/publisher/AdnAdInfo;", C3355vf.b, "error", "Lio/adn/sdk/publisher/AdnAdError;", C3355vf.e, "onAdImpression", C3355vf.f, "onAdShown", C3355vf.g, C3355vf.i, "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdnFullscreenAdListener {

    /* compiled from: AdnAdListener.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onAdRewarded(AdnFullscreenAdListener adnFullscreenAdListener, AdnAdInfo adnAdInfo) {
        }
    }

    void onAdClicked(AdnAdInfo adInfo);

    void onAdClosed(AdnAdInfo adInfo);

    void onAdImpression(AdnAdInfo adInfo);

    void onAdLoadFailed(AdnAdError error);

    void onAdLoaded(AdnAdInfo adInfo);

    void onAdRewarded(AdnAdInfo adInfo);

    void onAdShowFailed(AdnAdInfo adInfo, AdnAdError error);

    void onAdShown(AdnAdInfo adInfo);
}
