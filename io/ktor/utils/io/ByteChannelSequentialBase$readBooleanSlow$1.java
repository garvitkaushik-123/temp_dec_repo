package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteChannelSequential.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {570, 572}, m = "readBooleanSlow", n = {"this"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class ByteChannelSequentialBase$readBooleanSlow$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteChannelSequentialBase$readBooleanSlow$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$readBooleanSlow$1> continuation) {
        super(continuation);
        this.this$0 = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readBooleanSlow;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readBooleanSlow = this.this$0.readBooleanSlow(this);
        return readBooleanSlow;
    }
}
