package io.ktor.utils.io.core;

import com.ironsource.D5;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.internal.CharArraySequence;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.EncodeResult;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* compiled from: Strings.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\r\u0010\t\u001a\u00020\n*\u00020\u000bH\u0082\b\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0010\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0003\u001a\u001e\u0010\u0011\u001a\u00020\r*\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00102\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u0007\u001a.\u0010\u0014\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010 \u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\"\u0010!\u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\"\u001a\u00020\u0003H\u0007\u001a \u0010!\u001a\u00020\u0015*\u00020\u00102\u0006\u0010#\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a \u0010$\u001a\u00020\u0015*\u00020\u00102\u0006\u0010\b\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a \u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a \u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u00102\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u001e\u0010'\u001a\u00020\n*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010(\u001a\u00020\u0015*\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a$\u0010*\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u001d\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a(\u0010*\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a,\u0010,\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u001d\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a0\u0010,\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a$\u0010.\u001a\u00020\u0003*\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020+H\u0002\u001a\u001b\u0010/\u001a\u00020\r*\u00020\u00152\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0086\b\u001a4\u00100\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a4\u00100\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002062\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a$\u00107\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002062\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0002¨\u00068"}, d2 = {"bufferLimitExceeded", "", "limit", "", "prematureEndOfStream", ContentDisposition.Parameters.Size, "", "prematureEndOfStreamToReadChars", "charactersCount", "isAsciiChar", "", "", "readBytes", "", "Lio/ktor/utils/io/core/ByteReadPacket;", D5.q, "Lio/ktor/utils/io/core/Input;", "readBytesOf", "min", "max", "readText", "", "Lio/ktor/utils/io/core/Buffer;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "decoder", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "readTextExact", "readTextExactBytes", "bytes", "bytesCount", "readTextExactCharacters", "readUTF8Line", "estimate", "readUTF8LineTo", "readUTF8UntilDelimiter", "delimiters", "readUTF8UntilDelimiterTo", "Lio/ktor/utils/io/core/Output;", "readUTF8UntilDelimiterToSlowUtf8", "decoded0", "readUTFUntilDelimiterToSlowAscii", "toByteArray", "writeText", "", "text", "", "fromIndex", "toIndex", "", "writeTextUtf8", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class StringsKt {
    private static final boolean isAsciiChar(char c) {
        return c <= 127;
    }

    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return kotlin.text.StringsKt.encodeToByteArray(str);
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        return CharsetJVMKt.encodeToByteArray(newEncoder, str, 0, str.length());
    }

    public static final byte[] toByteArray(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return kotlin.text.StringsKt.encodeToByteArray(str);
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        return CharsetJVMKt.encodeToByteArray(newEncoder, str, 0, str.length());
    }

    public static /* synthetic */ String readUTF8Line$default(ByteReadPacket byteReadPacket, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 16;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readUTF8Line(byteReadPacket, i, i2);
    }

    public static /* synthetic */ String readUTF8Line$default(Input input, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 16;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readUTF8Line(input, i, i2);
    }

    public static final String readUTF8Line(Input input, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        StringBuilder sb = new StringBuilder(i);
        if (readUTF8LineTo(input, sb, i2)) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ String readUTF8UntilDelimiter$default(Input input, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiter(input, str, i);
    }

    public static final String readUTF8UntilDelimiter(Input input, String delimiters, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        StringBuilder sb = new StringBuilder();
        readUTF8UntilDelimiterTo(input, sb, delimiters, i);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ int readUTF8UntilDelimiterTo$default(Input input, Appendable appendable, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiterTo(input, appendable, str, i);
    }

    public static /* synthetic */ int readUTF8UntilDelimiterTo$default(Input input, Output output, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiterTo(input, output, str, i);
    }

    public static final int readUTF8UntilDelimiterTo(Input input, Output out, String delimiters, int i) {
        long readUntilDelimiters;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        int length = delimiters.length();
        if (length == 1 && delimiters.charAt(0) <= 127) {
            readUntilDelimiters = ScannerKt.readUntilDelimiter(input, (byte) delimiters.charAt(0), out);
        } else if (length == 2 && delimiters.charAt(0) <= 127 && delimiters.charAt(1) <= 127) {
            readUntilDelimiters = ScannerKt.readUntilDelimiters(input, (byte) delimiters.charAt(0), (byte) delimiters.charAt(1), out);
        } else {
            return readUTFUntilDelimiterToSlowAscii(input, delimiters, i, out);
        }
        return (int) readUntilDelimiters;
    }

    public static /* synthetic */ byte[] readBytes$default(ByteReadPacket byteReadPacket, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            long remaining = byteReadPacket.getRemaining();
            if (remaining > 2147483647L) {
                throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
            }
            i = (int) remaining;
        }
        return readBytes(byteReadPacket, i);
    }

    public static final byte[] readBytes(ByteReadPacket byteReadPacket, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (i != 0) {
            byte[] bArr = new byte[i];
            InputArraysKt.readFully((Input) byteReadPacket, bArr, 0, i);
            return bArr;
        }
        return UnsafeKt.EmptyByteArray;
    }

    public static final byte[] readBytes(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return readBytesOf(input, i, i);
    }

    public static final byte[] readBytes(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return readBytesOf$default(input, 0, 0, 3, null);
    }

    public static /* synthetic */ byte[] readBytesOf$default(Input input, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readBytesOf(input, i, i2);
    }

    public static final byte[] readBytesOf(Input input, int i, int i2) {
        int readAvailable;
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (i == i2 && i == 0) {
            return UnsafeKt.EmptyByteArray;
        }
        int i3 = 0;
        if (i == i2) {
            byte[] bArr = new byte[i];
            InputArraysKt.readFully(input, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = new byte[(int) RangesKt.coerceAtLeast(RangesKt.coerceAtMost(i2, EncodingKt.sizeEstimate(input)), i)];
        while (i3 < i2 && (readAvailable = InputArraysKt.readAvailable(input, bArr2, i3, Math.min(i2, bArr2.length) - i3)) > 0) {
            i3 += readAvailable;
            if (bArr2.length == i3) {
                bArr2 = Arrays.copyOf(bArr2, i3 * 2);
                Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(this, newSize)");
            }
        }
        if (i3 < i) {
            throw new EOFException("Not enough bytes available to read " + i + " bytes: " + (i - i3) + " more required");
        }
        if (i3 == bArr2.length) {
            return bArr2;
        }
        byte[] copyOf = Arrays.copyOf(bArr2, i3);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    public static /* synthetic */ int readText$default(Input input, Appendable appendable, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, appendable, charset, i);
    }

    public static final int readText(Input input, Appendable out, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        return CharsetJVMKt.decode(newDecoder, input, out, i);
    }

    public static /* synthetic */ String readText$default(Input input, CharsetDecoder charsetDecoder, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, charsetDecoder, i);
    }

    @Deprecated(message = "Use CharsetDecoder.decode instead", replaceWith = @ReplaceWith(expression = "decoder.decode(this, max)", imports = {"io.ktor.utils.io.charsets.decode"}))
    public static final String readText(Input input, CharsetDecoder decoder, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return EncodingKt.decode(decoder, input, i);
    }

    public static /* synthetic */ String readText$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, charset, i);
    }

    public static final String readText(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        return EncodingKt.decode(newDecoder, input, i);
    }

    public static final String readText(Buffer buffer, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        StringBuilder sb = new StringBuilder();
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        CharsetJVMKt.decodeBuffer(newDecoder, buffer, sb, true, i);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String readText$default(Buffer buffer, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(buffer, charset, i);
    }

    public static /* synthetic */ String readTextExact$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExact(input, charset, i);
    }

    @Deprecated(message = "Use readTextExactCharacters instead.", replaceWith = @ReplaceWith(expression = "readTextExactCharacters(n, charset)", imports = {}))
    public static final String readTextExact(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readTextExactCharacters(input, i, charset);
    }

    public static /* synthetic */ String readTextExactCharacters$default(Input input, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactCharacters(input, i, charset);
    }

    public static final String readTextExactCharacters(Input input, int i, Charset charset) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String readText = readText(input, charset, i);
        if (readText.length() >= i) {
            return readText;
        }
        prematureEndOfStreamToReadChars(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ String readTextExactBytes$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactBytes(input, charset, i);
    }

    @Deprecated(message = "Parameters order is changed.", replaceWith = @ReplaceWith(expression = "readTextExactBytes(bytes, charset)", imports = {}))
    public static final String readTextExactBytes(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readTextExactBytes(input, i, charset);
    }

    public static /* synthetic */ String readTextExactBytes$default(Input input, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactBytes(input, i, charset);
    }

    public static final String readTextExactBytes(Input input, int i, Charset charset) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        return CharsetJVMKt.decodeExactBytes(newDecoder, input, i);
    }

    public static /* synthetic */ void writeText$default(Output output, CharSequence charSequence, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(output, charSequence, i, i2, charset);
    }

    public static final void writeText(Output output, CharSequence text, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            writeTextUtf8(output, text, i, i2);
            return;
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        EncodingKt.encodeToImpl(newEncoder, output, text, i, i2);
    }

    public static /* synthetic */ void writeText$default(Output output, char[] cArr, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(output, cArr, i, i2, charset);
    }

    public static final void writeText(Output output, char[] text, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            writeTextUtf8(output, new CharArraySequence(text, 0, text.length), i, i2);
            return;
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        EncodingKt.encode(newEncoder, text, i, i2, output);
    }

    private static final Void bufferLimitExceeded(int i) {
        throw new BufferLimitExceededException("Too many characters before delimiter: limit " + i + " exceeded");
    }

    public static final Void prematureEndOfStream(int i) {
        throw new EOFException("Premature end of stream: expected " + i + " bytes");
    }

    public static final Void prematureEndOfStream(long j) {
        throw new EOFException("Premature end of stream: expected " + j + " bytes");
    }

    private static final Void prematureEndOfStreamToReadChars(int i) {
        throw new EOFException("Not enough input bytes to read " + i + " characters.");
    }

    public static final String readUTF8Line(ByteReadPacket byteReadPacket, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (byteReadPacket.getEndOfInput()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(i);
        if (readUTF8LineTo(byteReadPacket, sb, i2)) {
            return sb.toString();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01c2, code lost:
    
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x018c, code lost:
    
        r6.discardExact(((r13 - r11) - r16) + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0223, code lost:
    
        if (r3 == 0) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0225, code lost:
    
        io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r23, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0228, code lost:
    
        r3 = r9;
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x008e, code lost:
    
        r3 = r17;
        r9 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x010d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0154 A[Catch: all -> 0x01e3, TryCatch #2 {all -> 0x01e3, blocks: (B:45:0x0030, B:61:0x008a, B:64:0x01c6, B:71:0x01ce, B:74:0x01aa, B:82:0x0082, B:84:0x0094, B:85:0x009c, B:87:0x009d, B:88:0x00a5, B:93:0x00b0, B:95:0x00b4, B:97:0x00bd, B:102:0x00c3, B:105:0x00d3, B:107:0x00dd, B:109:0x00e3, B:118:0x010d, B:126:0x0103, B:128:0x0117, B:129:0x011f, B:130:0x0120, B:132:0x0126, B:138:0x0154, B:153:0x0176, B:155:0x0183, B:156:0x018b, B:145:0x018c, B:165:0x014a, B:167:0x0196, B:168:0x019e, B:170:0x019f, B:171:0x01a7, B:181:0x01b4), top: B:44:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x017f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x018c A[EDGE_INSN: B:157:0x018c->B:145:0x018c BREAK  A[LOOP:1: B:47:0x0046->B:74:0x01aa], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x008a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01aa A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean readUTF8LineTo(Input input, Appendable out, int i) {
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        ChunkBuffer prepareReadNextHead;
        ?? r5;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        int i10 = 1;
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (prepareReadFirstHead == null) {
            r5 = 1;
            i2 = 0;
            z = false;
        } else {
            int i11 = 1;
            int i12 = 1;
            int i13 = 0;
            i2 = 0;
            int i14 = 0;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = prepareReadFirstHead;
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i11) {
                        try {
                            ChunkBuffer chunkBuffer2 = prepareReadFirstHead;
                            ByteBuffer memory = chunkBuffer2.getMemory();
                            int readPosition = chunkBuffer2.getReadPosition();
                            int writePosition2 = chunkBuffer2.getWritePosition();
                            int i15 = readPosition;
                            int i16 = 0;
                            int i17 = 0;
                            int i18 = 0;
                            int i19 = 0;
                            while (true) {
                                if (i15 >= writePosition2) {
                                    i3 = i10;
                                    i4 = i13;
                                    z = false;
                                    chunkBuffer2.discardExact(writePosition2 - readPosition);
                                    i5 = i19;
                                    i12 = 0;
                                    break;
                                }
                                z = false;
                                z = false;
                                try {
                                    byte b = memory.get(i15);
                                    i3 = i10;
                                    int i20 = b & 255;
                                    i4 = i13;
                                    if ((b & 128) != 0) {
                                        if (i16 == 0) {
                                            int i21 = 128;
                                            i17 = i20;
                                            for (int i22 = i3; i22 < 7 && (i17 & i21) != 0; i22++) {
                                                i17 &= ~i21;
                                                i21 >>= 1;
                                                i16++;
                                            }
                                            int i23 = i16 - 1;
                                            if (i16 > writePosition2 - i15) {
                                                chunkBuffer2.discardExact(i15 - readPosition);
                                                i12 = i16;
                                                i5 = i19;
                                                break;
                                            }
                                            i18 = i16;
                                            i13 = i4;
                                            i16 = i23;
                                        } else {
                                            i17 = (i17 << 6) | (b & Byte.MAX_VALUE);
                                            i16--;
                                            if (i16 != 0) {
                                                i13 = i4;
                                            } else if (UTF8Kt.isBmpCodePoint(i17)) {
                                                char c = (char) i17;
                                                if (c != '\r') {
                                                    if (c == '\n') {
                                                        i8 = 0;
                                                        i14 = i3;
                                                        i19 = i14;
                                                    } else if (i4 == 0) {
                                                        if (i2 == i) {
                                                            bufferLimitExceeded(i);
                                                            throw new KotlinNothingValueException();
                                                        }
                                                        i2++;
                                                        out.append(c);
                                                        i8 = i3;
                                                    }
                                                    i13 = i4;
                                                    if (i8 == 0) {
                                                    }
                                                    i17 = 0;
                                                } else if (i4 == 0) {
                                                    i8 = i3;
                                                    i13 = i8;
                                                    if (i8 == 0) {
                                                        chunkBuffer2.discardExact(((i15 - readPosition) - i18) + 1);
                                                        break;
                                                    }
                                                    i17 = 0;
                                                }
                                                i8 = 0;
                                                i14 = i3;
                                                i13 = i4;
                                                if (i8 == 0) {
                                                }
                                                i17 = 0;
                                            } else {
                                                if (!UTF8Kt.isValidCodePoint(i17)) {
                                                    UTF8Kt.malformedCodePoint(i17);
                                                    throw new KotlinNothingValueException();
                                                }
                                                char highSurrogate = (char) UTF8Kt.highSurrogate(i17);
                                                if (highSurrogate != '\r') {
                                                    if (highSurrogate == '\n') {
                                                        i6 = 0;
                                                        i14 = i3;
                                                        i19 = i14;
                                                    } else if (i4 == 0) {
                                                        if (i2 == i) {
                                                            bufferLimitExceeded(i);
                                                            throw new KotlinNothingValueException();
                                                        }
                                                        i2++;
                                                        out.append(highSurrogate);
                                                        i6 = i3;
                                                    }
                                                    i13 = i4;
                                                    if (i6 == 0) {
                                                    }
                                                } else if (i4 == 0) {
                                                    i6 = i3;
                                                    i13 = i6;
                                                    if (i6 == 0) {
                                                        break;
                                                    }
                                                    char lowSurrogate = (char) UTF8Kt.lowSurrogate(i17);
                                                    if (lowSurrogate == '\r') {
                                                        if (i13 == 0) {
                                                            i7 = i3;
                                                            i13 = i7;
                                                            if (i7 == 0) {
                                                                break;
                                                            }
                                                            i17 = 0;
                                                        }
                                                        i7 = 0;
                                                        i14 = i3;
                                                        if (i7 == 0) {
                                                        }
                                                        i17 = 0;
                                                    } else {
                                                        if (lowSurrogate == '\n') {
                                                            i7 = 0;
                                                            i14 = i3;
                                                            i19 = i14;
                                                        } else if (i13 != 0) {
                                                            i7 = 0;
                                                            i14 = i3;
                                                        } else {
                                                            if (i2 == i) {
                                                                bufferLimitExceeded(i);
                                                                throw new KotlinNothingValueException();
                                                            }
                                                            i2++;
                                                            out.append(lowSurrogate);
                                                            i7 = i3;
                                                        }
                                                        if (i7 == 0) {
                                                        }
                                                        i17 = 0;
                                                    }
                                                }
                                                i6 = 0;
                                                i14 = i3;
                                                i13 = i4;
                                                if (i6 == 0) {
                                                }
                                            }
                                        }
                                        i15++;
                                        i10 = i3;
                                    } else {
                                        if (i16 != 0) {
                                            UTF8Kt.malformedByteCount(i16);
                                            throw new KotlinNothingValueException();
                                        }
                                        char c2 = (char) i20;
                                        if (c2 != '\r') {
                                            if (c2 == '\n') {
                                                i9 = 0;
                                                i14 = i3;
                                                i19 = i14;
                                            } else if (i4 == 0) {
                                                if (i2 == i) {
                                                    bufferLimitExceeded(i);
                                                    throw new KotlinNothingValueException();
                                                }
                                                i2++;
                                                out.append(c2);
                                                i9 = i3;
                                            }
                                            i13 = i4;
                                            if (i9 == 0) {
                                            }
                                        } else if (i4 == 0) {
                                            i9 = i3;
                                            i13 = i9;
                                            if (i9 == 0) {
                                                chunkBuffer2.discardExact(i15 - readPosition);
                                                break;
                                            }
                                            i15++;
                                            i10 = i3;
                                        }
                                        i9 = 0;
                                        i14 = i3;
                                        i13 = i4;
                                        if (i9 == 0) {
                                        }
                                    }
                                    if (i5 > 0) {
                                        chunkBuffer2.discardExact(i5);
                                    }
                                    i11 = i14 != 0 ? z ? 1 : 0 : RangesKt.coerceAtLeast(i12, i3);
                                    try {
                                        ChunkBuffer chunkBuffer3 = prepareReadFirstHead;
                                        writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                                    } catch (Throwable th) {
                                        th = th;
                                        i10 = 1;
                                        if (i10 != 0) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    ChunkBuffer chunkBuffer4 = prepareReadFirstHead;
                                    chunkBuffer4.getWritePosition();
                                    chunkBuffer4.getReadPosition();
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } else {
                        z = false;
                    }
                    if (writePosition == 0) {
                        try {
                            prepareReadNextHead = UnsafeKt.prepareReadNextHead(input, prepareReadFirstHead);
                        } catch (Throwable th4) {
                            th = th4;
                            i10 = z ? 1 : 0;
                            if (i10 != 0) {
                                UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        if (writePosition >= i11) {
                            ChunkBuffer chunkBuffer5 = prepareReadFirstHead;
                            if (chunkBuffer5.getCapacity() - chunkBuffer5.getLimit() >= 8) {
                                prepareReadNextHead = prepareReadFirstHead;
                            }
                        }
                        UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                        prepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i11);
                    }
                    if (prepareReadNextHead == null) {
                        i10 = z ? 1 : 0;
                        break;
                    }
                    prepareReadFirstHead = prepareReadNextHead;
                    i10 = 1;
                    if (i11 <= 0) {
                        break;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        }
        if (i10 <= r5) {
            return (i2 > 0 || !input.getEndOfInput()) ? r5 : z;
        }
        prematureEndOfStream(i10);
        throw new KotlinNothingValueException();
    }

    public static final int readUTF8UntilDelimiterTo(Input input, Appendable out, String delimiters, int i) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        boolean z4 = false;
        if (prepareReadFirstHead == null) {
            i2 = 0;
        } else {
            i2 = 0;
            boolean z5 = false;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = prepareReadFirstHead;
                    ByteBuffer memory = chunkBuffer.getMemory();
                    int readPosition = chunkBuffer.getReadPosition();
                    int writePosition = chunkBuffer.getWritePosition();
                    for (int i3 = readPosition; i3 < writePosition; i3++) {
                        byte b = memory.get(i3);
                        int i4 = b & 255;
                        if ((b & 128) != 128) {
                            char c = (char) i4;
                            boolean z6 = z5;
                            if (kotlin.text.StringsKt.contains$default((CharSequence) delimiters, c, false, 2, (Object) null)) {
                                z3 = false;
                                z5 = true;
                            } else {
                                if (i2 == i) {
                                    bufferLimitExceeded(i);
                                    throw new KotlinNothingValueException();
                                }
                                i2++;
                                out.append(c);
                                z5 = z6;
                                z3 = true;
                            }
                            if (z3) {
                            }
                        }
                        chunkBuffer.discardExact(i3 - readPosition);
                        z2 = false;
                        break;
                    }
                    boolean z7 = z5;
                    chunkBuffer.discardExact(writePosition - readPosition);
                    z5 = z7;
                    z2 = true;
                    if (z2) {
                        try {
                            prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, prepareReadFirstHead);
                            if (prepareReadFirstHead == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                }
            }
            z4 = z5;
        }
        return !z4 ? readUTF8UntilDelimiterToSlowUtf8(input, out, delimiters, i, i2) : i2;
    }

    private static final void writeTextUtf8(Output output, CharSequence charSequence, int i, int i2) {
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        int i3 = i;
        while (true) {
            try {
                ChunkBuffer chunkBuffer = prepareWriteHead;
                CharSequence charSequence2 = charSequence;
                int i4 = i2;
                int m10228encodeUTF8lBXzO7A = UTF8Kt.m10228encodeUTF8lBXzO7A(chunkBuffer.getMemory(), charSequence2, i3, i4, chunkBuffer.getWritePosition(), chunkBuffer.getLimit());
                short m10217component1Mh2AYeg = EncodeResult.m10217component1Mh2AYeg(m10228encodeUTF8lBXzO7A);
                short m10218component2Mh2AYeg = EncodeResult.m10218component2Mh2AYeg(m10228encodeUTF8lBXzO7A);
                int i5 = m10217component1Mh2AYeg & UShort.MAX_VALUE;
                i3 += i5;
                chunkBuffer.commitWritten(m10218component2Mh2AYeg & UShort.MAX_VALUE);
                int i6 = (i5 != 0 || i3 >= i4) ? i3 < i4 ? 1 : 0 : 8;
                if (i6 <= 0) {
                    return;
                }
                prepareWriteHead = UnsafeKt.prepareWriteHead(output, i6, prepareWriteHead);
                charSequence = charSequence2;
                i2 = i4;
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    private static final int readUTFUntilDelimiterToSlowAscii(Input input, String str, int i, Output output) {
        int i2;
        boolean z;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (prepareReadFirstHead == null) {
            z4 = false;
            i2 = 0;
        } else {
            i2 = 0;
            boolean z6 = false;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer = prepareReadFirstHead;
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    ByteBuffer memory = chunkBuffer.getMemory();
                    int readPosition = chunkBuffer.getReadPosition();
                    int writePosition2 = chunkBuffer.getWritePosition();
                    int i4 = readPosition;
                    while (i4 < writePosition2) {
                        byte b = memory.get(i4);
                        int i5 = b & 255;
                        if ((b & 128) != 128) {
                            boolean z7 = z6;
                            i3 = writePosition;
                            z2 = false;
                            if (kotlin.text.StringsKt.contains$default((CharSequence) str, (char) i5, false, 2, (Object) null)) {
                                z5 = false;
                                z6 = true;
                            } else {
                                if (i2 == i) {
                                    bufferLimitExceeded(i);
                                    throw new KotlinNothingValueException();
                                }
                                i2++;
                                z6 = z7;
                                z5 = true;
                            }
                            if (z5) {
                                i4++;
                                writePosition = i3;
                            }
                        } else {
                            i3 = writePosition;
                            z2 = false;
                        }
                        chunkBuffer.discardExact(i4 - readPosition);
                        z3 = z2;
                        break;
                    }
                    i3 = writePosition;
                    z2 = false;
                    chunkBuffer.discardExact(writePosition2 - readPosition);
                    z6 = z6;
                    z3 = true;
                    int writePosition3 = i3 - (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
                    if (writePosition3 > 0) {
                        chunkBuffer.rewind(writePosition3);
                        OutputKt.writeFully(output, chunkBuffer, writePosition3);
                    }
                    if (z3) {
                        try {
                            prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, prepareReadFirstHead);
                            if (prepareReadFirstHead == null) {
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = z2;
                            if (z) {
                                UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                }
            }
            z4 = z6;
        }
        return (z4 || input.getEndOfInput()) ? i2 : readUTF8UntilDelimiterToSlowUtf8(input, output, str, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x01d9, code lost:
    
        if (r7 == 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01db, code lost:
    
        io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r20, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x01de, code lost:
    
        r5 = r6;
        r8 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int readUTF8UntilDelimiterToSlowUtf8(Input input, Output output, String str, int i, int i2) {
        int i3;
        ChunkBuffer chunkBuffer;
        int i4;
        int i5;
        int i6;
        int i7;
        ByteBuffer byteBuffer;
        int i8;
        int i9;
        int i10;
        int i11;
        ChunkBuffer prepareReadNextHead;
        int i12;
        int i13;
        int i14;
        int i15 = 1;
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (prepareReadFirstHead == null) {
            i3 = i2;
            i13 = 1;
            i14 = 1;
        } else {
            int i16 = 1;
            int i17 = 1;
            ChunkBuffer chunkBuffer2 = prepareReadFirstHead;
            i3 = i2;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i16) {
                        try {
                            ChunkBuffer chunkBuffer3 = chunkBuffer2;
                            int writePosition2 = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                            ByteBuffer memory = chunkBuffer3.getMemory();
                            int readPosition = chunkBuffer3.getReadPosition();
                            int writePosition3 = chunkBuffer3.getWritePosition();
                            int i18 = readPosition;
                            int i19 = 0;
                            int i20 = 0;
                            int i21 = 0;
                            while (i18 < writePosition3) {
                                i4 = i15;
                                byte b = memory.get(i18);
                                int i22 = b & 255;
                                if ((b & 128) != 0) {
                                    i5 = writePosition2;
                                    byteBuffer = memory;
                                    if (i19 == 0) {
                                        int i23 = 128;
                                        i20 = i22;
                                        for (int i24 = i4; i24 < 7 && (i20 & i23) != 0; i24++) {
                                            i20 &= ~i23;
                                            i23 >>= 1;
                                            i19++;
                                        }
                                        int i25 = i19 - 1;
                                        if (i19 > writePosition3 - i18) {
                                            chunkBuffer3.discardExact(i18 - readPosition);
                                            i7 = i19;
                                            i6 = 0;
                                            break;
                                        }
                                        i21 = i19;
                                        i19 = i25;
                                    } else {
                                        i20 = (i20 << 6) | (b & Byte.MAX_VALUE);
                                        i19--;
                                        if (i19 == 0) {
                                            if (!UTF8Kt.isBmpCodePoint(i20)) {
                                                if (!UTF8Kt.isValidCodePoint(i20)) {
                                                    UTF8Kt.malformedCodePoint(i20);
                                                    throw new KotlinNothingValueException();
                                                }
                                                if (kotlin.text.StringsKt.contains$default((CharSequence) str, (char) UTF8Kt.highSurrogate(i20), false, 2, (Object) null)) {
                                                    i8 = 0;
                                                } else {
                                                    if (i3 == i) {
                                                        bufferLimitExceeded(i);
                                                        throw new KotlinNothingValueException();
                                                    }
                                                    i3++;
                                                    i8 = i4;
                                                }
                                                if (i8 != 0) {
                                                    i6 = 0;
                                                    if (kotlin.text.StringsKt.contains$default((CharSequence) str, (char) UTF8Kt.lowSurrogate(i20), false, 2, (Object) null)) {
                                                        i9 = 0;
                                                    } else {
                                                        if (i3 == i) {
                                                            bufferLimitExceeded(i);
                                                            throw new KotlinNothingValueException();
                                                        }
                                                        i3++;
                                                        i9 = i4;
                                                    }
                                                    if (i9 == 0) {
                                                    }
                                                } else {
                                                    i6 = 0;
                                                }
                                                chunkBuffer3.discardExact(((i18 - readPosition) - i21) + 1);
                                                i7 = -1;
                                                break;
                                            }
                                            if (kotlin.text.StringsKt.contains$default((CharSequence) str, (char) i20, false, 2, (Object) null)) {
                                                i10 = 0;
                                            } else {
                                                if (i3 == i) {
                                                    bufferLimitExceeded(i);
                                                    throw new KotlinNothingValueException();
                                                }
                                                i3++;
                                                i10 = i4;
                                            }
                                            if (i10 == 0) {
                                                chunkBuffer3.discardExact(((i18 - readPosition) - i21) + 1);
                                                i7 = -1;
                                                i6 = 0;
                                                break;
                                            }
                                            i6 = 0;
                                            i20 = i6;
                                        }
                                    }
                                    i18++;
                                    i15 = i4;
                                    writePosition2 = i5;
                                    memory = byteBuffer;
                                } else {
                                    if (i19 != 0) {
                                        UTF8Kt.malformedByteCount(i19);
                                        throw new KotlinNothingValueException();
                                    }
                                    i5 = writePosition2;
                                    byteBuffer = memory;
                                    if (kotlin.text.StringsKt.contains$default((CharSequence) str, (char) i22, false, 2, (Object) null)) {
                                        i11 = 0;
                                    } else {
                                        if (i3 == i) {
                                            bufferLimitExceeded(i);
                                            throw new KotlinNothingValueException();
                                        }
                                        i3++;
                                        i11 = i4;
                                    }
                                    if (i11 == 0) {
                                        chunkBuffer3.discardExact(i18 - readPosition);
                                        i7 = -1;
                                        i6 = 0;
                                        break;
                                    }
                                    i18++;
                                    i15 = i4;
                                    writePosition2 = i5;
                                    memory = byteBuffer;
                                }
                            }
                            i4 = i15;
                            i5 = writePosition2;
                            i6 = 0;
                            chunkBuffer3.discardExact(writePosition3 - readPosition);
                            i7 = 0;
                            int writePosition4 = i5 - (chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition());
                            if (writePosition4 > 0) {
                                chunkBuffer3.rewind(writePosition4);
                                OutputKt.writeFully(output, chunkBuffer3, writePosition4);
                            }
                            i16 = i7 == -1 ? i6 : RangesKt.coerceAtLeast(i7, i4);
                            try {
                                ChunkBuffer chunkBuffer4 = chunkBuffer2;
                                writePosition = chunkBuffer4.getWritePosition() - chunkBuffer4.getReadPosition();
                                i17 = i16;
                            } catch (Throwable th) {
                                th = th;
                                i15 = 1;
                                if (i15 != 0) {
                                }
                                throw th;
                            }
                        } finally {
                            chunkBuffer = chunkBuffer2;
                            chunkBuffer.getWritePosition();
                            chunkBuffer.getReadPosition();
                        }
                    } else {
                        i6 = 0;
                    }
                    if (writePosition == 0) {
                        try {
                            prepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBuffer2);
                        } catch (Throwable th2) {
                            th = th2;
                            i15 = i6;
                            if (i15 != 0) {
                                UnsafeKt.completeReadHead(input, chunkBuffer2);
                            }
                            throw th;
                        }
                    } else {
                        if (writePosition >= i16) {
                            ChunkBuffer chunkBuffer5 = chunkBuffer2;
                            if (chunkBuffer5.getCapacity() - chunkBuffer5.getLimit() >= 8) {
                                prepareReadNextHead = chunkBuffer2;
                            }
                        }
                        UnsafeKt.completeReadHead(input, chunkBuffer2);
                        prepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i16);
                    }
                    if (prepareReadNextHead == null) {
                        i12 = i6;
                        break;
                    }
                    chunkBuffer2 = prepareReadNextHead;
                    if (i16 <= 0) {
                        i12 = 1;
                        break;
                    }
                    i15 = 1;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
        if (i13 <= i14) {
            return i3;
        }
        prematureEndOfStream(i13);
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x01ca, code lost:
    
        if (r8 == 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01cc, code lost:
    
        io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r20, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x01cf, code lost:
    
        r3 = r7;
        r8 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int readUTF8UntilDelimiterToSlowUtf8(Input input, Appendable appendable, String str, int i, int i2) {
        int i3;
        ChunkBuffer chunkBuffer;
        int i4;
        int i5;
        int i6;
        int i7;
        ByteBuffer byteBuffer;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        ChunkBuffer prepareReadNextHead;
        int i13;
        int i14;
        int i15 = 1;
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (prepareReadFirstHead == null) {
            i3 = i2;
            i14 = 1;
        } else {
            int i16 = 1;
            int i17 = 1;
            ChunkBuffer chunkBuffer2 = prepareReadFirstHead;
            i3 = i2;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i16) {
                        try {
                            try {
                                ChunkBuffer chunkBuffer3 = chunkBuffer2;
                                ByteBuffer memory = chunkBuffer3.getMemory();
                                int readPosition = chunkBuffer3.getReadPosition();
                                int writePosition2 = chunkBuffer3.getWritePosition();
                                int i18 = readPosition;
                                int i19 = 0;
                                int i20 = 0;
                                int i21 = 0;
                                while (i18 < writePosition2) {
                                    i4 = i15;
                                    byte b = memory.get(i18);
                                    int i22 = b & 255;
                                    if ((b & 128) != 0) {
                                        byteBuffer = memory;
                                        i8 = readPosition;
                                        if (i19 == 0) {
                                            int i23 = 128;
                                            i20 = i22;
                                            for (int i24 = i4; i24 < 7 && (i20 & i23) != 0; i24++) {
                                                i20 &= ~i23;
                                                i23 >>= 1;
                                                i19++;
                                            }
                                            int i25 = i19 - 1;
                                            if (i19 > writePosition2 - i18) {
                                                chunkBuffer3.discardExact(i18 - i8);
                                                i6 = i19;
                                                i7 = -1;
                                                i5 = 0;
                                                break;
                                            }
                                            i21 = i19;
                                            i19 = i25;
                                        } else {
                                            i20 = (i20 << 6) | (b & Byte.MAX_VALUE);
                                            i19--;
                                            if (i19 == 0) {
                                                if (!UTF8Kt.isBmpCodePoint(i20)) {
                                                    if (!UTF8Kt.isValidCodePoint(i20)) {
                                                        UTF8Kt.malformedCodePoint(i20);
                                                        throw new KotlinNothingValueException();
                                                    }
                                                    char highSurrogate = (char) UTF8Kt.highSurrogate(i20);
                                                    if (kotlin.text.StringsKt.contains$default((CharSequence) str, highSurrogate, false, 2, (Object) null)) {
                                                        i9 = 0;
                                                    } else {
                                                        if (i3 == i) {
                                                            bufferLimitExceeded(i);
                                                            throw new KotlinNothingValueException();
                                                        }
                                                        i3++;
                                                        appendable.append(highSurrogate);
                                                        i9 = i4;
                                                    }
                                                    if (i9 != 0) {
                                                        char lowSurrogate = (char) UTF8Kt.lowSurrogate(i20);
                                                        i5 = 0;
                                                        if (kotlin.text.StringsKt.contains$default((CharSequence) str, lowSurrogate, false, 2, (Object) null)) {
                                                            i10 = 0;
                                                        } else {
                                                            if (i3 == i) {
                                                                bufferLimitExceeded(i);
                                                                throw new KotlinNothingValueException();
                                                            }
                                                            i3++;
                                                            appendable.append(lowSurrogate);
                                                            i10 = i4;
                                                        }
                                                        if (i10 == 0) {
                                                        }
                                                    } else {
                                                        i5 = 0;
                                                    }
                                                    chunkBuffer3.discardExact(((i18 - i8) - i21) + 1);
                                                    i7 = -1;
                                                    i6 = -1;
                                                    break;
                                                }
                                                char c = (char) i20;
                                                if (kotlin.text.StringsKt.contains$default((CharSequence) str, c, false, 2, (Object) null)) {
                                                    i11 = 0;
                                                } else {
                                                    if (i3 == i) {
                                                        bufferLimitExceeded(i);
                                                        throw new KotlinNothingValueException();
                                                    }
                                                    i3++;
                                                    appendable.append(c);
                                                    i11 = i4;
                                                }
                                                if (i11 == 0) {
                                                    chunkBuffer3.discardExact(((i18 - i8) - i21) + 1);
                                                    i7 = -1;
                                                    i6 = -1;
                                                    i5 = 0;
                                                    break;
                                                }
                                                i5 = 0;
                                                i20 = i5;
                                            }
                                        }
                                        i18++;
                                        i15 = i4;
                                        memory = byteBuffer;
                                        readPosition = i8;
                                    } else {
                                        if (i19 != 0) {
                                            UTF8Kt.malformedByteCount(i19);
                                            throw new KotlinNothingValueException();
                                        }
                                        char c2 = (char) i22;
                                        byteBuffer = memory;
                                        i8 = readPosition;
                                        if (kotlin.text.StringsKt.contains$default((CharSequence) str, c2, false, 2, (Object) null)) {
                                            i12 = 0;
                                        } else {
                                            if (i3 == i) {
                                                bufferLimitExceeded(i);
                                                throw new KotlinNothingValueException();
                                            }
                                            i3++;
                                            appendable.append(c2);
                                            i12 = i4;
                                        }
                                        if (i12 == 0) {
                                            chunkBuffer3.discardExact(i18 - i8);
                                            i7 = -1;
                                            i6 = -1;
                                            i5 = 0;
                                            break;
                                        }
                                        i18++;
                                        i15 = i4;
                                        memory = byteBuffer;
                                        readPosition = i8;
                                    }
                                }
                                i4 = i15;
                                i5 = 0;
                                chunkBuffer3.discardExact(writePosition2 - readPosition);
                                i6 = 0;
                                i7 = -1;
                                i16 = i6 == i7 ? i5 : RangesKt.coerceAtLeast(i6, i4);
                                ChunkBuffer chunkBuffer4 = chunkBuffer2;
                                writePosition = chunkBuffer4.getWritePosition() - chunkBuffer4.getReadPosition();
                                i17 = i16;
                            } finally {
                                chunkBuffer = chunkBuffer2;
                                chunkBuffer.getWritePosition();
                                chunkBuffer.getReadPosition();
                            }
                        } catch (Throwable th) {
                            th = th;
                            i15 = 1;
                            if (i15 != 0) {
                            }
                            throw th;
                        }
                    } else {
                        i5 = 0;
                    }
                    if (writePosition == 0) {
                        try {
                            prepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBuffer2);
                        } catch (Throwable th2) {
                            th = th2;
                            i15 = i5;
                            if (i15 != 0) {
                                UnsafeKt.completeReadHead(input, chunkBuffer2);
                            }
                            throw th;
                        }
                    } else {
                        if (writePosition >= i16) {
                            ChunkBuffer chunkBuffer5 = chunkBuffer2;
                            if (chunkBuffer5.getCapacity() - chunkBuffer5.getLimit() >= 8) {
                                prepareReadNextHead = chunkBuffer2;
                            }
                        }
                        UnsafeKt.completeReadHead(input, chunkBuffer2);
                        prepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i16);
                    }
                    if (prepareReadNextHead == null) {
                        i13 = i5;
                        break;
                    }
                    chunkBuffer2 = prepareReadNextHead;
                    if (i16 <= 0) {
                        i13 = 1;
                        break;
                    }
                    i15 = 1;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
        if (i15 <= i14) {
            return i3;
        }
        prematureEndOfStream(i15);
        throw new KotlinNothingValueException();
    }
}
