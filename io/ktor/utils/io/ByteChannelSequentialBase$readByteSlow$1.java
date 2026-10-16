package io.ktor.utils.io;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteChannelSequential.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {Sdk.SDKError.Reason.EVALUATE_JAVASCRIPT_FAILED_VALUE}, m = "readByteSlow", n = {"this"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class ByteChannelSequentialBase$readByteSlow$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteChannelSequentialBase$readByteSlow$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$readByteSlow$1> continuation) {
        super(continuation);
        this.this$0 = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readByteSlow;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readByteSlow = this.this$0.readByteSlow(this);
        return readByteSlow;
    }
}
