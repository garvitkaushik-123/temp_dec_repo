package com.unity3d.ads.core.domain.events;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.repository.TransactionEventRepository;
import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.gatewayclient.GatewayClient;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: TransactionEventObserver.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2", f = "TransactionEventObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class TransactionEventObserver$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TransactionEventObserver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransactionEventObserver$invoke$2(TransactionEventObserver transactionEventObserver, Continuation<? super TransactionEventObserver$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = transactionEventObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransactionEventObserver$invoke$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransactionEventObserver$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        Boolean bool;
        TransactionEventRepository transactionEventRepository;
        CoroutineDispatcher coroutineDispatcher;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.isRunning;
            do {
                value = mutableStateFlow.getValue();
                bool = (Boolean) value;
                bool.booleanValue();
            } while (!mutableStateFlow.compareAndSet(value, Boxing.boxBoolean(true)));
            if (bool.booleanValue()) {
                return Unit.INSTANCE;
            }
            transactionEventRepository = this.this$0.transactionEventRepository;
            Flow onEach = FlowKt.onEach(transactionEventRepository.getTransactionEvents(), new AnonymousClass2(this.this$0, null));
            coroutineDispatcher = this.this$0.defaultDispatcher;
            FlowKt.launchIn(onEach, CoroutineScopeKt.CoroutineScope(coroutineDispatcher));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* compiled from: TransactionEventObserver.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "currentTransactionEventRequest", "Lgatewayprotocol/v1/TransactionEventRequestOuterClass$TransactionEventRequest;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2$2", f = "TransactionEventObserver.kt", i = {1}, l = {44, 46, 55}, m = "invokeSuspend", n = {"fullRequest"}, s = {"L$0"})
    /* renamed from: com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<TransactionEventRequestOuterClass.TransactionEventRequest, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TransactionEventObserver this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TransactionEventObserver transactionEventObserver, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = transactionEventObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransactionEventRequestOuterClass.TransactionEventRequest transactionEventRequest, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(transactionEventRequest, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x00b1, code lost:
        
            if (r13.set(r1, r12) == r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
        
            if (r13 == r0) goto L23;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
            GatewayClient gatewayClient;
            GetRequestPolicy getRequestPolicy;
            UniversalRequestOuterClass.UniversalRequest universalRequest;
            ByteStringDataSource byteStringDataSource;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TransactionEventRequestOuterClass.TransactionEventRequest transactionEventRequest = (TransactionEventRequestOuterClass.TransactionEventRequest) this.L$0;
                UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                UniversalRequestKt.PayloadKt.Dsl.Companion companion = UniversalRequestKt.PayloadKt.Dsl.INSTANCE;
                UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                UniversalRequestKt.PayloadKt.Dsl _create = companion._create(newBuilder);
                _create.setTransactionEventRequest(transactionEventRequest);
                UniversalRequestOuterClass.UniversalRequest.Payload _build = _create._build();
                getUniversalRequestForPayLoad = this.this$0.getUniversalRequestForPayLoad;
                this.label = 1;
                obj = getUniversalRequestForPayLoad.invoke(_build, this);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    universalRequest = (UniversalRequestOuterClass.UniversalRequest) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((UniversalResponseOuterClass.UniversalResponse) obj).getError() != null) {
                        byteStringDataSource = this.this$0.iapTransactionStore;
                        ByteString byteString = universalRequest.getSharedData().getTimestamps().getTimestamp().toByteString();
                        Intrinsics.checkNotNullExpressionValue(byteString, "fullRequest.sharedData.t….timestamp.toByteString()");
                        this.L$0 = null;
                        this.label = 3;
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            UniversalRequestOuterClass.UniversalRequest universalRequest2 = (UniversalRequestOuterClass.UniversalRequest) obj;
            gatewayClient = this.this$0.gatewayClient;
            getRequestPolicy = this.this$0.getRequestPolicy;
            this.L$0 = universalRequest2;
            this.label = 2;
            obj = GatewayClient.DefaultImpls.request$default(gatewayClient, null, universalRequest2, getRequestPolicy.invoke(), OperationType.TRANSACTION_EVENT, this, 1, null);
            if (obj != coroutine_suspended) {
                universalRequest = universalRequest2;
                if (((UniversalResponseOuterClass.UniversalResponse) obj).getError() != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }
}
