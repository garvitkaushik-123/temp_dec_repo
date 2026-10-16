package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.data.api.remote.RemoteDataSource;
import io.adn.sdk.internal.domain.repository.RemoteDataRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoteDataRepositoryImpl.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/internal/data/repository/RemoteDataRepositoryImpl;", "Lio/adn/sdk/internal/domain/repository/RemoteDataRepository;", "remoteDataSource", "Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "<init>", "(Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;)V", "triggerAdnAttributionCallback", "", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class RemoteDataRepositoryImpl implements RemoteDataRepository {
    public static final int $stable = 8;
    private final RemoteDataSource remoteDataSource;

    public RemoteDataRepositoryImpl(RemoteDataSource remoteDataSource) {
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        this.remoteDataSource = remoteDataSource;
    }

    @Override // io.adn.sdk.internal.domain.repository.RemoteDataRepository
    public Object triggerAdnAttributionCallback(String str, Continuation<? super Unit> continuation) {
        Object triggerAdnInstallAttributionCallback = this.remoteDataSource.triggerAdnInstallAttributionCallback(str, continuation);
        return triggerAdnInstallAttributionCallback == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? triggerAdnInstallAttributionCallback : Unit.INSTANCE;
    }
}
