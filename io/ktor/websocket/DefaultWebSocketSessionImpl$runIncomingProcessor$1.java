package io.ktor.websocket;

import com.explorestack.protobuf.openrtb.LossReason;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: DefaultWebSocketSession.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1", f = "DefaultWebSocketSession.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7}, l = {352, 172, Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, 178, 179, 181, 196, LossReason.LOSS_REASON_CREATIVE_FILTERED_ANIMATION_TOO_LONG_VALUE, Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE}, m = "invokeSuspend", n = {"$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "frame", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "firstFrame", "frameBody", "closeFramePresented", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6", "L$8", "L$0", "L$1", "L$2", "L$3", "L$6", "L$0", "L$1", "L$2", "L$3", "L$6"})
/* loaded from: classes8.dex */
final class DefaultWebSocketSessionImpl$runIncomingProcessor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendChannel<Frame.Ping> $ponger;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ DefaultWebSocketSessionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DefaultWebSocketSessionImpl$runIncomingProcessor$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, SendChannel<? super Frame.Ping> sendChannel, Continuation<? super DefaultWebSocketSessionImpl$runIncomingProcessor$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultWebSocketSessionImpl;
        this.$ponger = sendChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultWebSocketSessionImpl$runIncomingProcessor$1 defaultWebSocketSessionImpl$runIncomingProcessor$1 = new DefaultWebSocketSessionImpl$runIncomingProcessor$1(this.this$0, this.$ponger, continuation);
        defaultWebSocketSessionImpl$runIncomingProcessor$1.L$0 = obj;
        return defaultWebSocketSessionImpl$runIncomingProcessor$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultWebSocketSessionImpl$runIncomingProcessor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x0510, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close(r30.this$0, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), r30) == r2) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0475, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close(r30.this$0, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), r30) == r2) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0335, code lost:
    
        r4 = r11.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r4);
        io.ktor.utils.io.core.OutputKt.writeFully$default((io.ktor.utils.io.core.Output) r4, r0.getData(), 0, 0, 6, (java.lang.Object) null);
        r0 = r12;
        r12 = r6;
        r6 = r0;
        r0 = r11;
        r11 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r0;
        r0 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x03bc, code lost:
    
        if (r4.send(r0, r30) == r2) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x032e, code lost:
    
        r0 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0410, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.close(r30.this$0, new io.ktor.websocket.CloseReason(io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), r30) == r2) goto L145;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0187 A[Catch: all -> 0x012b, TryCatch #5 {all -> 0x012b, blocks: (B:13:0x0045, B:20:0x017f, B:22:0x0187, B:24:0x01b5, B:26:0x01bf, B:28:0x01cd, B:29:0x01d1, B:32:0x01f0, B:42:0x0242, B:44:0x0246, B:46:0x024c, B:49:0x0267, B:51:0x026a, B:53:0x026e, B:56:0x0296, B:87:0x03c4, B:105:0x00bb, B:108:0x00e1, B:113:0x00fe, B:116:0x0124), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02c7 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:59:0x02c1, B:61:0x02c7, B:63:0x02cb, B:64:0x02cd, B:66:0x02d1, B:67:0x02da, B:69:0x02fc, B:71:0x0300, B:75:0x0338, B:103:0x008f), top: B:102:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02fc A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:59:0x02c1, B:61:0x02c7, B:63:0x02cb, B:64:0x02cd, B:66:0x02d1, B:67:0x02da, B:69:0x02fc, B:71:0x0300, B:75:0x0338, B:103:0x008f), top: B:102:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03c4 A[Catch: all -> 0x012b, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x012b, blocks: (B:13:0x0045, B:20:0x017f, B:22:0x0187, B:24:0x01b5, B:26:0x01bf, B:28:0x01cd, B:29:0x01d1, B:32:0x01f0, B:42:0x0242, B:44:0x0246, B:46:0x024c, B:49:0x0267, B:51:0x026a, B:53:0x026e, B:56:0x0296, B:87:0x03c4, B:105:0x00bb, B:108:0x00e1, B:113:0x00fe, B:116:0x0124), top: B:2:0x000c }] */
    /* JADX WARN: Type inference failed for: r0v106 */
    /* JADX WARN: Type inference failed for: r0v46, types: [T, io.ktor.websocket.Frame] */
    /* JADX WARN: Type inference failed for: r0v88 */
    /* JADX WARN: Type inference failed for: r4v29, types: [T, io.ktor.utils.io.core.BytePacketBuilder] */
    /* JADX WARN: Type inference failed for: r7v22, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0289 -> B:16:0x03c0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        ReceiveChannel<Frame> receiveChannel;
        CoroutineScope coroutineScope;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.BooleanRef booleanRef;
        Channel channel;
        Channel channel2;
        Channel channel3;
        Channel channel4;
        WebSocketSession webSocketSession;
        ReceiveChannel<Frame> incoming;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
        SendChannel<Frame.Ping> sendChannel;
        ChannelIterator<Frame> it;
        Throwable th2;
        ChannelIterator<Frame> channelIterator;
        ReceiveChannel<Frame> receiveChannel2;
        Ref.ObjectRef objectRef3;
        CoroutineScope coroutineScope2;
        Object obj2;
        ChannelIterator<Frame> channelIterator2;
        SendChannel<Frame.Ping> sendChannel2;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl2;
        Ref.BooleanRef booleanRef2;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        CoroutineScope coroutineScope3;
        ChannelIterator<Frame> channelIterator3;
        ReceiveChannel<Frame> receiveChannel3;
        SendChannel<Frame.Ping> sendChannel3;
        Ref.ObjectRef objectRef6;
        CoroutineScope coroutineScope4;
        ?? r0;
        Channel channel5;
        Frame processIncomingExtensions;
        Channel channel6;
        Frame processIncomingExtensions2;
        SendChannel<Frame.Ping> sendChannel4;
        SendChannel<Frame.Ping> sendChannel5;
        BytePacketBuilder bytePacketBuilder;
        Channel channel7;
        ?? r7;
        Channel channel8;
        Object checkMaxFrameSize;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = 1;
        Throwable th3 = null;
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.L$0;
                    objectRef = new Ref.ObjectRef();
                    objectRef2 = new Ref.ObjectRef();
                    booleanRef = new Ref.BooleanRef();
                    try {
                        webSocketSession = this.this$0.raw;
                        incoming = webSocketSession.getIncoming();
                        defaultWebSocketSessionImpl = this.this$0;
                        sendChannel = this.$ponger;
                        try {
                            it = incoming.iterator();
                            th2 = null;
                            this.L$0 = coroutineScope;
                            this.L$1 = objectRef;
                            this.L$2 = objectRef2;
                            this.L$3 = booleanRef;
                            this.L$4 = defaultWebSocketSessionImpl;
                            this.L$5 = sendChannel;
                            this.L$6 = incoming;
                            this.L$7 = it;
                            this.L$8 = th3;
                            this.label = i;
                            obj2 = it.hasNext(this);
                        } catch (Throwable th4) {
                            th = th4;
                            receiveChannel = incoming;
                            try {
                                throw th;
                            } catch (Throwable th5) {
                                ChannelsKt.cancelConsumed(receiveChannel, th);
                                throw th5;
                            }
                        }
                    } catch (ClosedSendChannelException unused) {
                        SendChannel.DefaultImpls.close$default(this.$ponger, null, 1, null);
                        BytePacketBuilder bytePacketBuilder2 = (BytePacketBuilder) objectRef2.element;
                        if (bytePacketBuilder2 != null) {
                            bytePacketBuilder2.release();
                            Unit unit = Unit.INSTANCE;
                        }
                        channel4 = this.this$0.filtered;
                        SendChannel.DefaultImpls.close$default(channel4, null, 1, null);
                        if (!booleanRef.element) {
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.L$7 = null;
                            this.L$8 = null;
                            this.label = 10;
                            break;
                        }
                    } catch (Throwable th6) {
                        try {
                            SendChannel.DefaultImpls.close$default(this.$ponger, null, 1, null);
                            channel2 = this.this$0.filtered;
                            channel2.close(th6);
                            SendChannel.DefaultImpls.close$default(this.$ponger, null, 1, null);
                            BytePacketBuilder bytePacketBuilder3 = (BytePacketBuilder) objectRef2.element;
                            if (bytePacketBuilder3 != null) {
                                bytePacketBuilder3.release();
                                Unit unit2 = Unit.INSTANCE;
                            }
                            channel3 = this.this$0.filtered;
                            SendChannel.DefaultImpls.close$default(channel3, null, 1, null);
                            if (!booleanRef.element) {
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.L$7 = null;
                                this.L$8 = null;
                                this.label = 11;
                                break;
                            }
                        } catch (Throwable th7) {
                            SendChannel.DefaultImpls.close$default(this.$ponger, null, 1, null);
                            BytePacketBuilder bytePacketBuilder4 = (BytePacketBuilder) objectRef2.element;
                            if (bytePacketBuilder4 != null) {
                                bytePacketBuilder4.release();
                                Unit unit3 = Unit.INSTANCE;
                            }
                            channel = this.this$0.filtered;
                            SendChannel.DefaultImpls.close$default(channel, null, 1, null);
                            if (booleanRef.element) {
                                throw th7;
                            }
                            this.L$0 = th7;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.L$7 = null;
                            this.L$8 = null;
                            this.label = 12;
                            if (WebSocketSessionKt.close(this.this$0, new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), this) != coroutine_suspended) {
                                throw th7;
                            }
                        }
                    }
                    if (obj2 != coroutine_suspended) {
                        ChannelIterator<Frame> channelIterator4 = it;
                        coroutineScope2 = coroutineScope;
                        channelIterator = channelIterator4;
                        SendChannel<Frame.Ping> sendChannel6 = sendChannel;
                        objectRef3 = objectRef;
                        receiveChannel2 = incoming;
                        r7 = sendChannel6;
                        if (((Boolean) obj2).booleanValue()) {
                            Unit unit4 = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            SendChannel.DefaultImpls.close$default(this.$ponger, null, 1, null);
                            BytePacketBuilder bytePacketBuilder5 = (BytePacketBuilder) objectRef2.element;
                            if (bytePacketBuilder5 != null) {
                                bytePacketBuilder5.release();
                                Unit unit5 = Unit.INSTANCE;
                            }
                            channel8 = this.this$0.filtered;
                            SendChannel.DefaultImpls.close$default(channel8, null, 1, null);
                            if (!booleanRef.element) {
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.L$7 = null;
                                this.label = 9;
                                break;
                            }
                            return Unit.INSTANCE;
                        }
                        Frame next = channelIterator.next();
                        DefaultWebSocketSessionKt.getLOGGER().trace("WebSocketSession(" + coroutineScope2 + ") receiving frame " + next);
                        if (next instanceof Frame.Close) {
                            if (!defaultWebSocketSessionImpl.getOutgoing().isClosedForSend()) {
                                SendChannel<Frame> outgoing = defaultWebSocketSessionImpl.getOutgoing();
                                CloseReason readReason = FrameCommonKt.readReason((Frame.Close) next);
                                if (readReason == null) {
                                    readReason = DefaultWebSocketSessionKt.NORMAL_CLOSE;
                                }
                                Frame.Close close = new Frame.Close(readReason);
                                this.L$0 = objectRef2;
                                this.L$1 = booleanRef;
                                this.L$2 = receiveChannel2;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.L$7 = null;
                                this.label = 2;
                                if (outgoing.send(close, this) == coroutine_suspended) {
                                }
                            }
                            booleanRef.element = true;
                            Unit unit6 = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            SendChannel.DefaultImpls.close$default(this.$ponger, null, 1, null);
                            bytePacketBuilder = (BytePacketBuilder) objectRef2.element;
                            if (bytePacketBuilder != null) {
                                bytePacketBuilder.release();
                                Unit unit7 = Unit.INSTANCE;
                            }
                            channel7 = this.this$0.filtered;
                            SendChannel.DefaultImpls.close$default(channel7, null, 1, null);
                            if (!booleanRef.element) {
                                this.L$0 = unit6;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.L$7 = null;
                                this.label = 3;
                                if (WebSocketSessionKt.close(this.this$0, new CloseReason(CloseReason.Codes.CLOSED_ABNORMALLY, "Connection was closed without close frame"), this) == coroutine_suspended) {
                                }
                            }
                            return unit6;
                        }
                        if (next instanceof Frame.Pong) {
                            SendChannel sendChannel7 = (SendChannel) defaultWebSocketSessionImpl.pinger;
                            sendChannel4 = r7;
                            if (sendChannel7 != null) {
                                this.L$0 = coroutineScope2;
                                this.L$1 = objectRef3;
                                this.L$2 = objectRef2;
                                this.L$3 = booleanRef;
                                this.L$4 = defaultWebSocketSessionImpl;
                                this.L$5 = r7;
                                this.L$6 = receiveChannel2;
                                this.L$7 = channelIterator;
                                this.label = 4;
                                sendChannel5 = r7;
                                if (sendChannel7.send(next, this) == coroutine_suspended) {
                                }
                                Unit unit8 = Unit.INSTANCE;
                                sendChannel4 = sendChannel5;
                            }
                        } else if (next instanceof Frame.Ping) {
                            this.L$0 = coroutineScope2;
                            this.L$1 = objectRef3;
                            this.L$2 = objectRef2;
                            this.L$3 = booleanRef;
                            this.L$4 = defaultWebSocketSessionImpl;
                            this.L$5 = r7;
                            this.L$6 = receiveChannel2;
                            this.L$7 = channelIterator;
                            this.label = 5;
                            Object send = r7.send(next, this);
                            sendChannel4 = r7;
                            if (send == coroutine_suspended) {
                            }
                        } else {
                            BytePacketBuilder bytePacketBuilder6 = (BytePacketBuilder) objectRef2.element;
                            this.L$0 = coroutineScope2;
                            this.L$1 = objectRef3;
                            this.L$2 = objectRef2;
                            this.L$3 = booleanRef;
                            this.L$4 = defaultWebSocketSessionImpl;
                            this.L$5 = r7;
                            this.L$6 = receiveChannel2;
                            this.L$7 = channelIterator;
                            this.L$8 = next;
                            this.label = 6;
                            checkMaxFrameSize = defaultWebSocketSessionImpl.checkMaxFrameSize(bytePacketBuilder6, next, this);
                            if (checkMaxFrameSize != coroutine_suspended) {
                                th3 = th2;
                                coroutineScope3 = coroutineScope2;
                                objectRef5 = objectRef3;
                                objectRef4 = objectRef2;
                                booleanRef2 = booleanRef;
                                defaultWebSocketSessionImpl2 = defaultWebSocketSessionImpl;
                                sendChannel2 = r7;
                                incoming = receiveChannel2;
                                channelIterator2 = channelIterator;
                                r0 = next;
                                if (r0.getFin()) {
                                    if (objectRef5.element != null) {
                                        Object obj3 = objectRef4.element;
                                        Intrinsics.checkNotNull(obj3);
                                        OutputKt.writeFully$default((Output) obj3, r0.getData(), 0, 0, 6, (Object) null);
                                        Frame.Companion companion = Frame.INSTANCE;
                                        Object obj4 = objectRef5.element;
                                        Intrinsics.checkNotNull(obj4);
                                        FrameType frameType = ((Frame) obj4).getFrameType();
                                        Object obj5 = objectRef4.element;
                                        Intrinsics.checkNotNull(obj5);
                                        byte[] readBytes$default = StringsKt.readBytes$default(((BytePacketBuilder) obj5).build(), 0, 1, null);
                                        Object obj6 = objectRef5.element;
                                        Intrinsics.checkNotNull(obj6);
                                        boolean rsv1 = ((Frame) obj6).getRsv1();
                                        Object obj7 = objectRef5.element;
                                        Intrinsics.checkNotNull(obj7);
                                        boolean rsv2 = ((Frame) obj7).getRsv2();
                                        Object obj8 = objectRef5.element;
                                        Intrinsics.checkNotNull(obj8);
                                        Frame byType = companion.byType(true, frameType, readBytes$default, rsv1, rsv2, ((Frame) obj8).getRsv3());
                                        objectRef5.element = null;
                                        channel5 = defaultWebSocketSessionImpl2.filtered;
                                        processIncomingExtensions = defaultWebSocketSessionImpl2.processIncomingExtensions(byType);
                                        this.L$0 = coroutineScope3;
                                        this.L$1 = objectRef5;
                                        this.L$2 = objectRef4;
                                        this.L$3 = booleanRef2;
                                        this.L$4 = defaultWebSocketSessionImpl2;
                                        this.L$5 = sendChannel2;
                                        this.L$6 = incoming;
                                        this.L$7 = channelIterator2;
                                        this.L$8 = null;
                                        this.label = 8;
                                        break;
                                    } else {
                                        channel6 = defaultWebSocketSessionImpl2.filtered;
                                        processIncomingExtensions2 = defaultWebSocketSessionImpl2.processIncomingExtensions(r0);
                                        this.L$0 = coroutineScope3;
                                        this.L$1 = objectRef5;
                                        this.L$2 = objectRef4;
                                        this.L$3 = booleanRef2;
                                        this.L$4 = defaultWebSocketSessionImpl2;
                                        this.L$5 = sendChannel2;
                                        this.L$6 = incoming;
                                        this.L$7 = channelIterator2;
                                        this.L$8 = null;
                                        this.label = 7;
                                        if (channel6.send(processIncomingExtensions2, this) != coroutine_suspended) {
                                            channelIterator3 = channelIterator2;
                                            receiveChannel3 = incoming;
                                            sendChannel3 = sendChannel2;
                                            defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                                            booleanRef = booleanRef2;
                                            objectRef2 = objectRef4;
                                            objectRef6 = objectRef5;
                                            coroutineScope4 = coroutineScope3;
                                        }
                                    }
                                    CoroutineScope coroutineScope5 = coroutineScope4;
                                    it = channelIterator3;
                                    coroutineScope = coroutineScope5;
                                    SendChannel<Frame.Ping> sendChannel8 = sendChannel3;
                                    incoming = receiveChannel3;
                                    objectRef = objectRef6;
                                    sendChannel = sendChannel8;
                                    th2 = th3;
                                    i = 1;
                                    th3 = null;
                                    this.L$0 = coroutineScope;
                                    this.L$1 = objectRef;
                                    this.L$2 = objectRef2;
                                    this.L$3 = booleanRef;
                                    this.L$4 = defaultWebSocketSessionImpl;
                                    this.L$5 = sendChannel;
                                    this.L$6 = incoming;
                                    this.L$7 = it;
                                    this.L$8 = th3;
                                    this.label = i;
                                    obj2 = it.hasNext(this);
                                    if (obj2 != coroutine_suspended) {
                                    }
                                } else {
                                    if (objectRef5.element == null) {
                                        objectRef5.element = r0;
                                    }
                                    if (objectRef4.element == null) {
                                        objectRef4.element = new BytePacketBuilder(null, 1, null);
                                    }
                                    Object obj9 = objectRef4.element;
                                    Intrinsics.checkNotNull(obj9);
                                    OutputKt.writeFully$default((Output) obj9, r0.getData(), 0, 0, 6, (Object) null);
                                    Ref.ObjectRef objectRef7 = objectRef5;
                                    it = channelIterator2;
                                    objectRef = objectRef7;
                                    Ref.ObjectRef objectRef8 = objectRef4;
                                    sendChannel = sendChannel2;
                                    defaultWebSocketSessionImpl = defaultWebSocketSessionImpl2;
                                    booleanRef = booleanRef2;
                                    objectRef2 = objectRef8;
                                    coroutineScope = coroutineScope3;
                                    th2 = th3;
                                    i = 1;
                                    th3 = null;
                                    this.L$0 = coroutineScope;
                                    this.L$1 = objectRef;
                                    this.L$2 = objectRef2;
                                    this.L$3 = booleanRef;
                                    this.L$4 = defaultWebSocketSessionImpl;
                                    this.L$5 = sendChannel;
                                    this.L$6 = incoming;
                                    this.L$7 = it;
                                    this.L$8 = th3;
                                    this.label = i;
                                    obj2 = it.hasNext(this);
                                    if (obj2 != coroutine_suspended) {
                                    }
                                }
                            }
                        }
                        CoroutineScope coroutineScope6 = coroutineScope2;
                        it = channelIterator;
                        coroutineScope = coroutineScope6;
                        SendChannel<Frame.Ping> sendChannel9 = sendChannel4;
                        incoming = receiveChannel2;
                        objectRef = objectRef3;
                        sendChannel = sendChannel9;
                        i = 1;
                        th3 = null;
                        this.L$0 = coroutineScope;
                        this.L$1 = objectRef;
                        this.L$2 = objectRef2;
                        this.L$3 = booleanRef;
                        this.L$4 = defaultWebSocketSessionImpl;
                        this.L$5 = sendChannel;
                        this.L$6 = incoming;
                        this.L$7 = it;
                        this.L$8 = th3;
                        this.label = i;
                        obj2 = it.hasNext(this);
                        if (obj2 != coroutine_suspended) {
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    channelIterator = (ChannelIterator) this.L$7;
                    receiveChannel2 = (ReceiveChannel) this.L$6;
                    SendChannel sendChannel10 = (SendChannel) this.L$5;
                    defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) this.L$4;
                    booleanRef = (Ref.BooleanRef) this.L$3;
                    objectRef2 = (Ref.ObjectRef) this.L$2;
                    objectRef3 = (Ref.ObjectRef) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    th2 = null;
                    r7 = sendChannel10;
                    if (((Boolean) obj2).booleanValue()) {
                    }
                    return coroutine_suspended;
                case 2:
                    receiveChannel2 = (ReceiveChannel) this.L$2;
                    booleanRef = (Ref.BooleanRef) this.L$1;
                    objectRef2 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    th2 = null;
                    booleanRef.element = true;
                    Unit unit62 = Unit.INSTANCE;
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    SendChannel.DefaultImpls.close$default(this.$ponger, null, 1, null);
                    bytePacketBuilder = (BytePacketBuilder) objectRef2.element;
                    if (bytePacketBuilder != null) {
                    }
                    channel7 = this.this$0.filtered;
                    SendChannel.DefaultImpls.close$default(channel7, null, 1, null);
                    if (!booleanRef.element) {
                    }
                    return unit62;
                case 3:
                    Unit unit9 = (Unit) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return unit9;
                case 4:
                    channelIterator = (ChannelIterator) this.L$7;
                    receiveChannel2 = (ReceiveChannel) this.L$6;
                    SendChannel<Frame.Ping> sendChannel11 = (SendChannel) this.L$5;
                    defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) this.L$4;
                    booleanRef = (Ref.BooleanRef) this.L$3;
                    objectRef2 = (Ref.ObjectRef) this.L$2;
                    objectRef3 = (Ref.ObjectRef) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    th2 = null;
                    sendChannel5 = sendChannel11;
                    Unit unit82 = Unit.INSTANCE;
                    sendChannel4 = sendChannel5;
                    CoroutineScope coroutineScope62 = coroutineScope2;
                    it = channelIterator;
                    coroutineScope = coroutineScope62;
                    SendChannel<Frame.Ping> sendChannel92 = sendChannel4;
                    incoming = receiveChannel2;
                    objectRef = objectRef3;
                    sendChannel = sendChannel92;
                    i = 1;
                    th3 = null;
                    this.L$0 = coroutineScope;
                    this.L$1 = objectRef;
                    this.L$2 = objectRef2;
                    this.L$3 = booleanRef;
                    this.L$4 = defaultWebSocketSessionImpl;
                    this.L$5 = sendChannel;
                    this.L$6 = incoming;
                    this.L$7 = it;
                    this.L$8 = th3;
                    this.label = i;
                    obj2 = it.hasNext(this);
                    if (obj2 != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 5:
                    channelIterator = (ChannelIterator) this.L$7;
                    receiveChannel2 = (ReceiveChannel) this.L$6;
                    SendChannel<Frame.Ping> sendChannel12 = (SendChannel) this.L$5;
                    defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) this.L$4;
                    booleanRef = (Ref.BooleanRef) this.L$3;
                    objectRef2 = (Ref.ObjectRef) this.L$2;
                    objectRef3 = (Ref.ObjectRef) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    th2 = null;
                    sendChannel4 = sendChannel12;
                    CoroutineScope coroutineScope622 = coroutineScope2;
                    it = channelIterator;
                    coroutineScope = coroutineScope622;
                    SendChannel<Frame.Ping> sendChannel922 = sendChannel4;
                    incoming = receiveChannel2;
                    objectRef = objectRef3;
                    sendChannel = sendChannel922;
                    i = 1;
                    th3 = null;
                    this.L$0 = coroutineScope;
                    this.L$1 = objectRef;
                    this.L$2 = objectRef2;
                    this.L$3 = booleanRef;
                    this.L$4 = defaultWebSocketSessionImpl;
                    this.L$5 = sendChannel;
                    this.L$6 = incoming;
                    this.L$7 = it;
                    this.L$8 = th3;
                    this.label = i;
                    obj2 = it.hasNext(this);
                    if (obj2 != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 6:
                    Frame frame = (Frame) this.L$8;
                    channelIterator2 = (ChannelIterator) this.L$7;
                    incoming = (ReceiveChannel) this.L$6;
                    sendChannel2 = (SendChannel) this.L$5;
                    defaultWebSocketSessionImpl2 = (DefaultWebSocketSessionImpl) this.L$4;
                    booleanRef2 = (Ref.BooleanRef) this.L$3;
                    objectRef4 = (Ref.ObjectRef) this.L$2;
                    objectRef5 = (Ref.ObjectRef) this.L$1;
                    coroutineScope3 = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        r0 = frame;
                        if (r0.getFin()) {
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        receiveChannel = incoming;
                        throw th;
                    }
                    break;
                case 7:
                    channelIterator3 = (ChannelIterator) this.L$7;
                    receiveChannel3 = (ReceiveChannel) this.L$6;
                    sendChannel3 = (SendChannel) this.L$5;
                    defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) this.L$4;
                    booleanRef = (Ref.BooleanRef) this.L$3;
                    objectRef2 = (Ref.ObjectRef) this.L$2;
                    objectRef6 = (Ref.ObjectRef) this.L$1;
                    coroutineScope4 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope52 = coroutineScope4;
                    it = channelIterator3;
                    coroutineScope = coroutineScope52;
                    SendChannel<Frame.Ping> sendChannel82 = sendChannel3;
                    incoming = receiveChannel3;
                    objectRef = objectRef6;
                    sendChannel = sendChannel82;
                    th2 = th3;
                    i = 1;
                    th3 = null;
                    this.L$0 = coroutineScope;
                    this.L$1 = objectRef;
                    this.L$2 = objectRef2;
                    this.L$3 = booleanRef;
                    this.L$4 = defaultWebSocketSessionImpl;
                    this.L$5 = sendChannel;
                    this.L$6 = incoming;
                    this.L$7 = it;
                    this.L$8 = th3;
                    this.label = i;
                    obj2 = it.hasNext(this);
                    if (obj2 != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 8:
                    channelIterator3 = (ChannelIterator) this.L$7;
                    receiveChannel3 = (ReceiveChannel) this.L$6;
                    sendChannel3 = (SendChannel) this.L$5;
                    defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) this.L$4;
                    booleanRef = (Ref.BooleanRef) this.L$3;
                    objectRef2 = (Ref.ObjectRef) this.L$2;
                    objectRef6 = (Ref.ObjectRef) this.L$1;
                    coroutineScope4 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope522 = coroutineScope4;
                    it = channelIterator3;
                    coroutineScope = coroutineScope522;
                    SendChannel<Frame.Ping> sendChannel822 = sendChannel3;
                    incoming = receiveChannel3;
                    objectRef = objectRef6;
                    sendChannel = sendChannel822;
                    th2 = th3;
                    i = 1;
                    th3 = null;
                    this.L$0 = coroutineScope;
                    this.L$1 = objectRef;
                    this.L$2 = objectRef2;
                    this.L$3 = booleanRef;
                    this.L$4 = defaultWebSocketSessionImpl;
                    this.L$5 = sendChannel;
                    this.L$6 = incoming;
                    this.L$7 = it;
                    this.L$8 = th3;
                    this.label = i;
                    obj2 = it.hasNext(this);
                    if (obj2 != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 9:
                case 10:
                case 11:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                case 12:
                    Throwable th9 = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th9;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }
}
