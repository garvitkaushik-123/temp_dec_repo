package io.ktor.websocket;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.util.cio.ChannelWriteException;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.pool.ObjectPool;
import io.ktor.websocket.Frame;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: WebSocketWriter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u00010B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020#H\u0002J!\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0011\u0010)\u001a\u00020#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0019\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020#2\u0006\u0010'\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lio/ktor/websocket/WebSocketWriter;", "Lkotlinx/coroutines/CoroutineScope;", "writeChannel", "Lio/ktor/utils/io/ByteWriteChannel;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "masking", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;ZLio/ktor/utils/io/pool/ObjectPool;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getMasking", "()Z", "setMasking", "(Z)V", "outgoing", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "queue", "Lkotlinx/coroutines/channels/Channel;", "", "serializer", "Lio/ktor/websocket/Serializer;", "writeLoopJob", "Lkotlinx/coroutines/Job;", "getWriteLoopJob$annotations", "()V", "close", "", "drainQueueAndDiscard", "drainQueueAndSerialize", "firstMsg", "buffer", "(Lio/ktor/websocket/Frame;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", "frame", "(Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLoop", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FlushRequest", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WebSocketWriter implements CoroutineScope {
    private final CoroutineContext coroutineContext;
    private boolean masking;
    private final ObjectPool<ByteBuffer> pool;
    private final Channel<Object> queue;
    private final Serializer serializer;
    private final ByteWriteChannel writeChannel;
    private final Job writeLoopJob;

    private static /* synthetic */ void getWriteLoopJob$annotations() {
    }

    public WebSocketWriter(ByteWriteChannel writeChannel, CoroutineContext coroutineContext, boolean z, ObjectPool<ByteBuffer> pool) {
        Intrinsics.checkNotNullParameter(writeChannel, "writeChannel");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.writeChannel = writeChannel;
        this.coroutineContext = coroutineContext;
        this.masking = z;
        this.pool = pool;
        this.queue = ChannelKt.Channel$default(8, null, null, 6, null);
        this.serializer = new Serializer();
        this.writeLoopJob = BuildersKt.launch(this, new CoroutineName("ws-writer"), CoroutineStart.ATOMIC, new WebSocketWriter$writeLoopJob$1(this, null));
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final boolean getMasking() {
        return this.masking;
    }

    public final void setMasking(boolean z) {
        this.masking = z;
    }

    public /* synthetic */ WebSocketWriter(ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext, boolean z, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteWriteChannel, coroutineContext, (i & 4) != 0 ? false : z, (i & 8) != 0 ? ByteBufferPoolKt.getKtorDefaultPool() : objectPool);
    }

    public final ObjectPool<ByteBuffer> getPool() {
        return this.pool;
    }

    public final SendChannel<Frame> getOutgoing() {
        return this.queue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|(2:3|(4:5|6|7|(1:(1:(8:11|12|13|14|(4:16|17|18|19)|21|22|(2:24|25)(7:26|27|28|(2:30|(2:34|(4:36|21|22|(0)(0))(2:37|38))(1:32))|17|18|19))(2:40|41))(9:42|43|44|27|28|(0)|17|18|19))(6:45|46|47|48|22|(0)(0))))|63|6|7|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
    
        if (r12 == r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0060, code lost:
    
        r11 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x005d, code lost:
    
        r11 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008b A[Catch: all -> 0x005d, ChannelWriteException -> 0x0060, TryCatch #4 {ChannelWriteException -> 0x0060, all -> 0x005d, blocks: (B:12:0x0038, B:14:0x00a4, B:22:0x0070, B:28:0x0083, B:30:0x008b, B:32:0x0093, B:34:0x00b0, B:36:0x00b4, B:37:0x00ba, B:38:0x00d2, B:43:0x0055), top: B:7:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a1 -> B:14:0x00a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b4 -> B:21:0x00ad). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeLoop(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        WebSocketWriter$writeLoop$1 webSocketWriter$writeLoop$1;
        int i;
        WebSocketWriter webSocketWriter;
        ChannelIterator<Object> it;
        WebSocketWriter$writeLoop$1 webSocketWriter$writeLoop$12;
        ChannelIterator<Object> channelIterator;
        WebSocketWriter$writeLoop$1 webSocketWriter$writeLoop$13;
        Object hasNext;
        try {
            if (continuation instanceof WebSocketWriter$writeLoop$1) {
                webSocketWriter$writeLoop$1 = (WebSocketWriter$writeLoop$1) continuation;
                if ((webSocketWriter$writeLoop$1.label & Integer.MIN_VALUE) != 0) {
                    webSocketWriter$writeLoop$1.label -= Integer.MIN_VALUE;
                    Object obj = webSocketWriter$writeLoop$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = webSocketWriter$writeLoop$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            ChannelIterator<Object> channelIterator2 = (ChannelIterator) webSocketWriter$writeLoop$1.L$2;
                            ByteBuffer byteBuffer2 = (ByteBuffer) webSocketWriter$writeLoop$1.L$1;
                            webSocketWriter = (WebSocketWriter) webSocketWriter$writeLoop$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            webSocketWriter$writeLoop$12 = webSocketWriter$writeLoop$1;
                            channelIterator = channelIterator2;
                            byteBuffer = byteBuffer2;
                            webSocketWriter$writeLoop$13 = webSocketWriter$writeLoop$12;
                            if (((Boolean) obj).booleanValue()) {
                            }
                            webSocketWriter.drainQueueAndDiscard();
                            return Unit.INSTANCE;
                        }
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ChannelIterator<Object> channelIterator3 = (ChannelIterator) webSocketWriter$writeLoop$1.L$2;
                        ByteBuffer byteBuffer3 = (ByteBuffer) webSocketWriter$writeLoop$1.L$1;
                        webSocketWriter = (WebSocketWriter) webSocketWriter$writeLoop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        WebSocketWriter$writeLoop$1 webSocketWriter$writeLoop$14 = webSocketWriter$writeLoop$1;
                        channelIterator = channelIterator3;
                        byteBuffer = byteBuffer3;
                        webSocketWriter$writeLoop$13 = webSocketWriter$writeLoop$14;
                        if (((Boolean) obj).booleanValue()) {
                            webSocketWriter.drainQueueAndDiscard();
                            return Unit.INSTANCE;
                        }
                        it = channelIterator;
                        webSocketWriter$writeLoop$1 = webSocketWriter$writeLoop$13;
                        webSocketWriter$writeLoop$1.L$0 = webSocketWriter;
                        webSocketWriter$writeLoop$1.L$1 = byteBuffer;
                        webSocketWriter$writeLoop$1.L$2 = it;
                        webSocketWriter$writeLoop$1.label = 1;
                        hasNext = it.hasNext(webSocketWriter$writeLoop$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        webSocketWriter$writeLoop$12 = webSocketWriter$writeLoop$1;
                        channelIterator = it;
                        obj = hasNext;
                        webSocketWriter$writeLoop$13 = webSocketWriter$writeLoop$12;
                        if (((Boolean) obj).booleanValue()) {
                            Object next = channelIterator.next();
                            if (next instanceof Frame) {
                                webSocketWriter$writeLoop$13.L$0 = webSocketWriter;
                                webSocketWriter$writeLoop$13.L$1 = byteBuffer;
                                webSocketWriter$writeLoop$13.L$2 = channelIterator;
                                webSocketWriter$writeLoop$13.label = 2;
                                obj = webSocketWriter.drainQueueAndSerialize((Frame) next, byteBuffer, webSocketWriter$writeLoop$13);
                            } else if (next instanceof FlushRequest) {
                                ((FlushRequest) next).complete();
                                it = channelIterator;
                                webSocketWriter$writeLoop$1 = webSocketWriter$writeLoop$13;
                                webSocketWriter$writeLoop$1.L$0 = webSocketWriter;
                                webSocketWriter$writeLoop$1.L$1 = byteBuffer;
                                webSocketWriter$writeLoop$1.L$2 = it;
                                webSocketWriter$writeLoop$1.label = 1;
                                hasNext = it.hasNext(webSocketWriter$writeLoop$1);
                                if (hasNext == coroutine_suspended) {
                                }
                            } else {
                                throw new IllegalArgumentException("unknown message " + next);
                            }
                        }
                        webSocketWriter.drainQueueAndDiscard();
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    byteBuffer.clear();
                    try {
                        it = this.queue.iterator();
                        webSocketWriter = this;
                        webSocketWriter$writeLoop$1.L$0 = webSocketWriter;
                        webSocketWriter$writeLoop$1.L$1 = byteBuffer;
                        webSocketWriter$writeLoop$1.L$2 = it;
                        webSocketWriter$writeLoop$1.label = 1;
                        hasNext = it.hasNext(webSocketWriter$writeLoop$1);
                        if (hasNext == coroutine_suspended) {
                        }
                    } catch (ChannelWriteException e) {
                        e = e;
                        webSocketWriter = this;
                        webSocketWriter.queue.close(ExceptionsKt.CancellationException("Failed to write to WebSocket.", e));
                        webSocketWriter.drainQueueAndDiscard();
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        webSocketWriter = this;
                        webSocketWriter.queue.close(th);
                        webSocketWriter.drainQueueAndDiscard();
                        return Unit.INSTANCE;
                    }
                }
            }
            if (i == 0) {
            }
        } finally {
            webSocketWriter.queue.close(ExceptionsKt.CancellationException("WebSocket closed.", null));
            ByteWriteChannelKt.close(webSocketWriter.writeChannel);
        }
        webSocketWriter$writeLoop$1 = new WebSocketWriter$writeLoop$1(this, continuation);
        Object obj2 = webSocketWriter$writeLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = webSocketWriter$writeLoop$1.label;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        throw new java.lang.IllegalArgumentException("unknown message " + r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void drainQueueAndDiscard() {
        SendChannel.DefaultImpls.close$default(this.queue, null, 1, null);
        while (true) {
            try {
                Object m11766getOrNullimpl = ChannelResult.m11766getOrNullimpl(this.queue.mo11754tryReceivePtdJZtk());
                if (m11766getOrNullimpl != null) {
                    if (!(m11766getOrNullimpl instanceof Frame.Close)) {
                        if (!(m11766getOrNullimpl instanceof Frame.Ping ? true : m11766getOrNullimpl instanceof Frame.Pong)) {
                            if (!(m11766getOrNullimpl instanceof FlushRequest)) {
                                if (!(m11766getOrNullimpl instanceof Frame.Text ? true : m11766getOrNullimpl instanceof Frame.Binary)) {
                                    break;
                                }
                            } else {
                                ((FlushRequest) m11766getOrNullimpl).complete();
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    return;
                }
            } catch (CancellationException unused) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
    
        kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r2.queue, null, 1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0122, code lost:
    
        if (r9.hasRemaining() == false) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x011c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r5v14, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00f7 -> B:10:0x00fa). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object drainQueueAndSerialize(Frame frame, ByteBuffer byteBuffer, Continuation<? super Boolean> continuation) {
        WebSocketWriter$drainQueueAndSerialize$1 webSocketWriter$drainQueueAndSerialize$1;
        int i;
        Ref.ObjectRef objectRef;
        WebSocketWriter webSocketWriter;
        WebSocketWriter webSocketWriter2;
        ByteWriteChannel byteWriteChannel;
        boolean z;
        ?? m11766getOrNullimpl;
        boolean z2;
        FlushRequest flushRequest;
        if (continuation instanceof WebSocketWriter$drainQueueAndSerialize$1) {
            webSocketWriter$drainQueueAndSerialize$1 = (WebSocketWriter$drainQueueAndSerialize$1) continuation;
            if ((webSocketWriter$drainQueueAndSerialize$1.label & Integer.MIN_VALUE) != 0) {
                webSocketWriter$drainQueueAndSerialize$1.label -= Integer.MIN_VALUE;
                Object obj = webSocketWriter$drainQueueAndSerialize$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = webSocketWriter$drainQueueAndSerialize$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    objectRef = new Ref.ObjectRef();
                    this.serializer.enqueue(frame);
                    webSocketWriter = this;
                    z = frame instanceof Frame.Close;
                    while (objectRef.element == 0) {
                        if (!(m11766getOrNullimpl instanceof FlushRequest)) {
                        }
                    }
                    if (!webSocketWriter.serializer.getHasOutstandingBytes()) {
                    }
                    webSocketWriter.serializer.setMasking(webSocketWriter.masking);
                    webSocketWriter.serializer.serialize(byteBuffer);
                    byteBuffer.flip();
                    webSocketWriter2 = webSocketWriter;
                    int i2 = z;
                    byteWriteChannel = webSocketWriter2.writeChannel;
                    webSocketWriter$drainQueueAndSerialize$1.L$0 = webSocketWriter2;
                    webSocketWriter$drainQueueAndSerialize$1.L$1 = byteBuffer;
                    webSocketWriter$drainQueueAndSerialize$1.L$2 = objectRef;
                    webSocketWriter$drainQueueAndSerialize$1.I$0 = i2;
                    webSocketWriter$drainQueueAndSerialize$1.label = 1;
                    z2 = i2;
                    if (byteWriteChannel.writeFully(byteBuffer, webSocketWriter$drainQueueAndSerialize$1) == coroutine_suspended) {
                    }
                    if (!webSocketWriter2.serializer.getHasOutstandingBytes()) {
                    }
                    if (objectRef.element == 0) {
                    }
                    i2 = z2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = webSocketWriter$drainQueueAndSerialize$1.I$0;
                    Ref.ObjectRef objectRef2 = (Ref.ObjectRef) webSocketWriter$drainQueueAndSerialize$1.L$2;
                    ByteBuffer byteBuffer2 = (ByteBuffer) webSocketWriter$drainQueueAndSerialize$1.L$1;
                    webSocketWriter2 = (WebSocketWriter) webSocketWriter$drainQueueAndSerialize$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef = objectRef2;
                    byteBuffer = byteBuffer2;
                    z2 = i3;
                    if (!webSocketWriter2.serializer.getHasOutstandingBytes() && !byteBuffer.hasRemaining() && (flushRequest = (FlushRequest) objectRef.element) != null) {
                        webSocketWriter2.writeChannel.flush();
                        flushRequest.complete();
                        objectRef.element = null;
                    }
                    if (objectRef.element == 0 || z2) {
                        i2 = z2;
                    }
                    byteBuffer.compact();
                    webSocketWriter = webSocketWriter2;
                    z = z2;
                    while (objectRef.element == 0 && !z && webSocketWriter.serializer.getRemainingCapacity() > 0 && (m11766getOrNullimpl = ChannelResult.m11766getOrNullimpl(webSocketWriter.queue.mo11754tryReceivePtdJZtk())) != 0) {
                        if (!(m11766getOrNullimpl instanceof FlushRequest)) {
                            objectRef.element = m11766getOrNullimpl;
                        } else if (m11766getOrNullimpl instanceof Frame.Close) {
                            webSocketWriter.serializer.enqueue((Frame) m11766getOrNullimpl);
                            z = true;
                        } else {
                            if (!(m11766getOrNullimpl instanceof Frame)) {
                                throw new IllegalArgumentException("unknown message " + ((Object) m11766getOrNullimpl));
                            }
                            webSocketWriter.serializer.enqueue((Frame) m11766getOrNullimpl);
                        }
                    }
                    if (!webSocketWriter.serializer.getHasOutstandingBytes() || byteBuffer.position() != 0) {
                        webSocketWriter.serializer.setMasking(webSocketWriter.masking);
                        webSocketWriter.serializer.serialize(byteBuffer);
                        byteBuffer.flip();
                        webSocketWriter2 = webSocketWriter;
                        int i22 = z;
                        byteWriteChannel = webSocketWriter2.writeChannel;
                        webSocketWriter$drainQueueAndSerialize$1.L$0 = webSocketWriter2;
                        webSocketWriter$drainQueueAndSerialize$1.L$1 = byteBuffer;
                        webSocketWriter$drainQueueAndSerialize$1.L$2 = objectRef;
                        webSocketWriter$drainQueueAndSerialize$1.I$0 = i22;
                        webSocketWriter$drainQueueAndSerialize$1.label = 1;
                        z2 = i22;
                        if (byteWriteChannel.writeFully(byteBuffer, webSocketWriter$drainQueueAndSerialize$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (!webSocketWriter2.serializer.getHasOutstandingBytes()) {
                            webSocketWriter2.writeChannel.flush();
                            flushRequest.complete();
                            objectRef.element = null;
                        }
                        if (objectRef.element == 0) {
                        }
                        i22 = z2;
                    } else {
                        webSocketWriter.writeChannel.flush();
                        FlushRequest flushRequest2 = (FlushRequest) objectRef.element;
                        if (flushRequest2 != null) {
                            Boxing.boxBoolean(flushRequest2.complete());
                        }
                        return Boxing.boxBoolean(z);
                    }
                }
            }
        }
        webSocketWriter$drainQueueAndSerialize$1 = new WebSocketWriter$drainQueueAndSerialize$1(this, continuation);
        Object obj2 = webSocketWriter$drainQueueAndSerialize$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = webSocketWriter$drainQueueAndSerialize$1.label;
        if (i != 0) {
        }
    }

    public final Object send(Frame frame, Continuation<? super Unit> continuation) {
        Object send = this.queue.send(frame, continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a2, code lost:
    
        if (r5.await(r0) != r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        if (r9.send(r2, r0) == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int, io.ktor.websocket.WebSocketWriter$FlushRequest] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object flush(Continuation<? super Unit> continuation) {
        WebSocketWriter$flush$1 webSocketWriter$flush$1;
        ?? r2;
        FlushRequest flushRequest;
        WebSocketWriter webSocketWriter;
        FlushRequest flushRequest2;
        Job job;
        try {
            if (continuation instanceof WebSocketWriter$flush$1) {
                webSocketWriter$flush$1 = (WebSocketWriter$flush$1) continuation;
                if ((webSocketWriter$flush$1.label & Integer.MIN_VALUE) != 0) {
                    webSocketWriter$flush$1.label -= Integer.MIN_VALUE;
                    Object obj = webSocketWriter$flush$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r2 = webSocketWriter$flush$1.label;
                    if (r2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        flushRequest = new FlushRequest((Job) getCoroutineContext().get(Job.INSTANCE));
                        try {
                            Channel<Object> channel = this.queue;
                            webSocketWriter$flush$1.L$0 = this;
                            webSocketWriter$flush$1.L$1 = flushRequest;
                            webSocketWriter$flush$1.L$2 = flushRequest;
                            webSocketWriter$flush$1.label = 1;
                        } catch (ClosedSendChannelException unused) {
                            webSocketWriter = this;
                            flushRequest2 = flushRequest;
                            flushRequest.complete();
                            job = webSocketWriter.writeLoopJob;
                            webSocketWriter$flush$1.L$0 = flushRequest2;
                            webSocketWriter$flush$1.L$1 = null;
                            webSocketWriter$flush$1.L$2 = null;
                            webSocketWriter$flush$1.label = 2;
                            if (job.join(webSocketWriter$flush$1) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                    } else if (r2 == 1) {
                        flushRequest = (FlushRequest) webSocketWriter$flush$1.L$2;
                        flushRequest2 = (FlushRequest) webSocketWriter$flush$1.L$1;
                        webSocketWriter = (WebSocketWriter) webSocketWriter$flush$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (ClosedSendChannelException unused2) {
                            flushRequest.complete();
                            job = webSocketWriter.writeLoopJob;
                            webSocketWriter$flush$1.L$0 = flushRequest2;
                            webSocketWriter$flush$1.L$1 = null;
                            webSocketWriter$flush$1.L$2 = null;
                            webSocketWriter$flush$1.label = 2;
                            if (job.join(webSocketWriter$flush$1) != coroutine_suspended) {
                                flushRequest = flushRequest2;
                                flushRequest2 = flushRequest;
                                webSocketWriter$flush$1.L$0 = null;
                                webSocketWriter$flush$1.L$1 = null;
                                webSocketWriter$flush$1.L$2 = null;
                                webSocketWriter$flush$1.label = 3;
                            }
                            return coroutine_suspended;
                        }
                        webSocketWriter$flush$1.L$0 = null;
                        webSocketWriter$flush$1.L$1 = null;
                        webSocketWriter$flush$1.L$2 = null;
                        webSocketWriter$flush$1.label = 3;
                    } else {
                        if (r2 != 2) {
                            if (r2 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        flushRequest = (FlushRequest) webSocketWriter$flush$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    flushRequest2 = flushRequest;
                    webSocketWriter$flush$1.L$0 = null;
                    webSocketWriter$flush$1.L$1 = null;
                    webSocketWriter$flush$1.L$2 = null;
                    webSocketWriter$flush$1.label = 3;
                }
            }
            if (r2 != 0) {
            }
            flushRequest2 = flushRequest;
            webSocketWriter$flush$1.L$0 = null;
            webSocketWriter$flush$1.L$1 = null;
            webSocketWriter$flush$1.L$2 = null;
            webSocketWriter$flush$1.label = 3;
        } catch (Throwable th) {
            r2.complete();
            throw th;
        }
        webSocketWriter$flush$1 = new WebSocketWriter$flush$1(this, continuation);
        Object obj2 = webSocketWriter$flush$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = webSocketWriter$flush$1.label;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Will be removed")
    public final void close() {
        SendChannel.DefaultImpls.close$default(this.queue, null, 1, null);
    }

    /* compiled from: WebSocketWriter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lio/ktor/websocket/WebSocketWriter$FlushRequest;", "", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "done", "Lkotlinx/coroutines/CompletableJob;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, "", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class FlushRequest {
        private final CompletableJob done;

        public FlushRequest(Job job) {
            this.done = JobKt.Job(job);
        }

        public final boolean complete() {
            return this.done.complete();
        }

        public final Object await(Continuation<? super Unit> continuation) {
            Object join = this.done.join(continuation);
            return join == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? join : Unit.INSTANCE;
        }
    }
}
