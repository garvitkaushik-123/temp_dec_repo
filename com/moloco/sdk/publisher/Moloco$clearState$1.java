package com.moloco.sdk.publisher;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.moloco.sdk.publisher.Moloco", f = "Moloco.kt", i = {0}, l = {451, 454}, m = "clearState$moloco_sdk_release", n = {"this"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class Moloco$clearState$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Moloco this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Moloco$clearState$1(Moloco moloco, Continuation<? super Moloco$clearState$1> continuation) {
        super(continuation);
        this.this$0 = moloco;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearState$moloco_sdk_release(this);
    }
}
