package io.ktor.websocket;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.websocket.WebSocketSession;
import java.util.List;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: RawWebSocketCommon.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00014B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u00100\u001a\u000201H\u0096@ø\u0001\u0000¢\u0006\u0002\u00102J\b\u00103\u001a\u000201H\u0017R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon;", "Lio/ktor/websocket/WebSocketSession;", "input", "Lio/ktor/utils/io/ByteReadChannel;", "output", "Lio/ktor/utils/io/ByteWriteChannel;", "maxFrameSize", "", "masking", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;)V", "_incoming", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "_outgoing", "", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "extensions", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "incoming", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "lastOpcode", "", "getMasking", "()Z", "setMasking", "(Z)V", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "outgoing", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "readerJob", "Lkotlinx/coroutines/Job;", "socketJob", "Lkotlinx/coroutines/CompletableJob;", "writerJob", "flush", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terminate", "FlushRequest", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class RawWebSocketCommon implements WebSocketSession {
    private final Channel<Frame> _incoming;
    private final Channel<Object> _outgoing;
    private final CoroutineContext coroutineContext;
    private final ByteReadChannel input;
    private int lastOpcode;
    private boolean masking;
    private long maxFrameSize;
    private final ByteWriteChannel output;
    private final Job readerJob;
    private final CompletableJob socketJob;
    private final Job writerJob;

    public RawWebSocketCommon(ByteReadChannel input, ByteWriteChannel output, long j, boolean z, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.input = input;
        this.output = output;
        this.maxFrameSize = j;
        this.masking = z;
        CompletableJob Job = JobKt.Job((Job) coroutineContext.get(Job.INSTANCE));
        this.socketJob = Job;
        this._incoming = ChannelKt.Channel$default(8, null, null, 6, null);
        this._outgoing = ChannelKt.Channel$default(8, null, null, 6, null);
        this.coroutineContext = coroutineContext.plus(Job).plus(new CoroutineName("raw-ws"));
        RawWebSocketCommon rawWebSocketCommon = this;
        this.writerJob = BuildersKt.launch(rawWebSocketCommon, new CoroutineName("ws-writer"), CoroutineStart.ATOMIC, new RawWebSocketCommon$writerJob$1(this, null));
        this.readerJob = BuildersKt.launch(rawWebSocketCommon, new CoroutineName("ws-reader"), CoroutineStart.ATOMIC, new RawWebSocketCommon$readerJob$1(this, null));
        Job.complete();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return WebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    public /* synthetic */ RawWebSocketCommon(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, byteWriteChannel, (i & 4) != 0 ? 2147483647L : j, (i & 8) != 0 ? false : z, coroutineContext);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.maxFrameSize = j;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.masking;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        this.masking = z;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this._incoming;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this._outgoing;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return CollectionsKt.emptyList();
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
    /* JADX WARN: Type inference failed for: r2v0, types: [int, io.ktor.websocket.RawWebSocketCommon$FlushRequest] */
    @Override // io.ktor.websocket.WebSocketSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object flush(Continuation<? super Unit> continuation) {
        RawWebSocketCommon$flush$1 rawWebSocketCommon$flush$1;
        ?? r2;
        FlushRequest flushRequest;
        RawWebSocketCommon rawWebSocketCommon;
        FlushRequest flushRequest2;
        Job job;
        try {
            if (continuation instanceof RawWebSocketCommon$flush$1) {
                rawWebSocketCommon$flush$1 = (RawWebSocketCommon$flush$1) continuation;
                if ((rawWebSocketCommon$flush$1.label & Integer.MIN_VALUE) != 0) {
                    rawWebSocketCommon$flush$1.label -= Integer.MIN_VALUE;
                    Object obj = rawWebSocketCommon$flush$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r2 = rawWebSocketCommon$flush$1.label;
                    if (r2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        flushRequest = new FlushRequest((Job) getCoroutineContext().get(Job.INSTANCE));
                        try {
                            Channel<Object> channel = this._outgoing;
                            rawWebSocketCommon$flush$1.L$0 = this;
                            rawWebSocketCommon$flush$1.L$1 = flushRequest;
                            rawWebSocketCommon$flush$1.L$2 = flushRequest;
                            rawWebSocketCommon$flush$1.label = 1;
                        } catch (ClosedSendChannelException unused) {
                            rawWebSocketCommon = this;
                            flushRequest2 = flushRequest;
                            flushRequest.complete();
                            job = rawWebSocketCommon.writerJob;
                            rawWebSocketCommon$flush$1.L$0 = flushRequest2;
                            rawWebSocketCommon$flush$1.L$1 = null;
                            rawWebSocketCommon$flush$1.L$2 = null;
                            rawWebSocketCommon$flush$1.label = 2;
                            if (job.join(rawWebSocketCommon$flush$1) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                    } else if (r2 == 1) {
                        flushRequest = (FlushRequest) rawWebSocketCommon$flush$1.L$2;
                        flushRequest2 = (FlushRequest) rawWebSocketCommon$flush$1.L$1;
                        rawWebSocketCommon = (RawWebSocketCommon) rawWebSocketCommon$flush$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (ClosedSendChannelException unused2) {
                            flushRequest.complete();
                            job = rawWebSocketCommon.writerJob;
                            rawWebSocketCommon$flush$1.L$0 = flushRequest2;
                            rawWebSocketCommon$flush$1.L$1 = null;
                            rawWebSocketCommon$flush$1.L$2 = null;
                            rawWebSocketCommon$flush$1.label = 2;
                            if (job.join(rawWebSocketCommon$flush$1) != coroutine_suspended) {
                                flushRequest = flushRequest2;
                                flushRequest2 = flushRequest;
                                rawWebSocketCommon$flush$1.L$0 = null;
                                rawWebSocketCommon$flush$1.L$1 = null;
                                rawWebSocketCommon$flush$1.L$2 = null;
                                rawWebSocketCommon$flush$1.label = 3;
                            }
                            return coroutine_suspended;
                        }
                        rawWebSocketCommon$flush$1.L$0 = null;
                        rawWebSocketCommon$flush$1.L$1 = null;
                        rawWebSocketCommon$flush$1.L$2 = null;
                        rawWebSocketCommon$flush$1.label = 3;
                    } else {
                        if (r2 != 2) {
                            if (r2 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        flushRequest = (FlushRequest) rawWebSocketCommon$flush$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    flushRequest2 = flushRequest;
                    rawWebSocketCommon$flush$1.L$0 = null;
                    rawWebSocketCommon$flush$1.L$1 = null;
                    rawWebSocketCommon$flush$1.L$2 = null;
                    rawWebSocketCommon$flush$1.label = 3;
                }
            }
            if (r2 != 0) {
            }
            flushRequest2 = flushRequest;
            rawWebSocketCommon$flush$1.L$0 = null;
            rawWebSocketCommon$flush$1.L$1 = null;
            rawWebSocketCommon$flush$1.L$2 = null;
            rawWebSocketCommon$flush$1.label = 3;
        } catch (Throwable th) {
            r2.complete();
            throw th;
        }
        rawWebSocketCommon$flush$1 = new RawWebSocketCommon$flush$1(this, continuation);
        Object obj2 = rawWebSocketCommon$flush$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = rawWebSocketCommon$flush$1.label;
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        SendChannel.DefaultImpls.close$default(getOutgoing(), null, 1, null);
        this.socketJob.complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RawWebSocketCommon.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon$FlushRequest;", "", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "done", "Lkotlinx/coroutines/CompletableJob;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, "", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class FlushRequest {
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
