package io.ktor.utils.io;

import com.ironsource.D5;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteReadChannel.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelKt", f = "ByteReadChannel.kt", i = {0}, l = {232}, m = "discardExact", n = {D5.q}, s = {"J$0"})
/* loaded from: classes8.dex */
final class ByteReadChannelKt$discardExact$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;

    ByteReadChannelKt$discardExact$1(Continuation<? super ByteReadChannelKt$discardExact$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteReadChannelKt.discardExact(null, 0L, this);
    }
}
