package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;

/* compiled from: WriterSession.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a#\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a%\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0006H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001ao\u0010\u0012\u001a\u00020\u0006*\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00060\u0014H\u0086Hø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u0004*\u00020\nH\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"writeBufferFallback", "Lio/ktor/utils/io/core/Buffer;", "writeBufferSuspend", "session", "Lio/ktor/utils/io/WriterSuspendSession;", "desiredSpace", "", "(Lio/ktor/utils/io/WriterSuspendSession;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeWriting", "", "Lio/ktor/utils/io/ByteWriteChannel;", "buffer", "written", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeWritingFallback", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestWriteBuffer", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "block", "Lkotlin/Function3;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", "freeSpace", "", "startOffset", "endExclusive", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeSessionFor", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WriterSessionKt {
    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(2:3|(11:5|6|(1:(1:(1:(2:11|12)(2:14|15))(2:16|17))(1:18))(1:36)|19|(1:21)|22|23|24|25|(2:27|28)|29))|38|6|(0)(0)|19|(0)|22|23|24|25|(0)|29) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a9, code lost:
    
        r0.L$0 = r11;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
    
        if (completeWriting(r9, r12, r2, r0) != r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
    
        throw r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005f, code lost:
    
        if (r12 == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object write(ByteWriteChannel byteWriteChannel, int i, Function3<? super Memory, ? super Long, ? super Long, Integer> function3, Continuation<? super Integer> continuation) {
        WriterSessionKt$write$1 writerSessionKt$write$1;
        Object coroutine_suspended;
        int i2;
        Buffer buffer;
        int i3;
        if (continuation instanceof WriterSessionKt$write$1) {
            writerSessionKt$write$1 = (WriterSessionKt$write$1) continuation;
            if ((writerSessionKt$write$1.label & Integer.MIN_VALUE) != 0) {
                writerSessionKt$write$1.label -= Integer.MIN_VALUE;
                Object obj = writerSessionKt$write$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = writerSessionKt$write$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    writerSessionKt$write$1.L$0 = byteWriteChannel;
                    writerSessionKt$write$1.L$1 = function3;
                    writerSessionKt$write$1.label = 1;
                    obj = requestWriteBuffer(byteWriteChannel, i, writerSessionKt$write$1);
                } else {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            Integer num = (Integer) writerSessionKt$write$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            return num;
                        }
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Throwable th = (Throwable) writerSessionKt$write$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        throw th;
                    }
                    function3 = (Function3) writerSessionKt$write$1.L$1;
                    byteWriteChannel = (ByteWriteChannel) writerSessionKt$write$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                buffer = (Buffer) obj;
                if (buffer == null) {
                    buffer = Buffer.INSTANCE.getEmpty();
                }
                i3 = 0;
                i3 = function3.invoke(Memory.m9965boximpl(buffer.getMemory()), Boxing.boxLong(buffer.getWritePosition()), Boxing.boxLong(buffer.getLimit())).intValue();
                buffer.commitWritten(i3);
                Integer boxInt = Boxing.boxInt(i3);
                writerSessionKt$write$1.L$0 = boxInt;
                writerSessionKt$write$1.L$1 = null;
                writerSessionKt$write$1.label = 2;
                if (completeWriting(byteWriteChannel, buffer, i3, writerSessionKt$write$1) != coroutine_suspended) {
                    return boxInt;
                }
                return coroutine_suspended;
            }
        }
        writerSessionKt$write$1 = new WriterSessionKt$write$1(continuation);
        Object obj2 = writerSessionKt$write$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = writerSessionKt$write$1.label;
        if (i2 != 0) {
        }
        buffer = (Buffer) obj2;
        if (buffer == null) {
        }
        i3 = 0;
        i3 = function3.invoke(Memory.m9965boximpl(buffer.getMemory()), Boxing.boxLong(buffer.getWritePosition()), Boxing.boxLong(buffer.getLimit())).intValue();
        buffer.commitWritten(i3);
        Integer boxInt2 = Boxing.boxInt(i3);
        writerSessionKt$write$1.L$0 = boxInt2;
        writerSessionKt$write$1.L$1 = null;
        writerSessionKt$write$1.label = 2;
        if (completeWriting(byteWriteChannel, buffer, i3, writerSessionKt$write$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    private static final Object write$$forInline(ByteWriteChannel byteWriteChannel, int i, Function3<? super Memory, ? super Long, ? super Long, Integer> function3, Continuation<? super Integer> continuation) {
        Buffer buffer = (Buffer) requestWriteBuffer(byteWriteChannel, i, continuation);
        if (buffer == null) {
            buffer = Buffer.INSTANCE.getEmpty();
        }
        int i2 = 0;
        try {
            i2 = function3.invoke(Memory.m9965boximpl(buffer.getMemory()), Long.valueOf(buffer.getWritePosition()), Long.valueOf(buffer.getLimit())).intValue();
            buffer.commitWritten(i2);
            return Integer.valueOf(i2);
        } finally {
            completeWriting(byteWriteChannel, buffer, i2, continuation);
        }
    }

    public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function3 function3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        Buffer buffer = (Buffer) requestWriteBuffer(byteWriteChannel, i, continuation);
        if (buffer == null) {
            buffer = Buffer.INSTANCE.getEmpty();
        }
        int i3 = 0;
        try {
            i3 = ((Number) function3.invoke(Memory.m9965boximpl(buffer.getMemory()), Long.valueOf(buffer.getWritePosition()), Long.valueOf(buffer.getLimit()))).intValue();
            buffer.commitWritten(i3);
            return Integer.valueOf(i3);
        } finally {
            completeWriting(byteWriteChannel, buffer, i3, continuation);
        }
    }

    public static final Object requestWriteBuffer(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Buffer> continuation) {
        WriterSuspendSession writeSessionFor = writeSessionFor(byteWriteChannel);
        if (writeSessionFor != null) {
            ChunkBuffer request = writeSessionFor.request(i);
            return request != null ? request : writeBufferSuspend(writeSessionFor, i, continuation);
        }
        return writeBufferFallback();
    }

    public static final Object completeWriting(ByteWriteChannel byteWriteChannel, Buffer buffer, int i, Continuation<? super Unit> continuation) {
        if (byteWriteChannel instanceof HasWriteSession) {
            ((HasWriteSession) byteWriteChannel).endWriteSession(i);
            return Unit.INSTANCE;
        }
        Object completeWritingFallback = completeWritingFallback(byteWriteChannel, buffer, continuation);
        return completeWritingFallback == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? completeWritingFallback : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object completeWritingFallback(ByteWriteChannel byteWriteChannel, Buffer buffer, Continuation<? super Unit> continuation) {
        WriterSessionKt$completeWritingFallback$1 writerSessionKt$completeWritingFallback$1;
        int i;
        if (continuation instanceof WriterSessionKt$completeWritingFallback$1) {
            writerSessionKt$completeWritingFallback$1 = (WriterSessionKt$completeWritingFallback$1) continuation;
            if ((writerSessionKt$completeWritingFallback$1.label & Integer.MIN_VALUE) != 0) {
                writerSessionKt$completeWritingFallback$1.label -= Integer.MIN_VALUE;
                Object obj = writerSessionKt$completeWritingFallback$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = writerSessionKt$completeWritingFallback$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (buffer instanceof ChunkBuffer) {
                        writerSessionKt$completeWritingFallback$1.L$0 = buffer;
                        writerSessionKt$completeWritingFallback$1.label = 1;
                        if (byteWriteChannel.writeFully(buffer, writerSessionKt$completeWritingFallback$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw new UnsupportedOperationException("Only ChunkBuffer instance is supported.");
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    buffer = (Buffer) writerSessionKt$completeWritingFallback$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ((ChunkBuffer) buffer).release(ChunkBuffer.INSTANCE.getPool());
                return Unit.INSTANCE;
            }
        }
        writerSessionKt$completeWritingFallback$1 = new WriterSessionKt$completeWritingFallback$1(continuation);
        Object obj2 = writerSessionKt$completeWritingFallback$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = writerSessionKt$completeWritingFallback$1.label;
        if (i != 0) {
        }
        ((ChunkBuffer) buffer).release(ChunkBuffer.INSTANCE.getPool());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeBufferSuspend(WriterSuspendSession writerSuspendSession, int i, Continuation<? super Buffer> continuation) {
        WriterSessionKt$writeBufferSuspend$1 writerSessionKt$writeBufferSuspend$1;
        int i2;
        if (continuation instanceof WriterSessionKt$writeBufferSuspend$1) {
            writerSessionKt$writeBufferSuspend$1 = (WriterSessionKt$writeBufferSuspend$1) continuation;
            if ((writerSessionKt$writeBufferSuspend$1.label & Integer.MIN_VALUE) != 0) {
                writerSessionKt$writeBufferSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = writerSessionKt$writeBufferSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = writerSessionKt$writeBufferSuspend$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    writerSessionKt$writeBufferSuspend$1.L$0 = writerSuspendSession;
                    writerSessionKt$writeBufferSuspend$1.I$0 = i;
                    writerSessionKt$writeBufferSuspend$1.label = 1;
                    if (writerSuspendSession.tryAwait(i, writerSessionKt$writeBufferSuspend$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = writerSessionKt$writeBufferSuspend$1.I$0;
                    writerSuspendSession = (WriterSuspendSession) writerSessionKt$writeBufferSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ChunkBuffer request = writerSuspendSession.request(i);
                return request == null ? request : writerSuspendSession.request(1);
            }
        }
        writerSessionKt$writeBufferSuspend$1 = new WriterSessionKt$writeBufferSuspend$1(continuation);
        Object obj2 = writerSessionKt$writeBufferSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = writerSessionKt$writeBufferSuspend$1.label;
        if (i2 != 0) {
        }
        ChunkBuffer request2 = writerSuspendSession.request(i);
        if (request2 == null) {
        }
    }

    private static final Buffer writeBufferFallback() {
        ChunkBuffer borrow = ChunkBuffer.INSTANCE.getPool().borrow();
        ChunkBuffer chunkBuffer = borrow;
        chunkBuffer.resetForWrite();
        chunkBuffer.reserveEndGap(8);
        return borrow;
    }

    private static final WriterSuspendSession writeSessionFor(ByteWriteChannel byteWriteChannel) {
        if (byteWriteChannel instanceof HasWriteSession) {
            return ((HasWriteSession) byteWriteChannel).beginWriteSession();
        }
        return null;
    }
}
