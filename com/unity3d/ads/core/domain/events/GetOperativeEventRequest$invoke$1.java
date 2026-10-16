package com.unity3d.ads.core.domain.events;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetOperativeEventRequest.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.events.GetOperativeEventRequest", f = "GetOperativeEventRequest.kt", i = {0, 0, 0}, l = {37}, m = "invoke", n = {"this", "adFormat", "$this$invoke_u24lambda_u242"}, s = {"L$0", "L$1", "L$3"})
/* loaded from: classes7.dex */
final class GetOperativeEventRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetOperativeEventRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetOperativeEventRequest$invoke$1(GetOperativeEventRequest getOperativeEventRequest, Continuation<? super GetOperativeEventRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = getOperativeEventRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, null, null, null, null, null, this);
    }
}
