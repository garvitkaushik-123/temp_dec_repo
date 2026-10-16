package io.ktor.utils.io.charsets;

import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: UTF.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001a\"\u0010\u001f\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001\u001a&\u0010#\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u0001\u001a$\u0010$\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\u001a$\u0010%\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\u001a$\u0010&\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\u001a9\u0010&\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150(H\u0082\b\u001a$\u0010*\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\u001a9\u0010*\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150(H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"HighSurrogateMagic", "", "MaxCodePoint", "MinHighSurrogate", "MinLowSurrogate", "MinSupplementary", "decodeUtf8Result", "", "numberOfChars", "requireBytes", "decodeUtf8ResultAcc", "preDecoded", "result", "highSurrogate", "cp", "indexOutOfBounds", "", "offset", "length", "arrayLength", "isBmpCodePoint", "", "isValidCodePoint", "codePoint", "lowSurrogate", "malformedCodePoint", "", "value", "unsupportedByteCount", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "decodeUTF", "Ljava/nio/ByteBuffer;", "out", "", "decodeUTF8Line", "decodeUTF8Line_array", "decodeUTF8Line_buffer", "decodeUTF8_array", "predicate", "Lkotlin/Function1;", "", "decodeUTF8_buffer", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class UTFKt {
    private static final int HighSurrogateMagic = 55232;
    private static final int MaxCodePoint = 1114111;
    private static final int MinHighSurrogate = 55296;
    private static final int MinLowSurrogate = 56320;
    private static final int MinSupplementary = 65536;

    public static final long decodeUtf8Result(int i, int i2) {
        return (i2 & 4294967295L) | (i << 32);
    }

    private static final int highSurrogate(int i) {
        return (i >>> 10) + 55232;
    }

    private static final boolean isBmpCodePoint(int i) {
        return (i >>> 16) == 0;
    }

    private static final boolean isValidCodePoint(int i) {
        return i <= MaxCodePoint;
    }

    private static final int lowSurrogate(int i) {
        return (i & 1023) + 56320;
    }

    public static final long decodeUtf8ResultAcc(int i, long j) {
        return decodeUtf8Result(i + ((int) (j >> 32)), (int) (j & 4294967295L));
    }

    public static final long decodeUTF(ByteBuffer byteBuffer, char[] out, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        int decodeASCII = StringsKt.decodeASCII(byteBuffer, out, i, i2);
        if (!byteBuffer.hasRemaining() || decodeASCII == i2) {
            return decodeUtf8Result(decodeASCII, 0);
        }
        return byteBuffer.hasArray() ? decodeUtf8ResultAcc(decodeASCII, decodeUTF8_array(byteBuffer, out, i + decodeASCII, i2 - decodeASCII)) : decodeUtf8ResultAcc(decodeASCII, decodeUTF8_buffer(byteBuffer, out, i + decodeASCII, i2 - decodeASCII));
    }

    public static /* synthetic */ long decodeUTF8Line$default(ByteBuffer byteBuffer, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return decodeUTF8Line(byteBuffer, cArr, i, i2);
    }

    public static final long decodeUTF8Line(ByteBuffer byteBuffer, char[] out, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        return byteBuffer.hasArray() ? decodeUTF8Line_array(byteBuffer, out, i, i2) : decodeUTF8Line_buffer(byteBuffer, out, i, i2);
    }

    private static final long decodeUTF8_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        int i3;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int remaining = byteBuffer.remaining() + arrayOffset;
        if (arrayOffset > remaining) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (remaining > array.length) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i4 = i + i2;
        if (i4 > cArr.length) {
            throw indexOutOfBounds(i, i2, cArr.length);
        }
        int i5 = i;
        while (arrayOffset < remaining && i5 < i4) {
            int i6 = arrayOffset + 1;
            byte b = array[arrayOffset];
            if (b >= 0) {
                cArr[i5] = (char) b;
                i5++;
                arrayOffset = i6;
            } else {
                if ((b & 224) == 192) {
                    if (i6 >= remaining) {
                        byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                        return decodeUtf8Result(i5 - i, 2);
                    }
                    arrayOffset += 2;
                    byte b2 = array[i6];
                    i3 = i5 + 1;
                    cArr[i5] = (char) ((b2 & 63) | ((b & Ascii.US) << 6));
                } else if ((b & 240) == 224) {
                    if (remaining - i6 < 2) {
                        byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                        return decodeUtf8Result(i5 - i, 3);
                    }
                    int i7 = arrayOffset + 2;
                    byte b3 = array[i6];
                    arrayOffset += 3;
                    byte b4 = array[i7];
                    int i8 = b & Ascii.SI;
                    int i9 = b4 & 63;
                    int i10 = i9 | ((b3 & 63) << 6) | (i8 << 12);
                    if (i8 == 0 || isBmpCodePoint(i10)) {
                        i3 = i5 + 1;
                        cArr[i5] = (char) i10;
                    } else {
                        malformedCodePoint(i10);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    if ((b & 248) != 240) {
                        unsupportedByteCount(b);
                        throw new KotlinNothingValueException();
                    }
                    if (remaining - i6 < 3) {
                        byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                        return decodeUtf8Result(i5 - i, 4);
                    }
                    byte b5 = array[i6];
                    int i11 = arrayOffset + 4;
                    int i12 = (b5 & 63) << 12;
                    int i13 = i12 | ((b & 7) << 18) | ((array[arrayOffset + 2] & 63) << 6) | (array[arrayOffset + 3] & 63);
                    if (!isValidCodePoint(i13)) {
                        malformedCodePoint(i13);
                        throw new KotlinNothingValueException();
                    }
                    if (i4 - i5 >= 2) {
                        int highSurrogate = highSurrogate(i13);
                        int lowSurrogate = lowSurrogate(i13);
                        int i14 = i5 + 1;
                        cArr[i5] = (char) highSurrogate;
                        i5 += 2;
                        cArr[i14] = (char) lowSurrogate;
                        arrayOffset = i11;
                    } else {
                        byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                        return decodeUtf8Result(i5 - i, 0);
                    }
                }
                i5 = i3;
            }
        }
        byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
        return decodeUtf8Result(i5 - i, 0);
    }

    private static final long decodeUTF8_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        int i3 = i + i2;
        if (i3 > cArr.length) {
            throw indexOutOfBounds(i, i2, cArr.length);
        }
        int i4 = i;
        while (byteBuffer.hasRemaining() && i4 < i3) {
            byte b = byteBuffer.get();
            if (b >= 0) {
                cArr[i4] = (char) b;
                i4++;
            } else if ((b & 224) == 192) {
                if (byteBuffer.hasRemaining()) {
                    byteBuffer.position(byteBuffer.position() - 1);
                    return decodeUtf8Result(i4 - i, 2);
                }
                cArr[i4] = (char) (((b & Ascii.US) << 6) | (byteBuffer.get() & 63));
                i4++;
            } else if ((b & 240) == 224) {
                if (byteBuffer.remaining() < 2) {
                    byteBuffer.position(byteBuffer.position() - 1);
                    return decodeUtf8Result(i4 - i, 3);
                }
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                int i5 = b & Ascii.SI;
                int i6 = ((b2 & 63) << 6) | (i5 << 12) | (b3 & 63);
                if (i5 == 0 || isBmpCodePoint(i6)) {
                    cArr[i4] = (char) i6;
                    i4++;
                } else {
                    malformedCodePoint(i6);
                    throw new KotlinNothingValueException();
                }
            } else if ((b & 248) == 240) {
                if (byteBuffer.remaining() < 3) {
                    byteBuffer.position(byteBuffer.position() - 1);
                    return decodeUtf8Result(i4 - i, 4);
                }
                int i7 = ((b & 7) << 18) | ((byteBuffer.get() & 63) << 12) | ((byteBuffer.get() & 63) << 6) | (byteBuffer.get() & 63);
                if (!isValidCodePoint(i7)) {
                    malformedCodePoint(i7);
                    throw new KotlinNothingValueException();
                }
                if (i3 - i4 >= 2) {
                    int highSurrogate = highSurrogate(i7);
                    int lowSurrogate = lowSurrogate(i7);
                    int i8 = i4 + 1;
                    cArr[i4] = (char) highSurrogate;
                    i4 += 2;
                    cArr[i8] = (char) lowSurrogate;
                } else {
                    byteBuffer.position(byteBuffer.position() - 4);
                    return decodeUtf8Result(i4 - i, 0);
                }
            } else {
                unsupportedByteCount(b);
                throw new KotlinNothingValueException();
            }
        }
        return decodeUtf8Result(i4 - i, 0);
    }

    private static final long decodeUTF8_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int remaining = byteBuffer.remaining() + arrayOffset;
        if (arrayOffset > remaining) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (remaining > array.length) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i3 = i + i2;
        if (i3 > cArr.length) {
            throw indexOutOfBounds(i, i2, cArr.length);
        }
        int i4 = i;
        while (arrayOffset < remaining && i4 < i3) {
            int i5 = arrayOffset + 1;
            byte b = array[arrayOffset];
            if (b >= 0) {
                char c = (char) b;
                if (!function1.invoke(Character.valueOf(c)).booleanValue()) {
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    return decodeUtf8Result(i4 - i, -1);
                }
                cArr[i4] = c;
                i4++;
                arrayOffset = i5;
            } else if ((b & 224) == 192) {
                if (i5 >= remaining) {
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    return decodeUtf8Result(i4 - i, 2);
                }
                int i6 = arrayOffset + 2;
                char c2 = (char) ((array[i5] & 63) | ((b & Ascii.US) << 6));
                if (!function1.invoke(Character.valueOf(c2)).booleanValue()) {
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    return decodeUtf8Result(i4 - i, -1);
                }
                cArr[i4] = c2;
                i4++;
                arrayOffset = i6;
            } else if ((b & 240) == 224) {
                if (remaining - i5 < 2) {
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    return decodeUtf8Result(i4 - i, 3);
                }
                byte b2 = array[i5];
                int i7 = arrayOffset + 3;
                byte b3 = array[arrayOffset + 2];
                int i8 = b & Ascii.SI;
                int i9 = (b3 & 63) | ((b2 & 63) << 6) | (i8 << 12);
                if (i8 == 0 || isBmpCodePoint(i9)) {
                    char c3 = (char) i9;
                    if (!function1.invoke(Character.valueOf(c3)).booleanValue()) {
                        byteBuffer.position((arrayOffset - 1) - byteBuffer.arrayOffset());
                        return decodeUtf8Result(i4 - i, -1);
                    }
                    cArr[i4] = c3;
                    i4++;
                    arrayOffset = i7;
                } else {
                    malformedCodePoint(i9);
                    throw new KotlinNothingValueException();
                }
            } else {
                if ((b & 248) != 240) {
                    unsupportedByteCount(b);
                    throw new KotlinNothingValueException();
                }
                if (remaining - i5 < 3) {
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    return decodeUtf8Result(i4 - i, 4);
                }
                byte b4 = array[i5];
                int i10 = arrayOffset + 4;
                int i11 = ((array[arrayOffset + 2] & 63) << 6) | ((b4 & 63) << 12) | ((b & 7) << 18) | (array[arrayOffset + 3] & 63);
                if (!isValidCodePoint(i11)) {
                    malformedCodePoint(i11);
                    throw new KotlinNothingValueException();
                }
                if (i3 - i4 >= 2) {
                    char highSurrogate = (char) highSurrogate(i11);
                    char lowSurrogate = (char) lowSurrogate(i11);
                    if (!function1.invoke(Character.valueOf(highSurrogate)).booleanValue() || !function1.invoke(Character.valueOf(lowSurrogate)).booleanValue()) {
                        byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                        return decodeUtf8Result(i4 - i, -1);
                    }
                    int i12 = i4 + 1;
                    cArr[i4] = highSurrogate;
                    i4 += 2;
                    cArr[i12] = lowSurrogate;
                    arrayOffset = i10;
                } else {
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    return decodeUtf8Result(i4 - i, 0);
                }
            }
        }
        byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
        return decodeUtf8Result(i4 - i, 0);
    }

    private static final long decodeUTF8_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        int i4 = i + i2;
        if (i4 > cArr.length) {
            throw indexOutOfBounds(i, i2, cArr.length);
        }
        int i5 = i;
        while (byteBuffer.hasRemaining() && i5 < i4) {
            byte b = byteBuffer.get();
            if (b >= 0) {
                char c = (char) b;
                if (!function1.invoke(Character.valueOf(c)).booleanValue()) {
                    byteBuffer.position(byteBuffer.position() - 1);
                    return decodeUtf8Result(i5 - i, -1);
                }
                i3 = i5 + 1;
                cArr[i5] = c;
            } else if ((b & 224) == 192) {
                if (!byteBuffer.hasRemaining()) {
                    byteBuffer.position(byteBuffer.position() - 1);
                    return decodeUtf8Result(i5 - i, 2);
                }
                char c2 = (char) (((b & Ascii.US) << 6) | (byteBuffer.get() & 63));
                if (!function1.invoke(Character.valueOf(c2)).booleanValue()) {
                    byteBuffer.position(byteBuffer.position() - 2);
                    return decodeUtf8Result(i5 - i, -1);
                }
                i3 = i5 + 1;
                cArr[i5] = c2;
            } else if ((b & 240) == 224) {
                if (byteBuffer.remaining() < 2) {
                    byteBuffer.position(byteBuffer.position() - 1);
                    return decodeUtf8Result(i5 - i, 3);
                }
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                int i6 = b & Ascii.SI;
                int i7 = ((b2 & 63) << 6) | (i6 << 12) | (b3 & 63);
                if (i6 == 0 || isBmpCodePoint(i7)) {
                    char c3 = (char) i7;
                    if (!function1.invoke(Character.valueOf(c3)).booleanValue()) {
                        byteBuffer.position(byteBuffer.position() - 3);
                        return decodeUtf8Result(i5 - i, -1);
                    }
                    i3 = i5 + 1;
                    cArr[i5] = c3;
                } else {
                    malformedCodePoint(i7);
                    throw new KotlinNothingValueException();
                }
            } else if ((b & 248) == 240) {
                if (byteBuffer.remaining() < 3) {
                    byteBuffer.position(byteBuffer.position() - 1);
                    return decodeUtf8Result(i5 - i, 4);
                }
                int i8 = ((b & 7) << 18) | ((byteBuffer.get() & 63) << 12) | ((byteBuffer.get() & 63) << 6) | (byteBuffer.get() & 63);
                if (!isValidCodePoint(i8)) {
                    malformedCodePoint(i8);
                    throw new KotlinNothingValueException();
                }
                if (i4 - i5 >= 2) {
                    char highSurrogate = (char) highSurrogate(i8);
                    char lowSurrogate = (char) lowSurrogate(i8);
                    if (!function1.invoke(Character.valueOf(highSurrogate)).booleanValue() || !function1.invoke(Character.valueOf(lowSurrogate)).booleanValue()) {
                        byteBuffer.position(byteBuffer.position() - 4);
                        return decodeUtf8Result(i5 - i, -1);
                    }
                    int i9 = i5 + 1;
                    cArr[i5] = highSurrogate;
                    i5 += 2;
                    cArr[i9] = lowSurrogate;
                } else {
                    byteBuffer.position(byteBuffer.position() - 4);
                    return decodeUtf8Result(i5 - i, 0);
                }
            } else {
                unsupportedByteCount(b);
                throw new KotlinNothingValueException();
            }
            i5 = i3;
        }
        return decodeUtf8Result(i5 - i, 0);
    }

    private static final Throwable indexOutOfBounds(int i, int i2, int i3) {
        return new IndexOutOfBoundsException(i + " (offset) + " + i2 + " (length) > " + i3 + " (array.length)");
    }

    private static final Void malformedCodePoint(int i) {
        throw new IllegalArgumentException("Malformed code-point " + Integer.toHexString(i) + " found");
    }

    private static final Void unsupportedByteCount(byte b) {
        StringBuilder sb = new StringBuilder("Unsupported byte code, first byte is 0x");
        String num = Integer.toString(b & 255, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        throw new IllegalStateException(sb.append(kotlin.text.StringsKt.padStart(num, 2, '0')).toString().toString());
    }

    private static final long decodeUTF8Line_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        long decodeUtf8Result;
        boolean z;
        char c;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int remaining = byteBuffer.remaining() + arrayOffset;
        if (arrayOffset > remaining) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (remaining > array.length) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i3 = i + i2;
        if (i3 > cArr.length) {
            throw indexOutOfBounds(i, i2, cArr.length);
        }
        int i4 = i;
        boolean z6 = false;
        while (arrayOffset < remaining && i4 < i3) {
            int i5 = arrayOffset + 1;
            byte b = array[arrayOffset];
            if (b >= 0) {
                char c2 = (char) b;
                if (c2 == '\r') {
                    z6 = true;
                    z = true;
                } else {
                    if (c2 == '\n') {
                        z6 = false;
                    } else if (!z6) {
                        z = true;
                    }
                    z = false;
                }
                if (!z) {
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    decodeUtf8Result = decodeUtf8Result(i4 - i, -1);
                    break;
                }
                cArr[i4] = c2;
                i4++;
                arrayOffset = i5;
            } else if ((b & 224) == 192) {
                if (i5 >= remaining) {
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    decodeUtf8Result = decodeUtf8Result(i4 - i, 2);
                    break;
                }
                int i6 = arrayOffset + 2;
                char c3 = (char) ((array[i5] & 63) | ((b & Ascii.US) << 6));
                if (c3 == '\r') {
                    z6 = true;
                    z5 = true;
                } else {
                    if (c3 == '\n') {
                        z6 = false;
                    } else if (!z6) {
                        z5 = true;
                    }
                    z5 = false;
                }
                if (!z5) {
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    decodeUtf8Result = decodeUtf8Result(i4 - i, -1);
                    break;
                }
                cArr[i4] = c3;
                i4++;
                arrayOffset = i6;
            } else {
                if ((b & 240) != 224) {
                    if ((b & 248) != 240) {
                        unsupportedByteCount(b);
                        throw new KotlinNothingValueException();
                    }
                    if (remaining - i5 < 3) {
                        byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                        decodeUtf8Result = decodeUtf8Result(i4 - i, 4);
                        break;
                    }
                    byte b2 = array[i5];
                    i5 = arrayOffset + 4;
                    int i7 = ((array[arrayOffset + 2] & 63) << 6) | ((b2 & 63) << 12) | ((b & 7) << 18) | (array[arrayOffset + 3] & 63);
                    if (!isValidCodePoint(i7)) {
                        malformedCodePoint(i7);
                        throw new KotlinNothingValueException();
                    }
                    if (i3 - i4 >= 2) {
                        char highSurrogate = (char) highSurrogate(i7);
                        char lowSurrogate = (char) lowSurrogate(i7);
                        if (highSurrogate == '\r') {
                            z6 = true;
                            z2 = true;
                            c = '\n';
                        } else {
                            c = '\n';
                            if (highSurrogate == '\n') {
                                z6 = false;
                            } else if (!z6) {
                                z2 = true;
                            }
                            z2 = false;
                        }
                        if (z2) {
                            if (lowSurrogate == '\r') {
                                z6 = true;
                                z3 = true;
                            } else {
                                if (lowSurrogate == c) {
                                    z6 = false;
                                } else if (!z6) {
                                    z3 = true;
                                }
                                z3 = false;
                            }
                            if (z3) {
                                int i8 = i4 + 1;
                                cArr[i4] = highSurrogate;
                                i4 += 2;
                                cArr[i8] = lowSurrogate;
                                arrayOffset = i5;
                            }
                        }
                        byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                        decodeUtf8Result = decodeUtf8Result(i4 - i, -1);
                        break;
                    }
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    decodeUtf8Result = decodeUtf8Result(i4 - i, 0);
                    break;
                }
                if (remaining - i5 < 2) {
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    decodeUtf8Result = decodeUtf8Result(i4 - i, 3);
                    break;
                }
                byte b3 = array[i5];
                int i9 = arrayOffset + 3;
                byte b4 = array[arrayOffset + 2];
                int i10 = b & Ascii.SI;
                int i11 = (b4 & 63) | ((b3 & 63) << 6) | (i10 << 12);
                if (i10 != 0 && !isBmpCodePoint(i11)) {
                    malformedCodePoint(i11);
                    throw new KotlinNothingValueException();
                }
                char c4 = (char) i11;
                if (c4 == '\r') {
                    z6 = true;
                    z4 = true;
                } else {
                    if (c4 == '\n') {
                        z6 = false;
                    } else if (!z6) {
                        z4 = true;
                    }
                    z4 = false;
                }
                if (!z4) {
                    byteBuffer.position((arrayOffset - 1) - byteBuffer.arrayOffset());
                    decodeUtf8Result = decodeUtf8Result(i4 - i, -1);
                    break;
                }
                cArr[i4] = c4;
                i4++;
                arrayOffset = i9;
            }
        }
        byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
        decodeUtf8Result = decodeUtf8Result(i4 - i, 0);
        int i12 = (int) (4294967295L & decodeUtf8Result);
        if (i12 == -1) {
            int i13 = (int) (decodeUtf8Result >> 32);
            if (z6) {
                return decodeUtf8Result(i13 - 1, -1);
            }
            byteBuffer.position(byteBuffer.position() + 1);
            if (i13 > 0) {
                int i14 = i13 - 1;
                if (cArr[i14] == '\r') {
                    return decodeUtf8Result(i14, -1);
                }
            }
        } else if (i12 == 0 && z6) {
            int i15 = (int) (decodeUtf8Result >> 32);
            byteBuffer.position(byteBuffer.position() - 1);
            return decodeUtf8Result(i15 - 1, 2);
        }
        return decodeUtf8Result;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00ea A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final long decodeUTF8Line_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        long decodeUtf8Result;
        boolean z;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i4 = i + i2;
        if (i4 > cArr.length) {
            throw indexOutOfBounds(i, i2, cArr.length);
        }
        int i5 = i;
        boolean z6 = false;
        while (byteBuffer.hasRemaining() && i5 < i4) {
            byte b = byteBuffer.get();
            if (b >= 0) {
                char c = (char) b;
                if (c == '\r') {
                    z6 = true;
                } else if (c == '\n') {
                    z6 = false;
                } else {
                    z = !z6;
                    if (z) {
                        byteBuffer.position(byteBuffer.position() - 1);
                        decodeUtf8Result = decodeUtf8Result(i5 - i, -1);
                        break;
                    }
                    i3 = i5 + 1;
                    cArr[i5] = c;
                    i5 = i3;
                }
                z = z6;
                if (z) {
                }
            } else if ((b & 224) == 192) {
                if (!byteBuffer.hasRemaining()) {
                    byteBuffer.position(byteBuffer.position() - 1);
                    decodeUtf8Result = decodeUtf8Result(i5 - i, 2);
                    break;
                }
                char c2 = (char) (((b & Ascii.US) << 6) | (byteBuffer.get() & 63));
                if (c2 == '\r') {
                    z6 = true;
                } else if (c2 == '\n') {
                    z6 = false;
                } else {
                    z2 = !z6;
                    if (z2) {
                        byteBuffer.position(byteBuffer.position() - 2);
                        decodeUtf8Result = decodeUtf8Result(i5 - i, -1);
                        break;
                    }
                    i3 = i5 + 1;
                    cArr[i5] = c2;
                    i5 = i3;
                }
                z2 = z6;
                if (z2) {
                }
            } else {
                if ((b & 240) != 224) {
                    if ((b & 248) == 240) {
                        if (byteBuffer.remaining() < 3) {
                            byteBuffer.position(byteBuffer.position() - 1);
                            decodeUtf8Result = decodeUtf8Result(i5 - i, 4);
                            break;
                        }
                        int i6 = ((b & 7) << 18) | ((byteBuffer.get() & 63) << 12) | ((byteBuffer.get() & 63) << 6) | (byteBuffer.get() & 63);
                        if (!isValidCodePoint(i6)) {
                            malformedCodePoint(i6);
                            throw new KotlinNothingValueException();
                        }
                        if (i4 - i5 >= 2) {
                            char highSurrogate = (char) highSurrogate(i6);
                            char lowSurrogate = (char) lowSurrogate(i6);
                            if (highSurrogate != '\r') {
                                if (highSurrogate != '\n') {
                                    z4 = !z6;
                                    if (z4) {
                                        if (lowSurrogate == '\r') {
                                            z6 = true;
                                        } else if (lowSurrogate == '\n') {
                                            z6 = false;
                                        } else {
                                            z5 = !z6;
                                            if (!z5) {
                                                int i7 = i5 + 1;
                                                cArr[i5] = highSurrogate;
                                                i5 += 2;
                                                cArr[i7] = lowSurrogate;
                                            }
                                        }
                                        z5 = z6;
                                        if (!z5) {
                                        }
                                    }
                                    byteBuffer.position(byteBuffer.position() - 4);
                                    decodeUtf8Result = decodeUtf8Result(i5 - i, -1);
                                    break;
                                }
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            z4 = z6;
                            if (z4) {
                            }
                            byteBuffer.position(byteBuffer.position() - 4);
                            decodeUtf8Result = decodeUtf8Result(i5 - i, -1);
                            break;
                        }
                        byteBuffer.position(byteBuffer.position() - 4);
                        decodeUtf8Result = decodeUtf8Result(i5 - i, 0);
                        break;
                    }
                    unsupportedByteCount(b);
                    throw new KotlinNothingValueException();
                }
                if (byteBuffer.remaining() < 2) {
                    byteBuffer.position(byteBuffer.position() - 1);
                    decodeUtf8Result = decodeUtf8Result(i5 - i, 3);
                    break;
                }
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                int i8 = b & Ascii.SI;
                int i9 = (i8 << 12) | ((b2 & 63) << 6) | (b3 & 63);
                if (i8 != 0 && !isBmpCodePoint(i9)) {
                    malformedCodePoint(i9);
                    throw new KotlinNothingValueException();
                }
                char c3 = (char) i9;
                if (c3 == '\r') {
                    z6 = true;
                } else if (c3 == '\n') {
                    z6 = false;
                } else {
                    z3 = !z6;
                    if (z3) {
                        byteBuffer.position(byteBuffer.position() - 3);
                        decodeUtf8Result = decodeUtf8Result(i5 - i, -1);
                        break;
                    }
                    i3 = i5 + 1;
                    cArr[i5] = c3;
                    i5 = i3;
                }
                z3 = z6;
                if (z3) {
                }
            }
        }
        decodeUtf8Result = decodeUtf8Result(i5 - i, 0);
        int i10 = (int) (4294967295L & decodeUtf8Result);
        if (i10 == -1) {
            int i11 = (int) (decodeUtf8Result >> 32);
            if (z6) {
                return decodeUtf8Result(i11 - 1, -1);
            }
            byteBuffer.position(byteBuffer.position() + 1);
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (cArr[i12] == '\r') {
                    return decodeUtf8Result(i12, -1);
                }
            }
        } else if (i10 == 0 && z6) {
            int i13 = (int) (decodeUtf8Result >> 32);
            byteBuffer.position(byteBuffer.position() - 1);
            return decodeUtf8Result(i13 - 1, 2);
        }
        return decodeUtf8Result;
    }
}
