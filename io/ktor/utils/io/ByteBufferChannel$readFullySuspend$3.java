package io.ktor.utils.io;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteBufferChannel.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0, 0}, l = {IronSourceError.ERROR_BN_RELOAD_SKIP_BANNER_LAYOUT_IS_NULL}, m = "readFullySuspend", n = {"this", "dst", "currentOffset", "currentLength", "consumed"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2"})
/* loaded from: classes8.dex */
final class ByteBufferChannel$readFullySuspend$3 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$readFullySuspend$3(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$readFullySuspend$3> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readFullySuspend;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readFullySuspend = this.this$0.readFullySuspend(null, 0, 0, this);
        return readFullySuspend;
    }
}
