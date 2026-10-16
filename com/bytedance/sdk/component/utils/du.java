package com.bytedance.sdk.component.utils;

import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public class du {
    private static final byte[] eli = eli("VP8X");

    private static byte[] eli(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    public static boolean eli(byte[] bArr, int i) {
        try {
            boolean eli2 = eli(bArr, i + 12, eli);
            int i2 = i + 20;
            if (bArr.length <= i2) {
                return false;
            }
            return eli2 && ((bArr[i2] & 2) == 2);
        } catch (Throwable th) {
            new Object[]{th};
            return false;
        }
    }

    private static boolean eli(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
