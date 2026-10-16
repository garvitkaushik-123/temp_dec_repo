package io.ktor.utils.io.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AwaitingSlot.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", i = {0}, l = {24}, m = "sleep", n = {"this"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class AwaitingSlot$sleep$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwaitingSlot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AwaitingSlot$sleep$1(AwaitingSlot awaitingSlot, Continuation<? super AwaitingSlot$sleep$1> continuation) {
        super(continuation);
        this.this$0 = awaitingSlot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sleep(null, this);
    }
}
