package com.instagram.common.viewpoint.core;

import android.util.Pair;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class LP {
    public static byte[] A00;
    public static String[] A01 = {"sX38XYxjSWs23SpIJtTv7zqsiULa6NDN", "GVdzvLjErUQlCiFlI6sj0UXKxa4oVMD1", "mIptDDVqgJzdzMBxnTdyNQyM9U5NEVN", "EbHk890dVqPqb4rol71PU8NjsI2mWG9N", "NaaYWHcYaAW6JEQtPhbZM5A", "ny7KRitGLB3lrMhzsw8kbWX2NySq0vmW", "JAavj5eiIDuEB7ikgcXMWWkFbaDdUxIE", "svQ0hoJoeE45w1Y6xC2"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static LN A02(InterfaceC2280ms interfaceC2280ms) throws IOException {
        byte[] bArr;
        C07364v c07364v = new C07364v(16);
        LO A03 = A03(1718449184, interfaceC2280ms, c07364v);
        AbstractC07133y.A08(A03.A01 >= 16);
        interfaceC2280ms.AGt(c07364v.A0l(), 0, 16);
        c07364v.A0f(0);
        int A0G = c07364v.A0G();
        int A0G2 = c07364v.A0G();
        int A0F = c07364v.A0F();
        int A0F2 = c07364v.A0F();
        int A0G3 = c07364v.A0G();
        int A0G4 = c07364v.A0G();
        int i = ((int) A03.A01) - 16;
        if (i > 0) {
            bArr = new byte[i];
            interfaceC2280ms.AGt(bArr, 0, i);
        } else {
            bArr = C5C.A07;
        }
        interfaceC2280ms.AK3((int) (interfaceC2280ms.A8i() - interfaceC2280ms.A8n()));
        return new LN(A0G, A0G2, A0F, A0F2, A0G3, A0G4, bArr);
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 67);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{59, Ascii.DLE, Ascii.CR, Ascii.SYN, 19, 88, 17, Ascii.VT, 88, Ascii.FF, Ascii.ETB, Ascii.ETB, 88, Ascii.DC4, Ascii.EM, 10, Ascii.US, Ascii.GS, 88, 80, 6, 74, 63, 58, 83, 81, 88, Ascii.FF, Ascii.ETB, 88, Ascii.VT, 19, 17, 8, 67, 88, 17, Ascii.FS, 66, 88, 45, 3, 10, Ascii.VT, Ascii.SYN, Ascii.CR, 10, 3, 68, 17, 10, Ascii.SI, 10, Ascii.VT, 19, 10, 68, 51, 37, 50, 68, 7, Ascii.FF, 17, 10, Ascii.SI, 94, 68, 105, 82, 79, 73, 76, 76, 83, 78, 72, 89, 88, Ascii.FS, 90, 83, 78, 81, Ascii.FS, 72, 69, 76, 89, 6, Ascii.FS, 105, 95, 72, 118, 91, 95, 90, 91, 76, 108, 91, 95, 90, 91, 76};
    }

    static {
        A05();
    }

    public static long A00(InterfaceC2280ms interfaceC2280ms) throws IOException {
        C07364v c07364v = new C07364v(8);
        LO chunkHeader = LO.A00(interfaceC2280ms, c07364v);
        if (chunkHeader.A00 != 1685272116) {
            interfaceC2280ms.AIl();
            return -1L;
        }
        interfaceC2280ms.A47(8);
        c07364v.A0f(0);
        interfaceC2280ms.AGt(c07364v.A0l(), 0, 8);
        long sampleDataSize = c07364v.A0N();
        interfaceC2280ms.AK3(((int) chunkHeader.A01) + 8);
        return sampleDataSize;
    }

    public static Pair<Long, Long> A01(InterfaceC2280ms interfaceC2280ms) throws IOException {
        interfaceC2280ms.AIl();
        LO A03 = A03(1684108385, interfaceC2280ms, new C07364v(8));
        interfaceC2280ms.AK3(8);
        return Pair.create(Long.valueOf(interfaceC2280ms.A8n()), Long.valueOf(A03.A01));
    }

    public static LO A03(int i, InterfaceC2280ms interfaceC2280ms, C07364v c07364v) throws IOException {
        LO A002 = LO.A00(interfaceC2280ms, c07364v);
        while (A002.A00 != i) {
            AbstractC07214g.A07(A04(91, 15, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), A04(40, 28, 39) + A002.A00);
            long j = A002.A01 + 8;
            if (j <= 2147483647L) {
                interfaceC2280ms.AK3((int) j);
                A002 = LO.A00(interfaceC2280ms, c07364v);
            } else {
                throw C3K.A00(A04(0, 40, 59) + A002.A00);
            }
        }
        return A002;
    }

    public static boolean A06(InterfaceC2280ms interfaceC2280ms) throws IOException {
        C07364v c07364v = new C07364v(8);
        LO A002 = LO.A00(interfaceC2280ms, c07364v);
        if (A002.A00 != 1380533830) {
            int i = A002.A00;
            if (A01[1].charAt(26) == 'h') {
                throw new RuntimeException();
            }
            A01[4] = "7d3HBnqB6pKujyEoyh9Hov6";
            if (i != 1380333108) {
                return false;
            }
        }
        interfaceC2280ms.AGt(c07364v.A0l(), 0, 4);
        c07364v.A0f(0);
        int A0C = c07364v.A0C();
        if (A0C != 1463899717) {
            AbstractC07214g.A05(A04(91, 15, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), A04(68, 23, 127) + A0C);
            return false;
        }
        return true;
    }
}
