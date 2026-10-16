package io.adn.sdk.internal.data.api.local;

import io.adn.sdk.internal.domain.repository.ExternalDataSource;
import kotlin.Metadata;

/* compiled from: LocalDataSource.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "", "advertisingIds", "Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "getAdvertisingIds", "()Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "systemInfo", "Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "getSystemInfo", "()Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "appInfo", "Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "getAppInfo", "()Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "externalData", "Lio/adn/sdk/internal/domain/repository/ExternalDataSource;", "getExternalData", "()Lio/adn/sdk/internal/domain/repository/ExternalDataSource;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface LocalDataSource {
    AdvertisingIdsApi getAdvertisingIds();

    AppInfoApi getAppInfo();

    ExternalDataSource getExternalData();

    SystemInfoApi getSystemInfo();
}
