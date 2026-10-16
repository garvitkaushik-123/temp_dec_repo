package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgbw {
    public static long[] zza(long[]... jArr) {
        long j = 0;
        for (long[] jArr2 : jArr) {
            j += jArr2.length;
        }
        int i = (int) j;
        zzfvp.zzh(j == ((long) i), "the total number of elements (%s) in the arrays must fit in an int", j);
        long[] jArr3 = new long[i];
        int i2 = 0;
        for (long[] jArr4 : jArr) {
            int length = jArr4.length;
            System.arraycopy(jArr4, 0, jArr3, i2, length);
            i2 += length;
        }
        return jArr3;
    }
}
