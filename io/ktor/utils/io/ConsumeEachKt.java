package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: ConsumeEach.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022:\u0010\u0003\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\u000bH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\f*j\u0010\r\"2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u000422\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"consumeEachBufferRange", "", "Lio/ktor/utils/io/ByteReadChannel;", "visitor", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "", "last", "Lio/ktor/utils/io/ConsumeEachBufferVisitor;", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ConsumeEachBufferVisitor", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ConsumeEachKt {
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8 A[Catch: all -> 0x013f, TryCatch #1 {all -> 0x013f, blocks: (B:37:0x00c6, B:39:0x00d8, B:40:0x00e4, B:42:0x00ee, B:45:0x00f7, B:49:0x00de), top: B:36:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de A[Catch: all -> 0x013f, TryCatch #1 {all -> 0x013f, blocks: (B:37:0x00c6, B:39:0x00d8, B:40:0x00e4, B:42:0x00ee, B:45:0x00f7, B:49:0x00de), top: B:36:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0159 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0126 -> B:20:0x0129). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object consumeEachBufferRange(ByteReadChannel byteReadChannel, Function2<? super ByteBuffer, ? super Boolean, Boolean> function2, Continuation<? super Unit> continuation) {
        ConsumeEachKt$consumeEachBufferRange$1 consumeEachKt$consumeEachBufferRange$1;
        int i;
        ConsumeEachKt$consumeEachBufferRange$1 consumeEachKt$consumeEachBufferRange$12;
        Ref.BooleanRef booleanRef;
        Function2<? super ByteBuffer, ? super Boolean, Boolean> function22;
        Ref.BooleanRef booleanRef2;
        ByteReadChannel byteReadChannel2;
        ByteReadChannel byteReadChannel3;
        Throwable th;
        ConsumeEachKt$consumeEachBufferRange$1 consumeEachKt$consumeEachBufferRange$13;
        ByteReadChannel byteReadChannel4;
        Function2<? super ByteBuffer, ? super Boolean, Boolean> function23;
        Buffer buffer;
        Buffer buffer2;
        long readPosition;
        long writePosition;
        ByteBuffer m9982getEmptySK3TCg8;
        int position;
        Object requestBuffer;
        if (continuation instanceof ConsumeEachKt$consumeEachBufferRange$1) {
            consumeEachKt$consumeEachBufferRange$1 = (ConsumeEachKt$consumeEachBufferRange$1) continuation;
            if ((consumeEachKt$consumeEachBufferRange$1.label & Integer.MIN_VALUE) != 0) {
                consumeEachKt$consumeEachBufferRange$1.label -= Integer.MIN_VALUE;
                Object obj = consumeEachKt$consumeEachBufferRange$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = consumeEachKt$consumeEachBufferRange$1.label;
                boolean z = false;
                int i2 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                    consumeEachKt$consumeEachBufferRange$12 = consumeEachKt$consumeEachBufferRange$1;
                    booleanRef = new Ref.BooleanRef();
                    function22 = function2;
                    booleanRef2 = booleanRef3;
                    byteReadChannel2 = byteReadChannel;
                    booleanRef2.element = z;
                    consumeEachKt$consumeEachBufferRange$12.L$0 = byteReadChannel2;
                    consumeEachKt$consumeEachBufferRange$12.L$1 = function22;
                    consumeEachKt$consumeEachBufferRange$12.L$2 = booleanRef2;
                    consumeEachKt$consumeEachBufferRange$12.L$3 = booleanRef;
                    consumeEachKt$consumeEachBufferRange$12.L$4 = byteReadChannel2;
                    consumeEachKt$consumeEachBufferRange$12.L$5 = null;
                    consumeEachKt$consumeEachBufferRange$12.label = i2;
                    requestBuffer = ReadSessionKt.requestBuffer(byteReadChannel2, i2, consumeEachKt$consumeEachBufferRange$12);
                    if (requestBuffer != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ByteReadChannel byteReadChannel5 = (ByteReadChannel) consumeEachKt$consumeEachBufferRange$1.L$4;
                    Ref.BooleanRef booleanRef4 = (Ref.BooleanRef) consumeEachKt$consumeEachBufferRange$1.L$3;
                    Ref.BooleanRef booleanRef5 = (Ref.BooleanRef) consumeEachKt$consumeEachBufferRange$1.L$2;
                    function23 = (Function2) consumeEachKt$consumeEachBufferRange$1.L$1;
                    byteReadChannel4 = (ByteReadChannel) consumeEachKt$consumeEachBufferRange$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    byteReadChannel3 = byteReadChannel5;
                    booleanRef2 = booleanRef5;
                    booleanRef = booleanRef4;
                    buffer = (Buffer) obj;
                    if (buffer == null) {
                    }
                    buffer2 = buffer;
                    ByteBuffer memory = buffer2.getMemory();
                    readPosition = buffer2.getReadPosition();
                    writePosition = buffer2.getWritePosition();
                    if (writePosition <= readPosition) {
                    }
                    booleanRef.element = m9982getEmptySK3TCg8.remaining() != byteReadChannel4.getAvailableForRead() && byteReadChannel4.isClosedForWrite();
                    booleanRef2.element = function23.invoke(m9982getEmptySK3TCg8, Boxing.boxBoolean(booleanRef.element)).booleanValue();
                    position = m9982getEmptySK3TCg8.position();
                    consumeEachKt$consumeEachBufferRange$1.L$0 = byteReadChannel4;
                    consumeEachKt$consumeEachBufferRange$1.L$1 = function23;
                    consumeEachKt$consumeEachBufferRange$1.L$2 = booleanRef2;
                    consumeEachKt$consumeEachBufferRange$1.L$3 = booleanRef;
                    consumeEachKt$consumeEachBufferRange$1.L$4 = byteReadChannel3;
                    consumeEachKt$consumeEachBufferRange$1.L$5 = buffer2;
                    consumeEachKt$consumeEachBufferRange$1.I$0 = position;
                    consumeEachKt$consumeEachBufferRange$1.label = 2;
                    if (ReadSessionKt.completeReadingFromBuffer(byteReadChannel3, buffer2, position, consumeEachKt$consumeEachBufferRange$1) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th2 = (Throwable) consumeEachKt$consumeEachBufferRange$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th2;
                }
                int i3 = consumeEachKt$consumeEachBufferRange$1.I$0;
                Buffer buffer3 = (Buffer) consumeEachKt$consumeEachBufferRange$1.L$5;
                byteReadChannel3 = (ByteReadChannel) consumeEachKt$consumeEachBufferRange$1.L$4;
                booleanRef = (Ref.BooleanRef) consumeEachKt$consumeEachBufferRange$1.L$3;
                Ref.BooleanRef booleanRef6 = (Ref.BooleanRef) consumeEachKt$consumeEachBufferRange$1.L$2;
                Function2<? super ByteBuffer, ? super Boolean, Boolean> function24 = (Function2) consumeEachKt$consumeEachBufferRange$1.L$1;
                ByteReadChannel byteReadChannel6 = (ByteReadChannel) consumeEachKt$consumeEachBufferRange$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    consumeEachKt$consumeEachBufferRange$12 = consumeEachKt$consumeEachBufferRange$1;
                    booleanRef2 = booleanRef6;
                    function22 = function24;
                    byteReadChannel2 = byteReadChannel6;
                } catch (Throwable th3) {
                    ConsumeEachKt$consumeEachBufferRange$1 consumeEachKt$consumeEachBufferRange$14 = consumeEachKt$consumeEachBufferRange$1;
                    th = th3;
                    consumeEachKt$consumeEachBufferRange$13 = consumeEachKt$consumeEachBufferRange$14;
                    consumeEachKt$consumeEachBufferRange$13.L$0 = th;
                    consumeEachKt$consumeEachBufferRange$13.L$1 = null;
                    consumeEachKt$consumeEachBufferRange$13.L$2 = null;
                    consumeEachKt$consumeEachBufferRange$13.L$3 = null;
                    consumeEachKt$consumeEachBufferRange$13.L$4 = null;
                    consumeEachKt$consumeEachBufferRange$13.L$5 = null;
                    consumeEachKt$consumeEachBufferRange$13.label = 3;
                    if (ReadSessionKt.completeReadingFromBuffer(byteReadChannel3, buffer3, 0, consumeEachKt$consumeEachBufferRange$13) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    throw th;
                }
                if ((booleanRef.element || !byteReadChannel2.isClosedForRead()) && booleanRef2.element) {
                    z = false;
                    i2 = 1;
                    booleanRef2.element = z;
                    consumeEachKt$consumeEachBufferRange$12.L$0 = byteReadChannel2;
                    consumeEachKt$consumeEachBufferRange$12.L$1 = function22;
                    consumeEachKt$consumeEachBufferRange$12.L$2 = booleanRef2;
                    consumeEachKt$consumeEachBufferRange$12.L$3 = booleanRef;
                    consumeEachKt$consumeEachBufferRange$12.L$4 = byteReadChannel2;
                    consumeEachKt$consumeEachBufferRange$12.L$5 = null;
                    consumeEachKt$consumeEachBufferRange$12.label = i2;
                    requestBuffer = ReadSessionKt.requestBuffer(byteReadChannel2, i2, consumeEachKt$consumeEachBufferRange$12);
                    if (requestBuffer != coroutine_suspended) {
                        try {
                            byteReadChannel4 = byteReadChannel2;
                            obj = requestBuffer;
                            function23 = function22;
                            consumeEachKt$consumeEachBufferRange$1 = consumeEachKt$consumeEachBufferRange$12;
                            byteReadChannel3 = byteReadChannel4;
                            buffer = (Buffer) obj;
                            if (buffer == null) {
                                buffer = Buffer.INSTANCE.getEmpty();
                            }
                            ByteBuffer memory2 = buffer2.getMemory();
                            readPosition = buffer2.getReadPosition();
                            writePosition = buffer2.getWritePosition();
                            if (writePosition <= readPosition) {
                                m9982getEmptySK3TCg8 = Memory.m9977slice87lwejk(memory2, readPosition, writePosition - readPosition);
                            } else {
                                m9982getEmptySK3TCg8 = Memory.INSTANCE.m9982getEmptySK3TCg8();
                            }
                            booleanRef.element = m9982getEmptySK3TCg8.remaining() != byteReadChannel4.getAvailableForRead() && byteReadChannel4.isClosedForWrite();
                            booleanRef2.element = function23.invoke(m9982getEmptySK3TCg8, Boxing.boxBoolean(booleanRef.element)).booleanValue();
                            position = m9982getEmptySK3TCg8.position();
                            consumeEachKt$consumeEachBufferRange$1.L$0 = byteReadChannel4;
                            consumeEachKt$consumeEachBufferRange$1.L$1 = function23;
                            consumeEachKt$consumeEachBufferRange$1.L$2 = booleanRef2;
                            consumeEachKt$consumeEachBufferRange$1.L$3 = booleanRef;
                            consumeEachKt$consumeEachBufferRange$1.L$4 = byteReadChannel3;
                            consumeEachKt$consumeEachBufferRange$1.L$5 = buffer2;
                            consumeEachKt$consumeEachBufferRange$1.I$0 = position;
                            consumeEachKt$consumeEachBufferRange$1.label = 2;
                            if (ReadSessionKt.completeReadingFromBuffer(byteReadChannel3, buffer2, position, consumeEachKt$consumeEachBufferRange$1) != coroutine_suspended) {
                                consumeEachKt$consumeEachBufferRange$12 = consumeEachKt$consumeEachBufferRange$1;
                                function22 = function23;
                                byteReadChannel2 = byteReadChannel4;
                                if (booleanRef.element) {
                                }
                                z = false;
                                i2 = 1;
                                booleanRef2.element = z;
                                consumeEachKt$consumeEachBufferRange$12.L$0 = byteReadChannel2;
                                consumeEachKt$consumeEachBufferRange$12.L$1 = function22;
                                consumeEachKt$consumeEachBufferRange$12.L$2 = booleanRef2;
                                consumeEachKt$consumeEachBufferRange$12.L$3 = booleanRef;
                                consumeEachKt$consumeEachBufferRange$12.L$4 = byteReadChannel2;
                                consumeEachKt$consumeEachBufferRange$12.L$5 = null;
                                consumeEachKt$consumeEachBufferRange$12.label = i2;
                                requestBuffer = ReadSessionKt.requestBuffer(byteReadChannel2, i2, consumeEachKt$consumeEachBufferRange$12);
                                if (requestBuffer != coroutine_suspended) {
                                }
                            }
                        } catch (Throwable th4) {
                            ConsumeEachKt$consumeEachBufferRange$1 consumeEachKt$consumeEachBufferRange$15 = consumeEachKt$consumeEachBufferRange$1;
                            th = th4;
                            consumeEachKt$consumeEachBufferRange$13 = consumeEachKt$consumeEachBufferRange$15;
                            buffer3 = buffer2;
                            consumeEachKt$consumeEachBufferRange$13.L$0 = th;
                            consumeEachKt$consumeEachBufferRange$13.L$1 = null;
                            consumeEachKt$consumeEachBufferRange$13.L$2 = null;
                            consumeEachKt$consumeEachBufferRange$13.L$3 = null;
                            consumeEachKt$consumeEachBufferRange$13.L$4 = null;
                            consumeEachKt$consumeEachBufferRange$13.L$5 = null;
                            consumeEachKt$consumeEachBufferRange$13.label = 3;
                            if (ReadSessionKt.completeReadingFromBuffer(byteReadChannel3, buffer3, 0, consumeEachKt$consumeEachBufferRange$13) != coroutine_suspended) {
                            }
                        }
                        buffer2 = buffer;
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        consumeEachKt$consumeEachBufferRange$1 = new ConsumeEachKt$consumeEachBufferRange$1(continuation);
        Object obj2 = consumeEachKt$consumeEachBufferRange$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = consumeEachKt$consumeEachBufferRange$1.label;
        boolean z2 = false;
        int i22 = 1;
        if (i != 0) {
        }
    }

    private static final Object consumeEachBufferRange$$forInline(ByteReadChannel byteReadChannel, Function2<? super ByteBuffer, ? super Boolean, Boolean> function2, Continuation<? super Unit> continuation) {
        ByteBuffer m9982getEmptySK3TCg8;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        do {
            booleanRef.element = false;
            boolean z = true;
            Buffer buffer = (Buffer) ReadSessionKt.requestBuffer(byteReadChannel, 1, continuation);
            if (buffer == null) {
                buffer = Buffer.INSTANCE.getEmpty();
            }
            try {
                Memory m9965boximpl = Memory.m9965boximpl(buffer.getMemory());
                Long valueOf = Long.valueOf(buffer.getReadPosition());
                long longValue = Long.valueOf(buffer.getWritePosition()).longValue();
                long longValue2 = valueOf.longValue();
                Memory memory = m9965boximpl;
                ByteBuffer m9981unboximpl = m9965boximpl.m9981unboximpl();
                if (longValue > longValue2) {
                    m9982getEmptySK3TCg8 = Memory.m9977slice87lwejk(m9981unboximpl, longValue2, longValue - longValue2);
                } else {
                    m9982getEmptySK3TCg8 = Memory.INSTANCE.m9982getEmptySK3TCg8();
                }
                if (m9982getEmptySK3TCg8.remaining() != byteReadChannel.getAvailableForRead() || !byteReadChannel.isClosedForWrite()) {
                    z = false;
                }
                booleanRef2.element = z;
                booleanRef.element = function2.invoke(m9982getEmptySK3TCg8, Boolean.valueOf(booleanRef2.element)).booleanValue();
                int intValue = Integer.valueOf(m9982getEmptySK3TCg8.position()).intValue();
                ReadSessionKt.completeReadingFromBuffer(byteReadChannel, buffer, intValue, continuation);
                Integer.valueOf(intValue);
                if (booleanRef2.element && byteReadChannel.isClosedForRead()) {
                    break;
                }
            } catch (Throwable th) {
                ReadSessionKt.completeReadingFromBuffer(byteReadChannel, buffer, 0, continuation);
                throw th;
            }
        } while (booleanRef.element);
        return Unit.INSTANCE;
    }
}
