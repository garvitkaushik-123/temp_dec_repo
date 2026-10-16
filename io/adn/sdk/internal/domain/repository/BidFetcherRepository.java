package io.adn.sdk.internal.domain.repository;

import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: BidFetcherRepository.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/internal/domain/repository/BidFetcherRepository;", "", "parseBidPayload", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "bidPayload", "", "(Lio/adn/sdk/publisher/AdnAdPlacement;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchBidFromNetwork", "(Lio/adn/sdk/publisher/AdnAdPlacement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface BidFetcherRepository {
    Object fetchBidFromNetwork(AdnAdPlacement adnAdPlacement, Continuation<? super String> continuation);

    Object parseBidPayload(AdnAdPlacement adnAdPlacement, String str, Continuation<? super BidResponse> continuation);
}
