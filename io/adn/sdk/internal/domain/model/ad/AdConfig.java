package io.adn.sdk.internal.domain.model.ad;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÇ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001c\u001a\u00020\u001dH×\u0001J\t\u0010\u001e\u001a\u00020\u001fH×\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdConfig;", "", "creativesConfig", "", "Lio/adn/sdk/internal/domain/model/ad/AdCreativeConfig;", "endCardDisplayMode", "Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "promotedAppCardEnabled", "", "promotedAppCardRedirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "<init>", "(Ljava/util/List;Lio/adn/sdk/internal/domain/model/ad/DisplayMode;ZLio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;)V", "getCreativesConfig", "()Ljava/util/List;", "getEndCardDisplayMode", "()Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "getPromotedAppCardEnabled", "()Z", "getPromotedAppCardRedirectionStrategy", "()Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdConfig {
    public static final int $stable = 8;
    private final List<AdCreativeConfig> creativesConfig;
    private final DisplayMode endCardDisplayMode;
    private final boolean promotedAppCardEnabled;
    private final RedirectionStrategy promotedAppCardRedirectionStrategy;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdConfig copy$default(AdConfig adConfig, List list, DisplayMode displayMode, boolean z, RedirectionStrategy redirectionStrategy, int i, Object obj) {
        if ((i & 1) != 0) {
            list = adConfig.creativesConfig;
        }
        if ((i & 2) != 0) {
            displayMode = adConfig.endCardDisplayMode;
        }
        if ((i & 4) != 0) {
            z = adConfig.promotedAppCardEnabled;
        }
        if ((i & 8) != 0) {
            redirectionStrategy = adConfig.promotedAppCardRedirectionStrategy;
        }
        return adConfig.copy(list, displayMode, z, redirectionStrategy);
    }

    public final List<AdCreativeConfig> component1() {
        return this.creativesConfig;
    }

    /* renamed from: component2, reason: from getter */
    public final DisplayMode getEndCardDisplayMode() {
        return this.endCardDisplayMode;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getPromotedAppCardEnabled() {
        return this.promotedAppCardEnabled;
    }

    /* renamed from: component4, reason: from getter */
    public final RedirectionStrategy getPromotedAppCardRedirectionStrategy() {
        return this.promotedAppCardRedirectionStrategy;
    }

    public final AdConfig copy(List<AdCreativeConfig> creativesConfig, DisplayMode endCardDisplayMode, boolean promotedAppCardEnabled, RedirectionStrategy promotedAppCardRedirectionStrategy) {
        Intrinsics.checkNotNullParameter(creativesConfig, "creativesConfig");
        Intrinsics.checkNotNullParameter(endCardDisplayMode, "endCardDisplayMode");
        Intrinsics.checkNotNullParameter(promotedAppCardRedirectionStrategy, "promotedAppCardRedirectionStrategy");
        return new AdConfig(creativesConfig, endCardDisplayMode, promotedAppCardEnabled, promotedAppCardRedirectionStrategy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdConfig)) {
            return false;
        }
        AdConfig adConfig = (AdConfig) other;
        return Intrinsics.areEqual(this.creativesConfig, adConfig.creativesConfig) && this.endCardDisplayMode == adConfig.endCardDisplayMode && this.promotedAppCardEnabled == adConfig.promotedAppCardEnabled && this.promotedAppCardRedirectionStrategy == adConfig.promotedAppCardRedirectionStrategy;
    }

    public int hashCode() {
        return (((((this.creativesConfig.hashCode() * 31) + this.endCardDisplayMode.hashCode()) * 31) + Boolean.hashCode(this.promotedAppCardEnabled)) * 31) + this.promotedAppCardRedirectionStrategy.hashCode();
    }

    public String toString() {
        return "AdConfig(creativesConfig=" + this.creativesConfig + ", endCardDisplayMode=" + this.endCardDisplayMode + ", promotedAppCardEnabled=" + this.promotedAppCardEnabled + ", promotedAppCardRedirectionStrategy=" + this.promotedAppCardRedirectionStrategy + ')';
    }

    public AdConfig(List<AdCreativeConfig> creativesConfig, DisplayMode endCardDisplayMode, boolean z, RedirectionStrategy promotedAppCardRedirectionStrategy) {
        Intrinsics.checkNotNullParameter(creativesConfig, "creativesConfig");
        Intrinsics.checkNotNullParameter(endCardDisplayMode, "endCardDisplayMode");
        Intrinsics.checkNotNullParameter(promotedAppCardRedirectionStrategy, "promotedAppCardRedirectionStrategy");
        this.creativesConfig = creativesConfig;
        this.endCardDisplayMode = endCardDisplayMode;
        this.promotedAppCardEnabled = z;
        this.promotedAppCardRedirectionStrategy = promotedAppCardRedirectionStrategy;
    }

    public final List<AdCreativeConfig> getCreativesConfig() {
        return this.creativesConfig;
    }

    public final DisplayMode getEndCardDisplayMode() {
        return this.endCardDisplayMode;
    }

    public final boolean getPromotedAppCardEnabled() {
        return this.promotedAppCardEnabled;
    }

    public final RedirectionStrategy getPromotedAppCardRedirectionStrategy() {
        return this.promotedAppCardRedirectionStrategy;
    }
}
