package com.unity3d.ads.core.data.datasource;

import androidx.datastore.core.CorruptionException;
import com.unity3d.ads.datastore.WebviewConfigurationStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WebviewConfigurationDataSource.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/unity3d/ads/datastore/WebviewConfigurationStore$WebViewConfigurationStore;", "exception", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource$get$2", f = "WebviewConfigurationDataSource.kt", i = {}, l = {15}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class WebviewConfigurationDataSource$get$2 extends SuspendLambda implements Function3<FlowCollector<? super WebviewConfigurationStore.WebViewConfigurationStore>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    WebviewConfigurationDataSource$get$2(Continuation<? super WebviewConfigurationDataSource$get$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super WebviewConfigurationStore.WebViewConfigurationStore> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        WebviewConfigurationDataSource$get$2 webviewConfigurationDataSource$get$2 = new WebviewConfigurationDataSource$get$2(continuation);
        webviewConfigurationDataSource$get$2.L$0 = flowCollector;
        webviewConfigurationDataSource$get$2.L$1 = th;
        return webviewConfigurationDataSource$get$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            if (th instanceof CorruptionException) {
                WebviewConfigurationStore.WebViewConfigurationStore defaultInstance = WebviewConfigurationStore.WebViewConfigurationStore.getDefaultInstance();
                Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance()");
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(defaultInstance, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
