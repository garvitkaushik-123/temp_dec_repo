package io.adn.sdk.internal.di.modules;

import io.adn.sdk.internal.data.api.local.AdvertisingIdsApi;
import io.adn.sdk.internal.data.api.local.AppInfoApi;
import io.adn.sdk.internal.data.api.local.LocalDataSource;
import io.adn.sdk.internal.data.api.local.SystemInfoApi;
import io.adn.sdk.internal.data.api.remote.RemoteDataSource;
import io.adn.sdk.internal.domain.repository.DeviceMetricsRepository;
import io.adn.sdk.internal.domain.repository.StorageRepository;
import kotlin.Metadata;

/* compiled from: DataSourceModule.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/adn/sdk/internal/di/modules/DataSourceModule;", "", "advertisingIdsApi", "Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "getAdvertisingIdsApi", "()Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "systemInfoApi", "Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "getSystemInfoApi", "()Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "appInfoApi", "Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "getAppInfoApi", "()Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "storageRepository", "Lio/adn/sdk/internal/domain/repository/StorageRepository;", "getStorageRepository", "()Lio/adn/sdk/internal/domain/repository/StorageRepository;", "localDataSource", "Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "getLocalDataSource", "()Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "remoteDataSource", "Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "getRemoteDataSource", "()Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "deviceMetricsRepository", "Lio/adn/sdk/internal/domain/repository/DeviceMetricsRepository;", "getDeviceMetricsRepository", "()Lio/adn/sdk/internal/domain/repository/DeviceMetricsRepository;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface DataSourceModule {
    AdvertisingIdsApi getAdvertisingIdsApi();

    AppInfoApi getAppInfoApi();

    DeviceMetricsRepository getDeviceMetricsRepository();

    LocalDataSource getLocalDataSource();

    RemoteDataSource getRemoteDataSource();

    StorageRepository getStorageRepository();

    SystemInfoApi getSystemInfoApi();
}
