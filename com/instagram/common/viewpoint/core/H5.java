package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network/classes2.dex */
public final class H5 {
    public static byte[] A03;
    public final H4 A00;
    public final Constructor<? extends H9> A01;
    public final AtomicBoolean A02 = new AtomicBoolean(false);

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 14);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{55, 0, 0, Ascii.GS, 0, 82, Ascii.ESC, Ascii.FS, 1, 6, 19, Ascii.FS, 6, Ascii.ESC, 19, 6, Ascii.ESC, Ascii.FS, Ascii.NAK, 82, Ascii.ETB, 10, 6, Ascii.ETB, Ascii.FS, 1, Ascii.ESC, Ascii.GS, Ascii.FS, 37, Ascii.RS, Ascii.NAK, 8, 0, Ascii.NAK, 19, 4, Ascii.NAK, Ascii.DC4, 80, Ascii.NAK, 2, 2, Ascii.US, 2, 80, 19, 2, Ascii.NAK, 17, 4, Ascii.EM, Ascii.RS, Ascii.ETB, 80, Ascii.NAK, 8, 4, 2, 17, 19, 4, Ascii.US, 2};
    }

    public H5(H4 h4) {
        this.A00 = h4;
    }

    private Constructor<? extends H9> A01() {
        synchronized (this.A02) {
            if (this.A02.get()) {
                return this.A01;
            }
            try {
                return this.A00.A7R();
            } catch (ClassNotFoundException unused) {
                this.A02.set(true);
                return this.A01;
            } catch (Exception e) {
                throw new RuntimeException(A00(0, 29, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), e);
            }
        }
    }

    public final H9 A03(Object... objArr) {
        Constructor<? extends H9> A01 = A01();
        if (A01 == null) {
            return null;
        }
        try {
            return A01.newInstance(objArr);
        } catch (Exception e) {
            throw new IllegalStateException(A00(29, 35, 126), e);
        }
    }
}
