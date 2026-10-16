package io.adn.sdk.internal.ui.fullscreen.model;

import androidx.compose.ui.graphics.Color;
import io.adn.sdk.R;
import io.adn.sdk.internal.domain.model.ad.AdCloseConfig;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.bidmachine.iab.vast.tags.VastTagName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdUiState.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u000e\u000f\u0010\u0011R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0004\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState;", "", "promotedAppUiState", "Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "getPromotedAppUiState", "()Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "effectiveCloseConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "getEffectiveCloseConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "effectiveCloseIcon", "", "getEffectiveCloseIcon", "()I", "Html", "Image", VastTagName.VIDEO, "PromotedAppCard", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Html;", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Image;", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$PromotedAppCard;", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Video;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface FullscreenAdSceneUiState {
    AdCloseConfig getEffectiveCloseConfig();

    int getEffectiveCloseIcon();

    PromotedAppUiState getPromotedAppUiState();

    /* compiled from: FullscreenAdUiState.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JI\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÇ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%H×\u0003J\t\u0010&\u001a\u00020\u0007H×\u0001J\t\u0010'\u001a\u00020(H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Html;", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState;", "promotedAppUiState", "Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "effectiveCloseConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "effectiveCloseIcon", "", "asset", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html;", "showLoadingCard", "", "config", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Html;", "<init>", "(Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;ILio/adn/sdk/internal/domain/model/ad/SceneAsset$Html;ZLio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Html;)V", "getPromotedAppUiState", "()Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "getEffectiveCloseConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "getEffectiveCloseIcon", "()I", "getAsset", "()Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html;", "getShowLoadingCard", "()Z", "getConfig", "()Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Html;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Html implements FullscreenAdSceneUiState {
        public static final int $stable = 8;
        private final SceneAsset.Html asset;
        private final FullscreenAdSceneConfig.Html config;
        private final AdCloseConfig effectiveCloseConfig;
        private final int effectiveCloseIcon;
        private final PromotedAppUiState promotedAppUiState;
        private final boolean showLoadingCard;

        public static /* synthetic */ Html copy$default(Html html, PromotedAppUiState promotedAppUiState, AdCloseConfig adCloseConfig, int i, SceneAsset.Html html2, boolean z, FullscreenAdSceneConfig.Html html3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                promotedAppUiState = html.promotedAppUiState;
            }
            if ((i2 & 2) != 0) {
                adCloseConfig = html.effectiveCloseConfig;
            }
            if ((i2 & 4) != 0) {
                i = html.effectiveCloseIcon;
            }
            if ((i2 & 8) != 0) {
                html2 = html.asset;
            }
            if ((i2 & 16) != 0) {
                z = html.showLoadingCard;
            }
            if ((i2 & 32) != 0) {
                html3 = html.config;
            }
            boolean z2 = z;
            FullscreenAdSceneConfig.Html html4 = html3;
            return html.copy(promotedAppUiState, adCloseConfig, i, html2, z2, html4);
        }

        /* renamed from: component1, reason: from getter */
        public final PromotedAppUiState getPromotedAppUiState() {
            return this.promotedAppUiState;
        }

        /* renamed from: component2, reason: from getter */
        public final AdCloseConfig getEffectiveCloseConfig() {
            return this.effectiveCloseConfig;
        }

        /* renamed from: component3, reason: from getter */
        public final int getEffectiveCloseIcon() {
            return this.effectiveCloseIcon;
        }

        /* renamed from: component4, reason: from getter */
        public final SceneAsset.Html getAsset() {
            return this.asset;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getShowLoadingCard() {
            return this.showLoadingCard;
        }

        /* renamed from: component6, reason: from getter */
        public final FullscreenAdSceneConfig.Html getConfig() {
            return this.config;
        }

        public final Html copy(PromotedAppUiState promotedAppUiState, AdCloseConfig effectiveCloseConfig, int effectiveCloseIcon, SceneAsset.Html asset, boolean showLoadingCard, FullscreenAdSceneConfig.Html config) {
            Intrinsics.checkNotNullParameter(effectiveCloseConfig, "effectiveCloseConfig");
            Intrinsics.checkNotNullParameter(config, "config");
            return new Html(promotedAppUiState, effectiveCloseConfig, effectiveCloseIcon, asset, showLoadingCard, config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Html)) {
                return false;
            }
            Html html = (Html) other;
            return Intrinsics.areEqual(this.promotedAppUiState, html.promotedAppUiState) && Intrinsics.areEqual(this.effectiveCloseConfig, html.effectiveCloseConfig) && this.effectiveCloseIcon == html.effectiveCloseIcon && Intrinsics.areEqual(this.asset, html.asset) && this.showLoadingCard == html.showLoadingCard && Intrinsics.areEqual(this.config, html.config);
        }

        public int hashCode() {
            PromotedAppUiState promotedAppUiState = this.promotedAppUiState;
            int hashCode = (((((promotedAppUiState == null ? 0 : promotedAppUiState.hashCode()) * 31) + this.effectiveCloseConfig.hashCode()) * 31) + Integer.hashCode(this.effectiveCloseIcon)) * 31;
            SceneAsset.Html html = this.asset;
            return ((((hashCode + (html != null ? html.hashCode() : 0)) * 31) + Boolean.hashCode(this.showLoadingCard)) * 31) + this.config.hashCode();
        }

        public String toString() {
            return "Html(promotedAppUiState=" + this.promotedAppUiState + ", effectiveCloseConfig=" + this.effectiveCloseConfig + ", effectiveCloseIcon=" + this.effectiveCloseIcon + ", asset=" + this.asset + ", showLoadingCard=" + this.showLoadingCard + ", config=" + this.config + ')';
        }

        public Html(PromotedAppUiState promotedAppUiState, AdCloseConfig effectiveCloseConfig, int i, SceneAsset.Html html, boolean z, FullscreenAdSceneConfig.Html config) {
            Intrinsics.checkNotNullParameter(effectiveCloseConfig, "effectiveCloseConfig");
            Intrinsics.checkNotNullParameter(config, "config");
            this.promotedAppUiState = promotedAppUiState;
            this.effectiveCloseConfig = effectiveCloseConfig;
            this.effectiveCloseIcon = i;
            this.asset = html;
            this.showLoadingCard = z;
            this.config = config;
        }

        public /* synthetic */ Html(PromotedAppUiState promotedAppUiState, AdCloseConfig adCloseConfig, int i, SceneAsset.Html html, boolean z, FullscreenAdSceneConfig.Html html2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(promotedAppUiState, adCloseConfig, i, (i2 & 8) != 0 ? null : html, z, html2);
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public PromotedAppUiState getPromotedAppUiState() {
            return this.promotedAppUiState;
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public AdCloseConfig getEffectiveCloseConfig() {
            return this.effectiveCloseConfig;
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public int getEffectiveCloseIcon() {
            return this.effectiveCloseIcon;
        }

        public final SceneAsset.Html getAsset() {
            return this.asset;
        }

        public final boolean getShowLoadingCard() {
            return this.showLoadingCard;
        }

        public final FullscreenAdSceneConfig.Html getConfig() {
            return this.config;
        }
    }

    /* compiled from: FullscreenAdUiState.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JI\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÇ\u0001J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H×\u0003J\t\u0010%\u001a\u00020\u0007H×\u0001J\t\u0010&\u001a\u00020'H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Image;", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState;", "promotedAppUiState", "Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "effectiveCloseConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "effectiveCloseIcon", "", "isRedirectionEnabled", "", "asset", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Media;", "config", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Image;", "<init>", "(Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;IZLio/adn/sdk/internal/domain/model/ad/SceneAsset$Media;Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Image;)V", "getPromotedAppUiState", "()Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "getEffectiveCloseConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "getEffectiveCloseIcon", "()I", "()Z", "getAsset", "()Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Media;", "getConfig", "()Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Image;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Image implements FullscreenAdSceneUiState {
        public static final int $stable = 8;
        private final SceneAsset.Media asset;
        private final FullscreenAdSceneConfig.Image config;
        private final AdCloseConfig effectiveCloseConfig;
        private final int effectiveCloseIcon;
        private final boolean isRedirectionEnabled;
        private final PromotedAppUiState promotedAppUiState;

        public static /* synthetic */ Image copy$default(Image image, PromotedAppUiState promotedAppUiState, AdCloseConfig adCloseConfig, int i, boolean z, SceneAsset.Media media, FullscreenAdSceneConfig.Image image2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                promotedAppUiState = image.promotedAppUiState;
            }
            if ((i2 & 2) != 0) {
                adCloseConfig = image.effectiveCloseConfig;
            }
            if ((i2 & 4) != 0) {
                i = image.effectiveCloseIcon;
            }
            if ((i2 & 8) != 0) {
                z = image.isRedirectionEnabled;
            }
            if ((i2 & 16) != 0) {
                media = image.asset;
            }
            if ((i2 & 32) != 0) {
                image2 = image.config;
            }
            SceneAsset.Media media2 = media;
            FullscreenAdSceneConfig.Image image3 = image2;
            return image.copy(promotedAppUiState, adCloseConfig, i, z, media2, image3);
        }

        /* renamed from: component1, reason: from getter */
        public final PromotedAppUiState getPromotedAppUiState() {
            return this.promotedAppUiState;
        }

        /* renamed from: component2, reason: from getter */
        public final AdCloseConfig getEffectiveCloseConfig() {
            return this.effectiveCloseConfig;
        }

        /* renamed from: component3, reason: from getter */
        public final int getEffectiveCloseIcon() {
            return this.effectiveCloseIcon;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsRedirectionEnabled() {
            return this.isRedirectionEnabled;
        }

        /* renamed from: component5, reason: from getter */
        public final SceneAsset.Media getAsset() {
            return this.asset;
        }

        /* renamed from: component6, reason: from getter */
        public final FullscreenAdSceneConfig.Image getConfig() {
            return this.config;
        }

        public final Image copy(PromotedAppUiState promotedAppUiState, AdCloseConfig effectiveCloseConfig, int effectiveCloseIcon, boolean isRedirectionEnabled, SceneAsset.Media asset, FullscreenAdSceneConfig.Image config) {
            Intrinsics.checkNotNullParameter(effectiveCloseConfig, "effectiveCloseConfig");
            Intrinsics.checkNotNullParameter(config, "config");
            return new Image(promotedAppUiState, effectiveCloseConfig, effectiveCloseIcon, isRedirectionEnabled, asset, config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Image)) {
                return false;
            }
            Image image = (Image) other;
            return Intrinsics.areEqual(this.promotedAppUiState, image.promotedAppUiState) && Intrinsics.areEqual(this.effectiveCloseConfig, image.effectiveCloseConfig) && this.effectiveCloseIcon == image.effectiveCloseIcon && this.isRedirectionEnabled == image.isRedirectionEnabled && Intrinsics.areEqual(this.asset, image.asset) && Intrinsics.areEqual(this.config, image.config);
        }

        public int hashCode() {
            PromotedAppUiState promotedAppUiState = this.promotedAppUiState;
            int hashCode = (((((((promotedAppUiState == null ? 0 : promotedAppUiState.hashCode()) * 31) + this.effectiveCloseConfig.hashCode()) * 31) + Integer.hashCode(this.effectiveCloseIcon)) * 31) + Boolean.hashCode(this.isRedirectionEnabled)) * 31;
            SceneAsset.Media media = this.asset;
            return ((hashCode + (media != null ? media.hashCode() : 0)) * 31) + this.config.hashCode();
        }

        public String toString() {
            return "Image(promotedAppUiState=" + this.promotedAppUiState + ", effectiveCloseConfig=" + this.effectiveCloseConfig + ", effectiveCloseIcon=" + this.effectiveCloseIcon + ", isRedirectionEnabled=" + this.isRedirectionEnabled + ", asset=" + this.asset + ", config=" + this.config + ')';
        }

        public Image(PromotedAppUiState promotedAppUiState, AdCloseConfig effectiveCloseConfig, int i, boolean z, SceneAsset.Media media, FullscreenAdSceneConfig.Image config) {
            Intrinsics.checkNotNullParameter(effectiveCloseConfig, "effectiveCloseConfig");
            Intrinsics.checkNotNullParameter(config, "config");
            this.promotedAppUiState = promotedAppUiState;
            this.effectiveCloseConfig = effectiveCloseConfig;
            this.effectiveCloseIcon = i;
            this.isRedirectionEnabled = z;
            this.asset = media;
            this.config = config;
        }

        public /* synthetic */ Image(PromotedAppUiState promotedAppUiState, AdCloseConfig adCloseConfig, int i, boolean z, SceneAsset.Media media, FullscreenAdSceneConfig.Image image, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(promotedAppUiState, adCloseConfig, i, z, (i2 & 16) != 0 ? null : media, image);
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public PromotedAppUiState getPromotedAppUiState() {
            return this.promotedAppUiState;
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public AdCloseConfig getEffectiveCloseConfig() {
            return this.effectiveCloseConfig;
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public int getEffectiveCloseIcon() {
            return this.effectiveCloseIcon;
        }

        public final boolean isRedirectionEnabled() {
            return this.isRedirectionEnabled;
        }

        public final SceneAsset.Media getAsset() {
            return this.asset;
        }

        public final FullscreenAdSceneConfig.Image getConfig() {
            return this.config;
        }
    }

    /* compiled from: FullscreenAdUiState.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000eHÆ\u0003JS\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000eHÇ\u0001J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&H×\u0003J\t\u0010'\u001a\u00020\u0007H×\u0001J\t\u0010(\u001a\u00020)H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Video;", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState;", "promotedAppUiState", "Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "effectiveCloseConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "effectiveCloseIcon", "", "isRedirectionEnabled", "", "asset", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Media;", "isMute", "config", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Video;", "<init>", "(Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;IZLio/adn/sdk/internal/domain/model/ad/SceneAsset$Media;ZLio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Video;)V", "getPromotedAppUiState", "()Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "getEffectiveCloseConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "getEffectiveCloseIcon", "()I", "()Z", "getAsset", "()Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Media;", "getConfig", "()Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$Video;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Video implements FullscreenAdSceneUiState {
        public static final int $stable = 8;
        private final SceneAsset.Media asset;
        private final FullscreenAdSceneConfig.Video config;
        private final AdCloseConfig effectiveCloseConfig;
        private final int effectiveCloseIcon;
        private final boolean isMute;
        private final boolean isRedirectionEnabled;
        private final PromotedAppUiState promotedAppUiState;

        public static /* synthetic */ Video copy$default(Video video, PromotedAppUiState promotedAppUiState, AdCloseConfig adCloseConfig, int i, boolean z, SceneAsset.Media media, boolean z2, FullscreenAdSceneConfig.Video video2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                promotedAppUiState = video.promotedAppUiState;
            }
            if ((i2 & 2) != 0) {
                adCloseConfig = video.effectiveCloseConfig;
            }
            if ((i2 & 4) != 0) {
                i = video.effectiveCloseIcon;
            }
            if ((i2 & 8) != 0) {
                z = video.isRedirectionEnabled;
            }
            if ((i2 & 16) != 0) {
                media = video.asset;
            }
            if ((i2 & 32) != 0) {
                z2 = video.isMute;
            }
            if ((i2 & 64) != 0) {
                video2 = video.config;
            }
            boolean z3 = z2;
            FullscreenAdSceneConfig.Video video3 = video2;
            SceneAsset.Media media2 = media;
            int i3 = i;
            return video.copy(promotedAppUiState, adCloseConfig, i3, z, media2, z3, video3);
        }

        /* renamed from: component1, reason: from getter */
        public final PromotedAppUiState getPromotedAppUiState() {
            return this.promotedAppUiState;
        }

        /* renamed from: component2, reason: from getter */
        public final AdCloseConfig getEffectiveCloseConfig() {
            return this.effectiveCloseConfig;
        }

        /* renamed from: component3, reason: from getter */
        public final int getEffectiveCloseIcon() {
            return this.effectiveCloseIcon;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsRedirectionEnabled() {
            return this.isRedirectionEnabled;
        }

        /* renamed from: component5, reason: from getter */
        public final SceneAsset.Media getAsset() {
            return this.asset;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsMute() {
            return this.isMute;
        }

        /* renamed from: component7, reason: from getter */
        public final FullscreenAdSceneConfig.Video getConfig() {
            return this.config;
        }

        public final Video copy(PromotedAppUiState promotedAppUiState, AdCloseConfig effectiveCloseConfig, int effectiveCloseIcon, boolean isRedirectionEnabled, SceneAsset.Media asset, boolean isMute, FullscreenAdSceneConfig.Video config) {
            Intrinsics.checkNotNullParameter(effectiveCloseConfig, "effectiveCloseConfig");
            Intrinsics.checkNotNullParameter(config, "config");
            return new Video(promotedAppUiState, effectiveCloseConfig, effectiveCloseIcon, isRedirectionEnabled, asset, isMute, config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return Intrinsics.areEqual(this.promotedAppUiState, video.promotedAppUiState) && Intrinsics.areEqual(this.effectiveCloseConfig, video.effectiveCloseConfig) && this.effectiveCloseIcon == video.effectiveCloseIcon && this.isRedirectionEnabled == video.isRedirectionEnabled && Intrinsics.areEqual(this.asset, video.asset) && this.isMute == video.isMute && Intrinsics.areEqual(this.config, video.config);
        }

        public int hashCode() {
            PromotedAppUiState promotedAppUiState = this.promotedAppUiState;
            int hashCode = (((((((promotedAppUiState == null ? 0 : promotedAppUiState.hashCode()) * 31) + this.effectiveCloseConfig.hashCode()) * 31) + Integer.hashCode(this.effectiveCloseIcon)) * 31) + Boolean.hashCode(this.isRedirectionEnabled)) * 31;
            SceneAsset.Media media = this.asset;
            return ((((hashCode + (media != null ? media.hashCode() : 0)) * 31) + Boolean.hashCode(this.isMute)) * 31) + this.config.hashCode();
        }

        public String toString() {
            return "Video(promotedAppUiState=" + this.promotedAppUiState + ", effectiveCloseConfig=" + this.effectiveCloseConfig + ", effectiveCloseIcon=" + this.effectiveCloseIcon + ", isRedirectionEnabled=" + this.isRedirectionEnabled + ", asset=" + this.asset + ", isMute=" + this.isMute + ", config=" + this.config + ')';
        }

        public Video(PromotedAppUiState promotedAppUiState, AdCloseConfig effectiveCloseConfig, int i, boolean z, SceneAsset.Media media, boolean z2, FullscreenAdSceneConfig.Video config) {
            Intrinsics.checkNotNullParameter(effectiveCloseConfig, "effectiveCloseConfig");
            Intrinsics.checkNotNullParameter(config, "config");
            this.promotedAppUiState = promotedAppUiState;
            this.effectiveCloseConfig = effectiveCloseConfig;
            this.effectiveCloseIcon = i;
            this.isRedirectionEnabled = z;
            this.asset = media;
            this.isMute = z2;
            this.config = config;
        }

        public /* synthetic */ Video(PromotedAppUiState promotedAppUiState, AdCloseConfig adCloseConfig, int i, boolean z, SceneAsset.Media media, boolean z2, FullscreenAdSceneConfig.Video video, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(promotedAppUiState, adCloseConfig, i, z, (i2 & 16) != 0 ? null : media, z2, video);
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public PromotedAppUiState getPromotedAppUiState() {
            return this.promotedAppUiState;
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public AdCloseConfig getEffectiveCloseConfig() {
            return this.effectiveCloseConfig;
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public int getEffectiveCloseIcon() {
            return this.effectiveCloseIcon;
        }

        public final boolean isRedirectionEnabled() {
            return this.isRedirectionEnabled;
        }

        public final SceneAsset.Media getAsset() {
            return this.asset;
        }

        public final boolean isMute() {
            return this.isMute;
        }

        public final FullscreenAdSceneConfig.Video getConfig() {
            return this.config;
        }
    }

    /* compiled from: FullscreenAdUiState.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b \u0010\u0017J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003JL\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÇ\u0001¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010(H×\u0003J\t\u0010)\u001a\u00020\u0007H×\u0001J\t\u0010*\u001a\u00020+H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$PromotedAppCard;", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState;", "promotedAppUiState", "Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "effectiveCloseConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "effectiveCloseIcon", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "isRedirectionEnabled", "", "config", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$PromotedAppCard;", "<init>", "(Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;IJZLio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$PromotedAppCard;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPromotedAppUiState", "()Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "getEffectiveCloseConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "getEffectiveCloseIcon", "()I", "getBackgroundColor-0d7_KjU", "()J", "J", "()Z", "getConfig", "()Lio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$PromotedAppCard;", "component1", "component2", "component3", "component4", "component4-0d7_KjU", "component5", "component6", "copy", "copy-Bx497Mc", "(Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;IJZLio/adn/sdk/internal/domain/model/ad/FullscreenAdSceneConfig$PromotedAppCard;)Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$PromotedAppCard;", "equals", "other", "", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class PromotedAppCard implements FullscreenAdSceneUiState {
        public static final int $stable = 8;
        private final long backgroundColor;
        private final FullscreenAdSceneConfig.PromotedAppCard config;
        private final AdCloseConfig effectiveCloseConfig;
        private final int effectiveCloseIcon;
        private final boolean isRedirectionEnabled;
        private final PromotedAppUiState promotedAppUiState;

        public /* synthetic */ PromotedAppCard(PromotedAppUiState promotedAppUiState, AdCloseConfig adCloseConfig, int i, long j, boolean z, FullscreenAdSceneConfig.PromotedAppCard promotedAppCard, DefaultConstructorMarker defaultConstructorMarker) {
            this(promotedAppUiState, adCloseConfig, i, j, z, promotedAppCard);
        }

        /* renamed from: copy-Bx497Mc$default, reason: not valid java name */
        public static /* synthetic */ PromotedAppCard m9579copyBx497Mc$default(PromotedAppCard promotedAppCard, PromotedAppUiState promotedAppUiState, AdCloseConfig adCloseConfig, int i, long j, boolean z, FullscreenAdSceneConfig.PromotedAppCard promotedAppCard2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                promotedAppUiState = promotedAppCard.promotedAppUiState;
            }
            if ((i2 & 2) != 0) {
                adCloseConfig = promotedAppCard.effectiveCloseConfig;
            }
            if ((i2 & 4) != 0) {
                i = promotedAppCard.effectiveCloseIcon;
            }
            if ((i2 & 8) != 0) {
                j = promotedAppCard.backgroundColor;
            }
            if ((i2 & 16) != 0) {
                z = promotedAppCard.isRedirectionEnabled;
            }
            if ((i2 & 32) != 0) {
                promotedAppCard2 = promotedAppCard.config;
            }
            long j2 = j;
            int i3 = i;
            return promotedAppCard.m9581copyBx497Mc(promotedAppUiState, adCloseConfig, i3, j2, z, promotedAppCard2);
        }

        /* renamed from: component1, reason: from getter */
        public final PromotedAppUiState getPromotedAppUiState() {
            return this.promotedAppUiState;
        }

        /* renamed from: component2, reason: from getter */
        public final AdCloseConfig getEffectiveCloseConfig() {
            return this.effectiveCloseConfig;
        }

        /* renamed from: component3, reason: from getter */
        public final int getEffectiveCloseIcon() {
            return this.effectiveCloseIcon;
        }

        /* renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
        public final long getBackgroundColor() {
            return this.backgroundColor;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsRedirectionEnabled() {
            return this.isRedirectionEnabled;
        }

        /* renamed from: component6, reason: from getter */
        public final FullscreenAdSceneConfig.PromotedAppCard getConfig() {
            return this.config;
        }

        /* renamed from: copy-Bx497Mc, reason: not valid java name */
        public final PromotedAppCard m9581copyBx497Mc(PromotedAppUiState promotedAppUiState, AdCloseConfig effectiveCloseConfig, int effectiveCloseIcon, long backgroundColor, boolean isRedirectionEnabled, FullscreenAdSceneConfig.PromotedAppCard config) {
            Intrinsics.checkNotNullParameter(promotedAppUiState, "promotedAppUiState");
            Intrinsics.checkNotNullParameter(effectiveCloseConfig, "effectiveCloseConfig");
            Intrinsics.checkNotNullParameter(config, "config");
            return new PromotedAppCard(promotedAppUiState, effectiveCloseConfig, effectiveCloseIcon, backgroundColor, isRedirectionEnabled, config, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PromotedAppCard)) {
                return false;
            }
            PromotedAppCard promotedAppCard = (PromotedAppCard) other;
            return Intrinsics.areEqual(this.promotedAppUiState, promotedAppCard.promotedAppUiState) && Intrinsics.areEqual(this.effectiveCloseConfig, promotedAppCard.effectiveCloseConfig) && this.effectiveCloseIcon == promotedAppCard.effectiveCloseIcon && Color.m4064equalsimpl0(this.backgroundColor, promotedAppCard.backgroundColor) && this.isRedirectionEnabled == promotedAppCard.isRedirectionEnabled && Intrinsics.areEqual(this.config, promotedAppCard.config);
        }

        public int hashCode() {
            return (((((((((this.promotedAppUiState.hashCode() * 31) + this.effectiveCloseConfig.hashCode()) * 31) + Integer.hashCode(this.effectiveCloseIcon)) * 31) + Color.m4070hashCodeimpl(this.backgroundColor)) * 31) + Boolean.hashCode(this.isRedirectionEnabled)) * 31) + this.config.hashCode();
        }

        public String toString() {
            return "PromotedAppCard(promotedAppUiState=" + this.promotedAppUiState + ", effectiveCloseConfig=" + this.effectiveCloseConfig + ", effectiveCloseIcon=" + this.effectiveCloseIcon + ", backgroundColor=" + ((Object) Color.m4071toStringimpl(this.backgroundColor)) + ", isRedirectionEnabled=" + this.isRedirectionEnabled + ", config=" + this.config + ')';
        }

        private PromotedAppCard(PromotedAppUiState promotedAppUiState, AdCloseConfig effectiveCloseConfig, int i, long j, boolean z, FullscreenAdSceneConfig.PromotedAppCard config) {
            Intrinsics.checkNotNullParameter(promotedAppUiState, "promotedAppUiState");
            Intrinsics.checkNotNullParameter(effectiveCloseConfig, "effectiveCloseConfig");
            Intrinsics.checkNotNullParameter(config, "config");
            this.promotedAppUiState = promotedAppUiState;
            this.effectiveCloseConfig = effectiveCloseConfig;
            this.effectiveCloseIcon = i;
            this.backgroundColor = j;
            this.isRedirectionEnabled = z;
            this.config = config;
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public PromotedAppUiState getPromotedAppUiState() {
            return this.promotedAppUiState;
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public AdCloseConfig getEffectiveCloseConfig() {
            return this.effectiveCloseConfig;
        }

        public /* synthetic */ PromotedAppCard(PromotedAppUiState promotedAppUiState, AdCloseConfig adCloseConfig, int i, long j, boolean z, FullscreenAdSceneConfig.PromotedAppCard promotedAppCard, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(promotedAppUiState, adCloseConfig, (i2 & 4) != 0 ? R.drawable.adn_ic_close : i, j, z, promotedAppCard, null);
        }

        @Override // io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState
        public int getEffectiveCloseIcon() {
            return this.effectiveCloseIcon;
        }

        /* renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
        public final long m9582getBackgroundColor0d7_KjU() {
            return this.backgroundColor;
        }

        public final boolean isRedirectionEnabled() {
            return this.isRedirectionEnabled;
        }

        public final FullscreenAdSceneConfig.PromotedAppCard getConfig() {
            return this.config;
        }
    }
}
