package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.AdObject;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: AdRepository.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/unity3d/ads/core/data/repository/AdRepository;", "", "addAd", "", "opportunityId", "Lcom/google/protobuf/ByteString;", "adObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "enqueueOpportunityForPlacement", "placementId", "", "getAd", "getAllAds", "", "hasOpportunityId", "", "pollOpportunityIdForPlacement", "removeAd", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdRepository {
    void addAd(ByteString opportunityId, AdObject adObject);

    void enqueueOpportunityForPlacement(String placementId, ByteString opportunityId);

    AdObject getAd(ByteString opportunityId);

    Map<ByteString, AdObject> getAllAds();

    boolean hasOpportunityId(ByteString opportunityId);

    ByteString pollOpportunityIdForPlacement(String placementId);

    void removeAd(ByteString opportunityId);
}
