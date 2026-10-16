package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidTriggerInitializationCompletedRequest.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidTriggerInitializationCompletedRequest", f = "AndroidTriggerInitializationCompletedRequest.kt", i = {0, 0, 1, 1}, l = {32, 34}, m = "invoke", n = {"this", "startTime", "this", "startTime"}, s = {"L$0", "J$0", "L$0", "J$0"})
/* loaded from: classes7.dex */
final class AndroidTriggerInitializationCompletedRequest$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidTriggerInitializationCompletedRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidTriggerInitializationCompletedRequest$invoke$1(AndroidTriggerInitializationCompletedRequest androidTriggerInitializationCompletedRequest, Continuation<? super AndroidTriggerInitializationCompletedRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidTriggerInitializationCompletedRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
