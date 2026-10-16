package io.adn.sdk.internal.di.modules;

import io.adn.sdk.internal.data.api.local.AdvertisingIdsApi;
import io.adn.sdk.internal.data.api.local.AdvertisingIdsApiImpl;
import io.adn.sdk.internal.data.api.local.AppInfoApi;
import io.adn.sdk.internal.data.api.local.AppInfoApiImpl;
import io.adn.sdk.internal.data.api.local.LocalDataSource;
import io.adn.sdk.internal.data.api.local.LocalDataSourceImpl;
import io.adn.sdk.internal.data.api.local.StorageRepositoryImpl;
import io.adn.sdk.internal.data.api.local.SystemInfoApi;
import io.adn.sdk.internal.data.api.local.SystemInfoApiImpl;
import io.adn.sdk.internal.data.api.remote.RemoteDataSource;
import io.adn.sdk.internal.data.repository.DeviceMetricsRepositoryImpl;
import io.adn.sdk.internal.di.SdkInjector;
import io.adn.sdk.internal.domain.repository.DeviceMetricsRepository;
import io.adn.sdk.internal.domain.repository.StorageRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: DataSourceModule.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lio/adn/sdk/internal/di/modules/DataSourceModuleImpl;", "Lio/adn/sdk/internal/di/modules/DataSourceModule;", "<init>", "()V", "advertisingIdsApi", "Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "getAdvertisingIdsApi", "()Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "advertisingIdsApi$delegate", "Lkotlin/Lazy;", "systemInfoApi", "Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "getSystemInfoApi", "()Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "systemInfoApi$delegate", "appInfoApi", "Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "getAppInfoApi", "()Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "appInfoApi$delegate", "storageRepository", "Lio/adn/sdk/internal/domain/repository/StorageRepository;", "getStorageRepository", "()Lio/adn/sdk/internal/domain/repository/StorageRepository;", "storageRepository$delegate", "localDataSource", "Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "getLocalDataSource", "()Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "localDataSource$delegate", "remoteDataSource", "Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "getRemoteDataSource", "()Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "remoteDataSource$delegate", "deviceMetricsRepository", "Lio/adn/sdk/internal/domain/repository/DeviceMetricsRepository;", "getDeviceMetricsRepository", "()Lio/adn/sdk/internal/domain/repository/DeviceMetricsRepository;", "deviceMetricsRepository$delegate", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DataSourceModuleImpl implements DataSourceModule {
    public static final int $stable = 8;

    /* renamed from: advertisingIdsApi$delegate, reason: from kotlin metadata */
    private final Lazy advertisingIdsApi = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.DataSourceModuleImpl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            AdvertisingIdsApiImpl advertisingIdsApi_delegate$lambda$1;
            advertisingIdsApi_delegate$lambda$1 = DataSourceModuleImpl.advertisingIdsApi_delegate$lambda$1();
            return advertisingIdsApi_delegate$lambda$1;
        }
    });

    /* renamed from: systemInfoApi$delegate, reason: from kotlin metadata */
    private final Lazy systemInfoApi = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.DataSourceModuleImpl$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SystemInfoApiImpl systemInfoApi_delegate$lambda$3;
            systemInfoApi_delegate$lambda$3 = DataSourceModuleImpl.systemInfoApi_delegate$lambda$3();
            return systemInfoApi_delegate$lambda$3;
        }
    });

    /* renamed from: appInfoApi$delegate, reason: from kotlin metadata */
    private final Lazy appInfoApi = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.DataSourceModuleImpl$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            AppInfoApiImpl appInfoApi_delegate$lambda$5;
            appInfoApi_delegate$lambda$5 = DataSourceModuleImpl.appInfoApi_delegate$lambda$5();
            return appInfoApi_delegate$lambda$5;
        }
    });

    /* renamed from: storageRepository$delegate, reason: from kotlin metadata */
    private final Lazy storageRepository = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.DataSourceModuleImpl$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            StorageRepositoryImpl storageRepository_delegate$lambda$7;
            storageRepository_delegate$lambda$7 = DataSourceModuleImpl.storageRepository_delegate$lambda$7();
            return storageRepository_delegate$lambda$7;
        }
    });

    /* renamed from: localDataSource$delegate, reason: from kotlin metadata */
    private final Lazy localDataSource = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.DataSourceModuleImpl$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            LocalDataSourceImpl localDataSource_delegate$lambda$8;
            localDataSource_delegate$lambda$8 = DataSourceModuleImpl.localDataSource_delegate$lambda$8(DataSourceModuleImpl.this);
            return localDataSource_delegate$lambda$8;
        }
    });

    /* renamed from: remoteDataSource$delegate, reason: from kotlin metadata */
    private final Lazy remoteDataSource = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.DataSourceModuleImpl$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            RemoteDataSource remoteDataSource_delegate$lambda$10;
            remoteDataSource_delegate$lambda$10 = DataSourceModuleImpl.remoteDataSource_delegate$lambda$10();
            return remoteDataSource_delegate$lambda$10;
        }
    });

    /* renamed from: deviceMetricsRepository$delegate, reason: from kotlin metadata */
    private final Lazy deviceMetricsRepository = LazyKt.lazy(new Function0() { // from class: io.adn.sdk.internal.di.modules.DataSourceModuleImpl$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DeviceMetricsRepositoryImpl deviceMetricsRepository_delegate$lambda$12;
            deviceMetricsRepository_delegate$lambda$12 = DataSourceModuleImpl.deviceMetricsRepository_delegate$lambda$12();
            return deviceMetricsRepository_delegate$lambda$12;
        }
    });

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public AdvertisingIdsApi getAdvertisingIdsApi() {
        return (AdvertisingIdsApi) this.advertisingIdsApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdvertisingIdsApiImpl advertisingIdsApi_delegate$lambda$1() {
        return new AdvertisingIdsApiImpl(SdkInjector.INSTANCE.getSdkModule().getAppContext());
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public SystemInfoApi getSystemInfoApi() {
        return (SystemInfoApi) this.systemInfoApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SystemInfoApiImpl systemInfoApi_delegate$lambda$3() {
        return new SystemInfoApiImpl(SdkInjector.INSTANCE.getSdkModule().getAppContext());
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public AppInfoApi getAppInfoApi() {
        return (AppInfoApi) this.appInfoApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppInfoApiImpl appInfoApi_delegate$lambda$5() {
        return new AppInfoApiImpl(SdkInjector.INSTANCE.getSdkModule().getAppContext());
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public StorageRepository getStorageRepository() {
        return (StorageRepository) this.storageRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StorageRepositoryImpl storageRepository_delegate$lambda$7() {
        return new StorageRepositoryImpl(SdkInjector.INSTANCE.getSdkModule().getAppContext());
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public LocalDataSource getLocalDataSource() {
        return (LocalDataSource) this.localDataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalDataSourceImpl localDataSource_delegate$lambda$8(DataSourceModuleImpl dataSourceModuleImpl) {
        return new LocalDataSourceImpl(dataSourceModuleImpl.getAdvertisingIdsApi(), dataSourceModuleImpl.getSystemInfoApi(), dataSourceModuleImpl.getAppInfoApi(), null, 8, null);
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public RemoteDataSource getRemoteDataSource() {
        return (RemoteDataSource) this.remoteDataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteDataSource remoteDataSource_delegate$lambda$10() {
        return new RemoteDataSource(SdkInjector.INSTANCE.getSdkModule().getHttpClient());
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public DeviceMetricsRepository getDeviceMetricsRepository() {
        return (DeviceMetricsRepository) this.deviceMetricsRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeviceMetricsRepositoryImpl deviceMetricsRepository_delegate$lambda$12() {
        return new DeviceMetricsRepositoryImpl(SdkInjector.INSTANCE.getSdkModule().getAppContext());
    }
}
