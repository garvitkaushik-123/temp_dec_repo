package com.moloco.sdk.publisher;

import com.moloco.sdk.Init;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.error.crash.a;
import com.moloco.sdk.internal.publisher.v;
import com.moloco.sdk.internal.publisher.w;
import com.moloco.sdk.internal.services.init.j;
import com.moloco.sdk.internal.services.init.n;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.init.MolocoInitParams;
import com.moloco.sdk.service_locator.a;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$initialize$1", f = "Moloco.kt", i = {}, l = {Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class Moloco$initialize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MolocoInitParams $initParam;
    final /* synthetic */ MolocoInitializationListener $listener;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Moloco$initialize$1(MolocoInitParams molocoInitParams, MolocoInitializationListener molocoInitializationListener, Continuation<? super Moloco$initialize$1> continuation) {
        super(2, continuation);
        this.$initParam = molocoInitParams;
        this.$listener = molocoInitializationListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Moloco$initialize$1(this.$initParam, this.$listener, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e5, code lost:
    
        if (r0 == r6) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e7, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
    
        if (r0 == r6) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
    
        if (r0.a(r15) == r6) goto L27;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        v initializationHandler;
        Object a2;
        Object updateAndroidClientMetricsOnInitSuccess;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "launched the scope to initialize sdk with thread name: " + Thread.currentThread().getName() + " and dispatcher DispatcherProvider().IO", null, false, 12, null);
            a b = a.d.f5752a.b();
            this.label = 1;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Moloco.INSTANCE.initializeILRD();
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Moloco SDK initialization success", null, false, 12, null);
                MolocoInitializationListener molocoInitializationListener = this.$listener;
                if (molocoInitializationListener != null) {
                    w.a(molocoInitializationListener, v.f.b());
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            a2 = obj;
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) a2;
            if (vVar instanceof v.a) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "Moloco", "Moloco SDK initialization failed", null, false, 12, null);
                MolocoInitializationListener molocoInitializationListener2 = this.$listener;
                if (molocoInitializationListener2 != null) {
                    w.a(molocoInitializationListener2, com.moloco.sdk.internal.publisher.v.f.a(((j) ((v.a) vVar).a()).toString()));
                }
                return Unit.INSTANCE;
            }
            if (!(vVar instanceof v.b)) {
                throw new NoWhenBranchMatchedException();
            }
            Moloco moloco = Moloco.INSTANCE;
            moloco.processInitConfigs((Init.SDKInitResponse) ((v.b) vVar).a());
            this.label = 3;
            updateAndroidClientMetricsOnInitSuccess = moloco.updateAndroidClientMetricsOnInitSuccess(this);
        }
        Moloco moloco2 = Moloco.INSTANCE;
        moloco2.initializeAndroidClientMetrics(this.$initParam);
        initializationHandler = moloco2.getInitializationHandler();
        String appKey = this.$initParam.getAppKey();
        MediationInfo mediationInfo = this.$initParam.getMediationInfo();
        n c = a.f.f5754a.c();
        MetricsRecorder create = MetricsRecorder.INSTANCE.create(this.$initParam.getMediationInfo().getName());
        this.label = 2;
        a2 = initializationHandler.a(appKey, mediationInfo, c, create, this);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Moloco$initialize$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
