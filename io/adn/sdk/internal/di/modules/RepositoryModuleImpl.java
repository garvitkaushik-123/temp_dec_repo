package io.adn.sdk.internal.di.modules;

import adn.analytics.AdnDataConverter;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryImpl;
import io.adn.sdk.internal.data.repository.InstallReferrerRepositoryImpl;
import io.adn.sdk.internal.data.repository.InstallReferrerStorageImpl;
import io.adn.sdk.internal.data.repository.RemoteDataRepositoryImpl;
import io.adn.sdk.internal.di.SdkInjector;
import io.adn.sdk.internal.domain.repository.BidTokenRepository;
import io.adn.sdk.internal.domain.repository.InstallReferrerRepository;
import io.adn.sdk.internal.domain.repository.InstallReferrerStorage;
import io.adn.sdk.internal.domain.repository.RemoteDataRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: RepositoryModule.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lio/adn/sdk/internal/di/modules/RepositoryModuleImpl;", "Lio/adn/sdk/internal/di/modules/RepositoryModule;", "<init>", "()V", "adnDataConverter", "Ladn/analytics/AdnDataConverter;", "getAdnDataConverter", "()Ladn/analytics/AdnDataConverter;", "adnDataConverter$delegate", "Lkotlin/Lazy;", "bidTokenRepository", "Lio/adn/sdk/internal/domain/repository/BidTokenRepository;", "getBidTokenRepository", "()Lio/adn/sdk/internal/domain/repository/BidTokenRepository;", "bidTokenRepository$delegate", "installReferrerRepository", "Lio/adn/sdk/internal/domain/repository/InstallReferrerRepository;", "getInstallReferrerRepository", "()Lio/adn/sdk/internal/domain/repository/InstallReferrerRepository;", "installReferrerRepository$delegate", "installReferrerStorage", "Lio/adn/sdk/internal/domain/repository/InstallReferrerStorage;", "getInstallReferrerStorage", "()Lio/adn/sdk/internal/domain/repository/InstallReferrerStorage;", "installReferrerStorage$delegate", "remoteDataRepository", "Lio/adn/sdk/internal/domain/repository/RemoteDataRepository;", "getRemoteDataRepository", "()Lio/adn/sdk/internal/domain/repository/RemoteDataRepository;", "remoteDataRepository$delegate", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class RepositoryModuleImpl implements RepositoryModule {
    public static final int $stable = 8;

    /* renamed from: adnDataConverter$delegate, reason: from kotlin metadata */
    private final Lazy adnDataConverter = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.RepositoryModuleImpl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            AdnDataConverter adnDataConverter_delegate$lambda$0;
            adnDataConverter_delegate$lambda$0 = RepositoryModuleImpl.adnDataConverter_delegate$lambda$0();
            return adnDataConverter_delegate$lambda$0;
        }
    });

    /* renamed from: bidTokenRepository$delegate, reason: from kotlin metadata */
    private final Lazy bidTokenRepository = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.RepositoryModuleImpl$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            BidTokenRepositoryImpl bidTokenRepository_delegate$lambda$2;
            bidTokenRepository_delegate$lambda$2 = RepositoryModuleImpl.bidTokenRepository_delegate$lambda$2();
            return bidTokenRepository_delegate$lambda$2;
        }
    });

    /* renamed from: installReferrerRepository$delegate, reason: from kotlin metadata */
    private final Lazy installReferrerRepository = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.RepositoryModuleImpl$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            InstallReferrerRepositoryImpl installReferrerRepository_delegate$lambda$4;
            installReferrerRepository_delegate$lambda$4 = RepositoryModuleImpl.installReferrerRepository_delegate$lambda$4();
            return installReferrerRepository_delegate$lambda$4;
        }
    });

    /* renamed from: installReferrerStorage$delegate, reason: from kotlin metadata */
    private final Lazy installReferrerStorage = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.RepositoryModuleImpl$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            InstallReferrerStorageImpl installReferrerStorage_delegate$lambda$5;
            installReferrerStorage_delegate$lambda$5 = RepositoryModuleImpl.installReferrerStorage_delegate$lambda$5();
            return installReferrerStorage_delegate$lambda$5;
        }
    });

    /* renamed from: remoteDataRepository$delegate, reason: from kotlin metadata */
    private final Lazy remoteDataRepository = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.RepositoryModuleImpl$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            RemoteDataRepositoryImpl remoteDataRepository_delegate$lambda$6;
            remoteDataRepository_delegate$lambda$6 = RepositoryModuleImpl.remoteDataRepository_delegate$lambda$6();
            return remoteDataRepository_delegate$lambda$6;
        }
    });

    @Override // io.adn.sdk.internal.di.modules.RepositoryModule
    public AdnDataConverter getAdnDataConverter() {
        return (AdnDataConverter) this.adnDataConverter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdnDataConverter adnDataConverter_delegate$lambda$0() {
        return new AdnDataConverter();
    }

    @Override // io.adn.sdk.internal.di.modules.RepositoryModule
    public BidTokenRepository getBidTokenRepository() {
        return (BidTokenRepository) this.bidTokenRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BidTokenRepositoryImpl bidTokenRepository_delegate$lambda$2() {
        SdkModule sdkModule = SdkInjector.INSTANCE.getSdkModule();
        return new BidTokenRepositoryImpl(sdkModule.getLocalDataSource(), sdkModule.getNetworkStatusService(), sdkModule.getAdnDataConverter(), sdkModule.createDiagnosticReporter());
    }

    @Override // io.adn.sdk.internal.di.modules.RepositoryModule
    public InstallReferrerRepository getInstallReferrerRepository() {
        return (InstallReferrerRepository) this.installReferrerRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InstallReferrerRepositoryImpl installReferrerRepository_delegate$lambda$4() {
        return new InstallReferrerRepositoryImpl(SdkInjector.INSTANCE.getSdkModule().getAppContext());
    }

    @Override // io.adn.sdk.internal.di.modules.RepositoryModule
    public InstallReferrerStorage getInstallReferrerStorage() {
        return (InstallReferrerStorage) this.installReferrerStorage.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InstallReferrerStorageImpl installReferrerStorage_delegate$lambda$5() {
        return new InstallReferrerStorageImpl(SdkInjector.INSTANCE.getSdkModule().getSharedPreferencesApi());
    }

    @Override // io.adn.sdk.internal.di.modules.RepositoryModule
    public RemoteDataRepository getRemoteDataRepository() {
        return (RemoteDataRepository) this.remoteDataRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteDataRepositoryImpl remoteDataRepository_delegate$lambda$6() {
        return new RemoteDataRepositoryImpl(SdkInjector.INSTANCE.getSdkModule().getRemoteDataSource());
    }
}
