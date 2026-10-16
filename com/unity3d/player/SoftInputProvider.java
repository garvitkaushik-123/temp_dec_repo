package com.unity3d.player;

import com.unity3d.player.a.AbstractC3503k;

/* loaded from: classes7.dex */
abstract class SoftInputProvider {
    private static final native int nativeGetSoftInputType();

    public static int a() {
        int nativeGetSoftInputType = nativeGetSoftInputType();
        int[] b = AbstractC3503k.b(4);
        int length = b.length;
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= length) {
                return 1;
            }
            int i3 = b[i];
            if (i3 == 1) {
                i2 = -1;
            } else if (i3 == 2) {
                i2 = 0;
            } else if (i3 != 3) {
                if (i3 != 4) {
                    throw null;
                }
                i2 = 2;
            }
            if (i2 == nativeGetSoftInputType) {
                return i3;
            }
            i++;
        }
    }
}
