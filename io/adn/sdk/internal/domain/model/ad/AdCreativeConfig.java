package io.adn.sdk.internal.domain.model.ad;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\t\u00103\u001a\u00020\rHÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\t\u00106\u001a\u00020\u0013HÆ\u0003J\t\u00107\u001a\u00020\u0015HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003Jw\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0005HÇ\u0001J\u0013\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010<\u001a\u00020\u0003H×\u0001J\t\u0010=\u001a\u00020>H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001c¨\u0006?"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdCreativeConfig;", "", FirebaseAnalytics.Param.INDEX, "", "autoCloseEnabled", "", "closeConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "muteConfig", "Lio/adn/sdk/internal/domain/model/ad/AdMuteConfig;", "privacyConfig", "Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "ctaConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "progressbarConfig", "Lio/adn/sdk/internal/domain/model/ad/AdProgressConfig;", "storeOverlayConfig", "Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "redirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "loadingStrategy", "Lio/adn/sdk/internal/domain/model/ad/LoadingStrategy;", "loadingCardEnabled", "<init>", "(IZLio/adn/sdk/internal/domain/model/ad/AdCloseConfig;Lio/adn/sdk/internal/domain/model/ad/AdMuteConfig;Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;Lio/adn/sdk/internal/domain/model/ad/AdProgressConfig;Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;Lio/adn/sdk/internal/domain/model/ad/LoadingStrategy;Z)V", "getIndex", "()I", "getAutoCloseEnabled", "()Z", "getCloseConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "getMuteConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdMuteConfig;", "getPrivacyConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "getCtaConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "getProgressbarConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdProgressConfig;", "getStoreOverlayConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "getRedirectionStrategy", "()Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "getLoadingStrategy", "()Lio/adn/sdk/internal/domain/model/ad/LoadingStrategy;", "getLoadingCardEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdCreativeConfig {
    public static final int $stable = 0;
    private final boolean autoCloseEnabled;
    private final AdCloseConfig closeConfig;
    private final AdCtaConfig ctaConfig;
    private final int index;
    private final boolean loadingCardEnabled;
    private final LoadingStrategy loadingStrategy;
    private final AdMuteConfig muteConfig;
    private final AdPrivacyConfig privacyConfig;
    private final AdProgressConfig progressbarConfig;
    private final RedirectionStrategy redirectionStrategy;
    private final AdStoreConfig storeOverlayConfig;

    public static /* synthetic */ AdCreativeConfig copy$default(AdCreativeConfig adCreativeConfig, int i, boolean z, AdCloseConfig adCloseConfig, AdMuteConfig adMuteConfig, AdPrivacyConfig adPrivacyConfig, AdCtaConfig adCtaConfig, AdProgressConfig adProgressConfig, AdStoreConfig adStoreConfig, RedirectionStrategy redirectionStrategy, LoadingStrategy loadingStrategy, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = adCreativeConfig.index;
        }
        if ((i2 & 2) != 0) {
            z = adCreativeConfig.autoCloseEnabled;
        }
        if ((i2 & 4) != 0) {
            adCloseConfig = adCreativeConfig.closeConfig;
        }
        if ((i2 & 8) != 0) {
            adMuteConfig = adCreativeConfig.muteConfig;
        }
        if ((i2 & 16) != 0) {
            adPrivacyConfig = adCreativeConfig.privacyConfig;
        }
        if ((i2 & 32) != 0) {
            adCtaConfig = adCreativeConfig.ctaConfig;
        }
        if ((i2 & 64) != 0) {
            adProgressConfig = adCreativeConfig.progressbarConfig;
        }
        if ((i2 & 128) != 0) {
            adStoreConfig = adCreativeConfig.storeOverlayConfig;
        }
        if ((i2 & 256) != 0) {
            redirectionStrategy = adCreativeConfig.redirectionStrategy;
        }
        if ((i2 & 512) != 0) {
            loadingStrategy = adCreativeConfig.loadingStrategy;
        }
        if ((i2 & 1024) != 0) {
            z2 = adCreativeConfig.loadingCardEnabled;
        }
        LoadingStrategy loadingStrategy2 = loadingStrategy;
        boolean z3 = z2;
        AdStoreConfig adStoreConfig2 = adStoreConfig;
        RedirectionStrategy redirectionStrategy2 = redirectionStrategy;
        AdCtaConfig adCtaConfig2 = adCtaConfig;
        AdProgressConfig adProgressConfig2 = adProgressConfig;
        AdPrivacyConfig adPrivacyConfig2 = adPrivacyConfig;
        AdCloseConfig adCloseConfig2 = adCloseConfig;
        return adCreativeConfig.copy(i, z, adCloseConfig2, adMuteConfig, adPrivacyConfig2, adCtaConfig2, adProgressConfig2, adStoreConfig2, redirectionStrategy2, loadingStrategy2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component10, reason: from getter */
    public final LoadingStrategy getLoadingStrategy() {
        return this.loadingStrategy;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getLoadingCardEnabled() {
        return this.loadingCardEnabled;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getAutoCloseEnabled() {
        return this.autoCloseEnabled;
    }

    /* renamed from: component3, reason: from getter */
    public final AdCloseConfig getCloseConfig() {
        return this.closeConfig;
    }

    /* renamed from: component4, reason: from getter */
    public final AdMuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    /* renamed from: component5, reason: from getter */
    public final AdPrivacyConfig getPrivacyConfig() {
        return this.privacyConfig;
    }

    /* renamed from: component6, reason: from getter */
    public final AdCtaConfig getCtaConfig() {
        return this.ctaConfig;
    }

    /* renamed from: component7, reason: from getter */
    public final AdProgressConfig getProgressbarConfig() {
        return this.progressbarConfig;
    }

    /* renamed from: component8, reason: from getter */
    public final AdStoreConfig getStoreOverlayConfig() {
        return this.storeOverlayConfig;
    }

    /* renamed from: component9, reason: from getter */
    public final RedirectionStrategy getRedirectionStrategy() {
        return this.redirectionStrategy;
    }

    public final AdCreativeConfig copy(int index, boolean autoCloseEnabled, AdCloseConfig closeConfig, AdMuteConfig muteConfig, AdPrivacyConfig privacyConfig, AdCtaConfig ctaConfig, AdProgressConfig progressbarConfig, AdStoreConfig storeOverlayConfig, RedirectionStrategy redirectionStrategy, LoadingStrategy loadingStrategy, boolean loadingCardEnabled) {
        Intrinsics.checkNotNullParameter(closeConfig, "closeConfig");
        Intrinsics.checkNotNullParameter(muteConfig, "muteConfig");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Intrinsics.checkNotNullParameter(ctaConfig, "ctaConfig");
        Intrinsics.checkNotNullParameter(progressbarConfig, "progressbarConfig");
        Intrinsics.checkNotNullParameter(storeOverlayConfig, "storeOverlayConfig");
        Intrinsics.checkNotNullParameter(redirectionStrategy, "redirectionStrategy");
        Intrinsics.checkNotNullParameter(loadingStrategy, "loadingStrategy");
        return new AdCreativeConfig(index, autoCloseEnabled, closeConfig, muteConfig, privacyConfig, ctaConfig, progressbarConfig, storeOverlayConfig, redirectionStrategy, loadingStrategy, loadingCardEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdCreativeConfig)) {
            return false;
        }
        AdCreativeConfig adCreativeConfig = (AdCreativeConfig) other;
        return this.index == adCreativeConfig.index && this.autoCloseEnabled == adCreativeConfig.autoCloseEnabled && Intrinsics.areEqual(this.closeConfig, adCreativeConfig.closeConfig) && Intrinsics.areEqual(this.muteConfig, adCreativeConfig.muteConfig) && Intrinsics.areEqual(this.privacyConfig, adCreativeConfig.privacyConfig) && Intrinsics.areEqual(this.ctaConfig, adCreativeConfig.ctaConfig) && Intrinsics.areEqual(this.progressbarConfig, adCreativeConfig.progressbarConfig) && Intrinsics.areEqual(this.storeOverlayConfig, adCreativeConfig.storeOverlayConfig) && this.redirectionStrategy == adCreativeConfig.redirectionStrategy && this.loadingStrategy == adCreativeConfig.loadingStrategy && this.loadingCardEnabled == adCreativeConfig.loadingCardEnabled;
    }

    public int hashCode() {
        return (((((((((((((((((((Integer.hashCode(this.index) * 31) + Boolean.hashCode(this.autoCloseEnabled)) * 31) + this.closeConfig.hashCode()) * 31) + this.muteConfig.hashCode()) * 31) + this.privacyConfig.hashCode()) * 31) + this.ctaConfig.hashCode()) * 31) + this.progressbarConfig.hashCode()) * 31) + this.storeOverlayConfig.hashCode()) * 31) + this.redirectionStrategy.hashCode()) * 31) + this.loadingStrategy.hashCode()) * 31) + Boolean.hashCode(this.loadingCardEnabled);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AdCreativeConfig(index=");
        sb.append(this.index).append(", autoCloseEnabled=").append(this.autoCloseEnabled).append(", closeConfig=").append(this.closeConfig).append(", muteConfig=").append(this.muteConfig).append(", privacyConfig=").append(this.privacyConfig).append(", ctaConfig=").append(this.ctaConfig).append(", progressbarConfig=").append(this.progressbarConfig).append(", storeOverlayConfig=").append(this.storeOverlayConfig).append(", redirectionStrategy=").append(this.redirectionStrategy).append(", loadingStrategy=").append(this.loadingStrategy).append(", loadingCardEnabled=").append(this.loadingCardEnabled).append(')');
        return sb.toString();
    }

    public AdCreativeConfig(int i, boolean z, AdCloseConfig closeConfig, AdMuteConfig muteConfig, AdPrivacyConfig privacyConfig, AdCtaConfig ctaConfig, AdProgressConfig progressbarConfig, AdStoreConfig storeOverlayConfig, RedirectionStrategy redirectionStrategy, LoadingStrategy loadingStrategy, boolean z2) {
        Intrinsics.checkNotNullParameter(closeConfig, "closeConfig");
        Intrinsics.checkNotNullParameter(muteConfig, "muteConfig");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Intrinsics.checkNotNullParameter(ctaConfig, "ctaConfig");
        Intrinsics.checkNotNullParameter(progressbarConfig, "progressbarConfig");
        Intrinsics.checkNotNullParameter(storeOverlayConfig, "storeOverlayConfig");
        Intrinsics.checkNotNullParameter(redirectionStrategy, "redirectionStrategy");
        Intrinsics.checkNotNullParameter(loadingStrategy, "loadingStrategy");
        this.index = i;
        this.autoCloseEnabled = z;
        this.closeConfig = closeConfig;
        this.muteConfig = muteConfig;
        this.privacyConfig = privacyConfig;
        this.ctaConfig = ctaConfig;
        this.progressbarConfig = progressbarConfig;
        this.storeOverlayConfig = storeOverlayConfig;
        this.redirectionStrategy = redirectionStrategy;
        this.loadingStrategy = loadingStrategy;
        this.loadingCardEnabled = z2;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean getAutoCloseEnabled() {
        return this.autoCloseEnabled;
    }

    public final AdCloseConfig getCloseConfig() {
        return this.closeConfig;
    }

    public final AdMuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    public final AdPrivacyConfig getPrivacyConfig() {
        return this.privacyConfig;
    }

    public final AdCtaConfig getCtaConfig() {
        return this.ctaConfig;
    }

    public final AdProgressConfig getProgressbarConfig() {
        return this.progressbarConfig;
    }

    public final AdStoreConfig getStoreOverlayConfig() {
        return this.storeOverlayConfig;
    }

    public final RedirectionStrategy getRedirectionStrategy() {
        return this.redirectionStrategy;
    }

    public final LoadingStrategy getLoadingStrategy() {
        return this.loadingStrategy;
    }

    public final boolean getLoadingCardEnabled() {
        return this.loadingCardEnabled;
    }
}
