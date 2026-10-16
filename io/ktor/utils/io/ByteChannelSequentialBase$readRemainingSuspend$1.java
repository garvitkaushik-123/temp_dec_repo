package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteChannelSequential.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {425}, m = "readRemainingSuspend", n = {"this", "builder", "limit"}, s = {"L$0", "L$1", "J$0"})
/* loaded from: classes8.dex */
final class ByteChannelSequentialBase$readRemainingSuspend$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteChannelSequentialBase$readRemainingSuspend$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$readRemainingSuspend$1> continuation) {
        super(continuation);
        this.this$0 = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readRemainingSuspend;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readRemainingSuspend = this.this$0.readRemainingSuspend(null, 0L, this);
        return readRemainingSuspend;
    }
}
