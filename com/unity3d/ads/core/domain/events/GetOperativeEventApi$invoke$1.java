package com.unity3d.ads.core.domain.events;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GetOperativeEventApi.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.events.GetOperativeEventApi", f = "GetOperativeEventApi.kt", i = {0}, l = {21}, m = "invoke", n = {"this"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class GetOperativeEventApi$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetOperativeEventApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetOperativeEventApi$invoke$1(GetOperativeEventApi getOperativeEventApi, Continuation<? super GetOperativeEventApi$invoke$1> continuation) {
        super(continuation);
        this.this$0 = getOperativeEventApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, null, null, null, null, null, this);
    }
}
