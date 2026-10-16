package io.ktor.websocket;

import com.vungle.ads.internal.protos.Sdk;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: PingPong.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$ponger$1", f = "PingPong.kt", i = {0, 1}, l = {Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 32}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$1", "L$1"})
/* loaded from: classes8.dex */
final class PingPongKt$ponger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Ping> $channel;
    final /* synthetic */ SendChannel<Frame.Pong> $outgoing;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PingPongKt$ponger$1(Channel<Frame.Ping> channel, SendChannel<? super Frame.Pong> sendChannel, Continuation<? super PingPongKt$ponger$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$outgoing = sendChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PingPongKt$ponger$1(this.$channel, this.$outgoing, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PingPongKt$ponger$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065 A[Catch: all -> 0x003a, TryCatch #2 {all -> 0x003a, blocks: (B:7:0x001b, B:10:0x004b, B:16:0x005d, B:18:0x0065, B:21:0x008e, B:29:0x0034, B:33:0x0046), top: B:2:0x0009, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #2 {all -> 0x003a, blocks: (B:7:0x001b, B:10:0x004b, B:16:0x005d, B:18:0x0065, B:21:0x008e, B:29:0x0034, B:33:0x0046), top: B:2:0x0009, outer: #1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x008c -> B:10:0x004b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Channel<Frame.Ping> channel;
        SendChannel<Frame.Pong> sendChannel;
        ChannelIterator it;
        Throwable th;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
            } finally {
            }
        } catch (ClosedSendChannelException unused) {
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            channel = this.$channel;
            sendChannel = this.$outgoing;
            it = channel.iterator();
        } else if (i == 1) {
            it = (ChannelIterator) this.L$2;
            channel = (ReceiveChannel) this.L$1;
            SendChannel<Frame.Pong> sendChannel2 = (SendChannel) this.L$0;
            ResultKt.throwOnFailure(obj);
            SendChannel<Frame.Pong> sendChannel3 = sendChannel2;
            th = null;
            if (!((Boolean) obj).booleanValue()) {
                Frame.Ping ping = (Frame.Ping) it.next();
                DefaultWebSocketSessionKt.getLOGGER().trace("Received ping message, sending pong message");
                Frame.Pong pong = new Frame.Pong(ping.getData(), (DisposableHandle) null, 2, (DefaultConstructorMarker) null);
                this.L$0 = sendChannel3;
                this.L$1 = channel;
                this.L$2 = it;
                this.label = 2;
                if (sendChannel3.send(pong, this) != coroutine_suspended) {
                    sendChannel = sendChannel3;
                    this.L$0 = sendChannel;
                    this.L$1 = channel;
                    this.L$2 = it;
                    this.label = 1;
                    hasNext = it.hasNext(this);
                    if (hasNext == coroutine_suspended) {
                        sendChannel3 = sendChannel;
                        obj = hasNext;
                        if (!((Boolean) obj).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(channel, th);
                            return Unit.INSTANCE;
                        }
                    }
                }
                return coroutine_suspended;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (ChannelIterator) this.L$2;
            channel = (ReceiveChannel) this.L$1;
            SendChannel<Frame.Pong> sendChannel4 = (SendChannel) this.L$0;
            ResultKt.throwOnFailure(obj);
            sendChannel = sendChannel4;
        }
        th = null;
        this.L$0 = sendChannel;
        this.L$1 = channel;
        this.L$2 = it;
        this.label = 1;
        hasNext = it.hasNext(this);
        if (hasNext == coroutine_suspended) {
        }
    }
}
