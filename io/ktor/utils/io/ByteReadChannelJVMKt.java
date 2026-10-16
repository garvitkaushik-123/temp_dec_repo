package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.internal.SequentialCopyToKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* compiled from: ByteReadChannelJVM.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a%\u0010\r\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"copyTo", "", "Lio/ktor/utils/io/ByteReadChannel;", "dst", "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyToImpl", "joinTo", "", "closeOnEnd", "", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinToImplSuspend", "close", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ByteReadChannelJVMKt {
    public static final Object joinTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, boolean z, Continuation<? super Unit> continuation) {
        if (byteWriteChannel == byteReadChannel) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if ((byteReadChannel instanceof ByteBufferChannel) && (byteWriteChannel instanceof ByteBufferChannel)) {
            Object joinFrom$ktor_io = ((ByteBufferChannel) byteWriteChannel).joinFrom$ktor_io((ByteBufferChannel) byteReadChannel, z, continuation);
            return joinFrom$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? joinFrom$ktor_io : Unit.INSTANCE;
        }
        Object joinToImplSuspend = joinToImplSuspend(byteReadChannel, byteWriteChannel, z, continuation);
        return joinToImplSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? joinToImplSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object joinToImplSuspend(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, boolean z, Continuation<? super Unit> continuation) {
        ByteReadChannelJVMKt$joinToImplSuspend$1 byteReadChannelJVMKt$joinToImplSuspend$1;
        int i;
        if (continuation instanceof ByteReadChannelJVMKt$joinToImplSuspend$1) {
            byteReadChannelJVMKt$joinToImplSuspend$1 = (ByteReadChannelJVMKt$joinToImplSuspend$1) continuation;
            if ((byteReadChannelJVMKt$joinToImplSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteReadChannelJVMKt$joinToImplSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteReadChannelJVMKt$joinToImplSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteReadChannelJVMKt$joinToImplSuspend$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteReadChannelJVMKt$joinToImplSuspend$1.L$0 = byteWriteChannel;
                    byteReadChannelJVMKt$joinToImplSuspend$1.Z$0 = z;
                    byteReadChannelJVMKt$joinToImplSuspend$1.label = 1;
                    if (copyTo(byteReadChannel, byteWriteChannel, Long.MAX_VALUE, byteReadChannelJVMKt$joinToImplSuspend$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z = byteReadChannelJVMKt$joinToImplSuspend$1.Z$0;
                    byteWriteChannel = (ByteWriteChannel) byteReadChannelJVMKt$joinToImplSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (!z) {
                    ByteWriteChannelKt.close(byteWriteChannel);
                } else {
                    byteWriteChannel.flush();
                }
                return Unit.INSTANCE;
            }
        }
        byteReadChannelJVMKt$joinToImplSuspend$1 = new ByteReadChannelJVMKt$joinToImplSuspend$1(continuation);
        Object obj2 = byteReadChannelJVMKt$joinToImplSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteReadChannelJVMKt$joinToImplSuspend$1.label;
        if (i != 0) {
        }
        if (!z) {
        }
        return Unit.INSTANCE;
    }

    public static final Object copyTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        if (byteReadChannel == byteWriteChannel) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (j == 0) {
            return Boxing.boxLong(0L);
        }
        if ((byteReadChannel instanceof ByteBufferChannel) && (byteWriteChannel instanceof ByteBufferChannel)) {
            return ((ByteBufferChannel) byteWriteChannel).copyDirect$ktor_io((ByteBufferChannel) byteReadChannel, j, null, continuation);
        }
        if ((byteReadChannel instanceof ByteChannelSequentialBase) && (byteWriteChannel instanceof ByteChannelSequentialBase)) {
            return SequentialCopyToKt.copyToSequentialImpl((ByteChannelSequentialBase) byteReadChannel, (ByteChannelSequentialBase) byteWriteChannel, Long.MAX_VALUE, continuation);
        }
        return copyToImpl(byteReadChannel, byteWriteChannel, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0090 A[Catch: all -> 0x00f4, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00f4, blocks: (B:37:0x00ea, B:39:0x00f0, B:20:0x0090), top: B:36:0x00ea }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c5 A[Catch: all -> 0x0069, TRY_LEAVE, TryCatch #2 {all -> 0x0069, blocks: (B:12:0x0041, B:23:0x00bc, B:25:0x00c5, B:29:0x0103, B:53:0x0065), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00df -> B:14:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyToImpl(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        ByteReadChannelJVMKt$copyToImpl$1 byteReadChannelJVMKt$copyToImpl$1;
        int i;
        ByteWriteChannel byteWriteChannel2;
        ChunkBuffer chunkBuffer;
        long j2;
        ?? r10;
        long j3;
        ByteReadChannel byteReadChannel2;
        ByteReadChannelJVMKt$copyToImpl$1 byteReadChannelJVMKt$copyToImpl$12;
        ByteWriteChannel byteWriteChannel3;
        ByteReadChannel byteReadChannel3;
        long j4;
        long j5;
        int i2;
        int intValue;
        long j6;
        try {
            if (continuation instanceof ByteReadChannelJVMKt$copyToImpl$1) {
                byteReadChannelJVMKt$copyToImpl$1 = (ByteReadChannelJVMKt$copyToImpl$1) continuation;
                if ((byteReadChannelJVMKt$copyToImpl$1.label & Integer.MIN_VALUE) != 0) {
                    byteReadChannelJVMKt$copyToImpl$1.label -= Integer.MIN_VALUE;
                    Object obj = byteReadChannelJVMKt$copyToImpl$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = byteReadChannelJVMKt$copyToImpl$1.label;
                    long j7 = 0;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        j2 = j;
                        chunkBuffer = ChunkBuffer.INSTANCE.getPool().borrow();
                        r10 = !byteWriteChannel.getAutoFlush();
                        j3 = 0;
                        byteReadChannel2 = byteReadChannel;
                        byteReadChannelJVMKt$copyToImpl$12 = byteReadChannelJVMKt$copyToImpl$1;
                        byteWriteChannel3 = byteWriteChannel;
                        j6 = j2 - j3;
                        if (j6 != j7) {
                        }
                    } else if (i == 1) {
                        j5 = byteReadChannelJVMKt$copyToImpl$1.J$1;
                        i2 = byteReadChannelJVMKt$copyToImpl$1.I$0;
                        j4 = byteReadChannelJVMKt$copyToImpl$1.J$0;
                        chunkBuffer = (ChunkBuffer) byteReadChannelJVMKt$copyToImpl$1.L$2;
                        byteWriteChannel2 = (ByteWriteChannel) byteReadChannelJVMKt$copyToImpl$1.L$1;
                        byteReadChannel3 = (ByteReadChannel) byteReadChannelJVMKt$copyToImpl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        intValue = ((Number) obj).intValue();
                        if (intValue == -1) {
                        }
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i3 = byteReadChannelJVMKt$copyToImpl$1.I$1;
                        j5 = byteReadChannelJVMKt$copyToImpl$1.J$1;
                        int i4 = byteReadChannelJVMKt$copyToImpl$1.I$0;
                        long j8 = byteReadChannelJVMKt$copyToImpl$1.J$0;
                        chunkBuffer = (ChunkBuffer) byteReadChannelJVMKt$copyToImpl$1.L$2;
                        byteWriteChannel2 = (ByteWriteChannel) byteReadChannelJVMKt$copyToImpl$1.L$1;
                        ByteReadChannel byteReadChannel4 = (ByteReadChannel) byteReadChannelJVMKt$copyToImpl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        byteReadChannel2 = byteReadChannel4;
                        int i5 = i4;
                        ByteReadChannelJVMKt$copyToImpl$1 byteReadChannelJVMKt$copyToImpl$13 = byteReadChannelJVMKt$copyToImpl$1;
                        byteWriteChannel3 = byteWriteChannel2;
                        long j9 = j5 + i3;
                        if (i5 != 0) {
                            try {
                                if (byteReadChannel2.get_availableForRead() == 0) {
                                    byteWriteChannel3.flush();
                                }
                            } catch (Throwable th) {
                                th = th;
                                byteWriteChannel2 = byteWriteChannel3;
                                try {
                                    byteWriteChannel2.close(th);
                                    throw th;
                                } finally {
                                    chunkBuffer.release(ChunkBuffer.INSTANCE.getPool());
                                }
                            }
                        }
                        long j10 = j8;
                        j3 = j9;
                        j2 = j10;
                        byteReadChannelJVMKt$copyToImpl$12 = byteReadChannelJVMKt$copyToImpl$13;
                        j7 = 0;
                        r10 = i5;
                        j6 = j2 - j3;
                        if (j6 != j7) {
                            chunkBuffer.resetForWrite((int) Math.min(chunkBuffer.getCapacity(), j6));
                            byteReadChannelJVMKt$copyToImpl$12.L$0 = byteReadChannel2;
                            byteReadChannelJVMKt$copyToImpl$12.L$1 = byteWriteChannel3;
                            byteReadChannelJVMKt$copyToImpl$12.L$2 = chunkBuffer;
                            byteReadChannelJVMKt$copyToImpl$12.J$0 = j2;
                            byteReadChannelJVMKt$copyToImpl$12.I$0 = r10;
                            byteReadChannelJVMKt$copyToImpl$12.J$1 = j3;
                            byteReadChannelJVMKt$copyToImpl$12.label = 1;
                            Object readAvailable = byteReadChannel2.readAvailable(chunkBuffer, byteReadChannelJVMKt$copyToImpl$12);
                            if (readAvailable != coroutine_suspended) {
                                byteWriteChannel2 = byteWriteChannel3;
                                byteReadChannelJVMKt$copyToImpl$1 = byteReadChannelJVMKt$copyToImpl$12;
                                i2 = r10;
                                byteReadChannel3 = byteReadChannel2;
                                obj = readAvailable;
                                j4 = j2;
                                j5 = j3;
                                intValue = ((Number) obj).intValue();
                                if (intValue == -1) {
                                    byteReadChannelJVMKt$copyToImpl$1.L$0 = byteReadChannel3;
                                    byteReadChannelJVMKt$copyToImpl$1.L$1 = byteWriteChannel2;
                                    byteReadChannelJVMKt$copyToImpl$1.L$2 = chunkBuffer;
                                    byteReadChannelJVMKt$copyToImpl$1.J$0 = j4;
                                    byteReadChannelJVMKt$copyToImpl$1.I$0 = i2;
                                    byteReadChannelJVMKt$copyToImpl$1.J$1 = j5;
                                    byteReadChannelJVMKt$copyToImpl$1.I$1 = intValue;
                                    byteReadChannelJVMKt$copyToImpl$1.label = 2;
                                    if (byteWriteChannel2.writeFully(chunkBuffer, byteReadChannelJVMKt$copyToImpl$1) != coroutine_suspended) {
                                        int i6 = i2;
                                        i3 = intValue;
                                        byteReadChannel2 = byteReadChannel3;
                                        j8 = j4;
                                        i5 = i6;
                                        ByteReadChannelJVMKt$copyToImpl$1 byteReadChannelJVMKt$copyToImpl$132 = byteReadChannelJVMKt$copyToImpl$1;
                                        byteWriteChannel3 = byteWriteChannel2;
                                        long j92 = j5 + i3;
                                        if (i5 != 0) {
                                        }
                                        long j102 = j8;
                                        j3 = j92;
                                        j2 = j102;
                                        byteReadChannelJVMKt$copyToImpl$12 = byteReadChannelJVMKt$copyToImpl$132;
                                        j7 = 0;
                                        r10 = i5;
                                        j6 = j2 - j3;
                                        if (j6 != j7) {
                                            byteWriteChannel2 = byteWriteChannel3;
                                            return Boxing.boxLong(j3);
                                        }
                                    }
                                } else {
                                    j3 = j5;
                                    return Boxing.boxLong(j3);
                                }
                            }
                            return coroutine_suspended;
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        byteReadChannelJVMKt$copyToImpl$1 = new ByteReadChannelJVMKt$copyToImpl$1(continuation);
        Object obj2 = byteReadChannelJVMKt$copyToImpl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteReadChannelJVMKt$copyToImpl$1.label;
        long j72 = 0;
    }
}
