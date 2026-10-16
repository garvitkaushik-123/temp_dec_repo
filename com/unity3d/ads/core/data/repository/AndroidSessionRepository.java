package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.SessionChange;
import com.unity3d.ads.core.data.model.TokenCounters;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.vungle.ads.internal.protos.Sdk;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import gatewayprotocol.v1.SessionCountersKt;
import gatewayprotocol.v1.SessionCountersOuterClass;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AndroidSessionRepository.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\u0015H\u0016J\u0011\u0010p\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010qJ\u0011\u0010r\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010qJ\u0011\u0010s\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010qJ\b\u0010t\u001a\u00020nH\u0016J\b\u0010u\u001a\u00020nH\u0016J\b\u0010v\u001a\u00020nH\u0016J\b\u0010w\u001a\u00020nH\u0016J\b\u0010x\u001a\u00020nH\u0016J\b\u0010y\u001a\u00020nH\u0016J\b\u0010z\u001a\u00020nH\u0016J\b\u0010{\u001a\u00020nH\u0016J\b\u0010|\u001a\u00020nH\u0016J\b\u0010}\u001a\u00020nH\u0016J\u0011\u0010~\u001a\u00020nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010qJ\b\u0010\u007f\u001a\u00020nH\u0016J\u001b\u0010\u0080\u0001\u001a\u00020n2\u0006\u0010*\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0081\u0001J\u001b\u0010\u0082\u0001\u001a\u00020n2\u0006\u0010*\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0081\u0001J\u001b\u0010\u0083\u0001\u001a\u00020n2\u0006\u0010*\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0081\u0001R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010+\u001a\u0004\u0018\u00010\u00122\b\u0010*\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00100\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b6\u0010-\"\u0004\b7\u0010/R\u0014\u00108\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R$\u0010;\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010AR\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00190\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010AR\u0014\u0010E\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010AR\u0014\u0010F\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010AR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010G\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00170M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001d0QX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020\b0MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020W0VX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR$\u0010Z\u001a\u00020 2\u0006\u0010*\u001a\u00020 8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u00102R$\u0010a\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bb\u00102\"\u0004\bc\u00104R$\u0010d\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00198V@VX\u0096\u000e¢\u0006\f\u001a\u0004\be\u0010A\"\u0004\bf\u0010gR$\u0010h\u001a\u00020%2\u0006\u0010*\u001a\u00020%8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bi\u0010j\"\u0004\bk\u0010l\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0084\u0001"}, d2 = {"Lcom/unity3d/ads/core/data/repository/AndroidSessionRepository;", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "gatewayCacheDataSource", "Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;", "privacyDataSource", "fsmDataSource", "nativeConfigDataSource", "defaultNativeConfiguration", "Lgatewayprotocol/v1/NativeConfigurationOuterClass$NativeConfiguration;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;Lgatewayprotocol/v1/NativeConfigurationOuterClass$NativeConfiguration;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "_currentState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/google/protobuf/ByteString;", "_gameId", "", "_gatewayUrl", "_headerBiddingTokenCounter", "", "_initializationState", "Lcom/unity3d/ads/core/data/model/InitializationState;", "_isFirstInitAttempt", "", "_isTestModeEnabled", "_onChange", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/unity3d/ads/core/data/model/SessionChange;", "_sdkConfiguration", "_sessionCounters", "Lgatewayprotocol/v1/SessionCountersOuterClass$SessionCounters;", "_sessionId", "_sessionToken", "_shouldInitialize", "_tokenCounters", "Lcom/unity3d/ads/core/data/model/TokenCounters;", "featureFlags", "Lgatewayprotocol/v1/NativeConfigurationOuterClass$FeatureFlags;", "getFeatureFlags", "()Lgatewayprotocol/v1/NativeConfigurationOuterClass$FeatureFlags;", "value", AndroidGetAdPlayerContext.KEY_GAME_ID, "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "gatewayState", "getGatewayState", "()Lcom/google/protobuf/ByteString;", "setGatewayState", "(Lcom/google/protobuf/ByteString;)V", "gatewayUrl", "getGatewayUrl", "setGatewayUrl", "headerBiddingTokenCounter", "getHeaderBiddingTokenCounter", "()I", "initializationState", "getInitializationState", "()Lcom/unity3d/ads/core/data/model/InitializationState;", "setInitializationState", "(Lcom/unity3d/ads/core/data/model/InitializationState;)V", "isDiagnosticsEnabled", "()Z", "isFirstInitAttempt", "isInit", "isOmEnabled", "isSdkInitialized", "isTestModeEnabled", "nativeConfiguration", "getNativeConfiguration", "()Lgatewayprotocol/v1/NativeConfigurationOuterClass$NativeConfiguration;", "setNativeConfiguration", "(Lgatewayprotocol/v1/NativeConfigurationOuterClass$NativeConfiguration;)V", "observeInitializationState", "Lkotlinx/coroutines/flow/Flow;", "getObserveInitializationState", "()Lkotlinx/coroutines/flow/Flow;", "onChange", "Lkotlinx/coroutines/flow/SharedFlow;", "getOnChange", "()Lkotlinx/coroutines/flow/SharedFlow;", "persistedNativeConfiguration", "scarEligibleFormats", "", "Lgatewayprotocol/v1/InitializationResponseOuterClass$AdFormat;", "getScarEligibleFormats", "()Ljava/util/List;", "sessionCounters", "getSessionCounters", "()Lgatewayprotocol/v1/SessionCountersOuterClass$SessionCounters;", "setSessionCounters", "(Lgatewayprotocol/v1/SessionCountersOuterClass$SessionCounters;)V", JsonStorageKeyNames.SESSION_ID_KEY, "getSessionId", "sessionToken", "getSessionToken", "setSessionToken", "shouldInitialize", "getShouldInitialize", "setShouldInitialize", "(Z)V", "tokenCounters", "getTokenCounters", "()Lcom/unity3d/ads/core/data/model/TokenCounters;", "setTokenCounters", "(Lcom/unity3d/ads/core/data/model/TokenCounters;)V", "addTimeToGlobalAdsFocusTime", "", "timeMs", "getGatewayCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrivacy", "getPrivacyFsm", "incrementBannerImpressionCount", "incrementBannerLoadRequestAdmCount", "incrementBannerLoadRequestCount", "incrementFocusChangeCount", "incrementGlobalAdsFocusChangeCount", "incrementLoadRequestAdmCount", "incrementLoadRequestCount", "incrementTokenSequenceNumber", "incrementTokenStartsCount", "incrementTokenWinsCount", "persistNativeConfiguration", "resetTokenCounters", "setGatewayCache", "(Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPrivacy", "setPrivacyFsm", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidSessionRepository implements SessionRepository {
    private final MutableStateFlow<ByteString> _currentState;
    private MutableStateFlow<String> _gameId;
    private final MutableStateFlow<String> _gatewayUrl;
    private final MutableStateFlow<Integer> _headerBiddingTokenCounter;
    private final MutableStateFlow<InitializationState> _initializationState;
    private final MutableStateFlow<Boolean> _isFirstInitAttempt;
    private final MutableStateFlow<Boolean> _isTestModeEnabled;
    private MutableSharedFlow<SessionChange> _onChange;
    private final MutableStateFlow<NativeConfigurationOuterClass.NativeConfiguration> _sdkConfiguration;
    private final MutableStateFlow<SessionCountersOuterClass.SessionCounters> _sessionCounters;
    private final MutableStateFlow<ByteString> _sessionId;
    private final MutableStateFlow<ByteString> _sessionToken;
    private final MutableStateFlow<Boolean> _shouldInitialize;
    private final MutableStateFlow<TokenCounters> _tokenCounters;
    private final ByteStringDataSource fsmDataSource;
    private final ByteStringDataSource gatewayCacheDataSource;
    private final MutableStateFlow<Boolean> isInit;
    private final ByteStringDataSource nativeConfigDataSource;
    private final SharedFlow<SessionChange> onChange;
    private final Flow<NativeConfigurationOuterClass.NativeConfiguration> persistedNativeConfiguration;
    private final ByteStringDataSource privacyDataSource;
    private final List<InitializationResponseOuterClass.AdFormat> scarEligibleFormats;

    public AndroidSessionRepository(ByteStringDataSource gatewayCacheDataSource, ByteStringDataSource privacyDataSource, ByteStringDataSource fsmDataSource, ByteStringDataSource nativeConfigDataSource, NativeConfigurationOuterClass.NativeConfiguration defaultNativeConfiguration, CoroutineDispatcher dispatcher, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(gatewayCacheDataSource, "gatewayCacheDataSource");
        Intrinsics.checkNotNullParameter(privacyDataSource, "privacyDataSource");
        Intrinsics.checkNotNullParameter(fsmDataSource, "fsmDataSource");
        Intrinsics.checkNotNullParameter(nativeConfigDataSource, "nativeConfigDataSource");
        Intrinsics.checkNotNullParameter(defaultNativeConfiguration, "defaultNativeConfiguration");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.gatewayCacheDataSource = gatewayCacheDataSource;
        this.privacyDataSource = privacyDataSource;
        this.fsmDataSource = fsmDataSource;
        this.nativeConfigDataSource = nativeConfigDataSource;
        MutableStateFlow<NativeConfigurationOuterClass.NativeConfiguration> MutableStateFlow = StateFlowKt.MutableStateFlow(defaultNativeConfiguration);
        this._sdkConfiguration = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this.isInit = MutableStateFlow2;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatcher), null, null, new AnonymousClass1(sendDiagnosticEvent, null), 3, null);
        final Flow flowCombine = FlowKt.flowCombine(MutableStateFlow, MutableStateFlow2, new AndroidSessionRepository$persistedNativeConfiguration$1(null));
        final Flow<Pair<? extends NativeConfigurationOuterClass.NativeConfiguration, ? extends Boolean>> flow = new Flow<Pair<? extends NativeConfigurationOuterClass.NativeConfiguration, ? extends Boolean>>() { // from class: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$filter$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$filter$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$filter$1$2", f = "AndroidSessionRepository.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                /* renamed from: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$filter$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (((Boolean) ((Pair) obj).getSecond()).booleanValue()) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Pair<? extends NativeConfigurationOuterClass.NativeConfiguration, ? extends Boolean>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.persistedNativeConfiguration = new Flow<NativeConfigurationOuterClass.NativeConfiguration>() { // from class: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$map$1$2", f = "AndroidSessionRepository.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                /* renamed from: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                Object first = ((Pair) obj).getFirst();
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(first, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super NativeConfigurationOuterClass.NativeConfiguration> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.scarEligibleFormats = new ArrayList();
        MutableSharedFlow<SessionChange> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._onChange = MutableSharedFlow$default;
        this.onChange = FlowKt.asSharedFlow(MutableSharedFlow$default);
        String gameId = ClientProperties.getGameId();
        this._gameId = StateFlowKt.MutableStateFlow(gameId != null ? gameId : null);
        UUID randomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID()");
        this._sessionId = StateFlowKt.MutableStateFlow(ProtobufExtensionsKt.toByteString(randomUUID));
        this._isTestModeEnabled = StateFlowKt.MutableStateFlow(Boolean.valueOf(SdkProperties.isTestMode()));
        SessionCountersOuterClass.SessionCounters build = SessionCountersOuterClass.SessionCounters.newBuilder().build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().build()");
        this._sessionCounters = StateFlowKt.MutableStateFlow(build);
        this._tokenCounters = StateFlowKt.MutableStateFlow(new TokenCounters(0, 0, 0));
        ByteString EMPTY = ByteString.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        this._sessionToken = StateFlowKt.MutableStateFlow(EMPTY);
        ByteString EMPTY2 = ByteString.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
        this._currentState = StateFlowKt.MutableStateFlow(EMPTY2);
        this._gatewayUrl = StateFlowKt.MutableStateFlow(UnityAdsConstants.DefaultUrls.GATEWAY_URL);
        this._initializationState = StateFlowKt.MutableStateFlow(InitializationState.NOT_INITIALIZED);
        this._headerBiddingTokenCounter = StateFlowKt.MutableStateFlow(0);
        this._shouldInitialize = StateFlowKt.MutableStateFlow(true);
        this._isFirstInitAttempt = StateFlowKt.MutableStateFlow(true);
    }

    /* compiled from: AndroidSessionRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidSessionRepository$1", f = "AndroidSessionRepository.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.core.data.repository.AndroidSessionRepository$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SendDiagnosticEvent $sendDiagnosticEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SendDiagnosticEvent sendDiagnosticEvent, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sendDiagnosticEvent = sendDiagnosticEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidSessionRepository.this.new AnonymousClass1(this.$sendDiagnosticEvent, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = AndroidSessionRepository.this.nativeConfigDataSource.get(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ByteString data = ((ByteStringStoreOuterClass.ByteStringStore) obj).getData();
                if (!data.isEmpty()) {
                    MutableStateFlow mutableStateFlow = AndroidSessionRepository.this._sdkConfiguration;
                    NativeConfigurationOuterClass.NativeConfiguration parseFrom = NativeConfigurationOuterClass.NativeConfiguration.parseFrom(data);
                    Intrinsics.checkNotNullExpressionValue(parseFrom, "parseFrom(data)");
                    mutableStateFlow.setValue(parseFrom);
                }
            } catch (Exception e) {
                SendDiagnosticEvent sendDiagnosticEvent = this.$sendDiagnosticEvent;
                String message = e.getMessage();
                if (message == null) {
                    message = "unknown";
                }
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_initialize_missed_native_parsing", null, MapsKt.mapOf(TuplesKt.to("debugReason", message)), null, null, null, 58, null);
            }
            AndroidSessionRepository.this.isInit.setValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public List<InitializationResponseOuterClass.AdFormat> getScarEligibleFormats() {
        return this.scarEligibleFormats;
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public SharedFlow<SessionChange> getOnChange() {
        return this.onChange;
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public String getGameId() {
        String value;
        String gameId;
        MutableStateFlow<String> mutableStateFlow = this._gameId;
        do {
            value = mutableStateFlow.getValue();
            gameId = ClientProperties.getGameId();
            if (gameId == null) {
                gameId = null;
            }
        } while (!mutableStateFlow.compareAndSet(value, gameId));
        return gameId;
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void setGameId(String str) {
        String value;
        MutableStateFlow<String> mutableStateFlow = this._gameId;
        do {
            value = mutableStateFlow.getValue();
            ClientProperties.setGameId(str);
        } while (!mutableStateFlow.compareAndSet(value, str));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public ByteString getSessionId() {
        return this._sessionId.getValue();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public boolean isTestModeEnabled() {
        Boolean value;
        Boolean valueOf;
        MutableStateFlow<Boolean> mutableStateFlow = this._isTestModeEnabled;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
            valueOf = Boolean.valueOf(SdkProperties.isTestMode());
        } while (!mutableStateFlow.compareAndSet(value, valueOf));
        return valueOf.booleanValue();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public SessionCountersOuterClass.SessionCounters getSessionCounters() {
        return this._sessionCounters.getValue();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void setSessionCounters(SessionCountersOuterClass.SessionCounters value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), value)) {
        }
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public TokenCounters getTokenCounters() {
        return this._tokenCounters.getValue();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void setTokenCounters(TokenCounters value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MutableStateFlow<TokenCounters> mutableStateFlow = this._tokenCounters;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), value)) {
        }
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void incrementLoadRequestCount() {
        SessionCountersOuterClass.SessionCounters value;
        SessionCountersKt.Dsl _create;
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        do {
            value = mutableStateFlow.getValue();
            SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.INSTANCE;
            SessionCountersOuterClass.SessionCounters.Builder builder = value.toBuilder();
            Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
            _create = companion._create(builder);
            _create.setLoadRequests(_create.getLoadRequests() + 1);
        } while (!mutableStateFlow.compareAndSet(value, _create._build()));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void incrementLoadRequestAdmCount() {
        SessionCountersOuterClass.SessionCounters value;
        SessionCountersKt.Dsl _create;
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        do {
            value = mutableStateFlow.getValue();
            SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.INSTANCE;
            SessionCountersOuterClass.SessionCounters.Builder builder = value.toBuilder();
            Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
            _create = companion._create(builder);
            _create.setLoadRequestsAdm(_create.getLoadRequestsAdm() + 1);
        } while (!mutableStateFlow.compareAndSet(value, _create._build()));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void incrementBannerLoadRequestCount() {
        SessionCountersOuterClass.SessionCounters value;
        SessionCountersKt.Dsl _create;
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        do {
            value = mutableStateFlow.getValue();
            SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.INSTANCE;
            SessionCountersOuterClass.SessionCounters.Builder builder = value.toBuilder();
            Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
            _create = companion._create(builder);
            _create.setBannerLoadRequests(_create.getBannerLoadRequests() + 1);
        } while (!mutableStateFlow.compareAndSet(value, _create._build()));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void incrementBannerLoadRequestAdmCount() {
        SessionCountersOuterClass.SessionCounters value;
        SessionCountersKt.Dsl _create;
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        do {
            value = mutableStateFlow.getValue();
            SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.INSTANCE;
            SessionCountersOuterClass.SessionCounters.Builder builder = value.toBuilder();
            Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
            _create = companion._create(builder);
            _create.setBannerRequestsAdm(_create.getBannerRequestsAdm() + 1);
        } while (!mutableStateFlow.compareAndSet(value, _create._build()));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void incrementBannerImpressionCount() {
        SessionCountersOuterClass.SessionCounters value;
        SessionCountersKt.Dsl _create;
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        do {
            value = mutableStateFlow.getValue();
            SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.INSTANCE;
            SessionCountersOuterClass.SessionCounters.Builder builder = value.toBuilder();
            Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
            _create = companion._create(builder);
            _create.setBannerImpressions(_create.getBannerImpressions() + 1);
        } while (!mutableStateFlow.compareAndSet(value, _create._build()));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void incrementGlobalAdsFocusChangeCount() {
        SessionCountersOuterClass.SessionCounters value;
        SessionCountersKt.Dsl _create;
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        do {
            value = mutableStateFlow.getValue();
            SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.INSTANCE;
            SessionCountersOuterClass.SessionCounters.Builder builder = value.toBuilder();
            Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
            _create = companion._create(builder);
            _create.setGlobalAdsFocusChangeCount(_create.getGlobalAdsFocusChangeCount() + 1);
        } while (!mutableStateFlow.compareAndSet(value, _create._build()));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void addTimeToGlobalAdsFocusTime(int timeMs) {
        SessionCountersOuterClass.SessionCounters value;
        SessionCountersKt.Dsl _create;
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        do {
            value = mutableStateFlow.getValue();
            SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.INSTANCE;
            SessionCountersOuterClass.SessionCounters.Builder builder = value.toBuilder();
            Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
            _create = companion._create(builder);
            _create.setGlobalAdsFocusTime(_create.getGlobalAdsFocusTime() + timeMs);
        } while (!mutableStateFlow.compareAndSet(value, _create._build()));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void incrementFocusChangeCount() {
        SessionCountersOuterClass.SessionCounters value;
        SessionCountersKt.Dsl _create;
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        do {
            value = mutableStateFlow.getValue();
            SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.INSTANCE;
            SessionCountersOuterClass.SessionCounters.Builder builder = value.toBuilder();
            Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
            _create = companion._create(builder);
            _create.setFocusChangeCount(_create.getFocusChangeCount() + 1);
        } while (!mutableStateFlow.compareAndSet(value, _create._build()));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void incrementTokenSequenceNumber() {
        TokenCounters value;
        TokenCounters tokenCounters;
        MutableStateFlow<TokenCounters> mutableStateFlow = this._tokenCounters;
        do {
            value = mutableStateFlow.getValue();
            tokenCounters = value;
        } while (!mutableStateFlow.compareAndSet(value, TokenCounters.copy$default(tokenCounters, tokenCounters.getSeq() + 1, 0, 0, 6, null)));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void incrementTokenWinsCount() {
        TokenCounters value;
        TokenCounters tokenCounters;
        MutableStateFlow<TokenCounters> mutableStateFlow = this._tokenCounters;
        do {
            value = mutableStateFlow.getValue();
            tokenCounters = value;
        } while (!mutableStateFlow.compareAndSet(value, TokenCounters.copy$default(tokenCounters, 0, tokenCounters.getWins() + 1, 0, 5, null)));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void incrementTokenStartsCount() {
        TokenCounters value;
        TokenCounters tokenCounters;
        MutableStateFlow<TokenCounters> mutableStateFlow = this._tokenCounters;
        do {
            value = mutableStateFlow.getValue();
            tokenCounters = value;
        } while (!mutableStateFlow.compareAndSet(value, TokenCounters.copy$default(tokenCounters, 0, 0, tokenCounters.getStarts() + 1, 3, null)));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void resetTokenCounters() {
        MutableStateFlow<TokenCounters> mutableStateFlow = this._tokenCounters;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new TokenCounters(0, 0, 0))) {
        }
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public ByteString getSessionToken() {
        return this._sessionToken.getValue();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void setSessionToken(ByteString value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MutableStateFlow<ByteString> mutableStateFlow = this._sessionToken;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), value)) {
        }
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public ByteString getGatewayState() {
        return this._currentState.getValue();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void setGatewayState(ByteString value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MutableStateFlow<ByteString> mutableStateFlow = this._currentState;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), value)) {
        }
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public NativeConfigurationOuterClass.NativeConfiguration getNativeConfiguration() {
        Object runBlocking$default;
        if (!this.isInit.getValue().booleanValue()) {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AndroidSessionRepository$nativeConfiguration$1(this, null), 1, null);
            return (NativeConfigurationOuterClass.NativeConfiguration) runBlocking$default;
        }
        return this._sdkConfiguration.getValue();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void setNativeConfiguration(NativeConfigurationOuterClass.NativeConfiguration value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MutableStateFlow<NativeConfigurationOuterClass.NativeConfiguration> mutableStateFlow = this._sdkConfiguration;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), value)) {
        }
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public String getGatewayUrl() {
        return this._gatewayUrl.getValue();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void setGatewayUrl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MutableStateFlow<String> mutableStateFlow = this._gatewayUrl;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), value)) {
        }
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public InitializationState getInitializationState() {
        return this._initializationState.getValue();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void setInitializationState(InitializationState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MutableStateFlow<InitializationState> mutableStateFlow = this._initializationState;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), value)) {
        }
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public Flow<InitializationState> getObserveInitializationState() {
        return this._initializationState;
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public boolean isSdkInitialized() {
        return getInitializationState() == InitializationState.INITIALIZED;
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public boolean isDiagnosticsEnabled() {
        return getNativeConfiguration().getDiagnosticEvents().getEnabled();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public NativeConfigurationOuterClass.FeatureFlags getFeatureFlags() {
        NativeConfigurationOuterClass.FeatureFlags featureFlags = getNativeConfiguration().getFeatureFlags();
        Intrinsics.checkNotNullExpressionValue(featureFlags, "nativeConfiguration.featureFlags");
        return featureFlags;
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public int getHeaderBiddingTokenCounter() {
        Integer value;
        Integer num;
        MutableStateFlow<Integer> mutableStateFlow = this._headerBiddingTokenCounter;
        do {
            value = mutableStateFlow.getValue();
            num = value;
        } while (!mutableStateFlow.compareAndSet(value, Integer.valueOf(num.intValue() + 1)));
        return num.intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getGatewayCache(Continuation<? super ByteString> continuation) {
        AndroidSessionRepository$getGatewayCache$1 androidSessionRepository$getGatewayCache$1;
        int i;
        if (continuation instanceof AndroidSessionRepository$getGatewayCache$1) {
            androidSessionRepository$getGatewayCache$1 = (AndroidSessionRepository$getGatewayCache$1) continuation;
            if ((androidSessionRepository$getGatewayCache$1.label & Integer.MIN_VALUE) != 0) {
                androidSessionRepository$getGatewayCache$1.label -= Integer.MIN_VALUE;
                Object obj = androidSessionRepository$getGatewayCache$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidSessionRepository$getGatewayCache$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteStringDataSource byteStringDataSource = this.gatewayCacheDataSource;
                    androidSessionRepository$getGatewayCache$1.label = 1;
                    obj = byteStringDataSource.get(androidSessionRepository$getGatewayCache$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ByteString data = ((ByteStringStoreOuterClass.ByteStringStore) obj).getData();
                Intrinsics.checkNotNullExpressionValue(data, "gatewayCacheDataSource.get().data");
                return data;
            }
        }
        androidSessionRepository$getGatewayCache$1 = new AndroidSessionRepository$getGatewayCache$1(this, continuation);
        Object obj2 = androidSessionRepository$getGatewayCache$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidSessionRepository$getGatewayCache$1.label;
        if (i != 0) {
        }
        ByteString data2 = ((ByteStringStoreOuterClass.ByteStringStore) obj2).getData();
        Intrinsics.checkNotNullExpressionValue(data2, "gatewayCacheDataSource.get().data");
        return data2;
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public Object setGatewayCache(ByteString byteString, Continuation<? super Unit> continuation) {
        Object obj = this.gatewayCacheDataSource.set(byteString, continuation);
        return obj == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? obj : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getPrivacy(Continuation<? super ByteString> continuation) {
        AndroidSessionRepository$getPrivacy$1 androidSessionRepository$getPrivacy$1;
        int i;
        if (continuation instanceof AndroidSessionRepository$getPrivacy$1) {
            androidSessionRepository$getPrivacy$1 = (AndroidSessionRepository$getPrivacy$1) continuation;
            if ((androidSessionRepository$getPrivacy$1.label & Integer.MIN_VALUE) != 0) {
                androidSessionRepository$getPrivacy$1.label -= Integer.MIN_VALUE;
                Object obj = androidSessionRepository$getPrivacy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidSessionRepository$getPrivacy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteStringDataSource byteStringDataSource = this.privacyDataSource;
                    androidSessionRepository$getPrivacy$1.label = 1;
                    obj = byteStringDataSource.get(androidSessionRepository$getPrivacy$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ByteString data = ((ByteStringStoreOuterClass.ByteStringStore) obj).getData();
                Intrinsics.checkNotNullExpressionValue(data, "privacyDataSource.get().data");
                return data;
            }
        }
        androidSessionRepository$getPrivacy$1 = new AndroidSessionRepository$getPrivacy$1(this, continuation);
        Object obj2 = androidSessionRepository$getPrivacy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidSessionRepository$getPrivacy$1.label;
        if (i != 0) {
        }
        ByteString data2 = ((ByteStringStoreOuterClass.ByteStringStore) obj2).getData();
        Intrinsics.checkNotNullExpressionValue(data2, "privacyDataSource.get().data");
        return data2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0066, code lost:
    
        if (r7.emit(r2, r0) != r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object setPrivacy(ByteString byteString, Continuation<? super Unit> continuation) {
        AndroidSessionRepository$setPrivacy$1 androidSessionRepository$setPrivacy$1;
        int i;
        AndroidSessionRepository androidSessionRepository;
        if (continuation instanceof AndroidSessionRepository$setPrivacy$1) {
            androidSessionRepository$setPrivacy$1 = (AndroidSessionRepository$setPrivacy$1) continuation;
            if ((androidSessionRepository$setPrivacy$1.label & Integer.MIN_VALUE) != 0) {
                androidSessionRepository$setPrivacy$1.label -= Integer.MIN_VALUE;
                Object obj = androidSessionRepository$setPrivacy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidSessionRepository$setPrivacy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteStringDataSource byteStringDataSource = this.privacyDataSource;
                    androidSessionRepository$setPrivacy$1.L$0 = this;
                    androidSessionRepository$setPrivacy$1.L$1 = byteString;
                    androidSessionRepository$setPrivacy$1.label = 1;
                    if (byteStringDataSource.set(byteString, androidSessionRepository$setPrivacy$1) != coroutine_suspended) {
                        androidSessionRepository = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                byteString = (ByteString) androidSessionRepository$setPrivacy$1.L$1;
                androidSessionRepository = (AndroidSessionRepository) androidSessionRepository$setPrivacy$1.L$0;
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow<SessionChange> mutableSharedFlow = androidSessionRepository._onChange;
                SessionChange.UserConsentChange userConsentChange = new SessionChange.UserConsentChange(byteString);
                androidSessionRepository$setPrivacy$1.L$0 = null;
                androidSessionRepository$setPrivacy$1.L$1 = null;
                androidSessionRepository$setPrivacy$1.label = 2;
            }
        }
        androidSessionRepository$setPrivacy$1 = new AndroidSessionRepository$setPrivacy$1(this, continuation);
        Object obj2 = androidSessionRepository$setPrivacy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidSessionRepository$setPrivacy$1.label;
        if (i != 0) {
        }
        MutableSharedFlow<SessionChange> mutableSharedFlow2 = androidSessionRepository._onChange;
        SessionChange.UserConsentChange userConsentChange2 = new SessionChange.UserConsentChange(byteString);
        androidSessionRepository$setPrivacy$1.L$0 = null;
        androidSessionRepository$setPrivacy$1.L$1 = null;
        androidSessionRepository$setPrivacy$1.label = 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getPrivacyFsm(Continuation<? super ByteString> continuation) {
        AndroidSessionRepository$getPrivacyFsm$1 androidSessionRepository$getPrivacyFsm$1;
        int i;
        if (continuation instanceof AndroidSessionRepository$getPrivacyFsm$1) {
            androidSessionRepository$getPrivacyFsm$1 = (AndroidSessionRepository$getPrivacyFsm$1) continuation;
            if ((androidSessionRepository$getPrivacyFsm$1.label & Integer.MIN_VALUE) != 0) {
                androidSessionRepository$getPrivacyFsm$1.label -= Integer.MIN_VALUE;
                Object obj = androidSessionRepository$getPrivacyFsm$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidSessionRepository$getPrivacyFsm$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteStringDataSource byteStringDataSource = this.fsmDataSource;
                    androidSessionRepository$getPrivacyFsm$1.label = 1;
                    obj = byteStringDataSource.get(androidSessionRepository$getPrivacyFsm$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ByteString data = ((ByteStringStoreOuterClass.ByteStringStore) obj).getData();
                Intrinsics.checkNotNullExpressionValue(data, "fsmDataSource.get().data");
                return data;
            }
        }
        androidSessionRepository$getPrivacyFsm$1 = new AndroidSessionRepository$getPrivacyFsm$1(this, continuation);
        Object obj2 = androidSessionRepository$getPrivacyFsm$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidSessionRepository$getPrivacyFsm$1.label;
        if (i != 0) {
        }
        ByteString data2 = ((ByteStringStoreOuterClass.ByteStringStore) obj2).getData();
        Intrinsics.checkNotNullExpressionValue(data2, "fsmDataSource.get().data");
        return data2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0066, code lost:
    
        if (r7.emit(r2, r0) != r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object setPrivacyFsm(ByteString byteString, Continuation<? super Unit> continuation) {
        AndroidSessionRepository$setPrivacyFsm$1 androidSessionRepository$setPrivacyFsm$1;
        int i;
        AndroidSessionRepository androidSessionRepository;
        if (continuation instanceof AndroidSessionRepository$setPrivacyFsm$1) {
            androidSessionRepository$setPrivacyFsm$1 = (AndroidSessionRepository$setPrivacyFsm$1) continuation;
            if ((androidSessionRepository$setPrivacyFsm$1.label & Integer.MIN_VALUE) != 0) {
                androidSessionRepository$setPrivacyFsm$1.label -= Integer.MIN_VALUE;
                Object obj = androidSessionRepository$setPrivacyFsm$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidSessionRepository$setPrivacyFsm$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteStringDataSource byteStringDataSource = this.fsmDataSource;
                    androidSessionRepository$setPrivacyFsm$1.L$0 = this;
                    androidSessionRepository$setPrivacyFsm$1.L$1 = byteString;
                    androidSessionRepository$setPrivacyFsm$1.label = 1;
                    if (byteStringDataSource.set(byteString, androidSessionRepository$setPrivacyFsm$1) != coroutine_suspended) {
                        androidSessionRepository = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                byteString = (ByteString) androidSessionRepository$setPrivacyFsm$1.L$1;
                androidSessionRepository = (AndroidSessionRepository) androidSessionRepository$setPrivacyFsm$1.L$0;
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow<SessionChange> mutableSharedFlow = androidSessionRepository._onChange;
                SessionChange.PrivacyFsmChange privacyFsmChange = new SessionChange.PrivacyFsmChange(byteString);
                androidSessionRepository$setPrivacyFsm$1.L$0 = null;
                androidSessionRepository$setPrivacyFsm$1.L$1 = null;
                androidSessionRepository$setPrivacyFsm$1.label = 2;
            }
        }
        androidSessionRepository$setPrivacyFsm$1 = new AndroidSessionRepository$setPrivacyFsm$1(this, continuation);
        Object obj2 = androidSessionRepository$setPrivacyFsm$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidSessionRepository$setPrivacyFsm$1.label;
        if (i != 0) {
        }
        MutableSharedFlow<SessionChange> mutableSharedFlow2 = androidSessionRepository._onChange;
        SessionChange.PrivacyFsmChange privacyFsmChange2 = new SessionChange.PrivacyFsmChange(byteString);
        androidSessionRepository$setPrivacyFsm$1.L$0 = null;
        androidSessionRepository$setPrivacyFsm$1.L$1 = null;
        androidSessionRepository$setPrivacyFsm$1.label = 2;
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public boolean getShouldInitialize() {
        return this._shouldInitialize.getValue().booleanValue();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public void setShouldInitialize(boolean z) {
        Boolean value;
        MutableStateFlow<Boolean> mutableStateFlow = this._shouldInitialize;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(z)));
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public boolean isOmEnabled() {
        return getNativeConfiguration().getEnableOm();
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public Object persistNativeConfiguration(Continuation<? super Unit> continuation) {
        ByteStringDataSource byteStringDataSource = this.nativeConfigDataSource;
        ByteString byteString = getNativeConfiguration().toByteString();
        Intrinsics.checkNotNullExpressionValue(byteString, "nativeConfiguration.toByteString()");
        Object obj = byteStringDataSource.set(byteString, continuation);
        return obj == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? obj : Unit.INSTANCE;
    }

    @Override // com.unity3d.ads.core.data.repository.SessionRepository
    public boolean isFirstInitAttempt() {
        Boolean value;
        Boolean bool;
        MutableStateFlow<Boolean> mutableStateFlow = this._isFirstInitAttempt;
        do {
            value = mutableStateFlow.getValue();
            bool = value;
            bool.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, false));
        return bool.booleanValue();
    }
}
