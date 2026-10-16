package com.unity3d.ads.core.domain.work;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.domain.events.UniversalRequestEventSender;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: UniversalRequestJob.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u001b\u001a\u00020\u001cH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/unity3d/ads/core/domain/work/UniversalRequestJob;", "Landroidx/work/CoroutineWorker;", "Lcom/unity3d/services/core/di/IServiceComponent;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "requestPolicy", "Lcom/unity3d/ads/gatewayclient/RequestPolicy;", "getRequestPolicy", "()Lcom/unity3d/ads/gatewayclient/RequestPolicy;", "setRequestPolicy", "(Lcom/unity3d/ads/gatewayclient/RequestPolicy;)V", "universalRequestDataSource", "Lcom/unity3d/ads/core/data/datasource/UniversalRequestDataSource;", "getUniversalRequestDataSource", "()Lcom/unity3d/ads/core/data/datasource/UniversalRequestDataSource;", "universalRequestDataSource$delegate", "Lkotlin/Lazy;", "universalRequestEventSender", "Lcom/unity3d/ads/core/domain/events/UniversalRequestEventSender;", "getUniversalRequestEventSender", "()Lcom/unity3d/ads/core/domain/events/UniversalRequestEventSender;", "universalRequestEventSender$delegate", "getWorkerParams", "()Landroidx/work/WorkerParameters;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public abstract class UniversalRequestJob extends CoroutineWorker implements IServiceComponent {
    public RequestPolicy requestPolicy;

    /* renamed from: universalRequestDataSource$delegate, reason: from kotlin metadata */
    private final Lazy universalRequestDataSource;

    /* renamed from: universalRequestEventSender$delegate, reason: from kotlin metadata */
    private final Lazy universalRequestEventSender;
    private final WorkerParameters workerParams;

    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        return doWork$suspendImpl(this, continuation);
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    protected final WorkerParameters getWorkerParams() {
        return this.workerParams;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniversalRequestJob(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.workerParams = workerParams;
        final UniversalRequestJob universalRequestJob = this;
        final String str = "";
        this.universalRequestEventSender = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<UniversalRequestEventSender>() { // from class: com.unity3d.ads.core.domain.work.UniversalRequestJob$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.events.UniversalRequestEventSender, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final UniversalRequestEventSender invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(UniversalRequestEventSender.class));
            }
        });
        this.universalRequestDataSource = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<UniversalRequestDataSource>() { // from class: com.unity3d.ads.core.domain.work.UniversalRequestJob$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.data.datasource.UniversalRequestDataSource, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final UniversalRequestDataSource invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(UniversalRequestDataSource.class));
            }
        });
    }

    public final RequestPolicy getRequestPolicy() {
        RequestPolicy requestPolicy = this.requestPolicy;
        if (requestPolicy != null) {
            return requestPolicy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("requestPolicy");
        return null;
    }

    public final void setRequestPolicy(RequestPolicy requestPolicy) {
        Intrinsics.checkNotNullParameter(requestPolicy, "<set-?>");
        this.requestPolicy = requestPolicy;
    }

    public final UniversalRequestEventSender getUniversalRequestEventSender() {
        return (UniversalRequestEventSender) this.universalRequestEventSender.getValue();
    }

    public final UniversalRequestDataSource getUniversalRequestDataSource() {
        return (UniversalRequestDataSource) this.universalRequestDataSource.getValue();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(2:3|(10:5|6|7|(1:(1:(1:(3:12|13|14)(2:16|17))(5:18|19|20|21|(1:23)(2:26|27)))(1:29))(2:34|(2:36|37)(3:38|(1:40)|25))|30|31|(2:33|25)|20|21|(0)(0)))|43|6|7|(0)(0)|30|31|(0)|20|21|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00cf, code lost:
    
        if (r9.remove(r8, r0) == r1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0045, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b0, code lost:
    
        r4 = kotlin.Result.INSTANCE;
        r9 = kotlin.Result.m10241constructorimpl(kotlin.ResultKt.createFailure(r9));
        r2 = r2;
        r8 = r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v16, types: [com.unity3d.ads.datastore.UniversalRequestStoreOuterClass$UniversalRequestStore] */
    /* JADX WARN: Type inference failed for: r9v8, types: [com.unity3d.ads.core.data.datasource.UniversalRequestDataSource] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object doWork$suspendImpl(UniversalRequestJob universalRequestJob, Continuation<? super ListenableWorker.Result> continuation) {
        UniversalRequestJob$doWork$1 universalRequestJob$doWork$1;
        Object coroutine_suspended;
        ?? r2;
        Object m10241constructorimpl;
        UniversalRequestJob universalRequestJob2;
        ?? r8;
        UniversalRequestOuterClass.UniversalRequest universalRequest;
        UniversalRequestEventSender universalRequestEventSender;
        RequestPolicy requestPolicy;
        if (continuation instanceof UniversalRequestJob$doWork$1) {
            universalRequestJob$doWork$1 = (UniversalRequestJob$doWork$1) continuation;
            if ((universalRequestJob$doWork$1.label & Integer.MIN_VALUE) != 0) {
                universalRequestJob$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = universalRequestJob$doWork$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                r2 = universalRequestJob$doWork$1.label;
                if (r2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String string = universalRequestJob.workerParams.getInputData().getString(UniversalRequestWorkerData.KEY_UNIVERSAL_REQUEST_ID);
                    if (string == null) {
                        ListenableWorker.Result success = ListenableWorker.Result.success();
                        Intrinsics.checkNotNullExpressionValue(success, "success()");
                        return success;
                    }
                    UniversalRequestDataSource universalRequestDataSource = universalRequestJob.getUniversalRequestDataSource();
                    universalRequestJob$doWork$1.L$0 = universalRequestJob;
                    universalRequestJob$doWork$1.L$1 = string;
                    universalRequestJob$doWork$1.label = 1;
                    Object obj2 = universalRequestDataSource.get(universalRequestJob$doWork$1);
                    if (obj2 != coroutine_suspended) {
                        universalRequestJob2 = universalRequestJob;
                        r8 = string;
                        obj = obj2;
                    }
                    return coroutine_suspended;
                }
                if (r2 == 1) {
                    String str = (String) universalRequestJob$doWork$1.L$1;
                    UniversalRequestJob universalRequestJob3 = (UniversalRequestJob) universalRequestJob$doWork$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    universalRequestJob2 = universalRequestJob3;
                    r8 = str;
                } else {
                    if (r2 != 2) {
                        if (r2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        ListenableWorker.Result success2 = ListenableWorker.Result.success();
                        Intrinsics.checkNotNullExpressionValue(success2, "{\n            universalR…esult.success()\n        }");
                        return success2;
                    }
                    ?? r82 = (String) universalRequestJob$doWork$1.L$1;
                    UniversalRequestJob universalRequestJob4 = (UniversalRequestJob) universalRequestJob$doWork$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    r2 = universalRequestJob4;
                    universalRequestJob = r82;
                    m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                    UniversalRequestJob universalRequestJob5 = r2;
                    ?? r83 = universalRequestJob;
                    if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                        ?? universalRequestDataSource2 = universalRequestJob5.getUniversalRequestDataSource();
                        universalRequestJob$doWork$1.L$0 = null;
                        universalRequestJob$doWork$1.L$1 = null;
                        universalRequestJob$doWork$1.label = 3;
                    } else {
                        ListenableWorker.Result retry = ListenableWorker.Result.retry();
                        Intrinsics.checkNotNullExpressionValue(retry, "{\n            Result.retry()\n        }");
                        return retry;
                    }
                }
                universalRequest = UniversalRequestOuterClass.UniversalRequest.parseFrom(((UniversalRequestStoreOuterClass.UniversalRequestStore) obj).getUniversalRequestMapOrThrow(r8));
                Result.Companion companion = Result.INSTANCE;
                universalRequestEventSender = universalRequestJob2.getUniversalRequestEventSender();
                Intrinsics.checkNotNullExpressionValue(universalRequest, "universalRequest");
                requestPolicy = universalRequestJob2.getRequestPolicy();
                universalRequestJob$doWork$1.L$0 = universalRequestJob2;
                universalRequestJob$doWork$1.L$1 = r8;
                universalRequestJob$doWork$1.label = 2;
                r2 = universalRequestJob2;
                universalRequestJob = r8;
                if (universalRequestEventSender.invoke(universalRequest, requestPolicy, universalRequestJob$doWork$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                UniversalRequestJob universalRequestJob52 = r2;
                ?? r832 = universalRequestJob;
                if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                }
            }
        }
        universalRequestJob$doWork$1 = new UniversalRequestJob$doWork$1(universalRequestJob, continuation);
        Object obj3 = universalRequestJob$doWork$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = universalRequestJob$doWork$1.label;
        if (r2 != 0) {
        }
        universalRequest = UniversalRequestOuterClass.UniversalRequest.parseFrom(((UniversalRequestStoreOuterClass.UniversalRequestStore) obj3).getUniversalRequestMapOrThrow(r8));
        Result.Companion companion2 = Result.INSTANCE;
        universalRequestEventSender = universalRequestJob2.getUniversalRequestEventSender();
        Intrinsics.checkNotNullExpressionValue(universalRequest, "universalRequest");
        requestPolicy = universalRequestJob2.getRequestPolicy();
        universalRequestJob$doWork$1.L$0 = universalRequestJob2;
        universalRequestJob$doWork$1.L$1 = r8;
        universalRequestJob$doWork$1.label = 2;
        r2 = universalRequestJob2;
        universalRequestJob = r8;
        if (universalRequestEventSender.invoke(universalRequest, requestPolicy, universalRequestJob$doWork$1) == coroutine_suspended) {
        }
        m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        UniversalRequestJob universalRequestJob522 = r2;
        ?? r8322 = universalRequestJob;
        if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
        }
    }
}
