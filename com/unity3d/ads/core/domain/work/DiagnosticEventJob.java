package com.unity3d.ads.core.domain.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.domain.GetRequestPolicy;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.ServiceProvider;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DiagnosticEventJob.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0013\u001a\u00020\u0014H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/unity3d/ads/core/domain/work/DiagnosticEventJob;", "Lcom/unity3d/ads/core/domain/work/UniversalRequestJob;", "Lcom/unity3d/services/core/di/IServiceComponent;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "diagnosticEventRequestWorkModifier", "Lcom/unity3d/ads/core/domain/work/DiagnosticEventRequestWorkModifier;", "getDiagnosticEventRequestWorkModifier", "()Lcom/unity3d/ads/core/domain/work/DiagnosticEventRequestWorkModifier;", "diagnosticEventRequestWorkModifier$delegate", "Lkotlin/Lazy;", "getDiagnosticRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "getGetDiagnosticRequestPolicy", "()Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "getDiagnosticRequestPolicy$delegate", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DiagnosticEventJob extends UniversalRequestJob implements IServiceComponent {

    /* renamed from: diagnosticEventRequestWorkModifier$delegate, reason: from kotlin metadata */
    private final Lazy diagnosticEventRequestWorkModifier;

    /* renamed from: getDiagnosticRequestPolicy$delegate, reason: from kotlin metadata */
    private final Lazy getDiagnosticRequestPolicy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticEventJob(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        final DiagnosticEventJob diagnosticEventJob = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        final String str = ServiceProvider.NAMED_OTHER_REQ;
        this.getDiagnosticRequestPolicy = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<GetRequestPolicy>() { // from class: com.unity3d.ads.core.domain.work.DiagnosticEventJob$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetRequestPolicy, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetRequestPolicy invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(GetRequestPolicy.class));
            }
        });
        final String str2 = "";
        this.diagnosticEventRequestWorkModifier = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<DiagnosticEventRequestWorkModifier>() { // from class: com.unity3d.ads.core.domain.work.DiagnosticEventJob$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.work.DiagnosticEventRequestWorkModifier, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DiagnosticEventRequestWorkModifier invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str2, Reflection.getOrCreateKotlinClass(DiagnosticEventRequestWorkModifier.class));
            }
        });
    }

    private final GetRequestPolicy getGetDiagnosticRequestPolicy() {
        return (GetRequestPolicy) this.getDiagnosticRequestPolicy.getValue();
    }

    private final DiagnosticEventRequestWorkModifier getDiagnosticEventRequestWorkModifier() {
        return (DiagnosticEventRequestWorkModifier) this.diagnosticEventRequestWorkModifier.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.unity3d.ads.core.domain.work.UniversalRequestJob, androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        DiagnosticEventJob$doWork$1 diagnosticEventJob$doWork$1;
        Object coroutine_suspended;
        int i;
        String string;
        DiagnosticEventJob diagnosticEventJob;
        UniversalRequestDataSource universalRequestDataSource;
        ByteString byteString;
        DiagnosticEventJob diagnosticEventJob2;
        if (continuation instanceof DiagnosticEventJob$doWork$1) {
            diagnosticEventJob$doWork$1 = (DiagnosticEventJob$doWork$1) continuation;
            if ((diagnosticEventJob$doWork$1.label & Integer.MIN_VALUE) != 0) {
                diagnosticEventJob$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = diagnosticEventJob$doWork$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = diagnosticEventJob$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    string = getWorkerParams().getInputData().getString(UniversalRequestWorkerData.KEY_UNIVERSAL_REQUEST_ID);
                    if (string == null) {
                        ListenableWorker.Result success = ListenableWorker.Result.success();
                        Intrinsics.checkNotNullExpressionValue(success, "success()");
                        return success;
                    }
                    UniversalRequestDataSource universalRequestDataSource2 = getUniversalRequestDataSource();
                    diagnosticEventJob$doWork$1.L$0 = this;
                    diagnosticEventJob$doWork$1.L$1 = string;
                    diagnosticEventJob$doWork$1.label = 1;
                    obj = universalRequestDataSource2.get(diagnosticEventJob$doWork$1);
                    if (obj != coroutine_suspended) {
                        diagnosticEventJob = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    diagnosticEventJob2 = (DiagnosticEventJob) diagnosticEventJob$doWork$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    diagnosticEventJob2.setRequestPolicy(diagnosticEventJob2.getGetDiagnosticRequestPolicy().invoke());
                    diagnosticEventJob$doWork$1.L$0 = null;
                    diagnosticEventJob$doWork$1.label = 3;
                    Object doWork = super.doWork(diagnosticEventJob$doWork$1);
                    return doWork != coroutine_suspended ? coroutine_suspended : doWork;
                }
                string = (String) diagnosticEventJob$doWork$1.L$1;
                diagnosticEventJob = (DiagnosticEventJob) diagnosticEventJob$doWork$1.L$0;
                ResultKt.throwOnFailure(obj);
                UniversalRequestOuterClass.UniversalRequest universalRequest = UniversalRequestOuterClass.UniversalRequest.parseFrom(((UniversalRequestStoreOuterClass.UniversalRequestStore) obj).getUniversalRequestMapOrThrow(string));
                DiagnosticEventRequestWorkModifier diagnosticEventRequestWorkModifier = diagnosticEventJob.getDiagnosticEventRequestWorkModifier();
                Intrinsics.checkNotNullExpressionValue(universalRequest, "universalRequest");
                UniversalRequestOuterClass.UniversalRequest invoke = diagnosticEventRequestWorkModifier.invoke(universalRequest);
                universalRequestDataSource = diagnosticEventJob.getUniversalRequestDataSource();
                byteString = invoke.toByteString();
                Intrinsics.checkNotNullExpressionValue(byteString, "modifiedUniversalRequest.toByteString()");
                diagnosticEventJob$doWork$1.L$0 = diagnosticEventJob;
                diagnosticEventJob$doWork$1.L$1 = null;
                diagnosticEventJob$doWork$1.label = 2;
                if (universalRequestDataSource.set(string, byteString, diagnosticEventJob$doWork$1) != coroutine_suspended) {
                    diagnosticEventJob2 = diagnosticEventJob;
                    diagnosticEventJob2.setRequestPolicy(diagnosticEventJob2.getGetDiagnosticRequestPolicy().invoke());
                    diagnosticEventJob$doWork$1.L$0 = null;
                    diagnosticEventJob$doWork$1.label = 3;
                    Object doWork2 = super.doWork(diagnosticEventJob$doWork$1);
                    if (doWork2 != coroutine_suspended) {
                    }
                }
            }
        }
        diagnosticEventJob$doWork$1 = new DiagnosticEventJob$doWork$1(this, continuation);
        Object obj2 = diagnosticEventJob$doWork$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = diagnosticEventJob$doWork$1.label;
        if (i != 0) {
        }
        UniversalRequestOuterClass.UniversalRequest universalRequest2 = UniversalRequestOuterClass.UniversalRequest.parseFrom(((UniversalRequestStoreOuterClass.UniversalRequestStore) obj2).getUniversalRequestMapOrThrow(string));
        DiagnosticEventRequestWorkModifier diagnosticEventRequestWorkModifier2 = diagnosticEventJob.getDiagnosticEventRequestWorkModifier();
        Intrinsics.checkNotNullExpressionValue(universalRequest2, "universalRequest");
        UniversalRequestOuterClass.UniversalRequest invoke2 = diagnosticEventRequestWorkModifier2.invoke(universalRequest2);
        universalRequestDataSource = diagnosticEventJob.getUniversalRequestDataSource();
        byteString = invoke2.toByteString();
        Intrinsics.checkNotNullExpressionValue(byteString, "modifiedUniversalRequest.toByteString()");
        diagnosticEventJob$doWork$1.L$0 = diagnosticEventJob;
        diagnosticEventJob$doWork$1.L$1 = null;
        diagnosticEventJob$doWork$1.label = 2;
        if (universalRequestDataSource.set(string, byteString, diagnosticEventJob$doWork$1) != coroutine_suspended) {
        }
    }
}
