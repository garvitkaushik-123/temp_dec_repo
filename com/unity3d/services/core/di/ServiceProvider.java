package com.unity3d.services.core.di;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import com.unity3d.ads.adplayer.AdPlayerScope;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.configuration.AndroidManifestIntPropertyReader;
import com.unity3d.ads.core.configuration.GameServerIdReader;
import com.unity3d.ads.core.configuration.MediationInitBlobMetadataReader;
import com.unity3d.ads.core.configuration.MediationTraitsMetadataReader;
import com.unity3d.ads.core.data.datasource.AnalyticsDataSource;
import com.unity3d.ads.core.data.datasource.AndroidAnalyticsDataSource;
import com.unity3d.ads.core.data.datasource.AndroidDeveloperConsentDataSource;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidFIdDataSource;
import com.unity3d.ads.core.data.datasource.AndroidFIdExistenceDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLegacyConfigStoreDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLegacyUserConsentDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLifecycleDataSource;
import com.unity3d.ads.core.data.datasource.AndroidLocalCacheDataSource;
import com.unity3d.ads.core.data.datasource.AndroidMediationDataSource;
import com.unity3d.ads.core.data.datasource.AndroidPrivacyDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidStoreDataSource;
import com.unity3d.ads.core.data.datasource.AndroidTcfDataSource;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.datasource.CacheDataSource;
import com.unity3d.ads.core.data.datasource.DeveloperConsentDataSource;
import com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.FIdDataSource;
import com.unity3d.ads.core.data.datasource.FIdExistenceDataSource;
import com.unity3d.ads.core.data.datasource.FetchGLInfoDataMigration;
import com.unity3d.ads.core.data.datasource.LegacyUserConsentDataSource;
import com.unity3d.ads.core.data.datasource.LifecycleDataSource;
import com.unity3d.ads.core.data.datasource.MediationDataSource;
import com.unity3d.ads.core.data.datasource.PrivacyDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.StoreDataSource;
import com.unity3d.ads.core.data.datasource.TcfDataSource;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource;
import com.unity3d.ads.core.data.manager.AndroidOfferwallManager;
import com.unity3d.ads.core.data.manager.AndroidOmidManager;
import com.unity3d.ads.core.data.manager.AndroidSDKPropertiesManager;
import com.unity3d.ads.core.data.manager.AndroidScarManager;
import com.unity3d.ads.core.data.manager.AndroidStorageManager;
import com.unity3d.ads.core.data.manager.OfferwallManager;
import com.unity3d.ads.core.data.manager.OmidManager;
import com.unity3d.ads.core.data.manager.SDKPropertiesManager;
import com.unity3d.ads.core.data.manager.ScarManager;
import com.unity3d.ads.core.data.manager.StorageManager;
import com.unity3d.ads.core.data.manager.TransactionEventManager;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.AndroidAdRepository;
import com.unity3d.ads.core.data.repository.AndroidCacheRepository;
import com.unity3d.ads.core.data.repository.AndroidCampaignRepository;
import com.unity3d.ads.core.data.repository.AndroidDeveloperConsentRepository;
import com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository;
import com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.AndroidLegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.AndroidMediationRepository;
import com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.AndroidSessionRepository;
import com.unity3d.ads.core.data.repository.AndroidTcfRepository;
import com.unity3d.ads.core.data.repository.AndroidTransactionEventRepository;
import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeveloperConsentRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.FocusRepository;
import com.unity3d.ads.core.data.repository.LegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.MediationRepository;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.OperativeEventRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.data.repository.TcfRepository;
import com.unity3d.ads.core.data.repository.TransactionEventRepository;
import com.unity3d.ads.core.domain.AndroidBuildHeaderBiddingToken;
import com.unity3d.ads.core.domain.AndroidCacheWebViewAssets;
import com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest;
import com.unity3d.ads.core.domain.AndroidGenerateByteStringId;
import com.unity3d.ads.core.domain.AndroidGetAdDataRefreshRequest;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerConfigRequest;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.ads.core.domain.AndroidGetAdRequest;
import com.unity3d.ads.core.domain.AndroidGetAdRequestPolicy;
import com.unity3d.ads.core.domain.AndroidGetClientInfo;
import com.unity3d.ads.core.domain.AndroidGetInitializationCompletedRequest;
import com.unity3d.ads.core.domain.AndroidGetInitializationData;
import com.unity3d.ads.core.domain.AndroidGetInitializationRequest;
import com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload;
import com.unity3d.ads.core.domain.AndroidGetIsAdActivity;
import com.unity3d.ads.core.domain.AndroidGetLifecycleFlow;
import com.unity3d.ads.core.domain.AndroidGetLimitedSessionToken;
import com.unity3d.ads.core.domain.AndroidGetOpenGLRendererInfo;
import com.unity3d.ads.core.domain.AndroidGetSharedDataTimestamps;
import com.unity3d.ads.core.domain.AndroidGetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.AndroidGetUniversalRequestSharedData;
import com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase;
import com.unity3d.ads.core.domain.AndroidHandleFocusCounters;
import com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse;
import com.unity3d.ads.core.domain.AndroidHandleGatewayInitializationResponse;
import com.unity3d.ads.core.domain.AndroidHandleGatewayUniversalResponse;
import com.unity3d.ads.core.domain.AndroidHandleOpenUrl;
import com.unity3d.ads.core.domain.AndroidHttpClientProvider;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import com.unity3d.ads.core.domain.AndroidLoad;
import com.unity3d.ads.core.domain.AndroidRefresh;
import com.unity3d.ads.core.domain.AndroidRemoveUrlQuery;
import com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent;
import com.unity3d.ads.core.domain.AndroidSendWebViewClientErrorDiagnostics;
import com.unity3d.ads.core.domain.AndroidShow;
import com.unity3d.ads.core.domain.AndroidTestDataInfo;
import com.unity3d.ads.core.domain.AndroidTriggerInitializationCompletedRequest;
import com.unity3d.ads.core.domain.AwaitInitialization;
import com.unity3d.ads.core.domain.BuildHeaderBiddingToken;
import com.unity3d.ads.core.domain.CacheFile;
import com.unity3d.ads.core.domain.CacheWebViewAssets;
import com.unity3d.ads.core.domain.CheckForGameIdAndTestModeChanges;
import com.unity3d.ads.core.domain.CleanAssets;
import com.unity3d.ads.core.domain.CleanUpWhenOpportunityExpires;
import com.unity3d.ads.core.domain.CommonAwaitInitialization;
import com.unity3d.ads.core.domain.CommonCacheFile;
import com.unity3d.ads.core.domain.CommonCheckForGameIdAndTestModeChanges;
import com.unity3d.ads.core.domain.CommonCleanAssets;
import com.unity3d.ads.core.domain.CommonCreateFile;
import com.unity3d.ads.core.domain.CommonGetAdObject;
import com.unity3d.ads.core.domain.CommonGetAdPlayer;
import com.unity3d.ads.core.domain.CommonGetCacheDirectory;
import com.unity3d.ads.core.domain.CommonGetFileExtensionFromUrl;
import com.unity3d.ads.core.domain.CommonGetGameId;
import com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken;
import com.unity3d.ads.core.domain.CommonGetInitializationState;
import com.unity3d.ads.core.domain.CommonGetIsFileCache;
import com.unity3d.ads.core.domain.CommonGetWebViewBridgeUseCase;
import com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken;
import com.unity3d.ads.core.domain.CommonSafeCallbackInvoke;
import com.unity3d.ads.core.domain.CommonSetGameId;
import com.unity3d.ads.core.domain.CommonSetInitializationState;
import com.unity3d.ads.core.domain.CommonShouldAllowInitialization;
import com.unity3d.ads.core.domain.CommonTokenNumberProvider;
import com.unity3d.ads.core.domain.CommonValidateGameId;
import com.unity3d.ads.core.domain.CreateFile;
import com.unity3d.ads.core.domain.ExecuteAdViewerRequest;
import com.unity3d.ads.core.domain.GetAdDataRefreshRequest;
import com.unity3d.ads.core.domain.GetAdObject;
import com.unity3d.ads.core.domain.GetAdPlayer;
import com.unity3d.ads.core.domain.GetAdPlayerConfigRequest;
import com.unity3d.ads.core.domain.GetAdRequest;
import com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetByteStringId;
import com.unity3d.ads.core.domain.GetCacheDirectory;
import com.unity3d.ads.core.domain.GetCachedAsset;
import com.unity3d.ads.core.domain.GetClientInfo;
import com.unity3d.ads.core.domain.GetFileExtensionFromUrl;
import com.unity3d.ads.core.domain.GetGameId;
import com.unity3d.ads.core.domain.GetHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetInitRequestPolicy;
import com.unity3d.ads.core.domain.GetInitializationCompletedRequest;
import com.unity3d.ads.core.domain.GetInitializationData;
import com.unity3d.ads.core.domain.GetInitializationRequest;
import com.unity3d.ads.core.domain.GetInitializationRequestPayload;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.domain.GetIsFileCache;
import com.unity3d.ads.core.domain.GetLatestWebViewConfiguration;
import com.unity3d.ads.core.domain.GetLimitedSessionToken;
import com.unity3d.ads.core.domain.GetOpenGLRendererInfo;
import com.unity3d.ads.core.domain.GetOperativeEventRequestPolicy;
import com.unity3d.ads.core.domain.GetOtherRequestPolicy;
import com.unity3d.ads.core.domain.GetPrivacyUpdateRequest;
import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.GetUniversalRequestSharedData;
import com.unity3d.ads.core.domain.GetWebViewBridgeUseCase;
import com.unity3d.ads.core.domain.HandleGatewayAdResponse;
import com.unity3d.ads.core.domain.HandleGatewayInitializationResponse;
import com.unity3d.ads.core.domain.HandleGatewayUniversalResponse;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.HandleOpenUrl;
import com.unity3d.ads.core.domain.HttpClientProvider;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.ads.core.domain.LegacyLoadUseCase;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import com.unity3d.ads.core.domain.Load;
import com.unity3d.ads.core.domain.Refresh;
import com.unity3d.ads.core.domain.RemoveUrlQuery;
import com.unity3d.ads.core.domain.SafeCallbackInvoke;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.SendPrivacyUpdateRequest;
import com.unity3d.ads.core.domain.SendWebViewClientErrorDiagnostics;
import com.unity3d.ads.core.domain.SetGameId;
import com.unity3d.ads.core.domain.SetInitializationState;
import com.unity3d.ads.core.domain.ShouldAllowInitialization;
import com.unity3d.ads.core.domain.Show;
import com.unity3d.ads.core.domain.TokenNumberProvider;
import com.unity3d.ads.core.domain.TriggerInitializationCompletedRequest;
import com.unity3d.ads.core.domain.TriggerInitializeListener;
import com.unity3d.ads.core.domain.ValidateGameId;
import com.unity3d.ads.core.domain.attribution.AndroidAttribution;
import com.unity3d.ads.core.domain.events.AndroidGetTransactionData;
import com.unity3d.ads.core.domain.events.AndroidHandleGatewayEventResponse;
import com.unity3d.ads.core.domain.events.CommonGetTransactionRequest;
import com.unity3d.ads.core.domain.events.CommonUniversalRequestTtlValidator;
import com.unity3d.ads.core.domain.events.DiagnosticEventObserver;
import com.unity3d.ads.core.domain.events.EventObservers;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventBatchRequest;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.domain.events.GetOperativeEventRequest;
import com.unity3d.ads.core.domain.events.GetTransactionData;
import com.unity3d.ads.core.domain.events.GetTransactionRequest;
import com.unity3d.ads.core.domain.events.HandleGatewayEventResponse;
import com.unity3d.ads.core.domain.events.OperativeEventObserver;
import com.unity3d.ads.core.domain.events.TransactionEventObserver;
import com.unity3d.ads.core.domain.events.UniversalRequestEventSender;
import com.unity3d.ads.core.domain.events.UniversalRequestTtlValidator;
import com.unity3d.ads.core.domain.offerwall.GetIsOfferwallAdReady;
import com.unity3d.ads.core.domain.offerwall.LoadOfferwallAd;
import com.unity3d.ads.core.domain.om.AndroidInitializeOMSDK;
import com.unity3d.ads.core.domain.om.AndroidOmFinishSession;
import com.unity3d.ads.core.domain.om.AndroidOmImpressionOccurred;
import com.unity3d.ads.core.domain.om.AndroidOmInteraction;
import com.unity3d.ads.core.domain.om.AndroidOmStartSession;
import com.unity3d.ads.core.domain.om.CommonGetOmData;
import com.unity3d.ads.core.domain.om.CommonIsOMActivated;
import com.unity3d.ads.core.domain.om.GetOmData;
import com.unity3d.ads.core.domain.om.InitializeOMSDK;
import com.unity3d.ads.core.domain.om.IsOMActivated;
import com.unity3d.ads.core.domain.om.OmFinishSession;
import com.unity3d.ads.core.domain.om.OmImpressionOccurred;
import com.unity3d.ads.core.domain.privacy.DeveloperConsentFlattenerRulesUseCase;
import com.unity3d.ads.core.domain.privacy.FlattenerRulesUseCase;
import com.unity3d.ads.core.domain.privacy.LegacyUserConsentFlattenerRulesUseCase;
import com.unity3d.ads.core.domain.scar.AndroidFetchSignalsAndSendUseCase;
import com.unity3d.ads.core.domain.scar.CommonScarEventReceiver;
import com.unity3d.ads.core.domain.scar.FetchSignalsAndSendUseCase;
import com.unity3d.ads.core.domain.scar.GetAndroidTokenEventRequest;
import com.unity3d.ads.core.domain.scar.GetHbTokenEventRequest;
import com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest;
import com.unity3d.ads.core.domain.scar.HandleGetTokenRequest;
import com.unity3d.ads.core.domain.scar.LoadScarAd;
import com.unity3d.ads.core.domain.scar.ScarTimeHackFixer;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import com.unity3d.ads.core.domain.work.DiagnosticEventRequestWorkModifier;
import com.unity3d.ads.core.domain.work.DownloadPriorityQueue;
import com.unity3d.ads.core.utils.CommonCoroutineTimer;
import com.unity3d.ads.core.utils.CoroutineTimer;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import com.unity3d.ads.datastore.WebviewConfigurationStore;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.services.SDKErrorHandler;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.ads.gmascar.GMAScarAdapterBridge;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.ads.measurements.MeasurementsService;
import com.unity3d.services.ads.offerwall.OfferwallAdapterBridge;
import com.unity3d.services.ads.token.AsyncTokenStorage;
import com.unity3d.services.ads.token.InMemoryTokenStorage;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.ads.topics.TopicsService;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.device.VolumeChange;
import com.unity3d.services.core.device.VolumeChangeContentObserver;
import com.unity3d.services.core.device.VolumeChangeMonitor;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.domain.task.InitializeSDK;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.domain.task.InitializeStateError;
import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import com.unity3d.services.core.fid.Constants;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.network.core.CronetEngineBuilderFactory;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.domain.CleanupDirectory;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.store.StoreMonitor;
import com.unity3d.services.store.StoreWebViewEventSender;
import com.unity3d.services.store.core.GatewayStoreExceptionHandler;
import com.unity3d.services.store.core.StoreEventListenerFactory;
import com.unity3d.services.store.core.StoreExceptionHandler;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: ServiceProvider.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020.H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/unity3d/services/core/di/ServiceProvider;", "Lcom/unity3d/services/core/di/IServiceProvider;", "()V", "CDN_CREATIVES_HOST", "", "CDN_CREATIVES_PORT", "", "DATA_STORE_GATEWAY_CACHE", "DATA_STORE_GL_INFO", "DATA_STORE_IAP_TRANSACTION", "DATA_STORE_NATIVE_CONFIG", "DATA_STORE_PRIVACY", "DATA_STORE_PRIVACY_FSM", "DATA_STORE_UNIVERSAL_REQUEST", "DATA_STORE_WEBVIEW_CONFIG", "DEFAULT_DISPATCHER", "DEV_CONSENT_PRIVACY_RULES", "GATEWAY_HOST", "GATEWAY_PORT", "HTTP_CACHE_DISK_SIZE", "", "HTTP_CLIENT_FETCH_TIMEOUT", "IO_DISPATCHER", "LEGACY_PRIVACY_RULES", "MAIN_DISPATCHER", "NAMED_AD_REQ", "NAMED_GATEWAY_HTTP_CLIENT", "NAMED_GET_TOKEN_SCOPE", "NAMED_INIT_REQ", "NAMED_INIT_SCOPE", "NAMED_LOAD_SCOPE", "NAMED_LOCAL", "NAMED_OFFERWALL_SCOPE", "NAMED_OMID_SCOPE", "NAMED_OPERATIVE_REQ", "NAMED_OTHER_REQ", "NAMED_PUBLIC_JOB", "NAMED_REMOTE", "NAMED_SCAR_SCOPE", "NAMED_SDK", "NAMED_SHOW_SCOPE", "NAMED_TRANSACTION_SCOPE", "PREF_GL_INFO", "SCAR_SIGNALS_FETCH_TIMEOUT", "SCAR_VERSION_FETCH_TIMEOUT", "serviceRegistry", "Lcom/unity3d/services/core/di/IServicesRegistry;", "getRegistry", MobileAdsBridgeBase.initializeMethodName, "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ServiceProvider implements IServiceProvider {
    public static final String CDN_CREATIVES_HOST = "cdn-creatives-cf-prd.acquire.unity3dusercontent.com";
    public static final int CDN_CREATIVES_PORT = 443;
    public static final String DATA_STORE_GATEWAY_CACHE = "gateway_cache.pb";
    public static final String DATA_STORE_GL_INFO = "glinfo.pb";
    public static final String DATA_STORE_IAP_TRANSACTION = "iap_transaction.pb";
    public static final String DATA_STORE_NATIVE_CONFIG = "native_configuration.pb";
    public static final String DATA_STORE_PRIVACY = "privacy.pb";
    public static final String DATA_STORE_PRIVACY_FSM = "privacy_fsm.pb";
    public static final String DATA_STORE_UNIVERSAL_REQUEST = "universal_request.pb";
    public static final String DATA_STORE_WEBVIEW_CONFIG = "webview_config.pb";
    public static final String DEFAULT_DISPATCHER = "default_dispatcher";
    public static final String DEV_CONSENT_PRIVACY_RULES = "dev_consent_privacy_rules";
    public static final String GATEWAY_HOST = "gateway.unityads.unity3d.com";
    public static final int GATEWAY_PORT = 443;
    public static final long HTTP_CACHE_DISK_SIZE = 20971520;
    public static final long HTTP_CLIENT_FETCH_TIMEOUT = 500;
    public static final ServiceProvider INSTANCE;
    public static final String IO_DISPATCHER = "io_dispatcher";
    public static final String LEGACY_PRIVACY_RULES = "legacy_privacy_rules";
    public static final String MAIN_DISPATCHER = "main_dispatcher";
    public static final String NAMED_AD_REQ = "ad_req";
    public static final String NAMED_GATEWAY_HTTP_CLIENT = "gateway_http_client";
    public static final String NAMED_GET_TOKEN_SCOPE = "get_token_scope";
    public static final String NAMED_INIT_REQ = "init_req";
    public static final String NAMED_INIT_SCOPE = "init_scope";
    public static final String NAMED_LOAD_SCOPE = "load_scope";
    public static final String NAMED_LOCAL = "local";
    public static final String NAMED_OFFERWALL_SCOPE = "offerwall_scope";
    public static final String NAMED_OMID_SCOPE = "omid_scope";
    public static final String NAMED_OPERATIVE_REQ = "op_event_req";
    public static final String NAMED_OTHER_REQ = "other_req";
    public static final String NAMED_PUBLIC_JOB = "public_job";
    public static final String NAMED_REMOTE = "remote";
    public static final String NAMED_SCAR_SCOPE = "scar_scope";
    public static final String NAMED_SDK = "sdk";
    public static final String NAMED_SHOW_SCOPE = "show_scope";
    public static final String NAMED_TRANSACTION_SCOPE = "transaction_scope";
    public static final String PREF_GL_INFO = "glinfo";
    public static final long SCAR_SIGNALS_FETCH_TIMEOUT = 50000;
    public static final long SCAR_VERSION_FETCH_TIMEOUT = 5000;
    private static final IServicesRegistry serviceRegistry;

    private ServiceProvider() {
    }

    static {
        ServiceProvider serviceProvider = new ServiceProvider();
        INSTANCE = serviceProvider;
        serviceRegistry = serviceProvider.initialize();
    }

    @Override // com.unity3d.services.core.di.IServiceProvider
    public IServicesRegistry getRegistry() {
        return serviceRegistry;
    }

    @Override // com.unity3d.services.core.di.IServiceProvider
    public IServicesRegistry initialize() {
        return ServicesRegistryKt.registry(new Function1<ServicesRegistry, Unit>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServicesRegistry servicesRegistry) {
                invoke2(servicesRegistry);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final ServicesRegistry registry) {
                Intrinsics.checkNotNullParameter(registry, "$this$registry");
                final UnityAdsModule unityAdsModule = new UnityAdsModule();
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class)), LazyKt.lazy(new Function0<Context>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Context invoke() {
                        return ClientProperties.getApplicationContext();
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class)), LazyKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineDispatcher invoke() {
                        return UnityAdsModule.this.mainDispatcher();
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class)), LazyKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineDispatcher invoke() {
                        return UnityAdsModule.this.defaultDispatcher();
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class)), LazyKt.lazy(new Function0<CoroutineDispatcher>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineDispatcher invoke() {
                        return UnityAdsModule.this.ioDispatcher();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class)), LazyKt.lazy(new Function0<ISDKDispatchers>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.5
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ISDKDispatchers invoke() {
                        return UnityAdsModule.this.sdkDispatchers();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class)), LazyKt.lazy(new Function0<SDKMetricsSender>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.6
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SDKMetricsSender invoke() {
                        return UnityAdsModule.this.sdkMetrics();
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_INIT_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class)), ServiceFactoryKt.factoryOf(new Function0<CoroutineScope>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineScope invoke() {
                        return UnityAdsModule.this.initCoroutineScope((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (CoroutineExceptionHandler) registry.resolveService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class))), (Job) registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, Reflection.getOrCreateKotlinClass(Job.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_LOAD_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class)), ServiceFactoryKt.factoryOf(new Function0<CoroutineScope>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineScope invoke() {
                        return UnityAdsModule.this.loadCoroutineScope((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (CoroutineExceptionHandler) registry.resolveService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class))), (Job) registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, Reflection.getOrCreateKotlinClass(Job.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_SHOW_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class)), ServiceFactoryKt.factoryOf(new Function0<CoroutineScope>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineScope invoke() {
                        return UnityAdsModule.this.showCoroutineScope((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (CoroutineExceptionHandler) registry.resolveService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class))), (Job) registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, Reflection.getOrCreateKotlinClass(Job.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_TRANSACTION_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class)), ServiceFactoryKt.factoryOf(new Function0<CoroutineScope>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineScope invoke() {
                        return UnityAdsModule.this.transactionCoroutineScope((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (CoroutineExceptionHandler) registry.resolveService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class))), (Job) registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, Reflection.getOrCreateKotlinClass(Job.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_GET_TOKEN_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class)), ServiceFactoryKt.factoryOf(new Function0<CoroutineScope>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.11
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineScope invoke() {
                        return UnityAdsModule.this.getTokenCoroutineScope((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (CoroutineExceptionHandler) registry.resolveService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class))), (Job) registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, Reflection.getOrCreateKotlinClass(Job.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_SCAR_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class)), ServiceFactoryKt.factoryOf(new Function0<CoroutineScope>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.12
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineScope invoke() {
                        return UnityAdsModule.this.scarSignalsCoroutineScope((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (CoroutineExceptionHandler) registry.resolveService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class))), (Job) registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, Reflection.getOrCreateKotlinClass(Job.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_OFFERWALL_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class)), ServiceFactoryKt.factoryOf(new Function0<CoroutineScope>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.13
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineScope invoke() {
                        return UnityAdsModule.this.offerwallSignalsCoroutineScope((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (CoroutineExceptionHandler) registry.resolveService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class))), (Job) registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, Reflection.getOrCreateKotlinClass(Job.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_OMID_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class)), ServiceFactoryKt.factoryOf(new Function0<CoroutineScope>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.14
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineScope invoke() {
                        return UnityAdsModule.this.omidCoroutineScope((ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (CoroutineExceptionHandler) registry.resolveService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class))), (Job) registry.resolveService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, Reflection.getOrCreateKotlinClass(Job.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_PUBLIC_JOB, Reflection.getOrCreateKotlinClass(Job.class)), ServiceFactoryKt.factoryOf(new Function0<Job>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.15
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Job invoke() {
                        return UnityAdsModule.this.publicApiJob((DiagnosticEventRepository) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.16
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ByteStringDataSource invoke() {
                        return new AndroidLegacyConfigStoreDataSource((StorageManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StorageManager.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<ByteStringStoreOuterClass.ByteStringStore>>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.17
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                        return UnityAdsModule.this.privacyDataStore((Context) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (CoroutineDispatcher) registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.18
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ByteStringDataSource invoke() {
                        return UnityAdsModule.this.privacyDataStore((DataStore) registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, Reflection.getOrCreateKotlinClass(DataStore.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<ByteStringStoreOuterClass.ByteStringStore>>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.19
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                        return UnityAdsModule.this.privacyFsmDataStore((Context) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (CoroutineDispatcher) registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.20
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ByteStringDataSource invoke() {
                        return UnityAdsModule.this.privacyFsmDataStore((DataStore) registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, Reflection.getOrCreateKotlinClass(DataStore.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<ByteStringStoreOuterClass.ByteStringStore>>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.21
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                        return UnityAdsModule.this.nativeConfigurationDataStore((Context) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (CoroutineDispatcher) registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.22
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ByteStringDataSource invoke() {
                        return UnityAdsModule.this.nativeConfigurationDataStore((DataStore) registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, Reflection.getOrCreateKotlinClass(DataStore.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<ByteStringStoreOuterClass.ByteStringStore>>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.23
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                        return UnityAdsModule.this.glInfoDataStore((Context) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (CoroutineDispatcher) registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (DataMigration) registry.resolveService(new ServiceKey(ServiceProvider.PREF_GL_INFO, Reflection.getOrCreateKotlinClass(DataMigration.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.24
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ByteStringDataSource invoke() {
                        return UnityAdsModule.this.glInfoDataStore((DataStore) registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, Reflection.getOrCreateKotlinClass(DataStore.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_UNIVERSAL_REQUEST, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore>>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.25
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> invoke() {
                        return UnityAdsModule.this.universalRequestDataStore((Context) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (CoroutineDispatcher) registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<ByteStringStoreOuterClass.ByteStringStore>>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.26
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DataStore<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                        return UnityAdsModule.this.iapTransactionDataStore((Context) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (CoroutineDispatcher) registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class)), LazyKt.lazy(new Function0<ByteStringDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.27
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ByteStringDataSource invoke() {
                        return UnityAdsModule.this.iapTransactionDataStore((DataStore) registry.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, Reflection.getOrCreateKotlinClass(DataStore.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DATA_STORE_WEBVIEW_CONFIG, Reflection.getOrCreateKotlinClass(DataStore.class)), LazyKt.lazy(new Function0<DataStore<WebviewConfigurationStore.WebViewConfigurationStore>>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.28
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DataStore<WebviewConfigurationStore.WebViewConfigurationStore> invoke() {
                        return UnityAdsModule.this.webViewConfigurationDataStore((Context) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (CoroutineDispatcher) registry.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AsyncTokenStorage.class)), LazyKt.lazy(new Function0<AsyncTokenStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.29
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AsyncTokenStorage invoke() {
                        return UnityAdsModule.this.asyncTokenStorage((TokenStorage) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TokenStorage.class))), (SDKMetricsSender) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(VolumeChangeMonitor.class)), LazyKt.lazy(new Function0<VolumeChangeMonitor>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.30
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final VolumeChangeMonitor invoke() {
                        return UnityAdsModule.this.volumeChangeMonitor((VolumeChange) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(VolumeChange.class))));
                    }
                }));
                registry.updateService(new ServiceKey("PUBLIC", Reflection.getOrCreateKotlinClass(JsonStorage.class)), LazyKt.lazy(new Function0<JsonStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.31
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final JsonStorage invoke() {
                        return UnityAdsModule.this.publicJsonStorage();
                    }
                }));
                registry.updateService(new ServiceKey("PRIVATE", Reflection.getOrCreateKotlinClass(JsonStorage.class)), LazyKt.lazy(new Function0<JsonStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.32
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final JsonStorage invoke() {
                        return UnityAdsModule.this.privateJsonStorage();
                    }
                }));
                registry.updateService(new ServiceKey("MEMORY", Reflection.getOrCreateKotlinClass(JsonStorage.class)), LazyKt.lazy(new Function0<JsonStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.33
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final JsonStorage invoke() {
                        return UnityAdsModule.this.memoryJsonStorage();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(NativeConfigurationOuterClass.NativeConfiguration.class)), LazyKt.lazy(new Function0<NativeConfigurationOuterClass.NativeConfiguration>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.34
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final NativeConfigurationOuterClass.NativeConfiguration invoke() {
                        return UnityAdsModule.this.defaultNativeConfiguration();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MeasurementsService.class)), LazyKt.lazy(new Function0<MeasurementsService>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.35
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MeasurementsService invoke() {
                        return UnityAdsModule.this.measurementService((Context) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TopicsService.class)), LazyKt.lazy(new Function0<TopicsService>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.36
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TopicsService invoke() {
                        return UnityAdsModule.this.topicsService((Context) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ISDKDispatchers) registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CronetEngineBuilderFactory.class)), LazyKt.lazy(new Function0<CronetEngineBuilderFactory>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.37
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CronetEngineBuilderFactory invoke() {
                        return new CronetEngineBuilderFactory();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClientProvider.class)), LazyKt.lazy(new Function0<HttpClientProvider>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.38
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HttpClientProvider invoke() {
                        return new AndroidHttpClientProvider((ConfigFileFromLocalStorage) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class))), (AlternativeFlowReader) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class))), (ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (CronetEngineBuilderFactory) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CronetEngineBuilderFactory.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (CleanupDirectory) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CleanupDirectory.class))), (MediationTraitsMetadataReader) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationTraitsMetadataReader.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClient.class)), LazyKt.lazy(new Function0<HttpClient>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.39
                    {
                        super(0);
                    }

                    /* compiled from: ServiceProvider.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/services/core/network/core/HttpClient;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "com.unity3d.services.core.di.ServiceProvider$initialize$1$39$1", f = "ServiceProvider.kt", i = {}, l = {444}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$39$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpClient>, Object> {
                        final /* synthetic */ ServicesRegistry $this_registry;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(ServicesRegistry servicesRegistry, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$this_registry = servicesRegistry;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$this_registry, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpClient> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i != 0) {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            Object invoke$default = HttpClientProvider.DefaultImpls.invoke$default((HttpClientProvider) this.$this_registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClientProvider.class))), false, this, 1, null);
                            return invoke$default == coroutine_suspended ? coroutine_suspended : invoke$default;
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HttpClient invoke() {
                        Object runBlocking$default;
                        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(ServicesRegistry.this, null), 1, null);
                        return (HttpClient) runBlocking$default;
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_GATEWAY_HTTP_CLIENT, Reflection.getOrCreateKotlinClass(HttpClient.class)), LazyKt.lazy(new Function0<HttpClient>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.40
                    {
                        super(0);
                    }

                    /* compiled from: ServiceProvider.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/services/core/network/core/HttpClient;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "com.unity3d.services.core.di.ServiceProvider$initialize$1$40$1", f = "ServiceProvider.kt", i = {}, l = {445}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.unity3d.services.core.di.ServiceProvider$initialize$1$40$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpClient>, Object> {
                        final /* synthetic */ ServicesRegistry $this_registry;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(ServicesRegistry servicesRegistry, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$this_registry = servicesRegistry;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$this_registry, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpClient> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i != 0) {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            Object invoke = ((HttpClientProvider) this.$this_registry.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClientProvider.class)))).invoke(true, this);
                            return invoke == coroutine_suspended ? coroutine_suspended : invoke;
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HttpClient invoke() {
                        Object runBlocking$default;
                        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(ServicesRegistry.this, null), 1, null);
                        return (HttpClient) runBlocking$default;
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationTraitsMetadataReader.class)), ServiceFactoryKt.factoryOf(new Function0<MediationTraitsMetadataReader>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.41
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MediationTraitsMetadataReader invoke() {
                        return new MediationTraitsMetadataReader((JsonStorage) ServicesRegistry.this.resolveService(new ServiceKey("MEMORY", Reflection.getOrCreateKotlinClass(JsonStorage.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class)), LazyKt.lazy(new Function0<AlternativeFlowReader>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.42
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AlternativeFlowReader invoke() {
                        return new AlternativeFlowReader((ConfigurationReader) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigurationReader.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (MediationTraitsMetadataReader) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationTraitsMetadataReader.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TcfDataSource.class)), LazyKt.lazy(new Function0<TcfDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.43
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TcfDataSource invoke() {
                        return new AndroidTcfDataSource();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TcfRepository.class)), LazyKt.lazy(new Function0<TcfRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.44
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TcfRepository invoke() {
                        return new AndroidTcfRepository((TcfDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TcfDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidManifestIntPropertyReader.class)), LazyKt.lazy(new Function0<AndroidManifestIntPropertyReader>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.45
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AndroidManifestIntPropertyReader invoke() {
                        return new AndroidManifestIntPropertyReader((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidTestDataInfo.class)), LazyKt.lazy(new Function0<AndroidTestDataInfo>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.46
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AndroidTestDataInfo invoke() {
                        return new AndroidTestDataInfo((AndroidManifestIntPropertyReader) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidManifestIntPropertyReader.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GameServerIdReader.class)), LazyKt.lazy(new Function0<GameServerIdReader>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.47
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GameServerIdReader invoke() {
                        return new GameServerIdReader((JsonStorage) ServicesRegistry.this.resolveService(new ServiceKey("PUBLIC", Reflection.getOrCreateKotlinClass(JsonStorage.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StoreDataSource.class)), LazyKt.lazy(new Function0<StoreDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.48
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final StoreDataSource invoke() {
                        return new AndroidStoreDataSource((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AnalyticsDataSource.class)), LazyKt.lazy(new Function0<AnalyticsDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.49
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AnalyticsDataSource invoke() {
                        return new AndroidAnalyticsDataSource();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeveloperConsentDataSource.class)), LazyKt.lazy(new Function0<DeveloperConsentDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.50
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DeveloperConsentDataSource invoke() {
                        return new AndroidDeveloperConsentDataSource((FlattenerRulesUseCase) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEV_CONSENT_PRIVACY_RULES, Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class))), (JsonStorage) ServicesRegistry.this.resolveService(new ServiceKey("PUBLIC", Reflection.getOrCreateKotlinClass(JsonStorage.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DynamicDeviceInfoDataSource.class)), LazyKt.lazy(new Function0<DynamicDeviceInfoDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.51
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DynamicDeviceInfoDataSource invoke() {
                        return new AndroidDynamicDeviceInfoDataSource((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (LifecycleDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LifecycleDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyUserConsentDataSource.class)), LazyKt.lazy(new Function0<LegacyUserConsentDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.52
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LegacyUserConsentDataSource invoke() {
                        return new AndroidLegacyUserConsentDataSource((FlattenerRulesUseCase) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.LEGACY_PRIVACY_RULES, Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class))), (JsonStorage) ServicesRegistry.this.resolveService(new ServiceKey("PRIVATE", Reflection.getOrCreateKotlinClass(JsonStorage.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LifecycleDataSource.class)), LazyKt.lazy(new Function0<LifecycleDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.53
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LifecycleDataSource invoke() {
                        return new AndroidLifecycleDataSource();
                    }
                }));
                registry.updateService(new ServiceKey("local", Reflection.getOrCreateKotlinClass(CacheDataSource.class)), LazyKt.lazy(new Function0<CacheDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.54
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CacheDataSource invoke() {
                        return new AndroidLocalCacheDataSource((CreateFile) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CreateFile.class))), (GetFileExtensionFromUrl) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetFileExtensionFromUrl.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CreateFile.class)), LazyKt.lazy(new Function0<CreateFile>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.55
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CreateFile invoke() {
                        return new CommonCreateFile();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetFileExtensionFromUrl.class)), LazyKt.lazy(new Function0<GetFileExtensionFromUrl>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.56
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetFileExtensionFromUrl invoke() {
                        return new CommonGetFileExtensionFromUrl((RemoveUrlQuery) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(RemoveUrlQuery.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(RemoveUrlQuery.class)), LazyKt.lazy(new Function0<RemoveUrlQuery>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.57
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final RemoveUrlQuery invoke() {
                        return new AndroidRemoveUrlQuery();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationDataSource.class)), LazyKt.lazy(new Function0<MediationDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.58
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MediationDataSource invoke() {
                        return new AndroidMediationDataSource((JsonStorage) ServicesRegistry.this.resolveService(new ServiceKey("MEMORY", Reflection.getOrCreateKotlinClass(JsonStorage.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(PrivacyDeviceInfoDataSource.class)), LazyKt.lazy(new Function0<PrivacyDeviceInfoDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.59
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final PrivacyDeviceInfoDataSource invoke() {
                        return new AndroidPrivacyDeviceInfoDataSource((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (FIdDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(FIdDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_REMOTE, Reflection.getOrCreateKotlinClass(CacheDataSource.class)), LazyKt.lazy(new Function0<CacheDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.60
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CacheDataSource invoke() {
                        return new AndroidRemoteCacheDataSource((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (CreateFile) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CreateFile.class))), (GetFileExtensionFromUrl) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetFileExtensionFromUrl.class))), (HttpClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClient.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StaticDeviceInfoDataSource.class)), LazyKt.lazy(new Function0<StaticDeviceInfoDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.61
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final StaticDeviceInfoDataSource invoke() {
                        return new AndroidStaticDeviceInfoDataSource((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ByteStringDataSource) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GL_INFO, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (AnalyticsDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AnalyticsDataSource.class))), (StoreDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StoreDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.PREF_GL_INFO, Reflection.getOrCreateKotlinClass(DataMigration.class)), LazyKt.lazy(new Function0<DataMigration<ByteStringStoreOuterClass.ByteStringStore>>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.62
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DataMigration<ByteStringStoreOuterClass.ByteStringStore> invoke() {
                        return new FetchGLInfoDataMigration((GetOpenGLRendererInfo) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOpenGLRendererInfo.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(UniversalRequestDataSource.class)), LazyKt.lazy(new Function0<UniversalRequestDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.63
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final UniversalRequestDataSource invoke() {
                        return new UniversalRequestDataSource((DataStore) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_UNIVERSAL_REQUEST, Reflection.getOrCreateKotlinClass(DataStore.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(WebviewConfigurationDataSource.class)), LazyKt.lazy(new Function0<WebviewConfigurationDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.64
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final WebviewConfigurationDataSource invoke() {
                        return new WebviewConfigurationDataSource((DataStore) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_WEBVIEW_CONFIG, Reflection.getOrCreateKotlinClass(DataStore.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OmidManager.class)), LazyKt.lazy(new Function0<OmidManager>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.65
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final OmidManager invoke() {
                        return new AndroidOmidManager();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKPropertiesManager.class)), LazyKt.lazy(new Function0<SDKPropertiesManager>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.66
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SDKPropertiesManager invoke() {
                        return new AndroidSDKPropertiesManager();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StorageManager.class)), LazyKt.lazy(new Function0<StorageManager>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.67
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final StorageManager invoke() {
                        return new AndroidStorageManager();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TransactionEventManager.class)), LazyKt.lazy(new Function0<TransactionEventManager>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.68
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TransactionEventManager invoke() {
                        return new TransactionEventManager((CoroutineScope) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_TRANSACTION_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class))), (StoreMonitor) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StoreMonitor.class))), (GetTransactionData) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetTransactionData.class))), (GetTransactionRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetTransactionRequest.class))), (TransactionEventRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TransactionEventRepository.class))), (ByteStringDataSource) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class)), LazyKt.lazy(new Function0<AdRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.69
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AdRepository invoke() {
                        return new AndroidAdRepository();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CacheRepository.class)), LazyKt.lazy(new Function0<CacheRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.70
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CacheRepository invoke() {
                        return new AndroidCacheRepository((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (GetCacheDirectory) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetCacheDirectory.class))), (CacheDataSource) ServicesRegistry.this.resolveService(new ServiceKey("local", Reflection.getOrCreateKotlinClass(CacheDataSource.class))), (CacheDataSource) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_REMOTE, Reflection.getOrCreateKotlinClass(CacheDataSource.class))), (Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (CleanupDirectory) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CleanupDirectory.class))), (DownloadPriorityQueue) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DownloadPriorityQueue.class))), (CreateFile) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CreateFile.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetCacheDirectory.class)), LazyKt.lazy(new Function0<GetCacheDirectory>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.71
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetCacheDirectory invoke() {
                        return new CommonGetCacheDirectory();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignRepository.class)), LazyKt.lazy(new Function0<CampaignRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.72
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CampaignRepository invoke() {
                        return new AndroidCampaignRepository((GetSharedDataTimestamps) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeveloperConsentRepository.class)), LazyKt.lazy(new Function0<DeveloperConsentRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.73
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DeveloperConsentRepository invoke() {
                        return new AndroidDeveloperConsentRepository((DeveloperConsentDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeveloperConsentDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class)), LazyKt.lazy(new Function0<DeviceInfoRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.74
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DeviceInfoRepository invoke() {
                        return new AndroidDeviceInfoRepository((StaticDeviceInfoDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StaticDeviceInfoDataSource.class))), (DynamicDeviceInfoDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DynamicDeviceInfoDataSource.class))), (PrivacyDeviceInfoDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(PrivacyDeviceInfoDataSource.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class)), LazyKt.lazy(new Function0<DiagnosticEventRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.75
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DiagnosticEventRepository invoke() {
                        return new AndroidDiagnosticEventRepository((CoroutineTimer) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CoroutineTimer.class))), (GetDiagnosticEventRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetDiagnosticEventRequest.class))), (CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyUserConsentRepository.class)), LazyKt.lazy(new Function0<LegacyUserConsentRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.76
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LegacyUserConsentRepository invoke() {
                        return new AndroidLegacyUserConsentRepository((LegacyUserConsentDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyUserConsentDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationRepository.class)), LazyKt.lazy(new Function0<MediationRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.77
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MediationRepository invoke() {
                        return new AndroidMediationRepository((MediationDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class)), LazyKt.lazy(new Function0<OpenMeasurementRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.78
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final OpenMeasurementRepository invoke() {
                        return new AndroidOpenMeasurementRepository((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (OmidManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OmidManager.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class)), LazyKt.lazy(new Function0<SessionRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.79
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SessionRepository invoke() {
                        return new AndroidSessionRepository((ByteStringDataSource) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_GATEWAY_CACHE, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (ByteStringDataSource) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (ByteStringDataSource) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_PRIVACY_FSM, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (ByteStringDataSource) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))), (NativeConfigurationOuterClass.NativeConfiguration) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(NativeConfigurationOuterClass.NativeConfiguration.class))), (CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TransactionEventRepository.class)), LazyKt.lazy(new Function0<TransactionEventRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.80
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TransactionEventRepository invoke() {
                        return new AndroidTransactionEventRepository();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OperativeEventRepository.class)), LazyKt.lazy(new Function0<OperativeEventRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.81
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final OperativeEventRepository invoke() {
                        return new OperativeEventRepository();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ExecuteAdViewerRequest.class)), LazyKt.lazy(new Function0<ExecuteAdViewerRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.82
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ExecuteAdViewerRequest invoke() {
                        return new AndroidExecuteAdViewerRequest((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (HttpClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClient.class))), (GetCachedAsset) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetCachedAsset.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetByteStringId.class)), LazyKt.lazy(new Function0<GetByteStringId>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.83
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetByteStringId invoke() {
                        return new AndroidGenerateByteStringId();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleOpenUrl.class)), LazyKt.lazy(new Function0<HandleOpenUrl>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.84
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HandleOpenUrl invoke() {
                        return new AndroidHandleOpenUrl((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Refresh.class)), LazyKt.lazy(new Function0<Refresh>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.85
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Refresh invoke() {
                        return new AndroidRefresh((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (GetAdDataRefreshRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdDataRefreshRequest.class))), (GetRequestPolicy) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (GatewayClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class)), LazyKt.lazy(new Function0<SendDiagnosticEvent>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.86
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SendDiagnosticEvent invoke() {
                        return new AndroidSendDiagnosticEvent((DiagnosticEventRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class))), (GetDiagnosticEventRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetDiagnosticEventRequest.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendWebViewClientErrorDiagnostics.class)), LazyKt.lazy(new Function0<SendWebViewClientErrorDiagnostics>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.87
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SendWebViewClientErrorDiagnostics invoke() {
                        return new AndroidSendWebViewClientErrorDiagnostics((SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Show.class)), LazyKt.lazy(new Function0<Show>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.88
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Show invoke() {
                        return new AndroidShow((AdRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))), (GameServerIdReader) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GameServerIdReader.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CacheFile.class)), LazyKt.lazy(new Function0<CacheFile>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.89
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CacheFile invoke() {
                        return new CommonCacheFile((CacheRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CacheRepository.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CleanAssets.class)), LazyKt.lazy(new Function0<CleanAssets>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.90
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CleanAssets invoke() {
                        return new CommonCleanAssets((CacheRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CacheRepository.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdObject.class)), LazyKt.lazy(new Function0<GetAdObject>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.91
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetAdObject invoke() {
                        return new CommonGetAdObject((AdRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetHeaderBiddingToken.class)), ServiceFactoryKt.factoryOf(new Function0<GetHeaderBiddingToken>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.92
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetHeaderBiddingToken invoke() {
                        return new CommonGetHeaderBiddingToken((BuildHeaderBiddingToken) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(BuildHeaderBiddingToken.class))), (FetchSignalsAndSendUseCase) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(FetchSignalsAndSendUseCase.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(BuildHeaderBiddingToken.class)), ServiceFactoryKt.factoryOf(new Function0<BuildHeaderBiddingToken>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.93
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final BuildHeaderBiddingToken invoke() {
                        return new AndroidBuildHeaderBiddingToken((GetByteStringId) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetByteStringId.class))), (GetClientInfo) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetClientInfo.class))), (GetSharedDataTimestamps) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class))), (GetLimitedSessionToken) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetLimitedSessionToken.class))), (GetInitializationData) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationData.class))), (DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (CampaignRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignRepository.class))), (TcfRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TcfRepository.class))), (AndroidTestDataInfo) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidTestDataInfo.class))), (OfferwallManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OfferwallManager.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TokenNumberProvider.class)), ServiceFactoryKt.factoryOf(new Function0<TokenNumberProvider>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.94
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TokenNumberProvider invoke() {
                        return new CommonTokenNumberProvider((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationData.class)), LazyKt.lazy(new Function0<GetInitializationData>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.95
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetInitializationData invoke() {
                        return new AndroidGetInitializationData((GetInitializationRequestPayload) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationRequestPayload.class))), (GetUniversalRequestSharedData) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestSharedData.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationInitBlobMetadataReader.class)), ServiceFactoryKt.factoryOf(new Function0<MediationInitBlobMetadataReader>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.96
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MediationInitBlobMetadataReader invoke() {
                        return new MediationInitBlobMetadataReader((JsonStorage) ServicesRegistry.this.resolveService(new ServiceKey("MEMORY", Reflection.getOrCreateKotlinClass(JsonStorage.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationRequestPayload.class)), LazyKt.lazy(new Function0<GetInitializationRequestPayload>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.97
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetInitializationRequestPayload invoke() {
                        return new AndroidGetInitializationRequestPayload((GetClientInfo) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetClientInfo.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (LegacyUserConsentRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyUserConsentRepository.class))), (MediationInitBlobMetadataReader) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationInitBlobMetadataReader.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationState.class)), LazyKt.lazy(new Function0<GetInitializationState>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.98
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetInitializationState invoke() {
                        return new CommonGetInitializationState((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (SDKPropertiesManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKPropertiesManager.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetIsFileCache.class)), LazyKt.lazy(new Function0<GetIsFileCache>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.99
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetIsFileCache invoke() {
                        return new CommonGetIsFileCache((CacheRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CacheRepository.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SetInitializationState.class)), LazyKt.lazy(new Function0<SetInitializationState>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.100
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SetInitializationState invoke() {
                        return new CommonSetInitializationState((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (SDKPropertiesManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKPropertiesManager.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class)), LazyKt.lazy(new Function0<GetRequestPolicy>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.101
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetRequestPolicy invoke() {
                        return new AndroidGetAdRequestPolicy((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdDataRefreshRequest.class)), LazyKt.lazy(new Function0<GetAdDataRefreshRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.102
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetAdDataRefreshRequest invoke() {
                        return new AndroidGetAdDataRefreshRequest((GetUniversalRequestForPayLoad) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (CampaignRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdPlayerConfigRequest.class)), LazyKt.lazy(new Function0<GetAdPlayerConfigRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.103
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetAdPlayerConfigRequest invoke() {
                        return new AndroidGetAdPlayerConfigRequest((GetUniversalRequestForPayLoad) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidGetAdPlayerContext.class)), LazyKt.lazy(new Function0<AndroidGetAdPlayerContext>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.104
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AndroidGetAdPlayerContext invoke() {
                        return new AndroidGetAdPlayerContext((DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdRequest.class)), LazyKt.lazy(new Function0<GetAdRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.105
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetAdRequest invoke() {
                        return new AndroidGetAdRequest((GetUniversalRequestForPayLoad) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (CampaignRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignRepository.class))), (WebviewConfigurationDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(WebviewConfigurationDataSource.class))), (TcfRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TcfRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetHbTokenEventRequest.class)), LazyKt.lazy(new Function0<GetHbTokenEventRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.106
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetHbTokenEventRequest invoke() {
                        return new GetAndroidTokenEventRequest();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CommonScarEventReceiver.class)), LazyKt.lazy(new Function0<CommonScarEventReceiver>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.107
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CommonScarEventReceiver invoke() {
                        return new CommonScarEventReceiver((CoroutineScope) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_SCAR_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GMAScarAdapterBridge.class)), LazyKt.lazy(new Function0<GMAScarAdapterBridge>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.108
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GMAScarAdapterBridge invoke() {
                        GMAScarAdapterBridge bridge = GMA.getInstance(new GMAEventSender((IEventSender) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CommonScarEventReceiver.class))))).getBridge();
                        Intrinsics.checkNotNullExpressionValue(bridge, "getInstance(GMAEventSend…EventReceiver>())).bridge");
                        return bridge;
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ScarTimeHackFixer.class)), LazyKt.lazy(new Function0<ScarTimeHackFixer>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.109
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ScarTimeHackFixer invoke() {
                        return new ScarTimeHackFixer((SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ScarManager.class)), LazyKt.lazy(new Function0<ScarManager>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.110
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ScarManager invoke() {
                        return new AndroidScarManager((CommonScarEventReceiver) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CommonScarEventReceiver.class))), (GMAScarAdapterBridge) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GMAScarAdapterBridge.class))), (ScarTimeHackFixer) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ScarTimeHackFixer.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(FetchSignalsAndSendUseCase.class)), LazyKt.lazy(new Function0<FetchSignalsAndSendUseCase>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.111
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final FetchSignalsAndSendUseCase invoke() {
                        return new AndroidFetchSignalsAndSendUseCase((CoroutineScope) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_SCAR_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (ScarManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ScarManager.class))), (HandleGetTokenRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGetTokenRequest.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LoadScarAd.class)), LazyKt.lazy(new Function0<LoadScarAd>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.112
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LoadScarAd invoke() {
                        return new LoadScarAd((ScarManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ScarManager.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGetTokenRequest.class)), LazyKt.lazy(new Function0<HandleGetTokenRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.113
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HandleGetTokenRequest invoke() {
                        return new HandleAndroidGetTokenRequest((GetUniversalRequestForPayLoad) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (GetHbTokenEventRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetHbTokenEventRequest.class))), (GetRequestPolicy) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (GatewayClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetClientInfo.class)), LazyKt.lazy(new Function0<GetClientInfo>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.114
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetClientInfo invoke() {
                        return new AndroidGetClientInfo((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (MediationRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationRepository.class))), (OmidManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OmidManager.class))), (ScarManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ScarManager.class))), (OfferwallManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OfferwallManager.class))), (FIdExistenceDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(FIdExistenceDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationCompletedRequest.class)), LazyKt.lazy(new Function0<GetInitializationCompletedRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.115
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetInitializationCompletedRequest invoke() {
                        return new AndroidGetInitializationCompletedRequest((GetUniversalRequestForPayLoad) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationRequest.class)), LazyKt.lazy(new Function0<GetInitializationRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.116
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetInitializationRequest invoke() {
                        return new AndroidGetInitializationRequest((GetInitializationRequestPayload) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationRequestPayload.class))), (GetUniversalRequestForPayLoad) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetLimitedSessionToken.class)), LazyKt.lazy(new Function0<GetLimitedSessionToken>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.117
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetLimitedSessionToken invoke() {
                        return new AndroidGetLimitedSessionToken((DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (MediationRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(MediationRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOpenGLRendererInfo.class)), LazyKt.lazy(new Function0<GetOpenGLRendererInfo>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.118
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetOpenGLRendererInfo invoke() {
                        return new AndroidGetOpenGLRendererInfo((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class)), LazyKt.lazy(new Function0<GetSharedDataTimestamps>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.119
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetSharedDataTimestamps invoke() {
                        return new AndroidGetSharedDataTimestamps();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class)), LazyKt.lazy(new Function0<GetUniversalRequestForPayLoad>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.120
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetUniversalRequestForPayLoad invoke() {
                        return new AndroidGetUniversalRequestForPayLoad((GetUniversalRequestSharedData) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestSharedData.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestSharedData.class)), LazyKt.lazy(new Function0<GetUniversalRequestSharedData>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.121
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetUniversalRequestSharedData invoke() {
                        return new AndroidGetUniversalRequestSharedData((GetSharedDataTimestamps) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (GetLimitedSessionToken) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetLimitedSessionToken.class))), (DeveloperConsentRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeveloperConsentRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetCachedAsset.class)), LazyKt.lazy(new Function0<GetCachedAsset>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.122
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetCachedAsset invoke() {
                        return new GetCachedAsset((CacheRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CacheRepository.class))), (Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (CacheWebViewAssets) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CacheWebViewAssets.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetWebViewBridgeUseCase.class)), LazyKt.lazy(new Function0<GetWebViewBridgeUseCase>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.123
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetWebViewBridgeUseCase invoke() {
                        return new CommonGetWebViewBridgeUseCase((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class)), LazyKt.lazy(new Function0<GetRequestPolicy>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.124
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetRequestPolicy invoke() {
                        return new GetInitRequestPolicy((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetLatestWebViewConfiguration.class)), LazyKt.lazy(new Function0<GetLatestWebViewConfiguration>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.125
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetLatestWebViewConfiguration invoke() {
                        return new GetLatestWebViewConfiguration((WebviewConfigurationDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(WebviewConfigurationDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_OPERATIVE_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class)), LazyKt.lazy(new Function0<GetRequestPolicy>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.126
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetRequestPolicy invoke() {
                        return new GetOperativeEventRequestPolicy((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class)), LazyKt.lazy(new Function0<GetRequestPolicy>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.127
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetRequestPolicy invoke() {
                        return new GetOtherRequestPolicy((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetPrivacyUpdateRequest.class)), LazyKt.lazy(new Function0<GetPrivacyUpdateRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.128
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetPrivacyUpdateRequest invoke() {
                        return new GetPrivacyUpdateRequest((GetUniversalRequestForPayLoad) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayInitializationResponse.class)), LazyKt.lazy(new Function0<HandleGatewayInitializationResponse>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.129
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HandleGatewayInitializationResponse invoke() {
                        return new AndroidHandleGatewayInitializationResponse((TransactionEventManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TransactionEventManager.class))), (TriggerInitializationCompletedRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TriggerInitializationCompletedRequest.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (CoroutineScope) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_INIT_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayUniversalResponse.class)), LazyKt.lazy(new Function0<HandleGatewayUniversalResponse>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.130
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HandleGatewayUniversalResponse invoke() {
                        return new AndroidHandleGatewayUniversalResponse((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeBoldSDK.class)), LazyKt.lazy(new Function0<InitializeBoldSDK>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.131
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeBoldSDK invoke() {
                        return new AndroidInitializeBoldSDK((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (InitializeOMSDK) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeOMSDK.class))), (GetInitializationRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationRequest.class))), (GetRequestPolicy) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (CleanAssets) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CleanAssets.class))), (HandleGatewayInitializationResponse) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayInitializationResponse.class))), (GatewayClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (EventObservers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(EventObservers.class))), (TriggerInitializeListener) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TriggerInitializeListener.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (DiagnosticEventRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class))), (StorageManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StorageManager.class))), (ConfigurationReader) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigurationReader.class))), (SDKPropertiesManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKPropertiesManager.class))), (GetGameId) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetGameId.class))), (AndroidHandleFocusCounters) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidHandleFocusCounters.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyShowUseCase.class)), ServiceFactoryKt.factoryOf(new Function0<LegacyShowUseCase>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.132
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LegacyShowUseCase invoke() {
                        return new LegacyShowUseCase((Show) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Show.class))), (AdRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (GetOperativeEventApi) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class))), (GetInitializationState) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationState.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (SafeCallbackInvoke) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SafeCallbackInvoke.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendPrivacyUpdateRequest.class)), LazyKt.lazy(new Function0<SendPrivacyUpdateRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.133
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SendPrivacyUpdateRequest invoke() {
                        return new SendPrivacyUpdateRequest((GetPrivacyUpdateRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetPrivacyUpdateRequest.class))), (GetRequestPolicy) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (GatewayClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TriggerInitializationCompletedRequest.class)), LazyKt.lazy(new Function0<TriggerInitializationCompletedRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.134
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TriggerInitializationCompletedRequest invoke() {
                        return new AndroidTriggerInitializationCompletedRequest((GetInitializationCompletedRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationCompletedRequest.class))), (GetRequestPolicy) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_INIT_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (GatewayClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TriggerInitializeListener.class)), LazyKt.lazy(new Function0<TriggerInitializeListener>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.135
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TriggerInitializeListener invoke() {
                        return new TriggerInitializeListener((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventObserver.class)), LazyKt.lazy(new Function0<DiagnosticEventObserver>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.136
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DiagnosticEventObserver invoke() {
                        return new DiagnosticEventObserver((GetUniversalRequestForPayLoad) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (GetDiagnosticEventBatchRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetDiagnosticEventBatchRequest.class))), (CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (DiagnosticEventRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class))), (UniversalRequestDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(UniversalRequestDataSource.class))), (BackgroundWorker) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(BackgroundWorker.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(EventObservers.class)), LazyKt.lazy(new Function0<EventObservers>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.137
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final EventObservers invoke() {
                        return new EventObservers((OperativeEventObserver) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OperativeEventObserver.class))), (DiagnosticEventObserver) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventObserver.class))), (TransactionEventObserver) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TransactionEventObserver.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetTransactionData.class)), LazyKt.lazy(new Function0<GetTransactionData>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.138
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetTransactionData invoke() {
                        return new AndroidGetTransactionData((GetByteStringId) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetByteStringId.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetTransactionRequest.class)), LazyKt.lazy(new Function0<GetTransactionRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.139
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetTransactionRequest invoke() {
                        return new CommonGetTransactionRequest((DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetDiagnosticEventBatchRequest.class)), LazyKt.lazy(new Function0<GetDiagnosticEventBatchRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.140
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetDiagnosticEventBatchRequest invoke() {
                        return new GetDiagnosticEventBatchRequest();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetDiagnosticEventRequest.class)), LazyKt.lazy(new Function0<GetDiagnosticEventRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.141
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetDiagnosticEventRequest invoke() {
                        return new GetDiagnosticEventRequest((GetSharedDataTimestamps) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class)), LazyKt.lazy(new Function0<GetOperativeEventApi>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.142
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetOperativeEventApi invoke() {
                        return new GetOperativeEventApi((OperativeEventRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OperativeEventRepository.class))), (GetOperativeEventRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOperativeEventRequest.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOperativeEventRequest.class)), LazyKt.lazy(new Function0<GetOperativeEventRequest>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.143
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetOperativeEventRequest invoke() {
                        return new GetOperativeEventRequest((GetByteStringId) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetByteStringId.class))), (DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (CampaignRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayEventResponse.class)), LazyKt.lazy(new Function0<HandleGatewayEventResponse>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.144
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HandleGatewayEventResponse invoke() {
                        return new AndroidHandleGatewayEventResponse();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OperativeEventObserver.class)), LazyKt.lazy(new Function0<OperativeEventObserver>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.145
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final OperativeEventObserver invoke() {
                        return new OperativeEventObserver((GetUniversalRequestForPayLoad) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (OperativeEventRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OperativeEventRepository.class))), (UniversalRequestDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(UniversalRequestDataSource.class))), (BackgroundWorker) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(BackgroundWorker.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TransactionEventObserver.class)), LazyKt.lazy(new Function0<TransactionEventObserver>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.146
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TransactionEventObserver invoke() {
                        return new TransactionEventObserver((GetUniversalRequestForPayLoad) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class))), (CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (TransactionEventRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TransactionEventRepository.class))), (GatewayClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))), (GetRequestPolicy) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_OTHER_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (ByteStringDataSource) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_IAP_TRANSACTION, Reflection.getOrCreateKotlinClass(ByteStringDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(UniversalRequestTtlValidator.class)), LazyKt.lazy(new Function0<UniversalRequestTtlValidator>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.147
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final UniversalRequestTtlValidator invoke() {
                        return new CommonUniversalRequestTtlValidator();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(UniversalRequestEventSender.class)), LazyKt.lazy(new Function0<UniversalRequestEventSender>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.148
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final UniversalRequestEventSender invoke() {
                        return new UniversalRequestEventSender((GatewayClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))), (HandleGatewayEventResponse) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayEventResponse.class))), (UniversalRequestTtlValidator) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(UniversalRequestTtlValidator.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OmFinishSession.class)), LazyKt.lazy(new Function0<OmFinishSession>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.149
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final OmFinishSession invoke() {
                        return new AndroidOmFinishSession((OpenMeasurementRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OmImpressionOccurred.class)), LazyKt.lazy(new Function0<OmImpressionOccurred>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.150
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final OmImpressionOccurred invoke() {
                        return new AndroidOmImpressionOccurred((OpenMeasurementRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidOmInteraction.class)), LazyKt.lazy(new Function0<AndroidOmInteraction>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.151
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AndroidOmInteraction invoke() {
                        return new AndroidOmStartSession((OpenMeasurementRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOmData.class)), LazyKt.lazy(new Function0<GetOmData>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.152
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetOmData invoke() {
                        return new CommonGetOmData((OpenMeasurementRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(IsOMActivated.class)), LazyKt.lazy(new Function0<IsOMActivated>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.153
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IsOMActivated invoke() {
                        return new CommonIsOMActivated((OpenMeasurementRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeOMSDK.class)), LazyKt.lazy(new Function0<InitializeOMSDK>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.154
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeOMSDK invoke() {
                        return new AndroidInitializeOMSDK((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (OpenMeasurementRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.DEV_CONSENT_PRIVACY_RULES, Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class)), LazyKt.lazy(new Function0<FlattenerRulesUseCase>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.155
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final FlattenerRulesUseCase invoke() {
                        return new DeveloperConsentFlattenerRulesUseCase();
                    }
                }));
                registry.updateService(new ServiceKey(ServiceProvider.LEGACY_PRIVACY_RULES, Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class)), LazyKt.lazy(new Function0<FlattenerRulesUseCase>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.156
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final FlattenerRulesUseCase invoke() {
                        return new LegacyUserConsentFlattenerRulesUseCase();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(BackgroundWorker.class)), LazyKt.lazy(new Function0<BackgroundWorker>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.157
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final BackgroundWorker invoke() {
                        return new BackgroundWorker((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DiagnosticEventRequestWorkModifier.class)), LazyKt.lazy(new Function0<DiagnosticEventRequestWorkModifier>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.158
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DiagnosticEventRequestWorkModifier invoke() {
                        return new DiagnosticEventRequestWorkModifier((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (LifecycleDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LifecycleDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class)), LazyKt.lazy(new Function0<GatewayClient>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.159
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GatewayClient invoke() {
                        return new CommonGatewayClient((HttpClient) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_GATEWAY_HTTP_CLIENT, Reflection.getOrCreateKotlinClass(HttpClient.class))), (HandleGatewayUniversalResponse) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayUniversalResponse.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class)), LazyKt.lazy(new Function0<CoroutineExceptionHandler>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.160
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineExceptionHandler invoke() {
                        return new SDKErrorHandler((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.IO_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (AlternativeFlowReader) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (SDKMetricsSender) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TokenStorage.class)), LazyKt.lazy(new Function0<TokenStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.161
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TokenStorage invoke() {
                        return new InMemoryTokenStorage();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(VolumeChange.class)), LazyKt.lazy(new Function0<VolumeChange>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.162
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final VolumeChange invoke() {
                        return new VolumeChangeContentObserver();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class)), LazyKt.lazy(new Function0<ConfigFileFromLocalStorage>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.163
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ConfigFileFromLocalStorage invoke() {
                        return new ConfigFileFromLocalStorage((ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeSDK.class)), LazyKt.lazy(new Function0<InitializeSDK>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.164
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeSDK invoke() {
                        return new InitializeSDK((ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (ConfigFileFromLocalStorage) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class))), (InitializeStateReset) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateReset.class))), (InitializeStateError) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateError.class))), (InitializeStateConfig) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfig.class))), (InitializeStateCreate) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateCreate.class))), (InitializeStateLoadCache) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadCache.class))), (InitializeStateLoadWeb) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadWeb.class))), (InitializeStateComplete) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateComplete.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateComplete.class)), LazyKt.lazy(new Function0<InitializeStateComplete>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.165
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateComplete invoke() {
                        return new InitializeStateComplete((DataStore) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DATA_STORE_NATIVE_CONFIG, Reflection.getOrCreateKotlinClass(DataStore.class))), (ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfig.class)), LazyKt.lazy(new Function0<InitializeStateConfig>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.166
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateConfig invoke() {
                        return new InitializeStateConfig((ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateConfigWithLoader) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfigWithLoader.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateConfigWithLoader.class)), LazyKt.lazy(new Function0<InitializeStateConfigWithLoader>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.167
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateConfigWithLoader invoke() {
                        return new InitializeStateConfigWithLoader((ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateNetworkError) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class))), (TokenStorage) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(TokenStorage.class))), (SDKMetricsSender) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateCreate.class)), LazyKt.lazy(new Function0<InitializeStateCreate>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.168
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateCreate invoke() {
                        return new InitializeStateCreate((ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateError.class)), LazyKt.lazy(new Function0<InitializeStateError>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.169
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateError invoke() {
                        return new InitializeStateError((ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadCache.class)), LazyKt.lazy(new Function0<InitializeStateLoadCache>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.170
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateLoadCache invoke() {
                        return new InitializeStateLoadCache((ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateLoadWeb.class)), LazyKt.lazy(new Function0<InitializeStateLoadWeb>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.171
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateLoadWeb invoke() {
                        return new InitializeStateLoadWeb((ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (InitializeStateNetworkError) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class))), (HttpClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HttpClient.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateReset.class)), LazyKt.lazy(new Function0<InitializeStateReset>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.172
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateReset invoke() {
                        return new InitializeStateReset((ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StoreMonitor.class)), LazyKt.lazy(new Function0<StoreMonitor>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.173
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final StoreMonitor invoke() {
                        return new StoreMonitor((StoreExceptionHandler) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StoreExceptionHandler.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StoreWebViewEventSender.class)), LazyKt.lazy(new Function0<StoreWebViewEventSender>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.174
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final StoreWebViewEventSender invoke() {
                        return new StoreWebViewEventSender((IEventSender) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(IEventSender.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StoreExceptionHandler.class)), LazyKt.lazy(new Function0<StoreExceptionHandler>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.175
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final StoreExceptionHandler invoke() {
                        return new GatewayStoreExceptionHandler();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StoreEventListenerFactory.class)), LazyKt.lazy(new Function0<StoreEventListenerFactory>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.176
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final StoreEventListenerFactory invoke() {
                        return new StoreEventListenerFactory((StoreWebViewEventSender) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(StoreWebViewEventSender.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ConfigurationReader.class)), LazyKt.lazy(new Function0<ConfigurationReader>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.177
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ConfigurationReader invoke() {
                        return new ConfigurationReader();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidAttribution.class)), LazyKt.lazy(new Function0<AndroidAttribution>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.178
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AndroidAttribution invoke() {
                        return new AndroidAttribution((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdPlayerScope.class)), ServiceFactoryKt.factoryOf(new Function0<AdPlayerScope>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.179
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AdPlayerScope invoke() {
                        return new AdPlayerScope((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidWebViewClient.class)), ServiceFactoryKt.factoryOf(new Function0<AndroidWebViewClient>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.180
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AndroidWebViewClient invoke() {
                        return new AndroidWebViewClient((GetCachedAsset) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetCachedAsset.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidGetWebViewContainerUseCase.class)), ServiceFactoryKt.factoryOf(new Function0<AndroidGetWebViewContainerUseCase>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.181
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AndroidGetWebViewContainerUseCase invoke() {
                        return new AndroidGetWebViewContainerUseCase((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))), (AndroidWebViewClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidWebViewClient.class))), (SendWebViewClientErrorDiagnostics) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendWebViewClientErrorDiagnostics.class))), (CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Load.class)), ServiceFactoryKt.factoryOf(new Function0<Load>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.182
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Load invoke() {
                        return new AndroidLoad((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (GetAdRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdRequest.class))), (GetAdPlayerConfigRequest) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdPlayerConfigRequest.class))), (GetRequestPolicy) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_AD_REQ, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class))), (HandleGatewayAdResponse) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayAdResponse.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (GatewayClient) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GatewayClient.class))), (AdRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AwaitInitialization.class)), ServiceFactoryKt.factoryOf(new Function0<AwaitInitialization>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.183
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AwaitInitialization invoke() {
                        return new CommonAwaitInitialization((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAsyncHeaderBiddingToken.class)), ServiceFactoryKt.factoryOf(new Function0<GetAsyncHeaderBiddingToken>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.184
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetAsyncHeaderBiddingToken invoke() {
                        return new CommonInitAwaitingGetHeaderBiddingToken((GetHeaderBiddingToken) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetHeaderBiddingToken.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (GetInitializationState) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationState.class))), (AwaitInitialization) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AwaitInitialization.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (SafeCallbackInvoke) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SafeCallbackInvoke.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdPlayer.class)), ServiceFactoryKt.factoryOf(new Function0<GetAdPlayer>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.185
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetAdPlayer invoke() {
                        return new CommonGetAdPlayer((DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), (CoroutineScope) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdPlayerScope.class))), (OpenMeasurementRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class))), (ScarManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ScarManager.class))), (OfferwallManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OfferwallManager.class))), (AdRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))), (LifecycleDataSource) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LifecycleDataSource.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CacheWebViewAssets.class)), LazyKt.lazy(new Function0<CacheWebViewAssets>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.186
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CacheWebViewAssets invoke() {
                        return new AndroidCacheWebViewAssets((CacheRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CacheRepository.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleGatewayAdResponse.class)), ServiceFactoryKt.factoryOf(new Function0<HandleGatewayAdResponse>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.187
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HandleGatewayAdResponse invoke() {
                        return new AndroidHandleGatewayAdResponse((AdRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))), (AndroidGetWebViewContainerUseCase) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidGetWebViewContainerUseCase.class))), (GetWebViewBridgeUseCase) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetWebViewBridgeUseCase.class))), (DeviceInfoRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class))), (HandleInvocationsFromAdViewer) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleInvocationsFromAdViewer.class))), (CampaignRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CampaignRepository.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (GetOperativeEventApi) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class))), (GetLatestWebViewConfiguration) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetLatestWebViewConfiguration.class))), (AdPlayerScope) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdPlayerScope.class))), (GetAdPlayer) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetAdPlayer.class))), (CacheWebViewAssets) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CacheWebViewAssets.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(HandleInvocationsFromAdViewer.class)), ServiceFactoryKt.factoryOf(new Function0<HandleInvocationsFromAdViewer>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.188
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HandleInvocationsFromAdViewer invoke() {
                        return new HandleInvocationsFromAdViewer();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LegacyLoadUseCase.class)), ServiceFactoryKt.factoryOf(new Function0<LegacyLoadUseCase>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.189
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LegacyLoadUseCase invoke() {
                        return new LegacyLoadUseCase((Load) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Load.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))), (GetInitializationState) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationState.class))), (AwaitInitialization) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AwaitInitialization.class))), (SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (AdRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AdRepository.class))), (SafeCallbackInvoke) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SafeCallbackInvoke.class))), (CleanUpWhenOpportunityExpires) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CleanUpWhenOpportunityExpires.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SafeCallbackInvoke.class)), LazyKt.lazy(new Function0<SafeCallbackInvoke>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.190
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SafeCallbackInvoke invoke() {
                        return new CommonSafeCallbackInvoke((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.MAIN_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class)), ServiceFactoryKt.factoryOf(new Function0<InitializeStateNetworkError>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.191
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final InitializeStateNetworkError invoke() {
                        return new InitializeStateNetworkError((ISDKDispatchers) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CoroutineTimer.class)), ServiceFactoryKt.factoryOf(new Function0<CoroutineTimer>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.192
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineTimer invoke() {
                        return new CommonCoroutineTimer((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(IEventSender.class)), LazyKt.lazy(new Function0<IEventSender>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.193
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IEventSender invoke() {
                        return SharedInstances.INSTANCE.getWebViewEventSender();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SetGameId.class)), LazyKt.lazy(new Function0<SetGameId>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.194
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final SetGameId invoke() {
                        return new CommonSetGameId((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetGameId.class)), LazyKt.lazy(new Function0<GetGameId>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.195
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetGameId invoke() {
                        return new CommonGetGameId((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ValidateGameId.class)), LazyKt.lazy(new Function0<ValidateGameId>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.196
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ValidateGameId invoke() {
                        return new CommonValidateGameId((GetGameId) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetGameId.class))), (SetGameId) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SetGameId.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ShouldAllowInitialization.class)), LazyKt.lazy(new Function0<ShouldAllowInitialization>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.197
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ShouldAllowInitialization invoke() {
                        return new CommonShouldAllowInitialization((AlternativeFlowReader) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class))), (CheckForGameIdAndTestModeChanges) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CheckForGameIdAndTestModeChanges.class))), (GetInitializationState) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetInitializationState.class))), (SetInitializationState) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SetInitializationState.class))), (ValidateGameId) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(ValidateGameId.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CheckForGameIdAndTestModeChanges.class)), LazyKt.lazy(new Function0<CheckForGameIdAndTestModeChanges>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.198
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CheckForGameIdAndTestModeChanges invoke() {
                        return new CommonCheckForGameIdAndTestModeChanges((GetGameId) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetGameId.class))), (SendDiagnosticEvent) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(DownloadPriorityQueue.class)), LazyKt.lazy(new Function0<DownloadPriorityQueue>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.199
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final DownloadPriorityQueue invoke() {
                        return new DownloadPriorityQueue();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CleanupDirectory.class)), LazyKt.lazy(new Function0<CleanupDirectory>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.200
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CleanupDirectory invoke() {
                        return new CleanupDirectory();
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(FocusRepository.class)), LazyKt.lazy(new Function0<FocusRepository>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.201
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final FocusRepository invoke() {
                        return new FocusRepository((AndroidGetLifecycleFlow) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidGetLifecycleFlow.class))), (CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidGetIsAdActivity.class)), LazyKt.lazy(new Function0<AndroidGetIsAdActivity>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.202
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AndroidGetIsAdActivity invoke() {
                        return new AndroidGetIsAdActivity((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidGetLifecycleFlow.class)), LazyKt.lazy(new Function0<AndroidGetLifecycleFlow>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.203
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AndroidGetLifecycleFlow invoke() {
                        return new AndroidGetLifecycleFlow((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidHandleFocusCounters.class)), LazyKt.lazy(new Function0<AndroidHandleFocusCounters>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.204
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final AndroidHandleFocusCounters invoke() {
                        return new AndroidHandleFocusCounters((SessionRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(SessionRepository.class))), (FocusRepository) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(FocusRepository.class))), (AndroidGetIsAdActivity) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(AndroidGetIsAdActivity.class))), (CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))), null, 16, null);
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OfferwallAdapterBridge.class)), LazyKt.lazy(new Function0<OfferwallAdapterBridge>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.205
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final OfferwallAdapterBridge invoke() {
                        return new OfferwallAdapterBridge((CoroutineScope) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.NAMED_OFFERWALL_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OfferwallManager.class)), LazyKt.lazy(new Function0<OfferwallManager>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.206
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final OfferwallManager invoke() {
                        return new AndroidOfferwallManager((OfferwallAdapterBridge) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OfferwallAdapterBridge.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(LoadOfferwallAd.class)), LazyKt.lazy(new Function0<LoadOfferwallAd>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.207
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LoadOfferwallAd invoke() {
                        return new LoadOfferwallAd((OfferwallManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OfferwallManager.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(GetIsOfferwallAdReady.class)), LazyKt.lazy(new Function0<GetIsOfferwallAdReady>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.208
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GetIsOfferwallAdReady invoke() {
                        return new GetIsOfferwallAdReady((OfferwallManager) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(OfferwallManager.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(FIdDataSource.class)), LazyKt.lazy(new Function0<FIdDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.209
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final FIdDataSource invoke() {
                        return new AndroidFIdDataSource((Context) ServicesRegistry.this.resolveService(new ServiceKey("", Reflection.getOrCreateKotlinClass(Context.class))));
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(FIdExistenceDataSource.class)), LazyKt.lazy(new Function0<FIdExistenceDataSource>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.210
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final FIdExistenceDataSource invoke() {
                        return new AndroidFIdExistenceDataSource(Constants.FID_CLASS);
                    }
                }));
                registry.updateService(new ServiceKey("", Reflection.getOrCreateKotlinClass(CleanUpWhenOpportunityExpires.class)), LazyKt.lazy(new Function0<CleanUpWhenOpportunityExpires>() { // from class: com.unity3d.services.core.di.ServiceProvider$initialize$1.211
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CleanUpWhenOpportunityExpires invoke() {
                        return new CleanUpWhenOpportunityExpires((CoroutineDispatcher) ServicesRegistry.this.resolveService(new ServiceKey(ServiceProvider.DEFAULT_DISPATCHER, Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class))));
                    }
                }));
            }
        });
    }
}
