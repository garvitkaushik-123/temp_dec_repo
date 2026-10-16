package io.ktor.utils.io.internal;

import com.ironsource.D5;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.WriterSuspendSession;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WriteSessionImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0001\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0019\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lio/ktor/utils/io/internal/WriteSessionImpl;", "Lio/ktor/utils/io/WriterSuspendSession;", "channel", "Lio/ktor/utils/io/ByteBufferChannel;", "(Lio/ktor/utils/io/ByteBufferChannel;)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "current", "locked", "", "ringBufferCapacity", "Lio/ktor/utils/io/internal/RingBufferCapacity;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "begin", "", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, "flush", AdActivity.REQUEST_KEY_EXTRA, "min", "tryAwait", D5.q, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitJoinSwitch", "written", "writtenFailed", "", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WriteSessionImpl implements WriterSuspendSession {
    private ByteBuffer byteBuffer;
    private ByteBufferChannel current;
    private int locked;
    private RingBufferCapacity ringBufferCapacity;
    private ChunkBuffer view;

    public WriteSessionImpl(ByteBufferChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.current = channel.resolveChannelInstance$ktor_io();
        this.byteBuffer = ChunkBuffer.INSTANCE.getEmpty().getMemory();
        this.view = ChunkBuffer.INSTANCE.getEmpty();
        this.ringBufferCapacity = this.current.currentState$ktor_io().capacity;
    }

    public final void begin() {
        ByteBufferChannel resolveChannelInstance$ktor_io = this.current.resolveChannelInstance$ktor_io();
        this.current = resolveChannelInstance$ktor_io;
        ByteBuffer byteBuffer = resolveChannelInstance$ktor_io.setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return;
        }
        this.byteBuffer = byteBuffer;
        ChunkBuffer ChunkBuffer$default = BufferUtilsJvmKt.ChunkBuffer$default(this.current.currentState$ktor_io().backingBuffer, null, 2, null);
        this.view = ChunkBuffer$default;
        BufferUtilsJvmKt.resetFromContentToWrite(ChunkBuffer$default, this.byteBuffer);
        this.ringBufferCapacity = this.current.currentState$ktor_io().capacity;
    }

    public final void complete() {
        int i = this.locked;
        if (i > 0) {
            this.ringBufferCapacity.completeRead(i);
            this.locked = 0;
        }
        this.current.restoreStateAfterWrite$ktor_io();
        this.current.tryTerminate$ktor_io();
    }

    @Override // io.ktor.utils.io.WriterSession
    public ChunkBuffer request(int min) {
        int tryWriteAtLeast = this.locked + this.ringBufferCapacity.tryWriteAtLeast(0);
        this.locked = tryWriteAtLeast;
        if (tryWriteAtLeast < min) {
            return null;
        }
        this.current.prepareWriteBuffer$ktor_io(this.byteBuffer, tryWriteAtLeast);
        if (this.byteBuffer.remaining() < min) {
            return null;
        }
        BufferUtilsJvmKt.resetFromContentToWrite(this.view, this.byteBuffer);
        return this.view;
    }

    @Override // io.ktor.utils.io.WriterSession
    public void written(int n) {
        int i;
        if (n < 0 || n > (i = this.locked)) {
            writtenFailed(n);
            throw new KotlinNothingValueException();
        }
        this.locked = i - n;
        this.current.bytesWrittenFromSession$ktor_io(this.byteBuffer, this.ringBufferCapacity, n);
    }

    private final Void writtenFailed(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Written bytes count shouldn't be negative: " + n);
        }
        throw new IllegalStateException("Unable to mark " + n + " bytes as written: only " + this.locked + " were pre-locked.");
    }

    @Override // io.ktor.utils.io.WriterSuspendSession
    public Object tryAwait(int i, Continuation<? super Unit> continuation) {
        if (this.current.getJoining() != null) {
            Object tryAwaitJoinSwitch = tryAwaitJoinSwitch(i, continuation);
            return tryAwaitJoinSwitch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? tryAwaitJoinSwitch : Unit.INSTANCE;
        }
        int i2 = this.locked;
        if (i2 >= i) {
            return Unit.INSTANCE;
        }
        if (i2 > 0) {
            this.ringBufferCapacity.completeRead(i2);
            this.locked = 0;
        }
        Object tryWriteSuspend$ktor_io = this.current.tryWriteSuspend$ktor_io(i, continuation);
        return tryWriteSuspend$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? tryWriteSuspend$ktor_io : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryAwaitJoinSwitch(int i, Continuation<? super Unit> continuation) {
        WriteSessionImpl$tryAwaitJoinSwitch$1 writeSessionImpl$tryAwaitJoinSwitch$1;
        int i2;
        WriteSessionImpl writeSessionImpl;
        ByteBuffer byteBuffer;
        if (continuation instanceof WriteSessionImpl$tryAwaitJoinSwitch$1) {
            writeSessionImpl$tryAwaitJoinSwitch$1 = (WriteSessionImpl$tryAwaitJoinSwitch$1) continuation;
            if ((writeSessionImpl$tryAwaitJoinSwitch$1.label & Integer.MIN_VALUE) != 0) {
                writeSessionImpl$tryAwaitJoinSwitch$1.label -= Integer.MIN_VALUE;
                Object obj = writeSessionImpl$tryAwaitJoinSwitch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = writeSessionImpl$tryAwaitJoinSwitch$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    int i3 = this.locked;
                    if (i3 > 0) {
                        this.ringBufferCapacity.completeRead(i3);
                        this.locked = 0;
                    }
                    flush();
                    this.current.restoreStateAfterWrite$ktor_io();
                    this.current.tryTerminate$ktor_io();
                    ByteBufferChannel byteBufferChannel = this.current;
                    writeSessionImpl$tryAwaitJoinSwitch$1.L$0 = this;
                    writeSessionImpl$tryAwaitJoinSwitch$1.label = 1;
                    if (byteBufferChannel.tryWriteSuspend$ktor_io(i, writeSessionImpl$tryAwaitJoinSwitch$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    writeSessionImpl = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    writeSessionImpl = (WriteSessionImpl) writeSessionImpl$tryAwaitJoinSwitch$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ByteBufferChannel resolveChannelInstance$ktor_io = writeSessionImpl.current.resolveChannelInstance$ktor_io();
                writeSessionImpl.current = resolveChannelInstance$ktor_io;
                byteBuffer = resolveChannelInstance$ktor_io.setupStateForWrite$ktor_io();
                if (byteBuffer != null) {
                    writeSessionImpl.byteBuffer = byteBuffer;
                    ChunkBuffer ChunkBuffer$default = BufferUtilsJvmKt.ChunkBuffer$default(writeSessionImpl.current.currentState$ktor_io().backingBuffer, null, 2, null);
                    writeSessionImpl.view = ChunkBuffer$default;
                    BufferUtilsJvmKt.resetFromContentToWrite(ChunkBuffer$default, writeSessionImpl.byteBuffer);
                    writeSessionImpl.ringBufferCapacity = writeSessionImpl.current.currentState$ktor_io().capacity;
                }
                return Unit.INSTANCE;
            }
        }
        writeSessionImpl$tryAwaitJoinSwitch$1 = new WriteSessionImpl$tryAwaitJoinSwitch$1(this, continuation);
        Object obj2 = writeSessionImpl$tryAwaitJoinSwitch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = writeSessionImpl$tryAwaitJoinSwitch$1.label;
        if (i2 != 0) {
        }
        ByteBufferChannel resolveChannelInstance$ktor_io2 = writeSessionImpl.current.resolveChannelInstance$ktor_io();
        writeSessionImpl.current = resolveChannelInstance$ktor_io2;
        byteBuffer = resolveChannelInstance$ktor_io2.setupStateForWrite$ktor_io();
        if (byteBuffer != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.WriterSession
    public void flush() {
        this.current.flush();
    }
}
