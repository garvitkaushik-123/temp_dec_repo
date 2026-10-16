package io.ktor.websocket;

import io.ktor.util.NIOKt;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: WebSocketReader.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001*B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0011\u0010#\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0019\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0019\u0010)\u001a\u00020$2\u0006\u0010'\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lio/ktor/websocket/WebSocketReader;", "Lkotlinx/coroutines/CoroutineScope;", "byteChannel", "Lio/ktor/utils/io/ByteReadChannel;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "maxFrameSize", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;JLio/ktor/utils/io/pool/ObjectPool;)V", "collector", "Lio/ktor/websocket/SimpleFrameCollector;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "frameParser", "Lio/ktor/websocket/FrameParser;", "incoming", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lio/ktor/websocket/Frame;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "queue", "Lkotlinx/coroutines/channels/Channel;", "readerJob", "Lkotlinx/coroutines/Job;", "getReaderJob$annotations", "()V", "state", "Lio/ktor/websocket/WebSocketReader$State;", "handleFrameIfProduced", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseLoop", "buffer", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLoop", "State", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WebSocketReader implements CoroutineScope {
    private final ByteReadChannel byteChannel;
    private final SimpleFrameCollector collector;
    private final CoroutineContext coroutineContext;
    private final FrameParser frameParser;
    private long maxFrameSize;
    private final Channel<Frame> queue;
    private final Job readerJob;
    private State state;

    /* compiled from: WebSocketReader.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/websocket/WebSocketReader$State;", "", "(Ljava/lang/String;I)V", "HEADER", "BODY", "CLOSED", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private enum State {
        HEADER,
        BODY,
        CLOSED
    }

    /* compiled from: WebSocketReader.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static /* synthetic */ void getReaderJob$annotations() {
    }

    public WebSocketReader(ByteReadChannel byteChannel, CoroutineContext coroutineContext, long j, ObjectPool<ByteBuffer> pool) {
        Intrinsics.checkNotNullParameter(byteChannel, "byteChannel");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.byteChannel = byteChannel;
        this.coroutineContext = coroutineContext;
        this.maxFrameSize = j;
        this.state = State.HEADER;
        this.frameParser = new FrameParser();
        this.collector = new SimpleFrameCollector();
        this.queue = ChannelKt.Channel$default(8, null, null, 6, null);
        this.readerJob = BuildersKt.launch(this, new CoroutineName("ws-reader"), CoroutineStart.ATOMIC, new WebSocketReader$readerJob$1(pool, this, null));
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public final void setMaxFrameSize(long j) {
        this.maxFrameSize = j;
    }

    public /* synthetic */ WebSocketReader(ByteReadChannel byteReadChannel, CoroutineContext coroutineContext, long j, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, coroutineContext, j, (i & 8) != 0 ? ByteBufferPoolKt.getKtorDefaultPool() : objectPool);
    }

    public final ReceiveChannel<Frame> getIncoming() {
        return this.queue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0084, code lost:
    
        if (r2.parseLoop(r8, r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0084 -> B:11:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readLoop(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        WebSocketReader$readLoop$1 webSocketReader$readLoop$1;
        int i;
        WebSocketReader webSocketReader;
        WebSocketReader webSocketReader2;
        if (continuation instanceof WebSocketReader$readLoop$1) {
            webSocketReader$readLoop$1 = (WebSocketReader$readLoop$1) continuation;
            if ((webSocketReader$readLoop$1.label & Integer.MIN_VALUE) != 0) {
                webSocketReader$readLoop$1.label -= Integer.MIN_VALUE;
                Object obj = webSocketReader$readLoop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = webSocketReader$readLoop$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteBuffer.clear();
                    webSocketReader = this;
                    if (webSocketReader.state != State.CLOSED) {
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteBuffer = (ByteBuffer) webSocketReader$readLoop$1.L$1;
                    webSocketReader2 = (WebSocketReader) webSocketReader$readLoop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    webSocketReader = webSocketReader2;
                    byteBuffer.compact();
                    if (webSocketReader.state != State.CLOSED) {
                        ByteReadChannel byteReadChannel = webSocketReader.byteChannel;
                        webSocketReader$readLoop$1.L$0 = webSocketReader;
                        webSocketReader$readLoop$1.L$1 = byteBuffer;
                        webSocketReader$readLoop$1.label = 1;
                        Object readAvailable = byteReadChannel.readAvailable(byteBuffer, webSocketReader$readLoop$1);
                        if (readAvailable != coroutine_suspended) {
                            webSocketReader2 = webSocketReader;
                            obj = readAvailable;
                            if (((Number) obj).intValue() != -1) {
                                webSocketReader2.state = State.CLOSED;
                            } else {
                                byteBuffer.flip();
                                webSocketReader$readLoop$1.L$0 = webSocketReader2;
                                webSocketReader$readLoop$1.L$1 = byteBuffer;
                                webSocketReader$readLoop$1.label = 2;
                            }
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                byteBuffer = (ByteBuffer) webSocketReader$readLoop$1.L$1;
                webSocketReader2 = (WebSocketReader) webSocketReader$readLoop$1.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Number) obj).intValue() != -1) {
                }
            }
        }
        webSocketReader$readLoop$1 = new WebSocketReader$readLoop$1(this, continuation);
        Object obj2 = webSocketReader$readLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = webSocketReader$readLoop$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object parseLoop(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        WebSocketReader$parseLoop$1 webSocketReader$parseLoop$1;
        int i;
        WebSocketReader webSocketReader;
        if (continuation instanceof WebSocketReader$parseLoop$1) {
            webSocketReader$parseLoop$1 = (WebSocketReader$parseLoop$1) continuation;
            if ((webSocketReader$parseLoop$1.label & Integer.MIN_VALUE) != 0) {
                webSocketReader$parseLoop$1.label -= Integer.MIN_VALUE;
                Object obj = webSocketReader$parseLoop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = webSocketReader$parseLoop$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    webSocketReader = this;
                } else {
                    if (i != 1 && i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteBuffer = (ByteBuffer) webSocketReader$parseLoop$1.L$1;
                    webSocketReader = (WebSocketReader) webSocketReader$parseLoop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (byteBuffer.hasRemaining()) {
                    int i2 = WhenMappings.$EnumSwitchMapping$0[webSocketReader.state.ordinal()];
                    if (i2 == 1) {
                        webSocketReader.frameParser.frame(byteBuffer);
                        if (webSocketReader.frameParser.getBodyReady()) {
                            webSocketReader.state = State.BODY;
                            if (webSocketReader.frameParser.getLength() > 2147483647L || webSocketReader.frameParser.getLength() > webSocketReader.maxFrameSize) {
                                throw new FrameTooBigException(webSocketReader.frameParser.getLength());
                            }
                            webSocketReader.collector.start((int) webSocketReader.frameParser.getLength(), byteBuffer);
                            webSocketReader$parseLoop$1.L$0 = webSocketReader;
                            webSocketReader$parseLoop$1.L$1 = byteBuffer;
                            webSocketReader$parseLoop$1.label = 1;
                            if (webSocketReader.handleFrameIfProduced(webSocketReader$parseLoop$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    } else if (i2 == 2) {
                        webSocketReader.collector.handle(byteBuffer);
                        webSocketReader$parseLoop$1.L$0 = webSocketReader;
                        webSocketReader$parseLoop$1.L$1 = byteBuffer;
                        webSocketReader$parseLoop$1.label = 2;
                        if (webSocketReader.handleFrameIfProduced(webSocketReader$parseLoop$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i2 == 3) {
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        webSocketReader$parseLoop$1 = new WebSocketReader$parseLoop$1(this, continuation);
        Object obj2 = webSocketReader$parseLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = webSocketReader$parseLoop$1.label;
        if (i != 0) {
        }
        while (byteBuffer.hasRemaining()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleFrameIfProduced(Continuation<? super Unit> continuation) {
        WebSocketReader$handleFrameIfProduced$1 webSocketReader$handleFrameIfProduced$1;
        int i;
        WebSocketReader webSocketReader;
        if (continuation instanceof WebSocketReader$handleFrameIfProduced$1) {
            webSocketReader$handleFrameIfProduced$1 = (WebSocketReader$handleFrameIfProduced$1) continuation;
            if ((webSocketReader$handleFrameIfProduced$1.label & Integer.MIN_VALUE) != 0) {
                webSocketReader$handleFrameIfProduced$1.label -= Integer.MIN_VALUE;
                Object obj = webSocketReader$handleFrameIfProduced$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = webSocketReader$handleFrameIfProduced$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.collector.getHasRemaining()) {
                        this.state = this.frameParser.getFrameType() == FrameType.CLOSE ? State.CLOSED : State.HEADER;
                        FrameParser frameParser = this.frameParser;
                        Frame byType = Frame.INSTANCE.byType(frameParser.getFin(), frameParser.getFrameType(), NIOKt.moveToByteArray(this.collector.take(frameParser.getMaskKey())), frameParser.getRsv1(), frameParser.getRsv2(), frameParser.getRsv3());
                        Channel<Frame> channel = this.queue;
                        webSocketReader$handleFrameIfProduced$1.L$0 = this;
                        webSocketReader$handleFrameIfProduced$1.label = 1;
                        if (channel.send(byType, webSocketReader$handleFrameIfProduced$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        webSocketReader = this;
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                webSocketReader = (WebSocketReader) webSocketReader$handleFrameIfProduced$1.L$0;
                ResultKt.throwOnFailure(obj);
                webSocketReader.frameParser.bodyComplete();
                return Unit.INSTANCE;
            }
        }
        webSocketReader$handleFrameIfProduced$1 = new WebSocketReader$handleFrameIfProduced$1(this, continuation);
        Object obj2 = webSocketReader$handleFrameIfProduced$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = webSocketReader$handleFrameIfProduced$1.label;
        if (i != 0) {
        }
        webSocketReader.frameParser.bodyComplete();
        return Unit.INSTANCE;
    }
}
