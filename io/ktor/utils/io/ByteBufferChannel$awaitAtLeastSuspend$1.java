package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteBufferChannel.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0}, l = {1871}, m = "awaitAtLeastSuspend", n = {"this"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class ByteBufferChannel$awaitAtLeastSuspend$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$awaitAtLeastSuspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$awaitAtLeastSuspend$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object awaitAtLeastSuspend;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitAtLeastSuspend = this.this$0.awaitAtLeastSuspend(0, this);
        return awaitAtLeastSuspend;
    }
}
