package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidHandleGatewayUniversalResponse.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayUniversalResponse", f = "AndroidHandleGatewayUniversalResponse.kt", i = {0, 0, 1, 1}, l = {35, 41, 44}, m = "invoke", n = {"this", "mutableData", "this", "mutableData"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes7.dex */
final class AndroidHandleGatewayUniversalResponse$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidHandleGatewayUniversalResponse this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidHandleGatewayUniversalResponse$invoke$1(AndroidHandleGatewayUniversalResponse androidHandleGatewayUniversalResponse, Continuation<? super AndroidHandleGatewayUniversalResponse$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidHandleGatewayUniversalResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}
