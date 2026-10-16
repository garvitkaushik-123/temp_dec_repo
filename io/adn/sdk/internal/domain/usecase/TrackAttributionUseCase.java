package io.adn.sdk.internal.domain.usecase;

import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.domain.repository.InstallReferrerRepository;
import io.adn.sdk.internal.domain.repository.InstallReferrerStorage;
import io.adn.sdk.internal.domain.repository.RemoteDataRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: TrackAttributionUseCase.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\f\u001a\u00020\rH\u0086\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/adn/sdk/internal/domain/usecase/TrackAttributionUseCase;", "", "installReferrerRepository", "Lio/adn/sdk/internal/domain/repository/InstallReferrerRepository;", "remoteDataRepository", "Lio/adn/sdk/internal/domain/repository/RemoteDataRepository;", "installReferrerStorage", "Lio/adn/sdk/internal/domain/repository/InstallReferrerStorage;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lio/adn/sdk/internal/domain/repository/InstallReferrerRepository;Lio/adn/sdk/internal/domain/repository/RemoteDataRepository;Lio/adn/sdk/internal/domain/repository/InstallReferrerStorage;Lkotlinx/coroutines/CoroutineScope;)V", "invoke", "", "logError", "error", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class TrackAttributionUseCase {
    public static final int $stable = 8;
    private final InstallReferrerRepository installReferrerRepository;
    private final InstallReferrerStorage installReferrerStorage;
    private final RemoteDataRepository remoteDataRepository;
    private final CoroutineScope scope;

    public TrackAttributionUseCase(InstallReferrerRepository installReferrerRepository, RemoteDataRepository remoteDataRepository, InstallReferrerStorage installReferrerStorage, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(installReferrerRepository, "installReferrerRepository");
        Intrinsics.checkNotNullParameter(remoteDataRepository, "remoteDataRepository");
        Intrinsics.checkNotNullParameter(installReferrerStorage, "installReferrerStorage");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.installReferrerRepository = installReferrerRepository;
        this.remoteDataRepository = remoteDataRepository;
        this.installReferrerStorage = installReferrerStorage;
        this.scope = scope;
    }

    public /* synthetic */ TrackAttributionUseCase(InstallReferrerRepository installReferrerRepository, RemoteDataRepository remoteDataRepository, InstallReferrerStorage installReferrerStorage, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(installReferrerRepository, remoteDataRepository, installReferrerStorage, (i & 8) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()) : coroutineScope);
    }

    public final void invoke() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new TrackAttributionUseCase$invoke$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logError(Throwable error) {
        Logger.INSTANCE.e("TrackAttributionUseCase", error);
    }
}
