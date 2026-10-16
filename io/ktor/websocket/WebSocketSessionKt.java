package io.ktor.websocket;

import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebSocketSession.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a/\u0010\n\u001a\u0002H\u000b\"\f\b\u0000\u0010\u000b*\u0006\u0012\u0002\b\u00030\f*\u00020\u00022\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u000b0\r¢\u0006\u0002\u0010\u000e\u001a1\u0010\u000f\u001a\u0004\u0018\u0001H\u000b\"\f\b\u0000\u0010\u000b*\u0006\u0012\u0002\b\u00030\f*\u00020\u00022\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u000b0\r¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u001d\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"close", "", "Lio/ktor/websocket/WebSocketSession;", "reason", "Lio/ktor/websocket/CloseReason;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/websocket/CloseReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cause", "", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeExceptionally", "extension", "T", "Lio/ktor/websocket/WebSocketExtension;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/websocket/WebSocketExtensionFactory;)Lio/ktor/websocket/WebSocketExtension;", "extensionOrNull", "send", "content", "", "(Lio/ktor/websocket/WebSocketSession;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websockets"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WebSocketSessionKt {
    public static final <T extends WebSocketExtension<?>> T extension(WebSocketSession webSocketSession, WebSocketExtensionFactory<?, T> extension) {
        Intrinsics.checkNotNullParameter(webSocketSession, "<this>");
        Intrinsics.checkNotNullParameter(extension, "extension");
        T t = (T) extensionOrNull(webSocketSession, extension);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(("Extension " + extension + " not found.").toString());
    }

    public static final <T extends WebSocketExtension<?>> T extensionOrNull(WebSocketSession webSocketSession, WebSocketExtensionFactory<?, T> extension) {
        Object obj;
        Intrinsics.checkNotNullParameter(webSocketSession, "<this>");
        Intrinsics.checkNotNullParameter(extension, "extension");
        Iterator<T> it = webSocketSession.getExtensions().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((WebSocketExtension) obj).getFactory().getKey() == extension.getKey()) {
                break;
            }
        }
        if (obj instanceof WebSocketExtension) {
            return (T) obj;
        }
        return null;
    }

    public static final Object send(WebSocketSession webSocketSession, String str, Continuation<? super Unit> continuation) {
        Object send = webSocketSession.send(new Frame.Text(str), continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }

    public static final Object send(WebSocketSession webSocketSession, byte[] bArr, Continuation<? super Unit> continuation) {
        Object send = webSocketSession.send(new Frame.Binary(true, bArr), continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|(2:3|(5:5|6|7|(1:(1:(3:11|12|13)(2:15|16))(2:17|18))(3:22|23|(2:25|21))|19))|27|6|7|(0)(0)|19) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        if (r5.flush(r0) != r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object close(WebSocketSession webSocketSession, CloseReason closeReason, Continuation<? super Unit> continuation) {
        WebSocketSessionKt$close$1 webSocketSessionKt$close$1;
        int i;
        if (continuation instanceof WebSocketSessionKt$close$1) {
            webSocketSessionKt$close$1 = (WebSocketSessionKt$close$1) continuation;
            if ((webSocketSessionKt$close$1.label & Integer.MIN_VALUE) != 0) {
                webSocketSessionKt$close$1.label -= Integer.MIN_VALUE;
                Object obj = webSocketSessionKt$close$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = webSocketSessionKt$close$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Frame.Close close = new Frame.Close(closeReason);
                    webSocketSessionKt$close$1.L$0 = webSocketSession;
                    webSocketSessionKt$close$1.label = 1;
                    if (webSocketSession.send(close, webSocketSessionKt$close$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    webSocketSession = (WebSocketSession) webSocketSessionKt$close$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                webSocketSessionKt$close$1.L$0 = null;
                webSocketSessionKt$close$1.label = 2;
            }
        }
        webSocketSessionKt$close$1 = new WebSocketSessionKt$close$1(continuation);
        Object obj2 = webSocketSessionKt$close$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = webSocketSessionKt$close$1.label;
        if (i != 0) {
        }
        webSocketSessionKt$close$1.L$0 = null;
        webSocketSessionKt$close$1.label = 2;
    }

    public static /* synthetic */ Object close$default(WebSocketSession webSocketSession, CloseReason closeReason, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
        }
        return close(webSocketSession, closeReason, (Continuation<? super Unit>) continuation);
    }

    @Deprecated(message = "Close with reason or terminate instead.")
    public static final Object close(WebSocketSession webSocketSession, Throwable th, Continuation<? super Unit> continuation) {
        if (th == null) {
            Object close$default = close$default(webSocketSession, null, continuation, 1, null);
            return close$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? close$default : Unit.INSTANCE;
        }
        Object closeExceptionally = closeExceptionally(webSocketSession, th, continuation);
        return closeExceptionally == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? closeExceptionally : Unit.INSTANCE;
    }

    public static final Object closeExceptionally(WebSocketSession webSocketSession, Throwable th, Continuation<? super Unit> continuation) {
        Object close = close(webSocketSession, th instanceof CancellationException ? new CloseReason(CloseReason.Codes.NORMAL, "") : new CloseReason(CloseReason.Codes.INTERNAL_ERROR, th.toString()), continuation);
        return close == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? close : Unit.INSTANCE;
    }
}
