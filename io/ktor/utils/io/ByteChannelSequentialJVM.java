package io.ktor.utils.io;

import com.ironsource.D5;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.ByteBuffersKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedSendChannelException;

/* compiled from: ByteChannelSequentialJVM.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0017J\u0011\u0010\f\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u000f0\u0011¢\u0006\u0002\b\u0013H\u0017¢\u0006\u0002\u0010\u0014J@\u0010\u0015\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2'\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0016¢\u0006\u0002\b\u0013H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J$\u0010!\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H\u0016J\u0019\u0010%\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010&\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J!\u0010'\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001fH\u0002J-\u0010-\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010.\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J$\u0010.\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H\u0016J\u0019\u0010/\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u00100\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u00101\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J%\u00102\u001a\u00020\n2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u00103R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialJVM;", "Lio/ktor/utils/io/ByteChannelSequentialBase;", "initial", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "autoFlush", "", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Z)V", "attachedJob", "Lkotlinx/coroutines/Job;", "attachJob", "", "job", "awaitContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookAhead", "R", "visitor", "Lkotlin/Function1;", "Lio/ktor/utils/io/LookAheadSession;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "lookAheadSuspend", "Lkotlin/Function2;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "min", "", "consumer", "Ljava/nio/ByteBuffer;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", "dst", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "block", "readAvailableSuspend", "readFully", "readFullySuspend", "rc0", "(Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReadAvailable", "tryWriteAvailable", "src", "write", "writeAvailable", "writeAvailableSuspend", "writeFully", "writeFullySuspend", "writeWhile", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Session", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ByteChannelSequentialJVM extends ByteChannelSequentialBase {
    private volatile Job attachedJob;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialJVM(ChunkBuffer initial, boolean z) {
        super(initial, z, null, 4, null);
        Intrinsics.checkNotNullParameter(initial, "initial");
    }

    @Override // io.ktor.utils.io.ByteChannel
    @Deprecated(message = DeprecationKt.IO_DEPRECATION_MESSAGE)
    public void attachJob(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.attachedJob = job;
        Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.ByteChannelSequentialJVM$attachJob$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ByteChannelSequentialJVM.this.attachedJob = null;
                if (th != null) {
                    ByteChannelSequentialJVM.this.cancel(ExceptionUtilsKt.unwrapCancellationException(th));
                }
            }
        }, 2, null);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        int tryWriteAvailable = tryWriteAvailable(byteBuffer);
        if (tryWriteAvailable <= 0) {
            if (byteBuffer.hasRemaining()) {
                return writeAvailableSuspend(byteBuffer, continuation);
            }
            tryWriteAvailable = 0;
        }
        return Boxing.boxInt(tryWriteAvailable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeAvailableSuspend(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        ByteChannelSequentialJVM$writeAvailableSuspend$1 byteChannelSequentialJVM$writeAvailableSuspend$1;
        int i;
        ByteChannelSequentialJVM byteChannelSequentialJVM;
        if (continuation instanceof ByteChannelSequentialJVM$writeAvailableSuspend$1) {
            byteChannelSequentialJVM$writeAvailableSuspend$1 = (ByteChannelSequentialJVM$writeAvailableSuspend$1) continuation;
            if ((byteChannelSequentialJVM$writeAvailableSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialJVM$writeAvailableSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialJVM$writeAvailableSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialJVM$writeAvailableSuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialJVM$writeAvailableSuspend$1.L$0 = this;
                    byteChannelSequentialJVM$writeAvailableSuspend$1.L$1 = byteBuffer;
                    byteChannelSequentialJVM$writeAvailableSuspend$1.label = 1;
                    if (awaitAtLeastNBytesAvailableForWrite$ktor_io(1, byteChannelSequentialJVM$writeAvailableSuspend$1) != coroutine_suspended) {
                        byteChannelSequentialJVM = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                byteBuffer = (ByteBuffer) byteChannelSequentialJVM$writeAvailableSuspend$1.L$1;
                byteChannelSequentialJVM = (ByteChannelSequentialJVM) byteChannelSequentialJVM$writeAvailableSuspend$1.L$0;
                ResultKt.throwOnFailure(obj);
                byteChannelSequentialJVM$writeAvailableSuspend$1.L$0 = null;
                byteChannelSequentialJVM$writeAvailableSuspend$1.L$1 = null;
                byteChannelSequentialJVM$writeAvailableSuspend$1.label = 2;
                Object writeAvailable = byteChannelSequentialJVM.writeAvailable(byteBuffer, byteChannelSequentialJVM$writeAvailableSuspend$1);
                return writeAvailable != coroutine_suspended ? coroutine_suspended : writeAvailable;
            }
        }
        byteChannelSequentialJVM$writeAvailableSuspend$1 = new ByteChannelSequentialJVM$writeAvailableSuspend$1(this, continuation);
        Object obj2 = byteChannelSequentialJVM$writeAvailableSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialJVM$writeAvailableSuspend$1.label;
        if (i != 0) {
        }
        byteChannelSequentialJVM$writeAvailableSuspend$1.L$0 = null;
        byteChannelSequentialJVM$writeAvailableSuspend$1.L$1 = null;
        byteChannelSequentialJVM$writeAvailableSuspend$1.label = 2;
        Object writeAvailable2 = byteChannelSequentialJVM.writeAvailable(byteBuffer, byteChannelSequentialJVM$writeAvailableSuspend$1);
        if (writeAvailable2 != coroutine_suspended2) {
        }
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFully(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        Object writeFullySuspend;
        tryWriteAvailable(byteBuffer);
        return (byteBuffer.hasRemaining() && (writeFullySuspend = writeFullySuspend(byteBuffer, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? writeFullySuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004e -> B:10:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeFullySuspend(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        ByteChannelSequentialJVM$writeFullySuspend$1 byteChannelSequentialJVM$writeFullySuspend$1;
        int i;
        ByteChannelSequentialJVM byteChannelSequentialJVM;
        if (continuation instanceof ByteChannelSequentialJVM$writeFullySuspend$1) {
            byteChannelSequentialJVM$writeFullySuspend$1 = (ByteChannelSequentialJVM$writeFullySuspend$1) continuation;
            if ((byteChannelSequentialJVM$writeFullySuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialJVM$writeFullySuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialJVM$writeFullySuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialJVM$writeFullySuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialJVM = this;
                    if (byteBuffer.hasRemaining()) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteBuffer = (ByteBuffer) byteChannelSequentialJVM$writeFullySuspend$1.L$1;
                    byteChannelSequentialJVM = (ByteChannelSequentialJVM) byteChannelSequentialJVM$writeFullySuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialJVM.afterWrite(byteChannelSequentialJVM.tryWriteAvailable(byteBuffer));
                    if (byteBuffer.hasRemaining()) {
                        byteChannelSequentialJVM$writeFullySuspend$1.L$0 = byteChannelSequentialJVM;
                        byteChannelSequentialJVM$writeFullySuspend$1.L$1 = byteBuffer;
                        byteChannelSequentialJVM$writeFullySuspend$1.label = 1;
                        if (byteChannelSequentialJVM.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, byteChannelSequentialJVM$writeFullySuspend$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        byteChannelSequentialJVM.afterWrite(byteChannelSequentialJVM.tryWriteAvailable(byteBuffer));
                        if (byteBuffer.hasRemaining()) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        byteChannelSequentialJVM$writeFullySuspend$1 = new ByteChannelSequentialJVM$writeFullySuspend$1(this, continuation);
        Object obj2 = byteChannelSequentialJVM$writeFullySuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialJVM$writeFullySuspend$1.label;
        if (i != 0) {
        }
    }

    private final int tryWriteAvailable(ByteBuffer src) {
        int remaining = src.remaining();
        int availableForWrite = getAvailableForWrite();
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause == null) {
                throw new ClosedSendChannelException("Channel closed for write");
            }
            throw closedCause;
        }
        if (remaining != 0) {
            if (remaining <= availableForWrite) {
                OutputArraysJVMKt.writeFully(getWritable(), src);
            } else if (availableForWrite != 0) {
                int limit = src.limit();
                src.limit(src.position() + availableForWrite);
                OutputArraysJVMKt.writeFully(getWritable(), src);
                src.limit(limit);
                remaining = availableForWrite;
            }
            afterWrite(remaining);
            return remaining;
        }
        remaining = 0;
        afterWrite(remaining);
        return remaining;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        int tryReadAvailable = tryReadAvailable(byteBuffer);
        if (tryReadAvailable != 0) {
            return Boxing.boxInt(tryReadAvailable);
        }
        return !byteBuffer.hasRemaining() ? Boxing.boxInt(0) : readAvailableSuspend(byteBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public int readAvailable(int min, Function1<? super ByteBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (get_availableForRead() < min) {
            return -1;
        }
        prepareFlushedBytes();
        ByteReadPacket readable = getReadable();
        ChunkBuffer prepareRead = readable.prepareRead(min);
        if (prepareRead == null) {
            StringsKt.prematureEndOfStream(min);
            throw new KotlinNothingValueException();
        }
        int readPosition = prepareRead.getReadPosition();
        try {
            ChunkBuffer chunkBuffer = prepareRead;
            ByteBuffer memory = chunkBuffer.getMemory();
            int readPosition2 = chunkBuffer.getReadPosition();
            int writePosition = chunkBuffer.getWritePosition() - readPosition2;
            ByteBuffer m9976slice87lwejk = Memory.m9976slice87lwejk(memory, readPosition2, writePosition);
            int position = m9976slice87lwejk.position();
            block.invoke(m9976slice87lwejk);
            int position2 = m9976slice87lwejk.position() - position;
            if (m9976slice87lwejk.limit() != writePosition) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            chunkBuffer.discardExact(m9976slice87lwejk.position());
            int readPosition3 = prepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == prepareRead.getWritePosition()) {
                readable.ensureNext(prepareRead);
                return position2;
            }
            readable.setHeadPosition(readPosition3);
            return position2;
        } catch (Throwable th) {
            int readPosition4 = prepareRead.getReadPosition();
            if (readPosition4 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition4 == prepareRead.getWritePosition()) {
                readable.ensureNext(prepareRead);
            } else {
                readable.setHeadPosition(readPosition4);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readAvailableSuspend(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        ByteChannelSequentialJVM$readAvailableSuspend$1 byteChannelSequentialJVM$readAvailableSuspend$1;
        Object obj;
        int i;
        ByteChannelSequentialJVM byteChannelSequentialJVM;
        if (continuation instanceof ByteChannelSequentialJVM$readAvailableSuspend$1) {
            byteChannelSequentialJVM$readAvailableSuspend$1 = (ByteChannelSequentialJVM$readAvailableSuspend$1) continuation;
            if ((byteChannelSequentialJVM$readAvailableSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialJVM$readAvailableSuspend$1.label -= Integer.MIN_VALUE;
                obj = byteChannelSequentialJVM$readAvailableSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialJVM$readAvailableSuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialJVM$readAvailableSuspend$1.L$0 = this;
                    byteChannelSequentialJVM$readAvailableSuspend$1.L$1 = byteBuffer;
                    byteChannelSequentialJVM$readAvailableSuspend$1.label = 1;
                    obj = await(1, byteChannelSequentialJVM$readAvailableSuspend$1);
                    if (obj != coroutine_suspended) {
                        byteChannelSequentialJVM = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                byteBuffer = (ByteBuffer) byteChannelSequentialJVM$readAvailableSuspend$1.L$1;
                byteChannelSequentialJVM = (ByteChannelSequentialJVM) byteChannelSequentialJVM$readAvailableSuspend$1.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    return Boxing.boxInt(-1);
                }
                byteChannelSequentialJVM$readAvailableSuspend$1.L$0 = null;
                byteChannelSequentialJVM$readAvailableSuspend$1.L$1 = null;
                byteChannelSequentialJVM$readAvailableSuspend$1.label = 2;
                Object readAvailable = byteChannelSequentialJVM.readAvailable(byteBuffer, byteChannelSequentialJVM$readAvailableSuspend$1);
                return readAvailable == coroutine_suspended ? coroutine_suspended : readAvailable;
            }
        }
        byteChannelSequentialJVM$readAvailableSuspend$1 = new ByteChannelSequentialJVM$readAvailableSuspend$1(this, continuation);
        obj = byteChannelSequentialJVM$readAvailableSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialJVM$readAvailableSuspend$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFully(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        int tryReadAvailable = tryReadAvailable(byteBuffer);
        if (tryReadAvailable != -1) {
            return !byteBuffer.hasRemaining() ? Boxing.boxInt(tryReadAvailable) : readFullySuspend(byteBuffer, tryReadAvailable, continuation);
        }
        throw new EOFException("Channel closed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0055 -> B:10:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readFullySuspend(ByteBuffer byteBuffer, int i, Continuation<? super Integer> continuation) {
        ByteChannelSequentialJVM$readFullySuspend$1 byteChannelSequentialJVM$readFullySuspend$1;
        int i2;
        ByteChannelSequentialJVM byteChannelSequentialJVM;
        if (continuation instanceof ByteChannelSequentialJVM$readFullySuspend$1) {
            byteChannelSequentialJVM$readFullySuspend$1 = (ByteChannelSequentialJVM$readFullySuspend$1) continuation;
            if ((byteChannelSequentialJVM$readFullySuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialJVM$readFullySuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialJVM$readFullySuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteChannelSequentialJVM$readFullySuspend$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialJVM = this;
                    if (!byteBuffer.hasRemaining()) {
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = byteChannelSequentialJVM$readFullySuspend$1.I$0;
                    ByteBuffer byteBuffer2 = (ByteBuffer) byteChannelSequentialJVM$readFullySuspend$1.L$1;
                    byteChannelSequentialJVM = (ByteChannelSequentialJVM) byteChannelSequentialJVM$readFullySuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i = i3;
                    byteBuffer = byteBuffer2;
                    if (!((Boolean) obj).booleanValue()) {
                        throw new EOFException("Channel closed");
                    }
                    int tryReadAvailable = byteChannelSequentialJVM.tryReadAvailable(byteBuffer);
                    if (tryReadAvailable != -1) {
                        i += tryReadAvailable;
                        if (!byteBuffer.hasRemaining()) {
                            byteChannelSequentialJVM$readFullySuspend$1.L$0 = byteChannelSequentialJVM;
                            byteChannelSequentialJVM$readFullySuspend$1.L$1 = byteBuffer;
                            byteChannelSequentialJVM$readFullySuspend$1.I$0 = i;
                            byteChannelSequentialJVM$readFullySuspend$1.label = 1;
                            obj = byteChannelSequentialJVM.await(1, byteChannelSequentialJVM$readFullySuspend$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (!((Boolean) obj).booleanValue()) {
                            }
                        } else {
                            return Boxing.boxInt(i);
                        }
                    } else {
                        throw new EOFException("Channel closed");
                    }
                }
            }
        }
        byteChannelSequentialJVM$readFullySuspend$1 = new ByteChannelSequentialJVM$readFullySuspend$1(this, continuation);
        Object obj2 = byteChannelSequentialJVM$readFullySuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteChannelSequentialJVM$readFullySuspend$1.label;
        if (i2 != 0) {
        }
    }

    private final int tryReadAvailable(ByteBuffer dst) {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (getClosed() && get_availableForRead() == 0) {
            return -1;
        }
        if (!getReadable().canRead()) {
            prepareFlushedBytes();
        }
        int readAvailable = ByteBuffersKt.readAvailable(getReadable(), dst);
        afterRead(readAvailable);
        return readAvailable;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read { } instead.")
    public <R> R lookAhead(Function1<? super LookAheadSession, ? extends R> visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        return visitor.invoke(new Session(this));
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read { } instead.")
    public <R> Object lookAheadSuspend(Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return function2.invoke(new Session(this), continuation);
    }

    /* compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialJVM$Session;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "channel", "Lio/ktor/utils/io/ByteChannelSequentialJVM;", "(Lio/ktor/utils/io/ByteChannelSequentialJVM;)V", "awaitAtLeast", "", D5.q, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumed", "", AdActivity.REQUEST_KEY_EXTRA, "Ljava/nio/ByteBuffer;", "skip", "atLeast", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Session implements LookAheadSuspendSession {
        private final ByteChannelSequentialJVM channel;

        public Session(ByteChannelSequentialJVM channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
        }

        @Override // io.ktor.utils.io.LookAheadSuspendSession
        public Object awaitAtLeast(int i, Continuation<? super Boolean> continuation) {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            return this.channel.await(i, continuation);
        }

        @Override // io.ktor.utils.io.LookAheadSession
        /* renamed from: consumed */
        public void mo10232consumed(int n) {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            this.channel.discard(n);
        }

        @Override // io.ktor.utils.io.LookAheadSession
        public ByteBuffer request(int skip, int atLeast) {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            if (this.channel.isClosedForRead()) {
                return null;
            }
            if (this.channel.getReadable().getEndOfInput()) {
                this.channel.prepareFlushedBytes();
            }
            ChunkBuffer head = this.channel.getReadable().getHead();
            ChunkBuffer chunkBuffer = head;
            if (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition() < atLeast + skip) {
                return null;
            }
            ByteBuffer slice = head.getMemory().slice();
            slice.position(head.getReadPosition() + skip);
            slice.limit(head.getWritePosition());
            return slice;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object read(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        ByteChannelSequentialJVM$read$1 byteChannelSequentialJVM$read$1;
        Object obj;
        int i2;
        ByteChannelSequentialJVM byteChannelSequentialJVM;
        if (continuation instanceof ByteChannelSequentialJVM$read$1) {
            byteChannelSequentialJVM$read$1 = (ByteChannelSequentialJVM$read$1) continuation;
            if ((byteChannelSequentialJVM$read$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialJVM$read$1.label -= Integer.MIN_VALUE;
                obj = byteChannelSequentialJVM$read$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = byteChannelSequentialJVM$read$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (i < 0) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    byteChannelSequentialJVM$read$1.L$0 = this;
                    byteChannelSequentialJVM$read$1.L$1 = function1;
                    byteChannelSequentialJVM$read$1.I$0 = i;
                    byteChannelSequentialJVM$read$1.label = 1;
                    obj = await(i, byteChannelSequentialJVM$read$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteChannelSequentialJVM = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = byteChannelSequentialJVM$read$1.I$0;
                    function1 = (Function1) byteChannelSequentialJVM$read$1.L$1;
                    byteChannelSequentialJVM = (ByteChannelSequentialJVM) byteChannelSequentialJVM$read$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    throw new EOFException("Channel closed while " + i + " bytes expected");
                }
                ByteReadPacket readable = byteChannelSequentialJVM.getReadable();
                ChunkBuffer prepareRead = readable.prepareRead(i);
                if (prepareRead == null) {
                    StringsKt.prematureEndOfStream(i);
                    throw new KotlinNothingValueException();
                }
                int readPosition = prepareRead.getReadPosition();
                try {
                    ChunkBuffer chunkBuffer = prepareRead;
                    ByteBuffer memory = chunkBuffer.getMemory();
                    int readPosition2 = chunkBuffer.getReadPosition();
                    int writePosition = chunkBuffer.getWritePosition() - readPosition2;
                    ByteBuffer m9976slice87lwejk = Memory.m9976slice87lwejk(memory, readPosition2, writePosition);
                    function1.invoke(m9976slice87lwejk);
                    if (m9976slice87lwejk.limit() != writePosition) {
                        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                    }
                    chunkBuffer.discardExact(m9976slice87lwejk.position());
                    int readPosition3 = prepareRead.getReadPosition();
                    if (readPosition3 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition3 == prepareRead.getWritePosition()) {
                        readable.ensureNext(prepareRead);
                    } else {
                        readable.setHeadPosition(readPosition3);
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    int readPosition4 = prepareRead.getReadPosition();
                    if (readPosition4 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition4 == prepareRead.getWritePosition()) {
                        readable.ensureNext(prepareRead);
                    } else {
                        readable.setHeadPosition(readPosition4);
                    }
                    throw th;
                }
            }
        }
        byteChannelSequentialJVM$read$1 = new ByteChannelSequentialJVM$read$1(this, continuation);
        obj = byteChannelSequentialJVM$read$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteChannelSequentialJVM$read$1.label;
        if (i2 != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    @Override // io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteReadChannel
    public Object awaitContent(Continuation<? super Unit> continuation) {
        Object await = await(1, continuation);
        return await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? await : Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public int writeAvailable(int min, Function1<? super ByteBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause == null) {
                throw new ClosedSendChannelException("Channel closed for write");
            }
            throw closedCause;
        }
        if (getAvailableForWrite() < min) {
            return 0;
        }
        BytePacketBuilder writable = getWritable();
        try {
            ChunkBuffer prepareWriteHead = writable.prepareWriteHead(min);
            ByteBuffer memory = prepareWriteHead.getMemory();
            int writePosition = prepareWriteHead.getWritePosition();
            int limit = prepareWriteHead.getLimit() - writePosition;
            ByteBuffer m9976slice87lwejk = Memory.m9976slice87lwejk(memory, writePosition, limit);
            int position = m9976slice87lwejk.position();
            block.invoke(m9976slice87lwejk);
            int position2 = m9976slice87lwejk.position() - position;
            if (m9976slice87lwejk.limit() != limit) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            int position3 = m9976slice87lwejk.position();
            prepareWriteHead.commitWritten(position3);
            if (position3 >= 0) {
                return position2;
            }
            throw new IllegalStateException("The returned value shouldn't be negative".toString());
        } finally {
            writable.afterHeadWrite();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008b A[Catch: all -> 0x00b5, TRY_LEAVE, TryCatch #0 {all -> 0x00b5, blocks: (B:12:0x006f, B:14:0x008b, B:19:0x009d, B:20:0x00a8, B:21:0x00a9, B:22:0x00b4), top: B:11:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a9 A[Catch: all -> 0x00b5, TryCatch #0 {all -> 0x00b5, blocks: (B:12:0x006f, B:14:0x008b, B:19:0x009d, B:20:0x00a8, B:21:0x00a9, B:22:0x00b4), top: B:11:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object write(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        ByteChannelSequentialJVM$write$1 byteChannelSequentialJVM$write$1;
        int i2;
        ByteChannelSequentialJVM byteChannelSequentialJVM;
        BytePacketBuilder writable;
        int limit;
        ByteBuffer m9976slice87lwejk;
        try {
            if (continuation instanceof ByteChannelSequentialJVM$write$1) {
                byteChannelSequentialJVM$write$1 = (ByteChannelSequentialJVM$write$1) continuation;
                if ((byteChannelSequentialJVM$write$1.label & Integer.MIN_VALUE) != 0) {
                    byteChannelSequentialJVM$write$1.label -= Integer.MIN_VALUE;
                    Object obj = byteChannelSequentialJVM$write$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = byteChannelSequentialJVM$write$1.label;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (getClosed()) {
                            Throwable closedCause = getClosedCause();
                            if (closedCause == null) {
                                throw new ClosedSendChannelException("Channel closed for write");
                            }
                            throw closedCause;
                        }
                        byteChannelSequentialJVM$write$1.L$0 = this;
                        byteChannelSequentialJVM$write$1.L$1 = function1;
                        byteChannelSequentialJVM$write$1.I$0 = i;
                        byteChannelSequentialJVM$write$1.label = 1;
                        if (awaitAtLeastNBytesAvailableForWrite$ktor_io(i, byteChannelSequentialJVM$write$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        byteChannelSequentialJVM = this;
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i = byteChannelSequentialJVM$write$1.I$0;
                        function1 = (Function1) byteChannelSequentialJVM$write$1.L$1;
                        byteChannelSequentialJVM = (ByteChannelSequentialJVM) byteChannelSequentialJVM$write$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    writable = byteChannelSequentialJVM.getWritable();
                    ChunkBuffer prepareWriteHead = writable.prepareWriteHead(i);
                    ByteBuffer memory = prepareWriteHead.getMemory();
                    int writePosition = prepareWriteHead.getWritePosition();
                    limit = prepareWriteHead.getLimit() - writePosition;
                    m9976slice87lwejk = Memory.m9976slice87lwejk(memory, writePosition, limit);
                    function1.invoke(m9976slice87lwejk);
                    if (m9976slice87lwejk.limit() == limit) {
                        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                    }
                    int position = m9976slice87lwejk.position();
                    prepareWriteHead.commitWritten(position);
                    if (position < 0) {
                        throw new IllegalStateException("The returned value shouldn't be negative".toString());
                    }
                    writable.afterHeadWrite();
                    byteChannelSequentialJVM.afterWrite(position);
                    return Unit.INSTANCE;
                }
            }
            ChunkBuffer prepareWriteHead2 = writable.prepareWriteHead(i);
            ByteBuffer memory2 = prepareWriteHead2.getMemory();
            int writePosition2 = prepareWriteHead2.getWritePosition();
            limit = prepareWriteHead2.getLimit() - writePosition2;
            m9976slice87lwejk = Memory.m9976slice87lwejk(memory2, writePosition2, limit);
            function1.invoke(m9976slice87lwejk);
            if (m9976slice87lwejk.limit() == limit) {
            }
        } catch (Throwable th) {
            writable.afterHeadWrite();
            throw th;
        }
        byteChannelSequentialJVM$write$1 = new ByteChannelSequentialJVM$write$1(this, continuation);
        Object obj2 = byteChannelSequentialJVM$write$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = byteChannelSequentialJVM$write$1.label;
        if (i2 != 0) {
        }
        writable = byteChannelSequentialJVM.getWritable();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009d A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #0 {all -> 0x00cd, blocks: (B:12:0x0078, B:14:0x009d, B:33:0x00b5, B:34:0x00c0, B:35:0x00c1, B:36:0x00cc), top: B:11:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1 A[Catch: all -> 0x00cd, TryCatch #0 {all -> 0x00cd, blocks: (B:12:0x0078, B:14:0x009d, B:33:0x00b5, B:34:0x00c0, B:35:0x00c1, B:36:0x00cc), top: B:11:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x006c -> B:10:0x006e). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeWhile(Function1<? super ByteBuffer, Boolean> function1, Continuation<? super Unit> continuation) {
        ByteChannelSequentialJVM$writeWhile$1 byteChannelSequentialJVM$writeWhile$1;
        int i;
        ByteChannelSequentialJVM byteChannelSequentialJVM;
        if (continuation instanceof ByteChannelSequentialJVM$writeWhile$1) {
            byteChannelSequentialJVM$writeWhile$1 = (ByteChannelSequentialJVM$writeWhile$1) continuation;
            if ((byteChannelSequentialJVM$writeWhile$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialJVM$writeWhile$1.label -= Integer.MIN_VALUE;
                Object obj = byteChannelSequentialJVM$writeWhile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelSequentialJVM$writeWhile$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelSequentialJVM = this;
                    if (!byteChannelSequentialJVM.getClosed()) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.BooleanRef booleanRef = (Ref.BooleanRef) byteChannelSequentialJVM$writeWhile$1.L$2;
                    Function1<? super ByteBuffer, Boolean> function12 = (Function1) byteChannelSequentialJVM$writeWhile$1.L$1;
                    byteChannelSequentialJVM = (ByteChannelSequentialJVM) byteChannelSequentialJVM$writeWhile$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    BytePacketBuilder writable = byteChannelSequentialJVM.getWritable();
                    try {
                        ChunkBuffer prepareWriteHead = writable.prepareWriteHead(1);
                        ByteBuffer memory = prepareWriteHead.getMemory();
                        int writePosition = prepareWriteHead.getWritePosition();
                        int limit = prepareWriteHead.getLimit() - writePosition;
                        ByteBuffer m9976slice87lwejk = Memory.m9976slice87lwejk(memory, writePosition, limit);
                        booleanRef.element = function12.invoke(m9976slice87lwejk).booleanValue();
                        if (m9976slice87lwejk.limit() != limit) {
                            int position = m9976slice87lwejk.position();
                            prepareWriteHead.commitWritten(position);
                            if (position < 0) {
                                throw new IllegalStateException("The returned value shouldn't be negative".toString());
                            }
                            writable.afterHeadWrite();
                            byteChannelSequentialJVM.afterWrite(position);
                            if (booleanRef.element) {
                                function1 = function12;
                                if (!byteChannelSequentialJVM.getClosed()) {
                                    Throwable closedCause = byteChannelSequentialJVM.getClosedCause();
                                    if (closedCause == null) {
                                        throw new ClosedSendChannelException("Channel closed for write");
                                    }
                                    throw closedCause;
                                }
                                Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                                byteChannelSequentialJVM$writeWhile$1.L$0 = byteChannelSequentialJVM;
                                byteChannelSequentialJVM$writeWhile$1.L$1 = function1;
                                byteChannelSequentialJVM$writeWhile$1.L$2 = booleanRef2;
                                byteChannelSequentialJVM$writeWhile$1.label = 1;
                                if (byteChannelSequentialJVM.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, byteChannelSequentialJVM$writeWhile$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                function12 = function1;
                                booleanRef = booleanRef2;
                                BytePacketBuilder writable2 = byteChannelSequentialJVM.getWritable();
                                ChunkBuffer prepareWriteHead2 = writable2.prepareWriteHead(1);
                                ByteBuffer memory2 = prepareWriteHead2.getMemory();
                                int writePosition2 = prepareWriteHead2.getWritePosition();
                                int limit2 = prepareWriteHead2.getLimit() - writePosition2;
                                ByteBuffer m9976slice87lwejk2 = Memory.m9976slice87lwejk(memory2, writePosition2, limit2);
                                booleanRef.element = function12.invoke(m9976slice87lwejk2).booleanValue();
                                if (m9976slice87lwejk2.limit() != limit2) {
                                    throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                                }
                            } else {
                                return Unit.INSTANCE;
                            }
                        }
                    } catch (Throwable th) {
                        writable2.afterHeadWrite();
                        throw th;
                    }
                }
            }
        }
        byteChannelSequentialJVM$writeWhile$1 = new ByteChannelSequentialJVM$writeWhile$1(this, continuation);
        Object obj2 = byteChannelSequentialJVM$writeWhile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelSequentialJVM$writeWhile$1.label;
        if (i != 0) {
        }
    }
}
