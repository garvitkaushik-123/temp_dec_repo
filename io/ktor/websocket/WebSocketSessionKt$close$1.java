package io.ktor.websocket;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WebSocketSession.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketSessionKt", f = "WebSocketSession.kt", i = {0}, l = {120, Sdk.SDKError.Reason.TPAT_ERROR_VALUE}, m = "close", n = {"$this$close"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class WebSocketSessionKt$close$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    WebSocketSessionKt$close$1(Continuation<? super WebSocketSessionKt$close$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WebSocketSessionKt.close((WebSocketSession) null, (CloseReason) null, this);
    }
}
