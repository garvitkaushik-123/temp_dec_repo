package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidHttpClientProvider.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHttpClientProvider", f = "AndroidHttpClientProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {177, 78}, m = "invoke", n = {"this", "$this$withLock_u24default$iv", "gatewaySpecific", "this", "$this$withLock_u24default$iv", "gatewaySpecific", "startTime", "usingRefactoredGatewayClient"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "J$0", "I$0"})
/* loaded from: classes7.dex */
final class AndroidHttpClientProvider$invoke$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidHttpClientProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidHttpClientProvider$invoke$1(AndroidHttpClientProvider androidHttpClientProvider, Continuation<? super AndroidHttpClientProvider$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidHttpClientProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(false, this);
    }
}
