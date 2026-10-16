package com.instagram.common.viewpoint.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.dF, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1716dF extends InputStream {
    public static byte[] A04;
    public MessageDigest A00;
    public final C1925ge A01;
    public final InterfaceC1715dE A02;
    public final FileInputStream A03;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 43);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-52, -61, -76, -23, -8, -15};
    }

    public C1716dF(C1925ge c1925ge, FileInputStream fileInputStream, InterfaceC1715dE interfaceC1715dE) {
        this.A03 = fileInputStream;
        this.A02 = interfaceC1715dE;
        this.A01 = c1925ge;
        try {
            this.A00 = MessageDigest.getInstance(A00(0, 3, 84));
        } catch (NoSuchAlgorithmException unused) {
            this.A00 = null;
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.A03.available();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte[] b = new byte[1];
        return read(b);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.A03.read(bArr, i, i2);
        if (this.A00 != null) {
            try {
                if (read > 0) {
                    this.A00.update(bArr, i, read);
                } else if (read == -1) {
                    this.A02.A9s(C1437Xa.A05(this.A00.digest()));
                    this.A00 = null;
                }
            } catch (Exception e) {
                this.A00 = null;
                this.A01.A08().ABz(A00(3, 3, 90), AbstractC1341Td.A13, new C1342Te(e));
            }
        }
        return read;
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        int actuallyRead = (int) j;
        byte[] bArr = new byte[1024];
        long j2 = 0;
        while (actuallyRead > 0) {
            int bytesToRead = read(bArr, 0, Math.min(actuallyRead, 1024));
            if (bytesToRead <= 0) {
                break;
            }
            actuallyRead -= bytesToRead;
            j2 += bytesToRead;
        }
        return j2;
    }
}
