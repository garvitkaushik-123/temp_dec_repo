package io.ktor.utils.io;

import com.ironsource.D5;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteReadChannel.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a'\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001d\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u001d\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001d\u0010\u0015\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a!\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"cancel", "", "Lio/ktor/utils/io/ByteReadChannel;", "copyAndClose", "", "dst", "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discard", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discardExact", "", D5.q, "(Lio/ktor/utils/io/ByteReadChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", "", "", "(Lio/ktor/utils/io/ByteReadChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFully", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRemaining", "Lio/ktor/utils/io/core/ByteReadPacket;", "readUTF8Line", "", "readUTF8LineTo", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ByteReadChannelKt {
    public static final Object readRemaining(ByteReadChannel byteReadChannel, Continuation<? super ByteReadPacket> continuation) {
        return byteReadChannel.readRemaining(Long.MAX_VALUE, continuation);
    }

    public static final Object readFully(ByteReadChannel byteReadChannel, ChunkBuffer chunkBuffer, Continuation<? super Unit> continuation) {
        ChunkBuffer chunkBuffer2 = chunkBuffer;
        Object readFully = byteReadChannel.readFully(chunkBuffer, chunkBuffer2.getLimit() - chunkBuffer2.getWritePosition(), continuation);
        return readFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFully : Unit.INSTANCE;
    }

    public static final Object readUTF8LineTo(ByteReadChannel byteReadChannel, Appendable appendable, Continuation<? super Boolean> continuation) {
        return byteReadChannel.readUTF8LineTo(appendable, Integer.MAX_VALUE, continuation);
    }

    public static final Object readUTF8Line(ByteReadChannel byteReadChannel, Continuation<? super String> continuation) {
        return byteReadChannel.readUTF8Line(Integer.MAX_VALUE, continuation);
    }

    public static final boolean cancel(ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        return byteReadChannel.cancel(null);
    }

    public static final Object discard(ByteReadChannel byteReadChannel, Continuation<? super Long> continuation) {
        return byteReadChannel.discard(Long.MAX_VALUE, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object discardExact(ByteReadChannel byteReadChannel, long j, Continuation<? super Unit> continuation) {
        ByteReadChannelKt$discardExact$1 byteReadChannelKt$discardExact$1;
        Object obj;
        int i;
        if (continuation instanceof ByteReadChannelKt$discardExact$1) {
            byteReadChannelKt$discardExact$1 = (ByteReadChannelKt$discardExact$1) continuation;
            if ((byteReadChannelKt$discardExact$1.label & Integer.MIN_VALUE) != 0) {
                byteReadChannelKt$discardExact$1.label -= Integer.MIN_VALUE;
                obj = byteReadChannelKt$discardExact$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteReadChannelKt$discardExact$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteReadChannelKt$discardExact$1.J$0 = j;
                    byteReadChannelKt$discardExact$1.label = 1;
                    obj = byteReadChannel.discard(j, byteReadChannelKt$discardExact$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = byteReadChannelKt$discardExact$1.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (((Number) obj).longValue() == j) {
                    throw new EOFException("Unable to discard " + j + " bytes");
                }
                return Unit.INSTANCE;
            }
        }
        byteReadChannelKt$discardExact$1 = new ByteReadChannelKt$discardExact$1(continuation);
        obj = byteReadChannelKt$discardExact$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteReadChannelKt$discardExact$1.label;
        if (i != 0) {
        }
        if (((Number) obj).longValue() == j) {
        }
    }

    private static final Object discardExact$$forInline(ByteReadChannel byteReadChannel, long j, Continuation<? super Unit> continuation) {
        if (((Number) byteReadChannel.discard(j, continuation)).longValue() != j) {
            throw new EOFException("Unable to discard " + j + " bytes");
        }
        return Unit.INSTANCE;
    }

    public static final Object readAvailable(ByteReadChannel byteReadChannel, byte[] bArr, Continuation<? super Integer> continuation) {
        return byteReadChannel.readAvailable(bArr, 0, bArr.length, continuation);
    }

    public static final Object readFully(ByteReadChannel byteReadChannel, byte[] bArr, Continuation<? super Unit> continuation) {
        Object readFully = byteReadChannel.readFully(bArr, 0, bArr.length, continuation);
        return readFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFully : Unit.INSTANCE;
    }

    public static final Object copyTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, Continuation<? super Long> continuation) {
        return ByteReadChannelJVMKt.copyTo(byteReadChannel, byteWriteChannel, Long.MAX_VALUE, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyAndClose(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        ByteReadChannelKt$copyAndClose$1 byteReadChannelKt$copyAndClose$1;
        int i;
        if (continuation instanceof ByteReadChannelKt$copyAndClose$1) {
            byteReadChannelKt$copyAndClose$1 = (ByteReadChannelKt$copyAndClose$1) continuation;
            if ((byteReadChannelKt$copyAndClose$1.label & Integer.MIN_VALUE) != 0) {
                byteReadChannelKt$copyAndClose$1.label -= Integer.MIN_VALUE;
                Object obj = byteReadChannelKt$copyAndClose$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteReadChannelKt$copyAndClose$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteReadChannelKt$copyAndClose$1.L$0 = byteWriteChannel;
                    byteReadChannelKt$copyAndClose$1.label = 1;
                    obj = ByteReadChannelJVMKt.copyTo(byteReadChannel, byteWriteChannel, j, byteReadChannelKt$copyAndClose$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteWriteChannel = (ByteWriteChannel) byteReadChannelKt$copyAndClose$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                long longValue = ((Number) obj).longValue();
                ByteWriteChannelKt.close(byteWriteChannel);
                return Boxing.boxLong(longValue);
            }
        }
        byteReadChannelKt$copyAndClose$1 = new ByteReadChannelKt$copyAndClose$1(continuation);
        Object obj2 = byteReadChannelKt$copyAndClose$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteReadChannelKt$copyAndClose$1.label;
        if (i != 0) {
        }
        long longValue2 = ((Number) obj2).longValue();
        ByteWriteChannelKt.close(byteWriteChannel);
        return Boxing.boxLong(longValue2);
    }

    public static /* synthetic */ Object copyAndClose$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyAndClose(byteReadChannel, byteWriteChannel, j, continuation);
    }
}
