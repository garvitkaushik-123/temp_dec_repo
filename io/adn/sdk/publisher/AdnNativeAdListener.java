package io.adn.sdk.publisher;

import com.ironsource.C3355vf;
import kotlin.Metadata;

/* compiled from: AdnAdListener.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\r"}, d2 = {"Lio/adn/sdk/publisher/AdnNativeAdListener;", "", C3355vf.j, "", "adInfo", "Lio/adn/sdk/publisher/AdnAdInfo;", "onAdMetadataLoaded", C3355vf.b, "error", "Lio/adn/sdk/publisher/AdnAdError;", C3355vf.e, "onAdImpression", C3355vf.f, "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdnNativeAdListener {
    void onAdClicked(AdnAdInfo adInfo);

    void onAdImpression(AdnAdInfo adInfo);

    void onAdLoadFailed(AdnAdError error);

    void onAdLoaded(AdnAdInfo adInfo);

    void onAdMetadataLoaded(AdnAdInfo adInfo);

    void onAdShowFailed(AdnAdInfo adInfo, AdnAdError error);
}
