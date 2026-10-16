package io.adn.sdk.internal.data.api.local;

import io.adn.sdk.internal.di.modules.DataSourceModuleKt;
import io.adn.sdk.internal.domain.repository.ExternalDataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalDataSource.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/adn/sdk/internal/data/api/local/LocalDataSourceImpl;", "Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "advertisingIds", "Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "systemInfo", "Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "appInfo", "Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "externalData", "Lio/adn/sdk/internal/domain/repository/ExternalDataSource;", "<init>", "(Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;Lio/adn/sdk/internal/data/api/local/SystemInfoApi;Lio/adn/sdk/internal/data/api/local/AppInfoApi;Lio/adn/sdk/internal/domain/repository/ExternalDataSource;)V", "getAdvertisingIds", "()Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "getSystemInfo", "()Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "getAppInfo", "()Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "getExternalData", "()Lio/adn/sdk/internal/domain/repository/ExternalDataSource;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LocalDataSourceImpl implements LocalDataSource {
    public static final int $stable = 0;
    private final AdvertisingIdsApi advertisingIds;
    private final AppInfoApi appInfo;
    private final ExternalDataSource externalData;
    private final SystemInfoApi systemInfo;

    public LocalDataSourceImpl(AdvertisingIdsApi advertisingIds, SystemInfoApi systemInfo, AppInfoApi appInfo, ExternalDataSource externalData) {
        Intrinsics.checkNotNullParameter(advertisingIds, "advertisingIds");
        Intrinsics.checkNotNullParameter(systemInfo, "systemInfo");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(externalData, "externalData");
        this.advertisingIds = advertisingIds;
        this.systemInfo = systemInfo;
        this.appInfo = appInfo;
        this.externalData = externalData;
    }

    @Override // io.adn.sdk.internal.data.api.local.LocalDataSource
    public AdvertisingIdsApi getAdvertisingIds() {
        return this.advertisingIds;
    }

    @Override // io.adn.sdk.internal.data.api.local.LocalDataSource
    public SystemInfoApi getSystemInfo() {
        return this.systemInfo;
    }

    @Override // io.adn.sdk.internal.data.api.local.LocalDataSource
    public AppInfoApi getAppInfo() {
        return this.appInfo;
    }

    public /* synthetic */ LocalDataSourceImpl(AdvertisingIdsApi advertisingIdsApi, SystemInfoApi systemInfoApi, AppInfoApi appInfoApi, ExternalDataSource externalDataSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(advertisingIdsApi, systemInfoApi, appInfoApi, (i & 8) != 0 ? DataSourceModuleKt.externalData() : externalDataSource);
    }

    @Override // io.adn.sdk.internal.data.api.local.LocalDataSource
    public ExternalDataSource getExternalData() {
        return this.externalData;
    }
}
