package com.unity3d.ads.core.domain;

import android.content.Context;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.LoadResult;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import com.unity3d.services.UnityAdsConstants;
import gatewayprotocol.v1.AdPlayerConfigResponseOuterClass;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.AdResponseKt;
import gatewayprotocol.v1.AdResponseOuterClass;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;
import gatewayprotocol.v1.HeaderBiddingAdMarkupOuterClass;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import gatewayprotocol.v1.WebviewConfiguration;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidLoad.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/core/data/model/LoadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidLoad$invoke$2", f = "AndroidLoad.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER, 76, 93, 97, 136}, m = "invokeSuspend", n = {"$this$withContext", "adType", "tmpAdObject", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "adType", "tmpAdObject", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "mark$iv$iv", "$this$withContext", "adType", "tmpAdObject", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "adType", "tmpAdObject", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "mark$iv$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0", "J$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0", "J$0"})
/* loaded from: classes7.dex */
final class AndroidLoad$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LoadResult>, Object> {
    final /* synthetic */ AdRequestOuterClass.BannerSize $bannerSize;
    final /* synthetic */ Context $context;
    final /* synthetic */ HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup $headerBiddingAdMarkup;
    final /* synthetic */ UnityAdsLoadOptions $loadOptions;
    final /* synthetic */ ByteString $opportunityId;
    final /* synthetic */ String $placement;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AndroidLoad this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidLoad$invoke$2(AndroidLoad androidLoad, AdRequestOuterClass.BannerSize bannerSize, HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup, ByteString byteString, String str, UnityAdsLoadOptions unityAdsLoadOptions, Context context, Continuation<? super AndroidLoad$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = androidLoad;
        this.$bannerSize = bannerSize;
        this.$headerBiddingAdMarkup = headerBiddingAdMarkup;
        this.$opportunityId = byteString;
        this.$placement = str;
        this.$loadOptions = unityAdsLoadOptions;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidLoad$invoke$2 androidLoad$invoke$2 = new AndroidLoad$invoke$2(this.this$0, this.$bannerSize, this.$headerBiddingAdMarkup, this.$opportunityId, this.$placement, this.$loadOptions, this.$context, continuation);
        androidLoad$invoke$2.L$0 = obj;
        return androidLoad$invoke$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LoadResult> continuation) {
        return ((AndroidLoad$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x03b2, code lost:
    
        if (r0 != r9) goto L116;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02c8 A[Catch: UnityAdsNetworkException -> 0x0027, TryCatch #5 {UnityAdsNetworkException -> 0x0027, blocks: (B:9:0x0020, B:11:0x03b5, B:13:0x03bb, B:15:0x03c9, B:18:0x03de, B:20:0x03e7, B:24:0x03ec, B:25:0x03f1, B:33:0x026e, B:36:0x029c, B:38:0x02c8, B:40:0x02e4, B:42:0x034d, B:43:0x0359, B:45:0x0366, B:46:0x0377, B:48:0x037d, B:51:0x0397, B:58:0x0264, B:60:0x0058, B:62:0x0215, B:81:0x0172, B:84:0x01a0, B:88:0x0168, B:90:0x0088, B:93:0x011a, B:108:0x0099, B:110:0x00a5, B:112:0x00bb, B:116:0x00c4, B:117:0x00c9, B:119:0x00f1, B:123:0x01d2, B:125:0x01f0, B:126:0x01f7, B:131:0x00c7), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02e4 A[Catch: UnityAdsNetworkException -> 0x0027, TryCatch #5 {UnityAdsNetworkException -> 0x0027, blocks: (B:9:0x0020, B:11:0x03b5, B:13:0x03bb, B:15:0x03c9, B:18:0x03de, B:20:0x03e7, B:24:0x03ec, B:25:0x03f1, B:33:0x026e, B:36:0x029c, B:38:0x02c8, B:40:0x02e4, B:42:0x034d, B:43:0x0359, B:45:0x0366, B:46:0x0377, B:48:0x037d, B:51:0x0397, B:58:0x0264, B:60:0x0058, B:62:0x0215, B:81:0x0172, B:84:0x01a0, B:88:0x0168, B:90:0x0088, B:93:0x011a, B:108:0x0099, B:110:0x00a5, B:112:0x00bb, B:116:0x00c4, B:117:0x00c9, B:119:0x00f1, B:123:0x01d2, B:125:0x01f0, B:126:0x01f7, B:131:0x00c7), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019e  */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        LoadResult.Failure handleGatewayException;
        SessionRepository sessionRepository;
        AdObject tmpAdObject;
        GetAdPlayerConfigRequest getAdPlayerConfigRequest;
        Object invoke;
        AdObject adObject;
        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType;
        GetAdRequest getAdRequest;
        Object invoke2;
        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType2;
        ?? r12;
        AdObject adObject2;
        GetRequestPolicy getRequestPolicy;
        long m11706markNowz9LOYto;
        long j;
        AdObject adObject3;
        int i;
        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType3;
        long j2;
        GatewayClient gatewayClient;
        Object request$default;
        Object m10241constructorimpl;
        SendDiagnosticEvent sendDiagnosticEvent;
        AdResponseOuterClass.AdResponse response;
        ?? r122;
        GetRequestPolicy getRequestPolicy2;
        long m11706markNowz9LOYto2;
        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType4;
        long j3;
        AdObject adObject4;
        long j4;
        GatewayClient gatewayClient2;
        Object request$default2;
        Object m10241constructorimpl2;
        HandleGatewayAdResponse handleGatewayAdResponse;
        Object invoke3;
        SendDiagnosticEvent sendDiagnosticEvent2;
        UniversalResponseOuterClass.UniversalResponse universalResponse;
        AdRepository adRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                sessionRepository = this.this$0.sessionRepository;
                if (!sessionRepository.isSdkInitialized()) {
                    return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INITIALIZE_FAILED, null, null, "not_initialized", null, false, 54, null);
                }
                boolean z = this.$bannerSize != null;
                DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType5 = z ? DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_BANNER : DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_FULLSCREEN;
                boolean isEmpty = this.$headerBiddingAdMarkup.getAdData().isEmpty();
                boolean z2 = !isEmpty;
                tmpAdObject = this.this$0.getTmpAdObject(this.$opportunityId, this.$placement, z2, diagnosticAdType5, this.$loadOptions);
                boolean z3 = z2;
                if (isEmpty) {
                    this.this$0.incrementLoadRequestCount(z);
                    getAdRequest = this.this$0.getAdRequest;
                    this.L$0 = coroutineScope;
                    this.L$1 = diagnosticAdType5;
                    this.L$2 = tmpAdObject;
                    this.I$0 = z3 ? 1 : 0;
                    this.label = 1;
                    invoke2 = getAdRequest.invoke(this.$placement, this.$opportunityId, this.$bannerSize, this);
                    if (invoke2 != coroutine_suspended) {
                        diagnosticAdType2 = diagnosticAdType5;
                        r12 = z3;
                        adObject2 = tmpAdObject;
                        UniversalRequestOuterClass.UniversalRequest universalRequest = (UniversalRequestOuterClass.UniversalRequest) invoke2;
                        getRequestPolicy = this.this$0.getRequestPolicy;
                        RequestPolicy invoke4 = getRequestPolicy.invoke();
                        AndroidLoad androidLoad = this.this$0;
                        m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                        Result.Companion companion = Result.INSTANCE;
                        gatewayClient = androidLoad.gatewayClient;
                        OperationType operationType = OperationType.LOAD;
                        this.L$0 = diagnosticAdType2;
                        this.L$1 = adObject2;
                        this.L$2 = null;
                        this.I$0 = r12;
                        this.J$0 = m11706markNowz9LOYto;
                        this.label = 2;
                        j = m11706markNowz9LOYto;
                        request$default = GatewayClient.DefaultImpls.request$default(gatewayClient, null, universalRequest, invoke4, operationType, this, 1, null);
                        if (request$default != coroutine_suspended) {
                        }
                    }
                } else {
                    this.this$0.incrementLoadRequestAdmCount(z);
                    getAdPlayerConfigRequest = this.this$0.getAdPlayerConfigRequest;
                    String str = this.$placement;
                    ByteString byteString = this.$opportunityId;
                    ByteString configurationToken = this.$headerBiddingAdMarkup.getConfigurationToken();
                    Intrinsics.checkNotNullExpressionValue(configurationToken, "headerBiddingAdMarkup.configurationToken");
                    InitializationResponseOuterClass.AdFormat adFormat = this.$bannerSize != null ? InitializationResponseOuterClass.AdFormat.AD_FORMAT_BANNER : null;
                    this.L$0 = coroutineScope;
                    this.L$1 = diagnosticAdType5;
                    this.L$2 = tmpAdObject;
                    this.I$0 = z3 ? 1 : 0;
                    this.label = 3;
                    invoke = getAdPlayerConfigRequest.invoke(str, byteString, configurationToken, adFormat, this);
                    if (invoke != coroutine_suspended) {
                        adObject = tmpAdObject;
                        diagnosticAdType = diagnosticAdType5;
                        r122 = z3;
                        UniversalRequestOuterClass.UniversalRequest universalRequest2 = (UniversalRequestOuterClass.UniversalRequest) invoke;
                        getRequestPolicy2 = this.this$0.getRequestPolicy;
                        RequestPolicy invoke5 = getRequestPolicy2.invoke();
                        AndroidLoad androidLoad2 = this.this$0;
                        m11706markNowz9LOYto2 = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                        Result.Companion companion2 = Result.INSTANCE;
                        gatewayClient2 = androidLoad2.gatewayClient;
                        OperationType operationType2 = OperationType.LOAD_HEADER_BIDDING;
                        this.L$0 = diagnosticAdType;
                        this.L$1 = adObject;
                        this.L$2 = null;
                        this.I$0 = r122;
                        this.J$0 = m11706markNowz9LOYto2;
                        this.label = 4;
                        diagnosticAdType4 = diagnosticAdType;
                        j3 = m11706markNowz9LOYto2;
                        request$default2 = GatewayClient.DefaultImpls.request$default(gatewayClient2, null, universalRequest2, invoke5, operationType2, this, 1, null);
                        if (request$default2 != coroutine_suspended) {
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                int i3 = this.I$0;
                tmpAdObject = (AdObject) this.L$2;
                DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType6 = (DiagnosticEventRequestOuterClass.DiagnosticAdType) this.L$1;
                ResultKt.throwOnFailure(obj);
                r12 = i3;
                diagnosticAdType2 = diagnosticAdType6;
                invoke2 = obj;
                adObject2 = tmpAdObject;
                UniversalRequestOuterClass.UniversalRequest universalRequest3 = (UniversalRequestOuterClass.UniversalRequest) invoke2;
                getRequestPolicy = this.this$0.getRequestPolicy;
                RequestPolicy invoke42 = getRequestPolicy.invoke();
                AndroidLoad androidLoad3 = this.this$0;
                m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    gatewayClient = androidLoad3.gatewayClient;
                    OperationType operationType3 = OperationType.LOAD;
                    this.L$0 = diagnosticAdType2;
                    this.L$1 = adObject2;
                    this.L$2 = null;
                    this.I$0 = r12;
                    this.J$0 = m11706markNowz9LOYto;
                    this.label = 2;
                    j = m11706markNowz9LOYto;
                } catch (Throwable th) {
                    th = th;
                    j = m11706markNowz9LOYto;
                }
                try {
                    request$default = GatewayClient.DefaultImpls.request$default(gatewayClient, null, universalRequest3, invoke42, operationType3, this, 1, null);
                } catch (Throwable th2) {
                    th = th2;
                    adObject3 = adObject2;
                    i = r12;
                    diagnosticAdType3 = diagnosticAdType2;
                    j2 = j;
                    Result.Companion companion4 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                    AdObject adObject5 = adObject3;
                    TimedValue timedValue = new TimedValue(Result.m10240boximpl(m10241constructorimpl), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j2), null);
                    AndroidLoad androidLoad4 = this.this$0;
                    Object value = ((Result) timedValue.component1()).getValue();
                    long duration = timedValue.getDuration();
                    sendDiagnosticEvent = androidLoad4.sendDiagnosticEvent;
                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, !Result.m10248isSuccessimpl(value) ? "native_load_config_success_time" : "native_load_config_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(duration, DurationUnit.MILLISECONDS)), null, null, adObject5, null, 44, null);
                    Object value2 = ((Result) timedValue.getValue()).getValue();
                    ResultKt.throwOnFailure(value2);
                    response = ((UniversalResponseOuterClass.UniversalResponse) value2).getPayload().getAdResponse();
                    DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType7 = diagnosticAdType3;
                    handleGatewayAdResponse = this.this$0.handleGatewayAdResponse;
                    UnityAdsLoadOptions unityAdsLoadOptions = this.$loadOptions;
                    ByteString byteString2 = this.$opportunityId;
                    Intrinsics.checkNotNullExpressionValue(response, "response");
                    Context context = this.$context;
                    String str2 = this.$placement;
                    if (i != 0) {
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    invoke3 = handleGatewayAdResponse.invoke(unityAdsLoadOptions, byteString2, response, context, str2, diagnosticAdType7, r31, this);
                }
                if (request$default != coroutine_suspended) {
                    adObject3 = adObject2;
                    i = r12;
                    diagnosticAdType3 = diagnosticAdType2;
                    j2 = j;
                    m10241constructorimpl = Result.m10241constructorimpl((UniversalResponseOuterClass.UniversalResponse) request$default);
                    AdObject adObject52 = adObject3;
                    TimedValue timedValue2 = new TimedValue(Result.m10240boximpl(m10241constructorimpl), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j2), null);
                    AndroidLoad androidLoad42 = this.this$0;
                    Object value3 = ((Result) timedValue2.component1()).getValue();
                    long duration2 = timedValue2.getDuration();
                    sendDiagnosticEvent = androidLoad42.sendDiagnosticEvent;
                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, !Result.m10248isSuccessimpl(value3) ? "native_load_config_success_time" : "native_load_config_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(duration2, DurationUnit.MILLISECONDS)), null, null, adObject52, null, 44, null);
                    Object value22 = ((Result) timedValue2.getValue()).getValue();
                    ResultKt.throwOnFailure(value22);
                    response = ((UniversalResponseOuterClass.UniversalResponse) value22).getPayload().getAdResponse();
                }
                return coroutine_suspended;
            }
            if (i2 == 2) {
                j2 = this.J$0;
                i = this.I$0;
                adObject3 = (AdObject) this.L$1;
                diagnosticAdType3 = (DiagnosticEventRequestOuterClass.DiagnosticAdType) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    request$default = obj;
                    m10241constructorimpl = Result.m10241constructorimpl((UniversalResponseOuterClass.UniversalResponse) request$default);
                } catch (Throwable th3) {
                    th = th3;
                    Result.Companion companion42 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                    AdObject adObject522 = adObject3;
                    TimedValue timedValue22 = new TimedValue(Result.m10240boximpl(m10241constructorimpl), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j2), null);
                    AndroidLoad androidLoad422 = this.this$0;
                    Object value32 = ((Result) timedValue22.component1()).getValue();
                    long duration22 = timedValue22.getDuration();
                    sendDiagnosticEvent = androidLoad422.sendDiagnosticEvent;
                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, !Result.m10248isSuccessimpl(value32) ? "native_load_config_success_time" : "native_load_config_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(duration22, DurationUnit.MILLISECONDS)), null, null, adObject522, null, 44, null);
                    Object value222 = ((Result) timedValue22.getValue()).getValue();
                    ResultKt.throwOnFailure(value222);
                    response = ((UniversalResponseOuterClass.UniversalResponse) value222).getPayload().getAdResponse();
                    DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType72 = diagnosticAdType3;
                    handleGatewayAdResponse = this.this$0.handleGatewayAdResponse;
                    UnityAdsLoadOptions unityAdsLoadOptions2 = this.$loadOptions;
                    ByteString byteString22 = this.$opportunityId;
                    Intrinsics.checkNotNullExpressionValue(response, "response");
                    Context context2 = this.$context;
                    String str22 = this.$placement;
                    if (i != 0) {
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    invoke3 = handleGatewayAdResponse.invoke(unityAdsLoadOptions2, byteString22, response, context2, str22, diagnosticAdType72, r31, this);
                }
                AdObject adObject5222 = adObject3;
                TimedValue timedValue222 = new TimedValue(Result.m10240boximpl(m10241constructorimpl), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j2), null);
                AndroidLoad androidLoad4222 = this.this$0;
                Object value322 = ((Result) timedValue222.component1()).getValue();
                long duration222 = timedValue222.getDuration();
                sendDiagnosticEvent = androidLoad4222.sendDiagnosticEvent;
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, !Result.m10248isSuccessimpl(value322) ? "native_load_config_success_time" : "native_load_config_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(duration222, DurationUnit.MILLISECONDS)), null, null, adObject5222, null, 44, null);
                Object value2222 = ((Result) timedValue222.getValue()).getValue();
                ResultKt.throwOnFailure(value2222);
                response = ((UniversalResponseOuterClass.UniversalResponse) value2222).getPayload().getAdResponse();
            } else {
                if (i2 == 3) {
                    int i4 = this.I$0;
                    AdObject adObject6 = (AdObject) this.L$2;
                    DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType8 = (DiagnosticEventRequestOuterClass.DiagnosticAdType) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    r122 = i4;
                    adObject = adObject6;
                    diagnosticAdType = diagnosticAdType8;
                    invoke = obj;
                    UniversalRequestOuterClass.UniversalRequest universalRequest22 = (UniversalRequestOuterClass.UniversalRequest) invoke;
                    getRequestPolicy2 = this.this$0.getRequestPolicy;
                    RequestPolicy invoke52 = getRequestPolicy2.invoke();
                    AndroidLoad androidLoad22 = this.this$0;
                    m11706markNowz9LOYto2 = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                    try {
                        Result.Companion companion22 = Result.INSTANCE;
                        gatewayClient2 = androidLoad22.gatewayClient;
                        OperationType operationType22 = OperationType.LOAD_HEADER_BIDDING;
                        this.L$0 = diagnosticAdType;
                        this.L$1 = adObject;
                        this.L$2 = null;
                        this.I$0 = r122;
                        this.J$0 = m11706markNowz9LOYto2;
                        this.label = 4;
                        diagnosticAdType4 = diagnosticAdType;
                        j3 = m11706markNowz9LOYto2;
                        try {
                            request$default2 = GatewayClient.DefaultImpls.request$default(gatewayClient2, null, universalRequest22, invoke52, operationType22, this, 1, null);
                        } catch (Throwable th4) {
                            th = th4;
                            i = r122;
                            adObject4 = adObject;
                            diagnosticAdType3 = diagnosticAdType4;
                            j4 = j3;
                            Result.Companion companion5 = Result.INSTANCE;
                            m10241constructorimpl2 = Result.m10241constructorimpl(ResultKt.createFailure(th));
                            AdObject adObject7 = adObject4;
                            TimedValue timedValue3 = new TimedValue(Result.m10240boximpl(m10241constructorimpl2), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j4), null);
                            AndroidLoad androidLoad5 = this.this$0;
                            Object value4 = ((Result) timedValue3.component1()).getValue();
                            long duration3 = timedValue3.getDuration();
                            sendDiagnosticEvent2 = androidLoad5.sendDiagnosticEvent;
                            SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, !Result.m10248isSuccessimpl(value4) ? "native_load_config_success_time" : "native_load_config_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(duration3, DurationUnit.MILLISECONDS)), null, null, adObject7, null, 44, null);
                            Object value5 = ((Result) timedValue3.getValue()).getValue();
                            ResultKt.throwOnFailure(value5);
                            universalResponse = (UniversalResponseOuterClass.UniversalResponse) value5;
                            if (!universalResponse.hasError()) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        diagnosticAdType4 = diagnosticAdType;
                        j3 = m11706markNowz9LOYto2;
                    }
                    if (request$default2 != coroutine_suspended) {
                        i = r122;
                        adObject4 = adObject;
                        diagnosticAdType3 = diagnosticAdType4;
                        j4 = j3;
                        m10241constructorimpl2 = Result.m10241constructorimpl((UniversalResponseOuterClass.UniversalResponse) request$default2);
                        AdObject adObject72 = adObject4;
                        TimedValue timedValue32 = new TimedValue(Result.m10240boximpl(m10241constructorimpl2), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j4), null);
                        AndroidLoad androidLoad52 = this.this$0;
                        Object value42 = ((Result) timedValue32.component1()).getValue();
                        long duration32 = timedValue32.getDuration();
                        sendDiagnosticEvent2 = androidLoad52.sendDiagnosticEvent;
                        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, !Result.m10248isSuccessimpl(value42) ? "native_load_config_success_time" : "native_load_config_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(duration32, DurationUnit.MILLISECONDS)), null, null, adObject72, null, 44, null);
                        Object value52 = ((Result) timedValue32.getValue()).getValue();
                        ResultKt.throwOnFailure(value52);
                        universalResponse = (UniversalResponseOuterClass.UniversalResponse) value52;
                        if (!universalResponse.hasError()) {
                        }
                    }
                    return coroutine_suspended;
                }
                if (i2 != 4) {
                    if (i2 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    invoke3 = obj;
                    LoadResult loadResult = (LoadResult) invoke3;
                    if (loadResult instanceof LoadResult.Success) {
                        adRepository = this.this$0.adRepository;
                        AdObject ad = adRepository.getAd(this.$opportunityId);
                        return ad == null ? new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadResult.MSG_AD_OBJECT, null, "ad_object_not_found", null, false, 52, null) : new LoadResult.Success(ad);
                    }
                    if (loadResult instanceof LoadResult.Failure) {
                        return loadResult;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                j4 = this.J$0;
                i = this.I$0;
                adObject4 = (AdObject) this.L$1;
                diagnosticAdType3 = (DiagnosticEventRequestOuterClass.DiagnosticAdType) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    request$default2 = obj;
                    m10241constructorimpl2 = Result.m10241constructorimpl((UniversalResponseOuterClass.UniversalResponse) request$default2);
                } catch (Throwable th6) {
                    th = th6;
                    Result.Companion companion52 = Result.INSTANCE;
                    m10241constructorimpl2 = Result.m10241constructorimpl(ResultKt.createFailure(th));
                    AdObject adObject722 = adObject4;
                    TimedValue timedValue322 = new TimedValue(Result.m10240boximpl(m10241constructorimpl2), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j4), null);
                    AndroidLoad androidLoad522 = this.this$0;
                    Object value422 = ((Result) timedValue322.component1()).getValue();
                    long duration322 = timedValue322.getDuration();
                    sendDiagnosticEvent2 = androidLoad522.sendDiagnosticEvent;
                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, !Result.m10248isSuccessimpl(value422) ? "native_load_config_success_time" : "native_load_config_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(duration322, DurationUnit.MILLISECONDS)), null, null, adObject722, null, 44, null);
                    Object value522 = ((Result) timedValue322.getValue()).getValue();
                    ResultKt.throwOnFailure(value522);
                    universalResponse = (UniversalResponseOuterClass.UniversalResponse) value522;
                    if (!universalResponse.hasError()) {
                    }
                }
                AdObject adObject7222 = adObject4;
                TimedValue timedValue3222 = new TimedValue(Result.m10240boximpl(m10241constructorimpl2), TimeSource.Monotonic.ValueTimeMark.m11711elapsedNowUwyO8pc(j4), null);
                AndroidLoad androidLoad5222 = this.this$0;
                Object value4222 = ((Result) timedValue3222.component1()).getValue();
                long duration3222 = timedValue3222.getDuration();
                sendDiagnosticEvent2 = androidLoad5222.sendDiagnosticEvent;
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, !Result.m10248isSuccessimpl(value4222) ? "native_load_config_success_time" : "native_load_config_failure_time", Boxing.boxDouble(Duration.m11610toDoubleimpl(duration3222, DurationUnit.MILLISECONDS)), null, null, adObject7222, null, 44, null);
                Object value5222 = ((Result) timedValue3222.getValue()).getValue();
                ResultKt.throwOnFailure(value5222);
                universalResponse = (UniversalResponseOuterClass.UniversalResponse) value5222;
                if (!universalResponse.hasError()) {
                    return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "gateway", universalResponse.getError().getErrorText(), false, 36, null);
                }
                AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse adPlayerConfigResponse = universalResponse.getPayload().getAdPlayerConfigResponse();
                HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup = this.$headerBiddingAdMarkup;
                AdResponseKt.Dsl.Companion companion6 = AdResponseKt.Dsl.INSTANCE;
                AdResponseOuterClass.AdResponse.Builder newBuilder = AdResponseOuterClass.AdResponse.newBuilder();
                Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                AdResponseKt.Dsl _create = companion6._create(newBuilder);
                ByteString adData = headerBiddingAdMarkup.getAdData();
                Intrinsics.checkNotNullExpressionValue(adData, "headerBiddingAdMarkup.adData");
                _create.setAdData(adData);
                _create.setAdDataVersion(headerBiddingAdMarkup.getAdDataVersion());
                ByteString trackingToken = adPlayerConfigResponse.getTrackingToken();
                Intrinsics.checkNotNullExpressionValue(trackingToken, "response.trackingToken");
                _create.setTrackingToken(trackingToken);
                ByteString impressionConfiguration = adPlayerConfigResponse.getImpressionConfiguration();
                Intrinsics.checkNotNullExpressionValue(impressionConfiguration, "response.impressionConfiguration");
                _create.setImpressionConfiguration(impressionConfiguration);
                _create.setImpressionConfigurationVersion(adPlayerConfigResponse.getImpressionConfigurationVersion());
                WebviewConfiguration.WebViewConfiguration webviewConfiguration = adPlayerConfigResponse.getWebviewConfiguration();
                Intrinsics.checkNotNullExpressionValue(webviewConfiguration, "response.webviewConfiguration");
                _create.setWebviewConfiguration(webviewConfiguration);
                ByteString adDataRefreshToken = adPlayerConfigResponse.getAdDataRefreshToken();
                Intrinsics.checkNotNullExpressionValue(adDataRefreshToken, "response.adDataRefreshToken");
                _create.setAdDataRefreshToken(adDataRefreshToken);
                if (adPlayerConfigResponse.hasError()) {
                    ErrorOuterClass.Error error = adPlayerConfigResponse.getError();
                    Intrinsics.checkNotNullExpressionValue(error, "response.error");
                    _create.setError(error);
                }
                ByteString adData2 = adPlayerConfigResponse.getAdData();
                Intrinsics.checkNotNullExpressionValue(adData2, "response.adData");
                if (ByteStringsKt.isNotEmpty(adData2)) {
                    ByteString adData3 = adPlayerConfigResponse.getAdData();
                    Intrinsics.checkNotNullExpressionValue(adData3, "response.adData");
                    _create.setAdData(adData3);
                    _create.setAdDataVersion(adPlayerConfigResponse.getAdDataVersion());
                }
                response = _create._build();
            }
            DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType722 = diagnosticAdType3;
            handleGatewayAdResponse = this.this$0.handleGatewayAdResponse;
            UnityAdsLoadOptions unityAdsLoadOptions22 = this.$loadOptions;
            ByteString byteString222 = this.$opportunityId;
            Intrinsics.checkNotNullExpressionValue(response, "response");
            Context context22 = this.$context;
            String str222 = this.$placement;
            boolean z4 = i != 0;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 5;
            invoke3 = handleGatewayAdResponse.invoke(unityAdsLoadOptions22, byteString222, response, context22, str222, diagnosticAdType722, z4, this);
        } catch (UnityAdsNetworkException e) {
            handleGatewayException = this.this$0.handleGatewayException(e);
            return handleGatewayException;
        }
    }
}
