package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WriterSession.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0}, l = {83}, m = "completeWritingFallback", n = {"buffer"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class WriterSessionKt$completeWritingFallback$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    WriterSessionKt$completeWritingFallback$1(Continuation<? super WriterSessionKt$completeWritingFallback$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object completeWritingFallback;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        completeWritingFallback = WriterSessionKt.completeWritingFallback(null, null, this);
        return completeWritingFallback;
    }
}
