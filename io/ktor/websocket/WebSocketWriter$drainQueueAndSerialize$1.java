package io.ktor.websocket;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WebSocketWriter.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0, 0, 0}, l = {Sdk.SDKError.Reason.TPAT_ERROR_VALUE}, m = "drainQueueAndSerialize", n = {"this", "buffer", "flush", "closeSent"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes8.dex */
final class WebSocketWriter$drainQueueAndSerialize$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebSocketWriter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebSocketWriter$drainQueueAndSerialize$1(WebSocketWriter webSocketWriter, Continuation<? super WebSocketWriter$drainQueueAndSerialize$1> continuation) {
        super(continuation);
        this.this$0 = webSocketWriter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object drainQueueAndSerialize;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        drainQueueAndSerialize = this.this$0.drainQueueAndSerialize(null, null, this);
        return drainQueueAndSerialize;
    }
}
