package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DefaultWebSocketSession.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0, 2}, l = {252, 256, 266}, m = "outgoingProcessorLoop", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes8.dex */
final class DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultWebSocketSessionImpl$outgoingProcessorLoop$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation<? super DefaultWebSocketSessionImpl$outgoingProcessorLoop$1> continuation) {
        super(continuation);
        this.this$0 = defaultWebSocketSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object outgoingProcessorLoop;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        outgoingProcessorLoop = this.this$0.outgoingProcessorLoop(this);
        return outgoingProcessorLoop;
    }
}
