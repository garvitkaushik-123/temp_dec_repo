package io.adn.sdk.internal.di.modules;

import adn.analytics.AdnDataConverter;
import android.app.Activity;
import android.content.Context;
import io.adn.sdk.internal.data.api.local.AdvertisingIdsApi;
import io.adn.sdk.internal.data.api.local.AppInfoApi;
import io.adn.sdk.internal.data.api.local.LocalDataSource;
import io.adn.sdk.internal.data.api.local.SharedPreferencesApi;
import io.adn.sdk.internal.data.api.local.SystemInfoApi;
import io.adn.sdk.internal.data.api.remote.RemoteDataSource;
import io.adn.sdk.internal.data.service.AudioService;
import io.adn.sdk.internal.data.service.NetworkStatusService;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.handler.FullscreenAdHandler;
import io.adn.sdk.internal.domain.handler.NativeAdHandler;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntity;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntity;
import io.adn.sdk.internal.domain.repository.AdFileLoader;
import io.adn.sdk.internal.domain.repository.AdTrackerSender;
import io.adn.sdk.internal.domain.repository.BidFetcherRepository;
import io.adn.sdk.internal.domain.repository.BidTokenRepository;
import io.adn.sdk.internal.domain.repository.DeviceMetricsRepository;
import io.adn.sdk.internal.domain.repository.FullscreenAdLoader;
import io.adn.sdk.internal.domain.repository.FullscreenAdSceneLoader;
import io.adn.sdk.internal.domain.repository.InstallReferrerRepository;
import io.adn.sdk.internal.domain.repository.InstallReferrerStorage;
import io.adn.sdk.internal.domain.repository.NativeAdLoader;
import io.adn.sdk.internal.domain.repository.RemoteDataRepository;
import io.adn.sdk.internal.domain.repository.StorageRepository;
import io.adn.sdk.internal.domain.repository.VastLoader;
import io.adn.sdk.internal.domain.usecase.FetchBidResponseUseCase;
import io.adn.sdk.internal.domain.usecase.GetBidTokenUseCase;
import io.adn.sdk.internal.domain.usecase.LoadFullscreenAdUseCase;
import io.adn.sdk.internal.domain.usecase.LoadNativeAdAssetsUseCase;
import io.adn.sdk.internal.domain.usecase.LoadNativeAdMetadataUseCase;
import io.adn.sdk.internal.domain.usecase.PostInitializationUseCase;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenAdViewModel;
import io.adn.sdk.internal.ui.nativead.NativeAdViewModel;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowserLauncher;
import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: SdkModule.kt */
@Metadata(d1 = {"\u0000ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\tBG\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0002HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÂ\u0003J\t\u0010\u001a\u001a\u00020\bHÂ\u0003J\t\u0010\u001b\u001a\u00020\tHÂ\u0003JY\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\tHÇ\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u0097\u0001J\u001d\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020$H\u0097\u0001J'\u0010%\u001a\u00020&2\b\b\u0001\u0010!\u001a\u00020\"2\b\b\u0001\u0010'\u001a\u00020(2\b\b\u0001\u0010)\u001a\u00020\u001eH\u0097\u0001J\u0013\u0010*\u001a\u00020+2\b\b\u0001\u0010!\u001a\u00020\"H\u0097\u0001J3\u0010,\u001a\u00020-2\b\b\u0001\u0010!\u001a\u00020\"2\b\b\u0001\u0010'\u001a\u00020.2\n\b\u0001\u0010/\u001a\u0004\u0018\u0001002\b\b\u0001\u0010)\u001a\u00020\u001eH\u0097\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H×\u0003J\u001d\u00105\u001a\u0002062\b\b\u0001\u00107\u001a\u0002082\b\b\u0001\u0010)\u001a\u00020\u001eH\u0097\u0001J\u0013\u00109\u001a\u00020:2\b\b\u0001\u0010#\u001a\u00020$H\u0097\u0001J\t\u0010;\u001a\u00020<H×\u0001J\u001d\u0010=\u001a\u00020>2\b\b\u0001\u0010?\u001a\u00020@2\b\b\u0001\u0010)\u001a\u00020\u001eH\u0097\u0001J\u0013\u0010A\u001a\u00020B2\b\b\u0001\u0010?\u001a\u00020CH\u0097\u0001J\u0013\u0010D\u001a\u00020E2\b\b\u0001\u0010?\u001a\u00020CH\u0097\u0001J\t\u0010F\u001a\u00020GH\u0097\u0001J\t\u0010H\u001a\u00020IH×\u0001R\u000e\u0010\n\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u00020K8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010N\u001a\u00020O8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020S8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020W8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020[8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020_8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0014\u0010b\u001a\u00020c8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020g8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020k8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020o8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0014\u0010r\u001a\u00020s8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0014\u0010v\u001a\u00020w8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0014\u0010z\u001a\u00020{8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0016\u0010~\u001a\u00020\u007f8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0082\u0001\u001a\u00030\u0083\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0086\u0001\u001a\u00030\u0087\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u008b\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008f\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u0093\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0097\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010\u009a\u0001\u001a\u00030\u009b\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0018\u0010\u009e\u0001\u001a\u00030\u009f\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001¨\u0006¢\u0001"}, d2 = {"Lio/adn/sdk/internal/di/modules/SdkModuleImpl;", "Lio/adn/sdk/internal/di/modules/SdkModule;", "Lio/adn/sdk/internal/di/modules/ProviderModule;", "Lio/adn/sdk/internal/di/modules/NetworkModule;", "Lio/adn/sdk/internal/di/modules/DataSourceModule;", "Lio/adn/sdk/internal/di/modules/ServicesModule;", "Lio/adn/sdk/internal/di/modules/AdLoaderModule;", "Lio/adn/sdk/internal/di/modules/RepositoryModule;", "Lio/adn/sdk/internal/di/modules/AnalyticsModule;", "Lio/adn/sdk/internal/di/modules/AdFactoryModule;", "providerModule", "networkModule", "dataSourceModule", "servicesModule", "adLoaderModule", "repositoryModule", "analyticsModule", "adFactory", "<init>", "(Lio/adn/sdk/internal/di/modules/ProviderModule;Lio/adn/sdk/internal/di/modules/NetworkModule;Lio/adn/sdk/internal/di/modules/DataSourceModule;Lio/adn/sdk/internal/di/modules/ServicesModule;Lio/adn/sdk/internal/di/modules/AdLoaderModule;Lio/adn/sdk/internal/di/modules/RepositoryModule;Lio/adn/sdk/internal/di/modules/AnalyticsModule;Lio/adn/sdk/internal/di/modules/AdFactoryModule;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "createDiagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "createFullscreenAd", "Lio/adn/sdk/internal/domain/handler/FullscreenAdHandler;", "activity", "Landroid/app/Activity;", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "createFullscreenAdViewModel", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenAdViewModel;", "ad", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", "diagnosticReporter", "createNativeAd", "Lio/adn/sdk/internal/domain/handler/NativeAdHandler;", "createNativeAdViewModel", "Lio/adn/sdk/internal/ui/nativead/NativeAdViewModel;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "inAppBrowserLauncher", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserLauncher;", "equals", "", "other", "", "fetchBidResponseUseCase", "Lio/adn/sdk/internal/domain/usecase/FetchBidResponseUseCase;", "bidFetcherRepository", "Lio/adn/sdk/internal/domain/repository/BidFetcherRepository;", "getBidTokenUseCase", "Lio/adn/sdk/internal/domain/usecase/GetBidTokenUseCase;", "hashCode", "", "loadFullscreenAdUseCase", "Lio/adn/sdk/internal/domain/usecase/LoadFullscreenAdUseCase;", "adLoader", "Lio/adn/sdk/internal/domain/repository/FullscreenAdLoader;", "loadNativeAdMetadataUseCase", "Lio/adn/sdk/internal/domain/usecase/LoadNativeAdMetadataUseCase;", "Lio/adn/sdk/internal/domain/repository/NativeAdLoader;", "loadNativeAdUseCase", "Lio/adn/sdk/internal/domain/usecase/LoadNativeAdAssetsUseCase;", "postInitializationUseCase", "Lio/adn/sdk/internal/domain/usecase/PostInitializationUseCase;", "toString", "", "adSceneLoader", "Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;", "getAdSceneLoader", "()Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;", "adTrackerSender", "Lio/adn/sdk/internal/domain/repository/AdTrackerSender;", "getAdTrackerSender", "()Lio/adn/sdk/internal/domain/repository/AdTrackerSender;", "adnDataConverter", "Ladn/analytics/AdnDataConverter;", "getAdnDataConverter", "()Ladn/analytics/AdnDataConverter;", "advertisingIdsApi", "Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "getAdvertisingIdsApi", "()Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "appInfoApi", "Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "getAppInfoApi", "()Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "audioService", "Lio/adn/sdk/internal/data/service/AudioService;", "getAudioService", "()Lio/adn/sdk/internal/data/service/AudioService;", "bidTokenRepository", "Lio/adn/sdk/internal/domain/repository/BidTokenRepository;", "getBidTokenRepository", "()Lio/adn/sdk/internal/domain/repository/BidTokenRepository;", "deviceMetricsRepository", "Lio/adn/sdk/internal/domain/repository/DeviceMetricsRepository;", "getDeviceMetricsRepository", "()Lio/adn/sdk/internal/domain/repository/DeviceMetricsRepository;", "fileLoader", "Lio/adn/sdk/internal/domain/repository/AdFileLoader;", "getFileLoader", "()Lio/adn/sdk/internal/domain/repository/AdFileLoader;", "httpClient", "Lio/ktor/client/HttpClient;", "getHttpClient", "()Lio/ktor/client/HttpClient;", "installReferrerRepository", "Lio/adn/sdk/internal/domain/repository/InstallReferrerRepository;", "getInstallReferrerRepository", "()Lio/adn/sdk/internal/domain/repository/InstallReferrerRepository;", "installReferrerStorage", "Lio/adn/sdk/internal/domain/repository/InstallReferrerStorage;", "getInstallReferrerStorage", "()Lio/adn/sdk/internal/domain/repository/InstallReferrerStorage;", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "localDataSource", "Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "getLocalDataSource", "()Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "networkStatusService", "Lio/adn/sdk/internal/data/service/NetworkStatusService;", "getNetworkStatusService", "()Lio/adn/sdk/internal/data/service/NetworkStatusService;", "remoteDataRepository", "Lio/adn/sdk/internal/domain/repository/RemoteDataRepository;", "getRemoteDataRepository", "()Lio/adn/sdk/internal/domain/repository/RemoteDataRepository;", "remoteDataSource", "Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "getRemoteDataSource", "()Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "sharedPreferencesApi", "Lio/adn/sdk/internal/data/api/local/SharedPreferencesApi;", "getSharedPreferencesApi", "()Lio/adn/sdk/internal/data/api/local/SharedPreferencesApi;", "storageRepository", "Lio/adn/sdk/internal/domain/repository/StorageRepository;", "getStorageRepository", "()Lio/adn/sdk/internal/domain/repository/StorageRepository;", "systemInfoApi", "Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "getSystemInfoApi", "()Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "vastAdLoader", "Lio/adn/sdk/internal/domain/repository/VastLoader;", "getVastAdLoader", "()Lio/adn/sdk/internal/domain/repository/VastLoader;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class SdkModuleImpl implements SdkModule, ProviderModule, NetworkModule, DataSourceModule, ServicesModule, AdLoaderModule, RepositoryModule, AnalyticsModule, AdFactoryModule {
    public static final int $stable = 0;
    private final AdFactoryModule adFactory;
    private final AdLoaderModule adLoaderModule;
    private final AnalyticsModule analyticsModule;
    private final DataSourceModule dataSourceModule;
    private final NetworkModule networkModule;
    private final ProviderModule providerModule;
    private final RepositoryModule repositoryModule;
    private final ServicesModule servicesModule;

    /* renamed from: component1, reason: from getter */
    private final ProviderModule getProviderModule() {
        return this.providerModule;
    }

    /* renamed from: component2, reason: from getter */
    private final NetworkModule getNetworkModule() {
        return this.networkModule;
    }

    /* renamed from: component3, reason: from getter */
    private final DataSourceModule getDataSourceModule() {
        return this.dataSourceModule;
    }

    /* renamed from: component4, reason: from getter */
    private final ServicesModule getServicesModule() {
        return this.servicesModule;
    }

    /* renamed from: component5, reason: from getter */
    private final AdLoaderModule getAdLoaderModule() {
        return this.adLoaderModule;
    }

    /* renamed from: component6, reason: from getter */
    private final RepositoryModule getRepositoryModule() {
        return this.repositoryModule;
    }

    /* renamed from: component7, reason: from getter */
    private final AnalyticsModule getAnalyticsModule() {
        return this.analyticsModule;
    }

    /* renamed from: component8, reason: from getter */
    private final AdFactoryModule getAdFactory() {
        return this.adFactory;
    }

    public static /* synthetic */ SdkModuleImpl copy$default(SdkModuleImpl sdkModuleImpl, ProviderModule providerModule, NetworkModule networkModule, DataSourceModule dataSourceModule, ServicesModule servicesModule, AdLoaderModule adLoaderModule, RepositoryModule repositoryModule, AnalyticsModule analyticsModule, AdFactoryModule adFactoryModule, int i, Object obj) {
        if ((i & 1) != 0) {
            providerModule = sdkModuleImpl.providerModule;
        }
        if ((i & 2) != 0) {
            networkModule = sdkModuleImpl.networkModule;
        }
        if ((i & 4) != 0) {
            dataSourceModule = sdkModuleImpl.dataSourceModule;
        }
        if ((i & 8) != 0) {
            servicesModule = sdkModuleImpl.servicesModule;
        }
        if ((i & 16) != 0) {
            adLoaderModule = sdkModuleImpl.adLoaderModule;
        }
        if ((i & 32) != 0) {
            repositoryModule = sdkModuleImpl.repositoryModule;
        }
        if ((i & 64) != 0) {
            analyticsModule = sdkModuleImpl.analyticsModule;
        }
        if ((i & 128) != 0) {
            adFactoryModule = sdkModuleImpl.adFactory;
        }
        AnalyticsModule analyticsModule2 = analyticsModule;
        AdFactoryModule adFactoryModule2 = adFactoryModule;
        AdLoaderModule adLoaderModule2 = adLoaderModule;
        RepositoryModule repositoryModule2 = repositoryModule;
        return sdkModuleImpl.copy(providerModule, networkModule, dataSourceModule, servicesModule, adLoaderModule2, repositoryModule2, analyticsModule2, adFactoryModule2);
    }

    public final SdkModuleImpl copy(ProviderModule providerModule, NetworkModule networkModule, DataSourceModule dataSourceModule, ServicesModule servicesModule, AdLoaderModule adLoaderModule, RepositoryModule repositoryModule, AnalyticsModule analyticsModule, AdFactoryModule adFactory) {
        Intrinsics.checkNotNullParameter(providerModule, "providerModule");
        Intrinsics.checkNotNullParameter(networkModule, "networkModule");
        Intrinsics.checkNotNullParameter(dataSourceModule, "dataSourceModule");
        Intrinsics.checkNotNullParameter(servicesModule, "servicesModule");
        Intrinsics.checkNotNullParameter(adLoaderModule, "adLoaderModule");
        Intrinsics.checkNotNullParameter(repositoryModule, "repositoryModule");
        Intrinsics.checkNotNullParameter(analyticsModule, "analyticsModule");
        Intrinsics.checkNotNullParameter(adFactory, "adFactory");
        return new SdkModuleImpl(providerModule, networkModule, dataSourceModule, servicesModule, adLoaderModule, repositoryModule, analyticsModule, adFactory);
    }

    @Override // io.adn.sdk.internal.di.modules.AnalyticsModule
    public DiagnosticReporter createDiagnosticReporter() {
        return this.analyticsModule.createDiagnosticReporter();
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public FullscreenAdHandler createFullscreenAd(Activity activity, AdnAdPlacement placement) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(placement, "placement");
        return this.adFactory.createFullscreenAd(activity, placement);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public FullscreenAdViewModel createFullscreenAdViewModel(Activity activity, FullscreenAdEntity ad, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        return this.adFactory.createFullscreenAdViewModel(activity, ad, diagnosticReporter);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public NativeAdHandler createNativeAd(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.adFactory.createNativeAd(activity);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public NativeAdViewModel createNativeAdViewModel(Activity activity, NativeAdEntity ad, AdnInAppBrowserLauncher inAppBrowserLauncher, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        return this.adFactory.createNativeAdViewModel(activity, ad, inAppBrowserLauncher, diagnosticReporter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SdkModuleImpl)) {
            return false;
        }
        SdkModuleImpl sdkModuleImpl = (SdkModuleImpl) other;
        return Intrinsics.areEqual(this.providerModule, sdkModuleImpl.providerModule) && Intrinsics.areEqual(this.networkModule, sdkModuleImpl.networkModule) && Intrinsics.areEqual(this.dataSourceModule, sdkModuleImpl.dataSourceModule) && Intrinsics.areEqual(this.servicesModule, sdkModuleImpl.servicesModule) && Intrinsics.areEqual(this.adLoaderModule, sdkModuleImpl.adLoaderModule) && Intrinsics.areEqual(this.repositoryModule, sdkModuleImpl.repositoryModule) && Intrinsics.areEqual(this.analyticsModule, sdkModuleImpl.analyticsModule) && Intrinsics.areEqual(this.adFactory, sdkModuleImpl.adFactory);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public FetchBidResponseUseCase fetchBidResponseUseCase(BidFetcherRepository bidFetcherRepository, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(bidFetcherRepository, "bidFetcherRepository");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        return this.adFactory.fetchBidResponseUseCase(bidFetcherRepository, diagnosticReporter);
    }

    @Override // io.adn.sdk.internal.di.modules.AdLoaderModule
    public FullscreenAdSceneLoader getAdSceneLoader() {
        return this.adLoaderModule.getAdSceneLoader();
    }

    @Override // io.adn.sdk.internal.di.modules.AnalyticsModule
    public AdTrackerSender getAdTrackerSender() {
        return this.analyticsModule.getAdTrackerSender();
    }

    @Override // io.adn.sdk.internal.di.modules.RepositoryModule
    public AdnDataConverter getAdnDataConverter() {
        return this.repositoryModule.getAdnDataConverter();
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public AdvertisingIdsApi getAdvertisingIdsApi() {
        return this.dataSourceModule.getAdvertisingIdsApi();
    }

    @Override // io.adn.sdk.internal.di.modules.ProviderModule
    public Context getAppContext() {
        return this.providerModule.getAppContext();
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public AppInfoApi getAppInfoApi() {
        return this.dataSourceModule.getAppInfoApi();
    }

    @Override // io.adn.sdk.internal.di.modules.ServicesModule
    public AudioService getAudioService() {
        return this.servicesModule.getAudioService();
    }

    @Override // io.adn.sdk.internal.di.modules.RepositoryModule
    public BidTokenRepository getBidTokenRepository() {
        return this.repositoryModule.getBidTokenRepository();
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public GetBidTokenUseCase getBidTokenUseCase(AdnAdPlacement placement) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        return this.adFactory.getBidTokenUseCase(placement);
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public DeviceMetricsRepository getDeviceMetricsRepository() {
        return this.dataSourceModule.getDeviceMetricsRepository();
    }

    @Override // io.adn.sdk.internal.di.modules.AdLoaderModule
    public AdFileLoader getFileLoader() {
        return this.adLoaderModule.getFileLoader();
    }

    @Override // io.adn.sdk.internal.di.modules.NetworkModule
    public HttpClient getHttpClient() {
        return this.networkModule.getHttpClient();
    }

    @Override // io.adn.sdk.internal.di.modules.RepositoryModule
    public InstallReferrerRepository getInstallReferrerRepository() {
        return this.repositoryModule.getInstallReferrerRepository();
    }

    @Override // io.adn.sdk.internal.di.modules.RepositoryModule
    public InstallReferrerStorage getInstallReferrerStorage() {
        return this.repositoryModule.getInstallReferrerStorage();
    }

    @Override // io.adn.sdk.internal.di.modules.ProviderModule
    public Json getJson() {
        return this.providerModule.getJson();
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public LocalDataSource getLocalDataSource() {
        return this.dataSourceModule.getLocalDataSource();
    }

    @Override // io.adn.sdk.internal.di.modules.ServicesModule
    public NetworkStatusService getNetworkStatusService() {
        return this.servicesModule.getNetworkStatusService();
    }

    @Override // io.adn.sdk.internal.di.modules.RepositoryModule
    public RemoteDataRepository getRemoteDataRepository() {
        return this.repositoryModule.getRemoteDataRepository();
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public RemoteDataSource getRemoteDataSource() {
        return this.dataSourceModule.getRemoteDataSource();
    }

    @Override // io.adn.sdk.internal.di.modules.ProviderModule
    public SharedPreferencesApi getSharedPreferencesApi() {
        return this.providerModule.getSharedPreferencesApi();
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public StorageRepository getStorageRepository() {
        return this.dataSourceModule.getStorageRepository();
    }

    @Override // io.adn.sdk.internal.di.modules.DataSourceModule
    public SystemInfoApi getSystemInfoApi() {
        return this.dataSourceModule.getSystemInfoApi();
    }

    @Override // io.adn.sdk.internal.di.modules.AdLoaderModule
    public VastLoader getVastAdLoader() {
        return this.adLoaderModule.getVastAdLoader();
    }

    public int hashCode() {
        return (((((((((((((this.providerModule.hashCode() * 31) + this.networkModule.hashCode()) * 31) + this.dataSourceModule.hashCode()) * 31) + this.servicesModule.hashCode()) * 31) + this.adLoaderModule.hashCode()) * 31) + this.repositoryModule.hashCode()) * 31) + this.analyticsModule.hashCode()) * 31) + this.adFactory.hashCode();
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public LoadFullscreenAdUseCase loadFullscreenAdUseCase(FullscreenAdLoader adLoader, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(adLoader, "adLoader");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        return this.adFactory.loadFullscreenAdUseCase(adLoader, diagnosticReporter);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public LoadNativeAdMetadataUseCase loadNativeAdMetadataUseCase(NativeAdLoader adLoader) {
        Intrinsics.checkNotNullParameter(adLoader, "adLoader");
        return this.adFactory.loadNativeAdMetadataUseCase(adLoader);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public LoadNativeAdAssetsUseCase loadNativeAdUseCase(NativeAdLoader adLoader) {
        Intrinsics.checkNotNullParameter(adLoader, "adLoader");
        return this.adFactory.loadNativeAdUseCase(adLoader);
    }

    @Override // io.adn.sdk.internal.di.modules.AdFactoryModule
    public PostInitializationUseCase postInitializationUseCase() {
        return this.adFactory.postInitializationUseCase();
    }

    public String toString() {
        return "SdkModuleImpl(providerModule=" + this.providerModule + ", networkModule=" + this.networkModule + ", dataSourceModule=" + this.dataSourceModule + ", servicesModule=" + this.servicesModule + ", adLoaderModule=" + this.adLoaderModule + ", repositoryModule=" + this.repositoryModule + ", analyticsModule=" + this.analyticsModule + ", adFactory=" + this.adFactory + ')';
    }

    public SdkModuleImpl(ProviderModule providerModule, NetworkModule networkModule, DataSourceModule dataSourceModule, ServicesModule servicesModule, AdLoaderModule adLoaderModule, RepositoryModule repositoryModule, AnalyticsModule analyticsModule, AdFactoryModule adFactory) {
        Intrinsics.checkNotNullParameter(providerModule, "providerModule");
        Intrinsics.checkNotNullParameter(networkModule, "networkModule");
        Intrinsics.checkNotNullParameter(dataSourceModule, "dataSourceModule");
        Intrinsics.checkNotNullParameter(servicesModule, "servicesModule");
        Intrinsics.checkNotNullParameter(adLoaderModule, "adLoaderModule");
        Intrinsics.checkNotNullParameter(repositoryModule, "repositoryModule");
        Intrinsics.checkNotNullParameter(analyticsModule, "analyticsModule");
        Intrinsics.checkNotNullParameter(adFactory, "adFactory");
        this.providerModule = providerModule;
        this.networkModule = networkModule;
        this.dataSourceModule = dataSourceModule;
        this.servicesModule = servicesModule;
        this.adLoaderModule = adLoaderModule;
        this.repositoryModule = repositoryModule;
        this.analyticsModule = analyticsModule;
        this.adFactory = adFactory;
    }
}
