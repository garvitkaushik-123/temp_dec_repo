package io.ktor.websocket;

import io.ktor.util.cio.ChannelIOException;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
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
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: RawWebSocketCommon.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$readerJob$1", f = "RawWebSocketCommon.kt", i = {2, 3}, l = {88, 92, 95, 99}, m = "invokeSuspend", n = {"cause", "cause"}, s = {"L$0", "L$0"})
/* loaded from: classes8.dex */
final class RawWebSocketCommon$readerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RawWebSocketCommon$readerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$readerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RawWebSocketCommon$readerJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RawWebSocketCommon$readerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
    
        if (r1.send(r11, r10) != r0) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073 A[Catch: all -> 0x003a, CancellationException -> 0x003c, ProtocolViolationException -> 0x003f, FrameTooBigException -> 0x0042, ChannelIOException -> 0x00a5, EOFException | ClosedReceiveChannelException -> 0x00b0, EOFException | ClosedReceiveChannelException -> 0x00b0, TryCatch #5 {EOFException | ClosedReceiveChannelException -> 0x00b0, blocks: (B:20:0x0032, B:21:0x0048, B:21:0x0048, B:25:0x0067, B:25:0x0067, B:27:0x0073, B:27:0x0073, B:30:0x0085, B:30:0x0085, B:31:0x007d, B:31:0x007d, B:32:0x0088, B:32:0x0088, B:35:0x0036), top: B:2:0x000b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0097 -> B:21:0x0048). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        Channel channel2;
        Channel channel3;
        ProtocolViolationException protocolViolationException;
        FrameTooBigException frameTooBigException;
        Channel channel4;
        Channel channel5;
        Channel channel6;
        Frame frame;
        Channel channel7;
        ByteReadChannel byteReadChannel;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
            try {
                try {
                } catch (FrameTooBigException e) {
                    this.L$0 = e;
                    this.label = 3;
                    if (this.this$0.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.TOO_BIG, e.getMessage())), this) != coroutine_suspended) {
                        frameTooBigException = e;
                    }
                } catch (ProtocolViolationException e2) {
                    this.L$0 = e2;
                    this.label = 4;
                    if (this.this$0.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.PROTOCOL_ERROR, e2.getMessage())), this) != coroutine_suspended) {
                        protocolViolationException = e2;
                    }
                }
            } catch (ChannelIOException unused) {
                channel3 = this.this$0._incoming;
                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) channel3, (CancellationException) null, 1, (Object) null);
            } catch (CancellationException e3) {
                channel2 = this.this$0._incoming;
                channel2.cancel(e3);
            } catch (Throwable th) {
                channel = this.this$0._incoming;
                channel.close(th);
                throw th;
            }
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
            } else if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                frame = (Frame) obj;
                if (!frame.getFrameType().getControlFrame()) {
                    this.this$0.lastOpcode = frame.getFin() ? 0 : frame.getFrameType().getOpcode();
                }
                channel7 = this.this$0._incoming;
                this.label = 2;
            } else {
                if (i2 != 2) {
                    if (i2 == 3) {
                        frameTooBigException = (FrameTooBigException) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        channel5 = this.this$0._incoming;
                        channel5.close(frameTooBigException);
                        return Unit.INSTANCE;
                    }
                    if (i2 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    protocolViolationException = (ProtocolViolationException) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    channel6 = this.this$0._incoming;
                    channel6.close(protocolViolationException);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            byteReadChannel = this.this$0.input;
            long maxFrameSize = this.this$0.getMaxFrameSize();
            i = this.this$0.lastOpcode;
            this.label = 1;
            obj = RawWebSocketCommonKt.readFrame(byteReadChannel, maxFrameSize, i, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            frame = (Frame) obj;
            if (!frame.getFrameType().getControlFrame()) {
            }
            channel7 = this.this$0._incoming;
            this.label = 2;
        } finally {
            channel4 = this.this$0._incoming;
            SendChannel.DefaultImpls.close$default(channel4, null, 1, null);
        }
    }
}
