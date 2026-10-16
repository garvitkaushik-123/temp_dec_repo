package com.unity3d.ads.core.domain;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidHttpClientProvider.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/services/core/configuration/Configuration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHttpClientProvider$invoke$2$httpClient$config$1", f = "AndroidHttpClientProvider.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidHttpClientProvider$invoke$2$httpClient$config$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Configuration>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidHttpClientProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidHttpClientProvider$invoke$2$httpClient$config$1(AndroidHttpClientProvider androidHttpClientProvider, Continuation<? super AndroidHttpClientProvider$invoke$2$httpClient$config$1> continuation) {
        super(2, continuation);
        this.this$0 = androidHttpClientProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidHttpClientProvider$invoke$2$httpClient$config$1 androidHttpClientProvider$invoke$2$httpClient$config$1 = new AndroidHttpClientProvider$invoke$2$httpClient$config$1(this.this$0, continuation);
        androidHttpClientProvider$invoke$2$httpClient$config$1.L$0 = obj;
        return androidHttpClientProvider$invoke$2$httpClient$config$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Configuration> continuation) {
        return ((AndroidHttpClientProvider$invoke$2$httpClient$config$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m10241constructorimpl;
        ConfigFileFromLocalStorage configFileFromLocalStorage;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AndroidHttpClientProvider androidHttpClientProvider = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                configFileFromLocalStorage = androidHttpClientProvider.configFileFromLocalStorage;
                ConfigFileFromLocalStorage.Params params = new ConfigFileFromLocalStorage.Params(null, 1, null);
                this.label = 1;
                obj2 = configFileFromLocalStorage.mo9272invokegIAlus(params, this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                obj2 = ((Result) obj).getValue();
            }
            m10241constructorimpl = Result.m10241constructorimpl(Result.m10240boximpl(obj2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        Result result = (Result) m10241constructorimpl;
        if (result == null) {
            return null;
        }
        Object value = result.getValue();
        return (Configuration) (Result.m10247isFailureimpl(value) ? null : value);
    }
}
