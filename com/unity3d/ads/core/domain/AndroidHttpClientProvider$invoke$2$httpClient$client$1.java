package com.unity3d.ads.core.domain;

import android.content.Context;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.core.RefactoredOkHttp3Client;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;

/* compiled from: AndroidHttpClientProvider.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/services/core/network/core/HttpClient;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHttpClientProvider$invoke$2$httpClient$client$1", f = "AndroidHttpClientProvider.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidHttpClientProvider$invoke$2$httpClient$client$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpClient>, Object> {
    final /* synthetic */ boolean $usingRefactoredGatewayClient;
    int label;
    final /* synthetic */ AndroidHttpClientProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidHttpClientProvider$invoke$2$httpClient$client$1(boolean z, AndroidHttpClientProvider androidHttpClientProvider, Continuation<? super AndroidHttpClientProvider$invoke$2$httpClient$client$1> continuation) {
        super(2, continuation);
        this.$usingRefactoredGatewayClient = z;
        this.this$0 = androidHttpClientProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidHttpClientProvider$invoke$2$httpClient$client$1(this.$usingRefactoredGatewayClient, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpClient> continuation) {
        return ((AndroidHttpClientProvider$invoke$2$httpClient$client$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        ISDKDispatchers iSDKDispatchers;
        ISDKDispatchers iSDKDispatchers2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$usingRefactoredGatewayClient) {
                iSDKDispatchers2 = this.this$0.dispatchers;
                return new RefactoredOkHttp3Client(iSDKDispatchers2, new OkHttpClient());
            }
            AndroidHttpClientProvider androidHttpClientProvider = this.this$0;
            context = androidHttpClientProvider.context;
            iSDKDispatchers = this.this$0.dispatchers;
            this.label = 1;
            obj = androidHttpClientProvider.buildNetworkClient(context, iSDKDispatchers, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return (HttpClient) obj;
    }
}
