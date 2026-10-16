package io.adn.sdk.internal.domain.repository;

import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntity;
import io.adn.sdk.internal.domain.model.ad.NativeAdMetadata;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: NativeAdLoader.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/internal/domain/repository/NativeAdLoader;", "", "loadAdMetadata", "Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;", "bidResponse", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "(Lio/adn/sdk/internal/domain/model/ad/BidResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadNativeAdAssets", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "metadata", "(Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface NativeAdLoader {
    Object loadAdMetadata(BidResponse bidResponse, Continuation<? super NativeAdMetadata> continuation);

    Object loadNativeAdAssets(NativeAdMetadata nativeAdMetadata, Continuation<? super NativeAdEntity> continuation);
}
