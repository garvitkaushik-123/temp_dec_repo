package com.unity3d.ads.core.domain.events;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import com.unity3d.ads.core.domain.work.DiagnosticEventJob;
import com.unity3d.ads.core.domain.work.UniversalRequestWorkerData;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import java.util.List;
import java.util.UUID;
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

/* compiled from: DiagnosticEventObserver.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2", f = "DiagnosticEventObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class DiagnosticEventObserver$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiagnosticEventObserver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiagnosticEventObserver$invoke$2(DiagnosticEventObserver diagnosticEventObserver, Continuation<? super DiagnosticEventObserver$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = diagnosticEventObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiagnosticEventObserver$invoke$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DiagnosticEventObserver$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        Boolean bool;
        DiagnosticEventRepository diagnosticEventRepository;
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
            diagnosticEventRepository = this.this$0.diagnosticEventRepository;
            Flow onEach = FlowKt.onEach(diagnosticEventRepository.getDiagnosticEvents(), new AnonymousClass2(this.this$0, null));
            coroutineDispatcher = this.this$0.defaultDispatcher;
            FlowKt.launchIn(onEach, CoroutineScopeKt.CoroutineScope(coroutineDispatcher));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* compiled from: DiagnosticEventObserver.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "currentDiagnosticEventRequest", "", "Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2$2", f = "DiagnosticEventObserver.kt", i = {1}, l = {42, 45}, m = "invokeSuspend", n = {"workId"}, s = {"L$0"})
    /* renamed from: com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<List<? extends DiagnosticEventRequestOuterClass.DiagnosticEvent>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DiagnosticEventObserver this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DiagnosticEventObserver diagnosticEventObserver, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = diagnosticEventObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(List<? extends DiagnosticEventRequestOuterClass.DiagnosticEvent> list, Continuation<? super Unit> continuation) {
            return invoke2((List<DiagnosticEventRequestOuterClass.DiagnosticEvent>) list, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(List<DiagnosticEventRequestOuterClass.DiagnosticEvent> list, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            if (r8 == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            GetDiagnosticEventBatchRequest getDiagnosticEventBatchRequest;
            GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
            UniversalRequestDataSource universalRequestDataSource;
            String str;
            BackgroundWorker backgroundWorker;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<DiagnosticEventRequestOuterClass.DiagnosticEvent> list = (List) this.L$0;
                UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                DiagnosticEventObserver diagnosticEventObserver = this.this$0;
                UniversalRequestKt.PayloadKt.Dsl.Companion companion = UniversalRequestKt.PayloadKt.Dsl.INSTANCE;
                UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                UniversalRequestKt.PayloadKt.Dsl _create = companion._create(newBuilder);
                getDiagnosticEventBatchRequest = diagnosticEventObserver.getDiagnosticEventBatchRequest;
                _create.setDiagnosticEventRequest(getDiagnosticEventBatchRequest.invoke(list));
                UniversalRequestOuterClass.UniversalRequest.Payload _build = _create._build();
                getUniversalRequestForPayLoad = this.this$0.getUniversalRequestForPayLoad;
                this.label = 1;
                obj = getUniversalRequestForPayLoad.invoke(_build, this);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    UniversalRequestWorkerData universalRequestWorkerData = new UniversalRequestWorkerData(str);
                    backgroundWorker = this.this$0.backgroundWorker;
                    Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                    Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…TED)\n            .build()");
                    OneTimeWorkRequest build2 = new OneTimeWorkRequest.Builder(DiagnosticEventJob.class).setConstraints(build).setInputData(universalRequestWorkerData.invoke()).addTag(BackgroundWorker.TAG).build();
                    Intrinsics.checkNotNullExpressionValue(build2, "OneTimeWorkRequestBuilde…TAG)\n            .build()");
                    backgroundWorker.getWorkManager().enqueue(build2);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            universalRequestDataSource = this.this$0.universalRequestDataSource;
            byte[] byteArray = ((UniversalRequestOuterClass.UniversalRequest) obj).toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "fullRequest.toByteArray()");
            this.L$0 = uuid;
            this.label = 2;
            if (universalRequestDataSource.set(uuid, ByteStringsKt.toByteString(byteArray), this) != coroutine_suspended) {
                str = uuid;
                UniversalRequestWorkerData universalRequestWorkerData2 = new UniversalRequestWorkerData(str);
                backgroundWorker = this.this$0.backgroundWorker;
                Constraints build3 = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                Intrinsics.checkNotNullExpressionValue(build3, "Builder()\n            .s…TED)\n            .build()");
                OneTimeWorkRequest build22 = new OneTimeWorkRequest.Builder(DiagnosticEventJob.class).setConstraints(build3).setInputData(universalRequestWorkerData2.invoke()).addTag(BackgroundWorker.TAG).build();
                Intrinsics.checkNotNullExpressionValue(build22, "OneTimeWorkRequestBuilde…TAG)\n            .build()");
                backgroundWorker.getWorkManager().enqueue(build22);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }
}
