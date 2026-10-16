package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class J4 {
    public static String[] A00 = {"oZj5aoX1KvbFHq33YkjSnnR9n2", "YrN4", "d5f6mUL", "wzC2np4aQz", "bSG0VkmAa5PTnnRqB4khFtTiUFve1XQW", "Qyz6G41qMcU917EtFwNhHmzpy", "Reep", "5AjdKovxhleFLdRt3FcvPVZSBJ"};

    public static J3 A00(int i, long[] jArr, int[] iArr, long j) {
        int chunkSamplesRemaining = 8192 / i;
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += C5C.A05(i3, chunkSamplesRemaining);
        }
        long[] jArr2 = new long[i2];
        int[] iArr2 = new int[i2];
        int originalSampleIndex = 0;
        long[] timestamps = new long[i2];
        int[] flags = new int[i2];
        int i4 = 0;
        int bufferSampleCount = 0;
        int i5 = 0;
        String[] strArr = A00;
        String str = strArr[2];
        String str2 = strArr[3];
        int maxSampleCount = str.length();
        if (maxSampleCount != str2.length()) {
            String[] strArr2 = A00;
            strArr2[2] = "OG99HZu";
            strArr2[3] = "ptKGW28cJb";
            while (true) {
                int rechunkedSampleCount = iArr.length;
                String[] strArr3 = A00;
                String str3 = strArr3[2];
                String str4 = strArr3[3];
                int maxSampleCount2 = str3.length();
                if (maxSampleCount2 == str4.length()) {
                    break;
                }
                A00[5] = "uTdlUcyBkPhiZ9U2ydDZL";
                if (i5 < rechunkedSampleCount) {
                    int rechunkedSampleCount2 = iArr[i5];
                    int maxSampleCount3 = A00[5].length();
                    if (maxSampleCount3 == 5) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A00;
                    strArr4[2] = "PmQbGcH";
                    strArr4[3] = "fT2ewQCR49";
                    long j2 = jArr[i5];
                    while (rechunkedSampleCount2 > 0) {
                        int maximumSize = Math.min(chunkSamplesRemaining, rechunkedSampleCount2);
                        jArr2[bufferSampleCount] = j2;
                        iArr2[bufferSampleCount] = i * maximumSize;
                        originalSampleIndex = Math.max(originalSampleIndex, iArr2[bufferSampleCount]);
                        timestamps[bufferSampleCount] = i4 * j;
                        flags[bufferSampleCount] = 1;
                        j2 += iArr2[bufferSampleCount];
                        i4 += maximumSize;
                        rechunkedSampleCount2 -= maximumSize;
                        bufferSampleCount++;
                    }
                    i5++;
                } else {
                    return new J3(jArr2, iArr2, originalSampleIndex, timestamps, flags, j * i4);
                }
            }
        }
        throw new RuntimeException();
    }
}
