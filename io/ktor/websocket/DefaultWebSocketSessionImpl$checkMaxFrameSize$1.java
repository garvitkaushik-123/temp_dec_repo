package io.ktor.websocket;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DefaultWebSocketSession.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0}, l = {327}, m = "checkMaxFrameSize", n = {ContentDisposition.Parameters.Size}, s = {"I$0"})
/* loaded from: classes8.dex */
final class DefaultWebSocketSessionImpl$checkMaxFrameSize$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultWebSocketSessionImpl$checkMaxFrameSize$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation<? super DefaultWebSocketSessionImpl$checkMaxFrameSize$1> continuation) {
        super(continuation);
        this.this$0 = defaultWebSocketSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object checkMaxFrameSize;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkMaxFrameSize = this.this$0.checkMaxFrameSize(null, null, this);
        return checkMaxFrameSize;
    }
}
