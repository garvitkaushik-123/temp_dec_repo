package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.service_locator.a;
import io.ktor.client.HttpClient;
import io.ktor.http.ContentType;
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

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"Lcom/moloco/sdk/xenoss/sdkdevkit/android/persistenttransport/UrlPostRequestWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moloco-sdk_release", "url", ""}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UrlPostRequestWorker extends CoroutineWorker {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f6361a = {Reflection.property0(new PropertyReference0Impl(UrlPostRequestWorker.class, "url", "<v#0>", 0))};
    public static final int b = 0;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlPostRequestWorker", f = "PersistentHttpRequest.kt", i = {0, 0}, l = {105}, m = "doWork", n = {"this", "url$delegate"}, s = {"L$0", "L$1"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6362a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return UrlPostRequestWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlPostRequestWorker(Context context, WorkerParameters params) {
        super(com.moloco.sdk.internal.android_context.b.a(context), params);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public static final String a(Map<String, Object> map) {
        Intrinsics.checkNotNull(map);
        return (String) MapsKt.getOrImplicitDefaultNullable(map, f6361a[0].getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        a aVar;
        int i;
        ContentType parse;
        Map<String, Object> map;
        UrlPostRequestWorker urlPostRequestWorker;
        boolean booleanValue;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.e = i2 - Integer.MIN_VALUE;
                a aVar2 = aVar;
                Object obj = aVar2.c;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar2.e;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HttpClient a2 = a.i.f5757a.a();
                    Map<String, Object> keyValueMap = getInputData().getKeyValueMap();
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, j.d, "Sending request to " + a(keyValueMap), null, false, 12, null);
                    byte[] byteArray = getInputData().getByteArray("body");
                    if (byteArray == null) {
                        ListenableWorker.Result failure = ListenableWorker.Result.failure();
                        Intrinsics.checkNotNullExpressionValue(failure, "failure(...)");
                        return failure;
                    }
                    String string = getInputData().getString("contentType");
                    if (string == null || (parse = ContentType.INSTANCE.parse(string)) == null) {
                        ListenableWorker.Result failure2 = ListenableWorker.Result.failure();
                        Intrinsics.checkNotNullExpressionValue(failure2, "failure(...)");
                        return failure2;
                    }
                    String string2 = getInputData().getString(j.e);
                    String a3 = a(keyValueMap);
                    aVar2.f6362a = this;
                    aVar2.b = keyValueMap;
                    aVar2.e = 1;
                    Object a4 = e.a(a2, a3, byteArray, parse, string2, aVar2);
                    if (a4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    map = keyValueMap;
                    obj = a4;
                    urlPostRequestWorker = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    map = (Map) aVar2.b;
                    urlPostRequestWorker = (UrlPostRequestWorker) aVar2.f6362a;
                    ResultKt.throwOnFailure(obj);
                }
                booleanValue = ((Boolean) obj).booleanValue();
                MolocoLogger.info$default(MolocoLogger.INSTANCE, j.d, "Request to " + a(map) + " was successful: " + booleanValue, null, false, 12, null);
                if (!booleanValue) {
                    ListenableWorker.Result success = ListenableWorker.Result.success();
                    Intrinsics.checkNotNullExpressionValue(success, "success(...)");
                    return success;
                }
                if (urlPostRequestWorker.getRunAttemptCount() >= 5) {
                    ListenableWorker.Result failure3 = ListenableWorker.Result.failure();
                    Intrinsics.checkNotNullExpressionValue(failure3, "failure(...)");
                    return failure3;
                }
                ListenableWorker.Result retry = ListenableWorker.Result.retry();
                Intrinsics.checkNotNullExpressionValue(retry, "retry(...)");
                return retry;
            }
        }
        aVar = new a(continuation);
        a aVar22 = aVar;
        Object obj2 = aVar22.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar22.e;
        if (i != 0) {
        }
        booleanValue = ((Boolean) obj2).booleanValue();
        MolocoLogger.info$default(MolocoLogger.INSTANCE, j.d, "Request to " + a(map) + " was successful: " + booleanValue, null, false, 12, null);
        if (!booleanValue) {
        }
    }
}
