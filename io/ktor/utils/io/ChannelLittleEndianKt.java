package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteOrder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChannelLittleEndian.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\n\u001a\u00020\t*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\r\u001a\u00020\f*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0013\u001a\u00020\u0012*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a<\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u0002H\u00152\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\u0081\bø\u0001\u0001¢\u0006\u0002\u0010\u0019\u001a<\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u00020\u00022\u0006\u0010\u001b\u001a\u0002H\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\u0081\bø\u0001\u0001¢\u0006\u0002\u0010\u001c\u001a9\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u00020\u001d2\u0006\u0010\u001b\u001a\u0002H\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\u0082\b¢\u0006\u0002\u0010\u001e\u001a%\u0010\u001f\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010#\u001a%\u0010$\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%\u001a\u001d\u0010&\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a%\u0010(\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010)\u001a\u001d\u0010*\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+\u001a%\u0010,\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\u001d\u0010.\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a%\u00100\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u00101\u001a\u001d\u00102\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u00103\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u00064"}, d2 = {"readDouble", "", "Lio/ktor/utils/io/ByteReadChannel;", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readDoubleLittleEndian", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFloat", "", "readFloatLittleEndian", "readInt", "", "readIntLittleEndian", "readLong", "", "readLongLittleEndian", "readShort", "", "readShortLittleEndian", "reverseIfNeeded", "T", "reverseBlock", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lio/ktor/utils/io/core/ByteOrder;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toLittleEndian", "value", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeDouble", "", "(Lio/ktor/utils/io/ByteWriteChannel;DLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeDoubleLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFloat", "(Lio/ktor/utils/io/ByteWriteChannel;FLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFloatLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeInt", "(Lio/ktor/utils/io/ByteWriteChannel;ILio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeIntLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLong", "(Lio/ktor/utils/io/ByteWriteChannel;JLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLongLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShort", "(Lio/ktor/utils/io/ByteWriteChannel;SLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShortLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ChannelLittleEndianKt {

    /* compiled from: ChannelLittleEndian.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ByteOrder.values().length];
            try {
                iArr[ByteOrder.BIG_ENDIAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readShort(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Short> continuation) {
        ChannelLittleEndianKt$readShort$1 channelLittleEndianKt$readShort$1;
        int i;
        if (continuation instanceof ChannelLittleEndianKt$readShort$1) {
            channelLittleEndianKt$readShort$1 = (ChannelLittleEndianKt$readShort$1) continuation;
            if ((channelLittleEndianKt$readShort$1.label & Integer.MIN_VALUE) != 0) {
                channelLittleEndianKt$readShort$1.label -= Integer.MIN_VALUE;
                Object obj = channelLittleEndianKt$readShort$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelLittleEndianKt$readShort$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    channelLittleEndianKt$readShort$1.L$0 = byteOrder;
                    channelLittleEndianKt$readShort$1.label = 1;
                    obj = byteReadChannel.readShort(channelLittleEndianKt$readShort$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteOrder = (ByteOrder) channelLittleEndianKt$readShort$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1 ? obj : Boxing.boxShort(Short.reverseBytes(((Number) obj).shortValue()));
            }
        }
        channelLittleEndianKt$readShort$1 = new ChannelLittleEndianKt$readShort$1(continuation);
        Object obj2 = channelLittleEndianKt$readShort$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelLittleEndianKt$readShort$1.label;
        if (i != 0) {
        }
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
        }
    }

    private static final Object readShort$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Short> continuation) {
        Object readShort = byteReadChannel.readShort(continuation);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? readShort : Short.valueOf(Short.reverseBytes(((Number) readShort).shortValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readInt(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Integer> continuation) {
        ChannelLittleEndianKt$readInt$1 channelLittleEndianKt$readInt$1;
        int i;
        if (continuation instanceof ChannelLittleEndianKt$readInt$1) {
            channelLittleEndianKt$readInt$1 = (ChannelLittleEndianKt$readInt$1) continuation;
            if ((channelLittleEndianKt$readInt$1.label & Integer.MIN_VALUE) != 0) {
                channelLittleEndianKt$readInt$1.label -= Integer.MIN_VALUE;
                Object obj = channelLittleEndianKt$readInt$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelLittleEndianKt$readInt$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    channelLittleEndianKt$readInt$1.L$0 = byteOrder;
                    channelLittleEndianKt$readInt$1.label = 1;
                    obj = byteReadChannel.readInt(channelLittleEndianKt$readInt$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteOrder = (ByteOrder) channelLittleEndianKt$readInt$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1 ? obj : Boxing.boxInt(Integer.reverseBytes(((Number) obj).intValue()));
            }
        }
        channelLittleEndianKt$readInt$1 = new ChannelLittleEndianKt$readInt$1(continuation);
        Object obj2 = channelLittleEndianKt$readInt$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelLittleEndianKt$readInt$1.label;
        if (i != 0) {
        }
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
        }
    }

    private static final Object readInt$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Integer> continuation) {
        Object readInt = byteReadChannel.readInt(continuation);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? readInt : Integer.valueOf(Integer.reverseBytes(((Number) readInt).intValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readLong(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Long> continuation) {
        ChannelLittleEndianKt$readLong$1 channelLittleEndianKt$readLong$1;
        int i;
        if (continuation instanceof ChannelLittleEndianKt$readLong$1) {
            channelLittleEndianKt$readLong$1 = (ChannelLittleEndianKt$readLong$1) continuation;
            if ((channelLittleEndianKt$readLong$1.label & Integer.MIN_VALUE) != 0) {
                channelLittleEndianKt$readLong$1.label -= Integer.MIN_VALUE;
                Object obj = channelLittleEndianKt$readLong$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelLittleEndianKt$readLong$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    channelLittleEndianKt$readLong$1.L$0 = byteOrder;
                    channelLittleEndianKt$readLong$1.label = 1;
                    obj = byteReadChannel.readLong(channelLittleEndianKt$readLong$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteOrder = (ByteOrder) channelLittleEndianKt$readLong$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1 ? obj : Boxing.boxLong(Long.reverseBytes(((Number) obj).longValue()));
            }
        }
        channelLittleEndianKt$readLong$1 = new ChannelLittleEndianKt$readLong$1(continuation);
        Object obj2 = channelLittleEndianKt$readLong$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelLittleEndianKt$readLong$1.label;
        if (i != 0) {
        }
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
        }
    }

    private static final Object readLong$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Long> continuation) {
        Object readLong = byteReadChannel.readLong(continuation);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? readLong : Long.valueOf(Long.reverseBytes(((Number) readLong).longValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readFloat(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Float> continuation) {
        ChannelLittleEndianKt$readFloat$1 channelLittleEndianKt$readFloat$1;
        int i;
        if (continuation instanceof ChannelLittleEndianKt$readFloat$1) {
            channelLittleEndianKt$readFloat$1 = (ChannelLittleEndianKt$readFloat$1) continuation;
            if ((channelLittleEndianKt$readFloat$1.label & Integer.MIN_VALUE) != 0) {
                channelLittleEndianKt$readFloat$1.label -= Integer.MIN_VALUE;
                Object obj = channelLittleEndianKt$readFloat$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelLittleEndianKt$readFloat$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    channelLittleEndianKt$readFloat$1.L$0 = byteOrder;
                    channelLittleEndianKt$readFloat$1.label = 1;
                    obj = byteReadChannel.readFloat(channelLittleEndianKt$readFloat$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteOrder = (ByteOrder) channelLittleEndianKt$readFloat$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1 ? obj : Boxing.boxFloat(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) obj).floatValue()))));
            }
        }
        channelLittleEndianKt$readFloat$1 = new ChannelLittleEndianKt$readFloat$1(continuation);
        Object obj2 = channelLittleEndianKt$readFloat$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelLittleEndianKt$readFloat$1.label;
        if (i != 0) {
        }
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
        }
    }

    private static final Object readFloat$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Float> continuation) {
        Object readFloat = byteReadChannel.readFloat(continuation);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? readFloat : Float.valueOf(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) readFloat).floatValue()))));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readDouble(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Double> continuation) {
        ChannelLittleEndianKt$readDouble$1 channelLittleEndianKt$readDouble$1;
        int i;
        if (continuation instanceof ChannelLittleEndianKt$readDouble$1) {
            channelLittleEndianKt$readDouble$1 = (ChannelLittleEndianKt$readDouble$1) continuation;
            if ((channelLittleEndianKt$readDouble$1.label & Integer.MIN_VALUE) != 0) {
                channelLittleEndianKt$readDouble$1.label -= Integer.MIN_VALUE;
                Object obj = channelLittleEndianKt$readDouble$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelLittleEndianKt$readDouble$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    channelLittleEndianKt$readDouble$1.L$0 = byteOrder;
                    channelLittleEndianKt$readDouble$1.label = 1;
                    obj = byteReadChannel.readDouble(channelLittleEndianKt$readDouble$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteOrder = (ByteOrder) channelLittleEndianKt$readDouble$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1 ? obj : Boxing.boxDouble(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) obj).doubleValue()))));
            }
        }
        channelLittleEndianKt$readDouble$1 = new ChannelLittleEndianKt$readDouble$1(continuation);
        Object obj2 = channelLittleEndianKt$readDouble$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelLittleEndianKt$readDouble$1.label;
        if (i != 0) {
        }
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
        }
    }

    private static final Object readDouble$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Double> continuation) {
        Object readDouble = byteReadChannel.readDouble(continuation);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? readDouble : Double.valueOf(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) readDouble).doubleValue()))));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readShortLittleEndian(ByteReadChannel byteReadChannel, Continuation<? super Short> continuation) {
        ChannelLittleEndianKt$readShortLittleEndian$1 channelLittleEndianKt$readShortLittleEndian$1;
        int i;
        if (continuation instanceof ChannelLittleEndianKt$readShortLittleEndian$1) {
            channelLittleEndianKt$readShortLittleEndian$1 = (ChannelLittleEndianKt$readShortLittleEndian$1) continuation;
            if ((channelLittleEndianKt$readShortLittleEndian$1.label & Integer.MIN_VALUE) != 0) {
                channelLittleEndianKt$readShortLittleEndian$1.label -= Integer.MIN_VALUE;
                Object obj = channelLittleEndianKt$readShortLittleEndian$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelLittleEndianKt$readShortLittleEndian$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    channelLittleEndianKt$readShortLittleEndian$1.label = 1;
                    obj = byteReadChannel.readShort(channelLittleEndianKt$readShortLittleEndian$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxShort(Short.reverseBytes(((Number) obj).shortValue()));
            }
        }
        channelLittleEndianKt$readShortLittleEndian$1 = new ChannelLittleEndianKt$readShortLittleEndian$1(continuation);
        Object obj2 = channelLittleEndianKt$readShortLittleEndian$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelLittleEndianKt$readShortLittleEndian$1.label;
        if (i != 0) {
        }
        return Boxing.boxShort(Short.reverseBytes(((Number) obj2).shortValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readIntLittleEndian(ByteReadChannel byteReadChannel, Continuation<? super Integer> continuation) {
        ChannelLittleEndianKt$readIntLittleEndian$1 channelLittleEndianKt$readIntLittleEndian$1;
        int i;
        if (continuation instanceof ChannelLittleEndianKt$readIntLittleEndian$1) {
            channelLittleEndianKt$readIntLittleEndian$1 = (ChannelLittleEndianKt$readIntLittleEndian$1) continuation;
            if ((channelLittleEndianKt$readIntLittleEndian$1.label & Integer.MIN_VALUE) != 0) {
                channelLittleEndianKt$readIntLittleEndian$1.label -= Integer.MIN_VALUE;
                Object obj = channelLittleEndianKt$readIntLittleEndian$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelLittleEndianKt$readIntLittleEndian$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    channelLittleEndianKt$readIntLittleEndian$1.label = 1;
                    obj = byteReadChannel.readInt(channelLittleEndianKt$readIntLittleEndian$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxInt(Integer.reverseBytes(((Number) obj).intValue()));
            }
        }
        channelLittleEndianKt$readIntLittleEndian$1 = new ChannelLittleEndianKt$readIntLittleEndian$1(continuation);
        Object obj2 = channelLittleEndianKt$readIntLittleEndian$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelLittleEndianKt$readIntLittleEndian$1.label;
        if (i != 0) {
        }
        return Boxing.boxInt(Integer.reverseBytes(((Number) obj2).intValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readLongLittleEndian(ByteReadChannel byteReadChannel, Continuation<? super Long> continuation) {
        ChannelLittleEndianKt$readLongLittleEndian$1 channelLittleEndianKt$readLongLittleEndian$1;
        int i;
        if (continuation instanceof ChannelLittleEndianKt$readLongLittleEndian$1) {
            channelLittleEndianKt$readLongLittleEndian$1 = (ChannelLittleEndianKt$readLongLittleEndian$1) continuation;
            if ((channelLittleEndianKt$readLongLittleEndian$1.label & Integer.MIN_VALUE) != 0) {
                channelLittleEndianKt$readLongLittleEndian$1.label -= Integer.MIN_VALUE;
                Object obj = channelLittleEndianKt$readLongLittleEndian$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelLittleEndianKt$readLongLittleEndian$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    channelLittleEndianKt$readLongLittleEndian$1.label = 1;
                    obj = byteReadChannel.readLong(channelLittleEndianKt$readLongLittleEndian$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxLong(Long.reverseBytes(((Number) obj).longValue()));
            }
        }
        channelLittleEndianKt$readLongLittleEndian$1 = new ChannelLittleEndianKt$readLongLittleEndian$1(continuation);
        Object obj2 = channelLittleEndianKt$readLongLittleEndian$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelLittleEndianKt$readLongLittleEndian$1.label;
        if (i != 0) {
        }
        return Boxing.boxLong(Long.reverseBytes(((Number) obj2).longValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readFloatLittleEndian(ByteReadChannel byteReadChannel, Continuation<? super Float> continuation) {
        ChannelLittleEndianKt$readFloatLittleEndian$1 channelLittleEndianKt$readFloatLittleEndian$1;
        int i;
        if (continuation instanceof ChannelLittleEndianKt$readFloatLittleEndian$1) {
            channelLittleEndianKt$readFloatLittleEndian$1 = (ChannelLittleEndianKt$readFloatLittleEndian$1) continuation;
            if ((channelLittleEndianKt$readFloatLittleEndian$1.label & Integer.MIN_VALUE) != 0) {
                channelLittleEndianKt$readFloatLittleEndian$1.label -= Integer.MIN_VALUE;
                Object obj = channelLittleEndianKt$readFloatLittleEndian$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelLittleEndianKt$readFloatLittleEndian$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    channelLittleEndianKt$readFloatLittleEndian$1.label = 1;
                    obj = byteReadChannel.readFloat(channelLittleEndianKt$readFloatLittleEndian$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxFloat(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) obj).floatValue()))));
            }
        }
        channelLittleEndianKt$readFloatLittleEndian$1 = new ChannelLittleEndianKt$readFloatLittleEndian$1(continuation);
        Object obj2 = channelLittleEndianKt$readFloatLittleEndian$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelLittleEndianKt$readFloatLittleEndian$1.label;
        if (i != 0) {
        }
        return Boxing.boxFloat(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) obj2).floatValue()))));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readDoubleLittleEndian(ByteReadChannel byteReadChannel, Continuation<? super Double> continuation) {
        ChannelLittleEndianKt$readDoubleLittleEndian$1 channelLittleEndianKt$readDoubleLittleEndian$1;
        int i;
        if (continuation instanceof ChannelLittleEndianKt$readDoubleLittleEndian$1) {
            channelLittleEndianKt$readDoubleLittleEndian$1 = (ChannelLittleEndianKt$readDoubleLittleEndian$1) continuation;
            if ((channelLittleEndianKt$readDoubleLittleEndian$1.label & Integer.MIN_VALUE) != 0) {
                channelLittleEndianKt$readDoubleLittleEndian$1.label -= Integer.MIN_VALUE;
                Object obj = channelLittleEndianKt$readDoubleLittleEndian$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelLittleEndianKt$readDoubleLittleEndian$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    channelLittleEndianKt$readDoubleLittleEndian$1.label = 1;
                    obj = byteReadChannel.readDouble(channelLittleEndianKt$readDoubleLittleEndian$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxDouble(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) obj).doubleValue()))));
            }
        }
        channelLittleEndianKt$readDoubleLittleEndian$1 = new ChannelLittleEndianKt$readDoubleLittleEndian$1(continuation);
        Object obj2 = channelLittleEndianKt$readDoubleLittleEndian$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelLittleEndianKt$readDoubleLittleEndian$1.label;
        if (i != 0) {
        }
        return Boxing.boxDouble(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) obj2).doubleValue()))));
    }

    public static final <T> T toLittleEndian(ByteReadChannel byteReadChannel, T t, Function1<? super T, ? extends T> reverseBlock) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(reverseBlock, "reverseBlock");
        return reverseBlock.invoke(t);
    }

    private static final <T> T toLittleEndian(ByteWriteChannel byteWriteChannel, T t, Function1<? super T, ? extends T> function1) {
        return function1.invoke(t);
    }

    public static final <T> T reverseIfNeeded(T t, ByteOrder byteOrder, Function1<? super T, ? extends T> reverseBlock) {
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        Intrinsics.checkNotNullParameter(reverseBlock, "reverseBlock");
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1 ? t : reverseBlock.invoke(t);
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, short s, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            s = Short.reverseBytes(s);
        }
        Object writeShort = byteWriteChannel.writeShort(s, continuation);
        return writeShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeShort : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, int i, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            i = Integer.reverseBytes(i);
        }
        Object writeInt = byteWriteChannel.writeInt(i, continuation);
        return writeInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeInt : Unit.INSTANCE;
    }

    public static final Object writeLong(ByteWriteChannel byteWriteChannel, long j, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            j = Long.reverseBytes(j);
        }
        Object writeLong = byteWriteChannel.writeLong(j, continuation);
        return writeLong == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeLong : Unit.INSTANCE;
    }

    public static final Object writeFloat(ByteWriteChannel byteWriteChannel, float f, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            f = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f)));
        }
        Object writeFloat = byteWriteChannel.writeFloat(f, continuation);
        return writeFloat == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFloat : Unit.INSTANCE;
    }

    public static final Object writeDouble(ByteWriteChannel byteWriteChannel, double d, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            d = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d)));
        }
        Object writeDouble = byteWriteChannel.writeDouble(d, continuation);
        return writeDouble == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeDouble : Unit.INSTANCE;
    }

    public static final Object writeShortLittleEndian(ByteWriteChannel byteWriteChannel, short s, Continuation<? super Unit> continuation) {
        Object writeShort = byteWriteChannel.writeShort(Short.reverseBytes(s), continuation);
        return writeShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeShort : Unit.INSTANCE;
    }

    public static final Object writeIntLittleEndian(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        Object writeInt = byteWriteChannel.writeInt(Integer.reverseBytes(i), continuation);
        return writeInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeInt : Unit.INSTANCE;
    }

    public static final Object writeLongLittleEndian(ByteWriteChannel byteWriteChannel, long j, Continuation<? super Unit> continuation) {
        Object writeLong = byteWriteChannel.writeLong(Long.reverseBytes(j), continuation);
        return writeLong == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeLong : Unit.INSTANCE;
    }

    public static final Object writeFloatLittleEndian(ByteWriteChannel byteWriteChannel, float f, Continuation<? super Unit> continuation) {
        Object writeFloat = byteWriteChannel.writeFloat(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f))), continuation);
        return writeFloat == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFloat : Unit.INSTANCE;
    }

    public static final Object writeDoubleLittleEndian(ByteWriteChannel byteWriteChannel, double d, Continuation<? super Unit> continuation) {
        Object writeDouble = byteWriteChannel.writeDouble(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d))), continuation);
        return writeDouble == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeDouble : Unit.INSTANCE;
    }
}
