package io.adn.sdk.internal.domain.repository;

import io.adn.sdk.internal.domain.model.ad.AttributionSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: InstallReferrerRepository.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/adn/sdk/internal/domain/repository/InstallReferrerRepository;", "", "getInstallReferrer", "Lio/adn/sdk/internal/domain/model/ad/AttributionSource;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface InstallReferrerRepository {
    Object getInstallReferrer(Continuation<? super AttributionSource> continuation);
}
