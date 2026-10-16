package io.adn.sdk.internal.data.api.local;

import io.adn.sdk.internal.domain.model.privacy.AdvertisingInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: AdvertisingIdsApi.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "", "getAdvertisingInfo", "Lio/adn/sdk/internal/domain/model/privacy/AdvertisingInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdvertisingIdsApi {
    Object getAdvertisingInfo(Continuation<? super AdvertisingInfo> continuation);
}
