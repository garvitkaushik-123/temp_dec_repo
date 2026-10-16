package io.adn.sdk.internal.domain.model.ad;

import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BidResponse.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010\"\u001a\u00020\rHÆ\u0003JN\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÇ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010(\u001a\u00020\u000bH×\u0001J\t\u0010)\u001a\u00020\u0005H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "adm", "", "adConfig", "Lio/adn/sdk/internal/domain/model/ad/AdConfig;", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "orientation", "", "extras", "Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "<init>", "(Lio/adn/sdk/publisher/AdnAdPlacement;Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/AdConfig;Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;Ljava/lang/Integer;Lio/adn/sdk/internal/domain/model/ad/BidExtra;)V", "getPlacement", "()Lio/adn/sdk/publisher/AdnAdPlacement;", "getAdm", "()Ljava/lang/String;", "getAdConfig", "()Lio/adn/sdk/internal/domain/model/ad/AdConfig;", "getPromotedApp", "()Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "getOrientation", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtras", "()Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lio/adn/sdk/publisher/AdnAdPlacement;Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/AdConfig;Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;Ljava/lang/Integer;Lio/adn/sdk/internal/domain/model/ad/BidExtra;)Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "equals", "", "other", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class BidResponse {
    public static final int $stable = 8;
    private final AdConfig adConfig;
    private final String adm;
    private final BidExtra extras;
    private final Integer orientation;
    private final AdnAdPlacement placement;
    private final AdPromotedApp promotedApp;

    public static /* synthetic */ BidResponse copy$default(BidResponse bidResponse, AdnAdPlacement adnAdPlacement, String str, AdConfig adConfig, AdPromotedApp adPromotedApp, Integer num, BidExtra bidExtra, int i, Object obj) {
        if ((i & 1) != 0) {
            adnAdPlacement = bidResponse.placement;
        }
        if ((i & 2) != 0) {
            str = bidResponse.adm;
        }
        if ((i & 4) != 0) {
            adConfig = bidResponse.adConfig;
        }
        if ((i & 8) != 0) {
            adPromotedApp = bidResponse.promotedApp;
        }
        if ((i & 16) != 0) {
            num = bidResponse.orientation;
        }
        if ((i & 32) != 0) {
            bidExtra = bidResponse.extras;
        }
        Integer num2 = num;
        BidExtra bidExtra2 = bidExtra;
        return bidResponse.copy(adnAdPlacement, str, adConfig, adPromotedApp, num2, bidExtra2);
    }

    /* renamed from: component1, reason: from getter */
    public final AdnAdPlacement getPlacement() {
        return this.placement;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAdm() {
        return this.adm;
    }

    /* renamed from: component3, reason: from getter */
    public final AdConfig getAdConfig() {
        return this.adConfig;
    }

    /* renamed from: component4, reason: from getter */
    public final AdPromotedApp getPromotedApp() {
        return this.promotedApp;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getOrientation() {
        return this.orientation;
    }

    /* renamed from: component6, reason: from getter */
    public final BidExtra getExtras() {
        return this.extras;
    }

    public final BidResponse copy(AdnAdPlacement placement, String adm, AdConfig adConfig, AdPromotedApp promotedApp, Integer orientation, BidExtra extras) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return new BidResponse(placement, adm, adConfig, promotedApp, orientation, extras);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BidResponse)) {
            return false;
        }
        BidResponse bidResponse = (BidResponse) other;
        return this.placement == bidResponse.placement && Intrinsics.areEqual(this.adm, bidResponse.adm) && Intrinsics.areEqual(this.adConfig, bidResponse.adConfig) && Intrinsics.areEqual(this.promotedApp, bidResponse.promotedApp) && Intrinsics.areEqual(this.orientation, bidResponse.orientation) && Intrinsics.areEqual(this.extras, bidResponse.extras);
    }

    public int hashCode() {
        int hashCode = ((((this.placement.hashCode() * 31) + this.adm.hashCode()) * 31) + this.adConfig.hashCode()) * 31;
        AdPromotedApp adPromotedApp = this.promotedApp;
        int hashCode2 = (hashCode + (adPromotedApp == null ? 0 : adPromotedApp.hashCode())) * 31;
        Integer num = this.orientation;
        return ((hashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.extras.hashCode();
    }

    public String toString() {
        return "BidResponse(placement=" + this.placement + ", adm=" + this.adm + ", adConfig=" + this.adConfig + ", promotedApp=" + this.promotedApp + ", orientation=" + this.orientation + ", extras=" + this.extras + ')';
    }

    public BidResponse(AdnAdPlacement placement, String adm, AdConfig adConfig, AdPromotedApp adPromotedApp, Integer num, BidExtra extras) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.placement = placement;
        this.adm = adm;
        this.adConfig = adConfig;
        this.promotedApp = adPromotedApp;
        this.orientation = num;
        this.extras = extras;
    }

    public final AdnAdPlacement getPlacement() {
        return this.placement;
    }

    public final String getAdm() {
        return this.adm;
    }

    public final AdConfig getAdConfig() {
        return this.adConfig;
    }

    public final AdPromotedApp getPromotedApp() {
        return this.promotedApp;
    }

    public final Integer getOrientation() {
        return this.orientation;
    }

    public final BidExtra getExtras() {
        return this.extras;
    }
}
