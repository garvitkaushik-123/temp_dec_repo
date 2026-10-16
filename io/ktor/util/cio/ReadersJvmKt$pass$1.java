package io.ktor.util.cio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ReadersJvm.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.util.cio.ReadersJvmKt", f = "ReadersJvm.kt", i = {0, 0, 0}, l = {18}, m = "pass", n = {"$this$pass", "buffer", "block"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes8.dex */
final class ReadersJvmKt$pass$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ReadersJvmKt$pass$1(Continuation<? super ReadersJvmKt$pass$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReadersJvmKt.pass(null, null, null, this);
    }
}
