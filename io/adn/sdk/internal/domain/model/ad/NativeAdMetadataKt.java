package io.adn.sdk.internal.domain.model.ad;

import io.adn.sdk.publisher.AdnAdInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdMetadata.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toAdInfo", "Lio/adn/sdk/publisher/AdnAdInfo;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeAdMetadataKt {
    public static final AdnAdInfo toAdInfo(NativeAdMetadata nativeAdMetadata) {
        Intrinsics.checkNotNullParameter(nativeAdMetadata, "<this>");
        return new AdnAdInfo(nativeAdMetadata.getExtra().getCreativeId(), null, nativeAdMetadata.getExtra().getCampaignId(), nativeAdMetadata.getExtra().getPrice(), nativeAdMetadata.getExtra().getId(), 2, null);
    }
}
