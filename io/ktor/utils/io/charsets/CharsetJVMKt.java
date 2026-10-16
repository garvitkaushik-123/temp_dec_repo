package io.ktor.utils.io.charsets;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferPrimitivesKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.jvm.ErrorsKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: CharsetJVM.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0015\u001a\u00020\u0001*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u001b\u001a\u00020\u0001\u001a6\u0010\u001c\u001a\u00020\u0001*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u001b\u001a\u00020\u0001H\u0000\u001a\u001e\u0010!\u001a\u00020\u0012*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0001\u001a \u0010#\u001a\u00020\u0012*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0001H\u0002\u001a \u0010$\u001a\u00020\u0012*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0001H\u0002\u001a\u0018\u0010%\u001a\u00020 *\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0018\u001a\u00020\u001dH\u0000\u001a0\u0010&\u001a\u00020\u0001*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u001dH\u0000\u001a*\u0010*\u001a\u00020+*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u0001\u001a,\u0010,\u001a\u00020+*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u0001H\u0000\u001a(\u0010-\u001a\u00020+*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0001H\u0002\u001a\u001e\u0010.\u001a\u00020/*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u0002002\u0006\u0010\u0018\u001a\u000201\u001a\f\u00102\u001a\u00020/*\u000203H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010\u0007\u001a\u00060\bj\u0002`\t*\u00060\nj\u0002`\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001d\u0010\u0007\u001a\u00060\bj\u0002`\t*\u00060\u000ej\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0010\"\u0019\u0010\u0011\u001a\u00020\u0012*\u00060\bj\u0002`\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014*\n\u00104\"\u00020\b2\u00020\b*\n\u00105\"\u00020\n2\u00020\n*\n\u00106\"\u00020\u000e2\u00020\u000e*\n\u00107\"\u0002082\u000208¨\u00069"}, d2 = {"DECODE_CHAR_BUFFER_SIZE", "", "EmptyByteBuffer", "Ljava/nio/ByteBuffer;", "EmptyCharBuffer", "Ljava/nio/CharBuffer;", "kotlin.jvm.PlatformType", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "getCharset", "(Ljava/nio/charset/CharsetDecoder;)Ljava/nio/charset/Charset;", "Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "(Ljava/nio/charset/CharsetEncoder;)Ljava/nio/charset/Charset;", "name", "", "getName", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "decode", "input", "Lio/ktor/utils/io/core/Input;", "dst", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "max", "decodeBuffer", "Lio/ktor/utils/io/core/Buffer;", "out", "lastBuffer", "", "decodeExactBytes", "inputLength", "decodeImplByteBuffer", "decodeImplSlow", "encodeComplete", "encodeImpl", "", "fromIndex", "toIndex", "encodeToByteArray", "", "encodeToByteArrayImpl1", "encodeToByteArraySlow", "encodeUTF8", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/core/Output;", "throwExceptionWrapped", "Ljava/nio/charset/CoderResult;", "Charset", "CharsetDecoder", "CharsetEncoder", "Charsets", "Lkotlin/text/Charsets;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CharsetJVMKt {
    private static final int DECODE_CHAR_BUFFER_SIZE = 8192;
    private static final ByteBuffer EmptyByteBuffer;
    private static final CharBuffer EmptyCharBuffer = CharBuffer.allocate(0);

    public static /* synthetic */ void Charset$annotations() {
    }

    public static final String getName(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "<this>");
        String name = charset.name();
        Intrinsics.checkNotNullExpressionValue(name, "name()");
        return name;
    }

    public static final Charset getCharset(CharsetEncoder charsetEncoder) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Charset charset = charsetEncoder.charset();
        Intrinsics.checkNotNullExpressionValue(charset, "charset()");
        return charset;
    }

    public static final byte[] encodeToByteArray(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (input instanceof String) {
            if (i == 0 && i2 == input.length()) {
                byte[] bytes = ((String) input).getBytes(charsetEncoder.charset());
                Intrinsics.checkNotNullExpressionValue(bytes, "input as java.lang.String).getBytes(charset())");
                return bytes;
            }
            String substring = ((String) input).substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes2 = substring.getBytes(charsetEncoder.charset());
            Intrinsics.checkNotNullExpressionValue(bytes2, "input.substring(fromInde…ring).getBytes(charset())");
            return bytes2;
        }
        return encodeToByteArraySlow(charsetEncoder, input, i, i2);
    }

    private static final byte[] encodeToByteArraySlow(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        ByteBuffer encode = charsetEncoder.encode(CharBuffer.wrap(charSequence, i, i2));
        byte[] bArr = null;
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            byte[] array = encode.array();
            if (array.length == encode.remaining()) {
                bArr = array;
            }
        }
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[encode.remaining()];
        encode.get(bArr2);
        return bArr2;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encodeToByteArray(charsetEncoder, charSequence, i, i2);
    }

    public static final int encodeImpl(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2, Buffer dst) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        CharBuffer wrap = CharBuffer.wrap(input, i, i2);
        int remaining = wrap.remaining();
        ByteBuffer memory = dst.getMemory();
        int writePosition = dst.getWritePosition();
        int limit = dst.getLimit() - writePosition;
        ByteBuffer m9976slice87lwejk = Memory.m9976slice87lwejk(memory, writePosition, limit);
        CoderResult result = charsetEncoder.encode(wrap, m9976slice87lwejk, false);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            throwExceptionWrapped(result);
        }
        if (m9976slice87lwejk.limit() != limit) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        dst.commitWritten(m9976slice87lwejk.position());
        return remaining - wrap.remaining();
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x01fb, code lost:
    
        r21 = r3;
        r22 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void encodeUTF8(CharsetEncoder charsetEncoder, ByteReadPacket input, Output dst) {
        ByteBuffer byteBuffer;
        int i;
        ChunkBuffer chunkBuffer;
        int i2;
        int i3;
        char lowSurrogate;
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (getCharset(charsetEncoder) == Charsets.UTF_8) {
            dst.writePacket(input);
            return;
        }
        ChunkBuffer borrow = ChunkBuffer.INSTANCE.getPool().borrow();
        try {
            ChunkBuffer chunkBuffer2 = borrow;
            int limit = chunkBuffer2.getLimit() - chunkBuffer2.getWritePosition();
            if (limit < 0) {
                throw new IllegalArgumentException(("size 0 is greater than buffer's remaining capacity " + limit).toString());
            }
            ByteBuffer duplicate = borrow.getMemory().duplicate();
            Intrinsics.checkNotNull(duplicate);
            int writePosition = borrow.getWritePosition();
            duplicate.limit(borrow.getLimit());
            duplicate.position(writePosition);
            CharBuffer asCharBuffer = duplicate.asCharBuffer();
            while (true) {
                int i4 = 1;
                if (input.getRemaining() <= 0) {
                    break;
                }
                asCharBuffer.clear();
                ChunkBuffer prepareReadHead$ktor_io = input.prepareReadHead$ktor_io(1);
                if (prepareReadHead$ktor_io == null) {
                    break;
                }
                ChunkBuffer chunkBuffer3 = prepareReadHead$ktor_io;
                ByteBuffer memory = chunkBuffer3.getMemory();
                int readPosition = chunkBuffer3.getReadPosition();
                int writePosition2 = chunkBuffer3.getWritePosition();
                int i5 = readPosition;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    if (i5 >= writePosition2) {
                        byteBuffer = duplicate;
                        i = writePosition;
                        chunkBuffer = prepareReadHead$ktor_io;
                        i2 = i4;
                        chunkBuffer3.discardExact(writePosition2 - readPosition);
                        i3 = 0;
                        break;
                    }
                    i2 = i4;
                    byte b = memory.get(i5);
                    byteBuffer = duplicate;
                    int i9 = b & 255;
                    i = writePosition;
                    i3 = -1;
                    if ((b & 128) == 0) {
                        if (i6 != 0) {
                            UTF8Kt.malformedByteCount(i6);
                            throw new KotlinNothingValueException();
                        }
                        char c = (char) i9;
                        if (!asCharBuffer.hasRemaining()) {
                            chunkBuffer3.discardExact(i5 - readPosition);
                            chunkBuffer = prepareReadHead$ktor_io;
                            break;
                        }
                        asCharBuffer.put(c);
                        chunkBuffer = prepareReadHead$ktor_io;
                        i5++;
                        i4 = i2;
                        duplicate = byteBuffer;
                        writePosition = i;
                        prepareReadHead$ktor_io = chunkBuffer;
                    } else if (i6 == 0) {
                        int i10 = 128;
                        chunkBuffer = prepareReadHead$ktor_io;
                        int i11 = i6;
                        int i12 = i9;
                        for (int i13 = i2; i13 < 7 && (i12 & i10) != 0; i13++) {
                            i12 &= ~i10;
                            i10 >>= 1;
                            i11++;
                        }
                        int i14 = i11 - 1;
                        if (i11 > writePosition2 - i5) {
                            chunkBuffer3.discardExact(i5 - readPosition);
                            i3 = i11;
                            break;
                        }
                        i8 = i11;
                        i7 = i12;
                        i6 = i14;
                        i5++;
                        i4 = i2;
                        duplicate = byteBuffer;
                        writePosition = i;
                        prepareReadHead$ktor_io = chunkBuffer;
                    } else {
                        chunkBuffer = prepareReadHead$ktor_io;
                        int i15 = (i7 << 6) | (b & Byte.MAX_VALUE);
                        i6--;
                        if (i6 != 0) {
                            i7 = i15;
                        } else if (UTF8Kt.isBmpCodePoint(i15)) {
                            lowSurrogate = (char) i15;
                            if (!asCharBuffer.hasRemaining()) {
                                chunkBuffer3.discardExact(((i5 - readPosition) - i8) + 1);
                                break;
                            }
                            asCharBuffer.put(lowSurrogate);
                            i7 = 0;
                        } else {
                            if (!UTF8Kt.isValidCodePoint(i15)) {
                                UTF8Kt.malformedCodePoint(i15);
                                throw new KotlinNothingValueException();
                            }
                            char highSurrogate = (char) UTF8Kt.highSurrogate(i15);
                            if (!asCharBuffer.hasRemaining()) {
                                break;
                            }
                            asCharBuffer.put(highSurrogate);
                            lowSurrogate = (char) UTF8Kt.lowSurrogate(i15);
                            if (!asCharBuffer.hasRemaining()) {
                                break;
                            }
                            asCharBuffer.put(lowSurrogate);
                            i7 = 0;
                        }
                        i5++;
                        i4 = i2;
                        duplicate = byteBuffer;
                        writePosition = i;
                        prepareReadHead$ktor_io = chunkBuffer;
                    }
                }
                chunkBuffer3.discardExact(((i5 - readPosition) - i8) + 1);
                input.setHeadPosition(chunkBuffer.getReadPosition());
                asCharBuffer.flip();
                if (asCharBuffer.hasRemaining()) {
                    ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(dst, i2, null);
                    int i16 = 1;
                    while (true) {
                        try {
                            ChunkBuffer chunkBuffer4 = prepareWriteHead;
                            ByteBuffer memory2 = chunkBuffer4.getMemory();
                            int writePosition3 = chunkBuffer4.getWritePosition();
                            int limit2 = chunkBuffer4.getLimit() - writePosition3;
                            ByteBuffer m9976slice87lwejk = Memory.m9976slice87lwejk(memory2, writePosition3, limit2);
                            CoderResult cr = charsetEncoder.encode(asCharBuffer, m9976slice87lwejk, false);
                            if (cr.isUnmappable() || cr.isMalformed()) {
                                Intrinsics.checkNotNullExpressionValue(cr, "cr");
                                throwExceptionWrapped(cr);
                            }
                            i16 = (cr.isOverflow() && m9976slice87lwejk.hasRemaining()) ? i16 + 1 : 1;
                            if (m9976slice87lwejk.limit() != limit2) {
                                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                            }
                            chunkBuffer4.commitWritten(m9976slice87lwejk.position());
                            int i17 = asCharBuffer.hasRemaining() ? i16 : 0;
                            if (i17 <= 0) {
                                break;
                            } else {
                                prepareWriteHead = UnsafeKt.prepareWriteHead(dst, i17, prepareWriteHead);
                            }
                        } finally {
                        }
                    }
                }
                if (i3 > 0) {
                    break;
                }
                duplicate = byteBuffer;
                writePosition = i;
            }
            asCharBuffer.clear();
            asCharBuffer.flip();
            ChunkBuffer prepareWriteHead2 = UnsafeKt.prepareWriteHead(dst, 1, null);
            int i18 = 1;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer5 = prepareWriteHead2;
                    ByteBuffer memory3 = chunkBuffer5.getMemory();
                    int writePosition4 = chunkBuffer5.getWritePosition();
                    int limit3 = chunkBuffer5.getLimit() - writePosition4;
                    ByteBuffer m9976slice87lwejk2 = Memory.m9976slice87lwejk(memory3, writePosition4, limit3);
                    CoderResult cr2 = charsetEncoder.encode(asCharBuffer, m9976slice87lwejk2, true);
                    if (cr2.isMalformed() || cr2.isUnmappable()) {
                        Intrinsics.checkNotNullExpressionValue(cr2, "cr");
                        throwExceptionWrapped(cr2);
                    }
                    i18 = cr2.isOverflow() ? i18 + 1 : 0;
                    if (m9976slice87lwejk2.limit() != limit3) {
                        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                    }
                    chunkBuffer5.commitWritten(m9976slice87lwejk2.position());
                    if (i18 <= 0) {
                        dst.afterHeadWrite();
                        int position = byteBuffer.position() - i;
                        if (position < 0 || position > limit) {
                            ErrorsKt.wrongBufferPositionChangeError(position, 0);
                            throw new KotlinNothingValueException();
                        }
                        borrow.commitWritten(position);
                        return;
                    }
                    prepareWriteHead2 = UnsafeKt.prepareWriteHead(dst, i18, prepareWriteHead2);
                } finally {
                }
            }
        } finally {
            borrow.release(ChunkBuffer.INSTANCE.getPool());
        }
    }

    public static /* synthetic */ byte[] encodeToByteArrayImpl1$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encodeToByteArrayImpl1(charsetEncoder, charSequence, i, i2);
    }

    public static /* synthetic */ int decodeBuffer$default(CharsetDecoder charsetDecoder, Buffer buffer, Appendable appendable, boolean z, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = Integer.MAX_VALUE;
        }
        return decodeBuffer(charsetDecoder, buffer, appendable, z, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final byte[] encodeToByteArrayImpl1(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2) {
        byte[] readBytes$default;
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (i >= i2) {
            return UnsafeKt.EmptyByteArray;
        }
        ChunkBuffer borrow = ChunkBuffer.INSTANCE.getPool().borrow();
        try {
            int encodeImpl = i + encodeImpl(charsetEncoder, input, i, i2, borrow);
            if (encodeImpl == i2) {
                ChunkBuffer chunkBuffer = borrow;
                int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                readBytes$default = new byte[writePosition];
                Intrinsics.checkNotNull(borrow, "null cannot be cast to non-null type io.ktor.utils.io.core.Buffer");
                BufferPrimitivesKt.readFully((Buffer) borrow, readBytes$default, 0, writePosition);
            } else {
                BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
                try {
                    bytePacketBuilder.appendSingleChunk$ktor_io(borrow.duplicate());
                    EncodingKt.encodeToImpl(charsetEncoder, bytePacketBuilder, input, encodeImpl, i2);
                    readBytes$default = io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null);
                } catch (Throwable th) {
                    bytePacketBuilder.release();
                    throw th;
                }
            }
            return readBytes$default;
        } finally {
            borrow.release(ChunkBuffer.INSTANCE.getPool());
        }
    }

    public static final Charset getCharset(CharsetDecoder charsetDecoder) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Charset charset = charsetDecoder.charset();
        Intrinsics.checkNotNull(charset);
        return charset;
    }

    public static final int decode(CharsetDecoder charsetDecoder, Input input, Appendable dst, int i) {
        CoderResult cr;
        ChunkBuffer chunkBuffer;
        ChunkBuffer prepareReadNextHead;
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        CharBuffer allocate = CharBuffer.allocate(8192);
        boolean z = true;
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        int i2 = 0;
        if (prepareReadFirstHead != null) {
            int i3 = 1;
            int i4 = 1;
            int i5 = 0;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i3) {
                        try {
                            ChunkBuffer chunkBuffer2 = prepareReadFirstHead;
                            int i6 = i - i5;
                            if (i6 == 0) {
                                i3 = 0;
                            } else {
                                ByteBuffer memory = chunkBuffer2.getMemory();
                                int readPosition = chunkBuffer2.getReadPosition();
                                int writePosition2 = chunkBuffer2.getWritePosition() - readPosition;
                                ByteBuffer m9976slice87lwejk = Memory.m9976slice87lwejk(memory, readPosition, writePosition2);
                                allocate.clear();
                                if (i6 < 8192) {
                                    allocate.limit(i6);
                                }
                                CoderResult rc = charsetDecoder.decode(m9976slice87lwejk, allocate, false);
                                allocate.flip();
                                i5 += allocate.remaining();
                                dst.append(allocate);
                                if (rc.isMalformed() || rc.isUnmappable()) {
                                    Intrinsics.checkNotNullExpressionValue(rc, "rc");
                                    throwExceptionWrapped(rc);
                                }
                                i4 = (rc.isUnderflow() && m9976slice87lwejk.hasRemaining()) ? i4 + 1 : 1;
                                if (m9976slice87lwejk.limit() != writePosition2) {
                                    throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                                }
                                chunkBuffer2.discardExact(m9976slice87lwejk.position());
                                i3 = i4;
                            }
                            writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                        } finally {
                            chunkBuffer = prepareReadFirstHead;
                            chunkBuffer.getWritePosition();
                            chunkBuffer.getReadPosition();
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            prepareReadNextHead = UnsafeKt.prepareReadNextHead(input, prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        if (writePosition >= i3) {
                            ChunkBuffer chunkBuffer3 = prepareReadFirstHead;
                            if (chunkBuffer3.getCapacity() - chunkBuffer3.getLimit() >= 8) {
                                prepareReadNextHead = prepareReadFirstHead;
                            }
                        }
                        UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                        prepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i3);
                    }
                    if (prepareReadNextHead == null) {
                        break;
                    }
                    if (i3 <= 0) {
                        i2 = 1;
                        prepareReadFirstHead = prepareReadNextHead;
                        break;
                    }
                    prepareReadFirstHead = prepareReadNextHead;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (i2 != 0) {
                UnsafeKt.completeReadHead(input, prepareReadFirstHead);
            }
            i2 = i5;
        }
        do {
            allocate.clear();
            int i7 = i - i2;
            if (i7 == 0) {
                break;
            }
            if (i7 < 8192) {
                allocate.limit(i7);
            }
            cr = charsetDecoder.decode(EmptyByteBuffer, allocate, true);
            allocate.flip();
            i2 += allocate.remaining();
            dst.append(allocate);
            if (cr.isUnmappable() || cr.isMalformed()) {
                Intrinsics.checkNotNullExpressionValue(cr, "cr");
                throwExceptionWrapped(cr);
            }
        } while (cr.isOverflow());
        return i2;
    }

    public static final String decodeExactBytes(CharsetDecoder charsetDecoder, Input input, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (i == 0) {
            return "";
        }
        if (input.getHeadEndExclusive() - input.getHeadPosition() >= i) {
            if (input.getHeadMemory().hasArray()) {
                ByteBuffer headMemory = input.getHeadMemory();
                byte[] array = headMemory.array();
                Intrinsics.checkNotNullExpressionValue(array, "bb.array()");
                int arrayOffset = headMemory.arrayOffset() + headMemory.position() + input.getHead().getReadPosition();
                Charset charset = charsetDecoder.charset();
                Intrinsics.checkNotNullExpressionValue(charset, "charset()");
                String str = new String(array, arrayOffset, i, charset);
                input.discardExact(i);
                return str;
            }
            return decodeImplByteBuffer(charsetDecoder, input, i);
        }
        return decodeImplSlow(charsetDecoder, input, i);
    }

    private static final String decodeImplByteBuffer(CharsetDecoder charsetDecoder, Input input, int i) {
        CharBuffer allocate = CharBuffer.allocate(i);
        ByteBuffer m9976slice87lwejk = Memory.m9976slice87lwejk(input.getHeadMemory(), input.getHead().getReadPosition(), i);
        CoderResult rc = charsetDecoder.decode(m9976slice87lwejk, allocate, true);
        if (rc.isMalformed() || rc.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(rc, "rc");
            throwExceptionWrapped(rc);
        }
        allocate.flip();
        input.discardExact(m9976slice87lwejk.position());
        String charBuffer = allocate.toString();
        Intrinsics.checkNotNullExpressionValue(charBuffer, "cb.toString()");
        return charBuffer;
    }

    private static final String decodeImplSlow(CharsetDecoder charsetDecoder, Input input, int i) {
        int i2;
        ChunkBuffer chunkBuffer;
        ChunkBuffer prepareReadNextHead;
        boolean z;
        boolean z2;
        CharBuffer allocate = CharBuffer.allocate(i);
        boolean z3 = true;
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (prepareReadFirstHead == null) {
            i2 = i;
            z2 = false;
        } else {
            i2 = i;
            int i3 = 1;
            int i4 = 1;
            boolean z4 = false;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i3) {
                        try {
                            ChunkBuffer chunkBuffer2 = prepareReadFirstHead;
                            if (allocate.hasRemaining() && i2 != 0) {
                                ByteBuffer memory = chunkBuffer2.getMemory();
                                int readPosition = chunkBuffer2.getReadPosition();
                                int writePosition2 = chunkBuffer2.getWritePosition() - readPosition;
                                ByteBuffer m9976slice87lwejk = Memory.m9976slice87lwejk(memory, readPosition, writePosition2);
                                int limit = m9976slice87lwejk.limit();
                                int position = m9976slice87lwejk.position();
                                boolean z5 = limit - position >= i2;
                                if (z5) {
                                    m9976slice87lwejk.limit(position + i2);
                                }
                                CoderResult rc = charsetDecoder.decode(m9976slice87lwejk, allocate, z5);
                                if (rc.isMalformed() || rc.isUnmappable()) {
                                    Intrinsics.checkNotNullExpressionValue(rc, "rc");
                                    throwExceptionWrapped(rc);
                                }
                                i4 = (rc.isUnderflow() && m9976slice87lwejk.hasRemaining()) ? i4 + 1 : 1;
                                m9976slice87lwejk.limit(limit);
                                i2 -= m9976slice87lwejk.position() - position;
                                if (m9976slice87lwejk.limit() != writePosition2) {
                                    throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                                }
                                chunkBuffer2.discardExact(m9976slice87lwejk.position());
                                i3 = i4;
                                z4 = z5;
                                ChunkBuffer chunkBuffer3 = prepareReadFirstHead;
                                writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                            }
                            i3 = 0;
                            ChunkBuffer chunkBuffer32 = prepareReadFirstHead;
                            writePosition = chunkBuffer32.getWritePosition() - chunkBuffer32.getReadPosition();
                        } finally {
                            chunkBuffer = prepareReadFirstHead;
                            chunkBuffer.getWritePosition();
                            chunkBuffer.getReadPosition();
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            prepareReadNextHead = UnsafeKt.prepareReadNextHead(input, prepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z3 = false;
                            if (z3) {
                                UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        if (writePosition >= i3) {
                            ChunkBuffer chunkBuffer4 = prepareReadFirstHead;
                            if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() >= 8) {
                                prepareReadNextHead = prepareReadFirstHead;
                            }
                        }
                        UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                        prepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i3);
                    }
                    if (prepareReadNextHead == null) {
                        z = false;
                        break;
                    }
                    prepareReadFirstHead = prepareReadNextHead;
                    if (i3 <= 0) {
                        z = true;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                UnsafeKt.completeReadHead(input, prepareReadFirstHead);
            }
            z2 = z4;
        }
        if (allocate.hasRemaining() && !z2) {
            CoderResult rc2 = charsetDecoder.decode(EmptyByteBuffer, allocate, true);
            if (rc2.isMalformed() || rc2.isUnmappable()) {
                Intrinsics.checkNotNullExpressionValue(rc2, "rc");
                throwExceptionWrapped(rc2);
            }
        }
        if (i2 > 0) {
            throw new EOFException("Not enough bytes available: had only " + (i - i2) + " instead of " + i);
        }
        if (i2 < 0) {
            throw new AssertionError("remainingInputBytes < 0");
        }
        allocate.flip();
        String charBuffer = allocate.toString();
        Intrinsics.checkNotNullExpressionValue(charBuffer, "cb.toString()");
        return charBuffer;
    }

    private static final void throwExceptionWrapped(CoderResult coderResult) {
        try {
            coderResult.throwException();
        } catch (java.nio.charset.MalformedInputException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new MalformedInputException(message);
        }
    }

    static {
        ByteBuffer allocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNull(allocate);
        EmptyByteBuffer = allocate;
    }

    public static final boolean encodeComplete(CharsetEncoder charsetEncoder, Buffer dst) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer memory = dst.getMemory();
        int writePosition = dst.getWritePosition();
        int limit = dst.getLimit() - writePosition;
        ByteBuffer m9976slice87lwejk = Memory.m9976slice87lwejk(memory, writePosition, limit);
        CoderResult result = charsetEncoder.encode(EmptyCharBuffer, m9976slice87lwejk, true);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            throwExceptionWrapped(result);
        }
        boolean isUnderflow = result.isUnderflow();
        if (m9976slice87lwejk.limit() != limit) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        dst.commitWritten(m9976slice87lwejk.position());
        return isUnderflow;
    }

    public static final int decodeBuffer(CharsetDecoder charsetDecoder, Buffer input, Appendable out, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(out, "out");
        ByteBuffer memory = input.getMemory();
        int readPosition = input.getReadPosition();
        int writePosition = input.getWritePosition() - readPosition;
        ByteBuffer m9976slice87lwejk = Memory.m9976slice87lwejk(memory, readPosition, writePosition);
        ChunkBuffer borrow = ChunkBuffer.INSTANCE.getPool().borrow();
        CharBuffer asCharBuffer = borrow.getMemory().asCharBuffer();
        int i2 = 0;
        while (m9976slice87lwejk.hasRemaining() && i2 < i) {
            try {
                int min = Math.min(asCharBuffer.capacity(), i - i2);
                asCharBuffer.clear();
                asCharBuffer.limit(min);
                CoderResult result = charsetDecoder.decode(m9976slice87lwejk, asCharBuffer, z);
                if (result.isMalformed() || result.isUnmappable()) {
                    Intrinsics.checkNotNullExpressionValue(result, "result");
                    throwExceptionWrapped(result);
                }
                i2 += min;
            } catch (Throwable th) {
                borrow.release(ChunkBuffer.INSTANCE.getPool());
                throw th;
            }
        }
        borrow.release(ChunkBuffer.INSTANCE.getPool());
        if (m9976slice87lwejk.limit() != writePosition) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        input.discardExact(m9976slice87lwejk.position());
        return i2;
    }
}
