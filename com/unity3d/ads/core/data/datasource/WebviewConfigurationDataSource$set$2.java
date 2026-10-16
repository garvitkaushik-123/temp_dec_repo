package com.unity3d.ads.core.data.datasource;

import com.unity3d.ads.datastore.WebviewConfigurationStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WebviewConfigurationDataSource.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/datastore/WebviewConfigurationStore$WebViewConfigurationStore;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource$set$2", f = "WebviewConfigurationDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class WebviewConfigurationDataSource$set$2 extends SuspendLambda implements Function2<WebviewConfigurationStore.WebViewConfigurationStore, Continuation<? super WebviewConfigurationStore.WebViewConfigurationStore>, Object> {
    final /* synthetic */ WebviewConfigurationStore.WebViewConfigurationStore $data;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebviewConfigurationDataSource$set$2(WebviewConfigurationStore.WebViewConfigurationStore webViewConfigurationStore, Continuation<? super WebviewConfigurationDataSource$set$2> continuation) {
        super(2, continuation);
        this.$data = webViewConfigurationStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebviewConfigurationDataSource$set$2(this.$data, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WebviewConfigurationStore.WebViewConfigurationStore webViewConfigurationStore, Continuation<? super WebviewConfigurationStore.WebViewConfigurationStore> continuation) {
        return ((WebviewConfigurationDataSource$set$2) create(webViewConfigurationStore, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.$data;
    }
}
