package io.ktor.websocket;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import io.ktor.util.cio.ChannelWriteException;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.websocket.Frame;
import io.ktor.websocket.RawWebSocketCommon;
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
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: RawWebSocketCommon.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$writerJob$1", f = "RawWebSocketCommon.kt", i = {1}, l = {58, 60}, m = "invokeSuspend", n = {PglCryptUtils.KEY_MESSAGE}, s = {"L$0"})
/* loaded from: classes8.dex */
final class RawWebSocketCommon$writerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RawWebSocketCommon$writerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$writerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RawWebSocketCommon$writerJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RawWebSocketCommon$writerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[Catch: all -> 0x0023, ChannelWriteException -> 0x0026, TryCatch #1 {ChannelWriteException -> 0x0026, blocks: (B:7:0x0013, B:8:0x0062, B:10:0x002c, B:15:0x0040, B:17:0x0044, B:20:0x007b, B:22:0x007f, B:23:0x0085, B:24:0x009d, B:25:0x006f, B:41:0x001f), top: B:2:0x000b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[Catch: all -> 0x0023, ChannelWriteException -> 0x0026, TryCatch #1 {ChannelWriteException -> 0x0026, blocks: (B:7:0x0013, B:8:0x0062, B:10:0x002c, B:15:0x0040, B:17:0x0044, B:20:0x007b, B:22:0x007f, B:23:0x0085, B:24:0x009d, B:25:0x006f, B:41:0x001f), top: B:2:0x000b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006f A[Catch: all -> 0x0023, ChannelWriteException -> 0x0026, TryCatch #1 {ChannelWriteException -> 0x0026, blocks: (B:7:0x0013, B:8:0x0062, B:10:0x002c, B:15:0x0040, B:17:0x0044, B:20:0x007b, B:22:0x007f, B:23:0x0085, B:24:0x009d, B:25:0x006f, B:41:0x001f), top: B:2:0x000b, outer: #0 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0061 -> B:8:0x0062). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007f -> B:10:0x002c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        Channel channel2;
        Channel channel3;
        ByteWriteChannel byteWriteChannel;
        Channel channel4;
        ByteWriteChannel byteWriteChannel2;
        Channel channel5;
        ByteWriteChannel byteWriteChannel3;
        Channel channel6;
        ByteWriteChannel byteWriteChannel4;
        Channel channel7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                try {
                } catch (ChannelWriteException e) {
                    channel2 = this.this$0._outgoing;
                    channel2.close(ExceptionsKt.CancellationException("Failed to write to WebSocket.", e));
                }
            } catch (Throwable th) {
                channel = this.this$0._outgoing;
                channel.close(th);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                channel6 = this.this$0._outgoing;
                this.L$0 = null;
                this.label = 1;
                obj = channel6.receive(this);
                if (obj == coroutine_suspended) {
                }
                if (obj instanceof Frame) {
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                if (obj instanceof Frame) {
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj2 = this.L$0;
                ResultKt.throwOnFailure(obj);
                byteWriteChannel4 = this.this$0.output;
                byteWriteChannel4.flush();
                if (obj2 instanceof Frame.Close) {
                    channel7 = this.this$0._outgoing;
                    SendChannel.DefaultImpls.close$default(channel7, null, 1, null);
                    channel4 = this.this$0._outgoing;
                    channel4.close(ExceptionsKt.CancellationException("WebSocket closed.", null));
                    byteWriteChannel2 = this.this$0.output;
                    ByteWriteChannelKt.close(byteWriteChannel2);
                    while (true) {
                        channel5 = this.this$0._outgoing;
                        Object m11766getOrNullimpl = ChannelResult.m11766getOrNullimpl(channel5.mo11754tryReceivePtdJZtk());
                        if (m11766getOrNullimpl != null) {
                            if (m11766getOrNullimpl instanceof RawWebSocketCommon.FlushRequest) {
                                ((RawWebSocketCommon.FlushRequest) m11766getOrNullimpl).complete();
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    }
                }
                channel6 = this.this$0._outgoing;
                this.L$0 = null;
                this.label = 1;
                obj = channel6.receive(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (obj instanceof Frame) {
                    if (obj instanceof RawWebSocketCommon.FlushRequest) {
                        ((RawWebSocketCommon.FlushRequest) obj).complete();
                        channel6 = this.this$0._outgoing;
                        this.L$0 = null;
                        this.label = 1;
                        obj = channel6.receive(this);
                        if (obj == coroutine_suspended) {
                        }
                        if (obj instanceof Frame) {
                            byteWriteChannel3 = this.this$0.output;
                            this.L$0 = obj;
                            this.label = 2;
                            if (RawWebSocketCommonKt.writeFrame(byteWriteChannel3, (Frame) obj, this.this$0.getMasking(), this) != coroutine_suspended) {
                                obj2 = obj;
                                byteWriteChannel4 = this.this$0.output;
                                byteWriteChannel4.flush();
                                if (obj2 instanceof Frame.Close) {
                                }
                                channel6 = this.this$0._outgoing;
                                this.L$0 = null;
                                this.label = 1;
                                obj = channel6.receive(this);
                                if (obj == coroutine_suspended) {
                                }
                                if (obj instanceof Frame) {
                                }
                            }
                            return coroutine_suspended;
                        }
                    } else {
                        throw new IllegalArgumentException("unknown message " + obj);
                    }
                }
            }
        } catch (Throwable th2) {
            channel3 = this.this$0._outgoing;
            channel3.close(ExceptionsKt.CancellationException("WebSocket closed.", null));
            byteWriteChannel = this.this$0.output;
            ByteWriteChannelKt.close(byteWriteChannel);
            throw th2;
        }
    }
}
