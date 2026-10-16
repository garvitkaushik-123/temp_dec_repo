package io.adn.sdk.internal.domain.repository;

import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: BidTokenRepository.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/domain/repository/BidTokenRepository;", "", "buildBidToken", "", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "(Lio/adn/sdk/publisher/AdnAdPlacement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface BidTokenRepository {
    Object buildBidToken(AdnAdPlacement adnAdPlacement, Continuation<? super String> continuation);
}
