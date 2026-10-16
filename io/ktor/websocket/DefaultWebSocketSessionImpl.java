package io.ktor.websocket;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: DefaultWebSocketSession.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\b\u0000\u0018\u0000 e2\u00020g2\u00020\u0001:\u0001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001cH\u0002¢\u0006\u0004\b!\u0010\"J)\u0010'\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%H\u0082@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J!\u0010,\u001a\u00020\f2\u0010\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0)H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\fH\u0017¢\u0006\u0004\b.\u0010 J\u000f\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101R\u001e\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020#0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010A\u001a\u00020@8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001e\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\n0K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR$\u0010S\u001a\u00020/2\u0006\u0010O\u001a\u00020/8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bP\u00101\"\u0004\bQ\u0010RR$\u0010X\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\n0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\n0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010JR*\u0010^\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010U\"\u0004\ba\u0010WR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010bR*\u0010\u0005\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010_\u001a\u0004\bc\u0010U\"\u0004\bd\u0010W\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006f"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSessionImpl;", "Lio/ktor/websocket/WebSocketSession;", "raw", "", "pingInterval", "timeoutMillis", "<init>", "(Lio/ktor/websocket/WebSocketSession;JJ)V", "Lio/ktor/utils/io/core/BytePacketBuilder;", "packet", "Lio/ktor/websocket/Frame;", "frame", "", "checkMaxFrameSize", "(Lio/ktor/utils/io/core/BytePacketBuilder;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", PglCryptUtils.KEY_MESSAGE, "goingAway", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "outgoingProcessorLoop", "processIncomingExtensions", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "processOutgoingExtensions", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Ping;", "ponger", "Lkotlinx/coroutines/Job;", "runIncomingProcessor", "(Lkotlinx/coroutines/channels/SendChannel;)Lkotlinx/coroutines/Job;", "runOrCancelPinger", "()V", "runOutgoingProcessor", "()Lkotlinx/coroutines/Job;", "Lio/ktor/websocket/CloseReason;", "reason", "", "exception", "sendCloseSequence", "(Lio/ktor/websocket/CloseReason;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "start", "(Ljava/util/List;)V", "terminate", "", "tryClose", "()Z", "", "_extensions", "Ljava/util/List;", "Lkotlinx/coroutines/Deferred;", "closeReason", "Lkotlinx/coroutines/Deferred;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/CompletableDeferred;", "closeReasonRef", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/CompletableJob;", "context", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getExtensions", "()Ljava/util/List;", "extensions", "Lkotlinx/coroutines/channels/Channel;", "filtered", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "value", "getMasking", "setMasking", "(Z)V", "masking", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "maxFrameSize", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "outgoingToBeProcessed", "newValue", "pingIntervalMillis", "J", "getPingIntervalMillis", "setPingIntervalMillis", "Lio/ktor/websocket/WebSocketSession;", "getTimeoutMillis", "setTimeoutMillis", "Companion", "ktor-websockets", "Lio/ktor/websocket/DefaultWebSocketSession;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DefaultWebSocketSessionImpl implements DefaultWebSocketSession, WebSocketSession {
    private final List<WebSocketExtension<?>> _extensions;
    private final Deferred<CloseReason> closeReason;
    private final CompletableDeferred<CloseReason> closeReasonRef;
    private volatile /* synthetic */ int closed;
    private final CompletableJob context;
    private final CoroutineContext coroutineContext;
    private final Channel<Frame> filtered;
    private final Channel<Frame> outgoingToBeProcessed;
    private long pingIntervalMillis;
    volatile /* synthetic */ Object pinger;
    private final WebSocketSession raw;
    private volatile /* synthetic */ int started;
    private long timeoutMillis;
    private static final Frame.Pong EmptyPong = new Frame.Pong(new byte[0], NonDisposableHandle.INSTANCE);
    static final /* synthetic */ AtomicReferenceFieldUpdater pinger$FU = AtomicReferenceFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, Object.class, "pinger");
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "closed");
    private static final /* synthetic */ AtomicIntegerFieldUpdater started$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, C3040d4.h.d0);

    public DefaultWebSocketSessionImpl(WebSocketSession raw, long j, long j2) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        this.raw = raw;
        this.pinger = null;
        CompletableDeferred<CloseReason> CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.closeReasonRef = CompletableDeferred$default;
        this.filtered = ChannelKt.Channel$default(8, null, null, 6, null);
        this.outgoingToBeProcessed = ChannelKt.Channel$default(UtilsKt.getOUTGOING_CHANNEL_CAPACITY(), null, null, 6, null);
        this.closed = 0;
        CompletableJob Job = JobKt.Job((Job) raw.getCoroutineContext().get(Job.INSTANCE));
        this.context = Job;
        this._extensions = new ArrayList();
        this.started = 0;
        this.coroutineContext = raw.getCoroutineContext().plus(Job).plus(new CoroutineName("ws-default"));
        this.pingIntervalMillis = j;
        this.timeoutMillis = j2;
        this.closeReason = CompletableDeferred$default;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return DefaultWebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this.filtered;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this.outgoingToBeProcessed;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return this._extensions;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.raw.getMasking();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        this.raw.setMasking(z);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.raw.getMaxFrameSize();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.raw.setMaxFrameSize(j);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setPingIntervalMillis(long j) {
        this.pingIntervalMillis = j;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setTimeoutMillis(long j) {
        this.timeoutMillis = j;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public Deferred<CloseReason> getCloseReason() {
        return this.closeReason;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void start(List<? extends WebSocketExtension<?>> negotiatedExtensions) {
        Intrinsics.checkNotNullParameter(negotiatedExtensions, "negotiatedExtensions");
        if (!started$FU.compareAndSet(this, 0, 1)) {
            throw new IllegalStateException(("WebSocket session " + this + " is already started.").toString());
        }
        DefaultWebSocketSessionKt.getLOGGER().trace("Starting default WebSocketSession(" + this + ") with negotiated extensions: " + CollectionsKt.joinToString$default(negotiatedExtensions, null, null, null, 0, null, null, 63, null));
        this._extensions.addAll(negotiatedExtensions);
        runOrCancelPinger();
        runIncomingProcessor(PingPongKt.ponger(this, getOutgoing()));
        runOutgoingProcessor();
    }

    public static /* synthetic */ Object goingAway$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Server is going down";
        }
        return defaultWebSocketSessionImpl.goingAway(str, continuation);
    }

    public final Object goingAway(String str, Continuation<? super Unit> continuation) {
        Object sendCloseSequence$default = sendCloseSequence$default(this, new CloseReason(CloseReason.Codes.GOING_AWAY, str), null, continuation, 2, null);
        return sendCloseSequence$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendCloseSequence$default : Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(Continuation<? super Unit> continuation) {
        Object flush = this.raw.flush(continuation);
        return flush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flush : Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        Job.DefaultImpls.cancel$default((Job) this.context, (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.cancel$default(this.raw, null, 1, null);
    }

    private final Job runIncomingProcessor(SendChannel<? super Frame.Ping> ponger) {
        CoroutineName coroutineName;
        Job launch$default;
        coroutineName = DefaultWebSocketSessionKt.IncomingProcessorCoroutineName;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, coroutineName.plus(Dispatchers.getUnconfined()), null, new DefaultWebSocketSessionImpl$runIncomingProcessor$1(this, ponger, null), 2, null);
        return launch$default;
    }

    private final Job runOutgoingProcessor() {
        CoroutineName coroutineName;
        coroutineName = DefaultWebSocketSessionKt.OutgoingProcessorCoroutineName;
        return BuildersKt.launch(this, coroutineName.plus(Dispatchers.getUnconfined()), CoroutineStart.UNDISPATCHED, new DefaultWebSocketSessionImpl$runOutgoingProcessor$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b5, code lost:
    
        if (sendCloseSequence$default(r6, r7, null, r9, 2, null) == r1) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d9 -> B:12:0x0037). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object outgoingProcessorLoop(Continuation<? super Unit> continuation) {
        DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 defaultWebSocketSessionImpl$outgoingProcessorLoop$1;
        int i;
        ChannelIterator<Frame> it;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
        ChannelIterator<Frame> channelIterator;
        Object hasNext;
        if (continuation instanceof DefaultWebSocketSessionImpl$outgoingProcessorLoop$1) {
            defaultWebSocketSessionImpl$outgoingProcessorLoop$1 = (DefaultWebSocketSessionImpl$outgoingProcessorLoop$1) continuation;
            if ((defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label & Integer.MIN_VALUE) != 0) {
                defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label -= Integer.MIN_VALUE;
                Object obj = defaultWebSocketSessionImpl$outgoingProcessorLoop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    it = this.outgoingToBeProcessed.iterator();
                    defaultWebSocketSessionImpl = this;
                    defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$0 = defaultWebSocketSessionImpl;
                    defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$1 = it;
                    defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label = 1;
                    hasNext = it.hasNext(defaultWebSocketSessionImpl$outgoingProcessorLoop$1);
                    if (hasNext != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    channelIterator = (ChannelIterator) defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$1;
                    defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 defaultWebSocketSessionImpl$outgoingProcessorLoop$12 = defaultWebSocketSessionImpl$outgoingProcessorLoop$1;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelIterator = (ChannelIterator) defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$1;
                defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$0;
                ResultKt.throwOnFailure(obj);
                it = channelIterator;
                defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$0 = defaultWebSocketSessionImpl;
                defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$1 = it;
                defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label = 1;
                hasNext = it.hasNext(defaultWebSocketSessionImpl$outgoingProcessorLoop$1);
                if (hasNext != coroutine_suspended) {
                    channelIterator = it;
                    obj = hasNext;
                    DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 defaultWebSocketSessionImpl$outgoingProcessorLoop$122 = defaultWebSocketSessionImpl$outgoingProcessorLoop$1;
                    if (((Boolean) obj).booleanValue()) {
                        Frame next = channelIterator.next();
                        DefaultWebSocketSessionKt.getLOGGER().trace("Sending " + next + " from session " + defaultWebSocketSessionImpl);
                        if (next instanceof Frame.Close) {
                            CloseReason readReason = FrameCommonKt.readReason((Frame.Close) next);
                            defaultWebSocketSessionImpl$outgoingProcessorLoop$122.L$0 = null;
                            defaultWebSocketSessionImpl$outgoingProcessorLoop$122.L$1 = null;
                            defaultWebSocketSessionImpl$outgoingProcessorLoop$122.label = 2;
                        } else {
                            if (next instanceof Frame.Text ? true : next instanceof Frame.Binary) {
                                next = defaultWebSocketSessionImpl.processOutgoingExtensions(next);
                            }
                            SendChannel<Frame> outgoing = defaultWebSocketSessionImpl.raw.getOutgoing();
                            defaultWebSocketSessionImpl$outgoingProcessorLoop$122.L$0 = defaultWebSocketSessionImpl;
                            defaultWebSocketSessionImpl$outgoingProcessorLoop$122.L$1 = channelIterator;
                            defaultWebSocketSessionImpl$outgoingProcessorLoop$122.label = 3;
                            if (outgoing.send(next, defaultWebSocketSessionImpl$outgoingProcessorLoop$122) != coroutine_suspended) {
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$1 = defaultWebSocketSessionImpl$outgoingProcessorLoop$122;
                                it = channelIterator;
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$0 = defaultWebSocketSessionImpl;
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$1.L$1 = it;
                                defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label = 1;
                                hasNext = it.hasNext(defaultWebSocketSessionImpl$outgoingProcessorLoop$1);
                                if (hasNext != coroutine_suspended) {
                                }
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
        }
        defaultWebSocketSessionImpl$outgoingProcessorLoop$1 = new DefaultWebSocketSessionImpl$outgoingProcessorLoop$1(this, continuation);
        Object obj2 = defaultWebSocketSessionImpl$outgoingProcessorLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultWebSocketSessionImpl$outgoingProcessorLoop$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendCloseSequence(CloseReason closeReason, Throwable th, Continuation<? super Unit> continuation) {
        DefaultWebSocketSessionImpl$sendCloseSequence$1 defaultWebSocketSessionImpl$sendCloseSequence$1;
        int i;
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
        if (continuation instanceof DefaultWebSocketSessionImpl$sendCloseSequence$1) {
            defaultWebSocketSessionImpl$sendCloseSequence$1 = (DefaultWebSocketSessionImpl$sendCloseSequence$1) continuation;
            if ((defaultWebSocketSessionImpl$sendCloseSequence$1.label & Integer.MIN_VALUE) != 0) {
                defaultWebSocketSessionImpl$sendCloseSequence$1.label -= Integer.MIN_VALUE;
                Object obj = defaultWebSocketSessionImpl$sendCloseSequence$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultWebSocketSessionImpl$sendCloseSequence$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!tryClose()) {
                        return Unit.INSTANCE;
                    }
                    DefaultWebSocketSessionKt.getLOGGER().trace("Sending Close Sequence for session " + this + " with reason " + closeReason + " and exception " + th);
                    this.context.complete();
                    if (closeReason == null) {
                        closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
                    }
                    try {
                        runOrCancelPinger();
                        if (closeReason.getCode() != CloseReason.Codes.CLOSED_ABNORMALLY.getCode()) {
                            SendChannel<Frame> outgoing = this.raw.getOutgoing();
                            Frame.Close close = new Frame.Close(closeReason);
                            defaultWebSocketSessionImpl$sendCloseSequence$1.L$0 = this;
                            defaultWebSocketSessionImpl$sendCloseSequence$1.L$1 = th;
                            defaultWebSocketSessionImpl$sendCloseSequence$1.L$2 = closeReason;
                            defaultWebSocketSessionImpl$sendCloseSequence$1.label = 1;
                            if (outgoing.send(close, defaultWebSocketSessionImpl$sendCloseSequence$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        defaultWebSocketSessionImpl = this;
                    } catch (Throwable th2) {
                        th = th2;
                        defaultWebSocketSessionImpl = this;
                        defaultWebSocketSessionImpl.closeReasonRef.complete(closeReason);
                        if (th != null) {
                            defaultWebSocketSessionImpl.outgoingToBeProcessed.close(th);
                            defaultWebSocketSessionImpl.filtered.close(th);
                        }
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    closeReason = (CloseReason) defaultWebSocketSessionImpl$sendCloseSequence$1.L$2;
                    th = (Throwable) defaultWebSocketSessionImpl$sendCloseSequence$1.L$1;
                    defaultWebSocketSessionImpl = (DefaultWebSocketSessionImpl) defaultWebSocketSessionImpl$sendCloseSequence$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        defaultWebSocketSessionImpl.closeReasonRef.complete(closeReason);
                        if (th != null) {
                        }
                        throw th;
                    }
                }
                defaultWebSocketSessionImpl.closeReasonRef.complete(closeReason);
                if (th != null) {
                    defaultWebSocketSessionImpl.outgoingToBeProcessed.close(th);
                    defaultWebSocketSessionImpl.filtered.close(th);
                }
                return Unit.INSTANCE;
            }
        }
        defaultWebSocketSessionImpl$sendCloseSequence$1 = new DefaultWebSocketSessionImpl$sendCloseSequence$1(this, continuation);
        Object obj2 = defaultWebSocketSessionImpl$sendCloseSequence$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultWebSocketSessionImpl$sendCloseSequence$1.label;
        if (i != 0) {
        }
        defaultWebSocketSessionImpl.closeReasonRef.complete(closeReason);
        if (th != null) {
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object sendCloseSequence$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, CloseReason closeReason, Throwable th, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return defaultWebSocketSessionImpl.sendCloseSequence(closeReason, th, continuation);
    }

    private final boolean tryClose() {
        return closed$FU.compareAndSet(this, 0, 1);
    }

    private final void runOrCancelPinger() {
        long pingIntervalMillis = getPingIntervalMillis();
        SendChannel<Frame.Pong> pinger = (this.closed == 0 && pingIntervalMillis > 0) ? PingPongKt.pinger(this, this.raw.getOutgoing(), pingIntervalMillis, getTimeoutMillis(), new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this, null)) : null;
        SendChannel sendChannel = (SendChannel) pinger$FU.getAndSet(this, pinger);
        if (sendChannel != null) {
            SendChannel.DefaultImpls.close$default(sendChannel, null, 1, null);
        }
        if (pinger != null) {
            ChannelResult.m11771isSuccessimpl(pinger.mo11746trySendJP2dKIU(EmptyPong));
        }
        if (this.closed == 0 || pinger == null) {
            return;
        }
        runOrCancelPinger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkMaxFrameSize(BytePacketBuilder bytePacketBuilder, Frame frame, Continuation<? super Unit> continuation) {
        DefaultWebSocketSessionImpl$checkMaxFrameSize$1 defaultWebSocketSessionImpl$checkMaxFrameSize$1;
        int i;
        int i2;
        if (continuation instanceof DefaultWebSocketSessionImpl$checkMaxFrameSize$1) {
            defaultWebSocketSessionImpl$checkMaxFrameSize$1 = (DefaultWebSocketSessionImpl$checkMaxFrameSize$1) continuation;
            if ((defaultWebSocketSessionImpl$checkMaxFrameSize$1.label & Integer.MIN_VALUE) != 0) {
                defaultWebSocketSessionImpl$checkMaxFrameSize$1.label -= Integer.MIN_VALUE;
                Object obj = defaultWebSocketSessionImpl$checkMaxFrameSize$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultWebSocketSessionImpl$checkMaxFrameSize$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    int length = frame.getData().length + (bytePacketBuilder != null ? bytePacketBuilder.getSize() : 0);
                    if (length > getMaxFrameSize()) {
                        if (bytePacketBuilder != null) {
                            bytePacketBuilder.release();
                        }
                        CloseReason closeReason = new CloseReason(CloseReason.Codes.TOO_BIG, "Frame is too big: " + length + ". Max size is " + getMaxFrameSize());
                        defaultWebSocketSessionImpl$checkMaxFrameSize$1.I$0 = length;
                        defaultWebSocketSessionImpl$checkMaxFrameSize$1.label = 1;
                        if (WebSocketSessionKt.close(this, closeReason, defaultWebSocketSessionImpl$checkMaxFrameSize$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i2 = length;
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = defaultWebSocketSessionImpl$checkMaxFrameSize$1.I$0;
                    ResultKt.throwOnFailure(obj);
                }
                throw new FrameTooBigException(i2);
            }
        }
        defaultWebSocketSessionImpl$checkMaxFrameSize$1 = new DefaultWebSocketSessionImpl$checkMaxFrameSize$1(this, continuation);
        Object obj2 = defaultWebSocketSessionImpl$checkMaxFrameSize$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultWebSocketSessionImpl$checkMaxFrameSize$1.label;
        if (i != 0) {
        }
        throw new FrameTooBigException(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Frame processIncomingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        while (it.hasNext()) {
            frame = ((WebSocketExtension) it.next()).processIncomingFrame(frame);
        }
        return frame;
    }

    private final Frame processOutgoingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        while (it.hasNext()) {
            frame = ((WebSocketExtension) it.next()).processOutgoingFrame(frame);
        }
        return frame;
    }
}
