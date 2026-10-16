package io.adn.sdk.internal.domain.model.ad;

import io.bidmachine.iab.vast.tags.VastTagName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdEntity.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u001a\u001b\u001c\u001dR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0082\u0001\u0004\u001e\u001f !¨\u0006\""}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig;", "", "closeConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "getCloseConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "privacyConfig", "Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "getPrivacyConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "storeConfig", "Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "getStoreConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "ctaConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "getCtaConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "redirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "getRedirectionStrategy", "()Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "displayMode", "Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "getDisplayMode", "()Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "Html", VastTagName.VIDEO, "Image", "PromotedAppCard", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Html;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Image;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$PromotedAppCard;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Video;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface FullscreenAdSceneConfig {
    AdCloseConfig getCloseConfig();

    AdCtaConfig getCtaConfig();

    DisplayMode getDisplayMode();

    AdPrivacyConfig getPrivacyConfig();

    RedirectionStrategy getRedirectionStrategy();

    AdStoreConfig getStoreConfig();

    /* compiled from: FullscreenAdEntity.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\t\u0010+\u001a\u00020\u0011HÆ\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÇ\u0001J\u0013\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010/H×\u0003J\t\u00100\u001a\u000201H×\u0001J\t\u00102\u001a\u000203H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00064"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Html;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig;", "closeConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "privacyConfig", "Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "storeConfig", "Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "ctaConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "redirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "displayMode", "Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "loadingStrategy", "Lio/adn/sdk/internal/domain/model/ad/LoadingStrategy;", "loadingCardEnabled", "", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;Lio/adn/sdk/internal/domain/model/ad/DisplayMode;Lio/adn/sdk/internal/domain/model/ad/LoadingStrategy;Z)V", "getCloseConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "getPrivacyConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "getStoreConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "getCtaConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "getRedirectionStrategy", "()Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "getDisplayMode", "()Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "getLoadingStrategy", "()Lio/adn/sdk/internal/domain/model/ad/LoadingStrategy;", "getLoadingCardEnabled", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Html implements FullscreenAdSceneConfig {
        public static final int $stable = 0;
        private final AdCloseConfig closeConfig;
        private final AdCtaConfig ctaConfig;
        private final DisplayMode displayMode;
        private final boolean loadingCardEnabled;
        private final LoadingStrategy loadingStrategy;
        private final AdPrivacyConfig privacyConfig;
        private final RedirectionStrategy redirectionStrategy;
        private final AdStoreConfig storeConfig;

        public static /* synthetic */ Html copy$default(Html html, AdCloseConfig adCloseConfig, AdPrivacyConfig adPrivacyConfig, AdStoreConfig adStoreConfig, AdCtaConfig adCtaConfig, RedirectionStrategy redirectionStrategy, DisplayMode displayMode, LoadingStrategy loadingStrategy, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                adCloseConfig = html.closeConfig;
            }
            if ((i & 2) != 0) {
                adPrivacyConfig = html.privacyConfig;
            }
            if ((i & 4) != 0) {
                adStoreConfig = html.storeConfig;
            }
            if ((i & 8) != 0) {
                adCtaConfig = html.ctaConfig;
            }
            if ((i & 16) != 0) {
                redirectionStrategy = html.redirectionStrategy;
            }
            if ((i & 32) != 0) {
                displayMode = html.displayMode;
            }
            if ((i & 64) != 0) {
                loadingStrategy = html.loadingStrategy;
            }
            if ((i & 128) != 0) {
                z = html.loadingCardEnabled;
            }
            LoadingStrategy loadingStrategy2 = loadingStrategy;
            boolean z2 = z;
            RedirectionStrategy redirectionStrategy2 = redirectionStrategy;
            DisplayMode displayMode2 = displayMode;
            return html.copy(adCloseConfig, adPrivacyConfig, adStoreConfig, adCtaConfig, redirectionStrategy2, displayMode2, loadingStrategy2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final AdCloseConfig getCloseConfig() {
            return this.closeConfig;
        }

        /* renamed from: component2, reason: from getter */
        public final AdPrivacyConfig getPrivacyConfig() {
            return this.privacyConfig;
        }

        /* renamed from: component3, reason: from getter */
        public final AdStoreConfig getStoreConfig() {
            return this.storeConfig;
        }

        /* renamed from: component4, reason: from getter */
        public final AdCtaConfig getCtaConfig() {
            return this.ctaConfig;
        }

        /* renamed from: component5, reason: from getter */
        public final RedirectionStrategy getRedirectionStrategy() {
            return this.redirectionStrategy;
        }

        /* renamed from: component6, reason: from getter */
        public final DisplayMode getDisplayMode() {
            return this.displayMode;
        }

        /* renamed from: component7, reason: from getter */
        public final LoadingStrategy getLoadingStrategy() {
            return this.loadingStrategy;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getLoadingCardEnabled() {
            return this.loadingCardEnabled;
        }

        public final Html copy(AdCloseConfig closeConfig, AdPrivacyConfig privacyConfig, AdStoreConfig storeConfig, AdCtaConfig ctaConfig, RedirectionStrategy redirectionStrategy, DisplayMode displayMode, LoadingStrategy loadingStrategy, boolean loadingCardEnabled) {
            Intrinsics.checkNotNullParameter(closeConfig, "closeConfig");
            Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
            Intrinsics.checkNotNullParameter(storeConfig, "storeConfig");
            Intrinsics.checkNotNullParameter(ctaConfig, "ctaConfig");
            Intrinsics.checkNotNullParameter(redirectionStrategy, "redirectionStrategy");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(loadingStrategy, "loadingStrategy");
            return new Html(closeConfig, privacyConfig, storeConfig, ctaConfig, redirectionStrategy, displayMode, loadingStrategy, loadingCardEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Html)) {
                return false;
            }
            Html html = (Html) other;
            return Intrinsics.areEqual(this.closeConfig, html.closeConfig) && Intrinsics.areEqual(this.privacyConfig, html.privacyConfig) && Intrinsics.areEqual(this.storeConfig, html.storeConfig) && Intrinsics.areEqual(this.ctaConfig, html.ctaConfig) && this.redirectionStrategy == html.redirectionStrategy && this.displayMode == html.displayMode && this.loadingStrategy == html.loadingStrategy && this.loadingCardEnabled == html.loadingCardEnabled;
        }

        public int hashCode() {
            return (((((((((((((this.closeConfig.hashCode() * 31) + this.privacyConfig.hashCode()) * 31) + this.storeConfig.hashCode()) * 31) + this.ctaConfig.hashCode()) * 31) + this.redirectionStrategy.hashCode()) * 31) + this.displayMode.hashCode()) * 31) + this.loadingStrategy.hashCode()) * 31) + Boolean.hashCode(this.loadingCardEnabled);
        }

        public String toString() {
            return "Html(closeConfig=" + this.closeConfig + ", privacyConfig=" + this.privacyConfig + ", storeConfig=" + this.storeConfig + ", ctaConfig=" + this.ctaConfig + ", redirectionStrategy=" + this.redirectionStrategy + ", displayMode=" + this.displayMode + ", loadingStrategy=" + this.loadingStrategy + ", loadingCardEnabled=" + this.loadingCardEnabled + ')';
        }

        public Html(AdCloseConfig closeConfig, AdPrivacyConfig privacyConfig, AdStoreConfig storeConfig, AdCtaConfig ctaConfig, RedirectionStrategy redirectionStrategy, DisplayMode displayMode, LoadingStrategy loadingStrategy, boolean z) {
            Intrinsics.checkNotNullParameter(closeConfig, "closeConfig");
            Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
            Intrinsics.checkNotNullParameter(storeConfig, "storeConfig");
            Intrinsics.checkNotNullParameter(ctaConfig, "ctaConfig");
            Intrinsics.checkNotNullParameter(redirectionStrategy, "redirectionStrategy");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(loadingStrategy, "loadingStrategy");
            this.closeConfig = closeConfig;
            this.privacyConfig = privacyConfig;
            this.storeConfig = storeConfig;
            this.ctaConfig = ctaConfig;
            this.redirectionStrategy = redirectionStrategy;
            this.displayMode = displayMode;
            this.loadingStrategy = loadingStrategy;
            this.loadingCardEnabled = z;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdCloseConfig getCloseConfig() {
            return this.closeConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdPrivacyConfig getPrivacyConfig() {
            return this.privacyConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdStoreConfig getStoreConfig() {
            return this.storeConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdCtaConfig getCtaConfig() {
            return this.ctaConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public RedirectionStrategy getRedirectionStrategy() {
            return this.redirectionStrategy;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public DisplayMode getDisplayMode() {
            return this.displayMode;
        }

        public final LoadingStrategy getLoadingStrategy() {
            return this.loadingStrategy;
        }

        public final boolean getLoadingCardEnabled() {
            return this.loadingCardEnabled;
        }
    }

    /* compiled from: FullscreenAdEntity.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\u000fHÆ\u0003J\t\u0010/\u001a\u00020\u0011HÆ\u0003J\t\u00100\u001a\u00020\u0013HÆ\u0003Jc\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÇ\u0001J\u0013\u00102\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u000104H×\u0003J\t\u00105\u001a\u000206H×\u0001J\t\u00107\u001a\u000208H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00069"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Video;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig;", "closeConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "privacyConfig", "Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "storeConfig", "Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "ctaConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "redirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "displayMode", "Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "muteConfig", "Lio/adn/sdk/internal/domain/model/ad/AdMuteConfig;", "autoCloseEnabled", "", "progressConfig", "Lio/adn/sdk/internal/domain/model/ad/AdProgressConfig;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;Lio/adn/sdk/internal/domain/model/ad/DisplayMode;Lio/adn/sdk/internal/domain/model/ad/AdMuteConfig;ZLio/adn/sdk/internal/domain/model/ad/AdProgressConfig;)V", "getCloseConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "getPrivacyConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "getStoreConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "getCtaConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "getRedirectionStrategy", "()Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "getDisplayMode", "()Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "getMuteConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdMuteConfig;", "getAutoCloseEnabled", "()Z", "getProgressConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdProgressConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Video implements FullscreenAdSceneConfig {
        public static final int $stable = 0;
        private final boolean autoCloseEnabled;
        private final AdCloseConfig closeConfig;
        private final AdCtaConfig ctaConfig;
        private final DisplayMode displayMode;
        private final AdMuteConfig muteConfig;
        private final AdPrivacyConfig privacyConfig;
        private final AdProgressConfig progressConfig;
        private final RedirectionStrategy redirectionStrategy;
        private final AdStoreConfig storeConfig;

        public static /* synthetic */ Video copy$default(Video video, AdCloseConfig adCloseConfig, AdPrivacyConfig adPrivacyConfig, AdStoreConfig adStoreConfig, AdCtaConfig adCtaConfig, RedirectionStrategy redirectionStrategy, DisplayMode displayMode, AdMuteConfig adMuteConfig, boolean z, AdProgressConfig adProgressConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                adCloseConfig = video.closeConfig;
            }
            if ((i & 2) != 0) {
                adPrivacyConfig = video.privacyConfig;
            }
            if ((i & 4) != 0) {
                adStoreConfig = video.storeConfig;
            }
            if ((i & 8) != 0) {
                adCtaConfig = video.ctaConfig;
            }
            if ((i & 16) != 0) {
                redirectionStrategy = video.redirectionStrategy;
            }
            if ((i & 32) != 0) {
                displayMode = video.displayMode;
            }
            if ((i & 64) != 0) {
                adMuteConfig = video.muteConfig;
            }
            if ((i & 128) != 0) {
                z = video.autoCloseEnabled;
            }
            if ((i & 256) != 0) {
                adProgressConfig = video.progressConfig;
            }
            boolean z2 = z;
            AdProgressConfig adProgressConfig2 = adProgressConfig;
            DisplayMode displayMode2 = displayMode;
            AdMuteConfig adMuteConfig2 = adMuteConfig;
            RedirectionStrategy redirectionStrategy2 = redirectionStrategy;
            AdStoreConfig adStoreConfig2 = adStoreConfig;
            return video.copy(adCloseConfig, adPrivacyConfig, adStoreConfig2, adCtaConfig, redirectionStrategy2, displayMode2, adMuteConfig2, z2, adProgressConfig2);
        }

        /* renamed from: component1, reason: from getter */
        public final AdCloseConfig getCloseConfig() {
            return this.closeConfig;
        }

        /* renamed from: component2, reason: from getter */
        public final AdPrivacyConfig getPrivacyConfig() {
            return this.privacyConfig;
        }

        /* renamed from: component3, reason: from getter */
        public final AdStoreConfig getStoreConfig() {
            return this.storeConfig;
        }

        /* renamed from: component4, reason: from getter */
        public final AdCtaConfig getCtaConfig() {
            return this.ctaConfig;
        }

        /* renamed from: component5, reason: from getter */
        public final RedirectionStrategy getRedirectionStrategy() {
            return this.redirectionStrategy;
        }

        /* renamed from: component6, reason: from getter */
        public final DisplayMode getDisplayMode() {
            return this.displayMode;
        }

        /* renamed from: component7, reason: from getter */
        public final AdMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getAutoCloseEnabled() {
            return this.autoCloseEnabled;
        }

        /* renamed from: component9, reason: from getter */
        public final AdProgressConfig getProgressConfig() {
            return this.progressConfig;
        }

        public final Video copy(AdCloseConfig closeConfig, AdPrivacyConfig privacyConfig, AdStoreConfig storeConfig, AdCtaConfig ctaConfig, RedirectionStrategy redirectionStrategy, DisplayMode displayMode, AdMuteConfig muteConfig, boolean autoCloseEnabled, AdProgressConfig progressConfig) {
            Intrinsics.checkNotNullParameter(closeConfig, "closeConfig");
            Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
            Intrinsics.checkNotNullParameter(storeConfig, "storeConfig");
            Intrinsics.checkNotNullParameter(ctaConfig, "ctaConfig");
            Intrinsics.checkNotNullParameter(redirectionStrategy, "redirectionStrategy");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(muteConfig, "muteConfig");
            Intrinsics.checkNotNullParameter(progressConfig, "progressConfig");
            return new Video(closeConfig, privacyConfig, storeConfig, ctaConfig, redirectionStrategy, displayMode, muteConfig, autoCloseEnabled, progressConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return Intrinsics.areEqual(this.closeConfig, video.closeConfig) && Intrinsics.areEqual(this.privacyConfig, video.privacyConfig) && Intrinsics.areEqual(this.storeConfig, video.storeConfig) && Intrinsics.areEqual(this.ctaConfig, video.ctaConfig) && this.redirectionStrategy == video.redirectionStrategy && this.displayMode == video.displayMode && Intrinsics.areEqual(this.muteConfig, video.muteConfig) && this.autoCloseEnabled == video.autoCloseEnabled && Intrinsics.areEqual(this.progressConfig, video.progressConfig);
        }

        public int hashCode() {
            return (((((((((((((((this.closeConfig.hashCode() * 31) + this.privacyConfig.hashCode()) * 31) + this.storeConfig.hashCode()) * 31) + this.ctaConfig.hashCode()) * 31) + this.redirectionStrategy.hashCode()) * 31) + this.displayMode.hashCode()) * 31) + this.muteConfig.hashCode()) * 31) + Boolean.hashCode(this.autoCloseEnabled)) * 31) + this.progressConfig.hashCode();
        }

        public String toString() {
            return "Video(closeConfig=" + this.closeConfig + ", privacyConfig=" + this.privacyConfig + ", storeConfig=" + this.storeConfig + ", ctaConfig=" + this.ctaConfig + ", redirectionStrategy=" + this.redirectionStrategy + ", displayMode=" + this.displayMode + ", muteConfig=" + this.muteConfig + ", autoCloseEnabled=" + this.autoCloseEnabled + ", progressConfig=" + this.progressConfig + ')';
        }

        public Video(AdCloseConfig closeConfig, AdPrivacyConfig privacyConfig, AdStoreConfig storeConfig, AdCtaConfig ctaConfig, RedirectionStrategy redirectionStrategy, DisplayMode displayMode, AdMuteConfig muteConfig, boolean z, AdProgressConfig progressConfig) {
            Intrinsics.checkNotNullParameter(closeConfig, "closeConfig");
            Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
            Intrinsics.checkNotNullParameter(storeConfig, "storeConfig");
            Intrinsics.checkNotNullParameter(ctaConfig, "ctaConfig");
            Intrinsics.checkNotNullParameter(redirectionStrategy, "redirectionStrategy");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(muteConfig, "muteConfig");
            Intrinsics.checkNotNullParameter(progressConfig, "progressConfig");
            this.closeConfig = closeConfig;
            this.privacyConfig = privacyConfig;
            this.storeConfig = storeConfig;
            this.ctaConfig = ctaConfig;
            this.redirectionStrategy = redirectionStrategy;
            this.displayMode = displayMode;
            this.muteConfig = muteConfig;
            this.autoCloseEnabled = z;
            this.progressConfig = progressConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdCloseConfig getCloseConfig() {
            return this.closeConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdPrivacyConfig getPrivacyConfig() {
            return this.privacyConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdStoreConfig getStoreConfig() {
            return this.storeConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdCtaConfig getCtaConfig() {
            return this.ctaConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public RedirectionStrategy getRedirectionStrategy() {
            return this.redirectionStrategy;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public DisplayMode getDisplayMode() {
            return this.displayMode;
        }

        public final AdMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        public final boolean getAutoCloseEnabled() {
            return this.autoCloseEnabled;
        }

        public final AdProgressConfig getProgressConfig() {
            return this.progressConfig;
        }
    }

    /* compiled from: FullscreenAdEntity.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÇ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H×\u0003J\t\u0010'\u001a\u00020(H×\u0001J\t\u0010)\u001a\u00020*H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Image;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig;", "closeConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "privacyConfig", "Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "storeConfig", "Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "ctaConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "displayMode", "Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "redirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;Lio/adn/sdk/internal/domain/model/ad/DisplayMode;Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;)V", "getCloseConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "getPrivacyConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "getStoreConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "getCtaConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "getDisplayMode", "()Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "getRedirectionStrategy", "()Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Image implements FullscreenAdSceneConfig {
        public static final int $stable = 0;
        private final AdCloseConfig closeConfig;
        private final AdCtaConfig ctaConfig;
        private final DisplayMode displayMode;
        private final AdPrivacyConfig privacyConfig;
        private final RedirectionStrategy redirectionStrategy;
        private final AdStoreConfig storeConfig;

        public static /* synthetic */ Image copy$default(Image image, AdCloseConfig adCloseConfig, AdPrivacyConfig adPrivacyConfig, AdStoreConfig adStoreConfig, AdCtaConfig adCtaConfig, DisplayMode displayMode, RedirectionStrategy redirectionStrategy, int i, Object obj) {
            if ((i & 1) != 0) {
                adCloseConfig = image.closeConfig;
            }
            if ((i & 2) != 0) {
                adPrivacyConfig = image.privacyConfig;
            }
            if ((i & 4) != 0) {
                adStoreConfig = image.storeConfig;
            }
            if ((i & 8) != 0) {
                adCtaConfig = image.ctaConfig;
            }
            if ((i & 16) != 0) {
                displayMode = image.displayMode;
            }
            if ((i & 32) != 0) {
                redirectionStrategy = image.redirectionStrategy;
            }
            DisplayMode displayMode2 = displayMode;
            RedirectionStrategy redirectionStrategy2 = redirectionStrategy;
            return image.copy(adCloseConfig, adPrivacyConfig, adStoreConfig, adCtaConfig, displayMode2, redirectionStrategy2);
        }

        /* renamed from: component1, reason: from getter */
        public final AdCloseConfig getCloseConfig() {
            return this.closeConfig;
        }

        /* renamed from: component2, reason: from getter */
        public final AdPrivacyConfig getPrivacyConfig() {
            return this.privacyConfig;
        }

        /* renamed from: component3, reason: from getter */
        public final AdStoreConfig getStoreConfig() {
            return this.storeConfig;
        }

        /* renamed from: component4, reason: from getter */
        public final AdCtaConfig getCtaConfig() {
            return this.ctaConfig;
        }

        /* renamed from: component5, reason: from getter */
        public final DisplayMode getDisplayMode() {
            return this.displayMode;
        }

        /* renamed from: component6, reason: from getter */
        public final RedirectionStrategy getRedirectionStrategy() {
            return this.redirectionStrategy;
        }

        public final Image copy(AdCloseConfig closeConfig, AdPrivacyConfig privacyConfig, AdStoreConfig storeConfig, AdCtaConfig ctaConfig, DisplayMode displayMode, RedirectionStrategy redirectionStrategy) {
            Intrinsics.checkNotNullParameter(closeConfig, "closeConfig");
            Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
            Intrinsics.checkNotNullParameter(storeConfig, "storeConfig");
            Intrinsics.checkNotNullParameter(ctaConfig, "ctaConfig");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(redirectionStrategy, "redirectionStrategy");
            return new Image(closeConfig, privacyConfig, storeConfig, ctaConfig, displayMode, redirectionStrategy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Image)) {
                return false;
            }
            Image image = (Image) other;
            return Intrinsics.areEqual(this.closeConfig, image.closeConfig) && Intrinsics.areEqual(this.privacyConfig, image.privacyConfig) && Intrinsics.areEqual(this.storeConfig, image.storeConfig) && Intrinsics.areEqual(this.ctaConfig, image.ctaConfig) && this.displayMode == image.displayMode && this.redirectionStrategy == image.redirectionStrategy;
        }

        public int hashCode() {
            return (((((((((this.closeConfig.hashCode() * 31) + this.privacyConfig.hashCode()) * 31) + this.storeConfig.hashCode()) * 31) + this.ctaConfig.hashCode()) * 31) + this.displayMode.hashCode()) * 31) + this.redirectionStrategy.hashCode();
        }

        public String toString() {
            return "Image(closeConfig=" + this.closeConfig + ", privacyConfig=" + this.privacyConfig + ", storeConfig=" + this.storeConfig + ", ctaConfig=" + this.ctaConfig + ", displayMode=" + this.displayMode + ", redirectionStrategy=" + this.redirectionStrategy + ')';
        }

        public Image(AdCloseConfig closeConfig, AdPrivacyConfig privacyConfig, AdStoreConfig storeConfig, AdCtaConfig ctaConfig, DisplayMode displayMode, RedirectionStrategy redirectionStrategy) {
            Intrinsics.checkNotNullParameter(closeConfig, "closeConfig");
            Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
            Intrinsics.checkNotNullParameter(storeConfig, "storeConfig");
            Intrinsics.checkNotNullParameter(ctaConfig, "ctaConfig");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(redirectionStrategy, "redirectionStrategy");
            this.closeConfig = closeConfig;
            this.privacyConfig = privacyConfig;
            this.storeConfig = storeConfig;
            this.ctaConfig = ctaConfig;
            this.displayMode = displayMode;
            this.redirectionStrategy = redirectionStrategy;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdCloseConfig getCloseConfig() {
            return this.closeConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdPrivacyConfig getPrivacyConfig() {
            return this.privacyConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdStoreConfig getStoreConfig() {
            return this.storeConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdCtaConfig getCtaConfig() {
            return this.ctaConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public DisplayMode getDisplayMode() {
            return this.displayMode;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public RedirectionStrategy getRedirectionStrategy() {
            return this.redirectionStrategy;
        }
    }

    /* compiled from: FullscreenAdEntity.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÇ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H×\u0003J\t\u0010'\u001a\u00020(H×\u0001J\t\u0010)\u001a\u00020*H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$PromotedAppCard;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig;", "closeConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "ctaConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "redirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "privacyConfig", "Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "displayMode", "Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "storeConfig", "Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;Lio/adn/sdk/internal/domain/model/ad/DisplayMode;Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;)V", "getCloseConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "getCtaConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "getRedirectionStrategy", "()Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "getPrivacyConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "getDisplayMode", "()Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "getStoreConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class PromotedAppCard implements FullscreenAdSceneConfig {
        public static final int $stable = 0;
        private final AdCloseConfig closeConfig;
        private final AdCtaConfig ctaConfig;
        private final DisplayMode displayMode;
        private final AdPrivacyConfig privacyConfig;
        private final RedirectionStrategy redirectionStrategy;
        private final AdStoreConfig storeConfig;

        public static /* synthetic */ PromotedAppCard copy$default(PromotedAppCard promotedAppCard, AdCloseConfig adCloseConfig, AdCtaConfig adCtaConfig, RedirectionStrategy redirectionStrategy, AdPrivacyConfig adPrivacyConfig, DisplayMode displayMode, AdStoreConfig adStoreConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                adCloseConfig = promotedAppCard.closeConfig;
            }
            if ((i & 2) != 0) {
                adCtaConfig = promotedAppCard.ctaConfig;
            }
            if ((i & 4) != 0) {
                redirectionStrategy = promotedAppCard.redirectionStrategy;
            }
            if ((i & 8) != 0) {
                adPrivacyConfig = promotedAppCard.privacyConfig;
            }
            if ((i & 16) != 0) {
                displayMode = promotedAppCard.displayMode;
            }
            if ((i & 32) != 0) {
                adStoreConfig = promotedAppCard.storeConfig;
            }
            DisplayMode displayMode2 = displayMode;
            AdStoreConfig adStoreConfig2 = adStoreConfig;
            return promotedAppCard.copy(adCloseConfig, adCtaConfig, redirectionStrategy, adPrivacyConfig, displayMode2, adStoreConfig2);
        }

        /* renamed from: component1, reason: from getter */
        public final AdCloseConfig getCloseConfig() {
            return this.closeConfig;
        }

        /* renamed from: component2, reason: from getter */
        public final AdCtaConfig getCtaConfig() {
            return this.ctaConfig;
        }

        /* renamed from: component3, reason: from getter */
        public final RedirectionStrategy getRedirectionStrategy() {
            return this.redirectionStrategy;
        }

        /* renamed from: component4, reason: from getter */
        public final AdPrivacyConfig getPrivacyConfig() {
            return this.privacyConfig;
        }

        /* renamed from: component5, reason: from getter */
        public final DisplayMode getDisplayMode() {
            return this.displayMode;
        }

        /* renamed from: component6, reason: from getter */
        public final AdStoreConfig getStoreConfig() {
            return this.storeConfig;
        }

        public final PromotedAppCard copy(AdCloseConfig closeConfig, AdCtaConfig ctaConfig, RedirectionStrategy redirectionStrategy, AdPrivacyConfig privacyConfig, DisplayMode displayMode, AdStoreConfig storeConfig) {
            Intrinsics.checkNotNullParameter(closeConfig, "closeConfig");
            Intrinsics.checkNotNullParameter(ctaConfig, "ctaConfig");
            Intrinsics.checkNotNullParameter(redirectionStrategy, "redirectionStrategy");
            Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(storeConfig, "storeConfig");
            return new PromotedAppCard(closeConfig, ctaConfig, redirectionStrategy, privacyConfig, displayMode, storeConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PromotedAppCard)) {
                return false;
            }
            PromotedAppCard promotedAppCard = (PromotedAppCard) other;
            return Intrinsics.areEqual(this.closeConfig, promotedAppCard.closeConfig) && Intrinsics.areEqual(this.ctaConfig, promotedAppCard.ctaConfig) && this.redirectionStrategy == promotedAppCard.redirectionStrategy && Intrinsics.areEqual(this.privacyConfig, promotedAppCard.privacyConfig) && this.displayMode == promotedAppCard.displayMode && Intrinsics.areEqual(this.storeConfig, promotedAppCard.storeConfig);
        }

        public int hashCode() {
            return (((((((((this.closeConfig.hashCode() * 31) + this.ctaConfig.hashCode()) * 31) + this.redirectionStrategy.hashCode()) * 31) + this.privacyConfig.hashCode()) * 31) + this.displayMode.hashCode()) * 31) + this.storeConfig.hashCode();
        }

        public String toString() {
            return "PromotedAppCard(closeConfig=" + this.closeConfig + ", ctaConfig=" + this.ctaConfig + ", redirectionStrategy=" + this.redirectionStrategy + ", privacyConfig=" + this.privacyConfig + ", displayMode=" + this.displayMode + ", storeConfig=" + this.storeConfig + ')';
        }

        public PromotedAppCard(AdCloseConfig closeConfig, AdCtaConfig ctaConfig, RedirectionStrategy redirectionStrategy, AdPrivacyConfig privacyConfig, DisplayMode displayMode, AdStoreConfig storeConfig) {
            Intrinsics.checkNotNullParameter(closeConfig, "closeConfig");
            Intrinsics.checkNotNullParameter(ctaConfig, "ctaConfig");
            Intrinsics.checkNotNullParameter(redirectionStrategy, "redirectionStrategy");
            Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(storeConfig, "storeConfig");
            this.closeConfig = closeConfig;
            this.ctaConfig = ctaConfig;
            this.redirectionStrategy = redirectionStrategy;
            this.privacyConfig = privacyConfig;
            this.displayMode = displayMode;
            this.storeConfig = storeConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdCloseConfig getCloseConfig() {
            return this.closeConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdCtaConfig getCtaConfig() {
            return this.ctaConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public RedirectionStrategy getRedirectionStrategy() {
            return this.redirectionStrategy;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdPrivacyConfig getPrivacyConfig() {
            return this.privacyConfig;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public DisplayMode getDisplayMode() {
            return this.displayMode;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig
        public AdStoreConfig getStoreConfig() {
            return this.storeConfig;
        }
    }
}
