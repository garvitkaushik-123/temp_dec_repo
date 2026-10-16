package io.adn.sdk.internal.domain.model.ad;

import io.adn.sdk.internal.domain.model.ad.AdLink;
import io.adn.sdk.internal.thirdparty.omsdk.model.AdMeasurementVerificationResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdMetadata.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BA\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÇ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010 \u001a\u00020!H×\u0001J\t\u0010\"\u001a\u00020\bH×\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006#"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;", "", "assets", "", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata;", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Native;", "impressionTrackers", "", "extra", "Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "adMeasurementVerificationResources", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementVerificationResource;", "<init>", "(Ljava/util/List;Lio/adn/sdk/internal/domain/model/ad/AdLink$Native;Ljava/util/List;Lio/adn/sdk/internal/domain/model/ad/BidExtra;Ljava/util/List;)V", "getAssets", "()Ljava/util/List;", "getLink", "()Lio/adn/sdk/internal/domain/model/ad/AdLink$Native;", "getImpressionTrackers", "getExtra", "()Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "getAdMeasurementVerificationResources", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class NativeAdMetadata {
    public static final int $stable = 8;
    private final List<AdMeasurementVerificationResource> adMeasurementVerificationResources;
    private final List<NativeAdAssetMetadata> assets;
    private final BidExtra extra;
    private final List<String> impressionTrackers;
    private final AdLink.Native link;

    public static /* synthetic */ NativeAdMetadata copy$default(NativeAdMetadata nativeAdMetadata, List list, AdLink.Native r2, List list2, BidExtra bidExtra, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = nativeAdMetadata.assets;
        }
        if ((i & 2) != 0) {
            r2 = nativeAdMetadata.link;
        }
        if ((i & 4) != 0) {
            list2 = nativeAdMetadata.impressionTrackers;
        }
        if ((i & 8) != 0) {
            bidExtra = nativeAdMetadata.extra;
        }
        if ((i & 16) != 0) {
            list3 = nativeAdMetadata.adMeasurementVerificationResources;
        }
        List list4 = list3;
        List list5 = list2;
        return nativeAdMetadata.copy(list, r2, list5, bidExtra, list4);
    }

    public final List<NativeAdAssetMetadata> component1() {
        return this.assets;
    }

    /* renamed from: component2, reason: from getter */
    public final AdLink.Native getLink() {
        return this.link;
    }

    public final List<String> component3() {
        return this.impressionTrackers;
    }

    /* renamed from: component4, reason: from getter */
    public final BidExtra getExtra() {
        return this.extra;
    }

    public final List<AdMeasurementVerificationResource> component5() {
        return this.adMeasurementVerificationResources;
    }

    public final NativeAdMetadata copy(List<? extends NativeAdAssetMetadata> assets, AdLink.Native link, List<String> impressionTrackers, BidExtra extra, List<AdMeasurementVerificationResource> adMeasurementVerificationResources) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(impressionTrackers, "impressionTrackers");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(adMeasurementVerificationResources, "adMeasurementVerificationResources");
        return new NativeAdMetadata(assets, link, impressionTrackers, extra, adMeasurementVerificationResources);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeAdMetadata)) {
            return false;
        }
        NativeAdMetadata nativeAdMetadata = (NativeAdMetadata) other;
        return Intrinsics.areEqual(this.assets, nativeAdMetadata.assets) && Intrinsics.areEqual(this.link, nativeAdMetadata.link) && Intrinsics.areEqual(this.impressionTrackers, nativeAdMetadata.impressionTrackers) && Intrinsics.areEqual(this.extra, nativeAdMetadata.extra) && Intrinsics.areEqual(this.adMeasurementVerificationResources, nativeAdMetadata.adMeasurementVerificationResources);
    }

    public int hashCode() {
        return (((((((this.assets.hashCode() * 31) + this.link.hashCode()) * 31) + this.impressionTrackers.hashCode()) * 31) + this.extra.hashCode()) * 31) + this.adMeasurementVerificationResources.hashCode();
    }

    public String toString() {
        return "NativeAdMetadata(assets=" + this.assets + ", link=" + this.link + ", impressionTrackers=" + this.impressionTrackers + ", extra=" + this.extra + ", adMeasurementVerificationResources=" + this.adMeasurementVerificationResources + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NativeAdMetadata(List<? extends NativeAdAssetMetadata> assets, AdLink.Native link, List<String> impressionTrackers, BidExtra extra, List<AdMeasurementVerificationResource> adMeasurementVerificationResources) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(impressionTrackers, "impressionTrackers");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(adMeasurementVerificationResources, "adMeasurementVerificationResources");
        this.assets = assets;
        this.link = link;
        this.impressionTrackers = impressionTrackers;
        this.extra = extra;
        this.adMeasurementVerificationResources = adMeasurementVerificationResources;
    }

    public final List<NativeAdAssetMetadata> getAssets() {
        return this.assets;
    }

    public final AdLink.Native getLink() {
        return this.link;
    }

    public final List<String> getImpressionTrackers() {
        return this.impressionTrackers;
    }

    public final BidExtra getExtra() {
        return this.extra;
    }

    public final List<AdMeasurementVerificationResource> getAdMeasurementVerificationResources() {
        return this.adMeasurementVerificationResources;
    }
}
