package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* compiled from: ReadSession.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001ao\u0010\b\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00062K\u0010\n\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000bH\u0086Hø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u0002H\u0002\u001a\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001d\u0010\u0018\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001f\u0010\u001a\u001a\u0004\u0018\u00010\u0004*\u00020\u00152\u0006\u0010\t\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"completeReadingFromBuffer", "", "Lio/ktor/utils/io/ByteReadChannel;", "buffer", "Lio/ktor/utils/io/core/Buffer;", "bytesRead", "", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "desiredSize", "block", "Lkotlin/Function3;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", "source", "", "start", "endExclusive", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readSessionFor", "Lio/ktor/utils/io/SuspendableReadSession;", "requestBuffer", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestBufferFallback", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "requestBufferSuspend", "(Lio/ktor/utils/io/SuspendableReadSession;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ReadSessionKt {
    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(2:3|(9:5|6|(1:(1:(1:(2:11|12)(2:14|15))(5:16|17|18|19|20))(1:27))(1:39)|28|(1:30)(1:38)|31|32|(3:34|19|20)|25))|41|6|(0)(0)|28|(0)(0)|31|32|(0)|25) */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b3, code lost:
    
        r10 = r8;
        r8 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0068, code lost:
    
        if (r11 == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object read(ByteReadChannel byteReadChannel, int i, Function3<? super Memory, ? super Long, ? super Long, Integer> function3, Continuation<? super Integer> continuation) {
        ReadSessionKt$read$1 readSessionKt$read$1;
        Object coroutine_suspended;
        int i2;
        Buffer empty;
        ByteReadChannel byteReadChannel2;
        int intValue;
        int i3;
        if (continuation instanceof ReadSessionKt$read$1) {
            readSessionKt$read$1 = (ReadSessionKt$read$1) continuation;
            if ((readSessionKt$read$1.label & Integer.MIN_VALUE) != 0) {
                readSessionKt$read$1.label -= Integer.MIN_VALUE;
                Object obj = readSessionKt$read$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = readSessionKt$read$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    readSessionKt$read$1.L$0 = byteReadChannel;
                    readSessionKt$read$1.L$1 = function3;
                    readSessionKt$read$1.label = 1;
                    obj = requestBuffer(byteReadChannel, i, readSessionKt$read$1);
                } else if (i2 == 1) {
                    function3 = (Function3) readSessionKt$read$1.L$1;
                    byteReadChannel = (ByteReadChannel) readSessionKt$read$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Throwable th = (Throwable) readSessionKt$read$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        throw th;
                    }
                    i3 = readSessionKt$read$1.I$0;
                    empty = (Buffer) readSessionKt$read$1.L$1;
                    byteReadChannel2 = (ByteReadChannel) readSessionKt$read$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return Boxing.boxInt(i3);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        readSessionKt$read$1.L$0 = th3;
                        readSessionKt$read$1.L$1 = null;
                        readSessionKt$read$1.label = 3;
                        if (completeReadingFromBuffer(byteReadChannel2, empty, 0, readSessionKt$read$1) != coroutine_suspended) {
                        }
                    }
                }
                Buffer buffer = (Buffer) obj;
                empty = buffer != null ? Buffer.INSTANCE.getEmpty() : buffer;
                intValue = function3.invoke(Memory.m9965boximpl(empty.getMemory()), Boxing.boxLong(empty.getReadPosition()), Boxing.boxLong(empty.getWritePosition())).intValue();
                readSessionKt$read$1.L$0 = byteReadChannel;
                readSessionKt$read$1.L$1 = empty;
                readSessionKt$read$1.I$0 = intValue;
                readSessionKt$read$1.label = 2;
                if (completeReadingFromBuffer(byteReadChannel, empty, intValue, readSessionKt$read$1) != coroutine_suspended) {
                    byteReadChannel2 = byteReadChannel;
                    i3 = intValue;
                    return Boxing.boxInt(i3);
                }
                return coroutine_suspended;
            }
        }
        readSessionKt$read$1 = new ReadSessionKt$read$1(continuation);
        Object obj2 = readSessionKt$read$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = readSessionKt$read$1.label;
        if (i2 != 0) {
        }
        Buffer buffer2 = (Buffer) obj2;
        if (buffer2 != null) {
        }
        intValue = function3.invoke(Memory.m9965boximpl(empty.getMemory()), Boxing.boxLong(empty.getReadPosition()), Boxing.boxLong(empty.getWritePosition())).intValue();
        readSessionKt$read$1.L$0 = byteReadChannel;
        readSessionKt$read$1.L$1 = empty;
        readSessionKt$read$1.I$0 = intValue;
        readSessionKt$read$1.label = 2;
        if (completeReadingFromBuffer(byteReadChannel, empty, intValue, readSessionKt$read$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    private static final Object read$$forInline(ByteReadChannel byteReadChannel, int i, Function3<? super Memory, ? super Long, ? super Long, Integer> function3, Continuation<? super Integer> continuation) {
        Buffer buffer = (Buffer) requestBuffer(byteReadChannel, i, continuation);
        if (buffer == null) {
            buffer = Buffer.INSTANCE.getEmpty();
        }
        try {
            int intValue = function3.invoke(Memory.m9965boximpl(buffer.getMemory()), Long.valueOf(buffer.getReadPosition()), Long.valueOf(buffer.getWritePosition())).intValue();
            completeReadingFromBuffer(byteReadChannel, buffer, intValue, continuation);
            return Integer.valueOf(intValue);
        } catch (Throwable th) {
            completeReadingFromBuffer(byteReadChannel, buffer, 0, continuation);
            throw th;
        }
    }

    public static /* synthetic */ Object read$default(ByteReadChannel byteReadChannel, int i, Function3 function3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        Buffer buffer = (Buffer) requestBuffer(byteReadChannel, i, continuation);
        if (buffer == null) {
            buffer = Buffer.INSTANCE.getEmpty();
        }
        try {
            int intValue = ((Number) function3.invoke(Memory.m9965boximpl(buffer.getMemory()), Long.valueOf(buffer.getReadPosition()), Long.valueOf(buffer.getWritePosition()))).intValue();
            completeReadingFromBuffer(byteReadChannel, buffer, intValue, continuation);
            return Integer.valueOf(intValue);
        } catch (Throwable th) {
            completeReadingFromBuffer(byteReadChannel, buffer, 0, continuation);
            throw th;
        }
    }

    public static final Object requestBuffer(ByteReadChannel byteReadChannel, int i, Continuation<? super Buffer> continuation) {
        SuspendableReadSession startReadSession;
        if (byteReadChannel instanceof SuspendableReadSession) {
            startReadSession = (SuspendableReadSession) byteReadChannel;
        } else {
            startReadSession = byteReadChannel instanceof HasReadSession ? ((HasReadSession) byteReadChannel).startReadSession() : null;
        }
        if (startReadSession != null) {
            ChunkBuffer request = startReadSession.request(RangesKt.coerceAtMost(i, 8));
            return request != null ? request : requestBufferSuspend(startReadSession, i, continuation);
        }
        return requestBufferFallback(byteReadChannel, i, continuation);
    }

    public static final Object completeReadingFromBuffer(ByteReadChannel byteReadChannel, Buffer buffer, int i, Continuation<? super Unit> continuation) {
        if (i < 0) {
            throw new IllegalStateException(("bytesRead shouldn't be negative: " + i).toString());
        }
        SuspendableReadSession readSessionFor = readSessionFor(byteReadChannel);
        if (readSessionFor != null) {
            readSessionFor.discard(i);
            if (byteReadChannel instanceof HasReadSession) {
                ((HasReadSession) byteReadChannel).endReadSession();
            }
            return Unit.INSTANCE;
        }
        if ((buffer instanceof ChunkBuffer) && buffer != ChunkBuffer.INSTANCE.getEmpty()) {
            ((ChunkBuffer) buffer).release(ChunkBuffer.INSTANCE.getPool());
            Object discard = byteReadChannel.discard(i, continuation);
            return discard == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? discard : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object requestBufferSuspend(SuspendableReadSession suspendableReadSession, int i, Continuation<? super Buffer> continuation) {
        ReadSessionKt$requestBufferSuspend$1 readSessionKt$requestBufferSuspend$1;
        int i2;
        if (continuation instanceof ReadSessionKt$requestBufferSuspend$1) {
            readSessionKt$requestBufferSuspend$1 = (ReadSessionKt$requestBufferSuspend$1) continuation;
            if ((readSessionKt$requestBufferSuspend$1.label & Integer.MIN_VALUE) != 0) {
                readSessionKt$requestBufferSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = readSessionKt$requestBufferSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = readSessionKt$requestBufferSuspend$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    readSessionKt$requestBufferSuspend$1.L$0 = suspendableReadSession;
                    readSessionKt$requestBufferSuspend$1.label = 1;
                    if (suspendableReadSession.await(i, readSessionKt$requestBufferSuspend$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    suspendableReadSession = (SuspendableReadSession) readSessionKt$requestBufferSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return suspendableReadSession.request(1);
            }
        }
        readSessionKt$requestBufferSuspend$1 = new ReadSessionKt$requestBufferSuspend$1(continuation);
        Object obj2 = readSessionKt$requestBufferSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = readSessionKt$requestBufferSuspend$1.label;
        if (i2 != 0) {
        }
        return suspendableReadSession.request(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object requestBufferFallback(ByteReadChannel byteReadChannel, int i, Continuation<? super ChunkBuffer> continuation) {
        ReadSessionKt$requestBufferFallback$1 readSessionKt$requestBufferFallback$1;
        int i2;
        ChunkBuffer chunkBuffer;
        if (continuation instanceof ReadSessionKt$requestBufferFallback$1) {
            readSessionKt$requestBufferFallback$1 = (ReadSessionKt$requestBufferFallback$1) continuation;
            if ((readSessionKt$requestBufferFallback$1.label & Integer.MIN_VALUE) != 0) {
                readSessionKt$requestBufferFallback$1.label -= Integer.MIN_VALUE;
                ReadSessionKt$requestBufferFallback$1 readSessionKt$requestBufferFallback$12 = readSessionKt$requestBufferFallback$1;
                Object obj = readSessionKt$requestBufferFallback$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = readSessionKt$requestBufferFallback$12.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ChunkBuffer borrow = ChunkBuffer.INSTANCE.getPool().borrow();
                    ByteBuffer byteBuffer = borrow.getMemory();
                    long writePosition = borrow.getWritePosition();
                    long j = i;
                    ChunkBuffer chunkBuffer2 = borrow;
                    long limit = chunkBuffer2.getLimit() - chunkBuffer2.getWritePosition();
                    readSessionKt$requestBufferFallback$12.L$0 = borrow;
                    readSessionKt$requestBufferFallback$12.label = 1;
                    Object mo9955peekTolBXzO7A = byteReadChannel.mo9955peekTolBXzO7A(byteBuffer, writePosition, 0L, j, limit, readSessionKt$requestBufferFallback$12);
                    if (mo9955peekTolBXzO7A == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = mo9955peekTolBXzO7A;
                    chunkBuffer = borrow;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    chunkBuffer = (ChunkBuffer) readSessionKt$requestBufferFallback$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                chunkBuffer.commitWritten((int) ((Number) obj).longValue());
                return chunkBuffer;
            }
        }
        readSessionKt$requestBufferFallback$1 = new ReadSessionKt$requestBufferFallback$1(continuation);
        ReadSessionKt$requestBufferFallback$1 readSessionKt$requestBufferFallback$122 = readSessionKt$requestBufferFallback$1;
        Object obj2 = readSessionKt$requestBufferFallback$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = readSessionKt$requestBufferFallback$122.label;
        if (i2 != 0) {
        }
        chunkBuffer.commitWritten((int) ((Number) obj2).longValue());
        return chunkBuffer;
    }

    private static final SuspendableReadSession readSessionFor(ByteReadChannel byteReadChannel) {
        if (byteReadChannel instanceof HasReadSession) {
            return ((HasReadSession) byteReadChannel).startReadSession();
        }
        return null;
    }
}
