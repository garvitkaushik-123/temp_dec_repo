package io.ktor.utils.io;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.ktor.utils.io.core.ByteOrder;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteWriteChannel.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\f\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001d\u0010\u0012\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u0013\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0013\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a.\u0010\u001a\u001a\u00020\t*\u00020\u00022\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t0\u001c¢\u0006\u0002\b\u001eH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a>\u0010 \u001a\u00020\t*\u00020\u00022'\u0010\u001b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\"\u0012\u0006\u0012\u0004\u0018\u00010#0!¢\u0006\u0002\b\u001eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010$\u001a\u001d\u0010%\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a%\u0010%\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a\u001d\u0010(\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020)H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010*\u001a\u001d\u0010(\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020+H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010,\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"close", "", "Lio/ktor/utils/io/ByteWriteChannel;", "writeAvailable", "", "src", "", "(Lio/ktor/utils/io/ByteWriteChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeBoolean", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/ktor/utils/io/ByteWriteChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeByte", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeChar", "ch", "", "(Lio/ktor/utils/io/ByteWriteChannel;CLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "writeInt", "i", "", "(Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "(Lio/ktor/utils/io/ByteWriteChannel;JLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacket", "builder", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacketSuspend", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShort", "s", "(Lio/ktor/utils/io/ByteWriteChannel;ILio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeStringUtf8", "", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/CharSequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ByteWriteChannelKt {
    public static final Object writeAvailable(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation<? super Integer> continuation) {
        return byteWriteChannel.writeAvailable(bArr, 0, bArr.length, continuation);
    }

    public static final Object writeFully(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation<? super Unit> continuation) {
        Object writeFully = byteWriteChannel.writeFully(bArr, 0, bArr.length, continuation);
        return writeFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFully : Unit.INSTANCE;
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        Object writeShort = byteWriteChannel.writeShort((short) (i & 65535), continuation);
        return writeShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeShort : Unit.INSTANCE;
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, int i, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        Object writeShort = ChannelLittleEndianKt.writeShort(byteWriteChannel, (short) (i & 65535), byteOrder, continuation);
        return writeShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeShort : Unit.INSTANCE;
    }

    public static final Object writeByte(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        Object writeByte = byteWriteChannel.writeByte((byte) (i & 255), continuation);
        return writeByte == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeByte : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, long j, Continuation<? super Unit> continuation) {
        Object writeInt = byteWriteChannel.writeInt((int) j, continuation);
        return writeInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeInt : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, long j, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        Object writeInt = ChannelLittleEndianKt.writeInt(byteWriteChannel, (int) j, byteOrder, continuation);
        return writeInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeInt : Unit.INSTANCE;
    }

    public static final boolean close(ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        return byteWriteChannel.close(null);
    }

    public static final Object writeBoolean(ByteWriteChannel byteWriteChannel, boolean z, Continuation<? super Unit> continuation) {
        Object writeByte = byteWriteChannel.writeByte(z ? (byte) 1 : (byte) 0, continuation);
        return writeByte == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeByte : Unit.INSTANCE;
    }

    public static final Object writeChar(ByteWriteChannel byteWriteChannel, char c, Continuation<? super Unit> continuation) {
        Object writeShort = writeShort(byteWriteChannel, c, continuation);
        return writeShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeShort : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
    
        if (r6.writePacket(r7, r0) != r1) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writePacketSuspend(ByteWriteChannel byteWriteChannel, Function2<? super BytePacketBuilder, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        ByteWriteChannelKt$writePacketSuspend$1 byteWriteChannelKt$writePacketSuspend$1;
        int i;
        BytePacketBuilder bytePacketBuilder;
        if (continuation instanceof ByteWriteChannelKt$writePacketSuspend$1) {
            byteWriteChannelKt$writePacketSuspend$1 = (ByteWriteChannelKt$writePacketSuspend$1) continuation;
            if ((byteWriteChannelKt$writePacketSuspend$1.label & Integer.MIN_VALUE) != 0) {
                byteWriteChannelKt$writePacketSuspend$1.label -= Integer.MIN_VALUE;
                Object obj = byteWriteChannelKt$writePacketSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteWriteChannelKt$writePacketSuspend$1.label;
                int i2 = 1;
                ObjectPool objectPool = null;
                Object[] objArr = 0;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    BytePacketBuilder bytePacketBuilder2 = new BytePacketBuilder(objectPool, i2, objArr == true ? 1 : 0);
                    try {
                        byteWriteChannelKt$writePacketSuspend$1.L$0 = bytePacketBuilder2;
                        byteWriteChannelKt$writePacketSuspend$1.L$1 = byteWriteChannel;
                        byteWriteChannelKt$writePacketSuspend$1.label = 1;
                        if (function2.invoke(bytePacketBuilder2, byteWriteChannelKt$writePacketSuspend$1) != coroutine_suspended) {
                            bytePacketBuilder = bytePacketBuilder2;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th) {
                        th = th;
                        bytePacketBuilder = bytePacketBuilder2;
                        bytePacketBuilder.release();
                        throw th;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                byteWriteChannel = (ByteWriteChannel) byteWriteChannelKt$writePacketSuspend$1.L$1;
                bytePacketBuilder = (BytePacketBuilder) byteWriteChannelKt$writePacketSuspend$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th2) {
                    th = th2;
                    bytePacketBuilder.release();
                    throw th;
                }
                ByteReadPacket build = bytePacketBuilder.build();
                byteWriteChannelKt$writePacketSuspend$1.L$0 = null;
                byteWriteChannelKt$writePacketSuspend$1.L$1 = null;
                byteWriteChannelKt$writePacketSuspend$1.label = 2;
            }
        }
        byteWriteChannelKt$writePacketSuspend$1 = new ByteWriteChannelKt$writePacketSuspend$1(continuation);
        Object obj2 = byteWriteChannelKt$writePacketSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteWriteChannelKt$writePacketSuspend$1.label;
        int i22 = 1;
        ObjectPool objectPool2 = null;
        Object[] objArr2 = 0;
        if (i != 0) {
        }
        ByteReadPacket build2 = bytePacketBuilder.build();
        byteWriteChannelKt$writePacketSuspend$1.L$0 = null;
        byteWriteChannelKt$writePacketSuspend$1.L$1 = null;
        byteWriteChannelKt$writePacketSuspend$1.label = 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object writeStringUtf8(ByteWriteChannel byteWriteChannel, CharSequence charSequence, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        try {
            StringsKt.writeText$default(bytePacketBuilder, charSequence, 0, 0, (Charset) null, 14, (Object) null);
            Object writePacket = byteWriteChannel.writePacket(bytePacketBuilder.build(), continuation);
            return writePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object writeStringUtf8(ByteWriteChannel byteWriteChannel, String str, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        try {
            StringsKt.writeText$default(bytePacketBuilder, str, 0, 0, (Charset) null, 14, (Object) null);
            Object writePacket = byteWriteChannel.writePacket(bytePacketBuilder.build(), continuation);
            return writePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object writePacket(ByteWriteChannel byteWriteChannel, Function1<? super BytePacketBuilder, Unit> function1, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        try {
            function1.invoke(bytePacketBuilder);
            Object writePacket = byteWriteChannel.writePacket(bytePacketBuilder.build(), continuation);
            return writePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Object writePacket$$forInline(ByteWriteChannel byteWriteChannel, Function1<? super BytePacketBuilder, Unit> function1, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        try {
            function1.invoke(bytePacketBuilder);
            byteWriteChannel.writePacket(bytePacketBuilder.build(), continuation);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
