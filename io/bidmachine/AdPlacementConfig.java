package io.bidmachine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdPlacementConfig.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lio/bidmachine/AdPlacementConfig;", "", "adsFormat", "Lio/bidmachine/AdsFormat;", "placementId", "", "customParams", "Lio/bidmachine/CustomParams;", "(Lio/bidmachine/AdsFormat;Ljava/lang/String;Lio/bidmachine/CustomParams;)V", "getAdsFormat", "()Lio/bidmachine/AdsFormat;", "getCustomParams", "()Lio/bidmachine/CustomParams;", "getPlacementId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Builder", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdPlacementConfig {
    private final AdsFormat adsFormat;
    private final CustomParams customParams;
    private final String placementId;

    public static /* synthetic */ AdPlacementConfig copy$default(AdPlacementConfig adPlacementConfig, AdsFormat adsFormat, String str, CustomParams customParams, int i, Object obj) {
        if ((i & 1) != 0) {
            adsFormat = adPlacementConfig.adsFormat;
        }
        if ((i & 2) != 0) {
            str = adPlacementConfig.placementId;
        }
        if ((i & 4) != 0) {
            customParams = adPlacementConfig.customParams;
        }
        return adPlacementConfig.copy(adsFormat, str, customParams);
    }

    /* renamed from: component1, reason: from getter */
    public final AdsFormat getAdsFormat() {
        return this.adsFormat;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPlacementId() {
        return this.placementId;
    }

    /* renamed from: component3, reason: from getter */
    public final CustomParams getCustomParams() {
        return this.customParams;
    }

    public final AdPlacementConfig copy(AdsFormat adsFormat, String placementId, CustomParams customParams) {
        Intrinsics.checkNotNullParameter(adsFormat, "adsFormat");
        return new AdPlacementConfig(adsFormat, placementId, customParams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdPlacementConfig)) {
            return false;
        }
        AdPlacementConfig adPlacementConfig = (AdPlacementConfig) other;
        return this.adsFormat == adPlacementConfig.adsFormat && Intrinsics.areEqual(this.placementId, adPlacementConfig.placementId) && Intrinsics.areEqual(this.customParams, adPlacementConfig.customParams);
    }

    public int hashCode() {
        int hashCode = this.adsFormat.hashCode() * 31;
        String str = this.placementId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        CustomParams customParams = this.customParams;
        return hashCode2 + (customParams != null ? customParams.hashCode() : 0);
    }

    public String toString() {
        return "AdPlacementConfig(adsFormat=" + this.adsFormat + ", placementId=" + this.placementId + ", customParams=" + this.customParams + ')';
    }

    public AdPlacementConfig(AdsFormat adsFormat, String str, CustomParams customParams) {
        Intrinsics.checkNotNullParameter(adsFormat, "adsFormat");
        this.adsFormat = adsFormat;
        this.placementId = str;
        this.customParams = customParams;
    }

    public final AdsFormat getAdsFormat() {
        return this.adsFormat;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final CustomParams getCustomParams() {
        return this.customParams;
    }

    /* compiled from: AdPlacementConfig.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/bidmachine/AdPlacementConfig$Builder;", "", "adsFormat", "Lio/bidmachine/AdsFormat;", "(Lio/bidmachine/AdsFormat;)V", "customParams", "Lio/bidmachine/CustomParams;", "placementId", "", "build", "Lio/bidmachine/AdPlacementConfig;", "withCustomParams", "withPlacementId", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        private final AdsFormat adsFormat;
        private CustomParams customParams;
        private String placementId;

        public Builder(AdsFormat adsFormat) {
            Intrinsics.checkNotNullParameter(adsFormat, "adsFormat");
            this.adsFormat = adsFormat;
        }

        public final Builder withPlacementId(String placementId) {
            this.placementId = placementId;
            return this;
        }

        public final Builder withCustomParams(CustomParams customParams) {
            this.customParams = customParams;
            return this;
        }

        public final AdPlacementConfig build() {
            return new AdPlacementConfig(this.adsFormat, this.placementId, this.customParams);
        }
    }
}
