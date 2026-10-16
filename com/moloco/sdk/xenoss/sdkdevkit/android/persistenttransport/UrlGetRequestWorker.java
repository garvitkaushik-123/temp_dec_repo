package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.service_locator.a;
import io.ktor.client.HttpClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"Lcom/moloco/sdk/xenoss/sdkdevkit/android/persistenttransport/UrlGetRequestWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moloco-sdk_release", "url", ""}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UrlGetRequestWorker extends CoroutineWorker {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f6359a = {Reflection.property0(new PropertyReference0Impl(UrlGetRequestWorker.class, "url", "<v#0>", 0))};
    public static final int b = 0;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlGetRequestWorker", f = "PersistentHttpRequest.kt", i = {0}, l = {84}, m = "doWork", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6360a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return UrlGetRequestWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlGetRequestWorker(Context context, WorkerParameters params) {
        super(com.moloco.sdk.internal.android_context.b.a(context), params);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public static final String a(Map<String, Object> map) {
        Intrinsics.checkNotNull(map);
        return (String) MapsKt.getOrImplicitDefaultNullable(map, f6359a[0].getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        a aVar;
        Object obj;
        int i;
        UrlGetRequestWorker urlGetRequestWorker;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.d = i2 - Integer.MIN_VALUE;
                obj = aVar.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar.d;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HttpClient a2 = a.i.f5757a.a();
                    Map<String, Object> keyValueMap = getInputData().getKeyValueMap();
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, j.d, "Sending request to " + a(keyValueMap), null, false, 12, null);
                    String a3 = a(keyValueMap);
                    aVar.f6360a = this;
                    aVar.d = 1;
                    obj = e.a(a2, a3, aVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    urlGetRequestWorker = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    urlGetRequestWorker = (UrlGetRequestWorker) aVar.f6360a;
                    ResultKt.throwOnFailure(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    ListenableWorker.Result success = ListenableWorker.Result.success();
                    Intrinsics.checkNotNullExpressionValue(success, "success(...)");
                    return success;
                }
                if (urlGetRequestWorker.getRunAttemptCount() >= 5) {
                    ListenableWorker.Result failure = ListenableWorker.Result.failure();
                    Intrinsics.checkNotNullExpressionValue(failure, "failure(...)");
                    return failure;
                }
                ListenableWorker.Result retry = ListenableWorker.Result.retry();
                Intrinsics.checkNotNullExpressionValue(retry, "retry(...)");
                return retry;
            }
        }
        aVar = new a(continuation);
        obj = aVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar.d;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }
}
