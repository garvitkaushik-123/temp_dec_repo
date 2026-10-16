package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnsignedTypes.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0087\bø\u0001\u0001¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u0017*\u00020\u0002H\u0087\bø\u0001\u0001¢\u0006\u0002\u0010\u0018\u001a\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u0002H\u0087\bø\u0001\u0001¢\u0006\u0002\u0010\u001b\u001a\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\u0002H\u0087\bø\u0001\u0001¢\u0006\u0002\u0010\u001e\u001a6\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a6\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a6\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u001a6\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a\"\u0010*\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a\"\u0010.\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u0017H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001a\"\u00101\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u001aH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001a\"\u00104\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u001dH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"readFully", "", "Lio/ktor/utils/io/core/Input;", "dst", "Lkotlin/UByteArray;", "offset", "", "length", "readFully-o1GoV1E", "(Lio/ktor/utils/io/core/Input;[BII)V", "Lkotlin/UIntArray;", "readFully-o2ZM2JE", "(Lio/ktor/utils/io/core/Input;[III)V", "Lkotlin/ULongArray;", "readFully-pqYNikA", "(Lio/ktor/utils/io/core/Input;[JII)V", "Lkotlin/UShortArray;", "readFully-Wt3Bwxc", "(Lio/ktor/utils/io/core/Input;[SII)V", "readUByte", "Lkotlin/UByte;", "(Lio/ktor/utils/io/core/Input;)B", "readUInt", "Lkotlin/UInt;", "(Lio/ktor/utils/io/core/Input;)I", "readULong", "Lkotlin/ULong;", "(Lio/ktor/utils/io/core/Input;)J", "readUShort", "Lkotlin/UShort;", "(Lio/ktor/utils/io/core/Input;)S", "writeFully", "Lio/ktor/utils/io/core/Output;", "array", "writeFully-o1GoV1E", "(Lio/ktor/utils/io/core/Output;[BII)V", "writeFully-o2ZM2JE", "(Lio/ktor/utils/io/core/Output;[III)V", "writeFully-pqYNikA", "(Lio/ktor/utils/io/core/Output;[JII)V", "writeFully-Wt3Bwxc", "(Lio/ktor/utils/io/core/Output;[SII)V", "writeUByte", "v", "writeUByte-EK-6454", "(Lio/ktor/utils/io/core/Output;B)V", "writeUInt", "writeUInt-Qn1smSk", "(Lio/ktor/utils/io/core/Output;I)V", "writeULong", "writeULong-2TYgG_w", "(Lio/ktor/utils/io/core/Output;J)V", "writeUShort", "writeUShort-i8woANY", "(Lio/ktor/utils/io/core/Output;S)V", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class UnsignedTypesKt {
    public static final byte readUByte(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return UByte.m10259constructorimpl(input.readByte());
    }

    public static final short readUShort(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return UShort.m10522constructorimpl(InputPrimitivesKt.readShort(input));
    }

    public static final int readUInt(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return UInt.m10336constructorimpl(InputPrimitivesKt.readInt(input));
    }

    public static final long readULong(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return ULong.m10415constructorimpl(InputPrimitivesKt.readLong(input));
    }

    /* renamed from: readFully-o1GoV1E$default, reason: not valid java name */
    public static /* synthetic */ void m10199readFullyo1GoV1E$default(Input readFully, byte[] dst, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m10318getSizeimpl(dst) - i;
        }
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* renamed from: readFully-o1GoV1E, reason: not valid java name */
    public static final void m10198readFullyo1GoV1E(Input readFully, byte[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* renamed from: readFully-Wt3Bwxc$default, reason: not valid java name */
    public static /* synthetic */ void m10197readFullyWt3Bwxc$default(Input readFully, short[] dst, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m10581getSizeimpl(dst) - i;
        }
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* renamed from: readFully-Wt3Bwxc, reason: not valid java name */
    public static final void m10196readFullyWt3Bwxc(Input readFully, short[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* renamed from: readFully-o2ZM2JE$default, reason: not valid java name */
    public static /* synthetic */ void m10201readFullyo2ZM2JE$default(Input readFully, int[] dst, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m10397getSizeimpl(dst) - i;
        }
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* renamed from: readFully-o2ZM2JE, reason: not valid java name */
    public static final void m10200readFullyo2ZM2JE(Input readFully, int[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* renamed from: readFully-pqYNikA$default, reason: not valid java name */
    public static /* synthetic */ void m10203readFullypqYNikA$default(Input readFully, long[] dst, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m10476getSizeimpl(dst) - i;
        }
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* renamed from: readFully-pqYNikA, reason: not valid java name */
    public static final void m10202readFullypqYNikA(Input readFully, long[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(dst, "dst");
        InputArraysKt.readFully(readFully, dst, i, i2);
    }

    /* renamed from: writeUByte-EK-6454, reason: not valid java name */
    public static final void m10212writeUByteEK6454(Output writeUByte, byte b) {
        Intrinsics.checkNotNullParameter(writeUByte, "$this$writeUByte");
        writeUByte.writeByte(b);
    }

    /* renamed from: writeUShort-i8woANY, reason: not valid java name */
    public static final void m10215writeUShorti8woANY(Output writeUShort, short s) {
        Intrinsics.checkNotNullParameter(writeUShort, "$this$writeUShort");
        OutputPrimitivesKt.writeShort(writeUShort, s);
    }

    /* renamed from: writeUInt-Qn1smSk, reason: not valid java name */
    public static final void m10213writeUIntQn1smSk(Output writeUInt, int i) {
        Intrinsics.checkNotNullParameter(writeUInt, "$this$writeUInt");
        OutputPrimitivesKt.writeInt(writeUInt, i);
    }

    /* renamed from: writeULong-2TYgG_w, reason: not valid java name */
    public static final void m10214writeULong2TYgG_w(Output writeULong, long j) {
        Intrinsics.checkNotNullParameter(writeULong, "$this$writeULong");
        OutputPrimitivesKt.writeLong(writeULong, j);
    }

    /* renamed from: writeFully-o1GoV1E$default, reason: not valid java name */
    public static /* synthetic */ void m10207writeFullyo1GoV1E$default(Output writeFully, byte[] array, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m10318getSizeimpl(array) - i;
        }
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* renamed from: writeFully-o1GoV1E, reason: not valid java name */
    public static final void m10206writeFullyo1GoV1E(Output writeFully, byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* renamed from: writeFully-Wt3Bwxc$default, reason: not valid java name */
    public static /* synthetic */ void m10205writeFullyWt3Bwxc$default(Output writeFully, short[] array, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m10581getSizeimpl(array) - i;
        }
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* renamed from: writeFully-Wt3Bwxc, reason: not valid java name */
    public static final void m10204writeFullyWt3Bwxc(Output writeFully, short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* renamed from: writeFully-o2ZM2JE$default, reason: not valid java name */
    public static /* synthetic */ void m10209writeFullyo2ZM2JE$default(Output writeFully, int[] array, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m10397getSizeimpl(array) - i;
        }
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* renamed from: writeFully-o2ZM2JE, reason: not valid java name */
    public static final void m10208writeFullyo2ZM2JE(Output writeFully, int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* renamed from: writeFully-pqYNikA$default, reason: not valid java name */
    public static /* synthetic */ void m10211writeFullypqYNikA$default(Output writeFully, long[] array, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m10476getSizeimpl(array) - i;
        }
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }

    /* renamed from: writeFully-pqYNikA, reason: not valid java name */
    public static final void m10210writeFullypqYNikA(Output writeFully, long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(array, "array");
        OutputKt.writeFully(writeFully, array, i, i2);
    }
}
