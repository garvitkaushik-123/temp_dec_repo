package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Delimited.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.DelimitedKt", f = "Delimited.kt", i = {0, 0, 0}, l = {81, 113}, m = "readUntilDelimiterSuspend", n = {"$this$readUntilDelimiterSuspend", "dst", "endFound"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes8.dex */
final class DelimitedKt$readUntilDelimiterSuspend$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    DelimitedKt$readUntilDelimiterSuspend$1(Continuation<? super DelimitedKt$readUntilDelimiterSuspend$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readUntilDelimiterSuspend;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readUntilDelimiterSuspend = DelimitedKt.readUntilDelimiterSuspend(null, null, null, 0, this);
        return readUntilDelimiterSuspend;
    }
}
