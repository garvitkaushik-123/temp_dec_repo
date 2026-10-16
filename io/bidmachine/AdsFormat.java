package io.bidmachine;

import android.text.TextUtils;
import io.bidmachine.banner.BannerSize;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.unified.UnifiedBannerAdRequestParams;
import io.bidmachine.unified.UnifiedFullscreenAdRequestParams;
import io.bidmachine.unified.UnifiedNativeAdRequestParams;

/* loaded from: classes7.dex */
public enum AdsFormat {
    Banner("banner", null, new AdsFormatMatcher<UnifiedBannerAdRequestParams>(AdsType.Banner) { // from class: io.bidmachine.AdsFormat.1
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.bidmachine.AdsFormat.AdsFormatMatcher
        public boolean isMatch(UnifiedBannerAdRequestParams adRequestParams, AdContentType adContentType) {
            return true;
        }
    }),
    Banner_320x50("banner_320x50", Banner, new AdsFormatMatcher<UnifiedBannerAdRequestParams>(AdsType.Banner) { // from class: io.bidmachine.AdsFormat.2
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.bidmachine.AdsFormat.AdsFormatMatcher
        public boolean isMatch(UnifiedBannerAdRequestParams adRequestParams, AdContentType adContentType) {
            return adRequestParams.getAdRequestParameters().getBannerSize() == BannerSize.Size_320x50;
        }
    }),
    Banner_300x250("banner_300x250", Banner, new AdsFormatMatcher<UnifiedBannerAdRequestParams>(AdsType.Banner) { // from class: io.bidmachine.AdsFormat.3
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.bidmachine.AdsFormat.AdsFormatMatcher
        public boolean isMatch(UnifiedBannerAdRequestParams adRequestParams, AdContentType adContentType) {
            return adRequestParams.getAdRequestParameters().getBannerSize() == BannerSize.Size_300x250;
        }
    }),
    Banner_728x90("banner_728x90", Banner, new AdsFormatMatcher<UnifiedBannerAdRequestParams>(AdsType.Banner) { // from class: io.bidmachine.AdsFormat.4
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.bidmachine.AdsFormat.AdsFormatMatcher
        public boolean isMatch(UnifiedBannerAdRequestParams adRequestParams, AdContentType adContentType) {
            return adRequestParams.getAdRequestParameters().getBannerSize() == BannerSize.Size_728x90;
        }
    }),
    Interstitial("interstitial", null, new AdsFormatMatcher<UnifiedFullscreenAdRequestParams>(AdsType.Interstitial) { // from class: io.bidmachine.AdsFormat.5
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.bidmachine.AdsFormat.AdsFormatMatcher
        public boolean isMatch(UnifiedFullscreenAdRequestParams adRequestParams, AdContentType adContentType) {
            return true;
        }
    }),
    InterstitialVideo("interstitial_video", Interstitial, new AdsFormatMatcher<UnifiedFullscreenAdRequestParams>(AdsType.Interstitial) { // from class: io.bidmachine.AdsFormat.6
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.bidmachine.AdsFormat.AdsFormatMatcher
        public boolean isMatch(UnifiedFullscreenAdRequestParams adRequestParams, AdContentType adContentType) {
            return adContentType == AdContentType.Video;
        }
    }),
    InterstitialStatic("interstitial_static", Interstitial, new AdsFormatMatcher<UnifiedFullscreenAdRequestParams>(AdsType.Interstitial) { // from class: io.bidmachine.AdsFormat.7
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.bidmachine.AdsFormat.AdsFormatMatcher
        public boolean isMatch(UnifiedFullscreenAdRequestParams adRequestParams, AdContentType adContentType) {
            return adContentType == AdContentType.Static;
        }
    }),
    Rewarded("rewarded", null, new AdsFormatMatcher<UnifiedFullscreenAdRequestParams>(AdsType.Rewarded) { // from class: io.bidmachine.AdsFormat.8
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.bidmachine.AdsFormat.AdsFormatMatcher
        public boolean isMatch(UnifiedFullscreenAdRequestParams adRequestParams, AdContentType adContentType) {
            return true;
        }
    }),
    RewardedVideo("rewarded_video", Rewarded, new AdsFormatMatcher<UnifiedFullscreenAdRequestParams>(AdsType.Rewarded) { // from class: io.bidmachine.AdsFormat.9
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.bidmachine.AdsFormat.AdsFormatMatcher
        public boolean isMatch(UnifiedFullscreenAdRequestParams adRequestParams, AdContentType adContentType) {
            return adContentType == AdContentType.Video;
        }
    }),
    RewardedStatic("rewarded_static", Rewarded, new AdsFormatMatcher<UnifiedFullscreenAdRequestParams>(AdsType.Rewarded) { // from class: io.bidmachine.AdsFormat.10
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.bidmachine.AdsFormat.AdsFormatMatcher
        public boolean isMatch(UnifiedFullscreenAdRequestParams adRequestParams, AdContentType adContentType) {
            return adContentType == AdContentType.Static;
        }
    }),
    Native("native", null, new AdsFormatMatcher<UnifiedNativeAdRequestParams>(AdsType.Native) { // from class: io.bidmachine.AdsFormat.11
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.bidmachine.AdsFormat.AdsFormatMatcher
        public boolean isMatch(UnifiedNativeAdRequestParams adRequestParams, AdContentType adContentType) {
            return true;
        }
    });

    private final AdsFormatMatcher matcher;
    private final AdsFormat parent;
    private final String remoteName;

    AdsFormat(String remoteName, AdsFormat parent, AdsFormatMatcher matcher) {
        this.remoteName = remoteName;
        this.parent = parent;
        this.matcher = matcher;
    }

    public String getRemoteName() {
        return this.remoteName;
    }

    public AdsFormat getParent() {
        return this.parent;
    }

    public AdsType getAdsType() {
        return this.matcher.adsType;
    }

    <T extends UnifiedAdRequestParams> boolean isMatch(AdsType adsType, T adRequestParams, AdContentType adContentType) {
        return this.matcher.isMatch(adsType, adRequestParams, adContentType);
    }

    public static AdsFormat byRemoteName(String name) {
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        for (AdsFormat adsFormat : values()) {
            if (adsFormat.remoteName.equals(name)) {
                return adsFormat;
            }
        }
        return null;
    }

    private static abstract class AdsFormatMatcher<T extends UnifiedAdRequestParams> {
        private final AdsType adsType;

        abstract boolean isMatch(T adRequestParams, AdContentType adContentType);

        AdsFormatMatcher(AdsType adsType) {
            this.adsType = adsType;
        }

        final boolean isMatch(AdsType adsType, T adRequestParams, AdContentType adContentType) {
            return adsType == this.adsType && isMatch(adRequestParams, adContentType);
        }
    }
}
