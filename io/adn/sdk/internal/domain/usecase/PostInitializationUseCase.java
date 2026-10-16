package io.adn.sdk.internal.domain.usecase;

import io.adn.sdk.internal.domain.model.config.SdkParameterKey;
import io.adn.sdk.internal.domain.repository.ExternalDataSource;
import io.adn.sdk.internal.domain.repository.StorageRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PostInitializationUseCase.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/domain/usecase/PostInitializationUseCase;", "", "initializeAdMeasurementUseCase", "Lio/adn/sdk/internal/domain/usecase/InitializeAdMeasurementUseCase;", "trackAttributionUseCase", "Lio/adn/sdk/internal/domain/usecase/TrackAttributionUseCase;", "storageRepository", "Lio/adn/sdk/internal/domain/repository/StorageRepository;", "externalDataSource", "Lio/adn/sdk/internal/domain/repository/ExternalDataSource;", "<init>", "(Lio/adn/sdk/internal/domain/usecase/InitializeAdMeasurementUseCase;Lio/adn/sdk/internal/domain/usecase/TrackAttributionUseCase;Lio/adn/sdk/internal/domain/repository/StorageRepository;Lio/adn/sdk/internal/domain/repository/ExternalDataSource;)V", "invoke", "Lkotlin/Result;", "", "invoke-d1pmJ48", "()Ljava/lang/Object;", "trackInstallAttributionIfEnabled", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PostInitializationUseCase {
    public static final int $stable = 8;
    private final ExternalDataSource externalDataSource;
    private final InitializeAdMeasurementUseCase initializeAdMeasurementUseCase;
    private final StorageRepository storageRepository;
    private final TrackAttributionUseCase trackAttributionUseCase;

    public PostInitializationUseCase(InitializeAdMeasurementUseCase initializeAdMeasurementUseCase, TrackAttributionUseCase trackAttributionUseCase, StorageRepository storageRepository, ExternalDataSource externalDataSource) {
        Intrinsics.checkNotNullParameter(initializeAdMeasurementUseCase, "initializeAdMeasurementUseCase");
        Intrinsics.checkNotNullParameter(trackAttributionUseCase, "trackAttributionUseCase");
        Intrinsics.checkNotNullParameter(storageRepository, "storageRepository");
        Intrinsics.checkNotNullParameter(externalDataSource, "externalDataSource");
        this.initializeAdMeasurementUseCase = initializeAdMeasurementUseCase;
        this.trackAttributionUseCase = trackAttributionUseCase;
        this.storageRepository = storageRepository;
        this.externalDataSource = externalDataSource;
    }

    /* renamed from: invoke-d1pmJ48, reason: not valid java name */
    public final Object m9509invoked1pmJ48() {
        try {
            Result.Companion companion = Result.INSTANCE;
            PostInitializationUseCase postInitializationUseCase = this;
            this.initializeAdMeasurementUseCase.invoke();
            this.storageRepository.cleanup();
            trackInstallAttributionIfEnabled();
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final void trackInstallAttributionIfEnabled() {
        if (((Boolean) this.externalDataSource.getSdkParameter(SdkParameterKey.ENABLE_SELF_ATTRIBUTION_TRACKING, false)).booleanValue()) {
            this.trackAttributionUseCase.invoke();
        }
    }
}
