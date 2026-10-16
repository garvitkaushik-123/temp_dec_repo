package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UArraySorting.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class UArraySortingKt {
    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m10697partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m10317getw2LRezQ = UByteArray.m10317getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m10317getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m10317getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m10317getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m10317getw2LRezQ2 = UByteArray.m10317getw2LRezQ(bArr, i);
                UByteArray.m10322setVurrAj0(bArr, i, UByteArray.m10317getw2LRezQ(bArr, i2));
                UByteArray.m10322setVurrAj0(bArr, i2, m10317getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m10701quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m10697partition4UcCI2c = m10697partition4UcCI2c(bArr, i, i2);
        int i3 = m10697partition4UcCI2c - 1;
        if (i < i3) {
            m10701quickSort4UcCI2c(bArr, i, i3);
        }
        if (m10697partition4UcCI2c < i2) {
            m10701quickSort4UcCI2c(bArr, m10697partition4UcCI2c, i2);
        }
    }

    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m10698partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m10580getMh2AYeg = UShortArray.m10580getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m10580getMh2AYeg2 = UShortArray.m10580getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = m10580getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m10580getMh2AYeg2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m10580getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m10580getMh2AYeg3 = UShortArray.m10580getMh2AYeg(sArr, i);
                UShortArray.m10585set01HTLdE(sArr, i, UShortArray.m10580getMh2AYeg(sArr, i2));
                UShortArray.m10585set01HTLdE(sArr, i2, m10580getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m10702quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m10698partitionAa5vz7o = m10698partitionAa5vz7o(sArr, i, i2);
        int i3 = m10698partitionAa5vz7o - 1;
        if (i < i3) {
            m10702quickSortAa5vz7o(sArr, i, i3);
        }
        if (m10698partitionAa5vz7o < i2) {
            m10702quickSortAa5vz7o(sArr, m10698partitionAa5vz7o, i2);
        }
    }

    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m10699partitionoBK06Vg(int[] iArr, int i, int i2) {
        int m10396getpVg5ArA = UIntArray.m10396getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m10396getpVg5ArA(iArr, i), m10396getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m10396getpVg5ArA(iArr, i2), m10396getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m10396getpVg5ArA2 = UIntArray.m10396getpVg5ArA(iArr, i);
                UIntArray.m10401setVXSXFK8(iArr, i, UIntArray.m10396getpVg5ArA(iArr, i2));
                UIntArray.m10401setVXSXFK8(iArr, i2, m10396getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m10703quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m10699partitionoBK06Vg = m10699partitionoBK06Vg(iArr, i, i2);
        int i3 = m10699partitionoBK06Vg - 1;
        if (i < i3) {
            m10703quickSortoBK06Vg(iArr, i, i3);
        }
        if (m10699partitionoBK06Vg < i2) {
            m10703quickSortoBK06Vg(iArr, m10699partitionoBK06Vg, i2);
        }
    }

    /* renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m10696partitionnroSd4(long[] jArr, int i, int i2) {
        long m10475getsVKNKU = ULongArray.m10475getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m10475getsVKNKU(jArr, i), m10475getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m10475getsVKNKU(jArr, i2), m10475getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m10475getsVKNKU2 = ULongArray.m10475getsVKNKU(jArr, i);
                ULongArray.m10480setk8EXiF4(jArr, i, ULongArray.m10475getsVKNKU(jArr, i2));
                ULongArray.m10480setk8EXiF4(jArr, i2, m10475getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m10700quickSortnroSd4(long[] jArr, int i, int i2) {
        int m10696partitionnroSd4 = m10696partitionnroSd4(jArr, i, i2);
        int i3 = m10696partitionnroSd4 - 1;
        if (i < i3) {
            m10700quickSortnroSd4(jArr, i, i3);
        }
        if (m10696partitionnroSd4 < i2) {
            m10700quickSortnroSd4(jArr, m10696partitionnroSd4, i2);
        }
    }

    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m10705sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m10701quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m10706sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m10702quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m10707sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m10703quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m10704sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m10700quickSortnroSd4(array, i, i2 - 1);
    }
}
