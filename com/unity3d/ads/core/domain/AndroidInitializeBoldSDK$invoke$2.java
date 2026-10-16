package com.unity3d.ads.core.domain;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.exception.GatewayException;
import com.unity3d.ads.core.data.model.exception.InitializationException;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.TimeSource;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidInitializeBoldSDK.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2", f = "AndroidInitializeBoldSDK.kt", i = {0, 0}, l = {66, 83}, m = "invokeSuspend", n = {"startTime", "isRetry"}, s = {"J$0", "I$0"})
/* loaded from: classes7.dex */
final class AndroidInitializeBoldSDK$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $source;
    int I$0;
    long J$0;
    int label;
    final /* synthetic */ AndroidInitializeBoldSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidInitializeBoldSDK$invoke$2(AndroidInitializeBoldSDK androidInitializeBoldSDK, String str, Continuation<? super AndroidInitializeBoldSDK$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = androidInitializeBoldSDK;
        this.$source = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidInitializeBoldSDK$invoke$2(this.this$0, this.$source, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidInitializeBoldSDK$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006e, code lost:
    
        if (r12 == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.withTimeout(com.unity3d.services.UnityAdsConstants.Timeout.INIT_TIMEOUT_MS, new com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2.AnonymousClass1(r11.this$0, r11.$source, !r12, null), r11) == r0) goto L23;
     */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlin.time.TimeMark, kotlin.time.TimeSource$Monotonic$ValueTimeMark, long] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SessionRepository sessionRepository;
        long m11706markNowz9LOYto;
        SessionRepository sessionRepository2;
        ?? m11707boximpl;
        Object initializationSuccess;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                sessionRepository2 = this.this$0.sessionRepository;
                boolean isFirstInitAttempt = sessionRepository2.isFirstInitAttempt();
                i = !isFirstInitAttempt ? 1 : 0;
                this.J$0 = m11706markNowz9LOYto;
                this.I$0 = i;
                this.label = 1;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                i = this.I$0;
                m11706markNowz9LOYto = this.J$0;
                ResultKt.throwOnFailure(obj);
            }
            AndroidInitializeBoldSDK androidInitializeBoldSDK = this.this$0;
            m11707boximpl = TimeSource.Monotonic.ValueTimeMark.m11707boximpl(m11706markNowz9LOYto);
            String str = this.$source;
            boolean z = i != 0;
            this.label = 2;
            initializationSuccess = androidInitializeBoldSDK.initializationSuccess(m11707boximpl, str, z, this);
        } catch (Exception e) {
            InitializationException parseFrom = InitializationException.INSTANCE.parseFrom(e);
            if (e instanceof GatewayException) {
                sessionRepository = this.this$0.sessionRepository;
                sessionRepository.setShouldInitialize(false);
            }
            this.this$0.initializationFailure(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(m11707boximpl), parseFrom, this.$source, i != 0);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AndroidInitializeBoldSDK.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2$1", f = "AndroidInitializeBoldSDK.kt", i = {}, l = {67, 69, 71, TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isRetry;
        final /* synthetic */ String $source;
        int label;
        final /* synthetic */ AndroidInitializeBoldSDK this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AndroidInitializeBoldSDK androidInitializeBoldSDK, String str, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = androidInitializeBoldSDK;
            this.$source = str;
            this.$isRetry = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$source, this.$isRetry, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x008a, code lost:
        
            if (r13 == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x008c, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x007a, code lost:
        
            if (r13 == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
        
            if (r13 == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
        
            if (r13 == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object initializationStart;
            GetInitializationRequest getInitializationRequest;
            GetRequestPolicy getRequestPolicy;
            GatewayClient gatewayClient;
            Object handleResponse;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                initializationStart = this.this$0.initializationStart(this.$source, this.$isRetry, this);
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                UniversalRequestOuterClass.UniversalRequest universalRequest = (UniversalRequestOuterClass.UniversalRequest) obj;
                getRequestPolicy = this.this$0.getRequestPolicy;
                RequestPolicy invoke = getRequestPolicy.invoke();
                gatewayClient = this.this$0.gatewayClient;
                this.label = 3;
                obj = GatewayClient.DefaultImpls.request$default(gatewayClient, null, universalRequest, invoke, OperationType.INITIALIZATION, this, 1, null);
            } else {
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                AndroidInitializeBoldSDK androidInitializeBoldSDK = this.this$0;
                this.label = 4;
                handleResponse = androidInitializeBoldSDK.handleResponse((UniversalResponseOuterClass.UniversalResponse) obj, this);
            }
            this.this$0.checkCanInitialize();
            getInitializationRequest = this.this$0.getInitializeRequest;
            this.label = 2;
            obj = getInitializationRequest.invoke(this);
        }
    }
}
