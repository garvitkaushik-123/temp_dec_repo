package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteWriteChannel.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelKt", f = "ByteWriteChannel.kt", i = {0}, l = {202, 202}, m = "writePacketSuspend", n = {"builder$iv"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class ByteWriteChannelKt$writePacketSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    ByteWriteChannelKt$writePacketSuspend$1(Continuation<? super ByteWriteChannelKt$writePacketSuspend$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteWriteChannelKt.writePacketSuspend(null, null, this);
    }
}
