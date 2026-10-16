package io.ktor.websocket;

import io.ktor.util.cio.ChannelIOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: DefaultWebSocketSession.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1", f = "DefaultWebSocketSession.kt", i = {}, l = {236, 247, 247, 247, 240, 247, 247, 244, 247, 247}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class DefaultWebSocketSessionImpl$runOutgoingProcessor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultWebSocketSessionImpl$runOutgoingProcessor$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation<? super DefaultWebSocketSessionImpl$runOutgoingProcessor$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultWebSocketSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultWebSocketSessionImpl$runOutgoingProcessor$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultWebSocketSessionImpl$runOutgoingProcessor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x00a6, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close$default(r11, null, r10, 1, null) == r1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0160, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0100, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close$default(r11, null, r10, 1, null) == r1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close$default(r11, null, r10, 1, null) == r1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        if (r11 == r1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x015e, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close$default(r11, null, r10, 1, null) != r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.closeExceptionally(r0, r0, r10) != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close$default(r11, null, r10, 1, null) != r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e1, code lost:
    
        if (io.ktor.websocket.DefaultWebSocketSessionImpl.sendCloseSequence$default(r10.this$0, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.NORMAL, ""), null, r10, 2, null) != r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0140, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close$default(r11, null, r10, 1, null) != r1) goto L49;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        WebSocketSession webSocketSession;
        Channel channel2;
        WebSocketSession webSocketSession2;
        Channel channel3;
        WebSocketSession webSocketSession3;
        Channel channel4;
        WebSocketSession webSocketSession4;
        Channel channel5;
        WebSocketSession webSocketSession5;
        Channel channel6;
        WebSocketSession webSocketSession6;
        Channel channel7;
        WebSocketSession webSocketSession7;
        Object outgoingProcessorLoop;
        Channel channel8;
        WebSocketSession webSocketSession8;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                try {
                } catch (ClosedSendChannelException unused) {
                    channel4 = this.this$0.outgoingToBeProcessed;
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) channel4, (CancellationException) null, 1, (Object) null);
                    webSocketSession4 = this.this$0.raw;
                    this.label = 3;
                } catch (Throwable th) {
                    channel3 = this.this$0.outgoingToBeProcessed;
                    channel3.cancel(ExceptionsKt.CancellationException("Failed to send frame", th));
                    webSocketSession3 = this.this$0.raw;
                    this.label = 8;
                }
            } catch (ChannelIOException unused2) {
                channel2 = this.this$0.outgoingToBeProcessed;
                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) channel2, (CancellationException) null, 1, (Object) null);
                webSocketSession2 = this.this$0.raw;
                this.label = 7;
            } catch (CancellationException unused3) {
                this.label = 5;
            } catch (ClosedReceiveChannelException unused4) {
                channel = this.this$0.outgoingToBeProcessed;
                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) channel, (CancellationException) null, 1, (Object) null);
                webSocketSession = this.this$0.raw;
                this.label = 4;
            }
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    outgoingProcessorLoop = this.this$0.outgoingProcessorLoop(this);
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    channel8 = this.this$0.outgoingToBeProcessed;
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) channel8, (CancellationException) null, 1, (Object) null);
                    webSocketSession8 = this.this$0.raw;
                    this.label = 2;
                    break;
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                case 9:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                case 5:
                    ResultKt.throwOnFailure(obj);
                    channel6 = this.this$0.outgoingToBeProcessed;
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) channel6, (CancellationException) null, 1, (Object) null);
                    webSocketSession6 = this.this$0.raw;
                    this.label = 6;
                    break;
                case 8:
                    ResultKt.throwOnFailure(obj);
                    channel7 = this.this$0.outgoingToBeProcessed;
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) channel7, (CancellationException) null, 1, (Object) null);
                    webSocketSession7 = this.this$0.raw;
                    this.label = 9;
                    break;
                case 10:
                    Throwable th2 = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th2;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th3) {
            channel5 = this.this$0.outgoingToBeProcessed;
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) channel5, (CancellationException) null, 1, (Object) null);
            webSocketSession5 = this.this$0.raw;
            this.L$0 = th3;
            this.label = 10;
            if (WebSocketSessionKt.close$default(webSocketSession5, null, this, 1, null) != coroutine_suspended) {
                throw th3;
            }
        }
    }
}
