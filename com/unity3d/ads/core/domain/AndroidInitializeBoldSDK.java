package com.unity3d.ads.core.domain;

import com.ironsource.C3337ue;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.core.data.manager.SDKPropertiesManager;
import com.unity3d.ads.core.data.manager.StorageManager;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.exception.InitializationException;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.events.EventObservers;
import com.unity3d.ads.core.domain.om.InitializeOMSDK;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.log.DeviceLog;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.TimeMark;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: AndroidInitializeBoldSDK.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 =2\u00020\u0001:\u0001=B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0002J,\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0002J\u0019\u0010/\u001a\u00020&2\u0006\u00100\u001a\u000201H\u0082@ø\u0001\u0000¢\u0006\u0002\u00102J(\u00103\u001a\u00020&2\u0006\u00104\u001a\u0002052\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0002J!\u00106\u001a\u00020&2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0082@ø\u0001\u0000¢\u0006\u0002\u00107J)\u00108\u001a\u00020&2\u0006\u00104\u001a\u0002052\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0082@ø\u0001\u0000¢\u0006\u0002\u00109J\u0019\u0010:\u001a\u00020&2\u0006\u0010,\u001a\u00020)H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020&H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidInitializeBoldSDK;", "Lcom/unity3d/ads/core/domain/InitializeBoldSDK;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "initializeOM", "Lcom/unity3d/ads/core/domain/om/InitializeOMSDK;", "getInitializeRequest", "Lcom/unity3d/ads/core/domain/GetInitializationRequest;", "getRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "cleanAssets", "Lcom/unity3d/ads/core/domain/CleanAssets;", "handleGatewayInitializationResponse", "Lcom/unity3d/ads/core/domain/HandleGatewayInitializationResponse;", "gatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "eventObservers", "Lcom/unity3d/ads/core/domain/events/EventObservers;", "triggerInitializeListener", "Lcom/unity3d/ads/core/domain/TriggerInitializeListener;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "diagnosticEventRepository", "Lcom/unity3d/ads/core/data/repository/DiagnosticEventRepository;", "storageManager", "Lcom/unity3d/ads/core/data/manager/StorageManager;", "legacyConfigurationReader", "Lcom/unity3d/services/core/configuration/ConfigurationReader;", "sdkPropertiesManager", "Lcom/unity3d/ads/core/data/manager/SDKPropertiesManager;", "getGameId", "Lcom/unity3d/ads/core/domain/GetGameId;", "handleFocusCounters", "Lcom/unity3d/ads/core/domain/AndroidHandleFocusCounters;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/om/InitializeOMSDK;Lcom/unity3d/ads/core/domain/GetInitializationRequest;Lcom/unity3d/ads/core/domain/GetRequestPolicy;Lcom/unity3d/ads/core/domain/CleanAssets;Lcom/unity3d/ads/core/domain/HandleGatewayInitializationResponse;Lcom/unity3d/ads/gatewayclient/GatewayClient;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/domain/events/EventObservers;Lcom/unity3d/ads/core/domain/TriggerInitializeListener;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/core/data/repository/DiagnosticEventRepository;Lcom/unity3d/ads/core/data/manager/StorageManager;Lcom/unity3d/services/core/configuration/ConfigurationReader;Lcom/unity3d/ads/core/data/manager/SDKPropertiesManager;Lcom/unity3d/ads/core/domain/GetGameId;Lcom/unity3d/ads/core/domain/AndroidHandleFocusCounters;)V", "checkCanInitialize", "", "getTags", "", "", "e", "Lcom/unity3d/ads/core/data/model/exception/InitializationException;", "source", "isRetry", "", "handleResponse", C3337ue.n, "Lgatewayprotocol/v1/UniversalResponseOuterClass$UniversalResponse;", "(Lgatewayprotocol/v1/UniversalResponseOuterClass$UniversalResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializationFailure", "startTime", "Lkotlin/time/TimeMark;", "initializationStart", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializationSuccess", "(Lkotlin/time/TimeMark;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupDiagnosticEvents", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidInitializeBoldSDK implements InitializeBoldSDK {
    public static final String MSG_GATEWAY_DENIED = "Gateway communication failure";
    public static final String MSG_NETWORK = "Network";
    public static final String MSG_TIMEOUT = "Timeout";
    public static final String MSG_UNKNOWN = "Initialization failure";
    private final CleanAssets cleanAssets;
    private final CoroutineDispatcher defaultDispatcher;
    private final DiagnosticEventRepository diagnosticEventRepository;
    private final EventObservers eventObservers;
    private final GatewayClient gatewayClient;
    private final GetGameId getGameId;
    private final GetInitializationRequest getInitializeRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final AndroidHandleFocusCounters handleFocusCounters;
    private final HandleGatewayInitializationResponse handleGatewayInitializationResponse;
    private final InitializeOMSDK initializeOM;
    private final ConfigurationReader legacyConfigurationReader;
    private final SDKPropertiesManager sdkPropertiesManager;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final StorageManager storageManager;
    private final TriggerInitializeListener triggerInitializeListener;

    public AndroidInitializeBoldSDK(CoroutineDispatcher defaultDispatcher, InitializeOMSDK initializeOM, GetInitializationRequest getInitializeRequest, GetRequestPolicy getRequestPolicy, CleanAssets cleanAssets, HandleGatewayInitializationResponse handleGatewayInitializationResponse, GatewayClient gatewayClient, SessionRepository sessionRepository, EventObservers eventObservers, TriggerInitializeListener triggerInitializeListener, SendDiagnosticEvent sendDiagnosticEvent, DiagnosticEventRepository diagnosticEventRepository, StorageManager storageManager, ConfigurationReader legacyConfigurationReader, SDKPropertiesManager sdkPropertiesManager, GetGameId getGameId, AndroidHandleFocusCounters handleFocusCounters) {
        Intrinsics.checkNotNullParameter(defaultDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(initializeOM, "initializeOM");
        Intrinsics.checkNotNullParameter(getInitializeRequest, "getInitializeRequest");
        Intrinsics.checkNotNullParameter(getRequestPolicy, "getRequestPolicy");
        Intrinsics.checkNotNullParameter(cleanAssets, "cleanAssets");
        Intrinsics.checkNotNullParameter(handleGatewayInitializationResponse, "handleGatewayInitializationResponse");
        Intrinsics.checkNotNullParameter(gatewayClient, "gatewayClient");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(eventObservers, "eventObservers");
        Intrinsics.checkNotNullParameter(triggerInitializeListener, "triggerInitializeListener");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(diagnosticEventRepository, "diagnosticEventRepository");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(legacyConfigurationReader, "legacyConfigurationReader");
        Intrinsics.checkNotNullParameter(sdkPropertiesManager, "sdkPropertiesManager");
        Intrinsics.checkNotNullParameter(getGameId, "getGameId");
        Intrinsics.checkNotNullParameter(handleFocusCounters, "handleFocusCounters");
        this.defaultDispatcher = defaultDispatcher;
        this.initializeOM = initializeOM;
        this.getInitializeRequest = getInitializeRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.cleanAssets = cleanAssets;
        this.handleGatewayInitializationResponse = handleGatewayInitializationResponse;
        this.gatewayClient = gatewayClient;
        this.sessionRepository = sessionRepository;
        this.eventObservers = eventObservers;
        this.triggerInitializeListener = triggerInitializeListener;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.diagnosticEventRepository = diagnosticEventRepository;
        this.storageManager = storageManager;
        this.legacyConfigurationReader = legacyConfigurationReader;
        this.sdkPropertiesManager = sdkPropertiesManager;
        this.getGameId = getGameId;
        this.handleFocusCounters = handleFocusCounters;
    }

    @Override // com.unity3d.ads.core.domain.InitializeBoldSDK
    public Object invoke(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.defaultDispatcher, new AndroidInitializeBoldSDK$invoke$2(this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleResponse(UniversalResponseOuterClass.UniversalResponse universalResponse, Continuation<? super Unit> continuation) {
        if (universalResponse.hasError()) {
            this.sessionRepository.setShouldInitialize(false);
            throw new InitializationException(MSG_GATEWAY_DENIED, null, "gateway", universalResponse.getError().getErrorText(), 2, null);
        }
        if (!universalResponse.hasPayload()) {
            throw new InitializationException(MSG_GATEWAY_DENIED, null, "gateway", "No payload", 2, null);
        }
        if (!universalResponse.getPayload().hasInitializationResponse()) {
            throw new InitializationException(MSG_GATEWAY_DENIED, null, "gateway", "No initialization response", 2, null);
        }
        HandleGatewayInitializationResponse handleGatewayInitializationResponse = this.handleGatewayInitializationResponse;
        InitializationResponseOuterClass.InitializationResponse initializationResponse = universalResponse.getPayload().getInitializationResponse();
        Intrinsics.checkNotNullExpressionValue(initializationResponse, "response.payload.initializationResponse");
        Object invoke = handleGatewayInitializationResponse.invoke(initializationResponse, continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkCanInitialize() {
        if (!this.sessionRepository.getShouldInitialize()) {
            throw new InitializationException(MSG_GATEWAY_DENIED, null, "gateway", "!sessionRepository.shouldInitialize", 2, null);
        }
        String invoke = this.getGameId.invoke();
        if ((invoke != null ? StringsKt.toIntOrNull(invoke) : null) == null) {
            throw new InitializationException("gameId \"" + invoke + "\" should be a number.", null, "invalid_game_id", invoke, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object initializationStart(String str, boolean z, Continuation<? super Unit> continuation) {
        DeviceLog.debug("Unity Ads Initialization Start");
        this.sdkPropertiesManager.setInitializationTime();
        this.sdkPropertiesManager.setInitializationTimeSinceEpoch();
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_initialization_started", null, MapsKt.mapOf(TuplesKt.to("source", str), TuplesKt.to("is_retry", String.valueOf(z)), TuplesKt.to("kotlin_version", KotlinVersion.CURRENT.toString())), null, null, null, 58, null);
        this.sessionRepository.setInitializationState(InitializationState.INITIALIZING);
        Object invoke = this.eventObservers.invoke(continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a9, code lost:
    
        if (r1.invoke(r2) != r3) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object initializationSuccess(TimeMark timeMark, String str, boolean z, Continuation<? super Unit> continuation) {
        AndroidInitializeBoldSDK$initializationSuccess$1 androidInitializeBoldSDK$initializationSuccess$1;
        int i;
        AndroidInitializeBoldSDK androidInitializeBoldSDK;
        AndroidInitializeBoldSDK androidInitializeBoldSDK2;
        if (continuation instanceof AndroidInitializeBoldSDK$initializationSuccess$1) {
            androidInitializeBoldSDK$initializationSuccess$1 = (AndroidInitializeBoldSDK$initializationSuccess$1) continuation;
            if ((androidInitializeBoldSDK$initializationSuccess$1.label & Integer.MIN_VALUE) != 0) {
                androidInitializeBoldSDK$initializationSuccess$1.label -= Integer.MIN_VALUE;
                Object obj = androidInitializeBoldSDK$initializationSuccess$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidInitializeBoldSDK$initializationSuccess$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    DeviceLog.debug("Unity Ads Initialization Success");
                    SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_initialize_task_success_time", Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(timeMark)), MapsKt.mapOf(TuplesKt.to("source", str), TuplesKt.to("is_retry", String.valueOf(z))), null, null, null, 56, null);
                    this.storageManager.hasInitialized();
                    InitializeOMSDK initializeOMSDK = this.initializeOM;
                    androidInitializeBoldSDK$initializationSuccess$1.L$0 = this;
                    androidInitializeBoldSDK$initializationSuccess$1.label = 1;
                    if (initializeOMSDK.invoke(androidInitializeBoldSDK$initializationSuccess$1) != coroutine_suspended) {
                        androidInitializeBoldSDK = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        androidInitializeBoldSDK2 = (AndroidInitializeBoldSDK) androidInitializeBoldSDK$initializationSuccess$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        androidInitializeBoldSDK2.legacyConfigurationReader.getCurrentConfiguration().deleteFromDisk();
                        androidInitializeBoldSDK2.sessionRepository.setInitializationState(InitializationState.INITIALIZED);
                        androidInitializeBoldSDK2.sdkPropertiesManager.setInitialized(true);
                        androidInitializeBoldSDK2.triggerInitializeListener.success();
                        androidInitializeBoldSDK2.setupDiagnosticEvents();
                        return Unit.INSTANCE;
                    }
                    androidInitializeBoldSDK = (AndroidInitializeBoldSDK) androidInitializeBoldSDK$initializationSuccess$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    androidInitializeBoldSDK.handleFocusCounters.invoke();
                    SessionRepository sessionRepository = androidInitializeBoldSDK.sessionRepository;
                    androidInitializeBoldSDK$initializationSuccess$1.L$0 = androidInitializeBoldSDK;
                    androidInitializeBoldSDK$initializationSuccess$1.label = 3;
                    if (sessionRepository.persistNativeConfiguration(androidInitializeBoldSDK$initializationSuccess$1) != coroutine_suspended) {
                        androidInitializeBoldSDK2 = androidInitializeBoldSDK;
                        androidInitializeBoldSDK2.legacyConfigurationReader.getCurrentConfiguration().deleteFromDisk();
                        androidInitializeBoldSDK2.sessionRepository.setInitializationState(InitializationState.INITIALIZED);
                        androidInitializeBoldSDK2.sdkPropertiesManager.setInitialized(true);
                        androidInitializeBoldSDK2.triggerInitializeListener.success();
                        androidInitializeBoldSDK2.setupDiagnosticEvents();
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                androidInitializeBoldSDK = (AndroidInitializeBoldSDK) androidInitializeBoldSDK$initializationSuccess$1.L$0;
                ResultKt.throwOnFailure(obj);
                CleanAssets cleanAssets = androidInitializeBoldSDK.cleanAssets;
                androidInitializeBoldSDK$initializationSuccess$1.L$0 = androidInitializeBoldSDK;
                androidInitializeBoldSDK$initializationSuccess$1.label = 2;
            }
        }
        androidInitializeBoldSDK$initializationSuccess$1 = new AndroidInitializeBoldSDK$initializationSuccess$1(this, continuation);
        Object obj2 = androidInitializeBoldSDK$initializationSuccess$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidInitializeBoldSDK$initializationSuccess$1.label;
        if (i != 0) {
        }
        CleanAssets cleanAssets2 = androidInitializeBoldSDK.cleanAssets;
        androidInitializeBoldSDK$initializationSuccess$1.L$0 = androidInitializeBoldSDK;
        androidInitializeBoldSDK$initializationSuccess$1.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializationFailure(TimeMark startTime, InitializationException e, String source, boolean isRetry) {
        DeviceLog.debug("Unity Ads Initialization Failure: " + e.getMessage());
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_initialize_task_failure_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(startTime)), getTags(e, source, isRetry), null, null, null, 56, null);
        this.sessionRepository.setInitializationState(InitializationState.FAILED);
        this.sdkPropertiesManager.setInitialized(false);
        this.triggerInitializeListener.error(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, e.getMessage());
        setupDiagnosticEvents();
    }

    private final Map<String, String> getTags(InitializationException e, String source, boolean isRetry) {
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put("operation", OperationType.INITIALIZATION.toString());
        createMapBuilder.put("reason", e.getReason());
        createMapBuilder.put("source", source);
        createMapBuilder.put("is_retry", String.valueOf(isRetry));
        if (e.getReasonDebug() != null) {
            createMapBuilder.put("reason_debug", e.getReasonDebug());
        }
        return MapsKt.build(createMapBuilder);
    }

    private final void setupDiagnosticEvents() {
        NativeConfigurationOuterClass.DiagnosticEventsConfiguration config = this.sessionRepository.getNativeConfiguration().getDiagnosticEvents();
        DiagnosticEventRepository diagnosticEventRepository = this.diagnosticEventRepository;
        Intrinsics.checkNotNullExpressionValue(config, "config");
        diagnosticEventRepository.configure(config);
    }
}
