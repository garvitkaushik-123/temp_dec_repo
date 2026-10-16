package com.unity3d.ads.core.domain;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: CommonInitAwaitingGetHeaderBiddingToken.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ#\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J-\u00101\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096Bø\u0001\u0000¢\u0006\u0002\u00102J&\u00103\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u000105H\u0002J\u0010\u00107\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u00108\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u00109\u001a\u000205H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u00020&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Lcom/unity3d/ads/core/domain/CommonInitAwaitingGetHeaderBiddingToken;", "Lcom/unity3d/ads/core/domain/GetAsyncHeaderBiddingToken;", "getHeaderBiddingToken", "Lcom/unity3d/ads/core/domain/GetHeaderBiddingToken;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "getInitializationState", "Lcom/unity3d/ads/core/domain/GetInitializationState;", "awaitInitialization", "Lcom/unity3d/ads/core/domain/AwaitInitialization;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "safeCallbackInvoke", "Lcom/unity3d/ads/core/domain/SafeCallbackInvoke;", "(Lcom/unity3d/ads/core/domain/GetHeaderBiddingToken;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/core/domain/GetInitializationState;Lcom/unity3d/ads/core/domain/AwaitInitialization;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/domain/SafeCallbackInvoke;)V", "getAwaitInitialization", "()Lcom/unity3d/ads/core/domain/AwaitInitialization;", "didAwaitInit", "", "getGetHeaderBiddingToken", "()Lcom/unity3d/ads/core/domain/GetHeaderBiddingToken;", "getGetInitializationState", "()Lcom/unity3d/ads/core/domain/GetInitializationState;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/unity3d/ads/IUnityAdsTokenListener;", "getListener", "()Lcom/unity3d/ads/IUnityAdsTokenListener;", "setListener", "(Lcom/unity3d/ads/IUnityAdsTokenListener;)V", "getSafeCallbackInvoke", "()Lcom/unity3d/ads/core/domain/SafeCallbackInvoke;", "getSendDiagnosticEvent", "()Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "getSessionRepository", "()Lcom/unity3d/ads/core/data/repository/SessionRepository;", "startState", "Lcom/unity3d/ads/core/data/model/InitializationState;", "startTime", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "getStartTime-z9LOYto", "()J", "J", "fetchToken", "", "tokenNumber", "", "tokenConfiguration", "Lcom/unity3d/ads/TokenConfiguration;", "(ILcom/unity3d/ads/TokenConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "(ILcom/unity3d/ads/TokenConfiguration;Lcom/unity3d/ads/IUnityAdsTokenListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tokenFailure", "reason", "", "reasonDebug", "tokenStart", "tokenSuccess", "token", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CommonInitAwaitingGetHeaderBiddingToken implements GetAsyncHeaderBiddingToken {
    private final AwaitInitialization awaitInitialization;
    private boolean didAwaitInit;
    private final GetHeaderBiddingToken getHeaderBiddingToken;
    private final GetInitializationState getInitializationState;
    private IUnityAdsTokenListener listener;
    private final SafeCallbackInvoke safeCallbackInvoke;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private InitializationState startState;
    private final long startTime;

    public CommonInitAwaitingGetHeaderBiddingToken(GetHeaderBiddingToken getHeaderBiddingToken, SendDiagnosticEvent sendDiagnosticEvent, GetInitializationState getInitializationState, AwaitInitialization awaitInitialization, SessionRepository sessionRepository, SafeCallbackInvoke safeCallbackInvoke) {
        Intrinsics.checkNotNullParameter(getHeaderBiddingToken, "getHeaderBiddingToken");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(getInitializationState, "getInitializationState");
        Intrinsics.checkNotNullParameter(awaitInitialization, "awaitInitialization");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(safeCallbackInvoke, "safeCallbackInvoke");
        this.getHeaderBiddingToken = getHeaderBiddingToken;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getInitializationState = getInitializationState;
        this.awaitInitialization = awaitInitialization;
        this.sessionRepository = sessionRepository;
        this.safeCallbackInvoke = safeCallbackInvoke;
        this.startTime = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
    }

    public final GetHeaderBiddingToken getGetHeaderBiddingToken() {
        return this.getHeaderBiddingToken;
    }

    public final SendDiagnosticEvent getSendDiagnosticEvent() {
        return this.sendDiagnosticEvent;
    }

    public final GetInitializationState getGetInitializationState() {
        return this.getInitializationState;
    }

    public final AwaitInitialization getAwaitInitialization() {
        return this.awaitInitialization;
    }

    public final SessionRepository getSessionRepository() {
        return this.sessionRepository;
    }

    public final SafeCallbackInvoke getSafeCallbackInvoke() {
        return this.safeCallbackInvoke;
    }

    /* renamed from: getStartTime-z9LOYto, reason: not valid java name and from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public final IUnityAdsTokenListener getListener() {
        return this.listener;
    }

    public final void setListener(IUnityAdsTokenListener iUnityAdsTokenListener) {
        this.listener = iUnityAdsTokenListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a9, code lost:
    
        if (r11.fetchToken(r9, r10, r0) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(int i, TokenConfiguration tokenConfiguration, IUnityAdsTokenListener iUnityAdsTokenListener, Continuation<? super Unit> continuation) {
        CommonInitAwaitingGetHeaderBiddingToken$invoke$1 commonInitAwaitingGetHeaderBiddingToken$invoke$1;
        int i2;
        CommonInitAwaitingGetHeaderBiddingToken commonInitAwaitingGetHeaderBiddingToken;
        if (continuation instanceof CommonInitAwaitingGetHeaderBiddingToken$invoke$1) {
            commonInitAwaitingGetHeaderBiddingToken$invoke$1 = (CommonInitAwaitingGetHeaderBiddingToken$invoke$1) continuation;
            if ((commonInitAwaitingGetHeaderBiddingToken$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonInitAwaitingGetHeaderBiddingToken$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = commonInitAwaitingGetHeaderBiddingToken$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = commonInitAwaitingGetHeaderBiddingToken$invoke$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    this.listener = iUnityAdsTokenListener;
                    tokenStart(i);
                    if (iUnityAdsTokenListener == null) {
                        tokenFailure(i, "listener_null", "IUnityAdsTokenListener is null");
                        return Unit.INSTANCE;
                    }
                    if (!this.sessionRepository.getShouldInitialize()) {
                        tokenFailure(i, "gateway", "!sessionRepository.shouldInitialize");
                        return Unit.INSTANCE;
                    }
                    long getTokenTimeoutMs = this.sessionRepository.getNativeConfiguration().getAdOperations().getGetTokenTimeoutMs();
                    CommonInitAwaitingGetHeaderBiddingToken$invoke$2 commonInitAwaitingGetHeaderBiddingToken$invoke$2 = new CommonInitAwaitingGetHeaderBiddingToken$invoke$2(this, null);
                    commonInitAwaitingGetHeaderBiddingToken$invoke$1.L$0 = this;
                    commonInitAwaitingGetHeaderBiddingToken$invoke$1.L$1 = tokenConfiguration;
                    commonInitAwaitingGetHeaderBiddingToken$invoke$1.I$0 = i;
                    commonInitAwaitingGetHeaderBiddingToken$invoke$1.label = 1;
                    if (TimeoutKt.withTimeoutOrNull(getTokenTimeoutMs, commonInitAwaitingGetHeaderBiddingToken$invoke$2, commonInitAwaitingGetHeaderBiddingToken$invoke$1) != coroutine_suspended) {
                        commonInitAwaitingGetHeaderBiddingToken = this;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                i = commonInitAwaitingGetHeaderBiddingToken$invoke$1.I$0;
                tokenConfiguration = (TokenConfiguration) commonInitAwaitingGetHeaderBiddingToken$invoke$1.L$1;
                commonInitAwaitingGetHeaderBiddingToken = (CommonInitAwaitingGetHeaderBiddingToken) commonInitAwaitingGetHeaderBiddingToken$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                if (commonInitAwaitingGetHeaderBiddingToken.sessionRepository.getShouldInitialize()) {
                    commonInitAwaitingGetHeaderBiddingToken.tokenFailure(i, "gateway", "!sessionRepository.shouldInitialize");
                    return Unit.INSTANCE;
                }
                commonInitAwaitingGetHeaderBiddingToken$invoke$1.L$0 = null;
                commonInitAwaitingGetHeaderBiddingToken$invoke$1.L$1 = null;
                commonInitAwaitingGetHeaderBiddingToken$invoke$1.label = 2;
            }
        }
        commonInitAwaitingGetHeaderBiddingToken$invoke$1 = new CommonInitAwaitingGetHeaderBiddingToken$invoke$1(this, continuation);
        Object obj2 = commonInitAwaitingGetHeaderBiddingToken$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = commonInitAwaitingGetHeaderBiddingToken$invoke$1.label;
        if (i2 != 0) {
        }
        if (commonInitAwaitingGetHeaderBiddingToken.sessionRepository.getShouldInitialize()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchToken(int i, TokenConfiguration tokenConfiguration, Continuation<? super Unit> continuation) {
        CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1 commonInitAwaitingGetHeaderBiddingToken$fetchToken$1;
        int i2;
        String str;
        CommonInitAwaitingGetHeaderBiddingToken commonInitAwaitingGetHeaderBiddingToken;
        String shortenedStackTrace$default;
        String str2;
        if (continuation instanceof CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1) {
            commonInitAwaitingGetHeaderBiddingToken$fetchToken$1 = (CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1) continuation;
            if ((commonInitAwaitingGetHeaderBiddingToken$fetchToken$1.label & Integer.MIN_VALUE) != 0) {
                commonInitAwaitingGetHeaderBiddingToken$fetchToken$1.label -= Integer.MIN_VALUE;
                Object obj = commonInitAwaitingGetHeaderBiddingToken$fetchToken$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = commonInitAwaitingGetHeaderBiddingToken$fetchToken$1.label;
                str = null;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        GetHeaderBiddingToken getHeaderBiddingToken = this.getHeaderBiddingToken;
                        commonInitAwaitingGetHeaderBiddingToken$fetchToken$1.L$0 = this;
                        commonInitAwaitingGetHeaderBiddingToken$fetchToken$1.I$0 = i;
                        commonInitAwaitingGetHeaderBiddingToken$fetchToken$1.label = 1;
                        obj = getHeaderBiddingToken.invoke(i, tokenConfiguration, commonInitAwaitingGetHeaderBiddingToken$fetchToken$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        commonInitAwaitingGetHeaderBiddingToken = this;
                    } catch (Exception e) {
                        e = e;
                        commonInitAwaitingGetHeaderBiddingToken = this;
                        shortenedStackTrace$default = ExceptionExtensionsKt.getShortenedStackTrace$default(e, 0, 1, null);
                        str2 = "uncaught_exception";
                        if (str != null) {
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = commonInitAwaitingGetHeaderBiddingToken$fetchToken$1.I$0;
                    commonInitAwaitingGetHeaderBiddingToken = (CommonInitAwaitingGetHeaderBiddingToken) commonInitAwaitingGetHeaderBiddingToken$fetchToken$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e2) {
                        e = e2;
                        shortenedStackTrace$default = ExceptionExtensionsKt.getShortenedStackTrace$default(e, 0, 1, null);
                        str2 = "uncaught_exception";
                        if (str != null) {
                        }
                        return Unit.INSTANCE;
                    }
                }
                str2 = null;
                str = (String) obj;
                shortenedStackTrace$default = null;
                if (str != null) {
                    commonInitAwaitingGetHeaderBiddingToken.tokenFailure(i, str2, shortenedStackTrace$default);
                } else {
                    commonInitAwaitingGetHeaderBiddingToken.tokenSuccess(i, str);
                }
                return Unit.INSTANCE;
            }
        }
        commonInitAwaitingGetHeaderBiddingToken$fetchToken$1 = new CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1(this, continuation);
        Object obj2 = commonInitAwaitingGetHeaderBiddingToken$fetchToken$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = commonInitAwaitingGetHeaderBiddingToken$fetchToken$1.label;
        str = null;
        if (i2 != 0) {
        }
        str2 = null;
        str = (String) obj2;
        shortenedStackTrace$default = null;
        if (str != null) {
        }
        return Unit.INSTANCE;
    }

    private final void tokenSuccess(int tokenNumber, final String token) {
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_gateway_token_success_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(this.startTime))), MapsKt.mapOf(TuplesKt.to("sync", "false"), TuplesKt.to("state", String.valueOf(this.startState)), TuplesKt.to("complete_state", GetInitializationState.DefaultImpls.invoke$default(this.getInitializationState, false, 1, null).toString()), TuplesKt.to("awaited_init", String.valueOf(this.didAwaitInit))), null, null, Integer.valueOf(tokenNumber), 24, null);
        this.safeCallbackInvoke.invoke(new Function0<Unit>() { // from class: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$tokenSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IUnityAdsTokenListener listener = CommonInitAwaitingGetHeaderBiddingToken.this.getListener();
                if (listener != null) {
                    listener.onUnityAdsTokenReady(token);
                }
            }
        });
    }

    static /* synthetic */ void tokenFailure$default(CommonInitAwaitingGetHeaderBiddingToken commonInitAwaitingGetHeaderBiddingToken, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        commonInitAwaitingGetHeaderBiddingToken.tokenFailure(i, str, str2);
    }

    private final void tokenFailure(int tokenNumber, String reason, String reasonDebug) {
        SendDiagnosticEvent sendDiagnosticEvent = this.sendDiagnosticEvent;
        Double valueOf = Double.valueOf(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(this.startTime)));
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put("sync", "false");
        createMapBuilder.put("state", String.valueOf(this.startState));
        createMapBuilder.put("complete_state", GetInitializationState.DefaultImpls.invoke$default(this.getInitializationState, false, 1, null).toString());
        createMapBuilder.put("awaited_init", String.valueOf(this.didAwaitInit));
        if (reason != null) {
        }
        if (reasonDebug != null) {
            createMapBuilder.put("reason_debug", reasonDebug);
        }
        Unit unit = Unit.INSTANCE;
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_gateway_token_failure_time", valueOf, MapsKt.build(createMapBuilder), null, null, Integer.valueOf(tokenNumber), 24, null);
        this.safeCallbackInvoke.invoke(new Function0<Unit>() { // from class: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$tokenFailure$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IUnityAdsTokenListener listener = CommonInitAwaitingGetHeaderBiddingToken.this.getListener();
                if (listener != null) {
                    listener.onUnityAdsTokenReady(null);
                }
            }
        });
    }

    private final void tokenStart(int tokenNumber) {
        this.startState = GetInitializationState.DefaultImpls.invoke$default(this.getInitializationState, false, 1, null);
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_gateway_token_started", null, MapsKt.mapOf(TuplesKt.to("sync", "false"), TuplesKt.to("state", String.valueOf(this.startState))), null, null, Integer.valueOf(tokenNumber), 26, null);
    }
}
