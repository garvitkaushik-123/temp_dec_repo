package io.ktor.client.engine.okhttp;

import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import io.ktor.websocket.FrameCommonKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.channels.ActorScope;
import kotlinx.coroutines.channels.ChannelIterator;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* compiled from: OkHttpWebsocketSession.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ActorScope;", "Lio/ktor/websocket/Frame;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpWebsocketSession$outgoing$1", f = "OkHttpWebsocketSession.kt", i = {0, 1, 1}, l = {62, 66}, m = "invokeSuspend", n = {"$this$actor", "websocket", "closeReason"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes8.dex */
final class OkHttpWebsocketSession$outgoing$1 extends SuspendLambda implements Function2<ActorScope<Frame>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Request $engineRequest;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ OkHttpWebsocketSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OkHttpWebsocketSession$outgoing$1(OkHttpWebsocketSession okHttpWebsocketSession, Request request, Continuation<? super OkHttpWebsocketSession$outgoing$1> continuation) {
        super(2, continuation);
        this.this$0 = okHttpWebsocketSession;
        this.$engineRequest = request;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OkHttpWebsocketSession$outgoing$1 okHttpWebsocketSession$outgoing$1 = new OkHttpWebsocketSession$outgoing$1(this.this$0, this.$engineRequest, continuation);
        okHttpWebsocketSession$outgoing$1.L$0 = obj;
        return okHttpWebsocketSession$outgoing$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ActorScope<Frame> actorScope, Continuation<? super Unit> continuation) {
        return ((OkHttpWebsocketSession$outgoing$1) create(actorScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0086, code lost:
    
        if (r10 != r0) goto L24;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0086 -> B:8:0x0089). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ActorScope actorScope;
        WebSocket.Factory factory;
        Request request;
        CompletableDeferred completableDeferred;
        WebSocket.Factory factory2;
        WebSocket newWebSocket;
        CloseReason closeReason;
        WebSocket webSocket;
        Throwable th;
        ChannelIterator it;
        boolean isReserved;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                actorScope = (ActorScope) this.L$0;
                factory = this.this$0.webSocketFactory;
                request = this.$engineRequest;
                completableDeferred = this.this$0.self;
                this.L$0 = actorScope;
                this.L$1 = factory;
                this.L$2 = request;
                this.label = 1;
                Object await = completableDeferred.await(this);
                if (await != coroutine_suspended) {
                    factory2 = factory;
                    obj = await;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                request = (Request) this.L$2;
                factory2 = (WebSocket.Factory) this.L$1;
                actorScope = (ActorScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (ChannelIterator) this.L$2;
                closeReason = (CloseReason) this.L$1;
                webSocket = (WebSocket) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        try {
                            webSocket.close(closeReason.getCode(), closeReason.getMessage());
                            return Unit.INSTANCE;
                        } finally {
                        }
                    }
                    Frame frame = (Frame) it.next();
                    if (frame instanceof Frame.Binary) {
                        webSocket.send(ByteString.INSTANCE.of(frame.getData(), 0, frame.getData().length));
                    } else {
                        if (!(frame instanceof Frame.Text)) {
                            if (!(frame instanceof Frame.Close)) {
                                throw new UnsupportedFrameTypeException(frame);
                            }
                            CloseReason readReason = FrameCommonKt.readReason((Frame.Close) frame);
                            Intrinsics.checkNotNull(readReason);
                            isReserved = OkHttpWebsocketSessionKt.isReserved(readReason);
                            if (!isReserved) {
                                closeReason = readReason;
                            }
                            Unit unit = Unit.INSTANCE;
                            try {
                                webSocket.close(closeReason.getCode(), closeReason.getMessage());
                                return unit;
                            } finally {
                            }
                        }
                        webSocket.send(new String(frame.getData(), Charsets.UTF_8));
                    }
                    this.L$0 = webSocket;
                    this.L$1 = closeReason;
                    this.L$2 = it;
                    this.label = 2;
                    obj = it.hasNext(this);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        webSocket.close(closeReason.getCode(), closeReason.getMessage());
                        throw th;
                    } finally {
                    }
                }
            }
            it = actorScope.getChannel().iterator();
            webSocket = newWebSocket;
            this.L$0 = webSocket;
            this.L$1 = closeReason;
            this.L$2 = it;
            this.label = 2;
            obj = it.hasNext(this);
        } catch (Throwable th3) {
            webSocket = newWebSocket;
            th = th3;
            webSocket.close(closeReason.getCode(), closeReason.getMessage());
            throw th;
        }
        newWebSocket = factory2.newWebSocket(request, (WebSocketListener) obj);
        closeReason = OkHttpWebsocketSessionKt.DEFAULT_CLOSE_REASON_ERROR;
    }
}
