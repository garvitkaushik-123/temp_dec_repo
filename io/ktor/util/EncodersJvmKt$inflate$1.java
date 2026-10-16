package io.ktor.util;

import com.vungle.ads.internal.protos.Sdk;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.InputKt;
import io.ktor.utils.io.core.InputLittleEndianKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: EncodersJvm.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.EncodersJvmKt$inflate$1", f = "EncodersJvm.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {68, 85, 161, 164, 103, 109, Sdk.SDKError.Reason.TPAT_ERROR_VALUE}, m = "invokeSuspend", n = {"$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "extraLen", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "n$iv", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes8.dex */
final class EncodersJvmKt$inflate$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $gzip;
    final /* synthetic */ ByteReadChannel $source;
    byte B$0;
    byte B$1;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    short S$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EncodersJvmKt$inflate$1(boolean z, ByteReadChannel byteReadChannel, Continuation<? super EncodersJvmKt$inflate$1> continuation) {
        super(2, continuation);
        this.$gzip = z;
        this.$source = byteReadChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EncodersJvmKt$inflate$1 encodersJvmKt$inflate$1 = new EncodersJvmKt$inflate$1(this.$gzip, this.$source, continuation);
        encodersJvmKt$inflate$1.L$0 = obj;
        return encodersJvmKt$inflate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((EncodersJvmKt$inflate$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0155, code lost:
    
        if (r2 == r0) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0229, code lost:
    
        if (r2 == r0) goto L96;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0357 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:8:0x0036, B:10:0x037f, B:11:0x0351, B:13:0x0357, B:17:0x0397, B:19:0x039b, B:21:0x03a3, B:23:0x03c3, B:28:0x03c8, B:29:0x03f0, B:30:0x03f1, B:31:0x03fc, B:32:0x03fd, B:33:0x0423, B:34:0x0424, B:36:0x043e, B:37:0x0449, B:39:0x005d, B:41:0x0325, B:42:0x02ee, B:44:0x02f4, B:46:0x02fa, B:50:0x033e, B:51:0x02ad, B:53:0x02b5, B:56:0x02d4, B:58:0x02dc, B:59:0x0343, B:61:0x034b, B:62:0x044a, B:64:0x007f), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0397 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:8:0x0036, B:10:0x037f, B:11:0x0351, B:13:0x0357, B:17:0x0397, B:19:0x039b, B:21:0x03a3, B:23:0x03c3, B:28:0x03c8, B:29:0x03f0, B:30:0x03f1, B:31:0x03fc, B:32:0x03fd, B:33:0x0423, B:34:0x0424, B:36:0x043e, B:37:0x0449, B:39:0x005d, B:41:0x0325, B:42:0x02ee, B:44:0x02f4, B:46:0x02fa, B:50:0x033e, B:51:0x02ad, B:53:0x02b5, B:56:0x02d4, B:58:0x02dc, B:59:0x0343, B:61:0x034b, B:62:0x044a, B:64:0x007f), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02f4 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:8:0x0036, B:10:0x037f, B:11:0x0351, B:13:0x0357, B:17:0x0397, B:19:0x039b, B:21:0x03a3, B:23:0x03c3, B:28:0x03c8, B:29:0x03f0, B:30:0x03f1, B:31:0x03fc, B:32:0x03fd, B:33:0x0423, B:34:0x0424, B:36:0x043e, B:37:0x0449, B:39:0x005d, B:41:0x0325, B:42:0x02ee, B:44:0x02f4, B:46:0x02fa, B:50:0x033e, B:51:0x02ad, B:53:0x02b5, B:56:0x02d4, B:58:0x02dc, B:59:0x0343, B:61:0x034b, B:62:0x044a, B:64:0x007f), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02b5 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:8:0x0036, B:10:0x037f, B:11:0x0351, B:13:0x0357, B:17:0x0397, B:19:0x039b, B:21:0x03a3, B:23:0x03c3, B:28:0x03c8, B:29:0x03f0, B:30:0x03f1, B:31:0x03fc, B:32:0x03fd, B:33:0x0423, B:34:0x0424, B:36:0x043e, B:37:0x0449, B:39:0x005d, B:41:0x0325, B:42:0x02ee, B:44:0x02f4, B:46:0x02fa, B:50:0x033e, B:51:0x02ad, B:53:0x02b5, B:56:0x02d4, B:58:0x02dc, B:59:0x0343, B:61:0x034b, B:62:0x044a, B:64:0x007f), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02dc A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:8:0x0036, B:10:0x037f, B:11:0x0351, B:13:0x0357, B:17:0x0397, B:19:0x039b, B:21:0x03a3, B:23:0x03c3, B:28:0x03c8, B:29:0x03f0, B:30:0x03f1, B:31:0x03fc, B:32:0x03fd, B:33:0x0423, B:34:0x0424, B:36:0x043e, B:37:0x0449, B:39:0x005d, B:41:0x0325, B:42:0x02ee, B:44:0x02f4, B:46:0x02fa, B:50:0x033e, B:51:0x02ad, B:53:0x02b5, B:56:0x02d4, B:58:0x02dc, B:59:0x0343, B:61:0x034b, B:62:0x044a, B:64:0x007f), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0343 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:8:0x0036, B:10:0x037f, B:11:0x0351, B:13:0x0357, B:17:0x0397, B:19:0x039b, B:21:0x03a3, B:23:0x03c3, B:28:0x03c8, B:29:0x03f0, B:30:0x03f1, B:31:0x03fc, B:32:0x03fd, B:33:0x0423, B:34:0x0424, B:36:0x043e, B:37:0x0449, B:39:0x005d, B:41:0x0325, B:42:0x02ee, B:44:0x02f4, B:46:0x02fa, B:50:0x033e, B:51:0x02ad, B:53:0x02b5, B:56:0x02d4, B:58:0x02dc, B:59:0x0343, B:61:0x034b, B:62:0x044a, B:64:0x007f), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01f6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x037d -> B:10:0x037f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0320 -> B:41:0x0325). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x02da -> B:51:0x02ad). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x02dc -> B:42:0x02ee). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        WriterScope writerScope;
        ByteBuffer borrow;
        ByteBuffer borrow2;
        Inflater inflater;
        CRC32 crc32;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        Inflater inflater2;
        Object readPacket;
        byte readByte;
        Inflater inflater3;
        WriterScope writerScope2;
        ByteBuffer byteBuffer3;
        Object readShort;
        CRC32 crc322;
        short s;
        Inflater inflater4;
        byte b;
        ByteBuffer byteBuffer4;
        byte b2;
        Object discard;
        CRC32 crc323;
        long j;
        boolean has;
        boolean has2;
        boolean has3;
        long j2;
        Object discard2;
        Ref.IntRef intRef;
        WriterScope writerScope3;
        CRC32 crc324;
        ByteBuffer byteBuffer5;
        Object obj2;
        CRC32 crc325;
        WriterScope writerScope4;
        Ref.IntRef intRef2;
        Object inflateTo;
        WriterScope writerScope5;
        Ref.IntRef intRef3;
        int i;
        CRC32 crc326;
        Ref.IntRef intRef4;
        int i2;
        Object inflateTo2;
        CRC32 crc327;
        Ref.IntRef intRef5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    writerScope = (WriterScope) this.L$0;
                    borrow = ByteBufferPoolKt.getKtorDefaultPool().borrow();
                    borrow2 = ByteBufferPoolKt.getKtorDefaultPool().borrow();
                    inflater = new Inflater(true);
                    crc32 = new CRC32();
                    if (this.$gzip) {
                        this.L$0 = writerScope;
                        this.L$1 = borrow;
                        this.L$2 = borrow2;
                        this.L$3 = inflater;
                        this.L$4 = crc32;
                        this.label = 1;
                        readPacket = this.$source.readPacket(10, this);
                        break;
                    } else {
                        byteBuffer = borrow;
                        byteBuffer2 = borrow2;
                        inflater2 = inflater;
                        try {
                            intRef = new Ref.IntRef();
                            writerScope3 = writerScope;
                            crc324 = crc32;
                            byteBuffer5 = byteBuffer;
                            if (this.$source.isClosedForRead()) {
                                this.L$0 = writerScope3;
                                this.L$1 = byteBuffer5;
                                this.L$2 = byteBuffer2;
                                this.L$3 = inflater2;
                                this.L$4 = crc324;
                                this.L$5 = intRef;
                                this.L$6 = null;
                                this.label = 5;
                                obj2 = this.$source.readAvailable(byteBuffer5, this);
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                if (((Number) obj2).intValue() > 0) {
                                    byteBuffer5.flip();
                                    inflater2.setInput(byteBuffer5.array(), byteBuffer5.position(), byteBuffer5.remaining());
                                    if (inflater2.needsInput() && !inflater2.finished()) {
                                        int i3 = intRef.element;
                                        this.L$0 = writerScope3;
                                        this.L$1 = byteBuffer5;
                                        this.L$2 = byteBuffer2;
                                        this.L$3 = inflater2;
                                        this.L$4 = crc324;
                                        this.L$5 = intRef;
                                        this.L$6 = intRef;
                                        this.I$0 = i3;
                                        this.label = 6;
                                        inflateTo = EncodersJvmKt.inflateTo(inflater2, writerScope3.getChannel(), byteBuffer2, crc324, this);
                                        if (inflateTo == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        writerScope5 = writerScope3;
                                        intRef3 = intRef;
                                        i = i3;
                                        crc326 = crc324;
                                        intRef4 = intRef3;
                                        intRef4.element = i + ((Number) inflateTo).intValue();
                                        byteBuffer5.position(byteBuffer5.limit() - inflater2.getRemaining());
                                        intRef = intRef3;
                                        crc324 = crc326;
                                        writerScope3 = writerScope5;
                                        if (inflater2.needsInput()) {
                                        }
                                        byteBuffer5.compact();
                                    } else {
                                        byteBuffer5.compact();
                                    }
                                }
                                if (this.$source.isClosedForRead()) {
                                    Throwable closedCause = this.$source.getClosedCause();
                                    if (closedCause != null) {
                                        throw closedCause;
                                    }
                                    byteBuffer5.flip();
                                    crc325 = crc324;
                                    writerScope4 = writerScope3;
                                    intRef2 = intRef;
                                    if (!inflater2.finished()) {
                                        i2 = intRef2.element;
                                        this.L$0 = writerScope4;
                                        this.L$1 = byteBuffer5;
                                        this.L$2 = byteBuffer2;
                                        this.L$3 = inflater2;
                                        this.L$4 = crc325;
                                        this.L$5 = intRef2;
                                        this.L$6 = intRef2;
                                        this.I$0 = i2;
                                        this.label = 7;
                                        inflateTo2 = EncodersJvmKt.inflateTo(inflater2, writerScope4.getChannel(), byteBuffer2, crc325, this);
                                        if (inflateTo2 != coroutine_suspended) {
                                            crc327 = crc325;
                                            intRef5 = intRef2;
                                            intRef2.element = i2 + ((Number) inflateTo2).intValue();
                                            byteBuffer5.position(byteBuffer5.limit() - inflater2.getRemaining());
                                            intRef2 = intRef5;
                                            crc325 = crc327;
                                            if (!inflater2.finished()) {
                                                if (this.$gzip) {
                                                    if (byteBuffer5.remaining() != 8) {
                                                        throw new IllegalStateException(("Expected 8 bytes in the trailer. Actual: " + byteBuffer5.remaining() + " $").toString());
                                                    }
                                                    byteBuffer5.order(ByteOrder.LITTLE_ENDIAN);
                                                    int i4 = byteBuffer5.getInt(byteBuffer5.position());
                                                    int i5 = byteBuffer5.getInt(byteBuffer5.position() + 4);
                                                    if (((int) crc325.getValue()) != i4) {
                                                        throw new IllegalStateException("Gzip checksum invalid.".toString());
                                                    }
                                                    if (intRef2.element != i5) {
                                                        throw new IllegalStateException(("Gzip size invalid. Expected " + i5 + ", actual " + intRef2.element).toString());
                                                    }
                                                } else if (byteBuffer5.hasRemaining()) {
                                                    throw new IllegalStateException("Check failed.".toString());
                                                }
                                                inflater2.end();
                                                ByteBufferPoolKt.getKtorDefaultPool().recycle(byteBuffer5);
                                                ByteBufferPoolKt.getKtorDefaultPool().recycle(byteBuffer2);
                                                return Unit.INSTANCE;
                                            }
                                        }
                                        return coroutine_suspended;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            ByteBuffer byteBuffer6 = byteBuffer;
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                inflater2.end();
                                ByteBufferPoolKt.getKtorDefaultPool().recycle(byteBuffer6);
                                ByteBufferPoolKt.getKtorDefaultPool().recycle(byteBuffer2);
                                throw th2;
                            }
                        }
                    }
                case 1:
                    CRC32 crc328 = (CRC32) this.L$4;
                    inflater = (Inflater) this.L$3;
                    borrow2 = (ByteBuffer) this.L$2;
                    borrow = (ByteBuffer) this.L$1;
                    writerScope = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    crc32 = crc328;
                    readPacket = obj;
                    ByteReadPacket byteReadPacket = (ByteReadPacket) readPacket;
                    ByteReadPacket byteReadPacket2 = byteReadPacket;
                    short readShortLittleEndian = InputLittleEndianKt.readShortLittleEndian(byteReadPacket2);
                    byte readByte2 = byteReadPacket.readByte();
                    readByte = byteReadPacket.readByte();
                    InputKt.discard(byteReadPacket2);
                    if ((readByte & 4) != 0) {
                        this.L$0 = writerScope;
                        this.L$1 = borrow;
                        this.L$2 = borrow2;
                        this.L$3 = inflater;
                        this.L$4 = crc32;
                        this.S$0 = readShortLittleEndian;
                        this.B$0 = readByte2;
                        this.B$1 = readByte;
                        this.label = 2;
                        readShort = this.$source.readShort(this);
                        if (readShort != coroutine_suspended) {
                            byteBuffer = borrow;
                            crc322 = crc32;
                            s = readShortLittleEndian;
                            inflater4 = inflater;
                            writerScope2 = writerScope;
                            b = readByte2;
                            byteBuffer4 = borrow2;
                            long shortValue = ((Number) readShort).shortValue();
                            this.L$0 = writerScope2;
                            this.L$1 = byteBuffer;
                            this.L$2 = byteBuffer4;
                            this.L$3 = inflater4;
                            this.L$4 = crc322;
                            this.S$0 = s;
                            this.B$0 = b;
                            this.B$1 = readByte;
                            this.J$0 = shortValue;
                            b2 = readByte;
                            this.label = 3;
                            discard = this.$source.discard(shortValue, this);
                            if (discard != coroutine_suspended) {
                                crc323 = crc322;
                                j = shortValue;
                                if (((Number) discard).longValue() == j) {
                                    throw new EOFException("Unable to discard " + j + " bytes");
                                }
                                ByteBuffer byteBuffer7 = byteBuffer4;
                                readByte2 = b;
                                byteBuffer3 = byteBuffer7;
                                inflater3 = inflater4;
                                readByte = b2;
                                readShortLittleEndian = s;
                                crc32 = crc323;
                                if (readShortLittleEndian == -29921) {
                                    throw new IllegalStateException(("GZIP magic invalid: " + ((int) readShortLittleEndian)).toString());
                                }
                                if (readByte2 == 8) {
                                    has = EncodersJvmKt.has(readByte, 8);
                                    if (!has) {
                                        has2 = EncodersJvmKt.has(readByte, 16);
                                        if (!has2) {
                                            has3 = EncodersJvmKt.has(readByte, 2);
                                            if (has3) {
                                                this.L$0 = writerScope2;
                                                this.L$1 = byteBuffer;
                                                this.L$2 = byteBuffer3;
                                                this.L$3 = inflater3;
                                                this.L$4 = crc32;
                                                j2 = 2;
                                                this.J$0 = 2L;
                                                this.label = 4;
                                                discard2 = this.$source.discard(2L, this);
                                                break;
                                            }
                                            inflater2 = inflater3;
                                            byteBuffer2 = byteBuffer3;
                                            writerScope = writerScope2;
                                            intRef = new Ref.IntRef();
                                            writerScope3 = writerScope;
                                            crc324 = crc32;
                                            byteBuffer5 = byteBuffer;
                                            if (this.$source.isClosedForRead()) {
                                            }
                                        } else {
                                            throw new IllegalStateException("Gzip file comment not supported".toString());
                                        }
                                    } else {
                                        throw new IllegalStateException("Gzip file name not supported".toString());
                                    }
                                } else {
                                    throw new IllegalStateException(("Deflater method unsupported: " + ((int) readByte2) + '.').toString());
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                    inflater3 = inflater;
                    byteBuffer = borrow;
                    writerScope2 = writerScope;
                    byteBuffer3 = borrow2;
                    if (readShortLittleEndian == -29921) {
                    }
                    break;
                case 2:
                    readByte = this.B$1;
                    byte b3 = this.B$0;
                    short s2 = this.S$0;
                    crc322 = (CRC32) this.L$4;
                    Inflater inflater5 = (Inflater) this.L$3;
                    ByteBuffer byteBuffer8 = (ByteBuffer) this.L$2;
                    ByteBuffer byteBuffer9 = (ByteBuffer) this.L$1;
                    WriterScope writerScope6 = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    b = b3;
                    writerScope2 = writerScope6;
                    inflater4 = inflater5;
                    byteBuffer4 = byteBuffer8;
                    byteBuffer = byteBuffer9;
                    readShort = obj;
                    s = s2;
                    long shortValue2 = ((Number) readShort).shortValue();
                    this.L$0 = writerScope2;
                    this.L$1 = byteBuffer;
                    this.L$2 = byteBuffer4;
                    this.L$3 = inflater4;
                    this.L$4 = crc322;
                    this.S$0 = s;
                    this.B$0 = b;
                    this.B$1 = readByte;
                    this.J$0 = shortValue2;
                    b2 = readByte;
                    this.label = 3;
                    discard = this.$source.discard(shortValue2, this);
                    if (discard != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 3:
                    j = this.J$0;
                    byte b4 = this.B$1;
                    b = this.B$0;
                    s = this.S$0;
                    crc323 = (CRC32) this.L$4;
                    inflater4 = (Inflater) this.L$3;
                    byteBuffer4 = (ByteBuffer) this.L$2;
                    byteBuffer = (ByteBuffer) this.L$1;
                    writerScope2 = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    b2 = b4;
                    discard = obj;
                    if (((Number) discard).longValue() == j) {
                    }
                    break;
                case 4:
                    j2 = this.J$0;
                    CRC32 crc329 = (CRC32) this.L$4;
                    inflater3 = (Inflater) this.L$3;
                    byteBuffer3 = (ByteBuffer) this.L$2;
                    ByteBuffer byteBuffer10 = (ByteBuffer) this.L$1;
                    WriterScope writerScope7 = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    byteBuffer = byteBuffer10;
                    writerScope2 = writerScope7;
                    crc32 = crc329;
                    discard2 = obj;
                    if (((Number) discard2).longValue() != j2) {
                        throw new EOFException("Unable to discard " + j2 + " bytes");
                    }
                    inflater2 = inflater3;
                    byteBuffer2 = byteBuffer3;
                    writerScope = writerScope2;
                    intRef = new Ref.IntRef();
                    writerScope3 = writerScope;
                    crc324 = crc32;
                    byteBuffer5 = byteBuffer;
                    if (this.$source.isClosedForRead()) {
                    }
                    break;
                case 5:
                    intRef = (Ref.IntRef) this.L$5;
                    crc324 = (CRC32) this.L$4;
                    inflater2 = (Inflater) this.L$3;
                    byteBuffer2 = (ByteBuffer) this.L$2;
                    byteBuffer5 = (ByteBuffer) this.L$1;
                    writerScope3 = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    if (((Number) obj2).intValue() > 0) {
                    }
                    if (this.$source.isClosedForRead()) {
                    }
                    break;
                case 6:
                    i = this.I$0;
                    intRef4 = (Ref.IntRef) this.L$6;
                    intRef3 = (Ref.IntRef) this.L$5;
                    crc326 = (CRC32) this.L$4;
                    inflater2 = (Inflater) this.L$3;
                    byteBuffer2 = (ByteBuffer) this.L$2;
                    byteBuffer5 = (ByteBuffer) this.L$1;
                    writerScope5 = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    inflateTo = obj;
                    intRef4.element = i + ((Number) inflateTo).intValue();
                    byteBuffer5.position(byteBuffer5.limit() - inflater2.getRemaining());
                    intRef = intRef3;
                    crc324 = crc326;
                    writerScope3 = writerScope5;
                    if (inflater2.needsInput()) {
                    }
                    byteBuffer5.compact();
                    if (this.$source.isClosedForRead()) {
                    }
                    break;
                case 7:
                    i2 = this.I$0;
                    intRef2 = (Ref.IntRef) this.L$6;
                    Ref.IntRef intRef6 = (Ref.IntRef) this.L$5;
                    CRC32 crc3210 = (CRC32) this.L$4;
                    inflater2 = (Inflater) this.L$3;
                    byteBuffer2 = (ByteBuffer) this.L$2;
                    byteBuffer5 = (ByteBuffer) this.L$1;
                    writerScope4 = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    crc327 = crc3210;
                    intRef5 = intRef6;
                    inflateTo2 = obj;
                    intRef2.element = i2 + ((Number) inflateTo2).intValue();
                    byteBuffer5.position(byteBuffer5.limit() - inflater2.getRemaining());
                    intRef2 = intRef5;
                    crc325 = crc327;
                    if (!inflater2.finished()) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
