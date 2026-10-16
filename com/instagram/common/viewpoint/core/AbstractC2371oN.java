package com.instagram.common.viewpoint.core;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Arrays;

@DoNotMock
/* renamed from: com.facebook.ads.redexgen.X.oN, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2371oN<E> {
    public static byte[] A00;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 39);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{71, 69, 74, 74, 75, 80, 4, 87, 80, 75, 86, 65, 4, 73, 75, 86, 65, 4, 80, 76, 69, 74, 4, 109, 74, 80, 65, 67, 65, 86, 10, 105, 101, 124, 123, 114, 101, 104, 113, 97, 4, 65, 72, 65, 73, 65, 74, 80, 87};
    }

    public static int A03(int oldCapacity, int minCapacity) {
        if (minCapacity >= 0) {
            if (minCapacity <= oldCapacity) {
                return oldCapacity;
            }
            int newCapacity = (oldCapacity >> 1) + oldCapacity + 1;
            if (newCapacity < minCapacity) {
                newCapacity = Integer.highestOneBit(minCapacity - 1) << 1;
            }
            if (newCapacity < 0) {
                return Integer.MAX_VALUE;
            }
            return newCapacity;
        }
        throw new IllegalArgumentException(A04(0, 49, 3));
    }
}
